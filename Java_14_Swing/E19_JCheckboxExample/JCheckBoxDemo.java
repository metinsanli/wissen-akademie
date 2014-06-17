package E19_JCheckboxExample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("all")
public class JCheckBoxDemo extends JPanel {

	JCheckBox jcbChin, jcbGlasses, jcbHair, jcbTeeth;

	StringBuffer choices;
	JLabel jlbPicture;
	JCheckBoxListener myListener = null;

	public JCheckBoxDemo() {
		myListener = new JCheckBoxListener();
		//
		jcbChin = new JCheckBox("Chin");
		jcbChin.setMnemonic(KeyEvent.VK_C); // ALT+C Checks/Unchecks thecheckbox
		jcbChin.setSelected(true);
		jcbChin.addItemListener(myListener);
		//
		jcbGlasses = new JCheckBox("Glasses");
		jcbGlasses.setMnemonic(KeyEvent.VK_G); // Alt+G
		jcbGlasses.setSelected(true);
		jcbGlasses.addItemListener(myListener);
		//
		jcbHair = new JCheckBox("Hair");
		jcbHair.setMnemonic(KeyEvent.VK_H); // Alt+H
		jcbHair.setSelected(true);
		jcbHair.addItemListener(myListener);
		//
		jcbTeeth = new JCheckBox("Teeth");
		jcbTeeth.setMnemonic(KeyEvent.VK_T); // Alt+T
		jcbTeeth.setSelected(true);
		jcbTeeth.addItemListener(myListener);
		//
		choices = new StringBuffer("cght");
		//
		jlbPicture = new JLabel(new ImageIcon("./src/E19_JCheckboxExample/geek-" + choices.toString().trim() + ".gif"));
		jlbPicture.setToolTipText(choices.toString().trim());
		//
		JPanel jplCheckBox = new JPanel();
		jplCheckBox.setLayout(new GridLayout(0, 1));
		jplCheckBox.add(jcbChin);
		jplCheckBox.add(jcbGlasses);
		jplCheckBox.add(jcbHair);
		jplCheckBox.add(jcbTeeth);
		//
		setLayout(new BorderLayout());
		add(jplCheckBox, BorderLayout.WEST);
		add(jlbPicture, BorderLayout.CENTER);
	} // end constructor DEFAULT

	public class JCheckBoxListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			int index = 0;
			char c = '-';
			Object source = e.getSource();
			if (source == jcbChin) {
				index = 0;
				c = 'c';
			} else if (source == jcbGlasses) {
				index = 1;
				c = 'g';
			} else if (source == jcbHair) {
				index = 2;
				c = 'h';
			} else if (source == jcbTeeth) {
				index = 3;
				c = 't';
			}
			if (e.getStateChange() == ItemEvent.DESELECTED)
				c = '-';
			choices.setCharAt(index, c);
			jlbPicture.setIcon(new ImageIcon("./src/E19_JCheckboxExample/geek-" + choices.toString().trim() + ".gif"));
			jlbPicture.setToolTipText(choices.toString());
		} // end abstract method

	} // END CLASS JCheckBoxListener

	public static void main(String[] args) {
		JFrame frame = new JFrame("JChecjBox Usage Demo");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setContentPane(new JCheckBoxDemo());
		frame.pack(); // setSize ile ayni
		frame.setVisible(true);
	} // end main()

} // END CLASS JCheckBoxDemo