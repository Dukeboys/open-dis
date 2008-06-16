package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.6. Abstract superclass for PDUs relating to the simulation itself. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class SimulationManagementFamilyPdu extends Pdu implements Serializable
{
   /** Entity that is sending message */
   protected EntityID  originatingEntityID = new EntityID(); 

   /** Entity that is intended to receive message */
   protected EntityID  receivingEntityID = new EntityID(); 


/** Constructor */
 public SimulationManagementFamilyPdu()
 {
    setProtocolFamily( (short)5 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + originatingEntityID.getMarshalledSize();  // originatingEntityID
   marshalSize = marshalSize + receivingEntityID.getMarshalledSize();  // receivingEntityID

   return marshalSize;
}


public void setOriginatingEntityID(EntityID pOriginatingEntityID)
{ originatingEntityID = pOriginatingEntityID;
}

@XmlElement
public EntityID getOriginatingEntityID()
{ return originatingEntityID; 
}

public void setReceivingEntityID(EntityID pReceivingEntityID)
{ receivingEntityID = pReceivingEntityID;
}

@XmlElement
public EntityID getReceivingEntityID()
{ return receivingEntityID; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       originatingEntityID.marshal(dos);
       receivingEntityID.marshal(dos);
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
       originatingEntityID.unmarshal(dis);
       receivingEntityID.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(SimulationManagementFamilyPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (originatingEntityID.equals( rhs.originatingEntityID) )) ivarsEqual = false;
     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
