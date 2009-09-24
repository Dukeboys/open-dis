package org.sedris;

//import SRM.*;

class OrmDataSet2 extends OrmDataSet
{
    private OrmDataSet2(  String label, 
                          String description, 
                          SRM_ORM_Code orm_code, 
                          SRM_ORMT_Code orm_template, 
                          SRM_OBRS_Code obrs_code, 
                          SRM_RD_Code rd_code,
                          SRM_ORM_Code reference_orm,
                          int rt_count ) 
    {
        super ( label, description, orm_code, 
                orm_template, obrs_code, rd_code,
                reference_orm, rt_count );
    }

    public static OrmDataSet getElem(SRM_ORM_Code code) 
    {
        return table[code.toInt() - 242];
    }

    public static OrmDataSet2[] table =
    {
        new OrmDataSet2
        (
             new String("ORM_VITI_LEVU_1916"), /*!< ISO18026 Label */
             new String("Viti Levu"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_VITI_LEVU_1916, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_VOIROL_1874"), /*!< ISO18026 Label */
             new String("Voirol"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_VOIROL_1874, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_VOIROL_1874_PM_PARIS"), /*!< ISO18026 Label */
             new String("Voirol (with the Prime Meridian at Paris)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_VOIROL_1874_PM_PARIS, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_VOIROL_1960"), /*!< ISO18026 Label */
             new String("Voirol - Revised"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_VOIROL_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_VOIROL_1960_PM_PARIS"), /*!< ISO18026 Label */
             new String("Voirol - Revised (with the Prime Meridian at Paris)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_VOIROL_1960_PM_PARIS, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_CLARKE_1880, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_WAKE_1952"), /*!< ISO18026 Label */
             new String("Wake (astronomic)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_WAKE_1952, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_WAKE_ENIWETOK_1960"), /*!< ISO18026 Label */
             new String("Wake-Eniwetok"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_WAKE_ENIWETOK_1960, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_HOUGH_1960, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_WGS_1972"), /*!< ISO18026 Label */
             new String("World Geodetic System"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_WGS_1972, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_WGS_1972, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_WGS_1984"), /*!< ISO18026 Label */
             new String("World Geodetic System"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_WGS_1984, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID_ORIGIN, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_WGS_1984, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_YACARE_1987"), /*!< ISO18026 Label */
             new String("Yacare (Uruguay)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_YACARE_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        ),

        new OrmDataSet2
        (
             new String("ORM_ZANDERIJ_1987"), /*!< ISO18026 Label */
             new String("Zanderij (Suriname)"), /*!< ISO18026 Published name */
             SRM_ORM_Code.ORM_ZANDERIJ_1987, /*!< ORM Code enum */
             SRM_ORMT_Code.ORMT_OBLATE_ELLIPSOID, /*!< ORM Template Code */
             SRM_OBRS_Code.OBRS_UNDEFINED, /*!< OBRS Code */
             SRM_RD_Code.RD_INTERNATIONAL_1924, /*!< RD parameterization code */
             SRM_ORM_Code.ORM_WGS_1984, /*!< Reference ORM */
             1 /*!< RT count for this ORM */
        )


    };
}

