import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;

@SuppressWarnings("all")
public class Uygulama extends JFrame {

	private Dosya dosya = new Dosya();
	private JPanel panelLabels = new JPanel(new GridLayout(5, 1));;
	private JPanel panelButtons = new JPanel(new GridLayout(1, 4));;
	private JPanel panelTextFields = new JPanel(new GridLayout(5, 1));;
	private JPanel panelSouth = new JPanel(new BorderLayout());;
	private JPanel panelCheckbox = new JPanel(new GridLayout(1, 5));;
	private JPanel panelSearch = new JPanel(new BorderLayout());;
	private JLabel lblBaslik = new JLabel("PERSONEL LISTESI");
	private JLabel lblTc = new JLabel("Tc Kimlik :");
	private JLabel lblAd = new JLabel("Ad Soyad :");
	private JLabel lblMeslek = new JLabel("Meslek :");
	private JLabel lblTel = new JLabel("Telefon :");
	private JLabel lblSehir = new JLabel("Sehir :");
	private JCheckBox ckbTc = new JCheckBox("TC Kimlik");;
	private JCheckBox ckbAd = new JCheckBox("Ad Soyad");;
	private JCheckBox ckbMeslek = new JCheckBox("Meslek");;
	private JCheckBox ckbTel = new JCheckBox("Telefon");;
	private JCheckBox ckbSehir = new JCheckBox("Sehir");;
	private JTextField txtTc = new JTextField(20);
	private JTextField txtAd = new JTextField(20);
	private JTextField txtMeslek = new JTextField(20);
	private JTextField txtTel = new JTextField(20);
	private JTextField txtSehir = new JTextField(15);
	private JTextField txtBul = new JTextField(30);
	private JButton btnEkle = new JButton("Ekle");
	private JButton btnSil = new JButton("Sil");
	private JButton btnOku = new JButton("Oku");
	private JButton btnYaz = new JButton("Kaydet");
	private JButton btnBul = new JButton("Bul");
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private final String[] sehirler = { "", "Istanbul", "Gaziantep", "Kayseri", "Ankara", "Izmir", "Urfa", "Van", "Antalya" };
	private JComboBox secenekler = new JComboBox(sehirler);

