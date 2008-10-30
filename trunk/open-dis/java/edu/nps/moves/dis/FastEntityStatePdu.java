package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.3.1. Represents the postion and state of one entity in the world. This is identical in function to entity state pdu, but generates less garbage to collect in the Java world. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class FastEntityStatePdu extends EntityInformationFamilyPdu implements Serializable
{
   /** The site ID */
   protected int  site;

   /** The application ID */
   protected int  application;

   /** the entity ID */
   protected int  entity;

   /** what force this entity is affiliated with, eg red, blue, neutral, etc */
   protected short  forceId;

   /** How many articulation parameters are in the variable length list */
   protected byte  numberOfArticulationParameters;

   /** Kind of entity */
   protected short  entityKind;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected short  domain;

   /** country to which the design of the entity is attributed */
   protected int  country;

   /** category of entity */
   protected short  category;

   /** subcategory of entity */
   protected short  subcategory;

   /** specific info based on subcategory field */
   protected short  specific;

   protected short  extra;

   /** Kind of entity */
   protected short  altEntityKind;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected short  altDomain;

   /** country to which the design of the entity is attributed */
   protected int  altCountry;

   /** category of entity */
   protected short  altCategory;

   /** subcategory of entity */
   protected short  altSubcategory;

   /** specific info based on subcategory field */
   protected short  altSpecific;

   protected short  altExtra;

   /** X velo */
   protected float  xVelocity;

   /** y Value */
   protected float  yVelocity;

   /** Z value */
   protected float  zVelocity;

   /** X value */
   protected float  xLocation;

   /** y Value */
   protected float  yLocation;

   /** Z value */
   protected float  zLocation;

   protected float  psi;

   protected float  theta;

   protected float  phi;

   /** a series of bit flags that are used to help draw the entity, such as smoking, on fire, etc. */
   protected int  entityAppearance;

   /** enumeration of what dead reckoning algorighm to use */
   protected short  deadReckoningAlgorithm;

   /** other parameters to use in the dead reckoning algorithm */
   protected byte[]  otherParameters = new byte[15]; 

   /** X value */
   protected float  xAcceleration;

   /** y Value */
   protected float  yAcceleration;

   /** Z value */
   protected float  zAcceleration;

   /** X value */
   protected float  xAngularVelocity;

   /** y Value */
   protected float  yAngularVelocity;

   /** Z value */
   protected float  zAngularVelocity;

   /** characters that can be used for debugging, or to draw unique strings on the side of entities in the world */
   protected byte[]  marking = new byte[12]; 

   /** a series of bit flags */
   protected int  capabilities;

   /** variable length list of articulation parameters */
   protected List articulationParameters = new ArrayList(); 

/** Constructor */
 public FastEntityStatePdu()
 {
    setPduType( (short)1 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + 2;  // site
   marshalSize = marshalSize + 2;  // application
   marshalSize = marshalSize + 2;  // entity
   marshalSize = marshalSize + 1;  // forceId
   marshalSize = marshalSize + 1;  // numberOfArticulationParameters
   marshalSize = marshalSize + 1;  // entityKind
   marshalSize = marshalSize + 1;  // domain
   marshalSize = marshalSize + 2;  // country
   marshalSize = marshalSize + 1;  // category
   marshalSize = marshalSize + 1;  // subcategory
   marshalSize = marshalSize + 1;  // specific
   marshalSize = marshalSize + 1;  // extra
   marshalSize = marshalSize + 1;  // altEntityKind
   marshalSize = marshalSize + 1;  // altDomain
   marshalSize = marshalSize + 2;  // altCountry
   marshalSize = marshalSize + 1;  // altCategory
   marshalSize = marshalSize + 1;  // altSubcategory
   marshalSize = marshalSize + 1;  // altSpecific
   marshalSize = marshalSize + 1;  // altExtra
   marshalSize = marshalSize + 4;  // xVelocity
   marshalSize = marshalSize + 4;  // yVelocity
   marshalSize = marshalSize + 4;  // zVelocity
   marshalSize = marshalSize + 4;  // xLocation
   marshalSize = marshalSize + 4;  // yLocation
   marshalSize = marshalSize + 4;  // zLocation
   marshalSize = marshalSize + 4;  // psi
   marshalSize = marshalSize + 4;  // theta
   marshalSize = marshalSize + 4;  // phi
   marshalSize = marshalSize + 4;  // entityAppearance
   marshalSize = marshalSize + 1;  // deadReckoningAlgorithm
   marshalSize = marshalSize + 15 * 1;  // otherParameters
   marshalSize = marshalSize + 4;  // xAcceleration
   marshalSize = marshalSize + 4;  // yAcceleration
   marshalSize = marshalSize + 4;  // zAcceleration
   marshalSize = marshalSize + 4;  // xAngularVelocity
   marshalSize = marshalSize + 4;  // yAngularVelocity
   marshalSize = marshalSize + 4;  // zAngularVelocity
   marshalSize = marshalSize + 12 * 1;  // marking
   marshalSize = marshalSize + 4;  // capabilities
   for(int idx=0; idx < articulationParameters.size(); idx++)
   {
        ArticulationParameter listElement = (ArticulationParameter)articulationParameters.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setSite(int pSite)
{ site = pSite;
}

@XmlAttribute
public int getSite()
{ return site; 
}

public void setApplication(int pApplication)
{ application = pApplication;
}

@XmlAttribute
public int getApplication()
{ return application; 
}

public void setEntity(int pEntity)
{ entity = pEntity;
}

@XmlAttribute
public int getEntity()
{ return entity; 
}

public void setForceId(short pForceId)
{ forceId = pForceId;
}

@XmlAttribute
public short getForceId()
{ return forceId; 
}

@XmlAttribute
public byte getNumberOfArticulationParameters()
{ return (byte)articulationParameters.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfArticulationParameters method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfArticulationParameters(byte pNumberOfArticulationParameters)
{ numberOfArticulationParameters = pNumberOfArticulationParameters;
}

public void setEntityKind(short pEntityKind)
{ entityKind = pEntityKind;
}

@XmlAttribute
public short getEntityKind()
{ return entityKind; 
}

public void setDomain(short pDomain)
{ domain = pDomain;
}

@XmlAttribute
public short getDomain()
{ return domain; 
}

public void setCountry(int pCountry)
{ country = pCountry;
}

@XmlAttribute
public int getCountry()
{ return country; 
}

public void setCategory(short pCategory)
{ category = pCategory;
}

@XmlAttribute
public short getCategory()
{ return category; 
}

public void setSubcategory(short pSubcategory)
{ subcategory = pSubcategory;
}

@XmlAttribute
public short getSubcategory()
{ return subcategory; 
}

public void setSpecific(short pSpecific)
{ specific = pSpecific;
}

@XmlAttribute
public short getSpecific()
{ return specific; 
}

public void setExtra(short pExtra)
{ extra = pExtra;
}

@XmlAttribute
public short getExtra()
{ return extra; 
}

public void setAltEntityKind(short pAltEntityKind)
{ altEntityKind = pAltEntityKind;
}

@XmlAttribute
public short getAltEntityKind()
{ return altEntityKind; 
}

public void setAltDomain(short pAltDomain)
{ altDomain = pAltDomain;
}

@XmlAttribute
public short getAltDomain()
{ return altDomain; 
}

public void setAltCountry(int pAltCountry)
{ altCountry = pAltCountry;
}

@XmlAttribute
public int getAltCountry()
{ return altCountry; 
}

public void setAltCategory(short pAltCategory)
{ altCategory = pAltCategory;
}

@XmlAttribute
public short getAltCategory()
{ return altCategory; 
}

public void setAltSubcategory(short pAltSubcategory)
{ altSubcategory = pAltSubcategory;
}

@XmlAttribute
public short getAltSubcategory()
{ return altSubcategory; 
}

public void setAltSpecific(short pAltSpecific)
{ altSpecific = pAltSpecific;
}

@XmlAttribute
public short getAltSpecific()
{ return altSpecific; 
}

public void setAltExtra(short pAltExtra)
{ altExtra = pAltExtra;
}

@XmlAttribute
public short getAltExtra()
{ return altExtra; 
}

public void setXVelocity(float pXVelocity)
{ xVelocity = pXVelocity;
}

@XmlAttribute
public float getXVelocity()
{ return xVelocity; 
}

public void setYVelocity(float pYVelocity)
{ yVelocity = pYVelocity;
}

@XmlAttribute
public float getYVelocity()
{ return yVelocity; 
}

public void setZVelocity(float pZVelocity)
{ zVelocity = pZVelocity;
}

@XmlAttribute
public float getZVelocity()
{ return zVelocity; 
}

public void setXLocation(float pXLocation)
{ xLocation = pXLocation;
}

@XmlAttribute
public float getXLocation()
{ return xLocation; 
}

public void setYLocation(float pYLocation)
{ yLocation = pYLocation;
}

@XmlAttribute
public float getYLocation()
{ return yLocation; 
}

public void setZLocation(float pZLocation)
{ zLocation = pZLocation;
}

@XmlAttribute
public float getZLocation()
{ return zLocation; 
}

public void setPsi(float pPsi)
{ psi = pPsi;
}

@XmlAttribute
public float getPsi()
{ return psi; 
}

public void setTheta(float pTheta)
{ theta = pTheta;
}

@XmlAttribute
public float getTheta()
{ return theta; 
}

public void setPhi(float pPhi)
{ phi = pPhi;
}

@XmlAttribute
public float getPhi()
{ return phi; 
}

public void setEntityAppearance(int pEntityAppearance)
{ entityAppearance = pEntityAppearance;
}

@XmlAttribute
public int getEntityAppearance()
{ return entityAppearance; 
}

public void setDeadReckoningAlgorithm(short pDeadReckoningAlgorithm)
{ deadReckoningAlgorithm = pDeadReckoningAlgorithm;
}

@XmlAttribute
public short getDeadReckoningAlgorithm()
{ return deadReckoningAlgorithm; 
}

public void setOtherParameters(byte[] pOtherParameters)
{ otherParameters = pOtherParameters;
}

@XmlElement(name="otherParameters" )
public byte[] getOtherParameters()
{ return otherParameters; }

public void setXAcceleration(float pXAcceleration)
{ xAcceleration = pXAcceleration;
}

@XmlAttribute
public float getXAcceleration()
{ return xAcceleration; 
}

public void setYAcceleration(float pYAcceleration)
{ yAcceleration = pYAcceleration;
}

@XmlAttribute
public float getYAcceleration()
{ return yAcceleration; 
}

public void setZAcceleration(float pZAcceleration)
{ zAcceleration = pZAcceleration;
}

@XmlAttribute
public float getZAcceleration()
{ return zAcceleration; 
}

public void setXAngularVelocity(float pXAngularVelocity)
{ xAngularVelocity = pXAngularVelocity;
}

@XmlAttribute
public float getXAngularVelocity()
{ return xAngularVelocity; 
}

public void setYAngularVelocity(float pYAngularVelocity)
{ yAngularVelocity = pYAngularVelocity;
}

@XmlAttribute
public float getYAngularVelocity()
{ return yAngularVelocity; 
}

public void setZAngularVelocity(float pZAngularVelocity)
{ zAngularVelocity = pZAngularVelocity;
}

@XmlAttribute
public float getZAngularVelocity()
{ return zAngularVelocity; 
}

public void setMarking(byte[] pMarking)
{ marking = pMarking;
}

@XmlElement(name="marking" )
public byte[] getMarking()
{ return marking; }

public void setCapabilities(int pCapabilities)
{ capabilities = pCapabilities;
}

@XmlAttribute
public int getCapabilities()
{ return capabilities; 
}

public void setArticulationParameters(List pArticulationParameters)
{ articulationParameters = pArticulationParameters;
}

@XmlElementWrapper(name="articulationParametersList" )
public List getArticulationParameters()
{ return articulationParameters; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       dos.writeShort( (short)site);
       dos.writeShort( (short)application);
       dos.writeShort( (short)entity);
       dos.writeByte( (byte)forceId);
       dos.writeByte( (byte)articulationParameters.size());
       dos.writeByte( (byte)entityKind);
       dos.writeByte( (byte)domain);
       dos.writeShort( (short)country);
       dos.writeByte( (byte)category);
       dos.writeByte( (byte)subcategory);
       dos.writeByte( (byte)specific);
       dos.writeByte( (byte)extra);
       dos.writeByte( (byte)altEntityKind);
       dos.writeByte( (byte)altDomain);
       dos.writeShort( (short)altCountry);
       dos.writeByte( (byte)altCategory);
       dos.writeByte( (byte)altSubcategory);
       dos.writeByte( (byte)altSpecific);
       dos.writeByte( (byte)altExtra);
       dos.writeFloat( (float)xVelocity);
       dos.writeFloat( (float)yVelocity);
       dos.writeFloat( (float)zVelocity);
       dos.writeFloat( (float)xLocation);
       dos.writeFloat( (float)yLocation);
       dos.writeFloat( (float)zLocation);
       dos.writeFloat( (float)psi);
       dos.writeFloat( (float)theta);
       dos.writeFloat( (float)phi);
       dos.writeInt( (int)entityAppearance);
       dos.writeByte( (byte)deadReckoningAlgorithm);

       for(int idx = 0; idx < otherParameters.length; idx++)
       {
           dos.writeByte(otherParameters[idx]);
       } // end of array marshaling

       dos.writeFloat( (float)xAcceleration);
       dos.writeFloat( (float)yAcceleration);
       dos.writeFloat( (float)zAcceleration);
       dos.writeFloat( (float)xAngularVelocity);
       dos.writeFloat( (float)yAngularVelocity);
       dos.writeFloat( (float)zAngularVelocity);

       for(int idx = 0; idx < marking.length; idx++)
       {
           dos.writeByte(marking[idx]);
       } // end of array marshaling

       dos.writeInt( (int)capabilities);

       for(int idx = 0; idx < articulationParameters.size(); idx++)
       {
            ArticulationParameter aArticulationParameter = (ArticulationParameter)articulationParameters.get(idx);
            aArticulationParameter.marshal(dos);
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
       site = (int)dis.readUnsignedShort();
       application = (int)dis.readUnsignedShort();
       entity = (int)dis.readUnsignedShort();
       forceId = (short)dis.readUnsignedByte();
       numberOfArticulationParameters = dis.readByte();
       entityKind = (short)dis.readUnsignedByte();
       domain = (short)dis.readUnsignedByte();
       country = (int)dis.readUnsignedShort();
       category = (short)dis.readUnsignedByte();
       subcategory = (short)dis.readUnsignedByte();
       specific = (short)dis.readUnsignedByte();
       extra = (short)dis.readUnsignedByte();
       altEntityKind = (short)dis.readUnsignedByte();
       altDomain = (short)dis.readUnsignedByte();
       altCountry = (int)dis.readUnsignedShort();
       altCategory = (short)dis.readUnsignedByte();
       altSubcategory = (short)dis.readUnsignedByte();
       altSpecific = (short)dis.readUnsignedByte();
       altExtra = (short)dis.readUnsignedByte();
       xVelocity = dis.readFloat();
       yVelocity = dis.readFloat();
       zVelocity = dis.readFloat();
       xLocation = dis.readFloat();
       yLocation = dis.readFloat();
       zLocation = dis.readFloat();
       psi = dis.readFloat();
       theta = dis.readFloat();
       phi = dis.readFloat();
       entityAppearance = dis.readInt();
       deadReckoningAlgorithm = (short)dis.readUnsignedByte();
       for(int idx = 0; idx < otherParameters.length; idx++)
       {
                otherParameters[idx] = dis.readByte();
       } // end of array unmarshaling
       xAcceleration = dis.readFloat();
       yAcceleration = dis.readFloat();
       zAcceleration = dis.readFloat();
       xAngularVelocity = dis.readFloat();
       yAngularVelocity = dis.readFloat();
       zAngularVelocity = dis.readFloat();
       for(int idx = 0; idx < marking.length; idx++)
       {
                marking[idx] = dis.readByte();
       } // end of array unmarshaling
       capabilities = dis.readInt();
        for(int idx = 0; idx < numberOfArticulationParameters; idx++)
        {
           ArticulationParameter anX = new ArticulationParameter();
            anX.unmarshal(dis);
            articulationParameters.add(anX);
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
 public boolean equals(FastEntityStatePdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (site == rhs.site)) ivarsEqual = false;
     if( ! (application == rhs.application)) ivarsEqual = false;
     if( ! (entity == rhs.entity)) ivarsEqual = false;
     if( ! (forceId == rhs.forceId)) ivarsEqual = false;
     if( ! (numberOfArticulationParameters == rhs.numberOfArticulationParameters)) ivarsEqual = false;
     if( ! (entityKind == rhs.entityKind)) ivarsEqual = false;
     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (country == rhs.country)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subcategory == rhs.subcategory)) ivarsEqual = false;
     if( ! (specific == rhs.specific)) ivarsEqual = false;
     if( ! (extra == rhs.extra)) ivarsEqual = false;
     if( ! (altEntityKind == rhs.altEntityKind)) ivarsEqual = false;
     if( ! (altDomain == rhs.altDomain)) ivarsEqual = false;
     if( ! (altCountry == rhs.altCountry)) ivarsEqual = false;
     if( ! (altCategory == rhs.altCategory)) ivarsEqual = false;
     if( ! (altSubcategory == rhs.altSubcategory)) ivarsEqual = false;
     if( ! (altSpecific == rhs.altSpecific)) ivarsEqual = false;
     if( ! (altExtra == rhs.altExtra)) ivarsEqual = false;
     if( ! (xVelocity == rhs.xVelocity)) ivarsEqual = false;
     if( ! (yVelocity == rhs.yVelocity)) ivarsEqual = false;
     if( ! (zVelocity == rhs.zVelocity)) ivarsEqual = false;
     if( ! (xLocation == rhs.xLocation)) ivarsEqual = false;
     if( ! (yLocation == rhs.yLocation)) ivarsEqual = false;
     if( ! (zLocation == rhs.zLocation)) ivarsEqual = false;
     if( ! (psi == rhs.psi)) ivarsEqual = false;
     if( ! (theta == rhs.theta)) ivarsEqual = false;
     if( ! (phi == rhs.phi)) ivarsEqual = false;
     if( ! (entityAppearance == rhs.entityAppearance)) ivarsEqual = false;
     if( ! (deadReckoningAlgorithm == rhs.deadReckoningAlgorithm)) ivarsEqual = false;

     for(int idx = 0; idx < 15; idx++)
     {
          if(!(otherParameters[idx] == rhs.otherParameters[idx])) ivarsEqual = false;
     }

     if( ! (xAcceleration == rhs.xAcceleration)) ivarsEqual = false;
     if( ! (yAcceleration == rhs.yAcceleration)) ivarsEqual = false;
     if( ! (zAcceleration == rhs.zAcceleration)) ivarsEqual = false;
     if( ! (xAngularVelocity == rhs.xAngularVelocity)) ivarsEqual = false;
     if( ! (yAngularVelocity == rhs.yAngularVelocity)) ivarsEqual = false;
     if( ! (zAngularVelocity == rhs.zAngularVelocity)) ivarsEqual = false;

     for(int idx = 0; idx < 12; idx++)
     {
          if(!(marking[idx] == rhs.marking[idx])) ivarsEqual = false;
     }

     if( ! (capabilities == rhs.capabilities)) ivarsEqual = false;

     for(int idx = 0; idx < articulationParameters.size(); idx++)
     {
        ArticulationParameter x = (ArticulationParameter)articulationParameters.get(idx);
        if( ! ( articulationParameters.get(idx).equals(rhs.articulationParameters.get(idx)))) ivarsEqual = false;
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
