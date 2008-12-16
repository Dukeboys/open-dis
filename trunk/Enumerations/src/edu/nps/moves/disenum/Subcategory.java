package edu.nps.moves.disenum;

/** Enumeration values for Subcategory
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Subcategory 
{

    OTHER(0, "Other"),
    CAVALRY_TROOP(1, "Cavalry Troop"),
    ARMOR(2, "Armor"),
    INFANTRY(3, "Infantry"),
    MECHANIZED_INFANTRY(4, "Mechanized Infantry"),
    CAVALRY(5, "Cavalry"),
    ARMORED_CAVALRY(6, "Armored Cavalry"),
    ARTILLERY(7, "Artillery"),
    SELF_PROPELLED_ARTILLERY(8, "Self-propelled Artillery"),
    CLOSE_AIR_SUPPORT(9, "Close Air Support"),
    ENGINEER(10, "Engineer"),
    AIR_DEFENSE_ARTILLERY(11, "Air Defense Artillery"),
    ANTI_TANK(12, "Anti-tank"),
    ARMY_AVIATION_FIXED_WING(13, "Army Aviation Fixed-wing"),
    ARMY_AVIATION_ROTARY_WING(14, "Army Aviation Rotary-wing"),
    ARMY_ATTACK_HELICOPTER(15, "Army Attack Helicopter"),
    AIR_CAVALRY(16, "Air Cavalry"),
    ARMOR_HEAVY_TASK_FORCE(17, "Armor Heavy Task Force"),
    MOTORIZED_RIFLE(18, "Motorized Rifle"),
    MECHANIZED_HEAVY_TASK_FORCE(19, "Mechanized Heavy Task Force"),
    COMMAND_POST(20, "Command Post"),
    CEWI(21, "CEWI"),
    TANK_ONLY(22, "Tank only");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Subcategory lookup[] = new Subcategory[23];

/* initialize the array at class load time */
static 
{
    for(Subcategory anEnum:Subcategory.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Subcategory(int value, String description)
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
