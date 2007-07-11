#include <DIS/CreateEntityPdu.h> 

using namespace DIS;


CreateEntityPdu::CreateEntityPdu() : SimulationManagementPdu(),
   _requestID(0)
{
    setPduType( 11 );
}

CreateEntityPdu::~CreateEntityPdu()
{
}

unsigned int CreateEntityPdu::getRequestID() const
{
    return _requestID;
}

void CreateEntityPdu::setRequestID(unsigned int pX)
{
    _requestID = pX;
}

void CreateEntityPdu::marshal(DataStream& dataStream) const
{
    SimulationManagementPdu::marshal(dataStream); // Marshal information in superclass first
    dataStream << _requestID;
}

void CreateEntityPdu::unmarshal(DataStream& dataStream)
{
    SimulationManagementPdu::unmarshal(dataStream); // unmarshal information in superclass first
    dataStream >> _requestID;
}


bool CreateEntityPdu::operator ==(const CreateEntityPdu& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = SimulationManagementPdu::operator==(rhs);

     if( ! (_requestID == rhs._requestID) ) ivarsEqual = false;

    return ivarsEqual;
 }

int CreateEntityPdu::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = SimulationManagementPdu::getMarshalledSize();
   marshalSize = marshalSize + 4;  // _requestID
    return marshalSize;
}

