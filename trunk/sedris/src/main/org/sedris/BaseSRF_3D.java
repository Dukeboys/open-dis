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
@brief Declaration of Base SRF 3D class.
*/

package org.sedris;

import java.util.*;

/** The BaseSRF_3D abstract class is the base class for the 3D SRFs.
@author David Shen
@see BaseSRF, BaseSRF_2D
*/
public abstract class BaseSRF_3D extends BaseSRF
{

    // member data for the geodetic valid region
    protected SRM_Extended_Valid_Region_Params[] _component_valid_region =
                          new SRM_Extended_Valid_Region_Params[3];

    // boolean flag indicating whether the coordinate component associated with
    // this SRF is angular
    protected boolean[] _component_is_angular = { false, false, false };

    /** Creates a 3D coordinate object.
        @return a 3D coordinate object
	@Note The initial coordinate value is defaulted to [ Double.NaN, Double.NaN, Double.NaN ].
    */
    public abstract Coord3D createCoordinate3D( );

    /** Creates a 3D coordinate object.
        @param coord_comp1 in: the values of the first component of the 3D coordinate
        @param coord_comp2 in: the values of the second component of the 3D coordinate
        @param coord_comp3 in: the values of the third component of the 3D coordinate
        @return a 3D coordinate object
    */
    public abstract Coord3D createCoordinate3D( double coord_comp1,
						double coord_comp2,
						double coord_comp3 );

    /** Retrieves the 3D coordinate component values.
        @note The input coordinate must have been created using this SRF.
        @param coord in: a 3D coordinate
        @return an array of size 3 containing the component values for the 3D coordinate
    */
    public double[] getCoordinate3DValues( Coord3D coord ) throws SrmException
    {
	if ( coord == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getCoordinate3DValues: null reference input parameter") );
	if ( coord.getSRF() != this )
	throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				new String("getCoordinate3DValues: Coordinate associated with different SRF") );

	return coord.getValues();
    }
	

    /** Changes a coordinate's values to this SRF.
        @param src in: the source 3D coordinate in some other 3D SRF
	@param tgt in out: the target coordinate in this 3D SRF
        @return the Valid Region of the target coordinate
    */
    public SRM_Coordinate_Valid_Region_Code changeCoordinate3DSRF ( Coord3D src, 
								    Coord3D tgt ) throws SrmException
    {
	SRM_Coordinate_Valid_Region_Code retValid;
	double[] tgtValues = new double[3];

	if ( src == null || tgt == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeCoordinate3DSRF: null reference input parameters") );

	retValid = OpManager.instance().computeAsArray
	    ( src.getSRF(), this, src.getValues(), tgtValues, null );
 
	tgt.setValues( tgtValues );
	
	return retValid;
    }


    /** Changes an array of 3D coordinate to this SRF.
	@note all the arrays must be of same length.
	@note all the coordinate in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus one to
              indicate that the operation successfully converted all the ccordinates
              in the source array.  Otherwise, the return value is the index of the offending coordinate
              in the source array.
        @param src in: the array of source 3D coordinate in some other 3D SRF
	@param tgt out: the array of target coordinate in this 3D SRF
	@param region out: the array of valid region assoicated with the array of target coordinates
        @return the index of the offending coordinate in the source array when an error condition occurs.  Otherwise,
                it is the size of the source array plus one.
    */
    public int changeCoordinate3DArraySRF ( Coord3D[] src, 
					    Coord3D[] tgt,
					    SRM_Coordinate_Valid_Region_Code[] region ) throws SrmException
    {
	boolean has_no_failure = true;
	double[] tgtValues = new double[3];

	if ( src.length != tgt.length || src.length != region.length )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeCoordinate3DArraySRF: inconsistent array size") );

	int retIndex = src.length+1;

	for ( int i=0; i<src.length && has_no_failure; i++ )
	    {
		try {
		    if ( src[i] == null || tgt[i] == null ) {
			throw new SrmException( SrmException._INVALID_INPUT, 
						new String("changeCoordinate3DArraySRF: null array element") );
		    }

		    region[i] = OpManager.instance().computeAsArray
			( src[i].getSRF(), this, src[i].getValues(), tgtValues, null ); 

		    tgt[i].setValues( tgtValues );
		} 
		catch ( SrmException ex ) {
		    retIndex = i;
		    has_no_failure = false;
		}
	    }

	return retIndex;
    }



    /** Set the Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
              method or the setExtendedValidRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @note Upper or Lower value is ignored if the interval is a
              semi-interval or unbounded.
        @note The Lower value must be strictly less than the Upper value.
        @param component in: the coordinate component (1, 2, or 3)
        @param interval in: the type of interval
        @param lower in: the lower value of the interval
        @param upper in: the upper value of the interval
    */
    public void setValidRegion( int component, 
			        SRM_Interval_Type type,
			        double lower,
			        double upper ) throws SrmException
    {
	if ( component < 1 || component > 3 )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				   "setValidRegion: component out of range [ 1, 3 ]" );

	int int_interval = type.toInt();

	SRM_SRFT_Code srft_code = getSRFTemplateCode();

	if ( srft_code == SRM_SRFT_Code.SRFT_CELESTIODETIC ||
	     srft_code == SRM_SRFT_Code.SRFT_PLANETODETIC )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
						    "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLongitude( lower ) && Const.isWellFormedLongitude( upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
							"setValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
							"setValidRegion: component 1 (longitude) lower and upper bounds are the same");

