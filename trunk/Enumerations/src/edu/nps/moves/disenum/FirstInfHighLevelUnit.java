package edu.nps.moves.disenum;

/** Enumeration values for FirstInfHighLevelUnit
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum FirstInfHighLevelUnit 
{

    X_1_16INF(1, "1-16INF"),
    X_2_16INF(2, "2-16INF"),
    X_1_34AR(3, "1-34AR"),
    X_2_34AR(4, "2-34AR"),
    X_3_37AR(5, "3-37AR"),
    X_4_37AR(6, "4-37AR"),
    X_1_118INF(7, "1-118INF"),
    X_4_118INF(8, "4-118INF"),
    X_2_265AR(9, "2-265AR"),
    X_2_136IF(10, "2-136IF"),
    X_1_5F(20, "1-5F"),
    X_4_5F(21, "4-5F"),
    X_1_178F(22, "1-178F"),
    X_6F(23, "6F"),
    X_25F(24, "25F"),
    X_1E(30, "1E"),
    X_70E(31, "70E"),
    X_4_1AVN(32, "4-1AVN"),
    X_1_1AVN(33, "1-1AVN"),
    X_2_3ADA(34, "2-3ADA"),
    X_1_4CAV(35, "1-4CAV"),
    X_701MSB(40, "701MSB"),
    X_101FSB(41, "101FSB"),
    X_201FSB(42, "201FSB"),
    X_163FSB(43, "163FSB"),
    X_101MI(45, "101MI"),
    X_121S(46, "121S"),
    X_1MP(47, "1MP"),
    X_12CML(48, "12CML"),
    X_1INF(50, "1INF"),
    XBDE(51, "XBDE"),
    AVNBDE(55, "AVNBDE"),
    E(56, "E"),
    F(57, "F"),
    DSC(58, "DSC");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public FirstInfHighLevelUnit lookup[] = new FirstInfHighLevelUnit[59];

/* initialize the array at class load time */
static 
{
    for(FirstInfHighLevelUnit anEnum:FirstInfHighLevelUnit.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
FirstInfHighLevelUnit(int value, String description)
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
