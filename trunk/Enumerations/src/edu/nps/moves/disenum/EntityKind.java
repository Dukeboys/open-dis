package edu.nps.moves.disenum;

/** Enumeration values for EntityKind
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG
 */

public enum EntityKind 
{

    OTHER(0, "Other"),
    PLATFORM(1, "Platform"),
    MUNITION(2, "Munition"),
    LIFE_FORM(3, "Life form"),
    ENVIRONMENTAL(4, "Environmental"),
    CULTURAL_FEATURE(5, "Cultural feature"),
    SUPPLY(6, "Supply"),
    RADIO(7, "Radio"),
    EXPENDABLE(8, "Expendable"),
    SENSOR_EMITTER(9, "Sensor/Emitter");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public EntityKind lookup[] = new EntityKind[10];

/* initialize the array at class load time */
static 
{
    for(EntityKind anEnum:EntityKind.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
EntityKind(int value, String description)
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
