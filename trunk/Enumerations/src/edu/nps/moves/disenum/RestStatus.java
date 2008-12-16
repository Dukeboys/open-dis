package edu.nps.moves.disenum;

/** Enumeration values for RestStatus
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum RestStatus 
{

    NOT_RESTED_HAS_NOT_SLEPT_IN_THE_LAST_THREE_DAYS(0, "Not rested (Has not slept in the last three days)"),
    HAS_SLEPT_AN_AVERAGE_OF_1_HOUR_PER_DAY_IN_THE_LAST_THREE_DAYS(1, "Has slept an average of 1 hour per day in the last three days."),
    HAS_SLEPT_AN_AVERAGE_OF_2_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS(2, "Has slept an average of 2 hours per day in the last three days."),
    HAS_SLEPT_AN_AVERAGE_OF_3_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS(3, "Has slept an average of 3 hours per day in the last three days."),
    HAS_SLEPT_AN_AVERAGE_OF_4_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS(4, "Has slept an average of 4 hours per day in the last three days."),
    HAS_SLEPT_AN_AVERAGE_OF_5_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS(5, "Has slept an average of 5 hours per day in the last three days."),
    HAS_SLEPT_AN_AVERAGE_OF_6_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS(6, "Has slept an average of 6 hours per day in the last three days."),
    HAS_SLEPT_AN_AVERAGE_OF_7_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS(7, "Has slept an average of 7 hours per day in the last three days."),
    FULLY_RESTED_HAS_SLEPT_AN_AVERAGE_OF_8_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS(8, "Fully rested (Has slept an average of 8 hours per day in the last three days)");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public RestStatus lookup[] = new RestStatus[9];

/* initialize the array at class load time */
static 
{
    for(RestStatus anEnum:RestStatus.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
RestStatus(int value, String description)
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
