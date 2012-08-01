
package edu.nps.moves.websockets;

import java.io.IOException;
import java.util.Iterator;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketFactory;

import edu.nps.moves.net.*;
import edu.nps.moves.dismobile.*;

import org.codehaus.jackson.map.ObjectMapper;
 
/**
 * A "networked virtual environment" servlet. This runs within a Jetty container
 * and handles connections from the web client, returning a specific client socket
 * with the logic to handle sending position data to the client, as described by
 * the "nve" protocol.<p>
 *
 * This maintains a list of all the NVESockets created as clients connect, and
 * contains a native network socket that can receive and send IEEE DIS PDUs from
 * any existing applications. 
 * 
 * @author mcgredo
 */
public class NVEServlet extends HttpServlet implements PduReceiver
{
    /** String tag for the websocket protocol intended to handle JSON-ized traffic */
    public static final String NVE_PROTOCOL = "nve";
    
    /** Timeout for a websocket connection with no traffic, in ms */
    public static final int WEBSOCKET_TIMEOUT = 300000; 
    public static final int WEBSOCKET_BUFFER_SIZE = 8192; 
    
    
  /** The web socket factory holds shared code necessary to create a web socket */
  private WebSocketFactory websocketFactory;
  
  /** A Set container that contains the various clients that have connected. Thread safe. 
   * This is used to distribute messages to everyone connected to the NVE. The NVESocket
   * handles ONLY JSON format DIS messages. To send or receive other information, use
   * the NVEMetaInfoSocket.
   */
  static final Set<NVESocket> clientConnections = new CopyOnWriteArraySet<NVESocket>();
  
  /** Native DIS network connection to the network */
  private NetConnection nativeConnection;

  /** EntityIDs and what connection they're associated with */
  static final ConcurrentHashMap<EntityID, NVESocket> entitiesAndConnections = new ConcurrentHashMap<EntityID, NVESocket>();
 
  /** Initialize the servlet. This is called at servlet startup.  Note that this
   * will not run until the first web client connects. 
   */
  @Override
  public void init() throws ServletException
  {
    // Create and configure WS factory. This uses an anonymous class, WebSocketFactory.Acceptor(),
    // that checks to make sure the origin is acceptable (by default all are) and that
    // the protocol being requested, "nve", is acceptable. The client can specify that
    // a particular protocol be used, and in this case we're passing back simple JSON
    // objects related to a made-up networked virtual environment protocol.
      
    websocketFactory = new WebSocketFactory(new WebSocketFactory.Acceptor()
    {
      /** Can check that the origin is acceptable */
      public boolean checkOrigin(HttpServletRequest request, String origin)
      {
        // Allow all origins
        return true;
      }

      // The client can specify a "protocol", ie what it expects from the server.
      // In this case the client specifies "nve", and our code will return an 
      // object that speaks JSON and passes back simple JSON objects with the
      // location.
      public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol)
      {
         System.out.println("Protocol requested by client is " + protocol);
         if (NVE_PROTOCOL.equals(protocol))
         {
           // Important! This is where the specific type of websocket class is created.
           // this creates an NVE socket, which can send and receive DIS packets in JSON
           // format.
           return new NVESocket(NVEServlet.this);
         }
         
         // Create other message handlers here for any sub-protocols. This tends
         // to be not a good idea in practice; you need to tie several connections from
         // the same web page together
         
         return null;
      }
    });
    
    // Set some default values
    websocketFactory.setBufferSize(WEBSOCKET_BUFFER_SIZE);
    websocketFactory.setMaxIdleTime(WEBSOCKET_TIMEOUT);
    
    // Start up a network listener that listens for conventional IEEE DIS packets
    // on the network interface. We use these to forward IEEE DIS from the network
    // at large to the clients participating via websockets, and to send out any
    // data to the big network that we receive from web-based clients
    
    System.out.println("Starting conventional DIS network connection");
    
    Properties netConnectionProperties = new Properties();
    netConnectionProperties.put("destinationAddress", "239.1.2.3");
    netConnectionProperties.put("port", "62040");
    netConnectionProperties.put("destinationPort", "62040");
    netConnectionProperties.put("timeToLive", "2");
    netConnectionProperties.put("connectionType", "udpMulticast");
    
    NetConnectionDescription connectDescription = new NetConnectionDescription(netConnectionProperties);
    NetConnectionFactory connectionFactory = new NetConnectionFactory();
    nativeConnection = (NetConnectionMulticast)connectionFactory.netConnectionForDescription(connectDescription);
    
