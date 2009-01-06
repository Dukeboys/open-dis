using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.12.13: A request for one or more records of data from an entity. COMPLETE
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
[XmlInclude(typeof(FourByteChunk))]
public class RecordQueryReliablePdu : SimulationManagementWithReliabilityFamilyPdu
{
   /** request ID */
   protected uint  _requestID;

   /** level of reliability service used for this transaction */
   protected byte  _requiredReliabilityService;

   /** padding. The spec is unclear and contradictory here. */
   protected ushort  _pad1;

   /** padding */
   protected byte  _pad2;

   /** event type */
   protected ushort  _eventType;

   /** time */
   protected uint  _time;

   /** numberOfRecords */
   protected uint  _numberOfRecords;

   /** record IDs */
   protected List<object> _recordIDs = new List<object>(); 

/** Constructor */
 public RecordQueryReliablePdu()
 {
    PduType = (byte)63;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 4;  // _requestID
   marshalSize = marshalSize + 1;  // _requiredReliabilityService
   marshalSize = marshalSize + 2;  // _pad1
   marshalSize = marshalSize + 1;  // _pad2
   marshalSize = marshalSize + 2;  // _eventType
   marshalSize = marshalSize + 4;  // _time
   marshalSize = marshalSize + 4;  // _numberOfRecords
   for(int idx=0; idx < _recordIDs.Count; idx++)
   {
        FourByteChunk listElement = (FourByteChunk)_recordIDs[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setRequestID(uint pRequestID)
{ _requestID = pRequestID;
}

[XmlElement(Type= typeof(uint), ElementName="requestID")]
public uint RequestID
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

public void setRequiredReliabilityService(byte pRequiredReliabilityService)
{ _requiredReliabilityService = pRequiredReliabilityService;
}

[XmlElement(Type= typeof(byte), ElementName="requiredReliabilityService")]
public byte RequiredReliabilityService
{
     get
{
          return _requiredReliabilityService;
}
     set
{
          _requiredReliabilityService = value;
}
}

public void setPad1(ushort pPad1)
{ _pad1 = pPad1;
}

[XmlElement(Type= typeof(ushort), ElementName="pad1")]
public ushort Pad1
{
     get
{
          return _pad1;
}
     set
{
          _pad1 = value;
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

public void setEventType(ushort pEventType)
{ _eventType = pEventType;
}

[XmlElement(Type= typeof(ushort), ElementName="eventType")]
public ushort EventType
{
     get
{
          return _eventType;
}
     set
{
          _eventType = value;
}
}

public void setTime(uint pTime)
{ _time = pTime;
}

[XmlElement(Type= typeof(uint), ElementName="time")]
public uint Time
{
     get
{
          return _time;
}
     set
{
          _time = value;
}
}

public void setRecordIDs(List<object> pRecordIDs)
{ _recordIDs = pRecordIDs;
}

public List<object> getRecordIDs()
{ return _recordIDs; }

[XmlElement(ElementName = "recordIDsList",Type = typeof(List<object>))]
public List<object> RecordIDs
{
     get
{
          return _recordIDs;
}
     set
{
          _recordIDs = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       dos.writeUint( (uint)_requestID);
       dos.writeByte( (byte)_requiredReliabilityService);
       dos.writeUshort( (ushort)_pad1);
       dos.writeByte( (byte)_pad2);
       dos.writeUshort( (ushort)_eventType);
       dos.writeUint( (uint)_time);
       dos.writeUint( (uint)_recordIDs.Count);

       for(int idx = 0; idx < _recordIDs.Count; idx++)
       {
            FourByteChunk aFourByteChunk = (FourByteChunk)_recordIDs[idx];
            aFourByteChunk.marshal(dos);
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
       _requestID = dis.readUint();
       _requiredReliabilityService = dis.readByte();
       _pad1 = dis.readUshort();
       _pad2 = dis.readByte();
       _eventType = dis.readUshort();
       _time = dis.readUint();
       _numberOfRecords = dis.readUint();
        for(int idx = 0; idx < _numberOfRecords; idx++)
        {
           FourByteChunk anX = new FourByteChunk();
            anX.unmarshal(dis);
            _recordIDs.Add(anX);
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
    sb.Append("----- RecordQueryReliablePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("uint\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _requiredReliabilityService\t " + _requiredReliabilityService.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _pad1\t " + _pad1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _eventType\t " + _eventType.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _time\t " + _time.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _recordIDs\t " + _recordIDs.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _recordIDs.Count; idx++)
       {
           sb.Append("FourByteChunk\t " + _recordIDs[idx] + System.Environment.NewLine);
            FourByteChunk aFourByteChunk = (FourByteChunk)_recordIDs[idx];
            aFourByteChunk.reflection(sb);
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
 public bool equals(RecordQueryReliablePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;
     if( ! (_requiredReliabilityService == rhs._requiredReliabilityService)) ivarsEqual = false;
     if( ! (_pad1 == rhs._pad1)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_eventType == rhs._eventType)) ivarsEqual = false;
     if( ! (_time == rhs._time)) ivarsEqual = false;
     if( ! (_numberOfRecords == rhs._numberOfRecords)) ivarsEqual = false;

     for(int idx = 0; idx < _recordIDs.Count; idx++)
     {
        FourByteChunk x = (FourByteChunk)_recordIDs[idx];
        if( ! ( _recordIDs[idx].Equals(rhs._recordIDs[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
