using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Shaft RPMs, used in underwater acoustic clacluations.
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
public class ShaftRPMs : Object
{
   /** Current shaft RPMs */
   protected short  _currentShaftRPMs;

   /** ordered shaft rpms */
   protected short  _orderedShaftRPMs;

   /** rate of change of shaft RPMs */
   protected float  _shaftRPMRateOfChange;


/** Constructor */
   ///<summary>
   ///Shaft RPMs, used in underwater acoustic clacluations.
   ///</summary>
 public ShaftRPMs()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _currentShaftRPMs
   marshalSize = marshalSize + 2;  // _orderedShaftRPMs
   marshalSize = marshalSize + 4;  // _shaftRPMRateOfChange

   return marshalSize;
}


   ///<summary>
   ///Current shaft RPMs
   ///</summary>
public void setCurrentShaftRPMs(short pCurrentShaftRPMs)
{ _currentShaftRPMs = pCurrentShaftRPMs;
}

[XmlElement(Type= typeof(short), ElementName="currentShaftRPMs")]
public short CurrentShaftRPMs
{
     get
{
          return _currentShaftRPMs;
}
     set
{
          _currentShaftRPMs = value;
}
}

   ///<summary>
   ///ordered shaft rpms
   ///</summary>
public void setOrderedShaftRPMs(short pOrderedShaftRPMs)
{ _orderedShaftRPMs = pOrderedShaftRPMs;
}

[XmlElement(Type= typeof(short), ElementName="orderedShaftRPMs")]
public short OrderedShaftRPMs
{
     get
{
          return _orderedShaftRPMs;
}
     set
{
          _orderedShaftRPMs = value;
}
}

   ///<summary>
   ///rate of change of shaft RPMs
   ///</summary>
public void setShaftRPMRateOfChange(float pShaftRPMRateOfChange)
{ _shaftRPMRateOfChange = pShaftRPMRateOfChange;
}

[XmlElement(Type= typeof(float), ElementName="shaftRPMRateOfChange")]
public float ShaftRPMRateOfChange
{
     get
{
          return _shaftRPMRateOfChange;
}
     set
{
          _shaftRPMRateOfChange = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)_currentShaftRPMs);
       dos.writeShort( (short)_orderedShaftRPMs);
       dos.writeFloat( (float)_shaftRPMRateOfChange);
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
       _currentShaftRPMs = dis.readShort();
       _orderedShaftRPMs = dis.readShort();
       _shaftRPMRateOfChange = dis.readFloat();
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
    sb.Append("----- ShaftRPMs-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("short\t _currentShaftRPMs\t " + _currentShaftRPMs.ToString() + System.Environment.NewLine);
           sb.Append("short\t _orderedShaftRPMs\t " + _orderedShaftRPMs.ToString() + System.Environment.NewLine);
           sb.Append("float\t _shaftRPMRateOfChange\t " + _shaftRPMRateOfChange.ToString() + System.Environment.NewLine);
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
 public bool equals(ShaftRPMs rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_currentShaftRPMs == rhs._currentShaftRPMs)) ivarsEqual = false;
     if( ! (_orderedShaftRPMs == rhs._orderedShaftRPMs)) ivarsEqual = false;
     if( ! (_shaftRPMRateOfChange == rhs._shaftRPMRateOfChange)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
