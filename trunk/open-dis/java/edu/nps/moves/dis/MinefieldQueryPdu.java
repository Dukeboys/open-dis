package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.10.2 Query a minefield for information about individual mines. Requires manual clean up to get the padding right. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class MinefieldQueryPdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected EntityID  minefieldID = new EntityID(); 

   /** EID of entity making the request */
   protected EntityID  requestingEntityID = new EntityID(); 

   /** request ID */
   protected short  requestID;

   /** Number of perimeter points for the minefield */
   protected short  numberOfPerimeterPoints;

   /** Padding */
   protected short  pad2;

   /** Number of sensor types */
   protected short  numberOfSensorTypes;

   /** data filter, 32 boolean fields */
   protected long  dataFilter;

   /** Entity type of mine being requested */
   protected EntityType  requestedMineType = new EntityType(); 

   /** perimeter points of request */
   protected List requestedPerimeterPoints = new ArrayList(); 
   /** Sensor types, each 16 bits long */
   protected List sensorTypes = new ArrayList(); 

/** Constructor */
 public MinefieldQueryPdu()
 {
    setPduType( (short)38 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + minefieldID.getMarshalledSize();  // minefieldID
   marshalSize = marshalSize + requestingEntityID.getMarshalledSize();  // requestingEntityID
   marshalSize = marshalSize + 1;  // requestID
   marshalSize = marshalSize + 1;  // numberOfPerimeterPoints
   marshalSize = marshalSize + 1;  // pad2
   marshalSize = marshalSize + 1;  // numberOfSensorTypes
   marshalSize = marshalSize + 4;  // dataFilter
   marshalSize = marshalSize + requestedMineType.getMarshalledSize();  // requestedMineType
   for(int idx=0; idx < requestedPerimeterPoints.size(); idx++)
   {
        Point listElement = (Point)requestedPerimeterPoints.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < sensorTypes.size(); idx++)
   {
        TwoByteChunk listElement = (TwoByteChunk)sensorTypes.get(idx);
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

public void setRequestID(short pRequestID)
{ requestID = pRequestID;
}

@XmlAttribute
public short getRequestID()
{ return requestID; 
}

@XmlAttribute
public short getNumberOfPerimeterPoints()
{ return (short)requestedPerimeterPoints.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfPerimeterPoints method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfPerimeterPoints(short pNumberOfPerimeterPoints)
{ numberOfPerimeterPoints = pNumberOfPerimeterPoints;
}

public void setPad2(short pPad2)
{ pad2 = pPad2;
}

@XmlAttribute
public short getPad2()
{ return pad2; 
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

public void setDataFilter(long pDataFilter)
{ dataFilter = pDataFilter;
}

@XmlAttribute
public long getDataFilter()
{ return dataFilter; 
}

public void setRequestedMineType(EntityType pRequestedMineType)
{ requestedMineType = pRequestedMineType;
}

@XmlElement
public EntityType getRequestedMineType()
{ return requestedMineType; 
}

public void setRequestedPerimeterPoints(List pRequestedPerimeterPoints)
{ requestedPerimeterPoints = pRequestedPerimeterPoints;
}

@XmlElementWrapper(name="requestedPerimeterPointsList" )
public List getRequestedPerimeterPoints()
{ return requestedPerimeterPoints; }

public void setSensorTypes(List pSensorTypes)
{ sensorTypes = pSensorTypes;
}

@XmlElementWrapper(name="sensorTypesList" )
public List getSensorTypes()
{ return sensorTypes; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeByte( (byte)requestID);
       dos.writeByte( (byte)requestedPerimeterPoints.size());
       dos.writeByte( (byte)pad2);
       dos.writeByte( (byte)sensorTypes.size());
       dos.writeInt( (int)dataFilter);
       requestedMineType.marshal(dos);

       for(int idx = 0; idx < requestedPerimeterPoints.size(); idx++)
       {
            Point aPoint = (Point)requestedPerimeterPoints.get(idx);
            aPoint.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < sensorTypes.size(); idx++)
       {
            TwoByteChunk aTwoByteChunk = (TwoByteChunk)sensorTypes.get(idx);
            aTwoByteChunk.marshal(dos);
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
       requestID = (short)dis.readUnsignedByte();
       numberOfPerimeterPoints = (short)dis.readUnsignedByte();
       pad2 = (short)dis.readUnsignedByte();
       numberOfSensorTypes = (short)dis.readUnsignedByte();
       dataFilter = dis.readInt();
       requestedMineType.unmarshal(dis);
        for(int idx = 0; idx < numberOfPerimeterPoints; idx++)
        {
           Point anX = new Point();
            anX.unmarshal(dis);
            requestedPerimeterPoints.add(anX);
        };

        for(int idx = 0; idx < numberOfSensorTypes; idx++)
        {
           TwoByteChunk anX = new TwoByteChunk();
            anX.unmarshal(dis);
            sensorTypes.add(anX);
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
 public boolean equals(MinefieldQueryPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (numberOfPerimeterPoints == rhs.numberOfPerimeterPoints)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (numberOfSensorTypes == rhs.numberOfSensorTypes)) ivarsEqual = false;
     if( ! (dataFilter == rhs.dataFilter)) ivarsEqual = false;
     if( ! (requestedMineType.equals( rhs.requestedMineType) )) ivarsEqual = false;

     for(int idx = 0; idx < requestedPerimeterPoints.size(); idx++)
     {
        Point x = (Point)requestedPerimeterPoints.get(idx);
        if( ! ( requestedPerimeterPoints.get(idx).equals(rhs.requestedPerimeterPoints.get(idx)))) ivarsEqual = false;
     }


     for(int idx = 0; idx < sensorTypes.size(); idx++)
     {
        TwoByteChunk x = (TwoByteChunk)sensorTypes.get(idx);
        if( ! ( sensorTypes.get(idx).equals(rhs.sensorTypes.get(idx)))) ivarsEqual = false;
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
