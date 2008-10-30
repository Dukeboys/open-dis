package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.11. This field shall specify information about a particular emitter system
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class EmitterSystem extends Object implements Serializable
{
   /** Name of the emitter, 16 bit enumeration */
   protected int  emitterName;

   /** function of the emitter, 8 bit enumeration */
   protected short  function;

   /** emitter ID, 8 bit enumeration */
   protected short  emitterIdNumber;


/** Constructor */
 public EmitterSystem()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // emitterName
   marshalSize = marshalSize + 1;  // function
   marshalSize = marshalSize + 1;  // emitterIdNumber

   return marshalSize;
}


public void setEmitterName(int pEmitterName)
{ emitterName = pEmitterName;
}

@XmlAttribute
public int getEmitterName()
{ return emitterName; 
}

public void setFunction(short pFunction)
{ function = pFunction;
}

@XmlAttribute
public short getFunction()
{ return function; 
}

public void setEmitterIdNumber(short pEmitterIdNumber)
{ emitterIdNumber = pEmitterIdNumber;
}

@XmlAttribute
public short getEmitterIdNumber()
{ return emitterIdNumber; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)emitterName);
       dos.writeByte( (byte)function);
       dos.writeByte( (byte)emitterIdNumber);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       emitterName = (int)dis.readUnsignedShort();
       function = (short)dis.readUnsignedByte();
       emitterIdNumber = (short)dis.readUnsignedByte();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(EmitterSystem rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (emitterName == rhs.emitterName)) ivarsEqual = false;
     if( ! (function == rhs.function)) ivarsEqual = false;
     if( ! (emitterIdNumber == rhs.emitterIdNumber)) ivarsEqual = false;

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
