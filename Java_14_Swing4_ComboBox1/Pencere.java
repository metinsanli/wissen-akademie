package DosyaOkuma;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("all")
public class Pencere extends JFrame {

	private static final long serialVersionUID = 1L;
	//
	private JButton butonArtir;
	private JButton butonAzalt;
	private JButton butonListele;
	private JLabel labelSayac;
	private JLabel labelGosterge;
	private JComboBox comBoxListe;
	private int sayac = 0;

	public Pencere() {
		// PENCERE
		setSize(500, 400);
		setTitle("Deneme Uygulamasi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		// BUTONLAR
		butonArtir = new JButton("Artir +");
		butonArtir.addActionListener(new ArtirButonOlay());
		butonAzalt = new JButton("Azalt -");
		butonAzalt.addActionListener(new AzaltButonOlay());
		butonListele = new JButton("Listele");
		butonListele.addActionListener(new ComBoxListele());
		// LABEL
		labelSayac = new JLabel(String.valueOf(sayac));
		labelGosterge = new JLabel("");
		// COMBOBOX
		comBoxListe = new JComboBox();
		comBoxListe.addActionListener(new ComBoxListele());
		comBoxListe.addActionListener(new ComBoxSec());
		// CONTAINER
		add(butonArtir);
		add(labelSayac);
		add(butonAzalt);
		add(butonListele);
		add(comBoxListe);
		add(labelGosterge);
		validate();
	} // end constructor DEFAULT

	public class ArtirButonOlay implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sayac = Integer.parseInt(labelSayac.getText()) + 1;
			labelSayac.setText(String.valueOf(sayac));
		}

	} // END INNER CLASS ArtirButonOlay

	public class AzaltButonOlay implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sayac = Integer.parseInt(labelSayac.getText()) - 1;
			labelSayac.setText(String.valueOf(sayac));
		}

	} // END INNER CLASS AzaltButonOlay

	public class ComBoxListele implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String satir = "";
			ArrayList<String> liste = new ArrayList<String>();
			try {
				BufferedReader bufDosya = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./src/DosyaOkuma/isimler.txt")), "Cp1254"));
				while ((satir = bufDosya.readLine()) != null) {
					liste.add(satir);
				}
				@SuppressWarnings("all")
				DefaultComboBoxModel model = new DefaultComboBoxModel(liste.toArray());
				comBoxListe.setModel(model);
				bufDosya.close();
			} catch (Exception e1) {
			}
		}
	} // END INNER CLASS ComBoxListele

	public class ComBoxSec implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent olay) {
			labelGosterge.setText((String) comBoxListe.getSelectedItem());
		} // end abstract method actionPerformed()

	} // END INNER CLASS ComboBoxSec

	public static void main(String[] args) throws Exception {
		new Pencere();
	} // end main()

} // END CLASS