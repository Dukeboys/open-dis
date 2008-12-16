package edu.nps.moves.disenum;

/** Enumeration values for UserProtocolIDNum
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum UserProtocolIDNum 
{

    CCSIL(1, "CCSIL"),
    A2ATD_SINCGARS_ERF(5, "A2ATD SINCGARS ERF"),
    A2ATD_CAC2(6, "A2ATD CAC2"),
    BATTLE_COMMAND(20, "Battle Command"),
    AFIWC_IADS_TRACK_REPORT(30, "AFIWC IADS Track Report"),
    AFIWC_IADS_COMM_C2_MESSAGE(31, "AFIWC IADS Comm C2 Message"),
    AFIWC_IADS_GROUND_CONTROL_INTERCEPTOR_GCI_COMMAND(32, "AFIWC IADS Ground Control Interceptor (GCI) Command"),
    AFIWC_VOICE_TEXT_MESSAGE(35, "AFIWC Voice Text Message"),
    MODSAF_TEXT_RADIO(177, "ModSAF Text Radio"),
    CCTT_SINCGARS_ERF_LOCKOUT(200, "CCTT SINCGARS ERF-LOCKOUT"),
    CCTT_SINCGARS_ERF_HOPSET(201, "CCTT SINCGARS ERF-HOPSET"),
    CCTT_SINCGARS_OTAR(202, "CCTT SINCGARS OTAR"),
    CCTT_SINCGARS_DATA(203, "CCTT SINCGARS DATA"),
    MODSAF_FWA_FORWARD_AIR_CONTROLLER(546, "ModSAF FWA Forward Air Controller"),
    MODSAF_THREAT_ADA_C3(832, "ModSAF Threat ADA C3"),
    F_16_MTC_AFAPD_PROTOCOL(1000, "F-16 MTC AFAPD Protocol"),
    F_16_MTC_IDL_PROTOCOL(1100, "F-16 MTC IDL Protocol"),
    MODSAF_ARTILLERY_FIRE_CONTROL(4570, "ModSAF Artillery Fire Control"),
    AGTS(5361, "AGTS"),
    GC3(6000, "GC3"),
    WNCP_DATA(6010, "WNCP data"),
    SPOKEN_TEXT_MESSAGE(6020, "Spoken text message"),
    LONGBOW_IDM_MESSAGE(6661, "Longbow IDM message"),
    COMANCHE_IDM_MESSAGE(6662, "Comanche IDM message"),
    LONGBOW_AIRBORNE_TACFIRE_MESSAGE(6663, "Longbow Airborne TACFIRE Message"),
    LONGBOW_GROUND_TACFIRE_MESSAGE(6664, "Longbow Ground TACFIRE Message"),
    LONGBOW_AFAPD_MESSAGE(6665, "Longbow AFAPD Message"),
    LONGBOW_ERF_MESSAGE(6666, "Longbow ERF message");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public UserProtocolIDNum lookup[] = new UserProtocolIDNum[6667];

/* initialize the array at class load time */
static 
{
    for(UserProtocolIDNum anEnum:UserProtocolIDNum.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
UserProtocolIDNum(int value, String description)
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
