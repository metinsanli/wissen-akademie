/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.z_unused;

import com.ays.databaseop.DBConn;
import com.ays.entity.Kisi;
import com.ays.forms.MainFrame;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**

 @author metin
 */
public class PanelKisiGuncelle extends javax.swing.JPanel {

    /**
     Creates new form PanelKisi
     */
    public PanelKisiGuncelle () {
        initComponents();
        DBConn baglanti = new DBConn();
        cmbTCKimlik.setModel(comboBoxDoldur(baglanti));
        cmbTCKimlikActionPerformed(null);
    }

    private DefaultComboBoxModel comboBoxDoldur (DBConn baglanti) {
        // Bu metod PanelDaireGuncelle.java ekranindaki cmbDaireNo'nun icini doldurmak icindir.
        DefaultComboBoxModel cmbxModel = new DefaultComboBoxModel();
        ArrayList<Kisi> kisiler = baglanti.getAllKisi();
        for (Kisi d : kisiler) {
            cmbxModel.addElement(d.getTCKimlik());
        }
        return cmbxModel;
    }

    /**
     This method is called from within the constructor to
     initialize the form.
     WARNING: Do NOT modify this code. The content of this method is
     always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbTCKimlik = new javax.swing.JComboBox();
        lblTCKimlik = new javax.swing.JLabel();
        lblAd = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        lblSoyad = new javax.swing.JLabel();
        txtSoyad = new javax.swing.JTextField();
        lblDogumTarih = new javax.swing.JLabel();
        dateDogumTarih = new org.jdesktop.swingx.JXDatePicker();
        btnKaydet = new javax.swing.JButton();
        btnTemizle = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        cmbTCKimlik.setEditable(true);
        cmbTCKimlik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTCKimlikActionPerformed(evt);
            }
        });

        lblTCKimlik.setText("TC Kimlik No");

        lblAd.setText("Adi");

        lblSoyad.setText("Soyadi");

        lblDogumTarih.setText("Dogum Tarihi");

        btnKaydet.setText("Kaydet");
        btnKaydet.setPreferredSize(new java.awt.Dimension(100, 28));
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        btnTemizle.setText("Formu Temizle");

        lblEmail.setText("Eposta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTemizle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTCKimlik)
                            .addComponent(lblAd)
                            .addComponent(lblSoyad))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAd)
                            .addComponent(txtSoyad)
                            .addComponent(cmbTCKimlik, 0, 1, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDogumTarih)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(dateDogumTarih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTCKimlik)
                    .addComponent(cmbTCKimlik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAd)
                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoyad)
                    .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDogumTarih)
                    .addComponent(dateDogumTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTemizle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTCKimlikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTCKimlikActionPerformed
        // TODO add your handling code here:
        Kisi kisi = new DBConn().getKisi((String) cmbTCKimlik.getSelectedItem());
        txtAd.setText(kisi.getAd());
        txtSoyad.setText(kisi.getSoyad());
        dateDogumTarih.setDate(kisi.getDogumTarih());
        txtEmail.setText(kisi.getEmail());
    }//GEN-LAST:event_cmbTCKimlikActionPerformed

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        // TODO add your handling code here:
        java.util.Date utilDate = dateDogumTarih.getDate(); // dateDogumTarih.getDate()'ten java.util.Date alip utilDate yaratiyor.
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // utilDate.getTime() ile java.sql.Date yaratip Kisi'nin constructor'ina veriyor
        Kisi kisi = new Kisi(cmbTCKimlik.getSelectedItem().toString(), txtAd.getText(), txtSoyad.getText(), sqlDate, txtEmail.getText());
        DBConn connection = new DBConn();
        int sonuc = connection.updateKisi(kisi);
        MainFrame.durumMesaji((sonuc == 1 ? "Kisi kayidi guncellendi." : "Kisi kayidi guncelleme basarisiz!"));
    }//GEN-LAST:event_btnKaydetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JButton btnTemizle;
    private javax.swing.JComboBox cmbTCKimlik;
    private org.jdesktop.swingx.JXDatePicker dateDogumTarih;
    private javax.swing.JLabel lblAd;
    private javax.swing.JLabel lblDogumTarih;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblSoyad;
    private javax.swing.JLabel lblTCKimlik;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSoyad;
    // End of variables declaration//GEN-END:variables
}