package edu.nps.moves.disenum;

/** Enumeration values for FLIR
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum FLIR 
{

    GENERIC_3_5(0, "Generic 3-5"),
    GENERIC_8_12(1, "Generic 8-12"),
    ASTAMIDS_I(2, "ASTAMIDS I"),
    ASTAMIDS_II(3, "ASTAMIDS II"),
    GSTAMIDS_3_5(4, "GSTAMIDS 3-5"),
    GSTAMIDS_8_12(5, "GSTAMIDS 8-12"),
    HSTAMIDS_3_5(6, "HSTAMIDS 3-5"),
    HSTAMIDS_8_12(7, "HSTAMIDS 8-12"),
    COBRA_3_5(8, "COBRA 3-5"),
    COBRA_8_12(9, "COBRA 8-12");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public FLIR lookup[] = new FLIR[10];

/* initialize the array at class load time */
static 
{
    for(FLIR anEnum:FLIR.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
FLIR(int value, String description)
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
