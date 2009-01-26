package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.12.9: initializing or chaning internal state information, reliable. Needs manual intervention to fix     padding on variable datums. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * @version $Id:$
 */
public class SetDataReliablePdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable {

    /** level of reliability service used for this transaction */
    protected short requiredReliabilityService;
    /** padding */
    protected int pad1;
    /** padding */
    protected short pad2;
    /** Request ID */
    protected long requestID;
    /** Fixed datum record count */
    protected long numberOfFixedDatumRecords;
    /** variable datum record count */
    protected long numberOfVariableDatumRecords;
    /** Fixed datum records */
    protected List<FixedDatum> fixedDatumRecords = new ArrayList<FixedDatum>();
    /** Variable datum records */
    protected List<VariableDatum> variableDatumRecords = new ArrayList<VariableDatum>();

    /** Constructor */

    public SetDataReliablePdu() {
        setPduType((short) 59);
    }

    @Override
    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize = super.getMarshalledSize();
        marshalSize = marshalSize + 1;  // requiredReliabilityService
        marshalSize = marshalSize + 2;  // pad1
        marshalSize = marshalSize + 1;  // pad2
        marshalSize = marshalSize + 4;  // requestID
        marshalSize = marshalSize + 4;  // numberOfFixedDatumRecords
        marshalSize = marshalSize + 4;  // numberOfVariableDatumRecords
        for (int idx = 0; idx < fixedDatumRecords.size(); idx++) {
            FixedDatum listElement = fixedDatumRecords.get(idx);
            marshalSize = marshalSize + listElement.getMarshalledSize();
        }
        for (int idx = 0; idx < variableDatumRecords.size(); idx++) {
            VariableDatum listElement = variableDatumRecords.get(idx);
            marshalSize = marshalSize + listElement.getMarshalledSize();
        }

