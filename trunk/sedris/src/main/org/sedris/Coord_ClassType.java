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

/**
@author David Shen
@brief Declaration of coordinate type enumeration class.
*/
public class Coord_ClassType extends Enum
{
    public static final int _CC_3D            = 1;
    public static final int _CD_3D            = 2;
    public static final int _CD_SURFACE       = 3;
    public static final int _CM_3D            = 4;
    public static final int _EC_AUGMENTED_3D  = 5;
    public static final int _EC_SURFACE       = 6;
    public static final int _EI_3D            = 7;
    public static final int _HAEC_3D          = 8;
    public static final int _HEEC_3D          = 9;
    public static final int _HEEQ_3D          = 10;
    public static final int _LCC_AUGMENTED_3D = 11;
    public static final int _LCC_SURFACE      = 12;
    public static final int _LSA_2D           = 13;
    public static final int _LSP_2D           = 14;
    public static final int _LSR_2D           = 15;
    public static final int _LSR_3D           = 16;
    public static final int _LCE_3D           = 17;
    public static final int _LTSAS_3D         = 18;
    public static final int _LTSAS_SURFACE    = 19;
    public static final int _LTSC_3D          = 20;
    public static final int _LTSC_SURFACE     = 21;
    public static final int _LTSE_3D          = 22;
    public static final int _LTSE_SURFACE     = 23;
    public static final int _M_AUGMENTED_3D   = 24;
    public static final int _M_SURFACE        = 25;
    public static final int _OMS_AUGMENTED_3D = 26;
    public static final int _OMS_SURFACE      = 27;
    public static final int _PD_3D            = 28;
    public static final int _PD_SURFACE       = 29;
    public static final int _PS_AUGMENTED_3D  = 30;
    public static final int _PS_SURFACE       = 31;
    public static final int _SEC_3D           = 32;
    public static final int _SEQ_3D           = 33;
    public static final int _SMD_3D           = 34;
    public static final int _SME_3D           = 35;
    public static final int _TM_AUGMENTED_3D  = 36;
    public static final int _TM_SURFACE       = 37;

    public static final int _totalEnum = 37;

    public static final Coord_ClassType LSA_2D
        = new Coord_ClassType(_LSA_2D, "LSA_2D");
    public static final Coord_ClassType CC_3D
        = new Coord_ClassType(_CC_3D, "CC_3D");
    public static final Coord_ClassType CD_3D
        = new Coord_ClassType(_CD_3D, "CD_3D");
    public static final Coord_ClassType CD_SURFACE
        = new Coord_ClassType(_CD_SURFACE, "CD_SURFACE");
    public static final Coord_ClassType PD_3D
        = new Coord_ClassType(_PD_3D, "PD_3D");
    public static final Coord_ClassType PD_SURFACE
        = new Coord_ClassType(_PD_SURFACE, "PD_SURFACE");
    public static final Coord_ClassType CM_3D
        = new Coord_ClassType(_CM_3D, "CM_3D");
    public static final Coord_ClassType EC_AUGMENTED_3D
        = new Coord_ClassType(_EC_AUGMENTED_3D, "EC_AUGMENTED_3D");
    public static final Coord_ClassType EC_SURFACE
        = new Coord_ClassType(_EC_SURFACE, "EC_SURFACE");
    public static final Coord_ClassType EI_3D
        = new Coord_ClassType(_EI_3D, "EI_3D");
    public static final Coord_ClassType HAEC_3D
        = new Coord_ClassType(_HAEC_3D, "HAEC_3D");
    public static final Coord_ClassType HEEC_3D
        = new Coord_ClassType(_HEEC_3D, "HEEC_3D");
    public static final Coord_ClassType HEEQ_3D
        = new Coord_ClassType(_HEEQ_3D, "HEEQ_3D");
    public static final Coord_ClassType LCC_AUGMENTED_3D
        = new Coord_ClassType(_LCC_AUGMENTED_3D, "LCC_AUGMENTED_3D");
    public static final Coord_ClassType LCC_SURFACE
        = new Coord_ClassType(_LCC_SURFACE, "LCC_SURFACE");
    public static final Coord_ClassType LSR_2D
        = new Coord_ClassType(_LSR_2D, "LSR_2D");
    public static final Coord_ClassType LSR_3D
        = new Coord_ClassType(_LSR_3D, "LSR_3D");
    public static final Coord_ClassType LTSAS_3D
        = new Coord_ClassType(_LTSAS_3D, "LTSAS_3D");
    public static final Coord_ClassType LTSAS_SURFACE
        = new Coord_ClassType(_LTSAS_SURFACE, "LTSAS_SURFACE");
    public static final Coord_ClassType LTSC_3D
        = new Coord_ClassType(_LTSC_3D, "LTSC_3D");
    public static final Coord_ClassType LTSC_SURFACE
        = new Coord_ClassType(_LTSC_SURFACE, "LTSC_SURFACE");
    public static final Coord_ClassType LTSE_3D
        = new Coord_ClassType(_LTSE_3D, "LTSE_3D");
    public static final Coord_ClassType LTSE_SURFACE
        = new Coord_ClassType(_LTSE_SURFACE, "LTSE_SURFACE");
    public static final Coord_ClassType M_AUGMENTED_3D
        = new Coord_ClassType(_M_AUGMENTED_3D, "M_AUGMENTED_3D");
    public static final Coord_ClassType M_SURFACE
        = new Coord_ClassType(_M_SURFACE, "M_SURFACE");
    public static final Coord_ClassType OMS_AUGMENTED_3D
        = new Coord_ClassType(_OMS_AUGMENTED_3D, "OMS_AUGMENTED_3D");
    public static final Coord_ClassType OMS_SURFACE
        = new Coord_ClassType(_OMS_SURFACE, "OMS_SURFACE");
    public static final Coord_ClassType LSP_2D
        = new Coord_ClassType(_LSP_2D, "LSP_2D");
    public static final Coord_ClassType PS_AUGMENTED_3D
        = new Coord_ClassType(_PS_AUGMENTED_3D, "PS_AUGMENTED_3D");
    public static final Coord_ClassType PS_SURFACE
        = new Coord_ClassType(_PS_SURFACE, "PS_SURFACE");
    public static final Coord_ClassType SEC_3D
        = new Coord_ClassType(_SEC_3D, "SEC_3D");
    public static final Coord_ClassType SEQ_3D
        = new Coord_ClassType(_SEQ_3D, "SEQ_3D");
    public static final Coord_ClassType SMD_3D
        = new Coord_ClassType(_SMD_3D, "SMD_3D");
    public static final Coord_ClassType SME_3D
        = new Coord_ClassType(_SME_3D, "SME_3D");
    public static final Coord_ClassType TM_AUGMENTED_3D
        = new Coord_ClassType(_TM_AUGMENTED_3D, "TM_AUGMENTED_3D");
    public static final Coord_ClassType TM_SURFACE
        = new Coord_ClassType(_TM_SURFACE, "TM_SURFACE");
    public static final Coord_ClassType LCE_3D
        = new Coord_ClassType(_LCE_3D, "LCE_3D");

    private Coord_ClassType(int code, String name)
    {
        super (code, name);
    }
}
