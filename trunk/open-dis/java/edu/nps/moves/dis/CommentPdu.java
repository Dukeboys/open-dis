package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.6.12. Arbitrary messages can be entered into the data stream via use of this PDU. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * @version $Id:$
 */
public class CommentPdu extends SimulationManagementFamilyPdu implements Serializable {

    /** Number of fixed datum records */
    protected long numberOfFixedDatumRecords;
    /** Number of variable datum records */
    protected long numberOfVariableDatumRecords;
    /** variable length list of fixed datums */
    protected List<FixedDatum> fixedDatums = new ArrayList<FixedDatum>();
    /** variable length list of variable length datums */
    protected List<VariableDatum> variableDatums = new ArrayList<VariableDatum>();

    /** Constructor */
    public CommentPdu() {
        setPduType((short) 22);
    }

    @Override
    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize = super.getMarshalledSize();
        marshalSize = marshalSize + 4;  // numberOfFixedDatumRecords
        marshalSize = marshalSize + 4;  // numberOfVariableDatumRecords
        for (int idx = 0; idx < fixedDatums.size(); idx++) {
            FixedDatum listElement = fixedDatums.get(idx);
            marshalSize = marshalSize + listElement.getMarshalledSize();
        }
        for (int idx = 0; idx < variableDatums.size(); idx++) {
            VariableDatum listElement = variableDatums.get(idx);
            marshalSize = marshalSize + listElement.getMarshalledSize();
        }

        return marshalSize;
    }

    @XmlAttribute
    public long getNumberOfFixedDatumRecords() {
        return (long) fixedDatums.size();
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
        return (long) variableDatums.size();
    }

    /** Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
     * The getnumberOfVariableDatumRecords method will also be based on the actual list length rather than this value.
     * The method is simply here for java bean completeness.
     * @param pNumberOfVariableDatumRecords
     */
    public void setNumberOfVariableDatumRecords(long pNumberOfVariableDatumRecords) {
        numberOfVariableDatumRecords = pNumberOfVariableDatumRecords;
    }

    public void setFixedDatums(List<FixedDatum> pFixedDatums) {
        fixedDatums = pFixedDatums;
    }

    @XmlElementWrapper(name = "fixedDatumsList")
    public List getFixedDatums() {
        return fixedDatums;
    }

    public void setVariableDatums(List<VariableDatum> pVariableDatums) {
        variableDatums = pVariableDatums;
    }

    @XmlElementWrapper(name = "variableDatumsList")
    public List getVariableDatums() {
        return variableDatums;
    }

    @Override
    public void marshal(DataOutputStream dos) {
        super.marshal(dos);
        try {
            dos.writeInt(fixedDatums.size());
            dos.writeInt(variableDatums.size());

            for (int idx = 0; idx < fixedDatums.size(); idx++) {
                FixedDatum aFixedDatum = fixedDatums.get(idx);
                aFixedDatum.marshal(dos);
            } // end of list marshalling


            for (int idx = 0; idx < variableDatums.size(); idx++) {
                VariableDatum aVariableDatum = variableDatums.get(idx);
                aVariableDatum.marshal(dos);
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
            numberOfFixedDatumRecords = dis.readInt();
            numberOfVariableDatumRecords = dis.readInt();
            for (int idx = 0; idx < numberOfFixedDatumRecords; idx++) {
                FixedDatum anX = new FixedDatum();
                anX.unmarshal(dis);
                fixedDatums.add(anX);
            }

            for (int idx = 0; idx < numberOfVariableDatumRecords; idx++) {
                VariableDatum anX = new VariableDatum();
                anX.unmarshal(dis);
                variableDatums.add(anX);
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
        buff.putInt(fixedDatums.size());
        buff.putInt(variableDatums.size());

        for (int idx = 0; idx < fixedDatums.size(); idx++) {
            FixedDatum aFixedDatum = fixedDatums.get(idx);
            aFixedDatum.marshal(buff);
        } // end of list marshalling


        for (int idx = 0; idx < variableDatums.size(); idx++) {
            VariableDatum aVariableDatum = variableDatums.get(idx);
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

        numberOfFixedDatumRecords = buff.getInt();
        numberOfVariableDatumRecords = buff.getInt();
        for (int idx = 0; idx < numberOfFixedDatumRecords; idx++) {
            FixedDatum anX = new FixedDatum();
            anX.unmarshal(buff);
            fixedDatums.add(anX);
        }

        for (int idx = 0; idx < numberOfVariableDatumRecords; idx++) {
            VariableDatum anX = new VariableDatum();
            anX.unmarshal(buff);
            variableDatums.add(anX);
        }

    } // end of unmarshal method

    /**
     * The equals method doesn't always work--mostly on on classes that consist only of primitives. Be careful.
     * @param rhs
     * @return
     */
    public boolean equals(CommentPdu rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        if (!(numberOfFixedDatumRecords == rhs.numberOfFixedDatumRecords)) {
            ivarsEqual = false;
        }
        if (!(numberOfVariableDatumRecords == rhs.numberOfVariableDatumRecords)) {
            ivarsEqual = false;
        }

        for (int idx = 0; idx < fixedDatums.size(); idx++) {
            FixedDatum x = fixedDatums.get(idx);
            if (!(x.equals(rhs.fixedDatums.get(idx)))) {
                ivarsEqual = false;
            }
        }

        for (int idx = 0; idx < variableDatums.size(); idx++) {
            VariableDatum x = variableDatums.get(idx);
            if (!(x.equals(rhs.variableDatums.get(idx)))) {
                ivarsEqual = false;
            }
        }

        return ivarsEqual;
    }
} // end of class
