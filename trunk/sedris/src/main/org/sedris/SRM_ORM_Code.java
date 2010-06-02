/**
@author David Shen
@brief SRM ORM code enumeration according to the SRM spec.
*/
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

public class SRM_ORM_Code extends Enum
{
    public static final int _totalEnum = 252;

    private static Vector  _enumVec = new Vector();
    private static HashMap _enumMap = new HashMap();

    /// Undefined
    public static final int _ORM_UNDEFINED = 0;
    /// 2D modelling space
    public static final int _ORM_ABSTRACT_2D = 1;
    /// 3D modelling space
    public static final int _ORM_ABSTRACT_3D = 2;
    /// Adindan
    public static final int _ORM_ADINDAN_1991 = 3;
    /// Adrastea
    public static final int _ORM_ADRASTEA_2000 = 4;
    /// Afgooye (Somalia)
    public static final int _ORM_AFGOOYE_1987 = 5;
    /// Ain el Abd
    public static final int _ORM_AIN_EL_ABD_1970 = 6;
    /// Amalthea
    public static final int _ORM_AMALTHEA_2000 = 7;
    /// American Samoa
    public static final int _ORM_AMERICAN_SAMOA_1962 = 8;
    /// Anna 1 (astronomic)
    public static final int _ORM_ANNA_1_1965 = 9;
    /// Antigua (astronomic)
    public static final int _ORM_ANTIGUA_1943 = 10;
    /// Arc
    public static final int _ORM_ARC_1950 = 11;
    /// Arc
    public static final int _ORM_ARC_1960 = 12;
    /// Ariel
    public static final int _ORM_ARIEL_1988 = 13;
    /// Ascension
    public static final int _ORM_ASCENSION_1958 = 14;
    /// Atlas
    public static final int _ORM_ATLAS_1988 = 15;
    /// Australian Geodetic
    public static final int _ORM_AUSTRALIAN_GEOD_1966 = 16;
    /// Australian Geodetic
    public static final int _ORM_AUSTRALIAN_GEOD_1984 = 17;
    /// Ayabelle Lighthouse (Djibouti)
    public static final int _ORM_AYABELLE_LIGHTHOUSE_1991 = 18;
    /// Beacon E (Iwo-jima; astronomic)
    public static final int _ORM_BEACON_E_1945 = 19;
    /// Belinda
    public static final int _ORM_BELINDA_1988 = 20;
    /// Bellevue (IGN)
    public static final int _ORM_BELLEVUE_IGN_1987 = 21;
    /// Bermuda
    public static final int _ORM_BERMUDA_1957 = 22;
    /// Bianca
    public static final int _ORM_BIANCA_1988 = 23;
    /// Bissau
    public static final int _ORM_BISSAU_1991 = 24;
    /// Bogota Observatory
    public static final int _ORM_BOGOTA_OBS_1987 = 25;
    /// Bogota Observatory (with the Prime Meridian at Bogota)
    public static final int _ORM_BOGOTA_OBS_1987_PM_BOGOTA = 26;
    /// Bukit Rimpah
    public static final int _ORM_BUKIT_RIMPAH_1987 = 27;
    /// Callisto
    public static final int _ORM_CALLISTO_2000 = 28;
    /// Calypso
    public static final int _ORM_CALYPSO_1988 = 29;
    /// Camp Area (astronomic)
    public static final int _ORM_CAMP_AREA_1987 = 30;
    /// Campo Inchauspe
    public static final int _ORM_CAMPO_INCHAUSPE_1969 = 31;
    /// Canton (astronomic)
    public static final int _ORM_CANTON_1966 = 32;
    /// Cape
    public static final int _ORM_CAPE_1987 = 33;
    /// Cape Canaveral
    public static final int _ORM_CAPE_CANAVERAL_1991 = 34;
    /// Carthage
    public static final int _ORM_CARTHAGE_1987 = 35;
    /// Charon
    public static final int _ORM_CHARON_1991 = 36;
    /// Chatam (astronomic)
    public static final int _ORM_CHATHAM_1971 = 37;
    /// Chua (astronomic)
    public static final int _ORM_CHUA_1987 = 38;
    /// COAMPS^(TM)
    public static final int _ORM_COAMPS_1998 = 39;
    /// Cordelia
    public static final int _ORM_CORDELIA_1988 = 40;
    /// Corrego Alegre
    public static final int _ORM_CORREGO_ALEGRE_1987 = 41;
    /// Cressida
    public static final int _ORM_CRESSIDA_1988 = 42;
    /// Dabola
    public static final int _ORM_DABOLA_1991 = 43;
    /// Deception
    public static final int _ORM_DECEPTION_1993 = 44;
    /// Deimos
    public static final int _ORM_DEIMOS_1988 = 45;
    /// Desdemona
    public static final int _ORM_DESDEMONA_1988 = 46;
    /// Despina
    public static final int _ORM_DESPINA_1991 = 47;
    /// Dione
    public static final int _ORM_DIONE_1982 = 48;
    /// Djakarta (also known as Batavia)
    public static final int _ORM_DJAKARTA_1987 = 49;
    /// Djakarta (also known as Batavia; with the Prime Meridian at Djakarta)
    public static final int _ORM_DJAKARTA_1987_PM_DJAKARTA = 50;
    /// DOS
    public static final int _ORM_DOS_1968 = 51;
    /// DOS 71/4 (St. Helena Island; astronomic)
    public static final int _ORM_DOS_71_4_1987 = 52;
    /// Earth equatorial inertial, Aries mean of 1950
    public static final int _ORM_EARTH_INERTIAL_ARIES_1950 = 53;
    /// Earth equatorial inertial, Aries true of date
    public static final int _ORM_EARTH_INERTIAL_ARIES_TRUE_OF_DATE = 54;
    /// Earth equatorial inertial, J2000.0
    public static final int _ORM_EARTH_INERTIAL_J2000r0 = 55;
    /// Solar ecliptic
    public static final int _ORM_EARTH_SOLAR_ECLIPTIC = 56;
    /// Solar equatorial
    public static final int _ORM_EARTH_SOLAR_EQUATORIAL = 57;
    /// Solar magnetic dipole
    public static final int _ORM_EARTH_SOLAR_MAG_DIPOLE = 58;
    /// Solar magnetospheric
    public static final int _ORM_EARTH_SOLAR_MAGNETOSPHERIC = 59;
    /// Easter
    public static final int _ORM_EASTER_1967 = 60;
    /// Enceladus
    public static final int _ORM_ENCELADUS_1994 = 61;
    /// Epimetheus
    public static final int _ORM_EPIMETHEUS_1988 = 62;
    /// Eros (asteroid 433)
    public static final int _ORM_EROS_2000 = 63;
    /// Estonia
    public static final int _ORM_ESTONIA_1937 = 64;
    /// ETRS
    public static final int _ORM_ETRS_1989 = 65;
    /// Europa
    public static final int _ORM_EUROPA_2000 = 66;
    /// European
    public static final int _ORM_EUROPE_1950 = 67;
    /// European
    public static final int _ORM_EUROPE_1979 = 68;
    /// Fahud
    public static final int _ORM_FAHUD_1987 = 69;
    /// Fort Thomas
    public static final int _ORM_FORT_THOMAS_1955 = 70;
    /// Galatea
    public static final int _ORM_GALATEA_1991 = 71;
    /// Gan
    public static final int _ORM_GAN_1970 = 72;
    /// Ganymede
    public static final int _ORM_GANYMEDE_2000 = 73;
    /// Gaspra (asteroid 951)
    public static final int _ORM_GASPRA_1991 = 74;
    /// GDA
    public static final int _ORM_GDA_1994 = 75;
    /// Geodetic Datum
    public static final int _ORM_GEODETIC_DATUM_1949 = 76;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1945 = 77;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1950 = 78;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1955 = 79;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1960 = 80;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1965 = 81;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1970 = 82;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1975 = 83;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1980 = 84;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1985 = 85;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1990 = 86;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_1995 = 87;
    /// Geomagnetic
    public static final int _ORM_GEOMAGNETIC_2000 = 88;
    /// Graciosa Base SW
    public static final int _ORM_GRACIOSA_BASE_SW_1948 = 89;
    /// Guam
    public static final int _ORM_GUAM_1963 = 90;
    /// Gunung Segara
    public static final int _ORM_GUNONG_SEGARA_1987 = 91;
    /// GUX1 (astronomic)
    public static final int _ORM_GUX_1_1987 = 92;
    /// Helene
    public static final int _ORM_HELENE_1992 = 93;
    /// Heliocentric Aries ecliptic, J2000.0
    public static final int _ORM_HELIO_ARIES_ECLIPTIC_J2000r0 = 94;
    /// Heliocentric Aries ecliptic, true of date
    public static final int _ORM_HELIO_ARIES_ECLIPTIC_TRUE_OF_DATE = 95;
    /// Heliocentric Earth ecliptic
    public static final int _ORM_HELIO_EARTH_ECLIPTIC = 96;
    /// Heliocentric Earth equatorial
    public static final int _ORM_HELIO_EARTH_EQUATORIAL = 97;
    /// Herat North
    public static final int _ORM_HERAT_NORTH_1987 = 98;
    /// Hermannskogel
    public static final int _ORM_HERMANNSKOGEL_1871 = 99;
    /// Hjorsey
    public static final int _ORM_HJORSEY_1955 = 100;
    /// Hong Kong
    public static final int _ORM_HONG_KONG_1963 = 101;
    /// Hu-Tzu-Shan
    public static final int _ORM_HU_TZU_SHAN_1991 = 102;
    /// Iapetus
    public static final int _ORM_IAPETUS_1988 = 103;
    /// Ida (asteroid 243)
    public static final int _ORM_IDA_1991 = 104;
    /// Indian
    public static final int _ORM_INDIAN_1916 = 105;
    /// Indian
    public static final int _ORM_INDIAN_1954 = 106;
    /// Indian
    public static final int _ORM_INDIAN_1956 = 107;
    /// Indian
    public static final int _ORM_INDIAN_1960 = 108;
    /// Indian
    public static final int _ORM_INDIAN_1962 = 109;
    /// Indian
    public static final int _ORM_INDIAN_1975 = 110;
    /// Indonesian
    public static final int _ORM_INDONESIAN_1974 = 111;
    /// Io
    public static final int _ORM_IO_2000 = 112;
    /// Ireland 1965
    public static final int _ORM_IRELAND_1965 = 113;
    /// International Satellite Triangulation Station (ISTS) 061 (astronomic)
    public static final int _ORM_ISTS_061_1968 = 114;
    /// International Satellite Triangulation Station (ISTS) 073 (astronomic)
    public static final int _ORM_ISTS_073_1969 = 115;
    /// Janus
    public static final int _ORM_JANUS_1988 = 116;
    /// Japanese Geodetic Datum 2000 (JGD2000)
    public static final int _ORM_JGD_2000 = 117;
    /// Johnston
    public static final int _ORM_JOHNSTON_1961 = 118;
    /// Juliet
    public static final int _ORM_JULIET_1988 = 119;
    /// Jupiter
    public static final int _ORM_JUPITER_1988 = 120;
    /// Jupiter equatorial inertial
    public static final int _ORM_JUPITER_INERTIAL = 121;
    /// Jupiter magnetic
    public static final int _ORM_JUPITER_MAGNETIC_1993 = 122;
    /// Jupiter solar ecliptic
    public static final int _ORM_JUPITER_SOLAR_ECLIPTIC = 123;
    /// Jupiter solar equatorial
    public static final int _ORM_JUPITER_SOLAR_EQUATORIAL = 124;
    /// Jupiter solar magnetic dipole
    public static final int _ORM_JUPITER_SOLAR_MAG_DIPOLE = 125;
    /// Jupiter solar magnetic ecliptic
    public static final int _ORM_JUPITER_SOLAR_MAG_ECLIPTIC = 126;
    /// Kandawala
    public static final int _ORM_KANDAWALA_1987 = 127;
    /// Kerguelen
    public static final int _ORM_KERGUELEN_1949 = 128;
    /// Kertau
    public static final int _ORM_KERTAU_1948 = 129;
    /// Korean Geodetic System
    public static final int _ORM_KOREAN_GEODETIC_1995 = 130;
    /// Kusaie 1951 (astronomic)
    public static final int _ORM_KUSAIE_1951 = 131;
    /// Larissa
    public static final int _ORM_LARISSA_1991 = 132;
    /// LC5 (astronomic)
    public static final int _ORM_LC5_1961 = 133;
    /// Leigon
    public static final int _ORM_LEIGON_1991 = 134;
    /// Liberia
    public static final int _ORM_LIBERIA_1964 = 135;
    /// Luzon
    public static final int _ORM_LUZON_1987 = 136;
    /// M'Poraloko
    public static final int _ORM_M_PORALOKO_1991 = 137;
    /// Mahe
    public static final int _ORM_MAHE_1971 = 138;
    /// Marcus Station (astronomic)
    public static final int _ORM_MARCUS_STATION_1952 = 139;
    /// Mars
    public static final int _ORM_MARS_2000 = 140;
    /// Mars equatorial inertial
    public static final int _ORM_MARS_INERTIAL = 141;
    /// Mars (spherical)
    public static final int _ORM_MARS_SPHERE_2000 = 142;
    /// MASS
    public static final int _ORM_MASS_1999 = 143;
    /// Massawa
    public static final int _ORM_MASSAWA_1987 = 144;
    /// Merchich
    public static final int _ORM_MERCHICH_1987 = 145;
    /// Mercury
    public static final int _ORM_MERCURY_1988 = 146;
    /// Mercury equatorial inertial
    public static final int _ORM_MERCURY_INERTIAL = 147;
    /// Metis
    public static final int _ORM_METIS_2000 = 148;
    /// Midway 1961 (astronomic)
    public static final int _ORM_MIDWAY_1961 = 149;
    /// Mimas
    public static final int _ORM_MIMAS_1994 = 150;
    /// Minna
    public static final int _ORM_MINNA_1991 = 151;
    /// Miranda
    public static final int _ORM_MIRANDA_1988 = 152;
    /// MM5 (AFWA)
    public static final int _ORM_MM5_1997 = 153;
    /// MODTRAN
    public static final int _ORM_MODTRAN_MIDLATITUDE_N_1989 = 154;
    /// MODTRAN
    public static final int _ORM_MODTRAN_MIDLATITUDE_S_1989 = 155;
    /// MODTRAN
    public static final int _ORM_MODTRAN_SUBARCTIC_N_1989 = 156;
    /// MODTRAN
    public static final int _ORM_MODTRAN_SUBARCTIC_S_1989 = 157;
    /// MODTRAN
    public static final int _ORM_MODTRAN_TROPICAL_1989 = 158;
    /// Montserrat (astronomic)
    public static final int _ORM_MONTSERRAT_1958 = 159;
    /// Moon
    public static final int _ORM_MOON_1991 = 160;
    /// Multigen flat Earth
    public static final int _ORM_MULTIGEN_FLAT_EARTH_1989 = 161;
    /// North American
    public static final int _ORM_N_AM_1927 = 162;
    /// North American
    public static final int _ORM_N_AM_1983 = 163;
    /// North Sahara
    public static final int _ORM_N_SAHARA_1959 = 164;
    /// Nahrwan
    public static final int _ORM_NAHRWAN_1987 = 165;
    /// Naiad
    public static final int _ORM_NAIAD_1991 = 166;
    /// Naparima BWI
    public static final int _ORM_NAPARIMA_1991 = 167;
    /// Neptune
    public static final int _ORM_NEPTUNE_1991 = 168;
    /// Neptune equatorial inertial
    public static final int _ORM_NEPTUNE_INERTIAL = 169;
    /// Neptune magnetic
    public static final int _ORM_NEPTUNE_MAGNETIC_1993 = 170;
    /// NOGAPS
    public static final int _ORM_NOGAPS_1988 = 171;
    /// NTF
    public static final int _ORM_NTF_1896 = 172;
    /// NTF (with the Prime Meridian at Paris)
    public static final int _ORM_NTF_1896_PM_PARIS = 173;
    /// Oberon
    public static final int _ORM_OBERON_1988 = 174;
    /// Observatorio Meteorologico
    public static final int _ORM_OBSERV_METEORO_1939 = 175;
    /// Old Egyptian
    public static final int _ORM_OLD_EGYPTIAN_1907 = 176;
    /// Old Hawaiian (Clarke)
    public static final int _ORM_OLD_HAWAIIAN_CLARKE_1987 = 177;
    /// Old Hawaiian (International)
    public static final int _ORM_OLD_HAWAIIAN_INT_1987 = 178;
    /// Ophelia
    public static final int _ORM_OPHELIA_1988 = 179;
    /// Ordnance Survey of Great Britain
    public static final int _ORM_OSGB_1936 = 180;
    /// Pan
    public static final int _ORM_PAN_1991 = 181;
    /// Pandora
    public static final int _ORM_PANDORA_1988 = 182;
    /// Phobos
    public static final int _ORM_PHOBOS_1988 = 183;
    /// Phoebe
    public static final int _ORM_PHOEBE_1988 = 184;
    /// Pico de las Nieves
    public static final int _ORM_PICO_DE_LAS_NIEVES_1987 = 185;
    /// Pitcairn (astronomic)
    public static final int _ORM_PITCAIRN_1967 = 186;
    /// Pluto
    public static final int _ORM_PLUTO_1994 = 187;
    /// Pluto equatorial inertial
    public static final int _ORM_PLUTO_INERTIAL = 188;
    /// Point 58
    public static final int _ORM_POINT_58_1991 = 189;
    /// Pointe Noire
    public static final int _ORM_POINTE_NOIRE_1948 = 190;
    /// Portia
    public static final int _ORM_PORTIA_1988 = 191;
    /// Porto Santo
    public static final int _ORM_PORTO_SANTO_1936 = 192;
    /// Prometheus
    public static final int _ORM_PROMETHEUS_1988 = 193;
    /// Proteus
    public static final int _ORM_PROTEUS_1991 = 194;
    /// Provisional South American
    public static final int _ORM_PROV_S_AM_1956 = 195;
    /// Provisional South Chilean (Hito XVIII)
    public static final int _ORM_PROV_S_CHILEAN_1963 = 196;
    /// Puck
    public static final int _ORM_PUCK_1988 = 197;
    /// Puerto Rico
    public static final int _ORM_PUERTO_RICO_1987 = 198;
    /// Pulkovo
    public static final int _ORM_PULKOVO_1942 = 199;
    /// Qatar National
    public static final int _ORM_QATAR_NATIONAL_1974 = 200;
    /// Qornoq
    public static final int _ORM_QORNOQ_1987 = 201;
    /// Reunion
    public static final int _ORM_REUNION_1947 = 202;
    /// Reseau Geodesique Francais
    public static final int _ORM_RGF_1993 = 203;
    /// Rhea
    public static final int _ORM_RHEA_1988 = 204;
    /// Rome (also known as Monte Mario)
    public static final int _ORM_ROME_1940 = 205;
    /// Rome (also known as Monte Mario) (with the Prime Meridian at Rome)
    public static final int _ORM_ROME_1940_PM_ROME = 206;
    /// Rosalind
    public static final int _ORM_ROSALIND_1988 = 207;
    /// South American
    public static final int _ORM_S_AM_1969 = 208;
    /// South Asia
    public static final int _ORM_S_ASIA_1987 = 209;
    /// S-JTSK
    public static final int _ORM_S_JTSK_1993 = 210;
    /// S-42 (Pulkovo)
    public static final int _ORM_S42_PULKOVO = 211;
    /// Santo (DOS)
    public static final int _ORM_SANTO_DOS_1965 = 212;
    /// Sao Braz
    public static final int _ORM_SAO_BRAZ_1987 = 213;
    /// Sapper Hill
    public static final int _ORM_SAPPER_HILL_1943 = 214;
    /// Saturn
    public static final int _ORM_SATURN_1988 = 215;
    /// Saturn equatorial inertial
    public static final int _ORM_SATURN_INERTIAL = 216;
    /// Saturn magnetic
    public static final int _ORM_SATURN_MAGNETIC_1993 = 217;
    /// Schwarzeck
    public static final int _ORM_SCHWARZECK_1991 = 218;
    /// Selvagem Grande
    public static final int _ORM_SELVAGEM_GRANDE_1938 = 219;
    /// Sierra Leone
    public static final int _ORM_SIERRA_LEONE_1960 = 220;
    /// SIRGAS
    public static final int _ORM_SIRGAS_2000 = 221;
    /// Sun
    public static final int _ORM_SUN_1992 = 222;
    /// Tananarive Observatory
    public static final int _ORM_TANANARIVE_OBS_1925 = 223;
    /// Tananarive Observatory (with the Prime Meridian at Paris)
    public static final int _ORM_TANANARIVE_OBS_1925_PM_PARIS = 224;
    /// Telesto
    public static final int _ORM_TELESTO_1988 = 225;
    /// Tern (astronomic)
    public static final int _ORM_TERN_1961 = 226;
    /// Tethys
    public static final int _ORM_TETHYS_1991 = 227;
    /// Thalassa
    public static final int _ORM_THALASSA_1991 = 228;
    /// Thebe
    public static final int _ORM_THEBE_2000 = 229;
    /// Timbali (Everest)
    public static final int _ORM_TIMBALAI_EVEREST_1948 = 230;
    /// Titan
    public static final int _ORM_TITAN_1982 = 231;
    /// Titania
    public static final int _ORM_TITANIA_1988 = 232;
    /// Tokyo
    public static final int _ORM_TOKYO_1991 = 233;
    /// Tristan (astronomic)
    public static final int _ORM_TRISTAN_1968 = 234;
    /// Triton
    public static final int _ORM_TRITON_1991 = 235;
    /// Umbriel
    public static final int _ORM_UMBRIEL_1988 = 236;
    /// Uranus
    public static final int _ORM_URANUS_1988 = 237;
    /// Uranus equatorial inertial
    public static final int _ORM_URANUS_INERTIAL = 238;
    /// Uranus magnetic
    public static final int _ORM_URANUS_MAGNETIC_1993 = 239;
    /// Venus
    public static final int _ORM_VENUS_1991 = 240;
    /// Venus equatorial inertial
    public static final int _ORM_VENUS_INERTIAL = 241;
    /// Viti Levu
    public static final int _ORM_VITI_LEVU_1916 = 242;
    /// Voirol
    public static final int _ORM_VOIROL_1874 = 243;
    /// Voirol (with the Prime Meridian at Paris)
    public static final int _ORM_VOIROL_1874_PM_PARIS = 244;
    /// Voirol - Revised
    public static final int _ORM_VOIROL_1960 = 245;
    /// Voirol - Revised (with the Prime Meridian at Paris)
    public static final int _ORM_VOIROL_1960_PM_PARIS = 246;
    /// Wake (astronomic)
    public static final int _ORM_WAKE_1952 = 247;
    /// Wake-Eniwetok
    public static final int _ORM_WAKE_ENIWETOK_1960 = 248;
    /// World Geodetic System
    public static final int _ORM_WGS_1972 = 249;
    /// World Geodetic System
    public static final int _ORM_WGS_1984 = 250;
    /// Yacare (Uruguay)
    public static final int _ORM_YACARE_1987 = 251;
    /// Zanderij (Suriname)
    public static final int _ORM_ZANDERIJ_1987 = 252;
    /// Added for the NGA Golden Data testing
    public static final int _ORM_EXPERIMENTAL_NGA_SPHERE = -1001;
    /// Added for the NGA Golden Data testing
    public static final int _ORM_EXPERIMENTAL_NGA_MAX = -1000;

