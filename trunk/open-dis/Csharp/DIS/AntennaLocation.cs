using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.3: location of the radiating portion of the antenna, specified in world coordinates and         entity coordinates.
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
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(Vector3Float))]
public class AntennaLocation : Object
{
   /** Location of the radiating portion of the antenna in world    coordinates */
   protected Vector3Double  _antennaLocation = new Vector3Double(); 

   /** Location of the radiating portion of the antenna     in entity coordinates */
   protected Vector3Float  _relativeAntennaLocation = new Vector3Float(); 


/** Constructor */
 public AntennaLocation()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + _antennaLocation.getMarshalledSize();  // _antennaLocation
   marshalSize = marshalSize + _relativeAntennaLocation.getMarshalledSize();  // _relativeAntennaLocation

   return marshalSize;
}


public void setAntennaLocation(Vector3Double pAntennaLocation)
{ _antennaLocation = pAntennaLocation;
}

public Vector3Double getAntennaLocation()
{ return _antennaLocation; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="antennaLocation")]
public Vector3Double AntennaLocation_
{
     get
{
          return _antennaLocation;
}
     set
{
          _antennaLocation = value;
}
}

public void setRelativeAntennaLocation(Vector3Float pRelativeAntennaLocation)
{ _relativeAntennaLocation = pRelativeAntennaLocation;
}

public Vector3Float getRelativeAntennaLocation()
{ return _relativeAntennaLocation; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="relativeAntennaLocation")]
public Vector3Float RelativeAntennaLocation
{
     get
{
          return _relativeAntennaLocation;
}
     set
{
          _relativeAntennaLocation = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       _antennaLocation.marshal(dos);
       _relativeAntennaLocation.marshal(dos);
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
       _antennaLocation.unmarshal(dis);
       _relativeAntennaLocation.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- AntennaLocation-----"  + System.Environment.NewLine);
    try 
    {
       sb.Append("=====_antennaLocation=====" + System.Environment.NewLine);
       _antennaLocation.reflection(sb);
       sb.Append("=====_relativeAntennaLocation=====" + System.Environment.NewLine);
       _relativeAntennaLocation.reflection(sb);
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
 public bool equals(AntennaLocation rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_antennaLocation.Equals( rhs._antennaLocation) )) ivarsEqual = false;
     if( ! (_relativeAntennaLocation.Equals( rhs._relativeAntennaLocation) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
