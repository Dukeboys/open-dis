using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.10.3 Information about individual mines within a minefield. This is very, very wrong. UNFINISHED
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
[XmlInclude(typeof(TwoByteChunk))]
[XmlInclude(typeof(Vector3Float))]
public class MinefieldDataPdu : MinefieldFamilyPdu
{
   /** Minefield ID */
   protected EntityID  _minefieldID = new EntityID(); 

   /** ID of entity making request */
   protected EntityID  _requestingEntityID = new EntityID(); 

   /** Minefield sequence number */
   protected ushort  _minefieldSequenceNumbeer;

   /** request ID */
   protected byte  _requestID;

   /** pdu sequence number */
   protected byte  _pduSequenceNumber;

   /** number of pdus in response */
   protected byte  _numberOfPdus;

   /** how many mines are in this PDU */
   protected byte  _numberOfMinesInThisPdu;

   /** how many sensor type are in this PDU */
   protected byte  _numberOfSensorTypes;

   /** padding */
   protected byte  _pad2 = 0;

   /** 32 boolean fields */
   protected uint  _dataFilter;

   /** Mine type */
   protected EntityType  _mineType = new EntityType(); 

   /** Sensor types, each 16 bits long */
   protected List<object> _sensorTypes = new List<object>(); 
   /** Padding to get things 32-bit aligned. @@@this is wrong--dyanmically sized padding needed */
   protected byte  _pad3;

