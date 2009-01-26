package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.3.1. Represents the postion and state of one entity in the world. This is identical in function to entity state pdu, but generates less garbage to collect in the Java world. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * @version $Id:$
 */
public class FastEntityStatePdu extends EntityInformationFamilyPdu implements Serializable {

    /** The site ID */
    protected int site;
    /** The application ID */
    protected int application;
    /** the entity ID */
    protected int entity;
    /** what force this entity is affiliated with, eg red, blue, neutral, etc */
    protected short forceId;
    /** How many articulation parameters are in the variable length list */
    protected byte numberOfArticulationParameters;
    /** Kind of entity */
    protected short entityKind;
    /** Domain of entity (air, surface, subsurface, space, etc) */
    protected short domain;
    /** country to which the design of the entity is attributed */
    protected int country;
    /** category of entity */
    protected short category;
    /** subcategory of entity */
    protected short subcategory;
    /** specific info based on subcategory field */
    protected short specific;
    protected short extra;
    /** Kind of entity */
    protected short altEntityKind;
    /** Domain of entity (air, surface, subsurface, space, etc) */
    protected short altDomain;
    /** country to which the design of the entity is attributed */
    protected int altCountry;
    /** category of entity */
    protected short altCategory;
    /** subcategory of entity */
    protected short altSubcategory;
    /** specific info based on subcategory field */
    protected short altSpecific;
    protected short altExtra;
    /** X velo */
    protected float xVelocity;
    /** y Value */
    protected float yVelocity;
    /** Z value */
    protected float zVelocity;
    /** X value */
    protected double xLocation;
    /** y Value */
    protected double yLocation;
    /** Z value */
    protected double zLocation;
    protected float psi;
    protected float theta;
    protected float phi;
    /** a series of bit flags that are used to help draw the entity, such as smoking, on fire, etc. */
    protected int entityAppearance;
    /** enumeration of what dead reckoning algorighm to use */
    protected short deadReckoningAlgorithm;
    /** other parameters to use in the dead reckoning algorithm */
    protected byte[] otherParameters = new byte[15];
    /** X value */
    protected float xAcceleration;
    /** y Value */
    protected float yAcceleration;
    /** Z value */
    protected float zAcceleration;
    /** X value */
    protected float xAngularVelocity;
    /** y Value */
    protected float yAngularVelocity;
    /** Z value */
    protected float zAngularVelocity;
    /** characters that can be used for debugging, or to draw unique strings on the side of entities in the world */
    protected byte[] marking = new byte[12];
    /** a series of bit flags */
    protected int capabilities;
    /** variable length list of articulation parameters */
    protected List<ArticulationParameter> articulationParameters = new ArrayList<ArticulationParameter>();

    /** Constructor */
    public FastEntityStatePdu() {
        setPduType((short) 1);
    }

    @Override
    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize = super.getMarshalledSize();
        marshalSize = marshalSize + 2;  // site
        marshalSize = marshalSize + 2;  // application
        marshalSize = marshalSize + 2;  // entity
        marshalSize = marshalSize + 1;  // forceId
        marshalSize = marshalSize + 1;  // numberOfArticulationParameters
        marshalSize = marshalSize + 1;  // entityKind
        marshalSize = marshalSize + 1;  // domain
        marshalSize = marshalSize + 2;  // country
        marshalSize = marshalSize + 1;  // category
        marshalSize = marshalSize + 1;  // subcategory
        marshalSize = marshalSize + 1;  // specific
        marshalSize = marshalSize + 1;  // extra
        marshalSize = marshalSize + 1;  // altEntityKind
        marshalSize = marshalSize + 1;  // altDomain
        marshalSize = marshalSize + 2;  // altCountry
        marshalSize = marshalSize + 1;  // altCategory
        marshalSize = marshalSize + 1;  // altSubcategory
        marshalSize = marshalSize + 1;  // altSpecific
        marshalSize = marshalSize + 1;  // altExtra
        marshalSize = marshalSize + 4;  // xVelocity
        marshalSize = marshalSize + 4;  // yVelocity
        marshalSize = marshalSize + 4;  // zVelocity
        marshalSize = marshalSize + 8;  // xLocation
        marshalSize = marshalSize + 8;  // yLocation
        marshalSize = marshalSize + 8;  // zLocation
        marshalSize = marshalSize + 4;  // psi
        marshalSize = marshalSize + 4;  // theta
        marshalSize = marshalSize + 4;  // phi
        marshalSize = marshalSize + 4;  // entityAppearance
        marshalSize = marshalSize + 1;  // deadReckoningAlgorithm
        marshalSize = marshalSize + 15 * 1;  // otherParameters
        marshalSize = marshalSize + 4;  // xAcceleration
        marshalSize = marshalSize + 4;  // yAcceleration
        marshalSize = marshalSize + 4;  // zAcceleration
        marshalSize = marshalSize + 4;  // xAngularVelocity
        marshalSize = marshalSize + 4;  // yAngularVelocity
        marshalSize = marshalSize + 4;  // zAngularVelocity
        marshalSize = marshalSize + 12 * 1;  // marking
        marshalSize = marshalSize + 4;  // capabilities
        for (int idx = 0; idx < articulationParameters.size(); idx++) {
            ArticulationParameter listElement = articulationParameters.get(idx);
            marshalSize = marshalSize + listElement.getMarshalledSize();
        }

