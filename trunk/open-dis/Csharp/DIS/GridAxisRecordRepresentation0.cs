using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.44: Grid data record, representation 0
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
[XmlInclude(typeof(OneByteChunk))]
public class GridAxisRecordRepresentation0 : GridAxisRecord
{
   /** number of bytes of environmental state data */
   protected ushort  _numberOfBytes;

   /** variable length list of data parameters @@@this is wrong--need padding as well */
   protected List<OneByteChunk> _dataValues = new List<OneByteChunk>(); 

/** Constructor */
   ///<summary>
   ///5.2.44: Grid data record, representation 0
   ///</summary>
 public GridAxisRecordRepresentation0()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 2;  // _numberOfBytes
   for(int idx=0; idx < _dataValues.Count; idx++)
   {
        OneByteChunk listElement = (OneByteChunk)_dataValues[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfBytes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfBytes(ushort pNumberOfBytes)
{ _numberOfBytes = pNumberOfBytes;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfBytes method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(ushort), ElementName="numberOfBytes")]
public ushort NumberOfBytes
{
     get
     {
          return _numberOfBytes;
     }
     set
     {
          _numberOfBytes = value;
     }
}

   ///<summary>
   ///variable length list of data parameters @@@this is wrong--need padding as well
   ///</summary>
public void setDataValues(List<OneByteChunk> pDataValues)
{ _dataValues = pDataValues;
}

   ///<summary>
   ///variable length list of data parameters @@@this is wrong--need padding as well
   ///</summary>
public List<OneByteChunk> getDataValues()
{ return _dataValues; }

   ///<summary>
   ///variable length list of data parameters @@@this is wrong--need padding as well
   ///</summary>
[XmlElement(ElementName = "dataValuesList",Type = typeof(List<OneByteChunk>))]
public List<OneByteChunk> DataValues
{
     get
{
          return _dataValues;
}
     set
{
          _dataValues = value;
}
}


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       dos.writeUshort( (ushort)_dataValues.Count);

       for(int idx = 0; idx < _dataValues.Count; idx++)
       {
            OneByteChunk aOneByteChunk = (OneByteChunk)_dataValues[idx];
            aOneByteChunk.marshal(dos);
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
    base.unmarshal(dis);

    try 
    {
       _numberOfBytes = dis.readUshort();
        for(int idx = 0; idx < _numberOfBytes; idx++)
        {
           OneByteChunk anX = new OneByteChunk();
            anX.unmarshal(dis);
            _dataValues.Add(anX);
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
    sb.Append("----- GridAxisRecordRepresentation0-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("ushort\t _dataValues\t " + _dataValues.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _dataValues.Count; idx++)
       {
           sb.Append("OneByteChunk\t " + _dataValues[idx] + System.Environment.NewLine);
            OneByteChunk aOneByteChunk = (OneByteChunk)_dataValues[idx];
            aOneByteChunk.reflection(sb);
       } // end of list marshalling

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
 public bool equals(GridAxisRecordRepresentation0 rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_numberOfBytes == rhs._numberOfBytes)) ivarsEqual = false;

     for(int idx = 0; idx < _dataValues.Count; idx++)
     {
        OneByteChunk x = (OneByteChunk)_dataValues[idx];
        if( ! ( _dataValues[idx].Equals(rhs._dataValues[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
