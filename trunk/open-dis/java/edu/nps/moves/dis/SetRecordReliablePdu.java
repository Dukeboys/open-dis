package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.12.14: Initializing or changing internal parameter info. Needs manual intervention     to fix padding in recrod set PDUs. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class SetRecordReliablePdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** request ID */
   protected long  requestID;

   /** level of reliability service used for this transaction */
   protected short  requiredReliabilityService;

   /** padding. The spec is unclear and contradictory here. */
   protected int  pad1;

   /** padding */
   protected short  pad2;

   /** Number of record sets in list */
   protected long  numberOfRecordSets;

   /** record sets */
   protected List recordSets = new ArrayList(); 

/** Constructor */
 public SetRecordReliablePdu()
 {
    setPduType( (short)64 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + 4;  // requestID
   marshalSize = marshalSize + 1;  // requiredReliabilityService
   marshalSize = marshalSize + 2;  // pad1
   marshalSize = marshalSize + 1;  // pad2
   marshalSize = marshalSize + 4;  // numberOfRecordSets
   for(int idx=0; idx < recordSets.size(); idx++)
   {
        RecordSet listElement = (RecordSet)recordSets.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setRequestID(long pRequestID)
{ requestID = pRequestID;
}

@XmlAttribute
public long getRequestID()
{ return requestID; 
}

public void setRequiredReliabilityService(short pRequiredReliabilityService)
{ requiredReliabilityService = pRequiredReliabilityService;
}

@XmlAttribute
public short getRequiredReliabilityService()
{ return requiredReliabilityService; 
}

public void setPad1(int pPad1)
{ pad1 = pPad1;
}

@XmlAttribute
public int getPad1()
{ return pad1; 
}

public void setPad2(short pPad2)
{ pad2 = pPad2;
}

@XmlAttribute
public short getPad2()
{ return pad2; 
}

@XmlAttribute
public long getNumberOfRecordSets()
{ return (long)recordSets.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfRecordSets method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfRecordSets(long pNumberOfRecordSets)
{ numberOfRecordSets = pNumberOfRecordSets;
}

public void setRecordSets(List pRecordSets)
{ recordSets = pRecordSets;
}

@XmlElementWrapper(name="recordSetsList" )
public List getRecordSets()
{ return recordSets; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       dos.writeInt( (int)requestID);
       dos.writeByte( (byte)requiredReliabilityService);
       dos.writeShort( (short)pad1);
       dos.writeByte( (byte)pad2);
       dos.writeInt( (int)recordSets.size());

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
       requestID = dis.readInt();
       requiredReliabilityService = (short)dis.readUnsignedByte();
       pad1 = (int)dis.readUnsignedShort();
       pad2 = (short)dis.readUnsignedByte();
       numberOfRecordSets = dis.readInt();
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
 public boolean equals(SetRecordReliablePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (numberOfRecordSets == rhs.numberOfRecordSets)) ivarsEqual = false;

     for(int idx = 0; idx < recordSets.size(); idx++)
     {
        RecordSet x = (RecordSet)recordSets.get(idx);
        if( ! ( recordSets.get(idx).equals(rhs.recordSets.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
// Copyright (c) 1995-2009 held by the author(s).  All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
//  are met:
// 
//  * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
// * Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer
// in the documentation and/or other materials provided with the
// distribution.
// * Neither the names of the Naval Postgraduate School (NPS)
//  Modeling Virtual Environments and Simulation (MOVES) Institute
// (http://www.nps.edu and http://www.MovesInstitute.org)
// nor the names of its contributors may be used to endorse or
//  promote products derived from this software without specific
// prior written permission.
// 
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// AS IS AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
// BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
// LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
// LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
// ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.
