using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.3.3.3. Information about elastic collisions in a DIS exercise shall be communicated using a Collision-Elastic PDU. COMPLETE
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
public class CollisionElasticPdu : EntityInformationFamilyPdu
{
   /** ID of the entity that issued the collision PDU */
   protected EntityID  _issuingEntityID = new EntityID(); 

   /** ID of entity that has collided with the issuing entity ID */
   protected EntityID  _collidingEntityID = new EntityID(); 

   /** ID of event */
   protected EventID  _collisionEventID = new EventID(); 

   /** some padding */
   protected short  _pad = 0;

   /** velocity at collision */
   protected Vector3Float  _contactVelocity = new Vector3Float(); 

   /** mass of issuing entity */
   protected float  _mass;

   /** Location with respect to entity the issuing entity collided with */
   protected Vector3Float  _location = new Vector3Float(); 

   /** tensor values */
   protected float  _collisionResultXX;

   /** tensor values */
   protected float  _collisionResultXY;

   /** tensor values */
   protected float  _collisionResultXZ;

   /** tensor values */
   protected float  _collisionResultYY;

   /** tensor values */
   protected float  _collisionResultYZ;

   /** tensor values */
   protected float  _collisionResultZZ;

   /** This record shall represent the normal vector to the surface at the point of collision detection. The surface normal shall be represented in world coordinates. */
   protected Vector3Float  _unitSurfaceNormal = new Vector3Float(); 

