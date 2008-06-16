package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * x,y point
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class Point extends Object implements Serializable
{
   /** x */
   protected float  x;

   /** y */
   protected float  y;


/** Constructor */
 public Point()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // x
   marshalSize = marshalSize + 4;  // y

   return marshalSize;
}


public void setX(float pX)
{ x = pX;
}

@XmlAttribute
public float getX()
{ return x; 
}

public void setY(float pY)
{ y = pY;
}

@XmlAttribute
public float getY()
{ return y; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)x);
       dos.writeFloat( (float)y);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       x = dis.readFloat();
       y = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(Point rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (x == rhs.x)) ivarsEqual = false;
     if( ! (y == rhs.y)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
