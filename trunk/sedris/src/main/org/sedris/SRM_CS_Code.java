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
@brief CS ORM code enumeration according to the SRM spec.
*/
public class SRM_CS_Code extends Enum
{
    public static final int _totalEnum = 28;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _CS_UNDEFINED = 0; /// Undefined
    public static final int _CS_EUCLIDEAN_3D = 1; /// Euclidean 3D.
    public static final int _CS_LOCOCENTRIC_EUCLIDEAN_3D = 2; /// Localized Euclidean 3D
    public static final int _CS_SPHERICAL = 3; /// Spherical.
    public static final int _CS_LOCOCENTRIC_SPHERICAL = 4; /// Localized spherical
    public static final int _CS_AZIMUTHAL_SPHERICAL = 5; /// Azimuthal spherical.
    public static final int _CS_LOCOCENTRIC_AZIMUTHAL_SPHERICAL = 6; /// Localized azimuthal spherical.
    public static final int _CS_GEODETIC = 7; /// Geodetic 3D.
    public static final int _CS_PLANETODETIC = 8; /// Planetodetic 3D. Geodetic 3D with longitude in opposite direction.
    public static final int _CS_CYLINDRICAL = 9; /// Cylindrical.
    public static final int _CS_LOCOCENTRIC_CYLINDRICAL = 10; /// Localized cylindrical.
    public static final int _CS_MERCATOR = 11; /// Mercator and augmented Mercator map projection coordinate systems.
    public static final int _CS_OBLIQUE_MERCATOR_SPHERICAL = 12; /// Oblique Mercator and augmented oblique Mercator map projections of a sphere.
    public static final int _CS_TRANSVERSE_MERCATOR = 13; /// Transverse Mercator and augmented transverse Mercator map projections.
    public static final int _CS_LAMBERT_CONFORMAL_CONIC = 14; /// Lambert conformal conic and augmented Lambert conformal conic map projections.
    public static final int _CS_POLAR_STEREOGRAPHIC = 15; /// Polar stereographic and augmented polar stereographic map projections.
    public static final int _CS_EQUIDISTANT_CYLINDRICAL = 16; /// Equidistant cylindrical and augmented equidistant cylindrical map projections.
    public static final int _CS_SURFACE_GEODETIC = 17; /// Surface geodetic.
    public static final int _CS_SURFACE_PLANETODETIC = 18; /// Surface planetodetic. Surface geodetic with longitude in opposite direction.
    public static final int _CS_LOCOCENTRIC_SURFACE_EUCLIDEAN = 19; /// Localization of Euclidean 2D CS into plane surface in 3D position-space.
    public static final int _CS_LOCOCENTRIC_SURFACE_AZIMUTHAL = 20; /// Localization of azimuthal CS into plane surface in 3D position-space.
    public static final int _CS_LOCOCENTRIC_SURFACE_POLAR = 21; /// Localization of polar CS into plane surface in 3D position-space.
    public static final int _CS_EUCLIDEAN_2D = 22; /// Euclidean 2D.
    public static final int _CS_LOCOCENTRIC_EUCLIDEAN_2D = 23; /// Localized Euclidean 2D
    public static final int _CS_AZIMUTHAL = 24; /// Azimuthal coordinate system.
    public static final int _CS_LOCOCENTRIC_AZIMUTHAL = 25; /// Localization of azimuthal CS.
    public static final int _CS_POLAR = 26; /// Polar coordinate system.
    public static final int _CS_LOCOCENTRIC_POLAR = 27; /// Localized polar.
    public static final int _CS_EUCLIDEAN_1D = 28; /// Euclidean 1D.

    public static final SRM_CS_Code CS_UNDEFINED
        = new SRM_CS_Code( _CS_UNDEFINED, "CS_UNDEFINED" );

