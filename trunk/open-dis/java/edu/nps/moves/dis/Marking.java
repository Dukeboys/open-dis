package edu.nps.moves.dis;

import java.io.*;
import javax.xml.bind.annotation.*;

/**
 * Section 5.2.15. Specifies the character set used inthe first byte, followed by 11 characters of text data.
 *
 * Copyright (c) 2008, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 * @version $Id:$
 */
public class Marking implements Serializable {

    /** The character set */
    protected short characterSet;

    /** The characters */
    protected byte[] characters = new byte[11];

    /** Constructor */
    public Marking() {}

    public int getMarshalledSize() {
        int marshalSize = 0;

        marshalSize += 1;  // characterSet
        marshalSize += 11; // characters

        return marshalSize;
    }

    /**
     * Typically US-ASCII
     * @param pCharacterSet
     */
    public void setCharacterSet(short pCharacterSet) {
        characterSet = pCharacterSet;
    }

    @XmlAttribute
    public short getCharacterSet() {
        return characterSet;
    }

    /**
     * Ensure what is set does not go over 11 characters -- post-processing patch
     * @param pCharacters an array of characters to set
     */
    public void setCharacters(byte[] pCharacters) {
        if (pCharacters.length >= characters.length) {
            System.arraycopy(pCharacters, 0, characters, 0, characters.length);
        } else {
            int pCharactersLength = pCharacters.length;
            System.arraycopy(pCharacters, 0, characters, 0, pCharactersLength);
            for (int ix = pCharactersLength; ix < characters.length; ix++) {

                // Ensure all zeros in unfilled fields
                characters[ix] = 0;
            }
        }
    }

    @XmlElement(name = "characters")
    public byte[] getCharacters() {
        return characters;
    }

    public void marshal(DataOutputStream dos) {
        try {
            dos.writeByte((byte) characterSet);

            for (int idx = 0; idx < characters.length; idx++) {
                dos.writeByte(characters[idx]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void unmarshal(DataInputStream dis) {
        try {
            characterSet = (short) dis.readUnsignedByte();
            for (int idx = 0; idx < characters.length; idx++) {
                characters[idx] = dis.readByte();
            }
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
        buff.put((byte) characterSet);

        for (byte character : characters) {
            buff.put(character);
        }
    }

    /**
     * Unpacks a Pdu from the underlying data.
     * @throws java.nio.BufferUnderflowException if buff is too small
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     * @since ??
     */
    public void unmarshal(java.nio.ByteBuffer buff) {
        characterSet = (short) (buff.get() & 0xFF);
        for (int idx = 0; idx < characters.length; idx++) {
            characters[idx] = buff.get();
        }
    }

    /**
     * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
     * @param rhs
     * @return
     */
    public boolean equals(Marking rhs) {
        boolean ivarsEqual = true;

        if (rhs.getClass() != this.getClass()) {
            return false;
        }

        if (!(characterSet == rhs.characterSet)) {
            ivarsEqual = false;
        }

        for (int idx = 0; idx < 11; idx++) {
            if (!(characters[idx] == rhs.characters[idx])) {
                ivarsEqual = false;
            }
        }

        return ivarsEqual;
    }

} // end of class file Marking.java
