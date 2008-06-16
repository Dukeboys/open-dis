package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.9.4 The joining of two or more simulation entities is communicated by this PDU. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IsPartOfPdu extends EntityManagementFamilyPdu implements Serializable
{
   /** ID of entity originating PDU */
   protected EntityID  orginatingEntityID = new EntityID(); 

   /** ID of entity receiving PDU */
   protected EntityID  receivingEntityID = new EntityID(); 

   /** relationship of joined parts */
   protected Relationship  relationship = new Relationship(); 

   /** location of part; centroid of part in host's coordinate system. x=range, y=bearing, z=0 */
   protected Vector3Float  partLocation = new Vector3Float(); 

   /** named location */
   protected NamedLocation  namedLocationID = new NamedLocation(); 

   /** entity type */
   protected EntityType  partEntityType = new EntityType(); 


/** Constructor */
 public IsPartOfPdu()
 {
    setPduType( (short)36 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + orginatingEntityID.getMarshalledSize();  // orginatingEntityID
   marshalSize = marshalSize + receivingEntityID.getMarshalledSize();  // receivingEntityID
   marshalSize = marshalSize + relationship.getMarshalledSize();  // relationship
   marshalSize = marshalSize + partLocation.getMarshalledSize();  // partLocation
   marshalSize = marshalSize + namedLocationID.getMarshalledSize();  // namedLocationID
   marshalSize = marshalSize + partEntityType.getMarshalledSize();  // partEntityType

   return marshalSize;
}


public void setOrginatingEntityID(EntityID pOrginatingEntityID)
{ orginatingEntityID = pOrginatingEntityID;
}

@XmlElement
public EntityID getOrginatingEntityID()
{ return orginatingEntityID; 
}

public void setReceivingEntityID(EntityID pReceivingEntityID)
{ receivingEntityID = pReceivingEntityID;
}

@XmlElement
public EntityID getReceivingEntityID()
{ return receivingEntityID; 
}

public void setRelationship(Relationship pRelationship)
{ relationship = pRelationship;
}

@XmlElement
public Relationship getRelationship()
{ return relationship; 
}

public void setPartLocation(Vector3Float pPartLocation)
{ partLocation = pPartLocation;
}

@XmlElement
public Vector3Float getPartLocation()
{ return partLocation; 
}

public void setNamedLocationID(NamedLocation pNamedLocationID)
{ namedLocationID = pNamedLocationID;
}

@XmlElement
public NamedLocation getNamedLocationID()
{ return namedLocationID; 
}

public void setPartEntityType(EntityType pPartEntityType)
{ partEntityType = pPartEntityType;
}

@XmlElement
public EntityType getPartEntityType()
{ return partEntityType; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       orginatingEntityID.marshal(dos);
       receivingEntityID.marshal(dos);
       relationship.marshal(dos);
       partLocation.marshal(dos);
       namedLocationID.marshal(dos);
       partEntityType.marshal(dos);
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
       orginatingEntityID.unmarshal(dis);
       receivingEntityID.unmarshal(dis);
       relationship.unmarshal(dis);
       partLocation.unmarshal(dis);
       namedLocationID.unmarshal(dis);
       partEntityType.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(IsPartOfPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (orginatingEntityID.equals( rhs.orginatingEntityID) )) ivarsEqual = false;
     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (relationship.equals( rhs.relationship) )) ivarsEqual = false;
     if( ! (partLocation.equals( rhs.partLocation) )) ivarsEqual = false;
     if( ! (namedLocationID.equals( rhs.namedLocationID) )) ivarsEqual = false;
     if( ! (partEntityType.equals( rhs.partEntityType) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
