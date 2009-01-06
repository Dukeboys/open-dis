using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Data about one electronic system
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
[XmlInclude(typeof(EmitterSystem))]
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(ElectronicEmissionBeamData))]
public class ElectronicEmissionSystemData : Object
{
   /** This field shall specify the length of this emitter system?s data (including beam data and its track/jam information) in 32-bit words. The length shall include the System Data Length field.  */
   protected byte  _systemDataLength;

   /** This field shall specify the number of beams being described in the current PDU for the system being described.  */
   protected byte  _numberOfBeams;

   /** padding. */
   protected ushort  _emissionsPadding2 = 0;

   /** This field shall specify information about a particular emitter system */
   protected EmitterSystem  _emitterSystem = new EmitterSystem(); 

   /** Location with respect to the entity */
   protected Vector3Float  _location = new Vector3Float(); 

   /** variable length list of beam data records */
   protected List<object> _beamDataRecords = new List<object>(); 

/** Constructor */
 public ElectronicEmissionSystemData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _systemDataLength
   marshalSize = marshalSize + 1;  // _numberOfBeams
   marshalSize = marshalSize + 2;  // _emissionsPadding2
   marshalSize = marshalSize + _emitterSystem.getMarshalledSize();  // _emitterSystem
   marshalSize = marshalSize + _location.getMarshalledSize();  // _location
   for(int idx=0; idx < _beamDataRecords.Count; idx++)
   {
        ElectronicEmissionBeamData listElement = (ElectronicEmissionBeamData)_beamDataRecords[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setSystemDataLength(byte pSystemDataLength)
{ _systemDataLength = pSystemDataLength;
}

[XmlElement(Type= typeof(byte), ElementName="systemDataLength")]
public byte SystemDataLength
{
     get
{
          return _systemDataLength;
}
     set
{
          _systemDataLength = value;
}
}

public void setEmissionsPadding2(ushort pEmissionsPadding2)
{ _emissionsPadding2 = pEmissionsPadding2;
}

[XmlElement(Type= typeof(ushort), ElementName="emissionsPadding2")]
public ushort EmissionsPadding2
{
     get
{
          return _emissionsPadding2;
}
     set
{
          _emissionsPadding2 = value;
}
}

public void setEmitterSystem(EmitterSystem pEmitterSystem)
{ _emitterSystem = pEmitterSystem;
}

public EmitterSystem getEmitterSystem()
{ return _emitterSystem; 
}

[XmlElement(Type= typeof(EmitterSystem), ElementName="emitterSystem")]
public EmitterSystem EmitterSystem
{
     get
{
          return _emitterSystem;
}
     set
{
          _emitterSystem = value;
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

public void setBeamDataRecords(List<object> pBeamDataRecords)
{ _beamDataRecords = pBeamDataRecords;
}

public List<object> getBeamDataRecords()
{ return _beamDataRecords; }

[XmlElement(ElementName = "beamDataRecordsList",Type = typeof(List<object>))]
public List<object> BeamDataRecords
{
     get
{
          return _beamDataRecords;
}
     set
{
          _beamDataRecords = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_systemDataLength);
       dos.writeByte( (byte)_beamDataRecords.Count);
       dos.writeUshort( (ushort)_emissionsPadding2);
       _emitterSystem.marshal(dos);
       _location.marshal(dos);

       for(int idx = 0; idx < _beamDataRecords.Count; idx++)
       {
            ElectronicEmissionBeamData aElectronicEmissionBeamData = (ElectronicEmissionBeamData)_beamDataRecords[idx];
            aElectronicEmissionBeamData.marshal(dos);
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
    try 
    {
       _systemDataLength = dis.readByte();
       _numberOfBeams = dis.readByte();
       _emissionsPadding2 = dis.readUshort();
       _emitterSystem.unmarshal(dis);
       _location.unmarshal(dis);
        for(int idx = 0; idx < _numberOfBeams; idx++)
        {
           ElectronicEmissionBeamData anX = new ElectronicEmissionBeamData();
            anX.unmarshal(dis);
            _beamDataRecords.Add(anX);
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
    sb.Append("----- ElectronicEmissionSystemData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _systemDataLength\t " + _systemDataLength.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _beamDataRecords\t " + _beamDataRecords.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _emissionsPadding2\t " + _emissionsPadding2.ToString() + System.Environment.NewLine);
       sb.Append("=====_emitterSystem=====" + System.Environment.NewLine);
       _emitterSystem.reflection(sb);
       sb.Append("=====_location=====" + System.Environment.NewLine);
       _location.reflection(sb);

       for(int idx = 0; idx < _beamDataRecords.Count; idx++)
       {
           sb.Append("ElectronicEmissionBeamData\t " + _beamDataRecords[idx] + System.Environment.NewLine);
            ElectronicEmissionBeamData aElectronicEmissionBeamData = (ElectronicEmissionBeamData)_beamDataRecords[idx];
            aElectronicEmissionBeamData.reflection(sb);
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
 public bool equals(ElectronicEmissionSystemData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_systemDataLength == rhs._systemDataLength)) ivarsEqual = false;
     if( ! (_numberOfBeams == rhs._numberOfBeams)) ivarsEqual = false;
     if( ! (_emissionsPadding2 == rhs._emissionsPadding2)) ivarsEqual = false;
     if( ! (_emitterSystem.Equals( rhs._emitterSystem) )) ivarsEqual = false;
     if( ! (_location.Equals( rhs._location) )) ivarsEqual = false;

     for(int idx = 0; idx < _beamDataRecords.Count; idx++)
     {
        ElectronicEmissionBeamData x = (ElectronicEmissionBeamData)_beamDataRecords[idx];
        if( ! ( _beamDataRecords[idx].Equals(rhs._beamDataRecords[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
