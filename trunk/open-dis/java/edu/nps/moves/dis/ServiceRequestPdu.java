package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.5.1. Information about a request for supplies. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ServiceRequestPdu extends LogisticsFamilyPdu implements Serializable
{
   /** Entity that is requesting service */
   protected EntityID  requestingEntityID = new EntityID(); 

   /** Entity that is providing the service */
   protected EntityID  servicingEntityID = new EntityID(); 

   /** type of service requested */
   protected short  serviceTypeRequested;

   /** How many requested */
   protected short  numberOfSupplyTypes;

   /** padding */
   protected short  serviceRequestPadding = 0;

   protected List supplies = new ArrayList(); 

/** Constructor */
 public ServiceRequestPdu()
 {
    setPduType( (short)5 );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize = marshalSize + requestingEntityID.getMarshalledSize();  // requestingEntityID
   marshalSize = marshalSize + servicingEntityID.getMarshalledSize();  // servicingEntityID
   marshalSize = marshalSize + 1;  // serviceTypeRequested
   marshalSize = marshalSize + 1;  // numberOfSupplyTypes
   marshalSize = marshalSize + 2;  // serviceRequestPadding
   for(int idx=0; idx < supplies.size(); idx++)
   {
        SupplyQuantity listElement = (SupplyQuantity)supplies.get(idx);
        marshalSize = marshalSize + listElement.getMarshalledSize();
   }

   return marshalSize;
}


public void setRequestingEntityID(EntityID pRequestingEntityID)
{ requestingEntityID = pRequestingEntityID;
}

@XmlElement
public EntityID getRequestingEntityID()
{ return requestingEntityID; 
}

public void setServicingEntityID(EntityID pServicingEntityID)
{ servicingEntityID = pServicingEntityID;
}

@XmlElement
public EntityID getServicingEntityID()
{ return servicingEntityID; 
}

public void setServiceTypeRequested(short pServiceTypeRequested)
{ serviceTypeRequested = pServiceTypeRequested;
}

@XmlAttribute
public short getServiceTypeRequested()
{ return serviceTypeRequested; 
}

@XmlAttribute
public short getNumberOfSupplyTypes()
{ return (short)supplies.size();
}

/** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfSupplyTypes method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public void setNumberOfSupplyTypes(short pNumberOfSupplyTypes)
{ numberOfSupplyTypes = pNumberOfSupplyTypes;
}

public void setServiceRequestPadding(short pServiceRequestPadding)
{ serviceRequestPadding = pServiceRequestPadding;
}

@XmlAttribute
public short getServiceRequestPadding()
{ return serviceRequestPadding; 
}

public void setSupplies(List pSupplies)
{ supplies = pSupplies;
}

@XmlElementWrapper(name="suppliesList" )
public List getSupplies()
{ return supplies; }


public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       requestingEntityID.marshal(dos);
       servicingEntityID.marshal(dos);
       dos.writeByte( (byte)serviceTypeRequested);
       dos.writeByte( (byte)supplies.size());
       dos.writeShort( (short)serviceRequestPadding);

       for(int idx = 0; idx < supplies.size(); idx++)
       {
            SupplyQuantity aSupplyQuantity = (SupplyQuantity)supplies.get(idx);
            aSupplyQuantity.marshal(dos);
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
       requestingEntityID.unmarshal(dis);
       servicingEntityID.unmarshal(dis);
       serviceTypeRequested = (short)dis.readUnsignedByte();
       numberOfSupplyTypes = (short)dis.readUnsignedByte();
       serviceRequestPadding = dis.readShort();
        for(int idx = 0; idx < numberOfSupplyTypes; idx++)
        {
           SupplyQuantity anX = new SupplyQuantity();
            anX.unmarshal(dis);
            supplies.add(anX);
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
 public boolean equals(ServiceRequestPdu rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (servicingEntityID.equals( rhs.servicingEntityID) )) ivarsEqual = false;
     if( ! (serviceTypeRequested == rhs.serviceTypeRequested)) ivarsEqual = false;
     if( ! (numberOfSupplyTypes == rhs.numberOfSupplyTypes)) ivarsEqual = false;
     if( ! (serviceRequestPadding == rhs.serviceRequestPadding)) ivarsEqual = false;

     for(int idx = 0; idx < supplies.size(); idx++)
     {
        SupplyQuantity x = (SupplyQuantity)supplies.get(idx);
        if( ! ( supplies.get(idx).equals(rhs.supplies.get(idx)))) ivarsEqual = false;
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
