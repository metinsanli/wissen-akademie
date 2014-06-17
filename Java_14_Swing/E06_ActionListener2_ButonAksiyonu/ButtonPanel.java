package E06_ActionListener2_ButonAksiyonu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.glass.events.WindowEvent;

@SuppressWarnings("all")
public class ButtonPanel extends JFrame implements ActionListener {

	private JButton yellowButton;
	private JButton blueButton;
	private JButton redButton;

	public ButtonPanel() {
		super("Deneme");
		setTitle("Buton Test");
		setSize(300, 400);
		setLayout(new FlowLayout());
		setVisible(true);
		//
		yellowButton = new JButton("Sari");
		blueButton = new JButton("Mavi");
		redButton = new JButton("Kirmizi");
		add(yellowButton);
		add(blueButton);
		add(redButton);
		yellowButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
	} // end constructor DEFAULT

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Color color = getBackground();
		if (source == yellowButton)
			color = Color.yellow;
		else if (source == blueButton)
			color = Color.blue;
		else if (source == redButton)
			color = Color.red;
		setBackground(color);
		repaint();
	} // end abstract method actionPerformed()

	public static void main(String[] args) {
		ButtonPanel frame = new ButtonPanel();
	} // end method main()

} // end class ButtonPanel 