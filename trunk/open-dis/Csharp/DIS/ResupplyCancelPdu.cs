using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.2.5.4. Cancel of resupply by either the receiving or supplying entity. COMPLETE
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
public class ResupplyCancelPdu : LogisticsFamilyPdu
{
   /** Entity that is receiving service */
   protected EntityID  _receivingEntityID = new EntityID(); 

   /** Entity that is supplying */
   protected EntityID  _supplyingEntityID = new EntityID(); 


/** Constructor */
 public ResupplyCancelPdu()
 {
    PduType = (byte)8;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _receivingEntityID.getMarshalledSize();  // _receivingEntityID
   marshalSize = marshalSize + _supplyingEntityID.getMarshalledSize();  // _supplyingEntityID

   return marshalSize;
}


public void setReceivingEntityID(EntityID pReceivingEntityID)
{ _receivingEntityID = pReceivingEntityID;
}

public EntityID getReceivingEntityID()
{ return _receivingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="receivingEntityID")]
public EntityID ReceivingEntityID
{
     get
{
          return _receivingEntityID;
}
     set
{
          _receivingEntityID = value;
}
}

public void setSupplyingEntityID(EntityID pSupplyingEntityID)
{ _supplyingEntityID = pSupplyingEntityID;
}

public EntityID getSupplyingEntityID()
{ return _supplyingEntityID; 
}

[XmlElement(Type= typeof(EntityID), ElementName="supplyingEntityID")]
public EntityID SupplyingEntityID
{
     get
{
          return _supplyingEntityID;
}
     set
{
          _supplyingEntityID = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _receivingEntityID.marshal(dos);
       _supplyingEntityID.marshal(dos);
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
       _receivingEntityID.unmarshal(dis);
       _supplyingEntityID.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- ResupplyCancelPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_receivingEntityID=====" + System.Environment.NewLine);
       _receivingEntityID.reflection(sb);
       sb.Append("=====_supplyingEntityID=====" + System.Environment.NewLine);
       _supplyingEntityID.reflection(sb);
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
 public bool equals(ResupplyCancelPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_receivingEntityID.Equals( rhs._receivingEntityID) )) ivarsEqual = false;
     if( ! (_supplyingEntityID.Equals( rhs._supplyingEntityID) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
