package edu.nps.moves.dis7mobile;

import java.util.*;
import java.io.*;
import edu.nps.moves.disenum.*;
import edu.nps.moves.disutil.*;


/**
 * First part of a simulation management (SIMAN) PDU and SIMAN-Reliability (SIMAN-R) PDU. Sectionn 6.2.81
 *
 * Copyright (c) 2008-2010, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class SimulationManagementPduHeader extends Object implements Serializable
{
   /** Conventional PDU header */
   protected PduHeader  pduHeader = new PduHeader(); 

   /** IDs the simulation or entity, etiehr a simulation or an entity. Either 6.2.80 or 6.2.28 */
   protected EntityID  originatingID = new EntityID(); 

   /** simulation, all simulations, a special ID, or an entity. See 5.6.5 and 5.12.4 */
   protected EntityID  recevingID = new EntityID(); 


/** Constructor */
 public SimulationManagementPduHeader()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + pduHeader.getMarshalledSize();  // pduHeader
   marshalSize = marshalSize + originatingID.getMarshalledSize();  // originatingID
   marshalSize = marshalSize + recevingID.getMarshalledSize();  // recevingID

   return marshalSize;
}


public void setPduHeader(PduHeader pPduHeader)
{ pduHeader = pPduHeader;
}

public PduHeader getPduHeader()
{ return pduHeader; 
}

public void setOriginatingID(EntityID pOriginatingID)
{ originatingID = pOriginatingID;
}

public EntityID getOriginatingID()
{ return originatingID; 
}

public void setRecevingID(EntityID pRecevingID)
{ recevingID = pRecevingID;
}

public EntityID getRecevingID()
{ return recevingID; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       pduHeader.marshal(dos);
       originatingID.marshal(dos);
       recevingID.marshal(dos);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       pduHeader.unmarshal(dis);
       originatingID.unmarshal(dis);
       recevingID.unmarshal(dis);
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
       pduHeader.marshal(buff);
       originatingID.marshal(buff);
       recevingID.marshal(buff);
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
       pduHeader.unmarshal(buff);
       originatingID.unmarshal(buff);
       recevingID.unmarshal(buff);
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

    if(!(obj instanceof SimulationManagementPduHeader))
        return false;

     final SimulationManagementPduHeader rhs = (SimulationManagementPduHeader)obj;

     if( ! (pduHeader.equals( rhs.pduHeader) )) ivarsEqual = false;
     if( ! (originatingID.equals( rhs.originatingID) )) ivarsEqual = false;
     if( ! (recevingID.equals( rhs.recevingID) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
