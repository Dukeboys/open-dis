using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.7.5. SEES PDU, supplemental emissions entity state information. COMPLETE
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
[XmlInclude(typeof(PropulsionSystemData))]
[XmlInclude(typeof(VectoringNozzleSystemData))]
public class SeesPdu : DistributedEmissionsFamilyPdu
{
   /** Originating entity ID */
   protected EntityID  _orginatingEntityID = new EntityID(); 

   /** IR Signature representation index */
   protected ushort  _infraredSignatureRepresentationIndex;

   /** acoustic Signature representation index */
   protected ushort  _acousticSignatureRepresentationIndex;

   /** radar cross section representation index */
   protected ushort  _radarCrossSectionSignatureRepresentationIndex;

   /** how many propulsion systems */
   protected ushort  _numberOfPropulsionSystems;

   /** how many vectoring nozzle systems */
   protected ushort  _numberOfVectoringNozzleSystems;

   /** variable length list of propulsion system data */
   protected List<object> _propulsionSystemData = new List<object>(); 
   /** variable length list of vectoring system data */
   protected List<object> _vectoringSystemData = new List<object>(); 

/** Constructor */
 public SeesPdu()
 {
    PduType = (byte)30;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _orginatingEntityID.getMarshalledSize();  // _orginatingEntityID
   marshalSize = marshalSize + 2;  // _infraredSignatureRepresentationIndex
   marshalSize = marshalSize + 2;  // _acousticSignatureRepresentationIndex
   marshalSize = marshalSize + 2;  // _radarCrossSectionSignatureRepresentationIndex
   marshalSize = marshalSize + 2;  // _numberOfPropulsionSystems
   marshalSize = marshalSize + 2;  // _numberOfVectoringNozzleSystems
   for(int idx=0; idx < _propulsionSystemData.Count; idx++)
   {
        PropulsionSystemData listElement = (PropulsionSystemData)_propulsionSystemData[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _vectoringSystemData.Count; idx++)
   {
        VectoringNozzleSystemData listElement = (VectoringNozzleSystemData)_vectoringSystemData[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setOrginatingEntityID(EntityID pOrginatingEntityID)
{ _orginatingEntityID = pOrginatingEntityID;
}

public EntityID getOrginatingEntityID()
{ return _orginatingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="orginatingEntityID")]
public EntityID OrginatingEntityID
{
     get
{
          return _orginatingEntityID;
}
     set
{
          _orginatingEntityID = value;
}
}

public void setInfraredSignatureRepresentationIndex(ushort pInfraredSignatureRepresentationIndex)
{ _infraredSignatureRepresentationIndex = pInfraredSignatureRepresentationIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="infraredSignatureRepresentationIndex")]
public ushort InfraredSignatureRepresentationIndex
{
     get
{
          return _infraredSignatureRepresentationIndex;
}
     set
{
          _infraredSignatureRepresentationIndex = value;
}
}

public void setAcousticSignatureRepresentationIndex(ushort pAcousticSignatureRepresentationIndex)
{ _acousticSignatureRepresentationIndex = pAcousticSignatureRepresentationIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="acousticSignatureRepresentationIndex")]
public ushort AcousticSignatureRepresentationIndex
{
     get
{
          return _acousticSignatureRepresentationIndex;
}
     set
{
          _acousticSignatureRepresentationIndex = value;
}
}

public void setRadarCrossSectionSignatureRepresentationIndex(ushort pRadarCrossSectionSignatureRepresentationIndex)
{ _radarCrossSectionSignatureRepresentationIndex = pRadarCrossSectionSignatureRepresentationIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="radarCrossSectionSignatureRepresentationIndex")]
public ushort RadarCrossSectionSignatureRepresentationIndex
{
     get
{
          return _radarCrossSectionSignatureRepresentationIndex;
}
     set
{
          _radarCrossSectionSignatureRepresentationIndex = value;
}
}

public void setPropulsionSystemData(List<object> pPropulsionSystemData)
{ _propulsionSystemData = pPropulsionSystemData;
}

public List<object> getPropulsionSystemData()
{ return _propulsionSystemData; }

[XmlElement(ElementName = "propulsionSystemDataList",Type = typeof(List<object>))]
public List<object> PropulsionSystemData
{
     get
{
          return _propulsionSystemData;
}
     set
{
          _propulsionSystemData = value;
}
}

public void setVectoringSystemData(List<object> pVectoringSystemData)
{ _vectoringSystemData = pVectoringSystemData;
}

public List<object> getVectoringSystemData()
{ return _vectoringSystemData; }

[XmlElement(ElementName = "vectoringSystemDataList",Type = typeof(List<object>))]
public List<object> VectoringSystemData
{
     get
{
          return _vectoringSystemData;
}
     set
{
          _vectoringSystemData = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _orginatingEntityID.marshal(dos);
       dos.writeUshort( (ushort)_infraredSignatureRepresentationIndex);
       dos.writeUshort( (ushort)_acousticSignatureRepresentationIndex);
       dos.writeUshort( (ushort)_radarCrossSectionSignatureRepresentationIndex);
       dos.writeUshort( (ushort)_propulsionSystemData.Count);
       dos.writeUshort( (ushort)_vectoringSystemData.Count);

       for(int idx = 0; idx < _propulsionSystemData.Count; idx++)
       {
            PropulsionSystemData aPropulsionSystemData = (PropulsionSystemData)_propulsionSystemData[idx];
            aPropulsionSystemData.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _vectoringSystemData.Count; idx++)
       {
            VectoringNozzleSystemData aVectoringNozzleSystemData = (VectoringNozzleSystemData)_vectoringSystemData[idx];
            aVectoringNozzleSystemData.marshal(dos);
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
       _orginatingEntityID.unmarshal(dis);
       _infraredSignatureRepresentationIndex = dis.readUshort();
       _acousticSignatureRepresentationIndex = dis.readUshort();
       _radarCrossSectionSignatureRepresentationIndex = dis.readUshort();
       _numberOfPropulsionSystems = dis.readUshort();
       _numberOfVectoringNozzleSystems = dis.readUshort();
        for(int idx = 0; idx < _numberOfPropulsionSystems; idx++)
        {
           PropulsionSystemData anX = new PropulsionSystemData();
            anX.unmarshal(dis);
            _propulsionSystemData.Add(anX);
        };

        for(int idx = 0; idx < _numberOfVectoringNozzleSystems; idx++)
        {
           VectoringNozzleSystemData anX = new VectoringNozzleSystemData();
            anX.unmarshal(dis);
            _vectoringSystemData.Add(anX);
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
    sb.Append("----- SeesPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_orginatingEntityID=====" + System.Environment.NewLine);
       _orginatingEntityID.reflection(sb);
           sb.Append("ushort\t _infraredSignatureRepresentationIndex\t " + _infraredSignatureRepresentationIndex.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _acousticSignatureRepresentationIndex\t " + _acousticSignatureRepresentationIndex.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _radarCrossSectionSignatureRepresentationIndex\t " + _radarCrossSectionSignatureRepresentationIndex.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _propulsionSystemData\t " + _propulsionSystemData.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _vectoringSystemData\t " + _vectoringSystemData.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _propulsionSystemData.Count; idx++)
       {
           sb.Append("PropulsionSystemData\t " + _propulsionSystemData[idx] + System.Environment.NewLine);
            PropulsionSystemData aPropulsionSystemData = (PropulsionSystemData)_propulsionSystemData[idx];
            aPropulsionSystemData.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _vectoringSystemData.Count; idx++)
       {
           sb.Append("VectoringNozzleSystemData\t " + _vectoringSystemData[idx] + System.Environment.NewLine);
            VectoringNozzleSystemData aVectoringNozzleSystemData = (VectoringNozzleSystemData)_vectoringSystemData[idx];
            aVectoringNozzleSystemData.reflection(sb);
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
 public bool equals(SeesPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_orginatingEntityID.Equals( rhs._orginatingEntityID) )) ivarsEqual = false;
     if( ! (_infraredSignatureRepresentationIndex == rhs._infraredSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (_acousticSignatureRepresentationIndex == rhs._acousticSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (_radarCrossSectionSignatureRepresentationIndex == rhs._radarCrossSectionSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (_numberOfPropulsionSystems == rhs._numberOfPropulsionSystems)) ivarsEqual = false;
     if( ! (_numberOfVectoringNozzleSystems == rhs._numberOfVectoringNozzleSystems)) ivarsEqual = false;

     for(int idx = 0; idx < _propulsionSystemData.Count; idx++)
     {
        PropulsionSystemData x = (PropulsionSystemData)_propulsionSystemData[idx];
        if( ! ( _propulsionSystemData[idx].Equals(rhs._propulsionSystemData[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _vectoringSystemData.Count; idx++)
     {
        VectoringNozzleSystemData x = (VectoringNozzleSystemData)_vectoringSystemData[idx];
        if( ! ( _vectoringSystemData[idx].Equals(rhs._vectoringSystemData[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
