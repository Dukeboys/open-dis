using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.11. This field shall specify information about a particular emitter system
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
public class EmitterSystem : Object
{
   /** Name of the emitter, 16 bit enumeration */
   protected ushort  _emitterName;

   /** function of the emitter, 8 bit enumeration */
   protected byte  _function;

   /** emitter ID, 8 bit enumeration */
   protected byte  _emitterIdNumber;


/** Constructor */
   ///<summary>
   ///Section 5.2.11. This field shall specify information about a particular emitter system
   ///</summary>
 public EmitterSystem()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _emitterName
   marshalSize = marshalSize + 1;  // _function
   marshalSize = marshalSize + 1;  // _emitterIdNumber

   return marshalSize;
}


   ///<summary>
   ///Name of the emitter, 16 bit enumeration
   ///</summary>
public void setEmitterName(ushort pEmitterName)
{ _emitterName = pEmitterName;
}

[XmlElement(Type= typeof(ushort), ElementName="emitterName")]
public ushort EmitterName
{
     get
{
          return _emitterName;
}
     set
{
          _emitterName = value;
}
}

   ///<summary>
   ///function of the emitter, 8 bit enumeration
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
   ///emitter ID, 8 bit enumeration
   ///</summary>
public void setEmitterIdNumber(byte pEmitterIdNumber)
{ _emitterIdNumber = pEmitterIdNumber;
}

[XmlElement(Type= typeof(byte), ElementName="emitterIdNumber")]
public byte EmitterIdNumber
{
     get
{
          return _emitterIdNumber;
}
     set
{
          _emitterIdNumber = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_emitterName);
       dos.writeByte( (byte)_function);
       dos.writeByte( (byte)_emitterIdNumber);
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
       _emitterName = dis.readUshort();
       _function = dis.readByte();
       _emitterIdNumber = dis.readByte();
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
    sb.Append("<EmitterSystem>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<emitterName type=\"ushort\">" + _emitterName.ToString() + "</emitterName> " + System.Environment.NewLine);
           sb.Append("<function type=\"byte\">" + _function.ToString() + "</function> " + System.Environment.NewLine);
           sb.Append("<emitterIdNumber type=\"byte\">" + _emitterIdNumber.ToString() + "</emitterIdNumber> " + System.Environment.NewLine);
    sb.Append("</EmitterSystem>"  + System.Environment.NewLine);
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
 public bool equals(EmitterSystem rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_emitterName == rhs._emitterName)) ivarsEqual = false;
     if( ! (_function == rhs._function)) ivarsEqual = false;
     if( ! (_emitterIdNumber == rhs._emitterIdNumber)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
