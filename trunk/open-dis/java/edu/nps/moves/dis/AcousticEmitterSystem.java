package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.3.35: Information about a particular UA emitter shall be represented using an Acoustic Emitter System record. This record shall consist of three fields: Acoustic Name, Function, and Acoustic ID Number
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class AcousticEmitterSystem extends Object implements Serializable
{
   /** This field shall specify the system for a particular UA emitter. */
   protected int  acousticName;

   /** This field shall describe the function of the acoustic system.  */
   protected short  acousticFunction;

   /** This field shall specify the UA emitter identification number relative to a specific system. This field shall be represented by an 8-bit unsigned integer. This field allows the differentiation of multiple systems on an entity, even if in some instances two or more of the systems may be identical UA emitter types. Numbering of systems shall begin with the value 1.  */
   protected short  acousticID;


/** Constructor */
 public AcousticEmitterSystem()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // acousticName
   marshalSize = marshalSize + 1;  // acousticFunction
   marshalSize = marshalSize + 1;  // acousticID

   return marshalSize;
}


public void setAcousticName(int pAcousticName)
{ acousticName = pAcousticName;
}

@XmlAttribute
public int getAcousticName()
{ return acousticName; 
}

public void setAcousticFunction(short pAcousticFunction)
{ acousticFunction = pAcousticFunction;
}

@XmlAttribute
public short getAcousticFunction()
{ return acousticFunction; 
}

public void setAcousticID(short pAcousticID)
{ acousticID = pAcousticID;
}

@XmlAttribute
public short getAcousticID()
{ return acousticID; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)acousticName);
       dos.writeByte( (byte)acousticFunction);
       dos.writeByte( (byte)acousticID);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       acousticName = (int)dis.readUnsignedShort();
       acousticFunction = (short)dis.readUnsignedByte();
       acousticID = (short)dis.readUnsignedByte();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(AcousticEmitterSystem rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (acousticName == rhs.acousticName)) ivarsEqual = false;
     if( ! (acousticFunction == rhs.acousticFunction)) ivarsEqual = false;
     if( ! (acousticID == rhs.acousticID)) ivarsEqual = false;

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
