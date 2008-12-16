package edu.nps.moves.disenum;

/** Enumeration values for RadioNomenclature
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum RadioNomenclature 
{

    OTHER(0, "Other"),
    AN_ARN_118(1, "AN/ARN-118"),
    AN_ARN_139(2, "AN/ARN-139"),
    GENERIC_GROUND_FIXED_TRANSMITTER(3, "Generic Ground Fixed Transmitter"),
    GENERIC_GROUND_MOBILE_TRANSMITTER(4, "Generic Ground Mobile Transmitter");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public RadioNomenclature lookup[] = new RadioNomenclature[5];

/* initialize the array at class load time */
static 
{
    for(RadioNomenclature anEnum:RadioNomenclature.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
RadioNomenclature(int value, String description)
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
