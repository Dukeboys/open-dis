using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.10.1 Abstract superclass for PDUs relating to minefields. COMPLETE
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
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(Orientation))]
[XmlInclude(typeof(Point))]
[XmlInclude(typeof(EntityType))]
public class MinefieldStatePdu : MinefieldFamilyPdu
{
   /** Minefield ID */
   protected EntityID  _minefieldID = new EntityID(); 

   /** Minefield sequence */
   protected ushort  _minefieldSequence;

   /** force ID */
   protected byte  _forceID;

   /** Number of permieter points */
   protected byte  _numberOfPerimeterPoints;

   /** type of minefield */
   protected EntityType  _minefieldType = new EntityType(); 

   /** how many mine types */
   protected ushort  _numberOfMineTypes;

   /** location of minefield in world coords */
   protected Vector3Double  _minefieldLocation = new Vector3Double(); 

   /** orientation of minefield */
   protected Orientation  _minefieldOrientation = new Orientation(); 

   /** appearance bitflags */
   protected ushort  _appearance;

   /** protocolMode */
   protected ushort  _protocolMode;

   /** perimeter points for the minefield */
   protected List<Point> _perimeterPoints = new List<Point>(); 
   /** Type of mines */
   protected List<EntityType> _mineType = new List<EntityType>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.10.1 Abstract superclass for PDUs relating to minefields. COMPLETE
   ///</summary>
 public MinefieldStatePdu()
 {
    PduType = (byte)37;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _minefieldID.getMarshalledSize();  // _minefieldID
   marshalSize = marshalSize + 2;  // _minefieldSequence
   marshalSize = marshalSize + 1;  // _forceID
   marshalSize = marshalSize + 1;  // _numberOfPerimeterPoints
   marshalSize = marshalSize + _minefieldType.getMarshalledSize();  // _minefieldType
   marshalSize = marshalSize + 2;  // _numberOfMineTypes
   marshalSize = marshalSize + _minefieldLocation.getMarshalledSize();  // _minefieldLocation
   marshalSize = marshalSize + _minefieldOrientation.getMarshalledSize();  // _minefieldOrientation
   marshalSize = marshalSize + 2;  // _appearance
   marshalSize = marshalSize + 2;  // _protocolMode
   for(int idx=0; idx < _perimeterPoints.Count; idx++)
   {
        Point listElement = (Point)_perimeterPoints[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _mineType.Count; idx++)
   {
        EntityType listElement = (EntityType)_mineType[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


   ///<summary>
   ///Minefield ID
   ///</summary>
public void setMinefieldID(EntityID pMinefieldID)
{ _minefieldID = pMinefieldID;
}

   ///<summary>
   ///Minefield ID
   ///</summary>
public EntityID getMinefieldID()
{ return _minefieldID; 
}

   ///<summary>
   ///Minefield ID
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="minefieldID")]
public EntityID MinefieldID
{
     get
{
          return _minefieldID;
}
     set
{
          _minefieldID = value;
}
}

   ///<summary>
   ///Minefield sequence
   ///</summary>
public void setMinefieldSequence(ushort pMinefieldSequence)
{ _minefieldSequence = pMinefieldSequence;
}

[XmlElement(Type= typeof(ushort), ElementName="minefieldSequence")]
public ushort MinefieldSequence
{
     get
{
          return _minefieldSequence;
}
     set
{
          _minefieldSequence = value;
}
}

   ///<summary>
   ///force ID
   ///</summary>
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

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfPerimeterPoints method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfPerimeterPoints(byte pNumberOfPerimeterPoints)
{ _numberOfPerimeterPoints = pNumberOfPerimeterPoints;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfPerimeterPoints method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(byte), ElementName="numberOfPerimeterPoints")]
public byte NumberOfPerimeterPoints
{
     get
     {
          return _numberOfPerimeterPoints;
     }
     set
     {
          _numberOfPerimeterPoints = value;
     }
}

   ///<summary>
   ///type of minefield
   ///</summary>
public void setMinefieldType(EntityType pMinefieldType)
{ _minefieldType = pMinefieldType;
}

   ///<summary>
   ///type of minefield
   ///</summary>
public EntityType getMinefieldType()
{ return _minefieldType; 
}

   ///<summary>
   ///type of minefield
   ///</summary>
[XmlElement(Type= typeof(EntityType), ElementName="minefieldType")]
public EntityType MinefieldType
{
     get
{
          return _minefieldType;
}
     set
{
          _minefieldType = value;
}
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfMineTypes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfMineTypes(ushort pNumberOfMineTypes)
{ _numberOfMineTypes = pNumberOfMineTypes;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfMineTypes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(ushort), ElementName="numberOfMineTypes")]
public ushort NumberOfMineTypes
{
     get
     {
          return _numberOfMineTypes;
     }
     set
     {
          _numberOfMineTypes = value;
     }
}

   ///<summary>
   ///location of minefield in world coords
   ///</summary>
public void setMinefieldLocation(Vector3Double pMinefieldLocation)
{ _minefieldLocation = pMinefieldLocation;
}

   ///<summary>
   ///location of minefield in world coords
   ///</summary>
public Vector3Double getMinefieldLocation()
{ return _minefieldLocation; 
}

   ///<summary>
   ///location of minefield in world coords
   ///</summary>
[XmlElement(Type= typeof(Vector3Double), ElementName="minefieldLocation")]
public Vector3Double MinefieldLocation
{
     get
{
          return _minefieldLocation;
}
     set
{
          _minefieldLocation = value;
}
}

   ///<summary>
   ///orientation of minefield
   ///</summary>
public void setMinefieldOrientation(Orientation pMinefieldOrientation)
{ _minefieldOrientation = pMinefieldOrientation;
}

   ///<summary>
   ///orientation of minefield
   ///</summary>
public Orientation getMinefieldOrientation()
{ return _minefieldOrientation; 
}

   ///<summary>
   ///orientation of minefield
   ///</summary>
[XmlElement(Type= typeof(Orientation), ElementName="minefieldOrientation")]
public Orientation MinefieldOrientation
{
     get
{
          return _minefieldOrientation;
}
     set
{
          _minefieldOrientation = value;
}
}

   ///<summary>
   ///appearance bitflags
   ///</summary>
public void setAppearance(ushort pAppearance)
{ _appearance = pAppearance;
}

[XmlElement(Type= typeof(ushort), ElementName="appearance")]
public ushort Appearance
{
     get
{
          return _appearance;
}
     set
{
          _appearance = value;
}
}

   ///<summary>
   ///protocolMode
   ///</summary>
public void setProtocolMode(ushort pProtocolMode)
{ _protocolMode = pProtocolMode;
}

[XmlElement(Type= typeof(ushort), ElementName="protocolMode")]
public ushort ProtocolMode
{
     get
{
          return _protocolMode;
}
     set
{
          _protocolMode = value;
}
}

   ///<summary>
   ///perimeter points for the minefield
   ///</summary>
public void setPerimeterPoints(List<Point> pPerimeterPoints)
{ _perimeterPoints = pPerimeterPoints;
}

   ///<summary>
   ///perimeter points for the minefield
   ///</summary>
public List<Point> getPerimeterPoints()
{ return _perimeterPoints; }

   ///<summary>
   ///perimeter points for the minefield
   ///</summary>
[XmlElement(ElementName = "perimeterPointsList",Type = typeof(List<Point>))]
public List<Point> PerimeterPoints
{
     get
{
          return _perimeterPoints;
}
     set
{
          _perimeterPoints = value;
}
}

   ///<summary>
   ///Type of mines
   ///</summary>
public void setMineType(List<EntityType> pMineType)
{ _mineType = pMineType;
}

   ///<summary>
   ///Type of mines
   ///</summary>
public List<EntityType> getMineType()
{ return _mineType; }

   ///<summary>
   ///Type of mines
   ///</summary>
[XmlElement(ElementName = "mineTypeList",Type = typeof(List<EntityType>))]
public List<EntityType> MineType
{
     get
{
          return _mineType;
}
     set
{
          _mineType = value;
}
}

///<summary>
///Automatically sets the length of the marshalled data, then calls the marshal method.
///</summary>
public void marshalAutoLengthSet(DataOutputStream dos)
{
       //Set the length prior to marshalling data
       this.setLength((ushort)this.getMarshalledSize());
       this.marshal(dos);
}

///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _minefieldID.marshal(dos);
       dos.writeUshort( (ushort)_minefieldSequence);
       dos.writeByte( (byte)_forceID);
       dos.writeByte( (byte)_perimeterPoints.Count);
       _minefieldType.marshal(dos);
       dos.writeUshort( (ushort)_mineType.Count);
       _minefieldLocation.marshal(dos);
       _minefieldOrientation.marshal(dos);
       dos.writeUshort( (ushort)_appearance);
       dos.writeUshort( (ushort)_protocolMode);

       for(int idx = 0; idx < _perimeterPoints.Count; idx++)
       {
            Point aPoint = (Point)_perimeterPoints[idx];
            aPoint.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _mineType.Count; idx++)
       {
            EntityType aEntityType = (EntityType)_mineType[idx];
            aEntityType.marshal(dos);
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
       _minefieldID.unmarshal(dis);
       _minefieldSequence = dis.readUshort();
       _forceID = dis.readByte();
       _numberOfPerimeterPoints = dis.readByte();
       _minefieldType.unmarshal(dis);
       _numberOfMineTypes = dis.readUshort();
       _minefieldLocation.unmarshal(dis);
       _minefieldOrientation.unmarshal(dis);
       _appearance = dis.readUshort();
       _protocolMode = dis.readUshort();
        for(int idx = 0; idx < _numberOfPerimeterPoints; idx++)
        {
           Point anX = new Point();
            anX.unmarshal(dis);
            _perimeterPoints.Add(anX);
        };

        for(int idx = 0; idx < _numberOfMineTypes; idx++)
        {
           EntityType anX = new EntityType();
            anX.unmarshal(dis);
            _mineType.Add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
public void reflection(StringBuilder sb)
{
    sb.Append("----- MinefieldStatePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_minefieldID=====" + System.Environment.NewLine);
       _minefieldID.reflection(sb);
           sb.Append("ushort\t _minefieldSequence\t " + _minefieldSequence.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _forceID\t " + _forceID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _perimeterPoints\t " + _perimeterPoints.Count.ToString() + System.Environment.NewLine);
       sb.Append("=====_minefieldType=====" + System.Environment.NewLine);
       _minefieldType.reflection(sb);
           sb.Append("ushort\t _mineType\t " + _mineType.Count.ToString() + System.Environment.NewLine);
       sb.Append("=====_minefieldLocation=====" + System.Environment.NewLine);
       _minefieldLocation.reflection(sb);
       sb.Append("=====_minefieldOrientation=====" + System.Environment.NewLine);
       _minefieldOrientation.reflection(sb);
           sb.Append("ushort\t _appearance\t " + _appearance.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _protocolMode\t " + _protocolMode.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _perimeterPoints.Count; idx++)
       {
           sb.Append("Point\t " + _perimeterPoints[idx] + System.Environment.NewLine);
            Point aPoint = (Point)_perimeterPoints[idx];
            aPoint.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _mineType.Count; idx++)
       {
           sb.Append("EntityType\t " + _mineType[idx] + System.Environment.NewLine);
            EntityType aEntityType = (EntityType)_mineType[idx];
            aEntityType.reflection(sb);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      Trace.WriteLine(e);
      Trace.Flush();
}
    } // end of marshal method

 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public bool equals(MinefieldStatePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_minefieldID.Equals( rhs._minefieldID) )) ivarsEqual = false;
     if( ! (_minefieldSequence == rhs._minefieldSequence)) ivarsEqual = false;
     if( ! (_forceID == rhs._forceID)) ivarsEqual = false;
     if( ! (_numberOfPerimeterPoints == rhs._numberOfPerimeterPoints)) ivarsEqual = false;
     if( ! (_minefieldType.Equals( rhs._minefieldType) )) ivarsEqual = false;
     if( ! (_numberOfMineTypes == rhs._numberOfMineTypes)) ivarsEqual = false;
     if( ! (_minefieldLocation.Equals( rhs._minefieldLocation) )) ivarsEqual = false;
     if( ! (_minefieldOrientation.Equals( rhs._minefieldOrientation) )) ivarsEqual = false;
     if( ! (_appearance == rhs._appearance)) ivarsEqual = false;
     if( ! (_protocolMode == rhs._protocolMode)) ivarsEqual = false;

     for(int idx = 0; idx < _perimeterPoints.Count; idx++)
     {
        Point x = (Point)_perimeterPoints[idx];
        if( ! ( _perimeterPoints[idx].Equals(rhs._perimeterPoints[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _mineType.Count; idx++)
     {
        EntityType x = (EntityType)_mineType[idx];
        if( ! ( _mineType[idx].Equals(rhs._mineType[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
