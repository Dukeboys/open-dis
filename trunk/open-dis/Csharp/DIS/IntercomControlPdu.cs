using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.8.5. Detailed inofrmation about the state of an intercom device and the actions it is requestion         of another intercom device, or the response to a requested action. Required manual intervention to fix the intercom parameters,        which can be of varialbe length. UNFINSISHED
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
[XmlInclude(typeof(IntercomCommunicationsParameters))]
public class IntercomControlPdu : RadioCommunicationsFamilyPdu
{
   /** control type */
   protected byte  _controlType;

   /** control type */
   protected byte  _communicationsChannelType;

   /** Source entity ID */
   protected EntityID  _sourceEntityID = new EntityID(); 

   /** The specific intercom device being simulated within an entity. */
   protected byte  _sourceCommunicationsDeviceID;

   /** Line number to which the intercom control refers */
   protected byte  _sourceLineID;

   /** priority of this message relative to transmissons from other intercom devices */
   protected byte  _transmitPriority;

   /** current transmit state of the line */
   protected byte  _transmitLineState;

   /** detailed type requested. */
   protected byte  _command;

   /** eid of the entity that has created this intercom channel. */
   protected EntityID  _masterEntityID = new EntityID(); 

   /** specific intercom device that has created this intercom channel */
   protected ushort  _masterCommunicationsDeviceID;

   /** number of intercom parameters */
   protected uint  _intercomParametersLength;

   /** @@@This is wrong--the length of the data field is variable. Using a long for now. */
   protected List<IntercomCommunicationsParameters> _intercomParameters = new List<IntercomCommunicationsParameters>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.8.5. Detailed inofrmation about the state of an intercom device and the actions it is requestion         of another intercom device, or the response to a requested action. Required manual intervention to fix the intercom parameters,        which can be of varialbe length. UNFINSISHED
   ///</summary>
 public IntercomControlPdu()
 {
    PduType = (byte)32;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 1;  // _controlType
   marshalSize = marshalSize + 1;  // _communicationsChannelType
   marshalSize = marshalSize + _sourceEntityID.getMarshalledSize();  // _sourceEntityID
   marshalSize = marshalSize + 1;  // _sourceCommunicationsDeviceID
   marshalSize = marshalSize + 1;  // _sourceLineID
   marshalSize = marshalSize + 1;  // _transmitPriority
   marshalSize = marshalSize + 1;  // _transmitLineState
   marshalSize = marshalSize + 1;  // _command
   marshalSize = marshalSize + _masterEntityID.getMarshalledSize();  // _masterEntityID
   marshalSize = marshalSize + 2;  // _masterCommunicationsDeviceID
   marshalSize = marshalSize + 4;  // _intercomParametersLength
   for(int idx=0; idx < _intercomParameters.Count; idx++)
   {
        IntercomCommunicationsParameters listElement = (IntercomCommunicationsParameters)_intercomParameters[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


   ///<summary>
   ///control type
   ///</summary>
public void setControlType(byte pControlType)
{ _controlType = pControlType;
}

[XmlElement(Type= typeof(byte), ElementName="controlType")]
public byte ControlType
{
     get
{
          return _controlType;
}
     set
{
          _controlType = value;
}
}

   ///<summary>
   ///control type
   ///</summary>
public void setCommunicationsChannelType(byte pCommunicationsChannelType)
{ _communicationsChannelType = pCommunicationsChannelType;
}

[XmlElement(Type= typeof(byte), ElementName="communicationsChannelType")]
public byte CommunicationsChannelType
{
     get
{
          return _communicationsChannelType;
}
     set
{
          _communicationsChannelType = value;
}
}

   ///<summary>
   ///Source entity ID
   ///</summary>
public void setSourceEntityID(EntityID pSourceEntityID)
{ _sourceEntityID = pSourceEntityID;
}

   ///<summary>
   ///Source entity ID
   ///</summary>
public EntityID getSourceEntityID()
{ return _sourceEntityID; 
}

   ///<summary>
   ///Source entity ID
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="sourceEntityID")]
public EntityID SourceEntityID
{
     get
{
          return _sourceEntityID;
}
     set
{
          _sourceEntityID = value;
}
}

   ///<summary>
   ///The specific intercom device being simulated within an entity.
   ///</summary>
public void setSourceCommunicationsDeviceID(byte pSourceCommunicationsDeviceID)
{ _sourceCommunicationsDeviceID = pSourceCommunicationsDeviceID;
}

[XmlElement(Type= typeof(byte), ElementName="sourceCommunicationsDeviceID")]
public byte SourceCommunicationsDeviceID
{
     get
{
          return _sourceCommunicationsDeviceID;
}
     set
{
          _sourceCommunicationsDeviceID = value;
}
}

   ///<summary>
   ///Line number to which the intercom control refers
   ///</summary>
public void setSourceLineID(byte pSourceLineID)
{ _sourceLineID = pSourceLineID;
}

[XmlElement(Type= typeof(byte), ElementName="sourceLineID")]
public byte SourceLineID
{
     get
{
          return _sourceLineID;
}
     set
{
          _sourceLineID = value;
}
}

   ///<summary>
   ///priority of this message relative to transmissons from other intercom devices
   ///</summary>
public void setTransmitPriority(byte pTransmitPriority)
{ _transmitPriority = pTransmitPriority;
}

[XmlElement(Type= typeof(byte), ElementName="transmitPriority")]
public byte TransmitPriority
{
     get
{
          return _transmitPriority;
}
     set
{
          _transmitPriority = value;
}
}

   ///<summary>
   ///current transmit state of the line
   ///</summary>
public void setTransmitLineState(byte pTransmitLineState)
{ _transmitLineState = pTransmitLineState;
}

[XmlElement(Type= typeof(byte), ElementName="transmitLineState")]
public byte TransmitLineState
{
     get
{
          return _transmitLineState;
}
     set
{
          _transmitLineState = value;
}
}

   ///<summary>
   ///detailed type requested.
   ///</summary>
public void setCommand(byte pCommand)
{ _command = pCommand;
}

[XmlElement(Type= typeof(byte), ElementName="command")]
public byte Command
{
     get
{
          return _command;
}
     set
{
          _command = value;
}
}

   ///<summary>
   ///eid of the entity that has created this intercom channel.
   ///</summary>
public void setMasterEntityID(EntityID pMasterEntityID)
{ _masterEntityID = pMasterEntityID;
}

   ///<summary>
   ///eid of the entity that has created this intercom channel.
   ///</summary>
public EntityID getMasterEntityID()
{ return _masterEntityID; 
}

   ///<summary>
   ///eid of the entity that has created this intercom channel.
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="masterEntityID")]
public EntityID MasterEntityID
{
     get
{
          return _masterEntityID;
}
     set
{
          _masterEntityID = value;
}
}

   ///<summary>
   ///specific intercom device that has created this intercom channel
   ///</summary>
