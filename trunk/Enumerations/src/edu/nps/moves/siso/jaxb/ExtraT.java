//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.09.25 at 01:15:49 PM PDT 
//


package edu.nps.moves.siso.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for extra_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="extra_t">
 *   &lt;complexContent>
 *     &lt;extension base="{}genericentry_t">
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extra_t")
public class ExtraT
    extends GenericentryT
{

    @XmlAttribute(required = true)
    protected float id;

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
