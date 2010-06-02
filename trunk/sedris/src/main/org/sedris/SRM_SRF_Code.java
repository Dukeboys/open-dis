// SRM SDK Release 4.1.3 - December 7, 2009

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
 *         Huntsville, AL  35807-3801
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
 * COPYRIGHT 2009, SCIENCE APPLICATIONS INTERNATIONAL CORPORATION.
 *                 ALL RIGHTS RESERVED.
 * 
 */

// SRM_OTHERS_GOES_HERE

package org.sedris;

import java.util.*;


/**
@author David Shen
@brief Declaration of SRM SRF set enumeration class.
*/
public class SRM_SRF_Code extends Enum
{
    public static final int _totalEnum = 14;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _SRF_UNDEFINED = 0; /// Undefined
    public static final int _SRF_BRITISH_NATIONAL_GRID_AIRY = 1; /// British national grid. A transverse Mercator projection using the AIRY_1830 ellipsoid
    public static final int _SRF_BRITISH_OSGRS80_GRID = 2; /// UK ordnance survey GRS80 grid. A transverse Mercator projection using the GRS_1980 ellipsoid.
    public static final int _SRF_DELAWARE_SPCS_1983 = 3; /// Delaware (US) state plane coordinate system
    public static final int _SRF_GEOCENTRIC_WGS_1984 = 4; /// Geocentric WGS 1984
    public static final int _SRF_GEODETIC_AUSTRALIA_1984 = 5; /// Geodetic Australia 1984
    public static final int _SRF_GEODETIC_WGS_1984 = 6; /// Geodetic WGS 1984
    public static final int _SRF_GEODETIC_N_AMERICAN_1983 = 7; /// Geodetic north american 1983
    public static final int _SRF_IRISH_GRID_1965 = 8; /// Irish grid
    public static final int _SRF_IRISH_TRANSVERSE_MERCATOR_1989 = 9; /// Irish transverse Mercator
    public static final int _SRF_LAMBERT_93 = 10; /// Lambert-93
    public static final int _SRF_LAMBERT_II_WIDE = 11; /// Lambert II etendu (Lambert II wide)
    public static final int _SRF_MARS_PLANETOCENTRIC_2000 = 12; /// Mars planetocentric
    public static final int _SRF_MARS_PLANETOGRAPHIC_2000 = 13; /// Mars planetodetic 
    public static final int _SRF_MARYLAND_SPCS_1983 = 14; /// Maryland (US) state plane coordinate system

    public static final SRM_SRF_Code SRF_UNDEFINED
        = new SRM_SRF_Code( _SRF_UNDEFINED, "SRF_UNDEFINED" );

    public static final SRM_SRF_Code SRF_BRITISH_NATIONAL_GRID_AIRY
        = new SRM_SRF_Code( _SRF_BRITISH_NATIONAL_GRID_AIRY, "SRF_BRITISH_NATIONAL_GRID_AIRY" );
    public static final SRM_SRF_Code SRF_BRITISH_OSGRS80_GRID
        = new SRM_SRF_Code( _SRF_BRITISH_OSGRS80_GRID, "SRF_BRITISH_OSGRS80_GRID" );
    public static final SRM_SRF_Code SRF_DELAWARE_SPCS_1983
        = new SRM_SRF_Code( _SRF_DELAWARE_SPCS_1983, "SRF_DELAWARE_SPCS_1983" );
    public static final SRM_SRF_Code SRF_GEOCENTRIC_WGS_1984
        = new SRM_SRF_Code( _SRF_GEOCENTRIC_WGS_1984, "SRF_GEOCENTRIC_WGS_1984" );
    public static final SRM_SRF_Code SRF_GEODETIC_AUSTRALIA_1984
        = new SRM_SRF_Code( _SRF_GEODETIC_AUSTRALIA_1984, "SRF_GEODETIC_AUSTRALIA_1984" );
    public static final SRM_SRF_Code SRF_GEODETIC_WGS_1984
        = new SRM_SRF_Code( _SRF_GEODETIC_WGS_1984, "SRF_GEODETIC_WGS_1984" );
    public static final SRM_SRF_Code SRF_GEODETIC_N_AMERICAN_1983
        = new SRM_SRF_Code( _SRF_GEODETIC_N_AMERICAN_1983, "SRF_GEODETIC_N_AMERICAN_1983" );
    public static final SRM_SRF_Code SRF_IRISH_GRID_1965
        = new SRM_SRF_Code( _SRF_IRISH_GRID_1965, "SRF_IRISH_GRID_1965" );
    public static final SRM_SRF_Code SRF_IRISH_TRANSVERSE_MERCATOR_1989
        = new SRM_SRF_Code( _SRF_IRISH_TRANSVERSE_MERCATOR_1989, "SRF_IRISH_TRANSVERSE_MERCATOR_1989" );
    public static final SRM_SRF_Code SRF_LAMBERT_93
        = new SRM_SRF_Code( _SRF_LAMBERT_93, "SRF_LAMBERT_93" );
    public static final SRM_SRF_Code SRF_LAMBERT_II_WIDE
        = new SRM_SRF_Code( _SRF_LAMBERT_II_WIDE, "SRF_LAMBERT_II_WIDE" );
    public static final SRM_SRF_Code SRF_MARS_PLANETOCENTRIC_2000
        = new SRM_SRF_Code( _SRF_MARS_PLANETOCENTRIC_2000, "SRF_MARS_PLANETOCENTRIC_2000" );
    public static final SRM_SRF_Code SRF_MARS_PLANETOGRAPHIC_2000
        = new SRM_SRF_Code( _SRF_MARS_PLANETOGRAPHIC_2000, "SRF_MARS_PLANETOGRAPHIC_2000" );
    public static final SRM_SRF_Code SRF_MARYLAND_SPCS_1983
        = new SRM_SRF_Code( _SRF_MARYLAND_SPCS_1983, "SRF_MARYLAND_SPCS_1983" );

    private SRM_SRF_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_SRF_Code from its enumerant value
    public static SRM_SRF_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRF_Code.getEnum: enumerant out of range") );
        else
            return (SRM_SRF_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_SRF_Code from its string name
    public static SRM_SRF_Code getEnum( String name ) throws SrmException
    {
        SRM_SRF_Code retCode = (SRM_SRF_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRF_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

