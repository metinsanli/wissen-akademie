package P04.LabelveIconEkleme;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

// 4
@SuppressWarnings("all")
public class Swing4_LabelFrame extends JFrame {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	public Swing4_LabelFrame() {
		super("JLabel Test Penceresi");
		setLayout(new FlowLayout());

		// Metin Gosterimi
		label1 = new JLabel("Sadece Metin");
		label1.setToolTipText("Etiket 1");
		add(label1);

		// Icon Gosterimi
		Icon star = new ImageIcon(getClass().getResource("starred.png"));
		label2 = new JLabel("Metin ve Icon Iceren Etiket", star, SwingConstants.LEFT);
		label2.setToolTipText("Etiket 2");
		add(label2);

		// Metin ve Icon Gosterimi
		label3 = new JLabel();
		label3.setText("Metin ve Icon Etiketi - Asagida ve Ortada!");
		label3.setIcon(star);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Etiket 3");
		add(label3);

	} // end constructor DEFAULT

} // end class
