package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.2.46.  Intercom communcations parameters
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IntercomCommunicationsParameters extends Object implements Serializable
{
   /** Type of intercom parameters record */
   protected int  recordType;

   /** length of record */
   protected int  recordLength;

   /** Jerks. Looks like the committee is forcing a lookup of the record type parameter to find out how long the field is. This is a placeholder. */
   protected long  recordSpecificField;


/** Constructor */
 public IntercomCommunicationsParameters()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // recordType
   marshalSize = marshalSize + 2;  // recordLength
   marshalSize = marshalSize + 4;  // recordSpecificField

   return marshalSize;
}


public void setRecordType(int pRecordType)
{ recordType = pRecordType;
}

@XmlAttribute
public int getRecordType()
{ return recordType; 
}

public void setRecordLength(int pRecordLength)
{ recordLength = pRecordLength;
}

@XmlAttribute
public int getRecordLength()
{ return recordLength; 
}

public void setRecordSpecificField(long pRecordSpecificField)
{ recordSpecificField = pRecordSpecificField;
}

@XmlAttribute
public long getRecordSpecificField()
{ return recordSpecificField; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)recordType);
       dos.writeShort( (short)recordLength);
       dos.writeInt( (int)recordSpecificField);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       recordType = (int)dis.readUnsignedShort();
       recordLength = (int)dis.readUnsignedShort();
       recordSpecificField = dis.readInt();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(IntercomCommunicationsParameters rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (recordSpecificField == rhs.recordSpecificField)) ivarsEqual = false;

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
