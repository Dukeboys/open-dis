using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.8.4. Actual transmission of intercome voice data. COMPLETE
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
[XmlInclude(typeof(OneByteChunk))]
public class IntercomSignalPdu : RadioCommunicationsFamilyPdu
{
   /** entity ID */
   protected EntityID  _entityID = new EntityID(); 

   /** ID of communications device */
   protected ushort  _communicationsDeviceID;

   /** encoding scheme */
   protected ushort  _encodingScheme;

   /** tactical data link type */
   protected ushort  _tdlType;

   /** sample rate */
   protected uint  _sampleRate;

   /** data length */
   protected ushort  _dataLength;

   /** samples */
   protected ushort  _samples;

   /** data bytes */
   protected List<object> _data = new List<object>(); 

/** Constructor */
 public IntercomSignalPdu()
 {
    PduType = (byte)31;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _entityID.getMarshalledSize();  // _entityID
   marshalSize = marshalSize + 2;  // _communicationsDeviceID
   marshalSize = marshalSize + 2;  // _encodingScheme
   marshalSize = marshalSize + 2;  // _tdlType
   marshalSize = marshalSize + 4;  // _sampleRate
   marshalSize = marshalSize + 2;  // _dataLength
   marshalSize = marshalSize + 2;  // _samples
   for(int idx=0; idx < _data.Count; idx++)
   {
        OneByteChunk listElement = (OneByteChunk)_data[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEntityID(EntityID pEntityID)
{ _entityID = pEntityID;
}

public EntityID getEntityID()
{ return _entityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="entityID")]
public EntityID EntityID
{
     get
{
          return _entityID;
}
     set
{
          _entityID = value;
}
}

public void setCommunicationsDeviceID(ushort pCommunicationsDeviceID)
{ _communicationsDeviceID = pCommunicationsDeviceID;
}

[XmlElement(Type= typeof(ushort), ElementName="communicationsDeviceID")]
public ushort CommunicationsDeviceID
{
     get
{
          return _communicationsDeviceID;
}
     set
{
          _communicationsDeviceID = value;
}
}

public void setEncodingScheme(ushort pEncodingScheme)
{ _encodingScheme = pEncodingScheme;
}

[XmlElement(Type= typeof(ushort), ElementName="encodingScheme")]
public ushort EncodingScheme
{
     get
{
          return _encodingScheme;
}
     set
{
          _encodingScheme = value;
}
}

public void setTdlType(ushort pTdlType)
{ _tdlType = pTdlType;
}

[XmlElement(Type= typeof(ushort), ElementName="tdlType")]
public ushort TdlType
{
     get
{
          return _tdlType;
}
     set
{
          _tdlType = value;
}
}

public void setSampleRate(uint pSampleRate)
{ _sampleRate = pSampleRate;
}

[XmlElement(Type= typeof(uint), ElementName="sampleRate")]
public uint SampleRate
{
     get
{
          return _sampleRate;
}
     set
{
          _sampleRate = value;
}
}

public void setSamples(ushort pSamples)
{ _samples = pSamples;
}

[XmlElement(Type= typeof(ushort), ElementName="samples")]
public ushort Samples
{
     get
{
          return _samples;
}
     set
{
          _samples = value;
}
}

public void setData(List<object> pData)
{ _data = pData;
}

public List<object> getData()
{ return _data; }

[XmlElement(ElementName = "dataList",Type = typeof(List<object>))]
public List<object> Data
{
     get
{
          return _data;
}
     set
{
          _data = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _entityID.marshal(dos);
       dos.writeUshort( (ushort)_communicationsDeviceID);
       dos.writeUshort( (ushort)_encodingScheme);
       dos.writeUshort( (ushort)_tdlType);
       dos.writeUint( (uint)_sampleRate);
       dos.writeUshort( (ushort)_data.Count);
       dos.writeUshort( (ushort)_samples);

       for(int idx = 0; idx < _data.Count; idx++)
       {
            OneByteChunk aOneByteChunk = (OneByteChunk)_data[idx];
            aOneByteChunk.marshal(dos);
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
       _entityID.unmarshal(dis);
       _communicationsDeviceID = dis.readUshort();
       _encodingScheme = dis.readUshort();
       _tdlType = dis.readUshort();
       _sampleRate = dis.readUint();
       _dataLength = dis.readUshort();
       _samples = dis.readUshort();
        for(int idx = 0; idx < _dataLength; idx++)
        {
           OneByteChunk anX = new OneByteChunk();
            anX.unmarshal(dis);
            _data.Add(anX);
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
    sb.Append("----- IntercomSignalPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_entityID=====" + System.Environment.NewLine);
       _entityID.reflection(sb);
           sb.Append("ushort\t _communicationsDeviceID\t " + _communicationsDeviceID.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _encodingScheme\t " + _encodingScheme.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _tdlType\t " + _tdlType.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _sampleRate\t " + _sampleRate.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _data\t " + _data.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _samples\t " + _samples.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _data.Count; idx++)
       {
           sb.Append("OneByteChunk\t " + _data[idx] + System.Environment.NewLine);
            OneByteChunk aOneByteChunk = (OneByteChunk)_data[idx];
            aOneByteChunk.reflection(sb);
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
 public bool equals(IntercomSignalPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_entityID.Equals( rhs._entityID) )) ivarsEqual = false;
     if( ! (_communicationsDeviceID == rhs._communicationsDeviceID)) ivarsEqual = false;
     if( ! (_encodingScheme == rhs._encodingScheme)) ivarsEqual = false;
     if( ! (_tdlType == rhs._tdlType)) ivarsEqual = false;
     if( ! (_sampleRate == rhs._sampleRate)) ivarsEqual = false;
     if( ! (_dataLength == rhs._dataLength)) ivarsEqual = false;
     if( ! (_samples == rhs._samples)) ivarsEqual = false;

     for(int idx = 0; idx < _data.Count; idx++)
     {
        OneByteChunk x = (OneByteChunk)_data[idx];
        if( ! ( _data[idx].Equals(rhs._data[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
