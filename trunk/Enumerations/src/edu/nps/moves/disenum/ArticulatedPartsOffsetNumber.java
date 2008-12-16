package edu.nps.moves.disenum;

/** Enumeration values for ArticulatedPartsOffsetNumber
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum ArticulatedPartsOffsetNumber 
{

    POSITION(1, "Position"),
    POSITION_RATE(2, "Position Rate"),
    EXTENSION(3, "Extension"),
    EXTENSION_RATE(4, "Extension Rate"),
    X(5, "X"),
    X_RATE(6, "X Rate"),
    Y(7, "Y"),
    Y_RATE(8, "Y Rate"),
    Z(9, "Z"),
    Z_RATE(10, "Z Rate"),
    AZIMUTH(11, "Azimuth"),
    AZIMUTH_RATE(12, "Azimuth Rate"),
    ELEVATION(13, "Elevation"),
    ELEVATION_RATE(14, "Elevation Rate"),
    ROTATION(15, "Rotation"),
    ROTATION_RATE(16, "Rotation Rate");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public ArticulatedPartsOffsetNumber lookup[] = new ArticulatedPartsOffsetNumber[17];

/* initialize the array at class load time */
static 
{
    for(ArticulatedPartsOffsetNumber anEnum:ArticulatedPartsOffsetNumber.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
ArticulatedPartsOffsetNumber(int value, String description)
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
