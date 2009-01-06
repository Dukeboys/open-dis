using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.8.1. Detailed information about a radio transmitter. This PDU requires manually         written code to complete, since the modulation parameters are of variable length. UNFINISHED
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
[XmlInclude(typeof(RadioEntityType))]
[XmlInclude(typeof(Vector3Double))]
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(ModulationType))]
[XmlInclude(typeof(Vector3Float))]
[XmlInclude(typeof(Vector3Float))]
public class TransmitterPdu : RadioCommunicationsFamilyPdu
{
   /** linear accelleration of entity */
   protected RadioEntityType  _radioEntityType = new RadioEntityType(); 

   /** transmit state */
   protected byte  _transmitState;

   /** input source */
   protected byte  _inputSource;

   /** padding */
   protected ushort  _padding1;

   /** Location of antenna */
   protected Vector3Double  _antennaLocation = new Vector3Double(); 

   /** relative location of antenna */
   protected Vector3Float  _relativeAntennaLocation = new Vector3Float(); 

   /** antenna pattern type */
   protected ushort  _antennaPatternType;

   /** atenna pattern length */
   protected ushort  _antennaPatternCount;

   /** frequency */
   protected double  _frequency;

   /** transmit frequency Bandwidth */
   protected float  _transmitFrequencyBandwidth;

   /** transmission power */
   protected float  _power;

   /** modulation */
   protected ModulationType  _modulationType = new ModulationType(); 

   /** crypto system enumeration */
   protected ushort  _cryptoSystem;

   /** crypto system key identifer */
   protected ushort  _cryptoKeyId;

   /** how many modulation parameters we have */
   protected byte  _modulationParameterCount;

   /** padding2 */
   protected ushort  _padding2 = 0;

   /** padding3 */
   protected byte  _padding3 = 0;

