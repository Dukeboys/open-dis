package edu.nps.moves.disenum;

/** Enumeration values for PlatformAir
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum PlatformAir 
{

    OTHER(0, "Other"),
    FIGHTER_AIR_DEFENSE(1, "Fighter/Air Defense"),
    ATTACK_STRIKE(2, "Attack/Strike"),
    BOMBER(3, "Bomber"),
    CARGO_TANKER(4, "Cargo/Tanker"),
    ASW_PATROL_OBSERVATION(5, "ASW/Patrol/Observation"),
    ELECTRONIC_WARFARE_EW(6, "Electronic Warfare (EW)"),
    RECONNAISSANCE(7, "Reconnaissance"),
    SURVEILLANCE_C2_AIRBORNE_EARLY_WARNING(8, "Surveillance/C2 (Airborne Early Warning)"),
    ATTACK_HELICOPTER(20, "Attack Helicopter"),
    UTILITY_HELICOPTER(21, "Utility Helicopter"),
    ANTISUBMARINE_WARFARE_PATROL_HELICOPTER(22, "Antisubmarine Warfare/Patrol Helicopter"),
    CARGO_HELICOPTER(23, "Cargo Helicopter"),
    OBSERVATION_HELICOPTER(24, "Observation Helicopter"),
    SPECIAL_OPERATIONS_HELICOPTER(25, "Special Operations Helicopter"),
    TRAINER(40, "Trainer"),
    UNMANNED(50, "Unmanned"),
    NON_COMBATANT_COMMERCIAL_AIRCRAFT(57, "Non-Combatant Commercial Aircraft");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public PlatformAir lookup[] = new PlatformAir[58];

/* initialize the array at class load time */
static 
{
    for(PlatformAir anEnum:PlatformAir.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
PlatformAir(int value, String description)
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
