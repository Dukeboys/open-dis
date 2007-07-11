#include <DIS/RadioCommunicationsPdu.h> 

using namespace DIS;


RadioCommunicationsPdu::RadioCommunicationsPdu() : Pdu(),
   _entityId(), 
   _radioId(0)
{
    setProtocolFamily( 4 );
}

RadioCommunicationsPdu::~RadioCommunicationsPdu()
{
}

EntityID& RadioCommunicationsPdu::getEntityId() 
{
    return _entityId;
}

const EntityID& RadioCommunicationsPdu::getEntityId() const
{
    return _entityId;
}

void RadioCommunicationsPdu::setEntityId(const EntityID &pX)
{
    _entityId = pX;
}

unsigned short RadioCommunicationsPdu::getRadioId() const
{
    return _radioId;
}

void RadioCommunicationsPdu::setRadioId(unsigned short pX)
{
    _radioId = pX;
}

void RadioCommunicationsPdu::marshal(DataStream& dataStream) const
{
    Pdu::marshal(dataStream); // Marshal information in superclass first
    _entityId.marshal(dataStream);
    dataStream << _radioId;
}

void RadioCommunicationsPdu::unmarshal(DataStream& dataStream)
{
    Pdu::unmarshal(dataStream); // unmarshal information in superclass first
    _entityId.unmarshal(dataStream);
    dataStream >> _radioId;
}


bool RadioCommunicationsPdu::operator ==(const RadioCommunicationsPdu& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = Pdu::operator==(rhs);

     if( ! (_entityId == rhs._entityId) ) ivarsEqual = false;
     if( ! (_radioId == rhs._radioId) ) ivarsEqual = false;

    return ivarsEqual;
 }

int RadioCommunicationsPdu::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = Pdu::getMarshalledSize();
   marshalSize = marshalSize + _entityId.getMarshalledSize();  // _entityId
   marshalSize = marshalSize + 2;  // _radioId
    return marshalSize;
}

