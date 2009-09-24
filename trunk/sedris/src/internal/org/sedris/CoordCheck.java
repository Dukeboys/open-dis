// SRM SDK Release 4.1.1 - June 23, 2007

// - SRM spec. 4.1

/*
 *                             NOTICE
 * 
 * This software is provided openly and freely for use in representing and
 * interchanging environmental data & databases.
 * 
 * This software was developed for use by the United States Government with
 * unlimited rights.  The software was developed under contract
 * DASG60-02-D-0006 TO-193 by Science Applications International Corporation.
 * The software is unclassified and is deemed as Distribution A, approved
 * for Public Release.
 * 
 * Use by others is permitted only upon the ACCEPTANCE OF THE TERMS AND
 * CONDITIONS, AS STIPULATED UNDER THE FOLLOWING PROVISIONS:
 * 
 *    1. Recipient may make unlimited copies of this software and give
 *       copies to other persons or entities as long as the copies contain
 *       this NOTICE, and as long as the same copyright notices that
 *       appear on, or in, this software remain.
 * 
 *    2. Trademarks. All trademarks belong to their respective trademark
 *       holders.  Third-Party applications/software/information are
 *       copyrighted by their respective owners.
 * 
 *    3. Recipient agrees to forfeit all intellectual property and
 *       ownership rights for any version created from the modification
 *       or adaptation of this software, including versions created from
 *       the translation and/or reverse engineering of the software design.
 * 
 *    4. Transfer.  Recipient may not sell, rent, lease, or sublicense
 *       this software.  Recipient may, however enable another person
 *       or entity the rights to use this software, provided that this
 *       AGREEMENT and NOTICE is furnished along with the software and
 *       /or software system utilizing this software.
 * 
 *       All revisions, modifications, created by the Recipient, to this
 *       software and/or related technical data shall be forwarded by the 
 *       Recipient to the Government at the following address:
 * 
 *         SMDC
 *         Attention SEDRIS (TO193) TPOC
 *         P.O. Box 1500
 *         Hunstville, AL  35807-3801
 * 
 *         or via electronic mail to:  se-mgmt@sedris.org
 * 
 *    5. No Warranty. This software is being delivered to you AS IS
 *       and there is no warranty, EXPRESS or IMPLIED, as to its use
 *       or performance.
 * 
 *       The RECIPIENT ASSUMES ALL RISKS, KNOWN AND UNKNOWN, OF USING
 *       THIS SOFTWARE.  The DEVELOPER EXPRESSLY DISCLAIMS, and the
 *       RECIPIENT WAIVES, ANY and ALL PERFORMANCE OR RESULTS YOU MAY
 *       OBTAIN BY USING THIS SOFTWARE OR DOCUMENTATION.  THERE IS
 *       NO WARRANTY, EXPRESS OR, IMPLIED, AS TO NON-INFRINGEMENT OF
 *       THIRD PARTY RIGHTS, MERCHANTABILITY, OR FITNESS FOR ANY
 *       PARTICULAR PURPOSE.  IN NO EVENT WILL THE DEVELOPER, THE
 *       UNITED STATES GOVERNMENT OR ANYONE ELSE ASSOCIATED WITH THE
 *       DEVELOPMENT OF THIS SOFTWARE BE HELD LIABLE FOR ANY CONSEQUENTIAL,
 *       INCIDENTAL OR SPECIAL DAMAGES, INCLUDING ANY LOST PROFITS
 *       OR LOST SAVINGS WHATSOEVER.
 */

/*
 * COPYRIGHT 2007, SCIENCE APPLICATIONS INTERNATIONAL CORPORATION.
 *                 ALL RIGHTS RESERVED.
 * 
 */

// SRM_OTHERS_GOES_HERE

/**
@author David Shen
*/

package org.sedris;

abstract class CoordCheck
{
    
