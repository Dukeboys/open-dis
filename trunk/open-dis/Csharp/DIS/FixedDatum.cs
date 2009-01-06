using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.18. Fixed Datum Record
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
public class FixedDatum : Object
{
   /** ID of the fixed datum */
   protected uint  _fixedDatumID;

   /** Value for the fixed datum */
   protected uint  _fixedDatumValue;


/** Constructor */
 public FixedDatum()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _fixedDatumID
   marshalSize = marshalSize + 4;  // _fixedDatumValue

   return marshalSize;
}


public void setFixedDatumID(uint pFixedDatumID)
{ _fixedDatumID = pFixedDatumID;
}

[XmlElement(Type= typeof(uint), ElementName="fixedDatumID")]
public uint FixedDatumID
{
     get
{
          return _fixedDatumID;
}
     set
{
          _fixedDatumID = value;
}
}

public void setFixedDatumValue(uint pFixedDatumValue)
{ _fixedDatumValue = pFixedDatumValue;
}

[XmlElement(Type= typeof(uint), ElementName="fixedDatumValue")]
public uint FixedDatumValue
{
     get
{
          return _fixedDatumValue;
}
     set
{
          _fixedDatumValue = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUint( (uint)_fixedDatumID);
       dos.writeUint( (uint)_fixedDatumValue);
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
       _fixedDatumID = dis.readUint();
       _fixedDatumValue = dis.readUint();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- FixedDatum-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("uint\t _fixedDatumID\t " + _fixedDatumID.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _fixedDatumValue\t " + _fixedDatumValue.ToString() + System.Environment.NewLine);
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
 public bool equals(FixedDatum rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_fixedDatumID == rhs._fixedDatumID)) ivarsEqual = false;
     if( ! (_fixedDatumValue == rhs._fixedDatumValue)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
