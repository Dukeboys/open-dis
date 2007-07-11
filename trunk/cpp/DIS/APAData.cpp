#include <DIS/APAData.h> 

using namespace DIS;


APAData::APAData():
   _parameterIndex(0), 
   _parameterValue(0)
{
}

APAData::~APAData()
{
}

unsigned short APAData::getParameterIndex() const
{
    return _parameterIndex;
}

void APAData::setParameterIndex(unsigned short pX)
{
    _parameterIndex = pX;
}

short APAData::getParameterValue() const
{
    return _parameterValue;
}

void APAData::setParameterValue(short pX)
{
    _parameterValue = pX;
}

void APAData::marshal(DataStream& dataStream) const
{
    dataStream << _parameterIndex;
    dataStream << _parameterValue;
}

void APAData::unmarshal(DataStream& dataStream)
{
    dataStream >> _parameterIndex;
    dataStream >> _parameterValue;
}


bool APAData::operator ==(const APAData& rhs) const
 {
     bool ivarsEqual = true;

     if( ! (_parameterIndex == rhs._parameterIndex) ) ivarsEqual = false;
     if( ! (_parameterValue == rhs._parameterValue) ) ivarsEqual = false;

    return ivarsEqual;
 }

int APAData::getMarshalledSize() const
{
   int marshalSize = 0;

   marshalSize = marshalSize + 2;  // _parameterIndex
   marshalSize = marshalSize + 2;  // _parameterValue
    return marshalSize;
}

