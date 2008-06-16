package edu.nps.moves.xmlpg;

/**
 * Represents an initial value for a primitive type. This can be set in a subclass
 * of a given class, for example to initialize a header, like version number of
 * packet type.
 *
 * @author DMcG
 */
public class InitialValue 
{
    /** The field name that will be  initialized in this class's constructor */
    private String variable;
    
    /** the value that it will be set to. */
    private String variableValue;
    
    public InitialValue(String pVariable, String pValue)
    {
        variable = pVariable;
        variableValue = pValue;
    }
    
    public String getVariable()
    {
        return variable;
    }
    
    public void setVariable(String pVariable)
    {
        variable = pVariable;
    }
    
    public String getVariableValue()
    {
        return variableValue;
    }
    
    public void setVariableValue(String pVal)
    {
        variableValue = pVal;
    }
    
    /** 
     * Returns the "standard" method name for a setter, given the variable name.
     */
    public String getSetterMethodName()
    {
        String methodName = new String(variable);
        methodName = "set" + this.initialCap(methodName);
        
        return methodName;
    }
    
    /** 
     * returns a string with the first letter capitalized. 
     */
    public String initialCap(String aString)
    {
        StringBuffer stb = new StringBuffer(aString);
        stb.setCharAt(0, Character.toUpperCase(aString.charAt(0)));
        
        return new String(stb);
    }
    
}
