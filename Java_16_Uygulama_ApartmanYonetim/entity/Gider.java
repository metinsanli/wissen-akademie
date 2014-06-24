/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.entity;

/**

 @author metin
 */
public class Gider {

    private String kod;
    private String ad;
    private String PROkod; // UPDATE ve DELETE islemlerinde kullanilacak.

    public Gider () {

    }

    public Gider (String kod, String ad) {
        this.ad = ad;
        this.kod = kod;
    }

    public Gider (String proKod, String kod, String ad) {
        this.ad = ad;
        this.kod = kod;
        this.PROkod = proKod;
    }

    public String toString () {
        return this.kod + " - " + this.ad;
    }

    public String getPROkod () {
        return PROkod;
    }

    public void setPROkod (String PROkod) {
        this.PROkod = PROkod;
    }

    public String getKod () {
        return kod;
    }

    public void setKod (String kod) {
        this.kod = kod;
    }

    public String getAd () {
        return ad;
    }

    public void setAd (String ad) {
        this.ad = ad;
    }

}
