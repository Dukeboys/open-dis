package edu.nps.moves.disenum;

/** Enumeration values for Bytes8_9_10_12
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Bytes8_9_10_12 
{

    X_0_9(0, "0-9"),
    X_0_9_1(10, "0-9"),
    E(69, "E"),
    UNDERSCORE_E(101, "Underscore E"),
    S(83, "S"),
    UNDERSCORE_S(115, "Underscore S"),
    X(88, "X"),
    UNDERSCORE_X(120, "Underscore X"),
    BLANK(32, "Blank");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Bytes8_9_10_12 lookup[] = new Bytes8_9_10_12[121];

/* initialize the array at class load time */
static 
{
    for(Bytes8_9_10_12 anEnum:Bytes8_9_10_12.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Bytes8_9_10_12(int value, String description)
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
