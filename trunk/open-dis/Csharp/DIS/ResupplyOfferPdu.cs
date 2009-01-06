using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.5.2. Information about a request for supplies. COMPLETE
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
[XmlInclude(typeof(SupplyQuantity))]
public class ResupplyOfferPdu : LogisticsFamilyPdu
{
   /** Entity that is receiving service */
   protected EntityID  _receivingEntityID = new EntityID(); 

   /** Entity that is supplying */
   protected EntityID  _supplyingEntityID = new EntityID(); 

   /** how many supplies are being offered */
   protected byte  _numberOfSupplyTypes;

   /** padding */
   protected short  _padding1 = 0;

   /** padding */
   protected byte  _padding2 = 0;

   protected List<object> _supplies = new List<object>(); 

/** Constructor */
 public ResupplyOfferPdu()
 {
    PduType = (byte)6;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _receivingEntityID.getMarshalledSize();  // _receivingEntityID
   marshalSize = marshalSize + _supplyingEntityID.getMarshalledSize();  // _supplyingEntityID
   marshalSize = marshalSize + 1;  // _numberOfSupplyTypes
   marshalSize = marshalSize + 2;  // _padding1
   marshalSize = marshalSize + 1;  // _padding2
   for(int idx=0; idx < _supplies.Count; idx++)
   {
        SupplyQuantity listElement = (SupplyQuantity)_supplies[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

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

public void setSupplyingEntityID(EntityID pSupplyingEntityID)
{ _supplyingEntityID = pSupplyingEntityID;
}

public EntityID getSupplyingEntityID()
{ return _supplyingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="supplyingEntityID")]
public EntityID SupplyingEntityID
{
     get
{
          return _supplyingEntityID;
}
     set
{
          _supplyingEntityID = value;
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

public void setSupplies(List<object> pSupplies)
{ _supplies = pSupplies;
}

public List<object> getSupplies()
{ return _supplies; }

[XmlElement(ElementName = "suppliesList",Type = typeof(List<object>))]
public List<object> Supplies
{
     get
{
          return _supplies;
}
     set
{
          _supplies = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _receivingEntityID.marshal(dos);
       _supplyingEntityID.marshal(dos);
       dos.writeByte( (byte)_supplies.Count);
       dos.writeShort( (short)_padding1);
       dos.writeByte( (byte)_padding2);

       for(int idx = 0; idx < _supplies.Count; idx++)
       {
            SupplyQuantity aSupplyQuantity = (SupplyQuantity)_supplies[idx];
            aSupplyQuantity.marshal(dos);
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
       _receivingEntityID.unmarshal(dis);
       _supplyingEntityID.unmarshal(dis);
       _numberOfSupplyTypes = dis.readByte();
       _padding1 = dis.readShort();
       _padding2 = dis.readByte();
        for(int idx = 0; idx < _numberOfSupplyTypes; idx++)
        {
           SupplyQuantity anX = new SupplyQuantity();
            anX.unmarshal(dis);
            _supplies.Add(anX);
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
    sb.Append("----- ResupplyOfferPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_receivingEntityID=====" + System.Environment.NewLine);
       _receivingEntityID.reflection(sb);
       sb.Append("=====_supplyingEntityID=====" + System.Environment.NewLine);
       _supplyingEntityID.reflection(sb);
           sb.Append("byte\t _supplies\t " + _supplies.Count.ToString() + System.Environment.NewLine);
           sb.Append("short\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _padding2\t " + _padding2.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _supplies.Count; idx++)
       {
           sb.Append("SupplyQuantity\t " + _supplies[idx] + System.Environment.NewLine);
            SupplyQuantity aSupplyQuantity = (SupplyQuantity)_supplies[idx];
            aSupplyQuantity.reflection(sb);
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
 public bool equals(ResupplyOfferPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_receivingEntityID.Equals( rhs._receivingEntityID) )) ivarsEqual = false;
     if( ! (_supplyingEntityID.Equals( rhs._supplyingEntityID) )) ivarsEqual = false;
     if( ! (_numberOfSupplyTypes == rhs._numberOfSupplyTypes)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_padding2 == rhs._padding2)) ivarsEqual = false;

     for(int idx = 0; idx < _supplies.Count; idx++)
     {
        SupplyQuantity x = (SupplyQuantity)_supplies[idx];
        if( ! ( _supplies[idx].Equals(rhs._supplies[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
