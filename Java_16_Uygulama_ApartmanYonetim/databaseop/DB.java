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
public class DB {

    private static final String URL = "jdbc:sqlserver://10.0.0.10:1433;databasename=dbApartman";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "D3n3m3123";
    private Connection connection = null;
    private PreparedStatement query1 = null;
    private PreparedStatement query2 = null;
    private PreparedStatement query3 = null;

    public DB () {
        try {
            //STEP 3: Baglantiyi olustur
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //STEP 4: sorgunu executeUpdate() ile beraber hemen calismasina izin vermemesi icin false yapiliyor.
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(1);
        }
    }

    public void setQuerys (String[] querys) throws Exception {
        String output = "";
        if (querys.length > 3) {
            throw new Exception("Sorgu sayisi 3'ten fazla olamaz!");
        }
        for (int i = 0; i < querys.length; i++) {
            switch (querys[i]) {
                case "INSERTKISI":
                    output = "INSERT INTO tblKisi ( TCKimlikNo, Adi, Soyadi, DogumTarihi, Email ) VALUES ( ?, ?, ?, CONVERT (DATE , ? , 104), ? )";
                    break;
                case "UPDATEKISI":
                    output = "UPDATE dbo.tblKisi SET TCKimlikNo = ?, Adi = ?, Soyadi = ?, DogumTarihi = ?, Email = ? WHERE TCKimlikNo = ?";
                    break;
                case "DELETEKISI":
                    output = "DELETE FROM tblKisi WHERE TCKimlikNo = ?";
                    break;
                case "GETALLKISI":
                    output = "SELECT * FROM [tblKisi] ORDER BY [Adi], [Soyadi]";
                    break;
                case "GETKISI":
                    output = "SELECT TCKimlikNo, Adi, Soyadi, DogumTarihi, Email"
                            + " FROM tblKisi WHERE TCKimlikNo LIKE ?";
                    break;
                case "GETKISIDAIRE":
                    output = "SELECT tblKisi.TCKimlikNo, tblKisi.Adi, tblKisi.Soyadi, tblKisi.DogumTarihi, tblKisi.Email, tblKisiDaire.DaireNo, tblKisiDaire.SahiplikDurumu"
                            + " FROM tblKisi LEFT OUTER JOIN tblKisiDaire ON tblKisi.TCKimlikNo = tblKisiDaire.TCKimlikNo"
                            + " WHERE tblKisi.TCKimlikNo LIKE ?";
                    break;
                case "INSERTDAIRE":
                    output = "INSERT INTO tblKisiDaire ( TCKimlikNo, DaireNo, SahiplikDurumu ) VALUES ( ?, ?, ? )";
                    break;
            } // SWITCH
            if (i == 0) {
                query1 = connection.prepareStatement(output);
            } else if (i == 1) {
                query2 = connection.prepareStatement(output);
            } else if (i == 2) {
                query2 = connection.prepareStatement(output);
            } // IF
        } // FOR
    } // METHOD

    public void close () {
        try {
            if (!query1.isClosed()) {
                query1.close();
            }
            if (!query2.isClosed()) {
                query2.close();
            }
            if (!query3.isClosed()) {
                query3.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public int insertKisiDaire (Kisi kisi) throws Exception {
        int result = 0;
        try {
            String[] querys = {"INSERTKISI", "INSERTKISIDAIRE"};
            setQuerys(querys); // SORGULAR SECILDI.
            // KISI EKLENIYOR
            query1.setString(1, kisi.getTCKimlik());
            query1.setString(2, kisi.getAd());
            query1.setString(3, kisi.getSoyad());
            query1.setDate(4, kisi.getDogumTarih());
            query1.setString(5, kisi.getEmail());

            // KISIDAIRE EKLENIYOR
            query2.setString(1, kisi.getTCKimlik());
            query2.setString(2, kisi.getDaireNo());
            query2.setBoolean(3, kisi.isSahiplik());

            result = query1.executeUpdate();
            result = query2.executeUpdate();

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
            close(); // ACIK OLAN BAGLANTILARI KAPAT!
        }
        return result;
    }

}
