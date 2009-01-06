using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.35. information about a specific UA emmtter
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
public class AcousticEmitter : Object
{
   /** the system for a particular UA emitter, and an enumeration */
   protected ushort  _acousticName;

   /** The function of the acoustic system */
   protected byte  _function;

   /** The UA emitter identification number relative to a specific system */
   protected byte  _acousticIdNumber;


/** Constructor */
 public AcousticEmitter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _acousticName
   marshalSize = marshalSize + 1;  // _function
   marshalSize = marshalSize + 1;  // _acousticIdNumber

   return marshalSize;
}


public void setAcousticName(ushort pAcousticName)
{ _acousticName = pAcousticName;
}

[XmlElement(Type= typeof(ushort), ElementName="acousticName")]
public ushort AcousticName
{
     get
{
          return _acousticName;
}
     set
{
          _acousticName = value;
}
}

public void setFunction(byte pFunction)
{ _function = pFunction;
}

[XmlElement(Type= typeof(byte), ElementName="function")]
public byte Function
{
     get
{
          return _function;
}
     set
{
          _function = value;
}
}

public void setAcousticIdNumber(byte pAcousticIdNumber)
{ _acousticIdNumber = pAcousticIdNumber;
}

[XmlElement(Type= typeof(byte), ElementName="acousticIdNumber")]
public byte AcousticIdNumber
{
     get
{
          return _acousticIdNumber;
}
     set
{
          _acousticIdNumber = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_acousticName);
       dos.writeByte( (byte)_function);
       dos.writeByte( (byte)_acousticIdNumber);
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
       _acousticName = dis.readUshort();
       _function = dis.readByte();
       _acousticIdNumber = dis.readByte();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- AcousticEmitter-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _acousticName\t " + _acousticName.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _function\t " + _function.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _acousticIdNumber\t " + _acousticIdNumber.ToString() + System.Environment.NewLine);
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
 public bool equals(AcousticEmitter rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_acousticName == rhs._acousticName)) ivarsEqual = false;
     if( ! (_function == rhs._function)) ivarsEqual = false;
     if( ! (_acousticIdNumber == rhs._acousticIdNumber)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
