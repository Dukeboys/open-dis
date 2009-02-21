using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.12: Abstract superclass for reliable simulation management PDUs
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
[XmlInclude(typeof(EntityID))]
public class SimulationManagementWithReliabilityFamilyPdu : Pdu
{
   /** Object originatig the request */
   protected EntityID  _originatingEntityID = new EntityID(); 

   /** Object with which this point object is associated */
   protected EntityID  _receivingEntityID = new EntityID(); 


/** Constructor */
   ///<summary>
   ///Section 5.3.12: Abstract superclass for reliable simulation management PDUs
   ///</summary>
 public SimulationManagementWithReliabilityFamilyPdu()
 {
    ProtocolFamily = (byte)10;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _originatingEntityID.getMarshalledSize();  // _originatingEntityID
   marshalSize = marshalSize + _receivingEntityID.getMarshalledSize();  // _receivingEntityID

   return marshalSize;
}


   ///<summary>
   ///Object originatig the request
   ///</summary>
public void setOriginatingEntityID(EntityID pOriginatingEntityID)
{ _originatingEntityID = pOriginatingEntityID;
}

   ///<summary>
   ///Object originatig the request
   ///</summary>
public EntityID getOriginatingEntityID()
{ return _originatingEntityID; 
}

   ///<summary>
   ///Object originatig the request
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="originatingEntityID")]
public EntityID OriginatingEntityID
{
     get
{
          return _originatingEntityID;
}
     set
{
          _originatingEntityID = value;
}
}

   ///<summary>
   ///Object with which this point object is associated
   ///</summary>
public void setReceivingEntityID(EntityID pReceivingEntityID)
{ _receivingEntityID = pReceivingEntityID;
}

   ///<summary>
   ///Object with which this point object is associated
   ///</summary>
public EntityID getReceivingEntityID()
{ return _receivingEntityID; 
}

   ///<summary>
   ///Object with which this point object is associated
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="receivingEntityID")]
public EntityID ReceivingEntityID
{
     get
{
          return _receivingEntityID;
}
     set
{
          _receivingEntityID = value;
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
       _originatingEntityID.marshal(dos);
       _receivingEntityID.marshal(dos);
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
       _originatingEntityID.unmarshal(dis);
       _receivingEntityID.unmarshal(dis);
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
    sb.Append("----- SimulationManagementWithReliabilityFamilyPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_originatingEntityID=====" + System.Environment.NewLine);
       _originatingEntityID.reflection(sb);
       sb.Append("=====_receivingEntityID=====" + System.Environment.NewLine);
       _receivingEntityID.reflection(sb);
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
 public bool equals(SimulationManagementWithReliabilityFamilyPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_originatingEntityID.Equals( rhs._originatingEntityID) )) ivarsEqual = false;
     if( ! (_receivingEntityID.Equals( rhs._receivingEntityID) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
