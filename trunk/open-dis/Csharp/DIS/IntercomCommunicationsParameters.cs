using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * 5.2.46.  Intercom communcations parameters
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
public class IntercomCommunicationsParameters : Object
{
   /** Type of intercom parameters record */
   protected ushort  _recordType;

   /** length of record */
   protected ushort  _recordLength;

   /** Jerks. Looks like the committee is forcing a lookup of the record type parameter to find out how long the field is. This is a placeholder. */
   protected uint  _recordSpecificField;


/** Constructor */
 public IntercomCommunicationsParameters()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // _recordType
   marshalSize = marshalSize + 2;  // _recordLength
   marshalSize = marshalSize + 4;  // _recordSpecificField

   return marshalSize;
}


public void setRecordType(ushort pRecordType)
{ _recordType = pRecordType;
}

[XmlElement(Type= typeof(ushort), ElementName="recordType")]
public ushort RecordType
{
     get
{
          return _recordType;
}
     set
{
          _recordType = value;
}
}

public void setRecordLength(ushort pRecordLength)
{ _recordLength = pRecordLength;
}

[XmlElement(Type= typeof(ushort), ElementName="recordLength")]
public ushort RecordLength
{
     get
{
          return _recordLength;
}
     set
{
          _recordLength = value;
}
}

public void setRecordSpecificField(uint pRecordSpecificField)
{ _recordSpecificField = pRecordSpecificField;
}

[XmlElement(Type= typeof(uint), ElementName="recordSpecificField")]
public uint RecordSpecificField
{
     get
{
          return _recordSpecificField;
}
     set
{
          _recordSpecificField = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUshort( (ushort)_recordType);
       dos.writeUshort( (ushort)_recordLength);
       dos.writeUint( (uint)_recordSpecificField);
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
       _recordType = dis.readUshort();
       _recordLength = dis.readUshort();
       _recordSpecificField = dis.readUint();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- IntercomCommunicationsParameters-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("ushort\t _recordType\t " + _recordType.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _recordLength\t " + _recordLength.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _recordSpecificField\t " + _recordSpecificField.ToString() + System.Environment.NewLine);
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
 public bool equals(IntercomCommunicationsParameters rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_recordType == rhs._recordType)) ivarsEqual = false;
     if( ! (_recordLength == rhs._recordLength)) ivarsEqual = false;
     if( ! (_recordSpecificField == rhs._recordSpecificField)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
