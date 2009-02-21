using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Identifies type of object. This is a shorter version of EntityType that omits the specific and extra fields.
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
public class ObjectType : Object
{
   /** Kind of entity */
   protected byte  _entityKind;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected byte  _domain;

   /** country to which the design of the entity is attributed */
   protected ushort  _country;

   /** category of entity */
   protected byte  _category;

   /** subcategory of entity */
   protected byte  _subcategory;


/** Constructor */
   ///<summary>
   ///Identifies type of object. This is a shorter version of EntityType that omits the specific and extra fields.
   ///</summary>
 public ObjectType()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _entityKind
   marshalSize = marshalSize + 1;  // _domain
   marshalSize = marshalSize + 2;  // _country
   marshalSize = marshalSize + 1;  // _category
   marshalSize = marshalSize + 1;  // _subcategory

   return marshalSize;
}


   ///<summary>
   ///Kind of entity
   ///</summary>
public void setEntityKind(byte pEntityKind)
{ _entityKind = pEntityKind;
}

[XmlElement(Type= typeof(byte), ElementName="entityKind")]
public byte EntityKind
{
     get
{
          return _entityKind;
}
     set
{
          _entityKind = value;
}
}

   ///<summary>
   ///Domain of entity (air, surface, subsurface, space, etc)
   ///</summary>
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

   ///<summary>
   ///country to which the design of the entity is attributed
   ///</summary>
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

   ///<summary>
   ///category of entity
   ///</summary>
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

   ///<summary>
   ///subcategory of entity
   ///</summary>
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


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_entityKind);
       dos.writeByte( (byte)_domain);
       dos.writeUshort( (ushort)_country);
       dos.writeByte( (byte)_category);
       dos.writeByte( (byte)_subcategory);
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
       _entityKind = dis.readByte();
       _domain = dis.readByte();
       _country = dis.readUshort();
       _category = dis.readByte();
       _subcategory = dis.readByte();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
public void reflection(StringBuilder sb)
{
    sb.Append("----- ObjectType-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _entityKind\t " + _entityKind.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _domain\t " + _domain.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _country\t " + _country.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _category\t " + _category.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _subcategory\t " + _subcategory.ToString() + System.Environment.NewLine);
    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
}
    } // end of marshal method

 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public bool equals(ObjectType rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_entityKind == rhs._entityKind)) ivarsEqual = false;
     if( ! (_domain == rhs._domain)) ivarsEqual = false;
     if( ! (_country == rhs._country)) ivarsEqual = false;
     if( ! (_category == rhs._category)) ivarsEqual = false;
     if( ! (_subcategory == rhs._subcategory)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
