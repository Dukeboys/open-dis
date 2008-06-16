package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.12.12: Arbitrary messages. Only reliable this time. Neds manual intervention     to fix padding in variable datums. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class CommentReliablePdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** Fixed datum record count */
   protected long  numberOfFixedDatumRecords;

   /** variable datum record count */
   protected long  numberOfVariableDatumRecords;

   /** Fixed datum records */
   protected List fixedDatumRecords = new ArrayList(); 
   /** Variable datum records */
   protected List variableDatumRecords = new ArrayList(); 

/** Constructor */
 public CommentReliablePdu()
 {
    setPduType( (short)62 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + 4;  // numberOfFixedDatumRecords
   marshalSize = marshalSize + 4;  // numberOfVariableDatumRecords
   for(int idx=0; idx < fixedDatumRecords.size(); idx++)
   {
        FixedDatum listElement = (FixedDatum)fixedDatumRecords.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < variableDatumRecords.size(); idx++)
   {
        VariableDatum listElement = (VariableDatum)variableDatumRecords.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


@XmlAttribute
public long getNumberOfFixedDatumRecords()
{ return (long)fixedDatumRecords.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfFixedDatumRecords method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfFixedDatumRecords(long pNumberOfFixedDatumRecords)
{ numberOfFixedDatumRecords = pNumberOfFixedDatumRecords;
}

@XmlAttribute
public long getNumberOfVariableDatumRecords()
{ return (long)variableDatumRecords.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfVariableDatumRecords method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfVariableDatumRecords(long pNumberOfVariableDatumRecords)
{ numberOfVariableDatumRecords = pNumberOfVariableDatumRecords;
}

public void setFixedDatumRecords(List pFixedDatumRecords)
{ fixedDatumRecords = pFixedDatumRecords;
}

@XmlElementWrapper(name="fixedDatumRecordsList" )
public List getFixedDatumRecords()
{ return fixedDatumRecords; }

public void setVariableDatumRecords(List pVariableDatumRecords)
{ variableDatumRecords = pVariableDatumRecords;
}

@XmlElementWrapper(name="variableDatumRecordsList" )
public List getVariableDatumRecords()
{ return variableDatumRecords; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       dos.writeInt( (int)fixedDatumRecords.size());
       dos.writeInt( (int)variableDatumRecords.size());

       for(int idx = 0; idx < fixedDatumRecords.size(); idx++)
       {
            FixedDatum aFixedDatum = (FixedDatum)fixedDatumRecords.get(idx);
            aFixedDatum.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < variableDatumRecords.size(); idx++)
       {
            VariableDatum aVariableDatum = (VariableDatum)variableDatumRecords.get(idx);
            aVariableDatum.marshal(dos);
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
       numberOfFixedDatumRecords = dis.readInt();
       numberOfVariableDatumRecords = dis.readInt();
        for(int idx = 0; idx < numberOfFixedDatumRecords; idx++)
        {
           FixedDatum anX = new FixedDatum();
            anX.unmarshal(dis);
            fixedDatumRecords.add(anX);
        };

        for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
        {
           VariableDatum anX = new VariableDatum();
            anX.unmarshal(dis);
            variableDatumRecords.add(anX);
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
 public boolean equals(CommentReliablePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (numberOfFixedDatumRecords == rhs.numberOfFixedDatumRecords)) ivarsEqual = false;
     if( ! (numberOfVariableDatumRecords == rhs.numberOfVariableDatumRecords)) ivarsEqual = false;

     for(int idx = 0; idx < fixedDatumRecords.size(); idx++)
     {
        FixedDatum x = (FixedDatum)fixedDatumRecords.get(idx);
        if( ! ( fixedDatumRecords.get(idx).equals(rhs.fixedDatumRecords.get(idx)))) ivarsEqual = false;
     }


     for(int idx = 0; idx < variableDatumRecords.size(); idx++)
     {
        VariableDatum x = (VariableDatum)variableDatumRecords.get(idx);
        if( ! ( variableDatumRecords.get(idx).equals(rhs.variableDatumRecords.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
