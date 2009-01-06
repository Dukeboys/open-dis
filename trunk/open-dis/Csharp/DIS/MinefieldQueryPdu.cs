using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.10.2 Query a minefield for information about individual mines. Requires manual clean up to get the padding right. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * Modified for use with C#:
 * Peter Smith (Naval Air Warfare Center - Training Systems Division)
 */
[Serializable]
[XmlRoot]
[XmlInclude(typeof(EntityID))]
[XmlInclude(typeof(EntityType))]
[XmlInclude(typeof(Point))]
[XmlInclude(typeof(TwoByteChunk))]
public class MinefieldQueryPdu : MinefieldFamilyPdu
{
   /** Minefield ID */
   protected EntityID  _minefieldID = new EntityID(); 

   /** EID of entity making the request */
   protected EntityID  _requestingEntityID = new EntityID(); 

   /** request ID */
   protected byte  _requestID;

   /** Number of perimeter points for the minefield */
   protected byte  _numberOfPerimeterPoints;

   /** Padding */
   protected byte  _pad2;

   /** Number of sensor types */
   protected byte  _numberOfSensorTypes;

   /** data filter, 32 boolean fields */
   protected uint  _dataFilter;

   /** Entity type of mine being requested */
   protected EntityType  _requestedMineType = new EntityType(); 

