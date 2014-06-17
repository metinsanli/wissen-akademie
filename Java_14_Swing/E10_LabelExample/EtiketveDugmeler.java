package E10_LabelExample;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class EtiketveDugmeler extends JFrame {

	private JLabel etiket;
	private JButton dugmeMetinDegis;

	JLabel[] etiketler = new JLabel[4];

	public EtiketveDugmeler() {
		super("Etiket ve Dugmeler Uygulamasi");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 300);
		// etiket
		etiket = new JLabel("Yazimi degistirmek icin Dugmeye bas!");
		add(etiket);
		// Dugme
		dugmeMetinDegis = new JButton("Degistir");
		dugmeMetinDegis.addActionListener(new DugmeTiklamasi());
		add(dugmeMetinDegis);
	} // end constructor default

	public class DugmeTiklamasi implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String yeniMetin = JOptionPane.showInputDialog("Yeni Metin Girisi");
			etiket.setText(yeniMetin);
		}

	} // END INNER CLASS

	public static void main(String[] args) {
		new EtiketveDugmeler().setVisible(true);
	}

}
