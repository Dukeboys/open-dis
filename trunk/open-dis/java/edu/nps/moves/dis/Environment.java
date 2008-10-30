package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.40. Information about a geometry, a state associated with a geometry, a bounding volume, or an associated entity ID. NOTE: this class requires hand coding.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class Environment extends Object implements Serializable
{
   /** Record type */
   protected long  environmentType;

   /** length, in bits */
   protected short  length;

   /** Identify the sequentially numbered record index */
   protected short  index;

   /** padding */
   protected short  padding1;

   /** Geometry or state record */
   protected short  geometry;

   /** padding to bring the total size up to a 64 bit boundry */
   protected short  padding2;


/** Constructor */
 public Environment()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // environmentType
   marshalSize = marshalSize + 1;  // length
   marshalSize = marshalSize + 1;  // index
   marshalSize = marshalSize + 1;  // padding1
   marshalSize = marshalSize + 1;  // geometry
   marshalSize = marshalSize + 1;  // padding2

   return marshalSize;
}


public void setEnvironmentType(long pEnvironmentType)
{ environmentType = pEnvironmentType;
}

@XmlAttribute
public long getEnvironmentType()
{ return environmentType; 
}

public void setLength(short pLength)
{ length = pLength;
}

@XmlAttribute
public short getLength()
{ return length; 
}

public void setIndex(short pIndex)
{ index = pIndex;
}

@XmlAttribute
public short getIndex()
{ return index; 
}

public void setPadding1(short pPadding1)
{ padding1 = pPadding1;
}

@XmlAttribute
public short getPadding1()
{ return padding1; 
}

public void setGeometry(short pGeometry)
{ geometry = pGeometry;
}

@XmlAttribute
public short getGeometry()
{ return geometry; 
}

public void setPadding2(short pPadding2)
{ padding2 = pPadding2;
}

@XmlAttribute
public short getPadding2()
{ return padding2; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeInt( (int)environmentType);
       dos.writeByte( (byte)length);
       dos.writeByte( (byte)index);
       dos.writeByte( (byte)padding1);
       dos.writeByte( (byte)geometry);
       dos.writeByte( (byte)padding2);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       environmentType = dis.readInt();
       length = (short)dis.readUnsignedByte();
       index = (short)dis.readUnsignedByte();
       padding1 = (short)dis.readUnsignedByte();
       geometry = (short)dis.readUnsignedByte();
       padding2 = (short)dis.readUnsignedByte();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(Environment rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (environmentType == rhs.environmentType)) ivarsEqual = false;
     if( ! (length == rhs.length)) ivarsEqual = false;
     if( ! (index == rhs.index)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (geometry == rhs.geometry)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;

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
