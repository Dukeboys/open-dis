package edu.nps.moves.net;

import java.io.*;
import java.net.*;
import java.util.*;

import edu.nps.moves.dis.Pdu;
import edu.nps.moves.disutil.PduFactory;

/**
 * This implements an object that can read and write DIS PDUs from a unicast
 * or multicast UDP socket. It implements the BehaviorProducer interface,
 * which allows objects to register as listeners for PDU arrival events,
 * and the BehaviorWriter interface, which allows PDUs to be written. It's
 * a bit complex internally, but not all that bad from an interface standpoint.<p>
 *
 * This runs in a thread of its own. The listeners for PDU events can either
 * run in threads of their own, which is a bit complex, or simply process
 * PDU objects as they come in, which is simple but may have performance
 * problems if processing a PDU takes a long time.<p>
 *
 * @author DMcG
 */
public class BehaviorProducerUDP implements BehaviorProducerIF, // Listener pattern for pdus
                                            BehaviorWriterIF, // IF for writing DIS pdus
                                            Runnable // Threaded object
{

    /** The (rough) size of an ethernet frame */
    public static final int MTU_SIZE = 1500;
    /** People who listen to us for PDU events. This is a Vector rather than
     * the preferred List to preserve compatability with older VRML browsers
     * that don't have the newer List interface.
     */
    private Vector<BehaviorConsumerIF> behaviorConsumerListeners;
    /**
     * Whether listeners are given unique copies of PDUs, or a single shared
     * copy.
     */
    private boolean useCopies = true;
    /**
     * Socket (multicast or unicast) that sends and receives data
     */
    private DatagramSocket socket;
    private InetAddress defaultDestinationIP = null;
    private int defaultDestinationPort = -1;

    public BehaviorProducerUDP(DatagramSocket pSocket) {
        behaviorConsumerListeners = new Vector<BehaviorConsumerIF>();
        socket = pSocket;
    }

    /**
     * Add a listener that will be notified when a PDU is
     * ready.
     *
     * @param consumer the object that will be notified of the PDU
     */
    public void addListener(BehaviorConsumerIF consumer) {
        // Add it only if absent, so we don't get dupe copies.
        if (!(behaviorConsumerListeners.contains(consumer))) {
            behaviorConsumerListeners.add(consumer);
        }
    }

    /**
     * Remove a listener/consumer of PDUs from the notification list.
     *
     * @param consumer to be removed from the notification list
     */
    public void removeListener(BehaviorConsumerIF consumer) {
        behaviorConsumerListeners.remove(consumer);
    }

    /**
     * Set a default destination, the destination that the plain
     * write(Pdu pdu) method will send to.
     *
     * Not an option for this concrete subclass.
     *
     * @param obj object that describes default destination
     */
    public void setDefaultDestination(Object obj) {
        throw new RuntimeException("Cannot create default destination with this data");
    }

    /**
     * Set the default destination that the plain write(pdu) method
     * will send data to.
     *
     * @param obj1 first object that describes destination (eg, IP)
     * @param obj2 second object that describes destination (eg, port number)
     */
    public void setDefaultDestination(Object obj1, Object obj2) {
        
        if (!(obj1 instanceof InetAddress) || !(obj2 instanceof Integer)) {
            throw new RuntimeException("The default destination must be an IP adddress and Integer port");
        }

        defaultDestinationIP = (InetAddress) obj1;
        defaultDestinationPort = ((Integer) obj2).intValue();
    }

    /**
     * Set the default destination that the plain write(pdu) method
     * will send data to.
     *
     * @param obj array of objects that specifies the destination
     */
    public void setDefaultDestination(Object obj[]) {
        if (obj.length != 2) {
            throw new RuntimeException("Wrong number of arguments to default destination");
        }

        this.setDefaultDestination(obj[0], obj[1]);
    }

    /**
     * Write a PDU to the default destination
     *
     * @param pdu the DIS PDU to be written
     */
    public void write(Pdu pdu) {
        this.write(pdu, defaultDestinationIP, defaultDestinationPort);
    }

    /**
     * Where the packet actually gets sent. This is the root functionality of
     * the class, what all the other write() methods eventually call.
     *
     * @param pdu the DIS pdu to write
     * @param addr the IP address to write to
     * @param port the destination port
     */
    private void write(Pdu pdu, InetAddress addr, int port) {
        DataOutputStream dos;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte buffer[];

        try {
            DatagramPacket packet;

            dos = new DataOutputStream(baos);
            pdu.marshal(dos);
            buffer = baos.toByteArray();
            packet = new DatagramPacket(buffer, buffer.length, addr, port);

            socket.send(packet);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Write a DIS pdu to the destination described by the object
     *
     * @param pdu the DIS pdu to write
     * @param destination Object that describes destination to write to
     */
    public void write(Pdu pdu, Object destination) {
        throw new RuntimeException("Use the two-parameter version of write()");
    }

    /**
     * Write a DIS PDU to the destination described by the objects.
     *
     * @param pdu the DIS pdu to write
     * @param destination1 object that describes destination (the InetAddress)
     * @param destination2 object that describes destination (Port number as an Integer object)
     */
    public void write(Pdu pdu, Object destination1, Object destination2) {
        if (!(destination1 instanceof InetAddress) || !(destination2 instanceof Integer)) {
            throw new RuntimeException("Arguments must be an internet address (unicast or multicast) and an Integer object");
        }

        this.write(pdu, (InetAddress) destination1, (((Integer) destination2).intValue()));
    }

    /**
     * write the DIS pdu to the destination described by the array of objects.
     *
     * @param pdu the dis pdu to write
     * @param dest array of objects that describe the destination to write to; [0] is the inetAddress, [1] is port number integer
     */
    public void write(Pdu pdu, Object dest[]) {
        if (dest.length != 2) {
            throw new RuntimeException("write desitnation array must have two elements, the first of which is an InetAddress, the second of which is an Integer object");
        }
        this.write(pdu, dest[0], dest[1]);
    }

    /**
     * This is a performance option. When a PDU arrives we want to distribute
     * it to all listeners. If we use a single copy of the object distributed
     * to all listeners this may cause problems if one listener modifies the
     * object and undermines the expectations of another listener. To avoid this
     * we can create a new copy of the PDU and hand off a new, unique copy of
     * the object to each listener. But this may cause some performance problems,
     * since it takes a while to allocate a new object.<p>
     *
     * The default behavior should be to distribute a new, unqiue copy to each
     * listener. this allows the user to override this behavior for better
     * performance.
     *
     * @param shouldCreateCopy true to create a new copy for each listener,
     * false for a shared copy for each listener
     */
    public void setUseCopies(boolean shouldCreateCopy) {
        useCopies = shouldCreateCopy;
    }

    /**
     * Entry point for thread.
     */
    public void run() {
        // Alan: moved these outside loop to lower gc
        byte buffer[] = new byte[MTU_SIZE];
        Pdu pdu;
        PduFactory pduf = new PduFactory();

        DatagramPacket packet;

        packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            try {
                socket.receive(packet);
                pdu = pduf.createPdu(packet.getData());
                if (pdu != null) {
                    for (int idx = 0; idx < behaviorConsumerListeners.size(); idx++) {
                        BehaviorConsumerIF consumer = behaviorConsumerListeners.elementAt(idx);

                        // Use a copy of the received PDU for more safety, or send a single
                        // copy of the object to multiple listeners for better performance.
                        if (useCopies) {
                            Pdu copyPdu = pduf.createPdu(packet.getData());
                            consumer.receivePdu(copyPdu, this);
                        } else {
                            consumer.receivePdu(pdu, this);
                        }
                    }
                } // if pdu != null
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        } // End while true
    } // end run()

} // end class file BehaviorProducerUDP.java