using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.5. Articulation parameters for  movable parts and attached parts of an entity. Specifes wether or not a change has occured,  the part identifcation of the articulated part to which it is attached, and the type and value of each parameter.
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
public class ArticulationParameter : Object
{
   protected byte  _parameterTypeDesignator;

   protected byte  _changeIndicator;

   protected ushort  _partAttachedTo;

   protected uint  _parameterType;

   protected double  _parameterValue;


/** Constructor */
   ///<summary>
   ///Section 5.2.5. Articulation parameters for  movable parts and attached parts of an entity. Specifes wether or not a change has occured,  the part identifcation of the articulated part to which it is attached, and the type and value of each parameter.
   ///</summary>
 public ArticulationParameter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _parameterTypeDesignator
   marshalSize = marshalSize + 1;  // _changeIndicator
   marshalSize = marshalSize + 2;  // _partAttachedTo
   marshalSize = marshalSize + 4;  // _parameterType
   marshalSize = marshalSize + 8;  // _parameterValue

   return marshalSize;
}


public void setParameterTypeDesignator(byte pParameterTypeDesignator)
{ _parameterTypeDesignator = pParameterTypeDesignator;
}

[XmlElement(Type= typeof(byte), ElementName="parameterTypeDesignator")]
public byte ParameterTypeDesignator
{
     get
{
          return _parameterTypeDesignator;
}
     set
{
          _parameterTypeDesignator = value;
}
}

public void setChangeIndicator(byte pChangeIndicator)
{ _changeIndicator = pChangeIndicator;
}

[XmlElement(Type= typeof(byte), ElementName="changeIndicator")]
public byte ChangeIndicator
{
     get
{
          return _changeIndicator;
}
     set
{
          _changeIndicator = value;
}
}

public void setPartAttachedTo(ushort pPartAttachedTo)
{ _partAttachedTo = pPartAttachedTo;
}

[XmlElement(Type= typeof(ushort), ElementName="partAttachedTo")]
public ushort PartAttachedTo
{
     get
{
          return _partAttachedTo;
}
     set
{
          _partAttachedTo = value;
}
}

public void setParameterType(uint pParameterType)
{ _parameterType = pParameterType;
}

[XmlElement(Type= typeof(uint), ElementName="parameterType")]
public uint ParameterType
{
     get
{
          return _parameterType;
}
     set
{
          _parameterType = value;
}
}

public void setParameterValue(double pParameterValue)
{ _parameterValue = pParameterValue;
}

[XmlElement(Type= typeof(double), ElementName="parameterValue")]
public double ParameterValue
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
       dos.writeByte( (byte)_parameterTypeDesignator);
       dos.writeByte( (byte)_changeIndicator);
       dos.writeUshort( (ushort)_partAttachedTo);
       dos.writeUint( (uint)_parameterType);
       dos.writeDouble( (double)_parameterValue);
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
       _parameterTypeDesignator = dis.readByte();
       _changeIndicator = dis.readByte();
       _partAttachedTo = dis.readUshort();
       _parameterType = dis.readUint();
       _parameterValue = dis.readDouble();
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
    sb.Append("----- ArticulationParameter-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _parameterTypeDesignator\t " + _parameterTypeDesignator.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _changeIndicator\t " + _changeIndicator.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _partAttachedTo\t " + _partAttachedTo.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _parameterType\t " + _parameterType.ToString() + System.Environment.NewLine);
           sb.Append("double\t _parameterValue\t " + _parameterValue.ToString() + System.Environment.NewLine);
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
 public bool equals(ArticulationParameter rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_parameterTypeDesignator == rhs._parameterTypeDesignator)) ivarsEqual = false;
     if( ! (_changeIndicator == rhs._changeIndicator)) ivarsEqual = false;
     if( ! (_partAttachedTo == rhs._partAttachedTo)) ivarsEqual = false;
     if( ! (_parameterType == rhs._parameterType)) ivarsEqual = false;
     if( ! (_parameterValue == rhs._parameterValue)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
