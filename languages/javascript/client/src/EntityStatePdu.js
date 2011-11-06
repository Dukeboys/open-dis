

function Pdu()
{
    Pdu.prototype.protocolVersion = 7;
    Pdu.prototype.exerciseId = 0;
    Pdu.prototype.pduType = 1;
    Pdu.prototype.protocolFamily = 1;
    Pdu.prototype.timestamp = 0;
    Pdu.prototype.length = 144;
    Pdu.prototype.pduStatus = 0;
    Pdu.prototype.padding = 0;
    
}

function EntityID()
{
    EntityID.prototype.site = 0;
    EntityID.prototype.application = 0;
    EntityID.prototype.entity = 0;
}
function EntityStatePdu()
{
    EntityStatePdu.prototype = new Pdu();
    EntityStatePdu.prototype.entityId = new EntityId();    
}

var eid = new EntityID("site : 0",
                            "application: 1",
                             "entity: 2");
                             
document.alert(eid);