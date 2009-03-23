using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.58. Used in IFF ATC PDU
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
public class SystemID : Object
{
   /** System Type */
   protected ushort  _systemType;

   /** System name, an enumeration */
   protected ushort  _systemName;

   /** System mode */
   protected byte  _systemMode;

   /** Change Options */
   protected byte  _changeOptions;


/** Constructor */
   ///<summary>
   ///5.2.58. Used in IFF ATC PDU
   ///</summary>
 public SystemID()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _systemType
   marshalSize = marshalSize + 2;  // _systemName
   marshalSize = marshalSize + 1;  // _systemMode
   marshalSize = marshalSize + 1;  // _changeOptions

   return marshalSize;
}


   ///<summary>
   ///System Type
   ///</summary>
public void setSystemType(ushort pSystemType)
{ _systemType = pSystemType;
}

[XmlElement(Type= typeof(ushort), ElementName="systemType")]
public ushort SystemType
{
     get
{
          return _systemType;
}
     set
{
          _systemType = value;
}
}

   ///<summary>
   ///System name, an enumeration
   ///</summary>
public void setSystemName(ushort pSystemName)
{ _systemName = pSystemName;
}

[XmlElement(Type= typeof(ushort), ElementName="systemName")]
public ushort SystemName
{
     get
{
          return _systemName;
}
     set
{
          _systemName = value;
}
}

   ///<summary>
   ///System mode
   ///</summary>
public void setSystemMode(byte pSystemMode)
{ _systemMode = pSystemMode;
}

[XmlElement(Type= typeof(byte), ElementName="systemMode")]
public byte SystemMode
{
     get
{
          return _systemMode;
}
     set
{
          _systemMode = value;
}
}

   ///<summary>
   ///Change Options
   ///</summary>
public void setChangeOptions(byte pChangeOptions)
{ _changeOptions = pChangeOptions;
}

[XmlElement(Type= typeof(byte), ElementName="changeOptions")]
public byte ChangeOptions
{
     get
{
          return _changeOptions;
}
     set
{
          _changeOptions = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_systemType);
       dos.writeUshort( (ushort)_systemName);
       dos.writeByte( (byte)_systemMode);
       dos.writeByte( (byte)_changeOptions);
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
       _systemType = dis.readUshort();
       _systemName = dis.readUshort();
       _systemMode = dis.readByte();
       _changeOptions = dis.readByte();
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
    sb.Append("<SystemID>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<systemType type=\"ushort\">" + _systemType.ToString() + "</systemType> " + System.Environment.NewLine);
           sb.Append("<systemName type=\"ushort\">" + _systemName.ToString() + "</systemName> " + System.Environment.NewLine);
           sb.Append("<systemMode type=\"byte\">" + _systemMode.ToString() + "</systemMode> " + System.Environment.NewLine);
           sb.Append("<changeOptions type=\"byte\">" + _changeOptions.ToString() + "</changeOptions> " + System.Environment.NewLine);
    sb.Append("</SystemID>"  + System.Environment.NewLine);
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
 public bool equals(SystemID rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_systemType == rhs._systemType)) ivarsEqual = false;
     if( ! (_systemName == rhs._systemName)) ivarsEqual = false;
     if( ! (_systemMode == rhs._systemMode)) ivarsEqual = false;
     if( ! (_changeOptions == rhs._changeOptions)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
