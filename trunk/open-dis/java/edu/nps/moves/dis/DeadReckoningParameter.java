package edu.nps.moves.dis;

import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * represents values used in dead reckoning algorithms
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class DeadReckoningParameter implements Serializable {

    /** enumeration of what dead reckoning algorighm to use */
    protected short deadReckoningAlgorithm;

    /** other parameters to use in the dead reckoning algorithm */
    protected byte[] otherParameters = new byte[15];

    /** Linear acceleration of the entity */
    protected Vector3Float entityLinearAcceleration = new Vector3Float();

    /** angular velocity of the entity */
    protected Vector3Float entityAngularVelocity = new Vector3Float();

    /** Constructor */
    public DeadReckoningParameter() {
        deadReckoningAlgorithm = 0;
    }

    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize += 1;  // deadReckoningAlgorithm
        marshalSize += 15;  // otherParameters
        marshalSize += entityLinearAcceleration.getMarshalledSize();  // entityLinearAcceleration
        marshalSize += entityAngularVelocity.getMarshalledSize();  // entityAngularVelocity

        return marshalSize;
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

    public void setEntityLinearAcceleration(Vector3Float pEntityLinearAcceleration) {
        entityLinearAcceleration = pEntityLinearAcceleration;
    }

    @XmlElement
    public Vector3Float getEntityLinearAcceleration() {
        return entityLinearAcceleration;
    }

    public void setEntityAngularVelocity(Vector3Float pEntityAngularVelocity) {
        entityAngularVelocity = pEntityAngularVelocity;
    }

    @XmlElement
    public Vector3Float getEntityAngularVelocity() {
        return entityAngularVelocity;
    }

    public void marshal(DataOutputStream dos) {
        try {
            dos.writeByte((byte) deadReckoningAlgorithm);

            for (int idx = 0; idx < otherParameters.length; idx++) {
                dos.writeByte(otherParameters[idx]);
            }

            entityLinearAcceleration.marshal(dos);
            entityAngularVelocity.marshal(dos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void unmarshal(DataInputStream dis) {
        try {
            deadReckoningAlgorithm = (short) dis.readUnsignedByte();
            for (int idx = 0; idx < otherParameters.length; idx++) {
                otherParameters[idx] = dis.readByte();
            }
            entityLinearAcceleration.unmarshal(dis);
            entityAngularVelocity.unmarshal(dis);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Packs a Pdu into the ByteBuffer.
     * @throws java.nio.BufferOverflowException if buff is too small
     * @throws java.nio.ReadOnlyBufferException if buff is read only
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin writing
     * @since ??
     */
    public void marshal(java.nio.ByteBuffer buff) {
        buff.put((byte) deadReckoningAlgorithm);

        for (byte op : otherParameters) {
            buff.put(op);
        }

        entityLinearAcceleration.marshal(buff);
        entityAngularVelocity.marshal(buff);
    }

    /**
     * Unpacks a Pdu from the underlying data.
     * @throws java.nio.BufferUnderflowException if buff is too small
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     * @since ??
     */
    public void unmarshal(java.nio.ByteBuffer buff) {
        deadReckoningAlgorithm = (short) (buff.get() & 0xFF);
        for (int idx = 0; idx < otherParameters.length; idx++) {
            otherParameters[idx] = buff.get();
        }
        entityLinearAcceleration.unmarshal(buff);
        entityAngularVelocity.unmarshal(buff);
    }

    /**
     * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
     * @param rhs
     * @return
     */
    public boolean equals(DeadReckoningParameter rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        if (!(deadReckoningAlgorithm == rhs.deadReckoningAlgorithm)) {
            ivarsEqual = false;
        }

        for (int idx = 0; idx < 15; idx++) {
            if (!(otherParameters[idx] == rhs.otherParameters[idx])) {
                ivarsEqual = false;
            }
        }

        if (!(entityLinearAcceleration.equals(rhs.entityLinearAcceleration))) {
            ivarsEqual = false;
        }
        if (!(entityAngularVelocity.equals(rhs.entityAngularVelocity))) {
            ivarsEqual = false;
        }

        return ivarsEqual;
    }
    
} // end of class
