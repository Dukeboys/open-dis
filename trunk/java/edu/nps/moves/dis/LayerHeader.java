package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * 5.2.47.  Layer header.
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class LayerHeader extends Object
{
   /** Layer number */
   protected short  layerNumber;

   /** Layer speccific information enumeration */
   protected short  layerSpecificInformaiton;

   /** information length */
   protected int  length;


/** Constructor */
 public LayerHeader()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 1;  // layerNumber
   marshalSize = marshalSize + 1;  // layerSpecificInformaiton
   marshalSize = marshalSize + 2;  // length

   return marshalSize;
}


public void setLayerNumber(short pLayerNumber)
{ layerNumber = pLayerNumber;
}

public short getLayerNumber()
{ return layerNumber; 
}

public void setLayerSpecificInformaiton(short pLayerSpecificInformaiton)
{ layerSpecificInformaiton = pLayerSpecificInformaiton;
}

public short getLayerSpecificInformaiton()
{ return layerSpecificInformaiton; 
}

public void setLength(int pLength)
{ length = pLength;
}

public int getLength()
{ return length; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)layerNumber);
       dos.writeByte( (byte)layerSpecificInformaiton);
       dos.writeShort( (short)length);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       layerNumber = dis.readByte();
       layerSpecificInformaiton = dis.readByte();
       length = dis.readShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(LayerHeader rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (layerNumber == rhs.layerNumber)) ivarsEqual = false;
     if( ! (layerSpecificInformaiton == rhs.layerSpecificInformaiton)) ivarsEqual = false;
     if( ! (length == rhs.length)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
