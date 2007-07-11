#include <DIS/SyntheticEnvironmentPduFamily.h> 

using namespace DIS;


SyntheticEnvironmentPduFamily::SyntheticEnvironmentPduFamily() : Pdu()

{
    setProtocolFamily( 9 );
}

SyntheticEnvironmentPduFamily::~SyntheticEnvironmentPduFamily()
{
}

void SyntheticEnvironmentPduFamily::marshal(DataStream& dataStream) const
{
    Pdu::marshal(dataStream); // Marshal information in superclass first
}

void SyntheticEnvironmentPduFamily::unmarshal(DataStream& dataStream)
{
    Pdu::unmarshal(dataStream); // unmarshal information in superclass first
}


bool SyntheticEnvironmentPduFamily::operator ==(const SyntheticEnvironmentPduFamily& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = Pdu::operator==(rhs);


    return ivarsEqual;
 }

int SyntheticEnvironmentPduFamily::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = Pdu::getMarshalledSize();
    return marshalSize;
}

