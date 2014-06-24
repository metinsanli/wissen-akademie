package com.wissen.soru;

import java.sql.Date;

public class Skor {

    private int id;
    private String ad;
    private String soyad;
    private int puan;
    private Date tarih;

    public Skor () {
    }

    public Skor (Integer id, String ad, String soyad, int puan, Date tarih) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.puan = puan;
        this.tarih = tarih;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
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

    public int getPuan () {
        return puan;
    }

    public void setPuan (int puan) {
        this.puan = puan;
    }

    public Date getTarih () {
        return tarih;
    }

    public void setTarih (Date tarih) {
        this.tarih = tarih;
    }

    public String[] getAllData () {
        String[] all = new String[5];
        all[0] = String.valueOf(id);
        all[1] = ad;
        all[2] = soyad;
        all[3] = tarih.toString();
        all[4] = String.valueOf(puan);
        return all;
    }

    @Override
    public String toString () {
        return id + "";
    }

}
