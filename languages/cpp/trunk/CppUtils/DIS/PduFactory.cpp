#include "PduFactory.h"
#include <DIS/EntityStatePdu.h>
#include <DIS/FirePdu.h>
#include <DIS/Endian.h>
#include <DIS/PDUType.h>

using namespace DIS;

PduFactory::PduFactory(void)
{
}

PduFactory::~PduFactory(void)
{
}

/**
 * Converts data read from the wire--a byte array--to a DIS PDU language
 * object. A new PDU is created for every data buffer. The consumer of this 
 * object is responsible for freeing it. The PDUs can be up to MTU in size;
 * in some fairly rare instances, mostly involving multiple PDUs in a single
 * datagram packet, PDUs may be larger than this and this will fail horribly.
 * If the PDU type is unrecognized, or cannot be unmarshalled, the method
 * returns NULL. The caller should check for this.
 */

Pdu * PduFactory::createPdu(const char* data)
{
	int dataLength = 1500; // MTU
	int pduType = data[2];
	DataStream dataStream(data, dataLength, DIS::BIG);

	Pdu* pdu = NULL;

	switch(pduType)
	{
	case PDU_ENTITY_STATE:
	    pdu = new EntityStatePdu();
		pdu->unmarshal(dataStream);
		break;

	case PDU_FIRE:
		pdu = new FirePdu();
		pdu->unmarshal(dataStream);
		break;

	case PDU_DETONATION:
		pdu = new DetonationPdu();
		pdu->unmarshal(dataStream);
		break;

	case PDU_DATA:
		pdu = new DataPdu();
		pdu->unmarshal(dataStream);
		break;

	default:
		break;
	}

	return pdu;

}