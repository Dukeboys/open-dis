package edu.nps.moves.disenum;

/** Enumeration values for InputSource
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum InputSource 
{

    OTHER(0, "Other"),
    PILOT(1, "Pilot"),
    COPILOT(2, "Copilot"),
    FIRST_OFFICER(3, "First Officer"),
    DRIVER(4, "Driver"),
    LOADER(5, "Loader"),
    GUNNER(6, "Gunner"),
    COMMANDER(7, "Commander"),
    DIGITAL_DATA_DEVICE(8, "Digital Data Device"),
    INTERCOM(9, "Intercom");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public InputSource lookup[] = new InputSource[10];

/* initialize the array at class load time */
static 
{
    for(InputSource anEnum:InputSource.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
InputSource(int value, String description)
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
