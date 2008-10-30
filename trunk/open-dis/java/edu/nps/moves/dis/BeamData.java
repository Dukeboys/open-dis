package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.39. Specification of the data necessary to  describe the scan volume of an emitter.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class BeamData extends Object implements Serializable
{
   /** Specifies the beam azimuth an elevation centers and corresponding half-angles     to describe the scan volume */
   protected float  beamAzimuthCenter;

   /** Specifies the beam azimuth sweep to determine scan volume */
   protected float  beamAzimuthSweep;

   /** Specifies the beam elevation center to determine scan volume */
   protected float  beamElevationCenter;

   /** Specifies the beam elevation sweep to determine scan volume */
   protected float  beamElevationSweep;

   /** allows receiver to synchronize its regenerated scan pattern to     that of the emmitter. Specifies the percentage of time a scan is through its pattern from its origion. */
   protected float  beamSweepSync;


/** Constructor */
 public BeamData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // beamAzimuthCenter
   marshalSize = marshalSize + 4;  // beamAzimuthSweep
   marshalSize = marshalSize + 4;  // beamElevationCenter
   marshalSize = marshalSize + 4;  // beamElevationSweep
   marshalSize = marshalSize + 4;  // beamSweepSync

   return marshalSize;
}


public void setBeamAzimuthCenter(float pBeamAzimuthCenter)
{ beamAzimuthCenter = pBeamAzimuthCenter;
}

@XmlAttribute
public float getBeamAzimuthCenter()
{ return beamAzimuthCenter; 
}

public void setBeamAzimuthSweep(float pBeamAzimuthSweep)
{ beamAzimuthSweep = pBeamAzimuthSweep;
}

@XmlAttribute
public float getBeamAzimuthSweep()
{ return beamAzimuthSweep; 
}

public void setBeamElevationCenter(float pBeamElevationCenter)
{ beamElevationCenter = pBeamElevationCenter;
}

@XmlAttribute
public float getBeamElevationCenter()
{ return beamElevationCenter; 
}

public void setBeamElevationSweep(float pBeamElevationSweep)
{ beamElevationSweep = pBeamElevationSweep;
}

@XmlAttribute
public float getBeamElevationSweep()
{ return beamElevationSweep; 
}

public void setBeamSweepSync(float pBeamSweepSync)
{ beamSweepSync = pBeamSweepSync;
}

@XmlAttribute
public float getBeamSweepSync()
{ return beamSweepSync; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)beamAzimuthCenter);
       dos.writeFloat( (float)beamAzimuthSweep);
       dos.writeFloat( (float)beamElevationCenter);
       dos.writeFloat( (float)beamElevationSweep);
       dos.writeFloat( (float)beamSweepSync);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       beamAzimuthCenter = dis.readFloat();
       beamAzimuthSweep = dis.readFloat();
       beamElevationCenter = dis.readFloat();
       beamElevationSweep = dis.readFloat();
       beamSweepSync = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(BeamData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (beamAzimuthCenter == rhs.beamAzimuthCenter)) ivarsEqual = false;
     if( ! (beamAzimuthSweep == rhs.beamAzimuthSweep)) ivarsEqual = false;
     if( ! (beamElevationCenter == rhs.beamElevationCenter)) ivarsEqual = false;
     if( ! (beamElevationSweep == rhs.beamElevationSweep)) ivarsEqual = false;
     if( ! (beamSweepSync == rhs.beamSweepSync)) ivarsEqual = false;

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
