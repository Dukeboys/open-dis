using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Used in UA PDU
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
public class ApaData : Object
{
   /** Index of APA parameter */
   protected ushort  _parameterIndex;

   /** Index of APA parameter */
   protected short  _parameterValue;


/** Constructor */
   ///<summary>
   ///Used in UA PDU
   ///</summary>
 public ApaData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _parameterIndex
   marshalSize = marshalSize + 2;  // _parameterValue

   return marshalSize;
}


   ///<summary>
   ///Index of APA parameter
   ///</summary>
public void setParameterIndex(ushort pParameterIndex)
{ _parameterIndex = pParameterIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="parameterIndex")]
public ushort ParameterIndex
{
     get
{
          return _parameterIndex;
}
     set
{
          _parameterIndex = value;
}
}

   ///<summary>
   ///Index of APA parameter
   ///</summary>
public void setParameterValue(short pParameterValue)
{ _parameterValue = pParameterValue;
}

[XmlElement(Type= typeof(short), ElementName="parameterValue")]
public short ParameterValue
{
     get
{
          return _parameterValue;
}
     set
{
          _parameterValue = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_parameterIndex);
       dos.writeShort( (short)_parameterValue);
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
       _parameterIndex = dis.readUshort();
       _parameterValue = dis.readShort();
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
    sb.Append("<ApaData>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<parameterIndex type=\"ushort\">" + _parameterIndex.ToString() + "</parameterIndex> " + System.Environment.NewLine);
           sb.Append("<parameterValue type=\"short\">" + _parameterValue.ToString() + "</parameterValue> " + System.Environment.NewLine);
    sb.Append("</ApaData>"  + System.Environment.NewLine);
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
 public bool equals(ApaData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_parameterIndex == rhs._parameterIndex)) ivarsEqual = false;
     if( ! (_parameterValue == rhs._parameterValue)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
