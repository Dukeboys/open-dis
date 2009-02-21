using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.5.1. Information about a request for supplies. COMPLETE
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
[XmlInclude(typeof(SupplyQuantity))]
public class ServiceRequestPdu : LogisticsFamilyPdu
{
   /** Entity that is requesting service */
   protected EntityID  _requestingEntityID = new EntityID(); 

   /** Entity that is providing the service */
   protected EntityID  _servicingEntityID = new EntityID(); 

   /** type of service requested */
   protected byte  _serviceTypeRequested;

   /** How many requested */
   protected byte  _numberOfSupplyTypes;

   /** padding */
   protected short  _serviceRequestPadding = 0;

   protected List<SupplyQuantity> _supplies = new List<SupplyQuantity>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.5.1. Information about a request for supplies. COMPLETE
   ///</summary>
 public ServiceRequestPdu()
 {
    PduType = (byte)5;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _requestingEntityID.getMarshalledSize();  // _requestingEntityID
   marshalSize = marshalSize + _servicingEntityID.getMarshalledSize();  // _servicingEntityID
   marshalSize = marshalSize + 1;  // _serviceTypeRequested
   marshalSize = marshalSize + 1;  // _numberOfSupplyTypes
   marshalSize = marshalSize + 2;  // _serviceRequestPadding
   for(int idx=0; idx < _supplies.Count; idx++)
   {
        SupplyQuantity listElement = (SupplyQuantity)_supplies[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


   ///<summary>
   ///Entity that is requesting service
   ///</summary>
public void setRequestingEntityID(EntityID pRequestingEntityID)
{ _requestingEntityID = pRequestingEntityID;
}

   ///<summary>
   ///Entity that is requesting service
   ///</summary>
public EntityID getRequestingEntityID()
{ return _requestingEntityID; 
}

   ///<summary>
   ///Entity that is requesting service
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="requestingEntityID")]
public EntityID RequestingEntityID
{
     get
{
          return _requestingEntityID;
}
     set
{
          _requestingEntityID = value;
}
}

   ///<summary>
   ///Entity that is providing the service
   ///</summary>
public void setServicingEntityID(EntityID pServicingEntityID)
{ _servicingEntityID = pServicingEntityID;
}

   ///<summary>
   ///Entity that is providing the service
   ///</summary>
public EntityID getServicingEntityID()
{ return _servicingEntityID; 
}

   ///<summary>
   ///Entity that is providing the service
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="servicingEntityID")]
public EntityID ServicingEntityID
{
     get
{
          return _servicingEntityID;
}
     set
{
          _servicingEntityID = value;
}
}

   ///<summary>
   ///type of service requested
   ///</summary>
public void setServiceTypeRequested(byte pServiceTypeRequested)
{ _serviceTypeRequested = pServiceTypeRequested;
}

[XmlElement(Type= typeof(byte), ElementName="serviceTypeRequested")]
public byte ServiceTypeRequested
{
     get
{
          return _serviceTypeRequested;
}
     set
{
          _serviceTypeRequested = value;
}
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfSupplyTypes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfSupplyTypes(byte pNumberOfSupplyTypes)
{ _numberOfSupplyTypes = pNumberOfSupplyTypes;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfSupplyTypes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(byte), ElementName="numberOfSupplyTypes")]
public byte NumberOfSupplyTypes
{
     get
     {
          return _numberOfSupplyTypes;
     }
     set
     {
          _numberOfSupplyTypes = value;
     }
}

   ///<summary>
   ///padding
   ///</summary>
public void setServiceRequestPadding(short pServiceRequestPadding)
{ _serviceRequestPadding = pServiceRequestPadding;
}

[XmlElement(Type= typeof(short), ElementName="serviceRequestPadding")]
public short ServiceRequestPadding
{
     get
{
          return _serviceRequestPadding;
}
     set
{
          _serviceRequestPadding = value;
}
}

public void setSupplies(List<SupplyQuantity> pSupplies)
{ _supplies = pSupplies;
}

public List<SupplyQuantity> getSupplies()
{ return _supplies; }

[XmlElement(ElementName = "suppliesList",Type = typeof(List<SupplyQuantity>))]
public List<SupplyQuantity> Supplies
{
     get
{
          return _supplies;
}
     set
{
          _supplies = value;
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
       _requestingEntityID.marshal(dos);
       _servicingEntityID.marshal(dos);
       dos.writeByte( (byte)_serviceTypeRequested);
       dos.writeByte( (byte)_supplies.Count);
       dos.writeShort( (short)_serviceRequestPadding);

       for(int idx = 0; idx < _supplies.Count; idx++)
       {
            SupplyQuantity aSupplyQuantity = (SupplyQuantity)_supplies[idx];
            aSupplyQuantity.marshal(dos);
       } // end of list marshalling

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
       _requestingEntityID.unmarshal(dis);
       _servicingEntityID.unmarshal(dis);
       _serviceTypeRequested = dis.readByte();
       _numberOfSupplyTypes = dis.readByte();
       _serviceRequestPadding = dis.readShort();
        for(int idx = 0; idx < _numberOfSupplyTypes; idx++)
        {
           SupplyQuantity anX = new SupplyQuantity();
            anX.unmarshal(dis);
            _supplies.Add(anX);
        };

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
    sb.Append("----- ServiceRequestPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_requestingEntityID=====" + System.Environment.NewLine);
       _requestingEntityID.reflection(sb);
       sb.Append("=====_servicingEntityID=====" + System.Environment.NewLine);
       _servicingEntityID.reflection(sb);
           sb.Append("byte\t _serviceTypeRequested\t " + _serviceTypeRequested.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _supplies\t " + _supplies.Count.ToString() + System.Environment.NewLine);
           sb.Append("short\t _serviceRequestPadding\t " + _serviceRequestPadding.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _supplies.Count; idx++)
       {
           sb.Append("SupplyQuantity\t " + _supplies[idx] + System.Environment.NewLine);
            SupplyQuantity aSupplyQuantity = (SupplyQuantity)_supplies[idx];
            aSupplyQuantity.reflection(sb);
       } // end of list marshalling

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
 public bool equals(ServiceRequestPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_requestingEntityID.Equals( rhs._requestingEntityID) )) ivarsEqual = false;
     if( ! (_servicingEntityID.Equals( rhs._servicingEntityID) )) ivarsEqual = false;
     if( ! (_serviceTypeRequested == rhs._serviceTypeRequested)) ivarsEqual = false;
     if( ! (_numberOfSupplyTypes == rhs._numberOfSupplyTypes)) ivarsEqual = false;
     if( ! (_serviceRequestPadding == rhs._serviceRequestPadding)) ivarsEqual = false;

     for(int idx = 0; idx < _supplies.Count; idx++)
     {
        SupplyQuantity x = (SupplyQuantity)_supplies[idx];
        if( ! ( _supplies[idx].Equals(rhs._supplies[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
