using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.3.2. Information about a collision. COMPLETE
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
public class CollisionPdu : EntityInformationFamilyPdu
{
   /** ID of the entity that issued the collision PDU */
   protected EntityID  _issuingEntityID = new EntityID(); 

   /** ID of entity that has collided with the issuing entity ID */
   protected EntityID  _collidingEntityID = new EntityID(); 

   /** ID of event */
   protected EventID  _eventID = new EventID(); 

   /** ID of event */
   protected byte  _collisionType;

   /** some padding */
   protected byte  _pad = 0;

   /** velocity at collision */
   protected Vector3Float  _velocity = new Vector3Float(); 

   /** mass of issuing entity */
   protected float  _mass;

   /** Location with respect to entity the issuing entity collided with */
   protected Vector3Float  _location = new Vector3Float(); 


/** Constructor */
 public CollisionPdu()
 {
    PduType = (byte)4;
    ProtocolFamily = (byte)1;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _issuingEntityID.getMarshalledSize();  // _issuingEntityID
   marshalSize = marshalSize + _collidingEntityID.getMarshalledSize();  // _collidingEntityID
   marshalSize = marshalSize + _eventID.getMarshalledSize();  // _eventID
   marshalSize = marshalSize + 1;  // _collisionType
   marshalSize = marshalSize + 1;  // _pad
   marshalSize = marshalSize + _velocity.getMarshalledSize();  // _velocity
   marshalSize = marshalSize + 4;  // _mass
   marshalSize = marshalSize + _location.getMarshalledSize();  // _location

   return marshalSize;
}


public void setIssuingEntityID(EntityID pIssuingEntityID)
{ _issuingEntityID = pIssuingEntityID;
}

public EntityID getIssuingEntityID()
{ return _issuingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="issuingEntityID")]
public EntityID IssuingEntityID
{
     get
{
          return _issuingEntityID;
}
     set
{
          _issuingEntityID = value;
}
}

public void setCollidingEntityID(EntityID pCollidingEntityID)
{ _collidingEntityID = pCollidingEntityID;
}

public EntityID getCollidingEntityID()
{ return _collidingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="collidingEntityID")]
public EntityID CollidingEntityID
{
     get
{
          return _collidingEntityID;
}
     set
{
          _collidingEntityID = value;
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

public void setCollisionType(byte pCollisionType)
{ _collisionType = pCollisionType;
}

[XmlElement(Type= typeof(byte), ElementName="collisionType")]
public byte CollisionType
{
     get
{
          return _collisionType;
}
     set
{
          _collisionType = value;
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

public void setMass(float pMass)
{ _mass = pMass;
}

[XmlElement(Type= typeof(float), ElementName="mass")]
public float Mass
{
     get
{
          return _mass;
}
     set
{
          _mass = value;
}
}

public void setLocation(Vector3Float pLocation)
{ _location = pLocation;
}

public Vector3Float getLocation()
{ return _location; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="location")]
public Vector3Float Location
{
     get
{
          return _location;
}
     set
{
          _location = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _issuingEntityID.marshal(dos);
       _collidingEntityID.marshal(dos);
       _eventID.marshal(dos);
       dos.writeByte( (byte)_collisionType);
       dos.writeByte( (byte)_pad);
       _velocity.marshal(dos);
       dos.writeFloat( (float)_mass);
       _location.marshal(dos);
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
       _issuingEntityID.unmarshal(dis);
       _collidingEntityID.unmarshal(dis);
       _eventID.unmarshal(dis);
       _collisionType = dis.readByte();
       _pad = dis.readByte();
       _velocity.unmarshal(dis);
       _mass = dis.readFloat();
       _location.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- CollisionPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_issuingEntityID=====" + System.Environment.NewLine);
       _issuingEntityID.reflection(sb);
       sb.Append("=====_collidingEntityID=====" + System.Environment.NewLine);
       _collidingEntityID.reflection(sb);
       sb.Append("=====_eventID=====" + System.Environment.NewLine);
       _eventID.reflection(sb);
           sb.Append("byte\t _collisionType\t " + _collisionType.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad\t " + _pad.ToString() + System.Environment.NewLine);
       sb.Append("=====_velocity=====" + System.Environment.NewLine);
       _velocity.reflection(sb);
           sb.Append("float\t _mass\t " + _mass.ToString() + System.Environment.NewLine);
       sb.Append("=====_location=====" + System.Environment.NewLine);
       _location.reflection(sb);
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
 public bool equals(CollisionPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_issuingEntityID.Equals( rhs._issuingEntityID) )) ivarsEqual = false;
     if( ! (_collidingEntityID.Equals( rhs._collidingEntityID) )) ivarsEqual = false;
     if( ! (_eventID.Equals( rhs._eventID) )) ivarsEqual = false;
     if( ! (_collisionType == rhs._collisionType)) ivarsEqual = false;
     if( ! (_pad == rhs._pad)) ivarsEqual = false;
     if( ! (_velocity.Equals( rhs._velocity) )) ivarsEqual = false;
     if( ! (_mass == rhs._mass)) ivarsEqual = false;
     if( ! (_location.Equals( rhs._location) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
