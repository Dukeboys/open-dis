using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.7.1. Information about active electronic warfare (EW) emissions and active EW countermeasures shall be communicated using an Electromagnetic Emission PDU. COMPLETE (I think)
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
[XmlInclude(typeof(EventID))]
[XmlInclude(typeof(ElectronicEmissionSystemData))]
public class ElectronicEmissionsPdu : DistributedEmissionsFamilyPdu
{
   /** ID of the entity emitting */
   protected EntityID  _emittingEntityID = new EntityID(); 

   /** ID of event */
   protected EventID  _eventID = new EventID(); 

   /** This field shall be used to indicate if the data in the PDU represents a state update or just data that has changed since issuance of the last Electromagnetic Emission PDU [relative to the identified entity and emission system(s)]. */
   protected byte  _stateUpdateIndicator;

   /** This field shall specify the number of emission systems being described in the current PDU. */
   protected byte  _numberOfSystems;

   /** padding */
   protected ushort  _paddingForEmissionsPdu;

   /** Electronic emmissions systems */
   protected List<ElectronicEmissionSystemData> _systems = new List<ElectronicEmissionSystemData>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.7.1. Information about active electronic warfare (EW) emissions and active EW countermeasures shall be communicated using an Electromagnetic Emission PDU. COMPLETE (I think)
   ///</summary>
 public ElectronicEmissionsPdu()
 {
    PduType = (byte)23;
    PaddingForEmissionsPdu = (ushort)0;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _emittingEntityID.getMarshalledSize();  // _emittingEntityID
   marshalSize = marshalSize + _eventID.getMarshalledSize();  // _eventID
   marshalSize = marshalSize + 1;  // _stateUpdateIndicator
   marshalSize = marshalSize + 1;  // _numberOfSystems
   marshalSize = marshalSize + 2;  // _paddingForEmissionsPdu
   for(int idx=0; idx < _systems.Count; idx++)
   {
        ElectronicEmissionSystemData listElement = (ElectronicEmissionSystemData)_systems[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


   ///<summary>
   ///ID of the entity emitting
   ///</summary>
public void setEmittingEntityID(EntityID pEmittingEntityID)
{ _emittingEntityID = pEmittingEntityID;
}

   ///<summary>
   ///ID of the entity emitting
   ///</summary>
public EntityID getEmittingEntityID()
{ return _emittingEntityID; 
}

   ///<summary>
   ///ID of the entity emitting
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="emittingEntityID")]
public EntityID EmittingEntityID
{
     get
{
          return _emittingEntityID;
}
     set
{
          _emittingEntityID = value;
}
}

   ///<summary>
   ///ID of event
   ///</summary>
public void setEventID(EventID pEventID)
{ _eventID = pEventID;
}

   ///<summary>
   ///ID of event
   ///</summary>
public EventID getEventID()
{ return _eventID; 
}

   ///<summary>
   ///ID of event
   ///</summary>
[XmlElement(Type= typeof(EventID), ElementName="eventID")]
public EventID EventID
{
     get
{
          return _eventID;
}
     set
{
          _eventID = value;
}
}

   ///<summary>
   ///This field shall be used to indicate if the data in the PDU represents a state update or just data that has changed since issuance of the last Electromagnetic Emission PDU [relative to the identified entity and emission system(s)].
   ///</summary>
public void setStateUpdateIndicator(byte pStateUpdateIndicator)
{ _stateUpdateIndicator = pStateUpdateIndicator;
}

[XmlElement(Type= typeof(byte), ElementName="stateUpdateIndicator")]
public byte StateUpdateIndicator
{
     get
{
          return _stateUpdateIndicator;
}
     set
{
          _stateUpdateIndicator = value;
}
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfSystems method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfSystems(byte pNumberOfSystems)
{ _numberOfSystems = pNumberOfSystems;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfSystems method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(byte), ElementName="numberOfSystems")]
public byte NumberOfSystems
{
     get
     {
          return _numberOfSystems;
     }
     set
     {
          _numberOfSystems = value;
     }
}

   ///<summary>
   ///padding
   ///</summary>
public void setPaddingForEmissionsPdu(ushort pPaddingForEmissionsPdu)
{ _paddingForEmissionsPdu = pPaddingForEmissionsPdu;
}

[XmlElement(Type= typeof(ushort), ElementName="paddingForEmissionsPdu")]
public ushort PaddingForEmissionsPdu
{
     get
{
          return _paddingForEmissionsPdu;
}
     set
{
          _paddingForEmissionsPdu = value;
}
}

   ///<summary>
   ///Electronic emmissions systems
   ///</summary>
public void setSystems(List<ElectronicEmissionSystemData> pSystems)
{ _systems = pSystems;
}

   ///<summary>
   ///Electronic emmissions systems
   ///</summary>
public List<ElectronicEmissionSystemData> getSystems()
{ return _systems; }

   ///<summary>
   ///Electronic emmissions systems
   ///</summary>
[XmlElement(ElementName = "systemsList",Type = typeof(List<ElectronicEmissionSystemData>))]
public List<ElectronicEmissionSystemData> Systems
{
     get
{
          return _systems;
}
     set
{
          _systems = value;
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
       _emittingEntityID.marshal(dos);
       _eventID.marshal(dos);
       dos.writeByte( (byte)_stateUpdateIndicator);
       dos.writeByte( (byte)_systems.Count);
       dos.writeUshort( (ushort)_paddingForEmissionsPdu);

       for(int idx = 0; idx < _systems.Count; idx++)
       {
            ElectronicEmissionSystemData aElectronicEmissionSystemData = (ElectronicEmissionSystemData)_systems[idx];
            aElectronicEmissionSystemData.marshal(dos);
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
       _emittingEntityID.unmarshal(dis);
       _eventID.unmarshal(dis);
       _stateUpdateIndicator = dis.readByte();
       _numberOfSystems = dis.readByte();
       _paddingForEmissionsPdu = dis.readUshort();
        for(int idx = 0; idx < _numberOfSystems; idx++)
        {
           ElectronicEmissionSystemData anX = new ElectronicEmissionSystemData();
            anX.unmarshal(dis);
            _systems.Add(anX);
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
    sb.Append("----- ElectronicEmissionsPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_emittingEntityID=====" + System.Environment.NewLine);
       _emittingEntityID.reflection(sb);
       sb.Append("=====_eventID=====" + System.Environment.NewLine);
       _eventID.reflection(sb);
           sb.Append("byte\t _stateUpdateIndicator\t " + _stateUpdateIndicator.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _systems\t " + _systems.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _paddingForEmissionsPdu\t " + _paddingForEmissionsPdu.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _systems.Count; idx++)
       {
           sb.Append("ElectronicEmissionSystemData\t " + _systems[idx] + System.Environment.NewLine);
            ElectronicEmissionSystemData aElectronicEmissionSystemData = (ElectronicEmissionSystemData)_systems[idx];
            aElectronicEmissionSystemData.reflection(sb);
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
 public bool equals(ElectronicEmissionsPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_emittingEntityID.Equals( rhs._emittingEntityID) )) ivarsEqual = false;
     if( ! (_eventID.Equals( rhs._eventID) )) ivarsEqual = false;
     if( ! (_stateUpdateIndicator == rhs._stateUpdateIndicator)) ivarsEqual = false;
     if( ! (_numberOfSystems == rhs._numberOfSystems)) ivarsEqual = false;
     if( ! (_paddingForEmissionsPdu == rhs._paddingForEmissionsPdu)) ivarsEqual = false;

     for(int idx = 0; idx < _systems.Count; idx++)
     {
        ElectronicEmissionSystemData x = (ElectronicEmissionSystemData)_systems[idx];
        if( ! ( _systems[idx].Equals(rhs._systems[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
