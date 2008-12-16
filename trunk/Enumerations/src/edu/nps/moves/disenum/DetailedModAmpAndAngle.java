package edu.nps.moves.disenum;

/** Enumeration values for DetailedModAmpAndAngle
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum DetailedModAmpAndAngle 
{

    OTHER(0, "Other"),
    AMPLITUDE_AND_ANGLE(1, "Amplitude and Angle");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public DetailedModAmpAndAngle lookup[] = new DetailedModAmpAndAngle[2];

/* initialize the array at class load time */
static 
{
    for(DetailedModAmpAndAngle anEnum:DetailedModAmpAndAngle.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
DetailedModAmpAndAngle(int value, String description)
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
