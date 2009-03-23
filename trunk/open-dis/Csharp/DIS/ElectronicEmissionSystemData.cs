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
   protected List<ElectronicEmissionBeamData> _beamDataRecords = new List<ElectronicEmissionBeamData>(); 

/** Constructor */
   ///<summary>
   ///Data about one electronic system
   ///</summary>
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


   ///<summary>
   ///This field shall specify the length of this emitter system?s data (including beam data and its track/jam information) in 32-bit words. The length shall include the System Data Length field. 
   ///</summary>
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

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfBeams method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfBeams(byte pNumberOfBeams)
{ _numberOfBeams = pNumberOfBeams;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfBeams method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(byte), ElementName="numberOfBeams")]
public byte NumberOfBeams
{
     get
     {
          return _numberOfBeams;
     }
     set
     {
          _numberOfBeams = value;
     }
}

   ///<summary>
   ///padding.
   ///</summary>
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

   ///<summary>
   ///This field shall specify information about a particular emitter system
   ///</summary>
public void setEmitterSystem(EmitterSystem pEmitterSystem)
{ _emitterSystem = pEmitterSystem;
}

   ///<summary>
   ///This field shall specify information about a particular emitter system
   ///</summary>
public EmitterSystem getEmitterSystem()
{ return _emitterSystem; 
}

   ///<summary>
   ///This field shall specify information about a particular emitter system
   ///</summary>
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

   ///<summary>
   ///Location with respect to the entity
   ///</summary>
public void setLocation(Vector3Float pLocation)
{ _location = pLocation;
}

   ///<summary>
   ///Location with respect to the entity
   ///</summary>
public Vector3Float getLocation()
{ return _location; 
}

   ///<summary>
   ///Location with respect to the entity
   ///</summary>
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

   ///<summary>
   ///variable length list of beam data records
   ///</summary>
public void setBeamDataRecords(List<ElectronicEmissionBeamData> pBeamDataRecords)
{ _beamDataRecords = pBeamDataRecords;
}

   ///<summary>
   ///variable length list of beam data records
   ///</summary>
public List<ElectronicEmissionBeamData> getBeamDataRecords()
{ return _beamDataRecords; }

   ///<summary>
   ///variable length list of beam data records
   ///</summary>
[XmlElement(ElementName = "beamDataRecordsList",Type = typeof(List<ElectronicEmissionBeamData>))]
public List<ElectronicEmissionBeamData> BeamDataRecords
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


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
public void reflection(StringBuilder sb)
{
    sb.Append("<ElectronicEmissionSystemData>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<systemDataLength type=\"byte\">" + _systemDataLength.ToString() + "</systemDataLength> " + System.Environment.NewLine);
           sb.Append("<beamDataRecords type=\"byte\">" + _beamDataRecords.Count.ToString() + "</beamDataRecords> " + System.Environment.NewLine);
           sb.Append("<emissionsPadding2 type=\"ushort\">" + _emissionsPadding2.ToString() + "</emissionsPadding2> " + System.Environment.NewLine);
    sb.Append("<emitterSystem>"  + System.Environment.NewLine);
       _emitterSystem.reflection(sb);
    sb.Append("</emitterSystem>"  + System.Environment.NewLine);
    sb.Append("<location>"  + System.Environment.NewLine);
       _location.reflection(sb);
    sb.Append("</location>"  + System.Environment.NewLine);

       for(int idx = 0; idx < _beamDataRecords.Count; idx++)
       {
           sb.Append("<beamDataRecords"+ idx.ToString() + " type=\"ElectronicEmissionBeamData\">" + System.Environment.NewLine);
            ElectronicEmissionBeamData aElectronicEmissionBeamData = (ElectronicEmissionBeamData)_beamDataRecords[idx];
            aElectronicEmissionBeamData.reflection(sb);
           sb.Append("</beamDataRecords"+ idx.ToString() + ">" + System.Environment.NewLine);
       } // end of list marshalling

    sb.Append("</ElectronicEmissionSystemData>"  + System.Environment.NewLine);
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
