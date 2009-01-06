using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * The superclass for all PDUs. This incorporates the PduHeader record, section 5.2.29.
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
public class Pdu : Object
{
   /** The version of the protocol. 5=DIS-1995, 6=DIS-1998. */
   protected byte  _protocolVersion = 6;

   /** Exercise ID */
   protected byte  _exerciseID = 0;

   /** Type of pdu, unique for each PDU class */
   protected byte  _pduType;

   /** value that refers to the protocol family, eg SimulationManagement, et */
   protected byte  _protocolFamily;

   /** Timestamp value */
   protected uint  _timestamp;

   /** Length, in bytes, of the PDU */
   protected ushort  _length;

   /** zero-filled array of padding */
   protected short  _padding = 0;


/** Constructor */
 public Pdu()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _protocolVersion
   marshalSize = marshalSize + 1;  // _exerciseID
   marshalSize = marshalSize + 1;  // _pduType
   marshalSize = marshalSize + 1;  // _protocolFamily
   marshalSize = marshalSize + 4;  // _timestamp
   marshalSize = marshalSize + 2;  // _length
   marshalSize = marshalSize + 2;  // _padding

   return marshalSize;
}


public void setProtocolVersion(byte pProtocolVersion)
{ _protocolVersion = pProtocolVersion;
}

[XmlElement(Type= typeof(byte), ElementName="protocolVersion")]
public byte ProtocolVersion
{
     get
{
          return _protocolVersion;
}
     set
{
          _protocolVersion = value;
}
}

public void setExerciseID(byte pExerciseID)
{ _exerciseID = pExerciseID;
}

[XmlElement(Type= typeof(byte), ElementName="exerciseID")]
public byte ExerciseID
{
     get
{
          return _exerciseID;
}
     set
{
          _exerciseID = value;
}
}

public void setPduType(byte pPduType)
{ _pduType = pPduType;
}

[XmlElement(Type= typeof(byte), ElementName="pduType")]
public byte PduType
{
     get
{
          return _pduType;
}
     set
{
          _pduType = value;
}
}

public void setProtocolFamily(byte pProtocolFamily)
{ _protocolFamily = pProtocolFamily;
}

[XmlElement(Type= typeof(byte), ElementName="protocolFamily")]
public byte ProtocolFamily
{
     get
{
          return _protocolFamily;
}
     set
{
          _protocolFamily = value;
}
}

public void setTimestamp(uint pTimestamp)
{ _timestamp = pTimestamp;
}

[XmlElement(Type= typeof(uint), ElementName="timestamp")]
public uint Timestamp
{
     get
{
          return _timestamp;
}
     set
{
          _timestamp = value;
}
}

public void setLength(ushort pLength)
{ _length = pLength;
}

[XmlElement(Type= typeof(ushort), ElementName="length")]
public ushort Length
{
     get
{
          return _length;
}
     set
{
          _length = value;
}
}

public void setPadding(short pPadding)
{ _padding = pPadding;
}

[XmlElement(Type= typeof(short), ElementName="padding")]
public short Padding
{
     get
{
          return _padding;
}
     set
{
          _padding = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_protocolVersion);
       dos.writeByte( (byte)_exerciseID);
       dos.writeByte( (byte)_pduType);
       dos.writeByte( (byte)_protocolFamily);
       dos.writeUint( (uint)_timestamp);
       dos.writeUshort( (ushort)_length);
       dos.writeShort( (short)_padding);
    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
    }
} // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       _protocolVersion = dis.readByte();
       _exerciseID = dis.readByte();
       _pduType = dis.readByte();
       _protocolFamily = dis.readByte();
       _timestamp = dis.readUint();
       _length = dis.readUshort();
       _padding = dis.readShort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- Pdu-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _protocolVersion\t " + _protocolVersion.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _exerciseID\t " + _exerciseID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pduType\t " + _pduType.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _protocolFamily\t " + _protocolFamily.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _timestamp\t " + _timestamp.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _length\t " + _length.ToString() + System.Environment.NewLine);
           sb.Append("short\t _padding\t " + _padding.ToString() + System.Environment.NewLine);
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
 public bool equals(Pdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_protocolVersion == rhs._protocolVersion)) ivarsEqual = false;
     if( ! (_exerciseID == rhs._exerciseID)) ivarsEqual = false;
     if( ! (_pduType == rhs._pduType)) ivarsEqual = false;
     if( ! (_protocolFamily == rhs._protocolFamily)) ivarsEqual = false;
     if( ! (_timestamp == rhs._timestamp)) ivarsEqual = false;
     if( ! (_length == rhs._length)) ivarsEqual = false;
     if( ! (_padding == rhs._padding)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
