package edu.nps.moves.disenum;

/** Enumeration values for PlatformSubSurface
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG
 */

public enum PlatformSubSurface 
{

    OTHER(0, "Other"),
    SSBN_NUCLEAR_BALLISTIC_MISSILE(1, "SSBN (Nuclear Ballistic Missile)"),
    SSGN_NUCLEAR_GUIDED_MISSILE(2, "SSGN (Nuclear Guided Missile)"),
    SSN_NUCLEAR_ATTACK_TORPEDO(3, "SSN (Nuclear Attack - Torpedo)"),
    SSG_CONVENTIONAL_GUIDED_MISSILE(4, "SSG (Conventional Guided Missile)"),
    SS_CONVENTIONAL_ATTACK_TORPEDO_PATROL(5, "SS (Conventional Attack - Torpedo, Patrol)"),
    SSAN_NUCLEAR_AUXILIARY(6, "SSAN (Nuclear Auxiliary)"),
    SSA_CONVENTIONAL_AUXILIARY(7, "SSA (Conventional Auxiliary)");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public PlatformSubSurface lookup[] = new PlatformSubSurface[8];

/* initialize the array at class load time */
static 
{
    for(PlatformSubSurface anEnum:PlatformSubSurface.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
PlatformSubSurface(int value, String description)
{
    this.value = value;
    this.description = description;
}

public int getValue()
{
  return value;
}


public String getDescription()
{
  return description;
}

}
