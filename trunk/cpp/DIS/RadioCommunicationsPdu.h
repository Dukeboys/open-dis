#ifndef RADIOCOMMUNICATIONSPDU_H
#define RADIOCOMMUNICATIONSPDU_H

#include <DIS/EntityID.h>
#include <DIS/Pdu.h>
#include <DIS/DataStream.h>
#include <DIS/msLibMacro.h>


namespace DIS
{
// Section 5.3.8. Abstract superclass for radio communications PDUs.

// Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved. 
//
// This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
//
// @author DMcG, jkg

class EXPORT_MACRO RadioCommunicationsPdu : public Pdu
{
protected:
  // ID of the entitythat is the source of the communication
  EntityID _entityId; 

  // particular radio within an entity
  unsigned short _radioId; 


 public:
    RadioCommunicationsPdu();
    virtual ~RadioCommunicationsPdu();

    virtual void marshal(DataStream& dataStream) const;
    virtual void unmarshal(DataStream& dataStream);

    EntityID& getEntityId(); 
    const EntityID&  getEntityId() const; 
    void setEntityId(const EntityID    &pX);

    unsigned short getRadioId() const; 
    void setRadioId(unsigned short pX); 


virtual int getMarshalledSize() const;

     bool operator  ==(const RadioCommunicationsPdu& rhs) const;
};
}

#endif
