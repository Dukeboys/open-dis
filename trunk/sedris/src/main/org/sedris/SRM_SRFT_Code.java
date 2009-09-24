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

package org.sedris;

import java.util.*;


/**
@author David Shen
@brief Declaration of SRM SRF template enumeration class.
*/
public class SRM_SRFT_Code extends Enum
{
    public static final int _totalEnum = 26;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _SRFT_UNDEFINED = 0; /// Undefined
    public static final int _SRFT_CELESTIOCENTRIC = 1; /// Celestiocentric SRFT
    public static final int _SRFT_LOCAL_SPACE_RECTANGULAR_3D = 2; /// Local Space Rectangular 3D SRFT
    public static final int _SRFT_CELESTIODETIC = 3; /// Celestiodetic SRFT
    public static final int _SRFT_PLANETODETIC = 4; /// Planetodetic SRFT
    public static final int _SRFT_LOCAL_TANGENT_SPACE_EUCLIDEAN = 5; /// Local Tangent Space Euclidean SRFT
    public static final int _SRFT_LOCAL_TANGENT_SPACE_AZIMUTHAL_SPHERICAL = 6; /// Local Tangent Space Azimuthal Spherical SRFT
    public static final int _SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL = 7; /// Local Tangent Space Cylindrical SRFT
    public static final int _SRFT_LOCOCENTRIC_EUCLIDEAN_3D = 8; /// Lococentric Euclidean 3D SRFT
    public static final int _SRFT_CELESTIOMAGNETIC = 9; /// Celestiomagnetic SRFT
    public static final int _SRFT_EQUATORIAL_INERTIAL = 10; /// Equatorial Inertial SRFT
    public static final int _SRFT_SOLAR_ECLIPTIC = 11; /// Solar Ecliptic SRFT
    public static final int _SRFT_SOLAR_EQUATORIAL = 12; /// Solar Equatorial SRFT
    public static final int _SRFT_SOLAR_MAGNETIC_ECLIPTIC = 13; /// Solar Magnetic Ecliptic SRFT
    public static final int _SRFT_SOLAR_MAGNETIC_DIPOLE = 14; /// Solar Magnetic Dipole SRFT
    public static final int _SRFT_HELIOSPHERIC_ARIES_ECLIPTIC = 15; /// Heliospheric Aries Ecliptic SRFT
    public static final int _SRFT_HELIOSPHERIC_EARTH_ECLIPTIC = 16; /// Heliospheric Earth Ecliptic SRFT
    public static final int _SRFT_HELIOSPHERIC_EARTH_EQUATORIAL = 17; /// Heliospheric Earth Equatorial SRFT
    public static final int _SRFT_MERCATOR = 18; /// Mercator SRFT
    public static final int _SRFT_OBLIQUE_MERCATOR_SPHERICAL = 19; /// Oblique Mercator SRFT for a sphere ORM
    public static final int _SRFT_TRANSVERSE_MERCATOR = 20; /// Transverse Mercator SRFT
    public static final int _SRFT_LAMBERT_CONFORMAL_CONIC = 21; /// Lambert Conformal Conic SRFT
    public static final int _SRFT_POLAR_STEREOGRAPHIC = 22; /// Polar Stereographic SRFT
    public static final int _SRFT_EQUIDISTANT_CYLINDRICAL = 23; /// Equidistant Cylindrical SRFT
    public static final int _SRFT_LOCAL_SPACE_RECTANGULAR_2D = 24; /// Local Space Rectangular 2D SRFT
    public static final int _SRFT_LOCAL_SPACE_AZIMUTHAL_2D = 25; /// Local Space Azimuthal 2D SRFT
    public static final int _SRFT_LOCAL_SPACE_POLAR_2D = 26; /// Local Space Polar 2D SRFT

    public static final SRM_SRFT_Code SRFT_UNDEFINED
        = new SRM_SRFT_Code( _SRFT_UNDEFINED, "SRFT_UNDEFINED" );

