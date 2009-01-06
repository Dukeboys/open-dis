using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.4.2. Information about stuff exploding. COMPLETE
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
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(BurstDescriptor))]
[XmlInclude(typeof(ArticulationParameter))]
public class DetonationPdu : WarfareFamilyPdu
{
   /** ID of muntion that was fired */
   protected EntityID  _munitionID = new EntityID(); 

   /** ID firing event */
   protected EventID  _eventID = new EventID(); 

   /** ID firing event */
   protected Vector3Float  _velocity = new Vector3Float(); 

   /** where the detonation is, in world coordinates */
   protected Vector3Double  _locationInWorldCoordinates = new Vector3Double(); 

   /** Describes munition used */
   protected BurstDescriptor  _burstDescriptor = new BurstDescriptor(); 

   /** location of the detonation or impact in the target entity's coordinate system. This information should be used for damage assessment. */
   protected Vector3Float  _locationInEntityCoordinates = new Vector3Float(); 

   /** result of the explosion */
   protected byte  _detonationResult;

   /** How many articulation parameters we have */
   protected byte  _numberOfArticulationParameters;

   /** padding */
   protected short  _pad = 0;

   protected List<object> _articulationParameters = new List<object>(); 

/** Constructor */
 public DetonationPdu()
 {
    PduType = (byte)3;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _munitionID.getMarshalledSize();  // _munitionID
   marshalSize = marshalSize + _eventID.getMarshalledSize();  // _eventID
   marshalSize = marshalSize + _velocity.getMarshalledSize();  // _velocity
   marshalSize = marshalSize + _locationInWorldCoordinates.getMarshalledSize();  // _locationInWorldCoordinates
   marshalSize = marshalSize + _burstDescriptor.getMarshalledSize();  // _burstDescriptor
   marshalSize = marshalSize + _locationInEntityCoordinates.getMarshalledSize();  // _locationInEntityCoordinates
   marshalSize = marshalSize + 1;  // _detonationResult
   marshalSize = marshalSize + 1;  // _numberOfArticulationParameters
   marshalSize = marshalSize + 2;  // _pad
   for(int idx=0; idx < _articulationParameters.Count; idx++)
   {
        ArticulationParameter listElement = (ArticulationParameter)_articulationParameters[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setMunitionID(EntityID pMunitionID)
{ _munitionID = pMunitionID;
}

public EntityID getMunitionID()
{ return _munitionID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="munitionID")]
public EntityID MunitionID
{
     get
{
          return _munitionID;
}
     set
{
          _munitionID = value;
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

public void setVelocity(Vector3Float pVelocity)
{ _velocity = pVelocity;
}

public Vector3Float getVelocity()
{ return _velocity; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="velocity")]
public Vector3Float Velocity
{
     get
{
          return _velocity;
}
     set
{
          _velocity = value;
}
}

public void setLocationInWorldCoordinates(Vector3Double pLocationInWorldCoordinates)
{ _locationInWorldCoordinates = pLocationInWorldCoordinates;
}

public Vector3Double getLocationInWorldCoordinates()
{ return _locationInWorldCoordinates; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="locationInWorldCoordinates")]
public Vector3Double LocationInWorldCoordinates
{
     get
{
          return _locationInWorldCoordinates;
}
     set
{
          _locationInWorldCoordinates = value;
}
}

public void setBurstDescriptor(BurstDescriptor pBurstDescriptor)
{ _burstDescriptor = pBurstDescriptor;
}

public BurstDescriptor getBurstDescriptor()
{ return _burstDescriptor; 
}

[XmlElement(Type= typeof(BurstDescriptor), ElementName="burstDescriptor")]
public BurstDescriptor BurstDescriptor
{
     get
{
          return _burstDescriptor;
}
     set
{
          _burstDescriptor = value;
}
}

public void setLocationInEntityCoordinates(Vector3Float pLocationInEntityCoordinates)
{ _locationInEntityCoordinates = pLocationInEntityCoordinates;
}

public Vector3Float getLocationInEntityCoordinates()
{ return _locationInEntityCoordinates; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="locationInEntityCoordinates")]
public Vector3Float LocationInEntityCoordinates
{
     get
{
          return _locationInEntityCoordinates;
}
     set
{
          _locationInEntityCoordinates = value;
}
}

public void setDetonationResult(byte pDetonationResult)
{ _detonationResult = pDetonationResult;
}

[XmlElement(Type= typeof(byte), ElementName="detonationResult")]
public byte DetonationResult
{
     get
{
          return _detonationResult;
}
     set
{
          _detonationResult = value;
}
}

public void setPad(short pPad)
{ _pad = pPad;
}

[XmlElement(Type= typeof(short), ElementName="pad")]
public short Pad
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

public void setArticulationParameters(List<object> pArticulationParameters)
{ _articulationParameters = pArticulationParameters;
}

public List<object> getArticulationParameters()
{ return _articulationParameters; }

[XmlElement(ElementName = "articulationParametersList",Type = typeof(List<object>))]
public List<object> ArticulationParameters
{
     get
{
          return _articulationParameters;
}
     set
{
          _articulationParameters = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _munitionID.marshal(dos);
       _eventID.marshal(dos);
       _velocity.marshal(dos);
       _locationInWorldCoordinates.marshal(dos);
       _burstDescriptor.marshal(dos);
       _locationInEntityCoordinates.marshal(dos);
       dos.writeByte( (byte)_detonationResult);
       dos.writeByte( (byte)_articulationParameters.Count);
       dos.writeShort( (short)_pad);

       for(int idx = 0; idx < _articulationParameters.Count; idx++)
       {
            ArticulationParameter aArticulationParameter = (ArticulationParameter)_articulationParameters[idx];
            aArticulationParameter.marshal(dos);
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
       _munitionID.unmarshal(dis);
       _eventID.unmarshal(dis);
       _velocity.unmarshal(dis);
       _locationInWorldCoordinates.unmarshal(dis);
       _burstDescriptor.unmarshal(dis);
       _locationInEntityCoordinates.unmarshal(dis);
       _detonationResult = dis.readByte();
       _numberOfArticulationParameters = dis.readByte();
       _pad = dis.readShort();
        for(int idx = 0; idx < _numberOfArticulationParameters; idx++)
        {
           ArticulationParameter anX = new ArticulationParameter();
            anX.unmarshal(dis);
            _articulationParameters.Add(anX);
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
    sb.Append("----- DetonationPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_munitionID=====" + System.Environment.NewLine);
       _munitionID.reflection(sb);
       sb.Append("=====_eventID=====" + System.Environment.NewLine);
       _eventID.reflection(sb);
       sb.Append("=====_velocity=====" + System.Environment.NewLine);
       _velocity.reflection(sb);
       sb.Append("=====_locationInWorldCoordinates=====" + System.Environment.NewLine);
       _locationInWorldCoordinates.reflection(sb);
       sb.Append("=====_burstDescriptor=====" + System.Environment.NewLine);
       _burstDescriptor.reflection(sb);
       sb.Append("=====_locationInEntityCoordinates=====" + System.Environment.NewLine);
       _locationInEntityCoordinates.reflection(sb);
           sb.Append("byte\t _detonationResult\t " + _detonationResult.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _articulationParameters\t " + _articulationParameters.Count.ToString() + System.Environment.NewLine);
           sb.Append("short\t _pad\t " + _pad.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _articulationParameters.Count; idx++)
       {
           sb.Append("ArticulationParameter\t " + _articulationParameters[idx] + System.Environment.NewLine);
            ArticulationParameter aArticulationParameter = (ArticulationParameter)_articulationParameters[idx];
            aArticulationParameter.reflection(sb);
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
 public bool equals(DetonationPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_munitionID.Equals( rhs._munitionID) )) ivarsEqual = false;
     if( ! (_eventID.Equals( rhs._eventID) )) ivarsEqual = false;
     if( ! (_velocity.Equals( rhs._velocity) )) ivarsEqual = false;
     if( ! (_locationInWorldCoordinates.Equals( rhs._locationInWorldCoordinates) )) ivarsEqual = false;
     if( ! (_burstDescriptor.Equals( rhs._burstDescriptor) )) ivarsEqual = false;
     if( ! (_locationInEntityCoordinates.Equals( rhs._locationInEntityCoordinates) )) ivarsEqual = false;
     if( ! (_detonationResult == rhs._detonationResult)) ivarsEqual = false;
     if( ! (_numberOfArticulationParameters == rhs._numberOfArticulationParameters)) ivarsEqual = false;
     if( ! (_pad == rhs._pad)) ivarsEqual = false;

     for(int idx = 0; idx < _articulationParameters.Count; idx++)
     {
        ArticulationParameter x = (ArticulationParameter)_articulationParameters[idx];
        if( ! ( _articulationParameters[idx].Equals(rhs._articulationParameters[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
