using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.35. information about a specific UA emmtter
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
public class AcousticEmitter : Object
{
   /** the system for a particular UA emitter, and an enumeration */
   protected ushort  _acousticName;

   /** The function of the acoustic system */
   protected byte  _function;

   /** The UA emitter identification number relative to a specific system */
   protected byte  _acousticIdNumber;


/** Constructor */
   ///<summary>
   ///Section 5.2.35. information about a specific UA emmtter
   ///</summary>
 public AcousticEmitter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _acousticName
   marshalSize = marshalSize + 1;  // _function
   marshalSize = marshalSize + 1;  // _acousticIdNumber

   return marshalSize;
}


   ///<summary>
   ///the system for a particular UA emitter, and an enumeration
   ///</summary>
public void setAcousticName(ushort pAcousticName)
{ _acousticName = pAcousticName;
}

[XmlElement(Type= typeof(ushort), ElementName="acousticName")]
public ushort AcousticName
{
     get
{
          return _acousticName;
}
     set
{
          _acousticName = value;
}
}

   ///<summary>
   ///The function of the acoustic system
   ///</summary>
public void setFunction(byte pFunction)
{ _function = pFunction;
}

[XmlElement(Type= typeof(byte), ElementName="function")]
public byte Function
{
     get
{
          return _function;
}
     set
{
          _function = value;
}
}

   ///<summary>
   ///The UA emitter identification number relative to a specific system
   ///</summary>
public void setAcousticIdNumber(byte pAcousticIdNumber)
{ _acousticIdNumber = pAcousticIdNumber;
}

[XmlElement(Type= typeof(byte), ElementName="acousticIdNumber")]
public byte AcousticIdNumber
{
     get
{
          return _acousticIdNumber;
}
     set
{
          _acousticIdNumber = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_acousticName);
       dos.writeByte( (byte)_function);
       dos.writeByte( (byte)_acousticIdNumber);
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
       _acousticName = dis.readUshort();
       _function = dis.readByte();
       _acousticIdNumber = dis.readByte();
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
    sb.Append("----- AcousticEmitter-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _acousticName\t " + _acousticName.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _function\t " + _function.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _acousticIdNumber\t " + _acousticIdNumber.ToString() + System.Environment.NewLine);
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
 public bool equals(AcousticEmitter rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_acousticName == rhs._acousticName)) ivarsEqual = false;
     if( ! (_function == rhs._function)) ivarsEqual = false;
     if( ! (_acousticIdNumber == rhs._acousticIdNumber)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
