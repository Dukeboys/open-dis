//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.09.25 at 01:15:49 PM PDT 
//


package edu.nps.moves.siso.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for category_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="category_t">
 *   &lt;complexContent>
 *     &lt;extension base="{}genericentry_t">
 *       &lt;sequence>
 *         &lt;element name="subcategory" type="{}subcategory_t" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category_t", propOrder = {
    "subcategory"
})
public class CategoryT
    extends GenericentryT
{

    protected List<SubcategoryT> subcategory;
    @XmlAttribute(required = true)
    protected float id;

    /**
     * Gets the value of the subcategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subcategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubcategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubcategoryT }
     * 
     * 
     */
    public List<SubcategoryT> getSubcategory() {
        if (subcategory == null) {
            subcategory = new ArrayList<SubcategoryT>();
        }
        return this.subcategory;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public float getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(float value) {
        this.id = value;
    }

}