        return marshalSize;
    }

    public void setSite(int pSite) {
        site = pSite;
    }

    @XmlAttribute
    public int getSite() {
        return site;
    }

    public void setApplication(int pApplication) {
        application = pApplication;
    }

    @XmlAttribute
    public int getApplication() {
        return application;
    }

    public void setEntity(int pEntity) {
        entity = pEntity;
    }

    @XmlAttribute
    public int getEntity() {
        return entity;
    }

    public void setForceId(short pForceId) {
        forceId = pForceId;
    }

    @XmlAttribute
    public short getForceId() {
        return forceId;
    }

    @XmlAttribute
    public byte getNumberOfArticulationParameters() {
        return (byte) articulationParameters.size();
    }

    /** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
     * The getnumberOfArticulationParameters method will also be based on the actual list length rather than this value.
     * The method is simply here for java bean completeness.
     * @param pNumberOfArticulationParameters
     */
    public void setNumberOfArticulationParameters(byte pNumberOfArticulationParameters) {
        numberOfArticulationParameters = pNumberOfArticulationParameters;
    }

    public void setEntityKind(short pEntityKind) {
        entityKind = pEntityKind;
    }

    @XmlAttribute
    public short getEntityKind() {
        return entityKind;
    }

    public void setDomain(short pDomain) {
        domain = pDomain;
    }

    @XmlAttribute
    public short getDomain() {
        return domain;
    }

    public void setCountry(int pCountry) {
        country = pCountry;
    }

    @XmlAttribute
    public int getCountry() {
        return country;
    }

    public void setCategory(short pCategory) {
        category = pCategory;
    }

    @XmlAttribute
    public short getCategory() {
        return category;
    }

    public void setSubcategory(short pSubcategory) {
        subcategory = pSubcategory;
    }

    @XmlAttribute
    public short getSubcategory() {
        return subcategory;
    }

    public void setSpecific(short pSpecific) {
        specific = pSpecific;
    }

    @XmlAttribute
    public short getSpecific() {
        return specific;
    }

    public void setExtra(short pExtra) {
        extra = pExtra;
    }

    @XmlAttribute
    public short getExtra() {
        return extra;
    }

    public void setAltEntityKind(short pAltEntityKind) {
        altEntityKind = pAltEntityKind;
    }

    @XmlAttribute
    public short getAltEntityKind() {
        return altEntityKind;
    }

    public void setAltDomain(short pAltDomain) {
        altDomain = pAltDomain;
    }

    @XmlAttribute
    public short getAltDomain() {
        return altDomain;
    }

    public void setAltCountry(int pAltCountry) {
        altCountry = pAltCountry;
    }

    @XmlAttribute
    public int getAltCountry() {
        return altCountry;
    }

    public void setAltCategory(short pAltCategory) {
        altCategory = pAltCategory;
    }

    @XmlAttribute
    public short getAltCategory() {
        return altCategory;
    }

    public void setAltSubcategory(short pAltSubcategory) {
        altSubcategory = pAltSubcategory;
    }

    @XmlAttribute
    public short getAltSubcategory() {
        return altSubcategory;
    }

    public void setAltSpecific(short pAltSpecific) {
        altSpecific = pAltSpecific;
    }

    @XmlAttribute
    public short getAltSpecific() {
        return altSpecific;
    }

    public void setAltExtra(short pAltExtra) {
        altExtra = pAltExtra;
    }

    @XmlAttribute
    public short getAltExtra() {
        return altExtra;
    }

    public void setXVelocity(float pXVelocity) {
        xVelocity = pXVelocity;
    }

    @XmlAttribute
    public float getXVelocity() {
        return xVelocity;
    }

    public void setYVelocity(float pYVelocity) {
        yVelocity = pYVelocity;
    }

    @XmlAttribute
    public float getYVelocity() {
        return yVelocity;
    }

    public void setZVelocity(float pZVelocity) {
        zVelocity = pZVelocity;
    }

    @XmlAttribute
    public float getZVelocity() {
        return zVelocity;
    }

    public void setXLocation(double pXLocation) {
        xLocation = pXLocation;
    }

    @XmlAttribute
    public double getXLocation() {
        return xLocation;
    }

    public void setYLocation(double pYLocation) {
        yLocation = pYLocation;
    }

    @XmlAttribute
    public double getYLocation() {
        return yLocation;
    }

    public void setZLocation(double pZLocation) {
        zLocation = pZLocation;
    }

    @XmlAttribute
    public double getZLocation() {
        return zLocation;
    }

    public void setPsi(float pPsi) {
        psi = pPsi;
    }

    @XmlAttribute
    public float getPsi() {
        return psi;
    }

    public void setTheta(float pTheta) {
        theta = pTheta;
    }

    @XmlAttribute
    public float getTheta() {
        return theta;
    }

    public void setPhi(float pPhi) {
        phi = pPhi;
    }

    @XmlAttribute
    public float getPhi() {
        return phi;
    }

    public void setEntityAppearance(int pEntityAppearance) {
        entityAppearance = pEntityAppearance;
    }

    @XmlAttribute
    public int getEntityAppearance() {
        return entityAppearance;
    }

    public void setDeadReckoningAlgorithm(short pDeadReckoningAlgorithm) {
        deadReckoningAlgorithm = pDeadReckoningAlgorithm;
    }

    @XmlAttribute
    public short getDeadReckoningAlgorithm() {
        return deadReckoningAlgorithm;
    }

    public void setOtherParameters(byte[] pOtherParameters) {
        otherParameters = pOtherParameters;
    }

    @XmlElement(name = "otherParameters")
    public byte[] getOtherParameters() {
        return otherParameters;
    }

    public void setXAcceleration(float pXAcceleration) {
        xAcceleration = pXAcceleration;
    }

    @XmlAttribute
    public float getXAcceleration() {
        return xAcceleration;
    }

    public void setYAcceleration(float pYAcceleration) {
        yAcceleration = pYAcceleration;
    }

    @XmlAttribute
    public float getYAcceleration() {
        return yAcceleration;
    }

    public void setZAcceleration(float pZAcceleration) {
        zAcceleration = pZAcceleration;
    }

    @XmlAttribute
    public float getZAcceleration() {
        return zAcceleration;
    }

    public void setXAngularVelocity(float pXAngularVelocity) {
        xAngularVelocity = pXAngularVelocity;
    }

    @XmlAttribute
    public float getXAngularVelocity() {
        return xAngularVelocity;
    }

    public void setYAngularVelocity(float pYAngularVelocity) {
        yAngularVelocity = pYAngularVelocity;
    }

    @XmlAttribute
    public float getYAngularVelocity() {
        return yAngularVelocity;
    }

    public void setZAngularVelocity(float pZAngularVelocity) {
        zAngularVelocity = pZAngularVelocity;
    }

    @XmlAttribute
    public float getZAngularVelocity() {
        return zAngularVelocity;
    }

    public void setMarking(byte[] pMarking) {
        marking = pMarking;
    }

    @XmlElement(name = "marking")
    public byte[] getMarking() {
        return marking;
    }

    public void setCapabilities(int pCapabilities) {
        capabilities = pCapabilities;
    }

    @XmlAttribute
    public int getCapabilities() {
        return capabilities;
    }

    public void setArticulationParameters(List<ArticulationParameter> pArticulationParameters) {
        articulationParameters = pArticulationParameters;
    }

    @XmlElementWrapper(name = "articulationParametersList")
    public List<ArticulationParameter> getArticulationParameters() {
        return articulationParameters;
    }

    @Override
    public void marshal(DataOutputStream dos) {
        super.marshal(dos);
        try {
            dos.writeShort((short) site);
            dos.writeShort((short) application);
            dos.writeShort((short) entity);
            dos.writeByte((byte) forceId);
            dos.writeByte((byte) articulationParameters.size());
            dos.writeByte((byte) entityKind);
            dos.writeByte((byte) domain);
            dos.writeShort((short) country);
            dos.writeByte((byte) category);
            dos.writeByte((byte) subcategory);
            dos.writeByte((byte) specific);
            dos.writeByte((byte) extra);
            dos.writeByte((byte) altEntityKind);
            dos.writeByte((byte) altDomain);
            dos.writeShort((short) altCountry);
            dos.writeByte((byte) altCategory);
            dos.writeByte((byte) altSubcategory);
            dos.writeByte((byte) altSpecific);
            dos.writeByte((byte) altExtra);
            dos.writeFloat(xVelocity);
            dos.writeFloat(yVelocity);
            dos.writeFloat(zVelocity);
            dos.writeDouble(xLocation);
            dos.writeDouble(yLocation);
            dos.writeDouble(zLocation);
            dos.writeFloat(psi);
            dos.writeFloat(theta);
            dos.writeFloat(phi);
            dos.writeInt(entityAppearance);
            dos.writeByte((byte) deadReckoningAlgorithm);

            for (int idx = 0; idx < otherParameters.length; idx++) {
                dos.writeByte(otherParameters[idx]);
            } // end of array marshaling

            dos.writeFloat(xAcceleration);
            dos.writeFloat(yAcceleration);
            dos.writeFloat(zAcceleration);
            dos.writeFloat(xAngularVelocity);
            dos.writeFloat(yAngularVelocity);
            dos.writeFloat(zAngularVelocity);

            for (int idx = 0; idx < marking.length; idx++) {
                dos.writeByte(marking[idx]);
            } // end of array marshaling

            dos.writeInt(capabilities);

            for (int idx = 0; idx < articulationParameters.size(); idx++) {
                ArticulationParameter aArticulationParameter = articulationParameters.get(idx);
                aArticulationParameter.marshal(dos);
            } // end of list marshalling

        } // end try
        catch (Exception e) {
            System.out.println(e);
        }
    } // end of marshal method

    @Override
    public void unmarshal(DataInputStream dis) {
        super.unmarshal(dis);

        try {
            site = dis.readUnsignedShort();
            application = dis.readUnsignedShort();
            entity = dis.readUnsignedShort();
            forceId = (short) dis.readUnsignedByte();
            numberOfArticulationParameters = dis.readByte();
            entityKind = (short) dis.readUnsignedByte();
            domain = (short) dis.readUnsignedByte();
            country = dis.readUnsignedShort();
            category = (short) dis.readUnsignedByte();
            subcategory = (short) dis.readUnsignedByte();
            specific = (short) dis.readUnsignedByte();
            extra = (short) dis.readUnsignedByte();
            altEntityKind = (short) dis.readUnsignedByte();
            altDomain = (short) dis.readUnsignedByte();
            altCountry = dis.readUnsignedShort();
            altCategory = (short) dis.readUnsignedByte();
            altSubcategory = (short) dis.readUnsignedByte();
            altSpecific = (short) dis.readUnsignedByte();
            altExtra = (short) dis.readUnsignedByte();
            xVelocity = dis.readFloat();
            yVelocity = dis.readFloat();
            zVelocity = dis.readFloat();
            xLocation = dis.readDouble();
            yLocation = dis.readDouble();
            zLocation = dis.readDouble();
            psi = dis.readFloat();
            theta = dis.readFloat();
            phi = dis.readFloat();
            entityAppearance = dis.readInt();
            deadReckoningAlgorithm = (short) dis.readUnsignedByte();
            for (int idx = 0; idx < otherParameters.length; idx++) {
                otherParameters[idx] = dis.readByte();
            } // end of array unmarshaling
            xAcceleration = dis.readFloat();
            yAcceleration = dis.readFloat();
            zAcceleration = dis.readFloat();
            xAngularVelocity = dis.readFloat();
            yAngularVelocity = dis.readFloat();
            zAngularVelocity = dis.readFloat();
            for (int idx = 0; idx < marking.length; idx++) {
                marking[idx] = dis.readByte();
            } // end of array unmarshaling
            capabilities = dis.readInt();
            for (int idx = 0; idx < numberOfArticulationParameters; idx++) {
                ArticulationParameter anX = new ArticulationParameter();
                anX.unmarshal(dis);
                articulationParameters.add(anX);
            }

        } // end try
        catch (Exception e) {
            System.out.println(e);
        }
    } // end of unmarshal method

    /**
     * Packs a Pdu into the ByteBuffer.
     * @throws java.nio.BufferOverflowException if buff is too small
     * @throws java.nio.ReadOnlyBufferException if buff is read only
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin writing
     * @since ??
     */
    @Override
    public void marshal(java.nio.ByteBuffer buff) {
        super.marshal(buff);
        buff.putShort((short) site);
        buff.putShort((short) application);
        buff.putShort((short) entity);
        buff.put((byte) forceId);
        buff.put((byte) articulationParameters.size());
        buff.put((byte) entityKind);
        buff.put((byte) domain);
        buff.putShort((short) country);
        buff.put((byte) category);
        buff.put((byte) subcategory);
        buff.put((byte) specific);
        buff.put((byte) extra);
        buff.put((byte) altEntityKind);
        buff.put((byte) altDomain);
        buff.putShort((short) altCountry);
        buff.put((byte) altCategory);
        buff.put((byte) altSubcategory);
        buff.put((byte) altSpecific);
        buff.put((byte) altExtra);
        buff.putFloat(xVelocity);
        buff.putFloat(yVelocity);
        buff.putFloat(zVelocity);
        buff.putDouble(xLocation);
        buff.putDouble(yLocation);
        buff.putDouble(zLocation);
        buff.putFloat(psi);
        buff.putFloat(theta);
        buff.putFloat(phi);
        buff.putInt(entityAppearance);
        buff.put((byte) deadReckoningAlgorithm);

        for (int idx = 0; idx < otherParameters.length; idx++) {
            buff.put(otherParameters[idx]);
        } // end of array marshaling

        buff.putFloat(xAcceleration);
        buff.putFloat(yAcceleration);
        buff.putFloat(zAcceleration);
        buff.putFloat(xAngularVelocity);
        buff.putFloat(yAngularVelocity);
        buff.putFloat(zAngularVelocity);

        for (int idx = 0; idx < marking.length; idx++) {
            buff.put(marking[idx]);
        } // end of array marshaling

        buff.putInt(capabilities);

        for (int idx = 0; idx < articulationParameters.size(); idx++) {
            ArticulationParameter aArticulationParameter = articulationParameters.get(idx);
            aArticulationParameter.marshal(buff);
        } // end of list marshalling

    } // end of marshal method

    /**
     * Unpacks a Pdu from the underlying data.
     * @throws java.nio.BufferUnderflowException if buff is too small
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     * @since ??
     */
    @Override
    public void unmarshal(java.nio.ByteBuffer buff) {
        super.unmarshal(buff);

        site = (buff.getShort() & 0xFFFF);
        application = (buff.getShort() & 0xFFFF);
        entity = (buff.getShort() & 0xFFFF);
        forceId = (short) (buff.get() & 0xFF);
        numberOfArticulationParameters = buff.get();
        entityKind = (short) (buff.get() & 0xFF);
        domain = (short) (buff.get() & 0xFF);
        country = (buff.getShort() & 0xFFFF);
        category = (short) (buff.get() & 0xFF);
        subcategory = (short) (buff.get() & 0xFF);
        specific = (short) (buff.get() & 0xFF);
        extra = (short) (buff.get() & 0xFF);
        altEntityKind = (short) (buff.get() & 0xFF);
        altDomain = (short) (buff.get() & 0xFF);
        altCountry = (buff.getShort() & 0xFFFF);
        altCategory = (short) (buff.get() & 0xFF);
        altSubcategory = (short) (buff.get() & 0xFF);
        altSpecific = (short) (buff.get() & 0xFF);
        altExtra = (short) (buff.get() & 0xFF);
        xVelocity = buff.getFloat();
        yVelocity = buff.getFloat();
        zVelocity = buff.getFloat();
        xLocation = buff.getDouble();
        yLocation = buff.getDouble();
        zLocation = buff.getDouble();
        psi = buff.getFloat();
        theta = buff.getFloat();
        phi = buff.getFloat();
        entityAppearance = buff.getInt();
        deadReckoningAlgorithm = (short) (buff.get() & 0xFF);
        for (int idx = 0; idx < otherParameters.length; idx++) {
            otherParameters[idx] = buff.get();
        } // end of array unmarshaling
        xAcceleration = buff.getFloat();
        yAcceleration = buff.getFloat();
        zAcceleration = buff.getFloat();
        xAngularVelocity = buff.getFloat();
        yAngularVelocity = buff.getFloat();
        zAngularVelocity = buff.getFloat();
        for (int idx = 0; idx < marking.length; idx++) {
            marking[idx] = buff.get();
        } // end of array unmarshaling
        capabilities = buff.getInt();
        for (int idx = 0; idx < numberOfArticulationParameters; idx++) {
            ArticulationParameter anX = new ArticulationParameter();
            anX.unmarshal(buff);
            articulationParameters.add(anX);
        }

    } // end of unmarshal method

    /**
     * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
     * @param rhs
     * @return 
     */
    public boolean equals(FastEntityStatePdu rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        if (!(site == rhs.site)) {
            ivarsEqual = false;
        }
        if (!(application == rhs.application)) {
            ivarsEqual = false;
        }
        if (!(entity == rhs.entity)) {
            ivarsEqual = false;
        }
        if (!(forceId == rhs.forceId)) {
            ivarsEqual = false;
        }
        if (!(numberOfArticulationParameters == rhs.numberOfArticulationParameters)) {
            ivarsEqual = false;
        }
        if (!(entityKind == rhs.entityKind)) {
            ivarsEqual = false;
        }
        if (!(domain == rhs.domain)) {
            ivarsEqual = false;
        }
        if (!(country == rhs.country)) {
            ivarsEqual = false;
        }
        if (!(category == rhs.category)) {
            ivarsEqual = false;
        }
        if (!(subcategory == rhs.subcategory)) {
            ivarsEqual = false;
        }
        if (!(specific == rhs.specific)) {
            ivarsEqual = false;
        }
        if (!(extra == rhs.extra)) {
            ivarsEqual = false;
        }
        if (!(altEntityKind == rhs.altEntityKind)) {
            ivarsEqual = false;
        }
        if (!(altDomain == rhs.altDomain)) {
            ivarsEqual = false;
        }
        if (!(altCountry == rhs.altCountry)) {
            ivarsEqual = false;
        }
        if (!(altCategory == rhs.altCategory)) {
            ivarsEqual = false;
        }
        if (!(altSubcategory == rhs.altSubcategory)) {
            ivarsEqual = false;
        }
        if (!(altSpecific == rhs.altSpecific)) {
            ivarsEqual = false;
        }
        if (!(altExtra == rhs.altExtra)) {
            ivarsEqual = false;
        }
        if (!(xVelocity == rhs.xVelocity)) {
            ivarsEqual = false;
        }
        if (!(yVelocity == rhs.yVelocity)) {
            ivarsEqual = false;
        }
        if (!(zVelocity == rhs.zVelocity)) {
            ivarsEqual = false;
        }
        if (!(xLocation == rhs.xLocation)) {
            ivarsEqual = false;
        }
        if (!(yLocation == rhs.yLocation)) {
            ivarsEqual = false;
        }
        if (!(zLocation == rhs.zLocation)) {
            ivarsEqual = false;
        }
        if (!(psi == rhs.psi)) {
            ivarsEqual = false;
        }
        if (!(theta == rhs.theta)) {
            ivarsEqual = false;
        }
        if (!(phi == rhs.phi)) {
            ivarsEqual = false;
        }
        if (!(entityAppearance == rhs.entityAppearance)) {
            ivarsEqual = false;
        }
        if (!(deadReckoningAlgorithm == rhs.deadReckoningAlgorithm)) {
            ivarsEqual = false;
        }

        for (int idx = 0; idx < 15; idx++) {
            if (!(otherParameters[idx] == rhs.otherParameters[idx])) {
                ivarsEqual = false;
            }
        }

        if (!(xAcceleration == rhs.xAcceleration)) {
            ivarsEqual = false;
        }
        if (!(yAcceleration == rhs.yAcceleration)) {
            ivarsEqual = false;
        }
        if (!(zAcceleration == rhs.zAcceleration)) {
            ivarsEqual = false;
        }
        if (!(xAngularVelocity == rhs.xAngularVelocity)) {
            ivarsEqual = false;
        }
        if (!(yAngularVelocity == rhs.yAngularVelocity)) {
            ivarsEqual = false;
        }
        if (!(zAngularVelocity == rhs.zAngularVelocity)) {
            ivarsEqual = false;
        }

        for (int idx = 0; idx < 12; idx++) {
            if (!(marking[idx] == rhs.marking[idx])) {
                ivarsEqual = false;
            }
        }

        if (!(capabilities == rhs.capabilities)) {
            ivarsEqual = false;
        }

        for (int idx = 0; idx < articulationParameters.size(); idx++) {
            ArticulationParameter x = articulationParameters.get(idx);
            if (!(x.equals(rhs.articulationParameters.get(idx)))) {
                ivarsEqual = false;
            }
        }

        return ivarsEqual;
    }
} // end of class
