package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.7.5. SEES PDU, supplemental emissions entity state information. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class SeesPdu extends DistributedEmissionsFamilyPdu implements Serializable
{
   /** Originating entity ID */
   protected EntityID  orginatingEntityID = new EntityID(); 

   /** IR Signature representation index */
   protected int  infraredSignatureRepresentationIndex;

   /** acoustic Signature representation index */
   protected int  acousticSignatureRepresentationIndex;

   /** radar cross section representation index */
   protected int  radarCrossSectionSignatureRepresentationIndex;

   /** how many propulsion systems */
   protected int  numberOfPropulsionSystems;

   /** how many vectoring nozzle systems */
   protected int  numberOfVectoringNozzleSystems;

   /** variable length list of propulsion system data */
   protected List propulsionSystemData = new ArrayList(); 
   /** variable length list of vectoring system data */
   protected List vectoringSystemData = new ArrayList(); 

/** Constructor */
 public SeesPdu()
 {
    setPduType( (short)30 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + orginatingEntityID.getMarshalledSize();  // orginatingEntityID
   marshalSize = marshalSize + 2;  // infraredSignatureRepresentationIndex
   marshalSize = marshalSize + 2;  // acousticSignatureRepresentationIndex
   marshalSize = marshalSize + 2;  // radarCrossSectionSignatureRepresentationIndex
   marshalSize = marshalSize + 2;  // numberOfPropulsionSystems
   marshalSize = marshalSize + 2;  // numberOfVectoringNozzleSystems
   for(int idx=0; idx < propulsionSystemData.size(); idx++)
   {
        PropulsionSystemData listElement = (PropulsionSystemData)propulsionSystemData.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < vectoringSystemData.size(); idx++)
   {
        VectoringNozzleSystemData listElement = (VectoringNozzleSystemData)vectoringSystemData.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setOrginatingEntityID(EntityID pOrginatingEntityID)
{ orginatingEntityID = pOrginatingEntityID;
}

@XmlElement
public EntityID getOrginatingEntityID()
{ return orginatingEntityID; 
}

public void setInfraredSignatureRepresentationIndex(int pInfraredSignatureRepresentationIndex)
{ infraredSignatureRepresentationIndex = pInfraredSignatureRepresentationIndex;
}

@XmlAttribute
public int getInfraredSignatureRepresentationIndex()
{ return infraredSignatureRepresentationIndex; 
}

public void setAcousticSignatureRepresentationIndex(int pAcousticSignatureRepresentationIndex)
{ acousticSignatureRepresentationIndex = pAcousticSignatureRepresentationIndex;
}

@XmlAttribute
public int getAcousticSignatureRepresentationIndex()
{ return acousticSignatureRepresentationIndex; 
}

public void setRadarCrossSectionSignatureRepresentationIndex(int pRadarCrossSectionSignatureRepresentationIndex)
{ radarCrossSectionSignatureRepresentationIndex = pRadarCrossSectionSignatureRepresentationIndex;
}

@XmlAttribute
public int getRadarCrossSectionSignatureRepresentationIndex()
{ return radarCrossSectionSignatureRepresentationIndex; 
}

@XmlAttribute
public int getNumberOfPropulsionSystems()
{ return (int)propulsionSystemData.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfPropulsionSystems method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfPropulsionSystems(int pNumberOfPropulsionSystems)
{ numberOfPropulsionSystems = pNumberOfPropulsionSystems;
}

@XmlAttribute
public int getNumberOfVectoringNozzleSystems()
{ return (int)vectoringSystemData.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfVectoringNozzleSystems method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfVectoringNozzleSystems(int pNumberOfVectoringNozzleSystems)
{ numberOfVectoringNozzleSystems = pNumberOfVectoringNozzleSystems;
}

public void setPropulsionSystemData(List pPropulsionSystemData)
{ propulsionSystemData = pPropulsionSystemData;
}

@XmlElementWrapper(name="propulsionSystemDataList" )
public List getPropulsionSystemData()
{ return propulsionSystemData; }

public void setVectoringSystemData(List pVectoringSystemData)
{ vectoringSystemData = pVectoringSystemData;
}

@XmlElementWrapper(name="vectoringSystemDataList" )
public List getVectoringSystemData()
{ return vectoringSystemData; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       orginatingEntityID.marshal(dos);
       dos.writeShort( (short)infraredSignatureRepresentationIndex);
       dos.writeShort( (short)acousticSignatureRepresentationIndex);
       dos.writeShort( (short)radarCrossSectionSignatureRepresentationIndex);
       dos.writeShort( (short)propulsionSystemData.size());
       dos.writeShort( (short)vectoringSystemData.size());

       for(int idx = 0; idx < propulsionSystemData.size(); idx++)
       {
            PropulsionSystemData aPropulsionSystemData = (PropulsionSystemData)propulsionSystemData.get(idx);
            aPropulsionSystemData.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < vectoringSystemData.size(); idx++)
       {
            VectoringNozzleSystemData aVectoringNozzleSystemData = (VectoringNozzleSystemData)vectoringSystemData.get(idx);
            aVectoringNozzleSystemData.marshal(dos);
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
       orginatingEntityID.unmarshal(dis);
       infraredSignatureRepresentationIndex = (int)dis.readUnsignedShort();
       acousticSignatureRepresentationIndex = (int)dis.readUnsignedShort();
       radarCrossSectionSignatureRepresentationIndex = (int)dis.readUnsignedShort();
       numberOfPropulsionSystems = (int)dis.readUnsignedShort();
       numberOfVectoringNozzleSystems = (int)dis.readUnsignedShort();
        for(int idx = 0; idx < numberOfPropulsionSystems; idx++)
        {
           PropulsionSystemData anX = new PropulsionSystemData();
            anX.unmarshal(dis);
            propulsionSystemData.add(anX);
        };

        for(int idx = 0; idx < numberOfVectoringNozzleSystems; idx++)
        {
           VectoringNozzleSystemData anX = new VectoringNozzleSystemData();
            anX.unmarshal(dis);
            vectoringSystemData.add(anX);
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
 public boolean equals(SeesPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (orginatingEntityID.equals( rhs.orginatingEntityID) )) ivarsEqual = false;
     if( ! (infraredSignatureRepresentationIndex == rhs.infraredSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (acousticSignatureRepresentationIndex == rhs.acousticSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (radarCrossSectionSignatureRepresentationIndex == rhs.radarCrossSectionSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (numberOfPropulsionSystems == rhs.numberOfPropulsionSystems)) ivarsEqual = false;
     if( ! (numberOfVectoringNozzleSystems == rhs.numberOfVectoringNozzleSystems)) ivarsEqual = false;

     for(int idx = 0; idx < propulsionSystemData.size(); idx++)
     {
        PropulsionSystemData x = (PropulsionSystemData)propulsionSystemData.get(idx);
        if( ! ( propulsionSystemData.get(idx).equals(rhs.propulsionSystemData.get(idx)))) ivarsEqual = false;
     }


     for(int idx = 0; idx < vectoringSystemData.size(); idx++)
     {
        VectoringNozzleSystemData x = (VectoringNozzleSystemData)vectoringSystemData.get(idx);
        if( ! ( vectoringSystemData.get(idx).equals(rhs.vectoringSystemData.get(idx)))) ivarsEqual = false;
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
