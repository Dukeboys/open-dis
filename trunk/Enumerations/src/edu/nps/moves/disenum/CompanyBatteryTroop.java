package edu.nps.moves.disenum;

/** Enumeration values for CompanyBatteryTroop
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum CompanyBatteryTroop 
{

    A_M(66, "A-M"),
    HQ(113, "HQ"),
    HHB(98, "HHB"),
    HHC(99, "HHC"),
    HHD(100, "HHD"),
    HHT(116, "HHT");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public CompanyBatteryTroop lookup[] = new CompanyBatteryTroop[117];

/* initialize the array at class load time */
static 
{
    for(CompanyBatteryTroop anEnum:CompanyBatteryTroop.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
CompanyBatteryTroop(int value, String description)
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
