using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.8.2. Detailed information about a radio transmitter. This PDU requires        manually written code to complete. The encodingScheme field can be used in multiple        ways, which requires hand-written code to finish. UNFINISHED
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
[XmlInclude(typeof(OneByteChunk))]
public class SignalPdu : RadioCommunicationsFamilyPdu
{
   /** encoding scheme used, and enumeration */
   protected ushort  _encodingScheme;

   /** tdl type */
   protected ushort  _tdlType;

   /** sample rate */
   protected uint  _sampleRate;

   /** length od data */
   protected short  _dataLength;

   /** number of samples */
   protected short  _samples;

   /** list of eight bit values */
   protected List<object> _data = new List<object>(); 

/** Constructor */
 public SignalPdu()
 {
    PduType = (byte)26;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
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

public void setSamples(short pSamples)
{ _samples = pSamples;
}

[XmlElement(Type= typeof(short), ElementName="samples")]
public short Samples
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
       dos.writeUshort( (ushort)_encodingScheme);
       dos.writeUshort( (ushort)_tdlType);
       dos.writeUint( (uint)_sampleRate);
       dos.writeShort( (short)_data.Count);
       dos.writeShort( (short)_samples);

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
       _encodingScheme = dis.readUshort();
       _tdlType = dis.readUshort();
       _sampleRate = dis.readUint();
       _dataLength = dis.readShort();
       _samples = dis.readShort();
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
    sb.Append("----- SignalPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("ushort\t _encodingScheme\t " + _encodingScheme.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _tdlType\t " + _tdlType.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _sampleRate\t " + _sampleRate.ToString() + System.Environment.NewLine);
           sb.Append("short\t _data\t " + _data.Count.ToString() + System.Environment.NewLine);
           sb.Append("short\t _samples\t " + _samples.ToString() + System.Environment.NewLine);

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
 public bool equals(SignalPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

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
