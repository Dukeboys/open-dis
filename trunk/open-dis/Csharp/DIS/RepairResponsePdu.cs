using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.5.6. Sent after repair complete PDU. COMPLETE
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
public class RepairResponsePdu : LogisticsFamilyPdu
{
   /** Entity that is receiving service */
   protected EntityID  _receivingEntityID = new EntityID(); 

   /** Entity that is supplying */
   protected EntityID  _repairingEntityID = new EntityID(); 

   /** Result of repair operation */
   protected byte  _repairResult;

   /** padding */
   protected short  _padding1 = 0;

   /** padding */
   protected byte  _padding2 = 0;


/** Constructor */
 public RepairResponsePdu()
 {
    PduType = (byte)10;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _receivingEntityID.getMarshalledSize();  // _receivingEntityID
   marshalSize = marshalSize + _repairingEntityID.getMarshalledSize();  // _repairingEntityID
   marshalSize = marshalSize + 1;  // _repairResult
   marshalSize = marshalSize + 2;  // _padding1
   marshalSize = marshalSize + 1;  // _padding2

   return marshalSize;
}


public void setReceivingEntityID(EntityID pReceivingEntityID)
{ _receivingEntityID = pReceivingEntityID;
}

public EntityID getReceivingEntityID()
{ return _receivingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="receivingEntityID")]
public EntityID ReceivingEntityID
{
     get
{
          return _receivingEntityID;
}
     set
{
          _receivingEntityID = value;
}
}

public void setRepairingEntityID(EntityID pRepairingEntityID)
{ _repairingEntityID = pRepairingEntityID;
}

public EntityID getRepairingEntityID()
{ return _repairingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="repairingEntityID")]
public EntityID RepairingEntityID
{
     get
{
          return _repairingEntityID;
}
     set
{
          _repairingEntityID = value;
}
}

public void setRepairResult(byte pRepairResult)
{ _repairResult = pRepairResult;
}

[XmlElement(Type= typeof(byte), ElementName="repairResult")]
public byte RepairResult
{
     get
{
          return _repairResult;
}
     set
{
          _repairResult = value;
}
}

public void setPadding1(short pPadding1)
{ _padding1 = pPadding1;
}

[XmlElement(Type= typeof(short), ElementName="padding1")]
public short Padding1
{
     get
{
          return _padding1;
}
     set
{
          _padding1 = value;
}
}

public void setPadding2(byte pPadding2)
{ _padding2 = pPadding2;
}

[XmlElement(Type= typeof(byte), ElementName="padding2")]
public byte Padding2
{
     get
{
          return _padding2;
}
     set
{
          _padding2 = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _receivingEntityID.marshal(dos);
       _repairingEntityID.marshal(dos);
       dos.writeByte( (byte)_repairResult);
       dos.writeShort( (short)_padding1);
       dos.writeByte( (byte)_padding2);
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
       _receivingEntityID.unmarshal(dis);
       _repairingEntityID.unmarshal(dis);
       _repairResult = dis.readByte();
       _padding1 = dis.readShort();
       _padding2 = dis.readByte();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- RepairResponsePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_receivingEntityID=====" + System.Environment.NewLine);
       _receivingEntityID.reflection(sb);
       sb.Append("=====_repairingEntityID=====" + System.Environment.NewLine);
       _repairingEntityID.reflection(sb);
           sb.Append("byte\t _repairResult\t " + _repairResult.ToString() + System.Environment.NewLine);
           sb.Append("short\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _padding2\t " + _padding2.ToString() + System.Environment.NewLine);
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
 public bool equals(RepairResponsePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_receivingEntityID.Equals( rhs._receivingEntityID) )) ivarsEqual = false;
     if( ! (_repairingEntityID.Equals( rhs._repairingEntityID) )) ivarsEqual = false;
     if( ! (_repairResult == rhs._repairResult)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_padding2 == rhs._padding2)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
