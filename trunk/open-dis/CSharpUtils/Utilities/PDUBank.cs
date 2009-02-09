using System;
using System.Collections.Generic;
using System.Text;
using DIS1998net;

namespace DISnet.Utilities
{
    /* Author Peter Smith (Naval Air Warfare Center - Training Systems Division) 01/23/2009
* Modifications: none
* Notes:
*/

    public class PDUBank
    {
        static public DIS1998net.Pdu GetPDU(uint pdu_type)
        {
            DISnet.Utilities.PDUTypes.PDUType1998 enumType = (PDUTypes.PDUType1998)pdu_type;
            return GetPDU(enumType);
        }

        static public DIS1998net.Pdu GetPDU(DISnet.Utilities.PDUTypes.PDUType1998 pdu_type)
        {
            DIS1998net.Pdu pdu = null;

            switch (pdu_type)
            {

                case PDUTypes.PDUType1998.PDU_ENTITY_STATE: pdu =  new EntityStatePdu(); break;
                case PDUTypes.PDUType1998.PDU_FIRE: pdu = new FirePdu(); break;
                case PDUTypes.PDUType1998.PDU_DETONATION: pdu = new DetonationPdu(); break;
                case PDUTypes.PDUType1998.PDU_COLLISION: pdu = new CollisionPdu(); break;
                case PDUTypes.PDUType1998.PDU_SERVICE_REQUEST: pdu = new ServiceRequestPdu(); break;
                case PDUTypes.PDUType1998.PDU_RESUPPLY_OFFER: pdu = new ResupplyOfferPdu(); break;
                case PDUTypes.PDUType1998.PDU_RESUPPLY_RECEIVED: pdu = new ResupplyReceivedPdu(); break;
                case PDUTypes.PDUType1998.PDU_RESUPPLY_CANCEL: pdu = new ResupplyCancelPdu(); break;
                case PDUTypes.PDUType1998.PDU_REPAIR_COMPLETE: pdu = new RepairCompletePdu(); break;
                case PDUTypes.PDUType1998.PDU_REPAIR_RESPONSE: pdu = new RepairResponsePdu(); break;
                case PDUTypes.PDUType1998.PDU_CREATE_ENTITY: pdu = new CreateEntityPdu(); break;
                case PDUTypes.PDUType1998.PDU_REMOVE_ENTITY: pdu = new RemoveEntityPdu(); break;
                case PDUTypes.PDUType1998.PDU_START_RESUME: pdu = new StartResumePdu(); break;
                case PDUTypes.PDUType1998.PDU_ACKNOWLEDGE: pdu = new AcknowledgePdu(); break;
                case PDUTypes.PDUType1998.PDU_ACTION_REQUEST: pdu = new ActionRequestPdu(); break;
                case PDUTypes.PDUType1998.PDU_ACTION_RESPONSE: pdu = new ActionResponsePdu(); break;
                case PDUTypes.PDUType1998.PDU_DATA_QUERY: pdu = new DataQueryPdu(); break;
                case PDUTypes.PDUType1998.PDU_SET_DATA: pdu = new SetDataPdu(); break;
                case PDUTypes.PDUType1998.PDU_EVENT_REPORT: pdu = new EventReportPdu(); break;
                case PDUTypes.PDUType1998.PDU_COMMENT: pdu = new CommentPdu(); break;
                case PDUTypes.PDUType1998.PDU_STOP_FREEZE: pdu = new StopFreezePdu(); break;
                case PDUTypes.PDUType1998.PDU_SIGNAL: pdu = new SignalPdu(); break;
                case PDUTypes.PDUType1998.PDU_TRANSMITTER: pdu = new TransmitterPdu(); break;
            }

            return pdu;
        }
    }
}
