/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wissen.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author metin
 */
@Entity
@Table(name = "tblKisiDaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKisiDaire.findAll", query = "SELECT t FROM TblKisiDaire t"),
    @NamedQuery(name = "TblKisiDaire.findByTCKimlikNo", query = "SELECT t FROM TblKisiDaire t WHERE t.tblKisiDairePK.tCKimlikNo = :tCKimlikNo"),
    @NamedQuery(name = "TblKisiDaire.findByDaireNo", query = "SELECT t FROM TblKisiDaire t WHERE t.tblKisiDairePK.daireNo = :daireNo"),
    @NamedQuery(name = "TblKisiDaire.findBySahiplikDurumu", query = "SELECT t FROM TblKisiDaire t WHERE t.tblKisiDairePK.sahiplikDurumu = :sahiplikDurumu")})
public class TblKisiDaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblKisiDairePK tblKisiDairePK;
    @JoinColumn(name = "DaireNo", referencedColumnName = "DaireNo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblDaire tblDaire;
    @JoinColumn(name = "TCKimlikNo", referencedColumnName = "TCKimlikNo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblKisi tblKisi;

    public TblKisiDaire () {
    }

    public TblKisiDaire (TblKisiDairePK tblKisiDairePK) {
        this.tblKisiDairePK = tblKisiDairePK;
    }

    public TblKisiDaire (String tCKimlikNo, String daireNo, boolean sahiplikDurumu) {
        this.tblKisiDairePK = new TblKisiDairePK(tCKimlikNo, daireNo, sahiplikDurumu);
    }

    public TblKisiDairePK getTblKisiDairePK () {
        return tblKisiDairePK;
    }

    public void setTblKisiDairePK (TblKisiDairePK tblKisiDairePK) {
        this.tblKisiDairePK = tblKisiDairePK;
    }

    public TblDaire getTblDaire () {
        return tblDaire;
    }

    public void setTblDaire (TblDaire tblDaire) {
        this.tblDaire = tblDaire;
    }

    public TblKisi getTblKisi () {
        return tblKisi;
    }

    public void setTblKisi (TblKisi tblKisi) {
        this.tblKisi = tblKisi;
    }

    @Override
    public int hashCode () {
        int hash = 0;
        hash += (tblKisiDairePK != null ? tblKisiDairePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKisiDaire)) {
            return false;
        }
        TblKisiDaire other = (TblKisiDaire) object;
        if ((this.tblKisiDairePK == null && other.tblKisiDairePK != null) || (this.tblKisiDairePK != null && !this.tblKisiDairePK.equals(other.tblKisiDairePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return "com.wissen.entity.TblKisiDaire[ tblKisiDairePK=" + tblKisiDairePK + " ]";
    }
    
}
