package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * Section 5.2.8. Time measurements that exceed one hour. Hours is the number of           hours since January 1, 1970, UTC
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ClockTime extends Object
{
   /** Hours in UTC */
   protected int  hour;

   /** Time past the hour */
   protected long  timePastHour;


/** Constructor */
 public ClockTime()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 4;  // hour
   marshalSize = marshalSize + 4;  // timePastHour

   return marshalSize;
}


public void setHour(int pHour)
{ hour = pHour;
}

public int getHour()
{ return hour; 
}

public void setTimePastHour(long pTimePastHour)
{ timePastHour = pTimePastHour;
}

public long getTimePastHour()
{ return timePastHour; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeInt( (int)hour);
       dos.writeInt( (int)timePastHour);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       hour = dis.readInt();
       timePastHour = dis.readInt();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(ClockTime rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (hour == rhs.hour)) ivarsEqual = false;
     if( ! (timePastHour == rhs.timePastHour)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
