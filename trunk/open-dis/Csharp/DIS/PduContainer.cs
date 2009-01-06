using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Used for XML compatability. A container that holds PDUs
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
[XmlInclude(typeof(Pdu))]
public class PduContainer : Object
{
   /** Number of PDUs in the container list */
   protected uint  _numberOfPdus;

   /** record sets */
   protected List<object> _pdus = new List<object>(); 

/** Constructor */
 public PduContainer()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // _numberOfPdus
   for(int idx=0; idx < _pdus.Count; idx++)
   {
        Pdu listElement = (Pdu)_pdus[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setPdus(List<object> pPdus)
{ _pdus = pPdus;
}

public List<object> getPdus()
{ return _pdus; }

[XmlElement(ElementName = "pdusList",Type = typeof(List<object>))]
public List<object> Pdus
{
     get
{
          return _pdus;
}
     set
{
          _pdus = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeUint( (uint)_pdus.Count);

       for(int idx = 0; idx < _pdus.Count; idx++)
       {
            Pdu aPdu = (Pdu)_pdus[idx];
            aPdu.marshal(dos);
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
       _numberOfPdus = dis.readUint();
        for(int idx = 0; idx < _numberOfPdus; idx++)
        {
           Pdu anX = new Pdu();
            anX.unmarshal(dis);
            _pdus.Add(anX);
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
    sb.Append("----- PduContainer-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("uint\t _pdus\t " + _pdus.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _pdus.Count; idx++)
       {
           sb.Append("Pdu\t " + _pdus[idx] + System.Environment.NewLine);
            Pdu aPdu = (Pdu)_pdus[idx];
            aPdu.reflection(sb);
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
 public bool equals(PduContainer rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_numberOfPdus == rhs._numberOfPdus)) ivarsEqual = false;

     for(int idx = 0; idx < _pdus.Count; idx++)
     {
        Pdu x = (Pdu)_pdus[idx];
        if( ! ( _pdus[idx].Equals(rhs._pdus[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
