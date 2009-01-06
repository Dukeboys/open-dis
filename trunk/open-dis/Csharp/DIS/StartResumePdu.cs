using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.6.3. Start or resume an exercise. COMPLETE
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
[XmlInclude(typeof(ClockTime))]
public class StartResumePdu : SimulationManagementFamilyPdu
{
   /** UTC time at which the simulation shall start or resume */
   protected ClockTime  _realWorldTime = new ClockTime(); 

   /** Simulation clock time at which the simulation shall start or resume */
   protected ClockTime  _simulationTime = new ClockTime(); 

   /** Identifier for the request */
   protected uint  _requestID;


/** Constructor */
 public StartResumePdu()
 {
    PduType = (byte)13;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _realWorldTime.getMarshalledSize();  // _realWorldTime
   marshalSize = marshalSize + _simulationTime.getMarshalledSize();  // _simulationTime
   marshalSize = marshalSize + 4;  // _requestID

   return marshalSize;
}


public void setRealWorldTime(ClockTime pRealWorldTime)
{ _realWorldTime = pRealWorldTime;
}

public ClockTime getRealWorldTime()
{ return _realWorldTime; 
}

[XmlElement(Type= typeof(ClockTime), ElementName="realWorldTime")]
public ClockTime RealWorldTime
{
     get
{
          return _realWorldTime;
}
     set
{
          _realWorldTime = value;
}
}

public void setSimulationTime(ClockTime pSimulationTime)
{ _simulationTime = pSimulationTime;
}

public ClockTime getSimulationTime()
{ return _simulationTime; 
}

[XmlElement(Type= typeof(ClockTime), ElementName="simulationTime")]
public ClockTime SimulationTime
{
     get
{
          return _simulationTime;
}
     set
{
          _simulationTime = value;
}
}

public void setRequestID(uint pRequestID)
{ _requestID = pRequestID;
}

[XmlElement(Type= typeof(uint), ElementName="requestID")]
public uint RequestID
{
     get
{
          return _requestID;
}
     set
{
          _requestID = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _realWorldTime.marshal(dos);
       _simulationTime.marshal(dos);
       dos.writeUint( (uint)_requestID);
    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
    }
} // end of marshal method

public void unmarshal(DataInputStream dis)
{
    base.unmarshal(dis);

    try 
    {
       _realWorldTime.unmarshal(dis);
       _simulationTime.unmarshal(dis);
       _requestID = dis.readUint();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- StartResumePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_realWorldTime=====" + System.Environment.NewLine);
       _realWorldTime.reflection(sb);
       sb.Append("=====_simulationTime=====" + System.Environment.NewLine);
       _simulationTime.reflection(sb);
           sb.Append("uint\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
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
 public bool equals(StartResumePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_realWorldTime.Equals( rhs._realWorldTime) )) ivarsEqual = false;
     if( ! (_simulationTime.Equals( rhs._simulationTime) )) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
