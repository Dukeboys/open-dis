package edu.nps.moves.dis7mobile;

import java.util.*;
import java.io.*;
import edu.nps.moves.disenum.*;



/**
 * indicate weapons (munitions) previously communicated via the Munition record. Section 6.2.61 
 *
 * Copyright (c) 2008-2010, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class MunitionReload extends Object implements Serializable
{
   /**  This field shall identify the entity type of the munition. See section 6.2.30. */
   protected EntityType  munitionType = new EntityType(); 

   /** the station or launcher to which the munition is assigned. See Annex I */
   protected long  station;

   /** the standard quantity of this munition type normally loaded at this station/launcher if a station/launcher is specified. */
   protected int  standardQuantity;

   /** the maximum quantity of this munition type that this station/launcher is capable of holding when a station/launcher is specified  */
   protected int  maximumQuantity;

   /** the station name within the host at which the part entity is located. */
   protected int  stationName;

   /** the number of the particular wing station, cargo hold etc., at which the part is attached. */
   protected int  stationNumber;


/** Constructor */
 public MunitionReload()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + munitionType.getMarshalledSize();  // munitionType
   marshalSize = marshalSize + 4;  // station
   marshalSize = marshalSize + 2;  // standardQuantity
   marshalSize = marshalSize + 2;  // maximumQuantity
   marshalSize = marshalSize + 2;  // stationName
   marshalSize = marshalSize + 2;  // stationNumber

   return marshalSize;
}


public void setMunitionType(EntityType pMunitionType)
{ munitionType = pMunitionType;
}

public EntityType getMunitionType()
{ return munitionType; 
}

public void setStation(long pStation)
{ station = pStation;
}

public long getStation()
{ return station; 
}

public void setStandardQuantity(int pStandardQuantity)
{ standardQuantity = pStandardQuantity;
}

public int getStandardQuantity()
{ return standardQuantity; 
}

public void setMaximumQuantity(int pMaximumQuantity)
{ maximumQuantity = pMaximumQuantity;
}

public int getMaximumQuantity()
{ return maximumQuantity; 
}

public void setStationName(int pStationName)
{ stationName = pStationName;
}

public int getStationName()
{ return stationName; 
}

public void setStationNumber(int pStationNumber)
{ stationNumber = pStationNumber;
}

public int getStationNumber()
{ return stationNumber; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       munitionType.marshal(dos);
       dos.writeInt( (int)station);
       dos.writeShort( (short)standardQuantity);
       dos.writeShort( (short)maximumQuantity);
       dos.writeShort( (short)stationName);
       dos.writeShort( (short)stationNumber);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       munitionType.unmarshal(dis);
       station = dis.readInt();
       standardQuantity = (int)dis.readUnsignedShort();
       maximumQuantity = (int)dis.readUnsignedShort();
       stationName = (int)dis.readUnsignedShort();
       stationNumber = (int)dis.readUnsignedShort();
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
       munitionType.marshal(buff);
       buff.putInt( (int)station);
       buff.putShort( (short)standardQuantity);
       buff.putShort( (short)maximumQuantity);
       buff.putShort( (short)stationName);
       buff.putShort( (short)stationNumber);
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
       munitionType.unmarshal(buff);
       station = buff.getInt();
       standardQuantity = (int)(buff.getShort() & 0xFFFF);
       maximumQuantity = (int)(buff.getShort() & 0xFFFF);
       stationName = (int)(buff.getShort() & 0xFFFF);
       stationNumber = (int)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof MunitionReload))
        return false;

     final MunitionReload rhs = (MunitionReload)obj;

     if( ! (munitionType.equals( rhs.munitionType) )) ivarsEqual = false;
     if( ! (station == rhs.station)) ivarsEqual = false;
     if( ! (standardQuantity == rhs.standardQuantity)) ivarsEqual = false;
     if( ! (maximumQuantity == rhs.maximumQuantity)) ivarsEqual = false;
     if( ! (stationName == rhs.stationName)) ivarsEqual = false;
     if( ! (stationNumber == rhs.stationNumber)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
