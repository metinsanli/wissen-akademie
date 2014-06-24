package com.wissen.entity;

import com.wissen.entity.TblKisiDaire;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-23T09:36:18")
@StaticMetamodel(TblDaire.class)
public class TblDaire_ { 

    public static volatile SingularAttribute<TblDaire, Integer> metreKare;
    public static volatile SingularAttribute<TblDaire, Integer> balkonSayisi;
    public static volatile SingularAttribute<TblDaire, String> daireNo;
    public static volatile CollectionAttribute<TblDaire, TblKisiDaire> tblKisiDaireCollection;
    public static volatile SingularAttribute<TblDaire, String> cephe;
    public static volatile SingularAttribute<TblDaire, Boolean> ebeveynBanyo;
    public static volatile SingularAttribute<TblDaire, Boolean> dublex;
    public static volatile SingularAttribute<TblDaire, Integer> katNo;
    public static volatile SingularAttribute<TblDaire, String> odaSayisi;

}