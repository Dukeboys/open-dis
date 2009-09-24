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
@brief Declaration of RD enumeration class.
*/
public class SRM_RD_Code extends Enum
{
    public static final int _totalEnum = 146;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _RD_UNDEFINED = 0; /// Undefined
    public static final int _RD_ORIGIN_2D = 1; /// Origin in 2D
    public static final int _RD_X_UNIT_POINT_2D = 2; /// x-axis unit point in 2D
    public static final int _RD_Y_UNIT_POINT_2D = 3; /// y-axis unit point in 2D
    public static final int _RD_ORIGIN_3D = 4; /// Origin in 3D
    public static final int _RD_X_UNIT_POINT_3D = 5; /// x-axis unit point in 3D
    public static final int _RD_Y_UNIT_POINT_3D = 6; /// y-axis unit point in 3D
    public static final int _RD_Z_UNIT_POINT_3D = 7; /// z-axis unit point in 3D
    public static final int _RD_X_AXIS_2D = 8; /// x-axis in 2D
    public static final int _RD_Y_AXIS_2D = 9; /// y-axis in 2D
    public static final int _RD_X_AXIS_3D = 10; /// x-axis in 3D
    public static final int _RD_Y_AXIS_3D = 11; /// y-axis in 3D
    public static final int _RD_Z_AXIS_3D = 12; /// z-axis in 3D
    public static final int _RD_XY_PLANE_3D = 13; /// xy-plane
    public static final int _RD_XZ_PLANE_3D = 14; /// xz-plane
    public static final int _RD_YZ_PLANE_3D = 15; /// yz-plane
    public static final int _RD_ADRASTEA_2000 = 16; /// Adrastea (satellite of Jupiter)
    public static final int _RD_AIRY_1830 = 17; /// Airy
    public static final int _RD_AMALTHEA_2000 = 18; /// Amalthea (satellite of Jupiter)
    public static final int _RD_ANANKE_1988 = 19; /// Ananke (satellite of Jupiter)
    public static final int _RD_APL_4r5_1968 = 20; /// APL 4.5
    public static final int _RD_ARIEL_1988 = 21; /// Ariel (satellite of Uranus)
    public static final int _RD_ATLAS_1988 = 22; /// Atlas (satellite of Saturn)
    public static final int _RD_AUSTRALIAN_NATIONAL_1966 = 23; /// Australian national
    public static final int _RD_AVERAGE_TERRESTRIAL_1977 = 24; /// Average terrestrial system
    public static final int _RD_BELINDA_1988 = 25; /// Belinda (satellite of Uranus)
    public static final int _RD_BESSEL_1841_ETHIOPIA = 26; /// Bessel (Ethiopia, Indonesia, Japan, and Korea)
    public static final int _RD_BESSEL_1841_NAMIBIA = 27; /// Bessel (Namibia)
    public static final int _RD_BIANCA_1988 = 28; /// Bianca (satellite of Uranus)
    public static final int _RD_CALLISTO_2000 = 29; /// Callisto (satellite of Jupiter)
    public static final int _RD_CALYPSO_1988 = 30; /// Calypso (satellite of Saturn)
    public static final int _RD_CARME_1988 = 31; /// Carme (satellite of Jupiter)
    public static final int _RD_CHARON_1991 = 32; /// Charon (satellite of Pluto)
    public static final int _RD_CLARKE_1858 = 33; /// Clarke
    public static final int _RD_CLARKE_1858_MODIFIED = 34; /// Clarke - modified
    public static final int _RD_CLARKE_1866 = 35; /// Clarke
    public static final int _RD_CLARKE_1880 = 36; /// Clarke
    public static final int _RD_CLARKE_1880_CAPE = 37; /// Clarke - Cape
    public static final int _RD_CLARKE_1880_FIJI = 38; /// Clarke - Fiji
    public static final int _RD_CLARKE_1880_IGN = 39; /// Clarke - IGN
    public static final int _RD_CLARKE_1880_PALESTINE = 40; /// Clarke - Palestine
    public static final int _RD_CLARKE_1880_SYRIA = 41; /// Clarke - Syria
    public static final int _RD_COAMPS_1998 = 42; /// Coupled Ocean/Atmospheric Mesoscale Prediction System (COAMPSTM)
    public static final int _RD_CORDELIA_1988 = 43; /// Cordelia (satellite of Uranus)
    public static final int _RD_CRESSIDA_1988 = 44; /// Cressida (satellite of Uranus)
    public static final int _RD_DANISH_1876 = 45; /// Danish - Andrae
    public static final int _RD_DEIMOS_1988 = 46; /// Deimos (satellite of Mars)
    public static final int _RD_DELAMBRE_1810 = 47; /// Delambre
    public static final int _RD_DESDEMONA_1988 = 48; /// Desdemona (satellite of Uranus)
    public static final int _RD_DESPINA_1991 = 49; /// Despina (satellite of Neptune)
    public static final int _RD_DIONE_1982 = 50; /// Dione (satellite of Saturn)
    public static final int _RD_ELARA_1988 = 51; /// Elara (satellite of Jupiter)
    public static final int _RD_ENCELADUS_1994 = 52; /// Enceladus (satellite of Saturn)
    public static final int _RD_EPIMETHEUS_1988 = 53; /// Epimetheus (satellite of Saturn)
    public static final int _RD_EROS_2000 = 54; /// Eros (asteroid 433, a minor planet)
    public static final int _RD_EUROPA_2000 = 55; /// Europa (satellite of Jupiter)
    public static final int _RD_EVEREST_ADJ_1937 = 56; /// Everest 1830 - adjusted
    public static final int _RD_EVEREST_1948 = 57; /// Everest
    public static final int _RD_EVEREST_1956 = 58; /// Everest
    public static final int _RD_EVEREST_REVISED_1962 = 59; /// Everest 1830 - revised definition
    public static final int _RD_EVEREST_1969 = 60; /// Everest
    public static final int _RD_EVEREST_BRUNEI_1967 = 61; /// Everest 1830 - 1967 definition (Brunei and East Malaysia - Sabah and Sarawak)
    public static final int _RD_FISCHER_1960 = 62; /// Fischer - Mercury
    public static final int _RD_FISCHER_1968 = 63; /// Fischer
    public static final int _RD_GALATEA_1991 = 64; /// Galatea (satellite of Neptune)
    public static final int _RD_GANYMEDE_2000 = 65; /// Ganymede (satellite of Jupiter)
    public static final int _RD_GASPRA_1991 = 66; /// Gaspra (asteroid 951, a minor planet)
    public static final int _RD_GRS_1967 = 67; /// Geodetic Reference System (GRS)
    public static final int _RD_GRS_1980 = 68; /// Geodetic Reference System (GRS)
    public static final int _RD_HELENE_1992 = 69; /// Helene (satellite of Saturn)
    public static final int _RD_HELMERT_1906 = 70; /// Helmert
    public static final int _RD_HIMALIA_1988 = 71; /// Himalia (satellite of Jupiter)
    public static final int _RD_HOUGH_1960 = 72; /// Hough
    public static final int _RD_HYPERION_2000 = 73; /// Hyperion (satellite of Saturn)
    public static final int _RD_IAG_1975 = 74; /// International Association of Geodesy (IAG) best estimate
    public static final int _RD_IAPETUS_1988 = 75; /// Iapetus (satellite of Saturn)
    public static final int _RD_IDA_1991 = 76; /// Ida (asteroid 293, a minor planet)
    public static final int _RD_INDONESIAN_1974 = 77; /// Indonesian
    public static final int _RD_INTERNATIONAL_1924 = 78; /// International
    public static final int _RD_IO_2000 = 79; /// Io (satellite of Jupiter)
    public static final int _RD_JANUS_1988 = 80; /// Janus (satellite of Saturn)
    public static final int _RD_JULIET_1988 = 81; /// Juliet (satellite of Uranus)
    public static final int _RD_JUPITER_1988 = 82; /// Jupiter
    public static final int _RD_KLEOPATRA_2000 = 83; /// Kleopatra (asteroid 216, a minor planet)
    public static final int _RD_KRASSOVSKY_1940 = 84; /// Krassovsky
    public static final int _RD_KRAYENHOFF_1827 = 85; /// Krayenhoff
    public static final int _RD_LARISSA_1991 = 86; /// Larissa (satellite of Neptune)
    public static final int _RD_LEDA_1988 = 87; /// Leda (satellite of Jupiter)
    public static final int _RD_LYSITHEA_1988 = 88; /// Lysithea (satellite of Jupiter)
    public static final int _RD_MARS_2000 = 89; /// Mars
    public static final int _RD_MARS_SPHERE_2000 = 90; /// Mars
    public static final int _RD_MASS_1999 = 91; /// MASS
    public static final int _RD_MERCURY_1988 = 92; /// Mercury
    public static final int _RD_METIS_2000 = 93; /// Metis (satellite of Jupiter)
    public static final int _RD_MIMAS_1994 = 94; /// Mimas (satellite of Saturn)
    public static final int _RD_MIRANDA_1988 = 95; /// Miranda (satellite of Uranus)
    public static final int _RD_MM5_1997 = 96; /// Mesoscale (weather) Model 5 (MM5), Air Force Weather Agency (AFWA), US
    public static final int _RD_MODIFIED_AIRY_1849 = 97; /// Modified Airy
    public static final int _RD_MODIFIED_FISCHER_1960 = 98; /// Modified Fischer
    public static final int _RD_MODTRAN_MIDLATITUDE_1989 = 99; /// MODTRAN (midlatitude regions)
    public static final int _RD_MODTRAN_SUBARCTIC_1989 = 100; /// MODTRAN (subarctic regions)
    public static final int _RD_MODTRAN_TROPICAL_1989 = 101; /// MODTRAN (tropical regions)
    public static final int _RD_MOON_1991 = 102; /// Moon (satellite of Earth)
    public static final int _RD_MULTIGEN_FLAT_EARTH_1989 = 103; /// Multigen flat Earth
    public static final int _RD_NAIAD_1991 = 104; /// Naiad (satellite of Neptune)
    public static final int _RD_NEPTUNE_1991 = 105; /// Neptune
    public static final int _RD_NEREID_1991 = 106; /// Nereid (satellite of Neptune)
    public static final int _RD_NOGAPS_1988 = 107; /// Navy Operational Global Atmospheric Prediction System (NOGAPS), US
    public static final int _RD_OBERON_1988 = 108; /// Oberon (satellite of Uranus)
    public static final int _RD_OPHELIA_1988 = 109; /// Ophelia (satellite of Uranus)
    public static final int _RD_PAN_1991 = 110; /// Pan (satellite of Saturn)
    public static final int _RD_PANDORA_1988 = 111; /// Pandora (satellite of Saturn)
    public static final int _RD_PASIPHAE_1988 = 112; /// Pasiphae (satellite of Jupiter)
    public static final int _RD_PHOBOS_1988 = 113; /// Phobos (satellite of Mars)
    public static final int _RD_PHOEBE_1988 = 114; /// Phoebe (satellite of Saturn)
    public static final int _RD_PLESSIS_MODIFIED_1817 = 115; /// Plessis - Modified
    public static final int _RD_PLUTO_1994 = 116; /// Pluto
    public static final int _RD_PORTIA_1988 = 117; /// Portia (satellite of Uranus)
    public static final int _RD_PROMETHEUS_1988 = 118; /// Prometheus (satellite of Saturn)
    public static final int _RD_PROTEUS_1991 = 119; /// Proteus (satellite of Neptune)
    public static final int _RD_PUCK_1988 = 120; /// Puck (satellite of Uranus)
    public static final int _RD_RHEA_1988 = 121; /// Rhea (satellite of Saturn)
    public static final int _RD_ROSALIND_1988 = 122; /// Rosalind (satellite of Uranus)
    public static final int _RD_SATURN_1988 = 123; /// Saturn
    public static final int _RD_SINOPE_1988 = 124; /// Sinope (satellite of Jupiter)
    public static final int _RD_SOUTH_AMERICAN_1969 = 125; /// South american
    public static final int _RD_SOVIET_GEODETIC_1985 = 126; /// Soviet geodetic system
    public static final int _RD_SOVIET_GEODETIC_1990 = 127; /// Soviet geodetic system
    public static final int _RD_STRUVE_1860 = 128; /// Struve
    public static final int _RD_SUN_1992 = 129; /// Sun
    public static final int _RD_TELESTO_1988 = 130; /// Telesto (satellite of Saturn)
    public static final int _RD_TETHYS_1991 = 131; /// Tethys (satellite of Saturn)
    public static final int _RD_THALASSA_1991 = 132; /// Thalassa (satellite of Neptune)
    public static final int _RD_THEBE_2000 = 133; /// Thebe (satellite of Jupiter)
    public static final int _RD_TITAN_1982 = 134; /// Titan (satellite of Saturn)
    public static final int _RD_TITANIA_1988 = 135; /// Titania (satellite of Uranus)
    public static final int _RD_TRITON_1991 = 136; /// Triton (satellite of Neptune)
    public static final int _RD_UMBRIEL_1988 = 137; /// Umbriel (satellite of Uranus)
    public static final int _RD_URANUS_1988 = 138; /// Uranus
    public static final int _RD_VENUS_1991 = 139; /// Venus
    public static final int _RD_WALBECK_AMS_1963 = 140; /// Walbeck 1819 - AMS
    public static final int _RD_WALBECK_PLANHEFT_1942 = 141; /// Walbeck 1819 - Planheft
    public static final int _RD_WAR_OFFICE_1924 = 142; /// War Office - McCaw
    public static final int _RD_WGS_1960 = 143; /// World Geodetic System 1960
    public static final int _RD_WGS_1966 = 144; /// World Geodetic System 1966
    public static final int _RD_WGS_1984 = 145; /// World geodetic system
    public static final int _RD_WGS_1972 = 146; /// World geodetic system

