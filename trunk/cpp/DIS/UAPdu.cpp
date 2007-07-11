#include <DIS/UAPdu.h> 

using namespace DIS;


UAPdu::UAPdu() : DistributedEmissionsPdu(),
   _emittingEntityID(), 
   _eventID(), 
   _stateChangeIndicator(0), 
   _pad(0), 
   _passiveParameterIndex(0), 
   _propulsionPlantConfiguration(0), 
   _numberOfShafts(0), 
   _numberOfAPAs(0), 
   _numberOfUAEmitterSystems(0)
{
    setPduType( 29 );
}

UAPdu::~UAPdu()
{
    _shaftRPMs.clear();
    _apaData.clear();
    _emitterSystems.clear();
}

EntityID& UAPdu::getEmittingEntityID() 
{
    return _emittingEntityID;
}

const EntityID& UAPdu::getEmittingEntityID() const
{
    return _emittingEntityID;
}

void UAPdu::setEmittingEntityID(const EntityID &pX)
{
    _emittingEntityID = pX;
}

EventID& UAPdu::getEventID() 
{
    return _eventID;
}

const EventID& UAPdu::getEventID() const
{
    return _eventID;
}

void UAPdu::setEventID(const EventID &pX)
{
    _eventID = pX;
}

char UAPdu::getStateChangeIndicator() const
{
    return _stateChangeIndicator;
}

void UAPdu::setStateChangeIndicator(char pX)
{
    _stateChangeIndicator = pX;
}

char UAPdu::getPad() const
{
    return _pad;
}

void UAPdu::setPad(char pX)
{
    _pad = pX;
}

unsigned short UAPdu::getPassiveParameterIndex() const
{
    return _passiveParameterIndex;
}

void UAPdu::setPassiveParameterIndex(unsigned short pX)
{
    _passiveParameterIndex = pX;
}

unsigned char UAPdu::getPropulsionPlantConfiguration() const
{
    return _propulsionPlantConfiguration;
}

void UAPdu::setPropulsionPlantConfiguration(unsigned char pX)
{
    _propulsionPlantConfiguration = pX;
}

unsigned char UAPdu::getNumberOfShafts() const
{
   return _shaftRPMs.size();
}

unsigned char UAPdu::getNumberOfAPAs() const
{
   return _apaData.size();
}

unsigned char UAPdu::getNumberOfUAEmitterSystems() const
{
   return _emitterSystems.size();
}

std::vector<ShaftRPMs>& UAPdu::getShaftRPMs() 
{
    return _shaftRPMs;
}

const std::vector<ShaftRPMs>& UAPdu::getShaftRPMs() const
{
    return _shaftRPMs;
}

void UAPdu::setShaftRPMs(const std::vector<ShaftRPMs>& pX)
{
     _shaftRPMs = pX;
}

std::vector<APAData>& UAPdu::getApaData() 
{
    return _apaData;
}

const std::vector<APAData>& UAPdu::getApaData() const
{
    return _apaData;
}

void UAPdu::setApaData(const std::vector<APAData>& pX)
{
     _apaData = pX;
}

std::vector<AcousticEmitterSystemData>& UAPdu::getEmitterSystems() 
{
    return _emitterSystems;
}

const std::vector<AcousticEmitterSystemData>& UAPdu::getEmitterSystems() const
{
    return _emitterSystems;
}

void UAPdu::setEmitterSystems(const std::vector<AcousticEmitterSystemData>& pX)
{
     _emitterSystems = pX;
}

void UAPdu::marshal(DataStream& dataStream) const
{
    DistributedEmissionsPdu::marshal(dataStream); // Marshal information in superclass first
    _emittingEntityID.marshal(dataStream);
    _eventID.marshal(dataStream);
    dataStream << _stateChangeIndicator;
    dataStream << _pad;
    dataStream << _passiveParameterIndex;
    dataStream << _propulsionPlantConfiguration;
    dataStream << ( unsigned char )_shaftRPMs.size();
    dataStream << ( unsigned char )_apaData.size();
    dataStream << ( unsigned char )_emitterSystems.size();

     for(size_t idx = 0; idx < _shaftRPMs.size(); idx++)
     {
        ShaftRPMs x = _shaftRPMs[idx];
        x.marshal(dataStream);
     }


     for(size_t idx = 0; idx < _apaData.size(); idx++)
     {
        APAData x = _apaData[idx];
        x.marshal(dataStream);
     }


     for(size_t idx = 0; idx < _emitterSystems.size(); idx++)
     {
        AcousticEmitterSystemData x = _emitterSystems[idx];
        x.marshal(dataStream);
     }

}

