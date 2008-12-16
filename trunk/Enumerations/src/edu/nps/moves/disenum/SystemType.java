package edu.nps.moves.disenum;

/** Enumeration values for SystemType
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum SystemType 
{

    OTHER(0, "Other"),
    MARK_X_XII_ATCRBS_MODE_S_TRANSPONDER(1, "Mark X/XII/ATCRBS/Mode S Transponder"),
    MARK_X_XII_ATCRBS_MODE_S_INTERROGATOR(2, "Mark X/XII/ATCRBS/Mode S Interrogator"),
    SOVIET_TRANSPONDER(3, "Soviet Transponder"),
    SOVIET_INTERROGATOR(4, "Soviet Interrogator"),
    RRB_TRANSPONDER(5, "RRB Transponder");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public SystemType lookup[] = new SystemType[6];

/* initialize the array at class load time */
static 
{
    for(SystemType anEnum:SystemType.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
SystemType(int value, String description)
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
