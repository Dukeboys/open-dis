using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.2: angular velocity measured in radians per second out each of the entity's own coordinate axes.
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
public class AngularVelocityVector : Object
{
   /** velocity about the x axis */
   protected float  _x = 0;

   /** velocity about the y axis */
   protected float  _y = 0;

   /** velocity about the zaxis */
   protected float  _z = 0;


/** Constructor */
 public AngularVelocityVector()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _x
   marshalSize = marshalSize + 4;  // _y
   marshalSize = marshalSize + 4;  // _z

   return marshalSize;
}


public void setX(float pX)
{ _x = pX;
}

[XmlElement(Type= typeof(float), ElementName="x")]
public float X
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

public void setY(float pY)
{ _y = pY;
}

[XmlElement(Type= typeof(float), ElementName="y")]
public float Y
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

public void setZ(float pZ)
{ _z = pZ;
}

[XmlElement(Type= typeof(float), ElementName="z")]
public float Z
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


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)_x);
       dos.writeFloat( (float)_y);
       dos.writeFloat( (float)_z);
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
       _x = dis.readFloat();
       _y = dis.readFloat();
       _z = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- AngularVelocityVector-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("float\t _x\t " + _x.ToString() + System.Environment.NewLine);
           sb.Append("float\t _y\t " + _y.ToString() + System.Environment.NewLine);
           sb.Append("float\t _z\t " + _z.ToString() + System.Environment.NewLine);
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
 public bool equals(AngularVelocityVector rhs)
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
