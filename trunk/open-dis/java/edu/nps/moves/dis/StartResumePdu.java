package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.6.3. Start or resume an exercise. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class StartResumePdu extends SimulationManagementFamilyPdu implements Serializable
{
   /** UTC time at which the simulation shall start or resume */
   protected ClockTime  realWorldTime = new ClockTime(); 

   /** Simulation clock time at which the simulation shall start or resume */
   protected ClockTime  simulationTime = new ClockTime(); 

   /** Identifier for the request */
   protected long  requestID;


/** Constructor */
 public StartResumePdu()
 {
    setPduType( (short)13 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + realWorldTime.getMarshalledSize();  // realWorldTime
   marshalSize = marshalSize + simulationTime.getMarshalledSize();  // simulationTime
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

public void setSimulationTime(ClockTime pSimulationTime)
{ simulationTime = pSimulationTime;
}

@XmlElement
public ClockTime getSimulationTime()
{ return simulationTime; 
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
       simulationTime.marshal(dos);
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
       simulationTime.unmarshal(dis);
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
 public boolean equals(StartResumePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (realWorldTime.equals( rhs.realWorldTime) )) ivarsEqual = false;
     if( ! (simulationTime.equals( rhs.simulationTime) )) ivarsEqual = false;
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
