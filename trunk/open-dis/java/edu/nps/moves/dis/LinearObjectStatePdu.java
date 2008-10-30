package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.11.4: Information abut the addition or modification of a synthecic enviroment object that      is anchored to the terrain with a single point and has size or orientation. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class LinearObjectStatePdu extends SyntheticEnvironmentFamilyPdu implements Serializable
{
   /** Object in synthetic environment */
   protected EntityID  objectID = new EntityID(); 

   /** Object with which this point object is associated */
   protected EntityID  referencedObjectID = new EntityID(); 

   /** unique update number of each state transition of an object */
   protected int  updateNumber;

   /** force ID */
   protected short  forceID;

   /** number of linear segment parameters */
   protected short  numberOfSegments;

   /** requesterID */
   protected SimulationAddress  requesterID = new SimulationAddress(); 

   /** receiver ID */
   protected SimulationAddress  receivingID = new SimulationAddress(); 

   /** Object type */
   protected ObjectType  objectType = new ObjectType(); 

   /** Linear segment parameters */
   protected List linearSegmentParameters = new ArrayList(); 

/** Constructor */
 public LinearObjectStatePdu()
 {
    setPduType( (short)44 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + objectID.getMarshalledSize();  // objectID
   marshalSize = marshalSize + referencedObjectID.getMarshalledSize();  // referencedObjectID
   marshalSize = marshalSize + 2;  // updateNumber
   marshalSize = marshalSize + 1;  // forceID
   marshalSize = marshalSize + 1;  // numberOfSegments
   marshalSize = marshalSize + requesterID.getMarshalledSize();  // requesterID
   marshalSize = marshalSize + receivingID.getMarshalledSize();  // receivingID
   marshalSize = marshalSize + objectType.getMarshalledSize();  // objectType
   for(int idx=0; idx < linearSegmentParameters.size(); idx++)
   {
        LinearSegmentParameter listElement = (LinearSegmentParameter)linearSegmentParameters.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setObjectID(EntityID pObjectID)
{ objectID = pObjectID;
}

@XmlElement
public EntityID getObjectID()
{ return objectID; 
}

public void setReferencedObjectID(EntityID pReferencedObjectID)
{ referencedObjectID = pReferencedObjectID;
}

@XmlElement
public EntityID getReferencedObjectID()
{ return referencedObjectID; 
}

public void setUpdateNumber(int pUpdateNumber)
{ updateNumber = pUpdateNumber;
}

@XmlAttribute
public int getUpdateNumber()
{ return updateNumber; 
}

public void setForceID(short pForceID)
{ forceID = pForceID;
}

@XmlAttribute
public short getForceID()
{ return forceID; 
}

@XmlAttribute
public short getNumberOfSegments()
{ return (short)linearSegmentParameters.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfSegments method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfSegments(short pNumberOfSegments)
{ numberOfSegments = pNumberOfSegments;
}

public void setRequesterID(SimulationAddress pRequesterID)
{ requesterID = pRequesterID;
}

@XmlElement
public SimulationAddress getRequesterID()
{ return requesterID; 
}

public void setReceivingID(SimulationAddress pReceivingID)
{ receivingID = pReceivingID;
}

@XmlElement
public SimulationAddress getReceivingID()
{ return receivingID; 
}

public void setObjectType(ObjectType pObjectType)
{ objectType = pObjectType;
}

@XmlElement
public ObjectType getObjectType()
{ return objectType; 
}

public void setLinearSegmentParameters(List pLinearSegmentParameters)
{ linearSegmentParameters = pLinearSegmentParameters;
}

@XmlElementWrapper(name="linearSegmentParametersList" )
public List getLinearSegmentParameters()
{ return linearSegmentParameters; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       objectID.marshal(dos);
       referencedObjectID.marshal(dos);
       dos.writeShort( (short)updateNumber);
       dos.writeByte( (byte)forceID);
       dos.writeByte( (byte)linearSegmentParameters.size());
       requesterID.marshal(dos);
       receivingID.marshal(dos);
       objectType.marshal(dos);

       for(int idx = 0; idx < linearSegmentParameters.size(); idx++)
       {
            LinearSegmentParameter aLinearSegmentParameter = (LinearSegmentParameter)linearSegmentParameters.get(idx);
            aLinearSegmentParameter.marshal(dos);
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
       objectID.unmarshal(dis);
       referencedObjectID.unmarshal(dis);
       updateNumber = (int)dis.readUnsignedShort();
       forceID = (short)dis.readUnsignedByte();
       numberOfSegments = (short)dis.readUnsignedByte();
       requesterID.unmarshal(dis);
       receivingID.unmarshal(dis);
       objectType.unmarshal(dis);
        for(int idx = 0; idx < numberOfSegments; idx++)
        {
           LinearSegmentParameter anX = new LinearSegmentParameter();
            anX.unmarshal(dis);
            linearSegmentParameters.add(anX);
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
 public boolean equals(LinearObjectStatePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (objectID.equals( rhs.objectID) )) ivarsEqual = false;
     if( ! (referencedObjectID.equals( rhs.referencedObjectID) )) ivarsEqual = false;
     if( ! (updateNumber == rhs.updateNumber)) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (numberOfSegments == rhs.numberOfSegments)) ivarsEqual = false;
     if( ! (requesterID.equals( rhs.requesterID) )) ivarsEqual = false;
     if( ! (receivingID.equals( rhs.receivingID) )) ivarsEqual = false;
     if( ! (objectType.equals( rhs.objectType) )) ivarsEqual = false;

     for(int idx = 0; idx < linearSegmentParameters.size(); idx++)
     {
        LinearSegmentParameter x = (LinearSegmentParameter)linearSegmentParameters.get(idx);
        if( ! ( linearSegmentParameters.get(idx).equals(rhs.linearSegmentParameters.get(idx)))) ivarsEqual = false;
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
