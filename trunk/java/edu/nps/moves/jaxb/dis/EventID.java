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
 * <p>Java class for eventID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eventID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="eventNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="site" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventID", propOrder = {
    "application",
    "eventNumber",
    "site"
})
public class EventID {

    protected int application;
    protected int eventNumber;
    protected int site;

    /**
     * Gets the value of the application property.
     * 
     */
    public int getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     */
    public void setApplication(int value) {
        this.application = value;
    }

    /**
     * Gets the value of the eventNumber property.
     * 
     */
    public int getEventNumber() {
        return eventNumber;
    }

    /**
     * Sets the value of the eventNumber property.
     * 
     */
    public void setEventNumber(int value) {
        this.eventNumber = value;
    }

    /**
     * Gets the value of the site property.
     * 
     */
    public int getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     */
    public void setSite(int value) {
        this.site = value;
    }

}
