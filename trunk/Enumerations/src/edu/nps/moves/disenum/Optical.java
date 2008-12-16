package edu.nps.moves.disenum;

/** Enumeration values for Optical
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Optical 
{

    UNAIDED_EYE_ACTIVELY_SEARCHING(0, "Unaided Eye, Actively Searching"),
    UNAIDED_EYE_NOT_ACTIVELY_SEARCHING(1, "Unaided Eye, Not Actively Searching"),
    BINOCULARS(2, "Binoculars"),
    IMAGE_INTENSIFIER(3, "Image Intensifier"),
    HMMWV_OCCUPANT_ACTIVELY_SEARCHING(4, "HMMWV occupant, Actively Searching"),
    HMMWV_OCCUPANT_NOT_ACTIVELY_SEARCHING(5, "HMMWV occupant, Not Actively Searching"),
    TRUCK_OCCUPANT_ACTIVELY_SEARCHING(6, "Truck occupant, Actively Searching"),
    TRUCK_OCCUPANT_NOT_ACTIVELY_SEARCHING(7, "Truck occupant, Not Actively Searching"),
    TRACKED_VEHICLE_OCCUPANT_CLOSED_HATCH_ACTIVELY_SEARCHING(8, "Tracked vehicle occupant, closed hatch, Actively Searching"),
    TRACKED_VEHICLE_OCCUPANT_CLOSED_HATCH_NOT_ACTIVELY_SEARCHING(9, "Tracked vehicle occupant, closed hatch, Not Actively Searching"),
    TRACKED_VEHICLE_OCCUPANT_OPEN_HATCH_ACTIVELY_SEARCHING(10, "Tracked vehicle occupant, open hatch, Actively Searching"),
    TRACKED_VEHICLE_OCCUPANT_OPEN_HATCH_NOT_ACTIVELY_SEARCHING(11, "Tracked vehicle occupant, open hatch, Not Actively Searching");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Optical lookup[] = new Optical[12];

/* initialize the array at class load time */
static 
{
    for(Optical anEnum:Optical.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Optical(int value, String description)
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
