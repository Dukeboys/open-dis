package edu.nps.moves.disenum;

/** Enumeration values for ProtocolVersion
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum ProtocolVersion 
{

    OTHER(0, "Other"),
    DIS_PDU_VERSION_10_MAY_92(1, "DIS PDU version 1.0 (May 92)"),
    IEEE_1278_1993(2, "IEEE 1278-1993"),
    DIS_PDU_VERSION_20_THIRD_DRAFT_MAY_93(3, "DIS PDU version 2.0 - third draft (May 93)"),
    DIS_PDU_VERSION_20_FOURTH_DRAFT_REVISED_MARCH_16_1994(4, "DIS PDU version 2.0 - fourth draft (revised) March 16, 1994"),
    IEEE_12781_1995(5, "IEEE 1278.1-1995"),
    IEEE_12781A_1998(6, "IEEE 1278.1A-1998");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public ProtocolVersion lookup[] = new ProtocolVersion[7];

/* initialize the array at class load time */
static 
{
    for(ProtocolVersion anEnum:ProtocolVersion.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
ProtocolVersion(int value, String description)
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
