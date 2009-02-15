package edu.nps.moves.dis;

import java.io.*;

/**
 * Section 5.3.3. Common superclass for EntityState, Collision, collision-elastic, and entity state update PDUs. This should be abstract. COMPLETE
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * @version $Id:$
 */
public class EntityInformationFamilyPdu extends Pdu implements Serializable {

    /** Constructor */
    public EntityInformationFamilyPdu() {
        setProtocolFamily((short) 1);
    }

    @Override
    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize = super.getMarshalledSize();

        return marshalSize;
    }

    @Override
    public void marshal(DataOutputStream dos) {
        super.marshal(dos);
        try {
        } // end try
        catch (Exception e) {
            System.out.println(e);
        }
    } // end of marshal method

    @Override
    public void unmarshal(DataInputStream dis) {
        super.unmarshal(dis);

        try {
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

    } // end of unmarshal method

    /**
     * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
     * @param rhs
     * @return
     */
    public boolean equals(EntityInformationFamilyPdu rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        return ivarsEqual;
    }
} // end of class file EntityInformationFamilyPdu.java
