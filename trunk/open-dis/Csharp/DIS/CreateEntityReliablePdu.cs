using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.12.1: creation of an entity , reliable. COMPLETE
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
public class CreateEntityReliablePdu : SimulationManagementWithReliabilityFamilyPdu
{
   /** level of reliability service used for this transaction */
   protected byte  _requiredReliabilityService;

   /** padding */
   protected ushort  _pad1;

   /** padding */
   protected byte  _pad2;

   /** Request ID */
   protected uint  _requestID;


/** Constructor */
 public CreateEntityReliablePdu()
 {
    PduType = (byte)51;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 1;  // _requiredReliabilityService
   marshalSize = marshalSize + 2;  // _pad1
   marshalSize = marshalSize + 1;  // _pad2
   marshalSize = marshalSize + 4;  // _requestID

   return marshalSize;
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
       dos.writeByte( (byte)_requiredReliabilityService);
       dos.writeUshort( (ushort)_pad1);
       dos.writeByte( (byte)_pad2);
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
       _requiredReliabilityService = dis.readByte();
       _pad1 = dis.readUshort();
       _pad2 = dis.readByte();
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
    sb.Append("----- CreateEntityReliablePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("byte\t _requiredReliabilityService\t " + _requiredReliabilityService.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _pad1\t " + _pad1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
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
 public bool equals(CreateEntityReliablePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_requiredReliabilityService == rhs._requiredReliabilityService)) ivarsEqual = false;
     if( ! (_pad1 == rhs._pad1)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
