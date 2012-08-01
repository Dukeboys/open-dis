
package edu.nps.moves.websockets;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketFactory;
import org.codehaus.jackson.map.ObjectMapper;
import edu.nps.moves.dismobile.*;


/**
 * The logic for a specific type of websocket. In this case an "Networked Virtual 
 * Environment" web socket that pushes back JSON object position updates to the client.
 * <p>
 * 
 * @author mcgredo
 */
public class NVESocket implements WebSocket.OnTextMessage
{
    /** Hand out unique IDs to the clients as they connect. Not used right now; everyone is zero */
    private static int nextObjectId = 0;
    
    /** Websocket.Connection interface */
    volatile Connection connection;
    
    /** Hook back to the servlet */
    NVEServlet servlet;
    
    /** Unique identifier for this connection */
    int nveSocketID;
    
    /** All the entityIDs from which we have _received from the client_
     * on this connection. This means those EIDs are hosted on that client,
     * and we should not send out PDUs to that client.
     */
    
    /** Updater, a Runnable object class that sends messages to the client periodicaly. */
    PositionUpdater positionUpdater;
    
    public NVESocket(NVEServlet servlet)
    {
        this.servlet = servlet;
        nveSocketID = nextObjectId;
        nextObjectId++;
    }
    
    public int getNveSocketID()
    {
        return nveSocketID;
    }
    
    @Override
    public boolean equals(Object otherObject)
    {
        if( !(otherObject instanceof NVESocket) )
            return false;
        
        NVESocket otherSocket = (NVESocket)otherObject;
        
        if(nveSocketID == otherSocket.getNveSocketID())
            return true;
        
        return false;  
    }
    
    public Connection getConnection()
    {
        return connection;
    }
    
    
    /** Client has connected. Add it to a list of all clients. Theoretically we
     * could pass messages between all clients, but for now we'll simply send
     * out updates periodically, directly from the server to a single client
     */
    @Override
    public void onOpen(Connection connection)
    {
        System.out.println("onOpen method called in NVESocket, id=" + nveSocketID);
        this.connection=connection;
        
        // Add us to the list of all client connections maintained by the servlet
        servlet.addNVEConnection(this); 
        
        // Create a thread that periodically sends position updates to the client
        //positionUpdater = new PositionUpdater(connection, this, servlet);
        //Thread updateThread = new Thread(positionUpdater);
        //updateThread.start();
    }
   
    /** Callback for when a WebSocket connection is closed.<p>
     * 
     * Remove this WebSocket from the members set and shut down the updater thread
     */
    @Override
    public void onClose(int closeCode, String message)
    {
        System.out.println("onClose method called in NVEWebSocket");
        servlet.removeNVEConnection(this);
        //positionUpdater.setStopSending(true); // Kill update thread
    }
    
    /** Callback for when a WebSocket message is received from client */
    @Override
    public void onMessage(String data)
    {
        //System.out.println("Got message from client, " + data);
        
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            EntityStatePdu espdu = objectMapper.readValue(data, EntityStatePdu.class);
            //System.out.println("Successfully deserialized JSON from client");
            
            // Keep track of the EIDs in use on the global servlet
            EntityID eid = espdu.getEntityID();
            if(!servlet.hasEntityID(eid, this))
            {
                servlet.addEntity(eid, this);
            }
            //System.out.println("(" + eid.getSite() + "," + eid.getApplication() + "," + eid.getEntity() + ")");
            
            // Echo  the JSON format out to the other participants, plus the native network
            servlet.sendPdu(data, this);
        }
        catch(Exception e)
        {
            System.out.println("Could not deserialize JSON");
        }
      
    }
    
    public void sendJsonMessage(String jsonFormatMessage)
    {
        try
        {
            connection.sendMessage(jsonFormatMessage);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
