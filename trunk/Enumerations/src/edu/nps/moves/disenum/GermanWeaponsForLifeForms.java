package edu.nps.moves.disenum;

/** Enumeration values for GermanWeaponsForLifeForms
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum GermanWeaponsForLifeForms 
{

    G3_RIFLE(1, "G3 rifle"),
    G11_RIFLE(2, "G11 rifle"),
    P1_PISTOL(3, "P1 pistol"),
    MG3_MACHINE_GUN(4, "MG3 machine gun"),
    MILAN_MISSILE(5, "Milan missile"),
    MP1_UZI_SUBMACHINE_GUN(6, "MP1 Uzi submachine gun"),
    PANZERFAUST_3_LIGHT_ANTI_TANK_WEAPON(7, "Panzerfaust 3 Light Anti-Tank Weapon"),
    DM19_HAND_GRENADE(8, "DM19 hand grenade"),
    DM29_HAND_GRENADE(9, "DM29 hand grenade");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public GermanWeaponsForLifeForms lookup[] = new GermanWeaponsForLifeForms[10];

/* initialize the array at class load time */
static 
{
    for(GermanWeaponsForLifeForms anEnum:GermanWeaponsForLifeForms.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
GermanWeaponsForLifeForms(int value, String description)
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
