using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.7.3. Information about underwater acoustic emmissions. This requires manual cleanup.  The beam data records should ALL be a the finish, rather than attached to each emitter system. UNFINISHED
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
[XmlInclude(typeof(ShaftRPMs))]
[XmlInclude(typeof(ApaData))]
[XmlInclude(typeof(AcousticEmitterSystemData))]
public class UaPdu : DistributedEmissionsFamilyPdu
{
   /** ID of the entity that is the source of the emission */
   protected EntityID  _emittingEntityID = new EntityID(); 

   /** ID of event */
   protected EventID  _eventID = new EventID(); 

   /** This field shall be used to indicate whether the data in the UA PDU represent a state update or data that have changed since issuance of the last UA PDU */
   protected byte  _stateChangeIndicator;

   /** padding */
   protected byte  _pad;

   /** This field indicates which database record (or file) shall be used in the definition of passive signature (unintentional) emissions of the entity. The indicated database record (or  file) shall define all noise generated as a function of propulsion plant configurations and associated  auxiliaries. */
   protected ushort  _passiveParameterIndex;

   /** This field shall specify the entity propulsion plant configuration. This field is used to determine the passive signature characteristics of an entity. */
   protected byte  _propulsionPlantConfiguration;

   /**  This field shall represent the number of shafts on a platform */
   protected byte  _numberOfShafts;

   /** This field shall indicate the number of APAs described in the current UA PDU */
   protected byte  _numberOfAPAs;

   /** This field shall specify the number of UA emitter systems being described in the current UA PDU */
   protected byte  _numberOfUAEmitterSystems;

