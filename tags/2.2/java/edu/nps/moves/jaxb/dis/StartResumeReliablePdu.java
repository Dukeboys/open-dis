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
 * <p>Java class for startResumeReliablePdu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="startResumeReliablePdu">
 *   &lt;complexContent>
 *     &lt;extension base="{}simulationManagementWithReliabilityFamilyPdu">
 *       &lt;sequence>
 *         &lt;element name="pad1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pad2" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="realWorldTime" type="{}clockTime" minOccurs="0"/>
 *         &lt;element name="requestID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="requiredReliabilityService" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="simulationTime" type="{}clockTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "startResumeReliablePdu", propOrder = {
    "pad1",
    "pad2",
    "realWorldTime",
    "requestID",
    "requiredReliabilityService",
    "simulationTime"
})
public class StartResumeReliablePdu
    extends SimulationManagementWithReliabilityFamilyPdu
{

    protected int pad1;
    protected short pad2;
    protected ClockTime realWorldTime;
    protected long requestID;
    protected short requiredReliabilityService;
    protected ClockTime simulationTime;

    /**
     * Gets the value of the pad1 property.
     * 
     */
    public int getPad1() {
        return pad1;
    }

    /**
     * Sets the value of the pad1 property.
     * 
     */
    public void setPad1(int value) {
        this.pad1 = value;
    }

    /**
     * Gets the value of the pad2 property.
     * 
     */
    public short getPad2() {
        return pad2;
    }

    /**
     * Sets the value of the pad2 property.
     * 
     */
    public void setPad2(short value) {
        this.pad2 = value;
    }

    /**
     * Gets the value of the realWorldTime property.
     * 
     * @return
     *     possible object is
     *     {@link ClockTime }
     *     
     */
    public ClockTime getRealWorldTime() {
        return realWorldTime;
    }

    /**
     * Sets the value of the realWorldTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClockTime }
     *     
     */
    public void setRealWorldTime(ClockTime value) {
        this.realWorldTime = value;
    }

    /**
     * Gets the value of the requestID property.
     * 
     */
    public long getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     * 
     */
    public void setRequestID(long value) {
        this.requestID = value;
    }

    /**
     * Gets the value of the requiredReliabilityService property.
     * 
     */
    public short getRequiredReliabilityService() {
        return requiredReliabilityService;
    }

    /**
     * Sets the value of the requiredReliabilityService property.
     * 
     */
    public void setRequiredReliabilityService(short value) {
        this.requiredReliabilityService = value;
    }

    /**
     * Gets the value of the simulationTime property.
     * 
     * @return
     *     possible object is
     *     {@link ClockTime }
     *     
     */
    public ClockTime getSimulationTime() {
        return simulationTime;
    }

    /**
     * Sets the value of the simulationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClockTime }
     *     
     */
    public void setSimulationTime(ClockTime value) {
        this.simulationTime = value;
    }

}