package edu.nps.moves.disenum;

/** Enumeration values for AttachedParts
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum AttachedParts 
{

    NOTHING_EMPTY(0, "Nothing, Empty"),
    SEQUENTIAL_IDS_FOR_MODEL_SPECIFIC_STATIONS(1, "Sequential IDs for model-specific stations"),
    FUSELAGE_STATIONS(512, "Fuselage Stations"),
    LEFT_WING_STATIONS(640, "Left-wing Stations"),
    RIGHT_WING_STATIONS(768, "Right-wing Stations"),
    M16A42_RIFLE(896, "M16A42 rifle"),
    M249_SAW(897, "M249 SAW"),
    M60_MACHINE_GUN(898, "M60 Machine gun"),
    M203_GRENADE_LAUNCHER(899, "M203 Grenade Launcher"),
    M136_AT4(900, "M136 AT4"),
    M47_DRAGON(901, "M47 Dragon"),
    AAWS_M_JAVELIN(902, "AAWS-M Javelin"),
    M18A1_CLAYMORE_MINE(903, "M18A1 Claymore Mine"),
    MK19_GRENADE_LAUNCHER(904, "MK19 Grenade Launcher"),
    M2_MACHINE_GUN(905, "M2 Machine Gun"),
    OTHER_ATTACHED_PARTS(906, "Other attached parts");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public AttachedParts lookup[] = new AttachedParts[907];

/* initialize the array at class load time */
static 
{
    for(AttachedParts anEnum:AttachedParts.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
AttachedParts(int value, String description)
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
