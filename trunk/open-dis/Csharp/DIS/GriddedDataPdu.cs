using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.11.2: Information about globat, spatially varying enviornmental effects. This requires manual cleanup; the grid axis        records are variable sized. UNFINISHED
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
[XmlInclude(typeof(Orientation))]
[XmlInclude(typeof(GridAxisRecord))]
public class GriddedDataPdu : SyntheticEnvironmentFamilyPdu
{
   /** environmental simulation application ID */
   protected EntityID  _environmentalSimulationApplicationID = new EntityID(); 

   /** unique identifier for each piece of enviornmental data */
   protected ushort  _fieldNumber;

   /** sequence number for the total set of PDUS used to transmit the data */
   protected ushort  _pduNumber;

   /** Total number of PDUS used to transmit the data */
   protected ushort  _pduTotal;

   /** coordinate system of the grid */
   protected ushort  _coordinateSystem;

   /** number of grid axes for the environmental data */
   protected byte  _numberOfGridAxes;

   /** are domain grid axes identidal to those of the priveious domain update? */
   protected byte  _constantGrid;

   /** type of environment */
   protected EntityType  _environmentType = new EntityType(); 

   /** orientation of the data grid */
   protected Orientation  _orientation = new Orientation(); 

   /** valid time of the enviormental data sample, 64 bit unsigned int */
   protected long  _sampleTime;

   /** total number of all data values for all pdus for an environmental sample */
   protected uint  _totalValues;

   /** total number of data values at each grid point. */
   protected byte  _vectorDimension;

   /** padding */
   protected ushort  _padding1;

   /** padding */
   protected byte  _padding2;