   /** perimeter points of request */
   protected List<object> _requestedPerimeterPoints = new List<object>(); 
   /** Sensor types, each 16 bits long */
   protected List<object> _sensorTypes = new List<object>(); 

/** Constructor */
 public MinefieldQueryPdu()
 {
    PduType = (byte)38;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _minefieldID.getMarshalledSize();  // _minefieldID
   marshalSize = marshalSize + _requestingEntityID.getMarshalledSize();  // _requestingEntityID
   marshalSize = marshalSize + 1;  // _requestID
   marshalSize = marshalSize + 1;  // _numberOfPerimeterPoints
   marshalSize = marshalSize + 1;  // _pad2
   marshalSize = marshalSize + 1;  // _numberOfSensorTypes
   marshalSize = marshalSize + 4;  // _dataFilter
   marshalSize = marshalSize + _requestedMineType.getMarshalledSize();  // _requestedMineType
   for(int idx=0; idx < _requestedPerimeterPoints.Count; idx++)
   {
        Point listElement = (Point)_requestedPerimeterPoints[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _sensorTypes.Count; idx++)
   {
        TwoByteChunk listElement = (TwoByteChunk)_sensorTypes[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setMinefieldID(EntityID pMinefieldID)
{ _minefieldID = pMinefieldID;
}

public EntityID getMinefieldID()
{ return _minefieldID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="minefieldID")]
public EntityID MinefieldID
{
     get
{
          return _minefieldID;
}
     set
{
          _minefieldID = value;
}
}

public void setRequestingEntityID(EntityID pRequestingEntityID)
{ _requestingEntityID = pRequestingEntityID;
}

public EntityID getRequestingEntityID()
{ return _requestingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="requestingEntityID")]
public EntityID RequestingEntityID
{
     get
{
          return _requestingEntityID;
}
     set
{
          _requestingEntityID = value;
}
}

public void setRequestID(byte pRequestID)
{ _requestID = pRequestID;
}

[XmlElement(Type= typeof(byte), ElementName="requestID")]
public byte RequestID
{
     get
{
          return _requestID;
}
     set
{
          _requestID = value;
}
}

public void setPad2(byte pPad2)
{ _pad2 = pPad2;
}

[XmlElement(Type= typeof(byte), ElementName="pad2")]
public byte Pad2
{
     get
{
          return _pad2;
}
     set
{
          _pad2 = value;
}
}

public void setDataFilter(uint pDataFilter)
{ _dataFilter = pDataFilter;
}

[XmlElement(Type= typeof(uint), ElementName="dataFilter")]
public uint DataFilter
{
     get
{
          return _dataFilter;
}
     set
{
          _dataFilter = value;
}
}

public void setRequestedMineType(EntityType pRequestedMineType)
{ _requestedMineType = pRequestedMineType;
}

public EntityType getRequestedMineType()
{ return _requestedMineType; 
}

[XmlElement(Type= typeof(EntityType), ElementName="requestedMineType")]
public EntityType RequestedMineType
{
     get
{
          return _requestedMineType;
}
     set
{
          _requestedMineType = value;
}
}

public void setRequestedPerimeterPoints(List<object> pRequestedPerimeterPoints)
{ _requestedPerimeterPoints = pRequestedPerimeterPoints;
}

public List<object> getRequestedPerimeterPoints()
{ return _requestedPerimeterPoints; }

[XmlElement(ElementName = "requestedPerimeterPointsList",Type = typeof(List<object>))]
public List<object> RequestedPerimeterPoints
{
     get
{
          return _requestedPerimeterPoints;
}
     set
{
          _requestedPerimeterPoints = value;
}
}

public void setSensorTypes(List<object> pSensorTypes)
{ _sensorTypes = pSensorTypes;
}

public List<object> getSensorTypes()
{ return _sensorTypes; }

[XmlElement(ElementName = "sensorTypesList",Type = typeof(List<object>))]
public List<object> SensorTypes
{
     get
{
          return _sensorTypes;
}
     set
{
          _sensorTypes = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _minefieldID.marshal(dos);
       _requestingEntityID.marshal(dos);
       dos.writeByte( (byte)_requestID);
       dos.writeByte( (byte)_requestedPerimeterPoints.Count);
       dos.writeByte( (byte)_pad2);
       dos.writeByte( (byte)_sensorTypes.Count);
       dos.writeUint( (uint)_dataFilter);
       _requestedMineType.marshal(dos);

       for(int idx = 0; idx < _requestedPerimeterPoints.Count; idx++)
       {
            Point aPoint = (Point)_requestedPerimeterPoints[idx];
            aPoint.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _sensorTypes.Count; idx++)
       {
            TwoByteChunk aTwoByteChunk = (TwoByteChunk)_sensorTypes[idx];
            aTwoByteChunk.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
    }
} // end of marshal method

public void unmarshal(DataInputStream dis)
{
    base.unmarshal(dis);

    try 
    {
       _minefieldID.unmarshal(dis);
       _requestingEntityID.unmarshal(dis);
       _requestID = dis.readByte();
       _numberOfPerimeterPoints = dis.readByte();
       _pad2 = dis.readByte();
       _numberOfSensorTypes = dis.readByte();
       _dataFilter = dis.readUint();
       _requestedMineType.unmarshal(dis);
        for(int idx = 0; idx < _numberOfPerimeterPoints; idx++)
        {
           Point anX = new Point();
            anX.unmarshal(dis);
            _requestedPerimeterPoints.Add(anX);
        };

        for(int idx = 0; idx < _numberOfSensorTypes; idx++)
        {
           TwoByteChunk anX = new TwoByteChunk();
            anX.unmarshal(dis);
            _sensorTypes.Add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- MinefieldQueryPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_minefieldID=====" + System.Environment.NewLine);
       _minefieldID.reflection(sb);
       sb.Append("=====_requestingEntityID=====" + System.Environment.NewLine);
       _requestingEntityID.reflection(sb);
           sb.Append("byte\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _requestedPerimeterPoints\t " + _requestedPerimeterPoints.Count.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _sensorTypes\t " + _sensorTypes.Count.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _dataFilter\t " + _dataFilter.ToString() + System.Environment.NewLine);
       sb.Append("=====_requestedMineType=====" + System.Environment.NewLine);
       _requestedMineType.reflection(sb);

       for(int idx = 0; idx < _requestedPerimeterPoints.Count; idx++)
       {
           sb.Append("Point\t " + _requestedPerimeterPoints[idx] + System.Environment.NewLine);
            Point aPoint = (Point)_requestedPerimeterPoints[idx];
            aPoint.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _sensorTypes.Count; idx++)
       {
           sb.Append("TwoByteChunk\t " + _sensorTypes[idx] + System.Environment.NewLine);
            TwoByteChunk aTwoByteChunk = (TwoByteChunk)_sensorTypes[idx];
            aTwoByteChunk.reflection(sb);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
}
    } // end of marshal method

 /**
  * The equals method doesn't always work--mostly it works only on on classes that consist only of primitives. Be careful.
  */
 public bool equals(MinefieldQueryPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_minefieldID.Equals( rhs._minefieldID) )) ivarsEqual = false;
     if( ! (_requestingEntityID.Equals( rhs._requestingEntityID) )) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;
     if( ! (_numberOfPerimeterPoints == rhs._numberOfPerimeterPoints)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_numberOfSensorTypes == rhs._numberOfSensorTypes)) ivarsEqual = false;
     if( ! (_dataFilter == rhs._dataFilter)) ivarsEqual = false;
     if( ! (_requestedMineType.Equals( rhs._requestedMineType) )) ivarsEqual = false;

     for(int idx = 0; idx < _requestedPerimeterPoints.Count; idx++)
     {
        Point x = (Point)_requestedPerimeterPoints[idx];
        if( ! ( _requestedPerimeterPoints[idx].Equals(rhs._requestedPerimeterPoints[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _sensorTypes.Count; idx++)
     {
        TwoByteChunk x = (TwoByteChunk)_sensorTypes[idx];
        if( ! ( _sensorTypes[idx].Equals(rhs._sensorTypes[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
