/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.databaseop;

import com.ays.entity.Daire;
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
        MainFrame.durumMesaji("Sql Server baglantisi basarili.");
    }

    public int insertKisi (Kisi kisi) {

        int result = 0;
        try {

            PreparedStatement insert = connection.prepareStatement("INSERT INTO [dbApartman].[dbo].[tblKisi]"
                    + " ( [TCKimlikNo], [Adi], [Soyadi], [DogumTarihi] )"
                    + " VALUES ( ?, ?, ?, CONVERT (DATE , ? , 104) )");
            insert.setString(1, kisi.getTCKimlik());
            insert.setString(2, kisi.getAd());
            insert.setString(3, kisi.getSoyad());
            insert.setDate(4, kisi.getDogumTarih());

            result = insert.executeUpdate(); // daire(Daire) nesnesinden gelen

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
                    + " [Adi] = ?, [Soyadi] = ?, [DogumTarihi] = CONVERT (DATE , ? , 104)"
                    + " WHERE [TCKimlikNo] = ?");

            update.setString(1, kisi.getAd());
            update.setString(2, kisi.getSoyad());
            update.setDate(3, kisi.getDogumTarih());
            update.setString(4, kisi.getTCKimlik());

            result = update.executeUpdate();

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

            PreparedStatement sorgu = connection.prepareStatement("SELECT * FROM [tblKisi]"
                    + " WHERE [TCKimlikNo] LIKE ?");
            sorgu.setString(1, tckno);
            veri = sorgu.executeQuery();
            while (veri.next()) {
                kisi.setTCKimlik(veri.getString("TCKimlikNo"));
                kisi.setAd(veri.getString("Adi"));
                kisi.setSoyad(veri.getString("Soyadi"));
                kisi.setDogumTarih(veri.getDate("DogumTarihi"));
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
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

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "\nEklediginiz deger zaten var!");
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
            JOptionPane.showConfirmDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
        } finally {
            close();
        }
        return daire;
    }

    public void close () {
        try {
            if (veri != null) { // Eger "veri" (PreparedStatement) sinif degiskeni hic kullanilmamissa burasi calismaz.
                veri.close();   // Sadece "connection.close();" calisacaktir.
            }
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
        }
    }

} // END CLASS
