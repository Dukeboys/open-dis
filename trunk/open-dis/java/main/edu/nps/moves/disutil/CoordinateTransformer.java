

package edu.nps.moves.disutil;

import edu.nps.moves.dis.Vector3Double;
import edu.nps.moves.dis.Vector3Float;

/**
 * Abstract superclass for doing global coordinate transforms. Given a Vector3Double
 * that specifies the location of an entity in the world, transforms it from a given
 * initial coordinate system (such as lat/lon/altitude, or x/y/altitude) to another
 * coordinate system, such as DIS earth-centered. This transformation is carried out
 * in the concrete subclass.<p>
 *
 * Ideally you want to translate into DIS standard coordinates, but not everyone
 * actually uses that, so I'm agnostic about whether you want to follow the
 * standard. If you want to write a transform that puts lat/lon on the wire, that's
 * up to you.<p>
 * 
 * @author DMcG
 */
public abstract class CoordinateTransformer
{
    /** Changes the coordinate system of the input coordinates to the target. The
     * return value is the destructively modified input object, ie the values of
     * the input object are changed and the object returned.
     * 
     * @param source
     * @return the destuctively modified object coordinates
     */
   public abstract Vector3Double transformCoordinate(Vector3Double source);

}
