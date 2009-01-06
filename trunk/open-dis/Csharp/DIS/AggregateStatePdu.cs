using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.9.1 informationa bout aggregating entities anc communicating information about the aggregated entities.        requires manual intervention to fix the padding between entityID lists and silent aggregate sysem lists--this padding        is dependent on how many entityIDs there are, and needs to be on a 32 bit word boundary. UNFINISHED
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
[XmlInclude(typeof(AggregateMarking))]
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(Orientation))]
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(AggregateID))]
[XmlInclude(typeof(EntityID))]
[XmlInclude(typeof(EntityType))]
[XmlInclude(typeof(EntityType))]
[XmlInclude(typeof(VariableDatum))]
public class AggregateStatePdu : EntityManagementFamilyPdu
{
   /** ID of aggregated entities */
   protected EntityID  _aggregateID = new EntityID(); 

   /** force ID */
   protected byte  _forceID;

   /** state of aggregate */
   protected byte  _aggregateState;

   /** entity type of the aggregated entities */
   protected EntityType  _aggregateType = new EntityType(); 

   /** formation of aggregated entities */
   protected uint  _formation;

   /** marking for aggregate; first char is charset type, rest is char data */
   protected AggregateMarking  _aggregateMarking = new AggregateMarking(); 

   /** dimensions of bounding box for the aggregated entities, origin at the center of mass */
   protected Vector3Float  _dimensions = new Vector3Float(); 

   /** orientation of the bounding box */
   protected Orientation  _orientation = new Orientation(); 

   /** center of mass of the aggregation */
   protected Vector3Double  _centerOfMass = new Vector3Double(); 

   /** velocity of aggregation */
   protected Vector3Float  _velocity = new Vector3Float(); 

   /** number of aggregates */
   protected ushort  _numberOfDisAggregates;

   /** number of entities */
   protected ushort  _numberOfDisEntities;

   /** number of silent aggregate types */
   protected ushort  _numberOfSilentAggregateTypes;

   /** number of silent entity types */
   protected ushort  _numberOfSilentEntityTypes;

   /** aggregates  list */
   protected List<object> _aggregateIDList = new List<object>(); 
   /** entity ID list */
   protected List<object> _entityIDList = new List<object>(); 
   /** @@@padding to put the start of the next list on a 32 bit boundary. This needs to be fixed */
   protected byte  _pad2;

   /** silent entity types */
   protected List<object> _silentAggregateSystemList = new List<object>(); 
   /** silent entity types */
   protected List<object> _silentEntitySystemList = new List<object>(); 
   /** number of variable datum records */
   protected uint  _numberOfVariableDatumRecords;

