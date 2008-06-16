//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.03.11 at 11:22:02 AM PDT 
//


package edu.nps.moves.jaxb.dis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serviceRequestPdu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceRequestPdu">
 *   &lt;complexContent>
 *     &lt;extension base="{}logisticsFamilyPdu">
 *       &lt;sequence>
 *         &lt;element name="numberOfSupplyTypes" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="requestingEntityID" type="{}entityID" minOccurs="0"/>
 *         &lt;element name="serviceRequestPadding" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="serviceTypeRequested" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="servicingEntityID" type="{}entityID" minOccurs="0"/>
 *         &lt;element name="supplies" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceRequestPdu", propOrder = {
    "numberOfSupplyTypes",
    "requestingEntityID",
    "serviceRequestPadding",
    "serviceTypeRequested",
    "servicingEntityID",
    "supplies"
})
public class ServiceRequestPdu
    extends LogisticsFamilyPdu
{

    protected short numberOfSupplyTypes;
    protected EntityID requestingEntityID;
    protected short serviceRequestPadding;
    protected short serviceTypeRequested;
    protected EntityID servicingEntityID;
    @XmlElement(nillable = true)
    protected List<Object> supplies;

    /**
     * Gets the value of the numberOfSupplyTypes property.
     * 
     */
    public short getNumberOfSupplyTypes() {
        return numberOfSupplyTypes;
    }

    /**
     * Sets the value of the numberOfSupplyTypes property.
     * 
     */
    public void setNumberOfSupplyTypes(short value) {
        this.numberOfSupplyTypes = value;
    }

    /**
     * Gets the value of the requestingEntityID property.
     * 
     * @return
     *     possible object is
     *     {@link EntityID }
     *     
     */
    public EntityID getRequestingEntityID() {
        return requestingEntityID;
    }

    /**
     * Sets the value of the requestingEntityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityID }
     *     
     */
    public void setRequestingEntityID(EntityID value) {
        this.requestingEntityID = value;
    }

    /**
     * Gets the value of the serviceRequestPadding property.
     * 
     */
    public short getServiceRequestPadding() {
        return serviceRequestPadding;
    }

    /**
     * Sets the value of the serviceRequestPadding property.
     * 
     */
    public void setServiceRequestPadding(short value) {
        this.serviceRequestPadding = value;
    }

    /**
     * Gets the value of the serviceTypeRequested property.
     * 
     */
    public short getServiceTypeRequested() {
        return serviceTypeRequested;
    }

    /**
     * Sets the value of the serviceTypeRequested property.
     * 
     */
    public void setServiceTypeRequested(short value) {
        this.serviceTypeRequested = value;
    }

    /**
     * Gets the value of the servicingEntityID property.
     * 
     * @return
     *     possible object is
     *     {@link EntityID }
     *     
     */
    public EntityID getServicingEntityID() {
        return servicingEntityID;
    }

    /**
     * Sets the value of the servicingEntityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityID }
     *     
     */
    public void setServicingEntityID(EntityID value) {
        this.servicingEntityID = value;
    }

    /**
     * Gets the value of the supplies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supplies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupplies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getSupplies() {
        if (supplies == null) {
            supplies = new ArrayList<Object>();
        }
        return this.supplies;
    }

}