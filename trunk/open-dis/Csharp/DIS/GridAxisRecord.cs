using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.44: Grid data record, a common abstract superclass for several subtypes 
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
public class GridAxisRecord : Object
{
   /** type of environmental sample */
   protected ushort  _sampleType;

   /** value that describes data representation */
   protected ushort  _dataRepresentation;


/** Constructor */
 public GridAxisRecord()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _sampleType
   marshalSize = marshalSize + 2;  // _dataRepresentation

   return marshalSize;
}


public void setSampleType(ushort pSampleType)
{ _sampleType = pSampleType;
}

[XmlElement(Type= typeof(ushort), ElementName="sampleType")]
public ushort SampleType
{
     get
{
          return _sampleType;
}
     set
{
          _sampleType = value;
}
}

public void setDataRepresentation(ushort pDataRepresentation)
{ _dataRepresentation = pDataRepresentation;
}

[XmlElement(Type= typeof(ushort), ElementName="dataRepresentation")]
public ushort DataRepresentation
{
     get
{
          return _dataRepresentation;
}
     set
{
          _dataRepresentation = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_sampleType);
       dos.writeUshort( (ushort)_dataRepresentation);
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
       _sampleType = dis.readUshort();
       _dataRepresentation = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- GridAxisRecord-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _sampleType\t " + _sampleType.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _dataRepresentation\t " + _dataRepresentation.ToString() + System.Environment.NewLine);
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
 public bool equals(GridAxisRecord rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_sampleType == rhs._sampleType)) ivarsEqual = false;
     if( ! (_dataRepresentation == rhs._dataRepresentation)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
