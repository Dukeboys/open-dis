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
 * <p>Java class for entityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="entityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="entityKind" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="extra" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="specific" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="subcategory" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entityType", propOrder = {
    "category",
    "country",
    "domain",
    "entityKind",
    "extra",
    "specific",
    "subcategory"
})
public class EntityType {

    protected short category;
    protected int country;
    protected short domain;
    protected short entityKind;
    protected short extra;
    protected short specific;
    protected short subcategory;

    /**
     * Gets the value of the category property.
     * 
     */
    public short getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     */
    public void setCategory(short value) {
        this.category = value;
    }

    /**
     * Gets the value of the country property.
     * 
     */
    public int getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     */
    public void setCountry(int value) {
        this.country = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     */
    public short getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     */
    public void setDomain(short value) {
        this.domain = value;
    }

    /**
     * Gets the value of the entityKind property.
     * 
     */
    public short getEntityKind() {
        return entityKind;
    }

    /**
     * Sets the value of the entityKind property.
     * 
     */
    public void setEntityKind(short value) {
        this.entityKind = value;
    }

    /**
     * Gets the value of the extra property.
     * 
     */
    public short getExtra() {
        return extra;
    }

    /**
     * Sets the value of the extra property.
     * 
     */
    public void setExtra(short value) {
        this.extra = value;
    }

    /**
     * Gets the value of the specific property.
     * 
     */
    public short getSpecific() {
        return specific;
    }

    /**
     * Sets the value of the specific property.
     * 
     */
    public void setSpecific(short value) {
        this.specific = value;
    }

    /**
     * Gets the value of the subcategory property.
     * 
     */
    public short getSubcategory() {
        return subcategory;
    }

    /**
     * Sets the value of the subcategory property.
     * 
     */
    public void setSubcategory(short value) {
        this.subcategory = value;
    }

}
