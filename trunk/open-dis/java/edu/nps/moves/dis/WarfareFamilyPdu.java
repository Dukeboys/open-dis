package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.4. abstract superclass for fire and detonation pdus that have shared information. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class WarfareFamilyPdu extends Pdu implements Serializable
{
   /** ID of the entity that shot */
   protected EntityID  firingEntityID = new EntityID(); 

   /** ID of the entity that is being shot at */
   protected EntityID  targetEntityID = new EntityID(); 


/** Constructor */
 public WarfareFamilyPdu()
 {
    setProtocolFamily( (short)2 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + firingEntityID.getMarshalledSize();  // firingEntityID
   marshalSize = marshalSize + targetEntityID.getMarshalledSize();  // targetEntityID

   return marshalSize;
}


public void setFiringEntityID(EntityID pFiringEntityID)
{ firingEntityID = pFiringEntityID;
}

@XmlElement
public EntityID getFiringEntityID()
{ return firingEntityID; 
}

public void setTargetEntityID(EntityID pTargetEntityID)
{ targetEntityID = pTargetEntityID;
}

@XmlElement
public EntityID getTargetEntityID()
{ return targetEntityID; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       firingEntityID.marshal(dos);
       targetEntityID.marshal(dos);
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
       firingEntityID.unmarshal(dis);
       targetEntityID.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(WarfareFamilyPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (firingEntityID.equals( rhs.firingEntityID) )) ivarsEqual = false;
     if( ! (targetEntityID.equals( rhs.targetEntityID) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
