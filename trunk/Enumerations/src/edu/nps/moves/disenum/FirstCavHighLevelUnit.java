package edu.nps.moves.disenum;

/** Enumeration values for FirstCavHighLevelUnit
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum FirstCavHighLevelUnit 
{

    X_1_7CAV(1, "1-7CAV"),
    X_2_5CAV(2, "2-5CAV"),
    X_2_8CAV(3, "2-8CAV"),
    X_3_32AR(4, "3-32AR"),
    X_1_5CAV(5, "1-5CAV"),
    X_1_8CAV(6, "1-8CAV"),
    X_1_32AR(7, "1-32AR"),
    X_1_67AR(8, "1-67AR"),
    X_3_67AR(9, "3-67AR"),
    X_3_41INF(10, "3-41INF"),
    X_1_82F(20, "1-82F"),
    X_3_82F(21, "3-82F"),
    X_1_3F(22, "1-3F"),
    X_21F(23, "21F"),
    X_92F(24, "92F"),
    X_8E(30, "8E"),
    X_20E(31, "20E"),
    X_91E(32, "91E"),
    X_1_227AVN(34, "1-227AVN"),
    X_4_227AVN(35, "4-227AVN"),
    F_227AVN(36, "F-227AVN"),
    X_4_5ADA(37, "4-5ADA"),
    X_15MSB(40, "15MSB"),
    X_27FSB(41, "27FSB"),
    X_115FSB(42, "115FSB"),
    X_215FSB(43, "215FSB"),
    X_312MI(45, "312MI"),
    X_13S(46, "13S"),
    X_545MP(47, "545MP"),
    X_68CML(48, "68CML"),
    X_1CAV(50, "1CAV"),
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
static public FirstCavHighLevelUnit lookup[] = new FirstCavHighLevelUnit[59];

/* initialize the array at class load time */
static 
{
    for(FirstCavHighLevelUnit anEnum:FirstCavHighLevelUnit.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
FirstCavHighLevelUnit(int value, String description)
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
