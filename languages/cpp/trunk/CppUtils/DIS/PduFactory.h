#pragma once

#include <DIS/msLibMacro.h>         // for library symbols
#include <DIS/Pdu.h>

namespace DIS
{
class EXPORT_MACRO PduFactory
{
public:
	PduFactory(void);
	~PduFactory(void);

	Pdu* createPdu(const char * data);
};
}
