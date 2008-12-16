package edu.nps.moves.disenum;

/** Enumeration values for DetailedModAmpMod
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum DetailedModAmpMod 
{

    OTHER(0, "Other"),
    AFSK_AUDIO_FREQUENCY_SHIFT_KEYING(1, "AFSK (Audio Frequency Shift Keying)"),
    AM_AMPLITUDE_MODULATION(2, "AM (Amplitude Modulation)"),
    CW_CONTINUOUS_WAVE_MODULATION(3, "CW (Continuous Wave Modulation)"),
    DSB_DOUBLE_SIDEBAND(4, "DSB (Double Sideband)"),
    ISB_INDEPENDENT_SIDEBAND(5, "ISB (Independent Sideband)"),
    LSB_SINGLE_BAND_SUPPRESSED_CARRIER_LOWER_SIDEBAND_MODE(6, "LSB (Single Band Suppressed Carrier, Lower Sideband Mode)"),
    SSB_FULL_SINGLE_SIDEBAND_FULL_CARRIER(7, "SSB-Full (Single Sideband Full Carrier)"),
    SSB_REDUC_SINGLE_BAND_REDUCED_CARRIER(8, "SSB-Reduc (Single Band Reduced Carrier)"),
    USB_SINGLE_BAND_SUPPRESSED_CARRIER_UPPER_SIDEBAND_MODE(9, "USB (Single Band Suppressed Carrier, Upper Sideband Mode)"),
    VSB_VESTIGIAL_SIDEBAND(10, "VSB (Vestigial Sideband)");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public DetailedModAmpMod lookup[] = new DetailedModAmpMod[11];

/* initialize the array at class load time */
static 
{
    for(DetailedModAmpMod anEnum:DetailedModAmpMod.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
DetailedModAmpMod(int value, String description)
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
