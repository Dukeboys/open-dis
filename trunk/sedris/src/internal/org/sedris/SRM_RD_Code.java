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
@author David Shen, Michele L. Worley
@brief Declaration of RD enumeration class.
*/
public class SRM_RD_Code extends Enum
{
    public static final int _RDCOD_UNSPECIFIED = 0; /// Unspecified
    public static final int _RDCOD_ORIGIN_2D = 1; /// Origin in 2D
    public static final int _RDCOD_X_UNIT_POINT_2D = 2; /// x-axis unit point in 2D
    public static final int _RDCOD_Y_UNIT_POINT_2D = 3; /// y-axis unit point in 2D
    public static final int _RDCOD_ORIGIN_3D = 4; /// Origin in 3D
    public static final int _RDCOD_X_UNIT_POINT_3D = 5; /// x-axis unit point in 3D
    public static final int _RDCOD_Y_UNIT_POINT_3D = 6; /// y-axis unit point in 3D
    public static final int _RDCOD_Z_UNIT_POINT_3D = 7; /// z-axis unit point in 3D
    public static final int _RDCOD_X_AXIS_2D = 8; /// x-axis in 2D
    public static final int _RDCOD_Y_AXIS_2D = 9; /// y-axis in 2D
    public static final int _RDCOD_X_AXIS_3D = 10; /// x-axis in 3D
    public static final int _RDCOD_Y_AXIS_3D = 11; /// y-axis in 3D
    public static final int _RDCOD_Z_AXIS_3D = 12; /// z-axis in 3D
    public static final int _RDCOD_XY_PLANE_3D = 13; /// xy-plane
    public static final int _RDCOD_XZ_PLANE_3D = 14; /// xz-plane
    public static final int _RDCOD_YZ_PLANE_3D = 15; /// yz-plane
    public static final int _RDCOD_ADRASTEA_2000 = 16; /// Adrastea (satellite of Jupiter)
    public static final int _RDCOD_AIRY_1830 = 17; /// Airy
    public static final int _RDCOD_AMALTHEA_2000 = 18; /// Amalthea (satellite of Jupiter)
    public static final int _RDCOD_ANANKE_1988 = 19; /// Ananke (satellite of Jupiter)
    public static final int _RDCOD_APL_4r5_1968 = 20; /// APL 4.5
    public static final int _RDCOD_ARIEL_1988 = 21; /// Ariel (satellite of Uranus)
    public static final int _RDCOD_ATLAS_1988 = 22; /// Atlas (satellite of Saturn)
    public static final int _RDCOD_AUSTRALIAN_NATIONAL_1966 = 23; /// Australian national
    public static final int _RDCOD_AVERAGE_TERRESTRIAL_1977 = 24; /// Average terrestrial system
    public static final int _RDCOD_BELINDA_1988 = 25; /// Belinda (satellite of Uranus)
    public static final int _RDCOD_BESSEL_1841_ETHIOPIA = 26; /// Bessel (Ethiopia, Indonesia, Japan, and Korea)
    public static final int _RDCOD_BESSEL_1841_NAMIBIA = 27; /// Bessel (Namibia)
    public static final int _RDCOD_BIANCA_1988 = 28; /// Bianca (satellite of Uranus)
    public static final int _RDCOD_CALLISTO_2000 = 29; /// Callisto (satellite of Jupiter)
    public static final int _RDCOD_CALYPSO_1988 = 30; /// Calypso (satellite of Saturn)
    public static final int _RDCOD_CARME_1988 = 31; /// Carme (satellite of Jupiter)
    public static final int _RDCOD_CHARON_1991 = 32; /// Charon (satellite of Pluto)
    public static final int _RDCOD_CLARKE_1858 = 33; /// Clarke
    public static final int _RDCOD_CLARKE_1858_MODIFIED = 34; /// Clarke - modified
    public static final int _RDCOD_CLARKE_1866 = 35; /// Clarke
    public static final int _RDCOD_CLARKE_1880 = 36; /// Clarke
    public static final int _RDCOD_CLARKE_1880_CAPE = 37; /// Clarke - Cape
    public static final int _RDCOD_CLARKE_1880_FIJI = 38; /// Clarke - Fiji
    public static final int _RDCOD_CLARKE_1880_IGN = 39; /// Clarke - IGN
    public static final int _RDCOD_CLARKE_1880_PALESTINE = 40; /// Clarke - Palestine
    public static final int _RDCOD_CLARKE_1880_SYRIA = 41; /// Clarke - Syria
    public static final int _RDCOD_COAMPS_1998 = 42; /// Coupled Ocean/Atmospheric Mesoscale Prediction System (COAMPSTM)
    public static final int _RDCOD_CORDELIA_1988 = 43; /// Cordelia (satellite of Uranus)
    public static final int _RDCOD_CRESSIDA_1988 = 44; /// Cressida (satellite of Uranus)
    public static final int _RDCOD_DANISH_1876 = 45; /// Danish - Andrae
    public static final int _RDCOD_DEIMOS_1988 = 46; /// Deimos (satellite of Mars)
    public static final int _RDCOD_DELAMBRE_1810 = 47; /// Delambre
    public static final int _RDCOD_DESDEMONA_1988 = 48; /// Desdemona (satellite of Uranus)
    public static final int _RDCOD_DESPINA_1991 = 49; /// Despina (satellite of Neptune)
    public static final int _RDCOD_DIONE_1982 = 50; /// Dione (satellite of Saturn)
    public static final int _RDCOD_ELARA_1988 = 51; /// Elara (satellite of Jupiter)
    public static final int _RDCOD_ENCELADUS_1994 = 52; /// Enceladus (satellite of Saturn)
    public static final int _RDCOD_EPIMETHEUS_1988 = 53; /// Epimetheus (satellite of Saturn)
    public static final int _RDCOD_EROS_2000 = 54; /// Eros (asteroid 433, a minor planet)
    public static final int _RDCOD_EUROPA_2000 = 55; /// Europa (satellite of Jupiter)
    public static final int _RDCOD_EVEREST_ADJ_1937 = 56; /// Everest 1830 - adjusted
    public static final int _RDCOD_EVEREST_1948 = 57; /// Everest
    public static final int _RDCOD_EVEREST_1956 = 58; /// Everest
    public static final int _RDCOD_EVEREST_REVISED_1962 = 59; /// Everest 1830 - revised definition
    public static final int _RDCOD_EVEREST_1969 = 60; /// Everest
    public static final int _RDCOD_EVEREST_BRUNEI_1967 = 61; /// Everest 1830 - 1967 definition (Brunei and East Malaysia - Sabah and Sarawak)
    public static final int _RDCOD_FISCHER_1960 = 62; /// Fischer - Mercury
    public static final int _RDCOD_FISCHER_1968 = 63; /// Fischer
    public static final int _RDCOD_GALATEA_1991 = 64; /// Galatea (satellite of Neptune)
    public static final int _RDCOD_GANYMEDE_2000 = 65; /// Ganymede (satellite of Jupiter)
    public static final int _RDCOD_GASPRA_1991 = 66; /// Gaspra (asteroid 951, a minor planet)
    public static final int _RDCOD_GRS_1967 = 67; /// Geodetic Reference System (GRS)
    public static final int _RDCOD_GRS_1980 = 68; /// Geodetic Reference System (GRS)
    public static final int _RDCOD_HELENE_1992 = 69; /// Helene (satellite of Saturn)
    public static final int _RDCOD_HELMERT_1906 = 70; /// Helmert
    public static final int _RDCOD_HIMALIA_1988 = 71; /// Himalia (satellite of Jupiter)
    public static final int _RDCOD_HOUGH_1960 = 72; /// Hough
    public static final int _RDCOD_HYPERION_2000 = 73; /// Hyperion (satellite of Saturn)
    public static final int _RDCOD_IAG_1975 = 74; /// International Association of Geodesy (IAG) best estimate
    public static final int _RDCOD_IAPETUS_1988 = 75; /// Iapetus (satellite of Saturn)
    public static final int _RDCOD_IDA_1991 = 76; /// Ida (asteroid 293, a minor planet)
    public static final int _RDCOD_INDONESIAN_1974 = 77; /// Indonesian
    public static final int _RDCOD_INTERNATIONAL_1924 = 78; /// International
    public static final int _RDCOD_IO_2000 = 79; /// Io (satellite of Jupiter)
    public static final int _RDCOD_JANUS_1988 = 80; /// Janus (satellite of Saturn)
    public static final int _RDCOD_JULIET_1988 = 81; /// Juliet (satellite of Uranus)
    public static final int _RDCOD_JUPITER_1988 = 82; /// Jupiter
    public static final int _RDCOD_KLEOPATRA_2000 = 83; /// Kleopatra (asteroid 216, a minor planet)
    public static final int _RDCOD_KRASSOVSKY_1940 = 84; /// Krassovsky
    public static final int _RDCOD_KRAYENHOFF_1827 = 85; /// Krayenhoff
    public static final int _RDCOD_LARISSA_1991 = 86; /// Larissa (satellite of Neptune)
    public static final int _RDCOD_LEDA_1988 = 87; /// Leda (satellite of Jupiter)
    public static final int _RDCOD_LYSITHEA_1988 = 88; /// Lysithea (satellite of Jupiter)
    public static final int _RDCOD_MARS_2000 = 89; /// Mars
    public static final int _RDCOD_MARS_SPHERE_2000 = 90; /// Mars
    public static final int _RDCOD_MASS_1999 = 91; /// MASS
    public static final int _RDCOD_MERCURY_1988 = 92; /// Mercury
    public static final int _RDCOD_METIS_2000 = 93; /// Metis (satellite of Jupiter)
    public static final int _RDCOD_MIMAS_1994 = 94; /// Mimas (satellite of Saturn)
    public static final int _RDCOD_MIRANDA_1988 = 95; /// Miranda (satellite of Uranus)
    public static final int _RDCOD_MM5_1997 = 96; /// Mesoscale (weather) Model 5 (MM5), Air Force Weather Agency (AFWA), US
    public static final int _RDCOD_MODIFIED_AIRY_1849 = 97; /// Modified Airy
    public static final int _RDCOD_MODIFIED_FISCHER_1960 = 98; /// Modified Fischer
    public static final int _RDCOD_MODTRAN_MIDLATITUDE_1989 = 99; /// MODTRAN (midlatitude regions)
    public static final int _RDCOD_MODTRAN_SUBARCTIC_1989 = 100; /// MODTRAN (subarctic regions)
    public static final int _RDCOD_MODTRAN_TROPICAL_1989 = 101; /// MODTRAN (tropical regions)
    public static final int _RDCOD_MOON_1991 = 102; /// Moon (satellite of Earth)
    public static final int _RDCOD_MULTIGEN_FLAT_EARTH_1989 = 103; /// Multigen flat Earth
    public static final int _RDCOD_NAIAD_1991 = 104; /// Naiad (satellite of Neptune)
    public static final int _RDCOD_NEPTUNE_1991 = 105; /// Neptune
    public static final int _RDCOD_NEREID_1991 = 106; /// Nereid (satellite of Neptune)
    public static final int _RDCOD_NOGAPS_1988 = 107; /// Navy Operational Global Atmospheric Prediction System (NOGAPS), US
    public static final int _RDCOD_OBERON_1988 = 108; /// Oberon (satellite of Uranus)
    public static final int _RDCOD_OPHELIA_1988 = 109; /// Ophelia (satellite of Uranus)
    public static final int _RDCOD_PAN_1991 = 110; /// Pan (satellite of Saturn)
    public static final int _RDCOD_PANDORA_1988 = 111; /// Pandora (satellite of Saturn)
    public static final int _RDCOD_PASIPHAE_1988 = 112; /// Pasiphae (satellite of Jupiter)
    public static final int _RDCOD_PHOBOS_1988 = 113; /// Phobos (satellite of Mars)
    public static final int _RDCOD_PHOEBE_1988 = 114; /// Phoebe (satellite of Saturn)
    public static final int _RDCOD_PLESSIS_MODIFIED_1817 = 115; /// Plessis - Modified
    public static final int _RDCOD_PLUTO_1994 = 116; /// Pluto
    public static final int _RDCOD_PORTIA_1988 = 117; /// Portia (satellite of Uranus)
    public static final int _RDCOD_PROMETHEUS_1988 = 118; /// Prometheus (satellite of Saturn)
    public static final int _RDCOD_PROTEUS_1991 = 119; /// Proteus (satellite of Neptune)
    public static final int _RDCOD_PUCK_1988 = 120; /// Puck (satellite of Uranus)
    public static final int _RDCOD_RHEA_1988 = 121; /// Rhea (satellite of Saturn)
    public static final int _RDCOD_ROSALIND_1988 = 122; /// Rosalind (satellite of Uranus)
    public static final int _RDCOD_SATURN_1988 = 123; /// Saturn
    public static final int _RDCOD_SINOPE_1988 = 124; /// Sinope (satellite of Jupiter)
    public static final int _RDCOD_SOUTH_AMERICAN_1969 = 125; /// South american
    public static final int _RDCOD_SOVIET_GEODETIC_1985 = 126; /// Soviet geodetic system
    public static final int _RDCOD_SOVIET_GEODETIC_1990 = 127; /// Soviet geodetic system
    public static final int _RDCOD_STRUVE_1860 = 128; /// Struve
    public static final int _RDCOD_SUN_1992 = 129; /// Sun
    public static final int _RDCOD_TELESTO_1988 = 130; /// Telesto (satellite of Saturn)
    public static final int _RDCOD_TETHYS_1991 = 131; /// Tethys (satellite of Saturn)
    public static final int _RDCOD_THALASSA_1991 = 132; /// Thalassa (satellite of Neptune)
    public static final int _RDCOD_THEBE_2000 = 133; /// Thebe (satellite of Jupiter)
    public static final int _RDCOD_TITAN_1982 = 134; /// Titan (satellite of Saturn)
    public static final int _RDCOD_TITANIA_1988 = 135; /// Titania (satellite of Uranus)
    public static final int _RDCOD_TRITON_1991 = 136; /// Triton (satellite of Neptune)
    public static final int _RDCOD_UMBRIEL_1988 = 137; /// Umbriel (satellite of Uranus)
    public static final int _RDCOD_URANUS_1988 = 138; /// Uranus
    public static final int _RDCOD_VENUS_1991 = 139; /// Venus
    public static final int _RDCOD_WALBECK_AMS_1963 = 140; /// Walbeck 1819 - AMS
    public static final int _RDCOD_WALBECK_PLANHEFT_1942 = 141; /// Walbeck 1819 - Planheft
    public static final int _RDCOD_WAR_OFFICE_1924 = 142; /// War Office - McCaw
    public static final int _RDCOD_WGS_1960 = 143; /// World Geodetic System 1960
    public static final int _RDCOD_WGS_1966 = 144; /// World Geodetic System 1966
    public static final int _RDCOD_WGS_1984 = 145; /// World geodetic system
    public static final int _RDCOD_WGS_1972 = 146; /// World geodetic system
    public static final int _RDCOD_EXPERIMENTAL_NGA_SRM_MAX = -1000;
    public static final int _RDCOD_EXPERIMENTAL_NGA_SPHERE = -1001;

