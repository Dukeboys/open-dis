using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.12.12: Arbitrary messages. Only reliable this time. Neds manual intervention     to fix padding in variable datums. UNFINISHED
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
public class CommentReliablePdu : SimulationManagementWithReliabilityFamilyPdu
{
   /** Fixed datum record count */
   protected uint  _numberOfFixedDatumRecords;

   /** variable datum record count */
   protected uint  _numberOfVariableDatumRecords;

   /** Fixed datum records */
   protected List<object> _fixedDatumRecords = new List<object>(); 
   /** Variable datum records */
   protected List<object> _variableDatumRecords = new List<object>(); 

/** Constructor */
 public CommentReliablePdu()
 {
    PduType = (byte)62;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
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
    sb.Append("----- CommentReliablePdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
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
 public bool equals(CommentReliablePdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

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
