using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * Section 5.3.4. abstract superclass for fire and detonation pdus that have shared information. COMPLETE
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
public class WarfareFamilyPdu : Pdu
{
   /** ID of the entity that shot */
   protected EntityID  _firingEntityID = new EntityID(); 

   /** ID of the entity that is being shot at */
   protected EntityID  _targetEntityID = new EntityID(); 


/** Constructor */
   ///<summary>
   ///Section 5.3.4. abstract superclass for fire and detonation pdus that have shared information. COMPLETE
   ///</summary>
 public WarfareFamilyPdu()
 {
    ProtocolFamily = (byte)2;
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = base.getMarshalledSize();
   marshalSize = marshalSize + _firingEntityID.getMarshalledSize();  // _firingEntityID
   marshalSize = marshalSize + _targetEntityID.getMarshalledSize();  // _targetEntityID

   return marshalSize;
}


   ///<summary>
   ///ID of the entity that shot
   ///</summary>
public void setFiringEntityID(EntityID pFiringEntityID)
{ _firingEntityID = pFiringEntityID;
}

   ///<summary>
   ///ID of the entity that shot
   ///</summary>
public EntityID getFiringEntityID()
{ return _firingEntityID; 
}

   ///<summary>
   ///ID of the entity that shot
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="firingEntityID")]
public EntityID FiringEntityID
{
     get
{
          return _firingEntityID;
}
     set
{
          _firingEntityID = value;
}
}

   ///<summary>
   ///ID of the entity that is being shot at
   ///</summary>
public void setTargetEntityID(EntityID pTargetEntityID)
{ _targetEntityID = pTargetEntityID;
}

   ///<summary>
   ///ID of the entity that is being shot at
   ///</summary>
public EntityID getTargetEntityID()
{ return _targetEntityID; 
}

   ///<summary>
   ///ID of the entity that is being shot at
   ///</summary>
[XmlElement(Type= typeof(EntityID), ElementName="targetEntityID")]
public EntityID TargetEntityID
{
     get
{
          return _targetEntityID;
}
     set
{
          _targetEntityID = value;
}
}

///<summary>
///Automatically sets the length of the marshalled data, then calls the marshal method.
///</summary>
public void marshalAutoLengthSet(DataOutputStream dos)
{
       //Set the length prior to marshalling data
       this.setLength((ushort)this.getMarshalledSize());
       this.marshal(dos);
}

///<summary>
///Marshal the data to the DataOutputStream.  Note: Length needs to be set before calling this method
///</summary>
public void marshal(DataOutputStream dos)
{
    base.marshal(dos);
    try 
    {
       _firingEntityID.marshal(dos);
       _targetEntityID.marshal(dos);
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
       _firingEntityID.unmarshal(dis);
       _targetEntityID.unmarshal(dis);
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
    sb.Append("----- WarfareFamilyPdu-----"  + System.Environment.NewLine);
    base.reflection(sb);
    try 
    {
       sb.Append("=====_firingEntityID=====" + System.Environment.NewLine);
       _firingEntityID.reflection(sb);
       sb.Append("=====_targetEntityID=====" + System.Environment.NewLine);
       _targetEntityID.reflection(sb);
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
 public bool equals(WarfareFamilyPdu rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_firingEntityID.Equals( rhs._firingEntityID) )) ivarsEqual = false;
     if( ! (_targetEntityID.Equals( rhs._targetEntityID) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
