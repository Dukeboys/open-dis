package edu.nps.moves.disenum;

/** Enumeration values for MunitionDomain
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum MunitionDomain 
{

    OTHER(0, "Other"),
    ANTI_AIR(1, "Anti-Air"),
    ANTI_ARMOR(2, "Anti-Armor"),
    ANTI_GUIDED_WEAPON(3, "Anti-Guided Weapon"),
    ANTIRADAR(4, "Antiradar"),
    ANTISATELLITE(5, "Antisatellite"),
    ANTISHIP(6, "Antiship"),
    ANTISUBMARINE(7, "Antisubmarine"),
    ANTIPERSONNEL(8, "Antipersonnel"),
    BATTLEFIELD_SUPPORT(9, "Battlefield Support"),
    STRATEGIC(10, "Strategic"),
    TACTICAL(11, "Tactical"),
    DIRECTED_ENERGY_DE_WEAPON(12, "Directed Energy (DE) Weapon");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public MunitionDomain lookup[] = new MunitionDomain[13];

/* initialize the array at class load time */
static 
{
    for(MunitionDomain anEnum:MunitionDomain.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
MunitionDomain(int value, String description)
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
