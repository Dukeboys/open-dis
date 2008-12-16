package edu.nps.moves.disenum;

/** Enumeration values for FrenchWeaponsForLifeForms
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum FrenchWeaponsForLifeForms 
{

    ACL_STRIM(1, "ACL-STRIM"),
    MISTRAL_MISSILE(2, "Mistral missile"),
    MILAN_AT_MISSILE(3, "Milan AT missile"),
    LRAC_F1_89_MM_AT_ROCKET_LAUNCHER(4, "LRAC F1 89-mm AT rocket launcher"),
    FA_MAS_RIFLE(5, "FA-MAS rifle"),
    AA_52_MACHINE_GUN(6, "AA-52 machine gun"),
    X_58_MM_RIFLE_GRENADE(7, "58-mm rifle grenade"),
    FR_F1_SNIPER_RIFLE(8, "FR-F1 sniper rifle");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public FrenchWeaponsForLifeForms lookup[] = new FrenchWeaponsForLifeForms[9];

/* initialize the array at class load time */
static 
{
    for(FrenchWeaponsForLifeForms anEnum:FrenchWeaponsForLifeForms.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
FrenchWeaponsForLifeForms(int value, String description)
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
