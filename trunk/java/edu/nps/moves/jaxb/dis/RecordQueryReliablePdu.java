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
 * <p>Java class for recordQueryReliablePdu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recordQueryReliablePdu">
 *   &lt;complexContent>
 *     &lt;extension base="{}simulationManagementWithReliabilityPduFamily">
 *       &lt;sequence>
 *         &lt;element name="eventType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfRecords" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="pad1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pad2" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="recordIDs" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requestID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="requiredReliabilityService" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recordQueryReliablePdu", propOrder = {
    "eventType",
    "numberOfRecords",
    "pad1",
    "pad2",
    "recordIDs",
    "requestID",
    "requiredReliabilityService",
    "time"
})
public class RecordQueryReliablePdu
    extends SimulationManagementWithReliabilityPduFamily
{

    protected int eventType;
    protected long numberOfRecords;
    protected int pad1;
    protected short pad2;
    @XmlElement(nillable = true)
    protected List<Object> recordIDs;
    protected long requestID;
    protected short requiredReliabilityService;
    protected long time;

    /**
     * Gets the value of the eventType property.
     * 
     */
    public int getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     */
    public void setEventType(int value) {
        this.eventType = value;
    }

    /**
     * Gets the value of the numberOfRecords property.
     * 
     */
    public long getNumberOfRecords() {
        return numberOfRecords;
    }

    /**
     * Sets the value of the numberOfRecords property.
     * 
     */
    public void setNumberOfRecords(long value) {
        this.numberOfRecords = value;
    }

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
     * Gets the value of the recordIDs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordIDs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordIDs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRecordIDs() {
        if (recordIDs == null) {
            recordIDs = new ArrayList<Object>();
        }
        return this.recordIDs;
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
     * Gets the value of the time property.
     * 
     */
    public long getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     */
    public void setTime(long value) {
        this.time = value;
    }

}
