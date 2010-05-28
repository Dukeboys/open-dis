package edu.nps.moves.disutil;

/**
 * Converts into Tait_Bryan_angles of roll, pitch and yaw/heading given the
 * position--latitude, longitude, and the euler angles psi, theta, and phi.
 * 
 *
 * @author loyaj & bhughes
 *
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

    /**
     * Gets a degree pitch for an entity based on euler angles. All angular values passed in must be in radians.
     * @param lat Entity's latitude, IN RADIANS
     * @param lon Entity's longitude, IN RADIANS
     * @param psi Psi angle
     * @param theta Theta angle
     * @return the pitch, in degrees, with 0 being level.A negative values is the entity's
     * nose is pointing downward, positive when the entity's nose is pointing upward.
     */
    public static double getPitchFromEuler(double lat, double lon, double psi, double theta)
    {
        double sinlat = Math.sin(lat);
        double sinlon = Math.sin(lon);
        double coslon = Math.cos(lon);
        double coslat = Math.cos(lat);
        double cosLatCosLon = coslat * coslon;
        double cosLatSinLon = coslat * sinlon;

        double cosTheta = Math.cos(theta);
        double cosPsi = Math.cos(psi);
        double sinPsi = Math.sin(psi);
        double sinTheta = Math.sin(theta);

        return Math.toDegrees(Math.asin(cosLatCosLon*cosTheta*cosPsi + cosLatSinLon*cosTheta*sinPsi - sinlat*sinTheta));
    }

    /**
     * Gets the degree roll for an entity based on euler angles. All angular values passed in must be in radians.
     * @param lat Entity's latitude, IN RADIANS
     * @param lon Entity's longitude, IN RADIANS
     * @param psi Psi angle
     * @param theta Theta angle
     * @param phi Phi angle
     * @return the roll, in degrees, with 0 being level flight.
     */
    public static double getRollFromEuler(double lat, double lon, double psi, double theta, double phi)
    {
        double sinlat = Math.sin(lat);
        double sinlon = Math.sin(lon);
        double coslon = Math.cos(lon);
        double coslat = Math.cos(lat);
        double cosLatCosLon = coslat * coslon;
        double cosLatSinLon = coslat * sinlon;

        double cosTheta = Math.cos(theta);
        double cosPsi   = Math.cos(psi);
        double sinPsi   = Math.sin(psi);
        double sinTheta = Math.sin(theta);
        double sinPhi   = Math.sin(phi);
        double cosPhi   = Math.cos(phi);

        double sinPhiSinTheta = sinPhi * sinTheta;
        double cosPhiSinTheta = cosPhi * sinTheta;

        double b23 = cosLatCosLon*(-cosPhi*sinPsi + sinPhiSinTheta*cosPsi) +
                     cosLatSinLon*( cosPhi*cosPsi + sinPhiSinTheta*sinPsi) +
                     sinlat * (sinPhi * cosTheta);

        double b33 = cosLatCosLon*( sinPhi*sinPsi + cosPhiSinTheta*cosPsi) +
                     cosLatSinLon*(-sinPhi*cosPsi + cosPhiSinTheta*sinPsi) +
                     sinlat * (cosPhi * cosTheta);

        return Math.toDegrees(Math.atan2(-b23, -b33));
    }
}
