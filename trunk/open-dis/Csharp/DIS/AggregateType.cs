using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.38. Identifies the type of aggregate including kind of entity, domain (surface, subsurface, air, etc) country, category, etc.
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
public class AggregateType : Object
{
   /** Kind of entity */
   protected byte  _aggregateKind;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected byte  _domain;

   /** country to which the design of the entity is attributed */
   protected ushort  _country;

   /** category of entity */
   protected byte  _category;

   /** subcategory of entity */
   protected byte  _subcategory;

   /** specific info based on subcategory field */
   protected byte  _specific;

   protected byte  _extra;


/** Constructor */
 public AggregateType()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _aggregateKind
   marshalSize = marshalSize + 1;  // _domain
   marshalSize = marshalSize + 2;  // _country
   marshalSize = marshalSize + 1;  // _category
   marshalSize = marshalSize + 1;  // _subcategory
   marshalSize = marshalSize + 1;  // _specific
   marshalSize = marshalSize + 1;  // _extra

   return marshalSize;
}


public void setAggregateKind(byte pAggregateKind)
{ _aggregateKind = pAggregateKind;
}

[XmlElement(Type= typeof(byte), ElementName="aggregateKind")]
public byte AggregateKind
{
     get
{
          return _aggregateKind;
}
     set
{
          _aggregateKind = value;
}
}

public void setDomain(byte pDomain)
{ _domain = pDomain;
}

[XmlElement(Type= typeof(byte), ElementName="domain")]
public byte Domain
{
     get
{
          return _domain;
}
     set
{
          _domain = value;
}
}

public void setCountry(ushort pCountry)
{ _country = pCountry;
}

[XmlElement(Type= typeof(ushort), ElementName="country")]
public ushort Country
{
     get
{
          return _country;
}
     set
{
          _country = value;
}
}

public void setCategory(byte pCategory)
{ _category = pCategory;
}

[XmlElement(Type= typeof(byte), ElementName="category")]
public byte Category
{
     get
{
          return _category;
}
     set
{
          _category = value;
}
}

public void setSubcategory(byte pSubcategory)
{ _subcategory = pSubcategory;
}

[XmlElement(Type= typeof(byte), ElementName="subcategory")]
public byte Subcategory
{
     get
{
          return _subcategory;
}
     set
{
          _subcategory = value;
}
}

public void setSpecific(byte pSpecific)
{ _specific = pSpecific;
}

[XmlElement(Type= typeof(byte), ElementName="specific")]
public byte Specific
{
     get
{
          return _specific;
}
     set
{
          _specific = value;
}
}

public void setExtra(byte pExtra)
{ _extra = pExtra;
}

[XmlElement(Type= typeof(byte), ElementName="extra")]
public byte Extra
{
     get
{
          return _extra;
}
     set
{
          _extra = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_aggregateKind);
       dos.writeByte( (byte)_domain);
       dos.writeUshort( (ushort)_country);
       dos.writeByte( (byte)_category);
       dos.writeByte( (byte)_subcategory);
       dos.writeByte( (byte)_specific);
       dos.writeByte( (byte)_extra);
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
       _aggregateKind = dis.readByte();
       _domain = dis.readByte();
       _country = dis.readUshort();
       _category = dis.readByte();
       _subcategory = dis.readByte();
       _specific = dis.readByte();
       _extra = dis.readByte();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- AggregateType-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _aggregateKind\t " + _aggregateKind.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _domain\t " + _domain.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _country\t " + _country.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _category\t " + _category.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _subcategory\t " + _subcategory.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _specific\t " + _specific.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _extra\t " + _extra.ToString() + System.Environment.NewLine);
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
 public bool equals(AggregateType rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_aggregateKind == rhs._aggregateKind)) ivarsEqual = false;
     if( ! (_domain == rhs._domain)) ivarsEqual = false;
     if( ! (_country == rhs._country)) ivarsEqual = false;
     if( ! (_category == rhs._category)) ivarsEqual = false;
     if( ! (_subcategory == rhs._subcategory)) ivarsEqual = false;
     if( ! (_specific == rhs._specific)) ivarsEqual = false;
     if( ! (_extra == rhs._extra)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
