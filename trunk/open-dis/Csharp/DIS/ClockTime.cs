using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.8. Time measurements that exceed one hour. Hours is the number of           hours since January 1, 1970, UTC
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
public class ClockTime : Object
{
   /** Hours in UTC */
   protected uint  _hour;

   /** Time past the hour */
   protected uint  _timePastHour;


/** Constructor */
 public ClockTime()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _hour
   marshalSize = marshalSize + 4;  // _timePastHour

   return marshalSize;
}


public void setHour(uint pHour)
{ _hour = pHour;
}

[XmlElement(Type= typeof(uint), ElementName="hour")]
public uint Hour
{
     get
{
          return _hour;
}
     set
{
          _hour = value;
}
}

public void setTimePastHour(uint pTimePastHour)
{ _timePastHour = pTimePastHour;
}

[XmlElement(Type= typeof(uint), ElementName="timePastHour")]
public uint TimePastHour
{
     get
{
          return _timePastHour;
}
     set
{
          _timePastHour = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUint( (uint)_hour);
       dos.writeUint( (uint)_timePastHour);
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
       _hour = dis.readUint();
       _timePastHour = dis.readUint();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- ClockTime-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("uint\t _hour\t " + _hour.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _timePastHour\t " + _timePastHour.ToString() + System.Environment.NewLine);
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
 public bool equals(ClockTime rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_hour == rhs._hour)) ivarsEqual = false;
     if( ! (_timePastHour == rhs._timePastHour)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
