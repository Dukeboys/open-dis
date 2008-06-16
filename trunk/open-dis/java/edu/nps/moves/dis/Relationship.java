package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.2.56. Purpose for joinging two entities
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class Relationship extends Object implements Serializable
{
   /** Nature of join */
   protected int  nature;

   /** position of join */
   protected int  position;


/** Constructor */
 public Relationship()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // nature
   marshalSize = marshalSize + 2;  // position

   return marshalSize;
}


public void setNature(int pNature)
{ nature = pNature;
}

@XmlAttribute
public int getNature()
{ return nature; 
}

public void setPosition(int pPosition)
{ position = pPosition;
}

@XmlAttribute
public int getPosition()
{ return position; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)nature);
       dos.writeShort( (short)position);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       nature = (int)dis.readUnsignedShort();
       position = (int)dis.readUnsignedShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(Relationship rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (nature == rhs.nature)) ivarsEqual = false;
     if( ! (position == rhs.position)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
