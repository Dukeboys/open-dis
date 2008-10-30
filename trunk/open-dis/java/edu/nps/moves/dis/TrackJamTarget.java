package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * One track/jam target
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class TrackJamTarget extends Object implements Serializable
{
   /** track/jam target */
   protected EntityID  trackJam = new EntityID(); 

   /** Emitter ID */
   protected short  emitterID;

   /** beam ID */
   protected short  beamID;


/** Constructor */
 public TrackJamTarget()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + trackJam.getMarshalledSize();  // trackJam
   marshalSize = marshalSize + 1;  // emitterID
   marshalSize = marshalSize + 1;  // beamID

   return marshalSize;
}


public void setTrackJam(EntityID pTrackJam)
{ trackJam = pTrackJam;
}

@XmlElement
public EntityID getTrackJam()
{ return trackJam; 
}

public void setEmitterID(short pEmitterID)
{ emitterID = pEmitterID;
}

@XmlAttribute
public short getEmitterID()
{ return emitterID; 
}

public void setBeamID(short pBeamID)
{ beamID = pBeamID;
}

@XmlAttribute
public short getBeamID()
{ return beamID; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       trackJam.marshal(dos);
       dos.writeByte( (byte)emitterID);
       dos.writeByte( (byte)beamID);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       trackJam.unmarshal(dis);
       emitterID = (short)dis.readUnsignedByte();
       beamID = (short)dis.readUnsignedByte();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(TrackJamTarget rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (trackJam.equals( rhs.trackJam) )) ivarsEqual = false;
     if( ! (emitterID == rhs.emitterID)) ivarsEqual = false;
     if( ! (beamID == rhs.beamID)) ivarsEqual = false;

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
