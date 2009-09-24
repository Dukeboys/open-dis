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
@brief SRFSM_Japan_RPCS
*/
public class SRM_SRFSM_Japan_RPCS_Code extends SRM_SRFSM_Code
{
    public static final int _totalEnum = 19;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _SRFSMJPRPCS_UNDEFINED = 0; /// Undefined
    public static final int _SRFSMJPRPCS_ZONE_I = 1; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_I
    public static final int _SRFSMJPRPCS_ZONE_II = 2; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_II
    public static final int _SRFSMJPRPCS_ZONE_III = 3; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_III
    public static final int _SRFSMJPRPCS_ZONE_IV = 4; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_IV
    public static final int _SRFSMJPRPCS_ZONE_V = 5; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_V
    public static final int _SRFSMJPRPCS_ZONE_VI = 6; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_VI
    public static final int _SRFSMJPRPCS_ZONE_VII = 7; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_VII
    public static final int _SRFSMJPRPCS_ZONE_VIII = 8; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_VIII
    public static final int _SRFSMJPRPCS_ZONE_IX = 9; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_IX
    public static final int _SRFSMJPRPCS_ZONE_X = 10; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_X
    public static final int _SRFSMJPRPCS_ZONE_XI = 11; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XI
    public static final int _SRFSMJPRPCS_ZONE_XII = 12; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XII
    public static final int _SRFSMJPRPCS_ZONE_XIII = 13; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XIII
    public static final int _SRFSMJPRPCS_ZONE_XIV = 14; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XIV
    public static final int _SRFSMJPRPCS_ZONE_XV = 15; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XV
    public static final int _SRFSMJPRPCS_ZONE_XVI = 16; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XVI
    public static final int _SRFSMJPRPCS_ZONE_XVII = 17; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XVII
    public static final int _SRFSMJPRPCS_ZONE_XVIII = 18; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XVIII
    public static final int _SRFSMJPRPCS_ZONE_XIX = 19; /// JAPAN_RECTANGULAR_PLANE_CS_ZONE_XIX

    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_UNDEFINED
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_UNDEFINED, "SRFSMJPRPCS_UNDEFINED" );


    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_I
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_I, "SRFSMJPRPCS_ZONE_I" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_II
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_II, "SRFSMJPRPCS_ZONE_II" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_III
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_III, "SRFSMJPRPCS_ZONE_III" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_IV
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_IV, "SRFSMJPRPCS_ZONE_IV" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_V
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_V, "SRFSMJPRPCS_ZONE_V" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_VI
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_VI, "SRFSMJPRPCS_ZONE_VI" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_VII
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_VII, "SRFSMJPRPCS_ZONE_VII" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_VIII
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_VIII, "SRFSMJPRPCS_ZONE_VIII" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_IX
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_IX, "SRFSMJPRPCS_ZONE_IX" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_X
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_X, "SRFSMJPRPCS_ZONE_X" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XI
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XI, "SRFSMJPRPCS_ZONE_XI" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XII
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XII, "SRFSMJPRPCS_ZONE_XII" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XIII
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XIII, "SRFSMJPRPCS_ZONE_XIII" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XIV
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XIV, "SRFSMJPRPCS_ZONE_XIV" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XV
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XV, "SRFSMJPRPCS_ZONE_XV" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XVI
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XVI, "SRFSMJPRPCS_ZONE_XVI" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XVII
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XVII, "SRFSMJPRPCS_ZONE_XVII" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XVIII
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XVIII, "SRFSMJPRPCS_ZONE_XVIII" );
    public static final SRM_SRFSM_Japan_RPCS_Code SRFSMJPRPCS_ZONE_XIX
        = new SRM_SRFSM_Japan_RPCS_Code( _SRFSMJPRPCS_ZONE_XIX, "SRFSMJPRPCS_ZONE_XIX" );

    private SRM_SRFSM_Japan_RPCS_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_SRFSM_Japan_RPCS_Code from its enumerant value
    public static SRM_SRFSM_Japan_RPCS_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFSM_Japan_RPCS_Code.getEnum: enumerant out of range") );
        else
            return (SRM_SRFSM_Japan_RPCS_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_SRFSM_Japan_RPCS_Code from its string name
    public static SRM_SRFSM_Japan_RPCS_Code getEnum( String name ) throws SrmException
    {
        SRM_SRFSM_Japan_RPCS_Code retCode = (SRM_SRFSM_Japan_RPCS_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_SRFSM_Japan_RPCS_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

