package edu.nps.moves.examples;

import edu.nps.moves.dis.*;

import java.io.*;
import javax.xml.bind.*;
import java.util.*;

/**
 * Example of using JAXB to marshal and unmarshal to XML. Uses
 * Jaxb 2.1.x.
 * 
 * @author DMcG
 * @version $Id:$
 */
public class MarshallExample {

    /**
     * Shows how to marshal out to XML and read from XML files.
     * @param args
     */
    public static void main(String args[]) {

        PduContainer container = new PduContainer(); // XmlRootElement marked class

        // A few PDUs to marshal
        EntityStatePdu espdu = new EntityStatePdu();
        FirePdu firePdu = new FirePdu();
        DetonationPdu detonationPdu = new DetonationPdu();
        FirePdu bang = new FirePdu();

        // Add them to the XmlRootElement container
        container.getPdus().add(espdu);
        container.getPdus().add(firePdu);
        container.getPdus().add(detonationPdu);
        container.getPdus().add(bang);
        
		// Create some more PDUs, setting the location, velocity, and entity IDs
		// to be random numbers.
        for(int idx = 0; idx < 20; idx++)
        {
            EntityStatePdu pdu = new EntityStatePdu();
            
            Vector3Double loc = pdu.getEntityLocation();
            loc.setX(Math.random());
            loc.setY(Math.random());
            loc.setZ(Math.random());
            
            Vector3Float vel = pdu.getEntityLinearVelocity();
            vel.setX((float)Math.random());
            vel.setY((float)Math.random());
            vel.setZ((float)Math.random());
            
            EntityID eid = pdu.getEntityID();
            eid.setSite((short)(Math.random() * 1000));
            eid.setApplication((short)(Math.random() * 1000));
            eid.setEntity((short)(Math.random() * 1000));
            
            container.getPdus().add(pdu);
        }

        // And marshal it out to an XML file. We have the PduContainer, which 
		// holds all the PDUs. Marshal it out to the given XML file.
        try 
		{
			// The context, which will contain the package of the classes we marshal
			// out
            JAXBContext context = JAXBContext.newInstance("edu.nps.moves.dis"); 
			
			// Choose the file to send to, and make it pretty-print
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(container, new FileOutputStream("somePdus.xml"));
            

            // Just to prove nothing funny is going on, read the XML file back in
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PduContainer unmarshalledObject = (PduContainer) unmarshaller.unmarshal(new FileInputStream("somePdus.xml"));
            System.out.println("got " + unmarshalledObject.getNumberOfPdus() + " back");
			
			List<Pdu> unmarshalledPdus = unmarshalledObject.getPdus();
			
			System.out.println("Marshalled PDUs out to XML, read them back, contents of list are...");
			for(int idx = 0; idx < unmarshalledPdus.size(); idx++)
			{
				Pdu aPdu = unmarshalledPdus.get(idx);
				System.out.println("   Pdu Type: " + aPdu.getClass().getName());
				if(aPdu instanceof EntityStatePdu)
				{
					EntityStatePdu es = (EntityStatePdu)aPdu;
					System.out.println("      EID:(" + es.getEntityID().getSite() + "," + 
									           es.getEntityID().getApplication() + "," + 
									           es.getEntityID().getEntity() + ")");
				}
			}
			
			
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);

        }
    }
}
