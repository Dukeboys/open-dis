package edu.nps.moves.spatial;

import org.sedris.*;

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
    SRF_Celestiodetic curvedSurfaceRef;
    SRF_Celestiocentric disCoordinateFrame;
    SRF_LocalTangentSpaceEuclidean localEuclidianPlane;
    Coord3D origin;

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
            localEuclidianPlane =
                    new SRF_LocalTangentSpaceEuclidean(SRM_ORM_Code.ORM_WGS_1984,
                    SRM_RT_Code.RT_WGS_1984_IDENTITY,
                    lonInRadians, latInRadians,  // Origin (note: lon, lat)
                    0.0,            // Azimuth; can rotate axis, but don't.
                    0.0, 0.0,       // False x,y origin (can offset origin to avoid negative coordinates)
                    heightOffset);  // Height offset


            origin = localEuclidianPlane.createCoordinate3D(0.0, 0.0, 0.0);
            


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
    public void DISCoordFromLocalFlat(double x, double y, double z)
    {
        try
        {
            Coord3D localCoordinates = localEuclidianPlane.createCoordinate3D(x, y, z);
            Coord3D disCoord = disCoordinateFrame.createCoordinate3D(0.0, 0.0, 0.0);

            SRM_Coordinate_Valid_Region_Code region = disCoordinateFrame.changeCoordinateSRF(localCoordinates, disCoord);

            System.out.println(region);

            double values[] = disCoordinateFrame.getCoordinate3DValues(disCoord);
            System.out.println("DIS x:" + values[0] + " y:" + values[1] + " z:" + values[2] );
            this.localCoordFromDis(values[0], values[1], values[2]);
            
        }
        catch(Exception e)
        {
            System.out.println("can't change to DIS coord " + e);
        }
    }

    public void localCoordFromDis(double x, double y, double z)
    {
        try
        {
            Coord3D localCoordinates = localEuclidianPlane.createCoordinate3D(0.0, 0.0, 0.0);
            Coord3D disCoord = disCoordinateFrame.createCoordinate3D(x, y, z);

            SRM_Coordinate_Valid_Region_Code region = localEuclidianPlane.changeCoordinateSRF( disCoord, localCoordinates);

            System.out.println(region);

            double values[] = localEuclidianPlane.getCoordinate3DValues(localCoordinates);
            System.out.println("-->Local x:" + values[0] + " y:" + values[1] + " z:" + values[2] );

        }
        catch(Exception e)
        {
            System.out.println("can't change from DIS coord to Local" + e);
        }
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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
