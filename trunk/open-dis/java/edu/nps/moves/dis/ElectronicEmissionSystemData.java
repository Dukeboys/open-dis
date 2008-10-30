package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Data about one electronic system
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ElectronicEmissionSystemData extends Object implements Serializable
{
   /** This field shall specify the length of this emitter system?s data (including beam data and its track/jam information) in 32-bit words. The length shall include the System Data Length field.  */
   protected short  systemDataLength;

   /** This field shall specify the number of beams being described in the current PDU for the system being described.  */
   protected short  numberOfBeams;

   /** padding. */
   protected int  emissionsPadding2 = 0;

   /** This field shall specify information about a particular emitter system */
   protected EmitterSystem  emitterSystem = new EmitterSystem(); 

   /** Location with respect to the entity */
   protected Vector3Float  location = new Vector3Float(); 

   /** variable length list of beam data records */
   protected List beamDataRecords = new ArrayList(); 

/** Constructor */
 public ElectronicEmissionSystemData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // systemDataLength
   marshalSize = marshalSize + 1;  // numberOfBeams
   marshalSize = marshalSize + 2;  // emissionsPadding2
   marshalSize = marshalSize + emitterSystem.getMarshalledSize();  // emitterSystem
   marshalSize = marshalSize + location.getMarshalledSize();  // location
   for(int idx=0; idx < beamDataRecords.size(); idx++)
   {
        ElectronicEmissionBeamData listElement = (ElectronicEmissionBeamData)beamDataRecords.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setSystemDataLength(short pSystemDataLength)
{ systemDataLength = pSystemDataLength;
}

@XmlAttribute
public short getSystemDataLength()
{ return systemDataLength; 
}

@XmlAttribute
public short getNumberOfBeams()
{ return (short)beamDataRecords.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfBeams method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfBeams(short pNumberOfBeams)
{ numberOfBeams = pNumberOfBeams;
}

public void setEmissionsPadding2(int pEmissionsPadding2)
{ emissionsPadding2 = pEmissionsPadding2;
}

@XmlAttribute
public int getEmissionsPadding2()
{ return emissionsPadding2; 
}

public void setEmitterSystem(EmitterSystem pEmitterSystem)
{ emitterSystem = pEmitterSystem;
}

@XmlElement
public EmitterSystem getEmitterSystem()
{ return emitterSystem; 
}

public void setLocation(Vector3Float pLocation)
{ location = pLocation;
}

@XmlElement
public Vector3Float getLocation()
{ return location; 
}

public void setBeamDataRecords(List pBeamDataRecords)
{ beamDataRecords = pBeamDataRecords;
}

@XmlElementWrapper(name="beamDataRecordsList" )
public List getBeamDataRecords()
{ return beamDataRecords; }


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)systemDataLength);
       dos.writeByte( (byte)beamDataRecords.size());
       dos.writeShort( (short)emissionsPadding2);
       emitterSystem.marshal(dos);
       location.marshal(dos);

       for(int idx = 0; idx < beamDataRecords.size(); idx++)
       {
            ElectronicEmissionBeamData aElectronicEmissionBeamData = (ElectronicEmissionBeamData)beamDataRecords.get(idx);
            aElectronicEmissionBeamData.marshal(dos);
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
       systemDataLength = (short)dis.readUnsignedByte();
       numberOfBeams = (short)dis.readUnsignedByte();
       emissionsPadding2 = (int)dis.readUnsignedShort();
       emitterSystem.unmarshal(dis);
       location.unmarshal(dis);
        for(int idx = 0; idx < numberOfBeams; idx++)
        {
           ElectronicEmissionBeamData anX = new ElectronicEmissionBeamData();
            anX.unmarshal(dis);
            beamDataRecords.add(anX);
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
 public boolean equals(ElectronicEmissionSystemData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (systemDataLength == rhs.systemDataLength)) ivarsEqual = false;
     if( ! (numberOfBeams == rhs.numberOfBeams)) ivarsEqual = false;
     if( ! (emissionsPadding2 == rhs.emissionsPadding2)) ivarsEqual = false;
     if( ! (emitterSystem.equals( rhs.emitterSystem) )) ivarsEqual = false;
     if( ! (location.equals( rhs.location) )) ivarsEqual = false;

     for(int idx = 0; idx < beamDataRecords.size(); idx++)
     {
        ElectronicEmissionBeamData x = (ElectronicEmissionBeamData)beamDataRecords.get(idx);
        if( ! ( beamDataRecords.get(idx).equals(rhs.beamDataRecords.get(idx)))) ivarsEqual = false;
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
