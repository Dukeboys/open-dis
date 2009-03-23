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
   protected List<Pdu> _pdus = new List<Pdu>(); 

/** Constructor */
   ///<summary>
   ///Used for XML compatability. A container that holds PDUs
   ///</summary>
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


/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfPdus method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
public void setNumberOfPdus(uint pNumberOfPdus)
{ _numberOfPdus = pNumberOfPdus;
}

/// <summary>
/// Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
/// The getnumberOfPdus method will also be based on the actual list length rather than this value. 
/// The method is simply here for completeness and should not be used for any computations.
/// </summary>
[XmlElement(Type= typeof(uint), ElementName="numberOfPdus")]
public uint NumberOfPdus
{
     get
     {
          return _numberOfPdus;
     }
     set
     {
          _numberOfPdus = value;
     }
}

   ///<summary>
   ///record sets
   ///</summary>
public void setPdus(List<Pdu> pPdus)
{ _pdus = pPdus;
}

   ///<summary>
   ///record sets
   ///</summary>
public List<Pdu> getPdus()
{ return _pdus; }

   ///<summary>
   ///record sets
   ///</summary>
[XmlElement(ElementName = "pdusList",Type = typeof(List<Pdu>))]
public List<Pdu> Pdus
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


///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
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


   ///<summary>
   ///This allows for a quick display of PDU data.  The current format is unacceptable and only used for debugging.
   ///This will be modified in the future to provide a better display.  Usage: 
   ///pdu.GetType().InvokeMember("reflection", System.Reflection.BindingFlags.InvokeMethod, null, pdu, new object[] { sb });
   ///where pdu is an object representing a single pdu and sb is a StringBuilder.
   ///Note: The supplied Utilities folder contains a method called 'DecodePDU' in the PDUProcessor Class that provides this functionality
   ///</summary>
public void reflection(StringBuilder sb)
{
    sb.Append("<PduContainer>"  + System.Environment.NewLine);
    try 
    {
           sb.Append("<pdus type=\"uint\">" + _pdus.Count.ToString() + "</pdus> " + System.Environment.NewLine);

       for(int idx = 0; idx < _pdus.Count; idx++)
       {
           sb.Append("<pdus"+ idx.ToString() + " type=\"Pdu\">" + System.Environment.NewLine);
            Pdu aPdu = (Pdu)_pdus[idx];
            aPdu.reflection(sb);
           sb.Append("</pdus"+ idx.ToString() + ">" + System.Environment.NewLine);
       } // end of list marshalling

    sb.Append("</PduContainer>"  + System.Environment.NewLine);
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
