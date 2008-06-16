package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.2.3: location of the radiating portion of the antenna, specified in world coordinates and         entity coordinates.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class AntennaLocation extends Object implements Serializable
{
   /** Location of the radiating portion of the antenna in world    coordinates */
   protected Vector3Double  antennaLocation = new Vector3Double(); 

   /** Location of the radiating portion of the antenna     in entity coordinates */
   protected Vector3Float  relativeAntennaLocation = new Vector3Float(); 


/** Constructor */
 public AntennaLocation()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + antennaLocation.getMarshalledSize();  // antennaLocation
   marshalSize = marshalSize + relativeAntennaLocation.getMarshalledSize();  // relativeAntennaLocation

   return marshalSize;
}


public void setAntennaLocation(Vector3Double pAntennaLocation)
{ antennaLocation = pAntennaLocation;
}

@XmlElement
public Vector3Double getAntennaLocation()
{ return antennaLocation; 
}

public void setRelativeAntennaLocation(Vector3Float pRelativeAntennaLocation)
{ relativeAntennaLocation = pRelativeAntennaLocation;
}

@XmlElement
public Vector3Float getRelativeAntennaLocation()
{ return relativeAntennaLocation; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       antennaLocation.marshal(dos);
       relativeAntennaLocation.marshal(dos);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       antennaLocation.unmarshal(dis);
       relativeAntennaLocation.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(AntennaLocation rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (antennaLocation.equals( rhs.antennaLocation) )) ivarsEqual = false;
     if( ! (relativeAntennaLocation.equals( rhs.relativeAntennaLocation) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
