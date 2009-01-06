using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.25. Identifies the type of radio
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
public class RadioEntityType : Object
{
   /** Kind of entity */
   protected byte  _entityKind;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected byte  _domain;

   /** country to which the design of the entity is attributed */
   protected ushort  _country;

   /** category of entity */
   protected byte  _category;

   /** specific info based on subcategory field */
   protected byte  _nomenclatureVersion;

   protected ushort  _nomenclature;


/** Constructor */
 public RadioEntityType()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _entityKind
   marshalSize = marshalSize + 1;  // _domain
   marshalSize = marshalSize + 2;  // _country
   marshalSize = marshalSize + 1;  // _category
   marshalSize = marshalSize + 1;  // _nomenclatureVersion
   marshalSize = marshalSize + 2;  // _nomenclature

   return marshalSize;
}


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

public void setNomenclatureVersion(byte pNomenclatureVersion)
{ _nomenclatureVersion = pNomenclatureVersion;
}

[XmlElement(Type= typeof(byte), ElementName="nomenclatureVersion")]
public byte NomenclatureVersion
{
     get
{
          return _nomenclatureVersion;
}
     set
{
          _nomenclatureVersion = value;
}
}

public void setNomenclature(ushort pNomenclature)
{ _nomenclature = pNomenclature;
}

[XmlElement(Type= typeof(ushort), ElementName="nomenclature")]
public ushort Nomenclature
{
     get
{
          return _nomenclature;
}
     set
{
          _nomenclature = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_entityKind);
       dos.writeByte( (byte)_domain);
       dos.writeUshort( (ushort)_country);
       dos.writeByte( (byte)_category);
       dos.writeByte( (byte)_nomenclatureVersion);
       dos.writeUshort( (ushort)_nomenclature);
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
       _nomenclatureVersion = dis.readByte();
       _nomenclature = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- RadioEntityType-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _entityKind\t " + _entityKind.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _domain\t " + _domain.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _country\t " + _country.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _category\t " + _category.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _nomenclatureVersion\t " + _nomenclatureVersion.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _nomenclature\t " + _nomenclature.ToString() + System.Environment.NewLine);
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
 public bool equals(RadioEntityType rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_entityKind == rhs._entityKind)) ivarsEqual = false;
     if( ! (_domain == rhs._domain)) ivarsEqual = false;
     if( ! (_country == rhs._country)) ivarsEqual = false;
     if( ! (_category == rhs._category)) ivarsEqual = false;
     if( ! (_nomenclatureVersion == rhs._nomenclatureVersion)) ivarsEqual = false;
     if( ! (_nomenclature == rhs._nomenclature)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
