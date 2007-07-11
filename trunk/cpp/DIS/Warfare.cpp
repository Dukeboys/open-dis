#include <DIS/Warfare.h> 

using namespace DIS;


Warfare::Warfare() : Pdu(),
   _firingEntityID(), 
   _targetEntityID()
{
    setProtocolFamily( 2 );
}

Warfare::~Warfare()
{
}

EntityID& Warfare::getFiringEntityID() 
{
    return _firingEntityID;
}

const EntityID& Warfare::getFiringEntityID() const
{
    return _firingEntityID;
}

void Warfare::setFiringEntityID(const EntityID &pX)
{
    _firingEntityID = pX;
}

EntityID& Warfare::getTargetEntityID() 
{
    return _targetEntityID;
}

const EntityID& Warfare::getTargetEntityID() const
{
    return _targetEntityID;
}

void Warfare::setTargetEntityID(const EntityID &pX)
{
    _targetEntityID = pX;
}

void Warfare::marshal(DataStream& dataStream) const
{
    Pdu::marshal(dataStream); // Marshal information in superclass first
    _firingEntityID.marshal(dataStream);
    _targetEntityID.marshal(dataStream);
}

void Warfare::unmarshal(DataStream& dataStream)
{
    Pdu::unmarshal(dataStream); // unmarshal information in superclass first
    _firingEntityID.unmarshal(dataStream);
    _targetEntityID.unmarshal(dataStream);
}


bool Warfare::operator ==(const Warfare& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = Pdu::operator==(rhs);

     if( ! (_firingEntityID == rhs._firingEntityID) ) ivarsEqual = false;
     if( ! (_targetEntityID == rhs._targetEntityID) ) ivarsEqual = false;

    return ivarsEqual;
 }

int Warfare::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = Pdu::getMarshalledSize();
   marshalSize = marshalSize + _firingEntityID.getMarshalledSize();  // _firingEntityID
   marshalSize = marshalSize + _targetEntityID.getMarshalledSize();  // _targetEntityID
    return marshalSize;
}