   /** variable length list of modulation parameters */
   protected List<object> _modulationParametersList = new List<object>(); 
   /** variable length list of antenna pattern records */
   protected List<object> _antennaPatternList = new List<object>(); 

/** Constructor */
 public TransmitterPdu()
 {
    PduType = (byte)25;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _radioEntityType.getMarshalledSize();  // _radioEntityType
   marshalSize = marshalSize + 1;  // _transmitState
   marshalSize = marshalSize + 1;  // _inputSource
   marshalSize = marshalSize + 2;  // _padding1
   marshalSize = marshalSize + _antennaLocation.getMarshalledSize();  // _antennaLocation
   marshalSize = marshalSize + _relativeAntennaLocation.getMarshalledSize();  // _relativeAntennaLocation
   marshalSize = marshalSize + 2;  // _antennaPatternType
   marshalSize = marshalSize + 2;  // _antennaPatternCount
   marshalSize = marshalSize + 8;  // _frequency
   marshalSize = marshalSize + 4;  // _transmitFrequencyBandwidth
   marshalSize = marshalSize + 4;  // _power
   marshalSize = marshalSize + _modulationType.getMarshalledSize();  // _modulationType
   marshalSize = marshalSize + 2;  // _cryptoSystem
   marshalSize = marshalSize + 2;  // _cryptoKeyId
   marshalSize = marshalSize + 1;  // _modulationParameterCount
   marshalSize = marshalSize + 2;  // _padding2
   marshalSize = marshalSize + 1;  // _padding3
   for(int idx=0; idx < _modulationParametersList.Count; idx++)
   {
        Vector3Float listElement = (Vector3Float)_modulationParametersList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _antennaPatternList.Count; idx++)
   {
        Vector3Float listElement = (Vector3Float)_antennaPatternList[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setRadioEntityType(RadioEntityType pRadioEntityType)
{ _radioEntityType = pRadioEntityType;
}

public RadioEntityType getRadioEntityType()
{ return _radioEntityType; 
}

[XmlElement(Type= typeof(RadioEntityType), ElementName="radioEntityType")]
public RadioEntityType RadioEntityType
{
     get
{
          return _radioEntityType;
}
     set
{
          _radioEntityType = value;
}
}

public void setTransmitState(byte pTransmitState)
{ _transmitState = pTransmitState;
}

[XmlElement(Type= typeof(byte), ElementName="transmitState")]
public byte TransmitState
{
     get
{
          return _transmitState;
}
     set
{
          _transmitState = value;
}
}

public void setInputSource(byte pInputSource)
{ _inputSource = pInputSource;
}

[XmlElement(Type= typeof(byte), ElementName="inputSource")]
public byte InputSource
{
     get
{
          return _inputSource;
}
     set
{
          _inputSource = value;
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

public void setAntennaLocation(Vector3Double pAntennaLocation)
{ _antennaLocation = pAntennaLocation;
}

public Vector3Double getAntennaLocation()
{ return _antennaLocation; 
}

[XmlElement(Type= typeof(Vector3Double), ElementName="antennaLocation")]
public Vector3Double AntennaLocation
{
     get
{
          return _antennaLocation;
}
     set
{
          _antennaLocation = value;
}
}

public void setRelativeAntennaLocation(Vector3Float pRelativeAntennaLocation)
{ _relativeAntennaLocation = pRelativeAntennaLocation;
}

public Vector3Float getRelativeAntennaLocation()
{ return _relativeAntennaLocation; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="relativeAntennaLocation")]
public Vector3Float RelativeAntennaLocation
{
     get
{
          return _relativeAntennaLocation;
}
     set
{
          _relativeAntennaLocation = value;
}
}

public void setAntennaPatternType(ushort pAntennaPatternType)
{ _antennaPatternType = pAntennaPatternType;
}

[XmlElement(Type= typeof(ushort), ElementName="antennaPatternType")]
public ushort AntennaPatternType
{
     get
{
          return _antennaPatternType;
}
     set
{
          _antennaPatternType = value;
}
}

public void setFrequency(double pFrequency)
{ _frequency = pFrequency;
}

[XmlElement(Type= typeof(double), ElementName="frequency")]
public double Frequency
{
     get
{
          return _frequency;
}
     set
{
          _frequency = value;
}
}

public void setTransmitFrequencyBandwidth(float pTransmitFrequencyBandwidth)
{ _transmitFrequencyBandwidth = pTransmitFrequencyBandwidth;
}

[XmlElement(Type= typeof(float), ElementName="transmitFrequencyBandwidth")]
public float TransmitFrequencyBandwidth
{
     get
{
          return _transmitFrequencyBandwidth;
}
     set
{
          _transmitFrequencyBandwidth = value;
}
}

public void setPower(float pPower)
{ _power = pPower;
}

[XmlElement(Type= typeof(float), ElementName="power")]
public float Power
{
     get
{
          return _power;
}
     set
{
          _power = value;
}
}

public void setModulationType(ModulationType pModulationType)
{ _modulationType = pModulationType;
}

public ModulationType getModulationType()
{ return _modulationType; 
}

[XmlElement(Type= typeof(ModulationType), ElementName="modulationType")]
public ModulationType ModulationType
{
     get
{
          return _modulationType;
}
     set
{
          _modulationType = value;
}
}

public void setCryptoSystem(ushort pCryptoSystem)
{ _cryptoSystem = pCryptoSystem;
}

[XmlElement(Type= typeof(ushort), ElementName="cryptoSystem")]
public ushort CryptoSystem
{
     get
{
          return _cryptoSystem;
}
     set
{
          _cryptoSystem = value;
}
}

public void setCryptoKeyId(ushort pCryptoKeyId)
{ _cryptoKeyId = pCryptoKeyId;
}

[XmlElement(Type= typeof(ushort), ElementName="cryptoKeyId")]
public ushort CryptoKeyId
{
     get
{
          return _cryptoKeyId;
}
     set
{
          _cryptoKeyId = value;
}
}

public void setPadding2(ushort pPadding2)
{ _padding2 = pPadding2;
}

[XmlElement(Type= typeof(ushort), ElementName="padding2")]
public ushort Padding2
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

public void setPadding3(byte pPadding3)
{ _padding3 = pPadding3;
}

[XmlElement(Type= typeof(byte), ElementName="padding3")]
public byte Padding3
{
     get
{
          return _padding3;
}
     set
{
          _padding3 = value;
}
}

public void setModulationParametersList(List<object> pModulationParametersList)
{ _modulationParametersList = pModulationParametersList;
}

public List<object> getModulationParametersList()
{ return _modulationParametersList; }

[XmlElement(ElementName = "modulationParametersListList",Type = typeof(List<object>))]
public List<object> ModulationParametersList
{
     get
{
          return _modulationParametersList;
}
     set
{
          _modulationParametersList = value;
}
}

public void setAntennaPatternList(List<object> pAntennaPatternList)
{ _antennaPatternList = pAntennaPatternList;
}

public List<object> getAntennaPatternList()
{ return _antennaPatternList; }

[XmlElement(ElementName = "antennaPatternListList",Type = typeof(List<object>))]
public List<object> AntennaPatternList
{
     get
{
          return _antennaPatternList;
}
     set
{
          _antennaPatternList = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _radioEntityType.marshal(dos);
       dos.writeByte( (byte)_transmitState);
       dos.writeByte( (byte)_inputSource);
       dos.writeUshort( (ushort)_padding1);
       _antennaLocation.marshal(dos);
       _relativeAntennaLocation.marshal(dos);
       dos.writeUshort( (ushort)_antennaPatternType);
       dos.writeUshort( (ushort)_antennaPatternList.Count);
       dos.writeDouble( (double)_frequency);
       dos.writeFloat( (float)_transmitFrequencyBandwidth);
       dos.writeFloat( (float)_power);
       _modulationType.marshal(dos);
       dos.writeUshort( (ushort)_cryptoSystem);
       dos.writeUshort( (ushort)_cryptoKeyId);
       dos.writeByte( (byte)_modulationParametersList.Count);
       dos.writeUshort( (ushort)_padding2);
       dos.writeByte( (byte)_padding3);

       for(int idx = 0; idx < _modulationParametersList.Count; idx++)
       {
            Vector3Float aVector3Float = (Vector3Float)_modulationParametersList[idx];
            aVector3Float.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _antennaPatternList.Count; idx++)
       {
            Vector3Float aVector3Float = (Vector3Float)_antennaPatternList[idx];
            aVector3Float.marshal(dos);
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
       _radioEntityType.unmarshal(dis);
       _transmitState = dis.readByte();
       _inputSource = dis.readByte();
       _padding1 = dis.readUshort();
       _antennaLocation.unmarshal(dis);
       _relativeAntennaLocation.unmarshal(dis);
       _antennaPatternType = dis.readUshort();
       _antennaPatternCount = dis.readUshort();
       _frequency = dis.readDouble();
       _transmitFrequencyBandwidth = dis.readFloat();
       _power = dis.readFloat();
       _modulationType.unmarshal(dis);
       _cryptoSystem = dis.readUshort();
       _cryptoKeyId = dis.readUshort();
       _modulationParameterCount = dis.readByte();
       _padding2 = dis.readUshort();
       _padding3 = dis.readByte();
        for(int idx = 0; idx < _modulationParameterCount; idx++)
        {
           Vector3Float anX = new Vector3Float();
            anX.unmarshal(dis);
            _modulationParametersList.Add(anX);
        };

        for(int idx = 0; idx < _antennaPatternCount; idx++)
        {
           Vector3Float anX = new Vector3Float();
            anX.unmarshal(dis);
            _antennaPatternList.Add(anX);
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
    sb.Append("----- TransmitterPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_radioEntityType=====" + System.Environment.NewLine);
       _radioEntityType.reflection(sb);
           sb.Append("byte\t _transmitState\t " + _transmitState.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _inputSource\t " + _inputSource.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
       sb.Append("=====_antennaLocation=====" + System.Environment.NewLine);
       _antennaLocation.reflection(sb);
       sb.Append("=====_relativeAntennaLocation=====" + System.Environment.NewLine);
       _relativeAntennaLocation.reflection(sb);
           sb.Append("ushort\t _antennaPatternType\t " + _antennaPatternType.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _antennaPatternList\t " + _antennaPatternList.Count.ToString() + System.Environment.NewLine);
           sb.Append("double\t _frequency\t " + _frequency.ToString() + System.Environment.NewLine);
           sb.Append("float\t _transmitFrequencyBandwidth\t " + _transmitFrequencyBandwidth.ToString() + System.Environment.NewLine);
           sb.Append("float\t _power\t " + _power.ToString() + System.Environment.NewLine);
       sb.Append("=====_modulationType=====" + System.Environment.NewLine);
       _modulationType.reflection(sb);
           sb.Append("ushort\t _cryptoSystem\t " + _cryptoSystem.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _cryptoKeyId\t " + _cryptoKeyId.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _modulationParametersList\t " + _modulationParametersList.Count.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _padding2\t " + _padding2.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _padding3\t " + _padding3.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _modulationParametersList.Count; idx++)
       {
           sb.Append("Vector3Float\t " + _modulationParametersList[idx] + System.Environment.NewLine);
            Vector3Float aVector3Float = (Vector3Float)_modulationParametersList[idx];
            aVector3Float.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _antennaPatternList.Count; idx++)
       {
           sb.Append("Vector3Float\t " + _antennaPatternList[idx] + System.Environment.NewLine);
            Vector3Float aVector3Float = (Vector3Float)_antennaPatternList[idx];
            aVector3Float.reflection(sb);
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
 public bool equals(TransmitterPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_radioEntityType.Equals( rhs._radioEntityType) )) ivarsEqual = false;
     if( ! (_transmitState == rhs._transmitState)) ivarsEqual = false;
     if( ! (_inputSource == rhs._inputSource)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_antennaLocation.Equals( rhs._antennaLocation) )) ivarsEqual = false;
     if( ! (_relativeAntennaLocation.Equals( rhs._relativeAntennaLocation) )) ivarsEqual = false;
     if( ! (_antennaPatternType == rhs._antennaPatternType)) ivarsEqual = false;
     if( ! (_antennaPatternCount == rhs._antennaPatternCount)) ivarsEqual = false;
     if( ! (_frequency == rhs._frequency)) ivarsEqual = false;
     if( ! (_transmitFrequencyBandwidth == rhs._transmitFrequencyBandwidth)) ivarsEqual = false;
     if( ! (_power == rhs._power)) ivarsEqual = false;
     if( ! (_modulationType.Equals( rhs._modulationType) )) ivarsEqual = false;
     if( ! (_cryptoSystem == rhs._cryptoSystem)) ivarsEqual = false;
     if( ! (_cryptoKeyId == rhs._cryptoKeyId)) ivarsEqual = false;
     if( ! (_modulationParameterCount == rhs._modulationParameterCount)) ivarsEqual = false;
     if( ! (_padding2 == rhs._padding2)) ivarsEqual = false;
     if( ! (_padding3 == rhs._padding3)) ivarsEqual = false;

     for(int idx = 0; idx < _modulationParametersList.Count; idx++)
     {
        Vector3Float x = (Vector3Float)_modulationParametersList[idx];
        if( ! ( _modulationParametersList[idx].Equals(rhs._modulationParametersList[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _antennaPatternList.Count; idx++)
     {
        Vector3Float x = (Vector3Float)_antennaPatternList[idx];
        if( ! ( _antennaPatternList[idx].Equals(rhs._antennaPatternList[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
