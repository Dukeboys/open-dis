#include <DIS/DistributedEmissionsPdu.h> 

using namespace DIS;


DistributedEmissionsPdu::DistributedEmissionsPdu() : Pdu()

{
    setProtocolFamily( 6 );
}

DistributedEmissionsPdu::~DistributedEmissionsPdu()
{
}

void DistributedEmissionsPdu::marshal(DataStream& dataStream) const
{
    Pdu::marshal(dataStream); // Marshal information in superclass first
}

void DistributedEmissionsPdu::unmarshal(DataStream& dataStream)
{
    Pdu::unmarshal(dataStream); // unmarshal information in superclass first
}


bool DistributedEmissionsPdu::operator ==(const DistributedEmissionsPdu& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = Pdu::operator==(rhs);


    return ivarsEqual;
 }

int DistributedEmissionsPdu::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = Pdu::getMarshalledSize();
    return marshalSize;
}

