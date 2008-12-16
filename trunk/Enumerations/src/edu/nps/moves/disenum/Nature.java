package edu.nps.moves.disenum;

/** Enumeration values for Nature
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Nature 
{

    OTHER(0, "Other"),
    HOST_FIREABLE_MUNITION(1, "Host-fireable munition"),
    MUNITION_CARRIED_AS_CARGO(2, "Munition carried as cargo"),
    FUEL_CARRIED_AS_CARGO(3, "Fuel carried as cargo"),
    GUNMOUNT_ATTACHED_TO_HOST(4, "Gunmount attached to host"),
    COMPUTER_GENERATED_FORCES_CARRIED_AS_CARGO(5, "Computer generated forces carried as cargo"),
    VEHICLE_CARRIED_AS_CARGO(6, "Vehicle carried as cargo"),
    EMITTER_MOUNTED_ON_HOST(7, "Emitter mounted on host"),
    MOBILE_COMMAND_AND_CONTROL_ENTITY_CARRIED_ABOARD_HOST(8, "Mobile command and control entity carried aboard host"),
    ENTITY_STATIONED_AT_POSITION_WITH_RESPECT_TO_HOST(9, "Entity stationed at position with respect to host"),
    TEAM_MEMBER_IN_FORMATION_WITH(10, "Team member in formation with");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Nature lookup[] = new Nature[11];

/* initialize the array at class load time */
static 
{
    for(Nature anEnum:Nature.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Nature(int value, String description)
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
