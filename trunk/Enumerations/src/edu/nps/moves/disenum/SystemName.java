package edu.nps.moves.disenum;

/** Enumeration values for SystemName
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum SystemName 
{

    OTHER(0, "Other"),
    MARK_X(1, "Mark X"),
    MARK_XII(2, "Mark XII"),
    ATCRBS(3, "ATCRBS"),
    SOVIET(4, "Soviet"),
    MODE_S(5, "Mode S"),
    MARK_X_XII_ATCRBS(6, "Mark X/XII/ATCRBS"),
    MARK_X_XII_ATCRBS_MODE_S(7, "Mark X/XII/ATCRBS/Mode S"),
    ARI_5954(8, "ARI 5954"),
    ARI_5983(9, "ARI 5983");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public SystemName lookup[] = new SystemName[10];

/* initialize the array at class load time */
static 
{
    for(SystemName anEnum:SystemName.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
SystemName(int value, String description)
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
