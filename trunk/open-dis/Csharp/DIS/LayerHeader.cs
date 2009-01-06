using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.47.  Layer header.
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
public class LayerHeader : Object
{
   /** Layer number */
   protected byte  _layerNumber;

   /** Layer speccific information enumeration */
   protected byte  _layerSpecificInformaiton;

   /** information length */
   protected ushort  _length;


/** Constructor */
 public LayerHeader()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _layerNumber
   marshalSize = marshalSize + 1;  // _layerSpecificInformaiton
   marshalSize = marshalSize + 2;  // _length

   return marshalSize;
}


public void setLayerNumber(byte pLayerNumber)
{ _layerNumber = pLayerNumber;
}

[XmlElement(Type= typeof(byte), ElementName="layerNumber")]
public byte LayerNumber
{
     get
{
          return _layerNumber;
}
     set
{
          _layerNumber = value;
}
}

public void setLayerSpecificInformaiton(byte pLayerSpecificInformaiton)
{ _layerSpecificInformaiton = pLayerSpecificInformaiton;
}

[XmlElement(Type= typeof(byte), ElementName="layerSpecificInformaiton")]
public byte LayerSpecificInformaiton
{
     get
{
          return _layerSpecificInformaiton;
}
     set
{
          _layerSpecificInformaiton = value;
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


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_layerNumber);
       dos.writeByte( (byte)_layerSpecificInformaiton);
       dos.writeUshort( (ushort)_length);
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
       _layerNumber = dis.readByte();
       _layerSpecificInformaiton = dis.readByte();
       _length = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- LayerHeader-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _layerNumber\t " + _layerNumber.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _layerSpecificInformaiton\t " + _layerSpecificInformaiton.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _length\t " + _length.ToString() + System.Environment.NewLine);
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
 public bool equals(LayerHeader rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_layerNumber == rhs._layerNumber)) ivarsEqual = false;
     if( ! (_layerSpecificInformaiton == rhs._layerSpecificInformaiton)) ivarsEqual = false;
     if( ! (_length == rhs._length)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
