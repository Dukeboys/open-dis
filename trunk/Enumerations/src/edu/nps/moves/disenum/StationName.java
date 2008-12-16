package edu.nps.moves.disenum;

/** Enumeration values for StationName
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum StationName 
{

    OTHER(0, "Other"),
    AIRCRAFT_WINGSTATION(1, "Aircraft wingstation"),
    SHIPS_FORWARD_GUNMOUNT_STARBOARD(2, "Ship's forward gunmount (starboard)"),
    SHIPS_FORWARD_GUNMOUNT_PORT(3, "Ship's forward gunmount (port)"),
    SHIPS_FORWARD_GUNMOUNT_CENTERLINE(4, "Ship's forward gunmount (centerline)"),
    SHIPS_AFT_GUNMOUNT_STARBOARD(5, "Ship's aft gunmount (starboard)"),
    SHIPS_AFT_GUNMOUNT_PORT(6, "Ship's aft gunmount (port)"),
    SHIPS_AFT_GUNMOUNT_CENTERLINE(7, "Ship's aft gunmount (centerline)"),
    FORWARD_TORPEDO_TUBE(8, "Forward torpedo tube"),
    AFT_TORPEDO_TUBE(9, "Aft torpedo tube"),
    BOMB_BAY(10, "Bomb bay"),
    CARGO_BAY(11, "Cargo bay"),
    TRUCK_BED(12, "Truck bed"),
    TRAILER_BED(13, "Trailer bed"),
    WELL_DECK(14, "Well deck"),
    ON_STATION_RNG_BRG(15, "On station - (RNG/BRG)"),
    ON_STATION_XYZ(16, "On station - (x,y,z)");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public StationName lookup[] = new StationName[17];

/* initialize the array at class load time */
static 
{
    for(StationName anEnum:StationName.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
StationName(int value, String description)
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
