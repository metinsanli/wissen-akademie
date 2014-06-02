/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.entity;

import java.sql.Date;

/**

 @author metin
 */
public class Kisi {

    private String TCKimlik;
    private String ad;
    private String soyad;
    private Date dogumTarih;
    private String email;
    //
    private String daireNo;
    private boolean sahiplik;
    private String PROTCNO; // UPDATE ve DELETE islemlerinde kullanilacak.

    public Kisi (String tc, String ad, String soyad, Date dogum, String email) {
        this.TCKimlik = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarih = dogum;
        this.email = email;
    }

    public Kisi (String orjinalTC, String tc, String ad, String soyad, Date dogum, String email, String daireNo, boolean sahiplikDurumu) {
        this.TCKimlik = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarih = dogum;
        this.email = email;
        this.daireNo = daireNo;
        this.sahiplik = sahiplikDurumu;
        this.PROTCNO = orjinalTC;
    }

    public String getPROTCNO () {
        return PROTCNO;
    }

    public void setPROTCNO (String PROTCNO) {
        this.PROTCNO = PROTCNO;
    }

    public String getDaireNo () {
        return daireNo;
    }

    public void setDaireNo (String daireNo) {
        this.daireNo = daireNo;
    }

    public boolean isSahiplik () {
        return sahiplik;
    }

    public void setSahiplik (boolean sahiplik) {
        this.sahiplik = sahiplik;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public Kisi () {
    } // end constructor DEFAULT

    public String getTCKimlik () {
        return TCKimlik;
    }

    public void setTCKimlik (String TCKimlik) {
        this.TCKimlik = TCKimlik;
    }

    public String getAd () {
        return ad;
    }

    public void setAd (String ad) {
        this.ad = ad;
    }

    public String getSoyad () {
        return soyad;
    }

    public void setSoyad (String soyad) {
        this.soyad = soyad;
    }

    public Date getDogumTarih () {
        return dogumTarih;
    }

    public void setDogumTarih (Date dogumTarih) {
        this.dogumTarih = dogumTarih;
    }

}
