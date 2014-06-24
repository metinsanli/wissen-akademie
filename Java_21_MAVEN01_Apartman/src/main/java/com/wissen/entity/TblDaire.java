/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wissen.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**

 @author metin
 */
@Entity
@Table(name = "tblDaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDaire.findAll", query = "SELECT t FROM TblDaire t"),
    @NamedQuery(name = "TblDaire.findByDaireNo", query = "SELECT t FROM TblDaire t WHERE t.daireNo = :daireNo"),
    @NamedQuery(name = "TblDaire.findByMetreKare", query = "SELECT t FROM TblDaire t WHERE t.metreKare = :metreKare"),
    @NamedQuery(name = "TblDaire.findByKatNo", query = "SELECT t FROM TblDaire t WHERE t.katNo = :katNo"),
    @NamedQuery(name = "TblDaire.findByCephe", query = "SELECT t FROM TblDaire t WHERE t.cephe = :cephe"),
    @NamedQuery(name = "TblDaire.findByOdaSayisi", query = "SELECT t FROM TblDaire t WHERE t.odaSayisi = :odaSayisi"),
    @NamedQuery(name = "TblDaire.findByEbeveynBanyo", query = "SELECT t FROM TblDaire t WHERE t.ebeveynBanyo = :ebeveynBanyo"),
    @NamedQuery(name = "TblDaire.findByBalkonSayisi", query = "SELECT t FROM TblDaire t WHERE t.balkonSayisi = :balkonSayisi"),
    @NamedQuery(name = "TblDaire.findByDublex", query = "SELECT t FROM TblDaire t WHERE t.dublex = :dublex")})
public class TblDaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DaireNo")
    private String daireNo;
    @Column(name = "MetreKare")
    private Integer metreKare;
    @Column(name = "KatNo")
    private Integer katNo;
    @Size(max = 20)
    @Column(name = "Cephe")
    private String cephe;
    @Size(max = 10)
    @Column(name = "OdaSayisi")
    private String odaSayisi;
    @Column(name = "EbeveynBanyo")
    private Boolean ebeveynBanyo;
    @Column(name = "BalkonSayisi")
    private Integer balkonSayisi;
    @Column(name = "Dublex")
    private Boolean dublex;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblDaire")
    private Collection<TblKisiDaire> tblKisiDaireCollection;

    public TblDaire () {
    }

    public TblDaire (String daireNo) {
        this.daireNo = daireNo;
    }

    public String getDaireNo () {
        return daireNo;
    }

    public void setDaireNo (String daireNo) {
        this.daireNo = daireNo;
    }

    public Integer getMetreKare () {
        return metreKare;
    }

    public void setMetreKare (Integer metreKare) {
        this.metreKare = metreKare;
    }

    public Integer getKatNo () {
        return katNo;
    }

    public void setKatNo (Integer katNo) {
        this.katNo = katNo;
    }

    public String getCephe () {
        return cephe;
    }

    public void setCephe (String cephe) {
        this.cephe = cephe;
    }

    public String getOdaSayisi () {
        return odaSayisi;
    }

    public void setOdaSayisi (String odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public Boolean getEbeveynBanyo () {
        return ebeveynBanyo;
    }

    public void setEbeveynBanyo (Boolean ebeveynBanyo) {
        this.ebeveynBanyo = ebeveynBanyo;
    }

    public Integer getBalkonSayisi () {
        return balkonSayisi;
    }

    public void setBalkonSayisi (Integer balkonSayisi) {
        this.balkonSayisi = balkonSayisi;
    }

    public Boolean getDublex () {
        return dublex;
    }

    public void setDublex (Boolean dublex) {
        this.dublex = dublex;
    }

    @XmlTransient
    public Collection<TblKisiDaire> getTblKisiDaireCollection () {
        return tblKisiDaireCollection;
    }

    public void setTblKisiDaireCollection (Collection<TblKisiDaire> tblKisiDaireCollection) {
        this.tblKisiDaireCollection = tblKisiDaireCollection;
    }

    @Override
    public int hashCode () {
        int hash = 0;
        hash += (daireNo != null ? daireNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDaire)) {
            return false;
        }
        TblDaire other = (TblDaire) object;
        if ((this.daireNo == null && other.daireNo != null) || (this.daireNo != null && !this.daireNo.equals(other.daireNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return "com.wissen.entity.TblDaire[ daireNo=" + daireNo + " ]";
    }
    
}
