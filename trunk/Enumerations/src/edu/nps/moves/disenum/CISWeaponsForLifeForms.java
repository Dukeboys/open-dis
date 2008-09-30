package edu.nps.moves.disenum;

/** Enumeration values for CISWeaponsForLifeForms
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG
 */

public enum CISWeaponsForLifeForms 
{

    AUTOMATIC_APS_9_MM_STECHKIN(201, "Automatic (APS) 9-mm, Stechkin"),
    PSM_545_MM(202, "PSM 5.45-mm"),
    SELF_LOADING_PM_9_MM_MAKAROV(203, "Self-loading (PM) 9-mm, Makarov"),
    TT_33_762_MM_TOKAREV(204, "TT-33 7.62-mm, Tokarev"),
    ASSAULT_RIFLE_AK_AND_AKM_762_MM(205, "Assault rifle AK and AKM, 7.62-mm"),
    ASSAULT_RIFLE_AK_74_AND_AKS_74_545_MM(206, "Assault rifle AK-74 and AKS-74, 5.45-mm"),
    SELF_LOADING_RIFLE_SKS_762_MM_SIMONOV(207, "Self-loading rifle (SKS), 7.62-mm, Simonov"),
    SNIPER_RIFLE_SVD_762_MM_DRAGUNOV(208, "Sniper rifle SVD 7.62-mm, Dragunov"),
    AKSU_74_545_MM(209, "AKSU-74 5.45-mm"),
    PPS_43_762_MM(210, "PPS-43 7.62-mm"),
    PPSH_41_762_MM(211, "PPSh-41 7.62-mm"),
    GENERAL_PURPOSE_PK_762_MM(212, "General purpose PK 7.62-mm"),
    HEAVY_DSHK_38_AND_MODEL_38_46_127_MM_DEGTYAREV(213, "Heavy DShK-38 and Model 38/46 12.7-mm, Degtyarev"),
    HEAVY_NSV_127_MM(214, "Heavy NSV 12.7-mm"),
    LIGHT_RPD_762_MM(215, "Light RPD 7.62-mm"),
    LIGHT_RPK_762_MM(216, "Light RPK 7.62-mm"),
    LIGHT_RPK_74_545_MM(217, "Light RPK-74 5.45-mm"),
    HAND_GRENADE_M75(218, "Hand grenade M75"),
    HAND_GRENADE_RGD_5(219, "Hand grenade RGD-5"),
    AP_HAND_GRENADE_F1(220, "AP hand grenade F1"),
    AT_HAND_GRENADE_RKG_3(221, "AT hand grenade RKG-3"),
    AT_HAND_GRENADE_RKG_3M(222, "AT hand grenade RKG-3M"),
    AT_HAND_GRENADE_RKG_3T(223, "AT hand grenade RKG-3T"),
    FRAGMENTATION_HAND_GRENADE_RGN(224, "Fragmentation hand grenade RGN"),
    FRAGMENTATION_HAND_GRENADE_RGO(225, "Fragmentation hand grenade RGO"),
    SMOKE_HAND_GRENADE_RDG_1(226, "Smoke hand grenade RDG-1"),
    PLAMYA_LAUNCHER_30_MM_AGS_17(227, "Plamya launcher, 30-mm AGS-17"),
    RIFLE_MOUNTED_LAUNCHER_BG_15_40_MM(228, "Rifle-mounted launcher, BG-15 40-mm"),
    LPO_50(229, "LPO-50"),
    ROKS_3(230, "ROKS-3"),
    CART_MOUNTED_TPO_50(231, "Cart-mounted TPO-50"),
    GIMLET_SA_16(232, "Gimlet SA-16"),
    GRAIL_SA_7(233, "Grail SA-7"),
    GREMLIN_SA_14(234, "Gremlin SA-14"),
    SAGGER_AT_3_MCLOS(235, "Sagger AT-3 (MCLOS)"),
    SAXHORN_AT_7(236, "Saxhorn AT-7"),
    SPIGOT_A_B_AT_14(237, "Spigot A/B AT-14"),
    SA_18(238, "SA-18"),
    SA_19(239, "SA-19"),
    GRAD_1P_MANPORTABLE_TRIPOD_ROCKET_LAUNCHER_122_MM_FOR_SPESNATZ_AND_OTHER_SPECIALISTS_AKA_9P132(240, "Grad-1P manportable tripod rocket launcher, 122-mm (for Spesnatz and other specialists; aka 9P132)"),
    LIGHT_ANTI_ARMOR_WEAPON_RPG_18(241, "Light anti-armor weapon RPG-18"),
    LIGHT_ANTITANK_WEAPON_RPG_22(242, "Light antitank weapon RPG-22"),
    MG_RPG(243, "MG & RPG"),
    PORTABLE_ROCKET_LAUNCHER_RPG_16(244, "Portable rocket launcher RPG-16"),
    RECOILLESS_GUN_73_MM_SPG_9(245, "Recoilless gun 73-mm SPG-9"),
    VAT_ROCKET_LAUNCHER_RPG_7(246, "VAT rocket launcher RPG-7"),
    MON_50_ANTIPERSONNEL_MINE(248, "Mon-50 antipersonnel mine");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public CISWeaponsForLifeForms lookup[] = new CISWeaponsForLifeForms[249];

/* initialize the array at class load time */
static 
{
    for(CISWeaponsForLifeForms anEnum:CISWeaponsForLifeForms.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
CISWeaponsForLifeForms(int value, String description)
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