    public static final SRM_ORM_Code ORM_UNDEFINED
        = new SRM_ORM_Code( _ORM_UNDEFINED, "ORM_UNDEFINED" );

    public static final SRM_ORM_Code ORM_ABSTRACT_2D
        = new SRM_ORM_Code( _ORM_ABSTRACT_2D, "ORM_ABSTRACT_2D" );
    public static final SRM_ORM_Code ORM_ABSTRACT_3D
        = new SRM_ORM_Code( _ORM_ABSTRACT_3D, "ORM_ABSTRACT_3D" );
    public static final SRM_ORM_Code ORM_ADINDAN_1991
        = new SRM_ORM_Code( _ORM_ADINDAN_1991, "ORM_ADINDAN_1991" );
    public static final SRM_ORM_Code ORM_ADRASTEA_2000
        = new SRM_ORM_Code( _ORM_ADRASTEA_2000, "ORM_ADRASTEA_2000" );
    public static final SRM_ORM_Code ORM_AFGOOYE_1987
        = new SRM_ORM_Code( _ORM_AFGOOYE_1987, "ORM_AFGOOYE_1987" );
    public static final SRM_ORM_Code ORM_AIN_EL_ABD_1970
        = new SRM_ORM_Code( _ORM_AIN_EL_ABD_1970, "ORM_AIN_EL_ABD_1970" );
    public static final SRM_ORM_Code ORM_AMALTHEA_2000
        = new SRM_ORM_Code( _ORM_AMALTHEA_2000, "ORM_AMALTHEA_2000" );
    public static final SRM_ORM_Code ORM_AMERICAN_SAMOA_1962
        = new SRM_ORM_Code( _ORM_AMERICAN_SAMOA_1962, "ORM_AMERICAN_SAMOA_1962" );
    public static final SRM_ORM_Code ORM_ANNA_1_1965
        = new SRM_ORM_Code( _ORM_ANNA_1_1965, "ORM_ANNA_1_1965" );
    public static final SRM_ORM_Code ORM_ANTIGUA_1943
        = new SRM_ORM_Code( _ORM_ANTIGUA_1943, "ORM_ANTIGUA_1943" );
    public static final SRM_ORM_Code ORM_ARC_1950
        = new SRM_ORM_Code( _ORM_ARC_1950, "ORM_ARC_1950" );
    public static final SRM_ORM_Code ORM_ARC_1960
        = new SRM_ORM_Code( _ORM_ARC_1960, "ORM_ARC_1960" );
    public static final SRM_ORM_Code ORM_ARIEL_1988
        = new SRM_ORM_Code( _ORM_ARIEL_1988, "ORM_ARIEL_1988" );
    public static final SRM_ORM_Code ORM_ASCENSION_1958
        = new SRM_ORM_Code( _ORM_ASCENSION_1958, "ORM_ASCENSION_1958" );
    public static final SRM_ORM_Code ORM_ATLAS_1988
        = new SRM_ORM_Code( _ORM_ATLAS_1988, "ORM_ATLAS_1988" );
    public static final SRM_ORM_Code ORM_AUSTRALIAN_GEOD_1966
        = new SRM_ORM_Code( _ORM_AUSTRALIAN_GEOD_1966, "ORM_AUSTRALIAN_GEOD_1966" );
    public static final SRM_ORM_Code ORM_AUSTRALIAN_GEOD_1984
        = new SRM_ORM_Code( _ORM_AUSTRALIAN_GEOD_1984, "ORM_AUSTRALIAN_GEOD_1984" );
    public static final SRM_ORM_Code ORM_AYABELLE_LIGHTHOUSE_1991
        = new SRM_ORM_Code( _ORM_AYABELLE_LIGHTHOUSE_1991, "ORM_AYABELLE_LIGHTHOUSE_1991" );
    public static final SRM_ORM_Code ORM_BEACON_E_1945
        = new SRM_ORM_Code( _ORM_BEACON_E_1945, "ORM_BEACON_E_1945" );
    public static final SRM_ORM_Code ORM_BELINDA_1988
        = new SRM_ORM_Code( _ORM_BELINDA_1988, "ORM_BELINDA_1988" );
    public static final SRM_ORM_Code ORM_BELLEVUE_IGN_1987
        = new SRM_ORM_Code( _ORM_BELLEVUE_IGN_1987, "ORM_BELLEVUE_IGN_1987" );
    public static final SRM_ORM_Code ORM_BERMUDA_1957
        = new SRM_ORM_Code( _ORM_BERMUDA_1957, "ORM_BERMUDA_1957" );
    public static final SRM_ORM_Code ORM_BIANCA_1988
        = new SRM_ORM_Code( _ORM_BIANCA_1988, "ORM_BIANCA_1988" );
    public static final SRM_ORM_Code ORM_BISSAU_1991
        = new SRM_ORM_Code( _ORM_BISSAU_1991, "ORM_BISSAU_1991" );
    public static final SRM_ORM_Code ORM_BOGOTA_OBS_1987
        = new SRM_ORM_Code( _ORM_BOGOTA_OBS_1987, "ORM_BOGOTA_OBS_1987" );
    public static final SRM_ORM_Code ORM_BOGOTA_OBS_1987_PM_BOGOTA
        = new SRM_ORM_Code( _ORM_BOGOTA_OBS_1987_PM_BOGOTA, "ORM_BOGOTA_OBS_1987_PM_BOGOTA" );
    public static final SRM_ORM_Code ORM_BUKIT_RIMPAH_1987
        = new SRM_ORM_Code( _ORM_BUKIT_RIMPAH_1987, "ORM_BUKIT_RIMPAH_1987" );
    public static final SRM_ORM_Code ORM_CALLISTO_2000
        = new SRM_ORM_Code( _ORM_CALLISTO_2000, "ORM_CALLISTO_2000" );
    public static final SRM_ORM_Code ORM_CALYPSO_1988
        = new SRM_ORM_Code( _ORM_CALYPSO_1988, "ORM_CALYPSO_1988" );
    public static final SRM_ORM_Code ORM_CAMP_AREA_1987
        = new SRM_ORM_Code( _ORM_CAMP_AREA_1987, "ORM_CAMP_AREA_1987" );
    public static final SRM_ORM_Code ORM_CAMPO_INCHAUSPE_1969
        = new SRM_ORM_Code( _ORM_CAMPO_INCHAUSPE_1969, "ORM_CAMPO_INCHAUSPE_1969" );
    public static final SRM_ORM_Code ORM_CANTON_1966
        = new SRM_ORM_Code( _ORM_CANTON_1966, "ORM_CANTON_1966" );
    public static final SRM_ORM_Code ORM_CAPE_1987
        = new SRM_ORM_Code( _ORM_CAPE_1987, "ORM_CAPE_1987" );
    public static final SRM_ORM_Code ORM_CAPE_CANAVERAL_1991
        = new SRM_ORM_Code( _ORM_CAPE_CANAVERAL_1991, "ORM_CAPE_CANAVERAL_1991" );
    public static final SRM_ORM_Code ORM_CARTHAGE_1987
        = new SRM_ORM_Code( _ORM_CARTHAGE_1987, "ORM_CARTHAGE_1987" );
    public static final SRM_ORM_Code ORM_CHARON_1991
        = new SRM_ORM_Code( _ORM_CHARON_1991, "ORM_CHARON_1991" );
    public static final SRM_ORM_Code ORM_CHATHAM_1971
        = new SRM_ORM_Code( _ORM_CHATHAM_1971, "ORM_CHATHAM_1971" );
    public static final SRM_ORM_Code ORM_CHUA_1987
        = new SRM_ORM_Code( _ORM_CHUA_1987, "ORM_CHUA_1987" );
    public static final SRM_ORM_Code ORM_COAMPS_1998
        = new SRM_ORM_Code( _ORM_COAMPS_1998, "ORM_COAMPS_1998" );
    public static final SRM_ORM_Code ORM_CORDELIA_1988
        = new SRM_ORM_Code( _ORM_CORDELIA_1988, "ORM_CORDELIA_1988" );
    public static final SRM_ORM_Code ORM_CORREGO_ALEGRE_1987
        = new SRM_ORM_Code( _ORM_CORREGO_ALEGRE_1987, "ORM_CORREGO_ALEGRE_1987" );
    public static final SRM_ORM_Code ORM_CRESSIDA_1988
        = new SRM_ORM_Code( _ORM_CRESSIDA_1988, "ORM_CRESSIDA_1988" );
    public static final SRM_ORM_Code ORM_DABOLA_1991
        = new SRM_ORM_Code( _ORM_DABOLA_1991, "ORM_DABOLA_1991" );
    public static final SRM_ORM_Code ORM_DECEPTION_1993
        = new SRM_ORM_Code( _ORM_DECEPTION_1993, "ORM_DECEPTION_1993" );
    public static final SRM_ORM_Code ORM_DEIMOS_1988
        = new SRM_ORM_Code( _ORM_DEIMOS_1988, "ORM_DEIMOS_1988" );
    public static final SRM_ORM_Code ORM_DESDEMONA_1988
        = new SRM_ORM_Code( _ORM_DESDEMONA_1988, "ORM_DESDEMONA_1988" );
    public static final SRM_ORM_Code ORM_DESPINA_1991
        = new SRM_ORM_Code( _ORM_DESPINA_1991, "ORM_DESPINA_1991" );
    public static final SRM_ORM_Code ORM_DIONE_1982
        = new SRM_ORM_Code( _ORM_DIONE_1982, "ORM_DIONE_1982" );
    public static final SRM_ORM_Code ORM_DJAKARTA_1987
        = new SRM_ORM_Code( _ORM_DJAKARTA_1987, "ORM_DJAKARTA_1987" );
    public static final SRM_ORM_Code ORM_DJAKARTA_1987_PM_DJAKARTA
        = new SRM_ORM_Code( _ORM_DJAKARTA_1987_PM_DJAKARTA, "ORM_DJAKARTA_1987_PM_DJAKARTA" );
    public static final SRM_ORM_Code ORM_DOS_1968
        = new SRM_ORM_Code( _ORM_DOS_1968, "ORM_DOS_1968" );
    public static final SRM_ORM_Code ORM_DOS_71_4_1987
        = new SRM_ORM_Code( _ORM_DOS_71_4_1987, "ORM_DOS_71_4_1987" );
    public static final SRM_ORM_Code ORM_EARTH_INERTIAL_ARIES_1950
        = new SRM_ORM_Code( _ORM_EARTH_INERTIAL_ARIES_1950, "ORM_EARTH_INERTIAL_ARIES_1950" );
    public static final SRM_ORM_Code ORM_EARTH_INERTIAL_ARIES_TRUE_OF_DATE
        = new SRM_ORM_Code( _ORM_EARTH_INERTIAL_ARIES_TRUE_OF_DATE, "ORM_EARTH_INERTIAL_ARIES_TRUE_OF_DATE" );
    public static final SRM_ORM_Code ORM_EARTH_INERTIAL_J2000r0
        = new SRM_ORM_Code( _ORM_EARTH_INERTIAL_J2000r0, "ORM_EARTH_INERTIAL_J2000r0" );
    public static final SRM_ORM_Code ORM_EARTH_SOLAR_ECLIPTIC
        = new SRM_ORM_Code( _ORM_EARTH_SOLAR_ECLIPTIC, "ORM_EARTH_SOLAR_ECLIPTIC" );
    public static final SRM_ORM_Code ORM_EARTH_SOLAR_EQUATORIAL
        = new SRM_ORM_Code( _ORM_EARTH_SOLAR_EQUATORIAL, "ORM_EARTH_SOLAR_EQUATORIAL" );
    public static final SRM_ORM_Code ORM_EARTH_SOLAR_MAG_DIPOLE
        = new SRM_ORM_Code( _ORM_EARTH_SOLAR_MAG_DIPOLE, "ORM_EARTH_SOLAR_MAG_DIPOLE" );
    public static final SRM_ORM_Code ORM_EARTH_SOLAR_MAGNETOSPHERIC
        = new SRM_ORM_Code( _ORM_EARTH_SOLAR_MAGNETOSPHERIC, "ORM_EARTH_SOLAR_MAGNETOSPHERIC" );
    public static final SRM_ORM_Code ORM_EASTER_1967
        = new SRM_ORM_Code( _ORM_EASTER_1967, "ORM_EASTER_1967" );
    public static final SRM_ORM_Code ORM_ENCELADUS_1994
        = new SRM_ORM_Code( _ORM_ENCELADUS_1994, "ORM_ENCELADUS_1994" );
    public static final SRM_ORM_Code ORM_EPIMETHEUS_1988
        = new SRM_ORM_Code( _ORM_EPIMETHEUS_1988, "ORM_EPIMETHEUS_1988" );
    public static final SRM_ORM_Code ORM_EROS_2000
        = new SRM_ORM_Code( _ORM_EROS_2000, "ORM_EROS_2000" );
    public static final SRM_ORM_Code ORM_ESTONIA_1937
        = new SRM_ORM_Code( _ORM_ESTONIA_1937, "ORM_ESTONIA_1937" );
    public static final SRM_ORM_Code ORM_ETRS_1989
        = new SRM_ORM_Code( _ORM_ETRS_1989, "ORM_ETRS_1989" );
    public static final SRM_ORM_Code ORM_EUROPA_2000
        = new SRM_ORM_Code( _ORM_EUROPA_2000, "ORM_EUROPA_2000" );
    public static final SRM_ORM_Code ORM_EUROPE_1950
        = new SRM_ORM_Code( _ORM_EUROPE_1950, "ORM_EUROPE_1950" );
    public static final SRM_ORM_Code ORM_EUROPE_1979
        = new SRM_ORM_Code( _ORM_EUROPE_1979, "ORM_EUROPE_1979" );
    public static final SRM_ORM_Code ORM_FAHUD_1987
        = new SRM_ORM_Code( _ORM_FAHUD_1987, "ORM_FAHUD_1987" );
    public static final SRM_ORM_Code ORM_FORT_THOMAS_1955
        = new SRM_ORM_Code( _ORM_FORT_THOMAS_1955, "ORM_FORT_THOMAS_1955" );
    public static final SRM_ORM_Code ORM_GALATEA_1991
        = new SRM_ORM_Code( _ORM_GALATEA_1991, "ORM_GALATEA_1991" );
    public static final SRM_ORM_Code ORM_GAN_1970
        = new SRM_ORM_Code( _ORM_GAN_1970, "ORM_GAN_1970" );
    public static final SRM_ORM_Code ORM_GANYMEDE_2000
        = new SRM_ORM_Code( _ORM_GANYMEDE_2000, "ORM_GANYMEDE_2000" );
    public static final SRM_ORM_Code ORM_GASPRA_1991
        = new SRM_ORM_Code( _ORM_GASPRA_1991, "ORM_GASPRA_1991" );
    public static final SRM_ORM_Code ORM_GDA_1994
        = new SRM_ORM_Code( _ORM_GDA_1994, "ORM_GDA_1994" );
    public static final SRM_ORM_Code ORM_GEODETIC_DATUM_1949
        = new SRM_ORM_Code( _ORM_GEODETIC_DATUM_1949, "ORM_GEODETIC_DATUM_1949" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1945
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1945, "ORM_GEOMAGNETIC_1945" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1950
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1950, "ORM_GEOMAGNETIC_1950" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1955
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1955, "ORM_GEOMAGNETIC_1955" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1960
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1960, "ORM_GEOMAGNETIC_1960" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1965
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1965, "ORM_GEOMAGNETIC_1965" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1970
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1970, "ORM_GEOMAGNETIC_1970" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1975
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1975, "ORM_GEOMAGNETIC_1975" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1980
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1980, "ORM_GEOMAGNETIC_1980" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1985
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1985, "ORM_GEOMAGNETIC_1985" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1990
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1990, "ORM_GEOMAGNETIC_1990" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_1995
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_1995, "ORM_GEOMAGNETIC_1995" );
    public static final SRM_ORM_Code ORM_GEOMAGNETIC_2000
        = new SRM_ORM_Code( _ORM_GEOMAGNETIC_2000, "ORM_GEOMAGNETIC_2000" );
    public static final SRM_ORM_Code ORM_GRACIOSA_BASE_SW_1948
        = new SRM_ORM_Code( _ORM_GRACIOSA_BASE_SW_1948, "ORM_GRACIOSA_BASE_SW_1948" );
    public static final SRM_ORM_Code ORM_GUAM_1963
        = new SRM_ORM_Code( _ORM_GUAM_1963, "ORM_GUAM_1963" );
    public static final SRM_ORM_Code ORM_GUNONG_SEGARA_1987
        = new SRM_ORM_Code( _ORM_GUNONG_SEGARA_1987, "ORM_GUNONG_SEGARA_1987" );
    public static final SRM_ORM_Code ORM_GUX_1_1987
        = new SRM_ORM_Code( _ORM_GUX_1_1987, "ORM_GUX_1_1987" );
    public static final SRM_ORM_Code ORM_HELENE_1992
        = new SRM_ORM_Code( _ORM_HELENE_1992, "ORM_HELENE_1992" );
    public static final SRM_ORM_Code ORM_HELIO_ARIES_ECLIPTIC_J2000r0
        = new SRM_ORM_Code( _ORM_HELIO_ARIES_ECLIPTIC_J2000r0, "ORM_HELIO_ARIES_ECLIPTIC_J2000r0" );
    public static final SRM_ORM_Code ORM_HELIO_ARIES_ECLIPTIC_TRUE_OF_DATE
        = new SRM_ORM_Code( _ORM_HELIO_ARIES_ECLIPTIC_TRUE_OF_DATE, "ORM_HELIO_ARIES_ECLIPTIC_TRUE_OF_DATE" );
    public static final SRM_ORM_Code ORM_HELIO_EARTH_ECLIPTIC
        = new SRM_ORM_Code( _ORM_HELIO_EARTH_ECLIPTIC, "ORM_HELIO_EARTH_ECLIPTIC" );
    public static final SRM_ORM_Code ORM_HELIO_EARTH_EQUATORIAL
        = new SRM_ORM_Code( _ORM_HELIO_EARTH_EQUATORIAL, "ORM_HELIO_EARTH_EQUATORIAL" );
    public static final SRM_ORM_Code ORM_HERAT_NORTH_1987
        = new SRM_ORM_Code( _ORM_HERAT_NORTH_1987, "ORM_HERAT_NORTH_1987" );
    public static final SRM_ORM_Code ORM_HERMANNSKOGEL_1871
        = new SRM_ORM_Code( _ORM_HERMANNSKOGEL_1871, "ORM_HERMANNSKOGEL_1871" );
    public static final SRM_ORM_Code ORM_HJORSEY_1955
        = new SRM_ORM_Code( _ORM_HJORSEY_1955, "ORM_HJORSEY_1955" );
    public static final SRM_ORM_Code ORM_HONG_KONG_1963
        = new SRM_ORM_Code( _ORM_HONG_KONG_1963, "ORM_HONG_KONG_1963" );
    public static final SRM_ORM_Code ORM_HU_TZU_SHAN_1991
        = new SRM_ORM_Code( _ORM_HU_TZU_SHAN_1991, "ORM_HU_TZU_SHAN_1991" );
    public static final SRM_ORM_Code ORM_IAPETUS_1988
        = new SRM_ORM_Code( _ORM_IAPETUS_1988, "ORM_IAPETUS_1988" );
    public static final SRM_ORM_Code ORM_IDA_1991
        = new SRM_ORM_Code( _ORM_IDA_1991, "ORM_IDA_1991" );
    public static final SRM_ORM_Code ORM_INDIAN_1916
        = new SRM_ORM_Code( _ORM_INDIAN_1916, "ORM_INDIAN_1916" );
    public static final SRM_ORM_Code ORM_INDIAN_1954
        = new SRM_ORM_Code( _ORM_INDIAN_1954, "ORM_INDIAN_1954" );
    public static final SRM_ORM_Code ORM_INDIAN_1956
        = new SRM_ORM_Code( _ORM_INDIAN_1956, "ORM_INDIAN_1956" );
    public static final SRM_ORM_Code ORM_INDIAN_1960
        = new SRM_ORM_Code( _ORM_INDIAN_1960, "ORM_INDIAN_1960" );
    public static final SRM_ORM_Code ORM_INDIAN_1962
        = new SRM_ORM_Code( _ORM_INDIAN_1962, "ORM_INDIAN_1962" );
    public static final SRM_ORM_Code ORM_INDIAN_1975
        = new SRM_ORM_Code( _ORM_INDIAN_1975, "ORM_INDIAN_1975" );
    public static final SRM_ORM_Code ORM_INDONESIAN_1974
        = new SRM_ORM_Code( _ORM_INDONESIAN_1974, "ORM_INDONESIAN_1974" );
    public static final SRM_ORM_Code ORM_IO_2000
        = new SRM_ORM_Code( _ORM_IO_2000, "ORM_IO_2000" );
    public static final SRM_ORM_Code ORM_IRELAND_1965
        = new SRM_ORM_Code( _ORM_IRELAND_1965, "ORM_IRELAND_1965" );
    public static final SRM_ORM_Code ORM_ISTS_061_1968
        = new SRM_ORM_Code( _ORM_ISTS_061_1968, "ORM_ISTS_061_1968" );
    public static final SRM_ORM_Code ORM_ISTS_073_1969
        = new SRM_ORM_Code( _ORM_ISTS_073_1969, "ORM_ISTS_073_1969" );
    public static final SRM_ORM_Code ORM_JANUS_1988
        = new SRM_ORM_Code( _ORM_JANUS_1988, "ORM_JANUS_1988" );
    public static final SRM_ORM_Code ORM_JGD_2000
        = new SRM_ORM_Code( _ORM_JGD_2000, "ORM_JGD_2000" );
    public static final SRM_ORM_Code ORM_JOHNSTON_1961
        = new SRM_ORM_Code( _ORM_JOHNSTON_1961, "ORM_JOHNSTON_1961" );
    public static final SRM_ORM_Code ORM_JULIET_1988
        = new SRM_ORM_Code( _ORM_JULIET_1988, "ORM_JULIET_1988" );
    public static final SRM_ORM_Code ORM_JUPITER_1988
        = new SRM_ORM_Code( _ORM_JUPITER_1988, "ORM_JUPITER_1988" );
    public static final SRM_ORM_Code ORM_JUPITER_INERTIAL
        = new SRM_ORM_Code( _ORM_JUPITER_INERTIAL, "ORM_JUPITER_INERTIAL" );
    public static final SRM_ORM_Code ORM_JUPITER_MAGNETIC_1993
        = new SRM_ORM_Code( _ORM_JUPITER_MAGNETIC_1993, "ORM_JUPITER_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORM_JUPITER_SOLAR_ECLIPTIC
        = new SRM_ORM_Code( _ORM_JUPITER_SOLAR_ECLIPTIC, "ORM_JUPITER_SOLAR_ECLIPTIC" );
    public static final SRM_ORM_Code ORM_JUPITER_SOLAR_EQUATORIAL
        = new SRM_ORM_Code( _ORM_JUPITER_SOLAR_EQUATORIAL, "ORM_JUPITER_SOLAR_EQUATORIAL" );
    public static final SRM_ORM_Code ORM_JUPITER_SOLAR_MAG_DIPOLE
        = new SRM_ORM_Code( _ORM_JUPITER_SOLAR_MAG_DIPOLE, "ORM_JUPITER_SOLAR_MAG_DIPOLE" );
    public static final SRM_ORM_Code ORM_JUPITER_SOLAR_MAG_ECLIPTIC
        = new SRM_ORM_Code( _ORM_JUPITER_SOLAR_MAG_ECLIPTIC, "ORM_JUPITER_SOLAR_MAG_ECLIPTIC" );
    public static final SRM_ORM_Code ORM_KANDAWALA_1987
        = new SRM_ORM_Code( _ORM_KANDAWALA_1987, "ORM_KANDAWALA_1987" );
    public static final SRM_ORM_Code ORM_KERGUELEN_1949
        = new SRM_ORM_Code( _ORM_KERGUELEN_1949, "ORM_KERGUELEN_1949" );
    public static final SRM_ORM_Code ORM_KERTAU_1948
        = new SRM_ORM_Code( _ORM_KERTAU_1948, "ORM_KERTAU_1948" );
    public static final SRM_ORM_Code ORM_KOREAN_GEODETIC_1995
        = new SRM_ORM_Code( _ORM_KOREAN_GEODETIC_1995, "ORM_KOREAN_GEODETIC_1995" );
    public static final SRM_ORM_Code ORM_KUSAIE_1951
        = new SRM_ORM_Code( _ORM_KUSAIE_1951, "ORM_KUSAIE_1951" );
    public static final SRM_ORM_Code ORM_LARISSA_1991
        = new SRM_ORM_Code( _ORM_LARISSA_1991, "ORM_LARISSA_1991" );
    public static final SRM_ORM_Code ORM_LC5_1961
        = new SRM_ORM_Code( _ORM_LC5_1961, "ORM_LC5_1961" );
    public static final SRM_ORM_Code ORM_LEIGON_1991
        = new SRM_ORM_Code( _ORM_LEIGON_1991, "ORM_LEIGON_1991" );
    public static final SRM_ORM_Code ORM_LIBERIA_1964
        = new SRM_ORM_Code( _ORM_LIBERIA_1964, "ORM_LIBERIA_1964" );
    public static final SRM_ORM_Code ORM_LUZON_1987
        = new SRM_ORM_Code( _ORM_LUZON_1987, "ORM_LUZON_1987" );
    public static final SRM_ORM_Code ORM_M_PORALOKO_1991
        = new SRM_ORM_Code( _ORM_M_PORALOKO_1991, "ORM_M_PORALOKO_1991" );
    public static final SRM_ORM_Code ORM_MAHE_1971
        = new SRM_ORM_Code( _ORM_MAHE_1971, "ORM_MAHE_1971" );
    public static final SRM_ORM_Code ORM_MARCUS_STATION_1952
        = new SRM_ORM_Code( _ORM_MARCUS_STATION_1952, "ORM_MARCUS_STATION_1952" );
    public static final SRM_ORM_Code ORM_MARS_2000
        = new SRM_ORM_Code( _ORM_MARS_2000, "ORM_MARS_2000" );
    public static final SRM_ORM_Code ORM_MARS_INERTIAL
        = new SRM_ORM_Code( _ORM_MARS_INERTIAL, "ORM_MARS_INERTIAL" );
    public static final SRM_ORM_Code ORM_MARS_SPHERE_2000
        = new SRM_ORM_Code( _ORM_MARS_SPHERE_2000, "ORM_MARS_SPHERE_2000" );
    public static final SRM_ORM_Code ORM_MASS_1999
        = new SRM_ORM_Code( _ORM_MASS_1999, "ORM_MASS_1999" );
    public static final SRM_ORM_Code ORM_MASSAWA_1987
        = new SRM_ORM_Code( _ORM_MASSAWA_1987, "ORM_MASSAWA_1987" );
    public static final SRM_ORM_Code ORM_MERCHICH_1987
        = new SRM_ORM_Code( _ORM_MERCHICH_1987, "ORM_MERCHICH_1987" );
    public static final SRM_ORM_Code ORM_MERCURY_1988
        = new SRM_ORM_Code( _ORM_MERCURY_1988, "ORM_MERCURY_1988" );
    public static final SRM_ORM_Code ORM_MERCURY_INERTIAL
        = new SRM_ORM_Code( _ORM_MERCURY_INERTIAL, "ORM_MERCURY_INERTIAL" );
    public static final SRM_ORM_Code ORM_METIS_2000
        = new SRM_ORM_Code( _ORM_METIS_2000, "ORM_METIS_2000" );
    public static final SRM_ORM_Code ORM_MIDWAY_1961
        = new SRM_ORM_Code( _ORM_MIDWAY_1961, "ORM_MIDWAY_1961" );
    public static final SRM_ORM_Code ORM_MIMAS_1994
        = new SRM_ORM_Code( _ORM_MIMAS_1994, "ORM_MIMAS_1994" );
    public static final SRM_ORM_Code ORM_MINNA_1991
        = new SRM_ORM_Code( _ORM_MINNA_1991, "ORM_MINNA_1991" );
    public static final SRM_ORM_Code ORM_MIRANDA_1988
        = new SRM_ORM_Code( _ORM_MIRANDA_1988, "ORM_MIRANDA_1988" );
    public static final SRM_ORM_Code ORM_MM5_1997
        = new SRM_ORM_Code( _ORM_MM5_1997, "ORM_MM5_1997" );
    public static final SRM_ORM_Code ORM_MODTRAN_MIDLATITUDE_N_1989
        = new SRM_ORM_Code( _ORM_MODTRAN_MIDLATITUDE_N_1989, "ORM_MODTRAN_MIDLATITUDE_N_1989" );
    public static final SRM_ORM_Code ORM_MODTRAN_MIDLATITUDE_S_1989
        = new SRM_ORM_Code( _ORM_MODTRAN_MIDLATITUDE_S_1989, "ORM_MODTRAN_MIDLATITUDE_S_1989" );
    public static final SRM_ORM_Code ORM_MODTRAN_SUBARCTIC_N_1989
        = new SRM_ORM_Code( _ORM_MODTRAN_SUBARCTIC_N_1989, "ORM_MODTRAN_SUBARCTIC_N_1989" );
    public static final SRM_ORM_Code ORM_MODTRAN_SUBARCTIC_S_1989
        = new SRM_ORM_Code( _ORM_MODTRAN_SUBARCTIC_S_1989, "ORM_MODTRAN_SUBARCTIC_S_1989" );
    public static final SRM_ORM_Code ORM_MODTRAN_TROPICAL_1989
        = new SRM_ORM_Code( _ORM_MODTRAN_TROPICAL_1989, "ORM_MODTRAN_TROPICAL_1989" );
    public static final SRM_ORM_Code ORM_MONTSERRAT_1958
        = new SRM_ORM_Code( _ORM_MONTSERRAT_1958, "ORM_MONTSERRAT_1958" );
    public static final SRM_ORM_Code ORM_MOON_1991
        = new SRM_ORM_Code( _ORM_MOON_1991, "ORM_MOON_1991" );
    public static final SRM_ORM_Code ORM_MULTIGEN_FLAT_EARTH_1989
        = new SRM_ORM_Code( _ORM_MULTIGEN_FLAT_EARTH_1989, "ORM_MULTIGEN_FLAT_EARTH_1989" );
    public static final SRM_ORM_Code ORM_N_AM_1927
        = new SRM_ORM_Code( _ORM_N_AM_1927, "ORM_N_AM_1927" );
    public static final SRM_ORM_Code ORM_N_AM_1983
        = new SRM_ORM_Code( _ORM_N_AM_1983, "ORM_N_AM_1983" );
    public static final SRM_ORM_Code ORM_N_SAHARA_1959
        = new SRM_ORM_Code( _ORM_N_SAHARA_1959, "ORM_N_SAHARA_1959" );
    public static final SRM_ORM_Code ORM_NAHRWAN_1987
        = new SRM_ORM_Code( _ORM_NAHRWAN_1987, "ORM_NAHRWAN_1987" );
    public static final SRM_ORM_Code ORM_NAIAD_1991
        = new SRM_ORM_Code( _ORM_NAIAD_1991, "ORM_NAIAD_1991" );
    public static final SRM_ORM_Code ORM_NAPARIMA_1991
        = new SRM_ORM_Code( _ORM_NAPARIMA_1991, "ORM_NAPARIMA_1991" );
    public static final SRM_ORM_Code ORM_NEPTUNE_1991
        = new SRM_ORM_Code( _ORM_NEPTUNE_1991, "ORM_NEPTUNE_1991" );
    public static final SRM_ORM_Code ORM_NEPTUNE_INERTIAL
        = new SRM_ORM_Code( _ORM_NEPTUNE_INERTIAL, "ORM_NEPTUNE_INERTIAL" );
    public static final SRM_ORM_Code ORM_NEPTUNE_MAGNETIC_1993
        = new SRM_ORM_Code( _ORM_NEPTUNE_MAGNETIC_1993, "ORM_NEPTUNE_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORM_NOGAPS_1988
        = new SRM_ORM_Code( _ORM_NOGAPS_1988, "ORM_NOGAPS_1988" );
    public static final SRM_ORM_Code ORM_NTF_1896
        = new SRM_ORM_Code( _ORM_NTF_1896, "ORM_NTF_1896" );
    public static final SRM_ORM_Code ORM_NTF_1896_PM_PARIS
        = new SRM_ORM_Code( _ORM_NTF_1896_PM_PARIS, "ORM_NTF_1896_PM_PARIS" );
    public static final SRM_ORM_Code ORM_OBERON_1988
        = new SRM_ORM_Code( _ORM_OBERON_1988, "ORM_OBERON_1988" );
    public static final SRM_ORM_Code ORM_OBSERV_METEORO_1939
        = new SRM_ORM_Code( _ORM_OBSERV_METEORO_1939, "ORM_OBSERV_METEORO_1939" );
    public static final SRM_ORM_Code ORM_OLD_EGYPTIAN_1907
        = new SRM_ORM_Code( _ORM_OLD_EGYPTIAN_1907, "ORM_OLD_EGYPTIAN_1907" );
    public static final SRM_ORM_Code ORM_OLD_HAWAIIAN_CLARKE_1987
        = new SRM_ORM_Code( _ORM_OLD_HAWAIIAN_CLARKE_1987, "ORM_OLD_HAWAIIAN_CLARKE_1987" );
    public static final SRM_ORM_Code ORM_OLD_HAWAIIAN_INT_1987
        = new SRM_ORM_Code( _ORM_OLD_HAWAIIAN_INT_1987, "ORM_OLD_HAWAIIAN_INT_1987" );
    public static final SRM_ORM_Code ORM_OPHELIA_1988
        = new SRM_ORM_Code( _ORM_OPHELIA_1988, "ORM_OPHELIA_1988" );
    public static final SRM_ORM_Code ORM_OSGB_1936
        = new SRM_ORM_Code( _ORM_OSGB_1936, "ORM_OSGB_1936" );
    public static final SRM_ORM_Code ORM_PAN_1991
        = new SRM_ORM_Code( _ORM_PAN_1991, "ORM_PAN_1991" );
    public static final SRM_ORM_Code ORM_PANDORA_1988
        = new SRM_ORM_Code( _ORM_PANDORA_1988, "ORM_PANDORA_1988" );
    public static final SRM_ORM_Code ORM_PHOBOS_1988
        = new SRM_ORM_Code( _ORM_PHOBOS_1988, "ORM_PHOBOS_1988" );
    public static final SRM_ORM_Code ORM_PHOEBE_1988
        = new SRM_ORM_Code( _ORM_PHOEBE_1988, "ORM_PHOEBE_1988" );
    public static final SRM_ORM_Code ORM_PICO_DE_LAS_NIEVES_1987
        = new SRM_ORM_Code( _ORM_PICO_DE_LAS_NIEVES_1987, "ORM_PICO_DE_LAS_NIEVES_1987" );
    public static final SRM_ORM_Code ORM_PITCAIRN_1967
        = new SRM_ORM_Code( _ORM_PITCAIRN_1967, "ORM_PITCAIRN_1967" );
    public static final SRM_ORM_Code ORM_PLUTO_1994
        = new SRM_ORM_Code( _ORM_PLUTO_1994, "ORM_PLUTO_1994" );
    public static final SRM_ORM_Code ORM_PLUTO_INERTIAL
        = new SRM_ORM_Code( _ORM_PLUTO_INERTIAL, "ORM_PLUTO_INERTIAL" );
    public static final SRM_ORM_Code ORM_POINT_58_1991
        = new SRM_ORM_Code( _ORM_POINT_58_1991, "ORM_POINT_58_1991" );
    public static final SRM_ORM_Code ORM_POINTE_NOIRE_1948
        = new SRM_ORM_Code( _ORM_POINTE_NOIRE_1948, "ORM_POINTE_NOIRE_1948" );
    public static final SRM_ORM_Code ORM_PORTIA_1988
        = new SRM_ORM_Code( _ORM_PORTIA_1988, "ORM_PORTIA_1988" );
    public static final SRM_ORM_Code ORM_PORTO_SANTO_1936
        = new SRM_ORM_Code( _ORM_PORTO_SANTO_1936, "ORM_PORTO_SANTO_1936" );
    public static final SRM_ORM_Code ORM_PROMETHEUS_1988
        = new SRM_ORM_Code( _ORM_PROMETHEUS_1988, "ORM_PROMETHEUS_1988" );
    public static final SRM_ORM_Code ORM_PROTEUS_1991
        = new SRM_ORM_Code( _ORM_PROTEUS_1991, "ORM_PROTEUS_1991" );
    public static final SRM_ORM_Code ORM_PROV_S_AM_1956
        = new SRM_ORM_Code( _ORM_PROV_S_AM_1956, "ORM_PROV_S_AM_1956" );
    public static final SRM_ORM_Code ORM_PROV_S_CHILEAN_1963
        = new SRM_ORM_Code( _ORM_PROV_S_CHILEAN_1963, "ORM_PROV_S_CHILEAN_1963" );
    public static final SRM_ORM_Code ORM_PUCK_1988
        = new SRM_ORM_Code( _ORM_PUCK_1988, "ORM_PUCK_1988" );
    public static final SRM_ORM_Code ORM_PUERTO_RICO_1987
        = new SRM_ORM_Code( _ORM_PUERTO_RICO_1987, "ORM_PUERTO_RICO_1987" );
    public static final SRM_ORM_Code ORM_PULKOVO_1942
        = new SRM_ORM_Code( _ORM_PULKOVO_1942, "ORM_PULKOVO_1942" );
    public static final SRM_ORM_Code ORM_QATAR_NATIONAL_1974
        = new SRM_ORM_Code( _ORM_QATAR_NATIONAL_1974, "ORM_QATAR_NATIONAL_1974" );
    public static final SRM_ORM_Code ORM_QORNOQ_1987
        = new SRM_ORM_Code( _ORM_QORNOQ_1987, "ORM_QORNOQ_1987" );
    public static final SRM_ORM_Code ORM_REUNION_1947
        = new SRM_ORM_Code( _ORM_REUNION_1947, "ORM_REUNION_1947" );
    public static final SRM_ORM_Code ORM_RGF_1993
        = new SRM_ORM_Code( _ORM_RGF_1993, "ORM_RGF_1993" );
    public static final SRM_ORM_Code ORM_RHEA_1988
        = new SRM_ORM_Code( _ORM_RHEA_1988, "ORM_RHEA_1988" );
    public static final SRM_ORM_Code ORM_ROME_1940
        = new SRM_ORM_Code( _ORM_ROME_1940, "ORM_ROME_1940" );
    public static final SRM_ORM_Code ORM_ROME_1940_PM_ROME
        = new SRM_ORM_Code( _ORM_ROME_1940_PM_ROME, "ORM_ROME_1940_PM_ROME" );
    public static final SRM_ORM_Code ORM_ROSALIND_1988
        = new SRM_ORM_Code( _ORM_ROSALIND_1988, "ORM_ROSALIND_1988" );
    public static final SRM_ORM_Code ORM_S_AM_1969
        = new SRM_ORM_Code( _ORM_S_AM_1969, "ORM_S_AM_1969" );
    public static final SRM_ORM_Code ORM_S_ASIA_1987
        = new SRM_ORM_Code( _ORM_S_ASIA_1987, "ORM_S_ASIA_1987" );
    public static final SRM_ORM_Code ORM_S_JTSK_1993
        = new SRM_ORM_Code( _ORM_S_JTSK_1993, "ORM_S_JTSK_1993" );
    public static final SRM_ORM_Code ORM_S42_PULKOVO
        = new SRM_ORM_Code( _ORM_S42_PULKOVO, "ORM_S42_PULKOVO" );
    public static final SRM_ORM_Code ORM_SANTO_DOS_1965
        = new SRM_ORM_Code( _ORM_SANTO_DOS_1965, "ORM_SANTO_DOS_1965" );
    public static final SRM_ORM_Code ORM_SAO_BRAZ_1987
        = new SRM_ORM_Code( _ORM_SAO_BRAZ_1987, "ORM_SAO_BRAZ_1987" );
    public static final SRM_ORM_Code ORM_SAPPER_HILL_1943
        = new SRM_ORM_Code( _ORM_SAPPER_HILL_1943, "ORM_SAPPER_HILL_1943" );
    public static final SRM_ORM_Code ORM_SATURN_1988
        = new SRM_ORM_Code( _ORM_SATURN_1988, "ORM_SATURN_1988" );
    public static final SRM_ORM_Code ORM_SATURN_INERTIAL
        = new SRM_ORM_Code( _ORM_SATURN_INERTIAL, "ORM_SATURN_INERTIAL" );
    public static final SRM_ORM_Code ORM_SATURN_MAGNETIC_1993
        = new SRM_ORM_Code( _ORM_SATURN_MAGNETIC_1993, "ORM_SATURN_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORM_SCHWARZECK_1991
        = new SRM_ORM_Code( _ORM_SCHWARZECK_1991, "ORM_SCHWARZECK_1991" );
    public static final SRM_ORM_Code ORM_SELVAGEM_GRANDE_1938
        = new SRM_ORM_Code( _ORM_SELVAGEM_GRANDE_1938, "ORM_SELVAGEM_GRANDE_1938" );
    public static final SRM_ORM_Code ORM_SIERRA_LEONE_1960
        = new SRM_ORM_Code( _ORM_SIERRA_LEONE_1960, "ORM_SIERRA_LEONE_1960" );
    public static final SRM_ORM_Code ORM_SIRGAS_2000
        = new SRM_ORM_Code( _ORM_SIRGAS_2000, "ORM_SIRGAS_2000" );
    public static final SRM_ORM_Code ORM_SUN_1992
        = new SRM_ORM_Code( _ORM_SUN_1992, "ORM_SUN_1992" );
    public static final SRM_ORM_Code ORM_TANANARIVE_OBS_1925
        = new SRM_ORM_Code( _ORM_TANANARIVE_OBS_1925, "ORM_TANANARIVE_OBS_1925" );
    public static final SRM_ORM_Code ORM_TANANARIVE_OBS_1925_PM_PARIS
        = new SRM_ORM_Code( _ORM_TANANARIVE_OBS_1925_PM_PARIS, "ORM_TANANARIVE_OBS_1925_PM_PARIS" );
    public static final SRM_ORM_Code ORM_TELESTO_1988
        = new SRM_ORM_Code( _ORM_TELESTO_1988, "ORM_TELESTO_1988" );
    public static final SRM_ORM_Code ORM_TERN_1961
        = new SRM_ORM_Code( _ORM_TERN_1961, "ORM_TERN_1961" );
    public static final SRM_ORM_Code ORM_TETHYS_1991
        = new SRM_ORM_Code( _ORM_TETHYS_1991, "ORM_TETHYS_1991" );
    public static final SRM_ORM_Code ORM_THALASSA_1991
        = new SRM_ORM_Code( _ORM_THALASSA_1991, "ORM_THALASSA_1991" );
    public static final SRM_ORM_Code ORM_THEBE_2000
        = new SRM_ORM_Code( _ORM_THEBE_2000, "ORM_THEBE_2000" );
    public static final SRM_ORM_Code ORM_TIMBALAI_EVEREST_1948
        = new SRM_ORM_Code( _ORM_TIMBALAI_EVEREST_1948, "ORM_TIMBALAI_EVEREST_1948" );
    public static final SRM_ORM_Code ORM_TITAN_1982
        = new SRM_ORM_Code( _ORM_TITAN_1982, "ORM_TITAN_1982" );
    public static final SRM_ORM_Code ORM_TITANIA_1988
        = new SRM_ORM_Code( _ORM_TITANIA_1988, "ORM_TITANIA_1988" );
    public static final SRM_ORM_Code ORM_TOKYO_1991
        = new SRM_ORM_Code( _ORM_TOKYO_1991, "ORM_TOKYO_1991" );
    public static final SRM_ORM_Code ORM_TRISTAN_1968
        = new SRM_ORM_Code( _ORM_TRISTAN_1968, "ORM_TRISTAN_1968" );
    public static final SRM_ORM_Code ORM_TRITON_1991
        = new SRM_ORM_Code( _ORM_TRITON_1991, "ORM_TRITON_1991" );
    public static final SRM_ORM_Code ORM_UMBRIEL_1988
        = new SRM_ORM_Code( _ORM_UMBRIEL_1988, "ORM_UMBRIEL_1988" );
    public static final SRM_ORM_Code ORM_URANUS_1988
        = new SRM_ORM_Code( _ORM_URANUS_1988, "ORM_URANUS_1988" );
    public static final SRM_ORM_Code ORM_URANUS_INERTIAL
        = new SRM_ORM_Code( _ORM_URANUS_INERTIAL, "ORM_URANUS_INERTIAL" );
    public static final SRM_ORM_Code ORM_URANUS_MAGNETIC_1993
        = new SRM_ORM_Code( _ORM_URANUS_MAGNETIC_1993, "ORM_URANUS_MAGNETIC_1993" );
    public static final SRM_ORM_Code ORM_VENUS_1991
        = new SRM_ORM_Code( _ORM_VENUS_1991, "ORM_VENUS_1991" );
    public static final SRM_ORM_Code ORM_VENUS_INERTIAL
        = new SRM_ORM_Code( _ORM_VENUS_INERTIAL, "ORM_VENUS_INERTIAL" );
    public static final SRM_ORM_Code ORM_VITI_LEVU_1916
        = new SRM_ORM_Code( _ORM_VITI_LEVU_1916, "ORM_VITI_LEVU_1916" );
    public static final SRM_ORM_Code ORM_VOIROL_1874
        = new SRM_ORM_Code( _ORM_VOIROL_1874, "ORM_VOIROL_1874" );
    public static final SRM_ORM_Code ORM_VOIROL_1874_PM_PARIS
        = new SRM_ORM_Code( _ORM_VOIROL_1874_PM_PARIS, "ORM_VOIROL_1874_PM_PARIS" );
    public static final SRM_ORM_Code ORM_VOIROL_1960
        = new SRM_ORM_Code( _ORM_VOIROL_1960, "ORM_VOIROL_1960" );
    public static final SRM_ORM_Code ORM_VOIROL_1960_PM_PARIS
        = new SRM_ORM_Code( _ORM_VOIROL_1960_PM_PARIS, "ORM_VOIROL_1960_PM_PARIS" );
    public static final SRM_ORM_Code ORM_WAKE_1952
        = new SRM_ORM_Code( _ORM_WAKE_1952, "ORM_WAKE_1952" );
    public static final SRM_ORM_Code ORM_WAKE_ENIWETOK_1960
        = new SRM_ORM_Code( _ORM_WAKE_ENIWETOK_1960, "ORM_WAKE_ENIWETOK_1960" );
    public static final SRM_ORM_Code ORM_WGS_1972
        = new SRM_ORM_Code( _ORM_WGS_1972, "ORM_WGS_1972" );
    public static final SRM_ORM_Code ORM_WGS_1984
        = new SRM_ORM_Code( _ORM_WGS_1984, "ORM_WGS_1984" );
    public static final SRM_ORM_Code ORM_YACARE_1987
        = new SRM_ORM_Code( _ORM_YACARE_1987, "ORM_YACARE_1987" );
    public static final SRM_ORM_Code ORM_ZANDERIJ_1987
        = new SRM_ORM_Code( _ORM_ZANDERIJ_1987, "ORM_ZANDERIJ_1987" );

    public static final SRM_ORM_Code ORM_EXPERIMENTAL_NGA_MAX
        = new SRM_ORM_Code( _ORM_EXPERIMENTAL_NGA_MAX, "ORM_EXPERIMENTAL_NGA_MAX" );
    public static final SRM_ORM_Code ORM_EXPERIMENTAL_NGA_SPHERE
        = new SRM_ORM_Code( _ORM_EXPERIMENTAL_NGA_SPHERE, "ORM_EXPERIMENTAL_NGA_SPHERE" );

    private SRM_ORM_Code(int code, String name)
    {
        super (code, name);
        _enumMap.put( name, this );
        if (code >= 0 && code < _totalEnum)
        {
            _enumVec.add( code, this );
        }
        else if (code == _ORM_EXPERIMENTAL_NGA_MAX)
        {
            _enumVec.add( _totalEnum, this );
        }
        else if (code == _ORM_EXPERIMENTAL_NGA_SPHERE)
        {
            _enumVec.add( _totalEnum+1, this );
        }
    }

    /** @return the SRM_ORM_Code from its enumerant value */
    public static SRM_ORM_Code getEnum( int enum_value ) throws SrmException
    {
        if (enum_value >= 0 && enum_value < _totalEnum )
            return (SRM_ORM_Code)(_enumVec.elementAt( enum_value ));
        else if (enum_value == _ORM_EXPERIMENTAL_NGA_MAX)
            return (SRM_ORM_Code)(_enumVec.elementAt( _totalEnum ));
        else if (enum_value == _ORM_EXPERIMENTAL_NGA_SPHERE)
            return (SRM_ORM_Code)(_enumVec.elementAt( _totalEnum+1 ));
        else
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_ORM_Code.getEnum: enumerant out of range") );
    }

    /** @return the SRM_ORM_Code from its string name */
    public static SRM_ORM_Code getEnum( String name ) throws SrmException
    {
        SRM_ORM_Code retCode = (SRM_ORM_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_ORM_Code.getEnum: enum. string not found") );

        return retCode;
    }
}
