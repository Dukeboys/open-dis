using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Used in UA PDU
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
[XmlInclude(typeof(AcousticBeamFundamentalParameter))]
public class AcousticBeamData : Object
{
   /** beam data length */
   protected ushort  _beamDataLength;

   /** beamIDNumber */
   protected byte  _beamIDNumber;

   /** padding */
   protected ushort  _pad2;

   /** fundamental data parameters */
   protected AcousticBeamFundamentalParameter  _fundamentalDataParameters = new AcousticBeamFundamentalParameter(); 


/** Constructor */
 public AcousticBeamData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _beamDataLength
   marshalSize = marshalSize + 1;  // _beamIDNumber
   marshalSize = marshalSize + 2;  // _pad2
   marshalSize = marshalSize + _fundamentalDataParameters.getMarshalledSize();  // _fundamentalDataParameters

   return marshalSize;
}


public void setBeamDataLength(ushort pBeamDataLength)
{ _beamDataLength = pBeamDataLength;
}

[XmlElement(Type= typeof(ushort), ElementName="beamDataLength")]
public ushort BeamDataLength
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

public void setFundamentalDataParameters(AcousticBeamFundamentalParameter pFundamentalDataParameters)
{ _fundamentalDataParameters = pFundamentalDataParameters;
}

public AcousticBeamFundamentalParameter getFundamentalDataParameters()
{ return _fundamentalDataParameters; 
}

[XmlElement(Type= typeof(AcousticBeamFundamentalParameter), ElementName="fundamentalDataParameters")]
public AcousticBeamFundamentalParameter FundamentalDataParameters
{
     get
{
          return _fundamentalDataParameters;
}
     set
{
          _fundamentalDataParameters = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_beamDataLength);
       dos.writeByte( (byte)_beamIDNumber);
       dos.writeUshort( (ushort)_pad2);
       _fundamentalDataParameters.marshal(dos);
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
       _beamDataLength = dis.readUshort();
       _beamIDNumber = dis.readByte();
       _pad2 = dis.readUshort();
       _fundamentalDataParameters.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- AcousticBeamData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _beamDataLength\t " + _beamDataLength.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _beamIDNumber\t " + _beamIDNumber.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
       sb.Append("=====_fundamentalDataParameters=====" + System.Environment.NewLine);
       _fundamentalDataParameters.reflection(sb);
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
 public bool equals(AcousticBeamData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_beamDataLength == rhs._beamDataLength)) ivarsEqual = false;
     if( ! (_beamIDNumber == rhs._beamIDNumber)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_fundamentalDataParameters.Equals( rhs._fundamentalDataParameters) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
