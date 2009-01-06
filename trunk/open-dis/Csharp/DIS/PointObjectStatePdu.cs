using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.11.3: Inormation abut the addition or modification of a synthecic enviroment object that is anchored      to the terrain with a single point. COMPLETE
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
[XmlInclude(typeof(ObjectType))]
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(Orientation))]
[XmlInclude(typeof(SimulationAddress))]
public class PointObjectStatePdu : SyntheticEnvironmentFamilyPdu
{
   /** Object in synthetic environment */
   protected EntityID  _objectID = new EntityID(); 

   /** Object with which this point object is associated */
   protected EntityID  _referencedObjectID = new EntityID(); 

   /** unique update number of each state transition of an object */
   protected ushort  _updateNumber;

   /** force ID */
   protected byte  _forceID;

   /** modifications */
   protected byte  _modifications;

   /** Object type */
   protected ObjectType  _objectType = new ObjectType(); 

   /** Object location */
   protected Vector3Double  _objectLocation = new Vector3Double(); 

   /** Object orientation */
   protected Orientation  _objectOrientation = new Orientation(); 

   /** Object apperance */
   protected double  _objectAppearance;

   /** requesterID */
   protected SimulationAddress  _requesterID = new SimulationAddress(); 

   /** receiver ID */
   protected SimulationAddress  _receivingID = new SimulationAddress(); 

   /** padding */
   protected uint  _pad2;


/** Constructor */
 public PointObjectStatePdu()
 {
    PduType = (byte)43;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _objectID.getMarshalledSize();  // _objectID
   marshalSize = marshalSize + _referencedObjectID.getMarshalledSize();  // _referencedObjectID
   marshalSize = marshalSize + 2;  // _updateNumber
   marshalSize = marshalSize + 1;  // _forceID
   marshalSize = marshalSize + 1;  // _modifications
   marshalSize = marshalSize + _objectType.getMarshalledSize();  // _objectType
   marshalSize = marshalSize + _objectLocation.getMarshalledSize();  // _objectLocation
   marshalSize = marshalSize + _objectOrientation.getMarshalledSize();  // _objectOrientation
   marshalSize = marshalSize + 8;  // _objectAppearance
   marshalSize = marshalSize + _requesterID.getMarshalledSize();  // _requesterID
   marshalSize = marshalSize + _receivingID.getMarshalledSize();  // _receivingID
   marshalSize = marshalSize + 4;  // _pad2

   return marshalSize;
}


public void setObjectID(EntityID pObjectID)
{ _objectID = pObjectID;
}

public EntityID getObjectID()
{ return _objectID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="objectID")]
public EntityID ObjectID
{
     get
{
          return _objectID;
}
     set
{
          _objectID = value;
}
}

public void setReferencedObjectID(EntityID pReferencedObjectID)
{ _referencedObjectID = pReferencedObjectID;
}

public EntityID getReferencedObjectID()
{ return _referencedObjectID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="referencedObjectID")]
public EntityID ReferencedObjectID
{
     get
{
          return _referencedObjectID;
}
     set
{
          _referencedObjectID = value;
}
}

public void setUpdateNumber(ushort pUpdateNumber)
{ _updateNumber = pUpdateNumber;
}

[XmlElement(Type= typeof(ushort), ElementName="updateNumber")]
public ushort UpdateNumber
{
     get
{
          return _updateNumber;
}
     set
{
          _updateNumber = value;
}
}

public void setForceID(byte pForceID)
{ _forceID = pForceID;
}

[XmlElement(Type= typeof(byte), ElementName="forceID")]
public byte ForceID
{
     get
{
          return _forceID;
}
     set
{
          _forceID = value;
}
}

public void setModifications(byte pModifications)
{ _modifications = pModifications;
}

[XmlElement(Type= typeof(byte), ElementName="modifications")]
public byte Modifications
{
     get
{
          return _modifications;
}
     set
{
          _modifications = value;
}
}

public void setObjectType(ObjectType pObjectType)
{ _objectType = pObjectType;
}

public ObjectType getObjectType()
{ return _objectType; 
}

[XmlElement(Type= typeof(ObjectType), ElementName="objectType")]
public ObjectType ObjectType
{
     get
{
          return _objectType;
}
     set
{
          _objectType = value;
}
}

public void setObjectLocation(Vector3Double pObjectLocation)
{ _objectLocation = pObjectLocation;
}

public Vector3Double getObjectLocation()
{ return _objectLocation; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="objectLocation")]
public Vector3Double ObjectLocation
{
     get
{
          return _objectLocation;
}
     set
{
          _objectLocation = value;
}
}

public void setObjectOrientation(Orientation pObjectOrientation)
{ _objectOrientation = pObjectOrientation;
}

public Orientation getObjectOrientation()
{ return _objectOrientation; 
}

