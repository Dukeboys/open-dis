using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 48 bit piece of data
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
public class SixByteChunk : Object
{
   /** six bytes of arbitrary data */
   protected byte[]  _otherParameters = new byte[6]; 


/** Constructor */
 public SixByteChunk()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 6 * 1;  // _otherParameters

   return marshalSize;
}


public void setOtherParameters(byte[] pOtherParameters)
{ _otherParameters = pOtherParameters;
}

public byte[] getOtherParameters()
{ return _otherParameters; }

[XmlArray(ElementName="otherParameters")]
public byte[] OtherParameters
{
     get
{
          return _otherParameters;
}
     set
{
          _otherParameters = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {

       for(int idx = 0; idx < _otherParameters.Length; idx++)
       {
           dos.writeByte(_otherParameters[idx]);
       } // end of array marshaling

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
       for(int idx = 0; idx < _otherParameters.Length; idx++)
       {
                _otherParameters[idx] = dis.readByte();
       } // end of array unmarshaling
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- SixByteChunk-----"  + System.Environment.NewLine);
    try 
    {

       for(int idx = 0; idx < _otherParameters.Length; idx++)
       {
           sb.Append("byte\t " + _otherParameters[idx] + System.Environment.NewLine);
       } // end of array reflection

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
 public bool equals(SixByteChunk rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;


     for(int idx = 0; idx < 6; idx++)
     {
          if(!(_otherParameters[idx] == rhs._otherParameters[idx])) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
