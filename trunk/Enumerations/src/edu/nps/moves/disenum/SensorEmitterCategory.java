package edu.nps.moves.disenum;

/** Enumeration values for SensorEmitterCategory
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum SensorEmitterCategory 
{

    OTHER(0, "Other"),
    MULTI_SPECTRAL(1, "Multi-spectral"),
    RF_ACTIVE(2, "RF Active"),
    RF_PASSIVE_INTERCEPT_AND_DF(3, "RF Passive (intercept and DF)"),
    OPTICAL_DIRECT_VIEWING_WITH_OR_WITHOUT_OPTICS(4, "Optical (direct viewing with or without optics)"),
    ELECTRO_OPTICAL(5, "Electro-Optical"),
    SEISMIC(6, "Seismic"),
    CHEMICAL_POINT_DETECTOR(7, "Chemical, point detector"),
    CHEMICAL_STANDOFF(8, "Chemical, standoff"),
    THERMAL_TEMPERATURE_SENSING(9, "Thermal (temperature sensing)"),
    ACOUSTIC_ACTIVE(10, "Acoustic, Active"),
    ACOUSTIC_PASSIVE(11, "Acoustic, Passive"),
    CONTACT_PRESSURE_PHYSICAL_HYDROSTATIC_BAROMETRIC(12, "Contact/Pressure (physical, hydrostatic, barometric)"),
    ELECTRO_MAGNETIC_RADIATION_GAMMA_RADIATION(13, "Electro-Magnetic Radiation (gamma radiation)"),
    PARTICLE_RADIATION_NEUTRONS_ALPHA_BETA_PARTICLES(14, "Particle Radiation (Neutrons, alpha, beta particles)"),
    MAGNETIC(15, "Magnetic"),
    GRAVITATIONAL(16, "Gravitational");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public SensorEmitterCategory lookup[] = new SensorEmitterCategory[17];

/* initialize the array at class load time */
static 
{
    for(SensorEmitterCategory anEnum:SensorEmitterCategory.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
SensorEmitterCategory(int value, String description)
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
