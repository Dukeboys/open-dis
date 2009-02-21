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
   ///<summary>
   ///Section 5.2.6.3. Start or resume an exercise. COMPLETE
   ///</summary>
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


   ///<summary>
   ///UTC time at which the simulation shall start or resume
   ///</summary>
public void setRealWorldTime(ClockTime pRealWorldTime)
{ _realWorldTime = pRealWorldTime;
}

   ///<summary>
   ///UTC time at which the simulation shall start or resume
   ///</summary>
public ClockTime getRealWorldTime()
{ return _realWorldTime; 
}

   ///<summary>
   ///UTC time at which the simulation shall start or resume
   ///</summary>
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

   ///<summary>
   ///Simulation clock time at which the simulation shall start or resume
   ///</summary>
public void setSimulationTime(ClockTime pSimulationTime)
{ _simulationTime = pSimulationTime;
}

   ///<summary>
   ///Simulation clock time at which the simulation shall start or resume
   ///</summary>
public ClockTime getSimulationTime()
{ return _simulationTime; 
}

   ///<summary>
   ///Simulation clock time at which the simulation shall start or resume
   ///</summary>
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

   ///<summary>
   ///Identifier for the request
   ///</summary>
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

///<summary>
///Automatically sets the length of the marshalled data, then calls the marshal method.
///</summary>
public void marshalAutoLengthSet(DataOutputStream dos)
{
       //Set the length prior to marshalling data
       this.setLength((ushort)this.getMarshalledSize());
       this.marshal(dos);
}

///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
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
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
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
