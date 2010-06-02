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
@brief Definition of the Axis Direction enumeration.
*/
public class SRM_Axis_Direction extends Enum
{
    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    protected static final int _UNDEFINED = 0;
    public static final int _POS_PRIMARY_AXIS = 1;
    public static final int _POS_SECONDARY_AXIS = 2;
    public static final int _POS_TERTIARY_AXIS = 3;
    public static final int _NEG_PRIMARY_AXIS = 4;
    public static final int _NEG_SECONDARY_AXIS = 5;
    public static final int _NEG_TERTIARY_AXIS = 6;

    public static final int _totalEnum = 6;

    protected static final SRM_Axis_Direction UNDEFINED
	= new SRM_Axis_Direction(_UNDEFINED, "UNDEFINED");
    public static final SRM_Axis_Direction POS_PRIMARY_AXIS
	= new SRM_Axis_Direction(_POS_PRIMARY_AXIS, "POS_PRIMARY_AXIS");
    public static final SRM_Axis_Direction POS_SECONDARY_AXIS
	= new SRM_Axis_Direction(_POS_SECONDARY_AXIS, "POS_SECONDARY_AXIS");
    public static final SRM_Axis_Direction POS_TERTIARY_AXIS
	= new SRM_Axis_Direction(_POS_TERTIARY_AXIS, "POS_TERTIARY_AXIS");
    public static final SRM_Axis_Direction NEG_PRIMARY_AXIS
	= new SRM_Axis_Direction(_NEG_PRIMARY_AXIS, "NEG_PRIMARY_AXIS");
    public static final SRM_Axis_Direction NEG_SECONDARY_AXIS
	= new SRM_Axis_Direction(_NEG_SECONDARY_AXIS, "NEG_SECONDARY_AXIS");
    public static final SRM_Axis_Direction NEG_TERTIARY_AXIS
	= new SRM_Axis_Direction(_NEG_TERTIARY_AXIS, "NEG_TERTIARY_AXIS");

    private SRM_Axis_Direction(int hemNum, String hemName) {
	super (hemNum, hemName);
	_enumMap.put( hemName, this ); 
	_enumVec.add( hemNum, this );
    }

    /// returns the Axis Direction object from its enumerant value
    public static SRM_Axis_Direction getEnum( int item ) throws SrmException
    {
	if ( item < 1 || item > _totalEnum )
	    throw new SrmException( SrmException._INVALID_INPUT, 
				    new String("SRM_Axis_Direction.getEnum: enumerant out of range") );
	else
	    return (SRM_Axis_Direction)(_enumVec.elementAt( item ));
    }

    /// returns the SRM_Axis_Direction from its string name
    public static SRM_Axis_Direction getEnum( String name ) throws SrmException
    {
	SRM_Axis_Direction retCode = (SRM_Axis_Direction)_enumMap.get( name );

	if ( retCode == null )
           throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_Axis_Direction.getEnum: enum. string not found=> " + name) );

	return retCode;
    }
}
