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
   protected List<Point> _requestedPerimeterPoints = new List<Point>(); 
   /** Sensor types, each 16 bits long */
   protected List<TwoByteChunk> _sensorTypes = new List<TwoByteChunk>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.10.2 Query a minefield for information about individual mines. Requires manual clean up to get the padding right. UNFINISHED
   ///</summary>
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


   ///<summary>
   ///Minefield ID
   ///</summary>
public void setMinefieldID(EntityID pMinefieldID)
{ _minefieldID = pMinefieldID;
}

   ///<summary>
   ///Minefield ID
   ///</summary>
public EntityID getMinefieldID()
{ return _minefieldID; 
}

   ///<summary>
   ///Minefield ID
   ///</summary>
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

   ///<summary>
   ///EID of entity making the request
   ///</summary>
public void setRequestingEntityID(EntityID pRequestingEntityID)
{ _requestingEntityID = pRequestingEntityID;
}

   ///<summary>
   ///EID of entity making the request
   ///</summary>
public EntityID getRequestingEntityID()
{ return _requestingEntityID; 
}

   ///<summary>
   ///EID of entity making the request
   ///</summary>
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

   ///<summary>
   ///request ID
   ///</summary>
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

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfPerimeterPoints method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfPerimeterPoints(byte pNumberOfPerimeterPoints)
{ _numberOfPerimeterPoints = pNumberOfPerimeterPoints;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfPerimeterPoints method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(byte), ElementName="numberOfPerimeterPoints")]
public byte NumberOfPerimeterPoints
{
     get
     {
          return _numberOfPerimeterPoints;
     }
     set
     {
          _numberOfPerimeterPoints = value;
     }
}

   ///<summary>
   ///Padding
   ///</summary>
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

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfSensorTypes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfSensorTypes(byte pNumberOfSensorTypes)
{ _numberOfSensorTypes = pNumberOfSensorTypes;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfSensorTypes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(byte), ElementName="numberOfSensorTypes")]
public byte NumberOfSensorTypes
{
     get
     {
          return _numberOfSensorTypes;
     }
     set
     {
          _numberOfSensorTypes = value;
     }
}

   ///<summary>
   ///data filter, 32 boolean fields
   ///</summary>
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

   ///<summary>
   ///Entity type of mine being requested
   ///</summary>
public void setRequestedMineType(EntityType pRequestedMineType)
{ _requestedMineType = pRequestedMineType;
}

   ///<summary>
   ///Entity type of mine being requested
   ///</summary>
public EntityType getRequestedMineType()
{ return _requestedMineType; 
}

   ///<summary>
   ///Entity type of mine being requested
   ///</summary>
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

   ///<summary>
   ///perimeter points of request
   ///</summary>
public void setRequestedPerimeterPoints(List<Point> pRequestedPerimeterPoints)
{ _requestedPerimeterPoints = pRequestedPerimeterPoints;
}

   ///<summary>
   ///perimeter points of request
   ///</summary>
public List<Point> getRequestedPerimeterPoints()
{ return _requestedPerimeterPoints; }

   ///<summary>
   ///perimeter points of request
   ///</summary>
[XmlElement(ElementName = "requestedPerimeterPointsList",Type = typeof(List<Point>))]
public List<Point> RequestedPerimeterPoints
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

   ///<summary>
   ///Sensor types, each 16 bits long
   ///</summary>
public void setSensorTypes(List<TwoByteChunk> pSensorTypes)
{ _sensorTypes = pSensorTypes;
}

   ///<summary>
   ///Sensor types, each 16 bits long
   ///</summary>
public List<TwoByteChunk> getSensorTypes()
{ return _sensorTypes; }

   ///<summary>
   ///Sensor types, each 16 bits long
   ///</summary>
[XmlElement(ElementName = "sensorTypesList",Type = typeof(List<TwoByteChunk>))]
public List<TwoByteChunk> SensorTypes
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

///<summary>
///Automatically sets the length of the marshalled data, then calls the marshal method.
///</summary>
public void marshalAutoLengthSet(DataOutputStream dos)
{
       //Set the length prior to marshalling data
       this.setLength((ushort)this.getMarshalledSize());
       this.marshal(dos);
}

///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
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
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
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
