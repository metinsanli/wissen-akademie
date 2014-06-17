package E15_BorderGridLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("all")
public class ComboBoxExample extends JFrame {

	private Dosya dosya = new Dosya();
	private JPanel panelLabels, panelButtons, panelTextFields;
	private JLabel lblBaslik, lblAd, lblMeslek, lblTel, lblSehir, lblDurum;
	private JTextField txtAd, txtMeslek, txtTel, txtSehir;
	private JButton btnBul = new JButton("Bul");
	private JButton btnYeniKayit = new JButton("Yeni Kayit");
	private JButton btnDegistir = new JButton("Degistir");
	private JComboBox secenekler;
	private final String[] sehirler = { "Istanbul", "Gaziantep", "Kayseri", "Ankra", "Izmir", "Urfa", "Van", "Antalya" };
	private JPanel panelCombos;

	public ComboBoxExample() {
		super("Border + Grid Layout Demo");
		this.setSize(350, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		// Pencereyi ekran boyutuna gore yeniden yerlestir
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		this.setLocation((size.width / 2) - (getWidth() / 2), (size.height / 2) - (getHeight() / 2));
		// baslik
		lblBaslik = new JLabel("PERSONEL LISTESI");
		lblBaslik.setFont(new Font("Serif", Font.BOLD, 20));
		// baslik yerlestir
		add(lblBaslik, BorderLayout.NORTH);
		// ad
		lblAd = new JLabel("Ad Soyad:");
		txtAd = new JTextField(20);
		// meslek
		lblMeslek = new JLabel("Meslek:");
		txtMeslek = new JTextField(20);
		// telefon
		lblTel = new JLabel("Telefon:");
		txtTel = new JTextField(20);
		// sehir
		lblSehir = new JLabel("Sehir");
		txtSehir = new JTextField(15);
		// durum
		lblDurum = new JLabel("Program baslatildi.");
		//add(lblDurum, BorderLayout.NORTH);
		// combo box
		secenekler = new JComboBox(sehirler);
		secenekler.addActionListener(new ComboSecim());
		secenekler.setMaximumRowCount(5);
		// etiket paneli
		panelLabels = new JPanel();
		panelLabels.setLayout(new GridLayout(4, 1));
		panelLabels.add(lblAd);
		panelLabels.add(lblMeslek);
		panelLabels.add(lblTel);
		panelLabels.add(lblSehir);
		panelLabels.setVisible(true);
		add(panelLabels, BorderLayout.WEST);
		// metin kutusu
		panelTextFields = new JPanel();
		panelTextFields.setLayout(new GridLayout(4, 1));
		panelTextFields.add(txtAd);
		panelTextFields.add(txtMeslek);
		panelTextFields.add(txtTel);
		panelTextFields.add(txtSehir);
		add(panelTextFields, BorderLayout.CENTER);
		// sehir paneli
		panelCombos = new JPanel();
		panelCombos.setLayout(new BorderLayout());
		panelCombos.add(secenekler, BorderLayout.SOUTH);
		add(panelCombos, BorderLayout.EAST);
		// dugme paneli
		panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(1, 3));
		btnBul.addActionListener(new aksiyon());
		panelButtons.add(btnBul);
		btnDegistir.addActionListener(new aksiyon());
		panelButtons.add(btnDegistir);
		btnYeniKayit.addActionListener(new aksiyon());
		panelButtons.add(btnYeniKayit);
		add(panelButtons, BorderLayout.SOUTH);
		// refresh jframe
		this.setVisible(true);
		validate();
	} // end constructor DEFAULT

	public class ComboSecim implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent olay) {
			txtSehir.setText((String) secenekler.getSelectedItem());
		}
	} // END INNER CLASS ComboSecim

	public class aksiyon implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent olay) {
			String secim = olay.getActionCommand();
			try {
				switch (secim) {
					case "Yeni Kayit":
						dosya.ekle(txtAd.getText() + "\t" + txtMeslek.getText() + "\t" + txtTel.getText() + "\t" + txtSehir.getText());
						lblDurum.setText("Yeni kayit olusturuldu.");
						break;
					case "Degistir":
						String getir1[] = dosya.bul(txtAd.getText()).split("\t");
						if (getir1 != null) {
							dosya.guncelle(txtAd.getText(), txtAd.getText() + "\t" + txtMeslek.getText() + "\t" + txtTel.getText() + "\t" + txtSehir.getText());
							lblDurum.setText("Kayit degistirildi.");
						}
						break;
					case "Bul":
						if (!(dosya.bul(txtAd.getText()).equals(null))) {
							String getir2[] = dosya.bul(txtAd.getText()).split("\t");
							txtAd.setText(getir2[0]);
							txtMeslek.setText(getir2[1]);
							txtTel.setText(getir2[2]);
							txtSehir.setText(getir2[3]);
							lblDurum.setText("Kayit bulundu.");
						}
						break;
				}
			} catch (Exception hata) {
				lblDurum.setText(hata.getMessage());
				if (hata instanceof NullPointerException)
					lblDurum.setText("Kayit bulunamadi!");
			}
		} // end abstract method actionPerformed()

	} // END INNER CLASS aksiyon

	public static void main(String[] mt) {
		new ComboBoxExample();
	} // end main()

} // END CLASS