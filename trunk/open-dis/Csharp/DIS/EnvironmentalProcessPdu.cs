using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.11.1: Information about environmental effects and processes. This requires manual cleanup. the environmental        record is variable, as is the padding. UNFINISHED
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
[XmlInclude(typeof(EntityType))]
[XmlInclude(typeof(Environment))]
public class EnvironmentalProcessPdu : SyntheticEnvironmentFamilyPdu
{
   /** Environmental process ID */
   protected EntityID  _environementalProcessID = new EntityID(); 

   /** Environment type */
   protected EntityType  _environmentType = new EntityType(); 

   /** model type */
   protected byte  _modelType;

   /** Environment status */
   protected byte  _environmentStatus;

   /** number of environment records  */
   protected byte  _numberOfEnvironmentRecords;

   /** PDU sequence number for the environmentla process if pdu sequencing required */
   protected ushort  _sequenceNumber;

   /** environemt records */
   protected List<Environment> _environmentRecords = new List<Environment>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.11.1: Information about environmental effects and processes. This requires manual cleanup. the environmental        record is variable, as is the padding. UNFINISHED
   ///</summary>
 public EnvironmentalProcessPdu()
 {
    PduType = (byte)41;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _environementalProcessID.getMarshalledSize();  // _environementalProcessID
   marshalSize = marshalSize + _environmentType.getMarshalledSize();  // _environmentType
   marshalSize = marshalSize + 1;  // _modelType
   marshalSize = marshalSize + 1;  // _environmentStatus
   marshalSize = marshalSize + 1;  // _numberOfEnvironmentRecords
   marshalSize = marshalSize + 2;  // _sequenceNumber
   for(int idx=0; idx < _environmentRecords.Count; idx++)
   {
        Environment listElement = (Environment)_environmentRecords[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


   ///<summary>
   ///Environmental process ID
   ///</summary>
public void setEnvironementalProcessID(EntityID pEnvironementalProcessID)
{ _environementalProcessID = pEnvironementalProcessID;
}

   ///<summary>
   ///Environmental process ID
   ///</summary>
public EntityID getEnvironementalProcessID()
{ return _environementalProcessID; 
}

   ///<summary>
   ///Environmental process ID
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="environementalProcessID")]
public EntityID EnvironementalProcessID
{
     get
{
          return _environementalProcessID;
}
     set
{
          _environementalProcessID = value;
}
}

   ///<summary>
   ///Environment type
   ///</summary>
public void setEnvironmentType(EntityType pEnvironmentType)
{ _environmentType = pEnvironmentType;
}

   ///<summary>
   ///Environment type
   ///</summary>
public EntityType getEnvironmentType()
{ return _environmentType; 
}

   ///<summary>
   ///Environment type
   ///</summary>
[XmlElement(Type= typeof(EntityType), ElementName="environmentType")]
public EntityType EnvironmentType
{
     get
{
          return _environmentType;
}
     set
{
          _environmentType = value;
}
}

   ///<summary>
   ///model type
   ///</summary>
public void setModelType(byte pModelType)
{ _modelType = pModelType;
}

[XmlElement(Type= typeof(byte), ElementName="modelType")]
public byte ModelType
{
     get
{
          return _modelType;
}
     set
{
          _modelType = value;
}
}

   ///<summary>
   ///Environment status
   ///</summary>
public void setEnvironmentStatus(byte pEnvironmentStatus)
{ _environmentStatus = pEnvironmentStatus;
}

[XmlElement(Type= typeof(byte), ElementName="environmentStatus")]
public byte EnvironmentStatus
{
     get
{
          return _environmentStatus;
}
     set
{
          _environmentStatus = value;
}
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfEnvironmentRecords method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfEnvironmentRecords(byte pNumberOfEnvironmentRecords)
{ _numberOfEnvironmentRecords = pNumberOfEnvironmentRecords;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfEnvironmentRecords method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(byte), ElementName="numberOfEnvironmentRecords")]
public byte NumberOfEnvironmentRecords
{
     get
     {
          return _numberOfEnvironmentRecords;
     }
     set
     {
          _numberOfEnvironmentRecords = value;
     }
}

   ///<summary>
   ///PDU sequence number for the environmentla process if pdu sequencing required
   ///</summary>
public void setSequenceNumber(ushort pSequenceNumber)
{ _sequenceNumber = pSequenceNumber;
}

[XmlElement(Type= typeof(ushort), ElementName="sequenceNumber")]
public ushort SequenceNumber
{
     get
{
          return _sequenceNumber;
}
     set
{
          _sequenceNumber = value;
}
}

   ///<summary>
   ///environemt records
   ///</summary>
public void setEnvironmentRecords(List<Environment> pEnvironmentRecords)
{ _environmentRecords = pEnvironmentRecords;
}

   ///<summary>
   ///environemt records
   ///</summary>
public List<Environment> getEnvironmentRecords()
{ return _environmentRecords; }

   ///<summary>
   ///environemt records
   ///</summary>
[XmlElement(ElementName = "environmentRecordsList",Type = typeof(List<Environment>))]
public List<Environment> EnvironmentRecords
{
     get
{
          return _environmentRecords;
}
     set
{
          _environmentRecords = value;
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
       _environementalProcessID.marshal(dos);
       _environmentType.marshal(dos);
       dos.writeByte( (byte)_modelType);
       dos.writeByte( (byte)_environmentStatus);
       dos.writeByte( (byte)_environmentRecords.Count);
       dos.writeUshort( (ushort)_sequenceNumber);

       for(int idx = 0; idx < _environmentRecords.Count; idx++)
       {
            Environment aEnvironment = (Environment)_environmentRecords[idx];
            aEnvironment.marshal(dos);
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
       _environementalProcessID.unmarshal(dis);
       _environmentType.unmarshal(dis);
       _modelType = dis.readByte();
       _environmentStatus = dis.readByte();
       _numberOfEnvironmentRecords = dis.readByte();
       _sequenceNumber = dis.readUshort();
        for(int idx = 0; idx < _numberOfEnvironmentRecords; idx++)
        {
           Environment anX = new Environment();
            anX.unmarshal(dis);
            _environmentRecords.Add(anX);
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
    sb.Append("----- EnvironmentalProcessPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_environementalProcessID=====" + System.Environment.NewLine);
       _environementalProcessID.reflection(sb);
       sb.Append("=====_environmentType=====" + System.Environment.NewLine);
       _environmentType.reflection(sb);
           sb.Append("byte\t _modelType\t " + _modelType.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _environmentStatus\t " + _environmentStatus.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _environmentRecords\t " + _environmentRecords.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _sequenceNumber\t " + _sequenceNumber.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _environmentRecords.Count; idx++)
       {
           sb.Append("Environment\t " + _environmentRecords[idx] + System.Environment.NewLine);
            Environment aEnvironment = (Environment)_environmentRecords[idx];
            aEnvironment.reflection(sb);
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
 public bool equals(EnvironmentalProcessPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_environementalProcessID.Equals( rhs._environementalProcessID) )) ivarsEqual = false;
     if( ! (_environmentType.Equals( rhs._environmentType) )) ivarsEqual = false;
     if( ! (_modelType == rhs._modelType)) ivarsEqual = false;
     if( ! (_environmentStatus == rhs._environmentStatus)) ivarsEqual = false;
     if( ! (_numberOfEnvironmentRecords == rhs._numberOfEnvironmentRecords)) ivarsEqual = false;
     if( ! (_sequenceNumber == rhs._sequenceNumber)) ivarsEqual = false;

     for(int idx = 0; idx < _environmentRecords.Count; idx++)
     {
        Environment x = (Environment)_environmentRecords[idx];
        if( ! ( _environmentRecords[idx].Equals(rhs._environmentRecords[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
