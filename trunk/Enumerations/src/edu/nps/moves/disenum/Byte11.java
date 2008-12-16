package edu.nps.moves.disenum;

/** Enumeration values for Byte11
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum Byte11 
{

    _CARET_(94, "^"),
    _GT_(62, ">"),
    INVERTED_CARROT(86, "inverted carrot"),
    _LT_(60, "<"),
    _CARET_AND_INVERTED_CARROT(126, "^ and inverted carrot"),
    _LT_GT_(61, "< >");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public Byte11 lookup[] = new Byte11[127];

/* initialize the array at class load time */
static 
{
    for(Byte11 anEnum:Byte11.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
Byte11(int value, String description)
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
