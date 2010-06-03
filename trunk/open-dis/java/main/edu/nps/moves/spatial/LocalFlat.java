package edu.nps.moves.spatial;

import org.sedris.*;
import edu.nps.moves.dis.*;

/**
 * Represents a local, flat area, which is convienient for somewhat small
 * simulated areas. The earth of course curves, so moving 1 m east can also
 * change the apparent altitude of the object from the perspective of the
 * starting point. This assumes a local, flat, euclidian coordinate system
 * with an origin at (lat, lon) and positive X pointing local east, positive Y
 * pointing local north, and positive Z pointing up. Specified in WGS_84 geodesic
 * coordinate system.<p>
 *
 * The coordinate system has its origin at the given (lat, lon) and creates a
 * plane tangent to the ellipsoid at that point. <p>
 *
 * See User’s Manual for SRM Orientation, Velocity, & Acceleration
 * Transformations Version 1.7, 13 December 2007, from the Sedris web site.
 * 
 * @author DMcG
 */
public class LocalFlat
{
    /** A reference frame for the earth's surface, ie an ellipsoid with coordinates
     * of the form (lat, lon, altitude).
     */
    SRF_Celestiodetic curvedSurfaceRef;

    /** A DIS reference frame, with a euclidian coordinate system with origin
     * at the center of of the earth. Coordinates, in (x, y, z), in meters. This
     * is the reference frame used by many DIS fields on the wire.
     */
    SRF_Celestiocentric disCoordinateFrame;

    /** A local, flat, euclidian reference frame. This is tangent to a (lat, lon, height)
     * on an earth that is supplied by the user in the constructor.
     * This allows users to set up a local, relatively small area
     * for moving things around without in the nuisance of worrying about curved
     * earth.
     */
    SRF_LocalTangentSpaceEuclidean localEuclidianFrame;

    /** The origin of the local euclidian reference frame */
    Coord3D localEuclidianOrigin;

    /**
     * Constructor for a local flat coordinate system. Takes the latitude and
     * longitude (in degrees) for WGS_84.<p>
     * 
     * @param originLat Origin of the flat local coordinate system, in degrees, latitude
     * @param originLon Orgigin of the flat local coordinate system, in degrees, longitude
     * @param origin height above ellipsoid surface, in meters
     */
    public LocalFlat(double originLat, double originLon, double heightOffset)
    {
        try
        {
            // Create a Celestiodetic SRF with WGS 1984, ie a curved coordinate
            // system (lat/lon)
             curvedSurfaceRef = new SRF_Celestiodetic(SRM_ORM_Code.ORM_WGS_1984,
                                           SRM_RT_Code.RT_WGS_1984_IDENTITY);

            // Create a Celesticentric SRF with WGS 1984, ie a rectilinear,
            // earth-centered coordinate system as used in DIS
            disCoordinateFrame = new SRF_Celestiocentric(SRM_ORM_Code.ORM_WGS_1984,
                                            SRM_RT_Code.RT_WGS_1984_IDENTITY);

            double latInRadians = Math.toRadians(originLat);
            double lonInRadians = Math.toRadians(originLon);

            // Reference system for a local euclidian space plane, tangent to the lat/lon
            // at a give altitude.
            localEuclidianFrame =
                    new SRF_LocalTangentSpaceEuclidean(SRM_ORM_Code.ORM_WGS_1984,
                    SRM_RT_Code.RT_WGS_1984_IDENTITY,
                    lonInRadians, latInRadians,  // Origin (note: lon, lat)
                    0.0,            // Azimuth; can rotate axis, but don't.
                    0.0, 0.0,       // False x,y origin (can offset origin to avoid negative coordinates)
                    heightOffset);  // Height offset

            // It's handy to have this pre-created in some calculations
            localEuclidianOrigin = localEuclidianFrame.createCoordinate3D(0.0, 0.0, 0.0);
        }
        catch(Exception e)
        {
            System.out.println("problem creating coordinate systems" + e);
        }

    }

    /**
     * Transform from local, flat coordinate system to the DIS coordinate system.
     * All units in meters, positive x east, y north, z altitude.
     * @param x x coordinate in local, flat coordinate system
     * @param y y coordinate in meters in local, flat coordinate system
     * @param z z coordinate, altitude, in meters in local flat coordinate system
     */
    public Vector3Double DISCoordFromLocalFlat(double x, double y, double z)
    {
        Vector3Double disCoordinates = new Vector3Double();
        try
        {
            Coord3D localCoordinates = localEuclidianFrame.createCoordinate3D(x, y, z);
            Coord3D disCoord = disCoordinateFrame.createCoordinate3D(0.0, 0.0, 0.0);

            SRM_Coordinate_Valid_Region_Code region = disCoordinateFrame.changeCoordinateSRF(localCoordinates, disCoord);

            //System.out.println(region);

            double values[] = disCoordinateFrame.getCoordinate3DValues(disCoord);
            System.out.println("DIS x:" + values[0] + " y:" + values[1] + " z:" + values[2] );

            disCoordinates.setX(values[0]);
            disCoordinates.setY(values[1]);
            disCoordinates.setZ(values[2]);
        }
        catch(Exception e)
        {
            //Should throw exception here
            System.out.println("can't change to DIS coord " + e);
            return null;
        }

        return disCoordinates;
    }

    /**
     * Given DIS coordinates, convert to the local euclidian plane coordinates.
     * 
     * @param x
     * @param y
     * @param z
     */
    public Vector3Double localCoordFromDis(double x, double y, double z)
    {
        Vector3Double local = new Vector3Double();
        
        try
        {
            Coord3D localCoordinates = localEuclidianFrame.createCoordinate3D(0.0, 0.0, 0.0);
            Coord3D disCoord = disCoordinateFrame.createCoordinate3D(x, y, z);

            SRM_Coordinate_Valid_Region_Code region = localEuclidianFrame.changeCoordinateSRF(disCoord, localCoordinates);

            //System.out.println("Region:" + region);

            double values[] = localEuclidianFrame.getCoordinate3DValues(localCoordinates);
            //System.out.println("-->Local x:" + values[0] + " y:" + values[1] + " z:" + values[2] );
            local.setX(values[0]);
            local.setY(values[1]);
            local.setZ(values[2]);
        }
        catch(Exception e)
        {
            System.out.println("can't change from DIS coord to Local" + e);
            return null;
        }

        return local;
    }

    public static void main(String args[])
    {

        // x-axis intercept: prime meridian, equator, and zero altitude.
        LocalFlat primeMeridian = new LocalFlat(0.0, 0.0, 0.0); 
        primeMeridian.DISCoordFromLocalFlat(0.0, 0.0, 0.0);

        // North pole: z-axis intercept with earth surface
        LocalFlat northPole = new LocalFlat(0.0, 180.0, 0.0); // north pole
        northPole.DISCoordFromLocalFlat(0.0, 0.0, 0.0);

        // y-axis: equator, 90 deg east. x and z should be near-zero
        LocalFlat yAxis = new LocalFlat(90.0, 0.0, 0.0); // y axis
        yAxis.DISCoordFromLocalFlat(0.0, 0.0, 0.0);

        // Move west a bit from the equator/prime meridian
        LocalFlat westALittle = new LocalFlat(0.0, -1.0, 0.0);
        westALittle.DISCoordFromLocalFlat(0.0, 0.0, 0.0);
    }
}
