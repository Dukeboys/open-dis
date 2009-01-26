package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * 5.3.3.4. Nonstatic information about a particular entity may be communicated by issuing an Entity State Update PDU. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * @version $Id:$
 */
public class EntityStateUpdatePdu extends EntityInformationFamilyPdu implements Serializable {

    /** This field shall identify the entity issuing the PDU */
    protected EntityID entityID = new EntityID();
    /** How many articulation parameters are in the variable length list */
    protected byte numberOfArticulationParameters;
    /** Describes the speed of the entity in the world */
    protected Vector3Float entityLinearVelocity = new Vector3Float();
    /** describes the location of the entity in the world */
    protected Vector3Double entityLocation = new Vector3Double();
    /** describes the orientation of the entity, in euler angles */
    protected Orientation entityOrientation = new Orientation();
    /** a series of bit flags that are used to help draw the entity, such as smoking, on fire, etc. */
    protected int entityAppearance;
    protected List<ArticulationParameter> articulationParameters = new ArrayList<ArticulationParameter>();

    /** Constructor */
    public EntityStateUpdatePdu() {
        setPduType((short) 67);
        setProtocolFamily((short) 1);
    }

    @Override
    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize = super.getMarshalledSize();
        marshalSize = marshalSize + entityID.getMarshalledSize();  // entityID
        marshalSize = marshalSize + 1;  // numberOfArticulationParameters
        marshalSize = marshalSize + entityLinearVelocity.getMarshalledSize();  // entityLinearVelocity
        marshalSize = marshalSize + entityLocation.getMarshalledSize();  // entityLocation
        marshalSize = marshalSize + entityOrientation.getMarshalledSize();  // entityOrientation
        marshalSize = marshalSize + 4;  // entityAppearance
        for (int idx = 0; idx < articulationParameters.size(); idx++) {
            ArticulationParameter listElement = articulationParameters.get(idx);
            marshalSize = marshalSize + listElement.getMarshalledSize();
        }

        return marshalSize;
    }

    public void setEntityID(EntityID pEntityID) {
        entityID = pEntityID;
    }

    @XmlElement
    public EntityID getEntityID() {
        return entityID;
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

    public void setEntityLinearVelocity(Vector3Float pEntityLinearVelocity) {
        entityLinearVelocity = pEntityLinearVelocity;
    }

    @XmlElement
    public Vector3Float getEntityLinearVelocity() {
        return entityLinearVelocity;
    }

    public void setEntityLocation(Vector3Double pEntityLocation) {
        entityLocation = pEntityLocation;
    }

    @XmlElement
    public Vector3Double getEntityLocation() {
        return entityLocation;
    }

    public void setEntityOrientation(Orientation pEntityOrientation) {
        entityOrientation = pEntityOrientation;
    }

    @XmlElement
    public Orientation getEntityOrientation() {
        return entityOrientation;
    }

    public void setEntityAppearance(int pEntityAppearance) {
        entityAppearance = pEntityAppearance;
    }

    @XmlAttribute
    public int getEntityAppearance() {
        return entityAppearance;
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
            entityID.marshal(dos);
            dos.writeByte((byte) articulationParameters.size());
            entityLinearVelocity.marshal(dos);
            entityLocation.marshal(dos);
            entityOrientation.marshal(dos);
            dos.writeInt(entityAppearance);

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
            entityID.unmarshal(dis);
            numberOfArticulationParameters = dis.readByte();
            entityLinearVelocity.unmarshal(dis);
            entityLocation.unmarshal(dis);
            entityOrientation.unmarshal(dis);
            entityAppearance = dis.readInt();
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
        entityID.marshal(buff);
        buff.put((byte) articulationParameters.size());
        entityLinearVelocity.marshal(buff);
        entityLocation.marshal(buff);
        entityOrientation.marshal(buff);
        buff.putInt(entityAppearance);

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

        entityID.unmarshal(buff);
        numberOfArticulationParameters = buff.get();
        entityLinearVelocity.unmarshal(buff);
        entityLocation.unmarshal(buff);
        entityOrientation.unmarshal(buff);
        entityAppearance = buff.getInt();
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
    public boolean equals(EntityStateUpdatePdu rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        if (!(entityID.equals(rhs.entityID))) {
            ivarsEqual = false;
        }
        if (!(numberOfArticulationParameters == rhs.numberOfArticulationParameters)) {
            ivarsEqual = false;
        }
        if (!(entityLinearVelocity.equals(rhs.entityLinearVelocity))) {
            ivarsEqual = false;
        }
        if (!(entityLocation.equals(rhs.entityLocation))) {
            ivarsEqual = false;
        }
        if (!(entityOrientation.equals(rhs.entityOrientation))) {
            ivarsEqual = false;
        }
        if (!(entityAppearance == rhs.entityAppearance)) {
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
