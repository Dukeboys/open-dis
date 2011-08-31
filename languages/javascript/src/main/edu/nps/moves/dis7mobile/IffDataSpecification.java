package edu.nps.moves.dis7mobile;

import java.util.*;
import java.io.*;
import edu.nps.moves.disenum.*;
import edu.nps.moves.disutil.*;


/**
 * Requires hand coding to be useful. Section 6.2.44
 *
 * Copyright (c) 2008-2010, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IffDataSpecification extends Object implements Serializable
{
   /** Number of iff records */
   protected EntityType  numberOfIffDataRecords = new EntityType(); 


/** Constructor */
 public IffDataSpecification()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + numberOfIffDataRecords.getMarshalledSize();  // numberOfIffDataRecords

   return marshalSize;
}


public void setNumberOfIffDataRecords(EntityType pNumberOfIffDataRecords)
{ numberOfIffDataRecords = pNumberOfIffDataRecords;
}

public EntityType getNumberOfIffDataRecords()
{ return numberOfIffDataRecords; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       numberOfIffDataRecords.marshal(dos);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       numberOfIffDataRecords.unmarshal(dis);
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
       numberOfIffDataRecords.marshal(buff);
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
       numberOfIffDataRecords.unmarshal(buff);
 } // end of unmarshal method 


 /*
  * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
  */
@Override
 public boolean equals(Object obj)
 {

    if(this == obj){
      return true;
    }

    if(obj == null){
       return false;
    }

    if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

 /**
  * Compare all fields that contribute to the state, ignoring
 transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof IffDataSpecification))
        return false;

     final IffDataSpecification rhs = (IffDataSpecification)obj;

     if( ! (numberOfIffDataRecords.equals( rhs.numberOfIffDataRecords) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
