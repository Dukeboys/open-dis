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
   ///<summary>
   ///discrete ostional relationsihip 
   ///</summary>
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


   ///<summary>
   ///station name enumeration
   ///</summary>
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

   ///<summary>
   ///station number
   ///</summary>
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


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
public void reflection(StringBuilder sb)
{
    sb.Append("<NamedLocation>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<stationName type=\"ushort\">" + _stationName.ToString() + "</stationName> " + System.Environment.NewLine);
           sb.Append("<stationNumber type=\"ushort\">" + _stationNumber.ToString() + "</stationNumber> " + System.Environment.NewLine);
    sb.Append("</NamedLocation>"  + System.Environment.NewLine);
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