    public static final SRM_SRFT_Code SRFT_CELESTIOCENTRIC
        = new SRM_SRFT_Code( _SRFT_CELESTIOCENTRIC, "SRFT_CELESTIOCENTRIC" );
    public static final SRM_SRFT_Code SRFT_LOCAL_SPACE_RECTANGULAR_3D
        = new SRM_SRFT_Code( _SRFT_LOCAL_SPACE_RECTANGULAR_3D, "SRFT_LOCAL_SPACE_RECTANGULAR_3D" );
    public static final SRM_SRFT_Code SRFT_CELESTIODETIC
        = new SRM_SRFT_Code( _SRFT_CELESTIODETIC, "SRFT_CELESTIODETIC" );
    public static final SRM_SRFT_Code SRFT_PLANETODETIC
        = new SRM_SRFT_Code( _SRFT_PLANETODETIC, "SRFT_PLANETODETIC" );
    public static final SRM_SRFT_Code SRFT_LOCAL_TANGENT_SPACE_EUCLIDEAN
        = new SRM_SRFT_Code( _SRFT_LOCAL_TANGENT_SPACE_EUCLIDEAN, "SRFT_LOCAL_TANGENT_SPACE_EUCLIDEAN" );
    public static final SRM_SRFT_Code SRFT_LOCAL_TANGENT_SPACE_AZIMUTHAL_SPHERICAL
        = new SRM_SRFT_Code( _SRFT_LOCAL_TANGENT_SPACE_AZIMUTHAL_SPHERICAL, "SRFT_LOCAL_TANGENT_SPACE_AZIMUTHAL_SPHERICAL" );
    public static final SRM_SRFT_Code SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL
        = new SRM_SRFT_Code( _SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL, "SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL" );
    public static final SRM_SRFT_Code SRFT_LOCOCENTRIC_EUCLIDEAN_3D
        = new SRM_SRFT_Code( _SRFT_LOCOCENTRIC_EUCLIDEAN_3D, "SRFT_LOCOCENTRIC_EUCLIDEAN_3D" );
    public static final SRM_SRFT_Code SRFT_CELESTIOMAGNETIC
        = new SRM_SRFT_Code( _SRFT_CELESTIOMAGNETIC, "SRFT_CELESTIOMAGNETIC" );
    public static final SRM_SRFT_Code SRFT_EQUATORIAL_INERTIAL
        = new SRM_SRFT_Code( _SRFT_EQUATORIAL_INERTIAL, "SRFT_EQUATORIAL_INERTIAL" );
    public static final SRM_SRFT_Code SRFT_SOLAR_ECLIPTIC
        = new SRM_SRFT_Code( _SRFT_SOLAR_ECLIPTIC, "SRFT_SOLAR_ECLIPTIC" );
    public static final SRM_SRFT_Code SRFT_SOLAR_EQUATORIAL
        = new SRM_SRFT_Code( _SRFT_SOLAR_EQUATORIAL, "SRFT_SOLAR_EQUATORIAL" );
    public static final SRM_SRFT_Code SRFT_SOLAR_MAGNETIC_ECLIPTIC
        = new SRM_SRFT_Code( _SRFT_SOLAR_MAGNETIC_ECLIPTIC, "SRFT_SOLAR_MAGNETIC_ECLIPTIC" );
    public static final SRM_SRFT_Code SRFT_SOLAR_MAGNETIC_DIPOLE
        = new SRM_SRFT_Code( _SRFT_SOLAR_MAGNETIC_DIPOLE, "SRFT_SOLAR_MAGNETIC_DIPOLE" );
    public static final SRM_SRFT_Code SRFT_HELIOSPHERIC_ARIES_ECLIPTIC
        = new SRM_SRFT_Code( _SRFT_HELIOSPHERIC_ARIES_ECLIPTIC, "SRFT_HELIOSPHERIC_ARIES_ECLIPTIC" );
    public static final SRM_SRFT_Code SRFT_HELIOSPHERIC_EARTH_ECLIPTIC
        = new SRM_SRFT_Code( _SRFT_HELIOSPHERIC_EARTH_ECLIPTIC, "SRFT_HELIOSPHERIC_EARTH_ECLIPTIC" );
    public static final SRM_SRFT_Code SRFT_HELIOSPHERIC_EARTH_EQUATORIAL
        = new SRM_SRFT_Code( _SRFT_HELIOSPHERIC_EARTH_EQUATORIAL, "SRFT_HELIOSPHERIC_EARTH_EQUATORIAL" );
    public static final SRM_SRFT_Code SRFT_MERCATOR
        = new SRM_SRFT_Code( _SRFT_MERCATOR, "SRFT_MERCATOR" );
    public static final SRM_SRFT_Code SRFT_OBLIQUE_MERCATOR_SPHERICAL
        = new SRM_SRFT_Code( _SRFT_OBLIQUE_MERCATOR_SPHERICAL, "SRFT_OBLIQUE_MERCATOR_SPHERICAL" );
    public static final SRM_SRFT_Code SRFT_TRANSVERSE_MERCATOR
        = new SRM_SRFT_Code( _SRFT_TRANSVERSE_MERCATOR, "SRFT_TRANSVERSE_MERCATOR" );
    public static final SRM_SRFT_Code SRFT_LAMBERT_CONFORMAL_CONIC
        = new SRM_SRFT_Code( _SRFT_LAMBERT_CONFORMAL_CONIC, "SRFT_LAMBERT_CONFORMAL_CONIC" );
    public static final SRM_SRFT_Code SRFT_POLAR_STEREOGRAPHIC
        = new SRM_SRFT_Code( _SRFT_POLAR_STEREOGRAPHIC, "SRFT_POLAR_STEREOGRAPHIC" );
    public static final SRM_SRFT_Code SRFT_EQUIDISTANT_CYLINDRICAL
        = new SRM_SRFT_Code( _SRFT_EQUIDISTANT_CYLINDRICAL, "SRFT_EQUIDISTANT_CYLINDRICAL" );
    public static final SRM_SRFT_Code SRFT_LOCAL_SPACE_RECTANGULAR_2D
        = new SRM_SRFT_Code( _SRFT_LOCAL_SPACE_RECTANGULAR_2D, "SRFT_LOCAL_SPACE_RECTANGULAR_2D" );
    public static final SRM_SRFT_Code SRFT_LOCAL_SPACE_AZIMUTHAL_2D
        = new SRM_SRFT_Code( _SRFT_LOCAL_SPACE_AZIMUTHAL_2D, "SRFT_LOCAL_SPACE_AZIMUTHAL_2D" );
    public static final SRM_SRFT_Code SRFT_LOCAL_SPACE_POLAR_2D
        = new SRM_SRFT_Code( _SRFT_LOCAL_SPACE_POLAR_2D, "SRFT_LOCAL_SPACE_POLAR_2D" );

    private SRM_SRFT_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_SRFT_Code from its enumerant value
    public static SRM_SRFT_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFT_Code.getEnum: enumerant out of range") );
        else
            return (SRM_SRFT_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_SRFT_Code from its string name
    public static SRM_SRFT_Code getEnum( String name ) throws SrmException
    {
        SRM_SRFT_Code retCode = (SRM_SRFT_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFT_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

