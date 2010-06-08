
package edu.nps.moves.spatial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.sedris.*;
import edu.nps.moves.dis.*;

/**
 *
 * @author mcgredo
 */
public class LocalFlatTest {

    public LocalFlatTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test creation of DIS coordinates from a local frame
     */
    @Test
    public void disCoordinatesFromLocal()
    {
         // x-axis intercept: prime meridian, equator, and zero altitude. The
        // DIS coordinates we get should have a Y value of about zero, a Z value
        // of about zero, and an X value of 6 million or so.
        // Z points up through north pole, X out prime meridian at equator, Y
        // a equator & 90 deg east.
        LocalFlat primeMeridian = new LocalFlat(0.0, 0.0, 0.0);
        Vector3Double origin = primeMeridian.DISCoordFromLocalFlat(0.0, 0.0, 0.0);
        assertTrue(origin.getY() < 1.0 && origin.getY() > -1.0);
        assertTrue(origin.getZ() < 1.0 && origin.getZ() > -1.0);
        // 6378137 is the actual true value we're looking for
        assertTrue(origin.getX() < 6378138 && origin.getX() > 6378136);
        //System.out.println("X value:" + origin.getX());


        // North pole: z-axis intercept with earth surface. Z value should be 6356752.314245179,
        // x and y zero (about).
        LocalFlat northPole = new LocalFlat(90.0, 0.0, 0.0); // north pole
        origin = northPole.DISCoordFromLocalFlat(0.0, 0.0, 0.0);

        //System.out.println("Origin:" + origin.getX() + "," + origin.getY() + "," + origin.getZ());

        assertTrue(origin.getY() < 1.0 && origin.getY() > -1.0);
        assertTrue(origin.getZ() < 6356753 && origin.getZ() > 6356751);
        assertTrue(origin.getX() < 1 && origin.getX() > -1);

        // y-axis: equator, 90 deg east.  z should be near-zero,
        // x near zero, y at 6378137.0
        LocalFlat yAxis = new LocalFlat(0.0, 90, 0.0); // lat, lon, alt: y axis for DIS
        origin = yAxis.DISCoordFromLocalFlat(0.0, 0.0, 0.0);
        assertTrue(origin.getY() <6378138 && origin.getY() > 6378136);
        assertTrue(origin.getZ() < 1 && origin.getZ() > -1);
        assertTrue(origin.getX() < 1 && origin.getX() > -1);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}