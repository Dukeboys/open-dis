package edu.nps.moves.examples;

import edu.nps.moves.dis.*;

import java.io.*;
import javax.xml.bind.*;
/**
 * Example of using JAXB to marshal and unmarshal to XML. Uses
 * Jaxb 2.1.x.
 * 
 * @author DMcG
 */
public class MarshallExample 
{
    /**
     * Shows two ways to marshal and unmarshal XML. The first way to marshal
     * involves calling a method in a class marked as an XmlRootElement in
     * the generated code. The second (preferred) way involves simply calling
     * the required marshal/unmarshal code external to the XmlRootElement
     * class.
     */
    public static void main(String args[])
    {
        
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
       
       // And marshall it to this file
       container.marshallToXml("somePdus.xml");
       
       // An alternative (preferred) way. Really, the above marshalToXml method was
       // created only because JAXBContext requires a list of all the classes that
       // may be marshalled out. That could be generated automatically, and from
       // there you can simply cut & paste the code to create a new JAXBContext
       // object. (To be official, the JAXBContext can pick up any statically
       // referenced class in the class passed in, but with subclasses in a container
       // list that might fail.)
       try
       { 
        JAXBContext context = JAXBContext.newInstance(
        edu.nps.moves.dis.MinefieldStatePdu.class,
        edu.nps.moves.dis.AcknowledgeReliablePdu.class,
        edu.nps.moves.dis.SyntheticEnvironmentFamilyPdu.class,
        edu.nps.moves.dis.DesignatorPdu.class,
        edu.nps.moves.dis.AcousticBeamData.class,
        edu.nps.moves.dis.AcousticEmitterSystemData.class,
        edu.nps.moves.dis.FundamentalParameterDataIff.class,
        edu.nps.moves.dis.Relationship.class,
        edu.nps.moves.dis.EntityManagementFamilyPdu.class,
        edu.nps.moves.dis.FastEntityStatePdu.class,
        edu.nps.moves.dis.DataReliablePdu.class,
        edu.nps.moves.dis.BurstDescriptor.class,
        edu.nps.moves.dis.EntityInformationFamilyPdu.class,
        edu.nps.moves.dis.IffAtcNavAidsLayer2Pdu.class,
        edu.nps.moves.dis.NamedLocation.class,
        edu.nps.moves.dis.TransferControlRequestPdu.class,
        edu.nps.moves.dis.EightByteChunk.class,
        edu.nps.moves.dis.ElectronicEmissionsPdu.class,
        edu.nps.moves.dis.CreateEntityReliablePdu.class,
        edu.nps.moves.dis.LinearSegmentParameter.class,
        edu.nps.moves.dis.EventReportPdu.class,
        edu.nps.moves.dis.MinefieldResponseNackPdu.class,
        edu.nps.moves.dis.FourByteChunk.class,
        edu.nps.moves.dis.EntityStateUpdatePdu.class,
        edu.nps.moves.dis.EnvironmentalProcessPdu.class,
        edu.nps.moves.dis.GridAxisRecord.class,
        edu.nps.moves.dis.IntercomCommunicationsParameters.class,
        edu.nps.moves.dis.LinearObjectStatePdu.class,
        edu.nps.moves.dis.EventReportReliablePdu.class,
        edu.nps.moves.dis.ArealObjectStatePdu.class,
        edu.nps.moves.dis.AcousticBeamFundamentalParameter.class,
        edu.nps.moves.dis.Vector3Float.class,
        edu.nps.moves.dis.StopFreezePdu.class,
        edu.nps.moves.dis.ArticulationParameter.class,
        edu.nps.moves.dis.FixedDatum.class,
        edu.nps.moves.dis.CommentReliablePdu.class,
        edu.nps.moves.dis.ServiceRequestPdu.class,
        edu.nps.moves.dis.IsGroupOfPdu.class,
        edu.nps.moves.dis.UaPdu.class,
        edu.nps.moves.dis.PointObjectStatePdu.class,
        edu.nps.moves.dis.FundamentalParameterData.class,
        edu.nps.moves.dis.DataQueryReliablePdu.class,
        edu.nps.moves.dis.SetRecordReliablePdu.class,
        edu.nps.moves.dis.ElectronicEmissionBeamData.class,
        edu.nps.moves.dis.DetonationPdu.class,
        edu.nps.moves.dis.RecordSet.class,
        edu.nps.moves.dis.ActionResponsePdu.class,
        edu.nps.moves.dis.ShaftRPMs.class,
        edu.nps.moves.dis.ActionRequestPdu.class,
        edu.nps.moves.dis.IsPartOfPdu.class,
        edu.nps.moves.dis.DeadReckoningParameter.class,
        edu.nps.moves.dis.GridAxisRecordRepresentation2.class,
        edu.nps.moves.dis.MinefieldQueryPdu.class,
        edu.nps.moves.dis.SystemID.class,
        edu.nps.moves.dis.MinefieldDataPdu.class,
        edu.nps.moves.dis.SimulationAddress.class,
        edu.nps.moves.dis.EntityID.class,
        edu.nps.moves.dis.AntennaLocation.class,
        edu.nps.moves.dis.DataQueryPdu.class,
        edu.nps.moves.dis.EntityType.class,
        edu.nps.moves.dis.IffAtcNavAidsLayer1Pdu.class,
        edu.nps.moves.dis.GridAxisRecordRepresentation1.class,
        edu.nps.moves.dis.BeamAntennaPattern.class,
        edu.nps.moves.dis.ResupplyReceivedPdu.class,
        edu.nps.moves.dis.Orientation.class,
        edu.nps.moves.dis.Pdu.class,
        edu.nps.moves.dis.ReceiverPdu.class,
        edu.nps.moves.dis.AggregateType.class,
        edu.nps.moves.dis.Environment.class,
        edu.nps.moves.dis.WarfareFamilyPdu.class,
        edu.nps.moves.dis.StopFreezeReliablePdu.class,
        edu.nps.moves.dis.SetDataReliablePdu.class,
        edu.nps.moves.dis.CommentPdu.class,
        edu.nps.moves.dis.SimulationManagementWithReliabilityFamilyPdu.class,
        edu.nps.moves.dis.CollisionPdu.class,
        edu.nps.moves.dis.IffFundamentalData.class,
        edu.nps.moves.dis.VariableDatum.class,
        edu.nps.moves.dis.FirePdu.class,
        edu.nps.moves.dis.SetDataPdu.class,
        edu.nps.moves.dis.AcousticEmitterSystem.class,
        edu.nps.moves.dis.RemoveEntityReliablePdu.class,
        edu.nps.moves.dis.RepairCompletePdu.class,
        edu.nps.moves.dis.CreateEntityPdu.class,
        edu.nps.moves.dis.IntercomControlPdu.class,
        edu.nps.moves.dis.ModulationType.class,
        edu.nps.moves.dis.SixByteChunk.class,
        edu.nps.moves.dis.IntercomSignalPdu.class,
        edu.nps.moves.dis.AggregateID.class,
        edu.nps.moves.dis.StartResumePdu.class,
        edu.nps.moves.dis.ActionResponseReliablePdu.class,
        edu.nps.moves.dis.SimulationManagementFamilyPdu.class,
        edu.nps.moves.dis.SphericalHarmonicAntennaPattern.class,
        edu.nps.moves.dis.ElectronicEmissionSystemData.class,
        edu.nps.moves.dis.LayerHeader.class,
        edu.nps.moves.dis.Point.class,
        edu.nps.moves.dis.RecordQueryReliablePdu.class,
        edu.nps.moves.dis.ResupplyOfferPdu.class,
        edu.nps.moves.dis.ClockTime.class,
        edu.nps.moves.dis.SignalPdu.class,
        edu.nps.moves.dis.RadioEntityType.class,
        edu.nps.moves.dis.AggregateStatePdu.class,
        edu.nps.moves.dis.StartResumeReliablePdu.class,
        edu.nps.moves.dis.DistributedEmissionsFamilyPdu.class,
        edu.nps.moves.dis.TrackJamTarget.class,
        edu.nps.moves.dis.AngularVelocityVector.class,
        edu.nps.moves.dis.RepairResponsePdu.class,
        edu.nps.moves.dis.Vector3Double.class,
        edu.nps.moves.dis.AcknowledgePdu.class,
        edu.nps.moves.dis.EntityStatePdu.class,
        edu.nps.moves.dis.RemoveEntityPdu.class,
        edu.nps.moves.dis.PduContainer.class,
        edu.nps.moves.dis.GriddedDataPdu.class,
        edu.nps.moves.dis.VectoringNozzleSystemData.class,
        edu.nps.moves.dis.DataPdu.class,
        edu.nps.moves.dis.ActionRequestReliablePdu.class,
        edu.nps.moves.dis.EmitterSystem.class,
        edu.nps.moves.dis.GridAxisRecordRepresentation0.class,
        edu.nps.moves.dis.SeesPdu.class,
        edu.nps.moves.dis.MinefieldFamilyPdu.class,
        edu.nps.moves.dis.ObjectType.class,
        edu.nps.moves.dis.ApaData.class,
        edu.nps.moves.dis.BeamData.class,
        edu.nps.moves.dis.PropulsionSystemData.class,
        edu.nps.moves.dis.OneByteChunk.class,
        edu.nps.moves.dis.AcousticEmitter.class,
        edu.nps.moves.dis.TransmitterPdu.class,
        edu.nps.moves.dis.EventID.class,
        edu.nps.moves.dis.Marking.class,
        edu.nps.moves.dis.AggregateMarking.class,
        edu.nps.moves.dis.CollisionElasticPdu.class,
        edu.nps.moves.dis.TwoByteChunk.class,
        edu.nps.moves.dis.ResupplyCancelPdu.class,
        edu.nps.moves.dis.RadioCommunicationsFamilyPdu.class,
        edu.nps.moves.dis.LogisticsFamilyPdu.class,
        edu.nps.moves.dis.SupplyQuantity.class    );
                
          
           // Just to prove nothing funny is going on, read the XML file back in
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PduContainer unmarshalledObject = (PduContainer)unmarshaller.unmarshal(new FileInputStream("somePdus.xml"));
            System.out.println("got " + unmarshalledObject.getNumberOfPdus() + " back");
       }
       catch(Exception e)
       {
           e.printStackTrace();
           System.out.println(e);

       }
    }

}
