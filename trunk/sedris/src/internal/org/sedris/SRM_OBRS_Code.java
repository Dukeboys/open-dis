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
@brief SRM OBRS code enumeration according to the SRM spec.
*/
public class SRM_OBRS_Code extends Enum
{
    public static final int _totalEnum = 9;

    private static Vector _enumVec = new Vector( );
    private static HashMap _enumMap = new HashMap( );

    public static final int _OBRSCOD_UNSPECIFIED = 0; /// Unspecified
    public static final int _OBRSCOD_EQUATORIAL_INERTIAL = 1; /// equatorial inertial
    public static final int _OBRSCOD_SOLAR_ECLIPTIC = 2; /// solar ecliptic
    public static final int _OBRSCOD_SOLAR_EQUATORIAL = 3; /// solar equatorial
    public static final int _OBRSCOD_HELIOCENTRIC_ARIES_ECLIPTIC = 4; /// heliocentric Aries ecliptic
    public static final int _OBRSCOD_HELIOCENT_PLANET_ECLIPTIC = 5; /// heliocentric planet ecliptic
    public static final int _OBRSCOD_HELIOCENT_PLANET_EQUATORIAL = 6; /// heliocentric planet equatorial
    public static final int _OBRSCOD_CELESTIOMAGNETIC = 7; /// celestiomagnetic
    public static final int _OBRSCOD_SOLAR_MAGNETIC_ECLIPTIC = 8; /// solar magnetic ecliptic
    public static final int _OBRSCOD_SOLAR_MAGNETIC_DIPOLE = 9; /// solar magnetic dipole

    public static final SRM_OBRS_Code OBRSCOD_UNSPECIFIED
        = new SRM_OBRS_Code( _OBRSCOD_UNSPECIFIED, "OBRSCOD_UNSPECIFIED" );

    public static final SRM_OBRS_Code OBRSCOD_EQUATORIAL_INERTIAL
        = new SRM_OBRS_Code( _OBRSCOD_EQUATORIAL_INERTIAL, "OBRSCOD_EQUATORIAL_INERTIAL" );
    public static final SRM_OBRS_Code OBRSCOD_SOLAR_ECLIPTIC
        = new SRM_OBRS_Code( _OBRSCOD_SOLAR_ECLIPTIC, "OBRSCOD_SOLAR_ECLIPTIC" );
    public static final SRM_OBRS_Code OBRSCOD_SOLAR_EQUATORIAL
        = new SRM_OBRS_Code( _OBRSCOD_SOLAR_EQUATORIAL, "OBRSCOD_SOLAR_EQUATORIAL" );
    public static final SRM_OBRS_Code OBRSCOD_HELIOCENTRIC_ARIES_ECLIPTIC
        = new SRM_OBRS_Code( _OBRSCOD_HELIOCENTRIC_ARIES_ECLIPTIC, "OBRSCOD_HELIOCENTRIC_ARIES_ECLIPTIC" );
    public static final SRM_OBRS_Code OBRSCOD_HELIOCENT_PLANET_ECLIPTIC
        = new SRM_OBRS_Code( _OBRSCOD_HELIOCENT_PLANET_ECLIPTIC, "OBRSCOD_HELIOCENT_PLANET_ECLIPTIC" );
    public static final SRM_OBRS_Code OBRSCOD_HELIOCENT_PLANET_EQUATORIAL
        = new SRM_OBRS_Code( _OBRSCOD_HELIOCENT_PLANET_EQUATORIAL, "OBRSCOD_HELIOCENT_PLANET_EQUATORIAL" );
    public static final SRM_OBRS_Code OBRSCOD_CELESTIOMAGNETIC
        = new SRM_OBRS_Code( _OBRSCOD_CELESTIOMAGNETIC, "OBRSCOD_CELESTIOMAGNETIC" );
    public static final SRM_OBRS_Code OBRSCOD_SOLAR_MAGNETIC_ECLIPTIC
        = new SRM_OBRS_Code( _OBRSCOD_SOLAR_MAGNETIC_ECLIPTIC, "OBRSCOD_SOLAR_MAGNETIC_ECLIPTIC" );
    public static final SRM_OBRS_Code OBRSCOD_SOLAR_MAGNETIC_DIPOLE
        = new SRM_OBRS_Code( _OBRSCOD_SOLAR_MAGNETIC_DIPOLE, "OBRSCOD_SOLAR_MAGNETIC_DIPOLE" );

    private SRM_OBRS_Code(int code, String name)
    {
        super (code, name);
        _enumMap.put( name, this );
        _enumVec.add( code, this );
    }

    /** returns the SRM_OBRS_Code from its enumerant value
     */
    public static SRM_OBRS_Code getEnum( int enum_value ) throws SrmException
    {
        if( enum_value < 1 || enum_value > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_OBRS_Code.getEnum: enumerant out of range") );
        else
            return (SRM_OBRS_Code)(_enumVec.elementAt( enum_value ));
    }

    /** returns the SRM_OBRS_Code from its string name
     */
    public static SRM_OBRS_Code getEnum( String name ) throws SrmException
    {
        SRM_OBRS_Code retCode = (SRM_OBRS_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_OBRS_Code.getEnum: enum. string not found") );

        return retCode;
    }
}
