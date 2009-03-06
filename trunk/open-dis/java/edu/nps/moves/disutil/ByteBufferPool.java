
package edu.nps.moves.disutil;

import java.nio.*;
import java.util.*;

/**
 * A pool that holds ByteBuffer objects. The rationale for this class results
 * from the fact that ByteBuffers can't expand when writing to them. So, for
 * example, we might have an espdu that has a marshalled length of 200 try
 * to put itself into a 144 byte buffer. But, for memory conservation reasons,
 * we also don't want to allocate a nuew buffer every time we marshal a PDU.
 * Instead we ask the pool for a byte buffer of the appropriate length, and
 * keep it around afterwards for reuse.<p>
 *
 * This has some obvious problems if we generate 2000 byte buffer objects, which
 * will have a big memory footprint that won't be GC'd. If this turns out to be
 * a problem--I suspect not, right now--we can implement some sort of clear()
 * operation to wipe out the pool once some criteria is met.<p>
 * 
 * @author DMcG
 */
public class ByteBufferPool
{

    private HashMap<Integer, ByteBuffer> pool;


    public ByteBufferPool()
    {
        pool = new HashMap<Integer, ByteBuffer>();
    }

    /**
     * Returns a byte buffer from the pool that has the given length.
     * If there is not ByteBuffer with that length, it is created and
     * added to the pool.
     *
     * @param length
     * @return The byte buffer with the given length
     */
    public ByteBuffer getByteBufferOfLength(int length)
    {
        ByteBuffer bbuf = pool.get(new Integer(length));

        if(bbuf == null)
        {
            byte[] backingStore = new byte[length];
            bbuf = ByteBuffer.wrap(backingStore);
            pool.put(new Integer(length), bbuf);
        }

        return bbuf;
    }

    /**
     * Removes all the byte buffers from the pool, allowing them to
     * be GC'd. 
     */
    public void clear()
    {
        pool.clear();
    }

}
