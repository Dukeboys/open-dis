using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.8. Abstract superclass for radio communications PDUs.
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
public class RadioCommunicationsFamilyPdu : Pdu
{
   /** ID of the entitythat is the source of the communication */
   protected EntityID  _entityId = new EntityID(); 

   /** particular radio within an entity */
   protected ushort  _radioId;


/** Constructor */
 public RadioCommunicationsFamilyPdu()
 {
    ProtocolFamily = (byte)4;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _entityId.getMarshalledSize();  // _entityId
   marshalSize = marshalSize + 2;  // _radioId

   return marshalSize;
}


public void setEntityId(EntityID pEntityId)
{ _entityId = pEntityId;
}

public EntityID getEntityId()
{ return _entityId; 
}

[XmlElement(Type= typeof(EntityID), ElementName="entityId")]
public EntityID EntityId
{
     get
{
          return _entityId;
}
     set
{
          _entityId = value;
}
}

public void setRadioId(ushort pRadioId)
{ _radioId = pRadioId;
}

[XmlElement(Type= typeof(ushort), ElementName="radioId")]
public ushort RadioId
{
     get
{
          return _radioId;
}
     set
{
          _radioId = value;
}
}


public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _entityId.marshal(dos);
       dos.writeUshort( (ushort)_radioId);
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
       _entityId.unmarshal(dis);
       _radioId = dis.readUshort();
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- RadioCommunicationsFamilyPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_entityId=====" + System.Environment.NewLine);
       _entityId.reflection(sb);
           sb.Append("ushort\t _radioId\t " + _radioId.ToString() + System.Environment.NewLine);
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
 public bool equals(RadioCommunicationsFamilyPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_entityId.Equals( rhs._entityId) )) ivarsEqual = false;
     if( ! (_radioId == rhs._radioId)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