	public Uygulama() {
		super("Border + Grid Layout Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		// TITLE
		lblBaslik.setFont(new Font("Serif", Font.BOLD, 20));
		add(lblBaslik, BorderLayout.NORTH);
		// LABEL
		panelLabels.add(lblTc);
		panelLabels.add(lblAd);
		panelLabels.add(lblMeslek);
		panelLabels.add(lblTel);
		panelLabels.add(lblSehir);
		add(panelLabels, BorderLayout.WEST);
		// COMBO BOX
		secenekler.addActionListener(new SehirSec());
		secenekler.setMaximumRowCount(5);
		// TEXT FIELD
		panelTextFields.add(txtTc);
		panelTextFields.add(txtAd);
		panelTextFields.add(txtMeslek);
		panelTextFields.add(txtTel);
		panelTextFields.add(secenekler); // sehir paneli
		add(panelTextFields, BorderLayout.CENTER);
		// SEARCH
		panelCheckbox.add(ckbTc);
		panelCheckbox.add(ckbAd);
		panelCheckbox.add(ckbMeslek);
		panelCheckbox.add(ckbTel);
		panelCheckbox.add(ckbSehir);
		panelSearch.add(panelCheckbox, "North");
		panelSearch.add(txtBul, "West");
		panelSearch.add(btnBul, "Center");
		panelSouth.add(panelSearch, BorderLayout.NORTH);
		btnBul.addActionListener(new Bul());
		// BUTTON
		btnEkle.addActionListener(new Ekle());
		panelButtons.add(btnEkle);
		btnSil.addActionListener(new Sil());
		panelButtons.add(btnSil);
		btnOku.addActionListener(new Oku());
		panelButtons.add(btnOku);
		btnYaz.addActionListener(new Kaydet());
		panelButtons.add(btnYaz);
		panelSouth.add(panelButtons, BorderLayout.CENTER);
		// JTABLE
		add(panelSouth, BorderLayout.SOUTH);
		model = new DefaultTableModel();
		model.addColumn("TC");
		model.addColumn("Ad Soyad");
		model.addColumn("Meslek");
		model.addColumn("Telefon");
		model.addColumn("Sehir");
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		panelSouth.add(scrollPane, BorderLayout.SOUTH);
		// Pencereyi ekran boyutuna gore yeniden yerlestir
		pack();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation((size.width / 2) - (getWidth() / 2), (size.height / 2) - (getHeight() / 2));
		validate();
		setVisible(true);
	} // end constructor DEFAULT

	public class SehirSec implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent olay) {
			txtSehir.setText((String) secenekler.getSelectedItem());
		}
	} // END INNER CLASS ComboSecim

	public class Ekle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent olay) {
			if (!txtTc.getText().trim().equals("") && !txtAd.getText().trim().equals("")) {
				String[] satir = { txtTc.getText(), txtAd.getText(), txtMeslek.getText(), txtTel.getText(), secenekler.getSelectedItem().toString() };
				model.addRow(satir);
			} else
				JOptionPane.showMessageDialog(null, "En az su bilgiler doldurulmalidir!\nTC Kimlik, Ad Soyad", "Bilgi!", 1);
		}
	} // END INNER CLASS aksiyon

	public class Sil implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int selected = table.getSelectedRow();
			if (selected != -1)
				model.removeRow(selected);
			else
				JOptionPane.showMessageDialog(null, "Listeden bir personel seciniz!", "Uyari!", 0);
		}
	} // END INNER CLASS Sil

	public class Kaydet implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Personel> list = new ArrayList<Personel>();
			int rowcount = model.getRowCount();
			int colcount = model.getColumnCount();
			Personel personel;
			if (rowcount != 0) {
				String[] satirlar = new String[colcount];
				for (int i = 0; i < rowcount; i++) {
					for (int j = 0; j < colcount; j++) {
						satirlar[j] = (String) model.getValueAt(i, j);
					}
					personel = new Personel(satirlar);
					list.add(personel);
				}
				dosya.yaz(list);
			}
		}
	} // END INNER CLASS Kaydet

	public class Oku implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] options = { "Evet", "Hayir" };
			int rowcount = model.getRowCount();
			ArrayList<Personel> list = dosya.oku();
			if (rowcount != list.size() && rowcount != 0) {
				int cevap = JOptionPane.showOptionDialog(null, "Listenizde kaydedilmemis degisikler var!\nDevam edilsinmi?", "metin", -1, 2, null, options, 0);
				switch (cevap) {
					case 0: // evet
						model.setRowCount(0); // jtable'i temizle
						for (Personel p : list)
							model.addRow(p.getAll());
						break;
				}
			} else {
				for (int i = rowcount; i > 0 && rowcount != 0; i--)
					model.removeRow(i - 1);// model'i (jtable) temizle
				for (Personel p : list)
					model.addRow(p.getAll()); // array listteki personel bilgilerini tabloya ekle
			}
		}
	} // END INNER CLASS Oku

	public class Bul implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			model.setRowCount(0);
			ArrayList<Personel> personel = dosya.oku();
			for (Personel p : personel) {
				if (ckbTc.isSelected() && p.getTc().equalsIgnoreCase(txtBul.getText())) {
					model.addRow(p.getAll());
					continue;
				} else if (ckbAd.isSelected() && p.getAdSoyad().equalsIgnoreCase(txtBul.getText())) {
					model.addRow(p.getAll());
					continue;
				} else if (ckbMeslek.isSelected() && p.getMeslek().equalsIgnoreCase(txtBul.getText())) {
					model.addRow(p.getAll());
					continue;
				} else if (ckbTel.isSelected() && p.getTelefon().equalsIgnoreCase(txtBul.getText())) {
					model.addRow(p.getAll());
					continue;
				} else if (ckbSehir.isSelected() && p.getSehir().equalsIgnoreCase(txtBul.getText())) {
					model.addRow(p.getAll());
					continue;
				}
			}
		}
	} // END INNER CLASS Bul

	public static void main(String[] mt) {
		Uygulama u = new Uygulama();
		u.new Oku().actionPerformed(null);
	} // end main()

} // END CLASS