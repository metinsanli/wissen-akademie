package P01_ActionListener1_MetinKutusu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TekMetinKutusu extends StandartPencere {

	private JLabel etiket;
	private JTextField metinKutusu;

	public TekMetinKutusu(String pencereBasligi) {
		super("Tek Metin Kutusu Uygulama");

		// Metin Kutusu > Etiket
		etiket = new JLabel("Bu yaziyi degistirmek icin, Metin Kutusuna birsey yazip\"ENTER\"a basin.");
		etiket.setToolTipText("Cikmak icin metin kutusuna \" ÇIK \" yazin.");
		add(etiket);

		// Metin Kutusu
		metinKutusu = new JTextField(10);
		// metinKutusu yaratma islemi ActionListener sinifi oncesinde
		// tanimlanmis olmali!
		MetinKutusuOlayIsleyici olayIsleyici = new MetinKutusuOlayIsleyici();
		metinKutusu.addActionListener(olayIsleyici);
		add(metinKutusu);
	} // end constructor

	public class MetinKutusuOlayIsleyici implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent eylem) {
			String yeniMetin = metinKutusu.getText();
			if (yeniMetin.equalsIgnoreCase("ÇIK"))
				System.exit(0);
			etiket.setText(yeniMetin);
			metinKutusu.setText("");
			JOptionPane.showMessageDialog(null, "Calistimi?");
		} // end abstract method actionPerformed()
	} // end class MetinKutusuOlayIsleyici

	public static void main(String[] args) {
		TekMetinKutusu pencere = new TekMetinKutusu("Merhaba");
		pencere.setVisible(true);
	} // end main()

} // en class TekMetinKutusu