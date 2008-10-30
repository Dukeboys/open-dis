package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Used in UA PDU
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class AcousticBeamData extends Object implements Serializable
{
   /** beam data length */
   protected int  beamDataLength;

   /** beamIDNumber */
   protected short  beamIDNumber;

   /** padding */
   protected int  pad2;

   /** fundamental data parameters */
   protected AcousticBeamFundamentalParameter  fundamentalDataParameters = new AcousticBeamFundamentalParameter(); 


/** Constructor */
 public AcousticBeamData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // beamDataLength
   marshalSize = marshalSize + 1;  // beamIDNumber
   marshalSize = marshalSize + 2;  // pad2
   marshalSize = marshalSize + fundamentalDataParameters.getMarshalledSize();  // fundamentalDataParameters

   return marshalSize;
}


public void setBeamDataLength(int pBeamDataLength)
{ beamDataLength = pBeamDataLength;
}

@XmlAttribute
public int getBeamDataLength()
{ return beamDataLength; 
}

public void setBeamIDNumber(short pBeamIDNumber)
{ beamIDNumber = pBeamIDNumber;
}

@XmlAttribute
public short getBeamIDNumber()
{ return beamIDNumber; 
}

public void setPad2(int pPad2)
{ pad2 = pPad2;
}

@XmlAttribute
public int getPad2()
{ return pad2; 
}

public void setFundamentalDataParameters(AcousticBeamFundamentalParameter pFundamentalDataParameters)
{ fundamentalDataParameters = pFundamentalDataParameters;
}

@XmlElement
public AcousticBeamFundamentalParameter getFundamentalDataParameters()
{ return fundamentalDataParameters; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)beamDataLength);
       dos.writeByte( (byte)beamIDNumber);
       dos.writeShort( (short)pad2);
       fundamentalDataParameters.marshal(dos);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       beamDataLength = (int)dis.readUnsignedShort();
       beamIDNumber = (short)dis.readUnsignedByte();
       pad2 = (int)dis.readUnsignedShort();
       fundamentalDataParameters.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(AcousticBeamData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (beamDataLength == rhs.beamDataLength)) ivarsEqual = false;
     if( ! (beamIDNumber == rhs.beamIDNumber)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (fundamentalDataParameters.equals( rhs.fundamentalDataParameters) )) ivarsEqual = false;

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
