package edu.nps.moves.disenum;

/** Enumeration values for RequestStatus
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum RequestStatus 
{

    OTHER(0, "Other"),
    PENDING(1, "Pending"),
    EXECUTING(2, "Executing"),
    PARTIALLY_COMPLETE(3, "Partially Complete"),
    COMPLETE(4, "Complete"),
    REQUEST_REJECTED(5, "Request rejected"),
    RETRANSMIT_REQUEST_NOW(6, "Retransmit request now"),
    RETRANSMIT_REQUEST_LATER(7, "Retransmit request later"),
    INVALID_TIME_PARAMETERS(8, "Invalid time parameters"),
    SIMULATION_TIME_EXCEEDED(9, "Simulation time exceeded"),
    REQUEST_DONE(10, "Request done"),
    TACCSF_LOS_REPLY_TYPE_1(100, "TACCSF LOS Reply-Type 1"),
    TACCSF_LOS_REPLY_TYPE_2(101, "TACCSF LOS Reply-Type 2"),
    JOIN_EXERCISE_REQUEST_REJECTED(201, "Join Exercise Request Rejected");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public RequestStatus lookup[] = new RequestStatus[202];

/* initialize the array at class load time */
static 
{
    for(RequestStatus anEnum:RequestStatus.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
RequestStatus(int value, String description)
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
