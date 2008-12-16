package edu.nps.moves.disenum;

/** Enumeration values for UKWeaponsForLifeForms
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum UKWeaponsForLifeForms 
{

    LAW_80(1, "LAW 80"),
    BLOWPIPE(2, "Blowpipe"),
    JAVELIN(3, "Javelin"),
    X_51_MM_MORTAR(4, "51-mm mortar"),
    SLR_762_MM_RIFLE(5, "SLR 7.62-mm rifle"),
    STERLING_9_MM_SUBMACHINE_GUN(6, "Sterling 9-mm submachine gun"),
    L7A2_GENERAL_PURPOSE_MG(7, "L7A2 general purpose MG"),
    L6_WOMBAT_RECOILLESS_RIFLE(8, "L6 Wombat Recoilless rifle,"),
    CARL_GUSTAV_89_MM_RECOILLESS_RIFLE(9, "Carl Gustav 89-mm recoilless rifle"),
    SA80_INDIVIDUAL_LIGHT_SUPPORT_WEAPON(10, "SA80 Individual/light support weapon"),
    TRIGAT(11, "Trigat"),
    MILAN_AT_MISSILE(12, "Milan AT missile");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public UKWeaponsForLifeForms lookup[] = new UKWeaponsForLifeForms[13];

/* initialize the array at class load time */
static 
{
    for(UKWeaponsForLifeForms anEnum:UKWeaponsForLifeForms.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
UKWeaponsForLifeForms(int value, String description)
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
