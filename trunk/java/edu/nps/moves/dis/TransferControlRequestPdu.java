package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * Section 5.3.9.3 Information initiating the dyanic allocation and control of simulation entities         between two simulation applications. Requires manual cleanup. The padding between record sets is variable. UNFINISHED
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class TransferControlRequestPdu extends EntityManagementFamilyPdu
{
   /** ID of entity originating request */
   protected EntityID  orginatingEntityID = new EntityID(); 

   /** ID of entity receiving request */
   protected EntityID  recevingEntityID = new EntityID(); 

   /** ID ofrequest */
   protected long  requestID;

   /** required level of reliabliity service. */
   protected short  requiredReliabilityService;

   /** type of transfer desired */
   protected short  tranferType;

   /** The entity for which control is being requested to transfer */
   protected EntityID  transferEntityID = new EntityID(); 

   /** number of record sets to transfer */
   protected short  numberOfRecordSets;

   /** @@@This is wrong--the RecordSet class needs more work */
   protected List recordSets = new ArrayList(); 

/** Constructor */
 public TransferControlRequestPdu()
 {
    setPduType( (short)35 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + orginatingEntityID.getMarshalledSize();  // orginatingEntityID
   marshalSize = marshalSize + recevingEntityID.getMarshalledSize();  // recevingEntityID
   marshalSize = marshalSize + 4;  // requestID
   marshalSize = marshalSize + 1;  // requiredReliabilityService
   marshalSize = marshalSize + 1;  // tranferType
   marshalSize = marshalSize + transferEntityID.getMarshalledSize();  // transferEntityID
   marshalSize = marshalSize + 1;  // numberOfRecordSets
   for(int idx=0; idx < recordSets.size(); idx++)
   {
        RecordSet listElement = (RecordSet)recordSets.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setOrginatingEntityID(EntityID pOrginatingEntityID)
{ orginatingEntityID = pOrginatingEntityID;
}

public EntityID getOrginatingEntityID()
{ return orginatingEntityID; }

public void setRecevingEntityID(EntityID pRecevingEntityID)
{ recevingEntityID = pRecevingEntityID;
}

public EntityID getRecevingEntityID()
{ return recevingEntityID; }

public void setRequestID(long pRequestID)
{ requestID = pRequestID;
}

public long getRequestID()
{ return requestID; 
}

public void setRequiredReliabilityService(short pRequiredReliabilityService)
{ requiredReliabilityService = pRequiredReliabilityService;
}

public short getRequiredReliabilityService()
{ return requiredReliabilityService; 
}

public void setTranferType(short pTranferType)
{ tranferType = pTranferType;
}

public short getTranferType()
{ return tranferType; 
}

public void setTransferEntityID(EntityID pTransferEntityID)
{ transferEntityID = pTransferEntityID;
}

public EntityID getTransferEntityID()
{ return transferEntityID; }

public short getNumberOfRecordSets()
{ return (short)recordSets.size();
}

public void setRecordSets(List pRecordSets)
{ recordSets = pRecordSets;
}

public List getRecordSets()
{ return recordSets; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       orginatingEntityID.marshal(dos);
       recevingEntityID.marshal(dos);
       dos.writeInt( (int)requestID);
       dos.writeByte( (byte)requiredReliabilityService);
       dos.writeByte( (byte)tranferType);
       transferEntityID.marshal(dos);
       dos.writeByte( (byte)recordSets.size());

       for(int idx = 0; idx < recordSets.size(); idx++)
       {
            RecordSet aRecordSet = (RecordSet)recordSets.get(idx);
            aRecordSet.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    super.unmarshal(dis);

    try 
    {
       orginatingEntityID.unmarshal(dis);
       recevingEntityID.unmarshal(dis);
       requestID = dis.readInt();
       requiredReliabilityService = dis.readByte();
       tranferType = dis.readByte();
       transferEntityID.unmarshal(dis);
       numberOfRecordSets = dis.readByte();
        for(int idx = 0; idx < numberOfRecordSets; idx++)
        {
           RecordSet anX = new RecordSet();
            anX.unmarshal(dis);
            recordSets.add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(TransferControlRequestPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (orginatingEntityID.equals( rhs.orginatingEntityID) )) ivarsEqual = false;
     if( ! (recevingEntityID.equals( rhs.recevingEntityID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (tranferType == rhs.tranferType)) ivarsEqual = false;
     if( ! (transferEntityID.equals( rhs.transferEntityID) )) ivarsEqual = false;
     if( ! (numberOfRecordSets == rhs.numberOfRecordSets)) ivarsEqual = false;

     for(int idx = 0; idx < recordSets.size(); idx++)
     {
        RecordSet x = (RecordSet)recordSets.get(idx);
        if( ! ( recordSets.get(idx).equals(rhs.recordSets.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
