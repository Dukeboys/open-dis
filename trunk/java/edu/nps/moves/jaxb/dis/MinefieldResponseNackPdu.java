//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.12 at 10:35:49 PM PST 
//


package edu.nps.moves.jaxb.dis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for minefieldResponseNackPdu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="minefieldResponseNackPdu">
 *   &lt;complexContent>
 *     &lt;extension base="{}minefieldPduFamily">
 *       &lt;sequence>
 *         &lt;element name="minefieldID" type="{}entityID" minOccurs="0"/>
 *         &lt;element name="missingPduSequenceNumbers" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numberOfMissingPdus" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="requestID" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="requestingEntityID" type="{}entityID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "minefieldResponseNackPdu", propOrder = {
    "minefieldID",
    "missingPduSequenceNumbers",
    "numberOfMissingPdus",
    "requestID",
    "requestingEntityID"
})
public class MinefieldResponseNackPdu
    extends MinefieldPduFamily
{

    protected EntityID minefieldID;
    @XmlElement(nillable = true)
    protected List<Object> missingPduSequenceNumbers;
    protected short numberOfMissingPdus;
    protected short requestID;
    protected EntityID requestingEntityID;

    /**
     * Gets the value of the minefieldID property.
     * 
     * @return
     *     possible object is
     *     {@link EntityID }
     *     
     */
    public EntityID getMinefieldID() {
        return minefieldID;
    }

    /**
     * Sets the value of the minefieldID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityID }
     *     
     */
    public void setMinefieldID(EntityID value) {
        this.minefieldID = value;
    }

    /**
     * Gets the value of the missingPduSequenceNumbers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the missingPduSequenceNumbers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMissingPduSequenceNumbers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getMissingPduSequenceNumbers() {
        if (missingPduSequenceNumbers == null) {
            missingPduSequenceNumbers = new ArrayList<Object>();
        }
        return this.missingPduSequenceNumbers;
    }

    /**
     * Gets the value of the numberOfMissingPdus property.
     * 
     */
    public short getNumberOfMissingPdus() {
        return numberOfMissingPdus;
    }

    /**
     * Sets the value of the numberOfMissingPdus property.
     * 
     */
    public void setNumberOfMissingPdus(short value) {
        this.numberOfMissingPdus = value;
    }

    /**
     * Gets the value of the requestID property.
     * 
     */
    public short getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     * 
     */
    public void setRequestID(short value) {
        this.requestID = value;
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

}
