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
   protected ushort  _TdlType;

   /** sample rate */
   protected uint  _sampleRate;

   /** data length */
   protected ushort  _dataLength;

   /** samples */
   protected ushort  _samples;

   /** data bytes */
   protected List<OneByteChunk> _data = new List<OneByteChunk>(); 

/** Constructor */
   ///<summary>
   ///Section 5.3.8.4. Actual transmission of intercome voice data. COMPLETE
   ///</summary>
 public IntercomSignalPdu()
 {
    PduType = (byte)31;
 }

new public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _entityID.getMarshalledSize();  // _entityID
   marshalSize = marshalSize + 2;  // _communicationsDeviceID
   marshalSize = marshalSize + 2;  // _encodingScheme
   marshalSize = marshalSize + 2;  // _TdlType
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
   ///entity ID
   ///</summary>
public void setEntityID(EntityID pEntityID)
{ _entityID = pEntityID;
}

   ///<summary>
   ///entity ID
   ///</summary>
public EntityID getEntityID()
{ return _entityID; 
}

   ///<summary>
   ///entity ID
   ///</summary>
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

   ///<summary>
   ///ID of communications device
   ///</summary>
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

   ///<summary>
   ///encoding scheme
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
   ///tactical data link type
   ///</summary>
public void setTdlType(ushort pTdlType)
{ _TdlType = pTdlType;
}

[XmlElement(Type= typeof(ushort), ElementName="TdlType")]
public ushort TdlType
{
     get
{
          return _TdlType;
}
     set
{
          _TdlType = value;
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
public void setDataLength(ushort pDataLength)
{ _dataLength = pDataLength;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getdataLength method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(ushort), ElementName="dataLength")]
public ushort DataLength
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
   ///samples
   ///</summary>
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

   ///<summary>
   ///data bytes
   ///</summary>
public void setData(List<OneByteChunk> pData)
{ _data = pData;
}

   ///<summary>
   ///data bytes
   ///</summary>
public List<OneByteChunk> getData()
{ return _data; }

   ///<summary>
   ///data bytes
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
       _entityID.marshal(dos);
       dos.writeUshort( (ushort)_communicationsDeviceID);
       dos.writeUshort( (ushort)_encodingScheme);
       dos.writeUshort( (ushort)_TdlType);
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

new public void unmarshal(DataInputStream dis)
{
    base.unmarshal(dis);

    try 
    {
       _entityID.unmarshal(dis);
       _communicationsDeviceID = dis.readUshort();
       _encodingScheme = dis.readUshort();
       _TdlType = dis.readUshort();
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
new public void reflection(StringBuilder sb)
{
    sb.Append("<IntercomSignalPdu>"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
    sb.Append("<entityID>"  + System.Environment.NewLine);
       _entityID.reflection(sb);
    sb.Append("</entityID>"  + System.Environment.NewLine);
           sb.Append("<communicationsDeviceID type=\"ushort\">" + _communicationsDeviceID.ToString() + "</communicationsDeviceID> " + System.Environment.NewLine);
           sb.Append("<encodingScheme type=\"ushort\">" + _encodingScheme.ToString() + "</encodingScheme> " + System.Environment.NewLine);
           sb.Append("<TdlType type=\"ushort\">" + _TdlType.ToString() + "</TdlType> " + System.Environment.NewLine);
           sb.Append("<sampleRate type=\"uint\">" + _sampleRate.ToString() + "</sampleRate> " + System.Environment.NewLine);
           sb.Append("<data type=\"ushort\">" + _data.Count.ToString() + "</data> " + System.Environment.NewLine);
           sb.Append("<samples type=\"ushort\">" + _samples.ToString() + "</samples> " + System.Environment.NewLine);

       for(int idx = 0; idx < _data.Count; idx++)
       {
           sb.Append("<data"+ idx.ToString() + " type=\"OneByteChunk\">" + System.Environment.NewLine);
            OneByteChunk aOneByteChunk = (OneByteChunk)_data[idx];
            aOneByteChunk.reflection(sb);
           sb.Append("</data"+ idx.ToString() + ">" + System.Environment.NewLine);
       } // end of list marshalling

    sb.Append("</IntercomSignalPdu>"  + System.Environment.NewLine);
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
 public bool equals(IntercomSignalPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_entityID.Equals( rhs._entityID) )) ivarsEqual = false;
     if( ! (_communicationsDeviceID == rhs._communicationsDeviceID)) ivarsEqual = false;
     if( ! (_encodingScheme == rhs._encodingScheme)) ivarsEqual = false;
     if( ! (_TdlType == rhs._TdlType)) ivarsEqual = false;
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
