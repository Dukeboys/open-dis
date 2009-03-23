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
   protected List<OneByteChunk> _data = new List<OneByteChunk>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.8.2. Detailed information about a radio transmitter. This PDU requires        manually written code to complete. The encodingScheme field can be used in multiple        ways, which requires hand-written code to finish. UNFINISHED
   ///</summary>
 public SignalPdu()
 {
    PduType = (byte)26;
 }

new public int getMarshalledSize()
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


   ///<summary>
   ///encoding scheme used, and enumeration
   ///</summary>
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

   ///<summary>
   ///tdl type
   ///</summary>
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

   ///<summary>
   ///sample rate
   ///</summary>
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

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getdataLength method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setDataLength(short pDataLength)
{ _dataLength = pDataLength;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getdataLength method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(short), ElementName="dataLength")]
public short DataLength
{
     get
     {
          return _dataLength;
     }
     set
     {
          _dataLength = value;
     }
}

   ///<summary>
   ///number of samples
   ///</summary>
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

   ///<summary>
   ///list of eight bit values
   ///</summary>
public void setData(List<OneByteChunk> pData)
{ _data = pData;
}

   ///<summary>
   ///list of eight bit values
   ///</summary>
public List<OneByteChunk> getData()
{ return _data; }

   ///<summary>
   ///list of eight bit values
   ///</summary>
[XmlElement(ElementName = "dataList",Type = typeof(List<OneByteChunk>))]
public List<OneByteChunk> Data
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

///<summary>
///Automatically sets the length of the marshalled data, then calls the marshal method.
///</summary>
new public void marshalAutoLengthSet(DataOutputStream dos)
{
       //Set the length prior to marshalling data
       this.setLength((ushort)this.getMarshalledSize());
       this.marshal(dos);
}

///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
new public void marshal(DataOutputStream dos)
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

new public void unmarshal(DataInputStream dis)
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
new public void reflection(StringBuilder sb)
{
    sb.Append("<SignalPdu>"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("<encodingScheme type=\"ushort\">" + _encodingScheme.ToString() + "</encodingScheme> " + System.Environment.NewLine);
           sb.Append("<tdlType type=\"ushort\">" + _tdlType.ToString() + "</tdlType> " + System.Environment.NewLine);
           sb.Append("<sampleRate type=\"uint\">" + _sampleRate.ToString() + "</sampleRate> " + System.Environment.NewLine);
           sb.Append("<data type=\"short\">" + _data.Count.ToString() + "</data> " + System.Environment.NewLine);
           sb.Append("<samples type=\"short\">" + _samples.ToString() + "</samples> " + System.Environment.NewLine);

       for(int idx = 0; idx < _data.Count; idx++)
       {
           sb.Append("<data"+ idx.ToString() + " type=\"OneByteChunk\">" + System.Environment.NewLine);
            OneByteChunk aOneByteChunk = (OneByteChunk)_data[idx];
            aOneByteChunk.reflection(sb);
           sb.Append("</data"+ idx.ToString() + ">" + System.Environment.NewLine);
       } // end of list marshalling

    sb.Append("</SignalPdu>"  + System.Environment.NewLine);
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
