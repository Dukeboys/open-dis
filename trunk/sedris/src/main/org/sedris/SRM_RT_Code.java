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
@brief Declaration of RT enumeration class.
*/
public class SRM_RT_Code extends Enum
{
    public static final int _totalEnum = 343;

    private static Vector _enumVec = new Vector( );

    private static HashMap _enumMap = new HashMap( );

    public static final int _RT_UNDEFINED = 0; /// Undefined
    public static final int _RT_ABSTRACT_2D_IDENTITY = 1; /// Universal
    public static final int _RT_ABSTRACT_3D_IDENTITY = 2; /// Universal
    public static final int _RT_ADINDAN_1991_BURKINA_FASO = 3; /// Burkina Faso
    public static final int _RT_ADINDAN_1991_CAMEROON = 4; /// Cameroon
    public static final int _RT_ADINDAN_1991_ETHIOPIA = 5; /// Ethiopia
    public static final int _RT_ADINDAN_1991_MALI = 6; /// Mali
    public static final int _RT_ADINDAN_1991_MEAN_SOLUTION = 7; /// Mean Solution (Ethiopia and Sudan)
    public static final int _RT_ADINDAN_1991_SENEGAL = 8; /// Senegal
    public static final int _RT_ADINDAN_1991_SUDAN = 9; /// Sudan
    public static final int _RT_ADRASTEA_2000_IDENTITY = 10; /// Global (Adrastea)
    public static final int _RT_AFGOOYE_1987_SOMALIA = 11; /// Somalia
    public static final int _RT_AIN_EL_ABD_1970_BAHRAIN_ISLAND = 12; /// Bahrain Island
    public static final int _RT_AIN_EL_ABD_1970_SAUDI_ARABIA = 13; /// Saudi Arabia
    public static final int _RT_AMALTHEA_2000_IDENTITY = 14; /// Global (Amalthea)
    public static final int _RT_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS = 15; /// American Samoa Islands
    public static final int _RT_ANNA_1_1965_COCOS_ISLANDS = 16; /// Cocos Islands
    public static final int _RT_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS = 17; /// Antigua and Leeward Islands
    public static final int _RT_ARC_1950_3_ZIMBABWE = 18; /// Zimbabwe
    public static final int _RT_ARC_1950_BOTSWANA = 19; /// Botswana
    public static final int _RT_ARC_1950_BURUNDI = 20; /// Burundi
    public static final int _RT_ARC_1950_LESOTHO = 21; /// Lesotho
    public static final int _RT_ARC_1950_MALAWI = 22; /// Malawi
    public static final int _RT_ARC_1950_MEAN_SOLUTION = 23; /// Mean Solution (Botswana, Lesotho, Malawi, Swaziland, Zaire, Zambia and Zimbabwe)
    public static final int _RT_ARC_1950_SWAZILAND = 24; /// Swaziland
    public static final int _RT_ARC_1950_ZAIRE = 25; /// Zaire
    public static final int _RT_ARC_1950_ZAMBIA = 26; /// Zambia
    public static final int _RT_ARC_1960_3_KENYA = 27; /// Kenya
    public static final int _RT_ARC_1960_MEAN_SOLUTION = 28; /// Mean Solution (Kenya and Tanzania)
    public static final int _RT_ARC_1960_TANZANIA = 29; /// Tanzania
    public static final int _RT_ARIEL_1988_IDENTITY = 30; /// Global (Ariel)
    public static final int _RT_ASCENSION_1958_ASCENSION_ISLAND = 31; /// Ascension Island
    public static final int _RT_ATLAS_1988_IDENTITY = 32; /// Global (Atlas)
    public static final int _RT_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA = 33; /// Australia and Tasmania
    public static final int _RT_AUSTRALIAN_GEOD_1984_3_AUSTRALIA_TASMANIA = 34; /// Australia and Tasmania
    public static final int _RT_AUSTRALIAN_GEOD_1984_7_AUSTRALIA_TASMANIA = 35; /// Australia and Tasmania
    public static final int _RT_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI = 36; /// Djibouti
    public static final int _RT_BEACON_E_1945_IWO_JIMA_ISLAND = 37; /// Iwo Jima Island
    public static final int _RT_BELINDA_1988_IDENTITY = 38; /// Global (Belinda)
    public static final int _RT_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS = 39; /// Efate and Erromango Islands (Vanuatu)
    public static final int _RT_BERMUDA_1957_BERMUDA = 40; /// Bermuda
    public static final int _RT_BIANCA_1988_IDENTITY = 41; /// Global (Bianca)
    public static final int _RT_BISSAU_1991_GUINEA_BISSAU = 42; /// Guinea-Bissau
    public static final int _RT_BOGOTA_OBS_1987_COLOMBIA = 43; /// Colombia
    public static final int _RT_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA = 44; /// Colombia
    public static final int _RT_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS = 45; /// Bangka and Belitung Islands (Indonesia)
    public static final int _RT_CALLISTO_2000_IDENTITY = 46; /// Global (Callisto)
    public static final int _RT_CALYPSO_1988_IDENTITY = 47; /// Global (Calypso)
    public static final int _RT_CAMP_AREA_1987_MCMURDO_CAMP = 48; /// McMurdo Camp Area (Antarctica)
    public static final int _RT_CAMPO_INCHAUSPE_1969_ARGENTINA = 49; /// Argentina
    public static final int _RT_CANTON_1966_PHOENIX_ISLANDS = 50; /// Phoenix Islands
    public static final int _RT_CAPE_1987_SOUTH_AFRICA = 51; /// South Africa
    public static final int _RT_CAPE_CANAVERAL_1991_MEAN_SOLUTION = 52; /// Mean Solution (Bahamas and Florida)
    public static final int _RT_CARTHAGE_1987_TUNISIA = 53; /// Tunisia
    public static final int _RT_CHARON_1991_IDENTITY = 54; /// Global (Charon)
    public static final int _RT_CHATHAM_1971_CHATHAM_ISLANDS = 55; /// Chatham Islands (New Zealand)
    public static final int _RT_CHUA_1987_PARAGUAY = 56; /// Paraguay
    public static final int _RT_COAMPS_1998_IDENTITY_BY_DEFAULT = 57; /// Global (Earth)
    public static final int _RT_CORDELIA_1988_IDENTITY = 58; /// Global (Cordelia)
    public static final int _RT_CORREGO_ALEGRE_1987_BRAZIL = 59; /// Brazil
    public static final int _RT_CRESSIDA_1988_IDENTITY = 60; /// Global (Cressida)
    public static final int _RT_DABOLA_1991_GUINEA = 61; /// Guinea
    public static final int _RT_DECEPTION_1993_DECEPTION_ISLAND = 62; /// Deception Island (Antarctica)
    public static final int _RT_DEIMOS_1988_IDENTITY = 63; /// Global (Deimos)
    public static final int _RT_DESDEMONA_1988_IDENTITY = 64; /// Global (Desdemona)
    public static final int _RT_DESPINA_1991_IDENTITY = 65; /// Global (Despina)
    public static final int _RT_DIONE_1982_IDENTITY = 66; /// Global (Dione)
    public static final int _RT_DJAKARTA_1987_PM_DJAKARTA_SUMATRA = 67; /// Sumatra (Indonesia)
    public static final int _RT_DJAKARTA_1987_SUMATRA = 68; /// Sumatra (Indonesia)
    public static final int _RT_DOS_1968_GIZO_ISLAND = 69; /// Gizo Island (New Georgia Islands)
    public static final int _RT_DOS_71_4_1987_ST_HELENA_ISLAND = 70; /// St. Helena Island
    public static final int _RT_EASTER_1967_EASTER_ISLAND = 71; /// Easter Island
    public static final int _RT_ENCELADUS_1994_IDENTITY = 72; /// Global (Enceladus)
    public static final int _RT_EPIMETHEUS_1988_IDENTITY = 73; /// Global (Epimetheus)
    public static final int _RT_EROS_2000_IDENTITY = 74; /// Global (Eros)
    public static final int _RT_ESTONIA_1937_ESTONIA = 75; /// Estonia
    public static final int _RT_ETRS_1989_IDENTITY_BY_MEASUREMENT = 76; /// Europe
    public static final int _RT_EUROPA_2000_IDENTITY = 77; /// Global (Europa)
    public static final int _RT_EUROPE_1950_3_CYPRUS = 78; /// Cyprus
    public static final int _RT_EUROPE_1950_CHANNEL_ISLANDS = 79; /// Channel Islands
    public static final int _RT_EUROPE_1950_EGYPT = 80; /// Egypt
    public static final int _RT_EUROPE_1950_ENGLAND_SCOTLAND = 81; /// England, Scotland, Channel Islands and Shetland Islands
    public static final int _RT_EUROPE_1950_GREECE = 82; /// Greece
    public static final int _RT_EUROPE_1950_IRAN = 83; /// Iran
    public static final int _RT_EUROPE_1950_IRAQ = 84; /// Iraq
    public static final int _RT_EUROPE_1950_IRELAND = 85; /// Ireland, Northern Ireland, Wales, England, Scotland, Channel Islands, and Shetland Islands
    public static final int _RT_EUROPE_1950_MALTA = 86; /// Malta
    public static final int _RT_EUROPE_1950_MEAN_SOLUTION = 87; /// Mean Solution (Austria, Belgium, Denmark, Finland, France, FRG, Gibraltar, Greece, Italy, Luxembourg, Netherlands, Norway, Portugal, Spain, Sweden and Switzerland)
    public static final int _RT_EUROPE_1950_NORWAY = 88; /// Finland and Norway
    public static final int _RT_EUROPE_1950_PORTUGAL_SPAIN = 89; /// Portugal and Spain
    public static final int _RT_EUROPE_1950_SARDINIA = 90; /// Sardinia (Italy)
    public static final int _RT_EUROPE_1950_SICILY = 91; /// Sicily (Italy)
    public static final int _RT_EUROPE_1950_TUNISIA = 92; /// Tunisia
    public static final int _RT_EUROPE_1950_W_EUROPE_MEAN_SOLUTION = 93; /// Western Europe Mean Solution (Austria, Denmark, France, FRG, Netherlands and Switzerland)
    public static final int _RT_EUROPE_1979_MEAN_SOLUTION = 94; /// Mean Solution (Austria, Finland, Netherlands, Norway, Spain, Sweden and Switzerland)
    public static final int _RT_FAHUD_1987_3_OMAN = 95; /// Oman
    public static final int _RT_FAHUD_1987_7_OMAN = 96; /// Oman
    public static final int _RT_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS = 97; /// St. Kitts, Nevis and Leeward Islands
    public static final int _RT_GALATEA_1991_IDENTITY = 98; /// Global (Galatea)
    public static final int _RT_GAN_1970_MALDIVES = 99; /// Republic of Maldives
    public static final int _RT_GANYMEDE_2000_IDENTITY = 100; /// Global (Ganymede)
    public static final int _RT_GASPRA_1991_IDENTITY = 101; /// Global (Gaspra)
    public static final int _RT_GDA_1994_IDENTITY_BY_MEASUREMENT = 102; /// Australia
    public static final int _RT_GEODETIC_DATUM_1949_3_NEW_ZEALAND = 103; /// New Zealand
    public static final int _RT_GEODETIC_DATUM_1949_7_NEW_ZEALAND = 104; /// New Zealand
    public static final int _RT_GEOMAGNETIC_1945_DGRF = 105; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1950_DGRF = 106; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1955_DGRF = 107; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1960_DGRF = 108; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1965_DGRF = 109; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1970_DGRF = 110; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1975_DGRF = 111; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1980_DGRF = 112; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1985_DGRF = 113; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1990_DGRF = 114; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_1995_IGRF = 115; /// Global (Earth)
    public static final int _RT_GEOMAGNETIC_2000_IGRF = 116; /// Global (Earth)
    public static final int _RT_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES = 117; /// Central Azores (Faial, Graciosa, Pico, Sao Jorge and Terceira Islands)
    public static final int _RT_GUAM_1963_GUAM = 118; /// Guam
    public static final int _RT_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND = 119; /// Kalimantan Island (Indonesia)
    public static final int _RT_GUX_1_1987_GUADALCANAL_ISLAND = 120; /// Guadalcanal Island
    public static final int _RT_HELENE_1992_IDENTITY = 121; /// Global (Helene)
    public static final int _RT_HERAT_NORTH_1987_AFGHANISTAN = 122; /// Afghanistan
    public static final int _RT_HERMANNSKOGEL_1871_3_YUGOSLAVIA = 123; /// Yugoslavia (prior to 1990), Slovenia, Croatia, Bosnia and Herzegovina, and Serbia
    public static final int _RT_HJORSEY_1955_ICELAND = 124; /// Iceland
    public static final int _RT_HONG_KONG_1963_HONG_KONG = 125; /// Hong Kong
    public static final int _RT_HU_TZU_SHAN_1991_TAIWAN = 126; /// Taiwan
    public static final int _RT_IAPETUS_1988_IDENTITY = 127; /// Global (Iapetus)
    public static final int _RT_IDA_1991_IDENTITY = 128; /// Global (Ida)
    public static final int _RT_INDIAN_1916_3_BANGLADESH = 129; /// Bangladesh
    public static final int _RT_INDIAN_1916_7_BANGLADESH = 130; /// Bangladesh
    public static final int _RT_INDIAN_1954_THAILAND = 131; /// Thailand
    public static final int _RT_INDIAN_1956_INDIA_NEPAL = 132; /// India and Nepal
    public static final int _RT_INDIAN_1960_CON_SON_ISLAND = 133; /// Con Son Island (Vietnam)
    public static final int _RT_INDIAN_1960_VIETNAM_16_N = 134; /// Vietnam (near 16 deg. N)
    public static final int _RT_INDIAN_1962_PAKISTAN = 135; /// Pakistan
    public static final int _RT_INDIAN_1975_1991_THAILAND = 136; /// Thailand
    public static final int _RT_INDIAN_1975_1997_THAILAND = 137; /// Thailand
    public static final int _RT_INDONESIAN_1974_INDONESIA = 138; /// Indonesia
    public static final int _RT_IO_2000_IDENTITY = 139; /// Global (Io)
    public static final int _RT_IRELAND_1965_3_IRELAND = 140; /// Ireland
    public static final int _RT_IRELAND_1965_7_IRELAND = 141; /// Ireland
    public static final int _RT_ISTS_061_1968_SOUTH_GEORGIA_ISLAND = 142; /// South Georgia Island
    public static final int _RT_ISTS_073_1969_DIEGO_GARCIA = 143; /// Diego Garcia
    public static final int _RT_JANUS_1988_IDENTITY = 144; /// Global (Janus)
    public static final int _RT_JGD_2000_IDENTITY_BY_MEASUREMENT = 145; /// Japan
    public static final int _RT_JOHNSTON_1961_JOHNSTON_ISLAND = 146; /// Johnston Island
    public static final int _RT_JULIET_1988_IDENTITY = 147; /// Global (Juliet)
    public static final int _RT_JUPITER_1988_IDENTITY = 148; /// Global (Jupiter)
    public static final int _RT_JUPITER_MAGNETIC_1993_VOYAGER = 149; /// Global (Jupiter)
    public static final int _RT_KANDAWALA_1987_3_SRI_LANKA = 150; /// Sri Lanka
    public static final int _RT_KERGUELEN_1949_KERGUELEN_ISLAND = 151; /// Kerguelen Island
    public static final int _RT_KERTAU_1948_3_W_MALAYSIA_SINGAPORE = 152; /// West Malaysia and Singapore
    public static final int _RT_KOREAN_GEODETIC_1995_SOUTH_KOREA = 153; /// South Korea
    public static final int _RT_KUSAIE_1951_CAROLINE_ISLANDS = 154; /// Caroline Islands (Federated States of Micronesia)
    public static final int _RT_LARISSA_1991_IDENTITY = 155; /// Global (Larissa)
    public static final int _RT_LC5_1961_CAYMAN_BRAC_ISLAND = 156; /// Cayman Brac Island
    public static final int _RT_LEIGON_1991_3_GHANA = 157; /// Ghana
    public static final int _RT_LEIGON_1991_7_GHANA = 158; /// Ghana
    public static final int _RT_LIBERIA_1964_LIBERIA = 159; /// Liberia
    public static final int _RT_LUZON_1987_MINDANAO_ISLAND = 160; /// Mindanao Island (Philippines)
    public static final int _RT_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND = 161; /// Philippines (excluding Mindanao Island)
    public static final int _RT_M_PORALOKO_1991_GABON = 162; /// Gabon
    public static final int _RT_MAHE_1971_MAHE_ISLAND = 163; /// Mahe Island (Seychelles)
    public static final int _RT_MARCUS_STATION_1952_MARCUS_ISLANDS = 164; /// Marcus Islands
    public static final int _RT_MARS_2000_IDENTITY = 165; /// Global (Mars)
    public static final int _RT_MARS_SPHERE_2000_GLOBAL = 166; /// Global (Mars)
    public static final int _RT_MASS_1999_IDENTITY_BY_DEFAULT = 167; /// Global (Earth)
    public static final int _RT_MASSAWA_1987_ERITREA_ETHIOPIA = 168; /// Eritrea and Ethiopia
    public static final int _RT_MERCHICH_1987_MOROCCO = 169; /// Morocco
    public static final int _RT_MERCURY_1988_IDENTITY = 170; /// Global (Mercury)
    public static final int _RT_METIS_2000_IDENTITY = 171; /// Global (Metis)
    public static final int _RT_MIDWAY_1961_MIDWAY_ISLANDS = 172; /// Midway Islands
    public static final int _RT_MIMAS_1994_IDENTITY = 173; /// Global (Mimas)
    public static final int _RT_MINNA_1991_CAMEROON = 174; /// Cameroon
    public static final int _RT_MINNA_1991_NIGERIA = 175; /// Nigeria
    public static final int _RT_MIRANDA_1988_IDENTITY = 176; /// Global (Miranda)
    public static final int _RT_MM5_1997_IDENTITY_BY_DEFAULT = 177; /// Global (Earth)
    public static final int _RT_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT = 178; /// Northern midlatitude regions (Earth)
    public static final int _RT_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT = 179; /// Southern midlatitude regions (Earth)
    public static final int _RT_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT = 180; /// Northern subarctic regions (Earth)
    public static final int _RT_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT = 181; /// Southern subarctic regions (Earth)
    public static final int _RT_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT = 182; /// Tropical regions (Earth)
    public static final int _RT_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS = 183; /// Montserrat and Leeward Islands
    public static final int _RT_MOON_1991_IDENTITY = 184; /// Global (Moon)
    public static final int _RT_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT = 185; /// Global (Earth)
    public static final int _RT_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS = 186; /// Alaska (excluding Aleutian Islands)
    public static final int _RT_N_AM_1927_ALBERTA_BRITISH_COLUMBIA = 187; /// Canada (Alberta and British Columbia)
    public static final int _RT_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND = 188; /// Bahamas (excluding San Salvador Island)
    public static final int _RT_N_AM_1927_CANADA = 189; /// Canada
    public static final int _RT_N_AM_1927_CANAL_ZONE = 190; /// Canal Zone
    public static final int _RT_N_AM_1927_CARIBBEAN = 191; /// Caribbean (Antigua Island, Barbados, Barbuda, Caicos Islands, Cuba, Dominican Republic, Grand Cayman, Jamaica and Turks Islands)
    public static final int _RT_N_AM_1927_CENTRAL_AMERICA = 192; /// Central America (Belize, Costa Rica, El Salvador, Guatemala, Honduras and Nicaragua)
    public static final int _RT_N_AM_1927_CONTINENTAL_US = 193; /// Continental United States Mean Solution
    public static final int _RT_N_AM_1927_CUBA = 194; /// Cuba
    public static final int _RT_N_AM_1927_EAST_ALEUTIAN_ISLANDS = 195; /// Aleutian Islands (east of 180 deg. W)
    public static final int _RT_N_AM_1927_EASTERN_CANADA = 196; /// Eastern Canada (New Brunswick, Newfoundland, Nova Scotia and Quebec)
    public static final int _RT_N_AM_1927_EASTERN_US = 197; /// Eastern United States (Alabama, Connecticut, Delaware, District of Columbia, Florida, Georgia, Illinois, Indiana, Kentucky, Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, New Hampshire, New Jersey, New York, North Carolina, Ohio, Pennsylvania, Rhode Island, South Carolina, Tennessee, Vermont, Virginia, West Virginia and Wisconsin)
    public static final int _RT_N_AM_1927_HAYES_PENINSULA = 198; /// Hayes Peninsula (Greenland)
    public static final int _RT_N_AM_1927_MANITOBA_ONTARIO = 199; /// Canada (Manitoba and Ontario)
    public static final int _RT_N_AM_1927_MEXICO = 200; /// Mexico
    public static final int _RT_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN = 201; /// Canada (Northwest Territories and Saskatchewan)
    public static final int _RT_N_AM_1927_SAN_SALVADOR_ISLAND = 202; /// San Salvador Island
    public static final int _RT_N_AM_1927_WEST_ALEUTIAN_ISLANDS = 203; /// Aleutian Islands (west of 180 deg. W)
    public static final int _RT_N_AM_1927_WESTERN_US = 204; /// Western United States (Arizona, Arkansas, California, Colorado, Idaho, Iowa, Kansas, Montana, Nebraska, Nevada, New Mexico, North Dakota, Oklahoma, Oregon, South Dakota, Texas, Utah, Washington and Wyoming)
    public static final int _RT_N_AM_1927_YUKON = 205; /// Canada (Yukon)
    public static final int _RT_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS = 206; /// Alaska (excluding Aleutian Islands)
    public static final int _RT_N_AM_1983_ALEUTIAN_ISLANDS = 207; /// Aleutian Islands
    public static final int _RT_N_AM_1983_CANADA = 208; /// Canada
    public static final int _RT_N_AM_1983_CONTINENTAL_US = 209; /// Continental United States
    public static final int _RT_N_AM_1983_HAWAII = 210; /// Hawaii
    public static final int _RT_N_AM_1983_MEXICO_CENTRAL_AMERICA = 211; /// Mexico and Central America
    public static final int _RT_N_SAHARA_1959_ALGERIA = 212; /// Algeria
    public static final int _RT_NAHRWAN_1987_MASIRAH_ISLAND = 213; /// Masirah Island (Oman)
    public static final int _RT_NAHRWAN_1987_SAUDI_ARABIA = 214; /// Saudi Arabia
    public static final int _RT_NAHRWAN_1987_UNITED_ARAB_EMIRATES = 215; /// United Arab Emirates
    public static final int _RT_NAIAD_1991_IDENTITY = 216; /// Global (Naiad)
    public static final int _RT_NAPARIMA_1991_TRINIDAD_TOBAGO = 217; /// Trinidad and Tobago (British West Indies)
    public static final int _RT_NEPTUNE_1991_IDENTITY = 218; /// Global (Neptune)
    public static final int _RT_NEPTUNE_MAGNETIC_1993_VOYAGER = 219; /// Global (Neptune)
    public static final int _RT_NOGAPS_1988_IDENTITY_BY_DEFAULT = 220; /// Global (Earth)
    public static final int _RT_NTF_1896_FRANCE = 221; /// France
    public static final int _RT_NTF_1896_PM_PARIS_FRANCE = 222; /// France
    public static final int _RT_OBERON_1988_IDENTITY = 223; /// Global (Oberon)
    public static final int _RT_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS = 224; /// Corvo Flores Islands (Azores)
    public static final int _RT_OLD_EGYPTIAN_1907_EGYPT = 225; /// Egypt
    public static final int _RT_OLD_HAWAIIAN_CLARKE_1987_HAWAII = 226; /// Hawaii (US)
    public static final int _RT_OLD_HAWAIIAN_CLARKE_1987_KAUAI = 227; /// Kauai (US)
    public static final int _RT_OLD_HAWAIIAN_CLARKE_1987_MAUI = 228; /// Maui (US)
    public static final int _RT_OLD_HAWAIIAN_CLARKE_1987_MEAN_SOLUTION = 229; /// Mean Solution (Hawaii (US))
    public static final int _RT_OLD_HAWAIIAN_CLARKE_1987_OAHU = 230; /// Oahu (US)
    public static final int _RT_OLD_HAWAIIAN_INT_1987_HAWAII = 231; /// Hawaii (US)
    public static final int _RT_OLD_HAWAIIAN_INT_1987_KAUAI = 232; /// Kauai (US)
    public static final int _RT_OLD_HAWAIIAN_INT_1987_MAUI = 233; /// Maui (US)
    public static final int _RT_OLD_HAWAIIAN_INT_1987_MEAN_SOLUTION = 234; /// Mean Solution (Hawaii (US))
    public static final int _RT_OLD_HAWAIIAN_INT_1987_OAHU = 235; /// Oahu (US)
    public static final int _RT_OPHELIA_1988_IDENTITY = 236; /// Global (Ophelia)
    public static final int _RT_OSGB_1936_3_MEAN_SOLUTION = 237; /// Mean Solution (England, Isle of Man, Scotland, Shetland, and Wales)
    public static final int _RT_OSGB_1936_7_GREAT_BRITAIN = 238; /// Great Britain
    public static final int _RT_OSGB_1936_ENGLAND = 239; /// England
    public static final int _RT_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES = 240; /// England, Isle of Man, and Wales
    public static final int _RT_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS = 241; /// Scotland and Shetland Islands
    public static final int _RT_OSGB_1936_WALES = 242; /// Wales
    public static final int _RT_PAN_1991_IDENTITY = 243; /// Global (Pan)
    public static final int _RT_PANDORA_1988_IDENTITY = 244; /// Global (Pandora)
    public static final int _RT_PHOBOS_1988_IDENTITY = 245; /// Global (Phobos)
    public static final int _RT_PHOEBE_1988_IDENTITY = 246; /// Global (Phoebe)
    public static final int _RT_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS = 247; /// Canary Islands (Spain)
    public static final int _RT_PITCAIRN_1967_PITCAIRN_ISLAND = 248; /// Pitcairn Island
    public static final int _RT_PLUTO_1994_IDENTITY = 249; /// Global (Pluto)
    public static final int _RT_POINT_58_1991_MEAN_SOLUTION = 250; /// Mean Solution (Burkina Faso and Niger)
    public static final int _RT_POINTE_NOIRE_1948_CONGO = 251; /// Congo
    public static final int _RT_PORTIA_1988_IDENTITY = 252; /// Global (Portia)
    public static final int _RT_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS = 253; /// Porto Santo and Madeira Islands
    public static final int _RT_PROMETHEUS_1988_IDENTITY = 254; /// Global (Prometheus)
    public static final int _RT_PROTEUS_1991_IDENTITY = 255; /// Global (Proteus)
    public static final int _RT_PROV_S_AM_1956_3_VENEZUELA = 256; /// Venezuela
    public static final int _RT_PROV_S_AM_1956_7_VENEZUELA = 257; /// Venezuela
    public static final int _RT_PROV_S_AM_1956_BOLIVIA = 258; /// Bolivia
    public static final int _RT_PROV_S_AM_1956_COLOMBIA = 259; /// Colombia
    public static final int _RT_PROV_S_AM_1956_ECUADOR = 260; /// Ecuador
    public static final int _RT_PROV_S_AM_1956_GUYANA = 261; /// Guyana
    public static final int _RT_PROV_S_AM_1956_MEAN_SOLUTION = 262; /// Mean Solution (Bolivia, Chile, Colombia, Ecuador, Guyana, Peru and Venezuela)
    public static final int _RT_PROV_S_AM_1956_N_CHILE_19_S = 263; /// Northern Chile (near 19 deg. S)
    public static final int _RT_PROV_S_AM_1956_PERU = 264; /// Peru
    public static final int _RT_PROV_S_AM_1956_S_CHILE_43_S = 265; /// Southern Chile (near 43 deg. S)
    public static final int _RT_PROV_S_CHILEAN_1963_SOUTH_CHILE = 266; /// South Chile (near 53 deg. S)
    public static final int _RT_PUCK_1988_IDENTITY = 267; /// Global (Puck)
    public static final int _RT_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS = 268; /// Puerto Rico and Virgin Islands
    public static final int _RT_PULKOVO_1942_RUSSIA = 269; /// Russia
    public static final int _RT_QATAR_NATIONAL_1974_3_QATAR = 270; /// Qatar
    public static final int _RT_QORNOQ_1987_SOUTH_GREENLAND = 271; /// South Greenland
    public static final int _RT_REUNION_1947_MASCARENE_ISLANDS = 272; /// Mascarene Islands
    public static final int _RT_RGF_1993_IDENTITY_BY_MEASUREMENT = 273; /// France
    public static final int _RT_RHEA_1988_IDENTITY = 274; /// Global (Rhea)
    public static final int _RT_ROME_1940_PM_ROME_SARDINIA = 275; /// Sardinia (Italy)
    public static final int _RT_ROME_1940_SARDINIA = 276; /// Sardinia (Italy)
    public static final int _RT_ROSALIND_1988_IDENTITY = 277; /// Global (Rosalind)
    public static final int _RT_S_AM_1969_ARGENTINA = 278; /// Argentina
    public static final int _RT_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS = 279; /// Baltra and Galapagos Islands (Ecuador)
    public static final int _RT_S_AM_1969_BOLIVIA = 280; /// Bolivia
    public static final int _RT_S_AM_1969_BRAZIL = 281; /// Brazil
    public static final int _RT_S_AM_1969_CHILE = 282; /// Chile
    public static final int _RT_S_AM_1969_COLOMBIA = 283; /// Colombia
    public static final int _RT_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS = 284; /// Ecuador (excluding Galapagos Islands)
    public static final int _RT_S_AM_1969_GUYANA = 285; /// Guyana
    public static final int _RT_S_AM_1969_MEAN_SOLUTION = 286; /// Mean Solution (Argentina, Bolivia, Brazil, Chile, Colombia, Ecuador, Guyana, Paraguay, Peru, Trinidad and Tobago, and Venezuela)
    public static final int _RT_S_AM_1969_PARAGUAY = 287; /// Paraguay
    public static final int _RT_S_AM_1969_PERU = 288; /// Peru
    public static final int _RT_S_AM_1969_TRINIDAD_TOBAGO = 289; /// Trinidad and Tobago (British West Indies)
    public static final int _RT_S_AM_1969_VENEZUELA = 290; /// Venezuela
    public static final int _RT_S_ASIA_1987_SINGAPORE = 291; /// Singapore
    public static final int _RT_S_JTSK_1993_CZECH_REP = 292; /// Czech Republic
    public static final int _RT_S_JTSK_1993_CZECH_REP_SLOVAKIA = 293; /// Czech Republic and Slovakia
    public static final int _RT_S42_PULKOVO_3_POLAND = 294; /// Poland
    public static final int _RT_S42_PULKOVO_ALBANIA = 295; /// Albania
    public static final int _RT_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA = 296; /// Czech Republic and Slovakia
    public static final int _RT_S42_PULKOVO_G_ROMANIA = 297; /// Romania
    public static final int _RT_S42_PULKOVO_HUNGARY = 298; /// Hungary
    public static final int _RT_S42_PULKOVO_KAZAKHSTAN = 299; /// Kazakhstan
    public static final int _RT_S42_PULKOVO_LATVIA = 300; /// Latvia
    public static final int _RT_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND = 301; /// Espirito Santo Island (Vanuatu)
    public static final int _RT_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS = 302; /// Sao Miguel and Santa Maria Islands (Azores)
    public static final int _RT_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS = 303; /// East Falkland Islands
    public static final int _RT_SATURN_1988_IDENTITY = 304; /// Global (Saturn)
    public static final int _RT_SATURN_MAGNETIC_1993_VOYAGER = 305; /// Global (Saturn)
    public static final int _RT_SCHWARZECK_1991_NAMIBIA = 306; /// Namibia
    public static final int _RT_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS = 307; /// Salvage Islands (Ilhas Selvagens; Savage Islands)
    public static final int _RT_SIERRA_LEONE_1960_SIERRA_LEONE = 308; /// Sierra Leone
    public static final int _RT_SIRGAS_2000_IDENTITY_BY_MEASUREMENT = 309; /// South America
    public static final int _RT_SUN_1992_IDENTITY = 310; /// Global (Sun)
    public static final int _RT_TANANARIVE_OBS_1925_3_MADAGASCAR = 311; /// Madagascar
    public static final int _RT_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR = 312; /// Madagascar
    public static final int _RT_TELESTO_1988_IDENTITY = 313; /// Global (Telesto)
    public static final int _RT_TERN_1961_TERN_ISLAND = 314; /// Tern Island (French Frigate Shoals, Hawaiian Islands)
    public static final int _RT_TETHYS_1991_IDENTITY = 315; /// Global (Tethys)
    public static final int _RT_THALASSA_1991_IDENTITY = 316; /// Global (Thalassa)
    public static final int _RT_THEBE_2000_IDENTITY = 317; /// Global (Thebe)
    public static final int _RT_TIMBALAI_EVEREST_1948_3_BRUNEI_E_MALAYSIA = 318; /// Brunei and East Malaysia (Sabah and Sarawak)
    public static final int _RT_TIMBALAI_EVEREST_1948_7_BRUNEI_E_MALAYSIA = 319; /// Brunei and East Malaysia (Sabah and Sarawak)
    public static final int _RT_TITAN_1982_IDENTITY = 320; /// Global (Titan)
    public static final int _RT_TITANIA_1988_IDENTITY = 321; /// Global (Titania)
    public static final int _RT_TOKYO_1991_JAPAN = 322; /// Japan
    public static final int _RT_TOKYO_1991_MEAN_SOLUTION = 323; /// Mean Solution (Japan, Korea, and Okinawa)
    public static final int _RT_TOKYO_1991_OKINAWA = 324; /// Okinawa (Japan)
    public static final int _RT_TOKYO_1991_1991_SOUTH_KOREA = 325; /// South Korea
    public static final int _RT_TOKYO_1991_1997_SOUTH_KOREA = 326; /// South Korea
    public static final int _RT_TRISTAN_1968_TRISTAN_DA_CUNHA = 327; /// Tristan da Cunha
    public static final int _RT_TRITON_1991_IDENTITY = 328; /// Global (Triton)
    public static final int _RT_UMBRIEL_1988_IDENTITY = 329; /// Global (Umbriel)
    public static final int _RT_URANUS_1988_IDENTITY = 330; /// Global (Uranus)
    public static final int _RT_URANUS_MAGNETIC_1993_VOYAGER = 331; /// Global (Uranus)
    public static final int _RT_VENUS_1991_IDENTITY = 332; /// Global (Venus)
    public static final int _RT_VITI_LEVU_1916_VITI_LEVU_ISLANDS = 333; /// Viti Levu Island (Fiji Islands)
    public static final int _RT_VOIROL_1874_ALGERIA = 334; /// Algeria
    public static final int _RT_VOIROL_1874_PM_PARIS_ALGERIA = 335; /// Algeria
    public static final int _RT_VOIROL_1960_ALGERIA = 336; /// Algeria
    public static final int _RT_VOIROL_1960_PM_PARIS_ALGERIA = 337; /// Algeria
    public static final int _RT_WAKE_1952_WAKE_ATOLL = 338; /// Wake Atoll
    public static final int _RT_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS = 339; /// Marshall Islands
    public static final int _RT_WGS_1972_GLOBAL = 340; /// Global (Earth)
    public static final int _RT_WGS_1984_IDENTITY = 341; /// Global (Earth)
    public static final int _RT_YACARE_1987_URUGUAY = 342; /// Uruguay
    public static final int _RT_ZANDERIJ_1987_SURINAME = 343; /// Suriname

