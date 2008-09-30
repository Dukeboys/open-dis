package edu.nps.moves.disenum;

/** Enumeration values for ForceID
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG
 */

public enum ForceID 
{

    OTHER(0, "Other"),
    FRIENDLY(1, "Friendly"),
    OPPOSING(2, "Opposing"),
    NEUTRAL(3, "Neutral"),
    FRIENDLY_2(4, "Friendly 2"),
    OPPOSING_2(5, "Opposing 2"),
    NEUTRAL_2(6, "Neutral 2"),
    FRIENDLY_3(7, "Friendly 3"),
    OPPOSING_3(8, "Opposing 3"),
    NEUTRAL_3(9, "Neutral 3"),
    FRIENDLY_4(10, "Friendly 4"),
    OPPOSING_4(11, "Opposing 4"),
    NEUTRAL_4(12, "Neutral 4"),
    FRIENDLY_5(13, "Friendly 5"),
    OPPOSING_5(14, "Opposing 5"),
    NEUTRAL_5(15, "Neutral 5"),
    FRIENDLY_6(16, "Friendly 6"),
    OPPOSING_6(17, "Opposing 6"),
    NEUTRAL_6(18, "Neutral 6"),
    FRIENDLY_7(19, "Friendly 7"),
    OPPOSING_7(20, "Opposing 7"),
    NEUTRAL_7(21, "Neutral 7"),
    FRIENDLY_8(22, "Friendly 8"),
    OPPOSING_8(23, "Opposing 8"),
    NEUTRAL_8(24, "Neutral 8"),
    FRIENDLY_9(25, "Friendly 9"),
    OPPOSING_9(26, "Opposing 9"),
    NEUTRAL_9(27, "Neutral 9"),
    FRIENDLY_10(28, "Friendly 10"),
    OPPOSING_10(29, "Opposing 10"),
    NEUTRAL_10(30, "Neutral 10");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public ForceID lookup[] = new ForceID[31];

/* initialize the array at class load time */
static 
{
    for(ForceID anEnum:ForceID.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
ForceID(int value, String description)
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
