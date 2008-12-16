package edu.nps.moves.disenum;

/** Enumeration values for Warhead
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Warhead 
{

    OTHER(0, "Other"),
    CARGO_VARIABLE_SUBMUNITIONS(10, "Cargo (Variable Submunitions)"),
    FUEL_AIR_EXPLOSIVE(20, "Fuel/Air Explosive"),
    GLASS_BEADS(30, "Glass Beads"),
    X_1_UM(31, "1 um"),
    X_5_UM(32, "5 um"),
    X_10_UM(33, "10 um"),
    HIGH_EXPLOSIVE_HE(1000, "High Explosive (HE)"),
    HE_PLASTIC(1100, "HE, Plastic"),
    HE_INCENDIARY(1200, "HE, Incendiary"),
    HE_FRAGMENTATION(1300, "HE, Fragmentation"),
    HE_ANTITANK(1400, "HE, Antitank"),
    HE_BOMBLETS(1500, "HE, Bomblets"),
    HE_SHAPED_CHARGE(1600, "HE, Shaped Charge"),
    HE_CONTINUOUS_ROD(1610, "HE, Continuous Rod"),
    HE_TUNGSTEN_BALL(1615, "HE, Tungsten Ball"),
    HE_BLAST_FRAGMENTATION(1620, "HE, Blast Fragmentation"),
    HE_STEERABLE_DARTS_WITH_HE(1625, "HE, Steerable Darts with HE"),
    HE_DARTS(1630, "HE, Darts"),
    HE_FLECHETTES(1635, "HE, Flechettes"),
    HE_DIRECTED_FRAGMENTATION(1640, "HE, Directed Fragmentation"),
    HE_SEMI_ARMOR_PIERCING_SAP(1645, "HE, Semi-Armor Piercing (SAP)"),
    HE_SHAPED_CHARGE_FRAGMENTATION(1650, "HE, Shaped Charge Fragmentation"),
    HE_SEMI_ARMOR_PIERCING_FRAGMENTATION(1655, "HE, Semi-Armor Piercing, Fragmentation"),
    HE_HOLLOW_CHARGE(1660, "HE, Hollow Charge"),
    HE_DOUBLE_HOLLOW_CHARGE(1665, "HE, Double Hollow Charge"),
    HE_GENERAL_PURPOSE(1670, "HE, General Purpose"),
    HE_BLAST_PENETRATOR(1675, "HE, Blast Penetrator"),
    HE_ROD_PENETRATOR(1680, "HE, Rod Penetrator"),
    HE_ANTIPERSONNEL(1685, "HE, Antipersonnel"),
    SMOKE(2000, "Smoke"),
    ILLUMINATION(3000, "Illumination"),
    PRACTICE(4000, "Practice"),
    KINETIC(5000, "Kinetic"),
    MINES(6000, "Mines"),
    NUCLEAR(7000, "Nuclear"),
    NUCLEAR_IMT(7010, "Nuclear, IMT"),
    CHEMICAL_GENERAL(8000, "Chemical, General"),
    CHEMICAL_BLISTER_AGENT(8100, "Chemical, Blister Agent"),
    HD_MUSTARD(8110, "HD (Mustard)"),
    THICKENED_HD_MUSTARD(8115, "Thickened HD (Mustard)"),
    DUSTY_HD_MUSTARD(8120, "Dusty HD (Mustard)"),
    CHEMICAL_BLOOD_AGENT(8200, "Chemical, Blood Agent"),
    AC_HCN(8210, "AC (HCN)"),
    CK_CNCI(8215, "CK (CNCI)"),
    CG_PHOSGENE(8220, "CG (Phosgene)"),
    CHEMICAL_NERVE_AGENT(8300, "Chemical, Nerve Agent"),
    VX(8310, "VX"),
    THICKENED_VX(8315, "Thickened VX"),
    DUSTY_VX(8320, "Dusty VX"),
    GA_TABUN(8325, "GA (Tabun)"),
    THICKENED_GA_TABUN(8330, "Thickened GA (Tabun)"),
    DUSTY_GA_TABUN(8335, "Dusty GA (Tabun)"),
    GB_SARIN(8340, "GB (Sarin)"),
    THICKENED_GB_SARIN(8345, "Thickened GB (Sarin)"),
    DUSTY_GB_SARIN(8350, "Dusty GB (Sarin)"),
    GD_SOMAN(8355, "GD (Soman)"),
    THICKENED_GD_SOMAN(8360, "Thickened GD (Soman)"),
    DUSTY_GD_SOMAN(8365, "Dusty GD (Soman)"),
    GF(8370, "GF"),
    THICKENED_GF(8375, "Thickened GF"),
    DUSTY_GF(8380, "Dusty GF"),
    BIOLOGICAL(9000, "Biological"),
    BIOLOGICAL_VIRUS(9100, "Biological, Virus"),
    BIOLOGICAL_BACTERIA(9200, "Biological, Bacteria"),
    BIOLOGICAL_RICKETTSIA(9300, "Biological, Rickettsia"),
    BIOLOGICAL_GENETICALLY_MODIFIED_MICRO_ORGANISMS(9400, "Biological, Genetically Modified Micro-organisms"),
    BIOLOGICAL_TOXIN(9500, "Biological, Toxin");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Warhead lookup[] = new Warhead[9501];

/* initialize the array at class load time */
static 
{
    for(Warhead anEnum:Warhead.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Warhead(int value, String description)
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
