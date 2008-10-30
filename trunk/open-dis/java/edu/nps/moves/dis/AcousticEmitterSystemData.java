package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Used in the UA pdu; ties together an emmitter and a location. This requires manual cleanup; the beam data should not be attached to each emitter system.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class AcousticEmitterSystemData extends Object implements Serializable
{
   /** Length of emitter system data */
   protected short  emitterSystemDataLength;

   /** Number of beams */
   protected short  numberOfBeams;

   /** padding */
   protected int  pad2;

   /** This field shall specify the system for a particular UA emitter. */
   protected AcousticEmitterSystem  acousticEmitterSystem = new AcousticEmitterSystem(); 

   /** Represents the location wrt the entity */
   protected Vector3Float  emitterLocation = new Vector3Float(); 

   /** For each beam in numberOfBeams, an emitter system. This is not right--the beam records need to be at the end of the PDU, rather than attached to each system. */
   protected List beamRecords = new ArrayList(); 

/** Constructor */
 public AcousticEmitterSystemData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // emitterSystemDataLength
   marshalSize = marshalSize + 1;  // numberOfBeams
   marshalSize = marshalSize + 2;  // pad2
   marshalSize = marshalSize + acousticEmitterSystem.getMarshalledSize();  // acousticEmitterSystem
   marshalSize = marshalSize + emitterLocation.getMarshalledSize();  // emitterLocation
   for(int idx=0; idx < beamRecords.size(); idx++)
   {
        AcousticBeamData listElement = (AcousticBeamData)beamRecords.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEmitterSystemDataLength(short pEmitterSystemDataLength)
{ emitterSystemDataLength = pEmitterSystemDataLength;
}

@XmlAttribute
public short getEmitterSystemDataLength()
{ return emitterSystemDataLength; 
}

@XmlAttribute
public short getNumberOfBeams()
{ return (short)beamRecords.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfBeams method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfBeams(short pNumberOfBeams)
{ numberOfBeams = pNumberOfBeams;
}

public void setPad2(int pPad2)
{ pad2 = pPad2;
}

@XmlAttribute
public int getPad2()
{ return pad2; 
}

public void setAcousticEmitterSystem(AcousticEmitterSystem pAcousticEmitterSystem)
{ acousticEmitterSystem = pAcousticEmitterSystem;
}

@XmlElement
public AcousticEmitterSystem getAcousticEmitterSystem()
{ return acousticEmitterSystem; 
}

public void setEmitterLocation(Vector3Float pEmitterLocation)
{ emitterLocation = pEmitterLocation;
}

@XmlElement
public Vector3Float getEmitterLocation()
{ return emitterLocation; 
}

public void setBeamRecords(List pBeamRecords)
{ beamRecords = pBeamRecords;
}

@XmlElementWrapper(name="beamRecordsList" )
public List getBeamRecords()
{ return beamRecords; }


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)emitterSystemDataLength);
       dos.writeByte( (byte)beamRecords.size());
       dos.writeShort( (short)pad2);
       acousticEmitterSystem.marshal(dos);
       emitterLocation.marshal(dos);

       for(int idx = 0; idx < beamRecords.size(); idx++)
       {
            AcousticBeamData aAcousticBeamData = (AcousticBeamData)beamRecords.get(idx);
            aAcousticBeamData.marshal(dos);
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
       emitterSystemDataLength = (short)dis.readUnsignedByte();
       numberOfBeams = (short)dis.readUnsignedByte();
       pad2 = (int)dis.readUnsignedShort();
       acousticEmitterSystem.unmarshal(dis);
       emitterLocation.unmarshal(dis);
        for(int idx = 0; idx < numberOfBeams; idx++)
        {
           AcousticBeamData anX = new AcousticBeamData();
            anX.unmarshal(dis);
            beamRecords.add(anX);
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
 public boolean equals(AcousticEmitterSystemData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (emitterSystemDataLength == rhs.emitterSystemDataLength)) ivarsEqual = false;
     if( ! (numberOfBeams == rhs.numberOfBeams)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (acousticEmitterSystem.equals( rhs.acousticEmitterSystem) )) ivarsEqual = false;
     if( ! (emitterLocation.equals( rhs.emitterLocation) )) ivarsEqual = false;

     for(int idx = 0; idx < beamRecords.size(); idx++)
     {
        AcousticBeamData x = (AcousticBeamData)beamRecords.get(idx);
        if( ! ( beamRecords.get(idx).equals(rhs.beamRecords.get(idx)))) ivarsEqual = false;
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
