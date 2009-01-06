using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.7.2. Handles designating operations. COMPLETE
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
public class DesignatorPdu : DistributedEmissionsFamilyPdu
{
   /** ID of the entity designating */
   protected EntityID  _designatingEntityID = new EntityID(); 

   /** This field shall specify a unique emitter database number assigned to  differentiate between otherwise similar or identical emitter beams within an emitter system. */
   protected ushort  _codeName;

   /** ID of the entity being designated */
   protected EntityID  _designatedEntityID = new EntityID(); 

   /** This field shall identify the designator code being used by the designating entity  */
   protected ushort  _designatorCode;

   /** This field shall identify the designator output power in watts */
   protected float  _designatorPower;

   /** This field shall identify the designator wavelength in units of microns */
   protected float  _designatorWavelength;

   /** designtor spot wrt the designated entity */
   protected Vector3Float  _designatorSpotWrtDesignated = new Vector3Float(); 

   /** designtor spot wrt the designated entity */
   protected Vector3Double  _designatorSpotLocation = new Vector3Double(); 

   /** Dead reckoning algorithm */
   protected byte  _deadReckoningAlgorithm;

   /** padding */
   protected ushort  _padding1;

   /** padding */
   protected byte  _padding2;

   /** linear accelleration of entity */
   protected Vector3Float  _entityLinearAcceleration = new Vector3Float(); 


/** Constructor */
 public DesignatorPdu()
 {
    PduType = (byte)24;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _designatingEntityID.getMarshalledSize();  // _designatingEntityID
   marshalSize = marshalSize + 2;  // _codeName
   marshalSize = marshalSize + _designatedEntityID.getMarshalledSize();  // _designatedEntityID
   marshalSize = marshalSize + 2;  // _designatorCode
   marshalSize = marshalSize + 4;  // _designatorPower
   marshalSize = marshalSize + 4;  // _designatorWavelength
   marshalSize = marshalSize + _designatorSpotWrtDesignated.getMarshalledSize();  // _designatorSpotWrtDesignated
   marshalSize = marshalSize + _designatorSpotLocation.getMarshalledSize();  // _designatorSpotLocation
   marshalSize = marshalSize + 1;  // _deadReckoningAlgorithm
   marshalSize = marshalSize + 2;  // _padding1
   marshalSize = marshalSize + 1;  // _padding2
   marshalSize = marshalSize + _entityLinearAcceleration.getMarshalledSize();  // _entityLinearAcceleration

   return marshalSize;
}


public void setDesignatingEntityID(EntityID pDesignatingEntityID)
{ _designatingEntityID = pDesignatingEntityID;
}

public EntityID getDesignatingEntityID()
{ return _designatingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="designatingEntityID")]
public EntityID DesignatingEntityID
{
     get
{
          return _designatingEntityID;
}
     set
{
          _designatingEntityID = value;
}
}

public void setCodeName(ushort pCodeName)
{ _codeName = pCodeName;
}

[XmlElement(Type= typeof(ushort), ElementName="codeName")]
public ushort CodeName
{
     get
{
          return _codeName;
}
     set
{
          _codeName = value;
}
}

public void setDesignatedEntityID(EntityID pDesignatedEntityID)
{ _designatedEntityID = pDesignatedEntityID;
}

public EntityID getDesignatedEntityID()
{ return _designatedEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="designatedEntityID")]
public EntityID DesignatedEntityID
{
     get
{
          return _designatedEntityID;
}
     set
{
          _designatedEntityID = value;
}
}

public void setDesignatorCode(ushort pDesignatorCode)
{ _designatorCode = pDesignatorCode;
}

[XmlElement(Type= typeof(ushort), ElementName="designatorCode")]
public ushort DesignatorCode
{
     get
{
          return _designatorCode;
}
     set
{
          _designatorCode = value;
}
}

public void setDesignatorPower(float pDesignatorPower)
{ _designatorPower = pDesignatorPower;
}

[XmlElement(Type= typeof(float), ElementName="designatorPower")]
public float DesignatorPower
{
     get
{
          return _designatorPower;
}
     set
{
          _designatorPower = value;
}
}

public void setDesignatorWavelength(float pDesignatorWavelength)
{ _designatorWavelength = pDesignatorWavelength;
}

[XmlElement(Type= typeof(float), ElementName="designatorWavelength")]
public float DesignatorWavelength
{
     get
{
          return _designatorWavelength;
}
     set
{
          _designatorWavelength = value;
}
}

public void setDesignatorSpotWrtDesignated(Vector3Float pDesignatorSpotWrtDesignated)
{ _designatorSpotWrtDesignated = pDesignatorSpotWrtDesignated;
}

public Vector3Float getDesignatorSpotWrtDesignated()
{ return _designatorSpotWrtDesignated; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="designatorSpotWrtDesignated")]
public Vector3Float DesignatorSpotWrtDesignated
{
     get
{
          return _designatorSpotWrtDesignated;
}
     set
{
          _designatorSpotWrtDesignated = value;
}
}

public void setDesignatorSpotLocation(Vector3Double pDesignatorSpotLocation)
{ _designatorSpotLocation = pDesignatorSpotLocation;
}

