package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * Used in UA PDU
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class AcousticBeamData extends Object
{
   /** beam data length */
   protected int  beamDataLength;

   /** beamIDNumber */
   protected short  beamIDNumber;

   /** padding */
   protected int  pad2;

   /** fundamental data parameters */
   protected AcousticBeamFundamentalParameter  fundamentalDataParameters = new AcousticBeamFundamentalParameter(); 


/** Constructor */
 public AcousticBeamData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // beamDataLength
   marshalSize = marshalSize + 1;  // beamIDNumber
   marshalSize = marshalSize + 2;  // pad2
   marshalSize = marshalSize + fundamentalDataParameters.getMarshalledSize();  // fundamentalDataParameters

   return marshalSize;
}


public void setBeamDataLength(int pBeamDataLength)
{ beamDataLength = pBeamDataLength;
}

public int getBeamDataLength()
{ return beamDataLength; 
}

public void setBeamIDNumber(short pBeamIDNumber)
{ beamIDNumber = pBeamIDNumber;
}

public short getBeamIDNumber()
{ return beamIDNumber; 
}

public void setPad2(int pPad2)
{ pad2 = pPad2;
}

public int getPad2()
{ return pad2; 
}

public void setFundamentalDataParameters(AcousticBeamFundamentalParameter pFundamentalDataParameters)
{ fundamentalDataParameters = pFundamentalDataParameters;
}

public AcousticBeamFundamentalParameter getFundamentalDataParameters()
{ return fundamentalDataParameters; }


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)beamDataLength);
       dos.writeByte( (byte)beamIDNumber);
       dos.writeShort( (short)pad2);
       fundamentalDataParameters.marshal(dos);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       beamDataLength = dis.readShort();
       beamIDNumber = dis.readByte();
       pad2 = dis.readShort();
       fundamentalDataParameters.unmarshal(dis);
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(AcousticBeamData rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (beamDataLength == rhs.beamDataLength)) ivarsEqual = false;
     if( ! (beamIDNumber == rhs.beamIDNumber)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (fundamentalDataParameters.equals( rhs.fundamentalDataParameters) )) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
