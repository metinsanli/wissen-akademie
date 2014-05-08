import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("all")
public class textareaframe extends JFrame {

	private JTextArea textarea1;
	private JTextArea textarea2;
	private JButton copyjbutton;

	public textareaframe() {
		super("Tex Area Demo");
		Box box = Box.createHorizontalBox();
		String demo = "Bu gürültücü çocuğun böyle sessiz\n" + "duruşuna Mümtaz hiç tahammül\nedemiyordu.\n" + "Vakıa, Ahmet de sakindi. Fakat yaratılıştan öyle idi.\n"
				+ " O, kendisini kabahatli bulan adamdı.";
		textarea1 = new JTextArea(demo, 10, 15);
		box.add(textarea1);
		copyjbutton = new JButton("Kopyala >>>");
		box.add(copyjbutton);
		copyjbutton.addActionListener(new metinkopyala());
		textarea2 = new JTextArea(10, 15);
		textarea2.setEditable(false);
		box.add(textarea2);
		add(box);
	} // end constructor DEFAULT

	public class metinkopyala implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textarea2.setText(textarea1.getSelectedText());
		} // end abstract methods actionPerformed

	} // END CLASS metinkopyala

	public static void main(String[] mt) {
		textareaframe taf = new textareaframe();
		taf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		taf.setSize(625, 200);
		taf.setVisible(true);
	}// end method main()

} // END CLASS