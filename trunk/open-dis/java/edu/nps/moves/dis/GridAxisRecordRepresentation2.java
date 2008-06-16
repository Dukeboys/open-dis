package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.2.44: Grid data record, representation 1
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class GridAxisRecordRepresentation2 extends GridAxisRecord implements Serializable
{
   /** number of values */
   protected int  numberOfValues;

   /** variable length list of data parameters @@@this is wrong--need padding as well */
   protected List dataValues = new ArrayList(); 

/** Constructor */
 public GridAxisRecordRepresentation2()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + 2;  // numberOfValues
   for(int idx=0; idx < dataValues.size(); idx++)
   {
        FourByteChunk listElement = (FourByteChunk)dataValues.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


@XmlAttribute
public int getNumberOfValues()
{ return (int)dataValues.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfValues method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfValues(int pNumberOfValues)
{ numberOfValues = pNumberOfValues;
}

public void setDataValues(List pDataValues)
{ dataValues = pDataValues;
}

@XmlElementWrapper(name="dataValuesList" )
public List getDataValues()
{ return dataValues; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       dos.writeShort( (short)dataValues.size());

       for(int idx = 0; idx < dataValues.size(); idx++)
       {
            FourByteChunk aFourByteChunk = (FourByteChunk)dataValues.get(idx);
            aFourByteChunk.marshal(dos);
       } // end of list marshalling

    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    super.unmarshal(dis);

    try 
    {
       numberOfValues = (int)dis.readUnsignedShort();
        for(int idx = 0; idx < numberOfValues; idx++)
        {
           FourByteChunk anX = new FourByteChunk();
            anX.unmarshal(dis);
            dataValues.add(anX);
        };

    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(GridAxisRecordRepresentation2 rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (numberOfValues == rhs.numberOfValues)) ivarsEqual = false;

     for(int idx = 0; idx < dataValues.size(); idx++)
     {
        FourByteChunk x = (FourByteChunk)dataValues.get(idx);
        if( ! ( dataValues.get(idx).equals(rhs.dataValues.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
