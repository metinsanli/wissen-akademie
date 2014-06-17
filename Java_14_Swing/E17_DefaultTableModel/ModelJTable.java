package E17_DefaultTableModel;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("all")
public class ModelJTable extends JFrame {

	private DefaultTableModel model;
	private JTable table;

	public ModelJTable() {
		super("Model JTable");
		model = new DefaultTableModel();
		model.addColumn("Ad");
		model.addColumn("Soyad");
		model.addColumn("Dogum Tarihi");

		table = new JTable(model);
		JButton addButton = new JButton("Vatandas ekle");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int satirSayisi = 1 + model.getRowCount();
				String[] vatandas = { satirSayisi + ". Yeni Kayit", "Yeni Kayit Soyadi", String.valueOf(1999 + satirSayisi) };
				model.addRow(vatandas);
			}
		});

		JButton removeButton = new JButton("Secili olani sil");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.removeRow(table.getSelectedRow());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Silinecek bir satir seciniz!");
				}
			}
		});

		JPanel inputPanel = new JPanel();
		inputPanel.add(addButton);
		inputPanel.add(removeButton);

		Container container = getContentPane();
		container.add(new JScrollPane(table), BorderLayout.CENTER);
		container.add(inputPanel, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		ModelJTable mj = new ModelJTable();
		mj.setSize(400, 400);
		mj.setVisible(true);

	} // end main()

} // end class