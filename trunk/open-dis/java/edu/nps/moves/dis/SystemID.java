package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.2.58. Used in IFF ATC PDU
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class SystemID extends Object implements Serializable
{
   /** System Type */
   protected int  systemType;

   /** System name, an enumeration */
   protected int  systemName;

   /** System mode */
   protected short  systemMode;

   /** Change Options */
   protected short  changeOptions;


/** Constructor */
 public SystemID()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // systemType
   marshalSize = marshalSize + 2;  // systemName
   marshalSize = marshalSize + 1;  // systemMode
   marshalSize = marshalSize + 1;  // changeOptions

   return marshalSize;
}


public void setSystemType(int pSystemType)
{ systemType = pSystemType;
}

@XmlAttribute
public int getSystemType()
{ return systemType; 
}

public void setSystemName(int pSystemName)
{ systemName = pSystemName;
}

@XmlAttribute
public int getSystemName()
{ return systemName; 
}

public void setSystemMode(short pSystemMode)
{ systemMode = pSystemMode;
}

@XmlAttribute
public short getSystemMode()
{ return systemMode; 
}

public void setChangeOptions(short pChangeOptions)
{ changeOptions = pChangeOptions;
}

@XmlAttribute
public short getChangeOptions()
{ return changeOptions; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)systemType);
       dos.writeShort( (short)systemName);
       dos.writeByte( (byte)systemMode);
       dos.writeByte( (byte)changeOptions);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       systemType = (int)dis.readUnsignedShort();
       systemName = (int)dis.readUnsignedShort();
       systemMode = (short)dis.readUnsignedByte();
       changeOptions = (short)dis.readUnsignedByte();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(SystemID rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (systemType == rhs.systemType)) ivarsEqual = false;
     if( ! (systemName == rhs.systemName)) ivarsEqual = false;
     if( ! (systemMode == rhs.systemMode)) ivarsEqual = false;
     if( ! (changeOptions == rhs.changeOptions)) ivarsEqual = false;

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
