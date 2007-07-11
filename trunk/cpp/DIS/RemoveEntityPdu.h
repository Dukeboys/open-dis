#ifndef REMOVEENTITYPDU_H
#define REMOVEENTITYPDU_H

#include <DIS/SimulationManagementPdu.h>
#include <DIS/DataStream.h>
#include <DIS/msLibMacro.h>


namespace DIS
{
// Section 5.3.6.2. Remove an entity. COMPLETE

// Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved. 
//
// This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
//
// @author DMcG, jkg

class EXPORT_MACRO RemoveEntityPdu : public SimulationManagementPdu
{
protected:
  // Identifier for the request
  unsigned int _requestID; 


 public:
    RemoveEntityPdu();
    virtual ~RemoveEntityPdu();

    virtual void marshal(DataStream& dataStream) const;
    virtual void unmarshal(DataStream& dataStream);

    unsigned int getRequestID() const; 
    void setRequestID(unsigned int pX); 


virtual int getMarshalledSize() const;

     bool operator  ==(const RemoveEntityPdu& rhs) const;
};
}

#endif
