package edu.nps.moves.examples;

import java.io.*;
import java.net.*;
import java.util.*;

import edu.nps.moves.dis.*;
import edu.nps.moves.disutil.DisTime;

/**
 * Creates and sends ESPDUs in IEEE binary format. 
 *
 * @author DMcG
 */
public class EspduSender 
{
    public enum NetworkMode{UNICAST, MULTICAST, BROADCAST};

    /** multicast group we send on */
    public static final String MULTICAST_GROUP="239.1.2.3";
   
    /** Port we send on */
    public static final int    PORT = 62040;
    
/** Possible system properties:
     * networkMode: unicast, broadcast, multicast
     * destinationIp: where to send the packet. If in multicast mode, this can be mcast.
     *                To determine bcast destination IP, use an online bcast address
     *                caclulator, for example http://www.remotemonitoringsystems.ca/broadcast.php
     *                If in mcast mode, a join() will be done on the mcast address.
     * port: port used for both source and destination.
     * @param args 
     */
public static void main(String args[])
{
    EntityStatePdu espdu = new EntityStatePdu();
    MulticastSocket socket = null;
    DisTime disTime = DisTime.getInstance();

    
    // Default settings. These are used if no system properties are set. 
    // If system properties are passed in, these are over ridden.
    int port = PORT;
    NetworkMode mode = NetworkMode.MULTICAST;
    InetAddress destinationIp = null;
    
    try
    {
        destinationIp = InetAddress.getByName("239.1.2.3");
    }
    catch(Exception e)
    {
        System.out.println("Cannot create multicast address");
        System.exit(0);
    }
    
    // All system properties, passed in on the command line via -Dattribute=value
    Properties systemProperties = System.getProperties();
    
    // IP address we send to
    String destinationIpString = systemProperties.getProperty("destinationIp");
    
    // Port we send to, and local port we open the socket on
    String portString = systemProperties.getProperty("port");
    
    // Network mode: unicast, multicast, broadcast
    String networkModeString = systemProperties.getProperty("networkMode"); // unicast or multicast or broadcast
        

    try
    {
      
        if(portString != null)
            port = Integer.parseInt(portString);
        
        socket = new MulticastSocket(port);
        
        if(destinationIpString != null)
        {
            destinationIp = InetAddress.getByName(destinationIpString);
        }

        if(networkModeString != null)
        {
            if(networkModeString.equalsIgnoreCase("unicast"))
                mode = NetworkMode.UNICAST;
            else if(networkModeString.equalsIgnoreCase("broadcast"))
                mode = NetworkMode.BROADCAST;
            else if(networkModeString.equalsIgnoreCase("multicast"))
            {
                mode = NetworkMode.MULTICAST;
                if(!destinationIp.isMulticastAddress())
                {
                    throw new RuntimeException("Sending to multicast address, but destination address " + destinationIp.toString() + "is not multicast");
                }
                
                socket.joinGroup(destinationIp);
                
            }
        } // end networkModeString
    }
    catch(Exception e)
    {
        System.out.println(e);
        System.exit(-1);
    }
    
    espdu.setExerciseID((short)0);
    
    // The EID is the unique identifier for objects in the world. This 
    // EID should match up with the ID for the object specified in the 
    // VMRL/x3d world.
    EntityID eid = espdu.getEntityID();
    eid.setSite(0);
    eid.setApplication(1); // 1
    eid.setEntity(2); // 2

    try
    {
        
        while(true)
        {
            System.out.println("Sending 100 ESPDU packets to " + destinationIp.toString());
            for(int idx = 0; idx < 100; idx++)
            {
                // The timestamp should be monotonically increasing. Many implementations
                // discard packets that have earlier timestamps (assumption is that it
                // arrived out of order) or non-increasing timestamp (dupe packet).
                // The time should be slaved to clock time, so we can determine the time
                // between packets, but this is the minimum for testing.
                long timestamp = espdu.getTimestamp();
                timestamp++;
                espdu.setTimestamp(timestamp);

                // An alterative approach: actually follow the standard.
                //int ts = disTime.getDisAbsoluteTimestamp();
                //espdu.setTimestamp(ts);
                
                // Modify the x-axis position of the object
                // 36.595517, -121.877939
                Vector3Double location = espdu.getEntityLocation();
                location.setX(36.595517);
                location.setY(-121.877939 + (double)((double)idx / 1000.0));
                
                // Do some rotation to make sure that works
                Orientation orientation = espdu.getEntityOrientation();
                float psi = orientation.getPsi();
                psi = psi + idx;
                orientation.setPsi(psi);
                orientation.setTheta((float)(orientation.getTheta() + idx /2.0));
                
                // Marshal out the object to a byte array, then send a datagram
                // packet with that data in it.
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                espdu.marshal(dos);
                byte[] data = baos.toByteArray();
               
                DatagramPacket packet = new DatagramPacket(data, data.length, destinationIp, PORT);
                
                socket.send(packet);
                Thread.sleep(1000);
                
                System.out.print("Espdu #" + idx + " EID=[" + eid.getSite() + "," + eid.getApplication() + "," + eid.getEntity() + "]");
                System.out.println(" Location=[" + location.getX() + "," + location.getY() + "," + location.getZ() + "]");
                                   
            }
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
        
}

}
