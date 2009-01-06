using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.48: Linear segment parameters
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
[XmlInclude(typeof(SixByteChunk))]
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(Orientation))]
public class LinearSegmentParameter : Object
{
   /** number of segments */
   protected byte  _segmentNumber;

   /** segment appearance */
   protected SixByteChunk  _segmentAppearance = new SixByteChunk(); 

   /** location */
   protected Vector3Double  _location = new Vector3Double(); 

   /** orientation */
   protected Orientation  _orientation = new Orientation(); 

   /** segmentLength */
   protected ushort  _segmentLength;

   /** segmentWidth */
   protected ushort  _segmentWidth;

   /** segmentHeight */
   protected ushort  _segmentHeight;

   /** segment Depth */
   protected ushort  _segmentDepth;

   /** segment Depth */
   protected uint  _pad1;


/** Constructor */
 public LinearSegmentParameter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _segmentNumber
   marshalSize = marshalSize + _segmentAppearance.getMarshalledSize();  // _segmentAppearance
   marshalSize = marshalSize + _location.getMarshalledSize();  // _location
   marshalSize = marshalSize + _orientation.getMarshalledSize();  // _orientation
   marshalSize = marshalSize + 2;  // _segmentLength
   marshalSize = marshalSize + 2;  // _segmentWidth
   marshalSize = marshalSize + 2;  // _segmentHeight
   marshalSize = marshalSize + 2;  // _segmentDepth
   marshalSize = marshalSize + 4;  // _pad1

   return marshalSize;
}


public void setSegmentNumber(byte pSegmentNumber)
{ _segmentNumber = pSegmentNumber;
}

[XmlElement(Type= typeof(byte), ElementName="segmentNumber")]
public byte SegmentNumber
{
     get
{
          return _segmentNumber;
}
     set
{
          _segmentNumber = value;
}
}

public void setSegmentAppearance(SixByteChunk pSegmentAppearance)
{ _segmentAppearance = pSegmentAppearance;
}

public SixByteChunk getSegmentAppearance()
{ return _segmentAppearance; 
}

[XmlElement(Type= typeof(SixByteChunk), ElementName="segmentAppearance")]
public SixByteChunk SegmentAppearance
{
     get
{
          return _segmentAppearance;
}
     set
{
          _segmentAppearance = value;
}
}

public void setLocation(Vector3Double pLocation)
{ _location = pLocation;
}

public Vector3Double getLocation()
{ return _location; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="location")]
public Vector3Double Location
{
     get
{
          return _location;
}
     set
{
          _location = value;
}
}

public void setOrientation(Orientation pOrientation)
{ _orientation = pOrientation;
}

public Orientation getOrientation()
{ return _orientation; 
}

[XmlElement(Type= typeof(Orientation), ElementName="orientation")]
public Orientation Orientation
{
     get
{
          return _orientation;
}
     set
{
          _orientation = value;
}
}

public void setSegmentLength(ushort pSegmentLength)
{ _segmentLength = pSegmentLength;
}

[XmlElement(Type= typeof(ushort), ElementName="segmentLength")]
public ushort SegmentLength
{
     get
{
          return _segmentLength;
}
     set
{
          _segmentLength = value;
}
}

public void setSegmentWidth(ushort pSegmentWidth)
{ _segmentWidth = pSegmentWidth;
}

[XmlElement(Type= typeof(ushort), ElementName="segmentWidth")]
public ushort SegmentWidth
{
     get
{
          return _segmentWidth;
}
     set
{
          _segmentWidth = value;
}
}

public void setSegmentHeight(ushort pSegmentHeight)
{ _segmentHeight = pSegmentHeight;
}

[XmlElement(Type= typeof(ushort), ElementName="segmentHeight")]
public ushort SegmentHeight
{
     get
{
          return _segmentHeight;
}
     set
{
          _segmentHeight = value;
}
}

public void setSegmentDepth(ushort pSegmentDepth)
{ _segmentDepth = pSegmentDepth;
}

[XmlElement(Type= typeof(ushort), ElementName="segmentDepth")]
public ushort SegmentDepth
{
     get
{
          return _segmentDepth;
}
     set
{
          _segmentDepth = value;
}
}

public void setPad1(uint pPad1)
{ _pad1 = pPad1;
}

[XmlElement(Type= typeof(uint), ElementName="pad1")]
public uint Pad1
{
     get
{
          return _pad1;
}
     set
{
          _pad1 = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_segmentNumber);
       _segmentAppearance.marshal(dos);
       _location.marshal(dos);
       _orientation.marshal(dos);
       dos.writeUshort( (ushort)_segmentLength);
       dos.writeUshort( (ushort)_segmentWidth);
       dos.writeUshort( (ushort)_segmentHeight);
       dos.writeUshort( (ushort)_segmentDepth);
       dos.writeUint( (uint)_pad1);
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
       _segmentNumber = dis.readByte();
       _segmentAppearance.unmarshal(dis);
       _location.unmarshal(dis);
       _orientation.unmarshal(dis);
       _segmentLength = dis.readUshort();
       _segmentWidth = dis.readUshort();
       _segmentHeight = dis.readUshort();
       _segmentDepth = dis.readUshort();
       _pad1 = dis.readUint();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- LinearSegmentParameter-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _segmentNumber\t " + _segmentNumber.ToString() + System.Environment.NewLine);
       sb.Append("=====_segmentAppearance=====" + System.Environment.NewLine);
       _segmentAppearance.reflection(sb);
       sb.Append("=====_location=====" + System.Environment.NewLine);
       _location.reflection(sb);
       sb.Append("=====_orientation=====" + System.Environment.NewLine);
       _orientation.reflection(sb);
           sb.Append("ushort\t _segmentLength\t " + _segmentLength.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _segmentWidth\t " + _segmentWidth.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _segmentHeight\t " + _segmentHeight.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _segmentDepth\t " + _segmentDepth.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _pad1\t " + _pad1.ToString() + System.Environment.NewLine);
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
 public bool equals(LinearSegmentParameter rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_segmentNumber == rhs._segmentNumber)) ivarsEqual = false;
     if( ! (_segmentAppearance.Equals( rhs._segmentAppearance) )) ivarsEqual = false;
     if( ! (_location.Equals( rhs._location) )) ivarsEqual = false;
     if( ! (_orientation.Equals( rhs._orientation) )) ivarsEqual = false;
     if( ! (_segmentLength == rhs._segmentLength)) ivarsEqual = false;
     if( ! (_segmentWidth == rhs._segmentWidth)) ivarsEqual = false;
     if( ! (_segmentHeight == rhs._segmentHeight)) ivarsEqual = false;
     if( ! (_segmentDepth == rhs._segmentDepth)) ivarsEqual = false;
     if( ! (_pad1 == rhs._pad1)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
