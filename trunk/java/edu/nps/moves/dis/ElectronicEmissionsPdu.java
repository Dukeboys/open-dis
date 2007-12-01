package edu.nps.moves.dis;

import java.util.*;
import java.io.*;

/**
 * Section 5.3.7.1. Information about active electronic warfare (EW) emissions and active EW countermeasures shall be communicated using an Electromagnetic Emission PDU. COMPLETE (I think)
 *
 * Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ElectronicEmissionsPdu extends DistributedEmissionsPdu
{
   /** ID of the entity emitting */
   protected EntityID  emittingEntityID = new EntityID(); 

   /** ID of event */
   protected EventID  eventID = new EventID(); 

   /** This field shall be used to indicate if the data in the PDU represents a state update or just data that has changed since issuance of the last Electromagnetic Emission PDU [relative to the identified entity and emission system(s)]. */
   protected short  stateUpdateIndicator;

   /** This field shall specify the number of emission systems being described in the current PDU. */
   protected short  numberOfSystems;

   /** Electronic emmissions systems */
   protected List systems = new ArrayList(); 

/** Constructor */
 public ElectronicEmissionsPdu()
 {
    setPduType( (short)23 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + emittingEntityID.getMarshalledSize();  // emittingEntityID
   marshalSize = marshalSize + eventID.getMarshalledSize();  // eventID
   marshalSize = marshalSize + 1;  // stateUpdateIndicator
   marshalSize = marshalSize + 1;  // numberOfSystems
   for(int idx=0; idx < systems.size(); idx++)
   {
        ElectronicEmissionSystemData listElement = (ElectronicEmissionSystemData)systems.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setEmittingEntityID(EntityID pEmittingEntityID)
{ emittingEntityID = pEmittingEntityID;
}

public EntityID getEmittingEntityID()
{ return emittingEntityID; }

public void setEventID(EventID pEventID)
{ eventID = pEventID;
}

public EventID getEventID()
{ return eventID; }

public void setStateUpdateIndicator(short pStateUpdateIndicator)
{ stateUpdateIndicator = pStateUpdateIndicator;
}

public short getStateUpdateIndicator()
{ return stateUpdateIndicator; 
}

public short getNumberOfSystems()
{ return (short)systems.size();
}

public void setSystems(List pSystems)
{ systems = pSystems;
}

public List getSystems()
{ return systems; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       emittingEntityID.marshal(dos);
       eventID.marshal(dos);
       dos.writeByte( (byte)stateUpdateIndicator);
       dos.writeByte( (byte)systems.size());

       for(int idx = 0; idx < systems.size(); idx++)
       {
            ElectronicEmissionSystemData aElectronicEmissionSystemData = (ElectronicEmissionSystemData)systems.get(idx);
            aElectronicEmissionSystemData.marshal(dos);
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
       stateUpdateIndicator = dis.readByte();
       numberOfSystems = dis.readByte();
        for(int idx = 0; idx < numberOfSystems; idx++)
        {
           ElectronicEmissionSystemData anX = new ElectronicEmissionSystemData();
            anX.unmarshal(dis);
            systems.add(anX);
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
 public boolean equals(ElectronicEmissionsPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (emittingEntityID.equals( rhs.emittingEntityID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (stateUpdateIndicator == rhs.stateUpdateIndicator)) ivarsEqual = false;
     if( ! (numberOfSystems == rhs.numberOfSystems)) ivarsEqual = false;

     for(int idx = 0; idx < systems.size(); idx++)
     {
        ElectronicEmissionSystemData x = (ElectronicEmissionSystemData)systems.get(idx);
        if( ! ( systems.get(idx).equals(rhs.systems.get(idx)))) ivarsEqual = false;
     }


    return ivarsEqual;
 }
} // end of class
