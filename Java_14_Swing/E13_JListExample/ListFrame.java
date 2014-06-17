package E13_JListExample;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("all")
public class ListFrame extends JFrame {

	private static final long serialVersionUID = 4248521385888188033L;
	private JList colorJList;
	private static final String[] colorNames = { "Siyah", "Blue", "Cygan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" };
	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
			Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };

	// List frame constructor add JScrollPane containing JList to Frame
	public ListFrame() {
		super("List Test");
		setLayout(new FlowLayout());
		// Renk Liste
		colorJList = new JList(colorNames);
		colorJList.setVisibleRowCount(5);
		// do not allow multiple selections
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// add JScrollPane containing JList to Frame
		add(new JScrollPane(colorJList));

		colorJList.addListSelectionListener(new ListOlayIsleyici());
		// call to addListSelectionListener
	}

	public class ListOlayIsleyici implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent e) {
			getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);

		}

	}

	public static void main(String[] args) {
		ListFrame listFrame = new ListFrame();
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(350, 150);
		listFrame.setVisible(true);

	}
}
