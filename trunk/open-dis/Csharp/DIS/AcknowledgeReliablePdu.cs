using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.12.5: Ack receipt of a start-resume, stop-freeze, create-entity or remove enitty (reliable) pdus. COMPLETE
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
public class AcknowledgeReliablePdu : SimulationManagementWithReliabilityFamilyPdu
{
   /** ack flags */
   protected ushort  _acknowledgeFlag;

   /** response flags */
   protected ushort  _responseFlag;

   /** Request ID */
   protected uint  _requestID;


/** Constructor */
   ///<summary>
   ///Section 5.3.12.5: Ack receipt of a start-resume, stop-freeze, create-entity or remove enitty (reliable) pdus. COMPLETE
   ///</summary>
 public AcknowledgeReliablePdu()
 {
    PduType = (byte)55;
 }

new public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 2;  // _acknowledgeFlag
   marshalSize = marshalSize + 2;  // _responseFlag
   marshalSize = marshalSize + 4;  // _requestID

   return marshalSize;
}


   ///<summary>
   ///ack flags
   ///</summary>
public void setAcknowledgeFlag(ushort pAcknowledgeFlag)
{ _acknowledgeFlag = pAcknowledgeFlag;
}

[XmlElement(Type= typeof(ushort), ElementName="acknowledgeFlag")]
public ushort AcknowledgeFlag
{
     get
{
          return _acknowledgeFlag;
}
     set
{
          _acknowledgeFlag = value;
}
}

   ///<summary>
   ///response flags
   ///</summary>
public void setResponseFlag(ushort pResponseFlag)
{ _responseFlag = pResponseFlag;
}

[XmlElement(Type= typeof(ushort), ElementName="responseFlag")]
public ushort ResponseFlag
{
     get
{
          return _responseFlag;
}
     set
{
          _responseFlag = value;
}
}

   ///<summary>
   ///Request ID
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
new public void marshalAutoLengthSet(DataOutputStream dos)
{
       //Set the length prior to marshalling data
       this.setLength((ushort)this.getMarshalledSize());
       this.marshal(dos);
}

///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
new public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       dos.writeUshort( (ushort)_acknowledgeFlag);
       dos.writeUshort( (ushort)_responseFlag);
       dos.writeUint( (uint)_requestID);
    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
    }
} // end of marshal method

new public void unmarshal(DataInputStream dis)
{
    base.unmarshal(dis);

    try 
    {
       _acknowledgeFlag = dis.readUshort();
       _responseFlag = dis.readUshort();
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
new public void reflection(StringBuilder sb)
{
    sb.Append("<AcknowledgeReliablePdu>"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("<acknowledgeFlag type=\"ushort\">" + _acknowledgeFlag.ToString() + "</acknowledgeFlag> " + System.Environment.NewLine);
           sb.Append("<responseFlag type=\"ushort\">" + _responseFlag.ToString() + "</responseFlag> " + System.Environment.NewLine);
           sb.Append("<requestID type=\"uint\">" + _requestID.ToString() + "</requestID> " + System.Environment.NewLine);
    sb.Append("</AcknowledgeReliablePdu>"  + System.Environment.NewLine);
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
 public bool equals(AcknowledgeReliablePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_acknowledgeFlag == rhs._acknowledgeFlag)) ivarsEqual = false;
     if( ! (_responseFlag == rhs._responseFlag)) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
