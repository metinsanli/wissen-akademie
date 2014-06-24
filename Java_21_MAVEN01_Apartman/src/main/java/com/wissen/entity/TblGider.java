/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wissen.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author metin
 */
@Entity
@Table(name = "tblGider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGider.findAll", query = "SELECT t FROM TblGider t"),
    @NamedQuery(name = "TblGider.findByGiderKod", query = "SELECT t FROM TblGider t WHERE t.giderKod = :giderKod"),
    @NamedQuery(name = "TblGider.findByGiderAdi", query = "SELECT t FROM TblGider t WHERE t.giderAdi = :giderAdi")})
public class TblGider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GiderKod")
    private String giderKod;
    @Size(max = 20)
    @Column(name = "GiderAdi")
    private String giderAdi;

    public TblGider () {
    }

    public TblGider (String giderKod) {
        this.giderKod = giderKod;
    }

    public String getGiderKod () {
        return giderKod;
    }

    public void setGiderKod (String giderKod) {
        this.giderKod = giderKod;
    }

    public String getGiderAdi () {
        return giderAdi;
    }

    public void setGiderAdi (String giderAdi) {
        this.giderAdi = giderAdi;
    }

    @Override
    public int hashCode () {
        int hash = 0;
        hash += (giderKod != null ? giderKod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGider)) {
            return false;
        }
        TblGider other = (TblGider) object;
        if ((this.giderKod == null && other.giderKod != null) || (this.giderKod != null && !this.giderKod.equals(other.giderKod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return "com.wissen.entity.TblGider[ giderKod=" + giderKod + " ]";
    }
    
}
