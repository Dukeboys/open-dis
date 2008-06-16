package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.34. Three double precision floating point values, x, y, and z
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class Vector3Double extends Object implements Serializable
{
   /** X value */
   protected double  x;

   /** Y value */
   protected double  y;

   /** Z value */
   protected double  z;


/** Constructor */
 public Vector3Double()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 8;  // x
   marshalSize = marshalSize + 8;  // y
   marshalSize = marshalSize + 8;  // z

   return marshalSize;
}


public void setX(double pX)
{ x = pX;
}

@XmlAttribute
public double getX()
{ return x; 
}

public void setY(double pY)
{ y = pY;
}

@XmlAttribute
public double getY()
{ return y; 
}

public void setZ(double pZ)
{ z = pZ;
}

@XmlAttribute
public double getZ()
{ return z; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeDouble( (double)x);
       dos.writeDouble( (double)y);
       dos.writeDouble( (double)z);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       x = dis.readDouble();
       y = dis.readDouble();
       z = dis.readDouble();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(Vector3Double rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (x == rhs.x)) ivarsEqual = false;
     if( ! (y == rhs.y)) ivarsEqual = false;
     if( ! (z == rhs.z)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
