package com.wissen.entity;

import com.wissen.entity.TblKisi;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-23T09:36:18")
@StaticMetamodel(TblMakbuz.class)
public class TblMakbuz_ { 

    public static volatile SingularAttribute<TblMakbuz, String> daireNo;
    public static volatile SingularAttribute<TblMakbuz, TblKisi> tCKimlikNo;
    public static volatile SingularAttribute<TblMakbuz, Boolean> durumu;
    public static volatile SingularAttribute<TblMakbuz, Date> ay;
    public static volatile SingularAttribute<TblMakbuz, Double> tutari;
    public static volatile SingularAttribute<TblMakbuz, String> makbuzNo;
    public static volatile SingularAttribute<TblMakbuz, Date> odemeTarihi;

}