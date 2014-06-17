package E16_BorderLayout;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("all")
public class BL extends JFrame {

	private Container c = getContentPane();

	public BL() {
		super("hey");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		// Pencereyi ekran boyutuna gore yeniden yerlestir
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation((size.width / 2) - (getWidth() / 2), (size.height / 2) - (getHeight() / 2));

		add(new JButton("East"), BorderLayout.EAST);
		add(new JButton("West"), BorderLayout.WEST);
		add(new JButton("North"), BorderLayout.NORTH);
		add(new JButton("South"), BorderLayout.SOUTH);

		setVisible(true);

	}

	public static void main(String[] args) {
		new BL();
	}
}
