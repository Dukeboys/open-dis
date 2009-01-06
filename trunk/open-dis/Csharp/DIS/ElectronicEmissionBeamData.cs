using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Description of one electronic emission beam
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
[XmlInclude(typeof(FundamentalParameterData))]
[XmlInclude(typeof(TrackJamTarget))]
public class ElectronicEmissionBeamData : Object
{
   /** This field shall specify the length of this beams data in 32 bit words */
   protected byte  _beamDataLength;

   /** This field shall specify a unique emitter database number assigned to differentiate between otherwise similar or identical emitter beams within an emitter system. */
   protected byte  _beamIDNumber;

   /** This field shall specify a Beam Parameter Index number that shall be used by receiving entities in conjunction with the Emitter Name field to provide a pointer to the stored database parameters required to regenerate the beam.  */
   protected ushort  _beamParameterIndex;

   /** Fundamental parameter data such as frequency range, beam sweep, etc. */
   protected FundamentalParameterData  _fundamentalParameterData = new FundamentalParameterData(); 

   /** beam function of a particular beam */
   protected byte  _beamFunction;

   /** Number of track/jam targets */
   protected byte  _numberOfTrackJamTargets;

   /** wheher or not the receiving simulation apps can assume all the targets in the scan pattern are being tracked/jammed */
   protected byte  _highDensityTrackJam;

   /** padding */
   protected byte  _pad4 = 0;

   /** identify jamming techniques used */
   protected uint  _jammingModeSequence;

