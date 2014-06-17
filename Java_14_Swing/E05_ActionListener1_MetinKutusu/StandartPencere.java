package E05_ActionListener1_MetinKutusu;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class StandartPencere extends JFrame {

	public StandartPencere(String pencereBasligi) {
		super(pencereBasligi);
		setLayout(new FlowLayout());
		this.setSize(550, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		this.setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
	} // end constructor

} // end class
