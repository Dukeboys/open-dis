package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Radio modulation
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ModulationType extends Object implements Serializable
{
   /** spread spectrum, 16 bit boolean array */
   protected int  spreadSpectrum;

   /** major */
   protected int  major;

   /** detail */
   protected int  detail;

   /** system */
   protected int  system;


/** Constructor */
 public ModulationType()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // spreadSpectrum
   marshalSize = marshalSize + 2;  // major
   marshalSize = marshalSize + 2;  // detail
   marshalSize = marshalSize + 2;  // system

   return marshalSize;
}


public void setSpreadSpectrum(int pSpreadSpectrum)
{ spreadSpectrum = pSpreadSpectrum;
}

@XmlAttribute
public int getSpreadSpectrum()
{ return spreadSpectrum; 
}

public void setMajor(int pMajor)
{ major = pMajor;
}

@XmlAttribute
public int getMajor()
{ return major; 
}

public void setDetail(int pDetail)
{ detail = pDetail;
}

@XmlAttribute
public int getDetail()
{ return detail; 
}

public void setSystem(int pSystem)
{ system = pSystem;
}

@XmlAttribute
public int getSystem()
{ return system; 
}


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)spreadSpectrum);
       dos.writeShort( (short)major);
       dos.writeShort( (short)detail);
       dos.writeShort( (short)system);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       spreadSpectrum = (int)dis.readUnsignedShort();
       major = (int)dis.readUnsignedShort();
       detail = (int)dis.readUnsignedShort();
       system = (int)dis.readUnsignedShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(ModulationType rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (spreadSpectrum == rhs.spreadSpectrum)) ivarsEqual = false;
     if( ! (major == rhs.major)) ivarsEqual = false;
     if( ! (detail == rhs.detail)) ivarsEqual = false;
     if( ! (system == rhs.system)) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
