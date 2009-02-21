using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.39. Specification of the data necessary to  describe the scan volume of an emitter.
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
public class BeamData : Object
{
   /** Specifies the beam azimuth an elevation centers and corresponding half-angles     to describe the scan volume */
   protected float  _beamAzimuthCenter;

   /** Specifies the beam azimuth sweep to determine scan volume */
   protected float  _beamAzimuthSweep;

   /** Specifies the beam elevation center to determine scan volume */
   protected float  _beamElevationCenter;

   /** Specifies the beam elevation sweep to determine scan volume */
   protected float  _beamElevationSweep;

   /** allows receiver to synchronize its regenerated scan pattern to     that of the emmitter. Specifies the percentage of time a scan is through its pattern from its origion. */
   protected float  _beamSweepSync;


/** Constructor */
   ///<summary>
   ///Section 5.2.39. Specification of the data necessary to  describe the scan volume of an emitter.
   ///</summary>
 public BeamData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _beamAzimuthCenter
   marshalSize = marshalSize + 4;  // _beamAzimuthSweep
   marshalSize = marshalSize + 4;  // _beamElevationCenter
   marshalSize = marshalSize + 4;  // _beamElevationSweep
   marshalSize = marshalSize + 4;  // _beamSweepSync

   return marshalSize;
}


   ///<summary>
   ///Specifies the beam azimuth an elevation centers and corresponding half-angles     to describe the scan volume
   ///</summary>
public void setBeamAzimuthCenter(float pBeamAzimuthCenter)
{ _beamAzimuthCenter = pBeamAzimuthCenter;
}

[XmlElement(Type= typeof(float), ElementName="beamAzimuthCenter")]
public float BeamAzimuthCenter
{
     get
{
          return _beamAzimuthCenter;
}
     set
{
          _beamAzimuthCenter = value;
}
}

   ///<summary>
   ///Specifies the beam azimuth sweep to determine scan volume
   ///</summary>
public void setBeamAzimuthSweep(float pBeamAzimuthSweep)
{ _beamAzimuthSweep = pBeamAzimuthSweep;
}

[XmlElement(Type= typeof(float), ElementName="beamAzimuthSweep")]
public float BeamAzimuthSweep
{
     get
{
          return _beamAzimuthSweep;
}
     set
{
          _beamAzimuthSweep = value;
}
}

   ///<summary>
   ///Specifies the beam elevation center to determine scan volume
   ///</summary>
public void setBeamElevationCenter(float pBeamElevationCenter)
{ _beamElevationCenter = pBeamElevationCenter;
}

[XmlElement(Type= typeof(float), ElementName="beamElevationCenter")]
public float BeamElevationCenter
{
     get
{
          return _beamElevationCenter;
}
     set
{
          _beamElevationCenter = value;
}
}

   ///<summary>
   ///Specifies the beam elevation sweep to determine scan volume
   ///</summary>
public void setBeamElevationSweep(float pBeamElevationSweep)
{ _beamElevationSweep = pBeamElevationSweep;
}

[XmlElement(Type= typeof(float), ElementName="beamElevationSweep")]
public float BeamElevationSweep
{
     get
{
          return _beamElevationSweep;
}
     set
{
          _beamElevationSweep = value;
}
}

   ///<summary>
   ///allows receiver to synchronize its regenerated scan pattern to     that of the emmitter. Specifies the percentage of time a scan is through its pattern from its origion.
   ///</summary>
public void setBeamSweepSync(float pBeamSweepSync)
{ _beamSweepSync = pBeamSweepSync;
}

[XmlElement(Type= typeof(float), ElementName="beamSweepSync")]
public float BeamSweepSync
{
     get
{
          return _beamSweepSync;
}
     set
{
          _beamSweepSync = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)_beamAzimuthCenter);
       dos.writeFloat( (float)_beamAzimuthSweep);
       dos.writeFloat( (float)_beamElevationCenter);
       dos.writeFloat( (float)_beamElevationSweep);
       dos.writeFloat( (float)_beamSweepSync);
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
       _beamAzimuthCenter = dis.readFloat();
       _beamAzimuthSweep = dis.readFloat();
       _beamElevationCenter = dis.readFloat();
       _beamElevationSweep = dis.readFloat();
       _beamSweepSync = dis.readFloat();
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
    sb.Append("----- BeamData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("float\t _beamAzimuthCenter\t " + _beamAzimuthCenter.ToString() + System.Environment.NewLine);
           sb.Append("float\t _beamAzimuthSweep\t " + _beamAzimuthSweep.ToString() + System.Environment.NewLine);
           sb.Append("float\t _beamElevationCenter\t " + _beamElevationCenter.ToString() + System.Environment.NewLine);
           sb.Append("float\t _beamElevationSweep\t " + _beamElevationSweep.ToString() + System.Environment.NewLine);
           sb.Append("float\t _beamSweepSync\t " + _beamSweepSync.ToString() + System.Environment.NewLine);
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
 public bool equals(BeamData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_beamAzimuthCenter == rhs._beamAzimuthCenter)) ivarsEqual = false;
     if( ! (_beamAzimuthSweep == rhs._beamAzimuthSweep)) ivarsEqual = false;
     if( ! (_beamElevationCenter == rhs._beamElevationCenter)) ivarsEqual = false;
     if( ! (_beamElevationSweep == rhs._beamElevationSweep)) ivarsEqual = false;
     if( ! (_beamSweepSync == rhs._beamSweepSync)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
