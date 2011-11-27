
package edu.nps.moves.websocket;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketFactory;
import org.codehaus.jackson.map.ObjectMapper;
import edu.nps.moves.dismobile.*;


/**
 * The logic for a specific type of websocket. In this case an "Networked Virtual 
 * Environment" web socket that pushes back JSON object position updates to the client.
 * 
 * @author mcgredo
 */
public class NVESocket implements WebSocket.OnTextMessage
{
    /** Hand out unique IDs to the clients as they connect. Not used right now; everyone is zero */
    private static int nextObjectId = 0;
    
    /** Websocket.Connection interface */
    volatile Connection connection;
    
    /** Updater, a Runnable object class that sends messages to the client periodicaly. */
    PositionUpdater positionUpdater;
    
    /** Client has connected. Add it to a list of all clients. Theoretically we
     * could pass messages between all clients, but for now we'll simply send
     * out updates periodically, directly from the server to a single client
     */
    @Override
    public void onOpen(Connection connection)
    {
        System.out.println("onOpen method called in NVESocket");
        this.connection=connection;
        
        // Add it to the list of all client connections maintained by the servlet
        NVEServlet.clientConnections.add(this);
        
        // Create a thread that periodically sends position updates to the client
        positionUpdater = new PositionUpdater(connection);
        Thread updateThread = new Thread(positionUpdater);
        updateThread.start();
    }
   
    /** Callback for when a WebSocket connection is closed.<p>
     * 
     * Remove this WebSocket from the members set and shut down the updater thread
     */
    @Override
    public void onClose(int closeCode, String message)
    {
        System.out.println("onClose method called in NVEWebSocket");
        NVEServlet.clientConnections.remove(this);
        positionUpdater.setStopSending(true); // Kill update thread
    }
    
    /** Callback for when a WebSocket message is received from client */
    @Override
    public void onMessage(String data)
    {
        System.out.println("onMessage method called in NVESocket");
        System.out.println("Got message from client, " + data);
        
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            EntityStatePdu espdu = objectMapper.readValue(data, EntityStatePdu.class);
            System.out.println("Successfully deserialized JSON from client");
        }
        catch(Exception e)
        {
            System.out.println("Could not deserialize JSON");
        }

      
      if(data.equalsIgnoreCase("GetID"))
      {
          
      }
      
    }

}
