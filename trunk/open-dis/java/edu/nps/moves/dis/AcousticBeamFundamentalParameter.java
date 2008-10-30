package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Used in UaPdu
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class AcousticBeamFundamentalParameter extends Object implements Serializable
{
   /** parameter index */
   protected int  activeEmissionParameterIndex;

   /** scan pattern */
   protected int  scanPattern;

   /** beam center azimuth */
   protected float  beamCenterAzimuth;

   /** azimuthal beamwidth */
   protected float  azimuthalBeamwidth;

   /** beam center */
   protected float  beamCenterDE;

   /** DE beamwidth (vertical beamwidth) */
   protected float  deBeamwidth;


/** Constructor */
 public AcousticBeamFundamentalParameter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // activeEmissionParameterIndex
   marshalSize = marshalSize + 2;  // scanPattern
   marshalSize = marshalSize + 4;  // beamCenterAzimuth
   marshalSize = marshalSize + 4;  // azimuthalBeamwidth
   marshalSize = marshalSize + 4;  // beamCenterDE
   marshalSize = marshalSize + 4;  // deBeamwidth

   return marshalSize;
}


public void setActiveEmissionParameterIndex(int pActiveEmissionParameterIndex)
{ activeEmissionParameterIndex = pActiveEmissionParameterIndex;
}

@XmlAttribute
public int getActiveEmissionParameterIndex()
{ return activeEmissionParameterIndex; 
}

public void setScanPattern(int pScanPattern)
{ scanPattern = pScanPattern;
}

@XmlAttribute
public int getScanPattern()
{ return scanPattern; 
}

public void setBeamCenterAzimuth(float pBeamCenterAzimuth)
{ beamCenterAzimuth = pBeamCenterAzimuth;
}

@XmlAttribute
public float getBeamCenterAzimuth()
{ return beamCenterAzimuth; 
}

public void setAzimuthalBeamwidth(float pAzimuthalBeamwidth)
{ azimuthalBeamwidth = pAzimuthalBeamwidth;
}

@XmlAttribute
public float getAzimuthalBeamwidth()
{ return azimuthalBeamwidth; 
}

public void setBeamCenterDE(float pBeamCenterDE)
{ beamCenterDE = pBeamCenterDE;
}

@XmlAttribute
public float getBeamCenterDE()
{ return beamCenterDE; 
}

public void setDeBeamwidth(float pDeBeamwidth)
{ deBeamwidth = pDeBeamwidth;
}

@XmlAttribute
public float getDeBeamwidth()
{ return deBeamwidth; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)activeEmissionParameterIndex);
       dos.writeShort( (short)scanPattern);
       dos.writeFloat( (float)beamCenterAzimuth);
       dos.writeFloat( (float)azimuthalBeamwidth);
       dos.writeFloat( (float)beamCenterDE);
       dos.writeFloat( (float)deBeamwidth);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       activeEmissionParameterIndex = (int)dis.readUnsignedShort();
       scanPattern = (int)dis.readUnsignedShort();
       beamCenterAzimuth = dis.readFloat();
       azimuthalBeamwidth = dis.readFloat();
       beamCenterDE = dis.readFloat();
       deBeamwidth = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(AcousticBeamFundamentalParameter rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (activeEmissionParameterIndex == rhs.activeEmissionParameterIndex)) ivarsEqual = false;
     if( ! (scanPattern == rhs.scanPattern)) ivarsEqual = false;
     if( ! (beamCenterAzimuth == rhs.beamCenterAzimuth)) ivarsEqual = false;
     if( ! (azimuthalBeamwidth == rhs.azimuthalBeamwidth)) ivarsEqual = false;
     if( ! (beamCenterDE == rhs.beamCenterDE)) ivarsEqual = false;
     if( ! (deBeamwidth == rhs.deBeamwidth)) ivarsEqual = false;

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
