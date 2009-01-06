using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.32. Variable Datum Record
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
[XmlInclude(typeof(EightByteChunk))]
public class VariableDatum : Object
{
   /** ID of the variable datum */
   protected uint  _variableDatumID;

   /** length of the variable datums */
   protected uint  _variableDatumLength;

   /** variable length list of 64-bit datums */
   protected List<object> _variableDatums = new List<object>(); 

/** Constructor */
 public VariableDatum()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _variableDatumID
   marshalSize = marshalSize + 4;  // _variableDatumLength
   for(int idx=0; idx < _variableDatums.Count; idx++)
   {
        EightByteChunk listElement = (EightByteChunk)_variableDatums[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setVariableDatumID(uint pVariableDatumID)
{ _variableDatumID = pVariableDatumID;
}

[XmlElement(Type= typeof(uint), ElementName="variableDatumID")]
public uint VariableDatumID
{
     get
{
          return _variableDatumID;
}
     set
{
          _variableDatumID = value;
}
}

public void setVariableDatums(List<object> pVariableDatums)
{ _variableDatums = pVariableDatums;
}

public List<object> getVariableDatums()
{ return _variableDatums; }

[XmlElement(ElementName = "variableDatumsList",Type = typeof(List<object>))]
public List<object> VariableDatums
{
     get
{
          return _variableDatums;
}
     set
{
          _variableDatums = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUint( (uint)_variableDatumID);
       dos.writeUint( (uint)_variableDatums.Count);

       for(int idx = 0; idx < _variableDatums.Count; idx++)
       {
            EightByteChunk aEightByteChunk = (EightByteChunk)_variableDatums[idx];
            aEightByteChunk.marshal(dos);
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
       _variableDatumID = dis.readUint();
       _variableDatumLength = dis.readUint();
        for(int idx = 0; idx < _variableDatumLength; idx++)
        {
           EightByteChunk anX = new EightByteChunk();
            anX.unmarshal(dis);
            _variableDatums.Add(anX);
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
    sb.Append("----- VariableDatum-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("uint\t _variableDatumID\t " + _variableDatumID.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _variableDatums\t " + _variableDatums.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _variableDatums.Count; idx++)
       {
           sb.Append("EightByteChunk\t " + _variableDatums[idx] + System.Environment.NewLine);
            EightByteChunk aEightByteChunk = (EightByteChunk)_variableDatums[idx];
            aEightByteChunk.reflection(sb);
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
 public bool equals(VariableDatum rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_variableDatumID == rhs._variableDatumID)) ivarsEqual = false;
     if( ! (_variableDatumLength == rhs._variableDatumLength)) ivarsEqual = false;

     for(int idx = 0; idx < _variableDatums.Count; idx++)
     {
        EightByteChunk x = (EightByteChunk)_variableDatums[idx];
        if( ! ( _variableDatums[idx].Equals(rhs._variableDatums[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
