package edu.nps.moves.disenum;

/** Enumeration values for GroupedEntityCategory
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum GroupedEntityCategory 
{

    UNDEFINED(0, "Undefined"),
    BASIC_GROUND_COMBAT_VEHICLE(1, "Basic Ground Combat Vehicle"),
    ENHANCED_GROUND_COMBAT_VEHICLE(2, "Enhanced Ground Combat Vehicle"),
    BASIC_GROUND_COMBAT_SOLDIER(3, "Basic Ground Combat Soldier"),
    ENHANCED_GROUND_COMBAT_SOLDIER(4, "Enhanced Ground Combat Soldier"),
    BASIC_ROTOR_WING_AIRCRAFT(5, "Basic Rotor Wing Aircraft"),
    ENHANCED_ROTOR_WING_AIRCRAFT(6, "Enhanced Rotor Wing Aircraft"),
    BASIC_FIXED_WING_AIRCRAFT(7, "Basic Fixed Wing Aircraft"),
    ENHANCED_FIXED_WING_AIRCRAFT(8, "Enhanced Fixed Wing Aircraft"),
    GROUND_LOGISTICS_VEHICLE(9, "Ground Logistics Vehicle");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public GroupedEntityCategory lookup[] = new GroupedEntityCategory[10];

/* initialize the array at class load time */
static 
{
    for(GroupedEntityCategory anEnum:GroupedEntityCategory.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
GroupedEntityCategory(int value, String description)
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
