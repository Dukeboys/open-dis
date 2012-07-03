
package edu.nps.moves.examples;

import edu.nps.moves.dis.*;
import edu.nps.moves.disutil.*;
import java.io.*;
import java.net.*;
import java.util.*;


/**
 *
 * @author mcgredo
 */
public class MissileSetup 
{
    public static final int PORT = 62040;
    public static final String MULTICAST_ADDRESS = "239.1.2.3";
    
    // Some made-up numbers for various things. 
    public static final int CHINA_LAKE = 17;
    public static final int XPLANE_APPLICATION = 127;
    public static final int JAAM_APPLICATION = 512;
    public static final int MISSILE_SHOOTER_ID = 1024;
    public static final int TARGET_ID = 8;
    public static final int RECEIVING_MISSILE_ID = 2048;
    
    public static MissileSetup missileSetup = null;
    
    MulticastSocket socket;
    
    public static void main(String args[])
    {
        MissileSetup setup = new MissileSetup();
        setup.sendInteractions();
        
    }
    
    public synchronized void send(Pdu aPdu)
    {
        try
        {
            byte buffer[] = aPdu.marshalWithDisAbsoluteTimestamp();
            InetAddress address = InetAddress.getByName(MULTICAST_ADDRESS);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, PORT );
            socket.send(packet);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static MissileSetup getInstance()
    {
        if(missileSetup == null)
        {
            missileSetup = new MissileSetup();
        }
        
        return missileSetup;
    }
    
    
    private MissileSetup()
    {
        socket = null;
        
        try
        {
            socket = new MulticastSocket(PORT);
            InetAddress address = InetAddress.getByName(MULTICAST_ADDRESS);
            socket.joinGroup(address);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    /**
     * Creates a SetDataPdu that has missile initialization data in it.
     * One and only one copy of this message should be sent. (In reality
     * this is problematic since UDP is unreliable.)<p>
     * 
     * VariableDatumID with ID=0 contains a number that tells us what
     * type of SetDataPdu this is. mode=0 is an intialization PDU.
     * 
     * @return an initialized SetDataPdu
     */
    public SetDataPdu createInitializeSetDataPdu()
    {
        SetDataPdu initializationPdu = new SetDataPdu();
        
        // EID of the shooter (or at least the RWS)
        EntityID originatingID = initializationPdu.getOriginatingEntityID();
        originatingID.setSite(CHINA_LAKE);                // China Lake, let's say.
        originatingID.setApplication(XPLANE_APPLICATION); // XPlane, let's say. Officially the ID of the RWS
        originatingID.setEntity(MISSILE_SHOOTER_ID);      // ID of the plane launching missile
        
        // A made-up entityID for the missile that will be receiving the data
        EntityID receivingEntityID = initializationPdu.getReceivingEntityID();
        receivingEntityID.setSite(CHINA_LAKE);
        receivingEntityID.setApplication(JAAM_APPLICATION);    // JAAM, let's say
        receivingEntityID.setEntity(RECEIVING_MISSILE_ID);     // ID of the missile receiving the update
        
        // We add a bunch of data to the SetDataPdu. These are all VariableDatums, which consist
        // of an ID, a length (in bits) of the data, and the data itself, in big endian format,
        // in chunks of up to 64 bits apiece. See section 5.3.32 
        
       try
       {
            // What type of event we're setting for: initialization, umbilical data, etc.
           
            // Note that we need to be careful here to keep everything in big endian format,
            // so we use the laborous process of marshalling via data output streams instead
            // of just directly setting things.
           
            // mode
            List<VariableDatum> varDatums = initializationPdu.getVariableDatums();
            VariableDatum d0 = new VariableDatum();
            
            // mode=0 on datumID 0 means this is an initialization SetDataPdu
            d0.setVariableDatumID(0);
            d0.setVariableDatumLength(16); // in bits
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeShort(0);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            
            // missile entity identifier (site, app, num)
            d0 = new VariableDatum();
            d0.setVariableDatumID(1);
            d0.setVariableDatumLength(48); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            EntityID eid = new EntityID();
            eid.setSite(CHINA_LAKE);
            eid.setApplication(XPLANE_APPLICATION);
            eid.setEntity(RECEIVING_MISSILE_ID);
            eid.marshal(dos);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            
            // Missile type, 1=AIM120, 2-AIM9x
            d0 = new VariableDatum();
            d0.setVariableDatumID(2);
            d0.setVariableDatumLength(16); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeShort(2);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            
            // Missile subtype, 1=AIM120, 2-AIM9x
            d0 = new VariableDatum();
            d0.setVariableDatumID(3);
            d0.setVariableDatumLength(16); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeShort(3);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            
            // Random number seed
            d0 = new VariableDatum();
            d0.setVariableDatumID(4);
            d0.setVariableDatumLength(32); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeInt(17);                         // 17 is the most random number
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            
            // launch station
            d0 = new VariableDatum();
            d0.setVariableDatumID(5);
            d0.setVariableDatumLength(16); // in bits
            byte[] data = new byte[2];
            data[0] = '2';
            data[1] = 'A';
            d0.setVariableData(data);
            varDatums.add(d0);
            
            // Mounting angle
            d0 = new VariableDatum();
            d0.setVariableDatumID(6);
            d0.setVariableDatumLength(48); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            Vector3Float ma = new Vector3Float();
            ma.setX(0.1f);
            ma.setY(0.2f);
            ma.setZ(0.3f);
            ma.marshal(dos);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            
            //System.out.println("Variable datums are " + varDatums.size() + " setDataPdu:" + initializationPdu.getNumberOfVariableDatumRecords() );
       }
       catch(Exception e)
       {
           e.printStackTrace();
           System.out.println(e);
       }
        
        return initializationPdu;
    }
    
    public SetDataPdu createUmbilicalDataPdu()
    {
        SetDataPdu umbilicalDataPdu = new SetDataPdu();
        
        List<VariableDatum> variableDatums = umbilicalDataPdu.getVariableDatums();
        VariableDatum d0 = new VariableDatum();
        
        try
        {
            System.out.println("Creating umbilical data SetDataPdu");
            // mode=1 in datumID 0 means this is an umbilical data setDataPdu
            d0.setVariableDatumID(0);
            d0.setVariableDatumLength(16); // in bits
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeShort((short)1);
            d0.setVariableData(baos.toByteArray());
            variableDatums.add(d0);
            
            // Alignment uncertainty
            d0 = new VariableDatum();
            d0.setVariableDatumID(101);
            d0.setVariableDatumLength(96); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeFloat(1.0f);
            dos.writeFloat(2.0f);
            dos.writeFloat(3.0f);
            d0.setVariableData(baos.toByteArray());
            variableDatums.add(d0);
            
            // Eject velocity
            d0 = new VariableDatum();
            d0.setVariableDatumID(102);
            d0.setVariableDatumLength(96); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeFloat(1.0f);
            dos.writeFloat(2.0f);
            dos.writeFloat(3.0f);
            d0.setVariableData(baos.toByteArray());
            variableDatums.add(d0);
            
            // Engagement order number, 0=visual launch, 1-4
            d0 = new VariableDatum();
            d0.setVariableDatumID(103);
            d0.setVariableDatumLength(32); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeInt(0); // visual launch
            d0.setVariableData(baos.toByteArray());
            variableDatums.add(d0);
            
            // First datalink time
            d0 = new VariableDatum();
            d0.setVariableDatumID(104);
            d0.setVariableDatumLength(64); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeDouble(10.0); // first data link time
            d0.setVariableData(baos.toByteArray());
            variableDatums.add(d0);
            System.out.println("First datalink time");
            
            // Radar resolutions
            d0 = new VariableDatum();
            d0.setVariableDatumID(105);
            d0.setVariableDatumLength(128); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeFloat(1.0f);
            dos.writeFloat(2.0f);
            dos.writeFloat(3.0f);
            dos.writeFloat(4.0f);
            d0.setVariableData(baos.toByteArray());
            variableDatums.add(d0);
            System.out.println("Radar resolutions");
        }
        catch(Exception e)
        {
           System.out.println(e); 
        }
        
        return umbilicalDataPdu;
        
    }
    
    public FirePdu createFirePdu()
    {
        FirePdu firePdu = new FirePdu();
        EntityID shooter = firePdu.getFiringEntityID();
        shooter.setSite(CHINA_LAKE);
        shooter.setApplication(XPLANE_APPLICATION);
        shooter.setEntity(MISSILE_SHOOTER_ID);
        
        EntityID target = firePdu.getTargetEntityID();
        target.setSite(CHINA_LAKE);
        target.setApplication(JAAM_APPLICATION);
        target.setEntity(TARGET_ID);
        
        EventID eventID = firePdu.getEventID();
        eventID.setSite(CHINA_LAKE);
        eventID.setEventNumber(512);
        
        return firePdu;
        
    }
    
    /** Create an entity state pdu to describe the shooter
     * 
     * @return 
     */
    public EntityStatePdu createShooterEntityStatePdu()
    {
        EntityStatePdu espdu = new EntityStatePdu();
        
        EntityID shooter = espdu.getEntityID();
        shooter.setSite(CHINA_LAKE);
        shooter.setApplication(XPLANE_APPLICATION);
        shooter.setEntity(MISSILE_SHOOTER_ID);
        
        espdu.getEntityLocation().setX(0.0);
        espdu.getEntityLocation().setY(0.0);
        espdu.getEntityLocation().setZ(1000.0);
    
        return espdu;
    }
    
    /** create an entity state pdu to describe the target
     * 
     * @return 
     */
    public EntityStatePdu createTargetEntityStatePdu()
    {
        EntityStatePdu espdu = new EntityStatePdu();
        
        espdu.getEntityID().setSite(CHINA_LAKE);
        espdu.getEntityID().setApplication(XPLANE_APPLICATION);
        espdu.getEntityID().setEntity(TARGET_ID);
        
        espdu.getEntityLocation().setX(1000.0);
        espdu.getEntityLocation().setY(0.0);
        espdu.getEntityLocation().setZ(1000.0);
    
        return espdu;
    }
    
    /** ESPDU completely unrelated to the missile/shooter/target
     * situation, just to make sure it doesn't cause problems on
     * receipt.
     * 
     * @return 
     */
    public EntityStatePdu createRandomEntityStatePdu()
    {
        EntityStatePdu espdu = new EntityStatePdu();
        
        espdu.getEntityID().setSite(CHINA_LAKE);
        espdu.getEntityID().setApplication(XPLANE_APPLICATION);
        espdu.getEntityID().setEntity(5000);
        
        espdu.getEntityLocation().setX(2000.0);
        espdu.getEntityLocation().setY(2000.0);
        espdu.getEntityLocation().setZ(2000.0);
    
        return espdu;
    }
    
    public SetDataPdu createLaunchPdu()
    {
        SetDataPdu launchPdu = new SetDataPdu();
        List<VariableDatum> varDatums = launchPdu.getVariableDatums();
        
        try
        {
            // Set the EID of the entity sending this.
            EntityID launcherEid = launchPdu.getOriginatingEntityID();
            launcherEid.setApplication(XPLANE_APPLICATION);
            launcherEid.setSite(CHINA_LAKE);
            launcherEid.setEntity(MISSILE_SHOOTER_ID);
            
            VariableDatum d0;
            ByteArrayOutputStream baos;
            DataOutputStream dos;
            
            // mode=2 in datumID 0 means this is a launch data setDataPdu
            d0 = new VariableDatum();
            d0.setVariableDatumID(0);
            d0.setVariableDatumLength(16); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeShort(2);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            System.out.println("Added mode");
            
            
            // target 1 identifier
            d0 = new VariableDatum();
            d0.setVariableDatumID(201);
            d0.setVariableDatumLength(48); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            EntityID eid = new EntityID();
            eid.setSite(CHINA_LAKE);
            eid.setApplication(XPLANE_APPLICATION);
            eid.setEntity(TARGET_ID);
            eid.marshal(dos);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            System.out.println("added target1 identifer in launch setData");
            
            // target 2 identifier
            /*
            d0 = new VariableDatum();
            d0.setVariableDatumID(202);
            d0.setVariableDatumLength(48); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            eid = new EntityID();
            eid.setSite(CHINA_LAKE);
            eid.setApplication(XPLANE_APPLICATION);
            eid.setEntity(RECEIVING_MISSILE_ID);
            eid.marshal(dos);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
            System.out.println("added target1 identifer in launch setData");
            * */
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return launchPdu;
    }
    
    
    public SetDataPdu createInitializeAndLaunch()
    {
        SetDataPdu createAndInitialize = new SetDataPdu();
        
        return createAndInitialize;
    }
    
    /** Create a SetDataPdu with deletion data in it 
     * 
     * @return 
     */
    public SetDataPdu createDeleteDataPdu()
    {
        SetDataPdu deleteDataPdu = new SetDataPdu();
        List<VariableDatum> varDatums = deleteDataPdu.getVariableDatums();
        
        try
        {
            VariableDatum d0;
            ByteArrayOutputStream baos;
            DataOutputStream dos;
            
            // mode=3 in datumID 0 means this is a delete data setDataPdu
            d0 = new VariableDatum();
            d0.setVariableDatumID(0);
            d0.setVariableDatumLength(16); // in bits
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeShort(3);
            d0.setVariableData(baos.toByteArray());
            varDatums.add(d0);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return deleteDataPdu;
    }
    
    public void sendInteractions()
    {
        // Construct a SetDataPdu to send, which initializes the data on the missile.
        // This is sent from the shooter to the missile on the rail.
        SetDataPdu initializationDataPdu = this.createInitializeSetDataPdu();
        FirePdu firePdu = this.createFirePdu();
        SetDataPdu umbilicalDataPdu = this.createUmbilicalDataPdu();
        SetDataPdu launchPdu = this.createLaunchPdu();
        
        EntityStatePdu shooter = this.createShooterEntityStatePdu();
        EntityStatePdu target = this.createTargetEntityStatePdu();
        
        // Create a couple threads to periodically send out espdus for
        // the shooter and target. These will be sent async throughout
        // the execution at random intervals.
       
        PduSenderInThread shooterT = new PduSenderInThread(shooter);
        Thread shooterThread = new Thread(shooterT);
        shooterThread.start();
        
        // The target object
        PduSenderInThread targetT = new PduSenderInThread(target);
        Thread targetThread = new Thread(targetT);
        targetThread.start();
        
        // An extra PDU, just to test the ability of the missile server
        // to handle PDUs unrelated to the shooter and target
        EntityStatePdu random = this.createRandomEntityStatePdu();
        PduSenderInThread randomT = new PduSenderInThread(random);
        Thread randomThread = new Thread(randomT);
        randomThread.start();
       
        try
        {
            
            System.out.println("Sending initialization setDataPdu");
            for(int idx = 0; idx < 1; idx++)
            {
                this.send(initializationDataPdu);
            }
            
            
            System.out.println("Sending umbilical updates");
            for(int idx = 0; idx < 5; idx++)
            {
                System.out.println("     Sending umbilical data...");
                this.send(umbilicalDataPdu);
                Thread.sleep((long)(Math.random() * 10000));
            }
            
 
            System.out.println("Sending launch pdu");
            for(int idx = 0; idx < 1; idx++)
            {
                System.out.println("     Sending launch data...");
                this.send(launchPdu);
            }
            
            
            System.out.println("Sending firePDU");
            for(int idx = 0; idx < 1; idx++)
            {
                this.send(firePdu);
            }
            
            Thread.sleep(100000);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
                
        
    }
    
}
