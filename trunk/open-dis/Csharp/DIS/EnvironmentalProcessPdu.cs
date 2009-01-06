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
   protected List<object> _environmentRecords = new List<object>(); 

/** Constructor */
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


public void setEnvironementalProcessID(EntityID pEnvironementalProcessID)
{ _environementalProcessID = pEnvironementalProcessID;
}

public EntityID getEnvironementalProcessID()
{ return _environementalProcessID; 
}

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

public void setEnvironmentType(EntityType pEnvironmentType)
{ _environmentType = pEnvironmentType;
}

public EntityType getEnvironmentType()
{ return _environmentType; 
}

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

public void setEnvironmentRecords(List<object> pEnvironmentRecords)
{ _environmentRecords = pEnvironmentRecords;
}

public List<object> getEnvironmentRecords()
{ return _environmentRecords; }

[XmlElement(ElementName = "environmentRecordsList",Type = typeof(List<object>))]
public List<object> EnvironmentRecords
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
  * The equals method doesn't always work--mostly it works only on on classes that consist only of primitives. Be careful.
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
