package java09_GoogleDrive_Upload;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("all")
public class MainWindow extends JFrame implements ActionListener {

	private Date date = new Date();
	private JPanel panelUst;
	private JButton btnDosyaSec;
	private JButton btnGonder;
	private JLabel lblBaslik;
	private JFileChooser jfc;
	private File file;
	private JTextArea txaBilgiEkrani;

	public static void main(String[] args) {
		new MainWindow();
	} // end method main()

	public MainWindow() {
		super("Google Drive Uploader");
		initWindow();
		addComponents();
		this.validate();
	} // end constructor

	public void initWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		// Pencereyi ekran boyutuna gore yeniden yerlestir
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		this.setLocation((size.width / 2) - (getWidth() / 2), (size.height / 2) - (getHeight() / 2));
		// pencereyi ortaya cikar
		this.setVisible(true);
	} // end method initWindow()

	public void addComponents() {
		panelUst = new JPanel(new GridLayout(1, 2));
		lblBaslik = new JLabel("Baslik :");
		panelUst.add(lblBaslik);
		btnDosyaSec = new JButton("Dosya Sec");
		btnDosyaSec.addActionListener(this); // dosya sec butonuna aksiyon tanimlabdi.
		panelUst.add(btnDosyaSec); // Ana panele eklenecek bilesenler (nihai)
		txaBilgiEkrani = new JTextArea(date.getTime() + " Program calistirildi.\n");
		txaBilgiEkrani.setRows(5);
		this.add(txaBilgiEkrani, "Center");
		this.add(panelUst, "North");
	} // end method addComponents()

	@Override
	public void actionPerformed(ActionEvent e){
		// System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
			case "Dosya Sec":
				if (jfc == null) {
					txaBilgiEkrani.setText(txaBilgiEkrani.getText() + "\n" + date.getTime() + " Dosya sec secildi.\n");
					this.remove(txaBilgiEkrani);
					jfc = new JFileChooser("$HOME");
					this.add(jfc, "Center");
					jfc.addActionListener(this);
					this.validate();
				} else {
					txaBilgiEkrani.setText(txaBilgiEkrani.getText() + "\n" + date.getTime() + " " + file.getPath() + " Dosya sec secildi.\n");
				}
				break;
			case "ApproveSelection":
				file = jfc.getSelectedFile();
				jfc.setVisible(false);
				// System.out.println(file.getName());
				this.remove(jfc);
				this.add(txaBilgiEkrani);
				btnGonder = new JButton("Gonder");
				btnGonder.addActionListener(this);
				this.add(btnGonder, "South");
				this.validate();
				break;
			case "CancelSelection":
				jfc.setVisible(false);
				jfc = null;
				this.validate();
				break;
			case "Gonder":
				try {
					new GD(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			default:
				break;
		}

	} // end abstract method actionPerformed()
	
} // END CLASS
