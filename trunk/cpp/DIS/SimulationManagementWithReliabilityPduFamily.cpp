#include <DIS/SimulationManagementWithReliabilityPduFamily.h> 

using namespace DIS;


SimulationManagementWithReliabilityPduFamily::SimulationManagementWithReliabilityPduFamily() : Pdu(),
   _originatingEntityID(), 
   _receivingEntityID()
{
    setProtocolFamily( 10 );
}

SimulationManagementWithReliabilityPduFamily::~SimulationManagementWithReliabilityPduFamily()
{
}

EntityID& SimulationManagementWithReliabilityPduFamily::getOriginatingEntityID() 
{
    return _originatingEntityID;
}

const EntityID& SimulationManagementWithReliabilityPduFamily::getOriginatingEntityID() const
{
    return _originatingEntityID;
}

void SimulationManagementWithReliabilityPduFamily::setOriginatingEntityID(const EntityID &pX)
{
    _originatingEntityID = pX;
}

EntityID& SimulationManagementWithReliabilityPduFamily::getReceivingEntityID() 
{
    return _receivingEntityID;
}

const EntityID& SimulationManagementWithReliabilityPduFamily::getReceivingEntityID() const
{
    return _receivingEntityID;
}

void SimulationManagementWithReliabilityPduFamily::setReceivingEntityID(const EntityID &pX)
{
    _receivingEntityID = pX;
}

void SimulationManagementWithReliabilityPduFamily::marshal(DataStream& dataStream) const
{
    Pdu::marshal(dataStream); // Marshal information in superclass first
    _originatingEntityID.marshal(dataStream);
    _receivingEntityID.marshal(dataStream);
}

void SimulationManagementWithReliabilityPduFamily::unmarshal(DataStream& dataStream)
{
    Pdu::unmarshal(dataStream); // unmarshal information in superclass first
    _originatingEntityID.unmarshal(dataStream);
    _receivingEntityID.unmarshal(dataStream);
}


bool SimulationManagementWithReliabilityPduFamily::operator ==(const SimulationManagementWithReliabilityPduFamily& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = Pdu::operator==(rhs);

     if( ! (_originatingEntityID == rhs._originatingEntityID) ) ivarsEqual = false;
     if( ! (_receivingEntityID == rhs._receivingEntityID) ) ivarsEqual = false;

    return ivarsEqual;
 }

int SimulationManagementWithReliabilityPduFamily::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = Pdu::getMarshalledSize();
   marshalSize = marshalSize + _originatingEntityID.getMarshalledSize();  // _originatingEntityID
   marshalSize = marshalSize + _receivingEntityID.getMarshalledSize();  // _receivingEntityID
    return marshalSize;
}

