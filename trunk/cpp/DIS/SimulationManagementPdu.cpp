#include <DIS/SimulationManagementPdu.h> 

using namespace DIS;


SimulationManagementPdu::SimulationManagementPdu() : Pdu(),
   _originatingEntityID(), 
   _receivingEntityID()
{
    setProtocolFamily( 5 );
}

SimulationManagementPdu::~SimulationManagementPdu()
{
}

EntityID& SimulationManagementPdu::getOriginatingEntityID() 
{
    return _originatingEntityID;
}

const EntityID& SimulationManagementPdu::getOriginatingEntityID() const
{
    return _originatingEntityID;
}

void SimulationManagementPdu::setOriginatingEntityID(const EntityID &pX)
{
    _originatingEntityID = pX;
}

EntityID& SimulationManagementPdu::getReceivingEntityID() 
{
    return _receivingEntityID;
}

const EntityID& SimulationManagementPdu::getReceivingEntityID() const
{
    return _receivingEntityID;
}

void SimulationManagementPdu::setReceivingEntityID(const EntityID &pX)
{
    _receivingEntityID = pX;
}

void SimulationManagementPdu::marshal(DataStream& dataStream) const
{
    Pdu::marshal(dataStream); // Marshal information in superclass first
    _originatingEntityID.marshal(dataStream);
    _receivingEntityID.marshal(dataStream);
}

void SimulationManagementPdu::unmarshal(DataStream& dataStream)
{
    Pdu::unmarshal(dataStream); // unmarshal information in superclass first
    _originatingEntityID.unmarshal(dataStream);
    _receivingEntityID.unmarshal(dataStream);
}


bool SimulationManagementPdu::operator ==(const SimulationManagementPdu& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = Pdu::operator==(rhs);

     if( ! (_originatingEntityID == rhs._originatingEntityID) ) ivarsEqual = false;
     if( ! (_receivingEntityID == rhs._receivingEntityID) ) ivarsEqual = false;

    return ivarsEqual;
 }

int SimulationManagementPdu::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = Pdu::getMarshalledSize();
   marshalSize = marshalSize + _originatingEntityID.getMarshalledSize();  // _originatingEntityID
   marshalSize = marshalSize + _receivingEntityID.getMarshalledSize();  // _receivingEntityID
    return marshalSize;
}