   /** shaft RPM values */
   protected List<object> _shaftRPMs = new List<object>(); 
   /** apaData */
   protected List<object> _apaData = new List<object>(); 
   protected List<object> _emitterSystems = new List<object>(); 

/** Constructor */
 public UaPdu()
 {
    PduType = (byte)29;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _emittingEntityID.getMarshalledSize();  // _emittingEntityID
   marshalSize = marshalSize + _eventID.getMarshalledSize();  // _eventID
   marshalSize = marshalSize + 1;  // _stateChangeIndicator
   marshalSize = marshalSize + 1;  // _pad
   marshalSize = marshalSize + 2;  // _passiveParameterIndex
   marshalSize = marshalSize + 1;  // _propulsionPlantConfiguration
   marshalSize = marshalSize + 1;  // _numberOfShafts
   marshalSize = marshalSize + 1;  // _numberOfAPAs
   marshalSize = marshalSize + 1;  // _numberOfUAEmitterSystems
   for(int idx=0; idx < _shaftRPMs.Count; idx++)
   {
        ShaftRPMs listElement = (ShaftRPMs)_shaftRPMs[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _apaData.Count; idx++)
   {
        ApaData listElement = (ApaData)_apaData[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _emitterSystems.Count; idx++)
   {
        AcousticEmitterSystemData listElement = (AcousticEmitterSystemData)_emitterSystems[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEmittingEntityID(EntityID pEmittingEntityID)
{ _emittingEntityID = pEmittingEntityID;
}

public EntityID getEmittingEntityID()
{ return _emittingEntityID; 
}

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

public void setEventID(EventID pEventID)
{ _eventID = pEventID;
}

public EventID getEventID()
{ return _eventID; 
}

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

public void setStateChangeIndicator(byte pStateChangeIndicator)
{ _stateChangeIndicator = pStateChangeIndicator;
}

[XmlElement(Type= typeof(byte), ElementName="stateChangeIndicator")]
public byte StateChangeIndicator
{
     get
{
          return _stateChangeIndicator;
}
     set
{
          _stateChangeIndicator = value;
}
}

public void setPad(byte pPad)
{ _pad = pPad;
}

[XmlElement(Type= typeof(byte), ElementName="pad")]
public byte Pad
{
     get
{
          return _pad;
}
     set
{
          _pad = value;
}
}

public void setPassiveParameterIndex(ushort pPassiveParameterIndex)
{ _passiveParameterIndex = pPassiveParameterIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="passiveParameterIndex")]
public ushort PassiveParameterIndex
{
     get
{
          return _passiveParameterIndex;
}
     set
{
          _passiveParameterIndex = value;
}
}

public void setPropulsionPlantConfiguration(byte pPropulsionPlantConfiguration)
{ _propulsionPlantConfiguration = pPropulsionPlantConfiguration;
}

[XmlElement(Type= typeof(byte), ElementName="propulsionPlantConfiguration")]
public byte PropulsionPlantConfiguration
{
     get
{
          return _propulsionPlantConfiguration;
}
     set
{
          _propulsionPlantConfiguration = value;
}
}

public void setShaftRPMs(List<object> pShaftRPMs)
{ _shaftRPMs = pShaftRPMs;
}

public List<object> getShaftRPMs()
{ return _shaftRPMs; }

[XmlElement(ElementName = "shaftRPMsList",Type = typeof(List<object>))]
public List<object> ShaftRPMs
{
     get
{
          return _shaftRPMs;
}
     set
{
          _shaftRPMs = value;
}
}

public void setApaData(List<object> pApaData)
{ _apaData = pApaData;
}

public List<object> getApaData()
{ return _apaData; }

[XmlElement(ElementName = "apaDataList",Type = typeof(List<object>))]
public List<object> ApaData
{
     get
{
          return _apaData;
}
     set
{
          _apaData = value;
}
}

public void setEmitterSystems(List<object> pEmitterSystems)
{ _emitterSystems = pEmitterSystems;
}

public List<object> getEmitterSystems()
{ return _emitterSystems; }

[XmlElement(ElementName = "emitterSystemsList",Type = typeof(List<object>))]
public List<object> EmitterSystems
{
     get
{
          return _emitterSystems;
}
     set
{
          _emitterSystems = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _emittingEntityID.marshal(dos);
       _eventID.marshal(dos);
       dos.writeByte( (byte)_stateChangeIndicator);
       dos.writeByte( (byte)_pad);
       dos.writeUshort( (ushort)_passiveParameterIndex);
       dos.writeByte( (byte)_propulsionPlantConfiguration);
       dos.writeByte( (byte)_shaftRPMs.Count);
       dos.writeByte( (byte)_apaData.Count);
       dos.writeByte( (byte)_emitterSystems.Count);

       for(int idx = 0; idx < _shaftRPMs.Count; idx++)
       {
            ShaftRPMs aShaftRPMs = (ShaftRPMs)_shaftRPMs[idx];
            aShaftRPMs.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _apaData.Count; idx++)
       {
            ApaData aApaData = (ApaData)_apaData[idx];
            aApaData.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _emitterSystems.Count; idx++)
       {
            AcousticEmitterSystemData aAcousticEmitterSystemData = (AcousticEmitterSystemData)_emitterSystems[idx];
            aAcousticEmitterSystemData.marshal(dos);
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
       _stateChangeIndicator = dis.readByte();
       _pad = dis.readByte();
       _passiveParameterIndex = dis.readUshort();
       _propulsionPlantConfiguration = dis.readByte();
       _numberOfShafts = dis.readByte();
       _numberOfAPAs = dis.readByte();
       _numberOfUAEmitterSystems = dis.readByte();
        for(int idx = 0; idx < _numberOfShafts; idx++)
        {
           ShaftRPMs anX = new ShaftRPMs();
            anX.unmarshal(dis);
            _shaftRPMs.Add(anX);
        };

        for(int idx = 0; idx < _numberOfAPAs; idx++)
        {
           ApaData anX = new ApaData();
            anX.unmarshal(dis);
            _apaData.Add(anX);
        };

        for(int idx = 0; idx < _numberOfUAEmitterSystems; idx++)
        {
           AcousticEmitterSystemData anX = new AcousticEmitterSystemData();
            anX.unmarshal(dis);
            _emitterSystems.Add(anX);
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
    sb.Append("----- UaPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_emittingEntityID=====" + System.Environment.NewLine);
       _emittingEntityID.reflection(sb);
       sb.Append("=====_eventID=====" + System.Environment.NewLine);
       _eventID.reflection(sb);
           sb.Append("byte\t _stateChangeIndicator\t " + _stateChangeIndicator.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad\t " + _pad.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _passiveParameterIndex\t " + _passiveParameterIndex.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _propulsionPlantConfiguration\t " + _propulsionPlantConfiguration.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _shaftRPMs\t " + _shaftRPMs.Count.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _apaData\t " + _apaData.Count.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _emitterSystems\t " + _emitterSystems.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _shaftRPMs.Count; idx++)
       {
           sb.Append("ShaftRPMs\t " + _shaftRPMs[idx] + System.Environment.NewLine);
            ShaftRPMs aShaftRPMs = (ShaftRPMs)_shaftRPMs[idx];
            aShaftRPMs.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _apaData.Count; idx++)
       {
           sb.Append("ApaData\t " + _apaData[idx] + System.Environment.NewLine);
            ApaData aApaData = (ApaData)_apaData[idx];
            aApaData.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _emitterSystems.Count; idx++)
       {
           sb.Append("AcousticEmitterSystemData\t " + _emitterSystems[idx] + System.Environment.NewLine);
            AcousticEmitterSystemData aAcousticEmitterSystemData = (AcousticEmitterSystemData)_emitterSystems[idx];
            aAcousticEmitterSystemData.reflection(sb);
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
 public bool equals(UaPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_emittingEntityID.Equals( rhs._emittingEntityID) )) ivarsEqual = false;
     if( ! (_eventID.Equals( rhs._eventID) )) ivarsEqual = false;
     if( ! (_stateChangeIndicator == rhs._stateChangeIndicator)) ivarsEqual = false;
     if( ! (_pad == rhs._pad)) ivarsEqual = false;
     if( ! (_passiveParameterIndex == rhs._passiveParameterIndex)) ivarsEqual = false;
     if( ! (_propulsionPlantConfiguration == rhs._propulsionPlantConfiguration)) ivarsEqual = false;
     if( ! (_numberOfShafts == rhs._numberOfShafts)) ivarsEqual = false;
     if( ! (_numberOfAPAs == rhs._numberOfAPAs)) ivarsEqual = false;
     if( ! (_numberOfUAEmitterSystems == rhs._numberOfUAEmitterSystems)) ivarsEqual = false;

     for(int idx = 0; idx < _shaftRPMs.Count; idx++)
     {
        ShaftRPMs x = (ShaftRPMs)_shaftRPMs[idx];
        if( ! ( _shaftRPMs[idx].Equals(rhs._shaftRPMs[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _apaData.Count; idx++)
     {
        ApaData x = (ApaData)_apaData[idx];
        if( ! ( _apaData[idx].Equals(rhs._apaData[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _emitterSystems.Count; idx++)
     {
        AcousticEmitterSystemData x = (AcousticEmitterSystemData)_emitterSystems[idx];
        if( ! ( _emitterSystems[idx].Equals(rhs._emitterSystems[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
