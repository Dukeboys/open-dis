
package edu.nps.moves.net;

import java.net.*;
import java.io.*;

import edu.nps.moves.dismobile.*;
import edu.nps.moves.disutil.*;

/**
 * A unicast NetConnection, which reads datagram/UDP packets sent to it, and sends
 * datagram/UDP packets to a specific unicast address.<p>
 * 
 * This implements the Runnable interface, so that it reads data from the wire.
 * The Runnable interface is implemented in the concrete subclasses, since potentially
 * not every concrete implementation of NetConnection needs it.<p>
 * 
 * @author mcgredo
 */
public class NetConnectionUnicast implements NetConnection, Runnable
{
    /** Time, in ms, before the socket times out on a read. In normal use this
     * simply gives us a chance to check if we should exit the read loop.
     */
    public static final int SOCKET_TIMEOUT_PERIOD = 5000;
    
    /** Thread that reads packets from the net */
    Thread         readThread;
    
    /** unicast socket */
    DatagramSocket socket;
    
    /** Unicast address to send to */
    InetAddress    destinationAddress;
    
    /** Port to read from */
    int            port;
    
    /** port to send to */
    int            destinationPort;
    
    /** User-friendly name */
    String         name;
    
    /** Boolean flag to exit read loop */
    boolean        continueRunning = true;
    
    /** Send received PDUs to this for distribution to interested parties */
    PduObserver pduObserver;
    
    public NetConnectionUnicast(NetConnectionDescription description)
    {
        try
        {
            destinationAddress = InetAddress.getByName(description.connectionProperties.getProperty("destinationAddress"));
            port = Integer.parseInt(description.connectionProperties.getProperty("port"));
            destinationPort = Integer.parseInt(description.connectionProperties.getProperty("destinationPort"));
            
            socket = new DatagramSocket(port);
            System.out.println("Created unicast network connection");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        
    }
    
    public NetConnectionDescription.ConnectionType getConnectionType()
    {
        return NetConnectionDescription.ConnectionType.UDP_UNICAST;
    }
    
    /** It's dangerous to start a thread from inside a constructor, so we have to expose a start()
     * method as well.
     */
    public void start()
    {
        readThread = new Thread(this);
        readThread.setDaemon(true);
        readThread.start();
    }
    
    public void stopReadThread()
    {
        continueRunning = false;
    }
    
    
    @Override
    /** Reads packets from the wire, turns them into DIS PDUs */
    public void run()
    {
        PduFactory pduFactory = new PduFactory();
        
        try
        {
            socket.setSoTimeout(SOCKET_TIMEOUT_PERIOD);
            while(continueRunning)
            {
                byte buffer[] = new byte[1500];
                DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
                
                socket.receive(datagram);
              
                // Turn the bytes into a DIS PDU and send them off to be processed
                Pdu aPdu = pduFactory.createPdu(datagram.getData());
                
                if(pduObserver != null)
                {
                    pduObserver.pduReceived(aPdu);
                }
                
            }
        }
        catch(SocketTimeoutException ste)
        {
            // Normal, ignore; this just gives us a chance to text the while loop exit criteria
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    @Override
    public void sendPdu(Pdu pdu)
    {
        try
        {
            byte buffer[] = pdu.marshal();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, destinationAddress, destinationPort);
            socket.send(packet);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    @Override
    public void setPduObserver(PduObserver pduObserver)
    {
        this.pduObserver = pduObserver;
    }
    
    @Override
    public void finalize()
    {
        System.out.println("In finalize for NetConnectionUnicast");
        try
        {
            super.finalize();
            if(socket != null && socket.isBound())
            {
                socket.close();
            }
        }
        catch(Throwable t)
        {
            System.out.println(t);
        }
    }
    
}
