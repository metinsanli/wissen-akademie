package E07_WindowListener1_Simple;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TekMetinKutusu extends StandartPencere {

	private static final long serialVersionUID = 1L;
	private JLabel etiket;
	private JTextField metinKutusu;

	public TekMetinKutusu() {
		super("Tek Metin Kutusu Uygulama");
		// this.addWindowListener(new PencereOlayIsleyici);
		setLayout(new FlowLayout());
		//
		etiket = new JLabel("Birseyler yazip ENTER a basin.");
		etiket.setToolTipText("Cikmak icin \"ÇIK\" yazin.");
		add(etiket);
		//
		metinKutusu = new JTextField(10);
		MetinKutusuOlayIsleyici olayIsleyici = new MetinKutusuOlayIsleyici();
		metinKutusu.addActionListener(olayIsleyici);
		add(metinKutusu);
	}

	public class MetinKutusuOlayIsleyici implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent eylem) {
			String yeniMetin = metinKutusu.getText();
			if (yeniMetin.equalsIgnoreCase("ÇIK"))
				System.exit(0);
			etiket.setText(yeniMetin);
			metinKutusu.setText("");
			JOptionPane.showMessageDialog(null, "Calistimi?");
		}

	}

	public class PencereOlayIsleyici implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			JOptionPane.showMessageDialog(null, "Pencere Acildi!");

		}

		@Override
		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(null, "Kaptiyoruz!");

		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		TekMetinKutusu pencere = new TekMetinKutusu();
		pencere.setVisible(true);
	}
}
