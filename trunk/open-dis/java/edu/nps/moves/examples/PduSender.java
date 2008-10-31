package edu.nps.moves.examples;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.bind.*;

import edu.nps.moves.dis.*;
import edu.nps.moves.disenum.PduType;

/**
 * This is an example that sends many/most types of PDUs. Useful for testing standards
 * compliance or getting a full set of PDUs. It also writes the generated PDUs to
 * an XML file.
 *
 * @author DMcG
 */

public class PduSender extends Object
{
    public static final int PORT = 62040;
    public static final String MULTICAST_ADDRESS = "239.1.2.3";
    
    public static void main(String args[])
    {
        try
        {
            List<Pdu> generatedPdus = new ArrayList<Pdu>();
            
            // Loop through all the enumerated PDU types, create a PDU for each type,
            // and add that PDU to a list.
            for(PduType pdu: PduType.values())
            {
                Pdu aPdu = null;
                
                switch(pdu)
                {
                    case ENTITY_STATE: 
                        new EntityStatePdu();                        
                        break;
                        
                    case FIRE: 
                        aPdu = new FirePdu();
                        break;
                        
                    case DETONATION:
                        aPdu = new DetonationPdu();
                        break;
                        
                    case COLLISION:
                        aPdu = new CollisionPdu();
                        break;
                        
                    case SERVICE_REQUEST:
                        aPdu = new ServiceRequestPdu();
                        break;
                        
                    case RESUPPLY_OFFER:
                        aPdu = new ResupplyOfferPdu();
                        break;
                        
                    case RESUPPLY_RECEIVED:
                        aPdu = new ResupplyReceivedPdu();
                        break;
                        
                    case RESUPPLY_CANCEL:
                        aPdu = new ResupplyCancelPdu();
                        break;
                        
                    case REPAIR_COMPLETE:
                        aPdu = new RepairCompletePdu();
                        break;
                        
                    case REPAIR_RESPONSE:
                        aPdu = new RepairResponsePdu();
                        break;
                        
                    case CREATE_ENTITY:
                        aPdu = new CreateEntityPdu();
                        break;
                        
                    case REMOVE_ENTITY:
                        aPdu = new RemoveEntityPdu();
                        break;
                        
                    case START_RESUME:
                        aPdu = new StartResumePdu();
                        break;
                        
                    case STOP_FREEZE:
                        aPdu = new StopFreezePdu();
                        break;
                        
                    case ACKNOWLEDGE:
                        aPdu = new AcknowledgePdu();
                        break;
                        
                    case ACTION_REQUEST:
                        aPdu = new ActionRequestPdu();
                        break;
                        
                    default: 
                        System.out.print("PDU not explictly handled. Type=" + pdu);
                        System.out.println();
                }
                
                if(aPdu != null)
                {
                    generatedPdus.add(aPdu);
                }
            }
                        
            // Send the PDUs we created
            InetAddress multicastAddress = InetAddress.getByName(MULTICAST_ADDRESS);
            MulticastSocket socket = new MulticastSocket(PORT);
            socket.joinGroup(multicastAddress);
                        
            for(int idx = 0; idx < generatedPdus.size(); idx++)
            {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                byte[] buffer;
                
                Pdu aPdu = generatedPdus.get(idx);
                aPdu.marshal(dos);
                
                buffer = baos.toByteArray();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, multicastAddress, PORT);
                socket.send(packet);
                //System.out.println(".");
            }
            
            // write the PDUs out to an XML file.
            PduContainer container = new PduContainer();
            container.setPdus(generatedPdus);
            container.marshallToXml("examplePdus.xml");    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}