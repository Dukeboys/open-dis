//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.12 at 10:35:49 PM PST 
//


package edu.nps.moves.jaxb.dis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for apaData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="apaData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parameterIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parameterValue" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "apaData", propOrder = {
    "parameterIndex",
    "parameterValue"
})
public class ApaData {

    protected int parameterIndex;
    protected short parameterValue;

    /**
     * Gets the value of the parameterIndex property.
     * 
     */
    public int getParameterIndex() {
        return parameterIndex;
    }

    /**
     * Sets the value of the parameterIndex property.
     * 
     */
    public void setParameterIndex(int value) {
        this.parameterIndex = value;
    }

    /**
     * Gets the value of the parameterValue property.
     * 
     */
    public short getParameterValue() {
        return parameterValue;
    }

    /**
     * Sets the value of the parameterValue property.
     * 
     */
    public void setParameterValue(short value) {
        this.parameterValue = value;
    }

}