    // table of reference template SRFs associated with the SRF (standard)
    private static SRM_SRFT_Code[] srfStdBoundaryDefTemplate = 
    {
	SRM_SRFT_Code.SRFT_UNDEFINED, // UNDEFINED,
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // BRITISH_NATIONAL_GRID = 1;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // DELAWARE_SPCS_1983 = 2;
	SRM_SRFT_Code.SRFT_CELESTIOCENTRIC, // GEOCENTRIC_DATUM_AUSTRALIA_1994 = 3;
	SRM_SRFT_Code.SRFT_CELESTIOCENTRIC, // GEOCENTRIC_WGS_1984 = 4;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // GEODETIC_AUSTRALIA_1984 = 5;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // GEODETIC_EUROPE_1950 = 6;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // GEODETIC_N_AMERICAN_1983 = 7;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // GEODETIC_WGS_1984 = 8;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // IRISH_GRID_1965 = 9;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // IRISH_TRANSVERSE_MERCATOR_1989 = 10;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // LAMBERT_1993 = 11;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // LAMBERT_II_WIDE = 12;
	SRM_SRFT_Code.SRFT_CELESTIOCENTRIC, // MARS_PLANETOCENTRIC_2000 = 13;
	SRM_SRFT_Code.SRFT_CELESTIODETIC, // MARS_PLANETOGRAPHIC_2000 = 14;
	SRM_SRFT_Code.SRFT_CELESTIODETIC // MARYLAND_SPCS_1983 = 15;
    };

    // table of reference template SRFs associated with the SRF sets
    // Notice they all have boundaries defined in CD_3D SRF.
    private static SRM_SRFT_Code[] srfsBoundaryDefTemplate = 
    {
	SRM_SRFT_Code.SRFT_UNDEFINED,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC
    };

    // table of reference template SRFs associated with the SRF templates
    // Notice that only the Projection based SRFs have their boundary SRFs  
    // different from their own SRFs
    private static SRM_SRFT_Code[] srftBoundaryDefTemplate = 
    {
	SRM_SRFT_Code.SRFT_UNDEFINED,
	SRM_SRFT_Code.SRFT_CELESTIOCENTRIC,
	SRM_SRFT_Code.SRFT_LOCAL_SPACE_RECTANGULAR_3D,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_PLANETODETIC,
	SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_EUCLIDEAN,
	SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_AZIMUTHAL_SPHERICAL,
	SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL,
	SRM_SRFT_Code.SRFT_CELESTIOMAGNETIC,
	SRM_SRFT_Code.SRFT_EQUATORIAL_INERTIAL,
	SRM_SRFT_Code.SRFT_SOLAR_ECLIPTIC,
	SRM_SRFT_Code.SRFT_SOLAR_EQUATORIAL,
	SRM_SRFT_Code.SRFT_SOLAR_MAGNETIC_ECLIPTIC,
	SRM_SRFT_Code.SRFT_SOLAR_MAGNETIC_DIPOLE,
	SRM_SRFT_Code.SRFT_HELIOSPHERIC_ARIES_ECLIPTIC,
	SRM_SRFT_Code.SRFT_HELIOSPHERIC_EARTH_ECLIPTIC,
	SRM_SRFT_Code.SRFT_HELIOSPHERIC_EARTH_EQUATORIAL,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_CELESTIODETIC,
	SRM_SRFT_Code.SRFT_LOCAL_SPACE_RECTANGULAR_2D,
	SRM_SRFT_Code.SRFT_LOCAL_SPACE_AZIMUTHAL_2D,
	SRM_SRFT_Code.SRFT_LOCAL_SPACE_POLAR_2D
    };


    protected static SRM_SRFT_Code getsrfsBoundaryDefTemplate( SRM_SRFS_Code srfs_code )
    {
	return srfsBoundaryDefTemplate[ srfs_code.toInt() ];
    }

