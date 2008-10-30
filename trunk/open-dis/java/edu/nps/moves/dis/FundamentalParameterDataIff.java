package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.2.45. Fundamental IFF atc data
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class FundamentalParameterDataIff extends Object implements Serializable
{
   /** ERP */
   protected float  erp;

   /** frequency */
   protected float  frequency;

   /** pgrf */
   protected float  pgrf;

   /** Pulse width */
   protected float  pulseWidth;

   /** Burst length */
   protected long  burstLength;

   /** Applicable modes enumeration */
   protected short  applicableModes;

   /** padding */
   protected int  pad2;

   /** padding */
   protected short  pad3;


/** Constructor */
 public FundamentalParameterDataIff()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // erp
   marshalSize = marshalSize + 4;  // frequency
   marshalSize = marshalSize + 4;  // pgrf
   marshalSize = marshalSize + 4;  // pulseWidth
   marshalSize = marshalSize + 4;  // burstLength
   marshalSize = marshalSize + 1;  // applicableModes
   marshalSize = marshalSize + 2;  // pad2
   marshalSize = marshalSize + 1;  // pad3

   return marshalSize;
}


public void setErp(float pErp)
{ erp = pErp;
}

@XmlAttribute
public float getErp()
{ return erp; 
}

public void setFrequency(float pFrequency)
{ frequency = pFrequency;
}

@XmlAttribute
public float getFrequency()
{ return frequency; 
}

public void setPgrf(float pPgrf)
{ pgrf = pPgrf;
}

@XmlAttribute
public float getPgrf()
{ return pgrf; 
}

public void setPulseWidth(float pPulseWidth)
{ pulseWidth = pPulseWidth;
}

@XmlAttribute
public float getPulseWidth()
{ return pulseWidth; 
}

public void setBurstLength(long pBurstLength)
{ burstLength = pBurstLength;
}

@XmlAttribute
public long getBurstLength()
{ return burstLength; 
}

public void setApplicableModes(short pApplicableModes)
{ applicableModes = pApplicableModes;
}

@XmlAttribute
public short getApplicableModes()
{ return applicableModes; 
}

public void setPad2(int pPad2)
{ pad2 = pPad2;
}

@XmlAttribute
public int getPad2()
{ return pad2; 
}

public void setPad3(short pPad3)
{ pad3 = pPad3;
}

@XmlAttribute
public short getPad3()
{ return pad3; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)erp);
       dos.writeFloat( (float)frequency);
       dos.writeFloat( (float)pgrf);
       dos.writeFloat( (float)pulseWidth);
       dos.writeInt( (int)burstLength);
       dos.writeByte( (byte)applicableModes);
       dos.writeShort( (short)pad2);
       dos.writeByte( (byte)pad3);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       erp = dis.readFloat();
       frequency = dis.readFloat();
       pgrf = dis.readFloat();
       pulseWidth = dis.readFloat();
       burstLength = dis.readInt();
       applicableModes = (short)dis.readUnsignedByte();
       pad2 = (int)dis.readUnsignedShort();
       pad3 = (short)dis.readUnsignedByte();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(FundamentalParameterDataIff rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (erp == rhs.erp)) ivarsEqual = false;
     if( ! (frequency == rhs.frequency)) ivarsEqual = false;
     if( ! (pgrf == rhs.pgrf)) ivarsEqual = false;
     if( ! (pulseWidth == rhs.pulseWidth)) ivarsEqual = false;
     if( ! (burstLength == rhs.burstLength)) ivarsEqual = false;
     if( ! (applicableModes == rhs.applicableModes)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (pad3 == rhs.pad3)) ivarsEqual = false;

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
