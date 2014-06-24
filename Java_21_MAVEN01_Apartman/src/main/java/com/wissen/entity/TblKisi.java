/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wissen.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**

 @author metin
 */
@Entity
@Table(name = "tblKisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKisi.findAll", query = "SELECT t FROM TblKisi t"),
    @NamedQuery(name = "TblKisi.findByTCKimlikNo", query = "SELECT t FROM TblKisi t WHERE t.tCKimlikNo = :tCKimlikNo"),
    @NamedQuery(name = "TblKisi.findByAdi", query = "SELECT t FROM TblKisi t WHERE t.adi = :adi"),
    @NamedQuery(name = "TblKisi.findBySoyadi", query = "SELECT t FROM TblKisi t WHERE t.soyadi = :soyadi"),
    @NamedQuery(name = "TblKisi.findByDogumTarihi", query = "SELECT t FROM TblKisi t WHERE t.dogumTarihi = :dogumTarihi"),
    @NamedQuery(name = "TblKisi.findByEmail", query = "SELECT t FROM TblKisi t WHERE t.email = :email")})
public class TblKisi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TCKimlikNo")
    private String tCKimlikNo;
    @Size(max = 20)
    @Column(name = "Adi")
    private String adi;
    @Size(max = 20)
    @Column(name = "Soyadi")
    private String soyadi;
    @Column(name = "DogumTarihi")
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblKisi")
    private Collection<TblKisiDaire> tblKisiDaireCollection;
    @OneToMany(mappedBy = "tCKimlikNo")
    private Collection<TblMakbuz> tblMakbuzCollection;

    public TblKisi () {
    }

    public TblKisi (String tCKimlikNo) {
        this.tCKimlikNo = tCKimlikNo;
    }

    public String getTCKimlikNo () {
        return tCKimlikNo;
    }

    public void setTCKimlikNo (String tCKimlikNo) {
        this.tCKimlikNo = tCKimlikNo;
    }

    public String getAdi () {
        return adi;
    }

    public void setAdi (String adi) {
        this.adi = adi;
    }

    public String getSoyadi () {
        return soyadi;
    }

    public void setSoyadi (String soyadi) {
        this.soyadi = soyadi;
    }

    public Date getDogumTarihi () {
        return dogumTarihi;
    }

    public void setDogumTarihi (Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<TblKisiDaire> getTblKisiDaireCollection () {
        return tblKisiDaireCollection;
    }

    public void setTblKisiDaireCollection (Collection<TblKisiDaire> tblKisiDaireCollection) {
        this.tblKisiDaireCollection = tblKisiDaireCollection;
    }

    @XmlTransient
    public Collection<TblMakbuz> getTblMakbuzCollection () {
        return tblMakbuzCollection;
    }

    public void setTblMakbuzCollection (Collection<TblMakbuz> tblMakbuzCollection) {
        this.tblMakbuzCollection = tblMakbuzCollection;
    }

    @Override
    public int hashCode () {
        int hash = 0;
        hash += (tCKimlikNo != null ? tCKimlikNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKisi)) {
            return false;
        }
        TblKisi other = (TblKisi) object;
        if ((this.tCKimlikNo == null && other.tCKimlikNo != null) || (this.tCKimlikNo != null && !this.tCKimlikNo.equals(other.tCKimlikNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return "com.wissen.entity.TblKisi[ tCKimlikNo=" + tCKimlikNo + " ]";
    }
    
}