    protected static SRM_SRFT_Code getsrfBoundaryDefTemplate( BaseSRF srf ) throws SrmException
    {
	SRM_SRFT_Code retCode = SRM_SRFT_Code.SRFT_UNDEFINED;

	// if it is a SRF Set member
	if ( srf.getSRFSetCode() != SRM_SRFS_Code.SRFS_UNDEFINED )
	    {
		retCode = srfsBoundaryDefTemplate[srf.getSRFSetCode().toInt()];
	    }

	// if it is a standard (defined) SRF
	else if ( srf.getSRFCode() != SRM_SRF_Code.SRF_UNDEFINED )
	    {
		retCode = srfStdBoundaryDefTemplate[srf.getSRFCode().toInt()];
	    }

	// it is a SRF template instance
	else if ( srf.getSRFTemplateCode() != SRM_SRFT_Code.SRFT_UNDEFINED )
	    {
		retCode = srftBoundaryDefTemplate[srf.getSRFTemplateCode().toInt()];
	    }

	else 
	   throw new SrmException( SrmException._INVALID_SOURCE_SRF, 
				    new String("Invalid source SRF Code") ); 

	return retCode;
    }

//	this case does not handle the cases where the angular parameter has the
//	lower bound > upper bound.  That is the case where the complement angle
//	needs to be computed, but there are there ranges of valid angles that makes
//	this verification tedious and inefficient.  XXX Fix for Topaz implementation.
	protected static SRM_Coordinate_Valid_Region_Code validcoordCheck( 
				SRM_Extended_Valid_Region_Params region,
			boolean region_is_angular, 
			double v_coord ) throws SrmException
	{
		SRM_Coordinate_Valid_Region_Code ret_reg = null;
		
		if ( region == null || region.type == SRM_Interval_Type.UNBOUNDED )
		{
			ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
		}
		else if ( region.type == SRM_Interval_Type.OPEN )
		{
			if ( region_is_angular && region.lower > region.upper ) // case for the complement circle (l->PI and -PI->h)
			{
				ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
				if ( (v_coord > region.lower && v_coord < Const.PI) ||
						(v_coord > -Const.PI && v_coord < region.upper) )
					ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
				else if ( (v_coord > region.extended_lower && v_coord < Const.PI) ||
						(v_coord > -Const.PI && v_coord < region.extended_upper) )
					ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
			}
			else
			{
				ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
				if ( v_coord > region.lower && v_coord < region.upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
				else if ( v_coord > region.extended_lower && v_coord < region.extended_upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
			}
		}
		else if ( region.type == SRM_Interval_Type.CLOSED )
		{
			if ( region_is_angular )
			{
			}
			else
			{
				ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
				if ( v_coord >= region.lower && v_coord <= region.upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
				else if ( v_coord >= region.extended_lower && v_coord <= region.extended_upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
			}
		}
		else if ( region.type == SRM_Interval_Type.GE_LT || region.type == SRM_Interval_Type.GE_SEMI ||
				region.type == SRM_Interval_Type.LT_SEMI )
		{
			if ( region_is_angular )
			{
			}
			else
			{
				ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
				if ( v_coord >= region.lower && v_coord < region.upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
				else if ( v_coord >= region.extended_lower && v_coord < region.extended_upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
			}
		}
		else if ( region.type == SRM_Interval_Type.GT_LE || region.type == SRM_Interval_Type.GT_SEMI ||
				region.type == SRM_Interval_Type.LE_SEMI )
		{
			if ( region_is_angular )
			{
			}
			else
			{
				ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
				if ( v_coord > region.lower && v_coord <= region.upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
				else if ( v_coord > region.extended_lower && v_coord <= region.extended_upper )
					ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
			}
		}
		
		if ( ret_reg == null )
		throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				new String("Invalid coordinate") );
		else
			return ret_reg;
	}
	
	
	protected static SRM_Coordinate_Valid_Region_Code validcoord2DCheck
	( SRM_Extended_Valid_Region_Params[] region,
			boolean[] region_is_angular,
			double[] v_coord) throws SrmException
	{
		SRM_Coordinate_Valid_Region_Code[] reg = new SRM_Coordinate_Valid_Region_Code[2];
		SRM_Coordinate_Valid_Region_Code ret_reg;
		
		for (int i=0; i<2; i++)
			reg[i] = validcoordCheck( region[i], 
					region_is_angular[i],
					v_coord[i]);
		
		if ( reg[0]==SRM_Coordinate_Valid_Region_Code.VALID && reg[1]==SRM_Coordinate_Valid_Region_Code.VALID )
			ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
		else if ( reg[0]==SRM_Coordinate_Valid_Region_Code.DEFINED || reg[1]==SRM_Coordinate_Valid_Region_Code.DEFINED )
			ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
		else 
			ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
		
		return ret_reg;
	}
	
	
	protected static SRM_Coordinate_Valid_Region_Code validcoord3DCheck
	( SRM_Extended_Valid_Region_Params[] region,
			boolean[] region_is_angular,
			double[] v_coord) throws SrmException
	{
		SRM_Coordinate_Valid_Region_Code[] reg = new SRM_Coordinate_Valid_Region_Code[3];
		SRM_Coordinate_Valid_Region_Code ret_reg;
		
		for (int i=0; i<3; i++)
			reg[i] = validcoordCheck( region[i], 
					region_is_angular[i],
					v_coord[i] );
		
		if ( reg[0]==SRM_Coordinate_Valid_Region_Code.VALID && reg[1]==SRM_Coordinate_Valid_Region_Code.VALID && reg[2]==SRM_Coordinate_Valid_Region_Code.VALID )
			ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
		else if ( reg[0]==SRM_Coordinate_Valid_Region_Code.DEFINED || reg[1]==SRM_Coordinate_Valid_Region_Code.DEFINED || reg[2]==SRM_Coordinate_Valid_Region_Code.DEFINED )
			ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
		else 
			ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
		
		return ret_reg;
	}
	
	protected static SRM_Coordinate_Valid_Region_Code validcoordGDCheck
	( SRM_Extended_Valid_Region_Params[] region,
			boolean[] region_is_angular,
			double[] v_coord) throws SrmException
	{
		SRM_Coordinate_Valid_Region_Code[] reg = new SRM_Coordinate_Valid_Region_Code[2];
		SRM_Coordinate_Valid_Region_Code ret_reg;
		
		for (int i=0; i<2; i++)
			reg[i] = validcoordCheck( region[i], 
					region_is_angular[i],
					v_coord[i] );
		
		if ( reg[0]==SRM_Coordinate_Valid_Region_Code.VALID && reg[1]==SRM_Coordinate_Valid_Region_Code.VALID )
			ret_reg = SRM_Coordinate_Valid_Region_Code.VALID;
		else if ( reg[0]==SRM_Coordinate_Valid_Region_Code.DEFINED || reg[1]==SRM_Coordinate_Valid_Region_Code.DEFINED )
			ret_reg = SRM_Coordinate_Valid_Region_Code.DEFINED;
		else 
			ret_reg = SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
		
		return ret_reg;
	}

    // check for NaN
    protected static SRM_Coordinate_Valid_Region_Code 
	forNaN( double[] coord ) throws SrmException
    {
	// this catches the cases where any of coord is NaN
	if ( Double.isNaN(coord[0]) ||
	     Double.isNaN(coord[1]) ||
	     Double.isNaN(coord[2]) )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("Invalid (not well formed) coordinate"));
	else
	    return SRM_Coordinate_Valid_Region_Code.VALID;
    }

    // forCelestiodetic
    protected static SRM_Coordinate_Valid_Region_Code 
	forCelestiodetic( OrmData ormData, double[] coord ) throws SrmException
    {
	if( Const.isWellFormedLongitude( coord[0] ) && // longitude
	    Const.isWellFormedLatitude( coord[1] ) && // latitude
	    ( coord[2] > -ormData.B ) && // ellipsoidal_height
	    Const.isWellFormedHeight( coord[2]) ) // ellipsoidal_height
	    {
		return SRM_Coordinate_Valid_Region_Code.VALID;
	    }
	else
	   throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("Invalid Celestiodetic coordinate") );
    }


    // forLCC  (using Celestiodetic)
    protected static SRM_Coordinate_Valid_Region_Code
	forLCC_cd( OrmData ormData, double[] coord ) throws SrmException
    {
	return forCelestiodetic( ormData, coord );
    }

    // forMercator  (using Celestiodetic)
    protected static SRM_Coordinate_Valid_Region_Code
	forMercator_cd( OrmData ormData, double[] coord ) throws SrmException
    {
	return forCelestiodetic( ormData, coord );
    }



    // forTransverseMercator
    protected static SRM_Coordinate_Valid_Region_Code
	forTransverseMercator_cd( OrmData ormData, SRF_TM_Params params, double[] coord ) throws SrmException
    {
	/*This ensures the the coordinate that we got is actually a good celestiodetic*/
	forCelestiodetic( ormData, coord );

	if( (Const.delta_lambda_min( coord[0], params.origin_longitude ) <= (4.0 * Const.RADIANS_PER_DEGREE + Const.EPSILON)) &&
	    ( coord[1] <= 84.5 * Const.RADIANS_PER_DEGREE + Const.EPSILON) && 
	    ( coord[1] >= -80.5 * Const.RADIANS_PER_DEGREE + Const.EPSILON) )
	    {
		return SRM_Coordinate_Valid_Region_Code.VALID;
	    }
	else if( (Const.delta_lambda_min( coord[0], params.origin_longitude ) <= (12.0 * Const.RADIANS_PER_DEGREE) + 1.0e-5) &&
		 ( coord[1] <= 89.99 * Const.RADIANS_PER_DEGREE + 1.0e-5) &&
		 ( coord[1] >= -89.99 * Const.RADIANS_PER_DEGREE + 1.0e-5 ) )
	    {
		return SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
	    }

	throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("Invalid coordinate") ); 
    }
	
    
    // forPolarStereographic
    protected static SRM_Coordinate_Valid_Region_Code
	forPolarStereographic_cd( SRF_PS_Params params, double[] coord ) throws SrmException
    {
	// 	geodetic_longitude=coord[0];
	// 	geodetic_latitude=coord[1];
	// 	ellipsoidal_height=coord[2];
  
    	if(params.polar_aspect == SRM_Polar_Aspect.NORTH)
    	{
    		if( coord[1] >= 0.0 && coord[1] < Const.PI_DIV_2 &&
    				coord[0] > -Const.PI && coord[0] <= Const.PI)	  
    		{
    			return  SRM_Coordinate_Valid_Region_Code.VALID;
    		}
    		else
    		{
    			throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") );
    		}
    	}
    	else  // SRM_PLRASP_SOUTH
    	{
    		if( coord[1] > -Const.PI_DIV_2 && coord[1] <= 0.0 &&
    				coord[0] > -Const.PI && coord[0] <= Const.PI )
    		{
    			return  SRM_Coordinate_Valid_Region_Code.VALID;
    		}
    		else
    		{
    			throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") );
    		}       
    	}
    }
    
    
    // forMercator  (using Celestiodetic)
    protected static SRM_Coordinate_Valid_Region_Code
	forEquidistantCylindrical_cd( OrmData ormData, double[] coord ) throws SrmException
    {
    	return forCelestiodetic( ormData, coord );
    }
    
    
    // forSpherical
    protected static SRM_Coordinate_Valid_Region_Code
	forSpherical( double[] coord ) throws SrmException
    {
	//   spherical_longitude=coord[0];
	//   spherical_latitude=coord[1];
	//   radius=coord[2];

	if( Const.isWellFormedLongitude(coord[0]) &&
	    Const.isWellFormedLatitude(coord[1]) &&
	    Const.isWellFormedRadius(coord[2]) )
	    return SRM_Coordinate_Valid_Region_Code.VALID;
	else
	   throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") ); 
    }


    // for LSR_3D
    protected static SRM_Coordinate_Valid_Region_Code
	forLsr3d( double[] coord ) throws SrmException
    {
	//   u=coord[0];
	//   v=coord[1];
	//   w=coord[2];
	
	if( Math.abs(coord[0]) + Math.abs(coord[1]) + Math.abs(coord[2]) > Const.EPSILON )
	    return SRM_Coordinate_Valid_Region_Code.VALID;
	else
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("Invalid LSR 3D coordinate") ); 
    }


    // for LSR_2D
    protected static SRM_Coordinate_Valid_Region_Code
	forLsr2d( double[] coord ) throws SrmException
    {
	//   u=coord[0];
	//   v=coord[1];
	
	if( Math.abs(coord[0]) + Math.abs(coord[1]) > Const.EPSILON )
	    return SRM_Coordinate_Valid_Region_Code.VALID;
	else
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("Invalid LSR 2D coordinate") ); 
    }


    // forAzSpher
    protected static SRM_Coordinate_Valid_Region_Code
	forAzSpherical( double[] coord ) throws SrmException
    {
	//  azimuth =coord[0];
	//  elevation_angle =coord[1];
	//  radius =coord[2];

	if( Const.isWellFormedAzimuth(coord[0]) &&
	    Const.isWellFormedLatitude(coord[1]) &&
	    Const.isWellFormedRadius(coord[2]) )
	    return SRM_Coordinate_Valid_Region_Code.VALID;
	else
	   throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") ); 
    }


    // forCylindrical
    protected static SRM_Coordinate_Valid_Region_Code
	forCylindrical( double[] coord ) throws SrmException
    {
	//   cylindrical_angle_theta=coord[0];
	//   radius_rho=coord[1];
	//   height_zeta=coord[2];

	if( Const.isWellFormedAzimuth(coord[0]) &&
	    Const.isWellFormedRadius(coord[1]) )
	    return SRM_Coordinate_Valid_Region_Code.VALID;
	else
	   throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") ); 
    }

    //
    // For SRF Sets
    //

    // forALSP
    protected static SRM_Coordinate_Valid_Region_Code 
	forALSP_cd( OrmData ormData, SRF_TM_Params params, double[] coord ) throws SrmException
    {
	// this validation is based on TM_AUGMENTED_3D validation
	return forTransverseMercator_cd( ormData, params, coord );
    }

    // forGTRS 
    protected static SRM_Coordinate_Valid_Region_Code
	forGTRS( double[] coord ) throws SrmException
    {
	/*This is the version that is used in conversions where it is not on the path to
	  check the validity
	*/
	return SRM_Coordinate_Valid_Region_Code.DEFINED;
    }


    // forGTRS 
    protected static SRM_Coordinate_Valid_Region_Code
	forGTRS_cd( SRM_SRFSM_Code srfSetMemberCode, double[] coord ) throws SrmException
    {
	/*This uses code inside of the GTRS library to look up the
	  validity of a GCS coordinate.  it takes the cellid and the WGS84 Celestiodetic coordinates
	  of a point
	*/
	double GtrsCellOriginLat = 0.0;

	GtrsDataSet tmpGtrsElem = GtrsDataSet.getElem( srfSetMemberCode.toInt() );
		
	GtrsCellOriginLat = GtrsDataSet.getCellOrigLat( tmpGtrsElem );
		
	if( ( coord[0] >= GtrsDataSet.getCellOrigLonMinExtent( srfSetMemberCode.toInt(), tmpGtrsElem ) ) &&
	    ( coord[0] <= GtrsDataSet.getCellOrigLonMaxExtent( srfSetMemberCode.toInt(), tmpGtrsElem ) ) &&
	    ( coord[1] >= (GtrsCellOriginLat - ( 0.5 * Const.RADIANS_PER_DEGREE ) ) )&&
	    ( coord[1] <= (GtrsCellOriginLat + ( 0.5 * Const.RADIANS_PER_DEGREE ) ) ) )
	    {
		return SRM_Coordinate_Valid_Region_Code.VALID;
	    }
	else
	    {
		return SRM_Coordinate_Valid_Region_Code.DEFINED;
	    }
	
    }
    

    // forUPS
    protected static SRM_Coordinate_Valid_Region_Code
	forUPS_cd( SRF_PS_Params params, double[] coord ) throws SrmException
    {
	/*!\note that this routine receives a transverse mercator SRF but a
	  coordinate that is celestiodetic since validation for mercator is
	  performed in a celestiodetic SRF*/

	// 	geodetic_longitude=coord[0];
	// 	geodetic_latitude=coord[1];
	// 	ellipsoidal_height=coord[2];

	if ( params.polar_aspect == SRM_Polar_Aspect.NORTH)
	    {

		if( coord[1] >= 84.0 * Const.RADIANS_PER_DEGREE)
		    {
			return SRM_Coordinate_Valid_Region_Code.VALID;
		    }
		else if( coord[1] >= 83.5 * Const.RADIANS_PER_DEGREE)	  
		    {
			return SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
		    }
		else
		    {
			throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") );
		    }
	    }
	else  //SRM_Polar_Aspect.SOUTH 
	    {
		if( coord[1] <= -80.0 * Const.RADIANS_PER_DEGREE)
		    {
			return SRM_Coordinate_Valid_Region_Code.VALID;
		    }
		else if( coord[1] <= -79.5 * Const.RADIANS_PER_DEGREE)	  
		    {
			return SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
		    }
		else
		    {
			throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") );
		    }
	    }
    }


    // forUTM
    protected static SRM_Coordinate_Valid_Region_Code
	forUTM_cd( SRF_TM_Params params, SRM_SRFSM_Code srfSetMemberCode, double[] coord ) throws SrmException
    {
	/*!\note that this routine receives a transverse mercator SRF but a
	  coordinate that is celestiodetic since validation for mercator is
	  performed in a celestiodetic SRF*/

	// 	geodetic_longitude=coord[0];
	// 	geodetic_latitude=coord[1];
	// 	ellipsoidal_height=coord[2];

	if( srfSetMemberCode.toInt() <= 60)  // zones 1 thru 60
	    {
		if(
		   (Const.delta_lambda_min( coord[0], params.origin_longitude) <= ( 3.0 * Const.RADIANS_PER_DEGREE))&&
		   ( coord[1] <  84.0 * Const.RADIANS_PER_DEGREE)&&
		   ( coord[1] >= 0.0 * Const.RADIANS_PER_DEGREE)
		   )
		    {
			return SRM_Coordinate_Valid_Region_Code.VALID;
		    }
		else if(
			(Const.delta_lambda_min( coord[0], params.origin_longitude) <= (3.5*Const.RADIANS_PER_DEGREE))&&
			( coord[1] <  84.5 * Const.RADIANS_PER_DEGREE)&&
			( coord[1] >= -0.5 * Const.RADIANS_PER_DEGREE)
			)
		    {
			return SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
		    }
		else if( // added based on Ralph's report "Validity Boundary Analysis for Extended TM" (07/20/05)
			(Const.delta_lambda_min( coord[0], params.origin_longitude) <= (6.0*Const.RADIANS_PER_DEGREE))&&
			( coord[1] <  84.5 * Const.RADIANS_PER_DEGREE)&&
			( coord[1] >= -0.5 * Const.RADIANS_PER_DEGREE)
			)
		    {
			return SRM_Coordinate_Valid_Region_Code.DEFINED;
		    }
		else
		    {
			throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") );
		    }
      
	    }
	else // > 60 and <= 120
	    {
		if(
		   (Const.delta_lambda_min( coord[0], params.origin_longitude) <= (3.0*Const.RADIANS_PER_DEGREE))&&
		   ( coord[1] <    0.0 * Const.RADIANS_PER_DEGREE)&&
		   ( coord[1] >= -80.0 * Const.RADIANS_PER_DEGREE)
		   )
		    {
			return SRM_Coordinate_Valid_Region_Code.VALID;
		    }
		else if(
			(Const.delta_lambda_min( coord[0], params.origin_longitude) <= (3.5*Const.RADIANS_PER_DEGREE))&&
			( coord[1] <    0.5 * Const.RADIANS_PER_DEGREE)&&
			( coord[1] >= -80.5 * Const.RADIANS_PER_DEGREE)
			)
		    {
			return SRM_Coordinate_Valid_Region_Code.EXTENDED_VALID;
		    }
		else if( // added based on Ralph's report "Validity Boundary Analysis for Extended TM" (07/20/05)
			(Const.delta_lambda_min( coord[0], params.origin_longitude) <= (6.0*Const.RADIANS_PER_DEGREE))&&
			( coord[1] <    0.5 * Const.RADIANS_PER_DEGREE)&&
			( coord[1] >= -80.5 * Const.RADIANS_PER_DEGREE)
			)
		    {
			return SRM_Coordinate_Valid_Region_Code.DEFINED;
		    }
		else
		    {
			throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
						new String("Invalid coordinate") );
		    }
	    }
    }

