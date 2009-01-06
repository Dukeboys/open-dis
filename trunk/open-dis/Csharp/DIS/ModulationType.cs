using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Radio modulation
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
public class ModulationType : Object
{
   /** spread spectrum, 16 bit boolean array */
   protected ushort  _spreadSpectrum;

   /** major */
   protected ushort  _major;

   /** detail */
   protected ushort  _detail;

   /** system */
   protected ushort  _system;


/** Constructor */
 public ModulationType()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _spreadSpectrum
   marshalSize = marshalSize + 2;  // _major
   marshalSize = marshalSize + 2;  // _detail
   marshalSize = marshalSize + 2;  // _system

   return marshalSize;
}


public void setSpreadSpectrum(ushort pSpreadSpectrum)
{ _spreadSpectrum = pSpreadSpectrum;
}

[XmlElement(Type= typeof(ushort), ElementName="spreadSpectrum")]
public ushort SpreadSpectrum
{
     get
{
          return _spreadSpectrum;
}
     set
{
          _spreadSpectrum = value;
}
}

public void setMajor(ushort pMajor)
{ _major = pMajor;
}

[XmlElement(Type= typeof(ushort), ElementName="major")]
public ushort Major
{
     get
{
          return _major;
}
     set
{
          _major = value;
}
}

public void setDetail(ushort pDetail)
{ _detail = pDetail;
}

[XmlElement(Type= typeof(ushort), ElementName="detail")]
public ushort Detail
{
     get
{
          return _detail;
}
     set
{
          _detail = value;
}
}

public void setSystem(ushort pSystem)
{ _system = pSystem;
}

[XmlElement(Type= typeof(ushort), ElementName="system")]
public ushort System_
{
     get
{
          return _system;
}
     set
{
          _system = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_spreadSpectrum);
       dos.writeUshort( (ushort)_major);
       dos.writeUshort( (ushort)_detail);
       dos.writeUshort( (ushort)_system);
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
       _spreadSpectrum = dis.readUshort();
       _major = dis.readUshort();
       _detail = dis.readUshort();
       _system = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- ModulationType-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _spreadSpectrum\t " + _spreadSpectrum.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _major\t " + _major.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _detail\t " + _detail.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _system\t " + _system.ToString() + System.Environment.NewLine);
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
 public bool equals(ModulationType rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_spreadSpectrum == rhs._spreadSpectrum)) ivarsEqual = false;
     if( ! (_major == rhs._major)) ivarsEqual = false;
     if( ! (_detail == rhs._detail)) ivarsEqual = false;
     if( ! (_system == rhs._system)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