   /** Mine locations */
   protected List<object> _mineLocation = new List<object>(); 

/** Constructor */
 public MinefieldDataPdu()
 {
    PduType = (byte)39;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _minefieldID.getMarshalledSize();  // _minefieldID
   marshalSize = marshalSize + _requestingEntityID.getMarshalledSize();  // _requestingEntityID
   marshalSize = marshalSize + 2;  // _minefieldSequenceNumbeer
   marshalSize = marshalSize + 1;  // _requestID
   marshalSize = marshalSize + 1;  // _pduSequenceNumber
   marshalSize = marshalSize + 1;  // _numberOfPdus
   marshalSize = marshalSize + 1;  // _numberOfMinesInThisPdu
   marshalSize = marshalSize + 1;  // _numberOfSensorTypes
   marshalSize = marshalSize + 1;  // _pad2
   marshalSize = marshalSize + 4;  // _dataFilter
   marshalSize = marshalSize + _mineType.getMarshalledSize();  // _mineType
   for(int idx=0; idx < _sensorTypes.Count; idx++)
   {
        TwoByteChunk listElement = (TwoByteChunk)_sensorTypes[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   marshalSize = marshalSize + 1;  // _pad3
   for(int idx=0; idx < _mineLocation.Count; idx++)
   {
        Vector3Float listElement = (Vector3Float)_mineLocation[idx];
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

public void setMinefieldSequenceNumbeer(ushort pMinefieldSequenceNumbeer)
{ _minefieldSequenceNumbeer = pMinefieldSequenceNumbeer;
}

[XmlElement(Type= typeof(ushort), ElementName="minefieldSequenceNumbeer")]
public ushort MinefieldSequenceNumbeer
{
     get
{
          return _minefieldSequenceNumbeer;
}
     set
{
          _minefieldSequenceNumbeer = value;
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

public void setPduSequenceNumber(byte pPduSequenceNumber)
{ _pduSequenceNumber = pPduSequenceNumber;
}

[XmlElement(Type= typeof(byte), ElementName="pduSequenceNumber")]
public byte PduSequenceNumber
{
     get
{
          return _pduSequenceNumber;
}
     set
{
          _pduSequenceNumber = value;
}
}

public void setNumberOfPdus(byte pNumberOfPdus)
{ _numberOfPdus = pNumberOfPdus;
}

[XmlElement(Type= typeof(byte), ElementName="numberOfPdus")]
public byte NumberOfPdus
{
     get
{
          return _numberOfPdus;
}
     set
{
          _numberOfPdus = value;
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

public void setMineType(EntityType pMineType)
{ _mineType = pMineType;
}

public EntityType getMineType()
{ return _mineType; 
}

[XmlElement(Type= typeof(EntityType), ElementName="mineType")]
public EntityType MineType
{
     get
{
          return _mineType;
}
     set
{
          _mineType = value;
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

public void setPad3(byte pPad3)
{ _pad3 = pPad3;
}

[XmlElement(Type= typeof(byte), ElementName="pad3")]
public byte Pad3
{
     get
{
          return _pad3;
}
     set
{
          _pad3 = value;
}
}

public void setMineLocation(List<object> pMineLocation)
{ _mineLocation = pMineLocation;
}

public List<object> getMineLocation()
{ return _mineLocation; }

[XmlElement(ElementName = "mineLocationList",Type = typeof(List<object>))]
public List<object> MineLocation
{
     get
{
          return _mineLocation;
}
     set
{
          _mineLocation = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _minefieldID.marshal(dos);
       _requestingEntityID.marshal(dos);
       dos.writeUshort( (ushort)_minefieldSequenceNumbeer);
       dos.writeByte( (byte)_requestID);
       dos.writeByte( (byte)_pduSequenceNumber);
       dos.writeByte( (byte)_numberOfPdus);
       dos.writeByte( (byte)_mineLocation.Count);
       dos.writeByte( (byte)_sensorTypes.Count);
       dos.writeByte( (byte)_pad2);
       dos.writeUint( (uint)_dataFilter);
       _mineType.marshal(dos);

       for(int idx = 0; idx < _sensorTypes.Count; idx++)
       {
            TwoByteChunk aTwoByteChunk = (TwoByteChunk)_sensorTypes[idx];
            aTwoByteChunk.marshal(dos);
       } // end of list marshalling

       dos.writeByte( (byte)_pad3);

       for(int idx = 0; idx < _mineLocation.Count; idx++)
       {
            Vector3Float aVector3Float = (Vector3Float)_mineLocation[idx];
            aVector3Float.marshal(dos);
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
       _minefieldSequenceNumbeer = dis.readUshort();
       _requestID = dis.readByte();
       _pduSequenceNumber = dis.readByte();
       _numberOfPdus = dis.readByte();
       _numberOfMinesInThisPdu = dis.readByte();
       _numberOfSensorTypes = dis.readByte();
       _pad2 = dis.readByte();
       _dataFilter = dis.readUint();
       _mineType.unmarshal(dis);
        for(int idx = 0; idx < _numberOfSensorTypes; idx++)
        {
           TwoByteChunk anX = new TwoByteChunk();
            anX.unmarshal(dis);
            _sensorTypes.Add(anX);
        };

       _pad3 = dis.readByte();
        for(int idx = 0; idx < _numberOfMinesInThisPdu; idx++)
        {
           Vector3Float anX = new Vector3Float();
            anX.unmarshal(dis);
            _mineLocation.Add(anX);
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
    sb.Append("----- MinefieldDataPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_minefieldID=====" + System.Environment.NewLine);
       _minefieldID.reflection(sb);
       sb.Append("=====_requestingEntityID=====" + System.Environment.NewLine);
       _requestingEntityID.reflection(sb);
           sb.Append("ushort\t _minefieldSequenceNumbeer\t " + _minefieldSequenceNumbeer.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pduSequenceNumber\t " + _pduSequenceNumber.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _numberOfPdus\t " + _numberOfPdus.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _mineLocation\t " + _mineLocation.Count.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _sensorTypes\t " + _sensorTypes.Count.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _dataFilter\t " + _dataFilter.ToString() + System.Environment.NewLine);
       sb.Append("=====_mineType=====" + System.Environment.NewLine);
       _mineType.reflection(sb);

       for(int idx = 0; idx < _sensorTypes.Count; idx++)
       {
           sb.Append("TwoByteChunk\t " + _sensorTypes[idx] + System.Environment.NewLine);
            TwoByteChunk aTwoByteChunk = (TwoByteChunk)_sensorTypes[idx];
            aTwoByteChunk.reflection(sb);
       } // end of list marshalling

           sb.Append("byte\t _pad3\t " + _pad3.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _mineLocation.Count; idx++)
       {
           sb.Append("Vector3Float\t " + _mineLocation[idx] + System.Environment.NewLine);
            Vector3Float aVector3Float = (Vector3Float)_mineLocation[idx];
            aVector3Float.reflection(sb);
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
 public bool equals(MinefieldDataPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_minefieldID.Equals( rhs._minefieldID) )) ivarsEqual = false;
     if( ! (_requestingEntityID.Equals( rhs._requestingEntityID) )) ivarsEqual = false;
     if( ! (_minefieldSequenceNumbeer == rhs._minefieldSequenceNumbeer)) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;
     if( ! (_pduSequenceNumber == rhs._pduSequenceNumber)) ivarsEqual = false;
     if( ! (_numberOfPdus == rhs._numberOfPdus)) ivarsEqual = false;
     if( ! (_numberOfMinesInThisPdu == rhs._numberOfMinesInThisPdu)) ivarsEqual = false;
     if( ! (_numberOfSensorTypes == rhs._numberOfSensorTypes)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_dataFilter == rhs._dataFilter)) ivarsEqual = false;
     if( ! (_mineType.Equals( rhs._mineType) )) ivarsEqual = false;

     for(int idx = 0; idx < _sensorTypes.Count; idx++)
     {
        TwoByteChunk x = (TwoByteChunk)_sensorTypes[idx];
        if( ! ( _sensorTypes[idx].Equals(rhs._sensorTypes[idx]))) ivarsEqual = false;
     }

     if( ! (_pad3 == rhs._pad3)) ivarsEqual = false;

     for(int idx = 0; idx < _mineLocation.Count; idx++)
     {
        Vector3Float x = (Vector3Float)_mineLocation[idx];
        if( ! ( _mineLocation[idx].Equals(rhs._mineLocation[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