    PduListener pduListener = new PduListener();
    
    nativeConnection.setPduObserver(pduListener);
    pduListener.addListener(this);
  }
 
  public void addNVEConnection(NVESocket newConnection)
  {
      clientConnections.add(newConnection);
  }
  
  public void removeNVEConnection(NVESocket aNVESocket)
  {
    clientConnections.remove(aNVESocket);  
    this.removeEntitiesForNveSocket(aNVESocket);
  }
  
  /**
   * Got a PDU from the conventional network. Send it out to all the websocket-connected
   * participants in JSON format.
   * 
   * @param aPdu 
   */
  @Override
  public void receivePdu(Pdu aPdu)
  {
      
      System.out.println("servlet got PDU from network");
      
      if(aPdu instanceof EntityStatePdu)
      {
          try
          {
              EntityStatePdu espdu = (EntityStatePdu)aPdu;
              EntityID eid = espdu.getEntityID();
              //System.out.println("espdu eid:" + espdu.getEntityID().getSite() + "," + espdu.getEntityID().getApplication() + "," + espdu.getEntityID().getEntity());
              //System.out.println("espdu location:" + espdu.getEntityLocation().getX() + "," + espdu.getEntityLocation().getY() + "," + espdu.getEntityLocation().getZ());
              ObjectMapper objectMapper = new ObjectMapper();
              String jsonFormatEspdu = objectMapper.writeValueAsString(espdu);
              
              NVESocket sendingConnection = entitiesAndConnections.get(eid);
              
              Iterator<NVESocket> iterator = clientConnections.iterator();
              while(iterator.hasNext())
              {
                  NVESocket aConnection = iterator.next();
                  if(sendingConnection == null || aConnection.getNveSocketID() != sendingConnection.getNveSocketID())
                  {
                    aConnection.sendJsonMessage(jsonFormatEspdu);
                  }
              }
              
              
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
          
      }
      
  }
  
  /**
   * Send a pdu to all the other participants in the simulation, exluding
   * the sender, plus send it to the native DIS network in DIS format
   * 
   * @param aPdu 
   */
  public void sendPdu(String jsonFormatPdu, NVESocket sender)
  {
      // Send the JSON string to all the other participants, excluding
      // the connection that sent the message in the first place
      Iterator<NVESocket> iterator = clientConnections.iterator();
      while(iterator.hasNext())
      {
          NVESocket aConnection = iterator.next();
          if( !(aConnection.equals(sender)) )
          {
            aConnection.sendJsonMessage(jsonFormatPdu);
          }
      }
      
      // Convert JSON to a PDU, and send it out on the conventional IEEE DIS socket
      try
      {
          ObjectMapper objectMapper = new ObjectMapper();
          EntityStatePdu espdu = (EntityStatePdu)objectMapper.readValue(jsonFormatPdu, EntityStatePdu.class);
          nativeConnection.sendPdu(espdu);
      }
      catch(Exception e)
      {
          e.printStackTrace();
          System.out.println(e);
      }
      
      
  }
 
  /** The http server has handed off the connection to us, the servlet. We do
   * our thing...creating and returning a web socket.
   */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
{
    // If the WebSocket factory accepts the connection, then return. This parses the
    // headers of the http request and figures out whether it's asking for a websocket
    // or something else. If it's asking for a web socket, and everything else looks
    // cool, a websocket object is made available by side effect.
    if (websocketFactory.acceptWebSocket(request,response))
        return;
    
    // Otherwise send an HTTP error.
    response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,"Can connect to NVEWebsocket only");
}

public boolean hasEntityID(EntityID eid, NVESocket aSocket)
{
    NVESocket socketForEid = entitiesAndConnections.get(eid);
    if(socketForEid == null)
    {
        return false;
    }
    
    return true;
}

public void addEntity(EntityID eid, NVESocket aSocket)
{
    entitiesAndConnections.put(eid, aSocket);
}

public void removeEntitiesForNveSocket(NVESocket aSocket)
{
    Set<Map.Entry<EntityID, NVESocket>> eset = entitiesAndConnections.entrySet();
    Iterator it = eset.iterator();
    while(it.hasNext())
    {
        Map.Entry<EntityID, NVESocket> entry = (Map.Entry<EntityID, NVESocket>)it.next();
        if(entry.getClass().equals(aSocket))
        {
            eset.remove(entry.getKey());
        }
    }
}

    
}
