package edu.nps.moves.dis7mobile;

import java.util.*;
import java.io.*;
import edu.nps.moves.disenum.*;
import edu.nps.moves.disutil.*;


/**
 * The Blanking Sector attribute record may be used to convey persistent areas within a scan volume where emitter power for a specific active emitter beam is reduced to an insignificant value. Section 6.2.12
 *
 * Copyright (c) 2008-2010, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class BlankingSector extends Object implements Serializable
{
   protected long  recordType = (long)3500;

   protected int  recordLength;

   protected short  emitterNumber;

   protected short  beamNumber;

   protected short  stateIndicator;

   protected float  leftAzimuth;

   protected float  rightAzimuth;

   protected float  lowerElevation;

   protected float  upperElevation;

   protected float  residualPower;


/** Constructor */
 public BlankingSector()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // recordType
   marshalSize = marshalSize + 2;  // recordLength
   marshalSize = marshalSize + 1;  // emitterNumber
   marshalSize = marshalSize + 1;  // beamNumber
   marshalSize = marshalSize + 1;  // stateIndicator
   marshalSize = marshalSize + 4;  // leftAzimuth
   marshalSize = marshalSize + 4;  // rightAzimuth
   marshalSize = marshalSize + 4;  // lowerElevation
   marshalSize = marshalSize + 4;  // upperElevation
   marshalSize = marshalSize + 4;  // residualPower

   return marshalSize;
}


public void setRecordType(long pRecordType)
{ recordType = pRecordType;
}

public long getRecordType()
{ return recordType; 
}

public void setRecordLength(int pRecordLength)
{ recordLength = pRecordLength;
}

public int getRecordLength()
{ return recordLength; 
}

public void setEmitterNumber(short pEmitterNumber)
{ emitterNumber = pEmitterNumber;
}

public short getEmitterNumber()
{ return emitterNumber; 
}

public void setBeamNumber(short pBeamNumber)
{ beamNumber = pBeamNumber;
}

public short getBeamNumber()
{ return beamNumber; 
}

public void setStateIndicator(short pStateIndicator)
{ stateIndicator = pStateIndicator;
}

public short getStateIndicator()
{ return stateIndicator; 
}

public void setLeftAzimuth(float pLeftAzimuth)
{ leftAzimuth = pLeftAzimuth;
}

public float getLeftAzimuth()
{ return leftAzimuth; 
}

public void setRightAzimuth(float pRightAzimuth)
{ rightAzimuth = pRightAzimuth;
}

public float getRightAzimuth()
{ return rightAzimuth; 
}

public void setLowerElevation(float pLowerElevation)
{ lowerElevation = pLowerElevation;
}

public float getLowerElevation()
{ return lowerElevation; 
}

public void setUpperElevation(float pUpperElevation)
{ upperElevation = pUpperElevation;
}

public float getUpperElevation()
{ return upperElevation; 
}

public void setResidualPower(float pResidualPower)
{ residualPower = pResidualPower;
}

public float getResidualPower()
{ return residualPower; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeInt( (int)recordType);
       dos.writeShort( (short)recordLength);
       dos.writeByte( (byte)emitterNumber);
       dos.writeByte( (byte)beamNumber);
       dos.writeByte( (byte)stateIndicator);
       dos.writeFloat( (float)leftAzimuth);
       dos.writeFloat( (float)rightAzimuth);
       dos.writeFloat( (float)lowerElevation);
       dos.writeFloat( (float)upperElevation);
       dos.writeFloat( (float)residualPower);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       recordType = dis.readInt();
       recordLength = (int)dis.readUnsignedShort();
       emitterNumber = (short)dis.readUnsignedByte();
       beamNumber = (short)dis.readUnsignedByte();
       stateIndicator = (short)dis.readUnsignedByte();
       leftAzimuth = dis.readFloat();
       rightAzimuth = dis.readFloat();
       lowerElevation = dis.readFloat();
       upperElevation = dis.readFloat();
       residualPower = dis.readFloat();
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
       buff.putInt( (int)recordType);
       buff.putShort( (short)recordLength);
       buff.put( (byte)emitterNumber);
       buff.put( (byte)beamNumber);
       buff.put( (byte)stateIndicator);
       buff.putFloat( (float)leftAzimuth);
       buff.putFloat( (float)rightAzimuth);
       buff.putFloat( (float)lowerElevation);
       buff.putFloat( (float)upperElevation);
       buff.putFloat( (float)residualPower);
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
       recordType = buff.getInt();
       recordLength = (int)(buff.getShort() & 0xFFFF);
       emitterNumber = (short)(buff.get() & 0xFF);
       beamNumber = (short)(buff.get() & 0xFF);
       stateIndicator = (short)(buff.get() & 0xFF);
       leftAzimuth = buff.getFloat();
       rightAzimuth = buff.getFloat();
       lowerElevation = buff.getFloat();
       upperElevation = buff.getFloat();
       residualPower = buff.getFloat();
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

    if(!(obj instanceof BlankingSector))
        return false;

     final BlankingSector rhs = (BlankingSector)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (emitterNumber == rhs.emitterNumber)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
     if( ! (stateIndicator == rhs.stateIndicator)) ivarsEqual = false;
     if( ! (leftAzimuth == rhs.leftAzimuth)) ivarsEqual = false;
     if( ! (rightAzimuth == rhs.rightAzimuth)) ivarsEqual = false;
     if( ! (lowerElevation == rhs.lowerElevation)) ivarsEqual = false;
     if( ! (upperElevation == rhs.upperElevation)) ivarsEqual = false;
     if( ! (residualPower == rhs.residualPower)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
