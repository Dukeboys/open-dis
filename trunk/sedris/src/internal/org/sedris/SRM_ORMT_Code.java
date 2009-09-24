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
@brief Declaration of ORM template enumeration class.
*/
public class SRM_ORMT_Code extends Enum
{
    public static final int _totalEnum = 9;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _ORMT_UNDEFINED = 0; /// Undefined
    public static final int _ORMT_BI_AXIS_ORIGIN_2D = 1; /// x- and y-axes determined by directed perpendicular lines passing through the origin
    public static final int _ORMT_SPHERE = 2; /// 3D sphere with designated directional axis and xz-plane
    public static final int _ORMT_OBLATE_ELLIPSOID = 3; /// Oblate ellipsoid with designated minor axis direction and xz-plane
    public static final int _ORMT_PROLATE_ELLIPSOID = 4; /// prolate ellipsoid with designated major axis direction and xz-plane
    public static final int _ORMT_TRI_AXIAL_ELLIPSOID = 5; /// 3D tri-axial ellipsoid with designated z-axis direction and xz-plane
    public static final int _ORMT_BI_AXIS_ORIGIN_3D = 6; /// x- and y-axes determined by directed perpendicular lines passing through the origin
    public static final int _ORMT_SPHERE_ORIGIN = 7; /// Sphere with two directed perpendicular lines passing through the centre of the sphere
    public static final int _ORMT_OBLATE_ELLIPSOID_ORIGIN = 8; /// Oblate ellipsoid with designated centre, minor axis direction and xz-plane
    public static final int _ORMT_TRI_PLANE = 9; /// Origin determined by the intersection of three planes

    public static final SRM_ORMT_Code ORMT_UNDEFINED
        = new SRM_ORMT_Code( _ORMT_UNDEFINED, "ORMT_UNDEFINED" );

    public static final SRM_ORMT_Code ORMT_BI_AXIS_ORIGIN_2D
        = new SRM_ORMT_Code( _ORMT_BI_AXIS_ORIGIN_2D, "ORMT_BI_AXIS_ORIGIN_2D" );
    public static final SRM_ORMT_Code ORMT_SPHERE
        = new SRM_ORMT_Code( _ORMT_SPHERE, "ORMT_SPHERE" );
    public static final SRM_ORMT_Code ORMT_OBLATE_ELLIPSOID
        = new SRM_ORMT_Code( _ORMT_OBLATE_ELLIPSOID, "ORMT_OBLATE_ELLIPSOID" );
    public static final SRM_ORMT_Code ORMT_PROLATE_ELLIPSOID
        = new SRM_ORMT_Code( _ORMT_PROLATE_ELLIPSOID, "ORMT_PROLATE_ELLIPSOID" );
    public static final SRM_ORMT_Code ORMT_TRI_AXIAL_ELLIPSOID
        = new SRM_ORMT_Code( _ORMT_TRI_AXIAL_ELLIPSOID, "ORMT_TRI_AXIAL_ELLIPSOID" );
    public static final SRM_ORMT_Code ORMT_BI_AXIS_ORIGIN_3D
        = new SRM_ORMT_Code( _ORMT_BI_AXIS_ORIGIN_3D, "ORMT_BI_AXIS_ORIGIN_3D" );
    public static final SRM_ORMT_Code ORMT_SPHERE_ORIGIN
        = new SRM_ORMT_Code( _ORMT_SPHERE_ORIGIN, "ORMT_SPHERE_ORIGIN" );
    public static final SRM_ORMT_Code ORMT_OBLATE_ELLIPSOID_ORIGIN
        = new SRM_ORMT_Code( _ORMT_OBLATE_ELLIPSOID_ORIGIN, "ORMT_OBLATE_ELLIPSOID_ORIGIN" );
    public static final SRM_ORMT_Code ORMT_TRI_PLANE
        = new SRM_ORMT_Code( _ORMT_TRI_PLANE, "ORMT_TRI_PLANE" );

    private SRM_ORMT_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_ORMT_Code from its enumerant value
    public static SRM_ORMT_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_ORMT_Code.getEnum: enumerant out of range") );
        else
            return (SRM_ORMT_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_ORMT_Code from its string name
    public static SRM_ORMT_Code getEnum( String name ) throws SrmException
    {
        SRM_ORMT_Code retCode = (SRM_ORMT_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_ORMT_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

