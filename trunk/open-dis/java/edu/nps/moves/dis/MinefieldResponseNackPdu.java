package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.10.4 proivde the means to request a retransmit of a minefield data pdu. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class MinefieldResponseNackPdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected EntityID  minefieldID = new EntityID(); 

   /** entity ID making the request */
   protected EntityID  requestingEntityID = new EntityID(); 

   /** request ID */
   protected short  requestID;

   /** how many pdus were missing */
   protected short  numberOfMissingPdus;

   /** PDU sequence numbers that were missing */
   protected List missingPduSequenceNumbers = new ArrayList(); 

/** Constructor */
 public MinefieldResponseNackPdu()
 {
    setPduType( (short)40 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + minefieldID.getMarshalledSize();  // minefieldID
   marshalSize = marshalSize + requestingEntityID.getMarshalledSize();  // requestingEntityID
   marshalSize = marshalSize + 1;  // requestID
   marshalSize = marshalSize + 1;  // numberOfMissingPdus
   for(int idx=0; idx < missingPduSequenceNumbers.size(); idx++)
   {
        EightByteChunk listElement = (EightByteChunk)missingPduSequenceNumbers.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setMinefieldID(EntityID pMinefieldID)
{ minefieldID = pMinefieldID;
}

@XmlElement
public EntityID getMinefieldID()
{ return minefieldID; 
}

public void setRequestingEntityID(EntityID pRequestingEntityID)
{ requestingEntityID = pRequestingEntityID;
}

@XmlElement
public EntityID getRequestingEntityID()
{ return requestingEntityID; 
}

public void setRequestID(short pRequestID)
{ requestID = pRequestID;
}

@XmlAttribute
public short getRequestID()
{ return requestID; 
}

@XmlAttribute
public short getNumberOfMissingPdus()
{ return (short)missingPduSequenceNumbers.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfMissingPdus method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfMissingPdus(short pNumberOfMissingPdus)
{ numberOfMissingPdus = pNumberOfMissingPdus;
}

public void setMissingPduSequenceNumbers(List pMissingPduSequenceNumbers)
{ missingPduSequenceNumbers = pMissingPduSequenceNumbers;
}

@XmlElementWrapper(name="missingPduSequenceNumbersList" )
public List getMissingPduSequenceNumbers()
{ return missingPduSequenceNumbers; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeByte( (byte)requestID);
       dos.writeByte( (byte)missingPduSequenceNumbers.size());

       for(int idx = 0; idx < missingPduSequenceNumbers.size(); idx++)
       {
            EightByteChunk aEightByteChunk = (EightByteChunk)missingPduSequenceNumbers.get(idx);
            aEightByteChunk.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    super.unmarshal(dis);

    try 
    {
       minefieldID.unmarshal(dis);
       requestingEntityID.unmarshal(dis);
       requestID = (short)dis.readUnsignedByte();
       numberOfMissingPdus = (short)dis.readUnsignedByte();
        for(int idx = 0; idx < numberOfMissingPdus; idx++)
        {
           EightByteChunk anX = new EightByteChunk();
            anX.unmarshal(dis);
            missingPduSequenceNumbers.add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(MinefieldResponseNackPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (numberOfMissingPdus == rhs.numberOfMissingPdus)) ivarsEqual = false;

     for(int idx = 0; idx < missingPduSequenceNumbers.size(); idx++)
     {
        EightByteChunk x = (EightByteChunk)missingPduSequenceNumbers.get(idx);
        if( ! ( missingPduSequenceNumbers.get(idx).equals(rhs.missingPduSequenceNumbers.get(idx)))) ivarsEqual = false;
     }


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
