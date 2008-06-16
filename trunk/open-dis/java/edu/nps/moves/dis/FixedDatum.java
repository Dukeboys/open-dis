package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.18. Fixed Datum Record
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class FixedDatum extends Object implements Serializable
{
   /** ID of the fixed datum */
   protected long  fixedDatumID;

   /** Value for the fixed datum */
   protected long  fixedDatumValue;


/** Constructor */
 public FixedDatum()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // fixedDatumID
   marshalSize = marshalSize + 4;  // fixedDatumValue

   return marshalSize;
}


public void setFixedDatumID(long pFixedDatumID)
{ fixedDatumID = pFixedDatumID;
}

@XmlAttribute
public long getFixedDatumID()
{ return fixedDatumID; 
}

public void setFixedDatumValue(long pFixedDatumValue)
{ fixedDatumValue = pFixedDatumValue;
}

@XmlAttribute
public long getFixedDatumValue()
{ return fixedDatumValue; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeInt( (int)fixedDatumID);
       dos.writeInt( (int)fixedDatumValue);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       fixedDatumID = dis.readInt();
       fixedDatumValue = dis.readInt();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(FixedDatum rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (fixedDatumID == rhs.fixedDatumID)) ivarsEqual = false;
     if( ! (fixedDatumValue == rhs.fixedDatumValue)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