    // forWISP
    protected static SRM_Coordinate_Valid_Region_Code 
	forWISP_cd( OrmData ormData, double[] coord ) throws SrmException
    {
	// this validation is based on LCC_AUGMENTED_3D, which is based on
	// the celectiodetic validation
	return forLCC_cd( ormData, coord );
    }

    // forJapan_cd XXX needs fix
    protected static SRM_Coordinate_Valid_Region_Code 
	forJapan_cd( OrmData ormData, double[] coord ) throws SrmException
    {
	// this validation is based on LCC_AUGMENTED_3D, which is based on
	// the celectiodetic validation
	return forLCC_cd( ormData, coord );
    }
    
    // forLNTF
    protected static SRM_Coordinate_Valid_Region_Code 
	forLNTF_cd( SRM_SRFSM_Code member, OrmData ormData, double[] coord ) throws SrmException
    {
	SRM_Coordinate_Valid_Region_Code retValid = null;
 
	if ( member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTF_ZONE_I ) { // LAMBERT_NTF_ZONE_I
	    if ((coord[0]>=  -5.0*Const.RADIANS_PER_DEGREE)&&
		(coord[0]<=  10.0*Const.RADIANS_PER_DEGREE)&&
		(coord[1]>= -53.5*Const.RADIANS_PER_DEGREE)&&
		(coord[1]<   57.0*Const.RADIANS_PER_DEGREE))
		retValid = SRM_Coordinate_Valid_Region_Code.VALID;
	    else
		throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
					new String("Invalid coordinate") );
	}
	else if (member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTF_ZONE_II ) { // LAMBERT_NTF_ZONE_II
	    if ((coord[0]>=  -5.0*Const.RADIANS_PER_DEGREE)&&
		(coord[0]<=  10.0*Const.RADIANS_PER_DEGREE)&&
		(coord[1]>= -50.5*Const.RADIANS_PER_DEGREE)&&
		(coord[1]<   53.5*Const.RADIANS_PER_DEGREE))
		retValid = SRM_Coordinate_Valid_Region_Code.VALID;
	    else
		throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
					new String("Invalid coordinate") );
	}
	else if (member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTF_ZONE_III ) { // LAMBERT_NTF_ZONE_III
	    if ((coord[0]>=  -5.0*Const.RADIANS_PER_DEGREE)&&
		(coord[0]<=  10.0*Const.RADIANS_PER_DEGREE)&&
		(coord[1]>= -47.0*Const.RADIANS_PER_DEGREE)&&
		(coord[1]<  50.5*Const.RADIANS_PER_DEGREE))
		retValid = SRM_Coordinate_Valid_Region_Code.VALID;
	    else
		throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
					new String("Invalid coordinate") );
	}
	else if (member == SRM_SRFSM_Lambert_NTF_Code.SRFSMLAMNTF_ZONE_IV ) // LAMBERT_NTF_ZONE_IV
	    /*!\valid for the island of Corsica.  No lon/lat for it. Assume valid.
	    */
	    return SRM_Coordinate_Valid_Region_Code.VALID;
	else
	    throw new SrmException( SrmException._INACTIONABLE, 
				    new String("Error in LNTF validation - illegal member=> " + member ) );

	return retValid;
    }

    // forMTMB
    protected static SRM_Coordinate_Valid_Region_Code 
	forMTMB_cd( OrmData ormData, SRF_TM_Params params, double[] coord ) throws SrmException
    {
	// this validation is based on TM_AUGMENTED_3D validation
	return forTransverseMercator_cd( ormData, params, coord );
    }

    // forMTMP
    protected static SRM_Coordinate_Valid_Region_Code 
	forMTMP_cd( OrmData ormData, SRF_TM_Params params, double[] coord ) throws SrmException
    {
	// this validation is based on TM_AUGMENTED_3D validation
	return forTransverseMercator_cd( ormData, params, coord );
    }

    
    // for TM_AUGMENTED_3D native
    protected static SRM_Coordinate_Valid_Region_Code
	forTransverseMercator_native 
	( double m, double bl, double x_threshold, double y_threshold,
	  double[] coord ) throws SrmException
    {
	if( coord[1] > y_threshold )
	    {
		if(( coord[1] > ( m * -Math.abs(coord[0])+bl)) )
		    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
					    new String("Invalid coordinate") );
		else
		    return SRM_Coordinate_Valid_Region_Code.VALID;
	    }
	else if( coord[1] < -y_threshold)
	    {
		if( coord[1] < (-m * -Math.abs(coord[0]) - bl))
		    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
					    new String("Invalid coordinate") );	
		else
		    return SRM_Coordinate_Valid_Region_Code.VALID;
	    }			    
	else 
	    {
		if( Math.abs(coord[0]) > x_threshold)
		    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
					    new String("Invalid coordinate") );
		else
		    return SRM_Coordinate_Valid_Region_Code.VALID;
	    }
    }
    
}
