package edu.nps.moves.disenum;

/** Enumeration values for BeamFunction
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum BeamFunction 
{

    OTHER(0, "Other"),
    SEARCH(1, "Search"),
    HEIGHT_FINDER(2, "Height finder"),
    ACQUISITION(3, "Acquisition"),
    TRACKING(4, "Tracking"),
    ACQUISITION_AND_TRACKING(5, "Acquisition and tracking"),
    COMMAND_GUIDANCE(6, "Command guidance"),
    ILLUMINATION(7, "Illumination"),
    RANGE_ONLY_RADAR(8, "Range only radar"),
    MISSILE_BEACON(9, "Missile beacon"),
    MISSILE_FUZE(10, "Missile fuze"),
    ACTIVE_RADAR_MISSILE_SEEKER(11, "Active radar missile seeker"),
    JAMMER(12, "Jammer"),
    IFF(13, "IFF"),
    NAVIGATIONAL_WEATHER(14, "Navigational / Weather"),
    METEOROLOGICAL(15, "Meteorological"),
    DATA_TRANSMISSION(16, "Data transmission"),
    NAVIGATIONAL_DIRECTIONAL_BEACON(17, "Navigational directional beacon");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public BeamFunction lookup[] = new BeamFunction[18];

/* initialize the array at class load time */
static 
{
    for(BeamFunction anEnum:BeamFunction.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
BeamFunction(int value, String description)
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
