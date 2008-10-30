package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.2.42. Basic operational data ofr IFF ATC NAVAIDS
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IffFundamentalData extends Object implements Serializable
{
   /** system status */
   protected short  systemStatus;

   /** Alternate parameter 4 */
   protected short  alternateParameter4;

   /** eight boolean fields */
   protected short  informationLayers;

   /** enumeration */
   protected short  modifier;

   /** parameter, enumeration */
   protected int  parameter1;

   /** parameter, enumeration */
   protected int  parameter2;

   /** parameter, enumeration */
   protected int  parameter3;

   /** parameter, enumeration */
   protected int  parameter4;

   /** parameter, enumeration */
   protected int  parameter5;

   /** parameter, enumeration */
   protected int  parameter6;


/** Constructor */
 public IffFundamentalData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // systemStatus
   marshalSize = marshalSize + 1;  // alternateParameter4
   marshalSize = marshalSize + 1;  // informationLayers
   marshalSize = marshalSize + 1;  // modifier
   marshalSize = marshalSize + 2;  // parameter1
   marshalSize = marshalSize + 2;  // parameter2
   marshalSize = marshalSize + 2;  // parameter3
   marshalSize = marshalSize + 2;  // parameter4
   marshalSize = marshalSize + 2;  // parameter5
   marshalSize = marshalSize + 2;  // parameter6

   return marshalSize;
}


public void setSystemStatus(short pSystemStatus)
{ systemStatus = pSystemStatus;
}

@XmlAttribute
public short getSystemStatus()
{ return systemStatus; 
}

public void setAlternateParameter4(short pAlternateParameter4)
{ alternateParameter4 = pAlternateParameter4;
}

@XmlAttribute
public short getAlternateParameter4()
{ return alternateParameter4; 
}

public void setInformationLayers(short pInformationLayers)
{ informationLayers = pInformationLayers;
}

@XmlAttribute
public short getInformationLayers()
{ return informationLayers; 
}

public void setModifier(short pModifier)
{ modifier = pModifier;
}

@XmlAttribute
public short getModifier()
{ return modifier; 
}

public void setParameter1(int pParameter1)
{ parameter1 = pParameter1;
}

@XmlAttribute
public int getParameter1()
{ return parameter1; 
}

public void setParameter2(int pParameter2)
{ parameter2 = pParameter2;
}

@XmlAttribute
public int getParameter2()
{ return parameter2; 
}

public void setParameter3(int pParameter3)
{ parameter3 = pParameter3;
}

@XmlAttribute
public int getParameter3()
{ return parameter3; 
}

public void setParameter4(int pParameter4)
{ parameter4 = pParameter4;
}

@XmlAttribute
public int getParameter4()
{ return parameter4; 
}

public void setParameter5(int pParameter5)
{ parameter5 = pParameter5;
}

@XmlAttribute
public int getParameter5()
{ return parameter5; 
}

public void setParameter6(int pParameter6)
{ parameter6 = pParameter6;
}

@XmlAttribute
public int getParameter6()
{ return parameter6; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)systemStatus);
       dos.writeByte( (byte)alternateParameter4);
       dos.writeByte( (byte)informationLayers);
       dos.writeByte( (byte)modifier);
       dos.writeShort( (short)parameter1);
       dos.writeShort( (short)parameter2);
       dos.writeShort( (short)parameter3);
       dos.writeShort( (short)parameter4);
       dos.writeShort( (short)parameter5);
       dos.writeShort( (short)parameter6);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       systemStatus = (short)dis.readUnsignedByte();
       alternateParameter4 = (short)dis.readUnsignedByte();
       informationLayers = (short)dis.readUnsignedByte();
       modifier = (short)dis.readUnsignedByte();
       parameter1 = (int)dis.readUnsignedShort();
       parameter2 = (int)dis.readUnsignedShort();
       parameter3 = (int)dis.readUnsignedShort();
       parameter4 = (int)dis.readUnsignedShort();
       parameter5 = (int)dis.readUnsignedShort();
       parameter6 = (int)dis.readUnsignedShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(IffFundamentalData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (systemStatus == rhs.systemStatus)) ivarsEqual = false;
     if( ! (alternateParameter4 == rhs.alternateParameter4)) ivarsEqual = false;
     if( ! (informationLayers == rhs.informationLayers)) ivarsEqual = false;
     if( ! (modifier == rhs.modifier)) ivarsEqual = false;
     if( ! (parameter1 == rhs.parameter1)) ivarsEqual = false;
     if( ! (parameter2 == rhs.parameter2)) ivarsEqual = false;
     if( ! (parameter3 == rhs.parameter3)) ivarsEqual = false;
     if( ! (parameter4 == rhs.parameter4)) ivarsEqual = false;
     if( ! (parameter5 == rhs.parameter5)) ivarsEqual = false;
     if( ! (parameter6 == rhs.parameter6)) ivarsEqual = false;

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
