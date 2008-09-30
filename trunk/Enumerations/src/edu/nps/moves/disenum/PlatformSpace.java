package edu.nps.moves.disenum;

/** Enumeration values for PlatformSpace
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG
 */

public enum PlatformSpace 
{

    OTHER(0, "Other"),
    MANNED(1, "Manned"),
    UNMANNED(2, "Unmanned"),
    BOOSTER(3, "Booster");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public PlatformSpace lookup[] = new PlatformSpace[4];

/* initialize the array at class load time */
static 
{
    for(PlatformSpace anEnum:PlatformSpace.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
PlatformSpace(int value, String description)
{
    this.value = value;
    this.description = description;
}

public int getValue()
{
  return value;
}


public String getDescription()
{
  return description;
}

}
