package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.10.1 Abstract superclass for PDUs relating to minefields. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class MinefieldStatePdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected EntityID  minefieldID = new EntityID(); 

   /** Minefield sequence */
   protected int  minefieldSequence;

   /** force ID */
   protected short  forceID;

   /** Number of permieter points */
   protected short  numberOfPerimeterPoints;

   /** type of minefield */
   protected EntityType  minefieldType = new EntityType(); 

   /** how many mine types */
   protected int  numberOfMineTypes;

   /** location of minefield in world coords */
   protected Vector3Double  minefieldLocation = new Vector3Double(); 

   /** orientation of minefield */
   protected Orientation  minefieldOrientation = new Orientation(); 

   /** appearance bitflags */
   protected int  appearance;

   /** protocolMode */
   protected int  protocolMode;

   /** perimeter points for the minefield */
   protected List perimeterPoints = new ArrayList(); 
   /** Type of mines */
   protected List mineType = new ArrayList(); 

/** Constructor */
 public MinefieldStatePdu()
 {
    setPduType( (short)37 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + minefieldID.getMarshalledSize();  // minefieldID
   marshalSize = marshalSize + 2;  // minefieldSequence
   marshalSize = marshalSize + 1;  // forceID
   marshalSize = marshalSize + 1;  // numberOfPerimeterPoints
   marshalSize = marshalSize + minefieldType.getMarshalledSize();  // minefieldType
   marshalSize = marshalSize + 2;  // numberOfMineTypes
   marshalSize = marshalSize + minefieldLocation.getMarshalledSize();  // minefieldLocation
   marshalSize = marshalSize + minefieldOrientation.getMarshalledSize();  // minefieldOrientation
   marshalSize = marshalSize + 2;  // appearance
   marshalSize = marshalSize + 2;  // protocolMode
   for(int idx=0; idx < perimeterPoints.size(); idx++)
   {
        Point listElement = (Point)perimeterPoints.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < mineType.size(); idx++)
   {
        EntityType listElement = (EntityType)mineType.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setMinefieldID(EntityID pMinefieldID)
{ minefieldID = pMinefieldID;
}

@XmlElement
public EntityID getMinefieldID()
{ return minefieldID; 
}

public void setMinefieldSequence(int pMinefieldSequence)
{ minefieldSequence = pMinefieldSequence;
}

@XmlAttribute
public int getMinefieldSequence()
{ return minefieldSequence; 
}

public void setForceID(short pForceID)
{ forceID = pForceID;
}

@XmlAttribute
public short getForceID()
{ return forceID; 
}

@XmlAttribute
public short getNumberOfPerimeterPoints()
{ return (short)perimeterPoints.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfPerimeterPoints method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfPerimeterPoints(short pNumberOfPerimeterPoints)
{ numberOfPerimeterPoints = pNumberOfPerimeterPoints;
}

public void setMinefieldType(EntityType pMinefieldType)
{ minefieldType = pMinefieldType;
}

@XmlElement
public EntityType getMinefieldType()
{ return minefieldType; 
}

@XmlAttribute
public int getNumberOfMineTypes()
{ return (int)mineType.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfMineTypes method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfMineTypes(int pNumberOfMineTypes)
{ numberOfMineTypes = pNumberOfMineTypes;
}

public void setMinefieldLocation(Vector3Double pMinefieldLocation)
{ minefieldLocation = pMinefieldLocation;
}

@XmlElement
public Vector3Double getMinefieldLocation()
{ return minefieldLocation; 
}

public void setMinefieldOrientation(Orientation pMinefieldOrientation)
{ minefieldOrientation = pMinefieldOrientation;
}

@XmlElement
public Orientation getMinefieldOrientation()
{ return minefieldOrientation; 
}

public void setAppearance(int pAppearance)
{ appearance = pAppearance;
}

@XmlAttribute
public int getAppearance()
{ return appearance; 
}

public void setProtocolMode(int pProtocolMode)
{ protocolMode = pProtocolMode;
}

@XmlAttribute
public int getProtocolMode()
{ return protocolMode; 
}

public void setPerimeterPoints(List pPerimeterPoints)
{ perimeterPoints = pPerimeterPoints;
}

@XmlElementWrapper(name="perimeterPointsList" )
public List getPerimeterPoints()
{ return perimeterPoints; }

public void setMineType(List pMineType)
{ mineType = pMineType;
}

@XmlElementWrapper(name="mineTypeList" )
public List getMineType()
{ return mineType; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       minefieldID.marshal(dos);
       dos.writeShort( (short)minefieldSequence);
       dos.writeByte( (byte)forceID);
       dos.writeByte( (byte)perimeterPoints.size());
       minefieldType.marshal(dos);
       dos.writeShort( (short)mineType.size());
       minefieldLocation.marshal(dos);
       minefieldOrientation.marshal(dos);
       dos.writeShort( (short)appearance);
       dos.writeShort( (short)protocolMode);

       for(int idx = 0; idx < perimeterPoints.size(); idx++)
       {
            Point aPoint = (Point)perimeterPoints.get(idx);
            aPoint.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < mineType.size(); idx++)
       {
            EntityType aEntityType = (EntityType)mineType.get(idx);
            aEntityType.marshal(dos);
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
       minefieldID.unmarshal(dis);
       minefieldSequence = (int)dis.readUnsignedShort();
       forceID = (short)dis.readUnsignedByte();
       numberOfPerimeterPoints = (short)dis.readUnsignedByte();
       minefieldType.unmarshal(dis);
       numberOfMineTypes = (int)dis.readUnsignedShort();
       minefieldLocation.unmarshal(dis);
       minefieldOrientation.unmarshal(dis);
       appearance = (int)dis.readUnsignedShort();
       protocolMode = (int)dis.readUnsignedShort();
        for(int idx = 0; idx < numberOfPerimeterPoints; idx++)
        {
           Point anX = new Point();
            anX.unmarshal(dis);
            perimeterPoints.add(anX);
        };

        for(int idx = 0; idx < numberOfMineTypes; idx++)
        {
           EntityType anX = new EntityType();
            anX.unmarshal(dis);
            mineType.add(anX);
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
 public boolean equals(MinefieldStatePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (minefieldSequence == rhs.minefieldSequence)) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (numberOfPerimeterPoints == rhs.numberOfPerimeterPoints)) ivarsEqual = false;
     if( ! (minefieldType.equals( rhs.minefieldType) )) ivarsEqual = false;
     if( ! (numberOfMineTypes == rhs.numberOfMineTypes)) ivarsEqual = false;
     if( ! (minefieldLocation.equals( rhs.minefieldLocation) )) ivarsEqual = false;
     if( ! (minefieldOrientation.equals( rhs.minefieldOrientation) )) ivarsEqual = false;
     if( ! (appearance == rhs.appearance)) ivarsEqual = false;
     if( ! (protocolMode == rhs.protocolMode)) ivarsEqual = false;

     for(int idx = 0; idx < perimeterPoints.size(); idx++)
     {
        Point x = (Point)perimeterPoints.get(idx);
        if( ! ( perimeterPoints.get(idx).equals(rhs.perimeterPoints.get(idx)))) ivarsEqual = false;
     }


     for(int idx = 0; idx < mineType.size(); idx++)
     {
        EntityType x = (EntityType)mineType.get(idx);
        if( ! ( mineType.get(idx).equals(rhs.mineType.get(idx)))) ivarsEqual = false;
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
