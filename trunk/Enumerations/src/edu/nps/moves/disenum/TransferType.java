package edu.nps.moves.disenum;

/** Enumeration values for TransferType
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum TransferType 
{

    OTHER(0, "Other"),
    CONTROLLING_APPLICATION_REQUESTS_TRANSFER_OF_AN_ENTITY(1, "Controlling application requests transfer of an entity"),
    APPLICATION_DESIRING_CONTROL_REQUESTS_TRANSFER_OF_AN_ENTITY(2, "Application desiring control requests transfer of an entity"),
    MUTUAL_EXCHANGE_SWAP_OF_AN_ENTITY(3, "Mutual exchange / swap of an entity"),
    CONTROLLING_APPLICATION_REQUESTS_TRANSFER_OF_AN_ENVIRONMENTAL_PROCESS(4, "Controlling application requests transfer of an environmental process"),
    APPLICATION_DESIRING_CONTROLS_REQUESTS_TRANSFER_OF_AN_ENVIRONMENTAL_PROCESS(5, "Application desiring controls requests transfer of an environmental process"),
    MUTUAL_EXCHANGE_SWAP_OF_AN_ENVIRONMENTAL(6, "Mutual exchange / swap of an environmental"),
    CANCEL_TRANSFER(7, "Cancel transfer");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public TransferType lookup[] = new TransferType[8];

/* initialize the array at class load time */
static 
{
    for(TransferType anEnum:TransferType.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
TransferType(int value, String description)
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
