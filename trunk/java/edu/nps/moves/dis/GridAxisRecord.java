package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * 5.2.44: Grid data record, a common abstract superclass for several subtypes 
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class GridAxisRecord extends Object
{
   /** type of environmental sample */
   protected int  sampleType;

   /** value that describes data representation */
   protected int  dataRepresentation;


/** Constructor */
 public GridAxisRecord()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // sampleType
   marshalSize = marshalSize + 2;  // dataRepresentation

   return marshalSize;
}


public void setSampleType(int pSampleType)
{ sampleType = pSampleType;
}

public int getSampleType()
{ return sampleType; 
}

public void setDataRepresentation(int pDataRepresentation)
{ dataRepresentation = pDataRepresentation;
}

public int getDataRepresentation()
{ return dataRepresentation; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)sampleType);
       dos.writeShort( (short)dataRepresentation);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       sampleType = dis.readShort();
       dataRepresentation = dis.readShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(GridAxisRecord rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (sampleType == rhs.sampleType)) ivarsEqual = false;
     if( ! (dataRepresentation == rhs.dataRepresentation)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
