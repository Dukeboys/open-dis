package edu.nps.moves.disenum;

/** Enumeration values for RadioCategory
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum RadioCategory 
{

    OTHER(0, "Other"),
    VOICE_TRANSMISSION_RECEPTION(1, "Voice Transmission/Reception"),
    DATA_LINK_TRANSMISSION_RECEPTION(2, "Data Link Transmission/Reception"),
    VOICE_AND_DATA_LINK_TRANSMISSION_RECEPTION(3, "Voice and Data Link Transmission/Reception"),
    INSTRUMENTED_LANDING_SYSTEM_ILS_GLIDESLOPE_TRANSMITTER(4, "Instrumented Landing System (ILS) Glideslope Transmitter"),
    INSTRUMENTED_LANDING_SYSTEM_ILS_LOCALIZER_TRANSMITTER(5, "Instrumented Landing System (ILS) Localizer Transmitter"),
    INSTRUMENTED_LANDING_SYSTEM_ILS_OUTER_MARKER_BEACON(6, "Instrumented Landing System (ILS) Outer Marker Beacon"),
    INSTRUMENTED_LANDING_SYSTEM_ILS_MIDDLE_MARKER_BEACON(7, "Instrumented Landing System (ILS) Middle Marker Beacon"),
    INSTRUMENTED_LANDING_SYSTEM_ILS_INNER_MARKER_BEACON(8, "Instrumented Landing System (ILS) Inner Marker Beacon"),
    INSTRUMENTED_LANDING_SYSTEM_ILS_RECEIVER_PLATFORM_RADIO(9, "Instrumented Landing System (ILS) Receiver (Platform Radio)"),
    TACTICAL_AIR_NAVIGATION_TACAN_TRANSMITTER_GROUND_FIXED_EQUIPMENT(10, "Tactical Air Navigation (TACAN) Transmitter (Ground Fixed Equipment)"),
    TACTICAL_AIR_NAVIGATION_TACAN_RECEIVER_MOVING_PLATFORM_EQUIPMENT(11, "Tactical Air Navigation (TACAN) Receiver (Moving Platform Equipment)"),
    TACTICAL_AIR_NAVIGATION_TACAN_TRANSMITTER_RECEIVER_MOVING_PLATFORM_EQUIPMENT(12, "Tactical Air Navigation (TACAN) Transmitter/Receiver (Moving Platform Equipment)"),
    VARIABLE_OMNI_RANGING_VOR_TRANSMITTER_GROUND_FIXED_EQUIPMENT(13, "Variable Omni-Ranging (VOR) Transmitter (Ground Fixed Equipment)"),
    VARIABLE_OMNI_RANGING_VOR_WITH_DISTANCE_MEASURING_EQUIPMENT_DME_TRANSMITTER_GROUND_FIXED_EQUIPMENT(14, "Variable Omni-Ranging (VOR) with Distance Measuring Equipment (DME) Transmitter (Ground Fixed Equipment)"),
    COMBINED_VOR_ILS_RECEIVER_MOVING_PLATFORM_EQUIPMENT(15, "Combined VOR/ILS Receiver (Moving Platform Equipment)"),
    COMBINED_VOR_TACAN_VORTAC_TRANSMITTER(16, "Combined VOR & TACAN (VORTAC) Transmitter"),
    NON_DIRECTIONAL_BEACON_NDB_TRANSMITTER(17, "Non-Directional Beacon (NDB) Transmitter"),
    NON_DIRECTIONAL_BEACON_NDB_RECEIVER(18, "Non-Directional Beacon (NDB) Receiver"),
    NON_DIRECTIONAL_BEACON_NDB_WITH_DISTANCE_MEASURING_EQUIPMENT_DME_TRANSMITTER(19, "Non-Directional Beacon (NDB) with Distance Measuring Equipment (DME) Transmitter"),
    DISTANCE_MEASURING_EQUIPMENT_DME(20, "Distance Measuring Equipment (DME)");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public RadioCategory lookup[] = new RadioCategory[21];

/* initialize the array at class load time */
static 
{
    for(RadioCategory anEnum:RadioCategory.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
RadioCategory(int value, String description)
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
