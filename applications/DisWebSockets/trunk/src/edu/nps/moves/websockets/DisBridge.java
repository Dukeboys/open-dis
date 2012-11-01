
package edu.nps.moves.websockets;

import java.util.*;
import edu.nps.moves.net.*;
import edu.nps.moves.dismobile.*;
import edu.nps.moves.disutil.*;

import org.eclipse.jetty.websocket.WebSocketClient;
import org.eclipse.jetty.websocket.WebSocketClientFactory;
import org.eclipse.jetty.websocket.WebSocketHandler;
import org.eclipse.jetty.websocket.WebSocketConnection;
import org.eclipse.jetty.websocket.WebSocket;
import java.util.concurrent.TimeUnit;
import java.net.URI;



/**
 * Forwards DIS traffic from the local network to a given websocket URL.
 * 
 * @author DMcG
 */
public class DisBridge implements PduReceiver
{
    Properties           localConnectionProperties;
    WebSocketClient      websocketClient = null;
    WebSocket.Connection connection;
    NetConnectionMulticast        localConnection = null;
    
    public DisBridge(Properties props)
    {
        this.localConnectionProperties = props;
        
        NetConnectionDescription connectDescription = new NetConnectionDescription(localConnectionProperties);
        NetConnectionFactory connectionFactory = new NetConnectionFactory();
        localConnection = (NetConnectionMulticast)connectionFactory.netConnectionForDescription(connectDescription);
        localConnection.setPduReceiver(this);
        
        // Set up the websocket connection to the server
        try
        {
            WebSocketClientFactory factory = new WebSocketClientFactory();
            factory.setBufferSize(1024 * 8);
            factory.start();
            
            websocketClient = factory.newWebSocketClient();
            websocketClient.setMaxIdleTime(300000);
            websocketClient.setMaxTextMessageSize(1024 * 8);
            websocketClient.setMaxBinaryMessageSize(1024 * 8);
            websocketClient.setProtocol("nveb");
            
            connection = websocketClient.open(new URI(localConnectionProperties.getProperty("websocketUrl")), new WebSocket.OnBinaryMessage()
            {
                @Override
                 public void onOpen(WebSocket.Connection connection)
                 {
                   System.out.println("Opened binary websocket");
                 }

                @Override
                 public void onClose(int closeCode, String message)
                 {
                   System.out.println("closed binary websocket");
                 }

                @Override
                 public void onMessage(byte[] data, int offset, int length)
                 {
                     // The jetty docs don't mention this--bitter, me?--but the binary data is prepended with some
                     // framing data cruft. The actual payload starts offset bytes into the data.
                     byte[] payload = new byte[length];
                     System.arraycopy(data, offset, payload, 0, length);
                     DisBridge.this.localConnection.sendData(payload);
                 }

            }).get(20, TimeUnit.SECONDS);
            
            Thread.sleep(10000);
                EntityStatePdu espdu = new EntityStatePdu();
                
                byte[] data = espdu.marshal();

                //connection.sendMessage("{\"protocolVersion\":6,\"exerciseID\":0,\"pduType\":1,\"protocolFamily\":1,\"timestamp\":0,\"pduLength\":144,\"padding\":0,\"entityID\":{\"site\":1,\"application\":1,\"entity\":57868},\"forceId\":0,\"numberOfArticulationParameters\":0,\"entityType\":{\"entityKind\":1,\"domain\":1,\"country\":225,\"category\":2,\"subcategory\":5,\"spec\":0,\"extra\":0},\"alternativeEntityType\":{\"entityKind\":0,\"domain\":0,\"country\":0,\"category\":0,\"subcategory\":0,\"spec\":0,\"extra\":0},\"entityLinearVelocity\":{\"x\":0,\"y\":0,\"z\":0},\"entityLocation\":{\"x\":6.800000000000003,\"y\":0,\"z\":5},\"entityOrientation\":{\"psi\":0,\"theta\":0,\"phi\":0},\"entityAppearance\":0,\"deadReckoningParameters\":{\"deadReckoningAlgorithm\":0,\"otherParameters\":\"AAAAAAAAAAAAAAAAAAAA\",\"entityLinearAcceleration\":{\"x\":0,\"y\":0,\"z\":0},\"entityAngularVelocity\":{\"x\":0,\"y\":0,\"z\":0}},\"marking\":{\"characterSet\":0,\"characters\":\"AAAAAAAAAAAAAAA=\"},\"capabilities\":0,\"articulationParameters\":[]}");
                connection.sendMessage(data, 0, data.length);    
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                     System.out.println("Can not open connection to binary websocket URL");
                 }
    }

    /** A pdu has been received from the local network; forward it to the websocket */
    @Override
    public void receivePdu(byte[] data)
    {
       System.out.println("Received data from local network");
    }
    
    public static void main(String[] args)
    {
        NetConnection nativeConnection;
        DisBridge localBridge;
        
        Properties netConnectionProperties = new Properties();
        netConnectionProperties.put("destinationAddress", "239.1.2.3");
        netConnectionProperties.put("port", "62040");
        netConnectionProperties.put("destinationPort", "62040");
        netConnectionProperties.put("timeToLive", "2");
        netConnectionProperties.put("connectionType", "udpMulticast");
        netConnectionProperties.put("websocketUrl", "ws://oam.nps.edu:80/nve");

        DisBridge newBridge = new DisBridge(netConnectionProperties);
        
        System.out.println("exiting");
        
    }
    
}
