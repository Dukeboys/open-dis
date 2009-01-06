using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Used in UaPdu
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
public class AcousticBeamFundamentalParameter : Object
{
   /** parameter index */
   protected ushort  _activeEmissionParameterIndex;

   /** scan pattern */
   protected ushort  _scanPattern;

   /** beam center azimuth */
   protected float  _beamCenterAzimuth;

   /** azimuthal beamwidth */
   protected float  _azimuthalBeamwidth;

   /** beam center */
   protected float  _beamCenterDE;

   /** DE beamwidth (vertical beamwidth) */
   protected float  _deBeamwidth;


/** Constructor */
 public AcousticBeamFundamentalParameter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _activeEmissionParameterIndex
   marshalSize = marshalSize + 2;  // _scanPattern
   marshalSize = marshalSize + 4;  // _beamCenterAzimuth
   marshalSize = marshalSize + 4;  // _azimuthalBeamwidth
   marshalSize = marshalSize + 4;  // _beamCenterDE
   marshalSize = marshalSize + 4;  // _deBeamwidth

   return marshalSize;
}


public void setActiveEmissionParameterIndex(ushort pActiveEmissionParameterIndex)
{ _activeEmissionParameterIndex = pActiveEmissionParameterIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="activeEmissionParameterIndex")]
public ushort ActiveEmissionParameterIndex
{
     get
{
          return _activeEmissionParameterIndex;
}
     set
{
          _activeEmissionParameterIndex = value;
}
}

public void setScanPattern(ushort pScanPattern)
{ _scanPattern = pScanPattern;
}

[XmlElement(Type= typeof(ushort), ElementName="scanPattern")]
public ushort ScanPattern
{
     get
{
          return _scanPattern;
}
     set
{
          _scanPattern = value;
}
}

public void setBeamCenterAzimuth(float pBeamCenterAzimuth)
{ _beamCenterAzimuth = pBeamCenterAzimuth;
}

[XmlElement(Type= typeof(float), ElementName="beamCenterAzimuth")]
public float BeamCenterAzimuth
{
     get
{
          return _beamCenterAzimuth;
}
     set
{
          _beamCenterAzimuth = value;
}
}

public void setAzimuthalBeamwidth(float pAzimuthalBeamwidth)
{ _azimuthalBeamwidth = pAzimuthalBeamwidth;
}

[XmlElement(Type= typeof(float), ElementName="azimuthalBeamwidth")]
public float AzimuthalBeamwidth
{
     get
{
          return _azimuthalBeamwidth;
}
     set
{
          _azimuthalBeamwidth = value;
}
}

public void setBeamCenterDE(float pBeamCenterDE)
{ _beamCenterDE = pBeamCenterDE;
}

[XmlElement(Type= typeof(float), ElementName="beamCenterDE")]
public float BeamCenterDE
{
     get
{
          return _beamCenterDE;
}
     set
{
          _beamCenterDE = value;
}
}

public void setDeBeamwidth(float pDeBeamwidth)
{ _deBeamwidth = pDeBeamwidth;
}

[XmlElement(Type= typeof(float), ElementName="deBeamwidth")]
public float DeBeamwidth
{
     get
{
          return _deBeamwidth;
}
     set
{
          _deBeamwidth = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_activeEmissionParameterIndex);
       dos.writeUshort( (ushort)_scanPattern);
       dos.writeFloat( (float)_beamCenterAzimuth);
       dos.writeFloat( (float)_azimuthalBeamwidth);
       dos.writeFloat( (float)_beamCenterDE);
       dos.writeFloat( (float)_deBeamwidth);
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
       _activeEmissionParameterIndex = dis.readUshort();
       _scanPattern = dis.readUshort();
       _beamCenterAzimuth = dis.readFloat();
       _azimuthalBeamwidth = dis.readFloat();
       _beamCenterDE = dis.readFloat();
       _deBeamwidth = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- AcousticBeamFundamentalParameter-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _activeEmissionParameterIndex\t " + _activeEmissionParameterIndex.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _scanPattern\t " + _scanPattern.ToString() + System.Environment.NewLine);
           sb.Append("float\t _beamCenterAzimuth\t " + _beamCenterAzimuth.ToString() + System.Environment.NewLine);
           sb.Append("float\t _azimuthalBeamwidth\t " + _azimuthalBeamwidth.ToString() + System.Environment.NewLine);
           sb.Append("float\t _beamCenterDE\t " + _beamCenterDE.ToString() + System.Environment.NewLine);
           sb.Append("float\t _deBeamwidth\t " + _deBeamwidth.ToString() + System.Environment.NewLine);
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
 public bool equals(AcousticBeamFundamentalParameter rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_activeEmissionParameterIndex == rhs._activeEmissionParameterIndex)) ivarsEqual = false;
     if( ! (_scanPattern == rhs._scanPattern)) ivarsEqual = false;
     if( ! (_beamCenterAzimuth == rhs._beamCenterAzimuth)) ivarsEqual = false;
     if( ! (_azimuthalBeamwidth == rhs._azimuthalBeamwidth)) ivarsEqual = false;
     if( ! (_beamCenterDE == rhs._beamCenterDE)) ivarsEqual = false;
     if( ! (_deBeamwidth == rhs._deBeamwidth)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
