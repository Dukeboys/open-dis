//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.01.31 at 02:05:02 PM PST 
//


package edu.nps.moves.jaxb.dis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for systemID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="systemID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changeOptions" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="systemMode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="systemName" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="systemType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "systemID", propOrder = {
    "changeOptions",
    "systemMode",
    "systemName",
    "systemType"
})
public class SystemID {

    protected short changeOptions;
    protected short systemMode;
    protected int systemName;
    protected int systemType;

    /**
     * Gets the value of the changeOptions property.
     * 
     */
    public short getChangeOptions() {
        return changeOptions;
    }

    /**
     * Sets the value of the changeOptions property.
     * 
     */
    public void setChangeOptions(short value) {
        this.changeOptions = value;
    }

    /**
     * Gets the value of the systemMode property.
     * 
     */
    public short getSystemMode() {
        return systemMode;
    }

    /**
     * Sets the value of the systemMode property.
     * 
     */
    public void setSystemMode(short value) {
        this.systemMode = value;
    }

    /**
     * Gets the value of the systemName property.
     * 
     */
    public int getSystemName() {
        return systemName;
    }

    /**
     * Sets the value of the systemName property.
     * 
     */
    public void setSystemName(int value) {
        this.systemName = value;
    }

    /**
     * Gets the value of the systemType property.
     * 
     */
    public int getSystemType() {
        return systemType;
    }

    /**
     * Sets the value of the systemType property.
     * 
     */
    public void setSystemType(int value) {
        this.systemType = value;
    }

}