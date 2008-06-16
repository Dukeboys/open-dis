package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Data about a propulsion system
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class PropulsionSystemData extends Object implements Serializable
{
   /** powerSetting */
   protected float  powerSetting;

   /** engine RPMs */
   protected float  engineRpm;


/** Constructor */
 public PropulsionSystemData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // powerSetting
   marshalSize = marshalSize + 4;  // engineRpm

   return marshalSize;
}


public void setPowerSetting(float pPowerSetting)
{ powerSetting = pPowerSetting;
}

@XmlAttribute
public float getPowerSetting()
{ return powerSetting; 
}

public void setEngineRpm(float pEngineRpm)
{ engineRpm = pEngineRpm;
}

@XmlAttribute
public float getEngineRpm()
{ return engineRpm; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)powerSetting);
       dos.writeFloat( (float)engineRpm);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       powerSetting = dis.readFloat();
       engineRpm = dis.readFloat();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(PropulsionSystemData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (powerSetting == rhs.powerSetting)) ivarsEqual = false;
     if( ! (engineRpm == rhs.engineRpm)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
