/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.databaseop;

import com.ays.entity.Daire;
import com.ays.entity.Gider;
import com.ays.entity.Kisi;
import com.ays.forms.MainFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBConn {

    private static final String URL = "jdbc:sqlserver://10.0.0.10:1433;databasename=dbApartman";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "D3n3m3123";
    private Connection connection = null;
    private ResultSet veri;

    public DBConn () {
        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException ex) {
            MainFrame.durumMesaji("Sql Server baglantisinda sorun var!!");
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
        }
        //MainFrame.durumMesaji("Sql Server baglantisi basarili.");
    }

    public int insertKisi (Kisi kisi) {

        int result = 0;
        try {

            PreparedStatement insert = connection.prepareStatement("INSERT INTO [dbApartman].[dbo].[tblKisi]"
                    + " ( [TCKimlikNo], [Adi], [Soyadi], [DogumTarihi], [Email] )"
                    + " VALUES ( ?, ?, ?, CONVERT (DATE , ? , 104), ? )");
            insert.setString(1, kisi.getTCKimlik());
            insert.setString(2, kisi.getAd());
            insert.setString(3, kisi.getSoyad());
            insert.setDate(4, kisi.getDogumTarih());
            insert.setString(5, kisi.getEmail());

            result = insert.executeUpdate(); // daire(Daire) nesnesinden gelen

            MainFrame.durumMesaji("Kisi bilgisi kaydedildi.");

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) {
                MainFrame.durumMesaji("Eklediginiz kayit zaten var!");
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
            }
        } finally {
            close();
        }
        return result;
    }

    public int updateKisi (Kisi kisi) {

        int result = 0;

        try {

            PreparedStatement update = connection.prepareStatement("UPDATE [tblKisi]"
                    + " SET [Adi] = ?, [Soyadi] = ?, [DogumTarihi] = CONVERT (DATE , ? , 104), [Email] = ?"
                    + " WHERE [TCKimlikNo] = ?");
            // Eger SQL SERVER'in Region and Language ayarlari English (2014-01-12) format
            // olarak ayarliysa update.setDate(3, kisi.getDogumTarih()); satirinin 
            // verdigi Turkish (12.01.2014) tarih formati CONVERT (DATE , ? , 104) ile English
            // formatina cevrilecektir.

            update.setString(1, kisi.getAd());
            update.setString(2, kisi.getSoyad());
            update.setDate(3, kisi.getDogumTarih());
            update.setString(4, kisi.getEmail());
            update.setString(5, kisi.getTCKimlik());

            result = update.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata olustu!\n" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    public int deleteKisi (Kisi kisi) {

        int result = 0;

        try {

            PreparedStatement delete = connection.prepareStatement("DELETE FROM [dbApartman].[dbo].[tblKisi]"
                    + " WHERE [TCKimlikNo] = ?");

            delete.setString(1, kisi.getTCKimlik());

            result = delete.executeUpdate();

            MainFrame.durumMesaji(kisi.getAd() + " " + kisi.getSoyad() + " isimli kisi kayidi silindi.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata olustu!\n" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    public ArrayList<Kisi> getAllKisi () {
        ArrayList<Kisi> kisiler = new ArrayList<>();
        PreparedStatement selectTumKisiler;
        try {
            selectTumKisiler = connection.prepareStatement("SELECT * FROM [tblKisi] ORDER BY [Adi]");
            veri = selectTumKisiler.executeQuery();
            while (veri.next()) {
                Kisi kisi = new Kisi();
                kisi.setTCKimlik(veri.getString("TCKimlikNo"));
                kisi.setAd(veri.getString("Adi"));
                kisi.setSoyad(veri.getString("Soyadi"));
                kisi.setDogumTarih(veri.getDate("DogumTarihi"));
                kisi.setEmail(veri.getString("Email"));
                kisiler.add(kisi);
            }
        } catch (SQLException ex) {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
        } finally {
            close();
        }
        return kisiler;
    }

    public Kisi getKisi (String tckno) {
        Kisi kisi = new Kisi();
        try {

            PreparedStatement sorgu = connection.prepareStatement("SELECT tblKisi.TCKimlikNo, tblKisi.Adi, tblKisi.Soyadi, tblKisi.DogumTarihi, tblKisi.Email, tblKisiDaire.DaireNo, tblKisiDaire.SahiplikDurumu"
                    + " FROM tblKisi LEFT OUTER JOIN tblKisiDaire ON tblKisi.TCKimlikNo = tblKisiDaire.TCKimlikNo"
                    + " WHERE [tblKisi].[TCKimlikNo] LIKE ?");
            sorgu.setString(1, tckno);

            veri = sorgu.executeQuery();

            while (veri.next()) {
                kisi.setTCKimlik(veri.getString("TCKimlikNo"));
                kisi.setAd(veri.getString("Adi"));
                kisi.setSoyad(veri.getString("Soyadi"));
                kisi.setDogumTarih(veri.getDate("DogumTarihi"));
                kisi.setEmail(veri.getString("Email"));
                kisi.setDaireNo(veri.getString("DaireNo"));
                kisi.setSahiplik(veri.getBoolean("SahiplikDurumu"));
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
            ex.printStackTrace();
        } finally {
            close();
        }
        return kisi;
    }

    public int insertDaire (Daire daire) {

        int result = 0;
        try {

            PreparedStatement insert = connection.prepareStatement("INSERT INTO [dbApartman].[dbo].[tblDaire]"
                    + " ( [DaireNo], [MetreKare], [KatNo], [Cephe], [OdaSayisi], [EbeveynBanyo], [BalkonSayisi], [Dublex] )"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )");

            insert.setString(1, daire.getDaireNo());
            insert.setInt(2, daire.getMetreKare());
            insert.setInt(3, daire.getKatNo());
            insert.setString(4, daire.getCephe());
            insert.setString(5, daire.getOdaSayisi());
            insert.setBoolean(6, daire.isEbeveynBanyo());
            insert.setInt(7, daire.getBalkonSayisi());
            insert.setBoolean(8, daire.isDublex());

            result = insert.executeUpdate(); // daire(Daire) nesnesinden gelen

            MainFrame.durumMesaji(daire.getDaireNo() + " nolu daire veri tabanina eklendi.");

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) {
                JOptionPane.showMessageDialog(null, "\nEklediginiz deger zaten var!");
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
            }
        } finally {
            close();
        }
        return result;
    }

    public int updateDaire (Daire daire) {
        int result = 0;
        try {

            PreparedStatement update = connection.prepareStatement("UPDATE [dbApartman].[dbo].[tblDaire]"
                    + " SET [MetreKare] = ?, [KatNo]  = ?, [Cephe] = ?, [OdaSayisi] = ?, [EbeveynBanyo] = ?, [BalkonSayisi] = ?, [Dublex] = ?"
                    + " WHERE [DaireNo] = ?");

            update.setInt(1, daire.getMetreKare());
            update.setInt(2, daire.getKatNo());
            update.setString(3, daire.getCephe());
            update.setString(4, daire.getOdaSayisi());
            update.setBoolean(5, daire.isEbeveynBanyo());
            update.setInt(6, daire.getBalkonSayisi());
            update.setBoolean(7, daire.isDublex());
            update.setString(8, daire.getDaireNo());

            result = update.executeUpdate(); // daire(Daire) nesnesinden gelen

            MainFrame.durumMesaji(daire.getDaireNo() + " nolu daireye ait bilgiler guncellendi.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata olustu!\n" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    public int deleteDaire (Daire daire) {
        int result = 0;
        try {

            PreparedStatement update = connection.prepareStatement("DELETE FROM [dbApartman].[dbo].[tblDaire]"
                    + " WHERE [DaireNo] = ?");

            update.setString(1, daire.getDaireNo());

            result = update.executeUpdate(); // daire(Daire) nesnesinden gelen

            MainFrame.durumMesaji(daire.getDaireNo() + " nolu daire kayidi silindi.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata olustu!\n" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    public ArrayList<Daire> getAllDaire () {
        ArrayList<Daire> daireler = new ArrayList<>();
        PreparedStatement selectTumDaireler;
        try {
            selectTumDaireler = connection.prepareStatement("SELECT * FROM [dbApartman].[dbo].[tblDaire] ORDER BY [DaireNo]");
            veri = selectTumDaireler.executeQuery();
            //results = new Vector<Daire>();
            while (veri.next()) {
                Daire daire = new Daire();
                daire.setDaireNo(veri.getString("DaireNo"));
                daire.setMetreKare(veri.getInt("MetreKare"));
                daire.setKatNo(veri.getInt("KatNo"));
                daire.setCephe(veri.getString("Cephe"));
                daire.setOdaSayisi(veri.getString("OdaSayisi"));
                daire.setEbeveynBanyo(veri.getBoolean("EbeveynBanyo"));
                daire.setBalkonSayisi(veri.getInt("BalkonSayisi"));
                daire.setDublex(veri.getBoolean("Dublex"));
                daireler.add(daire);
            }
        } catch (SQLException ex) {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
        } finally {
            close();
        }
        return daireler;
    }

    public Daire getDaire (String daireNo) {
        Daire daire = new Daire();
        try {
            /**
             Burada, getAllDaire() metodu ile veri tabanindan tum daireleri cekip icinden
             istedigim daireyi .equals() ile bulabilirdim fakat daha cok SQL sorgusu
             kullanmak icin PreparedStatement sinifini zorladim.
             */

            PreparedStatement sorgu = connection.prepareStatement("SELECT * FROM [dbApartman].[dbo].[tblDaire]"
                    + " WHERE [DaireNo]"
                    + " LIKE ? ORDER BY [DaireNo] ASC");
            sorgu.setString(1, daireNo);
            veri = sorgu.executeQuery();
            while (veri.next()) {
                daire.setDaireNo(veri.getString("DaireNo"));
                daire.setMetreKare(veri.getInt("MetreKare"));
                daire.setKatNo(veri.getInt("KatNo"));
                daire.setCephe(veri.getString("Cephe"));
                daire.setOdaSayisi(veri.getString("OdaSayisi"));
                daire.setEbeveynBanyo(veri.getBoolean("EbeveynBanyo"));
                daire.setBalkonSayisi(veri.getInt("BalkonSayisi"));
                daire.setDublex(veri.getBoolean("Dublex"));
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "getDaire() Hata olustu! :\n " + ex.getMessage());
        } finally {
            close();
        }
        return daire;
    }

    public int insertGider (Gider gider) {
        int result = 0;
        try {

            PreparedStatement insert = connection.prepareStatement("INSERT INTO [dbApartman].[dbo].[tblGider]"
                    + " ( [GiderKod], [GiderAdi] )"
                    + " VALUES ( ?, ? )");

            insert.setString(1, gider.getKod());
            insert.setString(2, gider.getAd());

            result = insert.executeUpdate();

            MainFrame.durumMesaji(gider.getAd() + " isimli gider veri tabanina eklendi.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "insertGider() Hata olustu!\n" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    public int updateGider (Gider gider) {

        int result = 0;

        try {

            PreparedStatement update = connection.prepareStatement("UPDATE [dbApartman].[dbo].[tblGider]"
                    + " SET [GiderAdi] = ?"
                    + " WHERE [GiderKod] = ?");

            update.setString(1, gider.getAd());
            update.setString(2, gider.getKod());

            result = update.executeUpdate();

            MainFrame.durumMesaji(gider.getAd() + " isimli gidere ait bilgiler guncellendi.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "updateGider() Hata olustu!\n" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    public int deleteGider (Gider gider) {

        int result = 0;

        try {

            PreparedStatement update = connection.prepareStatement("DELETE FROM [dbApartman].[dbo].[tblGider]"
                    + " WHERE [GiderKod] = ?");

            update.setString(1, gider.getKod());

            result = update.executeUpdate();

            MainFrame.durumMesaji(gider.getAd() + " isimli gider kayidi silindi.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "updateGider() Hata olustu!\n" + ex.getMessage());
        } finally {
            close();
        }
        return result;
    }

    public ArrayList<Gider> getAllGider () {

        ArrayList<Gider> giderler = new ArrayList<>();

        try {

            PreparedStatement sorgu = connection.prepareStatement("SELECT * FROM [tblGider] ORDER BY [GiderKod]");

            veri = sorgu.executeQuery();

            while (veri.next()) {
                Gider gider = new Gider(veri.getString("GiderKod"), veri.getString("GiderAdi"));
                giderler.add(gider);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getAllGider() Hata olustu!\n" + ex.getMessage());
        } finally {
            close();
        }
        return giderler;
    }

    public Gider getGider (String giderKod) {

        Gider gider = new Gider();

        try {

            PreparedStatement sorgu = connection.prepareStatement("SELECT * FROM [tblGider]"
                    + " WHERE [GiderKod] = ?");

            sorgu.setString(1, giderKod);
            veri = sorgu.executeQuery();

            while (veri.next()) {
                gider.setKod(veri.getString("GiderKod"));
                gider.setAd(veri.getString("GiderAdi"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getGider() Hata olustu!\n" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            close();
        }

        return gider;
    }

    public void close () {
        try {
            if (veri != null) { // Eger "veri" (PreparedStatement) sinif degiskeni hic kullanilmamissa burasi calismaz.
                veri.close();   // Sadece "connection.close();" calisacaktir.
            }
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "close() Hata olustu!\nHata Kodu : " + ex.getErrorCode() + "\n" + ex.getMessage());
        }
    }

} // END CLASS
