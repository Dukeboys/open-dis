package edu.nps.moves.disenum;

/** Enumeration values for Reason
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Reason 
{

    OTHER(0, "Other"),
    RECESS(1, "Recess"),
    TERMINATION(2, "Termination"),
    SYSTEM_FAILURE(3, "System Failure"),
    SECURITY_VIOLATION(4, "Security Violation"),
    ENTITY_RECONSTITUTION(5, "Entity Reconstitution"),
    STOP_FOR_RESET(6, "Stop for reset"),
    STOP_FOR_RESTART(7, "Stop for restart"),
    ABORT_TRAINING_RETURN_TO_TACTICAL_OPERATIONS(8, "Abort Training Return to Tactical Operations");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Reason lookup[] = new Reason[9];

/* initialize the array at class load time */
static 
{
    for(Reason anEnum:Reason.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Reason(int value, String description)
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
