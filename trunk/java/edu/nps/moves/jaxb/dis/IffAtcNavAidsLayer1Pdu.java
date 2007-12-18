//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.12 at 10:35:49 PM PST 
//


package edu.nps.moves.jaxb.dis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for iffAtcNavAidsLayer1Pdu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iffAtcNavAidsLayer1Pdu">
 *   &lt;complexContent>
 *     &lt;extension base="{}distributedEmissionsPdu">
 *       &lt;sequence>
 *         &lt;element name="emittingEntityId" type="{}entityID" minOccurs="0"/>
 *         &lt;element name="eventID" type="{}eventID" minOccurs="0"/>
 *         &lt;element name="fundamentalParameters" type="{}iffFundamentalData" minOccurs="0"/>
 *         &lt;element name="location" type="{}vector3Float" minOccurs="0"/>
 *         &lt;element name="pad2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="systemID" type="{}systemID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iffAtcNavAidsLayer1Pdu", propOrder = {
    "emittingEntityId",
    "eventID",
    "fundamentalParameters",
    "location",
    "pad2",
    "systemID"
})
@XmlSeeAlso({
    IffAtcNavAidsLayer2Pdu.class
})
public class IffAtcNavAidsLayer1Pdu
    extends DistributedEmissionsPdu
{

    protected EntityID emittingEntityId;
    protected EventID eventID;
    protected IffFundamentalData fundamentalParameters;
    protected Vector3Float location;
    protected int pad2;
    protected SystemID systemID;

    /**
     * Gets the value of the emittingEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link EntityID }
     *     
     */
    public EntityID getEmittingEntityId() {
        return emittingEntityId;
    }

    /**
     * Sets the value of the emittingEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityID }
     *     
     */
    public void setEmittingEntityId(EntityID value) {
        this.emittingEntityId = value;
    }

    /**
     * Gets the value of the eventID property.
     * 
     * @return
     *     possible object is
     *     {@link EventID }
     *     
     */
    public EventID getEventID() {
        return eventID;
    }

    /**
     * Sets the value of the eventID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventID }
     *     
     */
    public void setEventID(EventID value) {
        this.eventID = value;
    }

    /**
     * Gets the value of the fundamentalParameters property.
     * 
     * @return
     *     possible object is
     *     {@link IffFundamentalData }
     *     
     */
    public IffFundamentalData getFundamentalParameters() {
        return fundamentalParameters;
    }

    /**
     * Sets the value of the fundamentalParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link IffFundamentalData }
     *     
     */
    public void setFundamentalParameters(IffFundamentalData value) {
        this.fundamentalParameters = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Vector3Float }
     *     
     */
    public Vector3Float getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector3Float }
     *     
     */
    public void setLocation(Vector3Float value) {
        this.location = value;
    }

    /**
     * Gets the value of the pad2 property.
     * 
     */
    public int getPad2() {
        return pad2;
    }

    /**
     * Sets the value of the pad2 property.
     * 
     */
    public void setPad2(int value) {
        this.pad2 = value;
    }

    /**
     * Gets the value of the systemID property.
     * 
     * @return
     *     possible object is
     *     {@link SystemID }
     *     
     */
    public SystemID getSystemID() {
        return systemID;
    }

    /**
     * Sets the value of the systemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemID }
     *     
     */
    public void setSystemID(SystemID value) {
        this.systemID = value;
    }

}
