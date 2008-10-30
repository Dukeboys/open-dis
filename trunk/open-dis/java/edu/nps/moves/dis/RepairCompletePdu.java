package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.5.5. Repair is complete. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class RepairCompletePdu extends LogisticsFamilyPdu implements Serializable
{
   /** Entity that is receiving service */
   protected EntityID  receivingEntityID = new EntityID(); 

   /** Entity that is supplying */
   protected EntityID  repairingEntityID = new EntityID(); 

   /** Enumeration for type of repair */
   protected int  repair;

   /** padding */
   protected short  padding = 0;


/** Constructor */
 public RepairCompletePdu()
 {
    setPduType( (short)9 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + receivingEntityID.getMarshalledSize();  // receivingEntityID
   marshalSize = marshalSize + repairingEntityID.getMarshalledSize();  // repairingEntityID
   marshalSize = marshalSize + 2;  // repair
   marshalSize = marshalSize + 2;  // padding

   return marshalSize;
}


public void setReceivingEntityID(EntityID pReceivingEntityID)
{ receivingEntityID = pReceivingEntityID;
}

@XmlElement
public EntityID getReceivingEntityID()
{ return receivingEntityID; 
}

public void setRepairingEntityID(EntityID pRepairingEntityID)
{ repairingEntityID = pRepairingEntityID;
}

@XmlElement
public EntityID getRepairingEntityID()
{ return repairingEntityID; 
}

public void setRepair(int pRepair)
{ repair = pRepair;
}

@XmlAttribute
public int getRepair()
{ return repair; 
}

public void setPadding(short pPadding)
{ padding = pPadding;
}

@XmlAttribute
public short getPadding()
{ return padding; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       receivingEntityID.marshal(dos);
       repairingEntityID.marshal(dos);
       dos.writeShort( (short)repair);
       dos.writeShort( (short)padding);
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
       receivingEntityID.unmarshal(dis);
       repairingEntityID.unmarshal(dis);
       repair = (int)dis.readUnsignedShort();
       padding = dis.readShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(RepairCompletePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (repairingEntityID.equals( rhs.repairingEntityID) )) ivarsEqual = false;
     if( ! (repair == rhs.repair)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;

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
