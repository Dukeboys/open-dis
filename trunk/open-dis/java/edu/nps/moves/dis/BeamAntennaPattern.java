package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.4.2. Used when the antenna pattern type field has a value of 1. Specifies           the direction, patter, and polarization of radiation from an antenna.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class BeamAntennaPattern extends Object implements Serializable
{
   /** The rotation that transformst he reference coordinate sytem     into the beam coordinate system. Either world coordinates or entity coordinates may be used as the     reference coordinate system, as specified by teh reference system field of the antenna pattern record. */
   protected Orientation  beamDirection = new Orientation(); 

   protected float  azimuthBeamwidth = 0;

   protected float  referenceSystem = 0;

   protected short  padding1 = 0;

   protected byte  padding2 = 0;

   /** Magnigute of the z-component in beam coordinates at some arbitrary      single point in the mainbeam      and in the far field of the antenna. */
   protected float  ez;

   /** Magnigute of the x-component in beam coordinates at some arbitrary      single point in the mainbeam      and in the far field of the antenna. */
   protected float  ex;

   /** THe phase angle between Ez and Ex in radians. */
   protected float  phase;


/** Constructor */
 public BeamAntennaPattern()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + beamDirection.getMarshalledSize();  // beamDirection
   marshalSize = marshalSize + 4;  // azimuthBeamwidth
   marshalSize = marshalSize + 4;  // referenceSystem
   marshalSize = marshalSize + 2;  // padding1
   marshalSize = marshalSize + 1;  // padding2
   marshalSize = marshalSize + 4;  // ez
   marshalSize = marshalSize + 4;  // ex
   marshalSize = marshalSize + 4;  // phase

   return marshalSize;
}


public void setBeamDirection(Orientation pBeamDirection)
{ beamDirection = pBeamDirection;
}

@XmlElement
public Orientation getBeamDirection()
{ return beamDirection; 
}

public void setAzimuthBeamwidth(float pAzimuthBeamwidth)
{ azimuthBeamwidth = pAzimuthBeamwidth;
}

@XmlAttribute
public float getAzimuthBeamwidth()
{ return azimuthBeamwidth; 
}

public void setReferenceSystem(float pReferenceSystem)
{ referenceSystem = pReferenceSystem;
}

@XmlAttribute
public float getReferenceSystem()
{ return referenceSystem; 
}

public void setPadding1(short pPadding1)
{ padding1 = pPadding1;
}

@XmlAttribute
public short getPadding1()
{ return padding1; 
}

public void setPadding2(byte pPadding2)
{ padding2 = pPadding2;
}

@XmlAttribute
public byte getPadding2()
{ return padding2; 
}

public void setEz(float pEz)
{ ez = pEz;
}

@XmlAttribute
public float getEz()
{ return ez; 
}

public void setEx(float pEx)
{ ex = pEx;
}

@XmlAttribute
public float getEx()
{ return ex; 
}

public void setPhase(float pPhase)
{ phase = pPhase;
}

@XmlAttribute
public float getPhase()
{ return phase; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       beamDirection.marshal(dos);
       dos.writeFloat( (float)azimuthBeamwidth);
       dos.writeFloat( (float)referenceSystem);
       dos.writeShort( (short)padding1);
       dos.writeByte( (byte)padding2);
       dos.writeFloat( (float)ez);
       dos.writeFloat( (float)ex);
       dos.writeFloat( (float)phase);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       beamDirection.unmarshal(dis);
       azimuthBeamwidth = dis.readFloat();
       referenceSystem = dis.readFloat();
       padding1 = dis.readShort();
       padding2 = dis.readByte();
       ez = dis.readFloat();
       ex = dis.readFloat();
       phase = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(BeamAntennaPattern rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (beamDirection.equals( rhs.beamDirection) )) ivarsEqual = false;
     if( ! (azimuthBeamwidth == rhs.azimuthBeamwidth)) ivarsEqual = false;
     if( ! (referenceSystem == rhs.referenceSystem)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (ez == rhs.ez)) ivarsEqual = false;
     if( ! (ex == rhs.ex)) ivarsEqual = false;
     if( ! (phase == rhs.phase)) ivarsEqual = false;

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
