package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.5.4. Cancel of resupply by either the receiving or supplying entity. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ResupplyCancelPdu extends LogisticsFamilyPdu implements Serializable
{
   /** Entity that is receiving service */
   protected EntityID  receivingEntityID = new EntityID(); 

   /** Entity that is supplying */
   protected EntityID  supplyingEntityID = new EntityID(); 


/** Constructor */
 public ResupplyCancelPdu()
 {
    setPduType( (short)8 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + receivingEntityID.getMarshalledSize();  // receivingEntityID
   marshalSize = marshalSize + supplyingEntityID.getMarshalledSize();  // supplyingEntityID

   return marshalSize;
}


public void setReceivingEntityID(EntityID pReceivingEntityID)
{ receivingEntityID = pReceivingEntityID;
}

@XmlElement
public EntityID getReceivingEntityID()
{ return receivingEntityID; 
}

public void setSupplyingEntityID(EntityID pSupplyingEntityID)
{ supplyingEntityID = pSupplyingEntityID;
}

@XmlElement
public EntityID getSupplyingEntityID()
{ return supplyingEntityID; 
}


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       receivingEntityID.marshal(dos);
       supplyingEntityID.marshal(dos);
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
       supplyingEntityID.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(ResupplyCancelPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (supplyingEntityID.equals( rhs.supplyingEntityID) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