    public static final SRM_RT_Code RT_UNDEFINED
        = new SRM_RT_Code( _RT_UNDEFINED, "RT_UNDEFINED" );

    public static final SRM_RT_Code RT_ABSTRACT_2D_IDENTITY
        = new SRM_RT_Code( _RT_ABSTRACT_2D_IDENTITY, "RT_ABSTRACT_2D_IDENTITY" );
    public static final SRM_RT_Code RT_ABSTRACT_3D_IDENTITY
        = new SRM_RT_Code( _RT_ABSTRACT_3D_IDENTITY, "RT_ABSTRACT_3D_IDENTITY" );
    public static final SRM_RT_Code RT_ADINDAN_1991_BURKINA_FASO
        = new SRM_RT_Code( _RT_ADINDAN_1991_BURKINA_FASO, "RT_ADINDAN_1991_BURKINA_FASO" );
    public static final SRM_RT_Code RT_ADINDAN_1991_CAMEROON
        = new SRM_RT_Code( _RT_ADINDAN_1991_CAMEROON, "RT_ADINDAN_1991_CAMEROON" );
    public static final SRM_RT_Code RT_ADINDAN_1991_ETHIOPIA
        = new SRM_RT_Code( _RT_ADINDAN_1991_ETHIOPIA, "RT_ADINDAN_1991_ETHIOPIA" );
    public static final SRM_RT_Code RT_ADINDAN_1991_MALI
        = new SRM_RT_Code( _RT_ADINDAN_1991_MALI, "RT_ADINDAN_1991_MALI" );
    public static final SRM_RT_Code RT_ADINDAN_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_ADINDAN_1991_MEAN_SOLUTION, "RT_ADINDAN_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_ADINDAN_1991_SENEGAL
        = new SRM_RT_Code( _RT_ADINDAN_1991_SENEGAL, "RT_ADINDAN_1991_SENEGAL" );
    public static final SRM_RT_Code RT_ADINDAN_1991_SUDAN
        = new SRM_RT_Code( _RT_ADINDAN_1991_SUDAN, "RT_ADINDAN_1991_SUDAN" );
    public static final SRM_RT_Code RT_ADRASTEA_2000_IDENTITY
        = new SRM_RT_Code( _RT_ADRASTEA_2000_IDENTITY, "RT_ADRASTEA_2000_IDENTITY" );
    public static final SRM_RT_Code RT_AFGOOYE_1987_SOMALIA
        = new SRM_RT_Code( _RT_AFGOOYE_1987_SOMALIA, "RT_AFGOOYE_1987_SOMALIA" );
    public static final SRM_RT_Code RT_AIN_EL_ABD_1970_BAHRAIN_ISLAND
        = new SRM_RT_Code( _RT_AIN_EL_ABD_1970_BAHRAIN_ISLAND, "RT_AIN_EL_ABD_1970_BAHRAIN_ISLAND" );
    public static final SRM_RT_Code RT_AIN_EL_ABD_1970_SAUDI_ARABIA
        = new SRM_RT_Code( _RT_AIN_EL_ABD_1970_SAUDI_ARABIA, "RT_AIN_EL_ABD_1970_SAUDI_ARABIA" );
    public static final SRM_RT_Code RT_AMALTHEA_2000_IDENTITY
        = new SRM_RT_Code( _RT_AMALTHEA_2000_IDENTITY, "RT_AMALTHEA_2000_IDENTITY" );
    public static final SRM_RT_Code RT_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS
        = new SRM_RT_Code( _RT_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS, "RT_AMERICAN_SAMOA_1962_AMERICAN_SAMOA_ISLANDS" );
    public static final SRM_RT_Code RT_ANNA_1_1965_COCOS_ISLANDS
        = new SRM_RT_Code( _RT_ANNA_1_1965_COCOS_ISLANDS, "RT_ANNA_1_1965_COCOS_ISLANDS" );
    public static final SRM_RT_Code RT_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS
        = new SRM_RT_Code( _RT_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS, "RT_ANTIGUA_1943_ANTIGUA_LEEWARD_ISLANDS" );
    public static final SRM_RT_Code RT_ARC_1950_3_ZIMBABWE
        = new SRM_RT_Code( _RT_ARC_1950_3_ZIMBABWE, "RT_ARC_1950_3_ZIMBABWE" );
    public static final SRM_RT_Code RT_ARC_1950_BOTSWANA
        = new SRM_RT_Code( _RT_ARC_1950_BOTSWANA, "RT_ARC_1950_BOTSWANA" );
    public static final SRM_RT_Code RT_ARC_1950_BURUNDI
        = new SRM_RT_Code( _RT_ARC_1950_BURUNDI, "RT_ARC_1950_BURUNDI" );
    public static final SRM_RT_Code RT_ARC_1950_LESOTHO
        = new SRM_RT_Code( _RT_ARC_1950_LESOTHO, "RT_ARC_1950_LESOTHO" );
    public static final SRM_RT_Code RT_ARC_1950_MALAWI
        = new SRM_RT_Code( _RT_ARC_1950_MALAWI, "RT_ARC_1950_MALAWI" );
    public static final SRM_RT_Code RT_ARC_1950_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_ARC_1950_MEAN_SOLUTION, "RT_ARC_1950_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_ARC_1950_SWAZILAND
        = new SRM_RT_Code( _RT_ARC_1950_SWAZILAND, "RT_ARC_1950_SWAZILAND" );
    public static final SRM_RT_Code RT_ARC_1950_ZAIRE
        = new SRM_RT_Code( _RT_ARC_1950_ZAIRE, "RT_ARC_1950_ZAIRE" );
    public static final SRM_RT_Code RT_ARC_1950_ZAMBIA
        = new SRM_RT_Code( _RT_ARC_1950_ZAMBIA, "RT_ARC_1950_ZAMBIA" );
    public static final SRM_RT_Code RT_ARC_1960_3_KENYA
        = new SRM_RT_Code( _RT_ARC_1960_3_KENYA, "RT_ARC_1960_3_KENYA" );
    public static final SRM_RT_Code RT_ARC_1960_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_ARC_1960_MEAN_SOLUTION, "RT_ARC_1960_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_ARC_1960_TANZANIA
        = new SRM_RT_Code( _RT_ARC_1960_TANZANIA, "RT_ARC_1960_TANZANIA" );
    public static final SRM_RT_Code RT_ARIEL_1988_IDENTITY
        = new SRM_RT_Code( _RT_ARIEL_1988_IDENTITY, "RT_ARIEL_1988_IDENTITY" );
    public static final SRM_RT_Code RT_ASCENSION_1958_ASCENSION_ISLAND
        = new SRM_RT_Code( _RT_ASCENSION_1958_ASCENSION_ISLAND, "RT_ASCENSION_1958_ASCENSION_ISLAND" );
    public static final SRM_RT_Code RT_ATLAS_1988_IDENTITY
        = new SRM_RT_Code( _RT_ATLAS_1988_IDENTITY, "RT_ATLAS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA
        = new SRM_RT_Code( _RT_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA, "RT_AUSTRALIAN_GEOD_1966_AUSTRALIA_TASMANIA" );
    public static final SRM_RT_Code RT_AUSTRALIAN_GEOD_1984_3_AUSTRALIA_TASMANIA
        = new SRM_RT_Code( _RT_AUSTRALIAN_GEOD_1984_3_AUSTRALIA_TASMANIA, "RT_AUSTRALIAN_GEOD_1984_3_AUSTRALIA_TASMANIA" );
    public static final SRM_RT_Code RT_AUSTRALIAN_GEOD_1984_7_AUSTRALIA_TASMANIA
        = new SRM_RT_Code( _RT_AUSTRALIAN_GEOD_1984_7_AUSTRALIA_TASMANIA, "RT_AUSTRALIAN_GEOD_1984_7_AUSTRALIA_TASMANIA" );
    public static final SRM_RT_Code RT_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI
        = new SRM_RT_Code( _RT_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI, "RT_AYABELLE_LIGHTHOUSE_1991_DJIBOUTI" );
    public static final SRM_RT_Code RT_BEACON_E_1945_IWO_JIMA_ISLAND
        = new SRM_RT_Code( _RT_BEACON_E_1945_IWO_JIMA_ISLAND, "RT_BEACON_E_1945_IWO_JIMA_ISLAND" );
    public static final SRM_RT_Code RT_BELINDA_1988_IDENTITY
        = new SRM_RT_Code( _RT_BELINDA_1988_IDENTITY, "RT_BELINDA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS
        = new SRM_RT_Code( _RT_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS, "RT_BELLEVUE_IGN_1987_EFATE_ERROMANGO_ISLANDS" );
    public static final SRM_RT_Code RT_BERMUDA_1957_BERMUDA
        = new SRM_RT_Code( _RT_BERMUDA_1957_BERMUDA, "RT_BERMUDA_1957_BERMUDA" );
    public static final SRM_RT_Code RT_BIANCA_1988_IDENTITY
        = new SRM_RT_Code( _RT_BIANCA_1988_IDENTITY, "RT_BIANCA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_BISSAU_1991_GUINEA_BISSAU
        = new SRM_RT_Code( _RT_BISSAU_1991_GUINEA_BISSAU, "RT_BISSAU_1991_GUINEA_BISSAU" );
    public static final SRM_RT_Code RT_BOGOTA_OBS_1987_COLOMBIA
        = new SRM_RT_Code( _RT_BOGOTA_OBS_1987_COLOMBIA, "RT_BOGOTA_OBS_1987_COLOMBIA" );
    public static final SRM_RT_Code RT_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA
        = new SRM_RT_Code( _RT_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA, "RT_BOGOTA_OBS_1987_PM_BOGOTA_COLOMBIA" );
    public static final SRM_RT_Code RT_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS
        = new SRM_RT_Code( _RT_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS, "RT_BUKIT_RIMPAH_1987_BANGKA_BELITUNG_ISLANDS" );
    public static final SRM_RT_Code RT_CALLISTO_2000_IDENTITY
        = new SRM_RT_Code( _RT_CALLISTO_2000_IDENTITY, "RT_CALLISTO_2000_IDENTITY" );
    public static final SRM_RT_Code RT_CALYPSO_1988_IDENTITY
        = new SRM_RT_Code( _RT_CALYPSO_1988_IDENTITY, "RT_CALYPSO_1988_IDENTITY" );
    public static final SRM_RT_Code RT_CAMP_AREA_1987_MCMURDO_CAMP
        = new SRM_RT_Code( _RT_CAMP_AREA_1987_MCMURDO_CAMP, "RT_CAMP_AREA_1987_MCMURDO_CAMP" );
    public static final SRM_RT_Code RT_CAMPO_INCHAUSPE_1969_ARGENTINA
        = new SRM_RT_Code( _RT_CAMPO_INCHAUSPE_1969_ARGENTINA, "RT_CAMPO_INCHAUSPE_1969_ARGENTINA" );
    public static final SRM_RT_Code RT_CANTON_1966_PHOENIX_ISLANDS
        = new SRM_RT_Code( _RT_CANTON_1966_PHOENIX_ISLANDS, "RT_CANTON_1966_PHOENIX_ISLANDS" );
    public static final SRM_RT_Code RT_CAPE_1987_SOUTH_AFRICA
        = new SRM_RT_Code( _RT_CAPE_1987_SOUTH_AFRICA, "RT_CAPE_1987_SOUTH_AFRICA" );
    public static final SRM_RT_Code RT_CAPE_CANAVERAL_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_CAPE_CANAVERAL_1991_MEAN_SOLUTION, "RT_CAPE_CANAVERAL_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_CARTHAGE_1987_TUNISIA
        = new SRM_RT_Code( _RT_CARTHAGE_1987_TUNISIA, "RT_CARTHAGE_1987_TUNISIA" );
    public static final SRM_RT_Code RT_CHARON_1991_IDENTITY
        = new SRM_RT_Code( _RT_CHARON_1991_IDENTITY, "RT_CHARON_1991_IDENTITY" );
    public static final SRM_RT_Code RT_CHATHAM_1971_CHATHAM_ISLANDS
        = new SRM_RT_Code( _RT_CHATHAM_1971_CHATHAM_ISLANDS, "RT_CHATHAM_1971_CHATHAM_ISLANDS" );
    public static final SRM_RT_Code RT_CHUA_1987_PARAGUAY
        = new SRM_RT_Code( _RT_CHUA_1987_PARAGUAY, "RT_CHUA_1987_PARAGUAY" );
    public static final SRM_RT_Code RT_COAMPS_1998_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_COAMPS_1998_IDENTITY_BY_DEFAULT, "RT_COAMPS_1998_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_CORDELIA_1988_IDENTITY
        = new SRM_RT_Code( _RT_CORDELIA_1988_IDENTITY, "RT_CORDELIA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_CORREGO_ALEGRE_1987_BRAZIL
        = new SRM_RT_Code( _RT_CORREGO_ALEGRE_1987_BRAZIL, "RT_CORREGO_ALEGRE_1987_BRAZIL" );
    public static final SRM_RT_Code RT_CRESSIDA_1988_IDENTITY
        = new SRM_RT_Code( _RT_CRESSIDA_1988_IDENTITY, "RT_CRESSIDA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_DABOLA_1991_GUINEA
        = new SRM_RT_Code( _RT_DABOLA_1991_GUINEA, "RT_DABOLA_1991_GUINEA" );
    public static final SRM_RT_Code RT_DECEPTION_1993_DECEPTION_ISLAND
        = new SRM_RT_Code( _RT_DECEPTION_1993_DECEPTION_ISLAND, "RT_DECEPTION_1993_DECEPTION_ISLAND" );
    public static final SRM_RT_Code RT_DEIMOS_1988_IDENTITY
        = new SRM_RT_Code( _RT_DEIMOS_1988_IDENTITY, "RT_DEIMOS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_DESDEMONA_1988_IDENTITY
        = new SRM_RT_Code( _RT_DESDEMONA_1988_IDENTITY, "RT_DESDEMONA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_DESPINA_1991_IDENTITY
        = new SRM_RT_Code( _RT_DESPINA_1991_IDENTITY, "RT_DESPINA_1991_IDENTITY" );
    public static final SRM_RT_Code RT_DIONE_1982_IDENTITY
        = new SRM_RT_Code( _RT_DIONE_1982_IDENTITY, "RT_DIONE_1982_IDENTITY" );
    public static final SRM_RT_Code RT_DJAKARTA_1987_PM_DJAKARTA_SUMATRA
        = new SRM_RT_Code( _RT_DJAKARTA_1987_PM_DJAKARTA_SUMATRA, "RT_DJAKARTA_1987_PM_DJAKARTA_SUMATRA" );
    public static final SRM_RT_Code RT_DJAKARTA_1987_SUMATRA
        = new SRM_RT_Code( _RT_DJAKARTA_1987_SUMATRA, "RT_DJAKARTA_1987_SUMATRA" );
    public static final SRM_RT_Code RT_DOS_1968_GIZO_ISLAND
        = new SRM_RT_Code( _RT_DOS_1968_GIZO_ISLAND, "RT_DOS_1968_GIZO_ISLAND" );
    public static final SRM_RT_Code RT_DOS_71_4_1987_ST_HELENA_ISLAND
        = new SRM_RT_Code( _RT_DOS_71_4_1987_ST_HELENA_ISLAND, "RT_DOS_71_4_1987_ST_HELENA_ISLAND" );
    public static final SRM_RT_Code RT_EASTER_1967_EASTER_ISLAND
        = new SRM_RT_Code( _RT_EASTER_1967_EASTER_ISLAND, "RT_EASTER_1967_EASTER_ISLAND" );
    public static final SRM_RT_Code RT_ENCELADUS_1994_IDENTITY
        = new SRM_RT_Code( _RT_ENCELADUS_1994_IDENTITY, "RT_ENCELADUS_1994_IDENTITY" );
    public static final SRM_RT_Code RT_EPIMETHEUS_1988_IDENTITY
        = new SRM_RT_Code( _RT_EPIMETHEUS_1988_IDENTITY, "RT_EPIMETHEUS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_EROS_2000_IDENTITY
        = new SRM_RT_Code( _RT_EROS_2000_IDENTITY, "RT_EROS_2000_IDENTITY" );
    public static final SRM_RT_Code RT_ESTONIA_1937_ESTONIA
        = new SRM_RT_Code( _RT_ESTONIA_1937_ESTONIA, "RT_ESTONIA_1937_ESTONIA" );
    public static final SRM_RT_Code RT_ETRS_1989_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RT_ETRS_1989_IDENTITY_BY_MEASUREMENT, "RT_ETRS_1989_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RT_EUROPA_2000_IDENTITY
        = new SRM_RT_Code( _RT_EUROPA_2000_IDENTITY, "RT_EUROPA_2000_IDENTITY" );
    public static final SRM_RT_Code RT_EUROPE_1950_3_CYPRUS
        = new SRM_RT_Code( _RT_EUROPE_1950_3_CYPRUS, "RT_EUROPE_1950_3_CYPRUS" );
    public static final SRM_RT_Code RT_EUROPE_1950_CHANNEL_ISLANDS
        = new SRM_RT_Code( _RT_EUROPE_1950_CHANNEL_ISLANDS, "RT_EUROPE_1950_CHANNEL_ISLANDS" );
    public static final SRM_RT_Code RT_EUROPE_1950_EGYPT
        = new SRM_RT_Code( _RT_EUROPE_1950_EGYPT, "RT_EUROPE_1950_EGYPT" );
    public static final SRM_RT_Code RT_EUROPE_1950_ENGLAND_SCOTLAND
        = new SRM_RT_Code( _RT_EUROPE_1950_ENGLAND_SCOTLAND, "RT_EUROPE_1950_ENGLAND_SCOTLAND" );
    public static final SRM_RT_Code RT_EUROPE_1950_GREECE
        = new SRM_RT_Code( _RT_EUROPE_1950_GREECE, "RT_EUROPE_1950_GREECE" );
    public static final SRM_RT_Code RT_EUROPE_1950_IRAN
        = new SRM_RT_Code( _RT_EUROPE_1950_IRAN, "RT_EUROPE_1950_IRAN" );
    public static final SRM_RT_Code RT_EUROPE_1950_IRAQ
        = new SRM_RT_Code( _RT_EUROPE_1950_IRAQ, "RT_EUROPE_1950_IRAQ" );
    public static final SRM_RT_Code RT_EUROPE_1950_IRELAND
        = new SRM_RT_Code( _RT_EUROPE_1950_IRELAND, "RT_EUROPE_1950_IRELAND" );
    public static final SRM_RT_Code RT_EUROPE_1950_MALTA
        = new SRM_RT_Code( _RT_EUROPE_1950_MALTA, "RT_EUROPE_1950_MALTA" );
    public static final SRM_RT_Code RT_EUROPE_1950_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_EUROPE_1950_MEAN_SOLUTION, "RT_EUROPE_1950_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_EUROPE_1950_NORWAY
        = new SRM_RT_Code( _RT_EUROPE_1950_NORWAY, "RT_EUROPE_1950_NORWAY" );
    public static final SRM_RT_Code RT_EUROPE_1950_PORTUGAL_SPAIN
        = new SRM_RT_Code( _RT_EUROPE_1950_PORTUGAL_SPAIN, "RT_EUROPE_1950_PORTUGAL_SPAIN" );
    public static final SRM_RT_Code RT_EUROPE_1950_SARDINIA
        = new SRM_RT_Code( _RT_EUROPE_1950_SARDINIA, "RT_EUROPE_1950_SARDINIA" );
    public static final SRM_RT_Code RT_EUROPE_1950_SICILY
        = new SRM_RT_Code( _RT_EUROPE_1950_SICILY, "RT_EUROPE_1950_SICILY" );
    public static final SRM_RT_Code RT_EUROPE_1950_TUNISIA
        = new SRM_RT_Code( _RT_EUROPE_1950_TUNISIA, "RT_EUROPE_1950_TUNISIA" );
    public static final SRM_RT_Code RT_EUROPE_1950_W_EUROPE_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_EUROPE_1950_W_EUROPE_MEAN_SOLUTION, "RT_EUROPE_1950_W_EUROPE_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_EUROPE_1979_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_EUROPE_1979_MEAN_SOLUTION, "RT_EUROPE_1979_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_FAHUD_1987_3_OMAN
        = new SRM_RT_Code( _RT_FAHUD_1987_3_OMAN, "RT_FAHUD_1987_3_OMAN" );
    public static final SRM_RT_Code RT_FAHUD_1987_7_OMAN
        = new SRM_RT_Code( _RT_FAHUD_1987_7_OMAN, "RT_FAHUD_1987_7_OMAN" );
    public static final SRM_RT_Code RT_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS
        = new SRM_RT_Code( _RT_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS, "RT_FORT_THOMAS_1955_ST_KITTS_NEVIS_LEEWARD_ISLANDS" );
    public static final SRM_RT_Code RT_GALATEA_1991_IDENTITY
        = new SRM_RT_Code( _RT_GALATEA_1991_IDENTITY, "RT_GALATEA_1991_IDENTITY" );
    public static final SRM_RT_Code RT_GAN_1970_MALDIVES
        = new SRM_RT_Code( _RT_GAN_1970_MALDIVES, "RT_GAN_1970_MALDIVES" );
    public static final SRM_RT_Code RT_GANYMEDE_2000_IDENTITY
        = new SRM_RT_Code( _RT_GANYMEDE_2000_IDENTITY, "RT_GANYMEDE_2000_IDENTITY" );
    public static final SRM_RT_Code RT_GASPRA_1991_IDENTITY
        = new SRM_RT_Code( _RT_GASPRA_1991_IDENTITY, "RT_GASPRA_1991_IDENTITY" );
    public static final SRM_RT_Code RT_GDA_1994_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RT_GDA_1994_IDENTITY_BY_MEASUREMENT, "RT_GDA_1994_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RT_GEODETIC_DATUM_1949_3_NEW_ZEALAND
        = new SRM_RT_Code( _RT_GEODETIC_DATUM_1949_3_NEW_ZEALAND, "RT_GEODETIC_DATUM_1949_3_NEW_ZEALAND" );
    public static final SRM_RT_Code RT_GEODETIC_DATUM_1949_7_NEW_ZEALAND
        = new SRM_RT_Code( _RT_GEODETIC_DATUM_1949_7_NEW_ZEALAND, "RT_GEODETIC_DATUM_1949_7_NEW_ZEALAND" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1945_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1945_DGRF, "RT_GEOMAGNETIC_1945_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1950_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1950_DGRF, "RT_GEOMAGNETIC_1950_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1955_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1955_DGRF, "RT_GEOMAGNETIC_1955_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1960_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1960_DGRF, "RT_GEOMAGNETIC_1960_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1965_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1965_DGRF, "RT_GEOMAGNETIC_1965_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1970_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1970_DGRF, "RT_GEOMAGNETIC_1970_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1975_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1975_DGRF, "RT_GEOMAGNETIC_1975_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1980_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1980_DGRF, "RT_GEOMAGNETIC_1980_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1985_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1985_DGRF, "RT_GEOMAGNETIC_1985_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1990_DGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1990_DGRF, "RT_GEOMAGNETIC_1990_DGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_1995_IGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_1995_IGRF, "RT_GEOMAGNETIC_1995_IGRF" );
    public static final SRM_RT_Code RT_GEOMAGNETIC_2000_IGRF
        = new SRM_RT_Code( _RT_GEOMAGNETIC_2000_IGRF, "RT_GEOMAGNETIC_2000_IGRF" );
    public static final SRM_RT_Code RT_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES
        = new SRM_RT_Code( _RT_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES, "RT_GRACIOSA_BASE_SW_1948_CENTRAL_AZORES" );
    public static final SRM_RT_Code RT_GUAM_1963_GUAM
        = new SRM_RT_Code( _RT_GUAM_1963_GUAM, "RT_GUAM_1963_GUAM" );
    public static final SRM_RT_Code RT_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND
        = new SRM_RT_Code( _RT_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND, "RT_GUNONG_SEGARA_1987_KALIMANTAN_ISLAND" );
    public static final SRM_RT_Code RT_GUX_1_1987_GUADALCANAL_ISLAND
        = new SRM_RT_Code( _RT_GUX_1_1987_GUADALCANAL_ISLAND, "RT_GUX_1_1987_GUADALCANAL_ISLAND" );
    public static final SRM_RT_Code RT_HELENE_1992_IDENTITY
        = new SRM_RT_Code( _RT_HELENE_1992_IDENTITY, "RT_HELENE_1992_IDENTITY" );
    public static final SRM_RT_Code RT_HERAT_NORTH_1987_AFGHANISTAN
        = new SRM_RT_Code( _RT_HERAT_NORTH_1987_AFGHANISTAN, "RT_HERAT_NORTH_1987_AFGHANISTAN" );
    public static final SRM_RT_Code RT_HERMANNSKOGEL_1871_3_YUGOSLAVIA
        = new SRM_RT_Code( _RT_HERMANNSKOGEL_1871_3_YUGOSLAVIA, "RT_HERMANNSKOGEL_1871_3_YUGOSLAVIA" );
    public static final SRM_RT_Code RT_HJORSEY_1955_ICELAND
        = new SRM_RT_Code( _RT_HJORSEY_1955_ICELAND, "RT_HJORSEY_1955_ICELAND" );
    public static final SRM_RT_Code RT_HONG_KONG_1963_HONG_KONG
        = new SRM_RT_Code( _RT_HONG_KONG_1963_HONG_KONG, "RT_HONG_KONG_1963_HONG_KONG" );
    public static final SRM_RT_Code RT_HU_TZU_SHAN_1991_TAIWAN
        = new SRM_RT_Code( _RT_HU_TZU_SHAN_1991_TAIWAN, "RT_HU_TZU_SHAN_1991_TAIWAN" );
    public static final SRM_RT_Code RT_IAPETUS_1988_IDENTITY
        = new SRM_RT_Code( _RT_IAPETUS_1988_IDENTITY, "RT_IAPETUS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_IDA_1991_IDENTITY
        = new SRM_RT_Code( _RT_IDA_1991_IDENTITY, "RT_IDA_1991_IDENTITY" );
    public static final SRM_RT_Code RT_INDIAN_1916_3_BANGLADESH
        = new SRM_RT_Code( _RT_INDIAN_1916_3_BANGLADESH, "RT_INDIAN_1916_3_BANGLADESH" );
    public static final SRM_RT_Code RT_INDIAN_1916_7_BANGLADESH
        = new SRM_RT_Code( _RT_INDIAN_1916_7_BANGLADESH, "RT_INDIAN_1916_7_BANGLADESH" );
    public static final SRM_RT_Code RT_INDIAN_1954_THAILAND
        = new SRM_RT_Code( _RT_INDIAN_1954_THAILAND, "RT_INDIAN_1954_THAILAND" );
    public static final SRM_RT_Code RT_INDIAN_1956_INDIA_NEPAL
        = new SRM_RT_Code( _RT_INDIAN_1956_INDIA_NEPAL, "RT_INDIAN_1956_INDIA_NEPAL" );
    public static final SRM_RT_Code RT_INDIAN_1960_CON_SON_ISLAND
        = new SRM_RT_Code( _RT_INDIAN_1960_CON_SON_ISLAND, "RT_INDIAN_1960_CON_SON_ISLAND" );
    public static final SRM_RT_Code RT_INDIAN_1960_VIETNAM_16_N
        = new SRM_RT_Code( _RT_INDIAN_1960_VIETNAM_16_N, "RT_INDIAN_1960_VIETNAM_16_N" );
    public static final SRM_RT_Code RT_INDIAN_1962_PAKISTAN
        = new SRM_RT_Code( _RT_INDIAN_1962_PAKISTAN, "RT_INDIAN_1962_PAKISTAN" );
    public static final SRM_RT_Code RT_INDIAN_1975_1991_THAILAND
        = new SRM_RT_Code( _RT_INDIAN_1975_1991_THAILAND, "RT_INDIAN_1975_1991_THAILAND" );
    public static final SRM_RT_Code RT_INDIAN_1975_1997_THAILAND
        = new SRM_RT_Code( _RT_INDIAN_1975_1997_THAILAND, "RT_INDIAN_1975_1997_THAILAND" );
    public static final SRM_RT_Code RT_INDONESIAN_1974_INDONESIA
        = new SRM_RT_Code( _RT_INDONESIAN_1974_INDONESIA, "RT_INDONESIAN_1974_INDONESIA" );
    public static final SRM_RT_Code RT_IO_2000_IDENTITY
        = new SRM_RT_Code( _RT_IO_2000_IDENTITY, "RT_IO_2000_IDENTITY" );
    public static final SRM_RT_Code RT_IRELAND_1965_3_IRELAND
        = new SRM_RT_Code( _RT_IRELAND_1965_3_IRELAND, "RT_IRELAND_1965_3_IRELAND" );
    public static final SRM_RT_Code RT_IRELAND_1965_7_IRELAND
        = new SRM_RT_Code( _RT_IRELAND_1965_7_IRELAND, "RT_IRELAND_1965_7_IRELAND" );
    public static final SRM_RT_Code RT_ISTS_061_1968_SOUTH_GEORGIA_ISLAND
        = new SRM_RT_Code( _RT_ISTS_061_1968_SOUTH_GEORGIA_ISLAND, "RT_ISTS_061_1968_SOUTH_GEORGIA_ISLAND" );
    public static final SRM_RT_Code RT_ISTS_073_1969_DIEGO_GARCIA
        = new SRM_RT_Code( _RT_ISTS_073_1969_DIEGO_GARCIA, "RT_ISTS_073_1969_DIEGO_GARCIA" );
    public static final SRM_RT_Code RT_JANUS_1988_IDENTITY
        = new SRM_RT_Code( _RT_JANUS_1988_IDENTITY, "RT_JANUS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_JGD_2000_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RT_JGD_2000_IDENTITY_BY_MEASUREMENT, "RT_JGD_2000_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RT_JOHNSTON_1961_JOHNSTON_ISLAND
        = new SRM_RT_Code( _RT_JOHNSTON_1961_JOHNSTON_ISLAND, "RT_JOHNSTON_1961_JOHNSTON_ISLAND" );
    public static final SRM_RT_Code RT_JULIET_1988_IDENTITY
        = new SRM_RT_Code( _RT_JULIET_1988_IDENTITY, "RT_JULIET_1988_IDENTITY" );
    public static final SRM_RT_Code RT_JUPITER_1988_IDENTITY
        = new SRM_RT_Code( _RT_JUPITER_1988_IDENTITY, "RT_JUPITER_1988_IDENTITY" );
    public static final SRM_RT_Code RT_JUPITER_MAGNETIC_1993_VOYAGER
        = new SRM_RT_Code( _RT_JUPITER_MAGNETIC_1993_VOYAGER, "RT_JUPITER_MAGNETIC_1993_VOYAGER" );
    public static final SRM_RT_Code RT_KANDAWALA_1987_3_SRI_LANKA
        = new SRM_RT_Code( _RT_KANDAWALA_1987_3_SRI_LANKA, "RT_KANDAWALA_1987_3_SRI_LANKA" );
    public static final SRM_RT_Code RT_KERGUELEN_1949_KERGUELEN_ISLAND
        = new SRM_RT_Code( _RT_KERGUELEN_1949_KERGUELEN_ISLAND, "RT_KERGUELEN_1949_KERGUELEN_ISLAND" );
    public static final SRM_RT_Code RT_KERTAU_1948_3_W_MALAYSIA_SINGAPORE
        = new SRM_RT_Code( _RT_KERTAU_1948_3_W_MALAYSIA_SINGAPORE, "RT_KERTAU_1948_3_W_MALAYSIA_SINGAPORE" );
    public static final SRM_RT_Code RT_KOREAN_GEODETIC_1995_SOUTH_KOREA
        = new SRM_RT_Code( _RT_KOREAN_GEODETIC_1995_SOUTH_KOREA, "RT_KOREAN_GEODETIC_1995_SOUTH_KOREA" );
    public static final SRM_RT_Code RT_KUSAIE_1951_CAROLINE_ISLANDS
        = new SRM_RT_Code( _RT_KUSAIE_1951_CAROLINE_ISLANDS, "RT_KUSAIE_1951_CAROLINE_ISLANDS" );
    public static final SRM_RT_Code RT_LARISSA_1991_IDENTITY
        = new SRM_RT_Code( _RT_LARISSA_1991_IDENTITY, "RT_LARISSA_1991_IDENTITY" );
    public static final SRM_RT_Code RT_LC5_1961_CAYMAN_BRAC_ISLAND
        = new SRM_RT_Code( _RT_LC5_1961_CAYMAN_BRAC_ISLAND, "RT_LC5_1961_CAYMAN_BRAC_ISLAND" );
    public static final SRM_RT_Code RT_LEIGON_1991_3_GHANA
        = new SRM_RT_Code( _RT_LEIGON_1991_3_GHANA, "RT_LEIGON_1991_3_GHANA" );
    public static final SRM_RT_Code RT_LEIGON_1991_7_GHANA
        = new SRM_RT_Code( _RT_LEIGON_1991_7_GHANA, "RT_LEIGON_1991_7_GHANA" );
    public static final SRM_RT_Code RT_LIBERIA_1964_LIBERIA
        = new SRM_RT_Code( _RT_LIBERIA_1964_LIBERIA, "RT_LIBERIA_1964_LIBERIA" );
    public static final SRM_RT_Code RT_LUZON_1987_MINDANAO_ISLAND
        = new SRM_RT_Code( _RT_LUZON_1987_MINDANAO_ISLAND, "RT_LUZON_1987_MINDANAO_ISLAND" );
    public static final SRM_RT_Code RT_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND
        = new SRM_RT_Code( _RT_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND, "RT_LUZON_1987_PHILIPPINES_EXCLUDING_MINDANAO_ISLAND" );
    public static final SRM_RT_Code RT_M_PORALOKO_1991_GABON
        = new SRM_RT_Code( _RT_M_PORALOKO_1991_GABON, "RT_M_PORALOKO_1991_GABON" );
    public static final SRM_RT_Code RT_MAHE_1971_MAHE_ISLAND
        = new SRM_RT_Code( _RT_MAHE_1971_MAHE_ISLAND, "RT_MAHE_1971_MAHE_ISLAND" );
    public static final SRM_RT_Code RT_MARCUS_STATION_1952_MARCUS_ISLANDS
        = new SRM_RT_Code( _RT_MARCUS_STATION_1952_MARCUS_ISLANDS, "RT_MARCUS_STATION_1952_MARCUS_ISLANDS" );
    public static final SRM_RT_Code RT_MARS_2000_IDENTITY
        = new SRM_RT_Code( _RT_MARS_2000_IDENTITY, "RT_MARS_2000_IDENTITY" );
    public static final SRM_RT_Code RT_MARS_SPHERE_2000_GLOBAL
        = new SRM_RT_Code( _RT_MARS_SPHERE_2000_GLOBAL, "RT_MARS_SPHERE_2000_GLOBAL" );
    public static final SRM_RT_Code RT_MASS_1999_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MASS_1999_IDENTITY_BY_DEFAULT, "RT_MASS_1999_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_MASSAWA_1987_ERITREA_ETHIOPIA
        = new SRM_RT_Code( _RT_MASSAWA_1987_ERITREA_ETHIOPIA, "RT_MASSAWA_1987_ERITREA_ETHIOPIA" );
    public static final SRM_RT_Code RT_MERCHICH_1987_MOROCCO
        = new SRM_RT_Code( _RT_MERCHICH_1987_MOROCCO, "RT_MERCHICH_1987_MOROCCO" );
    public static final SRM_RT_Code RT_MERCURY_1988_IDENTITY
        = new SRM_RT_Code( _RT_MERCURY_1988_IDENTITY, "RT_MERCURY_1988_IDENTITY" );
    public static final SRM_RT_Code RT_METIS_2000_IDENTITY
        = new SRM_RT_Code( _RT_METIS_2000_IDENTITY, "RT_METIS_2000_IDENTITY" );
    public static final SRM_RT_Code RT_MIDWAY_1961_MIDWAY_ISLANDS
        = new SRM_RT_Code( _RT_MIDWAY_1961_MIDWAY_ISLANDS, "RT_MIDWAY_1961_MIDWAY_ISLANDS" );
    public static final SRM_RT_Code RT_MIMAS_1994_IDENTITY
        = new SRM_RT_Code( _RT_MIMAS_1994_IDENTITY, "RT_MIMAS_1994_IDENTITY" );
    public static final SRM_RT_Code RT_MINNA_1991_CAMEROON
        = new SRM_RT_Code( _RT_MINNA_1991_CAMEROON, "RT_MINNA_1991_CAMEROON" );
    public static final SRM_RT_Code RT_MINNA_1991_NIGERIA
        = new SRM_RT_Code( _RT_MINNA_1991_NIGERIA, "RT_MINNA_1991_NIGERIA" );
    public static final SRM_RT_Code RT_MIRANDA_1988_IDENTITY
        = new SRM_RT_Code( _RT_MIRANDA_1988_IDENTITY, "RT_MIRANDA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_MM5_1997_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MM5_1997_IDENTITY_BY_DEFAULT, "RT_MM5_1997_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT, "RT_MODTRAN_MIDLATITUDE_N_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT, "RT_MODTRAN_MIDLATITUDE_S_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT, "RT_MODTRAN_SUBARCTIC_N_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT, "RT_MODTRAN_SUBARCTIC_S_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT, "RT_MODTRAN_TROPICAL_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS
        = new SRM_RT_Code( _RT_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS, "RT_MONTSERRAT_1958_MONTSERRAT_LEEWARD_ISLANDS" );
    public static final SRM_RT_Code RT_MOON_1991_IDENTITY
        = new SRM_RT_Code( _RT_MOON_1991_IDENTITY, "RT_MOON_1991_IDENTITY" );
    public static final SRM_RT_Code RT_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT, "RT_MULTIGEN_FLAT_EARTH_1989_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RT_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS, "RT_N_AM_1927_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RT_N_AM_1927_ALBERTA_BRITISH_COLUMBIA
        = new SRM_RT_Code( _RT_N_AM_1927_ALBERTA_BRITISH_COLUMBIA, "RT_N_AM_1927_ALBERTA_BRITISH_COLUMBIA" );
    public static final SRM_RT_Code RT_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND
        = new SRM_RT_Code( _RT_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND, "RT_N_AM_1927_BAHAMAS_EXCLUDING_SAN_SALVADOR_ISLAND" );
    public static final SRM_RT_Code RT_N_AM_1927_CANADA
        = new SRM_RT_Code( _RT_N_AM_1927_CANADA, "RT_N_AM_1927_CANADA" );
    public static final SRM_RT_Code RT_N_AM_1927_CANAL_ZONE
        = new SRM_RT_Code( _RT_N_AM_1927_CANAL_ZONE, "RT_N_AM_1927_CANAL_ZONE" );
    public static final SRM_RT_Code RT_N_AM_1927_CARIBBEAN
        = new SRM_RT_Code( _RT_N_AM_1927_CARIBBEAN, "RT_N_AM_1927_CARIBBEAN" );
    public static final SRM_RT_Code RT_N_AM_1927_CENTRAL_AMERICA
        = new SRM_RT_Code( _RT_N_AM_1927_CENTRAL_AMERICA, "RT_N_AM_1927_CENTRAL_AMERICA" );
    public static final SRM_RT_Code RT_N_AM_1927_CONTINENTAL_US
        = new SRM_RT_Code( _RT_N_AM_1927_CONTINENTAL_US, "RT_N_AM_1927_CONTINENTAL_US" );
    public static final SRM_RT_Code RT_N_AM_1927_CUBA
        = new SRM_RT_Code( _RT_N_AM_1927_CUBA, "RT_N_AM_1927_CUBA" );
    public static final SRM_RT_Code RT_N_AM_1927_EAST_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RT_N_AM_1927_EAST_ALEUTIAN_ISLANDS, "RT_N_AM_1927_EAST_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RT_N_AM_1927_EASTERN_CANADA
        = new SRM_RT_Code( _RT_N_AM_1927_EASTERN_CANADA, "RT_N_AM_1927_EASTERN_CANADA" );
    public static final SRM_RT_Code RT_N_AM_1927_EASTERN_US
        = new SRM_RT_Code( _RT_N_AM_1927_EASTERN_US, "RT_N_AM_1927_EASTERN_US" );
    public static final SRM_RT_Code RT_N_AM_1927_HAYES_PENINSULA
        = new SRM_RT_Code( _RT_N_AM_1927_HAYES_PENINSULA, "RT_N_AM_1927_HAYES_PENINSULA" );
    public static final SRM_RT_Code RT_N_AM_1927_MANITOBA_ONTARIO
        = new SRM_RT_Code( _RT_N_AM_1927_MANITOBA_ONTARIO, "RT_N_AM_1927_MANITOBA_ONTARIO" );
    public static final SRM_RT_Code RT_N_AM_1927_MEXICO
        = new SRM_RT_Code( _RT_N_AM_1927_MEXICO, "RT_N_AM_1927_MEXICO" );
    public static final SRM_RT_Code RT_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN
        = new SRM_RT_Code( _RT_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN, "RT_N_AM_1927_NORTHWEST_TERRITORIES_SASKATCHEWAN" );
    public static final SRM_RT_Code RT_N_AM_1927_SAN_SALVADOR_ISLAND
        = new SRM_RT_Code( _RT_N_AM_1927_SAN_SALVADOR_ISLAND, "RT_N_AM_1927_SAN_SALVADOR_ISLAND" );
    public static final SRM_RT_Code RT_N_AM_1927_WEST_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RT_N_AM_1927_WEST_ALEUTIAN_ISLANDS, "RT_N_AM_1927_WEST_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RT_N_AM_1927_WESTERN_US
        = new SRM_RT_Code( _RT_N_AM_1927_WESTERN_US, "RT_N_AM_1927_WESTERN_US" );
    public static final SRM_RT_Code RT_N_AM_1927_YUKON
        = new SRM_RT_Code( _RT_N_AM_1927_YUKON, "RT_N_AM_1927_YUKON" );
    public static final SRM_RT_Code RT_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RT_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS, "RT_N_AM_1983_ALASKA_EXCLUDING_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RT_N_AM_1983_ALEUTIAN_ISLANDS
        = new SRM_RT_Code( _RT_N_AM_1983_ALEUTIAN_ISLANDS, "RT_N_AM_1983_ALEUTIAN_ISLANDS" );
    public static final SRM_RT_Code RT_N_AM_1983_CANADA
        = new SRM_RT_Code( _RT_N_AM_1983_CANADA, "RT_N_AM_1983_CANADA" );
    public static final SRM_RT_Code RT_N_AM_1983_CONTINENTAL_US
        = new SRM_RT_Code( _RT_N_AM_1983_CONTINENTAL_US, "RT_N_AM_1983_CONTINENTAL_US" );
    public static final SRM_RT_Code RT_N_AM_1983_HAWAII
        = new SRM_RT_Code( _RT_N_AM_1983_HAWAII, "RT_N_AM_1983_HAWAII" );
    public static final SRM_RT_Code RT_N_AM_1983_MEXICO_CENTRAL_AMERICA
        = new SRM_RT_Code( _RT_N_AM_1983_MEXICO_CENTRAL_AMERICA, "RT_N_AM_1983_MEXICO_CENTRAL_AMERICA" );
    public static final SRM_RT_Code RT_N_SAHARA_1959_ALGERIA
        = new SRM_RT_Code( _RT_N_SAHARA_1959_ALGERIA, "RT_N_SAHARA_1959_ALGERIA" );
    public static final SRM_RT_Code RT_NAHRWAN_1987_MASIRAH_ISLAND
        = new SRM_RT_Code( _RT_NAHRWAN_1987_MASIRAH_ISLAND, "RT_NAHRWAN_1987_MASIRAH_ISLAND" );
    public static final SRM_RT_Code RT_NAHRWAN_1987_SAUDI_ARABIA
        = new SRM_RT_Code( _RT_NAHRWAN_1987_SAUDI_ARABIA, "RT_NAHRWAN_1987_SAUDI_ARABIA" );
    public static final SRM_RT_Code RT_NAHRWAN_1987_UNITED_ARAB_EMIRATES
        = new SRM_RT_Code( _RT_NAHRWAN_1987_UNITED_ARAB_EMIRATES, "RT_NAHRWAN_1987_UNITED_ARAB_EMIRATES" );
    public static final SRM_RT_Code RT_NAIAD_1991_IDENTITY
        = new SRM_RT_Code( _RT_NAIAD_1991_IDENTITY, "RT_NAIAD_1991_IDENTITY" );
    public static final SRM_RT_Code RT_NAPARIMA_1991_TRINIDAD_TOBAGO
        = new SRM_RT_Code( _RT_NAPARIMA_1991_TRINIDAD_TOBAGO, "RT_NAPARIMA_1991_TRINIDAD_TOBAGO" );
    public static final SRM_RT_Code RT_NEPTUNE_1991_IDENTITY
        = new SRM_RT_Code( _RT_NEPTUNE_1991_IDENTITY, "RT_NEPTUNE_1991_IDENTITY" );
    public static final SRM_RT_Code RT_NEPTUNE_MAGNETIC_1993_VOYAGER
        = new SRM_RT_Code( _RT_NEPTUNE_MAGNETIC_1993_VOYAGER, "RT_NEPTUNE_MAGNETIC_1993_VOYAGER" );
    public static final SRM_RT_Code RT_NOGAPS_1988_IDENTITY_BY_DEFAULT
        = new SRM_RT_Code( _RT_NOGAPS_1988_IDENTITY_BY_DEFAULT, "RT_NOGAPS_1988_IDENTITY_BY_DEFAULT" );
    public static final SRM_RT_Code RT_NTF_1896_FRANCE
        = new SRM_RT_Code( _RT_NTF_1896_FRANCE, "RT_NTF_1896_FRANCE" );
    public static final SRM_RT_Code RT_NTF_1896_PM_PARIS_FRANCE
        = new SRM_RT_Code( _RT_NTF_1896_PM_PARIS_FRANCE, "RT_NTF_1896_PM_PARIS_FRANCE" );
    public static final SRM_RT_Code RT_OBERON_1988_IDENTITY
        = new SRM_RT_Code( _RT_OBERON_1988_IDENTITY, "RT_OBERON_1988_IDENTITY" );
    public static final SRM_RT_Code RT_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS
        = new SRM_RT_Code( _RT_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS, "RT_OBSERV_METEORO_1939_CORVO_FLORES_ISLANDS" );
    public static final SRM_RT_Code RT_OLD_EGYPTIAN_1907_EGYPT
        = new SRM_RT_Code( _RT_OLD_EGYPTIAN_1907_EGYPT, "RT_OLD_EGYPTIAN_1907_EGYPT" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_CLARKE_1987_HAWAII
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_CLARKE_1987_HAWAII, "RT_OLD_HAWAIIAN_CLARKE_1987_HAWAII" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_CLARKE_1987_KAUAI
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_CLARKE_1987_KAUAI, "RT_OLD_HAWAIIAN_CLARKE_1987_KAUAI" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_CLARKE_1987_MAUI
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_CLARKE_1987_MAUI, "RT_OLD_HAWAIIAN_CLARKE_1987_MAUI" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_CLARKE_1987_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_CLARKE_1987_MEAN_SOLUTION, "RT_OLD_HAWAIIAN_CLARKE_1987_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_CLARKE_1987_OAHU
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_CLARKE_1987_OAHU, "RT_OLD_HAWAIIAN_CLARKE_1987_OAHU" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_INT_1987_HAWAII
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_INT_1987_HAWAII, "RT_OLD_HAWAIIAN_INT_1987_HAWAII" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_INT_1987_KAUAI
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_INT_1987_KAUAI, "RT_OLD_HAWAIIAN_INT_1987_KAUAI" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_INT_1987_MAUI
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_INT_1987_MAUI, "RT_OLD_HAWAIIAN_INT_1987_MAUI" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_INT_1987_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_INT_1987_MEAN_SOLUTION, "RT_OLD_HAWAIIAN_INT_1987_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_OLD_HAWAIIAN_INT_1987_OAHU
        = new SRM_RT_Code( _RT_OLD_HAWAIIAN_INT_1987_OAHU, "RT_OLD_HAWAIIAN_INT_1987_OAHU" );
    public static final SRM_RT_Code RT_OPHELIA_1988_IDENTITY
        = new SRM_RT_Code( _RT_OPHELIA_1988_IDENTITY, "RT_OPHELIA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_OSGB_1936_3_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_OSGB_1936_3_MEAN_SOLUTION, "RT_OSGB_1936_3_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_OSGB_1936_7_GREAT_BRITAIN
        = new SRM_RT_Code( _RT_OSGB_1936_7_GREAT_BRITAIN, "RT_OSGB_1936_7_GREAT_BRITAIN" );
    public static final SRM_RT_Code RT_OSGB_1936_ENGLAND
        = new SRM_RT_Code( _RT_OSGB_1936_ENGLAND, "RT_OSGB_1936_ENGLAND" );
    public static final SRM_RT_Code RT_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES
        = new SRM_RT_Code( _RT_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES, "RT_OSGB_1936_ENGLAND_ISLE_OF_MAN_WALES" );
    public static final SRM_RT_Code RT_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS
        = new SRM_RT_Code( _RT_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS, "RT_OSGB_1936_SCOTLAND_SHETLAND_ISLANDS" );
    public static final SRM_RT_Code RT_OSGB_1936_WALES
        = new SRM_RT_Code( _RT_OSGB_1936_WALES, "RT_OSGB_1936_WALES" );
    public static final SRM_RT_Code RT_PAN_1991_IDENTITY
        = new SRM_RT_Code( _RT_PAN_1991_IDENTITY, "RT_PAN_1991_IDENTITY" );
    public static final SRM_RT_Code RT_PANDORA_1988_IDENTITY
        = new SRM_RT_Code( _RT_PANDORA_1988_IDENTITY, "RT_PANDORA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_PHOBOS_1988_IDENTITY
        = new SRM_RT_Code( _RT_PHOBOS_1988_IDENTITY, "RT_PHOBOS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_PHOEBE_1988_IDENTITY
        = new SRM_RT_Code( _RT_PHOEBE_1988_IDENTITY, "RT_PHOEBE_1988_IDENTITY" );
    public static final SRM_RT_Code RT_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS
        = new SRM_RT_Code( _RT_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS, "RT_PICO_DE_LAS_NIEVES_1987_CANARY_ISLANDS" );
    public static final SRM_RT_Code RT_PITCAIRN_1967_PITCAIRN_ISLAND
        = new SRM_RT_Code( _RT_PITCAIRN_1967_PITCAIRN_ISLAND, "RT_PITCAIRN_1967_PITCAIRN_ISLAND" );
    public static final SRM_RT_Code RT_PLUTO_1994_IDENTITY
        = new SRM_RT_Code( _RT_PLUTO_1994_IDENTITY, "RT_PLUTO_1994_IDENTITY" );
    public static final SRM_RT_Code RT_POINT_58_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_POINT_58_1991_MEAN_SOLUTION, "RT_POINT_58_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_POINTE_NOIRE_1948_CONGO
        = new SRM_RT_Code( _RT_POINTE_NOIRE_1948_CONGO, "RT_POINTE_NOIRE_1948_CONGO" );
    public static final SRM_RT_Code RT_PORTIA_1988_IDENTITY
        = new SRM_RT_Code( _RT_PORTIA_1988_IDENTITY, "RT_PORTIA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS
        = new SRM_RT_Code( _RT_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS, "RT_PORTO_SANTO_1936_PORTO_SANTO_MADEIRA_ISLANDS" );
    public static final SRM_RT_Code RT_PROMETHEUS_1988_IDENTITY
        = new SRM_RT_Code( _RT_PROMETHEUS_1988_IDENTITY, "RT_PROMETHEUS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_PROTEUS_1991_IDENTITY
        = new SRM_RT_Code( _RT_PROTEUS_1991_IDENTITY, "RT_PROTEUS_1991_IDENTITY" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_3_VENEZUELA
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_3_VENEZUELA, "RT_PROV_S_AM_1956_3_VENEZUELA" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_7_VENEZUELA
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_7_VENEZUELA, "RT_PROV_S_AM_1956_7_VENEZUELA" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_BOLIVIA
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_BOLIVIA, "RT_PROV_S_AM_1956_BOLIVIA" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_COLOMBIA
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_COLOMBIA, "RT_PROV_S_AM_1956_COLOMBIA" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_ECUADOR
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_ECUADOR, "RT_PROV_S_AM_1956_ECUADOR" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_GUYANA
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_GUYANA, "RT_PROV_S_AM_1956_GUYANA" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_MEAN_SOLUTION, "RT_PROV_S_AM_1956_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_N_CHILE_19_S
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_N_CHILE_19_S, "RT_PROV_S_AM_1956_N_CHILE_19_S" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_PERU
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_PERU, "RT_PROV_S_AM_1956_PERU" );
    public static final SRM_RT_Code RT_PROV_S_AM_1956_S_CHILE_43_S
        = new SRM_RT_Code( _RT_PROV_S_AM_1956_S_CHILE_43_S, "RT_PROV_S_AM_1956_S_CHILE_43_S" );
    public static final SRM_RT_Code RT_PROV_S_CHILEAN_1963_SOUTH_CHILE
        = new SRM_RT_Code( _RT_PROV_S_CHILEAN_1963_SOUTH_CHILE, "RT_PROV_S_CHILEAN_1963_SOUTH_CHILE" );
    public static final SRM_RT_Code RT_PUCK_1988_IDENTITY
        = new SRM_RT_Code( _RT_PUCK_1988_IDENTITY, "RT_PUCK_1988_IDENTITY" );
    public static final SRM_RT_Code RT_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS
        = new SRM_RT_Code( _RT_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS, "RT_PUERTO_RICO_1987_PUERTO_RICO_VIRGIN_ISLANDS" );
    public static final SRM_RT_Code RT_PULKOVO_1942_RUSSIA
        = new SRM_RT_Code( _RT_PULKOVO_1942_RUSSIA, "RT_PULKOVO_1942_RUSSIA" );
    public static final SRM_RT_Code RT_QATAR_NATIONAL_1974_3_QATAR
        = new SRM_RT_Code( _RT_QATAR_NATIONAL_1974_3_QATAR, "RT_QATAR_NATIONAL_1974_3_QATAR" );
    public static final SRM_RT_Code RT_QORNOQ_1987_SOUTH_GREENLAND
        = new SRM_RT_Code( _RT_QORNOQ_1987_SOUTH_GREENLAND, "RT_QORNOQ_1987_SOUTH_GREENLAND" );
    public static final SRM_RT_Code RT_REUNION_1947_MASCARENE_ISLANDS
        = new SRM_RT_Code( _RT_REUNION_1947_MASCARENE_ISLANDS, "RT_REUNION_1947_MASCARENE_ISLANDS" );
    public static final SRM_RT_Code RT_RGF_1993_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RT_RGF_1993_IDENTITY_BY_MEASUREMENT, "RT_RGF_1993_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RT_RHEA_1988_IDENTITY
        = new SRM_RT_Code( _RT_RHEA_1988_IDENTITY, "RT_RHEA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_ROME_1940_PM_ROME_SARDINIA
        = new SRM_RT_Code( _RT_ROME_1940_PM_ROME_SARDINIA, "RT_ROME_1940_PM_ROME_SARDINIA" );
    public static final SRM_RT_Code RT_ROME_1940_SARDINIA
        = new SRM_RT_Code( _RT_ROME_1940_SARDINIA, "RT_ROME_1940_SARDINIA" );
    public static final SRM_RT_Code RT_ROSALIND_1988_IDENTITY
        = new SRM_RT_Code( _RT_ROSALIND_1988_IDENTITY, "RT_ROSALIND_1988_IDENTITY" );
    public static final SRM_RT_Code RT_S_AM_1969_ARGENTINA
        = new SRM_RT_Code( _RT_S_AM_1969_ARGENTINA, "RT_S_AM_1969_ARGENTINA" );
    public static final SRM_RT_Code RT_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS
        = new SRM_RT_Code( _RT_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS, "RT_S_AM_1969_BALTRA_GALAPAGOS_ISLANDS" );
    public static final SRM_RT_Code RT_S_AM_1969_BOLIVIA
        = new SRM_RT_Code( _RT_S_AM_1969_BOLIVIA, "RT_S_AM_1969_BOLIVIA" );
    public static final SRM_RT_Code RT_S_AM_1969_BRAZIL
        = new SRM_RT_Code( _RT_S_AM_1969_BRAZIL, "RT_S_AM_1969_BRAZIL" );
    public static final SRM_RT_Code RT_S_AM_1969_CHILE
        = new SRM_RT_Code( _RT_S_AM_1969_CHILE, "RT_S_AM_1969_CHILE" );
    public static final SRM_RT_Code RT_S_AM_1969_COLOMBIA
        = new SRM_RT_Code( _RT_S_AM_1969_COLOMBIA, "RT_S_AM_1969_COLOMBIA" );
    public static final SRM_RT_Code RT_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS
        = new SRM_RT_Code( _RT_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS, "RT_S_AM_1969_ECUADOR_EXCLUDING_GALAPAGOS_ISLANDS" );
    public static final SRM_RT_Code RT_S_AM_1969_GUYANA
        = new SRM_RT_Code( _RT_S_AM_1969_GUYANA, "RT_S_AM_1969_GUYANA" );
    public static final SRM_RT_Code RT_S_AM_1969_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_S_AM_1969_MEAN_SOLUTION, "RT_S_AM_1969_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_S_AM_1969_PARAGUAY
        = new SRM_RT_Code( _RT_S_AM_1969_PARAGUAY, "RT_S_AM_1969_PARAGUAY" );
    public static final SRM_RT_Code RT_S_AM_1969_PERU
        = new SRM_RT_Code( _RT_S_AM_1969_PERU, "RT_S_AM_1969_PERU" );
    public static final SRM_RT_Code RT_S_AM_1969_TRINIDAD_TOBAGO
        = new SRM_RT_Code( _RT_S_AM_1969_TRINIDAD_TOBAGO, "RT_S_AM_1969_TRINIDAD_TOBAGO" );
    public static final SRM_RT_Code RT_S_AM_1969_VENEZUELA
        = new SRM_RT_Code( _RT_S_AM_1969_VENEZUELA, "RT_S_AM_1969_VENEZUELA" );
    public static final SRM_RT_Code RT_S_ASIA_1987_SINGAPORE
        = new SRM_RT_Code( _RT_S_ASIA_1987_SINGAPORE, "RT_S_ASIA_1987_SINGAPORE" );
    public static final SRM_RT_Code RT_S_JTSK_1993_CZECH_REP
        = new SRM_RT_Code( _RT_S_JTSK_1993_CZECH_REP, "RT_S_JTSK_1993_CZECH_REP" );
    public static final SRM_RT_Code RT_S_JTSK_1993_CZECH_REP_SLOVAKIA
        = new SRM_RT_Code( _RT_S_JTSK_1993_CZECH_REP_SLOVAKIA, "RT_S_JTSK_1993_CZECH_REP_SLOVAKIA" );
    public static final SRM_RT_Code RT_S42_PULKOVO_3_POLAND
        = new SRM_RT_Code( _RT_S42_PULKOVO_3_POLAND, "RT_S42_PULKOVO_3_POLAND" );
    public static final SRM_RT_Code RT_S42_PULKOVO_ALBANIA
        = new SRM_RT_Code( _RT_S42_PULKOVO_ALBANIA, "RT_S42_PULKOVO_ALBANIA" );
    public static final SRM_RT_Code RT_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA
        = new SRM_RT_Code( _RT_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA, "RT_S42_PULKOVO_CZECH_REPUBLIC_SLOVAKIA" );
    public static final SRM_RT_Code RT_S42_PULKOVO_G_ROMANIA
        = new SRM_RT_Code( _RT_S42_PULKOVO_G_ROMANIA, "RT_S42_PULKOVO_G_ROMANIA" );
    public static final SRM_RT_Code RT_S42_PULKOVO_HUNGARY
        = new SRM_RT_Code( _RT_S42_PULKOVO_HUNGARY, "RT_S42_PULKOVO_HUNGARY" );
    public static final SRM_RT_Code RT_S42_PULKOVO_KAZAKHSTAN
        = new SRM_RT_Code( _RT_S42_PULKOVO_KAZAKHSTAN, "RT_S42_PULKOVO_KAZAKHSTAN" );
    public static final SRM_RT_Code RT_S42_PULKOVO_LATVIA
        = new SRM_RT_Code( _RT_S42_PULKOVO_LATVIA, "RT_S42_PULKOVO_LATVIA" );
    public static final SRM_RT_Code RT_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND
        = new SRM_RT_Code( _RT_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND, "RT_SANTO_DOS_1965_ESPIRITO_SANTO_ISLAND" );
    public static final SRM_RT_Code RT_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS
        = new SRM_RT_Code( _RT_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS, "RT_SAO_BRAZ_1987_SAO_MIGUEL_SANTA_MARIA_ISLANDS" );
    public static final SRM_RT_Code RT_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS
        = new SRM_RT_Code( _RT_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS, "RT_SAPPER_HILL_1943_3_E_FALKLAND_ISLANDS" );
    public static final SRM_RT_Code RT_SATURN_1988_IDENTITY
        = new SRM_RT_Code( _RT_SATURN_1988_IDENTITY, "RT_SATURN_1988_IDENTITY" );
    public static final SRM_RT_Code RT_SATURN_MAGNETIC_1993_VOYAGER
        = new SRM_RT_Code( _RT_SATURN_MAGNETIC_1993_VOYAGER, "RT_SATURN_MAGNETIC_1993_VOYAGER" );
    public static final SRM_RT_Code RT_SCHWARZECK_1991_NAMIBIA
        = new SRM_RT_Code( _RT_SCHWARZECK_1991_NAMIBIA, "RT_SCHWARZECK_1991_NAMIBIA" );
    public static final SRM_RT_Code RT_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS
        = new SRM_RT_Code( _RT_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS, "RT_SELVAGEM_GRANDE_1938_SALVAGE_ISLANDS" );
    public static final SRM_RT_Code RT_SIERRA_LEONE_1960_SIERRA_LEONE
        = new SRM_RT_Code( _RT_SIERRA_LEONE_1960_SIERRA_LEONE, "RT_SIERRA_LEONE_1960_SIERRA_LEONE" );
    public static final SRM_RT_Code RT_SIRGAS_2000_IDENTITY_BY_MEASUREMENT
        = new SRM_RT_Code( _RT_SIRGAS_2000_IDENTITY_BY_MEASUREMENT, "RT_SIRGAS_2000_IDENTITY_BY_MEASUREMENT" );
    public static final SRM_RT_Code RT_SUN_1992_IDENTITY
        = new SRM_RT_Code( _RT_SUN_1992_IDENTITY, "RT_SUN_1992_IDENTITY" );
    public static final SRM_RT_Code RT_TANANARIVE_OBS_1925_3_MADAGASCAR
        = new SRM_RT_Code( _RT_TANANARIVE_OBS_1925_3_MADAGASCAR, "RT_TANANARIVE_OBS_1925_3_MADAGASCAR" );
    public static final SRM_RT_Code RT_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR
        = new SRM_RT_Code( _RT_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR, "RT_TANANARIVE_OBS_1925_PM_PARIS_3_MADAGASCAR" );
    public static final SRM_RT_Code RT_TELESTO_1988_IDENTITY
        = new SRM_RT_Code( _RT_TELESTO_1988_IDENTITY, "RT_TELESTO_1988_IDENTITY" );
    public static final SRM_RT_Code RT_TERN_1961_TERN_ISLAND
        = new SRM_RT_Code( _RT_TERN_1961_TERN_ISLAND, "RT_TERN_1961_TERN_ISLAND" );
    public static final SRM_RT_Code RT_TETHYS_1991_IDENTITY
        = new SRM_RT_Code( _RT_TETHYS_1991_IDENTITY, "RT_TETHYS_1991_IDENTITY" );
    public static final SRM_RT_Code RT_THALASSA_1991_IDENTITY
        = new SRM_RT_Code( _RT_THALASSA_1991_IDENTITY, "RT_THALASSA_1991_IDENTITY" );
    public static final SRM_RT_Code RT_THEBE_2000_IDENTITY
        = new SRM_RT_Code( _RT_THEBE_2000_IDENTITY, "RT_THEBE_2000_IDENTITY" );
    public static final SRM_RT_Code RT_TIMBALAI_EVEREST_1948_3_BRUNEI_E_MALAYSIA
        = new SRM_RT_Code( _RT_TIMBALAI_EVEREST_1948_3_BRUNEI_E_MALAYSIA, "RT_TIMBALAI_EVEREST_1948_3_BRUNEI_E_MALAYSIA" );
    public static final SRM_RT_Code RT_TIMBALAI_EVEREST_1948_7_BRUNEI_E_MALAYSIA
        = new SRM_RT_Code( _RT_TIMBALAI_EVEREST_1948_7_BRUNEI_E_MALAYSIA, "RT_TIMBALAI_EVEREST_1948_7_BRUNEI_E_MALAYSIA" );
    public static final SRM_RT_Code RT_TITAN_1982_IDENTITY
        = new SRM_RT_Code( _RT_TITAN_1982_IDENTITY, "RT_TITAN_1982_IDENTITY" );
    public static final SRM_RT_Code RT_TITANIA_1988_IDENTITY
        = new SRM_RT_Code( _RT_TITANIA_1988_IDENTITY, "RT_TITANIA_1988_IDENTITY" );
    public static final SRM_RT_Code RT_TOKYO_1991_JAPAN
        = new SRM_RT_Code( _RT_TOKYO_1991_JAPAN, "RT_TOKYO_1991_JAPAN" );
    public static final SRM_RT_Code RT_TOKYO_1991_MEAN_SOLUTION
        = new SRM_RT_Code( _RT_TOKYO_1991_MEAN_SOLUTION, "RT_TOKYO_1991_MEAN_SOLUTION" );
    public static final SRM_RT_Code RT_TOKYO_1991_OKINAWA
        = new SRM_RT_Code( _RT_TOKYO_1991_OKINAWA, "RT_TOKYO_1991_OKINAWA" );
    public static final SRM_RT_Code RT_TOKYO_1991_1991_SOUTH_KOREA
        = new SRM_RT_Code( _RT_TOKYO_1991_1991_SOUTH_KOREA, "RT_TOKYO_1991_1991_SOUTH_KOREA" );
    public static final SRM_RT_Code RT_TOKYO_1991_1997_SOUTH_KOREA
        = new SRM_RT_Code( _RT_TOKYO_1991_1997_SOUTH_KOREA, "RT_TOKYO_1991_1997_SOUTH_KOREA" );
    public static final SRM_RT_Code RT_TRISTAN_1968_TRISTAN_DA_CUNHA
        = new SRM_RT_Code( _RT_TRISTAN_1968_TRISTAN_DA_CUNHA, "RT_TRISTAN_1968_TRISTAN_DA_CUNHA" );
    public static final SRM_RT_Code RT_TRITON_1991_IDENTITY
        = new SRM_RT_Code( _RT_TRITON_1991_IDENTITY, "RT_TRITON_1991_IDENTITY" );
    public static final SRM_RT_Code RT_UMBRIEL_1988_IDENTITY
        = new SRM_RT_Code( _RT_UMBRIEL_1988_IDENTITY, "RT_UMBRIEL_1988_IDENTITY" );
    public static final SRM_RT_Code RT_URANUS_1988_IDENTITY
        = new SRM_RT_Code( _RT_URANUS_1988_IDENTITY, "RT_URANUS_1988_IDENTITY" );
    public static final SRM_RT_Code RT_URANUS_MAGNETIC_1993_VOYAGER
        = new SRM_RT_Code( _RT_URANUS_MAGNETIC_1993_VOYAGER, "RT_URANUS_MAGNETIC_1993_VOYAGER" );
    public static final SRM_RT_Code RT_VENUS_1991_IDENTITY
        = new SRM_RT_Code( _RT_VENUS_1991_IDENTITY, "RT_VENUS_1991_IDENTITY" );
    public static final SRM_RT_Code RT_VITI_LEVU_1916_VITI_LEVU_ISLANDS
        = new SRM_RT_Code( _RT_VITI_LEVU_1916_VITI_LEVU_ISLANDS, "RT_VITI_LEVU_1916_VITI_LEVU_ISLANDS" );
    public static final SRM_RT_Code RT_VOIROL_1874_ALGERIA
        = new SRM_RT_Code( _RT_VOIROL_1874_ALGERIA, "RT_VOIROL_1874_ALGERIA" );
    public static final SRM_RT_Code RT_VOIROL_1874_PM_PARIS_ALGERIA
        = new SRM_RT_Code( _RT_VOIROL_1874_PM_PARIS_ALGERIA, "RT_VOIROL_1874_PM_PARIS_ALGERIA" );
    public static final SRM_RT_Code RT_VOIROL_1960_ALGERIA
        = new SRM_RT_Code( _RT_VOIROL_1960_ALGERIA, "RT_VOIROL_1960_ALGERIA" );
    public static final SRM_RT_Code RT_VOIROL_1960_PM_PARIS_ALGERIA
        = new SRM_RT_Code( _RT_VOIROL_1960_PM_PARIS_ALGERIA, "RT_VOIROL_1960_PM_PARIS_ALGERIA" );
    public static final SRM_RT_Code RT_WAKE_1952_WAKE_ATOLL
        = new SRM_RT_Code( _RT_WAKE_1952_WAKE_ATOLL, "RT_WAKE_1952_WAKE_ATOLL" );
    public static final SRM_RT_Code RT_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS
        = new SRM_RT_Code( _RT_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS, "RT_WAKE_ENIWETOK_1960_MARSHALL_ISLANDS" );
    public static final SRM_RT_Code RT_WGS_1972_GLOBAL
        = new SRM_RT_Code( _RT_WGS_1972_GLOBAL, "RT_WGS_1972_GLOBAL" );
    public static final SRM_RT_Code RT_WGS_1984_IDENTITY
        = new SRM_RT_Code( _RT_WGS_1984_IDENTITY, "RT_WGS_1984_IDENTITY" );
    public static final SRM_RT_Code RT_YACARE_1987_URUGUAY
        = new SRM_RT_Code( _RT_YACARE_1987_URUGUAY, "RT_YACARE_1987_URUGUAY" );
    public static final SRM_RT_Code RT_ZANDERIJ_1987_SURINAME
        = new SRM_RT_Code( _RT_ZANDERIJ_1987_SURINAME, "RT_ZANDERIJ_1987_SURINAME" );

    private SRM_RT_Code(int code, String name) {
        super (code, name);
        _enumMap.put( name, this ); 
        _enumVec.add( code, this ); 
    }

    /// returns the SRM_RT_Code from its enumerant value
    public static SRM_RT_Code getEnum( int e ) throws SrmException
    {
        if( e < 1 || e > _totalEnum )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_RT_Code.getEnum: enumerant out of range") );
        else
            return (SRM_RT_Code)(_enumVec.elementAt( e ));
    }

    /// returns the SRM_RT_Code from its string name
    public static SRM_RT_Code getEnum( String name ) throws SrmException
    {
        SRM_RT_Code retCode = (SRM_RT_Code)_enumMap.get( name );

        if( retCode == null )
            throw new SrmException( SrmException._INVALID_INPUT,
                        new String("SRM_RT_Code.getEnum: enum. string not found") );

        return retCode;
    }
}

