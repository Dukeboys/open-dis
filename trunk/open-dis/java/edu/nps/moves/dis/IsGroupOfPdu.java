package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.9.2 Information about a particular group of entities grouped together for the purposes of netowrk bandwidth         reduction or aggregation. Needs manual cleanup. The GED size requires a database lookup. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IsGroupOfPdu extends EntityManagementFamilyPdu implements Serializable
{
   /** ID of aggregated entities */
   protected EntityID  groupEntityID = new EntityID(); 

   /** type of entities constituting the group */
   protected short  groupedEntityCategory;

   /** Number of individual entities constituting the group */
   protected short  numberOfGroupedEntities;

   /** padding */
   protected long  pad2;

   /** latitude */
   protected double  latitude;

   /** longitude */
   protected double  longitude;

   /** GED records about each individual entity in the group. @@@this is wrong--need a database lookup to find the actual size of the list elements */
   protected List groupedEntityDescriptions = new ArrayList(); 

/** Constructor */
 public IsGroupOfPdu()
 {
    setPduType( (short)34 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + groupEntityID.getMarshalledSize();  // groupEntityID
   marshalSize = marshalSize + 1;  // groupedEntityCategory
   marshalSize = marshalSize + 1;  // numberOfGroupedEntities
   marshalSize = marshalSize + 4;  // pad2
   marshalSize = marshalSize + 8;  // latitude
   marshalSize = marshalSize + 8;  // longitude
   for(int idx=0; idx < groupedEntityDescriptions.size(); idx++)
   {
        VariableDatum listElement = (VariableDatum)groupedEntityDescriptions.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setGroupEntityID(EntityID pGroupEntityID)
{ groupEntityID = pGroupEntityID;
}

@XmlElement
public EntityID getGroupEntityID()
{ return groupEntityID; 
}

public void setGroupedEntityCategory(short pGroupedEntityCategory)
{ groupedEntityCategory = pGroupedEntityCategory;
}

@XmlAttribute
public short getGroupedEntityCategory()
{ return groupedEntityCategory; 
}

@XmlAttribute
public short getNumberOfGroupedEntities()
{ return (short)groupedEntityDescriptions.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfGroupedEntities method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfGroupedEntities(short pNumberOfGroupedEntities)
{ numberOfGroupedEntities = pNumberOfGroupedEntities;
}

public void setPad2(long pPad2)
{ pad2 = pPad2;
}

@XmlAttribute
public long getPad2()
{ return pad2; 
}

public void setLatitude(double pLatitude)
{ latitude = pLatitude;
}

@XmlAttribute
public double getLatitude()
{ return latitude; 
}

public void setLongitude(double pLongitude)
{ longitude = pLongitude;
}

@XmlAttribute
public double getLongitude()
{ return longitude; 
}

public void setGroupedEntityDescriptions(List pGroupedEntityDescriptions)
{ groupedEntityDescriptions = pGroupedEntityDescriptions;
}

@XmlElementWrapper(name="groupedEntityDescriptionsList" )
public List getGroupedEntityDescriptions()
{ return groupedEntityDescriptions; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       groupEntityID.marshal(dos);
       dos.writeByte( (byte)groupedEntityCategory);
       dos.writeByte( (byte)groupedEntityDescriptions.size());
       dos.writeInt( (int)pad2);
       dos.writeDouble( (double)latitude);
       dos.writeDouble( (double)longitude);

       for(int idx = 0; idx < groupedEntityDescriptions.size(); idx++)
       {
            VariableDatum aVariableDatum = (VariableDatum)groupedEntityDescriptions.get(idx);
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
       groupEntityID.unmarshal(dis);
       groupedEntityCategory = (short)dis.readUnsignedByte();
       numberOfGroupedEntities = (short)dis.readUnsignedByte();
       pad2 = dis.readInt();
       latitude = dis.readDouble();
       longitude = dis.readDouble();
        for(int idx = 0; idx < numberOfGroupedEntities; idx++)
        {
           VariableDatum anX = new VariableDatum();
            anX.unmarshal(dis);
            groupedEntityDescriptions.add(anX);
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
 public boolean equals(IsGroupOfPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (groupEntityID.equals( rhs.groupEntityID) )) ivarsEqual = false;
     if( ! (groupedEntityCategory == rhs.groupedEntityCategory)) ivarsEqual = false;
     if( ! (numberOfGroupedEntities == rhs.numberOfGroupedEntities)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (latitude == rhs.latitude)) ivarsEqual = false;
     if( ! (longitude == rhs.longitude)) ivarsEqual = false;

     for(int idx = 0; idx < groupedEntityDescriptions.size(); idx++)
     {
        VariableDatum x = (VariableDatum)groupedEntityDescriptions.get(idx);
        if( ! ( groupedEntityDescriptions.get(idx).equals(rhs.groupedEntityDescriptions.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
// Copyright (c) 1995-2009 held by the author(s).  All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
//  are met:
// 
//  * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
// * Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer
// in the documentation and/or other materials provided with the
// distribution.
// * Neither the names of the Naval Postgraduate School (NPS)
//  Modeling Virtual Environments and Simulation (MOVES) Institute
// (http://www.nps.edu and http://www.MovesInstitute.org)
// nor the names of its contributors may be used to endorse or
//  promote products derived from this software without specific
// prior written permission.
// 
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// AS IS AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
// BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
// LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
// LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
// ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.
