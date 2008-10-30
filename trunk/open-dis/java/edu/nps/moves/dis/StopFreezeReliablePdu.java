package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.12.4: Stop freeze simulation, relaible. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class StopFreezeReliablePdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** time in real world for this operation to happen */
   protected ClockTime  realWorldTime = new ClockTime(); 

   /** Reason for stopping/freezing simulation */
   protected short  reason;

   /** internal behvior of the simulation while frozen */
   protected short  frozenBehavior;

   /** reliablity level */
   protected short  requiredReliablityService;

   /** padding */
   protected short  pad1;

   /** Request ID */
   protected long  requestID;


/** Constructor */
 public StopFreezeReliablePdu()
 {
    setPduType( (short)54 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + realWorldTime.getMarshalledSize();  // realWorldTime
   marshalSize = marshalSize + 1;  // reason
   marshalSize = marshalSize + 1;  // frozenBehavior
   marshalSize = marshalSize + 1;  // requiredReliablityService
   marshalSize = marshalSize + 1;  // pad1
   marshalSize = marshalSize + 4;  // requestID

   return marshalSize;
}


public void setRealWorldTime(ClockTime pRealWorldTime)
{ realWorldTime = pRealWorldTime;
}

@XmlElement
public ClockTime getRealWorldTime()
{ return realWorldTime; 
}

public void setReason(short pReason)
{ reason = pReason;
}

@XmlAttribute
public short getReason()
{ return reason; 
}

public void setFrozenBehavior(short pFrozenBehavior)
{ frozenBehavior = pFrozenBehavior;
}

@XmlAttribute
public short getFrozenBehavior()
{ return frozenBehavior; 
}

public void setRequiredReliablityService(short pRequiredReliablityService)
{ requiredReliablityService = pRequiredReliablityService;
}

@XmlAttribute
public short getRequiredReliablityService()
{ return requiredReliablityService; 
}

public void setPad1(short pPad1)
{ pad1 = pPad1;
}

@XmlAttribute
public short getPad1()
{ return pad1; 
}

public void setRequestID(long pRequestID)
{ requestID = pRequestID;
}

@XmlAttribute
public long getRequestID()
{ return requestID; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       realWorldTime.marshal(dos);
       dos.writeByte( (byte)reason);
       dos.writeByte( (byte)frozenBehavior);
       dos.writeByte( (byte)requiredReliablityService);
       dos.writeByte( (byte)pad1);
       dos.writeInt( (int)requestID);
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
       realWorldTime.unmarshal(dis);
       reason = (short)dis.readUnsignedByte();
       frozenBehavior = (short)dis.readUnsignedByte();
       requiredReliablityService = (short)dis.readUnsignedByte();
       pad1 = (short)dis.readUnsignedByte();
       requestID = dis.readInt();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(StopFreezeReliablePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (realWorldTime.equals( rhs.realWorldTime) )) ivarsEqual = false;
     if( ! (reason == rhs.reason)) ivarsEqual = false;
     if( ! (frozenBehavior == rhs.frozenBehavior)) ivarsEqual = false;
     if( ! (requiredReliablityService == rhs.requiredReliablityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;

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
