using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.40. Information about a geometry, a state associated with a geometry, a bounding volume, or an associated entity ID. NOTE: this class requires hand coding.
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
public class Environment : Object
{
   /** Record type */
   protected uint  _environmentType;

   /** length, in bits */
   protected byte  _length;

   /** Identify the sequentially numbered record index */
   protected byte  _index;

   /** padding */
   protected byte  _padding1;

   /** Geometry or state record */
   protected byte  _geometry;

   /** padding to bring the total size up to a 64 bit boundry */
   protected byte  _padding2;


/** Constructor */
 public Environment()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _environmentType
   marshalSize = marshalSize + 1;  // _length
   marshalSize = marshalSize + 1;  // _index
   marshalSize = marshalSize + 1;  // _padding1
   marshalSize = marshalSize + 1;  // _geometry
   marshalSize = marshalSize + 1;  // _padding2

   return marshalSize;
}


public void setEnvironmentType(uint pEnvironmentType)
{ _environmentType = pEnvironmentType;
}

[XmlElement(Type= typeof(uint), ElementName="environmentType")]
public uint EnvironmentType
{
     get
{
          return _environmentType;
}
     set
{
          _environmentType = value;
}
}

public void setLength(byte pLength)
{ _length = pLength;
}

[XmlElement(Type= typeof(byte), ElementName="length")]
public byte Length
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

public void setIndex(byte pIndex)
{ _index = pIndex;
}

[XmlElement(Type= typeof(byte), ElementName="index")]
public byte Index
{
     get
{
          return _index;
}
     set
{
          _index = value;
}
}

public void setPadding1(byte pPadding1)
{ _padding1 = pPadding1;
}

[XmlElement(Type= typeof(byte), ElementName="padding1")]
public byte Padding1
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

public void setGeometry(byte pGeometry)
{ _geometry = pGeometry;
}

[XmlElement(Type= typeof(byte), ElementName="geometry")]
public byte Geometry
{
     get
{
          return _geometry;
}
     set
{
          _geometry = value;
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
    try 
    {
       dos.writeUint( (uint)_environmentType);
       dos.writeByte( (byte)_length);
       dos.writeByte( (byte)_index);
       dos.writeByte( (byte)_padding1);
       dos.writeByte( (byte)_geometry);
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
    try 
    {
       _environmentType = dis.readUint();
       _length = dis.readByte();
       _index = dis.readByte();
       _padding1 = dis.readByte();
       _geometry = dis.readByte();
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
    sb.Append("----- Environment-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("uint\t _environmentType\t " + _environmentType.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _length\t " + _length.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _index\t " + _index.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _geometry\t " + _geometry.ToString() + System.Environment.NewLine);
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
 public bool equals(Environment rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_environmentType == rhs._environmentType)) ivarsEqual = false;
     if( ! (_length == rhs._length)) ivarsEqual = false;
     if( ! (_index == rhs._index)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_geometry == rhs._geometry)) ivarsEqual = false;
     if( ! (_padding2 == rhs._padding2)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
