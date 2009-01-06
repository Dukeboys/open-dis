using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.4.2. Used when the antenna pattern type field has a value of 1. Specifies           the direction, patter, and polarization of radiation from an antenna.
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
[XmlInclude(typeof(Orientation))]
public class BeamAntennaPattern : Object
{
   /** The rotation that transformst he reference coordinate sytem     into the beam coordinate system. Either world coordinates or entity coordinates may be used as the     reference coordinate system, as specified by teh reference system field of the antenna pattern record. */
   protected Orientation  _beamDirection = new Orientation(); 

   protected float  _azimuthBeamwidth = 0;

   protected float  _referenceSystem = 0;

   protected short  _padding1 = 0;

   protected byte  _padding2 = 0;

   /** Magnigute of the z-component in beam coordinates at some arbitrary      single point in the mainbeam      and in the far field of the antenna. */
   protected float  _ez;

   /** Magnigute of the x-component in beam coordinates at some arbitrary      single point in the mainbeam      and in the far field of the antenna. */
   protected float  _ex;

   /** THe phase angle between Ez and Ex in radians. */
   protected float  _phase;


/** Constructor */
 public BeamAntennaPattern()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + _beamDirection.getMarshalledSize();  // _beamDirection
   marshalSize = marshalSize + 4;  // _azimuthBeamwidth
   marshalSize = marshalSize + 4;  // _referenceSystem
   marshalSize = marshalSize + 2;  // _padding1
   marshalSize = marshalSize + 1;  // _padding2
   marshalSize = marshalSize + 4;  // _ez
   marshalSize = marshalSize + 4;  // _ex
   marshalSize = marshalSize + 4;  // _phase

   return marshalSize;
}


public void setBeamDirection(Orientation pBeamDirection)
{ _beamDirection = pBeamDirection;
}

public Orientation getBeamDirection()
{ return _beamDirection; 
}

[XmlElement(Type= typeof(Orientation), ElementName="beamDirection")]
public Orientation BeamDirection
{
     get
{
          return _beamDirection;
}
     set
{
          _beamDirection = value;
}
}

public void setAzimuthBeamwidth(float pAzimuthBeamwidth)
{ _azimuthBeamwidth = pAzimuthBeamwidth;
}

[XmlElement(Type= typeof(float), ElementName="azimuthBeamwidth")]
public float AzimuthBeamwidth
{
     get
{
          return _azimuthBeamwidth;
}
     set
{
          _azimuthBeamwidth = value;
}
}

public void setReferenceSystem(float pReferenceSystem)
{ _referenceSystem = pReferenceSystem;
}

[XmlElement(Type= typeof(float), ElementName="referenceSystem")]
public float ReferenceSystem
{
     get
{
          return _referenceSystem;
}
     set
{
          _referenceSystem = value;
}
}

public void setPadding1(short pPadding1)
{ _padding1 = pPadding1;
}

[XmlElement(Type= typeof(short), ElementName="padding1")]
public short Padding1
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

public void setPadding2(byte pPadding2)
{ _padding2 = pPadding2;
}

[XmlElement(Type= typeof(byte), ElementName="padding2")]
public byte Padding2
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

public void setEz(float pEz)
{ _ez = pEz;
}

[XmlElement(Type= typeof(float), ElementName="ez")]
public float Ez
{
     get
{
          return _ez;
}
     set
{
          _ez = value;
}
}

public void setEx(float pEx)
{ _ex = pEx;
}

[XmlElement(Type= typeof(float), ElementName="ex")]
public float Ex
{
     get
{
          return _ex;
}
     set
{
          _ex = value;
}
}

public void setPhase(float pPhase)
{ _phase = pPhase;
}

[XmlElement(Type= typeof(float), ElementName="phase")]
public float Phase
{
     get
{
          return _phase;
}
     set
{
          _phase = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       _beamDirection.marshal(dos);
       dos.writeFloat( (float)_azimuthBeamwidth);
       dos.writeFloat( (float)_referenceSystem);
       dos.writeShort( (short)_padding1);
       dos.writeByte( (byte)_padding2);
       dos.writeFloat( (float)_ez);
       dos.writeFloat( (float)_ex);
       dos.writeFloat( (float)_phase);
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
       _beamDirection.unmarshal(dis);
       _azimuthBeamwidth = dis.readFloat();
       _referenceSystem = dis.readFloat();
       _padding1 = dis.readShort();
       _padding2 = dis.readByte();
       _ez = dis.readFloat();
       _ex = dis.readFloat();
       _phase = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- BeamAntennaPattern-----"  + System.Environment.NewLine);
    try 
    {
       sb.Append("=====_beamDirection=====" + System.Environment.NewLine);
       _beamDirection.reflection(sb);
           sb.Append("float\t _azimuthBeamwidth\t " + _azimuthBeamwidth.ToString() + System.Environment.NewLine);
           sb.Append("float\t _referenceSystem\t " + _referenceSystem.ToString() + System.Environment.NewLine);
           sb.Append("short\t _padding1\t " + _padding1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _padding2\t " + _padding2.ToString() + System.Environment.NewLine);
           sb.Append("float\t _ez\t " + _ez.ToString() + System.Environment.NewLine);
           sb.Append("float\t _ex\t " + _ex.ToString() + System.Environment.NewLine);
           sb.Append("float\t _phase\t " + _phase.ToString() + System.Environment.NewLine);
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
 public bool equals(BeamAntennaPattern rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_beamDirection.Equals( rhs._beamDirection) )) ivarsEqual = false;
     if( ! (_azimuthBeamwidth == rhs._azimuthBeamwidth)) ivarsEqual = false;
     if( ! (_referenceSystem == rhs._referenceSystem)) ivarsEqual = false;
     if( ! (_padding1 == rhs._padding1)) ivarsEqual = false;
     if( ! (_padding2 == rhs._padding2)) ivarsEqual = false;
     if( ! (_ez == rhs._ez)) ivarsEqual = false;
     if( ! (_ex == rhs._ex)) ivarsEqual = false;
     if( ! (_phase == rhs._phase)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
