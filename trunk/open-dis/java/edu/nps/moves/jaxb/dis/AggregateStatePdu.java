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
 * <p>Java class for aggregateStatePdu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aggregateStatePdu">
 *   &lt;complexContent>
 *     &lt;extension base="{}entityManagementFamilyPdu">
 *       &lt;sequence>
 *         &lt;element name="aggregateID" type="{}entityID" minOccurs="0"/>
 *         &lt;element name="aggregateIDList" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="aggregateMarking" type="{}aggregateMarking" minOccurs="0"/>
 *         &lt;element name="aggregateState" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="aggregateType" type="{}entityType" minOccurs="0"/>
 *         &lt;element name="centerOfMass" type="{}vector3Double" minOccurs="0"/>
 *         &lt;element name="dimensions" type="{}vector3Float" minOccurs="0"/>
 *         &lt;element name="entityIDList" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="forceID" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="formation" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numberOfDisAggregates" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfDisEntities" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfSilentAggregateTypes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfSilentEntityTypes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfVariableDatumRecords" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orientation" type="{}orientation" minOccurs="0"/>
 *         &lt;element name="pad2" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="silentAggregateSystemList" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="silentEntitySystemList" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="variableDatumList" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="velocity" type="{}vector3Float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aggregateStatePdu", propOrder = {
    "aggregateID",
    "aggregateIDList",
    "aggregateMarking",
    "aggregateState",
    "aggregateType",
    "centerOfMass",
    "dimensions",
    "entityIDList",
    "forceID",
    "formation",
    "numberOfDisAggregates",
    "numberOfDisEntities",
    "numberOfSilentAggregateTypes",
    "numberOfSilentEntityTypes",
    "numberOfVariableDatumRecords",
    "orientation",
    "pad2",
    "silentAggregateSystemList",
    "silentEntitySystemList",
    "variableDatumList",
    "velocity"
})
public class AggregateStatePdu
    extends EntityManagementFamilyPdu
{

    protected EntityID aggregateID;
    @XmlElement(nillable = true)
    protected List<Object> aggregateIDList;
    protected AggregateMarking aggregateMarking;
    protected short aggregateState;
    protected EntityType aggregateType;
    protected Vector3Double centerOfMass;
    protected Vector3Float dimensions;
    @XmlElement(nillable = true)
    protected List<Object> entityIDList;
    protected short forceID;
    protected long formation;
    protected int numberOfDisAggregates;
    protected int numberOfDisEntities;
    protected int numberOfSilentAggregateTypes;
    protected int numberOfSilentEntityTypes;
    protected long numberOfVariableDatumRecords;
    protected Orientation orientation;
    protected short pad2;
    @XmlElement(nillable = true)
    protected List<Object> silentAggregateSystemList;
    @XmlElement(nillable = true)
    protected List<Object> silentEntitySystemList;
    @XmlElement(nillable = true)
    protected List<Object> variableDatumList;
    protected Vector3Float velocity;

    /**
     * Gets the value of the aggregateID property.
     * 
     * @return
     *     possible object is
     *     {@link EntityID }
     *     
     */
    public EntityID getAggregateID() {
        return aggregateID;
    }

    /**
     * Sets the value of the aggregateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityID }
     *     
     */
    public void setAggregateID(EntityID value) {
        this.aggregateID = value;
    }

    /**
     * Gets the value of the aggregateIDList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aggregateIDList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAggregateIDList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAggregateIDList() {
        if (aggregateIDList == null) {
            aggregateIDList = new ArrayList<Object>();
        }
        return this.aggregateIDList;
    }

    /**
     * Gets the value of the aggregateMarking property.
     * 
     * @return
     *     possible object is
     *     {@link AggregateMarking }
     *     
     */
    public AggregateMarking getAggregateMarking() {
        return aggregateMarking;
    }

    /**
     * Sets the value of the aggregateMarking property.
     * 
     * @param value
     *     allowed object is
     *     {@link AggregateMarking }
     *     
     */
    public void setAggregateMarking(AggregateMarking value) {
        this.aggregateMarking = value;
    }

    /**
     * Gets the value of the aggregateState property.
     * 
     */
    public short getAggregateState() {
        return aggregateState;
    }

    /**
     * Sets the value of the aggregateState property.
     * 
     */
    public void setAggregateState(short value) {
        this.aggregateState = value;
    }

    /**
     * Gets the value of the aggregateType property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getAggregateType() {
        return aggregateType;
    }

    /**
     * Sets the value of the aggregateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setAggregateType(EntityType value) {
        this.aggregateType = value;
    }

    /**
     * Gets the value of the centerOfMass property.
     * 
     * @return
     *     possible object is
     *     {@link Vector3Double }
     *     
     */
    public Vector3Double getCenterOfMass() {
        return centerOfMass;
    }

    /**
     * Sets the value of the centerOfMass property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector3Double }
     *     
     */
    public void setCenterOfMass(Vector3Double value) {
        this.centerOfMass = value;
    }

    /**
     * Gets the value of the dimensions property.
     * 
     * @return
     *     possible object is
     *     {@link Vector3Float }
     *     
     */
    public Vector3Float getDimensions() {
        return dimensions;
    }

    /**
     * Sets the value of the dimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector3Float }
     *     
     */
    public void setDimensions(Vector3Float value) {
        this.dimensions = value;
    }

    /**
     * Gets the value of the entityIDList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entityIDList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntityIDList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getEntityIDList() {
        if (entityIDList == null) {
            entityIDList = new ArrayList<Object>();
        }
        return this.entityIDList;
    }

    /**
     * Gets the value of the forceID property.
     * 
     */
    public short getForceID() {
        return forceID;
    }

    /**
     * Sets the value of the forceID property.
     * 
     */
    public void setForceID(short value) {
        this.forceID = value;
    }

    /**
     * Gets the value of the formation property.
     * 
     */
    public long getFormation() {
        return formation;
    }

    /**
     * Sets the value of the formation property.
     * 
     */
    public void setFormation(long value) {
        this.formation = value;
    }

    /**
     * Gets the value of the numberOfDisAggregates property.
     * 
     */
    public int getNumberOfDisAggregates() {
        return numberOfDisAggregates;
    }

    /**
     * Sets the value of the numberOfDisAggregates property.
     * 
     */
    public void setNumberOfDisAggregates(int value) {
        this.numberOfDisAggregates = value;
    }

    /**
     * Gets the value of the numberOfDisEntities property.
     * 
     */
    public int getNumberOfDisEntities() {
        return numberOfDisEntities;
    }

    /**
     * Sets the value of the numberOfDisEntities property.
     * 
     */
    public void setNumberOfDisEntities(int value) {
        this.numberOfDisEntities = value;
    }

    /**
     * Gets the value of the numberOfSilentAggregateTypes property.
     * 
     */
    public int getNumberOfSilentAggregateTypes() {
        return numberOfSilentAggregateTypes;
    }

    /**
     * Sets the value of the numberOfSilentAggregateTypes property.
     * 
     */
    public void setNumberOfSilentAggregateTypes(int value) {
        this.numberOfSilentAggregateTypes = value;
    }

    /**
     * Gets the value of the numberOfSilentEntityTypes property.
     * 
     */
    public int getNumberOfSilentEntityTypes() {
        return numberOfSilentEntityTypes;
    }

    /**
     * Sets the value of the numberOfSilentEntityTypes property.
     * 
     */
    public void setNumberOfSilentEntityTypes(int value) {
        this.numberOfSilentEntityTypes = value;
    }

    /**
     * Gets the value of the numberOfVariableDatumRecords property.
     * 
     */
    public long getNumberOfVariableDatumRecords() {
        return numberOfVariableDatumRecords;
    }

    /**
     * Sets the value of the numberOfVariableDatumRecords property.
     * 
     */
    public void setNumberOfVariableDatumRecords(long value) {
        this.numberOfVariableDatumRecords = value;
    }

    /**
     * Gets the value of the orientation property.
     * 
     * @return
     *     possible object is
     *     {@link Orientation }
     *     
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Orientation }
     *     
     */
    public void setOrientation(Orientation value) {
        this.orientation = value;
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
     * Gets the value of the silentAggregateSystemList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the silentAggregateSystemList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSilentAggregateSystemList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getSilentAggregateSystemList() {
        if (silentAggregateSystemList == null) {
            silentAggregateSystemList = new ArrayList<Object>();
        }
        return this.silentAggregateSystemList;
    }

    /**
     * Gets the value of the silentEntitySystemList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the silentEntitySystemList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSilentEntitySystemList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getSilentEntitySystemList() {
        if (silentEntitySystemList == null) {
            silentEntitySystemList = new ArrayList<Object>();
        }
        return this.silentEntitySystemList;
    }

    /**
     * Gets the value of the variableDatumList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableDatumList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariableDatumList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getVariableDatumList() {
        if (variableDatumList == null) {
            variableDatumList = new ArrayList<Object>();
        }
        return this.variableDatumList;
    }

    /**
     * Gets the value of the velocity property.
     * 
     * @return
     *     possible object is
     *     {@link Vector3Float }
     *     
     */
    public Vector3Float getVelocity() {
        return velocity;
    }

    /**
     * Sets the value of the velocity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector3Float }
     *     
     */
    public void setVelocity(Vector3Float value) {
        this.velocity = value;
    }

}