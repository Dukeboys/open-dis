using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.7. Specifies the type of muntion fired, the type of warhead, the         type of fuse, the number of rounds fired, and the rate at which the roudns are fired in         rounds per minute.
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
[XmlInclude(typeof(EntityType))]
public class BurstDescriptor : Object
{
   /** What munition was used in the burst */
   protected EntityType  _munition = new EntityType(); 

   /** type of warhead */
   protected ushort  _warhead;

   /** type of fuse used */
   protected ushort  _fuse;

   /** how many of the munition were fired */
   protected ushort  _quantity;

   /** rate at which the munition was fired */
   protected ushort  _rate;


/** Constructor */
 public BurstDescriptor()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + _munition.getMarshalledSize();  // _munition
   marshalSize = marshalSize + 2;  // _warhead
   marshalSize = marshalSize + 2;  // _fuse
   marshalSize = marshalSize + 2;  // _quantity
   marshalSize = marshalSize + 2;  // _rate

   return marshalSize;
}


public void setMunition(EntityType pMunition)
{ _munition = pMunition;
}

public EntityType getMunition()
{ return _munition; 
}

[XmlElement(Type= typeof(EntityType), ElementName="munition")]
public EntityType Munition
{
     get
{
          return _munition;
}
     set
{
          _munition = value;
}
}

public void setWarhead(ushort pWarhead)
{ _warhead = pWarhead;
}

[XmlElement(Type= typeof(ushort), ElementName="warhead")]
public ushort Warhead
{
     get
{
          return _warhead;
}
     set
{
          _warhead = value;
}
}

public void setFuse(ushort pFuse)
{ _fuse = pFuse;
}

[XmlElement(Type= typeof(ushort), ElementName="fuse")]
public ushort Fuse
{
     get
{
          return _fuse;
}
     set
{
          _fuse = value;
}
}

public void setQuantity(ushort pQuantity)
{ _quantity = pQuantity;
}

[XmlElement(Type= typeof(ushort), ElementName="quantity")]
public ushort Quantity
{
     get
{
          return _quantity;
}
     set
{
          _quantity = value;
}
}

public void setRate(ushort pRate)
{ _rate = pRate;
}

[XmlElement(Type= typeof(ushort), ElementName="rate")]
public ushort Rate
{
     get
{
          return _rate;
}
     set
{
          _rate = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       _munition.marshal(dos);
       dos.writeUshort( (ushort)_warhead);
       dos.writeUshort( (ushort)_fuse);
       dos.writeUshort( (ushort)_quantity);
       dos.writeUshort( (ushort)_rate);
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
       _munition.unmarshal(dis);
       _warhead = dis.readUshort();
       _fuse = dis.readUshort();
       _quantity = dis.readUshort();
       _rate = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- BurstDescriptor-----"  + System.Environment.NewLine);
    try 
    {
       sb.Append("=====_munition=====" + System.Environment.NewLine);
       _munition.reflection(sb);
           sb.Append("ushort\t _warhead\t " + _warhead.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _fuse\t " + _fuse.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _quantity\t " + _quantity.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _rate\t " + _rate.ToString() + System.Environment.NewLine);
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
 public bool equals(BurstDescriptor rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_munition.Equals( rhs._munition) )) ivarsEqual = false;
     if( ! (_warhead == rhs._warhead)) ivarsEqual = false;
     if( ! (_fuse == rhs._fuse)) ivarsEqual = false;
     if( ! (_quantity == rhs._quantity)) ivarsEqual = false;
     if( ! (_rate == rhs._rate)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
