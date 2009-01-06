using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.10.4 proivde the means to request a retransmit of a minefield data pdu. COMPLETE
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
[XmlInclude(typeof(EntityID))]
[XmlInclude(typeof(EightByteChunk))]
public class MinefieldResponseNackPdu : MinefieldFamilyPdu
{
   /** Minefield ID */
   protected EntityID  _minefieldID = new EntityID(); 

   /** entity ID making the request */
   protected EntityID  _requestingEntityID = new EntityID(); 

   /** request ID */
   protected byte  _requestID;

   /** how many pdus were missing */
   protected byte  _numberOfMissingPdus;

   /** PDU sequence numbers that were missing */
   protected List<object> _missingPduSequenceNumbers = new List<object>(); 

/** Constructor */
 public MinefieldResponseNackPdu()
 {
    PduType = (byte)40;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _minefieldID.getMarshalledSize();  // _minefieldID
   marshalSize = marshalSize + _requestingEntityID.getMarshalledSize();  // _requestingEntityID
   marshalSize = marshalSize + 1;  // _requestID
   marshalSize = marshalSize + 1;  // _numberOfMissingPdus
   for(int idx=0; idx < _missingPduSequenceNumbers.Count; idx++)
   {
        EightByteChunk listElement = (EightByteChunk)_missingPduSequenceNumbers[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setMinefieldID(EntityID pMinefieldID)
{ _minefieldID = pMinefieldID;
}

public EntityID getMinefieldID()
{ return _minefieldID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="minefieldID")]
public EntityID MinefieldID
{
     get
{
          return _minefieldID;
}
     set
{
          _minefieldID = value;
}
}

public void setRequestingEntityID(EntityID pRequestingEntityID)
{ _requestingEntityID = pRequestingEntityID;
}

public EntityID getRequestingEntityID()
{ return _requestingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="requestingEntityID")]
public EntityID RequestingEntityID
{
     get
{
          return _requestingEntityID;
}
     set
{
          _requestingEntityID = value;
}
}

public void setRequestID(byte pRequestID)
{ _requestID = pRequestID;
}

[XmlElement(Type= typeof(byte), ElementName="requestID")]
public byte RequestID
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

public void setMissingPduSequenceNumbers(List<object> pMissingPduSequenceNumbers)
{ _missingPduSequenceNumbers = pMissingPduSequenceNumbers;
}

public List<object> getMissingPduSequenceNumbers()
{ return _missingPduSequenceNumbers; }

[XmlElement(ElementName = "missingPduSequenceNumbersList",Type = typeof(List<object>))]
public List<object> MissingPduSequenceNumbers
{
     get
{
          return _missingPduSequenceNumbers;
}
     set
{
          _missingPduSequenceNumbers = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _minefieldID.marshal(dos);
       _requestingEntityID.marshal(dos);
       dos.writeByte( (byte)_requestID);
       dos.writeByte( (byte)_missingPduSequenceNumbers.Count);

       for(int idx = 0; idx < _missingPduSequenceNumbers.Count; idx++)
       {
            EightByteChunk aEightByteChunk = (EightByteChunk)_missingPduSequenceNumbers[idx];
            aEightByteChunk.marshal(dos);
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
       _minefieldID.unmarshal(dis);
       _requestingEntityID.unmarshal(dis);
       _requestID = dis.readByte();
       _numberOfMissingPdus = dis.readByte();
        for(int idx = 0; idx < _numberOfMissingPdus; idx++)
        {
           EightByteChunk anX = new EightByteChunk();
            anX.unmarshal(dis);
            _missingPduSequenceNumbers.Add(anX);
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
    sb.Append("----- MinefieldResponseNackPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_minefieldID=====" + System.Environment.NewLine);
       _minefieldID.reflection(sb);
       sb.Append("=====_requestingEntityID=====" + System.Environment.NewLine);
       _requestingEntityID.reflection(sb);
           sb.Append("byte\t _requestID\t " + _requestID.ToString() + System.Environment.NewLine);
           sb.Append("byte\t _missingPduSequenceNumbers\t " + _missingPduSequenceNumbers.Count.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _missingPduSequenceNumbers.Count; idx++)
       {
           sb.Append("EightByteChunk\t " + _missingPduSequenceNumbers[idx] + System.Environment.NewLine);
            EightByteChunk aEightByteChunk = (EightByteChunk)_missingPduSequenceNumbers[idx];
            aEightByteChunk.reflection(sb);
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
 public bool equals(MinefieldResponseNackPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_minefieldID.Equals( rhs._minefieldID) )) ivarsEqual = false;
     if( ! (_requestingEntityID.Equals( rhs._requestingEntityID) )) ivarsEqual = false;
     if( ! (_requestID == rhs._requestID)) ivarsEqual = false;
     if( ! (_numberOfMissingPdus == rhs._numberOfMissingPdus)) ivarsEqual = false;

     for(int idx = 0; idx < _missingPduSequenceNumbers.Count; idx++)
     {
        EightByteChunk x = (EightByteChunk)_missingPduSequenceNumbers[idx];
        if( ! ( _missingPduSequenceNumbers[idx].Equals(rhs._missingPduSequenceNumbers[idx]))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
} // end of namespace
