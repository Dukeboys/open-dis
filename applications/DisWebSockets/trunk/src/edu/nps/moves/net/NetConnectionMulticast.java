
package edu.nps.moves.net;

import java.net.*;
import java.io.*;
import java.util.*;

import edu.nps.moves.dismobile.*;
import edu.nps.moves.disutil.*;

/**
 * A multicast NetConnection, which reads datagram/UDP packets sent to it, and sends
 * datagram/UDP packets to the multicast address.<p>
 * 
 * This implements the Runnable interface, so that it reads data from the wire.
 * The Runnable interface is implemented in the concrete subclasses, since potentially
 * not every concrete implementation of NetConnection needs it.<p>
 * 
 * @author mcgredo
 */
public class NetConnectionMulticast implements NetConnection, Runnable
{
    /** Time, in ms, before the socket times out on a read. In normal use this
     * simply gives us a chance to check if we should exit the read loop.
     */
    public static final int SOCKET_TIMEOUT_PERIOD = 5000;
    
    /** Thread that reads packets from the net */
    Thread         readThread;
    
    /** multicastcast socket */
    MulticastSocket socket;
    
    /** multicast address to send to */
    InetAddress destinationAddress;
    
    /** Port to read from */
    int port;
    
    /** port to send to */
    int destinationPort;
    
    /** User-friendly name */
    String         name;
    
    /** Boolean flag to exit read loop */
    boolean        continueRunning = true;
    
    /** Send received PDUs to this for distribution to interested parties */
    PduObserver pduObserver = null;
    
    /**
     * Send to multicast address
     * 
     * @param description 
     */
    public NetConnectionMulticast(NetConnectionDescription description)
    {
        try
        {
            destinationAddress = InetAddress.getByName(description.connectionProperties.getProperty("destinationAddress"));
            if(!destinationAddress.isMulticastAddress())
            {
                System.out.println("Address " + destinationAddress + " is not a multicast address");
                return;
            }
            port = Integer.parseInt(description.connectionProperties.getProperty("port"));
            destinationPort = Integer.parseInt(description.connectionProperties.getProperty("destinationPort"));
            String ttl = description.connectionProperties.getProperty("timeToLive");
            
            short timeToLive = 0;
            if(ttl == null) // Somebody forgot to set TTL
            {
                timeToLive = 1; // Good for local network only
            }
            else
            {
                timeToLive = Short.parseShort(ttl);
            }
            
           
            socket = new MulticastSocket(port);
            socket.setLoopbackMode(false); // Don't read packets we sent
            socket.joinGroup(destinationAddress);
            socket.setTimeToLive(timeToLive);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    /** It's dangerous to start a thread from inside a constructor, so we have to expose a start()
     * method as well.
     */
    public void start()
    {
        readThread = new Thread(this);
        readThread.start();
    }
    
    public void stopReadThread()
    {
        continueRunning = false;
    }
    
    public NetConnectionDescription.ConnectionType getConnectionType()
    {
        return NetConnectionDescription.ConnectionType.UDP_MULTICAST;
    }
    
    
    @Override
    /** Reads packets from the wire, turns them into DIS PDUs */
    public void run()
    {
        System.out.println("Starting to read from the network");
        PduFactory pduFactory = new PduFactory();
        
        try
        {
            socket.setSoTimeout(SOCKET_TIMEOUT_PERIOD);
            while(continueRunning)
            {
                try
                {
                    byte buffer[] = new byte[1500];
                    DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);

                    socket.receive(datagram);
                    
                    // Did this come from us? If so, discard it.
                    if(datagram.getAddress().equals(InetAddress.getLocalHost()))
                    {
                        System.out.println("Got loopack PDU from network");
                        continue;
                    }

                    // Turn the bytes into a DIS PDU and send them off to be processed
                    Pdu aPdu = pduFactory.createPdu(datagram.getData());

                    if(pduObserver != null)
                    {
                        pduObserver.pduReceived(aPdu);
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
                
            } // end while loop
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
            
            byte[] buffer = pdu.marshal();
            
            
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, destinationAddress, destinationPort);
            socket.send(packet);
            
        }
        catch(Exception e)
        {
            System.out.println("Unable to send PDU");
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
        System.out.println("In finalize method for NetConnectionMulticast");
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
