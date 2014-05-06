package P03.EkranOrtalama;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("all")
public class Swing3_EkranOrtala extends JFrame {

	public Swing3_EkranOrtala() {
		setSize(300, 200);
		setTitle("Ekran Ortala");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// Pencereyi ekran boyutuna gore yeniden yerlestir
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		this.setLocation((size.width / 2) - (getWidth() / 2), (size.height / 2) - (getHeight() / 2));

		// Etiket yaz
		JLabel label = new JLabel();
		label.setText("Ekran cozunurlugu : " + size.width + " X " + size.height);
		add(label);
	} // end constructor DEFAULT

	public static void main(String[] args) {
		Swing3_EkranOrtala pencere = new Swing3_EkranOrtala();
		pencere.setVisible(true);
	} // end method main()

} // END CLASS
