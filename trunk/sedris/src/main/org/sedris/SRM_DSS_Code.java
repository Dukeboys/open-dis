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
@brief Declaration of SRM Designated spatial surface enumeration class
*/
public class SRM_DSS_Code extends Enum
{
    public static final int _totalEnum = 9;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _DSS_UNDEFINED = 0; /// Undefined
    public static final int _DSS_EGM96_GEOID = 1; /// WGS 84 EGM 96 geoid
    public static final int _DSS_IGLD_1955 = 2; /// International Great Lakes datum (IGLD) 1955
    public static final int _DSS_IGLD_1985 = 3; /// International Great Lakes datum (IGLD) 1985
    public static final int _DSS_MSL = 4; /// Mean sea level (MSL)
    public static final int _DSS_NAVD_1988 = 5; /// North American vertical datum (NAVD) 1988
    public static final int _DSS_NGVD_1929 = 6; /// National Geodetic Vertical Datum (NGVD) 1929
    public static final int _DSS_OSGM_2002 = 7; /// Ordnance survey geoid model (OSGM) 2002
    public static final int _DSS_WGS84_ELLIPSOID = 8; /// WGS 84 ellipsoid
    public static final int _DSS_EGM84_GEOID = 9; /// WGS 84 EGM 84 geoid

    public static final SRM_DSS_Code DSS_UNDEFINED
        = new SRM_DSS_Code( _DSS_UNDEFINED, "DSS_UNDEFINED" );

    public static final SRM_DSS_Code DSS_EGM96_GEOID
        = new SRM_DSS_Code( _DSS_EGM96_GEOID, "DSS_EGM96_GEOID" );
    public static final SRM_DSS_Code DSS_IGLD_1955
        = new SRM_DSS_Code( _DSS_IGLD_1955, "DSS_IGLD_1955" );
    public static final SRM_DSS_Code DSS_IGLD_1985
        = new SRM_DSS_Code( _DSS_IGLD_1985, "DSS_IGLD_1985" );
    public static final SRM_DSS_Code DSS_MSL
        = new SRM_DSS_Code( _DSS_MSL, "DSS_MSL" );
    public static final SRM_DSS_Code DSS_NAVD_1988
        = new SRM_DSS_Code( _DSS_NAVD_1988, "DSS_NAVD_1988" );
    public static final SRM_DSS_Code DSS_NGVD_1929
        = new SRM_DSS_Code( _DSS_NGVD_1929, "DSS_NGVD_1929" );
    public static final SRM_DSS_Code DSS_OSGM_2002
        = new SRM_DSS_Code( _DSS_OSGM_2002, "DSS_OSGM_2002" );
    public static final SRM_DSS_Code DSS_WGS84_ELLIPSOID
        = new SRM_DSS_Code( _DSS_WGS84_ELLIPSOID, "DSS_WGS84_ELLIPSOID" );
    public static final SRM_DSS_Code DSS_EGM84_GEOID
        = new SRM_DSS_Code( _DSS_EGM84_GEOID, "DSS_EGM84_GEOID" );

    private SRM_DSS_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_DSS_Code from its enumerant value
    public static SRM_DSS_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_DSS_Code.getEnum: enumerant out of range") );
        else
            return (SRM_DSS_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_DSS_Code from its string name
    public static SRM_DSS_Code getEnum( String name ) throws SrmException
    {
        SRM_DSS_Code retCode = (SRM_DSS_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_DSS_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

