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
 * <p>Java class for acousticEmitter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acousticEmitter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acousticIdNumber" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="acousticName" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="function" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acousticEmitter", propOrder = {
    "acousticIdNumber",
    "acousticName",
    "function"
})
public class AcousticEmitter {

    protected short acousticIdNumber;
    protected int acousticName;
    protected short function;

    /**
     * Gets the value of the acousticIdNumber property.
     * 
     */
    public short getAcousticIdNumber() {
        return acousticIdNumber;
    }

    /**
     * Sets the value of the acousticIdNumber property.
     * 
     */
    public void setAcousticIdNumber(short value) {
        this.acousticIdNumber = value;
    }

    /**
     * Gets the value of the acousticName property.
     * 
     */
    public int getAcousticName() {
        return acousticName;
    }

    /**
     * Sets the value of the acousticName property.
     * 
     */
    public void setAcousticName(int value) {
        this.acousticName = value;
    }

    /**
     * Gets the value of the function property.
     * 
     */
    public short getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     */
    public void setFunction(short value) {
        this.function = value;
    }

}
