package com.wissen.entity;

import com.wissen.entity.TblKisiDaire;
import com.wissen.entity.TblMakbuz;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-23T09:36:18")
@StaticMetamodel(TblKisi.class)
public class TblKisi_ { 

    public static volatile SingularAttribute<TblKisi, Date> dogumTarihi;
    public static volatile SingularAttribute<TblKisi, String> tCKimlikNo;
    public static volatile CollectionAttribute<TblKisi, TblKisiDaire> tblKisiDaireCollection;
    public static volatile CollectionAttribute<TblKisi, TblMakbuz> tblMakbuzCollection;
    public static volatile SingularAttribute<TblKisi, String> adi;
    public static volatile SingularAttribute<TblKisi, String> soyadi;
    public static volatile SingularAttribute<TblKisi, String> email;

}