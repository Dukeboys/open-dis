using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * discrete ostional relationsihip 
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
public class NamedLocation : Object
{
   /** station name enumeration */
   protected ushort  _stationName;

   /** station number */
   protected ushort  _stationNumber;


/** Constructor */
 public NamedLocation()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _stationName
   marshalSize = marshalSize + 2;  // _stationNumber

   return marshalSize;
}


public void setStationName(ushort pStationName)
{ _stationName = pStationName;
}

[XmlElement(Type= typeof(ushort), ElementName="stationName")]
public ushort StationName
{
     get
{
          return _stationName;
}
     set
{
          _stationName = value;
}
}

public void setStationNumber(ushort pStationNumber)
{ _stationNumber = pStationNumber;
}

[XmlElement(Type= typeof(ushort), ElementName="stationNumber")]
public ushort StationNumber
{
     get
{
          return _stationNumber;
}
     set
{
          _stationNumber = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_stationName);
       dos.writeUshort( (ushort)_stationNumber);
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
       _stationName = dis.readUshort();
       _stationNumber = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- NamedLocation-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _stationName\t " + _stationName.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _stationNumber\t " + _stationNumber.ToString() + System.Environment.NewLine);
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
 public bool equals(NamedLocation rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_stationName == rhs._stationName)) ivarsEqual = false;
     if( ! (_stationNumber == rhs._stationNumber)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
