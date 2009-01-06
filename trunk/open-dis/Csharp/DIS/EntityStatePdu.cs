using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.3.1. Represents the postion and state of one entity in the world. COMPLETE
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
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(Orientation))]
[XmlInclude(typeof(DeadReckoningParameter))]
[XmlInclude(typeof(Marking))]
[XmlInclude(typeof(ArticulationParameter))]
public class EntityStatePdu : EntityInformationFamilyPdu
{
   /** Unique ID for an entity that is tied to this state information */
   protected EntityID  _entityID = new EntityID(); 

   /** What force this entity is affiliated with, eg red, blue, neutral, etc */
   protected byte  _forceId;

   /** How many articulation parameters are in the variable length list */
   protected byte  _numberOfArticulationParameters;

   /** Describes the type of entity in the world */
   protected EntityType  _entityType = new EntityType(); 

   protected EntityType  _alternativeEntityType = new EntityType(); 

   /** Describes the speed of the entity in the world */
   protected Vector3Float  _entityLinearVelocity = new Vector3Float(); 

   /** describes the location of the entity in the world */
   protected Vector3Double  _entityLocation = new Vector3Double(); 

   /** describes the orientation of the entity, in euler angles */
   protected Orientation  _entityOrientation = new Orientation(); 

   /** a series of bit flags that are used to help draw the entity, such as smoking, on fire, etc. */
   protected uint  _entityAppearance;

   /** parameters used for dead reckoning */
   protected DeadReckoningParameter  _deadReckoningParameters = new DeadReckoningParameter(); 

   /** characters that can be used for debugging, or to draw unique strings on the side of entities in the world */
   protected Marking  _marking = new Marking(); 

   /** a series of bit flags */
   protected uint  _capabilities;