			_component_is_angular[component] = true;
		    }
		else if (  component == 2 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 2 (latitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLatitude( lower ) && Const.isWellFormedLatitude( upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 2 (latitude) lower and upper bounds are the same");
			_component_is_angular[component] = true;
		    }
		else //component == 3
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 3 (height) lower bound greater than upper bound");
			// 		  else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= -B || lower <= -B) )
			// 		      throw new SrmException( SrmException._INVALID_INPUT, 
			// 				       "setValidRegion: component 3 (height) bounds lower than minor semi-axes length");
		    }
	    }
		// azimuth, elevation, radius
	else if ( srft_code == SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_AZIMUTHAL_SPHERICAL )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedAzimuth( lower ) && Const.isWellFormedAzimuth( upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 1 (longitude) lower and upper bounds are the same");
			_component_is_angular[component] = true;
		    }
		else if (  component == 2 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 2 (latitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLatitude( lower ) && Const.isWellFormedLatitude( upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 2 (latitude) lower and upper bounds are the same");
			_component_is_angular[component] = true;
		    }
		else //component == 3
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 3 (height) lower bound greater than upper bound");
			else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= 0.0 || lower <= 0.0) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 3 (height) bounds lower than minor semi-axes length");
		    }
	    }
		// cylindrical angle, radius, h
	else if ( srft_code == SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLongitude( lower ) && Const.isWellFormedLongitude( upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 1 (longitude) lower and upper bounds are the same");
			_component_is_angular[component] = true;
		    }
		else if ( component == 2 )
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 2 (height) lower bound greater than upper bound");
			else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= 0.0 || lower <= 0.0) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 2 (height) bounds lower than minor semi-axes length");
		    }
		// component 3 has no boundaries.
	    }
		// spherical: lon, lat, h
	else if ( srft_code == SRM_SRFT_Code.SRFT_CELESTIOMAGNETIC ||
		  srft_code == SRM_SRFT_Code.SRFT_SOLAR_ECLIPTIC ||
		  srft_code == SRM_SRFT_Code.SRFT_SOLAR_EQUATORIAL ||
		  srft_code == SRM_SRFT_Code.SRFT_HELIOSPHERIC_ARIES_ECLIPTIC ||
		  srft_code == SRM_SRFT_Code.SRFT_HELIOSPHERIC_EARTH_ECLIPTIC ||
		  srft_code == SRM_SRFT_Code.SRFT_HELIOSPHERIC_EARTH_EQUATORIAL )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLongitude( lower ) && Const.isWellFormedLongitude( upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 1 (longitude) lower and upper bounds are the same");
			_component_is_angular[component] = true;
		    }
		else if (  component == 2 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 2 (latitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLatitude( lower ) && Const.isWellFormedLatitude( upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setValidRegion: component 2 (latitude) lower and upper bounds are the same");
			_component_is_angular[component] = true;
		    }
		else //component == 3
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 3 (height) lower bound greater than upper bound");
			else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= 0.0 || lower <= 0.0) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setValidRegion: component 3 (height) bounds lower than minor semi-axes length");
		    }
	    }
	    else
		if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
		    throw new SrmException( SrmException._INVALID_INPUT, "setValidRegion: int_interval lower bound greater than upper bound");

	// allocate array needed if needed
	if ( _component_valid_region[component-1] == null )
	    _component_valid_region[component-1] = new SRM_Extended_Valid_Region_Params();

	_component_valid_region[component-1].type = type;
	_component_valid_region[component-1].lower = lower;
	_component_valid_region[component-1].upper = upper;
    }

    /** Set the Extended Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
              method or the setValidRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @note Upper or Lower value is ignored if the interval is a
              semi-interval or unbounded.
        @note The Lower value must be strictly less than the Upper value.
        @note The Extended_Lower value must be strictly greater than the Lower value and
	      the Extended_Upper value must be strictly smaller than the Lower value.
        @param component in: the coordinate component (1, 2, or 3)
        @param interval in: the type of interval
        @param extended_lower in: the extended lower value of the interval
        @param lower in: the lower value of the interval
        @param upper in: the upper value of the interval
        @param extended_upper in: the extended_upper value of the interval
    */
    public void setExtendedValidRegion( int component, 
					SRM_Interval_Type type,
					double extended_lower,
					double lower,
					double upper,
					double extended_upper ) throws SrmException
    {
	if ( component < 1 || component > 3 )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				   "setExtendedValidRegion: component out of range [ 1, 3 ]" );

	int int_interval = type.toInt();

	SRM_SRFT_Code srft_code = getSRFTemplateCode();

	if ( srft_code == SRM_SRFT_Code.SRFT_CELESTIODETIC ||
	     srft_code == SRM_SRFT_Code.SRFT_PLANETODETIC )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI)
			    if ( !(Const.isWellFormedLongitude( lower ) && Const.isWellFormedLongitude( upper ) &&
				   Const.isWellFormedLongitude( extended_lower ) && Const.isWellFormedLongitude( extended_upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
			    else if ( lower < upper  && (extended_lower > lower || extended_upper < upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
			    else if ( lower > upper && ( extended_lower < lower || extended_upper > upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");

			_component_is_angular[component] = true;
		    }
		else if (  component == 2 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 2 (latitude) a cannot be semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLatitude( lower ) && Const.isWellFormedLatitude( upper ) &&
				   Const.isWellFormedLatitude( extended_lower ) && Const.isWellFormedLatitude( extended_upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
			    else if ( lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) lower and upper bounds are the same");
			    else if ( lower < upper && (extended_lower > lower || extended_upper < upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
			    else if ( lower > upper && ( extended_lower < lower || extended_upper > upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");

			_component_is_angular[component] = true;
		    }
		else //component == 3
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 3 (height) lower bound greater than upper bound");
			// 		  else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= -B || lower <= -B) )
			// 		      throw new SrmException( SrmException._INVALID_INPUT, 
			// 				       "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
			// 	  else if ( int_interval < SRM_Interval_Type._CLOSED &&
			// 		    ( extended_lower <= -B || extended_lower > lower || extended_upper < upper) )
			// 	    throw new SrmException( SrmException._INVALID_INPUT, 
			// 			     "setExtendedValidRegion: component 3 (height) extended bounds falls within valid region");
		    }
	    }
		// azimuth, elevation, radius
	else if ( srft_code == SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_AZIMUTHAL_SPHERICAL )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedAzimuth( lower ) && Const.isWellFormedAzimuth( upper ) &&
				   Const.isWellFormedAzimuth( extended_lower ) && Const.isWellFormedAzimuth( extended_upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
			    else if ( lower < upper  && (extended_lower > lower || extended_upper < upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
			    else if ( lower > upper && ( extended_lower < lower || extended_upper > upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");

			_component_is_angular[component] = true;
		    }
		else if (  component == 2 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 2 (latitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLatitude( lower ) && Const.isWellFormedLatitude( upper ) &&
				   Const.isWellFormedLatitude( extended_lower ) && Const.isWellFormedLatitude( extended_upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) lower and upper bounds are the same");
			    else if ( lower < upper && (extended_lower > lower || extended_upper < upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
			    else if ( lower > upper && ( extended_lower < lower || extended_upper > upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");

			_component_is_angular[component] = true;
		    }
		else //component == 3
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 3 (height) lower bound greater than upper bound");
			else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= 0.0 || lower <= 0.0) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
			else if ( int_interval < SRM_Interval_Type._CLOSED &&
				  ( extended_lower <= 0.0 || extended_lower > lower || extended_upper < upper) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 3 (height) extended bounds falls within valid region");
		    }
	    }
		// cylindrical angle, radius, h
	else if ( srft_code == SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedCylindricalAngle( lower ) && Const.isWellFormedCylindricalAngle( upper ) &&
				   Const.isWellFormedCylindricalAngle( extended_lower ) && Const.isWellFormedCylindricalAngle( extended_upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
			    else if ( lower < upper  && (extended_lower > lower || extended_upper < upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
			    else if ( lower > upper && ( extended_lower < lower || extended_upper > upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");

			_component_is_angular[component] = true;
		    }
		else if ( component == 2 )
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 2 (height) lower bound greater than upper bound");
			else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= 0.0 || lower <= 0.0) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 2 (height) bounds lower than minor semi-axes length");
			else if ( int_interval < SRM_Interval_Type._CLOSED &&
				  ( extended_lower <= 0.0 || extended_lower > lower || extended_upper < upper) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 2 (height) extended bounds falls within valid region");
		    }
		// component 3 has no boundaries.
	    }
		// spherical: lon, lat, h
	else if ( srft_code == SRM_SRFT_Code.SRFT_CELESTIOMAGNETIC ||
		  srft_code == SRM_SRFT_Code.SRFT_SOLAR_ECLIPTIC ||
		  srft_code == SRM_SRFT_Code.SRFT_SOLAR_EQUATORIAL ||
		  srft_code == SRM_SRFT_Code.SRFT_HELIOSPHERIC_ARIES_ECLIPTIC ||
		  srft_code == SRM_SRFT_Code.SRFT_HELIOSPHERIC_EARTH_ECLIPTIC ||
		  srft_code == SRM_SRFT_Code.SRFT_HELIOSPHERIC_EARTH_EQUATORIAL )
	    {
		if ( component == 1 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 1 (longitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLongitude( lower ) && Const.isWellFormedLongitude( upper ) &&
				   Const.isWellFormedLongitude( extended_lower ) && Const.isWellFormedLongitude( extended_upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) out of range (-PI, PI]");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) lower and upper bounds are the same");
			    else if ( lower < upper  && (extended_lower > lower || extended_upper < upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
			    else if ( lower > upper && ( extended_lower < lower || extended_upper > upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 1 (longitude) extended bounds falls within valid region");
			_component_is_angular[component] = true;
		    }
		else if (  component == 2 )
		    {
			if ( int_interval >= SRM_Interval_Type._GT_SEMI && int_interval <=  SRM_Interval_Type._LE_SEMI  )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 2 (latitude) cannot be a semi-interval region");
			else if ( int_interval < SRM_Interval_Type._GT_SEMI )
			    if ( !(Const.isWellFormedLatitude( lower ) && Const.isWellFormedLatitude( upper ) &&
				   Const.isWellFormedLatitude( extended_lower ) && Const.isWellFormedLatitude( extended_upper )) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) out of range (-PI/2, PI/2)");
			    else if ( int_interval < SRM_Interval_Type._GT_SEMI && lower == upper )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) lower and upper bounds are the same");
			    else if ( lower < upper && (extended_lower > lower || extended_upper < upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
			    else if ( lower > upper && ( extended_lower < lower || extended_upper > upper) )
				throw new SrmException( SrmException._INVALID_INPUT, 
						 "setExtendedValidRegion: component 2 (latitude) extended bounds falls within valid region");
			_component_is_angular[component] = true;
		    }
		else //component == 3
		    {
			if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 3 (height) lower bound greater than upper bound");
			else if ( int_interval <= SRM_Interval_Type._CLOSED && (upper <= 0.0 || lower <= 0.0) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 3 (height) bounds lower than minor semi-axes length");
			else if ( int_interval < SRM_Interval_Type._CLOSED &&
				  ( extended_lower <= 0.0 || extended_lower > lower || extended_upper < upper) )
			    throw new SrmException( SrmException._INVALID_INPUT, 
					     "setExtendedValidRegion: component 3 (height) extended bounds falls within valid region");
		    }
	    }
	    else
		if ( int_interval <= SRM_Interval_Type._CLOSED && upper <= lower )
		    throw new SrmException( SrmException._INVALID_INPUT, "setExtendedValidRegion: interval lower bound greater than upper bound");
	
	// allocate array needed if needed
	if ( _component_valid_region[component-1] == null )
	    _component_valid_region[component-1] = new SRM_Extended_Valid_Region_Params();

	_component_valid_region[component-1].type = type;
	_component_valid_region[component-1].extended_lower = extended_lower;
	_component_valid_region[component-1].lower = lower;
	_component_valid_region[component-1].upper = upper;
	_component_valid_region[component-1].extended_upper = extended_upper;
    }

    /** Get the Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
              method or the setExtendedValidRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @param component in: the coordinate component (1, 2, or 3)
        @return the valid region parameters
    */
    public SRM_Valid_Region_Params getValidRegion( int component ) throws SrmException
    {
      SRM_Valid_Region_Params ret_reg = new SRM_Valid_Region_Params();

      if ( component < 1 || component > 3 )
	throw new SrmException( SrmException._INVALID_INPUT, "getValidRegion: component out of range [ 1, 3 ]");

	ret_reg.type = _component_valid_region[component-1].type;
	ret_reg.lower = _component_valid_region[component-1].lower;
	ret_reg.upper = _component_valid_region[component-1].upper;

      return ret_reg;
    }

    /** Get the Extended Valid Region for this SRF.
        @note Given a coordinate component, the last invocation of this
              method or the setValidRegion method determines
              the valid and extended valid intervals of the coordinate
              component values.
        @param component in: the coordinate component (1, 2, or 3)
        @return the extended valid region parameters
    */
    public SRM_Extended_Valid_Region_Params getExtendedValidRegion( int component ) throws SrmException
    {
      SRM_Extended_Valid_Region_Params ret_reg = new SRM_Extended_Valid_Region_Params();

      if ( component < 1 || component > 3 )
	throw new SrmException( SrmException._INVALID_INPUT, "getExtendedValidRegion: component out of range [ 1, 3 ]");
      
	ret_reg.type = _component_valid_region[component-1].type;
	ret_reg.extended_lower = _component_valid_region[component-1].extended_lower;
	ret_reg.lower = _component_valid_region[component-1].lower;
	ret_reg.upper = _component_valid_region[component-1].upper;
	ret_reg.extended_upper = _component_valid_region[component-1].extended_upper;

      return ret_reg;
    }

    /** Changes a coordinate's values to this SRF using tranformation object.
        @note The tgt coordinate must have been created using this SRF.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range ( -2_PI, 2_PI ).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src in: the source coordinate in some other 3D SRF
	@param hst in: the ORM 3D transformation 
	@param tgt in out: the target coordinate in this 3D SRF
        @return the Valid Region of the target coordinate
    */
    public SRM_Coordinate_Valid_Region_Code changeCoordinate3DSRFObject( Coord3D src, 
									 SRM_ORM_Trans_3D_Params hst, 
									 Coord3D tgt )  throws SrmException
    {
	SRM_Coordinate_Valid_Region_Code retValid;
 	double[] tgtValues = new double[3];

	if ( src == null || tgt == null || hst == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeCoordinate3DSRFObject: null reference input parameters") );
	
	retValid = OpManager.instance().computeAsArray
	    ( src.getSRF(), this, src.getValues(), tgtValues, hst );

	tgt.setValues( tgtValues );
	
	return retValid;
    }


    /** Changes an array of coordinates to this SRF using tranformation object.
        @note The tgt coordinates in the tgt array must have been created using this SRF.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range ( -2_PI, 2_PI ).
        @note The value of delta_s for hst must be stricly greater than -1.0.
	@note all the arrays must be of same length.
	@note all the coordinate in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus one to
              indicate that the operation successfully converted all the ccordinates
              in the source array.  Otherwise, the return value is the index of the offending coordinate
              in the source array.
        @param src in: the array of source coordinates in some other 3D SRF
	@param hst in: the ORM 3D transformation object
	@param tgt out: the array of target coordinates in this 3D SRF
 	@param region out: the array of valid region assoicated with the array of target coordinates
        @return the index of the offending coordinate in the source array when an error condition occurs.  Otherwise,
                it is the size of the source array plus one.
    */
    public int changeCoordinate3DArraySRFObject ( Coord3D[] src, 
						  SRM_ORM_Trans_3D_Params hst,
						  Coord3D[] tgt,
						  SRM_Coordinate_Valid_Region_Code[] region ) throws SrmException
    {
	boolean has_no_failure = true;
	double[] tgtValues = new double[3];

	if ( hst == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeCoordinate3DArraySRFObject: null reference input parameters") );
	
	if ( src.length != tgt.length || src.length != region.length )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeCoordinate3DArraySRFObject: inconsistent array size") );

	int retIndex = src.length+1;

	for ( int i=0; i<src.length && has_no_failure; i++ )
	    {
		try {
		    if ( src[i] == null || tgt[i] == null ) {
			throw new SrmException( SrmException._INVALID_INPUT, 
						new String("changeCoordinate3DArraySRFObject: null array element") );
		    }

		    region[i] = OpManager.instance().computeAsArray
			( src[i].getSRF(), this, src[i].getValues(), tgtValues, hst ); 

		    tgt[i].setValues( tgtValues );
		} 
		catch ( SrmException ex ) {
		    retIndex = i;
		    has_no_failure = false;
		}
	    }

	return retIndex;
    }



    /** Creates a direction object.
        @param ref_coord in: the 3D reference coordinate in this SRF. 
        @param vec[] in: the array of size 3 containing the vector component values.  It can
                         be changed after the direction is created.
        @return a direction object
        @note The input reference coordinate must have been created using this SRF.
	@note The reference coordinate cannot be changed after the direction is instantiated.

        A sample code to instantiate a Direction object is as follows:
	@code

	import SRM.*;
	...
	
        try {

	   // first instantiate a SRF, say CD_3D SRF in WGS 1984
           SRF_Celestiodetic CdSrf = new SRF_Celestiodetic(SRM_ORM_Code.ORM_WGS_1984,
	                                                   SRM_RT_Code.RT_WGS_1984_IDENTITY);

           // then instantiate a 3D CD_3D coordinate as the reference coordinate
           Coord3D_Celestiodetic CdCoord = 
		(Coord3D_Celestiodetic)CdSrf.createCoordinate3D(Math.toRadians(10.0),
								Math.toRadians(20.0),
								100.0);
	
	   // then instantiate the Direction object by invoking the createDirection method
  	   Direction dir = CdSrf.createDirection( CdCoord, { 1.0, 2.0, 3.0 } );

        } catch (SrmException ex)
        ...

        // Note: The input reference coordinate is immutable.
					     
        @endcode    
    */
    public Direction createDirection(  Coord3D ref_coord,
				       double vec[] ) throws SrmException 
    {
	if ( ref_coord == null || vec == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("createDirection: null reference input parameter") );
	if ( ref_coord.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("createDirection: Ref. coordinate associated with different SRF") );
	if ( vec.length != 3 )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("createDirection: Input vector is not of size 3") );

	return new Direction (this, ref_coord, vec);
    }

    /** Creates a direction object with reference location and vector components as Double.NaN.
        @return a direction object
        @note This method is mainly intended for facilitating the creation of Direction objects
              that will be used as the target Direction for the changeDirectionSRF() method.
    */
    public Direction createDirection( ) throws SrmException 
    {
	return new Direction( this,
			      this.createCoordinate3D(),
			      new double[]{ Double.NaN, Double.NaN, Double.NaN } );
    }


    /** Retrieves the direction component values.
        @param direction in: the direction object
        @param ref_coord out: the 3D reference coordinate in this SRF
        @param vec[] out: the 3D reference coordinate in this SRF
        @note The input direction must have been created using this SRF.
        @note The input reference coordinate must have been created using this SRF.
    */
    public void getDirectionValues(  Direction direction,
				     Coord3D ref_coord,
				     double vec[] )  throws SrmException 
    { 
	if ( direction == null || ref_coord == null || vec == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getDirectionValues: null reference input parameter") );

	if ( direction.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("getDirectionValues: Direction associated with different SRF") );

	if ( ref_coord.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("getDirectionValues: Reference Coordinate associated with different SRF") );

	if ( vec.length != 3 )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getDirectionValues: Input vector is not of size 3") );

	double[] tmpDir = direction.getVec();

	ref_coord.setValues( direction.getInternalRefCoord().getValues() );

	vec[0] = tmpDir[0];
	vec[1] = tmpDir[1];
	vec[2] = tmpDir[2];
    }

    /** Changes a direction's reference coordinate and vector to this SRF.
        @param src_dir in: the source direction in some other SRF
        @param tgt_dir out: the target direction in this SRF
    */
    public SRM_Coordinate_Valid_Region_Code changeDirectionSRF( Direction src_dir, 
								Direction tgt_dir ) throws SrmException
    {
	if ( src_dir == null || tgt_dir == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeDirectionSRF: null reference input parameter") );

	if ( tgt_dir.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeDirectionSRF: Target Direction associated with different SRF") );

	SRM_Coordinate_Valid_Region_Code retValidity = SRM_Coordinate_Valid_Region_Code.VALID;
	double[] dir_values_tgt = new double[3];

	retValidity = this.changeCoordinate3DSRF( src_dir.getInternalRefCoord(), tgt_dir.getInternalRefCoord() );
	
	DirectionSupport.changeDirectionVector( (BaseSRF_3D) src_dir.getSRF(),
						src_dir.getInternalRefCoord(),
						src_dir.getVec(),
						this,
						tgt_dir.getInternalRefCoord(),
						dir_values_tgt);
	
	tgt_dir.setVec( dir_values_tgt );

	return retValidity;
    }

    
    /** Changes an array of directions to this SRF.
	@note all the arrays must be of same length.
	@note all the directions in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus one to
              indicate that the operation successfully converted all the directions
              in the source array.  Otherwise, the return value is the index of the offending direction
              in the source array.
        @param src_dir in: the array of source direction in some other 3D SRF
	@param tgt_dir out: the array of target direction in this 3D SRF
	@param region out: the array of valid region associated with the array of target direction
        @return the index of the offending direction in the source array when an error condition occurs.  Otherwise,
                it is the size of the source array plus one.
    */
    public int changeDirectionArraySRF ( Direction[] src_dir, 
					 Direction[] tgt_dir,
					 SRM_Coordinate_Valid_Region_Code[] region ) throws SrmException
    {
	boolean has_no_failure = true;
	double[] dir_values_tgt = new double[3];

	if ( src_dir.length != tgt_dir.length || src_dir.length != region.length )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeDirectionArraySRF: inconsistent array size") );

	int retIndex = src_dir.length+1;

	for ( int i=0; i<src_dir.length && has_no_failure; i++ )
	    {
		try {
		    if ( src_dir[i] == null || tgt_dir[i] == null ) {
			throw new SrmException( SrmException._INVALID_INPUT, 
						new String("changeDirectionArraySRF: null array element") );
		    }

		    region[i] = this.changeCoordinate3DSRF( src_dir[i].getInternalRefCoord(), tgt_dir[i].getInternalRefCoord() );

		    DirectionSupport.changeDirectionVector( (BaseSRF_3D) src_dir[i].getSRF(),
							    src_dir[i].getInternalRefCoord(),
							    src_dir[i].getVec(),
							    this,
							    tgt_dir[i].getInternalRefCoord(),
							    dir_values_tgt );
		    
		    tgt_dir[i].setVec( dir_values_tgt );
		} 
		catch ( SrmException ex ) {
		    retIndex = i;
		    has_no_failure = false;
		}
	    }

	return retIndex;
    }


   /** Changes a direction's values to this SRF using tranformation object.
        @note The tgt direction must have been created using this SRF.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range ( -2_PI, 2_PI ).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src_dir in: the source direction in some other SRF
        @param hst in: the ORM 3D transformation
        @param tgt_dir out: the target direction in this SRF
	@return valid region category for the reference location associated with the target direction
    */
    public SRM_Coordinate_Valid_Region_Code changeDirectionSRFObject( Direction src_dir,
								      SRM_ORM_Trans_3D_Params hst,
								      Direction tgt_dir) throws SrmException
    {
	SRM_Coordinate_Valid_Region_Code retValid = SRM_Coordinate_Valid_Region_Code.DEFINED;

	if ( src_dir == null || tgt_dir == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeDirectionSRF: null reference input parameter") );

	if ( tgt_dir.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeDirectionSRF: Target Direction associated with different SRF") );

	double[] dir_values_tgt = new double[3];

	try {
		retValid = this.changeCoordinate3DSRFObject( src_dir.getInternalRefCoord(), hst, tgt_dir.getInternalRefCoord() );
	} catch ( SrmException ex ) {
	    throw new SrmException( SrmException._OPERATION_UNSUPPORTED, 
			    new String("changeDirectionSRFObject: change reference coodinate SRF not possible") );
	}
	
	DirectionSupport.changeDirectionVector( (BaseSRF_3D) src_dir.getSRF(),
						src_dir.getInternalRefCoord(),
						src_dir.getVec(),
						this,
						tgt_dir.getInternalRefCoord(),
						dir_values_tgt);
	
	tgt_dir.setVec( dir_values_tgt );

 	return retValid;
    }

    /** Changes an array of directions to this SRF using tranformation object.
	@note all the arrays must be of same length.
	@note all the directions in an array must be associated with the same SRF.
        @note the returned integer value will be the length of the array plus one to
              indicate that the operation successfully converted all the directions
              in the source array.  Otherwise, the return value is the index of the offending direction
              in the source array.
        @note The value of omega_1, omega_2 and omega_3 for hst must be within the range ( -2_PI, 2_PI ).
        @note The value of delta_s for hst must be stricly greater than -1.0.
        @param src_dir in: the array of source direction in some other 3D SRF
        @param hst in: the ORM 3D transformation
	@param tgt_dir out: the array of target direction in this 3D SRF
	@param region out: the array of valid region associated with the array of target direction
        @return the index of the offending direction in the source array when an error condition occurs.  Otherwise,
                it is the size of the source array plus one.
    */
    public int changeDirectionArraySRFObject ( Direction[] src_dir, 
					       SRM_ORM_Trans_3D_Params hst,
					       Direction[] tgt_dir,
					       SRM_Coordinate_Valid_Region_Code[] region ) throws SrmException
    {
	boolean has_no_failure = true;
	double[] dir_values_tgt = new double[3];

	if ( src_dir.length != tgt_dir.length || src_dir.length != region.length )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeDirectionArraySRF: inconsistent array size") );

	int retIndex = src_dir.length+1;

	for ( int i=0; i<src_dir.length && has_no_failure; i++ )
	    {
		try {
		    if ( src_dir[i] == null || tgt_dir[i] == null ) {
			throw new SrmException( SrmException._INVALID_INPUT, 
						new String("changeDirectionArraySRF: null array element") );
		    }

		    region[i] = this.changeCoordinate3DSRFObject( src_dir[i].getInternalRefCoord(),
								  hst,
								  tgt_dir[i].getInternalRefCoord() );

		    DirectionSupport.changeDirectionVector( (BaseSRF_3D) src_dir[i].getSRF(),
							    src_dir[i].getInternalRefCoord(),
							    src_dir[i].getVec(),
							    this,
							    tgt_dir[i].getInternalRefCoord(),
							    dir_values_tgt );
		    
		    tgt_dir[i].setVec( dir_values_tgt );
		} 
		catch ( SrmException ex ) {
		    retIndex = i;
		    has_no_failure = false;
		}
	    }

	return retIndex;
    }


    /** Check a direction in this SRF.
        @note The input direction object must have been created using this SRF.
        @param direction in: the direction in this SRF
        @return the coordinate valid region code in the direction's SRF
     */
    public SRM_Coordinate_Valid_Region_Code checkDirection( Direction direction ) throws SrmException
    {
	if ( direction == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("checkDirection: null reference input parameter") );

	if ( direction.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("checkDirection: direction associated with different SRF") );
	
	SRM_Coordinate_Valid_Region_Code retReg = null;

	retReg = this.checkCoordinate( direction.getInternalRefCoord() );

	double [] vec = direction.getVec();

	if ( vec[0]*vec[0] + vec[1]*vec[1] + vec[2]*vec[2] <= Const.EPSILON_SQ )
	    throw new SrmException( SrmException._INVALID_SOURCE_DIRECTION, 
				    new String("checkDirection: Direction vector magnitude ~ 0.0 ") );
	    
	return retReg;
    }

    /** Creates an orientation object.
        @param ref_coord in: the 3D reference coordinate in this SRF
        @param mtx[][] in: the 3x3 matrix containing the three vector component values
        @return an orientation object
        @note The input reference coordinate must have been created using this SRF.

        A sample code to instantiate an Orientation object is as follows:
	@code

	import SRM.*;
	...
	
        try {

	   // first instantiate a SRF, say CD_3D SRF in WGS 1984
           SRF_Celestiodetic CdSrf = new SRF_Celestiodetic(SRM_ORM_Code.ORM_WGS_1984,
	                                                   SRM_RT_Code.RT_WGS_1984_IDENTITY);

           // then Instantiate a 3D CD_3D coordinate as the reference coordinate
           Coord3D_Celestiodetic CdCoord = 
		(Coord3D_Celestiodetic)CdSrf.createCoordinate3D(Math.toRadians(10.0),
								Math.toRadians(20.0),
								100.0);
	   // then allocate a 3x3 matrix
	   double[][] matrix = new double[][]{ {1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0} };
	
	   // then instantiate the Orientation object by invoking the createOrientation method
  	   Orientation ori = CdSrf.createOrientation( CdCoord, matrix );

        } catch (SrmException ex)
        ...

        // Note: The input reference coordinate is immutable.
					     
        @endcode 
    */
    public Orientation createOrientation( Coord3D ref_coord,
					  double mtx[][] ) throws SrmException 
    {
	if ( ref_coord == null || mtx == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("createOrientation: null reference input parameter") );
	if ( ref_coord.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("createOrientation: Ref. coordinate associated with different SRF") );
	if ( mtx.length != 3 && mtx[2].length !=3 )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("createOrientation: Input Orientation matrix is not 3x3") );

	return new Orientation (this, ref_coord, mtx);
    }

    /** Creates an Orientation object with a reference location and three Direction objects as the 3x3
        Orientation matrix.
        @return an Orientation object
        @note The input reference coordinate must have been created using this SRF.
        @note The input Direction objects must have use the same reference location
              as the input reference location.
    */
    public Orientation createOrientation( Coord3D ref_coord,
					  Direction dir1,
					  Direction dir2,
					  Direction dir3 ) throws SrmException 
    {
	if ( ref_coord == null || dir1 == null || dir2 == null || dir3 == null)
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("createOrientation: null reference input parameter") );

	if ( ref_coord.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("createOrientation: Ref. coordinate associated with different SRF") );

	if ( dir1._ref_coord != ref_coord || dir2._ref_coord != ref_coord || dir3._ref_coord != ref_coord )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("createOrientation: Direction reference location mismatch") );

	return new Orientation( this,
				ref_coord,
				new double[][]{ dir1._vec,
			    	                dir2._vec,
				                dir3._vec } );
    }


    /** Creates an Orientation object with a reference location and matrix components as Double.NaN.
        @return an Orientation object
        @note This method is mainly intended for facilitating the creation of Orientation objects
              that will be used as the target Orientation for the changeOrientationSRF() method.
    */
    public Orientation createOrientation( ) throws SrmException 
    {
	return new Orientation( this,
				this.createCoordinate3D(),
				new double[][]{ {Double.NaN, Double.NaN, Double.NaN},
			    	                {Double.NaN, Double.NaN, Double.NaN},
				                {Double.NaN, Double.NaN, Double.NaN} } );
    }


    /** Retrieves the orientation component values.
        @note The input orientation must have been created using this SRF.
        @note The input reference coordinate must have been created using this SRF.
        @param orientation in: the orientaiton object
        @param ref_coord out: the 3D reference coordinate in this SRF
        @param mtx[] out: the 3D reference coordinate in this SRF
    */
    public void getOrientationValues( Orientation orientation,
				      Coord3D ref_coord,
				      double mtx[][] )  throws SrmException 
    {
	if ( orientation == null || ref_coord == null || mtx == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getOrientationValues: null reference input parameter") );

	if ( orientation.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("getOrientationValues: Orientation associated with different SRF") );

	if ( ref_coord.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("getOrientationValues: Reference Coordinate associated with different SRF") );

	if ( mtx.length != 3 && mtx[2].length !=3 )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getOrientationValues: Input Orientation matrix is not 3x3") );

	double[][] tmpMtx = orientation.getMatrix();

	ref_coord.setValues( orientation.getInternalRefCoord().getValues() );

	for (int i=0; i<3; i++)
	    for (int j=0; j<3; j++)
		mtx[i][j] = tmpMtx[i][j];
    }

    /** Check an orientation in this SRF.
        @note The input orientation object must have been created using this SRF.
        @param orientation in: the orientation in this SRF
        @return the coordinate valid region code in the orientation's SRF
    */
    public SRM_Coordinate_Valid_Region_Code checkOrientation( Orientation orientation ) throws SrmException
    {
	if ( orientation == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("checkOrientation: null reference input parameter") );

	if ( orientation.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("checkOrientation: orientation associated with different SRF") );

	SRM_Coordinate_Valid_Region_Code retReg = null;

	retReg = this.checkCoordinate( orientation.getInternalRefCoord() );

	if ( Const.det( orientation.getMatrix(), 3 ) < Const.EPSILON )
	    throw new SrmException( SrmException._INVALID_SOURCE_ORIENTATION, 
				    new String("checkOrientation: orientation matrix not inversible") );

	return retReg;
    }

    /** Changes an orientation's values to this SRF.
        @param src_ori in: the source orientation in some other SRF
        @return the destination orientation in this SRF
    */
    public SRM_Coordinate_Valid_Region_Code
	changeOrientationSRF( Orientation src_ori, Orientation tgt_ori ) throws SrmException
    {
	if ( src_ori == null || tgt_ori == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeOrientationSRF: null reference input parameter") );

	if ( tgt_ori.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("changeOrientationSRF: Target Orientation associated with different SRF") );

	SRM_Coordinate_Valid_Region_Code retValidity = SRM_Coordinate_Valid_Region_Code.VALID;
	double[][] dir_values_tgt = new double[3][3];
	double[][] tempOri;
	double[] tempVec = new double[3];
	double[] tempVecOut = new double[3];

	tempOri = src_ori.getMatrix();
	
	retValidity = this.changeCoordinate3DSRF( src_ori.getInternalRefCoord(), tgt_ori.getInternalRefCoord() );
	
	for (int i=0; i<3; i++) 
	    {
		tempVec[0] = tempOri[i][0];
		tempVec[1] = tempOri[i][1];
		tempVec[2] = tempOri[i][2];
		
		DirectionSupport.changeDirectionVector( (BaseSRF_3D) src_ori.getSRF(),
							src_ori.getInternalRefCoord(),
							tempVec,
							this,
							tgt_ori.getInternalRefCoord(),
							tempVecOut);
		
		dir_values_tgt[i][0] = tempVecOut[0];
		dir_values_tgt[i][1] = tempVecOut[1];
		dir_values_tgt[i][2] = tempVecOut[2];
	    }
	
	if ( Const.det(dir_values_tgt, 3) < Const.EPSILON)
	    throw new SrmException( SrmException._INVALID_TARGET_ORIENTATION, 
				    new String("changeOrientationSRF: Invalid target orientation matrix (det ~ 0.0)") );
	
	tgt_ori.setMatrix( dir_values_tgt );
	
	return retValidity;
    }

    /** Instances a 3D source coordinate and orientation into this SRF.
        @param src_coord in: the source coordinate to be instantiated in this SRF
        @param orientation in: the orientation to be instantiated in this SRF
        @return the coordinates in this SRF
    */
    public Coord3D instanceAbstractSpaceCoordinate( Coord3D src_coord,
						    Orientation orientation) throws SrmException
    {
	throw new SrmException( SrmException._NOT_IMPLEMENTED, 
			    new String("instanceAbstractSpaceCoordinate is unimplemented") );
    }


    /** Returns the euclidean distance between two coordinates.
        @param coord1 in: a coordinate in some SRF
        @param coord2 in: a coordinate in some SRF
        @return the Euclidean distance between the two Coord3D coordinates (in meters).
        @note The input coordinates do not need to be from the same SRF.
        @note This method will make (and cache) internal conversions when the inputs coordinates
              are from SRFs other than SRF_Celestiocentric.
     */
    public static double calculateEuclideanDistance( Coord3D coord1,
						     Coord3D coord2 ) throws SrmException
    {
	double[] tempCcSrcCoord = new double[3];
	double[] tempCcTgtCoord = new double[3];

	double delta_x,delta_y,delta_z;

	/*Check for null reference*/
	if( coord1 == null || coord2 == null)
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("calculateEuclideanDistance: null reference input parameter"));

	/*Test to see if the source and target SRF's are both for the same body*/
	if( OrmDataSet.getElem(coord1.getSRF().get_orm())._reference_orm !=
	    OrmDataSet.getElem(coord2.getSRF().get_orm())._reference_orm )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("calculateEuclideanDistance: coordinates" + 
					       " associated with different reference ORMs"));
	
	// converting source coordinate to celestiocentric SRF
	tempCcSrcCoord = interimConv( coord1, SRM_SRFT_Code.SRFT_CELESTIOCENTRIC );
	
	// 		System.out.println("tempCcSrcCoord=> " + tempCcSrcCoord[0] + ", " 
	// 				   + tempCcSrcCoord[1] + ", " 
	// 				   + tempCcSrcCoord[2]);
	
	// converting target coordinate to celestiocentric SRF
	tempCcTgtCoord = interimConv( coord2, SRM_SRFT_Code.SRFT_CELESTIOCENTRIC );
	
	// 		System.out.println("tempCcTgtCoord=> " + tempCcTgtCoord[0] + ", " 
	// 				   + tempCcTgtCoord[1] + ", " 
	// 				   + tempCcTgtCoord[2]);
	
	delta_x = tempCcSrcCoord[0] - tempCcTgtCoord[0];
	delta_y = tempCcSrcCoord[1] - tempCcTgtCoord[1];
	delta_z = tempCcSrcCoord[2] - tempCcTgtCoord[2];
	
	return Math.sqrt( Const.square(delta_x) +
			  Const.square(delta_y) +
			  Const.square(delta_z) );
    }


    /** Computes the natural SRF Set member code (region) where the 3D coordinate is
        located in the target SRF Set.
        @note The input coordinate must have been created using this SRF.
        @param src_coord in : the source 3D coordinate in an SRF
	@param orm_dst in : the ORM for the destination SRF Set
	@param rt_dst in : the RT for the destination SRF Set
	@param tgt_srfs in : the destination SRF Set Code
        @return the SRF Set Member code for the destination SRF Set
    */
    public SRM_SRFSM_Code getNaturalSRFSetMemberCode( Coord3D src_coord,
					   SRM_ORM_Code orm_dst,
					   SRM_RT_Code rt_dst,
					   SRM_SRFS_Code tgt_srfs) throws SrmException
    {
	if (src_coord == null || orm_dst == null || rt_dst == null || tgt_srfs == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getNaturalSRFSetMemberCode: null reference input parameter") );

	if ( src_coord.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("getNaturalSRFSetMemberCode: Coordinate associated with different SRF") );	

	return getMemberCode( src_coord.getValues(), orm_dst, rt_dst, tgt_srfs );
    }


    /** Returns the natural SRF Set member instance that the 3D coordinate is
        located in the target SRF Set.
        @note The input coordinate must have been created using this SRF.
        @param src_coord in : the source 3D coordinate in an SRF
	@param orm_dst in : the ORM for the destination SRF Set
	@param rt_dst in : the RT for the destination SRF Set
	@param tgt_srfs in : the destination SRF Set Code
        @return the SRF Set Member instance for the destination SRF Set
    */
    public BaseSRF_3D getNaturalSRFSetMember( Coord3D src_coord,
					      SRM_ORM_Code orm_dst,
					      SRM_RT_Code rt_dst,
					      SRM_SRFS_Code tgt_srfs) throws SrmException
    {
	if (src_coord == null || orm_dst == null || rt_dst == null || tgt_srfs == null )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getNaturalSRFSetMemberCode: null reference input parameter") );

	if ( src_coord.getSRF() != this )
	    throw new SrmException( SrmException._INVALID_SOURCE_COORDINATE, 
				    new String("getNaturalSRFSetMemberCode: Coordinate associated with different SRF") );	

	SRM_SRFSM_Code tmpMemberCode;
	
	tmpMemberCode = getMemberCode( src_coord.getValues(), orm_dst, rt_dst, tgt_srfs );
	
	return (BaseSRF_3D)CreateSRF.srfSetMember( tgt_srfs, tmpMemberCode, orm_dst, rt_dst );
    }




    protected SRM_SRFSM_Code getMemberCode( double[] src_coord,
				            SRM_ORM_Code orm_dst,
				            SRM_RT_Code rt_dst,
				            SRM_SRFS_Code tgt_srfs) throws SrmException
    {
	SRM_SRFT_Code myBoundaryTemplateSrf;
	BaseSRF tmpSrf;
	double[] coord_tgt = new double[3];
	SRM_SRFSM_Code retSetMember;

	if ( tgt_srfs == SRM_SRFS_Code.SRFS_UNDEFINED )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("getNaturalSRFSetMemberCode: UNDEFINED SRF Set is not valid for this operation") );


	// instantiate cache for the SRF if not already created
	if ( this._internalSRFs == null)
	    this._internalSRFs = new HashMap();
		
	tmpSrf = (BaseSRF)this._internalSRFs.get("TgtBoundSrfT"+orm_dst+tgt_srfs);
			
	// create an interim boundary SRF using SRF's local cache
	if ( tmpSrf == null ) 
	    {
		myBoundaryTemplateSrf = CoordCheck.getsrfsBoundaryDefTemplate( tgt_srfs );

		tmpSrf = CreateSRF.fromCode( myBoundaryTemplateSrf, 
					     orm_dst,
					     rt_dst );
				
				// cache the created interim SRF
		this._internalSRFs.put("NatRegTgtBoundSrfT"+orm_dst+tgt_srfs, tmpSrf);
	    }

	try {
	    // convert src coord to the interin Celestiodetic (in this case) coord.
	    OpManager.instance().computeAsArray( this, 
						 tmpSrf,
						 src_coord,
						 coord_tgt,
						 null );
	} catch (SrmException ex) {
	    throw new SrmException( SrmException._INVALID_SOURCE_SRF, 
				    new String("No natural set member code for this coordinate") );
	}

	if ( tgt_srfs == SRM_SRFS_Code.SRFS_ALABAMA_SPCS )
	    retSetMember = NaturalSetMember.forALSP( coord_tgt );
	else if ( tgt_srfs == SRM_SRFS_Code.SRFS_LAMBERT_NTF )
	    retSetMember = NaturalSetMember.forLAMBERT_NTF( coord_tgt );
	else if ( tgt_srfs == SRM_SRFS_Code.SRFS_GTRS_GLOBAL_COORDINATE_SYSTEM )
	    retSetMember = NaturalSetMember.forGTRS( coord_tgt );
	else if ( tgt_srfs == SRM_SRFS_Code.SRFS_JAPAN_RECTANGULAR_PLANE_CS )
	    retSetMember = NaturalSetMember.forJPRP( coord_tgt );
	else if ( tgt_srfs == SRM_SRFS_Code.SRFS_UNIVERSAL_POLAR_STEREOGRAPHIC )
	    retSetMember = NaturalSetMember.forUPS( coord_tgt );
	else if ( tgt_srfs == SRM_SRFS_Code.SRFS_UNIVERSAL_TRANSVERSE_MERCATOR )
	    retSetMember = NaturalSetMember.forUTM( coord_tgt );
	else if ( tgt_srfs == SRM_SRFS_Code.SRFS_WISCONSIN_SPCS )
	    retSetMember = NaturalSetMember.forWISP( coord_tgt );
	else 
	    throw new SrmException( SrmException._INACTIONABLE, 
				    new String("getNaturalSRFSetMemberCode: Inactionable error") );
	
	return retSetMember;
    }
}
