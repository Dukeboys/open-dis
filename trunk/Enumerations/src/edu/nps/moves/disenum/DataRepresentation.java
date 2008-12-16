package edu.nps.moves.disenum;

/** Enumeration values for DataRepresentation
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum DataRepresentation 
{

    TYPE_0(0, "Type 0"),
    TYPE_1(1, "Type 1"),
    TYPE_2(2, "Type 2");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public DataRepresentation lookup[] = new DataRepresentation[3];

/* initialize the array at class load time */
static 
{
    for(DataRepresentation anEnum:DataRepresentation.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
DataRepresentation(int value, String description)
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
