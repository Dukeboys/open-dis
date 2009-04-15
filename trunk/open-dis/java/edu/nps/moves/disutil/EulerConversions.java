package edu.nps.moves.disutil;

/**
 * Converts a given pose--latitude, longitude, and the euler angles psi and theta--
 * into a degree heading<p>
 *
 * @author loyaj
 */

public class EulerConversions
{
    /**
     * Gets a degree heading for an entity based on euler angles. All angular values passed in must be in radians.
     * @param lat Entity's latitude, IN RADIANS
     * @param lon Entity's longitude, IN RADIANS
     * @param psi Psi angle
     * @param theta Theta angle
     * @return the heading, in degrees, with 0 being north, positive angles going clockwise,
     * and negative angles going counterclockwise
     */
    public static double getOrientationFromEuler(double lat, double lon, double psi, double theta)
    {
        double sinlat = Math.sin(lat);
        double sinlon = Math.sin(lon);
        double coslon = Math.cos(lon);
        double coslat = Math.cos(lat);
        double sinsin = sinlat * sinlon;

        double cosTheta = Math.cos(theta);
        double cosPsi = Math.cos(psi);
        double sinPsi = Math.sin(psi);
        double sinTheta = Math.sin(theta);


        double cosThetaCosPsi = cosTheta * cosPsi;
        double cosThetaSinPsi = cosTheta * sinPsi;
        double sincos = sinlat * coslon;

        double b11 = -sinlon * cosThetaCosPsi + coslon * cosThetaSinPsi;
        double b12 = -sincos * cosThetaCosPsi - sinsin * cosThetaSinPsi - coslat * sinTheta;

        return Math.toDegrees(Math.atan2(b11, b12));//range is -pi to pi
    }
}