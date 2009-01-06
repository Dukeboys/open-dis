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
public class ApaData : Object
{
   /** Index of APA parameter */
   protected ushort  _parameterIndex;

   /** Index of APA parameter */
   protected short  _parameterValue;


/** Constructor */
 public ApaData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _parameterIndex
   marshalSize = marshalSize + 2;  // _parameterValue

   return marshalSize;
}


public void setParameterIndex(ushort pParameterIndex)
{ _parameterIndex = pParameterIndex;
}

[XmlElement(Type= typeof(ushort), ElementName="parameterIndex")]
public ushort ParameterIndex
{
     get
{
          return _parameterIndex;
}
     set
{
          _parameterIndex = value;
}
}

public void setParameterValue(short pParameterValue)
{ _parameterValue = pParameterValue;
}

[XmlElement(Type= typeof(short), ElementName="parameterValue")]
public short ParameterValue
{
     get
{
          return _parameterValue;
}
     set
{
          _parameterValue = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_parameterIndex);
       dos.writeShort( (short)_parameterValue);
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
       _parameterIndex = dis.readUshort();
       _parameterValue = dis.readShort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- ApaData-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _parameterIndex\t " + _parameterIndex.ToString() + System.Environment.NewLine);
           sb.Append("short\t _parameterValue\t " + _parameterValue.ToString() + System.Environment.NewLine);
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
 public bool equals(ApaData rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_parameterIndex == rhs._parameterIndex)) ivarsEqual = false;
     if( ! (_parameterValue == rhs._parameterValue)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
