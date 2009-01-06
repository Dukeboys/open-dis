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


public void reflection(StringBuilder sb)
{
    sb.Append("----- PropulsionSystemData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("float\t _powerSetting\t " + _powerSetting.ToString() + System.Environment.NewLine);
           sb.Append("float\t _engineRpm\t " + _engineRpm.ToString() + System.Environment.NewLine);
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
