package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Each entity in a given DIS simulation application shall be given an entity identifier number unique to all  other entities in that application. This identifier number is valid for the duration of the exercise; however,  entity identifier numbers may be reused when all possible numbers have been exhausted. No entity shall  have an entity identifier number of NO_ENTITY, ALL_ENTITIES, or RQST_ASSIGN_ID. The entity iden-  tifier number need not be registered or retained for future exercises. The entity identifier number shall be  specified by a 16-bit unsigned integer.  An entity identifier number equal to zero with valid site and application identification shall address a  simulation application. An entity identifier number equal to ALL_ENTITIES shall mean all entities within  the specified site and application. An entity identifier number equal to RQST_ASSIGN_ID allows the  receiver of the create entity to define the entity identifier number of the new entity.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class EntityID extends Object implements Serializable
{
   /** The site ID */
   protected int  site;

   /** The application ID */
   protected int  application;

   /** the entity ID */
   protected int  entity;


/** Constructor */
 public EntityID()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = marshalSize + 2;  // site
   marshalSize = marshalSize + 2;  // application
   marshalSize = marshalSize + 2;  // entity

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


public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeShort( (short)site);
       dos.writeShort( (short)application);
       dos.writeShort( (short)entity);
    } // end try 
    catch(Exception e)
    { 
      System.out.println(e);}
    } // end of marshal method

public void unmarshal(DataInputStream dis)
{
    try 
    {
       site = (int)dis.readUnsignedShort();
       application = (int)dis.readUnsignedShort();
       entity = (int)dis.readUnsignedShort();
    } // end try 
   catch(Exception e)
    { 
      System.out.println(e); 
    }
 } // end of unmarshal method 


 /**
  * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
  */
 public boolean equals(EntityID rhs)
 {
     boolean ivarsEqual = true;

    if(rhs.getClass() != this.getClass())
        return false;

     if( ! (site == rhs.site)) ivarsEqual = false;
     if( ! (application == rhs.application)) ivarsEqual = false;
     if( ! (entity == rhs.entity)) ivarsEqual = false;

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
