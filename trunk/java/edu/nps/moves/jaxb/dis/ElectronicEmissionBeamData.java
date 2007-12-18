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
 * <p>Java class for electronicEmissionBeamData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="electronicEmissionBeamData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beamDataLength" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="beamFunction" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="beamIDNumber" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="beamParameterIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fundamentalParameterData" type="{}fundamentalParameterData" minOccurs="0"/>
 *         &lt;element name="highDensityTrackJam" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="jammingModeSequence" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numberOfTrackJamTargets" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="pad4" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="trackJamTargets" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "electronicEmissionBeamData", propOrder = {
    "beamDataLength",
    "beamFunction",
    "beamIDNumber",
    "beamParameterIndex",
    "fundamentalParameterData",
    "highDensityTrackJam",
    "jammingModeSequence",
    "numberOfTrackJamTargets",
    "pad4",
    "trackJamTargets"
})
public class ElectronicEmissionBeamData {

    protected short beamDataLength;
    protected short beamFunction;
    protected short beamIDNumber;
    protected int beamParameterIndex;
    protected FundamentalParameterData fundamentalParameterData;
    protected short highDensityTrackJam;
    protected long jammingModeSequence;
    protected short numberOfTrackJamTargets;
    protected short pad4;
    @XmlElement(nillable = true)
    protected List<Object> trackJamTargets;

    /**
     * Gets the value of the beamDataLength property.
     * 
     */
    public short getBeamDataLength() {
        return beamDataLength;
    }

    /**
     * Sets the value of the beamDataLength property.
     * 
     */
    public void setBeamDataLength(short value) {
        this.beamDataLength = value;
    }

    /**
     * Gets the value of the beamFunction property.
     * 
     */
    public short getBeamFunction() {
        return beamFunction;
    }

    /**
     * Sets the value of the beamFunction property.
     * 
     */
    public void setBeamFunction(short value) {
        this.beamFunction = value;
    }

    /**
     * Gets the value of the beamIDNumber property.
     * 
     */
    public short getBeamIDNumber() {
        return beamIDNumber;
    }

    /**
     * Sets the value of the beamIDNumber property.
     * 
     */
    public void setBeamIDNumber(short value) {
        this.beamIDNumber = value;
    }

    /**
     * Gets the value of the beamParameterIndex property.
     * 
     */
    public int getBeamParameterIndex() {
        return beamParameterIndex;
    }

    /**
     * Sets the value of the beamParameterIndex property.
     * 
     */
    public void setBeamParameterIndex(int value) {
        this.beamParameterIndex = value;
    }

    /**
     * Gets the value of the fundamentalParameterData property.
     * 
     * @return
     *     possible object is
     *     {@link FundamentalParameterData }
     *     
     */
    public FundamentalParameterData getFundamentalParameterData() {
        return fundamentalParameterData;
    }

    /**
     * Sets the value of the fundamentalParameterData property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundamentalParameterData }
     *     
     */
    public void setFundamentalParameterData(FundamentalParameterData value) {
        this.fundamentalParameterData = value;
    }

    /**
     * Gets the value of the highDensityTrackJam property.
     * 
     */
    public short getHighDensityTrackJam() {
        return highDensityTrackJam;
    }

    /**
     * Sets the value of the highDensityTrackJam property.
     * 
     */
    public void setHighDensityTrackJam(short value) {
        this.highDensityTrackJam = value;
    }

    /**
     * Gets the value of the jammingModeSequence property.
     * 
     */
    public long getJammingModeSequence() {
        return jammingModeSequence;
    }

    /**
     * Sets the value of the jammingModeSequence property.
     * 
     */
    public void setJammingModeSequence(long value) {
        this.jammingModeSequence = value;
    }

    /**
     * Gets the value of the numberOfTrackJamTargets property.
     * 
     */
    public short getNumberOfTrackJamTargets() {
        return numberOfTrackJamTargets;
    }

    /**
     * Sets the value of the numberOfTrackJamTargets property.
     * 
     */
    public void setNumberOfTrackJamTargets(short value) {
        this.numberOfTrackJamTargets = value;
    }

    /**
     * Gets the value of the pad4 property.
     * 
     */
    public short getPad4() {
        return pad4;
    }

    /**
     * Sets the value of the pad4 property.
     * 
     */
    public void setPad4(short value) {
        this.pad4 = value;
    }

    /**
     * Gets the value of the trackJamTargets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trackJamTargets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrackJamTargets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getTrackJamTargets() {
        if (trackJamTargets == null) {
            trackJamTargets = new ArrayList<Object>();
        }
        return this.trackJamTargets;
    }

}
