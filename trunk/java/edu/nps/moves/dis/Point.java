package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.jaxb.dis.*;

/**
 * x,y point
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class Point extends Object
{
   /** x */
   protected float  x;

   /** y */
   protected float  y;


/** Constructor */
 public Point()
 {
 }

/** 
 * Constructor--takes a parallel jaxb object and returns an open-dis object 
 * 1.4_sed_bait_start */
 public Point(edu.nps.moves.jaxb.dis.Point x)
 {
     this.x = x.getX();
     this.y = x.getY();
 }
/* 1.4_sed_bait_end */


/**
 * returns a jaxb object intialized from this object, given an empty jaxb object
 * 1.4_sed_bait_start **/
 public edu.nps.moves.jaxb.dis.Point initializeJaxbObject(edu.nps.moves.jaxb.dis.Point x)
 {
     ObjectFactory factory = new ObjectFactory();

     x.setX( this.getX() );
     x.setY( this.getY() );
   return x;
 }
/* 1.4_sed_bait_end */


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

public float getX()
{ return x; 
}

public void setY(float pY)
{ y = pY;
}

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