    public static final SRM_CS_Code CS_EUCLIDEAN_3D
        = new SRM_CS_Code( _CS_EUCLIDEAN_3D, "CS_EUCLIDEAN_3D" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_EUCLIDEAN_3D
        = new SRM_CS_Code( _CS_LOCOCENTRIC_EUCLIDEAN_3D, "CS_LOCOCENTRIC_EUCLIDEAN_3D" );
    public static final SRM_CS_Code CS_SPHERICAL
        = new SRM_CS_Code( _CS_SPHERICAL, "CS_SPHERICAL" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_SPHERICAL
        = new SRM_CS_Code( _CS_LOCOCENTRIC_SPHERICAL, "CS_LOCOCENTRIC_SPHERICAL" );
    public static final SRM_CS_Code CS_AZIMUTHAL_SPHERICAL
        = new SRM_CS_Code( _CS_AZIMUTHAL_SPHERICAL, "CS_AZIMUTHAL_SPHERICAL" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_AZIMUTHAL_SPHERICAL
        = new SRM_CS_Code( _CS_LOCOCENTRIC_AZIMUTHAL_SPHERICAL, "CS_LOCOCENTRIC_AZIMUTHAL_SPHERICAL" );
    public static final SRM_CS_Code CS_GEODETIC
        = new SRM_CS_Code( _CS_GEODETIC, "CS_GEODETIC" );
    public static final SRM_CS_Code CS_PLANETODETIC
        = new SRM_CS_Code( _CS_PLANETODETIC, "CS_PLANETODETIC" );
    public static final SRM_CS_Code CS_CYLINDRICAL
        = new SRM_CS_Code( _CS_CYLINDRICAL, "CS_CYLINDRICAL" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_CYLINDRICAL
        = new SRM_CS_Code( _CS_LOCOCENTRIC_CYLINDRICAL, "CS_LOCOCENTRIC_CYLINDRICAL" );
    public static final SRM_CS_Code CS_MERCATOR
        = new SRM_CS_Code( _CS_MERCATOR, "CS_MERCATOR" );
    public static final SRM_CS_Code CS_OBLIQUE_MERCATOR_SPHERICAL
        = new SRM_CS_Code( _CS_OBLIQUE_MERCATOR_SPHERICAL, "CS_OBLIQUE_MERCATOR_SPHERICAL" );
    public static final SRM_CS_Code CS_TRANSVERSE_MERCATOR
        = new SRM_CS_Code( _CS_TRANSVERSE_MERCATOR, "CS_TRANSVERSE_MERCATOR" );
    public static final SRM_CS_Code CS_LAMBERT_CONFORMAL_CONIC
        = new SRM_CS_Code( _CS_LAMBERT_CONFORMAL_CONIC, "CS_LAMBERT_CONFORMAL_CONIC" );
    public static final SRM_CS_Code CS_POLAR_STEREOGRAPHIC
        = new SRM_CS_Code( _CS_POLAR_STEREOGRAPHIC, "CS_POLAR_STEREOGRAPHIC" );
    public static final SRM_CS_Code CS_EQUIDISTANT_CYLINDRICAL
        = new SRM_CS_Code( _CS_EQUIDISTANT_CYLINDRICAL, "CS_EQUIDISTANT_CYLINDRICAL" );
    public static final SRM_CS_Code CS_SURFACE_GEODETIC
        = new SRM_CS_Code( _CS_SURFACE_GEODETIC, "CS_SURFACE_GEODETIC" );
    public static final SRM_CS_Code CS_SURFACE_PLANETODETIC
        = new SRM_CS_Code( _CS_SURFACE_PLANETODETIC, "CS_SURFACE_PLANETODETIC" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_SURFACE_EUCLIDEAN
        = new SRM_CS_Code( _CS_LOCOCENTRIC_SURFACE_EUCLIDEAN, "CS_LOCOCENTRIC_SURFACE_EUCLIDEAN" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_SURFACE_AZIMUTHAL
        = new SRM_CS_Code( _CS_LOCOCENTRIC_SURFACE_AZIMUTHAL, "CS_LOCOCENTRIC_SURFACE_AZIMUTHAL" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_SURFACE_POLAR
        = new SRM_CS_Code( _CS_LOCOCENTRIC_SURFACE_POLAR, "CS_LOCOCENTRIC_SURFACE_POLAR" );
    public static final SRM_CS_Code CS_EUCLIDEAN_2D
        = new SRM_CS_Code( _CS_EUCLIDEAN_2D, "CS_EUCLIDEAN_2D" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_EUCLIDEAN_2D
        = new SRM_CS_Code( _CS_LOCOCENTRIC_EUCLIDEAN_2D, "CS_LOCOCENTRIC_EUCLIDEAN_2D" );
    public static final SRM_CS_Code CS_AZIMUTHAL
        = new SRM_CS_Code( _CS_AZIMUTHAL, "CS_AZIMUTHAL" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_AZIMUTHAL
        = new SRM_CS_Code( _CS_LOCOCENTRIC_AZIMUTHAL, "CS_LOCOCENTRIC_AZIMUTHAL" );
    public static final SRM_CS_Code CS_POLAR
        = new SRM_CS_Code( _CS_POLAR, "CS_POLAR" );
    public static final SRM_CS_Code CS_LOCOCENTRIC_POLAR
        = new SRM_CS_Code( _CS_LOCOCENTRIC_POLAR, "CS_LOCOCENTRIC_POLAR" );
    public static final SRM_CS_Code CS_EUCLIDEAN_1D
        = new SRM_CS_Code( _CS_EUCLIDEAN_1D, "CS_EUCLIDEAN_1D" );

    private SRM_CS_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_CS_Code from its enumerant value
    public static SRM_CS_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_CS_Code.getEnum: enumerant out of range") );
        else
            return (SRM_CS_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_CS_Code from its string name
    public static SRM_CS_Code getEnum( String name ) throws SrmException
    {
        SRM_CS_Code retCode = (SRM_CS_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_CS_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