   /** variableDatums */
   protected List<object> _variableDatumList = new List<object>(); 

/** Constructor */
 public AggregateStatePdu()
 {
    PduType = (byte)33;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _aggregateID.getMarshalledSize();  // _aggregateID
   marshalSize = marshalSize + 1;  // _forceID
   marshalSize = marshalSize + 1;  // _aggregateState
   marshalSize = marshalSize + _aggregateType.getMarshalledSize();  // _aggregateType
   marshalSize = marshalSize + 4;  // _formation
   marshalSize = marshalSize + _aggregateMarking.getMarshalledSize();  // _aggregateMarking
   marshalSize = marshalSize + _dimensions.getMarshalledSize();  // _dimensions
   marshalSize = marshalSize + _orientation.getMarshalledSize();  // _orientation
   marshalSize = marshalSize + _centerOfMass.getMarshalledSize();  // _centerOfMass
   marshalSize = marshalSize + _velocity.getMarshalledSize();  // _velocity
   marshalSize = marshalSize + 2;  // _numberOfDisAggregates
   marshalSize = marshalSize + 2;  // _numberOfDisEntities
   marshalSize = marshalSize + 2;  // _numberOfSilentAggregateTypes
   marshalSize = marshalSize + 2;  // _numberOfSilentEntityTypes
   for(int idx=0; idx < _aggregateIDList.Count; idx++)
   {
        AggregateID listElement = (AggregateID)_aggregateIDList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _entityIDList.Count; idx++)
   {
        EntityID listElement = (EntityID)_entityIDList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   marshalSize = marshalSize + 1;  // _pad2
   for(int idx=0; idx < _silentAggregateSystemList.Count; idx++)
   {
        EntityType listElement = (EntityType)_silentAggregateSystemList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _silentEntitySystemList.Count; idx++)
   {
        EntityType listElement = (EntityType)_silentEntitySystemList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   marshalSize = marshalSize + 4;  // _numberOfVariableDatumRecords
   for(int idx=0; idx < _variableDatumList.Count; idx++)
   {
        VariableDatum listElement = (VariableDatum)_variableDatumList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setAggregateID(EntityID pAggregateID)
{ _aggregateID = pAggregateID;
}

public EntityID getAggregateID()
{ return _aggregateID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="aggregateID")]
public EntityID AggregateID
{
     get
{
          return _aggregateID;
}
     set
{
          _aggregateID = value;
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

public void setAggregateState(byte pAggregateState)
{ _aggregateState = pAggregateState;
}

[XmlElement(Type= typeof(byte), ElementName="aggregateState")]
public byte AggregateState
{
     get
{
          return _aggregateState;
}
     set
{
          _aggregateState = value;
}
}

public void setAggregateType(EntityType pAggregateType)
{ _aggregateType = pAggregateType;
}

public EntityType getAggregateType()
{ return _aggregateType; 
}

[XmlElement(Type= typeof(EntityType), ElementName="aggregateType")]
public EntityType AggregateType
{
     get
{
          return _aggregateType;
}
     set
{
          _aggregateType = value;
}
}

public void setFormation(uint pFormation)
{ _formation = pFormation;
}

[XmlElement(Type= typeof(uint), ElementName="formation")]
public uint Formation
{
     get
{
          return _formation;
}
     set
{
          _formation = value;
}
}

public void setAggregateMarking(AggregateMarking pAggregateMarking)
{ _aggregateMarking = pAggregateMarking;
}

public AggregateMarking getAggregateMarking()
{ return _aggregateMarking; 
}

[XmlElement(Type= typeof(AggregateMarking), ElementName="aggregateMarking")]
public AggregateMarking AggregateMarking
{
     get
{
          return _aggregateMarking;
}
     set
{
          _aggregateMarking = value;
}
}

public void setDimensions(Vector3Float pDimensions)
{ _dimensions = pDimensions;
}

public Vector3Float getDimensions()
{ return _dimensions; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="dimensions")]
public Vector3Float Dimensions
{
     get
{
          return _dimensions;
}
     set
{
          _dimensions = value;
}
}

public void setOrientation(Orientation pOrientation)
{ _orientation = pOrientation;
}

public Orientation getOrientation()
{ return _orientation; 
}

[XmlElement(Type= typeof(Orientation), ElementName="orientation")]
public Orientation Orientation
{
     get
{
          return _orientation;
}
     set
{
          _orientation = value;
}
}

public void setCenterOfMass(Vector3Double pCenterOfMass)
{ _centerOfMass = pCenterOfMass;
}

public Vector3Double getCenterOfMass()
{ return _centerOfMass; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="centerOfMass")]
public Vector3Double CenterOfMass
{
     get
{
          return _centerOfMass;
}
     set
{
          _centerOfMass = value;
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

public void setAggregateIDList(List<object> pAggregateIDList)
{ _aggregateIDList = pAggregateIDList;
}

public List<object> getAggregateIDList()
{ return _aggregateIDList; }

[XmlElement(ElementName = "aggregateIDListList",Type = typeof(List<object>))]
public List<object> AggregateIDList
{
     get
{
          return _aggregateIDList;
}
     set
{
          _aggregateIDList = value;
}
}

public void setEntityIDList(List<object> pEntityIDList)
{ _entityIDList = pEntityIDList;
}

public List<object> getEntityIDList()
{ return _entityIDList; }

[XmlElement(ElementName = "entityIDListList",Type = typeof(List<object>))]
public List<object> EntityIDList
{
     get
{
          return _entityIDList;
}
     set
{
          _entityIDList = value;
}
}

public void setPad2(byte pPad2)
{ _pad2 = pPad2;
}

[XmlElement(Type= typeof(byte), ElementName="pad2")]
public byte Pad2
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

public void setSilentAggregateSystemList(List<object> pSilentAggregateSystemList)
{ _silentAggregateSystemList = pSilentAggregateSystemList;
}

public List<object> getSilentAggregateSystemList()
{ return _silentAggregateSystemList; }

[XmlElement(ElementName = "silentAggregateSystemListList",Type = typeof(List<object>))]
public List<object> SilentAggregateSystemList
{
     get
{
          return _silentAggregateSystemList;
}
     set
{
          _silentAggregateSystemList = value;
}
}

public void setSilentEntitySystemList(List<object> pSilentEntitySystemList)
{ _silentEntitySystemList = pSilentEntitySystemList;
}

public List<object> getSilentEntitySystemList()
{ return _silentEntitySystemList; }

[XmlElement(ElementName = "silentEntitySystemListList",Type = typeof(List<object>))]
public List<object> SilentEntitySystemList
{
     get
{
          return _silentEntitySystemList;
}
     set
{
          _silentEntitySystemList = value;
}
}

public void setVariableDatumList(List<object> pVariableDatumList)
{ _variableDatumList = pVariableDatumList;
}

public List<object> getVariableDatumList()
{ return _variableDatumList; }

[XmlElement(ElementName = "variableDatumListList",Type = typeof(List<object>))]
public List<object> VariableDatumList
{
     get
{
          return _variableDatumList;
}
     set
{
          _variableDatumList = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _aggregateID.marshal(dos);
       dos.writeByte( (byte)_forceID);
       dos.writeByte( (byte)_aggregateState);
       _aggregateType.marshal(dos);
       dos.writeUint( (uint)_formation);
       _aggregateMarking.marshal(dos);
       _dimensions.marshal(dos);
       _orientation.marshal(dos);
       _centerOfMass.marshal(dos);
       _velocity.marshal(dos);
       dos.writeUshort( (ushort)_aggregateIDList.Count);
       dos.writeUshort( (ushort)_entityIDList.Count);
       dos.writeUshort( (ushort)_silentAggregateSystemList.Count);
       dos.writeUshort( (ushort)_silentEntitySystemList.Count);

       for(int idx = 0; idx < _aggregateIDList.Count; idx++)
       {
            AggregateID aAggregateID = (AggregateID)_aggregateIDList[idx];
            aAggregateID.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _entityIDList.Count; idx++)
       {
            EntityID aEntityID = (EntityID)_entityIDList[idx];
            aEntityID.marshal(dos);
       } // end of list marshalling

       dos.writeByte( (byte)_pad2);

       for(int idx = 0; idx < _silentAggregateSystemList.Count; idx++)
       {
            EntityType aEntityType = (EntityType)_silentAggregateSystemList[idx];
            aEntityType.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _silentEntitySystemList.Count; idx++)
       {
            EntityType aEntityType = (EntityType)_silentEntitySystemList[idx];
            aEntityType.marshal(dos);
       } // end of list marshalling

       dos.writeUint( (uint)_variableDatumList.Count);

       for(int idx = 0; idx < _variableDatumList.Count; idx++)
       {
            VariableDatum aVariableDatum = (VariableDatum)_variableDatumList[idx];
            aVariableDatum.marshal(dos);
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
       _aggregateID.unmarshal(dis);
       _forceID = dis.readByte();
       _aggregateState = dis.readByte();
       _aggregateType.unmarshal(dis);
       _formation = dis.readUint();
       _aggregateMarking.unmarshal(dis);
       _dimensions.unmarshal(dis);
       _orientation.unmarshal(dis);
       _centerOfMass.unmarshal(dis);
       _velocity.unmarshal(dis);
       _numberOfDisAggregates = dis.readUshort();
       _numberOfDisEntities = dis.readUshort();
       _numberOfSilentAggregateTypes = dis.readUshort();
       _numberOfSilentEntityTypes = dis.readUshort();
        for(int idx = 0; idx < _numberOfDisAggregates; idx++)
        {
           AggregateID anX = new AggregateID();
            anX.unmarshal(dis);
            _aggregateIDList.Add(anX);
        };

        for(int idx = 0; idx < _numberOfDisEntities; idx++)
        {
           EntityID anX = new EntityID();
            anX.unmarshal(dis);
            _entityIDList.Add(anX);
        };

       _pad2 = dis.readByte();
        for(int idx = 0; idx < _numberOfSilentAggregateTypes; idx++)
        {
           EntityType anX = new EntityType();
            anX.unmarshal(dis);
            _silentAggregateSystemList.Add(anX);
        };

        for(int idx = 0; idx < _numberOfSilentEntityTypes; idx++)
        {
           EntityType anX = new EntityType();
            anX.unmarshal(dis);
            _silentEntitySystemList.Add(anX);
        };

       _numberOfVariableDatumRecords = dis.readUint();
        for(int idx = 0; idx < _numberOfVariableDatumRecords; idx++)
        {
           VariableDatum anX = new VariableDatum();
            anX.unmarshal(dis);
            _variableDatumList.Add(anX);
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
    sb.Append("----- AggregateStatePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_aggregateID=====" + System.Environment.NewLine);
       _aggregateID.reflection(sb);
           sb.Append("byte\t _forceID\t " + _forceID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _aggregateState\t " + _aggregateState.ToString() + System.Environment.NewLine);
       sb.Append("=====_aggregateType=====" + System.Environment.NewLine);
       _aggregateType.reflection(sb);
           sb.Append("uint\t _formation\t " + _formation.ToString() + System.Environment.NewLine);
       sb.Append("=====_aggregateMarking=====" + System.Environment.NewLine);
       _aggregateMarking.reflection(sb);
       sb.Append("=====_dimensions=====" + System.Environment.NewLine);
       _dimensions.reflection(sb);
       sb.Append("=====_orientation=====" + System.Environment.NewLine);
       _orientation.reflection(sb);
       sb.Append("=====_centerOfMass=====" + System.Environment.NewLine);
       _centerOfMass.reflection(sb);
       sb.Append("=====_velocity=====" + System.Environment.NewLine);
       _velocity.reflection(sb);
           sb.Append("ushort\t _aggregateIDList\t " + _aggregateIDList.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _entityIDList\t " + _entityIDList.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _silentAggregateSystemList\t " + _silentAggregateSystemList.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _silentEntitySystemList\t " + _silentEntitySystemList.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _aggregateIDList.Count; idx++)
       {
           sb.Append("AggregateID\t " + _aggregateIDList[idx] + System.Environment.NewLine);
            AggregateID aAggregateID = (AggregateID)_aggregateIDList[idx];
            aAggregateID.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _entityIDList.Count; idx++)
       {
           sb.Append("EntityID\t " + _entityIDList[idx] + System.Environment.NewLine);
            EntityID aEntityID = (EntityID)_entityIDList[idx];
            aEntityID.reflection(sb);
       } // end of list marshalling

           sb.Append("byte\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _silentAggregateSystemList.Count; idx++)
       {
           sb.Append("EntityType\t " + _silentAggregateSystemList[idx] + System.Environment.NewLine);
            EntityType aEntityType = (EntityType)_silentAggregateSystemList[idx];
            aEntityType.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _silentEntitySystemList.Count; idx++)
       {
           sb.Append("EntityType\t " + _silentEntitySystemList[idx] + System.Environment.NewLine);
            EntityType aEntityType = (EntityType)_silentEntitySystemList[idx];
            aEntityType.reflection(sb);
       } // end of list marshalling

           sb.Append("uint\t _variableDatumList\t " + _variableDatumList.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _variableDatumList.Count; idx++)
       {
           sb.Append("VariableDatum\t " + _variableDatumList[idx] + System.Environment.NewLine);
            VariableDatum aVariableDatum = (VariableDatum)_variableDatumList[idx];
            aVariableDatum.reflection(sb);
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
 public bool equals(AggregateStatePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_aggregateID.Equals( rhs._aggregateID) )) ivarsEqual = false;
     if( ! (_forceID == rhs._forceID)) ivarsEqual = false;
     if( ! (_aggregateState == rhs._aggregateState)) ivarsEqual = false;
     if( ! (_aggregateType.Equals( rhs._aggregateType) )) ivarsEqual = false;
     if( ! (_formation == rhs._formation)) ivarsEqual = false;
     if( ! (_aggregateMarking.Equals( rhs._aggregateMarking) )) ivarsEqual = false;
     if( ! (_dimensions.Equals( rhs._dimensions) )) ivarsEqual = false;
     if( ! (_orientation.Equals( rhs._orientation) )) ivarsEqual = false;
     if( ! (_centerOfMass.Equals( rhs._centerOfMass) )) ivarsEqual = false;
     if( ! (_velocity.Equals( rhs._velocity) )) ivarsEqual = false;
     if( ! (_numberOfDisAggregates == rhs._numberOfDisAggregates)) ivarsEqual = false;
     if( ! (_numberOfDisEntities == rhs._numberOfDisEntities)) ivarsEqual = false;
     if( ! (_numberOfSilentAggregateTypes == rhs._numberOfSilentAggregateTypes)) ivarsEqual = false;
     if( ! (_numberOfSilentEntityTypes == rhs._numberOfSilentEntityTypes)) ivarsEqual = false;

     for(int idx = 0; idx < _aggregateIDList.Count; idx++)
     {
        AggregateID x = (AggregateID)_aggregateIDList[idx];
        if( ! ( _aggregateIDList[idx].Equals(rhs._aggregateIDList[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _entityIDList.Count; idx++)
     {
        EntityID x = (EntityID)_entityIDList[idx];
        if( ! ( _entityIDList[idx].Equals(rhs._entityIDList[idx]))) ivarsEqual = false;
     }

     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;

     for(int idx = 0; idx < _silentAggregateSystemList.Count; idx++)
     {
        EntityType x = (EntityType)_silentAggregateSystemList[idx];
        if( ! ( _silentAggregateSystemList[idx].Equals(rhs._silentAggregateSystemList[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _silentEntitySystemList.Count; idx++)
     {
        EntityType x = (EntityType)_silentEntitySystemList[idx];
        if( ! ( _silentEntitySystemList[idx].Equals(rhs._silentEntitySystemList[idx]))) ivarsEqual = false;
     }

     if( ! (_numberOfVariableDatumRecords == rhs._numberOfVariableDatumRecords)) ivarsEqual = false;

     for(int idx = 0; idx < _variableDatumList.Count; idx++)
     {
        VariableDatum x = (VariableDatum)_variableDatumList[idx];
        if( ! ( _variableDatumList[idx].Equals(rhs._variableDatumList[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
