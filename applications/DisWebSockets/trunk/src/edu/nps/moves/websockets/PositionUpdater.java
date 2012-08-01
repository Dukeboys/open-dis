
package edu.nps.moves.websockets;

import org.eclipse.jetty.websocket.WebSocket; 
import edu.nps.moves.dismobile.*;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Sends JSON objects to the client side, each JSON object representing a position update.
 * @author mcgredo
 */
public class PositionUpdater implements Runnable
{
    /**  How often to send to the client */
    public static final long SEND_FREQUENCY_IN_MS = 500;
    
    /** x, y, and z position */ 
    double x = 0.0;
    double y = 0.0;
    double z = 0.0;
    
    /** a unique identifier for the object to be moved in the webgl scene. Not used right now. */
    int   uniqueId = 0;
    
    boolean stopSending = false;
    
    /** Websocket connection to the web browser */
    WebSocket.Connection connection;
    NVEServlet servlet;
    NVESocket nveSocket;
    
    /**
     * Constructor, called by the servlet. Passed in a connection to the client 
     * @param connection 
     */
    public PositionUpdater(WebSocket.Connection connection, NVESocket nveSocket, NVEServlet servlet)
    {
       this.connection = connection; 
       this.servlet = servlet;
       this.nveSocket = nveSocket;
    }
    
    /** Call with "true" to kill the sending thread, typcially when the connection closes */
    public void setStopSending(boolean status)
    {
        stopSending = status;
    }
    
    /** Moves an object along the x axis from 0 to 20. At the end of this is closes down the socket
     * and exits the thread.
     */
    public void run()
    {
        double reverse = 1;
        int strykerEntityID = (int)(Math.random() * 20000);
        
        while(!stopSending)
        {
            try
            {
                
                EntityStatePdu mlrsEspdu = new EntityStatePdu();
                EntityStatePdu strykerEspdu = new EntityStatePdu();
                
                mlrsEspdu.getEntityLocation().setX(x + 2);
                mlrsEspdu.getEntityOrientation().setTheta((float)(Math.PI + x));
                mlrsEspdu.getEntityID().setEntity(1);
                EntityType mlrsType = mlrsEspdu.getEntityType();
                mlrsType.setCountry(225);          // USA
                mlrsType.setEntityKind((short)1);  // platform
                mlrsType.setDomain((short)1);      // land
                mlrsType.setCategory((short)4);    // SP artillery
                mlrsType.setSubcategory((short)1); // mlrs

                
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonMlrsEspdu = objectMapper.writeValueAsString(mlrsEspdu); 
                
                strykerEspdu.getEntityLocation().setX(x);
                strykerEspdu.getEntityLocation().setZ(5);
                strykerEspdu.getEntityOrientation().setTheta((float)(Math.PI + x));
                strykerEspdu.getEntityID().setEntity(strykerEntityID);
                EntityType lavType = strykerEspdu.getEntityType();
                lavType.setCountry(225);          // USA
                lavType.setEntityKind((short)1);  // platform
                lavType.setDomain((short)1);      // land
                lavType.setCategory((short)2);    // ifv
                lavType.setSubcategory((short)5); // lav

                objectMapper = new ObjectMapper();
                String jsonStrykerEspdu = objectMapper.writeValueAsString(strykerEspdu);
                
                
                
                //System.out.println("String value of MLRS espdu in json is " + jsonMlrsEspdu);
                //System.out.println("String value of Stryker espud in json is " + jsonStrykerEspdu);
                //connection.sendMessage(jsonMlrsEspdu);
                servlet.sendPdu(jsonMlrsEspdu, null);
                
                
                x = x + reverse * 0.2;
                if(x > 50.0 || x < 0.0)
                {
                    reverse = reverse * -1.0;
                    
                    /*
                    System.out.println("breaking out of loop");
                    stopSending = true;
                    break;
                     */
                }
                
                Thread.sleep(SEND_FREQUENCY_IN_MS);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }    
        }
                
        connection.disconnect();
        
    }
    
}
