using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * One track/jam target
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
public class TrackJamTarget : Object
{
   /** track/jam target */
   protected EntityID  _trackJam = new EntityID(); 

   /** Emitter ID */
   protected byte  _emitterID;

   /** beam ID */
   protected byte  _beamID;


/** Constructor */
 public TrackJamTarget()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + _trackJam.getMarshalledSize();  // _trackJam
   marshalSize = marshalSize + 1;  // _emitterID
   marshalSize = marshalSize + 1;  // _beamID

   return marshalSize;
}


public void setTrackJam(EntityID pTrackJam)
{ _trackJam = pTrackJam;
}

public EntityID getTrackJam()
{ return _trackJam; 
}

[XmlElement(Type= typeof(EntityID), ElementName="trackJam")]
public EntityID TrackJam
{
     get
{
          return _trackJam;
}
     set
{
          _trackJam = value;
}
}

public void setEmitterID(byte pEmitterID)
{ _emitterID = pEmitterID;
}

[XmlElement(Type= typeof(byte), ElementName="emitterID")]
public byte EmitterID
{
     get
{
          return _emitterID;
}
     set
{
          _emitterID = value;
}
}

public void setBeamID(byte pBeamID)
{ _beamID = pBeamID;
}

[XmlElement(Type= typeof(byte), ElementName="beamID")]
public byte BeamID
{
     get
{
          return _beamID;
}
     set
{
          _beamID = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       _trackJam.marshal(dos);
       dos.writeByte( (byte)_emitterID);
       dos.writeByte( (byte)_beamID);
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
       _trackJam.unmarshal(dis);
       _emitterID = dis.readByte();
       _beamID = dis.readByte();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- TrackJamTarget-----"  + System.Environment.NewLine);
    try 
    {
       sb.Append("=====_trackJam=====" + System.Environment.NewLine);
       _trackJam.reflection(sb);
           sb.Append("byte\t _emitterID\t " + _emitterID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _beamID\t " + _beamID.ToString() + System.Environment.NewLine);
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
 public bool equals(TrackJamTarget rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_trackJam.Equals( rhs._trackJam) )) ivarsEqual = false;
     if( ! (_emitterID == rhs._emitterID)) ivarsEqual = false;
     if( ! (_beamID == rhs._beamID)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