   /** variable length list of articulation parameters */
   protected List<object> _articulationParameters = new List<object>(); 

/** Constructor */
 public EntityStatePdu()
 {
    PduType = (byte)1;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _entityID.getMarshalledSize();  // _entityID
   marshalSize = marshalSize + 1;  // _forceId
   marshalSize = marshalSize + 1;  // _numberOfArticulationParameters
   marshalSize = marshalSize + _entityType.getMarshalledSize();  // _entityType
   marshalSize = marshalSize + _alternativeEntityType.getMarshalledSize();  // _alternativeEntityType
   marshalSize = marshalSize + _entityLinearVelocity.getMarshalledSize();  // _entityLinearVelocity
   marshalSize = marshalSize + _entityLocation.getMarshalledSize();  // _entityLocation
   marshalSize = marshalSize + _entityOrientation.getMarshalledSize();  // _entityOrientation
   marshalSize = marshalSize + 4;  // _entityAppearance
   marshalSize = marshalSize + _deadReckoningParameters.getMarshalledSize();  // _deadReckoningParameters
   marshalSize = marshalSize + _marking.getMarshalledSize();  // _marking
   marshalSize = marshalSize + 4;  // _capabilities
   for(int idx=0; idx < _articulationParameters.Count; idx++)
   {
        ArticulationParameter listElement = (ArticulationParameter)_articulationParameters[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEntityID(EntityID pEntityID)
{ _entityID = pEntityID;
}

public EntityID getEntityID()
{ return _entityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="entityID")]
public EntityID EntityID
{
     get
{
          return _entityID;
}
     set
{
          _entityID = value;
}
}

public void setForceId(byte pForceId)
{ _forceId = pForceId;
}

[XmlElement(Type= typeof(byte), ElementName="forceId")]
public byte ForceId
{
     get
{
          return _forceId;
}
     set
{
          _forceId = value;
}
}

public void setEntityType(EntityType pEntityType)
{ _entityType = pEntityType;
}

public EntityType getEntityType()
{ return _entityType; 
}

[XmlElement(Type= typeof(EntityType), ElementName="entityType")]
public EntityType EntityType
{
     get
{
          return _entityType;
}
     set
{
          _entityType = value;
}
}

public void setAlternativeEntityType(EntityType pAlternativeEntityType)
{ _alternativeEntityType = pAlternativeEntityType;
}

public EntityType getAlternativeEntityType()
{ return _alternativeEntityType; 
}

[XmlElement(Type= typeof(EntityType), ElementName="alternativeEntityType")]
public EntityType AlternativeEntityType
{
     get
{
          return _alternativeEntityType;
}
     set
{
          _alternativeEntityType = value;
}
}

public void setEntityLinearVelocity(Vector3Float pEntityLinearVelocity)
{ _entityLinearVelocity = pEntityLinearVelocity;
}

public Vector3Float getEntityLinearVelocity()
{ return _entityLinearVelocity; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="entityLinearVelocity")]
public Vector3Float EntityLinearVelocity
{
     get
{
          return _entityLinearVelocity;
}
     set
{
          _entityLinearVelocity = value;
}
}

public void setEntityLocation(Vector3Double pEntityLocation)
{ _entityLocation = pEntityLocation;
}

public Vector3Double getEntityLocation()
{ return _entityLocation; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="entityLocation")]
public Vector3Double EntityLocation
{
     get
{
          return _entityLocation;
}
     set
{
          _entityLocation = value;
}
}

public void setEntityOrientation(Orientation pEntityOrientation)
{ _entityOrientation = pEntityOrientation;
}

public Orientation getEntityOrientation()
{ return _entityOrientation; 
}

[XmlElement(Type= typeof(Orientation), ElementName="entityOrientation")]
public Orientation EntityOrientation
{
     get
{
          return _entityOrientation;
}
     set
{
          _entityOrientation = value;
}
}

public void setEntityAppearance(uint pEntityAppearance)
{ _entityAppearance = pEntityAppearance;
}

[XmlElement(Type= typeof(uint), ElementName="entityAppearance")]
public uint EntityAppearance
{
     get
{
          return _entityAppearance;
}
     set
{
          _entityAppearance = value;
}
}

public void setDeadReckoningParameters(DeadReckoningParameter pDeadReckoningParameters)
{ _deadReckoningParameters = pDeadReckoningParameters;
}

public DeadReckoningParameter getDeadReckoningParameters()
{ return _deadReckoningParameters; 
}

[XmlElement(Type= typeof(DeadReckoningParameter), ElementName="deadReckoningParameters")]
public DeadReckoningParameter DeadReckoningParameters
{
     get
{
          return _deadReckoningParameters;
}
     set
{
          _deadReckoningParameters = value;
}
}

public void setMarking(Marking pMarking)
{ _marking = pMarking;
}

public Marking getMarking()
{ return _marking; 
}

[XmlElement(Type= typeof(Marking), ElementName="marking")]
public Marking Marking
{
     get
{
          return _marking;
}
     set
{
          _marking = value;
}
}

public void setCapabilities(uint pCapabilities)
{ _capabilities = pCapabilities;
}

[XmlElement(Type= typeof(uint), ElementName="capabilities")]
public uint Capabilities
{
     get
{
          return _capabilities;
}
     set
{
          _capabilities = value;
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
       _entityID.marshal(dos);
       dos.writeByte( (byte)_forceId);
       dos.writeByte( (byte)_articulationParameters.Count);
       _entityType.marshal(dos);
       _alternativeEntityType.marshal(dos);
       _entityLinearVelocity.marshal(dos);
       _entityLocation.marshal(dos);
       _entityOrientation.marshal(dos);
       dos.writeUint( (uint)_entityAppearance);
       _deadReckoningParameters.marshal(dos);
       _marking.marshal(dos);
       dos.writeUint( (uint)_capabilities);

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
       _entityID.unmarshal(dis);
       _forceId = dis.readByte();
       _numberOfArticulationParameters = dis.readByte();
       _entityType.unmarshal(dis);
       _alternativeEntityType.unmarshal(dis);
       _entityLinearVelocity.unmarshal(dis);
       _entityLocation.unmarshal(dis);
       _entityOrientation.unmarshal(dis);
       _entityAppearance = dis.readUint();
       _deadReckoningParameters.unmarshal(dis);
       _marking.unmarshal(dis);
       _capabilities = dis.readUint();
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
    sb.Append("----- EntityStatePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_entityID=====" + System.Environment.NewLine);
       _entityID.reflection(sb);
           sb.Append("byte\t _forceId\t " + _forceId.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _articulationParameters\t " + _articulationParameters.Count.ToString() + System.Environment.NewLine);
       sb.Append("=====_entityType=====" + System.Environment.NewLine);
       _entityType.reflection(sb);
       sb.Append("=====_alternativeEntityType=====" + System.Environment.NewLine);
       _alternativeEntityType.reflection(sb);
       sb.Append("=====_entityLinearVelocity=====" + System.Environment.NewLine);
       _entityLinearVelocity.reflection(sb);
       sb.Append("=====_entityLocation=====" + System.Environment.NewLine);
       _entityLocation.reflection(sb);
       sb.Append("=====_entityOrientation=====" + System.Environment.NewLine);
       _entityOrientation.reflection(sb);
           sb.Append("uint\t _entityAppearance\t " + _entityAppearance.ToString() + System.Environment.NewLine);
       sb.Append("=====_deadReckoningParameters=====" + System.Environment.NewLine);
       _deadReckoningParameters.reflection(sb);
       sb.Append("=====_marking=====" + System.Environment.NewLine);
       _marking.reflection(sb);
           sb.Append("uint\t _capabilities\t " + _capabilities.ToString() + System.Environment.NewLine);

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
 public bool equals(EntityStatePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_entityID.Equals( rhs._entityID) )) ivarsEqual = false;
     if( ! (_forceId == rhs._forceId)) ivarsEqual = false;
     if( ! (_numberOfArticulationParameters == rhs._numberOfArticulationParameters)) ivarsEqual = false;
     if( ! (_entityType.Equals( rhs._entityType) )) ivarsEqual = false;
     if( ! (_alternativeEntityType.Equals( rhs._alternativeEntityType) )) ivarsEqual = false;
     if( ! (_entityLinearVelocity.Equals( rhs._entityLinearVelocity) )) ivarsEqual = false;
     if( ! (_entityLocation.Equals( rhs._entityLocation) )) ivarsEqual = false;
     if( ! (_entityOrientation.Equals( rhs._entityOrientation) )) ivarsEqual = false;
     if( ! (_entityAppearance == rhs._entityAppearance)) ivarsEqual = false;
     if( ! (_deadReckoningParameters.Equals( rhs._deadReckoningParameters) )) ivarsEqual = false;
     if( ! (_marking.Equals( rhs._marking) )) ivarsEqual = false;
     if( ! (_capabilities == rhs._capabilities)) ivarsEqual = false;

     for(int idx = 0; idx < _articulationParameters.Count; idx++)
     {
        ArticulationParameter x = (ArticulationParameter)_articulationParameters[idx];
        if( ! ( _articulationParameters[idx].Equals(rhs._articulationParameters[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
