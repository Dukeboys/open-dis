package edu.nps.moves.disenum;

/** Enumeration values for AcousticSystemName
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum AcousticSystemName 
{

    OTHER(0, "Other"),
    AN_BQQ_5(1, "AN/BQQ-5"),
    AN_SSQ_62(2, "AN/SSQ-62"),
    AN_SQS_23(3, "AN/SQS-23"),
    AN_SQS_26(4, "AN/SQS-26"),
    AN_SQS_53(5, "AN/SQS-53"),
    ALFS(6, "ALFS"),
    LFA(7, "LFA"),
    AN_AQS_901(8, "AN/AQS-901"),
    AN_AQS_902(9, "AN/AQS-902");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public AcousticSystemName lookup[] = new AcousticSystemName[10];

/* initialize the array at class load time */
static 
{
    for(AcousticSystemName anEnum:AcousticSystemName.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
AcousticSystemName(int value, String description)
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
