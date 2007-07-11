package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * Used in UA PDU
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class APAData extends Object
{
   /** Index of APA parameter */
   protected int  parameterIndex;

   /** Index of APA parameter */
   protected short  parameterValue;


/** Constructor */
 public APAData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // parameterIndex
   marshalSize = marshalSize + 2;  // parameterValue

   return marshalSize;
}


public void setParameterIndex(int pParameterIndex)
{ parameterIndex = pParameterIndex;
}

public int getParameterIndex()
{ return parameterIndex; 
}

public void setParameterValue(short pParameterValue)
{ parameterValue = pParameterValue;
}

public short getParameterValue()
{ return parameterValue; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)parameterIndex);
       dos.writeShort( (short)parameterValue);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       parameterIndex = dis.readShort();
       parameterValue = dis.readShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(APAData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (parameterIndex == rhs.parameterIndex)) ivarsEqual = false;
     if( ! (parameterValue == rhs.parameterValue)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
