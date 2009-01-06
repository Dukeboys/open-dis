using System;
using System.Collections.Generic;
using System.Text;
using System.Diagnostics;
using System.Xml.Serialization;
using DISnet.DataStreamUtilities;

namespace DIS1998net
{

/**
 * represents values used in dead reckoning algorithms
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
[XmlInclude(typeof(Vector3Float))]
public class DeadReckoningParameter : Object
{
   /** enumeration of what dead reckoning algorighm to use */
   protected byte  _deadReckoningAlgorithm;

   /** other parameters to use in the dead reckoning algorithm */
   protected byte[]  _otherParameters = new byte[15]; 

   /** Linear acceleration of the entity */
   protected Vector3Float  _entityLinearAcceleration = new Vector3Float(); 

   /** angular velocity of the entity */
   protected Vector3Float  _entityAngularVelocity = new Vector3Float(); 


/** Constructor */
 public DeadReckoningParameter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // _deadReckoningAlgorithm
   marshalSize = marshalSize + 15 * 1;  // _otherParameters
   marshalSize = marshalSize + _entityLinearAcceleration.getMarshalledSize();  // _entityLinearAcceleration
   marshalSize = marshalSize + _entityAngularVelocity.getMarshalledSize();  // _entityAngularVelocity

   return marshalSize;
}


public void setDeadReckoningAlgorithm(byte pDeadReckoningAlgorithm)
{ _deadReckoningAlgorithm = pDeadReckoningAlgorithm;
}

[XmlElement(Type= typeof(byte), ElementName="deadReckoningAlgorithm")]
public byte DeadReckoningAlgorithm
{
     get
{
          return _deadReckoningAlgorithm;
}
     set
{
          _deadReckoningAlgorithm = value;
}
}

public void setOtherParameters(byte[] pOtherParameters)
{ _otherParameters = pOtherParameters;
}

public byte[] getOtherParameters()
{ return _otherParameters; }

[XmlArray(ElementName="otherParameters")]
public byte[] OtherParameters
{
     get
{
          return _otherParameters;
}
     set
{
          _otherParameters = value;
}
}

public void setEntityLinearAcceleration(Vector3Float pEntityLinearAcceleration)
{ _entityLinearAcceleration = pEntityLinearAcceleration;
}

public Vector3Float getEntityLinearAcceleration()
{ return _entityLinearAcceleration; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="entityLinearAcceleration")]
public Vector3Float EntityLinearAcceleration
{
     get
{
          return _entityLinearAcceleration;
}
     set
{
          _entityLinearAcceleration = value;
}
}

public void setEntityAngularVelocity(Vector3Float pEntityAngularVelocity)
{ _entityAngularVelocity = pEntityAngularVelocity;
}

public Vector3Float getEntityAngularVelocity()
{ return _entityAngularVelocity; 
}

[XmlElement(Type= typeof(Vector3Float), ElementName="entityAngularVelocity")]
public Vector3Float EntityAngularVelocity
{
     get
{
          return _entityAngularVelocity;
}
     set
{
          _entityAngularVelocity = value;
}
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)_deadReckoningAlgorithm);

       for(int idx = 0; idx < _otherParameters.Length; idx++)
       {
           dos.writeByte(_otherParameters[idx]);
       } // end of array marshaling

       _entityLinearAcceleration.marshal(dos);
       _entityAngularVelocity.marshal(dos);
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
       _deadReckoningAlgorithm = dis.readByte();
       for(int idx = 0; idx < _otherParameters.Length; idx++)
       {
                _otherParameters[idx] = dis.readByte();
       } // end of array unmarshaling
       _entityLinearAcceleration.unmarshal(dis);
       _entityAngularVelocity.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      Trace.WriteLine(e); 
      Trace.Flush();
    }
 } // end of unmarshal method 


public void reflection(StringBuilder sb)
{
    sb.Append("----- DeadReckoningParameter-----"  + System.Environment.NewLine);
    try 
    {
           sb.Append("byte\t _deadReckoningAlgorithm\t " + _deadReckoningAlgorithm.ToString() + System.Environment.NewLine);

       for(int idx = 0; idx < _otherParameters.Length; idx++)
       {
           sb.Append("byte\t " + _otherParameters[idx] + System.Environment.NewLine);
       } // end of array reflection

       sb.Append("=====_entityLinearAcceleration=====" + System.Environment.NewLine);
       _entityLinearAcceleration.reflection(sb);
       sb.Append("=====_entityAngularVelocity=====" + System.Environment.NewLine);
       _entityAngularVelocity.reflection(sb);
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
 public bool equals(DeadReckoningParameter rhs)
 {
     bool ivarsEqual = true;

    if(rhs.GetType() != this.GetType())
        return false;

     if( ! (_deadReckoningAlgorithm == rhs._deadReckoningAlgorithm)) ivarsEqual = false;

     for(int idx = 0; idx < 15; idx++)
     {
          if(!(_otherParameters[idx] == rhs._otherParameters[idx])) ivarsEqual = false;
     }

     if( ! (_entityLinearAcceleration.Equals( rhs._entityLinearAcceleration) )) ivarsEqual = false;
     if( ! (_entityAngularVelocity.Equals( rhs._entityAngularVelocity) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
} // end of namespace
