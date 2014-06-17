package E02_JFrameSimple;
// 2
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Swing2_BosPencere extends JFrame {

	public Swing2_BosPencere() {
		setSize(300, 200);
		setTitle("Bos Pencere");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // end constructor DEFAULT

	public static void main(String[] args) {
		Swing2_BosPencere pencere = new Swing2_BosPencere();
		pencere.setVisible(true);
	} // end main()

} // end class