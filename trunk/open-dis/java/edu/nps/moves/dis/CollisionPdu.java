package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.3.2. Information about a collision. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class CollisionPdu extends EntityInformationFamilyPdu implements Serializable
{
   /** ID of the entity that issued the collision PDU */
   protected EntityID  issuingEntityID = new EntityID(); 

   /** ID of entity that has collided with the issuing entity ID */
   protected EntityID  collidingEntityID = new EntityID(); 

   /** ID of event */
   protected EventID  eventID = new EventID(); 

   /** ID of event */
   protected short  collisionType;

   /** some padding */
   protected byte  pad = 0;

   /** velocity at collision */
   protected Vector3Float  velocity = new Vector3Float(); 

   /** mass of issuing entity */
   protected float  mass;

   /** Location with respect to entity the issuing entity collided with */
   protected Vector3Float  location = new Vector3Float(); 


/** Constructor */
 public CollisionPdu()
 {
    setPduType( (short)4 );
    setProtocolFamily( (short)1 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + issuingEntityID.getMarshalledSize();  // issuingEntityID
   marshalSize = marshalSize + collidingEntityID.getMarshalledSize();  // collidingEntityID
   marshalSize = marshalSize + eventID.getMarshalledSize();  // eventID
   marshalSize = marshalSize + 1;  // collisionType
   marshalSize = marshalSize + 1;  // pad
   marshalSize = marshalSize + velocity.getMarshalledSize();  // velocity
   marshalSize = marshalSize + 4;  // mass
   marshalSize = marshalSize + location.getMarshalledSize();  // location

   return marshalSize;
}


public void setIssuingEntityID(EntityID pIssuingEntityID)
{ issuingEntityID = pIssuingEntityID;
}

@XmlElement
public EntityID getIssuingEntityID()
{ return issuingEntityID; 
}

public void setCollidingEntityID(EntityID pCollidingEntityID)
{ collidingEntityID = pCollidingEntityID;
}

@XmlElement
public EntityID getCollidingEntityID()
{ return collidingEntityID; 
}

public void setEventID(EventID pEventID)
{ eventID = pEventID;
}

@XmlElement
public EventID getEventID()
{ return eventID; 
}

public void setCollisionType(short pCollisionType)
{ collisionType = pCollisionType;
}

@XmlAttribute
public short getCollisionType()
{ return collisionType; 
}

public void setPad(byte pPad)
{ pad = pPad;
}

@XmlAttribute
public byte getPad()
{ return pad; 
}

public void setVelocity(Vector3Float pVelocity)
{ velocity = pVelocity;
}

@XmlElement
public Vector3Float getVelocity()
{ return velocity; 
}

public void setMass(float pMass)
{ mass = pMass;
}

@XmlAttribute
public float getMass()
{ return mass; 
}

public void setLocation(Vector3Float pLocation)
{ location = pLocation;
}

@XmlElement
public Vector3Float getLocation()
{ return location; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       issuingEntityID.marshal(dos);
       collidingEntityID.marshal(dos);
       eventID.marshal(dos);
       dos.writeByte( (byte)collisionType);
       dos.writeByte( (byte)pad);
       velocity.marshal(dos);
       dos.writeFloat( (float)mass);
       location.marshal(dos);
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
       issuingEntityID.unmarshal(dis);
       collidingEntityID.unmarshal(dis);
       eventID.unmarshal(dis);
       collisionType = (short)dis.readUnsignedByte();
       pad = dis.readByte();
       velocity.unmarshal(dis);
       mass = dis.readFloat();
       location.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(CollisionPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (issuingEntityID.equals( rhs.issuingEntityID) )) ivarsEqual = false;
     if( ! (collidingEntityID.equals( rhs.collidingEntityID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (collisionType == rhs.collisionType)) ivarsEqual = false;
     if( ! (pad == rhs.pad)) ivarsEqual = false;
     if( ! (velocity.equals( rhs.velocity) )) ivarsEqual = false;
     if( ! (mass == rhs.mass)) ivarsEqual = false;
     if( ! (location.equals( rhs.location) )) ivarsEqual = false;

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
