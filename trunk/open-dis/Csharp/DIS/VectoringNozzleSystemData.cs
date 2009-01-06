using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Data about a vectoring nozzle system
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
public class VectoringNozzleSystemData : Object
{
   /** horizontal deflection angle */
   protected float  _horizontalDeflectionAngle;

   /** vertical deflection angle */
   protected float  _verticalDeflectionAngle;


/** Constructor */
 public VectoringNozzleSystemData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _horizontalDeflectionAngle
   marshalSize = marshalSize + 4;  // _verticalDeflectionAngle

   return marshalSize;
}


public void setHorizontalDeflectionAngle(float pHorizontalDeflectionAngle)
{ _horizontalDeflectionAngle = pHorizontalDeflectionAngle;
}

[XmlElement(Type= typeof(float), ElementName="horizontalDeflectionAngle")]
public float HorizontalDeflectionAngle
{
     get
{
          return _horizontalDeflectionAngle;
}
     set
{
          _horizontalDeflectionAngle = value;
}
}

public void setVerticalDeflectionAngle(float pVerticalDeflectionAngle)
{ _verticalDeflectionAngle = pVerticalDeflectionAngle;
}

[XmlElement(Type= typeof(float), ElementName="verticalDeflectionAngle")]
public float VerticalDeflectionAngle
{
     get
{
          return _verticalDeflectionAngle;
}
     set
{
          _verticalDeflectionAngle = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)_horizontalDeflectionAngle);
       dos.writeFloat( (float)_verticalDeflectionAngle);
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
       _horizontalDeflectionAngle = dis.readFloat();
       _verticalDeflectionAngle = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- VectoringNozzleSystemData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("float\t _horizontalDeflectionAngle\t " + _horizontalDeflectionAngle.ToString() + System.Environment.NewLine);
           sb.Append("float\t _verticalDeflectionAngle\t " + _verticalDeflectionAngle.ToString() + System.Environment.NewLine);
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
 public bool equals(VectoringNozzleSystemData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_horizontalDeflectionAngle == rhs._horizontalDeflectionAngle)) ivarsEqual = false;
     if( ! (_verticalDeflectionAngle == rhs._verticalDeflectionAngle)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
