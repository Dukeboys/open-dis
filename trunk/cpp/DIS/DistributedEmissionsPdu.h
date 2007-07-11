#ifndef DISTRIBUTEDEMISSIONSPDU_H
#define DISTRIBUTEDEMISSIONSPDU_H

#include <DIS/Pdu.h>
#include <DIS/DataStream.h>
#include <DIS/msLibMacro.h>


namespace DIS
{
// Section 5.3.7. Electronic Emmisions. Abstract superclass for distirubted emissions PDU

// Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved. 
//
// This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
//
// @author DMcG, jkg

class EXPORT_MACRO DistributedEmissionsPdu : public Pdu
{
protected:

 public:
    DistributedEmissionsPdu();
    virtual ~DistributedEmissionsPdu();

    virtual void marshal(DataStream& dataStream) const;
    virtual void unmarshal(DataStream& dataStream);


virtual int getMarshalledSize() const;

     bool operator  ==(const DistributedEmissionsPdu& rhs) const;
};
}

#endif
