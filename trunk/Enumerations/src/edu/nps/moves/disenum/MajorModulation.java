package edu.nps.moves.disenum;

/** Enumeration values for MajorModulation
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum MajorModulation 
{

    OTHER(0, "Other"),
    AMPLITUDE(1, "Amplitude"),
    AMPLITUDE_AND_ANGLE(2, "Amplitude and Angle"),
    ANGLE(3, "Angle"),
    COMBINATION(4, "Combination"),
    PULSE(5, "Pulse"),
    UNMODULATED(6, "Unmodulated"),
    CARRIER_PHASE_SHIFT_MODULATION_CPSM(7, "Carrier Phase Shift Modulation (CPSM)");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public MajorModulation lookup[] = new MajorModulation[8];

/* initialize the array at class load time */
static 
{
    for(MajorModulation anEnum:MajorModulation.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
MajorModulation(int value, String description)
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
