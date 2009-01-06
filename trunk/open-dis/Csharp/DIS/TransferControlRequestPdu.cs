using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.9.3 Information initiating the dyanic allocation and control of simulation entities         between two simulation applications. Requires manual cleanup. The padding between record sets is variable. UNFINISHED
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
[XmlInclude(typeof(RecordSet))]
public class TransferControlRequestPdu : EntityManagementFamilyPdu
{
   /** ID of entity originating request */
   protected EntityID  _orginatingEntityID = new EntityID(); 

   /** ID of entity receiving request */
   protected EntityID  _recevingEntityID = new EntityID(); 

   /** ID ofrequest */
   protected uint  _requestID;

   /** required level of reliabliity service. */
   protected byte  _requiredReliabilityService;

   /** type of transfer desired */
   protected byte  _tranferType;

   /** The entity for which control is being requested to transfer */
   protected EntityID  _transferEntityID = new EntityID(); 

   /** number of record sets to transfer */
   protected byte  _numberOfRecordSets;

   /** @@@This is wrong--the RecordSet class needs more work */
   protected List<object> _recordSets = new List<object>(); 

/** Constructor */
 public TransferControlRequestPdu()
 {
    PduType = (byte)35;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _orginatingEntityID.getMarshalledSize();  // _orginatingEntityID
   marshalSize = marshalSize + _recevingEntityID.getMarshalledSize();  // _recevingEntityID
   marshalSize = marshalSize + 4;  // _requestID
   marshalSize = marshalSize + 1;  // _requiredReliabilityService
   marshalSize = marshalSize + 1;  // _tranferType
   marshalSize = marshalSize + _transferEntityID.getMarshalledSize();  // _transferEntityID
   marshalSize = marshalSize + 1;  // _numberOfRecordSets
   for(int idx=0; idx < _recordSets.Count; idx++)
   {
        RecordSet listElement = (RecordSet)_recordSets[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setOrginatingEntityID(EntityID pOrginatingEntityID)
{ _orginatingEntityID = pOrginatingEntityID;
}

public EntityID getOrginatingEntityID()
{ return _orginatingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="orginatingEntityID")]
public EntityID OrginatingEntityID
{
     get
{
          return _orginatingEntityID;
}
     set
{
          _orginatingEntityID = value;
}
}

public void setRecevingEntityID(EntityID pRecevingEntityID)
{ _recevingEntityID = pRecevingEntityID;
}

public EntityID getRecevingEntityID()
{ return _recevingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="recevingEntityID")]
public EntityID RecevingEntityID
{
     get
{
          return _recevingEntityID;
}
     set
{
          _recevingEntityID = value;
}
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

public void setTranferType(byte pTranferType)
{ _tranferType = pTranferType;
}

[XmlElement(Type= typeof(byte), ElementName="tranferType")]
public byte TranferType
{
     get
{
          return _tranferType;
}
     set
{
          _tranferType = value;
}
}

public void setTransferEntityID(EntityID pTransferEntityID)
{ _transferEntityID = pTransferEntityID;
}

public EntityID getTransferEntityID()
{ return _transferEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="transferEntityID")]
public EntityID TransferEntityID
{
     get
{
          return _transferEntityID;
}
     set
{
          _transferEntityID = value;
}
}

public void setRecordSets(List<object> pRecordSets)
{ _recordSets = pRecordSets;
}

public List<object> getRecordSets()
{ return _recordSets; }

[XmlElement(ElementName = "recordSetsList",Type = typeof(List<object>))]
public List<object> RecordSets
{
     get
{
          return _recordSets;
}
     set
{
          _recordSets = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _orginatingEntityID.marshal(dos);
       _recevingEntityID.marshal(dos);
       dos.writeUint( (uint)_requestID);
       dos.writeByte( (byte)_requiredReliabilityService);
       dos.writeByte( (byte)_tranferType);
       _transferEntityID.marshal(dos);
       dos.writeByte( (byte)_recordSets.Count);

       for(int idx = 0; idx < _recordSets.Count; idx++)
       {
            RecordSet aRecordSet = (RecordSet)_recordSets[idx];
            aRecordSet.marshal(dos);
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
       _orginatingEntityID.unmarshal(dis);
       _recevingEntityID.unmarshal(dis);
       _requestID = dis.readUint();
       _requiredReliabilityService = dis.readByte();
       _tranferType = dis.readByte();
       _transferEntityID.unmarshal(dis);
       _numberOfRecordSets = dis.readByte();
        for(int idx = 0; idx < _numberOfRecordSets; idx++)
        {
           RecordSet anX = new RecordSet();
            anX.unmarshal(dis);
            _recordSets.Add(anX);
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
    sb.Append("----- TransferControlRequestPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_orginatingEntityID=====" + System.Environment.NewLine);
       _orginatingEntityID.reflection(sb);
       sb.Append("=====_recevingEntityID=====" + System.Environment.NewLine);
       _recevingEntityID.reflection(sb);
           sb.Append("uint\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _requiredReliabilityService\t " + _requiredReliabilityService.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _tranferType\t " + _tranferType.ToString() + System.Environment.NewLine);
       sb.Append("=====_transferEntityID=====" + System.Environment.NewLine);
       _transferEntityID.reflection(sb);
           sb.Append("byte\t _recordSets\t " + _recordSets.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _recordSets.Count; idx++)
       {
           sb.Append("RecordSet\t " + _recordSets[idx] + System.Environment.NewLine);
            RecordSet aRecordSet = (RecordSet)_recordSets[idx];
            aRecordSet.reflection(sb);
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
 public bool equals(TransferControlRequestPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_orginatingEntityID.Equals( rhs._orginatingEntityID) )) ivarsEqual = false;
     if( ! (_recevingEntityID.Equals( rhs._recevingEntityID) )) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;
     if( ! (_requiredReliabilityService == rhs._requiredReliabilityService)) ivarsEqual = false;
     if( ! (_tranferType == rhs._tranferType)) ivarsEqual = false;
     if( ! (_transferEntityID.Equals( rhs._transferEntityID) )) ivarsEqual = false;
     if( ! (_numberOfRecordSets == rhs._numberOfRecordSets)) ivarsEqual = false;

     for(int idx = 0; idx < _recordSets.Count; idx++)
     {
        RecordSet x = (RecordSet)_recordSets[idx];
        if( ! ( _recordSets[idx].Equals(rhs._recordSets[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