public void setMasterCommunicationsDeviceID(ushort pMasterCommunicationsDeviceID)
{ _masterCommunicationsDeviceID = pMasterCommunicationsDeviceID;
}

[XmlElement(Type= typeof(ushort), ElementName="masterCommunicationsDeviceID")]
public ushort MasterCommunicationsDeviceID
{
     get
{
          return _masterCommunicationsDeviceID;
}
     set
{
          _masterCommunicationsDeviceID = value;
}
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getintercomParametersLength method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setIntercomParametersLength(uint pIntercomParametersLength)
{ _intercomParametersLength = pIntercomParametersLength;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getintercomParametersLength method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(uint), ElementName="intercomParametersLength")]
public uint IntercomParametersLength
{
     get
     {
          return _intercomParametersLength;
     }
     set
     {
          _intercomParametersLength = value;
     }
}

   ///<summary>
   ///@@@This is wrong--the length of the data field is variable. Using a long for now.
   ///</summary>
public void setIntercomParameters(List<IntercomCommunicationsParameters> pIntercomParameters)
{ _intercomParameters = pIntercomParameters;
}

   ///<summary>
   ///@@@This is wrong--the length of the data field is variable. Using a long for now.
   ///</summary>
public List<IntercomCommunicationsParameters> getIntercomParameters()
{ return _intercomParameters; }

   ///<summary>
   ///@@@This is wrong--the length of the data field is variable. Using a long for now.
   ///</summary>