   /** This field shall represent the degree to which energy is conserved in a collision */
   protected float  _coefficientOfRestitution;


/** Constructor */
 public CollisionElasticPdu()
 {
    PduType = (byte)66;
    ProtocolFamily = (byte)1;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _issuingEntityID.getMarshalledSize();  // _issuingEntityID
   marshalSize = marshalSize + _collidingEntityID.getMarshalledSize();  // _collidingEntityID
   marshalSize = marshalSize + _collisionEventID.getMarshalledSize();  // _collisionEventID
   marshalSize = marshalSize + 2;  // _pad
   marshalSize = marshalSize + _contactVelocity.getMarshalledSize();  // _contactVelocity
   marshalSize = marshalSize + 4;  // _mass
   marshalSize = marshalSize + _location.getMarshalledSize();  // _location
   marshalSize = marshalSize + 4;  // _collisionResultXX
   marshalSize = marshalSize + 4;  // _collisionResultXY
   marshalSize = marshalSize + 4;  // _collisionResultXZ
   marshalSize = marshalSize + 4;  // _collisionResultYY
   marshalSize = marshalSize + 4;  // _collisionResultYZ
   marshalSize = marshalSize + 4;  // _collisionResultZZ
   marshalSize = marshalSize + _unitSurfaceNormal.getMarshalledSize();  // _unitSurfaceNormal
   marshalSize = marshalSize + 4;  // _coefficientOfRestitution

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

public void setCollisionEventID(EventID pCollisionEventID)
{ _collisionEventID = pCollisionEventID;
}

public EventID getCollisionEventID()
{ return _collisionEventID; 
}

[XmlElement(Type= typeof(EventID), ElementName="collisionEventID")]
public EventID CollisionEventID
{
     get
{
          return _collisionEventID;
}
     set
{
          _collisionEventID = value;
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

public void setContactVelocity(Vector3Float pContactVelocity)
{ _contactVelocity = pContactVelocity;
}

public Vector3Float getContactVelocity()
{ return _contactVelocity; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="contactVelocity")]
public Vector3Float ContactVelocity
{
     get
{
          return _contactVelocity;
}
     set
{
          _contactVelocity = value;
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

public void setCollisionResultXX(float pCollisionResultXX)
{ _collisionResultXX = pCollisionResultXX;
}

[XmlElement(Type= typeof(float), ElementName="collisionResultXX")]
public float CollisionResultXX
{
     get
{
          return _collisionResultXX;
}
     set
{
          _collisionResultXX = value;
}
}

public void setCollisionResultXY(float pCollisionResultXY)
{ _collisionResultXY = pCollisionResultXY;
}

[XmlElement(Type= typeof(float), ElementName="collisionResultXY")]
public float CollisionResultXY
{
     get
{
          return _collisionResultXY;
}
     set
{
          _collisionResultXY = value;
}
}

public void setCollisionResultXZ(float pCollisionResultXZ)
{ _collisionResultXZ = pCollisionResultXZ;
}

[XmlElement(Type= typeof(float), ElementName="collisionResultXZ")]
public float CollisionResultXZ
{
     get
{
          return _collisionResultXZ;
}
     set
{
          _collisionResultXZ = value;
}
}

public void setCollisionResultYY(float pCollisionResultYY)
{ _collisionResultYY = pCollisionResultYY;
}

[XmlElement(Type= typeof(float), ElementName="collisionResultYY")]
public float CollisionResultYY
{
     get
{
          return _collisionResultYY;
}
     set
{
          _collisionResultYY = value;
}
}

public void setCollisionResultYZ(float pCollisionResultYZ)
{ _collisionResultYZ = pCollisionResultYZ;
}

[XmlElement(Type= typeof(float), ElementName="collisionResultYZ")]
public float CollisionResultYZ
{
     get
{
          return _collisionResultYZ;
}
     set
{
          _collisionResultYZ = value;
}
}

public void setCollisionResultZZ(float pCollisionResultZZ)
{ _collisionResultZZ = pCollisionResultZZ;
}

[XmlElement(Type= typeof(float), ElementName="collisionResultZZ")]
public float CollisionResultZZ
{
     get
{
          return _collisionResultZZ;
}
     set
{
          _collisionResultZZ = value;
}
}

public void setUnitSurfaceNormal(Vector3Float pUnitSurfaceNormal)
{ _unitSurfaceNormal = pUnitSurfaceNormal;
}

public Vector3Float getUnitSurfaceNormal()
{ return _unitSurfaceNormal; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="unitSurfaceNormal")]
public Vector3Float UnitSurfaceNormal
{
     get
{
          return _unitSurfaceNormal;
}
     set
{
          _unitSurfaceNormal = value;
}
}

public void setCoefficientOfRestitution(float pCoefficientOfRestitution)
{ _coefficientOfRestitution = pCoefficientOfRestitution;
}

[XmlElement(Type= typeof(float), ElementName="coefficientOfRestitution")]
public float CoefficientOfRestitution
{
     get
{
          return _coefficientOfRestitution;
}
     set
{
          _coefficientOfRestitution = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _issuingEntityID.marshal(dos);
       _collidingEntityID.marshal(dos);
       _collisionEventID.marshal(dos);
       dos.writeShort( (short)_pad);
       _contactVelocity.marshal(dos);
       dos.writeFloat( (float)_mass);
       _location.marshal(dos);
       dos.writeFloat( (float)_collisionResultXX);
       dos.writeFloat( (float)_collisionResultXY);
       dos.writeFloat( (float)_collisionResultXZ);
       dos.writeFloat( (float)_collisionResultYY);
       dos.writeFloat( (float)_collisionResultYZ);
       dos.writeFloat( (float)_collisionResultZZ);
       _unitSurfaceNormal.marshal(dos);
       dos.writeFloat( (float)_coefficientOfRestitution);
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
       _collisionEventID.unmarshal(dis);
       _pad = dis.readShort();
       _contactVelocity.unmarshal(dis);
       _mass = dis.readFloat();
       _location.unmarshal(dis);
       _collisionResultXX = dis.readFloat();
       _collisionResultXY = dis.readFloat();
       _collisionResultXZ = dis.readFloat();
       _collisionResultYY = dis.readFloat();
       _collisionResultYZ = dis.readFloat();
       _collisionResultZZ = dis.readFloat();
       _unitSurfaceNormal.unmarshal(dis);
       _coefficientOfRestitution = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- CollisionElasticPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_issuingEntityID=====" + System.Environment.NewLine);
       _issuingEntityID.reflection(sb);
       sb.Append("=====_collidingEntityID=====" + System.Environment.NewLine);
       _collidingEntityID.reflection(sb);
       sb.Append("=====_collisionEventID=====" + System.Environment.NewLine);
       _collisionEventID.reflection(sb);
           sb.Append("short\t _pad\t " + _pad.ToString() + System.Environment.NewLine);
       sb.Append("=====_contactVelocity=====" + System.Environment.NewLine);
       _contactVelocity.reflection(sb);
           sb.Append("float\t _mass\t " + _mass.ToString() + System.Environment.NewLine);
       sb.Append("=====_location=====" + System.Environment.NewLine);
       _location.reflection(sb);
           sb.Append("float\t _collisionResultXX\t " + _collisionResultXX.ToString() + System.Environment.NewLine);
           sb.Append("float\t _collisionResultXY\t " + _collisionResultXY.ToString() + System.Environment.NewLine);
           sb.Append("float\t _collisionResultXZ\t " + _collisionResultXZ.ToString() + System.Environment.NewLine);
           sb.Append("float\t _collisionResultYY\t " + _collisionResultYY.ToString() + System.Environment.NewLine);
           sb.Append("float\t _collisionResultYZ\t " + _collisionResultYZ.ToString() + System.Environment.NewLine);
           sb.Append("float\t _collisionResultZZ\t " + _collisionResultZZ.ToString() + System.Environment.NewLine);
       sb.Append("=====_unitSurfaceNormal=====" + System.Environment.NewLine);
       _unitSurfaceNormal.reflection(sb);
           sb.Append("float\t _coefficientOfRestitution\t " + _coefficientOfRestitution.ToString() + System.Environment.NewLine);
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
 public bool equals(CollisionElasticPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_issuingEntityID.Equals( rhs._issuingEntityID) )) ivarsEqual = false;
     if( ! (_collidingEntityID.Equals( rhs._collidingEntityID) )) ivarsEqual = false;
     if( ! (_collisionEventID.Equals( rhs._collisionEventID) )) ivarsEqual = false;
     if( ! (_pad == rhs._pad)) ivarsEqual = false;
     if( ! (_contactVelocity.Equals( rhs._contactVelocity) )) ivarsEqual = false;
     if( ! (_mass == rhs._mass)) ivarsEqual = false;
     if( ! (_location.Equals( rhs._location) )) ivarsEqual = false;
     if( ! (_collisionResultXX == rhs._collisionResultXX)) ivarsEqual = false;
     if( ! (_collisionResultXY == rhs._collisionResultXY)) ivarsEqual = false;
     if( ! (_collisionResultXZ == rhs._collisionResultXZ)) ivarsEqual = false;
     if( ! (_collisionResultYY == rhs._collisionResultYY)) ivarsEqual = false;
     if( ! (_collisionResultYZ == rhs._collisionResultYZ)) ivarsEqual = false;
     if( ! (_collisionResultZZ == rhs._collisionResultZZ)) ivarsEqual = false;
     if( ! (_unitSurfaceNormal.Equals( rhs._unitSurfaceNormal) )) ivarsEqual = false;
     if( ! (_coefficientOfRestitution == rhs._coefficientOfRestitution)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
