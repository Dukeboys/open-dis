package edu.nps.moves.disenum;

/** Enumeration values for ProtocolFamily
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum ProtocolFamily 
{

    OTHER(0, "Other"),
    ENTITY_INFORMATION_INTERACTION(1, "Entity Information/Interaction"),
    WARFARE(2, "Warfare"),
    LOGISTICS(3, "Logistics"),
    RADIO_COMMUNICATION(4, "Radio Communication"),
    SIMULATION_MANAGEMENT(5, "Simulation Management"),
    DISTRIBUTED_EMISSION_REGENERATION(6, "Distributed Emission Regeneration"),
    ENTITY_MANAGEMENT(7, "Entity Management"),
    MINEFIELD(8, "Minefield"),
    SYNTHETIC_ENVIRONMENT(9, "Synthetic Environment"),
    SIMULATION_MANAGEMENT_WITH_RELIABILITY(10, "Simulation Management with Reliability"),
    LIVE_ENTITY(11, "Live Entity"),
    NON_REAL_TIME(12, "Non-Real Time"),
    EXPERIMENTAL_COMPUTER_GENERATED_FORCES(129, "Experimental - Computer Generated Forces");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public ProtocolFamily lookup[] = new ProtocolFamily[130];

/* initialize the array at class load time */
static 
{
    for(ProtocolFamily anEnum:ProtocolFamily.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
ProtocolFamily(int value, String description)
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
