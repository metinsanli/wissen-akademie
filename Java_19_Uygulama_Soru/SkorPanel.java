package com.wissen.soru;

import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("all")
public class SkorPanel extends javax.swing.JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Iterator itr;

	public SkorPanel() {
		initComponents();
	}

	private DefaultTableModel tabloDoldur(List<Skor> l) {
		String[] columnNames = { "ID", "Ad", "Soyad", "Tarih", "PUAN" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		itr = l.iterator();
		for (Skor sk : l) {
			model.addRow(sk.getAllData());
		}
		return model;
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setClosable(true);
		setTitle("Top Scores");
		setPreferredSize(new java.awt.Dimension(440, 185));
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

		jTable1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
		jTable1.setModel(tabloDoldur(new DB().getSkorlar()));
		jTable1.setRowHeight(25);
		jScrollPane1.setViewportView(jTable1);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void formİnternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formİnternalFrameClosed
		MainMain.closeSkor();
	}// GEN-LAST:event_formİnternalFrameClosed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables
}
