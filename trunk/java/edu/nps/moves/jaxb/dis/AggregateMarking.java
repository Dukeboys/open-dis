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
 * <p>Java class for aggregateMarking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aggregateMarking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="characterSet" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="characters" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aggregateMarking", propOrder = {
    "characterSet",
    "characters"
})
public class AggregateMarking {

    protected short characterSet;
    protected byte[] characters;

    /**
     * Gets the value of the characterSet property.
     * 
     */
    public short getCharacterSet() {
        return characterSet;
    }

    /**
     * Sets the value of the characterSet property.
     * 
     */
    public void setCharacterSet(short value) {
        this.characterSet = value;
    }

    /**
     * Gets the value of the characters property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCharacters() {
        return characters;
    }

    /**
     * Sets the value of the characters property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCharacters(byte[] value) {
        this.characters = ((byte[]) value);
    }

}
