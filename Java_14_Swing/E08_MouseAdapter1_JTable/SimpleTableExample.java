package E08_MouseAdapter1_JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("all")
public class SimpleTableExample extends JFrame {

	private JPanel topPanel, leftPanel;
	private JTable table;
	private JScrollPane scrollpane;
	private JTextField txtDeger;
	private JTextField txtSatir;
	private JTextArea tAreaSutun;
	private String[][] urunler;

	public SimpleTableExample() {
		// Set the frame Characteristics
		setTitle("Simple Table Application");
		setSize(600, 200);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		add(topPanel, BorderLayout.CENTER);

		// Create a left panel
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		txtDeger = new JTextField(10);
		txtSatir = new JTextField(20);
		tAreaSutun = new JTextArea(20, 10);
		leftPanel.add(txtDeger, BorderLayout.PAGE_START);
		leftPanel.add(txtSatir, BorderLayout.PAGE_END);
		leftPanel.add(tAreaSutun, BorderLayout.CENTER);
		add(leftPanel, BorderLayout.WEST);

		// Create columns names
		String columnNames[] = { "Urun Barkod", "Urun Adi", "Fiyat", "Adet", "Tutar" };

		// Create some data
		String dataValues[][] = { { "00245", "Domates", "7", "10", "70" }, { "34500", "Patates", "3", "9", "21" } };

		// Create a new table instance
		table = new JTable(dataValues, columnNames);
		table.setEnabled(true);

		// Add the table to a scrolling pane
		scrollpane = new JScrollPane(table);
		topPanel.add(scrollpane, BorderLayout.CENTER);

		// Add table actions
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource(); // down cast
					int satir = target.getSelectedRow();
					int sutun = target.getSelectedColumn();
					txtDeger.setText(String.valueOf(target.getValueAt(satir, sutun)));
				} // end if

				if (e.getClickCount() == 2) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int numOfColumns = target.getColumnCount();
					String record = "";
					for (int i = 0; i < numOfColumns; i++) {
						record += (target.getValueAt(row, i) + " ");
						txtSatir.setText(record);
					} // end for
				} // end if

				if (e.getButton() == MouseEvent.BUTTON3) {
					JTable target = (JTable) e.getSource();
					int column = target.getSelectedColumn();
					int numOfRows = target.getRowCount();
					JOptionPane.showMessageDialog(null, column);
					String record = "";
					for (int i = 0; i < numOfRows; i++) {
						record += (target.getValueAt(i, column) + "\n");
					}
				}
			} // end method mousePressed()
		});

		//
		txtDeger.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setValueAt(txtDeger.getText(), 2, 2);
			}
		});

	} // end constructor DEFAULT

	public static void main(String[] args) {
		SimpleTableExample mainFrame = new SimpleTableExample();
		mainFrame.setVisible(true);
	} // end main()

} // END CLASS