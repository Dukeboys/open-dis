package edu.nps.moves.disenum;

/** Enumeration values for PlatformSurface
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG
 */

public enum PlatformSurface 
{

    OTHER(0, "Other"),
    CARRIER(1, "Carrier"),
    COMMAND_SHIP_CRUISER(2, "Command Ship/Cruiser"),
    GUIDED_MISSILE_CRUISER(3, "Guided Missile Cruiser"),
    GUIDED_MISSILE_DESTROYER_DDG(4, "Guided Missile Destroyer (DDG)"),
    DESTROYER_DD(5, "Destroyer (DD)"),
    GUIDED_MISSILE_FRIGATE_FFG(6, "Guided Missile Frigate (FFG)"),
    LIGHT_PATROL_CRAFT(7, "Light/Patrol Craft"),
    MINE_COUNTERMEASURE_SHIP_CRAFT(8, "Mine Countermeasure Ship/Craft"),
    DOCK_LANDING_SHIP(9, "Dock Landing Ship"),
    TANK_LANDING_SHIP(10, "Tank Landing Ship"),
    LANDING_CRAFT(11, "Landing Craft"),
    LIGHT_CARRIER(12, "Light Carrier"),
    CRUISER_HELICOPTER_CARRIER(13, "Cruiser/Helicopter Carrier"),
    HYDROFOIL(14, "Hydrofoil"),
    AIR_CUSHION_SURFACE_EFFECT(15, "Air Cushion/Surface Effect"),
    AUXILIARY(16, "Auxiliary"),
    AUXILIARY_MERCHANT_MARINE(17, "Auxiliary, Merchant Marine"),
    UTILITY(18, "Utility"),
    FRIGATE_INCLUDING_CORVETTE(50, "Frigate (including Corvette)"),
    BATTLESHIP(51, "Battleship"),
    HEAVY_CRUISER(52, "Heavy Cruiser"),
    DESTROYER_TENDER(53, "Destroyer Tender"),
    AMPHIBIOUS_ASSAULT_SHIP(54, "Amphibious Assault Ship"),
    AMPHIBIOUS_CARGO_SHIP(55, "Amphibious Cargo Ship"),
    AMPHIBIOUS_TRANSPORT_DOCK(56, "Amphibious Transport Dock"),
    AMMUNITION_SHIP(57, "Ammunition Ship"),
    COMBAT_STORES_SHIP(58, "Combat Stores Ship"),
    SURVEILLANCE_TOWED_ARRAY_SONAR_SYSTEM_SURTASS(59, "Surveillance Towed Array Sonar System (SURTASS)"),
    FAST_COMBAT_SUPPORT_SHIP(60, "Fast Combat Support Ship"),
    NON_COMBATANT_SHIP(61, "Non-Combatant Ship"),
    COAST_GUARD_CUTTERS(62, "Coast Guard Cutters"),
    COAST_GUARD_BOATS(63, "Coast Guard Boats");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public PlatformSurface lookup[] = new PlatformSurface[64];

/* initialize the array at class load time */
static 
{
    for(PlatformSurface anEnum:PlatformSurface.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
PlatformSurface(int value, String description)
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
