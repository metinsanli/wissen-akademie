package E01_SimpleGui;
// 1
import javax.swing.JOptionPane;

public class Swing1_SimpleGui1 {

	public static void main(String[] args) {

		String sayi1 = JOptionPane.showInputDialog("Birinci sayiyi girin :");
		String sayi2 = JOptionPane.showInputDialog("Ikinci sayiyi girin :");

		int s1 = Integer.parseInt(sayi1);
		int s2 = Integer.parseInt(sayi2);

		int toplam = s1 + s2;

		//
		JOptionPane.showMessageDialog(null, "Toplam :" + toplam, "Girilen sayilarin toplami", JOptionPane.PLAIN_MESSAGE);

	}

}
