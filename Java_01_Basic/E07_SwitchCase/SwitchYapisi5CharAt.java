package E07_SwitchCase;
import java.util.Scanner;

public class SwitchYapisi5CharAt {

	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		System.out.print("Paket kodunu girin >");

		String cevap = veri.next();
		char c = cevap.charAt(0);
		String sonuc = "";

		switch (c) {
		case 'E':
		case 'e':
			sonuc = sonuc + "\tE...\n";
			break;
		case 'D':
		case 'd':
			sonuc = sonuc + "\tD...\n";
			break;
		case 'C':
		case 'c':
			sonuc = sonuc + "\tC...\n";
			break;
		case 'B':
		case 'b':
			sonuc = sonuc + "\tB...\n";
			break;
		case 'A':
		case 'a':
			sonuc = sonuc + "\tA...\n";
			break;
		default:
			sonuc = "Diger bir harf.";
		}

		System.out.println(sonuc);
		veri.close();

	} // end main
} // end class