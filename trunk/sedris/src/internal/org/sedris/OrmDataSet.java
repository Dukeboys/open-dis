
package org.sedris;

import java.util.*;

//import SRM.*;

class OrmDataSet
{
    public String        _label;
    public String        _description;
    public SRM_ORM_Code  _orm_code;
    public SRM_ORMT_Code _orm_template;
    public SRM_OBRS_Code _obrs_code;
    public SRM_RD_Code   _rd_code;
    public SRM_ORM_Code  _reference_orm;
    public int           _rt_count;
    public Vector        _rt_vector;
    
    protected OrmDataSet( String        label, 
                          String        description, 
                          SRM_ORM_Code  orm_code, 
                          SRM_ORMT_Code orm_template, 
                          SRM_OBRS_Code obrs_code, 
                          SRM_RD_Code   rd_code,
                          SRM_ORM_Code  reference_orm,
                          int           rt_count ) 
    {
        _label = label;
        _description = description;
        _orm_code = orm_code;
        _orm_template = orm_template;
        _obrs_code = obrs_code;
        _rd_code = rd_code;
        _reference_orm = reference_orm;
        _rt_count = rt_count;
    }

    // The actual data has to be split to two table in the children classes
    // OrmDataSet1 and OrmDataSet2 so that the compile can handle the large 
    // amount of cases.
    public static OrmDataSet getElem(SRM_ORM_Code code) 
    {
        if ( code.toInt() <= 241 )  // this table has ORM from 0 to 241        
        {
            return OrmDataSet1.getElem( code );
        }
        else // this table has ORM from 242 to 482    
        {
            return OrmDataSet2.getElem( code );
        }
    }
}

