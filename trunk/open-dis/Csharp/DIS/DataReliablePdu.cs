using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.12.10: issued in response to a data query R or set dataR pdu. Needs manual intervention      to fix padding on variable datums. UNFINSIHED
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
[XmlInclude(typeof(FixedDatum))]
[XmlInclude(typeof(VariableDatum))]
public class DataReliablePdu : SimulationManagementWithReliabilityFamilyPdu
{
   /** Request ID */
   protected uint  _requestID;

   /** level of reliability service used for this transaction */
   protected byte  _requiredReliabilityService;

   /** padding */
   protected ushort  _pad1;

   /** padding */
   protected byte  _pad2;

   /** Fixed datum record count */
   protected uint  _numberOfFixedDatumRecords;

   /** variable datum record count */
   protected uint  _numberOfVariableDatumRecords;

   /** Fixed datum records */
   protected List<object> _fixedDatumRecords = new List<object>(); 
   /** Variable datum records */
   protected List<object> _variableDatumRecords = new List<object>(); 

/** Constructor */
 public DataReliablePdu()
 {
    PduType = (byte)60;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 4;  // _requestID
   marshalSize = marshalSize + 1;  // _requiredReliabilityService
   marshalSize = marshalSize + 2;  // _pad1
   marshalSize = marshalSize + 1;  // _pad2
   marshalSize = marshalSize + 4;  // _numberOfFixedDatumRecords
   marshalSize = marshalSize + 4;  // _numberOfVariableDatumRecords
   for(int idx=0; idx < _fixedDatumRecords.Count; idx++)
   {
        FixedDatum listElement = (FixedDatum)_fixedDatumRecords[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _variableDatumRecords.Count; idx++)
   {
        VariableDatum listElement = (VariableDatum)_variableDatumRecords[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setRequestID(uint pRequestID)
{ _requestID = pRequestID;
}

[XmlElement(Type= typeof(uint), ElementName="requestID")]
public uint RequestID
{
     get
{
          return _requestID;
}
     set
{
          _requestID = value;
}
}

public void setRequiredReliabilityService(byte pRequiredReliabilityService)
{ _requiredReliabilityService = pRequiredReliabilityService;
}

[XmlElement(Type= typeof(byte), ElementName="requiredReliabilityService")]
public byte RequiredReliabilityService
{
     get
{
          return _requiredReliabilityService;
}
     set
{
          _requiredReliabilityService = value;
}
}

public void setPad1(ushort pPad1)
{ _pad1 = pPad1;
}

[XmlElement(Type= typeof(ushort), ElementName="pad1")]
public ushort Pad1
{
     get
{
          return _pad1;
}
     set
{
          _pad1 = value;
}
}

public void setPad2(byte pPad2)
{ _pad2 = pPad2;
}

[XmlElement(Type= typeof(byte), ElementName="pad2")]
public byte Pad2
{
     get
{
          return _pad2;
}
     set
{
          _pad2 = value;
}
}

public void setFixedDatumRecords(List<object> pFixedDatumRecords)
{ _fixedDatumRecords = pFixedDatumRecords;
}

public List<object> getFixedDatumRecords()
{ return _fixedDatumRecords; }

[XmlElement(ElementName = "fixedDatumRecordsList",Type = typeof(List<object>))]
public List<object> FixedDatumRecords
{
     get
{
          return _fixedDatumRecords;
}
     set
{
          _fixedDatumRecords = value;
}
}

public void setVariableDatumRecords(List<object> pVariableDatumRecords)
{ _variableDatumRecords = pVariableDatumRecords;
}

public List<object> getVariableDatumRecords()
{ return _variableDatumRecords; }

[XmlElement(ElementName = "variableDatumRecordsList",Type = typeof(List<object>))]
public List<object> VariableDatumRecords
{
     get
{
          return _variableDatumRecords;
}
     set
{
          _variableDatumRecords = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       dos.writeUint( (uint)_requestID);
       dos.writeByte( (byte)_requiredReliabilityService);
       dos.writeUshort( (ushort)_pad1);
       dos.writeByte( (byte)_pad2);
       dos.writeUint( (uint)_fixedDatumRecords.Count);
       dos.writeUint( (uint)_variableDatumRecords.Count);

       for(int idx = 0; idx < _fixedDatumRecords.Count; idx++)
       {
            FixedDatum aFixedDatum = (FixedDatum)_fixedDatumRecords[idx];
            aFixedDatum.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _variableDatumRecords.Count; idx++)
       {
            VariableDatum aVariableDatum = (VariableDatum)_variableDatumRecords[idx];
            aVariableDatum.marshal(dos);
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
       _requestID = dis.readUint();
       _requiredReliabilityService = dis.readByte();
       _pad1 = dis.readUshort();
       _pad2 = dis.readByte();
       _numberOfFixedDatumRecords = dis.readUint();
       _numberOfVariableDatumRecords = dis.readUint();
        for(int idx = 0; idx < _numberOfFixedDatumRecords; idx++)
        {
           FixedDatum anX = new FixedDatum();
            anX.unmarshal(dis);
            _fixedDatumRecords.Add(anX);
        };

        for(int idx = 0; idx < _numberOfVariableDatumRecords; idx++)
        {
           VariableDatum anX = new VariableDatum();
            anX.unmarshal(dis);
            _variableDatumRecords.Add(anX);
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
    sb.Append("----- DataReliablePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("uint\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _requiredReliabilityService\t " + _requiredReliabilityService.ToString() + System.Environment.NewLine);
           sb.Append("ushort\t _pad1\t " + _pad1.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _pad2\t " + _pad2.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _fixedDatumRecords\t " + _fixedDatumRecords.Count.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _variableDatumRecords\t " + _variableDatumRecords.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _fixedDatumRecords.Count; idx++)
       {
           sb.Append("FixedDatum\t " + _fixedDatumRecords[idx] + System.Environment.NewLine);
            FixedDatum aFixedDatum = (FixedDatum)_fixedDatumRecords[idx];
            aFixedDatum.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _variableDatumRecords.Count; idx++)
       {
           sb.Append("VariableDatum\t " + _variableDatumRecords[idx] + System.Environment.NewLine);
            VariableDatum aVariableDatum = (VariableDatum)_variableDatumRecords[idx];
            aVariableDatum.reflection(sb);
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
 public bool equals(DataReliablePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;
     if( ! (_requiredReliabilityService == rhs._requiredReliabilityService)) ivarsEqual = false;
     if( ! (_pad1 == rhs._pad1)) ivarsEqual = false;
     if( ! (_pad2 == rhs._pad2)) ivarsEqual = false;
     if( ! (_numberOfFixedDatumRecords == rhs._numberOfFixedDatumRecords)) ivarsEqual = false;
     if( ! (_numberOfVariableDatumRecords == rhs._numberOfVariableDatumRecords)) ivarsEqual = false;

     for(int idx = 0; idx < _fixedDatumRecords.Count; idx++)
     {
        FixedDatum x = (FixedDatum)_fixedDatumRecords[idx];
        if( ! ( _fixedDatumRecords[idx].Equals(rhs._fixedDatumRecords[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _variableDatumRecords.Count; idx++)
     {
        VariableDatum x = (VariableDatum)_variableDatumRecords[idx];
        if( ! ( _variableDatumRecords[idx].Equals(rhs._variableDatumRecords[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
