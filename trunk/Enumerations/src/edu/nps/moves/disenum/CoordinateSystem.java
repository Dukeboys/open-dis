package edu.nps.moves.disenum;

/** Enumeration values for CoordinateSystem
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum CoordinateSystem 
{

    RIGHT_HANDED_CARTESIAN_LOCAL_TOPOGRAPHIC_PROJECTION_EAST_NORTH_UP(0, "Right handed Cartesian (local topographic projection: east, north, up)"),
    LEFT_HANDED_CARTESIAN_LOCAL_TOPOGRAPHIC_PROJECTION_EAST_NORTH_DOWN(1, "Left handed Cartesian (local topographic projection: east, north, down)"),
    LATITUDE_LONGITUDE_HEIGHT(2, "Latitude, Longitude, Height"),
    LATITUDE_LONGITUDE_DEPTH(3, "Latitude, Longitude, Depth");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public CoordinateSystem lookup[] = new CoordinateSystem[4];

/* initialize the array at class load time */
static 
{
    for(CoordinateSystem anEnum:CoordinateSystem.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
CoordinateSystem(int value, String description)
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