    public static final SRM_RD_Code RD_UNDEFINED
        = new SRM_RD_Code( _RD_UNDEFINED, "RD_UNDEFINED" );

    public static final SRM_RD_Code RD_ORIGIN_2D
        = new SRM_RD_Code( _RD_ORIGIN_2D, "RD_ORIGIN_2D" );
    public static final SRM_RD_Code RD_X_UNIT_POINT_2D
        = new SRM_RD_Code( _RD_X_UNIT_POINT_2D, "RD_X_UNIT_POINT_2D" );
    public static final SRM_RD_Code RD_Y_UNIT_POINT_2D
        = new SRM_RD_Code( _RD_Y_UNIT_POINT_2D, "RD_Y_UNIT_POINT_2D" );
    public static final SRM_RD_Code RD_ORIGIN_3D
        = new SRM_RD_Code( _RD_ORIGIN_3D, "RD_ORIGIN_3D" );
    public static final SRM_RD_Code RD_X_UNIT_POINT_3D
        = new SRM_RD_Code( _RD_X_UNIT_POINT_3D, "RD_X_UNIT_POINT_3D" );
    public static final SRM_RD_Code RD_Y_UNIT_POINT_3D
        = new SRM_RD_Code( _RD_Y_UNIT_POINT_3D, "RD_Y_UNIT_POINT_3D" );
    public static final SRM_RD_Code RD_Z_UNIT_POINT_3D
        = new SRM_RD_Code( _RD_Z_UNIT_POINT_3D, "RD_Z_UNIT_POINT_3D" );
    public static final SRM_RD_Code RD_X_AXIS_2D
        = new SRM_RD_Code( _RD_X_AXIS_2D, "RD_X_AXIS_2D" );
    public static final SRM_RD_Code RD_Y_AXIS_2D
        = new SRM_RD_Code( _RD_Y_AXIS_2D, "RD_Y_AXIS_2D" );
    public static final SRM_RD_Code RD_X_AXIS_3D
        = new SRM_RD_Code( _RD_X_AXIS_3D, "RD_X_AXIS_3D" );
    public static final SRM_RD_Code RD_Y_AXIS_3D
        = new SRM_RD_Code( _RD_Y_AXIS_3D, "RD_Y_AXIS_3D" );
    public static final SRM_RD_Code RD_Z_AXIS_3D
        = new SRM_RD_Code( _RD_Z_AXIS_3D, "RD_Z_AXIS_3D" );
    public static final SRM_RD_Code RD_XY_PLANE_3D
        = new SRM_RD_Code( _RD_XY_PLANE_3D, "RD_XY_PLANE_3D" );
    public static final SRM_RD_Code RD_XZ_PLANE_3D
        = new SRM_RD_Code( _RD_XZ_PLANE_3D, "RD_XZ_PLANE_3D" );
    public static final SRM_RD_Code RD_YZ_PLANE_3D
        = new SRM_RD_Code( _RD_YZ_PLANE_3D, "RD_YZ_PLANE_3D" );
    public static final SRM_RD_Code RD_ADRASTEA_2000
        = new SRM_RD_Code( _RD_ADRASTEA_2000, "RD_ADRASTEA_2000" );
    public static final SRM_RD_Code RD_AIRY_1830
        = new SRM_RD_Code( _RD_AIRY_1830, "RD_AIRY_1830" );
    public static final SRM_RD_Code RD_AMALTHEA_2000
        = new SRM_RD_Code( _RD_AMALTHEA_2000, "RD_AMALTHEA_2000" );
    public static final SRM_RD_Code RD_ANANKE_1988
        = new SRM_RD_Code( _RD_ANANKE_1988, "RD_ANANKE_1988" );
    public static final SRM_RD_Code RD_APL_4r5_1968
        = new SRM_RD_Code( _RD_APL_4r5_1968, "RD_APL_4r5_1968" );
    public static final SRM_RD_Code RD_ARIEL_1988
        = new SRM_RD_Code( _RD_ARIEL_1988, "RD_ARIEL_1988" );
    public static final SRM_RD_Code RD_ATLAS_1988
        = new SRM_RD_Code( _RD_ATLAS_1988, "RD_ATLAS_1988" );
    public static final SRM_RD_Code RD_AUSTRALIAN_NATIONAL_1966
        = new SRM_RD_Code( _RD_AUSTRALIAN_NATIONAL_1966, "RD_AUSTRALIAN_NATIONAL_1966" );
    public static final SRM_RD_Code RD_AVERAGE_TERRESTRIAL_1977
        = new SRM_RD_Code( _RD_AVERAGE_TERRESTRIAL_1977, "RD_AVERAGE_TERRESTRIAL_1977" );
    public static final SRM_RD_Code RD_BELINDA_1988
        = new SRM_RD_Code( _RD_BELINDA_1988, "RD_BELINDA_1988" );
    public static final SRM_RD_Code RD_BESSEL_1841_ETHIOPIA
        = new SRM_RD_Code( _RD_BESSEL_1841_ETHIOPIA, "RD_BESSEL_1841_ETHIOPIA" );
    public static final SRM_RD_Code RD_BESSEL_1841_NAMIBIA
        = new SRM_RD_Code( _RD_BESSEL_1841_NAMIBIA, "RD_BESSEL_1841_NAMIBIA" );
    public static final SRM_RD_Code RD_BIANCA_1988
        = new SRM_RD_Code( _RD_BIANCA_1988, "RD_BIANCA_1988" );
    public static final SRM_RD_Code RD_CALLISTO_2000
        = new SRM_RD_Code( _RD_CALLISTO_2000, "RD_CALLISTO_2000" );
    public static final SRM_RD_Code RD_CALYPSO_1988
        = new SRM_RD_Code( _RD_CALYPSO_1988, "RD_CALYPSO_1988" );
    public static final SRM_RD_Code RD_CARME_1988
        = new SRM_RD_Code( _RD_CARME_1988, "RD_CARME_1988" );
    public static final SRM_RD_Code RD_CHARON_1991
        = new SRM_RD_Code( _RD_CHARON_1991, "RD_CHARON_1991" );
    public static final SRM_RD_Code RD_CLARKE_1858
        = new SRM_RD_Code( _RD_CLARKE_1858, "RD_CLARKE_1858" );
    public static final SRM_RD_Code RD_CLARKE_1858_MODIFIED
        = new SRM_RD_Code( _RD_CLARKE_1858_MODIFIED, "RD_CLARKE_1858_MODIFIED" );
    public static final SRM_RD_Code RD_CLARKE_1866
        = new SRM_RD_Code( _RD_CLARKE_1866, "RD_CLARKE_1866" );
    public static final SRM_RD_Code RD_CLARKE_1880
        = new SRM_RD_Code( _RD_CLARKE_1880, "RD_CLARKE_1880" );
    public static final SRM_RD_Code RD_CLARKE_1880_CAPE
        = new SRM_RD_Code( _RD_CLARKE_1880_CAPE, "RD_CLARKE_1880_CAPE" );
    public static final SRM_RD_Code RD_CLARKE_1880_FIJI
        = new SRM_RD_Code( _RD_CLARKE_1880_FIJI, "RD_CLARKE_1880_FIJI" );
    public static final SRM_RD_Code RD_CLARKE_1880_IGN
        = new SRM_RD_Code( _RD_CLARKE_1880_IGN, "RD_CLARKE_1880_IGN" );
    public static final SRM_RD_Code RD_CLARKE_1880_PALESTINE
        = new SRM_RD_Code( _RD_CLARKE_1880_PALESTINE, "RD_CLARKE_1880_PALESTINE" );
    public static final SRM_RD_Code RD_CLARKE_1880_SYRIA
        = new SRM_RD_Code( _RD_CLARKE_1880_SYRIA, "RD_CLARKE_1880_SYRIA" );
    public static final SRM_RD_Code RD_COAMPS_1998
        = new SRM_RD_Code( _RD_COAMPS_1998, "RD_COAMPS_1998" );
    public static final SRM_RD_Code RD_CORDELIA_1988
        = new SRM_RD_Code( _RD_CORDELIA_1988, "RD_CORDELIA_1988" );
    public static final SRM_RD_Code RD_CRESSIDA_1988
        = new SRM_RD_Code( _RD_CRESSIDA_1988, "RD_CRESSIDA_1988" );
    public static final SRM_RD_Code RD_DANISH_1876
        = new SRM_RD_Code( _RD_DANISH_1876, "RD_DANISH_1876" );
    public static final SRM_RD_Code RD_DEIMOS_1988
        = new SRM_RD_Code( _RD_DEIMOS_1988, "RD_DEIMOS_1988" );
    public static final SRM_RD_Code RD_DELAMBRE_1810
        = new SRM_RD_Code( _RD_DELAMBRE_1810, "RD_DELAMBRE_1810" );
    public static final SRM_RD_Code RD_DESDEMONA_1988
        = new SRM_RD_Code( _RD_DESDEMONA_1988, "RD_DESDEMONA_1988" );
    public static final SRM_RD_Code RD_DESPINA_1991
        = new SRM_RD_Code( _RD_DESPINA_1991, "RD_DESPINA_1991" );
    public static final SRM_RD_Code RD_DIONE_1982
        = new SRM_RD_Code( _RD_DIONE_1982, "RD_DIONE_1982" );
    public static final SRM_RD_Code RD_ELARA_1988
        = new SRM_RD_Code( _RD_ELARA_1988, "RD_ELARA_1988" );
    public static final SRM_RD_Code RD_ENCELADUS_1994
        = new SRM_RD_Code( _RD_ENCELADUS_1994, "RD_ENCELADUS_1994" );
    public static final SRM_RD_Code RD_EPIMETHEUS_1988
        = new SRM_RD_Code( _RD_EPIMETHEUS_1988, "RD_EPIMETHEUS_1988" );
    public static final SRM_RD_Code RD_EROS_2000
        = new SRM_RD_Code( _RD_EROS_2000, "RD_EROS_2000" );
    public static final SRM_RD_Code RD_EUROPA_2000
        = new SRM_RD_Code( _RD_EUROPA_2000, "RD_EUROPA_2000" );
    public static final SRM_RD_Code RD_EVEREST_ADJ_1937
        = new SRM_RD_Code( _RD_EVEREST_ADJ_1937, "RD_EVEREST_ADJ_1937" );
    public static final SRM_RD_Code RD_EVEREST_1948
        = new SRM_RD_Code( _RD_EVEREST_1948, "RD_EVEREST_1948" );
    public static final SRM_RD_Code RD_EVEREST_1956
        = new SRM_RD_Code( _RD_EVEREST_1956, "RD_EVEREST_1956" );
    public static final SRM_RD_Code RD_EVEREST_REVISED_1962
        = new SRM_RD_Code( _RD_EVEREST_REVISED_1962, "RD_EVEREST_REVISED_1962" );
    public static final SRM_RD_Code RD_EVEREST_1969
        = new SRM_RD_Code( _RD_EVEREST_1969, "RD_EVEREST_1969" );
    public static final SRM_RD_Code RD_EVEREST_BRUNEI_1967
        = new SRM_RD_Code( _RD_EVEREST_BRUNEI_1967, "RD_EVEREST_BRUNEI_1967" );
    public static final SRM_RD_Code RD_FISCHER_1960
        = new SRM_RD_Code( _RD_FISCHER_1960, "RD_FISCHER_1960" );
    public static final SRM_RD_Code RD_FISCHER_1968
        = new SRM_RD_Code( _RD_FISCHER_1968, "RD_FISCHER_1968" );
    public static final SRM_RD_Code RD_GALATEA_1991
        = new SRM_RD_Code( _RD_GALATEA_1991, "RD_GALATEA_1991" );
    public static final SRM_RD_Code RD_GANYMEDE_2000
        = new SRM_RD_Code( _RD_GANYMEDE_2000, "RD_GANYMEDE_2000" );
    public static final SRM_RD_Code RD_GASPRA_1991
        = new SRM_RD_Code( _RD_GASPRA_1991, "RD_GASPRA_1991" );
    public static final SRM_RD_Code RD_GRS_1967
        = new SRM_RD_Code( _RD_GRS_1967, "RD_GRS_1967" );
    public static final SRM_RD_Code RD_GRS_1980
        = new SRM_RD_Code( _RD_GRS_1980, "RD_GRS_1980" );
    public static final SRM_RD_Code RD_HELENE_1992
        = new SRM_RD_Code( _RD_HELENE_1992, "RD_HELENE_1992" );
    public static final SRM_RD_Code RD_HELMERT_1906
        = new SRM_RD_Code( _RD_HELMERT_1906, "RD_HELMERT_1906" );
    public static final SRM_RD_Code RD_HIMALIA_1988
        = new SRM_RD_Code( _RD_HIMALIA_1988, "RD_HIMALIA_1988" );
    public static final SRM_RD_Code RD_HOUGH_1960
        = new SRM_RD_Code( _RD_HOUGH_1960, "RD_HOUGH_1960" );
    public static final SRM_RD_Code RD_HYPERION_2000
        = new SRM_RD_Code( _RD_HYPERION_2000, "RD_HYPERION_2000" );
    public static final SRM_RD_Code RD_IAG_1975
        = new SRM_RD_Code( _RD_IAG_1975, "RD_IAG_1975" );
    public static final SRM_RD_Code RD_IAPETUS_1988
        = new SRM_RD_Code( _RD_IAPETUS_1988, "RD_IAPETUS_1988" );
    public static final SRM_RD_Code RD_IDA_1991
        = new SRM_RD_Code( _RD_IDA_1991, "RD_IDA_1991" );
    public static final SRM_RD_Code RD_INDONESIAN_1974
        = new SRM_RD_Code( _RD_INDONESIAN_1974, "RD_INDONESIAN_1974" );
    public static final SRM_RD_Code RD_INTERNATIONAL_1924
        = new SRM_RD_Code( _RD_INTERNATIONAL_1924, "RD_INTERNATIONAL_1924" );
    public static final SRM_RD_Code RD_IO_2000
        = new SRM_RD_Code( _RD_IO_2000, "RD_IO_2000" );
    public static final SRM_RD_Code RD_JANUS_1988
        = new SRM_RD_Code( _RD_JANUS_1988, "RD_JANUS_1988" );
    public static final SRM_RD_Code RD_JULIET_1988
        = new SRM_RD_Code( _RD_JULIET_1988, "RD_JULIET_1988" );
    public static final SRM_RD_Code RD_JUPITER_1988
        = new SRM_RD_Code( _RD_JUPITER_1988, "RD_JUPITER_1988" );
    public static final SRM_RD_Code RD_KLEOPATRA_2000
        = new SRM_RD_Code( _RD_KLEOPATRA_2000, "RD_KLEOPATRA_2000" );
    public static final SRM_RD_Code RD_KRASSOVSKY_1940
        = new SRM_RD_Code( _RD_KRASSOVSKY_1940, "RD_KRASSOVSKY_1940" );
    public static final SRM_RD_Code RD_KRAYENHOFF_1827
        = new SRM_RD_Code( _RD_KRAYENHOFF_1827, "RD_KRAYENHOFF_1827" );
    public static final SRM_RD_Code RD_LARISSA_1991
        = new SRM_RD_Code( _RD_LARISSA_1991, "RD_LARISSA_1991" );
    public static final SRM_RD_Code RD_LEDA_1988
        = new SRM_RD_Code( _RD_LEDA_1988, "RD_LEDA_1988" );
    public static final SRM_RD_Code RD_LYSITHEA_1988
        = new SRM_RD_Code( _RD_LYSITHEA_1988, "RD_LYSITHEA_1988" );
    public static final SRM_RD_Code RD_MARS_2000
        = new SRM_RD_Code( _RD_MARS_2000, "RD_MARS_2000" );
    public static final SRM_RD_Code RD_MARS_SPHERE_2000
        = new SRM_RD_Code( _RD_MARS_SPHERE_2000, "RD_MARS_SPHERE_2000" );
    public static final SRM_RD_Code RD_MASS_1999
        = new SRM_RD_Code( _RD_MASS_1999, "RD_MASS_1999" );
    public static final SRM_RD_Code RD_MERCURY_1988
        = new SRM_RD_Code( _RD_MERCURY_1988, "RD_MERCURY_1988" );
    public static final SRM_RD_Code RD_METIS_2000
        = new SRM_RD_Code( _RD_METIS_2000, "RD_METIS_2000" );
    public static final SRM_RD_Code RD_MIMAS_1994
        = new SRM_RD_Code( _RD_MIMAS_1994, "RD_MIMAS_1994" );
    public static final SRM_RD_Code RD_MIRANDA_1988
        = new SRM_RD_Code( _RD_MIRANDA_1988, "RD_MIRANDA_1988" );
    public static final SRM_RD_Code RD_MM5_1997
        = new SRM_RD_Code( _RD_MM5_1997, "RD_MM5_1997" );
    public static final SRM_RD_Code RD_MODIFIED_AIRY_1849
        = new SRM_RD_Code( _RD_MODIFIED_AIRY_1849, "RD_MODIFIED_AIRY_1849" );
    public static final SRM_RD_Code RD_MODIFIED_FISCHER_1960
        = new SRM_RD_Code( _RD_MODIFIED_FISCHER_1960, "RD_MODIFIED_FISCHER_1960" );
    public static final SRM_RD_Code RD_MODTRAN_MIDLATITUDE_1989
        = new SRM_RD_Code( _RD_MODTRAN_MIDLATITUDE_1989, "RD_MODTRAN_MIDLATITUDE_1989" );
    public static final SRM_RD_Code RD_MODTRAN_SUBARCTIC_1989
        = new SRM_RD_Code( _RD_MODTRAN_SUBARCTIC_1989, "RD_MODTRAN_SUBARCTIC_1989" );
    public static final SRM_RD_Code RD_MODTRAN_TROPICAL_1989
        = new SRM_RD_Code( _RD_MODTRAN_TROPICAL_1989, "RD_MODTRAN_TROPICAL_1989" );
    public static final SRM_RD_Code RD_MOON_1991
        = new SRM_RD_Code( _RD_MOON_1991, "RD_MOON_1991" );
    public static final SRM_RD_Code RD_MULTIGEN_FLAT_EARTH_1989
        = new SRM_RD_Code( _RD_MULTIGEN_FLAT_EARTH_1989, "RD_MULTIGEN_FLAT_EARTH_1989" );
    public static final SRM_RD_Code RD_NAIAD_1991
        = new SRM_RD_Code( _RD_NAIAD_1991, "RD_NAIAD_1991" );
    public static final SRM_RD_Code RD_NEPTUNE_1991
        = new SRM_RD_Code( _RD_NEPTUNE_1991, "RD_NEPTUNE_1991" );
    public static final SRM_RD_Code RD_NEREID_1991
        = new SRM_RD_Code( _RD_NEREID_1991, "RD_NEREID_1991" );
    public static final SRM_RD_Code RD_NOGAPS_1988
        = new SRM_RD_Code( _RD_NOGAPS_1988, "RD_NOGAPS_1988" );
    public static final SRM_RD_Code RD_OBERON_1988
        = new SRM_RD_Code( _RD_OBERON_1988, "RD_OBERON_1988" );
    public static final SRM_RD_Code RD_OPHELIA_1988
        = new SRM_RD_Code( _RD_OPHELIA_1988, "RD_OPHELIA_1988" );
    public static final SRM_RD_Code RD_PAN_1991
        = new SRM_RD_Code( _RD_PAN_1991, "RD_PAN_1991" );
    public static final SRM_RD_Code RD_PANDORA_1988
        = new SRM_RD_Code( _RD_PANDORA_1988, "RD_PANDORA_1988" );
    public static final SRM_RD_Code RD_PASIPHAE_1988
        = new SRM_RD_Code( _RD_PASIPHAE_1988, "RD_PASIPHAE_1988" );
    public static final SRM_RD_Code RD_PHOBOS_1988
        = new SRM_RD_Code( _RD_PHOBOS_1988, "RD_PHOBOS_1988" );
    public static final SRM_RD_Code RD_PHOEBE_1988
        = new SRM_RD_Code( _RD_PHOEBE_1988, "RD_PHOEBE_1988" );
    public static final SRM_RD_Code RD_PLESSIS_MODIFIED_1817
        = new SRM_RD_Code( _RD_PLESSIS_MODIFIED_1817, "RD_PLESSIS_MODIFIED_1817" );
    public static final SRM_RD_Code RD_PLUTO_1994
        = new SRM_RD_Code( _RD_PLUTO_1994, "RD_PLUTO_1994" );
    public static final SRM_RD_Code RD_PORTIA_1988
        = new SRM_RD_Code( _RD_PORTIA_1988, "RD_PORTIA_1988" );
    public static final SRM_RD_Code RD_PROMETHEUS_1988
        = new SRM_RD_Code( _RD_PROMETHEUS_1988, "RD_PROMETHEUS_1988" );
    public static final SRM_RD_Code RD_PROTEUS_1991
        = new SRM_RD_Code( _RD_PROTEUS_1991, "RD_PROTEUS_1991" );
    public static final SRM_RD_Code RD_PUCK_1988
        = new SRM_RD_Code( _RD_PUCK_1988, "RD_PUCK_1988" );
    public static final SRM_RD_Code RD_RHEA_1988
        = new SRM_RD_Code( _RD_RHEA_1988, "RD_RHEA_1988" );
    public static final SRM_RD_Code RD_ROSALIND_1988
        = new SRM_RD_Code( _RD_ROSALIND_1988, "RD_ROSALIND_1988" );
    public static final SRM_RD_Code RD_SATURN_1988
        = new SRM_RD_Code( _RD_SATURN_1988, "RD_SATURN_1988" );
    public static final SRM_RD_Code RD_SINOPE_1988
        = new SRM_RD_Code( _RD_SINOPE_1988, "RD_SINOPE_1988" );
    public static final SRM_RD_Code RD_SOUTH_AMERICAN_1969
        = new SRM_RD_Code( _RD_SOUTH_AMERICAN_1969, "RD_SOUTH_AMERICAN_1969" );
    public static final SRM_RD_Code RD_SOVIET_GEODETIC_1985
        = new SRM_RD_Code( _RD_SOVIET_GEODETIC_1985, "RD_SOVIET_GEODETIC_1985" );
    public static final SRM_RD_Code RD_SOVIET_GEODETIC_1990
        = new SRM_RD_Code( _RD_SOVIET_GEODETIC_1990, "RD_SOVIET_GEODETIC_1990" );
    public static final SRM_RD_Code RD_STRUVE_1860
        = new SRM_RD_Code( _RD_STRUVE_1860, "RD_STRUVE_1860" );
    public static final SRM_RD_Code RD_SUN_1992
        = new SRM_RD_Code( _RD_SUN_1992, "RD_SUN_1992" );
    public static final SRM_RD_Code RD_TELESTO_1988
        = new SRM_RD_Code( _RD_TELESTO_1988, "RD_TELESTO_1988" );
    public static final SRM_RD_Code RD_TETHYS_1991
        = new SRM_RD_Code( _RD_TETHYS_1991, "RD_TETHYS_1991" );
    public static final SRM_RD_Code RD_THALASSA_1991
        = new SRM_RD_Code( _RD_THALASSA_1991, "RD_THALASSA_1991" );
    public static final SRM_RD_Code RD_THEBE_2000
        = new SRM_RD_Code( _RD_THEBE_2000, "RD_THEBE_2000" );
    public static final SRM_RD_Code RD_TITAN_1982
        = new SRM_RD_Code( _RD_TITAN_1982, "RD_TITAN_1982" );
    public static final SRM_RD_Code RD_TITANIA_1988
        = new SRM_RD_Code( _RD_TITANIA_1988, "RD_TITANIA_1988" );
    public static final SRM_RD_Code RD_TRITON_1991
        = new SRM_RD_Code( _RD_TRITON_1991, "RD_TRITON_1991" );
    public static final SRM_RD_Code RD_UMBRIEL_1988
        = new SRM_RD_Code( _RD_UMBRIEL_1988, "RD_UMBRIEL_1988" );
    public static final SRM_RD_Code RD_URANUS_1988
        = new SRM_RD_Code( _RD_URANUS_1988, "RD_URANUS_1988" );
    public static final SRM_RD_Code RD_VENUS_1991
        = new SRM_RD_Code( _RD_VENUS_1991, "RD_VENUS_1991" );
    public static final SRM_RD_Code RD_WALBECK_AMS_1963
        = new SRM_RD_Code( _RD_WALBECK_AMS_1963, "RD_WALBECK_AMS_1963" );
    public static final SRM_RD_Code RD_WALBECK_PLANHEFT_1942
        = new SRM_RD_Code( _RD_WALBECK_PLANHEFT_1942, "RD_WALBECK_PLANHEFT_1942" );
    public static final SRM_RD_Code RD_WAR_OFFICE_1924
        = new SRM_RD_Code( _RD_WAR_OFFICE_1924, "RD_WAR_OFFICE_1924" );
    public static final SRM_RD_Code RD_WGS_1960
        = new SRM_RD_Code( _RD_WGS_1960, "RD_WGS_1960" );
    public static final SRM_RD_Code RD_WGS_1966
        = new SRM_RD_Code( _RD_WGS_1966, "RD_WGS_1966" );
    public static final SRM_RD_Code RD_WGS_1984
        = new SRM_RD_Code( _RD_WGS_1984, "RD_WGS_1984" );
    public static final SRM_RD_Code RD_WGS_1972
        = new SRM_RD_Code( _RD_WGS_1972, "RD_WGS_1972" );

    private SRM_RD_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_RD_Code from its enumerant value
    public static SRM_RD_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_RD_Code.getEnum: enumerant out of range") );
        else
            return (SRM_RD_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_RD_Code from its string name
    public static SRM_RD_Code getEnum( String name ) throws SrmException
    {
        SRM_RD_Code retCode = (SRM_RD_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_RD_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

