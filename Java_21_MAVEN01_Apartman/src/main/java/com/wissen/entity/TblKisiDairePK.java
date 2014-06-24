/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wissen.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**

 @author metin
 */
@Embeddable
public class TblKisiDairePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TCKimlikNo")
    private String tCKimlikNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DaireNo")
    private String daireNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SahiplikDurumu")
    private boolean sahiplikDurumu;

    public TblKisiDairePK () {
    }

    public TblKisiDairePK (String tCKimlikNo, String daireNo, boolean sahiplikDurumu) {
        this.tCKimlikNo = tCKimlikNo;
        this.daireNo = daireNo;
        this.sahiplikDurumu = sahiplikDurumu;
    }

    public String getTCKimlikNo () {
        return tCKimlikNo;
    }

    public void setTCKimlikNo (String tCKimlikNo) {
        this.tCKimlikNo = tCKimlikNo;
    }

    public String getDaireNo () {
        return daireNo;
    }

    public void setDaireNo (String daireNo) {
        this.daireNo = daireNo;
    }

    public boolean getSahiplikDurumu () {
        return sahiplikDurumu;
    }

    public void setSahiplikDurumu (boolean sahiplikDurumu) {
        this.sahiplikDurumu = sahiplikDurumu;
    }

    @Override
    public int hashCode () {
        int hash = 0;
        hash += (tCKimlikNo != null ? tCKimlikNo.hashCode() : 0);
        hash += (daireNo != null ? daireNo.hashCode() : 0);
        hash += (sahiplikDurumu ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKisiDairePK)) {
            return false;
        }
        TblKisiDairePK other = (TblKisiDairePK) object;
        if ((this.tCKimlikNo == null && other.tCKimlikNo != null) || (this.tCKimlikNo != null && !this.tCKimlikNo.equals(other.tCKimlikNo))) {
            return false;
        }
        if ((this.daireNo == null && other.daireNo != null) || (this.daireNo != null && !this.daireNo.equals(other.daireNo))) {
            return false;
        }
        if (this.sahiplikDurumu != other.sahiplikDurumu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return "com.wissen.entity.TblKisiDairePK[ tCKimlikNo=" + tCKimlikNo + ", daireNo=" + daireNo + ", sahiplikDurumu=" + sahiplikDurumu + " ]";
    }
    
}
