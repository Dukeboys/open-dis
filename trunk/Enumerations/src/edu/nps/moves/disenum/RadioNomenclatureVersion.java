package edu.nps.moves.disenum;

/** Enumeration values for RadioNomenclatureVersion
 * The enumeration values are generated from the SISO DIS XML EBV document, which was
 * obtained from http://discussions.sisostds.org/default.asp?action=10&fd=31
 *
 * Copyright 2008. This work is licensed under the BSD license, available at
 * http://www.movesinstitute.org/licenses
 *
 * @author DMcG, Jason Nelson
 */

public enum RadioNomenclatureVersion 
{

    OTHER(0, "Other"),
    JOINT_ELECTRONICS_TYPE_DESIGNATION_SYSTEM_JETDS_NOMENCLATURE_AN_PER_MIL_STD_196(1, "Joint Electronics Type Designation System (JETDS) Nomenclature (AN/ per Mil-STD-196)"),
    MANUFACTURER_DESIGNATION(2, "Manufacturer Designation"),
    NATIONAL_DESIGNATION(3, "National Designation");

    /** The enumerated value */
    public final int value;

    /** Text/english description of the enumerated value */
    public final String description;

/** This is an array, with each slot corresponding to an enumerated value
 * and that slot containing the enumerated object. Use to look up enumerated object when you have the value
 */
static public RadioNomenclatureVersion lookup[] = new RadioNomenclatureVersion[4];

/* initialize the array at class load time */
static 
{
    for(RadioNomenclatureVersion anEnum:RadioNomenclatureVersion.values())
    {
        lookup[anEnum.value] = anEnum;
    }
}

/** Constructor */
RadioNomenclatureVersion(int value, String description)
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
