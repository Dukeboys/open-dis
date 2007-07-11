#include <DIS/ElectronicEmmisionsPdu.h> 

using namespace DIS;


ElectronicEmmisionsPdu::ElectronicEmmisionsPdu() : DistributedEmissionsPdu(),
   _emittingEntityID(), 
   _eventID(), 
   _stateUpdateIndicator(0), 
   _numberOfSystems(0)
{
    setPduType( 23 );
}

ElectronicEmmisionsPdu::~ElectronicEmmisionsPdu()
{
    _systems.clear();
}

EntityID& ElectronicEmmisionsPdu::getEmittingEntityID() 
{
    return _emittingEntityID;
}

const EntityID& ElectronicEmmisionsPdu::getEmittingEntityID() const
{
    return _emittingEntityID;
}

void ElectronicEmmisionsPdu::setEmittingEntityID(const EntityID &pX)
{
    _emittingEntityID = pX;
}

EventID& ElectronicEmmisionsPdu::getEventID() 
{
    return _eventID;
}

const EventID& ElectronicEmmisionsPdu::getEventID() const
{
    return _eventID;
}

void ElectronicEmmisionsPdu::setEventID(const EventID &pX)
{
    _eventID = pX;
}

unsigned char ElectronicEmmisionsPdu::getStateUpdateIndicator() const
{
    return _stateUpdateIndicator;
}

void ElectronicEmmisionsPdu::setStateUpdateIndicator(unsigned char pX)
{
    _stateUpdateIndicator = pX;
}

unsigned char ElectronicEmmisionsPdu::getNumberOfSystems() const
{
   return _systems.size();
}

std::vector<ElectronicEmissionSystemData>& ElectronicEmmisionsPdu::getSystems() 
{
    return _systems;
}

const std::vector<ElectronicEmissionSystemData>& ElectronicEmmisionsPdu::getSystems() const
{
    return _systems;
}

void ElectronicEmmisionsPdu::setSystems(const std::vector<ElectronicEmissionSystemData>& pX)
{
     _systems = pX;
}

void ElectronicEmmisionsPdu::marshal(DataStream& dataStream) const
{
    DistributedEmissionsPdu::marshal(dataStream); // Marshal information in superclass first
    _emittingEntityID.marshal(dataStream);
    _eventID.marshal(dataStream);
    dataStream << _stateUpdateIndicator;
    dataStream << ( unsigned char )_systems.size();

     for(size_t idx = 0; idx < _systems.size(); idx++)
     {
        ElectronicEmissionSystemData x = _systems[idx];
        x.marshal(dataStream);
     }

}

void ElectronicEmmisionsPdu::unmarshal(DataStream& dataStream)
{
    DistributedEmissionsPdu::unmarshal(dataStream); // unmarshal information in superclass first
    _emittingEntityID.unmarshal(dataStream);
    _eventID.unmarshal(dataStream);
    dataStream >> _stateUpdateIndicator;
    dataStream >> _numberOfSystems;

     _systems.clear();
     for(size_t idx = 0; idx < _numberOfSystems; idx++)
     {
        ElectronicEmissionSystemData x;
        x.unmarshal(dataStream);
        _systems.push_back(x);
     }
}


bool ElectronicEmmisionsPdu::operator ==(const ElectronicEmmisionsPdu& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = DistributedEmissionsPdu::operator==(rhs);

     if( ! (_emittingEntityID == rhs._emittingEntityID) ) ivarsEqual = false;
     if( ! (_eventID == rhs._eventID) ) ivarsEqual = false;
     if( ! (_stateUpdateIndicator == rhs._stateUpdateIndicator) ) ivarsEqual = false;

     for(size_t idx = 0; idx < _systems.size(); idx++)
     {
        if( ! ( _systems[idx] == rhs._systems[idx]) ) ivarsEqual = false;
     }


    return ivarsEqual;
 }

int ElectronicEmmisionsPdu::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = DistributedEmissionsPdu::getMarshalledSize();
   marshalSize = marshalSize + _emittingEntityID.getMarshalledSize();  // _emittingEntityID
   marshalSize = marshalSize + _eventID.getMarshalledSize();  // _eventID
   marshalSize = marshalSize + 1;  // _stateUpdateIndicator
   marshalSize = marshalSize + 1;  // _numberOfSystems

   for(int idx=0; idx < _systems.size(); idx++)
   {
        ElectronicEmissionSystemData listElement = _systems[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
    }

    return marshalSize;
}

