package E09_ComboBox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ComboBoxExample extends JFrame {

	@SuppressWarnings("rawtypes")
	private JComboBox secenekler;
	private JTextField txtSehir;
	private final String[] sehirler = { "istanbul", "gaziantep", "kayseri", "ankara", "izmir", "sinop" };

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ComboBoxExample() {
		super("Combo Box Uygulamasi");
		this.setLayout(new FlowLayout());
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//
		secenekler = new JComboBox(sehirler);
		secenekler.addActionListener(new ComboSecim());
		txtSehir = new JTextField(10);
		add(secenekler);
		add(txtSehir);
		validate(); // refresh etkisi gosterir
	} // end constructor DEFAULT

	public class ComboSecim implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent olay) {
			txtSehir.setText((String) secenekler.getSelectedItem());
		} // end abstract method actionPerformed()

	} // END INNER CLASS ComboSecim

	public static void main(String[] args) {
		new ComboBoxExample();
	} // end main()

} // END CLASS