void UAPdu::unmarshal(DataStream& dataStream)
{
    DistributedEmissionsPdu::unmarshal(dataStream); // unmarshal information in superclass first
    _emittingEntityID.unmarshal(dataStream);
    _eventID.unmarshal(dataStream);
    dataStream >> _stateChangeIndicator;
    dataStream >> _pad;
    dataStream >> _passiveParameterIndex;
    dataStream >> _propulsionPlantConfiguration;
    dataStream >> _numberOfShafts;
    dataStream >> _numberOfAPAs;
    dataStream >> _numberOfUAEmitterSystems;

     _shaftRPMs.clear();
     for(size_t idx = 0; idx < _numberOfShafts; idx++)
     {
        ShaftRPMs x;
        x.unmarshal(dataStream);
        _shaftRPMs.push_back(x);
     }

     _apaData.clear();
     for(size_t idx = 0; idx < _numberOfAPAs; idx++)
     {
        APAData x;
        x.unmarshal(dataStream);
        _apaData.push_back(x);
     }

     _emitterSystems.clear();
     for(size_t idx = 0; idx < _numberOfUAEmitterSystems; idx++)
     {
        AcousticEmitterSystemData x;
        x.unmarshal(dataStream);
        _emitterSystems.push_back(x);
     }
}


bool UAPdu::operator ==(const UAPdu& rhs) const
 {
     bool ivarsEqual = true;

     ivarsEqual = DistributedEmissionsPdu::operator==(rhs);

     if( ! (_emittingEntityID == rhs._emittingEntityID) ) ivarsEqual = false;
     if( ! (_eventID == rhs._eventID) ) ivarsEqual = false;
     if( ! (_stateChangeIndicator == rhs._stateChangeIndicator) ) ivarsEqual = false;
     if( ! (_pad == rhs._pad) ) ivarsEqual = false;
     if( ! (_passiveParameterIndex == rhs._passiveParameterIndex) ) ivarsEqual = false;
     if( ! (_propulsionPlantConfiguration == rhs._propulsionPlantConfiguration) ) ivarsEqual = false;

     for(size_t idx = 0; idx < _shaftRPMs.size(); idx++)
     {
        if( ! ( _shaftRPMs[idx] == rhs._shaftRPMs[idx]) ) ivarsEqual = false;
     }


     for(size_t idx = 0; idx < _apaData.size(); idx++)
     {
        if( ! ( _apaData[idx] == rhs._apaData[idx]) ) ivarsEqual = false;
     }


     for(size_t idx = 0; idx < _emitterSystems.size(); idx++)
     {
        if( ! ( _emitterSystems[idx] == rhs._emitterSystems[idx]) ) ivarsEqual = false;
     }


    return ivarsEqual;
 }

int UAPdu::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = DistributedEmissionsPdu::getMarshalledSize();
   marshalSize = marshalSize + _emittingEntityID.getMarshalledSize();  // _emittingEntityID
   marshalSize = marshalSize + _eventID.getMarshalledSize();  // _eventID
   marshalSize = marshalSize + 1;  // _stateChangeIndicator
   marshalSize = marshalSize + 1;  // _pad
   marshalSize = marshalSize + 2;  // _passiveParameterIndex
   marshalSize = marshalSize + 1;  // _propulsionPlantConfiguration
   marshalSize = marshalSize + 1;  // _numberOfShafts
   marshalSize = marshalSize + 1;  // _numberOfAPAs
   marshalSize = marshalSize + 1;  // _numberOfUAEmitterSystems

   for(int idx=0; idx < _shaftRPMs.size(); idx++)
   {
        ShaftRPMs listElement = _shaftRPMs[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
    }


   for(int idx=0; idx < _apaData.size(); idx++)
   {
        APAData listElement = _apaData[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
    }


   for(int idx=0; idx < _emitterSystems.size(); idx++)
   {
        AcousticEmitterSystemData listElement = _emitterSystems[idx];
        marshalSize = marshalSize + listElement.getMarshalledSize();
    }

    return marshalSize;
}

