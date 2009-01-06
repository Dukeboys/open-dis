using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.8.3. Communication of a receiver state. COMPLETE
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
public class ReceiverPdu : RadioCommunicationsFamilyPdu
{
   /** encoding scheme used, and enumeration */
   protected ushort  _receiverState;

   /** padding */
   protected ushort  _padding1;

   /** received power */
   protected float  _receivedPoser;

   /** ID of transmitter */
   protected EntityID  _transmitterEntityId = new EntityID(); 

   /** ID of transmitting radio */
   protected ushort  _transmitterRadioId;


/** Constructor */
 public ReceiverPdu()
 {
    PduType = (byte)27;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 2;  // _receiverState
   marshalSize = marshalSize + 2;  // _padding1
   marshalSize = marshalSize + 4;  // _receivedPoser
   marshalSize = marshalSize + _transmitterEntityId.getMarshalledSize();  // _transmitterEntityId
   marshalSize = marshalSize + 2;  // _transmitterRadioId

   return marshalSize;
}


public void setReceiverState(ushort pReceiverState)
{ _receiverState = pReceiverState;
}

[XmlElement(Type= typeof(ushort), ElementName="receiverState")]
public ushort ReceiverState
{
     get
{
          return _receiverState;
}
     set
{
          _receiverState = value;
}
}

public void setPadding1(ushort pPadding1)
{ _padding1 = pPadding1;
}

[XmlElement(Type= typeof(ushort), ElementName="padding1")]
public ushort Padding1
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

public void setReceivedPoser(float pReceivedPoser)
{ _receivedPoser = pReceivedPoser;
}

[XmlElement(Type= typeof(float), ElementName="receivedPoser")]
public float ReceivedPoser
{
     get
{
          return _receivedPoser;
}
     set
{
          _receivedPoser = value;
}
}

public void setTransmitterEntityId(EntityID pTransmitterEntityId)
{ _transmitterEntityId = pTransmitterEntityId;
}

public EntityID getTransmitterEntityId()
{ return _transmitterEntityId; 
}

[XmlElement(Type= typeof(EntityID), ElementName="transmitterEntityId")]
public EntityID TransmitterEntityId
{
     get
{
          return _transmitterEntityId;
}
     set
{
          _transmitterEntityId = value;
}
}

public void setTransmitterRadioId(ushort pTransmitterRadioId)
{ _transmitterRadioId = pTransmitterRadioId;
}

[XmlElement(Type= typeof(ushort), ElementName="transmitterRadioId")]
public ushort TransmitterRadioId
{
     get
{
          return _transmitterRadioId;
}
     set
{
          _transmitterRadioId = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       dos.writeUshort( (ushort)_receiverState);
       dos.writeUshort( (ushort)_padding1);
       dos.writeFloat( (float)_receivedPoser);
       _transmitterEntityId.marshal(dos);
       dos.writeUshort( (ushort)_transmitterRadioId);
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
       _receiverState = dis.readUshort();
       _padding1 = dis.readUshort();
       _receivedPoser = dis.readFloat();
       _transmitterEntityId.unmarshal(dis);
       _transmitterRadioId = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- ReceiverPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("ushort\t _receiverState\t " + _receiverState.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
           sb.Append("float\t _receivedPoser\t " + _receivedPoser.ToString() + System.Environment.NewLine);
       sb.Append("=====_transmitterEntityId=====" + System.Environment.NewLine);
       _transmitterEntityId.reflection(sb);
           sb.Append("ushort\t _transmitterRadioId\t " + _transmitterRadioId.ToString() + System.Environment.NewLine);
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
 public bool equals(ReceiverPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_receiverState == rhs._receiverState)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_receivedPoser == rhs._receivedPoser)) ivarsEqual = false;
     if( ! (_transmitterEntityId.Equals( rhs._transmitterEntityId) )) ivarsEqual = false;
     if( ! (_transmitterRadioId == rhs._transmitterRadioId)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