   /** Grid data @@@This is wrong */
   protected List<object> _gridDataList = new List<object>(); 

/** Constructor */
 public GriddedDataPdu()
 {
    PduType = (byte)42;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _environmentalSimulationApplicationID.getMarshalledSize();  // _environmentalSimulationApplicationID
   marshalSize = marshalSize + 2;  // _fieldNumber
   marshalSize = marshalSize + 2;  // _pduNumber
   marshalSize = marshalSize + 2;  // _pduTotal
   marshalSize = marshalSize + 2;  // _coordinateSystem
   marshalSize = marshalSize + 1;  // _numberOfGridAxes
   marshalSize = marshalSize + 1;  // _constantGrid
   marshalSize = marshalSize + _environmentType.getMarshalledSize();  // _environmentType
   marshalSize = marshalSize + _orientation.getMarshalledSize();  // _orientation
   marshalSize = marshalSize + 8;  // _sampleTime
   marshalSize = marshalSize + 4;  // _totalValues
   marshalSize = marshalSize + 1;  // _vectorDimension
   marshalSize = marshalSize + 2;  // _padding1
   marshalSize = marshalSize + 1;  // _padding2
   for(int idx=0; idx < _gridDataList.Count; idx++)
   {
        GridAxisRecord listElement = (GridAxisRecord)_gridDataList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEnvironmentalSimulationApplicationID(EntityID pEnvironmentalSimulationApplicationID)
{ _environmentalSimulationApplicationID = pEnvironmentalSimulationApplicationID;
}

public EntityID getEnvironmentalSimulationApplicationID()
{ return _environmentalSimulationApplicationID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="environmentalSimulationApplicationID")]
public EntityID EnvironmentalSimulationApplicationID
{
     get
{
          return _environmentalSimulationApplicationID;
}
     set
{
          _environmentalSimulationApplicationID = value;
}
}

public void setFieldNumber(ushort pFieldNumber)
{ _fieldNumber = pFieldNumber;
}

[XmlElement(Type= typeof(ushort), ElementName="fieldNumber")]
public ushort FieldNumber
{
     get
{
          return _fieldNumber;
}
     set
{
          _fieldNumber = value;
}
}

public void setPduNumber(ushort pPduNumber)
{ _pduNumber = pPduNumber;
}

[XmlElement(Type= typeof(ushort), ElementName="pduNumber")]
public ushort PduNumber
{
     get
{
          return _pduNumber;
}
     set
{
          _pduNumber = value;
}
}

public void setPduTotal(ushort pPduTotal)
{ _pduTotal = pPduTotal;
}

[XmlElement(Type= typeof(ushort), ElementName="pduTotal")]
public ushort PduTotal
{
     get
{
          return _pduTotal;
}
     set
{
          _pduTotal = value;
}
}

public void setCoordinateSystem(ushort pCoordinateSystem)
{ _coordinateSystem = pCoordinateSystem;
}

[XmlElement(Type= typeof(ushort), ElementName="coordinateSystem")]
public ushort CoordinateSystem
{
     get
{
          return _coordinateSystem;
}
     set
{
          _coordinateSystem = value;
}
}

public void setConstantGrid(byte pConstantGrid)
{ _constantGrid = pConstantGrid;
}

[XmlElement(Type= typeof(byte), ElementName="constantGrid")]
public byte ConstantGrid
{
     get
{
          return _constantGrid;
}
     set
{
          _constantGrid = value;
}
}

public void setEnvironmentType(EntityType pEnvironmentType)
{ _environmentType = pEnvironmentType;
}

public EntityType getEnvironmentType()
{ return _environmentType; 
}

[XmlElement(Type= typeof(EntityType), ElementName="environmentType")]
public EntityType EnvironmentType
{
     get
{
          return _environmentType;
}
     set
{
          _environmentType = value;
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

public void setSampleTime(long pSampleTime)
{ _sampleTime = pSampleTime;
}

[XmlElement(Type= typeof(long), ElementName="sampleTime")]
public long SampleTime
{
     get
{
          return _sampleTime;
}
     set
{
          _sampleTime = value;
}
}

public void setTotalValues(uint pTotalValues)
{ _totalValues = pTotalValues;
}

[XmlElement(Type= typeof(uint), ElementName="totalValues")]
public uint TotalValues
{
     get
{
          return _totalValues;
}
     set
{
          _totalValues = value;
}
}

public void setVectorDimension(byte pVectorDimension)
{ _vectorDimension = pVectorDimension;
}

[XmlElement(Type= typeof(byte), ElementName="vectorDimension")]
public byte VectorDimension
{
     get
{
          return _vectorDimension;
}
     set
{
          _vectorDimension = value;
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

public void setGridDataList(List<object> pGridDataList)
{ _gridDataList = pGridDataList;
}

public List<object> getGridDataList()
{ return _gridDataList; }

[XmlElement(ElementName = "gridDataListList",Type = typeof(List<object>))]
public List<object> GridDataList
{
     get
{
          return _gridDataList;
}
     set
{
          _gridDataList = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _environmentalSimulationApplicationID.marshal(dos);
       dos.writeUshort( (ushort)_fieldNumber);
       dos.writeUshort( (ushort)_pduNumber);
       dos.writeUshort( (ushort)_pduTotal);
       dos.writeUshort( (ushort)_coordinateSystem);
       dos.writeByte( (byte)_gridDataList.Count);
       dos.writeByte( (byte)_constantGrid);
       _environmentType.marshal(dos);
       _orientation.marshal(dos);
       dos.writeLong( (long)_sampleTime);
       dos.writeUint( (uint)_totalValues);
       dos.writeByte( (byte)_vectorDimension);
       dos.writeUshort( (ushort)_padding1);
       dos.writeByte( (byte)_padding2);

       for(int idx = 0; idx < _gridDataList.Count; idx++)
       {
            GridAxisRecord aGridAxisRecord = (GridAxisRecord)_gridDataList[idx];
            aGridAxisRecord.marshal(dos);
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
       _environmentalSimulationApplicationID.unmarshal(dis);
       _fieldNumber = dis.readUshort();
       _pduNumber = dis.readUshort();
       _pduTotal = dis.readUshort();
       _coordinateSystem = dis.readUshort();
       _numberOfGridAxes = dis.readByte();
       _constantGrid = dis.readByte();
       _environmentType.unmarshal(dis);
       _orientation.unmarshal(dis);
       _sampleTime = dis.readLong();
       _totalValues = dis.readUint();
       _vectorDimension = dis.readByte();
       _padding1 = dis.readUshort();
       _padding2 = dis.readByte();
        for(int idx = 0; idx < _numberOfGridAxes; idx++)
        {
           GridAxisRecord anX = new GridAxisRecord();
            anX.unmarshal(dis);
            _gridDataList.Add(anX);
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
    sb.Append("----- GriddedDataPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_environmentalSimulationApplicationID=====" + System.Environment.NewLine);
       _environmentalSimulationApplicationID.reflection(sb);
           sb.Append("ushort\t _fieldNumber\t " + _fieldNumber.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _pduNumber\t " + _pduNumber.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _pduTotal\t " + _pduTotal.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _coordinateSystem\t " + _coordinateSystem.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _gridDataList\t " + _gridDataList.Count.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _constantGrid\t " + _constantGrid.ToString() + System.Environment.NewLine);
       sb.Append("=====_environmentType=====" + System.Environment.NewLine);
       _environmentType.reflection(sb);
       sb.Append("=====_orientation=====" + System.Environment.NewLine);
       _orientation.reflection(sb);
           sb.Append("long\t _sampleTime\t " + _sampleTime.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _totalValues\t " + _totalValues.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _vectorDimension\t " + _vectorDimension.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _padding2\t " + _padding2.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _gridDataList.Count; idx++)
       {
           sb.Append("GridAxisRecord\t " + _gridDataList[idx] + System.Environment.NewLine);
            GridAxisRecord aGridAxisRecord = (GridAxisRecord)_gridDataList[idx];
            aGridAxisRecord.reflection(sb);
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
 public bool equals(GriddedDataPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_environmentalSimulationApplicationID.Equals( rhs._environmentalSimulationApplicationID) )) ivarsEqual = false;
     if( ! (_fieldNumber == rhs._fieldNumber)) ivarsEqual = false;
     if( ! (_pduNumber == rhs._pduNumber)) ivarsEqual = false;
     if( ! (_pduTotal == rhs._pduTotal)) ivarsEqual = false;
     if( ! (_coordinateSystem == rhs._coordinateSystem)) ivarsEqual = false;
     if( ! (_numberOfGridAxes == rhs._numberOfGridAxes)) ivarsEqual = false;
     if( ! (_constantGrid == rhs._constantGrid)) ivarsEqual = false;
     if( ! (_environmentType.Equals( rhs._environmentType) )) ivarsEqual = false;
     if( ! (_orientation.Equals( rhs._orientation) )) ivarsEqual = false;
     if( ! (_sampleTime == rhs._sampleTime)) ivarsEqual = false;
     if( ! (_totalValues == rhs._totalValues)) ivarsEqual = false;
     if( ! (_vectorDimension == rhs._vectorDimension)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_padding2 == rhs._padding2)) ivarsEqual = false;

     for(int idx = 0; idx < _gridDataList.Count; idx++)
     {
        GridAxisRecord x = (GridAxisRecord)_gridDataList[idx];
        if( ! ( _gridDataList[idx].Equals(rhs._gridDataList[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
