package edu.nps.moves.disenum;

/** Enumeration values for DetonationResult
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum DetonationResult 
{

    OTHER(0, "Other"),
    ENTITY_IMPACT(1, "Entity Impact"),
    ENTITY_PROXIMATE_DETONATION(2, "Entity Proximate Detonation"),
    GROUND_IMPACT(3, "Ground Impact"),
    GROUND_PROXIMATE_DETONATION(4, "Ground Proximate Detonation"),
    DETONATION(5, "Detonation"),
    NONE_OR_NO_DETONATION_DUD(6, "None or No Detonation (Dud)"),
    HE_HIT_SMALL(7, "HE hit, small"),
    HE_HIT_MEDIUM(8, "HE hit, medium"),
    HE_HIT_LARGE(9, "HE hit, large"),
    ARMOR_PIERCING_HIT(10, "Armor-piercing hit"),
    DIRT_BLAST_SMALL(11, "Dirt blast, small"),
    DIRT_BLAST_MEDIUM(12, "Dirt blast, medium"),
    DIRT_BLAST_LARGE(13, "Dirt blast, large"),
    WATER_BLAST_SMALL(14, "Water blast, small"),
    WATER_BLAST_MEDIUM(15, "Water blast, medium"),
    WATER_BLAST_LARGE(16, "Water blast, large"),
    AIR_HIT(17, "Air hit"),
    BUILDING_HIT_SMALL(18, "Building hit, small"),
    BUILDING_HIT_MEDIUM(19, "Building hit, medium"),
    BUILDING_HIT_LARGE(20, "Building hit, large"),
    MINE_CLEARING_LINE_CHARGE(21, "Mine-clearing line charge"),
    ENVIRONMENT_OBJECT_IMPACT(22, "Environment object impact"),
    ENVIRONMENT_OBJECT_PROXIMATE_DETONATION(23, "Environment object proximate detonation"),
    WATER_IMPACT(24, "Water Impact"),
    AIR_BURST(25, "Air Burst"),
    KILL_WITH_FRAGMENT_TYPE_1(26, "Kill with fragment type 1"),
    KILL_WITH_FRAGMENT_TYPE_2(27, "Kill with fragment type 2"),
    KILL_WITH_FRAGMENT_TYPE_3(28, "Kill with fragment type 3"),
    KILL_WITH_FRAGMENT_TYPE_1_AFTER_FLY_OUT_FAILURE(29, "Kill with fragment type 1 after fly-out failure"),
    KILL_WITH_FRAGMENT_TYPE_2_AFTER_FLY_OUT_FAILURE(30, "Kill with fragment type 2 after fly-out failure"),
    MISS_DUE_TO_FLY_OUT_FAILURE(31, "Miss due to fly-out failure"),
    MISS_DUE_TO_END_GAME_FAILURE(32, "Miss due to end-game failure"),
    MISS_DUE_TO_FLY_OUT_AND_END_GAME_FAILURE(33, "Miss due to fly-out and end-game failure");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public DetonationResult lookup[] = new DetonationResult[34];

/* initialize the array at class load time */
static 
{
    for(DetonationResult anEnum:DetonationResult.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
DetonationResult(int value, String description)
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
