package org.sedris;

/** The base enumeration from which all enumeration classes are inherited.
@author David Shen

*/
public abstract class Enum
{
    private String _enumStr;
    private int _enumInt;

    protected Enum (int enumInt, String enumStr)
    {
        _enumInt = enumInt;
        _enumStr = new String(enumStr);
    }

    /** Returns the string for the enumerant name
     */
    public String toString()
    {
        return new String(_enumStr);
    }

    /** returns the integer code value for the enumerant
     */
    public int toInt()
    {
        return _enumInt;
    }
}
