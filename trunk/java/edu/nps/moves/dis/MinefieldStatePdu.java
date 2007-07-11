package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * Section 5.3.10.1 Abstract superclass for PDUs relating to minefields. COMPLETE
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class MinefieldStatePdu extends MinefieldPduFamily
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

public EntityID getMinefieldID()
{ return minefieldID; }

public void setMinefieldSequence(int pMinefieldSequence)
{ minefieldSequence = pMinefieldSequence;
}

public int getMinefieldSequence()
{ return minefieldSequence; 
}

public void setForceID(short pForceID)
{ forceID = pForceID;
}

public short getForceID()
{ return forceID; 
}

public short getNumberOfPerimeterPoints()
{ return (short)perimeterPoints.size();
}

public void setMinefieldType(EntityType pMinefieldType)
{ minefieldType = pMinefieldType;
}

public EntityType getMinefieldType()
{ return minefieldType; }

public int getNumberOfMineTypes()
{ return (int)mineType.size();
}

public void setMinefieldLocation(Vector3Double pMinefieldLocation)
{ minefieldLocation = pMinefieldLocation;
}

public Vector3Double getMinefieldLocation()
{ return minefieldLocation; }

public void setMinefieldOrientation(Orientation pMinefieldOrientation)
{ minefieldOrientation = pMinefieldOrientation;
}

public Orientation getMinefieldOrientation()
{ return minefieldOrientation; }

public void setAppearance(int pAppearance)
{ appearance = pAppearance;
}

public int getAppearance()
{ return appearance; 
}

public void setProtocolMode(int pProtocolMode)
{ protocolMode = pProtocolMode;
}

public int getProtocolMode()
{ return protocolMode; 
}

public void setPerimeterPoints(List pPerimeterPoints)
{ perimeterPoints = pPerimeterPoints;
}

public List getPerimeterPoints()
{ return perimeterPoints; }

public void setMineType(List pMineType)
{ mineType = pMineType;
}

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
       minefieldSequence = dis.readShort();
       forceID = dis.readByte();
       numberOfPerimeterPoints = dis.readByte();
       minefieldType.unmarshal(dis);
       numberOfMineTypes = dis.readShort();
       minefieldLocation.unmarshal(dis);
       minefieldOrientation.unmarshal(dis);
       appearance = dis.readShort();
       protocolMode = dis.readShort();
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
