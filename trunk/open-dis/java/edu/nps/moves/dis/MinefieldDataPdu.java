package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.10.3 Information about individual mines within a minefield. This is very, very wrong. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class MinefieldDataPdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected EntityID  minefieldID = new EntityID(); 

   /** ID of entity making request */
   protected EntityID  requestingEntityID = new EntityID(); 

   /** Minefield sequence number */
   protected int  minefieldSequenceNumbeer;

   /** request ID */
   protected short  requestID;

   /** pdu sequence number */
   protected short  pduSequenceNumber;

   /** number of pdus in response */
   protected short  numberOfPdus;

   /** how many mines are in this PDU */
   protected short  numberOfMinesInThisPdu;

   /** how many sensor type are in this PDU */
   protected short  numberOfSensorTypes;

   /** padding */
   protected short  pad2 = 0;

   /** 32 boolean fields */
   protected long  dataFilter;

   /** Mine type */
   protected EntityType  mineType = new EntityType(); 

   /** Sensor types, each 16 bits long */
   protected List sensorTypes = new ArrayList(); 
   /** Padding to get things 32-bit aligned. @@@this is wrong--dyanmically sized padding needed */
   protected short  pad3;

   /** Mine locations */
   protected List mineLocation = new ArrayList(); 

/** Constructor */
 public MinefieldDataPdu()
 {
    setPduType( (short)39 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + minefieldID.getMarshalledSize();  // minefieldID
   marshalSize = marshalSize + requestingEntityID.getMarshalledSize();  // requestingEntityID
   marshalSize = marshalSize + 2;  // minefieldSequenceNumbeer
   marshalSize = marshalSize + 1;  // requestID
   marshalSize = marshalSize + 1;  // pduSequenceNumber
   marshalSize = marshalSize + 1;  // numberOfPdus
   marshalSize = marshalSize + 1;  // numberOfMinesInThisPdu
   marshalSize = marshalSize + 1;  // numberOfSensorTypes
   marshalSize = marshalSize + 1;  // pad2
   marshalSize = marshalSize + 4;  // dataFilter
   marshalSize = marshalSize + mineType.getMarshalledSize();  // mineType
   for(int idx=0; idx < sensorTypes.size(); idx++)
   {
        TwoByteChunk listElement = (TwoByteChunk)sensorTypes.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   marshalSize = marshalSize + 1;  // pad3
   for(int idx=0; idx < mineLocation.size(); idx++)
   {
        Vector3Float listElement = (Vector3Float)mineLocation.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setMinefieldID(EntityID pMinefieldID)
{ minefieldID = pMinefieldID;
}

@XmlElement
public EntityID getMinefieldID()
{ return minefieldID; 
}

public void setRequestingEntityID(EntityID pRequestingEntityID)
{ requestingEntityID = pRequestingEntityID;
}

@XmlElement
public EntityID getRequestingEntityID()
{ return requestingEntityID; 
}

public void setMinefieldSequenceNumbeer(int pMinefieldSequenceNumbeer)
{ minefieldSequenceNumbeer = pMinefieldSequenceNumbeer;
}

@XmlAttribute
public int getMinefieldSequenceNumbeer()
{ return minefieldSequenceNumbeer; 
}

public void setRequestID(short pRequestID)
{ requestID = pRequestID;
}

@XmlAttribute
public short getRequestID()
{ return requestID; 
}

public void setPduSequenceNumber(short pPduSequenceNumber)
{ pduSequenceNumber = pPduSequenceNumber;
}

@XmlAttribute
public short getPduSequenceNumber()
{ return pduSequenceNumber; 
}

public void setNumberOfPdus(short pNumberOfPdus)
{ numberOfPdus = pNumberOfPdus;
}

@XmlAttribute
public short getNumberOfPdus()
{ return numberOfPdus; 
}

@XmlAttribute
public short getNumberOfMinesInThisPdu()
{ return (short)mineLocation.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfMinesInThisPdu method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfMinesInThisPdu(short pNumberOfMinesInThisPdu)
{ numberOfMinesInThisPdu = pNumberOfMinesInThisPdu;
}

@XmlAttribute
public short getNumberOfSensorTypes()
{ return (short)sensorTypes.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfSensorTypes method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfSensorTypes(short pNumberOfSensorTypes)
{ numberOfSensorTypes = pNumberOfSensorTypes;
}

public void setPad2(short pPad2)
{ pad2 = pPad2;
}

@XmlAttribute
public short getPad2()
{ return pad2; 
}

public void setDataFilter(long pDataFilter)
{ dataFilter = pDataFilter;
}

@XmlAttribute
public long getDataFilter()
{ return dataFilter; 
}

public void setMineType(EntityType pMineType)
{ mineType = pMineType;
}

@XmlElement
public EntityType getMineType()
{ return mineType; 
}

public void setSensorTypes(List pSensorTypes)
{ sensorTypes = pSensorTypes;
}

@XmlElementWrapper(name="sensorTypesList" )
public List getSensorTypes()
{ return sensorTypes; }

public void setPad3(short pPad3)
{ pad3 = pPad3;
}

@XmlAttribute
public short getPad3()
{ return pad3; 
}

public void setMineLocation(List pMineLocation)
{ mineLocation = pMineLocation;
}

@XmlElementWrapper(name="mineLocationList" )
public List getMineLocation()
{ return mineLocation; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeShort( (short)minefieldSequenceNumbeer);
       dos.writeByte( (byte)requestID);
       dos.writeByte( (byte)pduSequenceNumber);
       dos.writeByte( (byte)numberOfPdus);
       dos.writeByte( (byte)mineLocation.size());
       dos.writeByte( (byte)sensorTypes.size());
       dos.writeByte( (byte)pad2);
       dos.writeInt( (int)dataFilter);
       mineType.marshal(dos);

       for(int idx = 0; idx < sensorTypes.size(); idx++)
       {
            TwoByteChunk aTwoByteChunk = (TwoByteChunk)sensorTypes.get(idx);
            aTwoByteChunk.marshal(dos);
       } // end of list marshalling

       dos.writeByte( (byte)pad3);

       for(int idx = 0; idx < mineLocation.size(); idx++)
       {
            Vector3Float aVector3Float = (Vector3Float)mineLocation.get(idx);
            aVector3Float.marshal(dos);
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
       minefieldID.unmarshal(dis);
       requestingEntityID.unmarshal(dis);
       minefieldSequenceNumbeer = (int)dis.readUnsignedShort();
       requestID = (short)dis.readUnsignedByte();
       pduSequenceNumber = (short)dis.readUnsignedByte();
       numberOfPdus = (short)dis.readUnsignedByte();
       numberOfMinesInThisPdu = (short)dis.readUnsignedByte();
       numberOfSensorTypes = (short)dis.readUnsignedByte();
       pad2 = (short)dis.readUnsignedByte();
       dataFilter = dis.readInt();
       mineType.unmarshal(dis);
        for(int idx = 0; idx < numberOfSensorTypes; idx++)
        {
           TwoByteChunk anX = new TwoByteChunk();
            anX.unmarshal(dis);
            sensorTypes.add(anX);
        };

       pad3 = (short)dis.readUnsignedByte();
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
           Vector3Float anX = new Vector3Float();
            anX.unmarshal(dis);
            mineLocation.add(anX);
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
 public boolean equals(MinefieldDataPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (minefieldSequenceNumbeer == rhs.minefieldSequenceNumbeer)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (pduSequenceNumber == rhs.pduSequenceNumber)) ivarsEqual = false;
     if( ! (numberOfPdus == rhs.numberOfPdus)) ivarsEqual = false;
     if( ! (numberOfMinesInThisPdu == rhs.numberOfMinesInThisPdu)) ivarsEqual = false;
     if( ! (numberOfSensorTypes == rhs.numberOfSensorTypes)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (dataFilter == rhs.dataFilter)) ivarsEqual = false;
     if( ! (mineType.equals( rhs.mineType) )) ivarsEqual = false;

     for(int idx = 0; idx < sensorTypes.size(); idx++)
     {
        TwoByteChunk x = (TwoByteChunk)sensorTypes.get(idx);
        if( ! ( sensorTypes.get(idx).equals(rhs.sensorTypes.get(idx)))) ivarsEqual = false;
     }

     if( ! (pad3 == rhs.pad3)) ivarsEqual = false;

     for(int idx = 0; idx < mineLocation.size(); idx++)
     {
        Vector3Float x = (Vector3Float)mineLocation.get(idx);
        if( ! ( mineLocation.get(idx).equals(rhs.mineLocation.get(idx)))) ivarsEqual = false;
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
