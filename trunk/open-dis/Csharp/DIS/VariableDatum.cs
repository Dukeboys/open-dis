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
   protected List<EightByteChunk> _variableDatums = new List<EightByteChunk>(); 

/** Constructor */
   ///<summary>
   ///Section 5.2.32. Variable Datum Record
   ///</summary>
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


   ///<summary>
   ///ID of the variable datum
   ///</summary>
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

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getvariableDatumLength method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setVariableDatumLength(uint pVariableDatumLength)
{ _variableDatumLength = pVariableDatumLength;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getvariableDatumLength method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(uint), ElementName="variableDatumLength")]
public uint VariableDatumLength
{
     get
     {
          return _variableDatumLength;
     }
     set
     {
          _variableDatumLength = value;
     }
}

   ///<summary>
   ///variable length list of 64-bit datums
   ///</summary>
public void setVariableDatums(List<EightByteChunk> pVariableDatums)
{ _variableDatums = pVariableDatums;
}

   ///<summary>
   ///variable length list of 64-bit datums
   ///</summary>
public List<EightByteChunk> getVariableDatums()
{ return _variableDatums; }

   ///<summary>
   ///variable length list of 64-bit datums
   ///</summary>
[XmlElement(ElementName = "variableDatumsList",Type = typeof(List<EightByteChunk>))]
public List<EightByteChunk> VariableDatums
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


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
public void reflection(StringBuilder sb)
{
    sb.Append("<VariableDatum>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<variableDatumID type=\"uint\">" + _variableDatumID.ToString() + "</variableDatumID> " + System.Environment.NewLine);
           sb.Append("<variableDatums type=\"uint\">" + _variableDatums.Count.ToString() + "</variableDatums> " + System.Environment.NewLine);

       for(int idx = 0; idx < _variableDatums.Count; idx++)
       {
           sb.Append("<variableDatums"+ idx.ToString() + " type=\"EightByteChunk\">" + System.Environment.NewLine);
            EightByteChunk aEightByteChunk = (EightByteChunk)_variableDatums[idx];
            aEightByteChunk.reflection(sb);
           sb.Append("</variableDatums"+ idx.ToString() + ">" + System.Environment.NewLine);
       } // end of list marshalling

    sb.Append("</VariableDatum>"  + System.Environment.NewLine);
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
