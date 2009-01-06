using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.5.5. Repair is complete. COMPLETE
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
public class RepairCompletePdu : LogisticsFamilyPdu
{
   /** Entity that is receiving service */
   protected EntityID  _receivingEntityID = new EntityID(); 

   /** Entity that is supplying */
   protected EntityID  _repairingEntityID = new EntityID(); 

   /** Enumeration for type of repair */
   protected ushort  _repair;

   /** padding */
   protected short  _padding = 0;


/** Constructor */
 public RepairCompletePdu()
 {
    PduType = (byte)9;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _receivingEntityID.getMarshalledSize();  // _receivingEntityID
   marshalSize = marshalSize + _repairingEntityID.getMarshalledSize();  // _repairingEntityID
   marshalSize = marshalSize + 2;  // _repair
   marshalSize = marshalSize + 2;  // _padding

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

public void setRepair(ushort pRepair)
{ _repair = pRepair;
}

[XmlElement(Type= typeof(ushort), ElementName="repair")]
public ushort Repair
{
     get
{
          return _repair;
}
     set
{
          _repair = value;
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
    base.marshal(dos);
    try 
    {
       _receivingEntityID.marshal(dos);
       _repairingEntityID.marshal(dos);
       dos.writeUshort( (ushort)_repair);
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
    base.unmarshal(dis);

    try 
    {
       _receivingEntityID.unmarshal(dis);
       _repairingEntityID.unmarshal(dis);
       _repair = dis.readUshort();
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
    sb.Append("----- RepairCompletePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_receivingEntityID=====" + System.Environment.NewLine);
       _receivingEntityID.reflection(sb);
       sb.Append("=====_repairingEntityID=====" + System.Environment.NewLine);
       _repairingEntityID.reflection(sb);
           sb.Append("ushort\t _repair\t " + _repair.ToString() + System.Environment.NewLine);
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
 public bool equals(RepairCompletePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_receivingEntityID.Equals( rhs._receivingEntityID) )) ivarsEqual = false;
     if( ! (_repairingEntityID.Equals( rhs._repairingEntityID) )) ivarsEqual = false;
     if( ! (_repair == rhs._repair)) ivarsEqual = false;
     if( ! (_padding == rhs._padding)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
