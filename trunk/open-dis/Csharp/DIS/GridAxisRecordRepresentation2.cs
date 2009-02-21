using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.44: Grid data record, representation 1
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
[XmlInclude(typeof(FourByteChunk))]
public class GridAxisRecordRepresentation2 : GridAxisRecord
{
   /** number of values */
   protected ushort  _numberOfValues;

   /** variable length list of data parameters @@@this is wrong--need padding as well */
   protected List<FourByteChunk> _dataValues = new List<FourByteChunk>(); 

/** Constructor */
   ///<summary>
   ///5.2.44: Grid data record, representation 1
   ///</summary>
 public GridAxisRecordRepresentation2()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 2;  // _numberOfValues
   for(int idx=0; idx < _dataValues.Count; idx++)
   {
        FourByteChunk listElement = (FourByteChunk)_dataValues[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfValues method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfValues(ushort pNumberOfValues)
{ _numberOfValues = pNumberOfValues;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfValues method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(ushort), ElementName="numberOfValues")]
public ushort NumberOfValues
{
     get
     {
          return _numberOfValues;
     }
     set
     {
          _numberOfValues = value;
     }
}

   ///<summary>
   ///variable length list of data parameters @@@this is wrong--need padding as well
   ///</summary>
public void setDataValues(List<FourByteChunk> pDataValues)
{ _dataValues = pDataValues;
}

   ///<summary>
   ///variable length list of data parameters @@@this is wrong--need padding as well
   ///</summary>
public List<FourByteChunk> getDataValues()
{ return _dataValues; }

   ///<summary>
   ///variable length list of data parameters @@@this is wrong--need padding as well
   ///</summary>
[XmlElement(ElementName = "dataValuesList",Type = typeof(List<FourByteChunk>))]
public List<FourByteChunk> DataValues
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
            FourByteChunk aFourByteChunk = (FourByteChunk)_dataValues[idx];
            aFourByteChunk.marshal(dos);
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
       _numberOfValues = dis.readUshort();
        for(int idx = 0; idx < _numberOfValues; idx++)
        {
           FourByteChunk anX = new FourByteChunk();
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
    sb.Append("----- GridAxisRecordRepresentation2-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("ushort\t _dataValues\t " + _dataValues.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _dataValues.Count; idx++)
       {
           sb.Append("FourByteChunk\t " + _dataValues[idx] + System.Environment.NewLine);
            FourByteChunk aFourByteChunk = (FourByteChunk)_dataValues[idx];
            aFourByteChunk.reflection(sb);
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
 public bool equals(GridAxisRecordRepresentation2 rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_numberOfValues == rhs._numberOfValues)) ivarsEqual = false;

     for(int idx = 0; idx < _dataValues.Count; idx++)
     {
        FourByteChunk x = (FourByteChunk)_dataValues[idx];
        if( ! ( _dataValues[idx].Equals(rhs._dataValues[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
