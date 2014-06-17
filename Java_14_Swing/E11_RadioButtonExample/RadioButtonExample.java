package E11_RadioButtonExample;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RadioButtonExample extends JFrame {

	private JTextField textField;
	private Font boldFont;
	private Font plainFont;
	private Font italicFont;
	private Font boldItalicFont;
	private ButtonGroup radioGroup;
	private JRadioButton plainJRadioButton;
	private JRadioButton boldJRadioButton;
	private JRadioButton italicJRadioButton;
	private JRadioButton boldItalicJRadioButton;

	public RadioButtonExample() {
		//
		super("radio button");
		setLayout(new FlowLayout());
		setLocation(500, 300);
		//
		textField = new JTextField("watch the font style change", 25);
		add(textField);
		//
		plainJRadioButton = new JRadioButton("plain", false);
		boldJRadioButton = new JRadioButton("bold", true);
		italicJRadioButton = new JRadioButton("italic", false);
		boldItalicJRadioButton = new JRadioButton("bold/italic", false);
		//
		add(plainJRadioButton);
		add(boldJRadioButton);
		add(italicJRadioButton);
		add(boldItalicJRadioButton);
		//
		radioGroup = new ButtonGroup();
		radioGroup.add(plainJRadioButton);
		radioGroup.add(boldItalicJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldItalicJRadioButton);
		//
		plainFont = new Font("serif", Font.PLAIN, 14);
		boldFont = new Font("serif", Font.BOLD, 14);
		italicFont = new Font("serif", Font.ITALIC, 14);
		boldItalicFont = new Font("serif", Font.BOLD + Font.ITALIC, 14);
		//
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
	} // end constructor DEFAULT

	public class RadioButtonHandler implements ItemListener {

		private Font font;

		public RadioButtonHandler(Font f) {
			font = f;
		} // end constructor

		@Override
		public void itemStateChanged(ItemEvent e) {
			textField.setFont(font);
		}

	}

	public static void main(String[] args) {
		RadioButtonExample radiobuttonframe = new RadioButtonExample();
		radiobuttonframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		radiobuttonframe.setSize(300, 100);
		radiobuttonframe.setVisible(true);
	}
}
