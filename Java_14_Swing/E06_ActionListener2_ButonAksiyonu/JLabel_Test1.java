package E06_ActionListener2_ButonAksiyonu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("all")
public class JLabel_Test1 {

	public class Pencere extends JFrame {

		public Pencere(String baslik) {
			JFrame pencere = new JFrame(baslik);
			pencere.setLayout(new FlowLayout());
			pencere.setSize(500, 250);
			pencere.setDefaultCloseOperation(EXIT_ON_CLOSE);
			pencere.setLocation(500, 300);
		} // end constructor

	} // END CLASS Pencere

	public class Bilesenler extends Pencere {

		private JLabel etiket;

		public Bilesenler(String baslik) {
			super(baslik);
			Olay olay = new Olay();

			etiket = new JLabel("Heyo");
			add(etiket);
		} // end constructor

	} // END CLASS Bilesenler

	public class Olay implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		} // end abstract method actionPerformed()

	} // END CLASS olay

	public void main(String[] args) {
		Bilesenler program = new Bilesenler("Metin Sanli");
		program.setVisible(true);
	} // end main()

} // END CLASS JLabel_Test1