package edu.nps.moves.dis;

import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.5. Articulation parameters for movable parts and attached parts of an entity. Specifes wether or not a change has occured, the part identifcation of the articulated part to which it is attached, and the type and value of each parameter.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * $Id:$
 */
public class ArticulationParameter implements Serializable {

    protected byte parameterTypeDesignator;
    protected byte changeIndicator;
    protected short partAttachedTo;
    protected int parameterType;
    protected double parameterValue;

    /** Constructor */
    public ArticulationParameter() {
        parameterTypeDesignator = 0;
        changeIndicator = 0;
        partAttachedTo = 0;
        parameterType = 0;
        parameterValue = 0.0d;
    }

    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize = marshalSize + 1;  // parameterTypeDesignator
        marshalSize = marshalSize + 1;  // changeIndicator
        marshalSize = marshalSize + 2;  // partAttachedTo
        marshalSize = marshalSize + 4;  // parameterType
        marshalSize = marshalSize + 8;  // parameterValue

        return marshalSize;
    }

    public void setParameterTypeDesignator(byte pParameterTypeDesignator) {
        parameterTypeDesignator = pParameterTypeDesignator;
    }

    @XmlAttribute
    public short getParameterTypeDesignator() {
        return parameterTypeDesignator;
    }

    public void setChangeIndicator(byte pChangeIndicator) {
        
        // Don't allow negative, or more than (2^7) - 1 -- post processing patch
        if ((pChangeIndicator < 0) || (pChangeIndicator > Byte.MAX_VALUE)) {
            pChangeIndicator = 0;
        } else {
            changeIndicator = pChangeIndicator;
        }
    }

    @XmlAttribute
    public short getChangeIndicator() {
        return changeIndicator;
    }

    public void setPartAttachedTo(short pPartAttachedTo) {
        partAttachedTo = pPartAttachedTo;
    }

    @XmlAttribute
    public int getPartAttachedTo() {
        return partAttachedTo;
    }

    public void setParameterType(int pParameterType) {
        parameterType = pParameterType;
    }

    @XmlAttribute
    public int getParameterType() {
        return parameterType;
    }

    public void setParameterValue(double pParameterValue) {
        parameterValue = pParameterValue;
    }

    @XmlAttribute
    public double getParameterValue() {
        return parameterValue;
    }

    public void marshal(DataOutputStream dos) {
        try {
            dos.writeByte(parameterTypeDesignator);
            dos.writeByte(changeIndicator);
            dos.writeShort(partAttachedTo);
            dos.writeInt(parameterType);
            dos.writeDouble(parameterValue);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void unmarshal(DataInputStream dis) {
        try {
            parameterTypeDesignator = (byte) dis.readUnsignedByte();
            changeIndicator = (byte) dis.readUnsignedByte();
            partAttachedTo = (short) dis.readUnsignedShort();
            parameterType = dis.readInt();
            parameterValue = dis.readDouble();
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
        buff.put(parameterTypeDesignator);
        buff.put(changeIndicator);
        buff.putShort(partAttachedTo);
        buff.putInt(parameterType);
        buff.putDouble(parameterValue);
    }

    /**
     * Unpacks a Pdu from the underlying data.
     * @throws java.nio.BufferUnderflowException if buff is too small
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     * @since ??
     */
    public void unmarshal(java.nio.ByteBuffer buff) {
        parameterTypeDesignator = (byte) (buff.get() & 0xFF);
        changeIndicator = (byte) (buff.get() & 0xFF);
        partAttachedTo = (short) (buff.getShort() & 0xFFFF);
        parameterType = buff.getInt();
        parameterValue = buff.getDouble();
    }

    /**
     * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
     * @param rhs
     * @return
     */
    public boolean equals(ArticulationParameter rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        if (!(parameterTypeDesignator == rhs.parameterTypeDesignator)) {
            ivarsEqual = false;
        }
        if (!(changeIndicator == rhs.changeIndicator)) {
            ivarsEqual = false;
        }
        if (!(partAttachedTo == rhs.partAttachedTo)) {
            ivarsEqual = false;
        }
        if (!(parameterType == rhs.parameterType)) {
            ivarsEqual = false;
        }
        if (!(parameterValue == rhs.parameterValue)) {
            ivarsEqual = false;
        }

        return ivarsEqual;
    }

} // end of class file ArticluationParameter.java