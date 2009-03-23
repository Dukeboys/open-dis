using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Data about a propulsion system
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
public class PropulsionSystemData : Object
{
   /** powerSetting */
   protected float  _powerSetting;

   /** engine RPMs */
   protected float  _engineRpm;


/** Constructor */
   ///<summary>
   ///Data about a propulsion system
   ///</summary>
 public PropulsionSystemData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _powerSetting
   marshalSize = marshalSize + 4;  // _engineRpm

   return marshalSize;
}


   ///<summary>
   ///powerSetting
   ///</summary>
public void setPowerSetting(float pPowerSetting)
{ _powerSetting = pPowerSetting;
}

[XmlElement(Type= typeof(float), ElementName="powerSetting")]
public float PowerSetting
{
     get
{
          return _powerSetting;
}
     set
{
          _powerSetting = value;
}
}

   ///<summary>
   ///engine RPMs
   ///</summary>
public void setEngineRpm(float pEngineRpm)
{ _engineRpm = pEngineRpm;
}

[XmlElement(Type= typeof(float), ElementName="engineRpm")]
public float EngineRpm
{
     get
{
          return _engineRpm;
}
     set
{
          _engineRpm = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)_powerSetting);
       dos.writeFloat( (float)_engineRpm);
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
       _powerSetting = dis.readFloat();
       _engineRpm = dis.readFloat();
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
    sb.Append("<PropulsionSystemData>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<powerSetting type=\"float\">" + _powerSetting.ToString() + "</powerSetting> " + System.Environment.NewLine);
           sb.Append("<engineRpm type=\"float\">" + _engineRpm.ToString() + "</engineRpm> " + System.Environment.NewLine);
    sb.Append("</PropulsionSystemData>"  + System.Environment.NewLine);
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
 public bool equals(PropulsionSystemData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_powerSetting == rhs._powerSetting)) ivarsEqual = false;
     if( ! (_engineRpm == rhs._engineRpm)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
