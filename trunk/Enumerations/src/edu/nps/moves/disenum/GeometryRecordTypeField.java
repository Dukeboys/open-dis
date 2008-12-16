package edu.nps.moves.disenum;

/** Enumeration values for GeometryRecordTypeField
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum GeometryRecordTypeField 
{

    POINT_RECORD_1(655360, "Point Record 1"),
    POINT_RECORD_2(167772160, "Point Record 2"),
    LINE_RECORD_1(786432, "Line Record 1"),
    LINE_RECORD_2(201326592, "Line Record 2"),
    BOUNDING_SPHERE_RECORD(65536, "Bounding Sphere Record"),
    SPHERE_RECORD_1(851968, "Sphere Record 1"),
    SPHERE_RECORD_2(218103808, "Sphere Record 2"),
    ELLIPSOID_RECORD_1(1048576, "Ellipsoid Record 1"),
    ELLIPSOID_RECORD_2(268435456, "Ellipsoid Record 2"),
    CONE_RECORD_1(3145728, "Cone Record 1"),
    CONE_RECORD_2(805306368, "Cone Record 2"),
    UNIFORM_GEOMETRY_RECORD(327680, "Uniform Geometry Record"),
    RECTANGULAR_VOLUME_RECORD_1(5242880, "Rectangular Volume Record 1"),
    RECTANGULAR_VOLUME_RECORD_2(1342177280, "Rectangular Volume Record 2"),
    GAUSSIAN_PLUME_RECORD(1610612736, "Gaussian Plume Record"),
    GAUSSIAN_PUFF_RECORD(1879048192, "Gaussian Puff Record"),
    RECTANGULAR_VOLUME_RECORD_3(83886080, "Rectangular Volume Record 3");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public GeometryRecordTypeField lookup[] = new GeometryRecordTypeField[1879048193];

/* initialize the array at class load time */
static 
{
    for(GeometryRecordTypeField anEnum:GeometryRecordTypeField.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
GeometryRecordTypeField(int value, String description)
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