[XmlElement(Type= typeof(Orientation), ElementName="objectOrientation")]
public Orientation ObjectOrientation
{
     get
{
          return _objectOrientation;
}
     set
{
          _objectOrientation = value;
}
}

public void setObjectAppearance(double pObjectAppearance)
{ _objectAppearance = pObjectAppearance;
}

[XmlElement(Type= typeof(double), ElementName="objectAppearance")]
public double ObjectAppearance
{
     get
{
          return _objectAppearance;
}
     set
{
          _objectAppearance = value;
}
}

public void setRequesterID(SimulationAddress pRequesterID)
{ _requesterID = pRequesterID;
}

public SimulationAddress getRequesterID()
{ return _requesterID; 
}

[XmlElement(Type= typeof(SimulationAddress), ElementName="requesterID")]
public SimulationAddress RequesterID
{
     get
{
          return _requesterID;
}
     set
{
          _requesterID = value;
}
}

public void setReceivingID(SimulationAddress pReceivingID)
{ _receivingID = pReceivingID;
}

public SimulationAddress getReceivingID()
{ return _receivingID; 
}

[XmlElement(Type= typeof(SimulationAddress), ElementName="receivingID")]
public SimulationAddress ReceivingID
{
     get
{
          return _receivingID;
}
     set
{
          _receivingID = value;
}
}

public void setPad2(uint pPad2)
{ _pad2 = pPad2;
}

[XmlElement(Type= typeof(uint), ElementName="pad2")]
public uint Pad2
{
     get
{
          return _pad2;
}
     set
{
          _pad2 = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _objectID.marshal(dos);
       _referencedObjectID.marshal(dos);
       dos.writeUshort( (ushort)_updateNumber);
       dos.writeByte( (byte)_forceID);
       dos.writeByte( (byte)_modifications);
       _objectType.marshal(dos);
       _objectLocation.marshal(dos);
       _objectOrientation.marshal(dos);
       dos.writeDouble( (double)_objectAppearance);
       _requesterID.marshal(dos);
       _receivingID.marshal(dos);
       dos.writeUint( (uint)_pad2);
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
       _objectID.unmarshal(dis);
       _referencedObjectID.unmarshal(dis);
       _updateNumber = dis.readUshort();
       _forceID = dis.readByte();
       _modifications = dis.readByte();
       _objectType.unmarshal(dis);
       _objectLocation.unmarshal(dis);
       _objectOrientation.unmarshal(dis);
       _objectAppearance = dis.readDouble();
       _requesterID.unmarshal(dis);
       _receivingID.unmarshal(dis);
       _pad2 = dis.readUint();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- PointObjectStatePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_objectID=====" + System.Environment.NewLine);
       _objectID.reflection(sb);
       sb.Append("=====_referencedObjectID=====" + System.Environment.NewLine);
       _referencedObjectID.reflection(sb);
           sb.Append("ushort\t _updateNumber\t " + _updateNumber.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _forceID\t " + _forceID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _modifications\t " + _modifications.ToString() + System.Environment.NewLine);
       sb.Append("=====_objectType=====" + System.Environment.NewLine);
       _objectType.reflection(sb);
       sb.Append("=====_objectLocation=====" + System.Environment.NewLine);
       _objectLocation.reflection(sb);
       sb.Append("=====_objectOrientation=====" + System.Environment.NewLine);
       _objectOrientation.reflection(sb);
           sb.Append("double\t _objectAppearance\t " + _objectAppearance.ToString() + System.Environment.NewLine);
       sb.Append("=====_requesterID=====" + System.Environment.NewLine);
       _requesterID.reflection(sb);
       sb.Append("=====_receivingID=====" + System.Environment.NewLine);
       _receivingID.reflection(sb);
           sb.Append("uint\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
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
 public bool equals(PointObjectStatePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_objectID.Equals( rhs._objectID) )) ivarsEqual = false;
     if( ! (_referencedObjectID.Equals( rhs._referencedObjectID) )) ivarsEqual = false;
     if( ! (_updateNumber == rhs._updateNumber)) ivarsEqual = false;
     if( ! (_forceID == rhs._forceID)) ivarsEqual = false;
     if( ! (_modifications == rhs._modifications)) ivarsEqual = false;
     if( ! (_objectType.Equals( rhs._objectType) )) ivarsEqual = false;
     if( ! (_objectLocation.Equals( rhs._objectLocation) )) ivarsEqual = false;
     if( ! (_objectOrientation.Equals( rhs._objectOrientation) )) ivarsEqual = false;
     if( ! (_objectAppearance == rhs._objectAppearance)) ivarsEqual = false;
     if( ! (_requesterID.Equals( rhs._requesterID) )) ivarsEqual = false;
     if( ! (_receivingID.Equals( rhs._receivingID) )) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
