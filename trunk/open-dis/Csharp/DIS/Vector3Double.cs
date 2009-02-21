using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.34. Three double precision floating point values, x, y, and z
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
public class Vector3Double : Object
{
   /** X value */
   protected double  _x;

   /** Y value */
   protected double  _y;

   /** Z value */
   protected double  _z;


/** Constructor */
   ///<summary>
   ///Section 5.3.34. Three double precision floating point values, x, y, and z
   ///</summary>
 public Vector3Double()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 8;  // _x
   marshalSize = marshalSize + 8;  // _y
   marshalSize = marshalSize + 8;  // _z

   return marshalSize;
}


   ///<summary>
   ///X value
   ///</summary>
public void setX(double pX)
{ _x = pX;
}

[XmlElement(Type= typeof(double), ElementName="x")]
public double X
{
     get
{
          return _x;
}
     set
{
          _x = value;
}
}

   ///<summary>
   ///Y value
   ///</summary>
public void setY(double pY)
{ _y = pY;
}

[XmlElement(Type= typeof(double), ElementName="y")]
public double Y
{
     get
{
          return _y;
}
     set
{
          _y = value;
}
}

   ///<summary>
   ///Z value
   ///</summary>
public void setZ(double pZ)
{ _z = pZ;
}

[XmlElement(Type= typeof(double), ElementName="z")]
public double Z
{
     get
{
          return _z;
}
     set
{
          _z = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeDouble( (double)_x);
       dos.writeDouble( (double)_y);
       dos.writeDouble( (double)_z);
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
       _x = dis.readDouble();
       _y = dis.readDouble();
       _z = dis.readDouble();
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
    sb.Append("----- Vector3Double-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("double\t _x\t " + _x.ToString() + System.Environment.NewLine);
           sb.Append("double\t _y\t " + _y.ToString() + System.Environment.NewLine);
           sb.Append("double\t _z\t " + _z.ToString() + System.Environment.NewLine);
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
 public bool equals(Vector3Double rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_x == rhs._x)) ivarsEqual = false;
     if( ! (_y == rhs._y)) ivarsEqual = false;
     if( ! (_z == rhs._z)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
