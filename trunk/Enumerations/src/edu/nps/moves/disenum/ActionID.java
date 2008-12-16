package edu.nps.moves.disenum;

/** Enumeration values for ActionID
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum ActionID 
{

    OTHER(0, "Other"),
    LOCAL_STORAGE_OF_THE_REQUESTED_INFORMATION(1, "Local storage of the requested information"),
    INFORM_SM_OF_EVENT_RAN_OUT_OF_AMMUNITION(2, "Inform SM of event ran out of ammunition"),
    INFORM_SM_OF_EVENT_KILLED_IN_ACTION(3, "Inform SM of event killed in action"),
    INFORM_SM_OF_EVENT_DAMAGE(4, "Inform SM of event damage"),
    INFORM_SM_OF_EVENT_MOBILITY_DISABLED(5, "Inform SM of event mobility disabled"),
    INFORM_SM_OF_EVENT_FIRE_DISABLED(6, "Inform SM of event fire disabled"),
    INFORM_SM_OF_EVENT_RAN_OUT_OF_FUEL(7, "Inform SM of event ran out of fuel"),
    RECALL_CHECKPOINT_DATA(8, "Recall checkpoint data"),
    RECALL_INITIAL_PARAMETERS(9, "Recall initial parameters"),
    INITIATE_TETHER_LEAD(10, "Initiate tether-lead"),
    INITIATE_TETHER_FOLLOW(11, "Initiate tether-follow"),
    UNTHETHER(12, "Unthether"),
    INITIATE_SERVICE_STATION_RESUPPLY(13, "Initiate service station resupply"),
    INITIATE_TAILGATE_RESUPPLY(14, "Initiate tailgate resupply"),
    INITIATE_HITCH_LEAD(15, "Initiate hitch lead"),
    INITIATE_HITCH_FOLLOW(16, "Initiate hitch follow"),
    UNHITCH(17, "Unhitch"),
    MOUNT(18, "Mount"),
    DISMOUNT(19, "Dismount"),
    START_DRC_DAILY_READINESS_CHECK(20, "Start DRC (Daily Readiness Check)"),
    STOP_DRC(21, "Stop DRC"),
    DATA_QUERY(22, "Data Query"),
    STATUS_REQUEST(23, "Status Request"),
    SEND_OBJECT_STATE_DATA(24, "Send Object State Data"),
    RECONSTITUTE(25, "Reconstitute"),
    LOCK_SITE_CONFIGURATION(26, "Lock Site Configuration"),
    UNLOCK_SITE_CONFIGURATION(27, "Unlock Site Configuration"),
    UPDATE_SITE_CONFIGURATION(28, "Update Site Configuration"),
    QUERY_SITE_CONFIGURATION(29, "Query Site Configuration"),
    TETHERING_INFORMATION(30, "Tethering Information"),
    MOUNT_INTENT(31, "Mount Intent"),
    ACCEPT_SUBSCRIPTION(33, "Accept Subscription"),
    UNSUBSCRIBE(34, "Unsubscribe"),
    TELEPORT_ENTITY(35, "Teleport entity"),
    CHANGE_AGGREGATE_STATE(36, "Change aggregate state"),
    REQUEST_START_PDU(37, "Request Start PDU"),
    WAKEUP_GET_READY_FOR_INITIALIZATION(38, "Wakeup get ready for initialization"),
    INITIALIZE_INTERNAL_PARAMETERS(39, "Initialize internal parameters"),
    SEND_PLAN_DATA(40, "Send plan data"),
    SYNCHRONIZE_INTERNAL_CLOCKS(41, "Synchronize internal clocks"),
    RUN(42, "Run"),
    SAVE_INTERNAL_PARAMETERS(43, "Save internal parameters"),
    SIMULATE_MALFUNCTION(44, "Simulate malfunction"),
    JOIN_EXERCISE(45, "Join exercise"),
    RESIGN_EXERCISE(46, "Resign exercise"),
    TIME_ADVANCE(47, "Time advance"),
    TACCSF_LOS_REQUEST_TYPE_1(100, "TACCSF LOS Request-Type 1"),
    TACCSF_LOS_REQUEST_TYPE_2(101, "TACCSF LOS Request-Type 2");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public ActionID lookup[] = new ActionID[102];

/* initialize the array at class load time */
static 
{
    for(ActionID anEnum:ActionID.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
ActionID(int value, String description)
{
    this.value = value;
    this.description = description;
}

/** Returns the enumerated value for this enumeration */
public int getValue()
{
  return value;
}


/** Returns a text descriptioni for this enumerated value. This is usually used as the basis for the enumeration name. */
public String getDescription()
{
  return description;
}

}
