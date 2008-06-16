package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.*;

/**
 * Used for XML compatability. A container that holds PDUs
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
@XmlRootElement
public class PduContainer extends Object implements Serializable
{
   /** Number of PDUs in the container list */
   protected int  numberOfPdus;

   /** record sets */
   protected List pdus = new ArrayList(); 

/** Constructor */
 public PduContainer()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // numberOfPdus
   for(int idx=0; idx < pdus.size(); idx++)
   {
        Pdu listElement = (Pdu)pdus.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


@XmlAttribute
public int getNumberOfPdus()
{ return (int)pdus.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfPdus method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfPdus(int pNumberOfPdus)
{ numberOfPdus = pNumberOfPdus;
}

public void setPdus(List pPdus)
{ pdus = pPdus;
}

@XmlElementWrapper(name="pdusList" )
public List getPdus()
{ return pdus; }


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeInt( (int)pdus.size());

       for(int idx = 0; idx < pdus.size(); idx++)
       {
            Pdu aPdu = (Pdu)pdus.get(idx);
            aPdu.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       numberOfPdus = dis.readInt();
        for(int idx = 0; idx < numberOfPdus; idx++)
        {
           Pdu anX = new Pdu();
            anX.unmarshal(dis);
            pdus.add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 

/**
* JAXB is picky about marshalling classes it hasn't heard of before. This solves
* the problem by including every single class in the JAXB context. You'll probably want to 
* cut and paste this elsewhere to get all the class names 
*/
public void marshallToXml(String filename)
{
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

      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(this, new FileOutputStream(filename));
    } // End try
    catch(Exception e) {System.out.println(e);
};
}


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(PduContainer rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (numberOfPdus == rhs.numberOfPdus)) ivarsEqual = false;

     for(int idx = 0; idx < pdus.size(); idx++)
     {
        Pdu x = (Pdu)pdus.get(idx);
        if( ! ( pdus.get(idx).equals(rhs.pdus.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
