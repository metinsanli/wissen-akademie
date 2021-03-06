/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.forms;

import com.ays.databaseop.DBConn;
import com.ays.entity.Daire;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**

 @author metin
 */
@SuppressWarnings("all")
public class PanelDaire extends javax.swing.JPanel {

    /**
     Creates new form panelDaire
     */
    public PanelDaire () {
        initComponents();
        cmbDaireNo.setModel(comboBoxDoldur()); // COMBOBOX IN ICINI DOLDURUYOR
        cmbDaireNoActionPerformed(null); // pencere acildiginda checkbox a daire numaralarini getir.
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

        lblSec = new javax.swing.JLabel();
        cmbDaireNo = new javax.swing.JComboBox();
        lblDaireNo = new javax.swing.JLabel();
        txtDaireNo = new javax.swing.JTextField();
        lblMetreKare = new javax.swing.JLabel();
        txtMetreKare = new javax.swing.JTextField();
        lblOdaSayisi = new javax.swing.JLabel();
        txtOdaSayisi = new javax.swing.JTextField();
        lblKatNo = new javax.swing.JLabel();
        txtKatNo = new javax.swing.JTextField();
        lblCephe = new javax.swing.JLabel();
        txtCephe = new javax.swing.JTextField();
        lblEbeveynBanyo = new javax.swing.JLabel();
        ckbEbeveynBanyo = new javax.swing.JCheckBox();
        lblBalkonSayisi = new javax.swing.JLabel();
        txtBalkonSayisi = new javax.swing.JTextField();
        lblbDublex = new javax.swing.JLabel();
        ckbDublex = new javax.swing.JCheckBox();
        btnSil = new javax.swing.JButton();
        btnKaydet = new javax.swing.JButton();

        lblSec.setText("Sec");

        cmbDaireNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDaireNoActionPerformed(evt);
            }
        });

        lblDaireNo.setText("Daire No");

        lblMetreKare.setText("Metre Kare");

        lblOdaSayisi.setText("Oda Sayisi");

        lblKatNo.setText("Kat No");

        lblCephe.setText("Cephe");

        lblEbeveynBanyo.setText("Ebeveyn Banyo");

        ckbEbeveynBanyo.setText("= Var/Yok");

        lblBalkonSayisi.setText("Balkon Sayisi");

        lblbDublex.setText("Dublex");

        ckbDublex.setText("= Evet/Hayır");

        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnKaydet.setText("Kaydet");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSec)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMetreKare)
                                .addComponent(lblOdaSayisi)
                                .addComponent(lblKatNo)
                                .addComponent(lblCephe)
                                .addComponent(lblEbeveynBanyo)
                                .addComponent(lblbDublex)
                                .addComponent(lblBalkonSayisi)
                                .addComponent(lblDaireNo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMetreKare, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(txtOdaSayisi, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(txtKatNo, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(txtCephe, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(txtBalkonSayisi, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(ckbDublex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ckbEbeveynBanyo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDaireNo, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(cmbDaireNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSec)
                    .addComponent(cmbDaireNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDaireNo)
                    .addComponent(txtDaireNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetreKare)
                    .addComponent(txtMetreKare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKatNo)
                    .addComponent(txtKatNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCephe)
                    .addComponent(txtCephe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOdaSayisi)
                    .addComponent(txtOdaSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEbeveynBanyo)
                    .addComponent(ckbEbeveynBanyo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalkonSayisi)
                    .addComponent(txtBalkonSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbDublex)
                    .addComponent(ckbDublex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSil)
                    .addComponent(btnKaydet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        // TODO add your handling code here:
        if (!txtDaireNo.getText().equals("")) {
            Daire yeniDaire = new Daire(txtDaireNo.getText(), Integer.parseInt(txtMetreKare.getText()), Integer.parseInt(txtKatNo.getText()), txtCephe.getText(), txtOdaSayisi.getText(), ckbEbeveynBanyo.isSelected(), Integer.parseInt(txtBalkonSayisi.getText()), ckbDublex.isSelected());
            ArrayList<Daire> daireler = new DBConn().getAllDaire();

            boolean yeniEkle = false;

            for (Daire temp : daireler) {
                if (yeniDaire.getDaireNo().equals(temp.getDaireNo())) {
                    new DBConn().updateDaire(yeniDaire);
                    yeniEkle = false;
                    break;
                }
                yeniEkle = true;
            }

            if (yeniEkle) {
                new DBConn().insertDaire(yeniDaire);
            }

            cmbDaireNo.setModel(comboBoxDoldur());

        } else {
            JOptionPane.showMessageDialog(null, "Yeni kayit icin en az \"Daire No\" girilmelidir!");
        } // END IF
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void cmbDaireNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDaireNoActionPerformed
        // TODO add your handling code here:
        /**
         checkbox tan daire no secildiginde alt taraftaki alanlara secilen dairenin
         bilgileri getirilecek
         */
        Daire daire = new DBConn().getDaire(cmbDaireNo.getSelectedItem().toString());
        txtDaireNo.setText(daire.getDaireNo());
        txtMetreKare.setText(String.valueOf(daire.getMetreKare()));
        txtKatNo.setText(String.valueOf(daire.getKatNo()));
        txtCephe.setText(daire.getCephe());
        txtOdaSayisi.setText(daire.getOdaSayisi());
        ckbEbeveynBanyo.setSelected(daire.isEbeveynBanyo());
        txtBalkonSayisi.setText(String.valueOf(daire.getBalkonSayisi()));
        ckbDublex.setSelected(daire.isDublex());
    }//GEN-LAST:event_cmbDaireNoActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        // TODO add your handling code here:

        Daire silinecekDaire = new Daire(txtDaireNo.getText(), Integer.parseInt(txtMetreKare.getText()), Integer.parseInt(txtKatNo.getText()), txtCephe.getText(), txtOdaSayisi.getText(), ckbEbeveynBanyo.isSelected(), Integer.parseInt(txtBalkonSayisi.getText()), ckbDublex.isSelected());

        if (cmbDaireNo.getSelectedIndex() != 0) {

            int onay = JOptionPane.showConfirmDialog(btnSil, "Sectiginiz \"Daire\"ye ait bilgiler silinecektir!\nEminmisiniz ?", "Silme Onayi", 0, 0);

            if (onay == 0) {

                new DBConn().deleteDaire(silinecekDaire);

            }

        } else {

            MainFrame.durumMesaji("Silmek icin bir daire secmelisiniz!");

        }

        cmbDaireNo.setModel(comboBoxDoldur());
    }//GEN-LAST:event_btnSilActionPerformed

    private DefaultComboBoxModel comboBoxDoldur () {
        // Bu metod PanelDaire.java ekranindaki cmbDaireNo'nun icini doldurmak icindir.
        DBConn baglanti = new DBConn();
        DefaultComboBoxModel cmbxModel = new DefaultComboBoxModel();
        ArrayList<Daire> daireler = baglanti.getAllDaire();
        cmbxModel.addElement("< Yeni >");
        for (Daire d : daireler) {
            cmbxModel.addElement(d.getDaireNo());
        }
        return cmbxModel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JButton btnSil;
    private javax.swing.JCheckBox ckbDublex;
    private javax.swing.JCheckBox ckbEbeveynBanyo;
    private javax.swing.JComboBox cmbDaireNo;
    private javax.swing.JLabel lblBalkonSayisi;
    private javax.swing.JLabel lblCephe;
    private javax.swing.JLabel lblDaireNo;
    private javax.swing.JLabel lblEbeveynBanyo;
    private javax.swing.JLabel lblKatNo;
    private javax.swing.JLabel lblMetreKare;
    private javax.swing.JLabel lblOdaSayisi;
    private javax.swing.JLabel lblSec;
    private javax.swing.JLabel lblbDublex;
    private javax.swing.JTextField txtBalkonSayisi;
    private javax.swing.JTextField txtCephe;
    private javax.swing.JTextField txtDaireNo;
    private javax.swing.JTextField txtKatNo;
    private javax.swing.JTextField txtMetreKare;
    private javax.swing.JTextField txtOdaSayisi;
    // End of variables declaration//GEN-END:variables
}
