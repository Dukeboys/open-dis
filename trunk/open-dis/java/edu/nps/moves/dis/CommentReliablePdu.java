package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.3.12.12: Arbitrary messages. Only reliable this time. Neds manual intervention     to fix padding in variable datums. UNFINISHED
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * @version $Id:$
 */
public class CommentReliablePdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable {

    /** Fixed datum record count */
    protected long numberOfFixedDatumRecords;
    /** variable datum record count */
    protected long numberOfVariableDatumRecords;
    /** Fixed datum records */
    protected List<FixedDatum> fixedDatumRecords = new ArrayList<FixedDatum>();
    /** Variable datum records */
    protected List<VariableDatum> variableDatumRecords = new ArrayList<VariableDatum>();

    /** Constructor */
    public CommentReliablePdu() {
        setPduType((short) 62);
    }

    @Override
    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize = super.getMarshalledSize();
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
    public List getFixedDatumRecords() {
        return fixedDatumRecords;
    }

    public void setVariableDatumRecords(List<VariableDatum> pVariableDatumRecords) {
        variableDatumRecords = pVariableDatumRecords;
    }

    @XmlElementWrapper(name = "variableDatumRecordsList")
    public List getVariableDatumRecords() {
        return variableDatumRecords;
    }

    @Override
    public void marshal(DataOutputStream dos) {
        super.marshal(dos);
        try {
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
    public void unmarshal(DataInputStream dis) {
        super.unmarshal(dis);

        try {
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
    public boolean equals(CommentReliablePdu rhs) {
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
