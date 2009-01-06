using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.6.12. Arbitrary messages can be entered into the data stream via use of this PDU. COMPLETE
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
public class CommentPdu : SimulationManagementFamilyPdu
{
   /** Number of fixed datum records */
   protected uint  _numberOfFixedDatumRecords;

   /** Number of variable datum records */
   protected uint  _numberOfVariableDatumRecords;

   /** variable length list of fixed datums */
   protected List<object> _fixedDatums = new List<object>(); 
   /** variable length list of variable length datums */
   protected List<object> _variableDatums = new List<object>(); 

/** Constructor */
 public CommentPdu()
 {
    PduType = (byte)22;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + 4;  // _numberOfFixedDatumRecords
   marshalSize = marshalSize + 4;  // _numberOfVariableDatumRecords
   for(int idx=0; idx < _fixedDatums.Count; idx++)
   {
        FixedDatum listElement = (FixedDatum)_fixedDatums[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < _variableDatums.Count; idx++)
   {
        VariableDatum listElement = (VariableDatum)_variableDatums[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setFixedDatums(List<object> pFixedDatums)
{ _fixedDatums = pFixedDatums;
}

public List<object> getFixedDatums()
{ return _fixedDatums; }

[XmlElement(ElementName = "fixedDatumsList",Type = typeof(List<object>))]
public List<object> FixedDatums
{
     get
{
          return _fixedDatums;
}
     set
{
          _fixedDatums = value;
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
    base.marshal(dos);
    try 
    {
       dos.writeUint( (uint)_fixedDatums.Count);
       dos.writeUint( (uint)_variableDatums.Count);

       for(int idx = 0; idx < _fixedDatums.Count; idx++)
       {
            FixedDatum aFixedDatum = (FixedDatum)_fixedDatums[idx];
            aFixedDatum.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < _variableDatums.Count; idx++)
       {
            VariableDatum aVariableDatum = (VariableDatum)_variableDatums[idx];
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
            _fixedDatums.Add(anX);
        };

        for(int idx = 0; idx < _numberOfVariableDatumRecords; idx++)
        {
           VariableDatum anX = new VariableDatum();
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
    sb.Append("----- CommentPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
           sb.Append("uint\t _fixedDatums\t " + _fixedDatums.Count.ToString() + System.Environment.NewLine);
           sb.Append("uint\t _variableDatums\t " + _variableDatums.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _fixedDatums.Count; idx++)
       {
           sb.Append("FixedDatum\t " + _fixedDatums[idx] + System.Environment.NewLine);
            FixedDatum aFixedDatum = (FixedDatum)_fixedDatums[idx];
            aFixedDatum.reflection(sb);
       } // end of list marshalling


       for(int idx = 0; idx < _variableDatums.Count; idx++)
       {
           sb.Append("VariableDatum\t " + _variableDatums[idx] + System.Environment.NewLine);
            VariableDatum aVariableDatum = (VariableDatum)_variableDatums[idx];
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
 public bool equals(CommentPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_numberOfFixedDatumRecords == rhs._numberOfFixedDatumRecords)) ivarsEqual = false;
     if( ! (_numberOfVariableDatumRecords == rhs._numberOfVariableDatumRecords)) ivarsEqual = false;

     for(int idx = 0; idx < _fixedDatums.Count; idx++)
     {
        FixedDatum x = (FixedDatum)_fixedDatums[idx];
        if( ! ( _fixedDatums[idx].Equals(rhs._fixedDatums[idx]))) ivarsEqual = false;
     }


     for(int idx = 0; idx < _variableDatums.Count; idx++)
     {
        VariableDatum x = (VariableDatum)_variableDatums[idx];
        if( ! ( _variableDatums[idx].Equals(rhs._variableDatums[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
