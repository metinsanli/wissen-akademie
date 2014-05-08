

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("all")
public class MultipleSelectionFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JList colorJList; // renkler listesi
	private JList copyJList; // icine kopyalanacak liste
	private JButton copyJButton; // button
	private static final String[] colorNames = { "Black", "Blue", "Cygan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" };

	public MultipleSelectionFrame() {
		super("Multiple Selection List");
		setLayout(new FlowLayout());
		colorJList = new JList(colorNames); // hold names of all colors
		colorJList.setVisibleRowCount(5); // show five rows
		colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(colorJList)); // add list with scrollpane
		copyJButton = new JButton("Copy >>>");
		copyJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyJList.setListData(colorJList.getSelectedValues());
			}
		});
		add(copyJButton);
		copyJList = new JList();
		copyJList.setVisibleRowCount(5);
		copyJList.setFixedCellWidth(100);
		copyJList.setFixedCellHeight(15);
		copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(copyJList));

	} // end constructor DEFAULT

	public static void main(String[] args) {
		MultipleSelectionFrame multipleSelectionFrame = new MultipleSelectionFrame();
		multipleSelectionFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		multipleSelectionFrame.setSize(350, 150);
		multipleSelectionFrame.setVisible(true);
	} // end main()

} // END CLASS MultipleSelectionFrame