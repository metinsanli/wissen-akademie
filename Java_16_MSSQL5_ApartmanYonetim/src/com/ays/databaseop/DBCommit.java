/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.databaseop;

import com.ays.entity.Kisi;
import com.ays.forms.MainFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**

 @author metin
 */
public class DBCommit {

    private static final String URL = "jdbc:sqlserver://10.0.0.10:1433;databasename=dbApartman";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "D3n3m3123";
    private Connection connection = null;

    public DBCommit () {
        try {

            //STEP 3: Baglantiyi olustur
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //STEP 4: sorgunu executeUpdate() ile beraber hemen calismasina izin vermemesi icin false yapiliyor.
            connection.setAutoCommit(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public int insertKisiDaire (Kisi kisi) {

        int result = 0;
        try {
            // KISI EKLENIYOR
            PreparedStatement insertKisi = connection.prepareStatement("INSERT INTO [tblKisi]"
                    + " ( [TCKimlikNo], [Adi], [Soyadi], [DogumTarihi], [Email] )"
                    + " VALUES ( ?, ?, ?, CONVERT (DATE , ? , 104), ? )");

            insertKisi.setString(1, kisi.getTCKimlik());
            insertKisi.setString(2, kisi.getAd());
            insertKisi.setString(3, kisi.getSoyad());
            insertKisi.setDate(4, kisi.getDogumTarih());
            insertKisi.setString(5, kisi.getEmail());

            // KISIDAIRE EKLENIYOR
            PreparedStatement insertKisiDaire = connection.prepareStatement("INSERT INTO [tblKisiDaire]"
                    + " ( [TCKimlikNo], [DaireNo], [SahiplikDurumu] )"
                    + " VALUES ( ?, ?, ? )");

            insertKisiDaire.setString(1, kisi.getTCKimlik());
            insertKisiDaire.setString(2, kisi.getDaireNo());
            insertKisiDaire.setBoolean(3, kisi.isSahiplik());

            result = insertKisi.executeUpdate();
            result = insertKisiDaire.executeUpdate();

            connection.commit(); // [tblKisi] ve [tblKisiDaire] IKI TABLOYA YAZILIYOR..

            MainFrame.durumMesaji("Kisi bilgileri daire bilgisiyle kaydedildi.");

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) {
                MainFrame.durumMesaji("Eklediginiz kayit zaten var!");
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "\nHata Kodu : " + ex.getErrorCode());
            }

            try {
                connection.rollback();// YAZMADA HATA OLURSA YAZILAN VERI GERI ALINACAK
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, ex1.getMessage() + "\nHata Kodu : " + ex1.getErrorCode());
            }
        } finally {
            close();
        }
        return result;
    }

    public void close () {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
