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
   protected List<object> _dataValues = new List<object>(); 

/** Constructor */
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


public void setDataValues(List<object> pDataValues)
{ _dataValues = pDataValues;
}

public List<object> getDataValues()
{ return _dataValues; }

[XmlElement(ElementName = "dataValuesList",Type = typeof(List<object>))]
public List<object> DataValues
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
  * The equals method doesn't always work--mostly it works only on on classes that consist only of primitives. Be careful.
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