   /** variable length list of track/jam targets */
   protected List<object> _trackJamTargets = new List<object>(); 

/** Constructor */
 public ElectronicEmissionBeamData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _beamDataLength
   marshalSize = marshalSize + 1;  // _beamIDNumber
   marshalSize = marshalSize + 2;  // _beamParameterIndex
   marshalSize = marshalSize + _fundamentalParameterData.getMarshalledSize();  // _fundamentalParameterData
   marshalSize = marshalSize + 1;  // _beamFunction
   marshalSize = marshalSize + 1;  // _numberOfTrackJamTargets
   marshalSize = marshalSize + 1;  // _highDensityTrackJam
   marshalSize = marshalSize + 1;  // _pad4
   marshalSize = marshalSize + 4;  // _jammingModeSequence
   for(int idx=0; idx < _trackJamTargets.Count; idx++)
   {
        TrackJamTarget listElement = (TrackJamTarget)_trackJamTargets[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setBeamDataLength(byte pBeamDataLength)
{ _beamDataLength = pBeamDataLength;
}

[XmlElement(Type= typeof(byte), ElementName="beamDataLength")]
public byte BeamDataLength
{
     get
{
          return _beamDataLength;
}
     set
{
          _beamDataLength = value;
}
}

public void setBeamIDNumber(byte pBeamIDNumber)
{ _beamIDNumber = pBeamIDNumber;
}

[XmlElement(Type= typeof(byte), ElementName="beamIDNumber")]
public byte BeamIDNumber
{
     get
{
          return _beamIDNumber;
}
     set
{
          _beamIDNumber = value;
}
}

public void setBeamParameterIndex(ushort pBeamParameterIndex)
{ _beamParameterIndex = pBeamParameterIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="beamParameterIndex")]
public ushort BeamParameterIndex
{
     get
{
          return _beamParameterIndex;
}
     set
{
          _beamParameterIndex = value;
}
}

public void setFundamentalParameterData(FundamentalParameterData pFundamentalParameterData)
{ _fundamentalParameterData = pFundamentalParameterData;
}

public FundamentalParameterData getFundamentalParameterData()
{ return _fundamentalParameterData; 
}

[XmlElement(Type= typeof(FundamentalParameterData), ElementName="fundamentalParameterData")]
public FundamentalParameterData FundamentalParameterData
{
     get
{
          return _fundamentalParameterData;
}
     set
{
          _fundamentalParameterData = value;
}
}

public void setBeamFunction(byte pBeamFunction)
{ _beamFunction = pBeamFunction;
}

[XmlElement(Type= typeof(byte), ElementName="beamFunction")]
public byte BeamFunction
{
     get
{
          return _beamFunction;
}
     set
{
          _beamFunction = value;
}
}

public void setHighDensityTrackJam(byte pHighDensityTrackJam)
{ _highDensityTrackJam = pHighDensityTrackJam;
}

[XmlElement(Type= typeof(byte), ElementName="highDensityTrackJam")]
public byte HighDensityTrackJam
{
     get
{
          return _highDensityTrackJam;
}
     set
{
          _highDensityTrackJam = value;
}
}

public void setPad4(byte pPad4)
{ _pad4 = pPad4;
}

[XmlElement(Type= typeof(byte), ElementName="pad4")]
public byte Pad4
{
     get
{
          return _pad4;
}
     set
{
          _pad4 = value;
}
}

public void setJammingModeSequence(uint pJammingModeSequence)
{ _jammingModeSequence = pJammingModeSequence;
}

[XmlElement(Type= typeof(uint), ElementName="jammingModeSequence")]
public uint JammingModeSequence
{
     get
{
          return _jammingModeSequence;
}
     set
{
          _jammingModeSequence = value;
}
}

public void setTrackJamTargets(List<object> pTrackJamTargets)
{ _trackJamTargets = pTrackJamTargets;
}

public List<object> getTrackJamTargets()
{ return _trackJamTargets; }

[XmlElement(ElementName = "trackJamTargetsList",Type = typeof(List<object>))]
public List<object> TrackJamTargets
{
     get
{
          return _trackJamTargets;
}
     set
{
          _trackJamTargets = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_beamDataLength);
       dos.writeByte( (byte)_beamIDNumber);
       dos.writeUshort( (ushort)_beamParameterIndex);
       _fundamentalParameterData.marshal(dos);
       dos.writeByte( (byte)_beamFunction);
       dos.writeByte( (byte)_trackJamTargets.Count);
       dos.writeByte( (byte)_highDensityTrackJam);
       dos.writeByte( (byte)_pad4);
       dos.writeUint( (uint)_jammingModeSequence);

       for(int idx = 0; idx < _trackJamTargets.Count; idx++)
       {
            TrackJamTarget aTrackJamTarget = (TrackJamTarget)_trackJamTargets[idx];
            aTrackJamTarget.marshal(dos);
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
       _beamDataLength = dis.readByte();
       _beamIDNumber = dis.readByte();
       _beamParameterIndex = dis.readUshort();
       _fundamentalParameterData.unmarshal(dis);
       _beamFunction = dis.readByte();
       _numberOfTrackJamTargets = dis.readByte();
       _highDensityTrackJam = dis.readByte();
       _pad4 = dis.readByte();
       _jammingModeSequence = dis.readUint();
        for(int idx = 0; idx < _numberOfTrackJamTargets; idx++)
        {
           TrackJamTarget anX = new TrackJamTarget();
            anX.unmarshal(dis);
            _trackJamTargets.Add(anX);
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
    sb.Append("----- ElectronicEmissionBeamData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _beamDataLength\t " + _beamDataLength.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _beamIDNumber\t " + _beamIDNumber.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _beamParameterIndex\t " + _beamParameterIndex.ToString() + System.Environment.NewLine);
       sb.Append("=====_fundamentalParameterData=====" + System.Environment.NewLine);
       _fundamentalParameterData.reflection(sb);
           sb.Append("byte\t _beamFunction\t " + _beamFunction.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _trackJamTargets\t " + _trackJamTargets.Count.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _highDensityTrackJam\t " + _highDensityTrackJam.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad4\t " + _pad4.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _jammingModeSequence\t " + _jammingModeSequence.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _trackJamTargets.Count; idx++)
       {
           sb.Append("TrackJamTarget\t " + _trackJamTargets[idx] + System.Environment.NewLine);
            TrackJamTarget aTrackJamTarget = (TrackJamTarget)_trackJamTargets[idx];
            aTrackJamTarget.reflection(sb);
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
 public bool equals(ElectronicEmissionBeamData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_beamDataLength == rhs._beamDataLength)) ivarsEqual = false;
     if( ! (_beamIDNumber == rhs._beamIDNumber)) ivarsEqual = false;
     if( ! (_beamParameterIndex == rhs._beamParameterIndex)) ivarsEqual = false;
     if( ! (_fundamentalParameterData.Equals( rhs._fundamentalParameterData) )) ivarsEqual = false;
     if( ! (_beamFunction == rhs._beamFunction)) ivarsEqual = false;
     if( ! (_numberOfTrackJamTargets == rhs._numberOfTrackJamTargets)) ivarsEqual = false;
     if( ! (_highDensityTrackJam == rhs._highDensityTrackJam)) ivarsEqual = false;
     if( ! (_pad4 == rhs._pad4)) ivarsEqual = false;
     if( ! (_jammingModeSequence == rhs._jammingModeSequence)) ivarsEqual = false;

     for(int idx = 0; idx < _trackJamTargets.Count; idx++)
     {
        TrackJamTarget x = (TrackJamTarget)_trackJamTargets[idx];
        if( ! ( _trackJamTargets[idx].Equals(rhs._trackJamTargets[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
