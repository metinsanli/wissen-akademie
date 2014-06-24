package com.wissen.soru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

@SuppressWarnings("all")
public class DB {

    private Connection connection;
    private PreparedStatement sorgu;
    private ResultSet veri;

    public DB () {
        try {

            connection = DriverManager.getConnection("jdbc:sqlserver://10.0.0.10:1433;databasename=dbSoru", "test", "D3n3m3123");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DB.CONSTRUCTOR\n" + ex.getMessage());
        }
    }

    public boolean testConnection () {

        boolean r = false;

        try {

            r = !connection.isClosed();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DB.testConnection()\n" + ex.getMessage());
        } finally {
            close();
        }

        return r;
    }

    public List<Soru> getSorular () {

        List<Soru> sorular = new ArrayList<>();

        try {

            sorgu = connection.prepareStatement("SELECT * FROM [dbSoru].[dbo].[tblSoru]");
            veri = sorgu.executeQuery();

            while (veri.next()) {
                sorular.add(new Soru(veri.getInt("SoruNo"), veri.getString("A"), veri.getString("B"), veri.getString("C"), veri.getString("D"), veri.getString("E"), veri.getString("TRUE")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DB.getSorular()\n" + ex.getMessage());
        } finally {
            close();
        }

        return sorular;
    }

    public List<Skor> getSkorlar () {

        List<Skor> skorlar = new ArrayList<>();

        try {

            sorgu = connection.prepareStatement("SELECT TOP 5 * FROM [dbSoru].[dbo].[tblSkor] ORDER BY Puan DESC");
            veri = sorgu.executeQuery();

            while (veri.next()) {
                skorlar.add(new Skor(veri.getInt("ID"), veri.getString("Ad"), veri.getString("Soyad"), veri.getInt("PUAN"), veri.getDate("Tarih")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DB.getSkorlar()\n" + ex.getMessage());
        } finally {
            close();
        }

        return skorlar;
    }

    public void close () {
        try {

            if (!veri.isClosed()) {
                veri.close();
            }

            if (!sorgu.isClosed()) {
                sorgu.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "DB.close()\n" + ex.getMessage());
        } finally {
            try {

                if (!connection.isClosed()) {
                    connection.close();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "DB.close()\n" + ex.getMessage());
            }
        }
    }
}