        return marshalSize;
    }

    public void setRequiredReliabilityService(short pRequiredReliabilityService) {
        requiredReliabilityService = pRequiredReliabilityService;
    }

    @XmlAttribute
    public short getRequiredReliabilityService() {
        return requiredReliabilityService;
    }

    public void setPad1(int pPad1) {
        pad1 = pPad1;
    }

    @XmlAttribute
    public int getPad1() {
        return pad1;
    }

    public void setPad2(short pPad2) {
        pad2 = pPad2;
    }

    @XmlAttribute
    public short getPad2() {
        return pad2;
    }

    public void setRequestID(long pRequestID) {
        requestID = pRequestID;
    }

    @XmlAttribute
    public long getRequestID() {
        return requestID;
    }

    @XmlAttribute
    public long getNumberOfFixedDatumRecords() {
        return (long) fixedDatumRecords.size();
    }

    /** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
     * The getnumberOfFixedDatumRecords method will also be based on the actual list length rather than this value.
     * The method is simply here for java bean completeness.
     * @param pNumberOfFixedDatumRecords
     */
    public void setNumberOfFixedDatumRecords(long pNumberOfFixedDatumRecords) {
        numberOfFixedDatumRecords = pNumberOfFixedDatumRecords;
    }

    @XmlAttribute
    public long getNumberOfVariableDatumRecords() {
        return (long) variableDatumRecords.size();
    }

    /** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
     * The getnumberOfVariableDatumRecords method will also be based on the actual list length rather than this value.
     * The method is simply here for java bean completeness.
     * @param pNumberOfVariableDatumRecords
     */
    public void setNumberOfVariableDatumRecords(long pNumberOfVariableDatumRecords) {
        numberOfVariableDatumRecords = pNumberOfVariableDatumRecords;
    }

    public void setFixedDatumRecords(List<FixedDatum> pFixedDatumRecords) {
        fixedDatumRecords = pFixedDatumRecords;
    }

    @XmlElementWrapper(name = "fixedDatumRecordsList")
    public List<FixedDatum> getFixedDatumRecords() {
        return fixedDatumRecords;
    }

    @SuppressWarnings("unchecked")
    public void setVariableDatumRecords(List<VariableDatum> pVariableDatumRecords) {
        variableDatumRecords = pVariableDatumRecords;
    }

    @XmlElementWrapper(name = "variableDatumRecordsList")
    public List<VariableDatum> getVariableDatumRecords() {
        return variableDatumRecords;
    }

    @Override
    public void marshal(DataOutputStream dos) {
        super.marshal(dos);
        try {
            dos.writeByte((byte) requiredReliabilityService);
            dos.writeShort((short) pad1);
            dos.writeByte((byte) pad2);
            dos.writeInt((int) requestID);
            dos.writeInt(fixedDatumRecords.size());
            dos.writeInt(variableDatumRecords.size());

            for (int idx = 0; idx < fixedDatumRecords.size(); idx++) {
                FixedDatum aFixedDatum = fixedDatumRecords.get(idx);
                aFixedDatum.marshal(dos);
            } // end of list marshalling


            for (int idx = 0; idx < variableDatumRecords.size(); idx++) {
                VariableDatum aVariableDatum = variableDatumRecords.get(idx);
                aVariableDatum.marshal(dos);
            } // end of list marshalling

        } // end try
        catch (Exception e) {
            System.out.println(e);
        }
    } // end of marshal method

    @Override
    /**
     *
     */
    public void unmarshal(DataInputStream dis) {
        super.unmarshal(dis);

        try {
            requiredReliabilityService = (short) dis.readUnsignedByte();
            pad1 = dis.readUnsignedShort();
            pad2 = (short) dis.readUnsignedByte();
            requestID = dis.readInt();
            numberOfFixedDatumRecords = dis.readInt();
            numberOfVariableDatumRecords = dis.readInt();
            for (int idx = 0; idx < numberOfFixedDatumRecords; idx++) {
                FixedDatum anX = new FixedDatum();
                anX.unmarshal(dis);
                fixedDatumRecords.add(anX);
            }

            for (int idx = 0; idx < numberOfVariableDatumRecords; idx++) {
                VariableDatum anX = new VariableDatum();
                anX.unmarshal(dis);
                variableDatumRecords.add(anX);
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
        buff.put((byte) requiredReliabilityService);
        buff.putShort((short) pad1);
        buff.put((byte) pad2);
        buff.putInt((int) requestID);
        buff.putInt(fixedDatumRecords.size());
        buff.putInt(variableDatumRecords.size());

        for (int idx = 0; idx < fixedDatumRecords.size(); idx++) {
            FixedDatum aFixedDatum = fixedDatumRecords.get(idx);
            aFixedDatum.marshal(buff);
        } // end of list marshalling


        for (int idx = 0; idx < variableDatumRecords.size(); idx++) {
            VariableDatum aVariableDatum = variableDatumRecords.get(idx);
            aVariableDatum.marshal(buff);
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

        requiredReliabilityService = (short) (buff.get() & 0xFF);
        pad1 = (buff.getShort() & 0xFFFF);
        pad2 = (short) (buff.get() & 0xFF);
        requestID = buff.getInt();
        numberOfFixedDatumRecords = buff.getInt();
        numberOfVariableDatumRecords = buff.getInt();
        for (int idx = 0; idx < numberOfFixedDatumRecords; idx++) {
            FixedDatum anX = new FixedDatum();
            anX.unmarshal(buff);
            fixedDatumRecords.add(anX);
        }

        for (int idx = 0; idx < numberOfVariableDatumRecords; idx++) {
            VariableDatum anX = new VariableDatum();
            anX.unmarshal(buff);
            variableDatumRecords.add(anX);
        }

    } // end of unmarshal method

    /**
     * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
     * @param rhs
     * @return
     */
    public boolean equals(SetDataReliablePdu rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        if (!(requiredReliabilityService == rhs.requiredReliabilityService)) {
            ivarsEqual = false;
        }
        if (!(pad1 == rhs.pad1)) {
            ivarsEqual = false;
        }
        if (!(pad2 == rhs.pad2)) {
            ivarsEqual = false;
        }
        if (!(requestID == rhs.requestID)) {
            ivarsEqual = false;
        }
        if (!(numberOfFixedDatumRecords == rhs.numberOfFixedDatumRecords)) {
            ivarsEqual = false;
        }
        if (!(numberOfVariableDatumRecords == rhs.numberOfVariableDatumRecords)) {
            ivarsEqual = false;
        }

        for (int idx = 0; idx < fixedDatumRecords.size(); idx++) {
            FixedDatum x = fixedDatumRecords.get(idx);
            if (!(x.equals(rhs.fixedDatumRecords.get(idx)))) {
                ivarsEqual = false;
            }
        }

        for (int idx = 0; idx < variableDatumRecords.size(); idx++) {
            VariableDatum x = variableDatumRecords.get(idx);
            if (!(x.equals(rhs.variableDatumRecords.get(idx)))) {
                ivarsEqual = false;
            }
        }

        return ivarsEqual;
    }
} // end of class
