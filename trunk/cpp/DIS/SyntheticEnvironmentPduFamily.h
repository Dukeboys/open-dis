#ifndef SYNTHETICENVIRONMENTPDUFAMILY_H
#define SYNTHETICENVIRONMENTPDUFAMILY_H

#include <DIS/Pdu.h>
#include <DIS/DataStream.h>
#include <DIS/msLibMacro.h>


namespace DIS
{
// Section 5.3.11: Abstract superclass for synthetic environment PDUs

// Copyright (c) 2007, MOVES Institute, Naval Postgraduate School. All rights reserved. 
//
// This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
//
// @author DMcG, jkg

class EXPORT_MACRO SyntheticEnvironmentPduFamily : public Pdu
{
protected:

 public:
    SyntheticEnvironmentPduFamily();
    virtual ~SyntheticEnvironmentPduFamily();

    virtual void marshal(DataStream& dataStream) const;
    virtual void unmarshal(DataStream& dataStream);


virtual int getMarshalledSize() const;

     bool operator  ==(const SyntheticEnvironmentPduFamily& rhs) const;
};
}

#endif
