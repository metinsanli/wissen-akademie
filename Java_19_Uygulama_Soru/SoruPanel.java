package com.wissen.soru;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class SoruPanel extends javax.swing.JInternalFrame {

    private Iterator itr;

    public SoruPanel(List<Soru> ss) {
        initComponents();
        Collections.shuffle(ss); // Sorular karistiriliyor
        itr = ss.iterator(); // Iteratore aktariliyor
        nextQuest();
    }

    private void nextQuest() {
        //
        if (itr.hasNext()) {
            Soru soru = (Soru) itr.next();
            rbA.setText(soru.getA());
            rbB.setText(soru.getB());
            rbC.setText(soru.getC());
            rbD.setText(soru.getD());
            rbE.setText(soru.getE());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblSoru = new javax.swing.JLabel();
        rbA = new javax.swing.JRadioButton();
        rbB = new javax.swing.JRadioButton();
        rbC = new javax.swing.JRadioButton();
        rbD = new javax.swing.JRadioButton();
        rbE = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();

        setClosable(true);
        setTitle("New Quiz");
        setLayer(1);
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(100, 90));
        setNormalBounds(new java.awt.Rectangle(0, 0, 10, 0));
        setPreferredSize(new java.awt.Dimension(340, 250));
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formİnternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lblSoru.setText("?");

        buttonGroup1.add(rbA);
        rbA.setText("?");

        buttonGroup1.add(rbB);
        rbB.setText("?");

        buttonGroup1.add(rbC);
        rbC.setText("?");

        buttonGroup1.add(rbD);
        rbD.setText("?");

        buttonGroup1.add(rbE);
        rbE.setText("?");

        btnNext.setText("Sonraki");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSoru))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(rbA))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(rbB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(rbC))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(rbD))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(rbE)))
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        nextQuest();
    }//GEN-LAST:event_btnNextActionPerformed

    private void formİnternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formİnternalFrameClosed
        // TODO add your handling code here:
        MainMain.closeNew();
    }//GEN-LAST:event_formİnternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblSoru;
    private javax.swing.JRadioButton rbA;
    private javax.swing.JRadioButton rbB;
    private javax.swing.JRadioButton rbC;
    private javax.swing.JRadioButton rbD;
    private javax.swing.JRadioButton rbE;
    // End of variables declaration//GEN-END:variables
}
