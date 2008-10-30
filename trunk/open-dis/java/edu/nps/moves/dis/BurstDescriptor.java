package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.7. Specifies the type of muntion fired, the type of warhead, the         type of fuse, the number of rounds fired, and the rate at which the roudns are fired in         rounds per minute.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class BurstDescriptor extends Object implements Serializable
{
   /** What munition was used in the burst */
   protected EntityType  munition = new EntityType(); 

   /** type of warhead */
   protected int  warhead;

   /** type of fuse used */
   protected int  fuse;

   /** how many of the munition were fired */
   protected int  quantity;

   /** rate at which the munition was fired */
   protected int  rate;


/** Constructor */
 public BurstDescriptor()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + munition.getMarshalledSize();  // munition
   marshalSize = marshalSize + 2;  // warhead
   marshalSize = marshalSize + 2;  // fuse
   marshalSize = marshalSize + 2;  // quantity
   marshalSize = marshalSize + 2;  // rate

   return marshalSize;
}


public void setMunition(EntityType pMunition)
{ munition = pMunition;
}

@XmlElement
public EntityType getMunition()
{ return munition; 
}

public void setWarhead(int pWarhead)
{ warhead = pWarhead;
}

@XmlAttribute
public int getWarhead()
{ return warhead; 
}

public void setFuse(int pFuse)
{ fuse = pFuse;
}

@XmlAttribute
public int getFuse()
{ return fuse; 
}

public void setQuantity(int pQuantity)
{ quantity = pQuantity;
}

@XmlAttribute
public int getQuantity()
{ return quantity; 
}

public void setRate(int pRate)
{ rate = pRate;
}

@XmlAttribute
public int getRate()
{ return rate; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       munition.marshal(dos);
       dos.writeShort( (short)warhead);
       dos.writeShort( (short)fuse);
       dos.writeShort( (short)quantity);
       dos.writeShort( (short)rate);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       munition.unmarshal(dis);
       warhead = (int)dis.readUnsignedShort();
       fuse = (int)dis.readUnsignedShort();
       quantity = (int)dis.readUnsignedShort();
       rate = (int)dis.readUnsignedShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(BurstDescriptor rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (munition.equals( rhs.munition) )) ivarsEqual = false;
     if( ! (warhead == rhs.warhead)) ivarsEqual = false;
     if( ! (fuse == rhs.fuse)) ivarsEqual = false;
     if( ! (quantity == rhs.quantity)) ivarsEqual = false;
     if( ! (rate == rhs.rate)) ivarsEqual = false;

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
