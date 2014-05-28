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

    public Kisi () {
    } // end constructor DEFAULT

    public Kisi (String tc, String ad, String soyad, Date dogum) {
        this.TCKimlik = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarih = dogum;
    }

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