[XmlElement(ElementName = "intercomParametersList",Type = typeof(List<IntercomCommunicationsParameters>))]
public List<IntercomCommunicationsParameters> IntercomParameters
{
     get
{
          return _intercomParameters;
}
     set
{
          _intercomParameters = value;
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
       dos.writeByte( (byte)_controlType);
       dos.writeByte( (byte)_communicationsChannelType);
       _sourceEntityID.marshal(dos);
       dos.writeByte( (byte)_sourceCommunicationsDeviceID);
       dos.writeByte( (byte)_sourceLineID);
       dos.writeByte( (byte)_transmitPriority);
       dos.writeByte( (byte)_transmitLineState);
       dos.writeByte( (byte)_command);
       _masterEntityID.marshal(dos);
       dos.writeUshort( (ushort)_masterCommunicationsDeviceID);
       dos.writeUint( (uint)_intercomParameters.Count);

       for(int idx = 0; idx < _intercomParameters.Count; idx++)
       {
            IntercomCommunicationsParameters aIntercomCommunicationsParameters = (IntercomCommunicationsParameters)_intercomParameters[idx];
            aIntercomCommunicationsParameters.marshal(dos);
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
       _controlType = dis.readByte();
       _communicationsChannelType = dis.readByte();
       _sourceEntityID.unmarshal(dis);
       _sourceCommunicationsDeviceID = dis.readByte();
       _sourceLineID = dis.readByte();
       _transmitPriority = dis.readByte();
       _transmitLineState = dis.readByte();
       _command = dis.readByte();
       _masterEntityID.unmarshal(dis);
       _masterCommunicationsDeviceID = dis.readUshort();
       _intercomParametersLength = dis.readUint();
        for(int idx = 0; idx < _intercomParametersLength; idx++)
        {
           IntercomCommunicationsParameters anX = new IntercomCommunicationsParameters();
            anX.unmarshal(dis);
            _intercomParameters.Add(anX);
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
    sb.Append("----- IntercomControlPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("byte\t _controlType\t " + _controlType.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _communicationsChannelType\t " + _communicationsChannelType.ToString() + System.Environment.NewLine);
       sb.Append("=====_sourceEntityID=====" + System.Environment.NewLine);
       _sourceEntityID.reflection(sb);
           sb.Append("byte\t _sourceCommunicationsDeviceID\t " + _sourceCommunicationsDeviceID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _sourceLineID\t " + _sourceLineID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _transmitPriority\t " + _transmitPriority.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _transmitLineState\t " + _transmitLineState.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _command\t " + _command.ToString() + System.Environment.NewLine);
       sb.Append("=====_masterEntityID=====" + System.Environment.NewLine);
       _masterEntityID.reflection(sb);
           sb.Append("ushort\t _masterCommunicationsDeviceID\t " + _masterCommunicationsDeviceID.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _intercomParameters\t " + _intercomParameters.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _intercomParameters.Count; idx++)
       {
           sb.Append("IntercomCommunicationsParameters\t " + _intercomParameters[idx] + System.Environment.NewLine);
            IntercomCommunicationsParameters aIntercomCommunicationsParameters = (IntercomCommunicationsParameters)_intercomParameters[idx];
            aIntercomCommunicationsParameters.reflection(sb);
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
 public bool equals(IntercomControlPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_controlType == rhs._controlType)) ivarsEqual = false;
     if( ! (_communicationsChannelType == rhs._communicationsChannelType)) ivarsEqual = false;
     if( ! (_sourceEntityID.Equals( rhs._sourceEntityID) )) ivarsEqual = false;
     if( ! (_sourceCommunicationsDeviceID == rhs._sourceCommunicationsDeviceID)) ivarsEqual = false;
     if( ! (_sourceLineID == rhs._sourceLineID)) ivarsEqual = false;
     if( ! (_transmitPriority == rhs._transmitPriority)) ivarsEqual = false;
     if( ! (_transmitLineState == rhs._transmitLineState)) ivarsEqual = false;
     if( ! (_command == rhs._command)) ivarsEqual = false;
     if( ! (_masterEntityID.Equals( rhs._masterEntityID) )) ivarsEqual = false;
     if( ! (_masterCommunicationsDeviceID == rhs._masterCommunicationsDeviceID)) ivarsEqual = false;
     if( ! (_intercomParametersLength == rhs._intercomParametersLength)) ivarsEqual = false;

     for(int idx = 0; idx < _intercomParameters.Count; idx++)
     {
        IntercomCommunicationsParameters x = (IntercomCommunicationsParameters)_intercomParameters[idx];
        if( ! ( _intercomParameters[idx].Equals(rhs._intercomParameters[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
