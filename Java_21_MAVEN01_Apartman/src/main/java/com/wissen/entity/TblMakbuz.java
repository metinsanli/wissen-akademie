/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wissen.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author metin
 */
@Entity
@Table(name = "tblMakbuz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMakbuz.findAll", query = "SELECT t FROM TblMakbuz t"),
    @NamedQuery(name = "TblMakbuz.findByMakbuzNo", query = "SELECT t FROM TblMakbuz t WHERE t.makbuzNo = :makbuzNo"),
    @NamedQuery(name = "TblMakbuz.findByAy", query = "SELECT t FROM TblMakbuz t WHERE t.ay = :ay"),
    @NamedQuery(name = "TblMakbuz.findByDaireNo", query = "SELECT t FROM TblMakbuz t WHERE t.daireNo = :daireNo"),
    @NamedQuery(name = "TblMakbuz.findByTutari", query = "SELECT t FROM TblMakbuz t WHERE t.tutari = :tutari"),
    @NamedQuery(name = "TblMakbuz.findByOdemeTarihi", query = "SELECT t FROM TblMakbuz t WHERE t.odemeTarihi = :odemeTarihi"),
    @NamedQuery(name = "TblMakbuz.findByDurumu", query = "SELECT t FROM TblMakbuz t WHERE t.durumu = :durumu")})
public class TblMakbuz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MakbuzNo")
    private String makbuzNo;
    @Column(name = "Ay")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ay;
    @Size(max = 10)
    @Column(name = "DaireNo")
    private String daireNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Tutari")
    private Double tutari;
    @Column(name = "OdemeTarihi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date odemeTarihi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Durumu")
    private boolean durumu;
    @JoinColumn(name = "TCKimlikNo", referencedColumnName = "TCKimlikNo")
    @ManyToOne
    private TblKisi tCKimlikNo;

    public TblMakbuz () {
    }

    public TblMakbuz (String makbuzNo) {
        this.makbuzNo = makbuzNo;
    }

    public TblMakbuz (String makbuzNo, boolean durumu) {
        this.makbuzNo = makbuzNo;
        this.durumu = durumu;
    }

    public String getMakbuzNo () {
        return makbuzNo;
    }

    public void setMakbuzNo (String makbuzNo) {
        this.makbuzNo = makbuzNo;
    }

    public Date getAy () {
        return ay;
    }

    public void setAy (Date ay) {
        this.ay = ay;
    }

    public String getDaireNo () {
        return daireNo;
    }

    public void setDaireNo (String daireNo) {
        this.daireNo = daireNo;
    }

    public Double getTutari () {
        return tutari;
    }

    public void setTutari (Double tutari) {
        this.tutari = tutari;
    }

    public Date getOdemeTarihi () {
        return odemeTarihi;
    }

    public void setOdemeTarihi (Date odemeTarihi) {
        this.odemeTarihi = odemeTarihi;
    }

    public boolean getDurumu () {
        return durumu;
    }

    public void setDurumu (boolean durumu) {
        this.durumu = durumu;
    }

    public TblKisi getTCKimlikNo () {
        return tCKimlikNo;
    }

    public void setTCKimlikNo (TblKisi tCKimlikNo) {
        this.tCKimlikNo = tCKimlikNo;
    }

    @Override
    public int hashCode () {
        int hash = 0;
        hash += (makbuzNo != null ? makbuzNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMakbuz)) {
            return false;
        }
        TblMakbuz other = (TblMakbuz) object;
        if ((this.makbuzNo == null && other.makbuzNo != null) || (this.makbuzNo != null && !this.makbuzNo.equals(other.makbuzNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return "com.wissen.entity.TblMakbuz[ makbuzNo=" + makbuzNo + " ]";
    }
    
}
