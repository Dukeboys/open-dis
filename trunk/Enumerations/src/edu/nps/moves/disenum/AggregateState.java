package edu.nps.moves.disenum;

/** Enumeration values for AggregateState
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum AggregateState 
{

    OTHER(0, "Other"),
    AGGREGATED(1, "Aggregated"),
    DISAGGREGATED(2, "Disaggregated"),
    FULLY_DISAGGREGATED(3, "Fully disaggregated"),
    PSEUDO_DISAGGREGATED(4, "Pseudo-disaggregated"),
    PARTIALLY_DISAGGREGATED(5, "Partially-disaggregated");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public AggregateState lookup[] = new AggregateState[6];

/* initialize the array at class load time */
static 
{
    for(AggregateState anEnum:AggregateState.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
AggregateState(int value, String description)
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
