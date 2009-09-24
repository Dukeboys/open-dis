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
@brief Declaration of RD category enumeration class.
*/
public class SRM_RDC_Code extends Enum
{
    public static final int _totalEnum = 8;

    private static Vector _enumVec = new Vector( );

    protected static final int _RDC_UNDEFINED = 0; // Undefined
    public static final int _RDC_POINT = 1; // Point.
    public static final int _RDC_CURVE = 2; // Directed curve.
    public static final int _RDC_AXIS = 3; // Directed straight curve.
    public static final int _RDC_PLANE = 4; // Oriented planar surface.
    public static final int _RDC_ELLIPSOID = 5; // Oriented surface based on an ellipsoid.
    public static final int _RDC_SPHERE = 6; // Oriented surface based on a sphere.
    public static final int _RDC_PROLATE_SPHEROID = 7; // Oriented surface based on an oblate spheroid.
    public static final int _RDC_TRI_AXIAL_SPHEROID = 8; // Oriented surface based on a tri-axial spheroid.

    protected static final SRM_RDC_Code RDC_UNDEFINED
        = new SRM_RDC_Code( _RDC_UNDEFINED, "UNDEFINED" );

    public static final SRM_RDC_Code RDC_POINT
        = new SRM_RDC_Code( _RDC_POINT, "POINT" );
    public static final SRM_RDC_Code RDC_CURVE
        = new SRM_RDC_Code( _RDC_CURVE, "CURVE" );
    public static final SRM_RDC_Code RDC_AXIS
        = new SRM_RDC_Code( _RDC_AXIS, "AXIS" );
    public static final SRM_RDC_Code RDC_PLANE
        = new SRM_RDC_Code( _RDC_PLANE, "PLANE" );
    public static final SRM_RDC_Code RDC_ELLIPSOID
        = new SRM_RDC_Code( _RDC_ELLIPSOID, "ELLIPSOID" );
    public static final SRM_RDC_Code RDC_SPHERE
        = new SRM_RDC_Code( _RDC_SPHERE, "SPHERE" );
    public static final SRM_RDC_Code RDC_PROLATE_SPHEROID
        = new SRM_RDC_Code( _RDC_PROLATE_SPHEROID, "PROLATE_SPHEROID" );
    public static final SRM_RDC_Code RDC_TRI_AXIAL_SPHEROID
        = new SRM_RDC_Code( _RDC_TRI_AXIAL_SPHEROID, "TRI_AXIAL_SPHEROID" );

    private SRM_RDC_Code(int code, String name) {
        super (code, name);
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_RDC_Code from its enumerant value
    public static SRM_RDC_Code getEnum( int item ) throws SrmException
    {
        if( item < 1 || item > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_RDC_Code.getEnum: enumerant out of range") );
        else
            return (SRM_RDC_Code)(_enumVec.elementAt( item ));
    }
}

