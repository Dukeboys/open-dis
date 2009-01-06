using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.3.3.4. Nonstatic information about a particular entity may be communicated by issuing an Entity State Update PDU. COMPLETE
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
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(Orientation))]
[XmlInclude(typeof(ArticulationParameter))]
public class EntityStateUpdatePdu : EntityInformationFamilyPdu
{
   /** This field shall identify the entity issuing the PDU */
   protected EntityID  _entityID = new EntityID(); 

   /** How many articulation parameters are in the variable length list */
   protected byte  _numberOfArticulationParameters;

   /** Describes the speed of the entity in the world */
   protected Vector3Float  _entityLinearVelocity = new Vector3Float(); 

   /** describes the location of the entity in the world */
   protected Vector3Double  _entityLocation = new Vector3Double(); 

   /** describes the orientation of the entity, in euler angles */
   protected Orientation  _entityOrientation = new Orientation(); 

   /** a series of bit flags that are used to help draw the entity, such as smoking, on fire, etc. */
   protected uint  _entityAppearance;

   protected List<object> _articulationParameters = new List<object>(); 

/** Constructor */
 public EntityStateUpdatePdu()
 {
    PduType = (byte)67;
    ProtocolFamily = (byte)1;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _entityID.getMarshalledSize();  // _entityID
   marshalSize = marshalSize + 1;  // _numberOfArticulationParameters
   marshalSize = marshalSize + _entityLinearVelocity.getMarshalledSize();  // _entityLinearVelocity
   marshalSize = marshalSize + _entityLocation.getMarshalledSize();  // _entityLocation
   marshalSize = marshalSize + _entityOrientation.getMarshalledSize();  // _entityOrientation
   marshalSize = marshalSize + 4;  // _entityAppearance
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
       dos.writeByte( (byte)_articulationParameters.Count);
       _entityLinearVelocity.marshal(dos);
       _entityLocation.marshal(dos);
       _entityOrientation.marshal(dos);
       dos.writeUint( (uint)_entityAppearance);

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
       _numberOfArticulationParameters = dis.readByte();
       _entityLinearVelocity.unmarshal(dis);
       _entityLocation.unmarshal(dis);
       _entityOrientation.unmarshal(dis);
       _entityAppearance = dis.readUint();
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
    sb.Append("----- EntityStateUpdatePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_entityID=====" + System.Environment.NewLine);
       _entityID.reflection(sb);
           sb.Append("byte\t _articulationParameters\t " + _articulationParameters.Count.ToString() + System.Environment.NewLine);
       sb.Append("=====_entityLinearVelocity=====" + System.Environment.NewLine);
       _entityLinearVelocity.reflection(sb);
       sb.Append("=====_entityLocation=====" + System.Environment.NewLine);
       _entityLocation.reflection(sb);
       sb.Append("=====_entityOrientation=====" + System.Environment.NewLine);
       _entityOrientation.reflection(sb);
           sb.Append("uint\t _entityAppearance\t " + _entityAppearance.ToString() + System.Environment.NewLine);

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
 public bool equals(EntityStateUpdatePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_entityID.Equals( rhs._entityID) )) ivarsEqual = false;
     if( ! (_numberOfArticulationParameters == rhs._numberOfArticulationParameters)) ivarsEqual = false;
     if( ! (_entityLinearVelocity.Equals( rhs._entityLinearVelocity) )) ivarsEqual = false;
     if( ! (_entityLocation.Equals( rhs._entityLocation) )) ivarsEqual = false;
     if( ! (_entityOrientation.Equals( rhs._entityOrientation) )) ivarsEqual = false;
     if( ! (_entityAppearance == rhs._entityAppearance)) ivarsEqual = false;

     for(int idx = 0; idx < _articulationParameters.Count; idx++)
     {
        ArticulationParameter x = (ArticulationParameter)_articulationParameters[idx];
        if( ! ( _articulationParameters[idx].Equals(rhs._articulationParameters[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
