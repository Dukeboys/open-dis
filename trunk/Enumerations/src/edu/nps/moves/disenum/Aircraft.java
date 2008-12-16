package edu.nps.moves.disenum;

/** Enumeration values for Aircraft
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Aircraft 
{

    ENGINE_OFF(-100, "Engine Off"),
    IDLE_POWER(0, "Idle Power"),
    MIL_POWER(50, "Mil. Power"),
    MIN_A_B(51, "Min. A/B"),
    MAX_A_B(100, "Max. A/B");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Aircraft lookup[] = new Aircraft[101];

/* initialize the array at class load time */
static 
{
    for(Aircraft anEnum:Aircraft.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Aircraft(int value, String description)
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
