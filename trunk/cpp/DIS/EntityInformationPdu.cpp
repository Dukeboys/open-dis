#include <DIS/EntityInformationPdu.h> 

using namespace DIS;


EntityInformationPdu::EntityInformationPdu() : Pdu()

{
    setProtocolFamily( 1 );
}

EntityInformationPdu::~EntityInformationPdu()
{
}

void EntityInformationPdu::marshal(DataStream& dataStream) const
{
    Pdu::marshal(dataStream); // Marshal information in superclass first
}

void EntityInformationPdu::unmarshal(DataStream& dataStream)
{
    Pdu::unmarshal(dataStream); // unmarshal information in superclass first
}


bool EntityInformationPdu::operator ==(const EntityInformationPdu& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = Pdu::operator==(rhs);


    return ivarsEqual;
 }

int EntityInformationPdu::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = Pdu::getMarshalledSize();
    return marshalSize;
}

