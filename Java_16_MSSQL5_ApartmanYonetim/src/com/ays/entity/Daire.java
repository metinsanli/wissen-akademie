/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.entity;

public class Daire {

    private String daireNo;
    private int metreKare;
    private int katNo;
    private String cephe;
    private String odaSayisi;
    private boolean ebeveynBanyo;
    private int balkonSayisi;
    private boolean dublex;

    public Daire () {

    } // end cosntructor DEFAULT

    public Daire (String dno, int mkare, int kno, String cephe, String osayisi, boolean ebanyo, int bsayi, boolean dublex) {
        this.daireNo = dno;
        this.metreKare = mkare;
        this.katNo = kno;
        this.cephe = cephe;
        this.odaSayisi = osayisi;
        this.ebeveynBanyo = ebanyo;
        this.balkonSayisi = bsayi;
        this.dublex = dublex;
    } // end constructor

    public String getDaireNo () {
        return daireNo;
    }

    public void setDaireNo (String daireNo) {
        this.daireNo = daireNo;
    }

    public int getMetreKare () {
        return metreKare;
    }

    public void setMetreKare (int metreKare) {
        this.metreKare = metreKare;
    }

    public int getKatNo () {
        return katNo;
    }

    public void setKatNo (int katNo) {
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

    public boolean isEbeveynBanyo () {
        return ebeveynBanyo;
    }

    public void setEbeveynBanyo (boolean ebeveynBanyo) {
        this.ebeveynBanyo = ebeveynBanyo;
    }

    public int getBalkonSayisi () {
        return balkonSayisi;
    }

    public void setBalkonSayisi (int balkonSayisi) {
        this.balkonSayisi = balkonSayisi;
    }

    public boolean isDublex () {
        return dublex;
    }

    public void setDublex (boolean dublex) {
        this.dublex = dublex;
    }

} // END CLASS