    public static final int _totalEnum = 146;

    private static Vector _enumVec = new Vector();

    private static HashMap _enumMap = new HashMap();

    public static final SRM_RD_Code RDCOD_UNSPECIFIED
        = new SRM_RD_Code(_RDCOD_UNSPECIFIED, "RDCOD_UNSPECIFIED");

    public static final SRM_RD_Code RDCOD_ORIGIN_2D
        = new SRM_RD_Code(_RDCOD_ORIGIN_2D, "RDCOD_ORIGIN_2D");
    public static final SRM_RD_Code RDCOD_X_UNIT_POINT_2D
        = new SRM_RD_Code(_RDCOD_X_UNIT_POINT_2D, "RDCOD_X_UNIT_POINT_2D");
    public static final SRM_RD_Code RDCOD_Y_UNIT_POINT_2D
        = new SRM_RD_Code(_RDCOD_Y_UNIT_POINT_2D, "RDCOD_Y_UNIT_POINT_2D");
    public static final SRM_RD_Code RDCOD_ORIGIN_3D
        = new SRM_RD_Code(_RDCOD_ORIGIN_3D, "RDCOD_ORIGIN_3D");
    public static final SRM_RD_Code RDCOD_X_UNIT_POINT_3D
        = new SRM_RD_Code(_RDCOD_X_UNIT_POINT_3D, "RDCOD_X_UNIT_POINT_3D");
    public static final SRM_RD_Code RDCOD_Y_UNIT_POINT_3D
        = new SRM_RD_Code(_RDCOD_Y_UNIT_POINT_3D, "RDCOD_Y_UNIT_POINT_3D");
    public static final SRM_RD_Code RDCOD_Z_UNIT_POINT_3D
        = new SRM_RD_Code(_RDCOD_Z_UNIT_POINT_3D, "RDCOD_Z_UNIT_POINT_3D");
    public static final SRM_RD_Code RDCOD_X_AXIS_2D
        = new SRM_RD_Code(_RDCOD_X_AXIS_2D, "RDCOD_X_AXIS_2D");
    public static final SRM_RD_Code RDCOD_Y_AXIS_2D
        = new SRM_RD_Code(_RDCOD_Y_AXIS_2D, "RDCOD_Y_AXIS_2D");
    public static final SRM_RD_Code RDCOD_X_AXIS_3D
        = new SRM_RD_Code(_RDCOD_X_AXIS_3D, "RDCOD_X_AXIS_3D");
    public static final SRM_RD_Code RDCOD_Y_AXIS_3D
        = new SRM_RD_Code(_RDCOD_Y_AXIS_3D, "RDCOD_Y_AXIS_3D");
    public static final SRM_RD_Code RDCOD_Z_AXIS_3D
        = new SRM_RD_Code(_RDCOD_Z_AXIS_3D, "RDCOD_Z_AXIS_3D");
    public static final SRM_RD_Code RDCOD_XY_PLANE_3D
        = new SRM_RD_Code(_RDCOD_XY_PLANE_3D, "RDCOD_XY_PLANE_3D");
    public static final SRM_RD_Code RDCOD_XZ_PLANE_3D
        = new SRM_RD_Code(_RDCOD_XZ_PLANE_3D, "RDCOD_XZ_PLANE_3D");
    public static final SRM_RD_Code RDCOD_YZ_PLANE_3D
        = new SRM_RD_Code(_RDCOD_YZ_PLANE_3D, "RDCOD_YZ_PLANE_3D");
    public static final SRM_RD_Code RDCOD_ADRASTEA_2000
        = new SRM_RD_Code(_RDCOD_ADRASTEA_2000, "RDCOD_ADRASTEA_2000");
    public static final SRM_RD_Code RDCOD_AIRY_1830
        = new SRM_RD_Code(_RDCOD_AIRY_1830, "RDCOD_AIRY_1830");
    public static final SRM_RD_Code RDCOD_AMALTHEA_2000
        = new SRM_RD_Code(_RDCOD_AMALTHEA_2000, "RDCOD_AMALTHEA_2000");
    public static final SRM_RD_Code RDCOD_ANANKE_1988
        = new SRM_RD_Code(_RDCOD_ANANKE_1988, "RDCOD_ANANKE_1988");
    public static final SRM_RD_Code RDCOD_APL_4r5_1968
        = new SRM_RD_Code(_RDCOD_APL_4r5_1968, "RDCOD_APL_4r5_1968");
    public static final SRM_RD_Code RDCOD_ARIEL_1988
        = new SRM_RD_Code(_RDCOD_ARIEL_1988, "RDCOD_ARIEL_1988");
    public static final SRM_RD_Code RDCOD_ATLAS_1988
        = new SRM_RD_Code(_RDCOD_ATLAS_1988, "RDCOD_ATLAS_1988");
    public static final SRM_RD_Code RDCOD_AUSTRALIAN_NATIONAL_1966
        = new SRM_RD_Code(_RDCOD_AUSTRALIAN_NATIONAL_1966, "RDCOD_AUSTRALIAN_NATIONAL_1966");
    public static final SRM_RD_Code RDCOD_AVERAGE_TERRESTRIAL_1977
        = new SRM_RD_Code(_RDCOD_AVERAGE_TERRESTRIAL_1977, "RDCOD_AVERAGE_TERRESTRIAL_1977");
    public static final SRM_RD_Code RDCOD_BELINDA_1988
        = new SRM_RD_Code(_RDCOD_BELINDA_1988, "RDCOD_BELINDA_1988");
    public static final SRM_RD_Code RDCOD_BESSEL_1841_ETHIOPIA
        = new SRM_RD_Code(_RDCOD_BESSEL_1841_ETHIOPIA, "RDCOD_BESSEL_1841_ETHIOPIA");
    public static final SRM_RD_Code RDCOD_BESSEL_1841_NAMIBIA
        = new SRM_RD_Code(_RDCOD_BESSEL_1841_NAMIBIA, "RDCOD_BESSEL_1841_NAMIBIA");
    public static final SRM_RD_Code RDCOD_BIANCA_1988
        = new SRM_RD_Code(_RDCOD_BIANCA_1988, "RDCOD_BIANCA_1988");
    public static final SRM_RD_Code RDCOD_CALLISTO_2000
        = new SRM_RD_Code(_RDCOD_CALLISTO_2000, "RDCOD_CALLISTO_2000");
    public static final SRM_RD_Code RDCOD_CALYPSO_1988
        = new SRM_RD_Code(_RDCOD_CALYPSO_1988, "RDCOD_CALYPSO_1988");
    public static final SRM_RD_Code RDCOD_CARME_1988
        = new SRM_RD_Code(_RDCOD_CARME_1988, "RDCOD_CARME_1988");
    public static final SRM_RD_Code RDCOD_CHARON_1991
        = new SRM_RD_Code(_RDCOD_CHARON_1991, "RDCOD_CHARON_1991");
    public static final SRM_RD_Code RDCOD_CLARKE_1858
        = new SRM_RD_Code(_RDCOD_CLARKE_1858, "RDCOD_CLARKE_1858");
    public static final SRM_RD_Code RDCOD_CLARKE_1858_MODIFIED
        = new SRM_RD_Code(_RDCOD_CLARKE_1858_MODIFIED, "RDCOD_CLARKE_1858_MODIFIED");
    public static final SRM_RD_Code RDCOD_CLARKE_1866
        = new SRM_RD_Code(_RDCOD_CLARKE_1866, "RDCOD_CLARKE_1866");
    public static final SRM_RD_Code RDCOD_CLARKE_1880
        = new SRM_RD_Code(_RDCOD_CLARKE_1880, "RDCOD_CLARKE_1880");
    public static final SRM_RD_Code RDCOD_CLARKE_1880_CAPE
        = new SRM_RD_Code(_RDCOD_CLARKE_1880_CAPE, "RDCOD_CLARKE_1880_CAPE");
    public static final SRM_RD_Code RDCOD_CLARKE_1880_FIJI
        = new SRM_RD_Code(_RDCOD_CLARKE_1880_FIJI, "RDCOD_CLARKE_1880_FIJI");
    public static final SRM_RD_Code RDCOD_CLARKE_1880_IGN
        = new SRM_RD_Code(_RDCOD_CLARKE_1880_IGN, "RDCOD_CLARKE_1880_IGN");
    public static final SRM_RD_Code RDCOD_CLARKE_1880_PALESTINE
        = new SRM_RD_Code(_RDCOD_CLARKE_1880_PALESTINE, "RDCOD_CLARKE_1880_PALESTINE");
    public static final SRM_RD_Code RDCOD_CLARKE_1880_SYRIA
        = new SRM_RD_Code(_RDCOD_CLARKE_1880_SYRIA, "RDCOD_CLARKE_1880_SYRIA");
    public static final SRM_RD_Code RDCOD_COAMPS_1998
        = new SRM_RD_Code(_RDCOD_COAMPS_1998, "RDCOD_COAMPS_1998");
    public static final SRM_RD_Code RDCOD_CORDELIA_1988
        = new SRM_RD_Code(_RDCOD_CORDELIA_1988, "RDCOD_CORDELIA_1988");
    public static final SRM_RD_Code RDCOD_CRESSIDA_1988
        = new SRM_RD_Code(_RDCOD_CRESSIDA_1988, "RDCOD_CRESSIDA_1988");
    public static final SRM_RD_Code RDCOD_DANISH_1876
        = new SRM_RD_Code(_RDCOD_DANISH_1876, "RDCOD_DANISH_1876");
    public static final SRM_RD_Code RDCOD_DEIMOS_1988
        = new SRM_RD_Code(_RDCOD_DEIMOS_1988, "RDCOD_DEIMOS_1988");
    public static final SRM_RD_Code RDCOD_DELAMBRE_1810
        = new SRM_RD_Code(_RDCOD_DELAMBRE_1810, "RDCOD_DELAMBRE_1810");
    public static final SRM_RD_Code RDCOD_DESDEMONA_1988
        = new SRM_RD_Code(_RDCOD_DESDEMONA_1988, "RDCOD_DESDEMONA_1988");
    public static final SRM_RD_Code RDCOD_DESPINA_1991
        = new SRM_RD_Code(_RDCOD_DESPINA_1991, "RDCOD_DESPINA_1991");
    public static final SRM_RD_Code RDCOD_DIONE_1982
        = new SRM_RD_Code(_RDCOD_DIONE_1982, "RDCOD_DIONE_1982");
    public static final SRM_RD_Code RDCOD_ELARA_1988
        = new SRM_RD_Code(_RDCOD_ELARA_1988, "RDCOD_ELARA_1988");
    public static final SRM_RD_Code RDCOD_ENCELADUS_1994
        = new SRM_RD_Code(_RDCOD_ENCELADUS_1994, "RDCOD_ENCELADUS_1994");
    public static final SRM_RD_Code RDCOD_EPIMETHEUS_1988
        = new SRM_RD_Code(_RDCOD_EPIMETHEUS_1988, "RDCOD_EPIMETHEUS_1988");
    public static final SRM_RD_Code RDCOD_EROS_2000
        = new SRM_RD_Code(_RDCOD_EROS_2000, "RDCOD_EROS_2000");
    public static final SRM_RD_Code RDCOD_EUROPA_2000
        = new SRM_RD_Code(_RDCOD_EUROPA_2000, "RDCOD_EUROPA_2000");
    public static final SRM_RD_Code RDCOD_EVEREST_ADJ_1937
        = new SRM_RD_Code(_RDCOD_EVEREST_ADJ_1937, "RDCOD_EVEREST_ADJ_1937");
    public static final SRM_RD_Code RDCOD_EVEREST_1948
        = new SRM_RD_Code(_RDCOD_EVEREST_1948, "RDCOD_EVEREST_1948");
    public static final SRM_RD_Code RDCOD_EVEREST_1956
        = new SRM_RD_Code(_RDCOD_EVEREST_1956, "RDCOD_EVEREST_1956");
    public static final SRM_RD_Code RDCOD_EVEREST_REVISED_1962
        = new SRM_RD_Code(_RDCOD_EVEREST_REVISED_1962, "RDCOD_EVEREST_REVISED_1962");
    public static final SRM_RD_Code RDCOD_EVEREST_1969
        = new SRM_RD_Code(_RDCOD_EVEREST_1969, "RDCOD_EVEREST_1969");
    public static final SRM_RD_Code RDCOD_EVEREST_BRUNEI_1967
        = new SRM_RD_Code(_RDCOD_EVEREST_BRUNEI_1967, "RDCOD_EVEREST_BRUNEI_1967");
    public static final SRM_RD_Code RDCOD_FISCHER_1960
        = new SRM_RD_Code(_RDCOD_FISCHER_1960, "RDCOD_FISCHER_1960");
    public static final SRM_RD_Code RDCOD_FISCHER_1968
        = new SRM_RD_Code(_RDCOD_FISCHER_1968, "RDCOD_FISCHER_1968");
    public static final SRM_RD_Code RDCOD_GALATEA_1991
        = new SRM_RD_Code(_RDCOD_GALATEA_1991, "RDCOD_GALATEA_1991");
    public static final SRM_RD_Code RDCOD_GANYMEDE_2000
        = new SRM_RD_Code(_RDCOD_GANYMEDE_2000, "RDCOD_GANYMEDE_2000");
    public static final SRM_RD_Code RDCOD_GASPRA_1991
        = new SRM_RD_Code(_RDCOD_GASPRA_1991, "RDCOD_GASPRA_1991");
    public static final SRM_RD_Code RDCOD_GRS_1967
        = new SRM_RD_Code(_RDCOD_GRS_1967, "RDCOD_GRS_1967");
    public static final SRM_RD_Code RDCOD_GRS_1980
        = new SRM_RD_Code(_RDCOD_GRS_1980, "RDCOD_GRS_1980");
    public static final SRM_RD_Code RDCOD_HELENE_1992
        = new SRM_RD_Code(_RDCOD_HELENE_1992, "RDCOD_HELENE_1992");
    public static final SRM_RD_Code RDCOD_HELMERT_1906
        = new SRM_RD_Code(_RDCOD_HELMERT_1906, "RDCOD_HELMERT_1906");
    public static final SRM_RD_Code RDCOD_HIMALIA_1988
        = new SRM_RD_Code(_RDCOD_HIMALIA_1988, "RDCOD_HIMALIA_1988");
    public static final SRM_RD_Code RDCOD_HOUGH_1960
        = new SRM_RD_Code(_RDCOD_HOUGH_1960, "RDCOD_HOUGH_1960");
    public static final SRM_RD_Code RDCOD_HYPERION_2000
        = new SRM_RD_Code(_RDCOD_HYPERION_2000, "RDCOD_HYPERION_2000");
    public static final SRM_RD_Code RDCOD_IAG_1975
        = new SRM_RD_Code(_RDCOD_IAG_1975, "RDCOD_IAG_1975");
    public static final SRM_RD_Code RDCOD_IAPETUS_1988
        = new SRM_RD_Code(_RDCOD_IAPETUS_1988, "RDCOD_IAPETUS_1988");
    public static final SRM_RD_Code RDCOD_IDA_1991
        = new SRM_RD_Code(_RDCOD_IDA_1991, "RDCOD_IDA_1991");
    public static final SRM_RD_Code RDCOD_INDONESIAN_1974
        = new SRM_RD_Code(_RDCOD_INDONESIAN_1974, "RDCOD_INDONESIAN_1974");
    public static final SRM_RD_Code RDCOD_INTERNATIONAL_1924
        = new SRM_RD_Code(_RDCOD_INTERNATIONAL_1924, "RDCOD_INTERNATIONAL_1924");
    public static final SRM_RD_Code RDCOD_IO_2000
        = new SRM_RD_Code(_RDCOD_IO_2000, "RDCOD_IO_2000");
    public static final SRM_RD_Code RDCOD_JANUS_1988
        = new SRM_RD_Code(_RDCOD_JANUS_1988, "RDCOD_JANUS_1988");
    public static final SRM_RD_Code RDCOD_JULIET_1988
        = new SRM_RD_Code(_RDCOD_JULIET_1988, "RDCOD_JULIET_1988");
    public static final SRM_RD_Code RDCOD_JUPITER_1988
        = new SRM_RD_Code(_RDCOD_JUPITER_1988, "RDCOD_JUPITER_1988");
    public static final SRM_RD_Code RDCOD_KLEOPATRA_2000
        = new SRM_RD_Code(_RDCOD_KLEOPATRA_2000, "RDCOD_KLEOPATRA_2000");
    public static final SRM_RD_Code RDCOD_KRASSOVSKY_1940
        = new SRM_RD_Code(_RDCOD_KRASSOVSKY_1940, "RDCOD_KRASSOVSKY_1940");
    public static final SRM_RD_Code RDCOD_KRAYENHOFF_1827
        = new SRM_RD_Code(_RDCOD_KRAYENHOFF_1827, "RDCOD_KRAYENHOFF_1827");
    public static final SRM_RD_Code RDCOD_LARISSA_1991
        = new SRM_RD_Code(_RDCOD_LARISSA_1991, "RDCOD_LARISSA_1991");
    public static final SRM_RD_Code RDCOD_LEDA_1988
        = new SRM_RD_Code(_RDCOD_LEDA_1988, "RDCOD_LEDA_1988");
    public static final SRM_RD_Code RDCOD_LYSITHEA_1988
        = new SRM_RD_Code(_RDCOD_LYSITHEA_1988, "RDCOD_LYSITHEA_1988");
    public static final SRM_RD_Code RDCOD_MARS_2000
        = new SRM_RD_Code(_RDCOD_MARS_2000, "RDCOD_MARS_2000");
    public static final SRM_RD_Code RDCOD_MARS_SPHERE_2000
        = new SRM_RD_Code(_RDCOD_MARS_SPHERE_2000, "RDCOD_MARS_SPHERE_2000");
    public static final SRM_RD_Code RDCOD_MASS_1999
        = new SRM_RD_Code(_RDCOD_MASS_1999, "RDCOD_MASS_1999");
    public static final SRM_RD_Code RDCOD_MERCURY_1988
        = new SRM_RD_Code(_RDCOD_MERCURY_1988, "RDCOD_MERCURY_1988");
    public static final SRM_RD_Code RDCOD_METIS_2000
        = new SRM_RD_Code(_RDCOD_METIS_2000, "RDCOD_METIS_2000");
    public static final SRM_RD_Code RDCOD_MIMAS_1994
        = new SRM_RD_Code(_RDCOD_MIMAS_1994, "RDCOD_MIMAS_1994");
    public static final SRM_RD_Code RDCOD_MIRANDA_1988
        = new SRM_RD_Code(_RDCOD_MIRANDA_1988, "RDCOD_MIRANDA_1988");
    public static final SRM_RD_Code RDCOD_MM5_1997
        = new SRM_RD_Code(_RDCOD_MM5_1997, "RDCOD_MM5_1997");
    public static final SRM_RD_Code RDCOD_MODIFIED_AIRY_1849
        = new SRM_RD_Code(_RDCOD_MODIFIED_AIRY_1849, "RDCOD_MODIFIED_AIRY_1849");
    public static final SRM_RD_Code RDCOD_MODIFIED_FISCHER_1960
        = new SRM_RD_Code(_RDCOD_MODIFIED_FISCHER_1960, "RDCOD_MODIFIED_FISCHER_1960");
    public static final SRM_RD_Code RDCOD_MODTRAN_MIDLATITUDE_1989
        = new SRM_RD_Code(_RDCOD_MODTRAN_MIDLATITUDE_1989, "RDCOD_MODTRAN_MIDLATITUDE_1989");
    public static final SRM_RD_Code RDCOD_MODTRAN_SUBARCTIC_1989
        = new SRM_RD_Code(_RDCOD_MODTRAN_SUBARCTIC_1989, "RDCOD_MODTRAN_SUBARCTIC_1989");
    public static final SRM_RD_Code RDCOD_MODTRAN_TROPICAL_1989
        = new SRM_RD_Code(_RDCOD_MODTRAN_TROPICAL_1989, "RDCOD_MODTRAN_TROPICAL_1989");
    public static final SRM_RD_Code RDCOD_MOON_1991
        = new SRM_RD_Code(_RDCOD_MOON_1991, "RDCOD_MOON_1991");
    public static final SRM_RD_Code RDCOD_MULTIGEN_FLAT_EARTH_1989
        = new SRM_RD_Code(_RDCOD_MULTIGEN_FLAT_EARTH_1989, "RDCOD_MULTIGEN_FLAT_EARTH_1989");
    public static final SRM_RD_Code RDCOD_NAIAD_1991
        = new SRM_RD_Code(_RDCOD_NAIAD_1991, "RDCOD_NAIAD_1991");
    public static final SRM_RD_Code RDCOD_NEPTUNE_1991
        = new SRM_RD_Code(_RDCOD_NEPTUNE_1991, "RDCOD_NEPTUNE_1991");
    public static final SRM_RD_Code RDCOD_NEREID_1991
        = new SRM_RD_Code(_RDCOD_NEREID_1991, "RDCOD_NEREID_1991");
    public static final SRM_RD_Code RDCOD_NOGAPS_1988
        = new SRM_RD_Code(_RDCOD_NOGAPS_1988, "RDCOD_NOGAPS_1988");
    public static final SRM_RD_Code RDCOD_OBERON_1988
        = new SRM_RD_Code(_RDCOD_OBERON_1988, "RDCOD_OBERON_1988");
    public static final SRM_RD_Code RDCOD_OPHELIA_1988
        = new SRM_RD_Code(_RDCOD_OPHELIA_1988, "RDCOD_OPHELIA_1988");
    public static final SRM_RD_Code RDCOD_PAN_1991
        = new SRM_RD_Code(_RDCOD_PAN_1991, "RDCOD_PAN_1991");
    public static final SRM_RD_Code RDCOD_PANDORA_1988
        = new SRM_RD_Code(_RDCOD_PANDORA_1988, "RDCOD_PANDORA_1988");
    public static final SRM_RD_Code RDCOD_PASIPHAE_1988
        = new SRM_RD_Code(_RDCOD_PASIPHAE_1988, "RDCOD_PASIPHAE_1988");
    public static final SRM_RD_Code RDCOD_PHOBOS_1988
        = new SRM_RD_Code(_RDCOD_PHOBOS_1988, "RDCOD_PHOBOS_1988");
    public static final SRM_RD_Code RDCOD_PHOEBE_1988
        = new SRM_RD_Code(_RDCOD_PHOEBE_1988, "RDCOD_PHOEBE_1988");
    public static final SRM_RD_Code RDCOD_PLESSIS_MODIFIED_1817
        = new SRM_RD_Code(_RDCOD_PLESSIS_MODIFIED_1817, "RDCOD_PLESSIS_MODIFIED_1817");
    public static final SRM_RD_Code RDCOD_PLUTO_1994
        = new SRM_RD_Code(_RDCOD_PLUTO_1994, "RDCOD_PLUTO_1994");
    public static final SRM_RD_Code RDCOD_PORTIA_1988
        = new SRM_RD_Code(_RDCOD_PORTIA_1988, "RDCOD_PORTIA_1988");
    public static final SRM_RD_Code RDCOD_PROMETHEUS_1988
        = new SRM_RD_Code(_RDCOD_PROMETHEUS_1988, "RDCOD_PROMETHEUS_1988");
    public static final SRM_RD_Code RDCOD_PROTEUS_1991
        = new SRM_RD_Code(_RDCOD_PROTEUS_1991, "RDCOD_PROTEUS_1991");
    public static final SRM_RD_Code RDCOD_PUCK_1988
        = new SRM_RD_Code(_RDCOD_PUCK_1988, "RDCOD_PUCK_1988");
    public static final SRM_RD_Code RDCOD_RHEA_1988
        = new SRM_RD_Code(_RDCOD_RHEA_1988, "RDCOD_RHEA_1988");
    public static final SRM_RD_Code RDCOD_ROSALIND_1988
        = new SRM_RD_Code(_RDCOD_ROSALIND_1988, "RDCOD_ROSALIND_1988");
    public static final SRM_RD_Code RDCOD_SATURN_1988
        = new SRM_RD_Code(_RDCOD_SATURN_1988, "RDCOD_SATURN_1988");
    public static final SRM_RD_Code RDCOD_SINOPE_1988
        = new SRM_RD_Code(_RDCOD_SINOPE_1988, "RDCOD_SINOPE_1988");
    public static final SRM_RD_Code RDCOD_SOUTH_AMERICAN_1969
        = new SRM_RD_Code(_RDCOD_SOUTH_AMERICAN_1969, "RDCOD_SOUTH_AMERICAN_1969");
    public static final SRM_RD_Code RDCOD_SOVIET_GEODETIC_1985
        = new SRM_RD_Code(_RDCOD_SOVIET_GEODETIC_1985, "RDCOD_SOVIET_GEODETIC_1985");
    public static final SRM_RD_Code RDCOD_SOVIET_GEODETIC_1990
        = new SRM_RD_Code(_RDCOD_SOVIET_GEODETIC_1990, "RDCOD_SOVIET_GEODETIC_1990");
    public static final SRM_RD_Code RDCOD_STRUVE_1860
        = new SRM_RD_Code(_RDCOD_STRUVE_1860, "RDCOD_STRUVE_1860");
    public static final SRM_RD_Code RDCOD_SUN_1992
        = new SRM_RD_Code(_RDCOD_SUN_1992, "RDCOD_SUN_1992");
    public static final SRM_RD_Code RDCOD_TELESTO_1988
        = new SRM_RD_Code(_RDCOD_TELESTO_1988, "RDCOD_TELESTO_1988");
    public static final SRM_RD_Code RDCOD_TETHYS_1991
        = new SRM_RD_Code(_RDCOD_TETHYS_1991, "RDCOD_TETHYS_1991");
    public static final SRM_RD_Code RDCOD_THALASSA_1991
        = new SRM_RD_Code(_RDCOD_THALASSA_1991, "RDCOD_THALASSA_1991");
    public static final SRM_RD_Code RDCOD_THEBE_2000
        = new SRM_RD_Code(_RDCOD_THEBE_2000, "RDCOD_THEBE_2000");
    public static final SRM_RD_Code RDCOD_TITAN_1982
        = new SRM_RD_Code(_RDCOD_TITAN_1982, "RDCOD_TITAN_1982");
    public static final SRM_RD_Code RDCOD_TITANIA_1988
        = new SRM_RD_Code(_RDCOD_TITANIA_1988, "RDCOD_TITANIA_1988");
    public static final SRM_RD_Code RDCOD_TRITON_1991
        = new SRM_RD_Code(_RDCOD_TRITON_1991, "RDCOD_TRITON_1991");
    public static final SRM_RD_Code RDCOD_UMBRIEL_1988
        = new SRM_RD_Code(_RDCOD_UMBRIEL_1988, "RDCOD_UMBRIEL_1988");
    public static final SRM_RD_Code RDCOD_URANUS_1988
        = new SRM_RD_Code(_RDCOD_URANUS_1988, "RDCOD_URANUS_1988");
    public static final SRM_RD_Code RDCOD_VENUS_1991
        = new SRM_RD_Code(_RDCOD_VENUS_1991, "RDCOD_VENUS_1991");
    public static final SRM_RD_Code RDCOD_WALBECK_AMS_1963
        = new SRM_RD_Code(_RDCOD_WALBECK_AMS_1963, "RDCOD_WALBECK_AMS_1963");
    public static final SRM_RD_Code RDCOD_WALBECK_PLANHEFT_1942
        = new SRM_RD_Code(_RDCOD_WALBECK_PLANHEFT_1942, "RDCOD_WALBECK_PLANHEFT_1942");
    public static final SRM_RD_Code RDCOD_WAR_OFFICE_1924
        = new SRM_RD_Code(_RDCOD_WAR_OFFICE_1924, "RDCOD_WAR_OFFICE_1924");
    public static final SRM_RD_Code RDCOD_WGS_1960
        = new SRM_RD_Code(_RDCOD_WGS_1960, "RDCOD_WGS_1960");
    public static final SRM_RD_Code RDCOD_WGS_1966
        = new SRM_RD_Code(_RDCOD_WGS_1966, "RDCOD_WGS_1966");
    public static final SRM_RD_Code RDCOD_WGS_1984
        = new SRM_RD_Code(_RDCOD_WGS_1984, "RDCOD_WGS_1984");
    public static final SRM_RD_Code RDCOD_WGS_1972
        = new SRM_RD_Code(_RDCOD_WGS_1972, "RDCOD_WGS_1972");
    public static final SRM_RD_Code RDCOD_EXPERIMENTAL_NGA_SRM_MAX
        = new SRM_RD_Code(_RDCOD_EXPERIMENTAL_NGA_SRM_MAX, "RDCOD_EXPERIMENTAL_NGA_SRM_MAX");
    public static final SRM_RD_Code RDCOD_EXPERIMENTAL_NGA_SPHERE
        = new SRM_RD_Code(_RDCOD_EXPERIMENTAL_NGA_SPHERE, "RDCOD_EXPERIMENTAL_NGA_SPHERE");

