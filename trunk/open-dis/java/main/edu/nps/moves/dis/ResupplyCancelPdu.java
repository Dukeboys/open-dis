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
 * Packs a Pdu into the ByteBuffer.
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @since ??
 */
public void marshal(java.nio.ByteBuffer buff)
{
       super.marshal(buff);
       receivingEntityID.marshal(buff);
       supplyingEntityID.marshal(buff);
    } // end of marshal method

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 * @since ??
 */
public void unmarshal(java.nio.ByteBuffer buff)
{
       super.unmarshal(buff);

       receivingEntityID.unmarshal(buff);
       supplyingEntityID.unmarshal(buff);
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
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