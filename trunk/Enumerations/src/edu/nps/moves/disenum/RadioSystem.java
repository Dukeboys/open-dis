package edu.nps.moves.disenum;

/** Enumeration values for RadioSystem
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum RadioSystem 
{

    OTHER(0, "Other"),
    GENERIC(1, "Generic"),
    HQ(2, "HQ"),
    HQII(3, "HQII"),
    HQIIA(4, "HQIIA"),
    SINCGARS(5, "SINCGARS"),
    CCTT_SINCGARS(6, "CCTT SINCGARS"),
    EPLRS_ENHANCED_POSITION_LOCATION_REPORTING_SYSTEM(7, "EPLRS (Enhanced Position Location Reporting System)"),
    JTIDS_MIDS(8, "JTIDS/MIDS");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public RadioSystem lookup[] = new RadioSystem[9];

/* initialize the array at class load time */
static 
{
    for(RadioSystem anEnum:RadioSystem.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
RadioSystem(int value, String description)
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
