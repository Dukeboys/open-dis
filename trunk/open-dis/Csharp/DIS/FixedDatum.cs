using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.18. Fixed Datum Record
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
public class FixedDatum : Object
{
   /** ID of the fixed datum */
   protected uint  _fixedDatumID;

   /** Value for the fixed datum */
   protected uint  _fixedDatumValue;


/** Constructor */
   ///<summary>
   ///Section 5.2.18. Fixed Datum Record
   ///</summary>
 public FixedDatum()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _fixedDatumID
   marshalSize = marshalSize + 4;  // _fixedDatumValue

   return marshalSize;
}


   ///<summary>
   ///ID of the fixed datum
   ///</summary>
public void setFixedDatumID(uint pFixedDatumID)
{ _fixedDatumID = pFixedDatumID;
}

[XmlElement(Type= typeof(uint), ElementName="fixedDatumID")]
public uint FixedDatumID
{
     get
{
          return _fixedDatumID;
}
     set
{
          _fixedDatumID = value;
}
}

   ///<summary>
   ///Value for the fixed datum
   ///</summary>
public void setFixedDatumValue(uint pFixedDatumValue)
{ _fixedDatumValue = pFixedDatumValue;
}

[XmlElement(Type= typeof(uint), ElementName="fixedDatumValue")]
public uint FixedDatumValue
{
     get
{
          return _fixedDatumValue;
}
     set
{
          _fixedDatumValue = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUint( (uint)_fixedDatumID);
       dos.writeUint( (uint)_fixedDatumValue);
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
       _fixedDatumID = dis.readUint();
       _fixedDatumValue = dis.readUint();
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
    sb.Append("<FixedDatum>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<fixedDatumID type=\"uint\">" + _fixedDatumID.ToString() + "</fixedDatumID> " + System.Environment.NewLine);
           sb.Append("<fixedDatumValue type=\"uint\">" + _fixedDatumValue.ToString() + "</fixedDatumValue> " + System.Environment.NewLine);
    sb.Append("</FixedDatum>"  + System.Environment.NewLine);
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
 public bool equals(FixedDatum rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_fixedDatumID == rhs._fixedDatumID)) ivarsEqual = false;
     if( ! (_fixedDatumValue == rhs._fixedDatumValue)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
