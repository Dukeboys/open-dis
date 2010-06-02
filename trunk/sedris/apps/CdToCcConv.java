import SRM.*;

public class CdToCcConv
{ 

    public static void main (String args[]) 
    {	
	System.out.println( "*** Sample program using SRM Java API to convert a 3D coordinate" );
	System.out.println( "*** from a Celestiodetic SRF to a Celestiocentric SRF." );
	
	// Declare reference variables for the CD and CC SRFs
	SRF_Celestiodetic CdSrf = null;
	SRF_Celestiocentric CcSrf = null;

	try {
		
	    // Create a Celestiodetic SRF with WGS 1984
	    CdSrf = new SRF_Celestiodetic(SRM_ORM_Code.ORM_WGS_1984,
	    				  SRM_RT_Code.RT_WGS_1984_IDENTITY);

	    // Create a Celesticentric SRF with WGS 1984
	    CcSrf = new SRF_Celestiocentric(SRM_ORM_Code.ORM_WGS_1984,
					    SRM_RT_Code.RT_WGS_1984_IDENTITY);

	    // Create a 3D Celestiodetic coordinate with 
	    // longitude           => 10.0 degrees (note: this input parameter is converted to radians)
	    // latitude            => 20.0 degrees (note: this input parameter is converted to radians)
	    // ellipsopidal height => 100.0 meters
	    Coord3D_Celestiodetic CdCoord = 
		(Coord3D_Celestiodetic)CdSrf.createCoordinate3D(Math.toRadians(10.0),
								Math.toRadians(20.0),
								100.0);

	    // Instantiate a 3D Celestiocentric coordinate
	    // This is an alternative method for instantiate a 3D coordinate
	    Coord3D_Celestiocentric CcCoord = new Coord3D_Celestiocentric( CcSrf );
	
	    // print out the SRF parameter calues and the coordinate component values
	    System.out.println("CdSrf parameter =>  \n" + CdSrf);
	    System.out.println("CcSrf parameter =>  \n" + CcSrf);
	    System.out.println("CdCoord components (source) => \n" + CdCoord);

	    // convert the 3D Celestiodetic coordinate to 3D Celestiocentric coordinate
	    SRM_Coordinate_Valid_Region_Code valRegion = 
		CcSrf.changeCoordinateSRF( CdCoord, CcCoord );
	
	    // print out the values of the resulting 3D Celestiocentric coordinate
	    System.out.println("CcCoord components (destination) => \n" + CcCoord + " is " + valRegion );

	}
	catch (SrmException ex) {
	    // catch SrmException and print out the error code and text.
	    System.out.println("Exception caught=> " + ex.what() + ", " + ex);
	}
	
    }
}
