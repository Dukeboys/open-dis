using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Used in the UA pdu; ties together an emmitter and a location. This requires manual cleanup; the beam data should not be attached to each emitter system.
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
[XmlInclude(typeof(AcousticEmitterSystem))]
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(AcousticBeamData))]
public class AcousticEmitterSystemData : Object
{
   /** Length of emitter system data */
   protected byte  _emitterSystemDataLength;

   /** Number of beams */
   protected byte  _numberOfBeams;

   /** padding */
   protected ushort  _pad2;

   /** This field shall specify the system for a particular UA emitter. */
   protected AcousticEmitterSystem  _acousticEmitterSystem = new AcousticEmitterSystem(); 

   /** Represents the location wrt the entity */
   protected Vector3Float  _emitterLocation = new Vector3Float(); 

   /** For each beam in numberOfBeams, an emitter system. This is not right--the beam records need to be at the end of the PDU, rather than attached to each system. */
   protected List<object> _beamRecords = new List<object>(); 

/** Constructor */
 public AcousticEmitterSystemData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _emitterSystemDataLength
   marshalSize = marshalSize + 1;  // _numberOfBeams
   marshalSize = marshalSize + 2;  // _pad2
   marshalSize = marshalSize + _acousticEmitterSystem.getMarshalledSize();  // _acousticEmitterSystem
   marshalSize = marshalSize + _emitterLocation.getMarshalledSize();  // _emitterLocation
   for(int idx=0; idx < _beamRecords.Count; idx++)
   {
        AcousticBeamData listElement = (AcousticBeamData)_beamRecords[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEmitterSystemDataLength(byte pEmitterSystemDataLength)
{ _emitterSystemDataLength = pEmitterSystemDataLength;
}

[XmlElement(Type= typeof(byte), ElementName="emitterSystemDataLength")]
public byte EmitterSystemDataLength
{
     get
{
          return _emitterSystemDataLength;
}
     set
{
          _emitterSystemDataLength = value;
}
}

public void setPad2(ushort pPad2)
{ _pad2 = pPad2;
}

[XmlElement(Type= typeof(ushort), ElementName="pad2")]
public ushort Pad2
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

public void setAcousticEmitterSystem(AcousticEmitterSystem pAcousticEmitterSystem)
{ _acousticEmitterSystem = pAcousticEmitterSystem;
}

public AcousticEmitterSystem getAcousticEmitterSystem()
{ return _acousticEmitterSystem; 
}

[XmlElement(Type= typeof(AcousticEmitterSystem), ElementName="acousticEmitterSystem")]
public AcousticEmitterSystem AcousticEmitterSystem
{
     get
{
          return _acousticEmitterSystem;
}
     set
{
          _acousticEmitterSystem = value;
}
}

public void setEmitterLocation(Vector3Float pEmitterLocation)
{ _emitterLocation = pEmitterLocation;
}

public Vector3Float getEmitterLocation()
{ return _emitterLocation; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="emitterLocation")]
public Vector3Float EmitterLocation
{
     get
{
          return _emitterLocation;
}
     set
{
          _emitterLocation = value;
}
}

public void setBeamRecords(List<object> pBeamRecords)
{ _beamRecords = pBeamRecords;
}

public List<object> getBeamRecords()
{ return _beamRecords; }

[XmlElement(ElementName = "beamRecordsList",Type = typeof(List<object>))]
public List<object> BeamRecords
{
     get
{
          return _beamRecords;
}
     set
{
          _beamRecords = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_emitterSystemDataLength);
       dos.writeByte( (byte)_beamRecords.Count);
       dos.writeUshort( (ushort)_pad2);
       _acousticEmitterSystem.marshal(dos);
       _emitterLocation.marshal(dos);

       for(int idx = 0; idx < _beamRecords.Count; idx++)
       {
            AcousticBeamData aAcousticBeamData = (AcousticBeamData)_beamRecords[idx];
            aAcousticBeamData.marshal(dos);
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
       _emitterSystemDataLength = dis.readByte();
       _numberOfBeams = dis.readByte();
       _pad2 = dis.readUshort();
       _acousticEmitterSystem.unmarshal(dis);
       _emitterLocation.unmarshal(dis);
        for(int idx = 0; idx < _numberOfBeams; idx++)
        {
           AcousticBeamData anX = new AcousticBeamData();
            anX.unmarshal(dis);
            _beamRecords.Add(anX);
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
    sb.Append("----- AcousticEmitterSystemData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _emitterSystemDataLength\t " + _emitterSystemDataLength.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _beamRecords\t " + _beamRecords.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
       sb.Append("=====_acousticEmitterSystem=====" + System.Environment.NewLine);
       _acousticEmitterSystem.reflection(sb);
       sb.Append("=====_emitterLocation=====" + System.Environment.NewLine);
       _emitterLocation.reflection(sb);

       for(int idx = 0; idx < _beamRecords.Count; idx++)
       {
           sb.Append("AcousticBeamData\t " + _beamRecords[idx] + System.Environment.NewLine);
            AcousticBeamData aAcousticBeamData = (AcousticBeamData)_beamRecords[idx];
            aAcousticBeamData.reflection(sb);
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
 public bool equals(AcousticEmitterSystemData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_emitterSystemDataLength == rhs._emitterSystemDataLength)) ivarsEqual = false;
     if( ! (_numberOfBeams == rhs._numberOfBeams)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_acousticEmitterSystem.Equals( rhs._acousticEmitterSystem) )) ivarsEqual = false;
     if( ! (_emitterLocation.Equals( rhs._emitterLocation) )) ivarsEqual = false;

     for(int idx = 0; idx < _beamRecords.Count; idx++)
     {
        AcousticBeamData x = (AcousticBeamData)_beamRecords[idx];
        if( ! ( _beamRecords[idx].Equals(rhs._beamRecords[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
