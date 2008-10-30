package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.7.3. Information about underwater acoustic emmissions. This requires manual cleanup.  The beam data records should ALL be a the finish, rather than attached to each emitter system. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class UaPdu extends DistributedEmissionsFamilyPdu implements Serializable
{
   /** ID of the entity that is the source of the emission */
   protected EntityID  emittingEntityID = new EntityID(); 

   /** ID of event */
   protected EventID  eventID = new EventID(); 

   /** This field shall be used to indicate whether the data in the UA PDU represent a state update or data that have changed since issuance of the last UA PDU */
   protected byte  stateChangeIndicator;

   /** padding */
   protected byte  pad;

   /** This field indicates which database record (or file) shall be used in the definition of passive signature (unintentional) emissions of the entity. The indicated database record (or  file) shall define all noise generated as a function of propulsion plant configurations and associated  auxiliaries. */
   protected int  passiveParameterIndex;

   /** This field shall specify the entity propulsion plant configuration. This field is used to determine the passive signature characteristics of an entity. */
   protected short  propulsionPlantConfiguration;

   /**  This field shall represent the number of shafts on a platform */
   protected short  numberOfShafts;

   /** This field shall indicate the number of APAs described in the current UA PDU */
   protected short  numberOfAPAs;

   /** This field shall specify the number of UA emitter systems being described in the current UA PDU */
   protected short  numberOfUAEmitterSystems;

   /** shaft RPM values */
   protected List shaftRPMs = new ArrayList(); 
   /** apaData */
   protected List apaData = new ArrayList(); 
   protected List emitterSystems = new ArrayList(); 

/** Constructor */
 public UaPdu()
 {
    setPduType( (short)29 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + emittingEntityID.getMarshalledSize();  // emittingEntityID
   marshalSize = marshalSize + eventID.getMarshalledSize();  // eventID
   marshalSize = marshalSize + 1;  // stateChangeIndicator
   marshalSize = marshalSize + 1;  // pad
   marshalSize = marshalSize + 2;  // passiveParameterIndex
   marshalSize = marshalSize + 1;  // propulsionPlantConfiguration
   marshalSize = marshalSize + 1;  // numberOfShafts
   marshalSize = marshalSize + 1;  // numberOfAPAs
   marshalSize = marshalSize + 1;  // numberOfUAEmitterSystems
   for(int idx=0; idx < shaftRPMs.size(); idx++)
   {
        ShaftRPMs listElement = (ShaftRPMs)shaftRPMs.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < apaData.size(); idx++)
   {
        ApaData listElement = (ApaData)apaData.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }
   for(int idx=0; idx < emitterSystems.size(); idx++)
   {
        AcousticEmitterSystemData listElement = (AcousticEmitterSystemData)emitterSystems.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEmittingEntityID(EntityID pEmittingEntityID)
{ emittingEntityID = pEmittingEntityID;
}

@XmlElement
public EntityID getEmittingEntityID()
{ return emittingEntityID; 
}

public void setEventID(EventID pEventID)
{ eventID = pEventID;
}

@XmlElement
public EventID getEventID()
{ return eventID; 
}

public void setStateChangeIndicator(byte pStateChangeIndicator)
{ stateChangeIndicator = pStateChangeIndicator;
}

@XmlAttribute
public byte getStateChangeIndicator()
{ return stateChangeIndicator; 
}

public void setPad(byte pPad)
{ pad = pPad;
}

@XmlAttribute
public byte getPad()
{ return pad; 
}

public void setPassiveParameterIndex(int pPassiveParameterIndex)
{ passiveParameterIndex = pPassiveParameterIndex;
}

@XmlAttribute
public int getPassiveParameterIndex()
{ return passiveParameterIndex; 
}

public void setPropulsionPlantConfiguration(short pPropulsionPlantConfiguration)
{ propulsionPlantConfiguration = pPropulsionPlantConfiguration;
}

@XmlAttribute
public short getPropulsionPlantConfiguration()
{ return propulsionPlantConfiguration; 
}

@XmlAttribute
public short getNumberOfShafts()
{ return (short)shaftRPMs.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfShafts method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfShafts(short pNumberOfShafts)
{ numberOfShafts = pNumberOfShafts;
}

@XmlAttribute
public short getNumberOfAPAs()
{ return (short)apaData.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfAPAs method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfAPAs(short pNumberOfAPAs)
{ numberOfAPAs = pNumberOfAPAs;
}

@XmlAttribute
public short getNumberOfUAEmitterSystems()
{ return (short)emitterSystems.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfUAEmitterSystems method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfUAEmitterSystems(short pNumberOfUAEmitterSystems)
{ numberOfUAEmitterSystems = pNumberOfUAEmitterSystems;
}

public void setShaftRPMs(List pShaftRPMs)
{ shaftRPMs = pShaftRPMs;
}

@XmlElementWrapper(name="shaftRPMsList" )
public List getShaftRPMs()
{ return shaftRPMs; }

public void setApaData(List pApaData)
{ apaData = pApaData;
}

@XmlElementWrapper(name="apaDataList" )
public List getApaData()
{ return apaData; }

public void setEmitterSystems(List pEmitterSystems)
{ emitterSystems = pEmitterSystems;
}

@XmlElementWrapper(name="emitterSystemsList" )
public List getEmitterSystems()
{ return emitterSystems; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       emittingEntityID.marshal(dos);
       eventID.marshal(dos);
       dos.writeByte( (byte)stateChangeIndicator);
       dos.writeByte( (byte)pad);
       dos.writeShort( (short)passiveParameterIndex);
       dos.writeByte( (byte)propulsionPlantConfiguration);
       dos.writeByte( (byte)shaftRPMs.size());
       dos.writeByte( (byte)apaData.size());
       dos.writeByte( (byte)emitterSystems.size());

       for(int idx = 0; idx < shaftRPMs.size(); idx++)
       {
            ShaftRPMs aShaftRPMs = (ShaftRPMs)shaftRPMs.get(idx);
            aShaftRPMs.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < apaData.size(); idx++)
       {
            ApaData aApaData = (ApaData)apaData.get(idx);
            aApaData.marshal(dos);
       } // end of list marshalling


       for(int idx = 0; idx < emitterSystems.size(); idx++)
       {
            AcousticEmitterSystemData aAcousticEmitterSystemData = (AcousticEmitterSystemData)emitterSystems.get(idx);
            aAcousticEmitterSystemData.marshal(dos);
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
       emittingEntityID.unmarshal(dis);
       eventID.unmarshal(dis);
       stateChangeIndicator = dis.readByte();
       pad = dis.readByte();
       passiveParameterIndex = (int)dis.readUnsignedShort();
       propulsionPlantConfiguration = (short)dis.readUnsignedByte();
       numberOfShafts = (short)dis.readUnsignedByte();
       numberOfAPAs = (short)dis.readUnsignedByte();
       numberOfUAEmitterSystems = (short)dis.readUnsignedByte();
        for(int idx = 0; idx < numberOfShafts; idx++)
        {
           ShaftRPMs anX = new ShaftRPMs();
            anX.unmarshal(dis);
            shaftRPMs.add(anX);
        };

        for(int idx = 0; idx < numberOfAPAs; idx++)
        {
           ApaData anX = new ApaData();
            anX.unmarshal(dis);
            apaData.add(anX);
        };

        for(int idx = 0; idx < numberOfUAEmitterSystems; idx++)
        {
           AcousticEmitterSystemData anX = new AcousticEmitterSystemData();
            anX.unmarshal(dis);
            emitterSystems.add(anX);
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
 public boolean equals(UaPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (emittingEntityID.equals( rhs.emittingEntityID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (stateChangeIndicator == rhs.stateChangeIndicator)) ivarsEqual = false;
     if( ! (pad == rhs.pad)) ivarsEqual = false;
     if( ! (passiveParameterIndex == rhs.passiveParameterIndex)) ivarsEqual = false;
     if( ! (propulsionPlantConfiguration == rhs.propulsionPlantConfiguration)) ivarsEqual = false;
     if( ! (numberOfShafts == rhs.numberOfShafts)) ivarsEqual = false;
     if( ! (numberOfAPAs == rhs.numberOfAPAs)) ivarsEqual = false;
     if( ! (numberOfUAEmitterSystems == rhs.numberOfUAEmitterSystems)) ivarsEqual = false;

     for(int idx = 0; idx < shaftRPMs.size(); idx++)
     {
        ShaftRPMs x = (ShaftRPMs)shaftRPMs.get(idx);
        if( ! ( shaftRPMs.get(idx).equals(rhs.shaftRPMs.get(idx)))) ivarsEqual = false;
     }


     for(int idx = 0; idx < apaData.size(); idx++)
     {
        ApaData x = (ApaData)apaData.get(idx);
        if( ! ( apaData.get(idx).equals(rhs.apaData.get(idx)))) ivarsEqual = false;
     }


     for(int idx = 0; idx < emitterSystems.size(); idx++)
     {
        AcousticEmitterSystemData x = (AcousticEmitterSystemData)emitterSystems.get(idx);
        if( ! ( emitterSystems.get(idx).equals(rhs.emitterSystems.get(idx)))) ivarsEqual = false;
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