    private SRM_RD_Code(int code, String name)
    {
        super (code, name);
        _enumMap.put(name, this);
        if (code >= 0 && code <= _totalEnum)
        {
            _enumVec.add(code, this);
        }
        else if (code == _RDCOD_EXPERIMENTAL_NGA_SRM_MAX)
        {
            _enumVec.add(_totalEnum+1, this);
        }
        else if (code == _RDCOD_EXPERIMENTAL_NGA_SPHERE)
        {
            _enumVec.add(_totalEnum+2, this);
        }
    }

    /** returns the SRM_RD_Code from its enumerant value
     */
    public static SRM_RD_Code getEnum(int item) throws SrmException
    {
        if (item >= 0 && item <= _totalEnum)
            return (SRM_RD_Code)(_enumVec.elementAt(item));
        else if (item == _RDCOD_EXPERIMENTAL_NGA_SRM_MAX)
            return (SRM_RD_Code)(_enumVec.elementAt(_totalEnum+1));
        else if (item == _RDCOD_EXPERIMENTAL_NGA_SPHERE)
            return (SRM_RD_Code)(_enumVec.elementAt(_totalEnum+2));
        else
            throw new SrmException(SrmException._INVALID_INPUT,
                        new String("SRM_RD_Code.getEnum: enumerant out of range"));
    }

    /** returns the SRM_RD_Code from its string name
     */
    public static SRM_RD_Code getEnum(String name) throws SrmException
    {
        SRM_RD_Code retCode = (SRM_RD_Code)_enumMap.get(name);

        if (retCode == null)
            throw new SrmException(SrmException._INVALID_INPUT,
                        new String("SRM_RD_Code.getEnum: enum. string not found"));

        return retCode;
    }
}
