using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.12.4: Stop freeze simulation, relaible. COMPLETE
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
[XmlInclude(typeof(ClockTime))]
public class StopFreezeReliablePdu : SimulationManagementWithReliabilityFamilyPdu
{
   /** time in real world for this operation to happen */
   protected ClockTime  _realWorldTime = new ClockTime(); 

   /** Reason for stopping/freezing simulation */
   protected byte  _reason;

   /** internal behvior of the simulation while frozen */
   protected byte  _frozenBehavior;

   /** reliablity level */
   protected byte  _requiredReliablityService;

   /** padding */
   protected byte  _pad1;

   /** Request ID */
   protected uint  _requestID;


/** Constructor */
 public StopFreezeReliablePdu()
 {
    PduType = (byte)54;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _realWorldTime.getMarshalledSize();  // _realWorldTime
   marshalSize = marshalSize + 1;  // _reason
   marshalSize = marshalSize + 1;  // _frozenBehavior
   marshalSize = marshalSize + 1;  // _requiredReliablityService
   marshalSize = marshalSize + 1;  // _pad1
   marshalSize = marshalSize + 4;  // _requestID

   return marshalSize;
}


public void setRealWorldTime(ClockTime pRealWorldTime)
{ _realWorldTime = pRealWorldTime;
}

public ClockTime getRealWorldTime()
{ return _realWorldTime; 
}

[XmlElement(Type= typeof(ClockTime), ElementName="realWorldTime")]
public ClockTime RealWorldTime
{
     get
{
          return _realWorldTime;
}
     set
{
          _realWorldTime = value;
}
}

public void setReason(byte pReason)
{ _reason = pReason;
}

[XmlElement(Type= typeof(byte), ElementName="reason")]
public byte Reason
{
     get
{
          return _reason;
}
     set
{
          _reason = value;
}
}

public void setFrozenBehavior(byte pFrozenBehavior)
{ _frozenBehavior = pFrozenBehavior;
}

[XmlElement(Type= typeof(byte), ElementName="frozenBehavior")]
public byte FrozenBehavior
{
     get
{
          return _frozenBehavior;
}
     set
{
          _frozenBehavior = value;
}
}

public void setRequiredReliablityService(byte pRequiredReliablityService)
{ _requiredReliablityService = pRequiredReliablityService;
}

[XmlElement(Type= typeof(byte), ElementName="requiredReliablityService")]
public byte RequiredReliablityService
{
     get
{
          return _requiredReliablityService;
}
     set
{
          _requiredReliablityService = value;
}
}

public void setPad1(byte pPad1)
{ _pad1 = pPad1;
}

[XmlElement(Type= typeof(byte), ElementName="pad1")]
public byte Pad1
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


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _realWorldTime.marshal(dos);
       dos.writeByte( (byte)_reason);
       dos.writeByte( (byte)_frozenBehavior);
       dos.writeByte( (byte)_requiredReliablityService);
       dos.writeByte( (byte)_pad1);
       dos.writeUint( (uint)_requestID);
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
       _realWorldTime.unmarshal(dis);
       _reason = dis.readByte();
       _frozenBehavior = dis.readByte();
       _requiredReliablityService = dis.readByte();
       _pad1 = dis.readByte();
       _requestID = dis.readUint();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- StopFreezeReliablePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_realWorldTime=====" + System.Environment.NewLine);
       _realWorldTime.reflection(sb);
           sb.Append("byte\t _reason\t " + _reason.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _frozenBehavior\t " + _frozenBehavior.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _requiredReliablityService\t " + _requiredReliablityService.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad1\t " + _pad1.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
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
 public bool equals(StopFreezeReliablePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_realWorldTime.Equals( rhs._realWorldTime) )) ivarsEqual = false;
     if( ! (_reason == rhs._reason)) ivarsEqual = false;
     if( ! (_frozenBehavior == rhs._frozenBehavior)) ivarsEqual = false;
     if( ! (_requiredReliablityService == rhs._requiredReliablityService)) ivarsEqual = false;
     if( ! (_pad1 == rhs._pad1)) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