public Vector3Double getDesignatorSpotLocation()
{ return _designatorSpotLocation; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="designatorSpotLocation")]
public Vector3Double DesignatorSpotLocation
{
     get
{
          return _designatorSpotLocation;
}
     set
{
          _designatorSpotLocation = value;
}
}

public void setDeadReckoningAlgorithm(byte pDeadReckoningAlgorithm)
{ _deadReckoningAlgorithm = pDeadReckoningAlgorithm;
}

[XmlElement(Type= typeof(byte), ElementName="deadReckoningAlgorithm")]
public byte DeadReckoningAlgorithm
{
     get
{
          return _deadReckoningAlgorithm;
}
     set
{
          _deadReckoningAlgorithm = value;
}
}

public void setPadding1(ushort pPadding1)
{ _padding1 = pPadding1;
}

[XmlElement(Type= typeof(ushort), ElementName="padding1")]
public ushort Padding1
{
     get
{
          return _padding1;
}
     set
{
          _padding1 = value;
}
}

public void setPadding2(byte pPadding2)
{ _padding2 = pPadding2;
}

[XmlElement(Type= typeof(byte), ElementName="padding2")]
public byte Padding2
{
     get
{
          return _padding2;
}
     set
{
          _padding2 = value;
}
}

public void setEntityLinearAcceleration(Vector3Float pEntityLinearAcceleration)
{ _entityLinearAcceleration = pEntityLinearAcceleration;
}

public Vector3Float getEntityLinearAcceleration()
{ return _entityLinearAcceleration; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="entityLinearAcceleration")]
public Vector3Float EntityLinearAcceleration
{
     get
{
          return _entityLinearAcceleration;
}
     set
{
          _entityLinearAcceleration = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _designatingEntityID.marshal(dos);
       dos.writeUshort( (ushort)_codeName);
       _designatedEntityID.marshal(dos);
       dos.writeUshort( (ushort)_designatorCode);
       dos.writeFloat( (float)_designatorPower);
       dos.writeFloat( (float)_designatorWavelength);
       _designatorSpotWrtDesignated.marshal(dos);
       _designatorSpotLocation.marshal(dos);
       dos.writeByte( (byte)_deadReckoningAlgorithm);
       dos.writeUshort( (ushort)_padding1);
       dos.writeByte( (byte)_padding2);
       _entityLinearAcceleration.marshal(dos);
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
       _designatingEntityID.unmarshal(dis);
       _codeName = dis.readUshort();
       _designatedEntityID.unmarshal(dis);
       _designatorCode = dis.readUshort();
       _designatorPower = dis.readFloat();
       _designatorWavelength = dis.readFloat();
       _designatorSpotWrtDesignated.unmarshal(dis);
       _designatorSpotLocation.unmarshal(dis);
       _deadReckoningAlgorithm = dis.readByte();
       _padding1 = dis.readUshort();
       _padding2 = dis.readByte();
       _entityLinearAcceleration.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- DesignatorPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_designatingEntityID=====" + System.Environment.NewLine);
       _designatingEntityID.reflection(sb);
           sb.Append("ushort\t _codeName\t " + _codeName.ToString() + System.Environment.NewLine);
       sb.Append("=====_designatedEntityID=====" + System.Environment.NewLine);
       _designatedEntityID.reflection(sb);
           sb.Append("ushort\t _designatorCode\t " + _designatorCode.ToString() + System.Environment.NewLine);
           sb.Append("float\t _designatorPower\t " + _designatorPower.ToString() + System.Environment.NewLine);
           sb.Append("float\t _designatorWavelength\t " + _designatorWavelength.ToString() + System.Environment.NewLine);
       sb.Append("=====_designatorSpotWrtDesignated=====" + System.Environment.NewLine);
       _designatorSpotWrtDesignated.reflection(sb);
       sb.Append("=====_designatorSpotLocation=====" + System.Environment.NewLine);
       _designatorSpotLocation.reflection(sb);
           sb.Append("byte\t _deadReckoningAlgorithm\t " + _deadReckoningAlgorithm.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _padding2\t " + _padding2.ToString() + System.Environment.NewLine);
       sb.Append("=====_entityLinearAcceleration=====" + System.Environment.NewLine);
       _entityLinearAcceleration.reflection(sb);
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
 public bool equals(DesignatorPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_designatingEntityID.Equals( rhs._designatingEntityID) )) ivarsEqual = false;
     if( ! (_codeName == rhs._codeName)) ivarsEqual = false;
     if( ! (_designatedEntityID.Equals( rhs._designatedEntityID) )) ivarsEqual = false;
     if( ! (_designatorCode == rhs._designatorCode)) ivarsEqual = false;
     if( ! (_designatorPower == rhs._designatorPower)) ivarsEqual = false;
     if( ! (_designatorWavelength == rhs._designatorWavelength)) ivarsEqual = false;
     if( ! (_designatorSpotWrtDesignated.Equals( rhs._designatorSpotWrtDesignated) )) ivarsEqual = false;
     if( ! (_designatorSpotLocation.Equals( rhs._designatorSpotLocation) )) ivarsEqual = false;
     if( ! (_deadReckoningAlgorithm == rhs._deadReckoningAlgorithm)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_padding2 == rhs._padding2)) ivarsEqual = false;
     if( ! (_entityLinearAcceleration.Equals( rhs._entityLinearAcceleration) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
