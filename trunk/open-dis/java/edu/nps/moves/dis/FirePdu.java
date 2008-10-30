package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Sectioin 5.3.4.1. Information about someone firing something. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class FirePdu extends WarfareFamilyPdu implements Serializable
{
   /** ID of the munition that is being shot */
   protected EntityID  munitionID = new EntityID(); 

   /** ID of event */
   protected EventID  eventID = new EventID(); 

   protected int  fireMissionIndex;

   /** location of the firing event */
   protected Vector3Double  locationInWorldCoordinates = new Vector3Double(); 

   /** Describes munitions used in the firing event */
   protected BurstDescriptor  burstDescriptor = new BurstDescriptor(); 

   /** Velocity of the ammunition */
   protected Vector3Float  velocity = new Vector3Float(); 

   /** range to the target */
   protected float  range;


/** Constructor */
 public FirePdu()
 {
    setPduType( (short)2 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + munitionID.getMarshalledSize();  // munitionID
   marshalSize = marshalSize + eventID.getMarshalledSize();  // eventID
   marshalSize = marshalSize + 4;  // fireMissionIndex
   marshalSize = marshalSize + locationInWorldCoordinates.getMarshalledSize();  // locationInWorldCoordinates
   marshalSize = marshalSize + burstDescriptor.getMarshalledSize();  // burstDescriptor
   marshalSize = marshalSize + velocity.getMarshalledSize();  // velocity
   marshalSize = marshalSize + 4;  // range

   return marshalSize;
}


public void setMunitionID(EntityID pMunitionID)
{ munitionID = pMunitionID;
}

@XmlElement
public EntityID getMunitionID()
{ return munitionID; 
}

public void setEventID(EventID pEventID)
{ eventID = pEventID;
}

@XmlElement
public EventID getEventID()
{ return eventID; 
}

public void setFireMissionIndex(int pFireMissionIndex)
{ fireMissionIndex = pFireMissionIndex;
}

@XmlAttribute
public int getFireMissionIndex()
{ return fireMissionIndex; 
}

public void setLocationInWorldCoordinates(Vector3Double pLocationInWorldCoordinates)
{ locationInWorldCoordinates = pLocationInWorldCoordinates;
}

@XmlElement
public Vector3Double getLocationInWorldCoordinates()
{ return locationInWorldCoordinates; 
}

public void setBurstDescriptor(BurstDescriptor pBurstDescriptor)
{ burstDescriptor = pBurstDescriptor;
}

@XmlElement
public BurstDescriptor getBurstDescriptor()
{ return burstDescriptor; 
}

public void setVelocity(Vector3Float pVelocity)
{ velocity = pVelocity;
}

@XmlElement
public Vector3Float getVelocity()
{ return velocity; 
}

public void setRange(float pRange)
{ range = pRange;
}

@XmlAttribute
public float getRange()
{ return range; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       munitionID.marshal(dos);
       eventID.marshal(dos);
       dos.writeInt( (int)fireMissionIndex);
       locationInWorldCoordinates.marshal(dos);
       burstDescriptor.marshal(dos);
       velocity.marshal(dos);
       dos.writeFloat( (float)range);
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
       munitionID.unmarshal(dis);
       eventID.unmarshal(dis);
       fireMissionIndex = dis.readInt();
       locationInWorldCoordinates.unmarshal(dis);
       burstDescriptor.unmarshal(dis);
       velocity.unmarshal(dis);
       range = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(FirePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (munitionID.equals( rhs.munitionID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (fireMissionIndex == rhs.fireMissionIndex)) ivarsEqual = false;
     if( ! (locationInWorldCoordinates.equals( rhs.locationInWorldCoordinates) )) ivarsEqual = false;
     if( ! (burstDescriptor.equals( rhs.burstDescriptor) )) ivarsEqual = false;
     if( ! (velocity.equals( rhs.velocity) )) ivarsEqual = false;
     if( ! (range == rhs.range)) ivarsEqual = false;

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
