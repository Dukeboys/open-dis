
package edu.nps.moves.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketFactory;
 
/**
 * A "networked virtual environment" servlet. This runs within a Jetty container
 * and handles connections from the web client, returning a specific client socket
 * with the logic to handle sending position data to the client, as described by
 * the "nve" protocol.<p>
 * 
 * This boils down to a piece of code that can hand back a websocket to a
 * client. 
 * 
 * @author mcgredo
 */
public class NVEServlet extends HttpServlet
{
    
  /** The web socket factory holds shared code necessary to create a web socket */
  private WebSocketFactory websocketFactory;
  
  /** A Set container that contains the various clients that have connected. Thread safe. 
   * This is unused by the logic for now, but you could, for example, use this to send
   * out updates to several browsers connected to the same server--client A sends in an
   * update message, and the server turns around and sends that to all the other clients
   * that are connected, so that everyone receives the position update.
   */
  static final Set<NVESocket> clientConnections = new CopyOnWriteArraySet<NVESocket>();
 
  /** Initialize the servlet. This is called at servlet startup. */
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
         if ("nve".equals(protocol))
         {
           // Important! This is where the specific type of websocket class is created.
           return new NVESocket();
         }
         
         return null;
      }
    });
    
    // Set some default values
    websocketFactory.setBufferSize(4096);
    websocketFactory.setMaxIdleTime(60000);
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

    
}
