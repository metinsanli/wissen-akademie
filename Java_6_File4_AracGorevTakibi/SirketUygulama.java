import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class SirketUygulama {
	static File dosyatest = new File("./src/Metin.txt");

	public static void main(String[] args) throws Exception {

		// anaMenu();
		Arac.durumDegistir("34 MTN 23", "BOSTA", "GOREVDE");

	} // end main()

	public static void anaMenu() throws Exception {
		while (true) {
			int secim = -1;
			System.out.printf("\n\n#### ARAC GOREV TAKIP UYGULAMASI ####\n");
			System.out.printf("\n[1] - Bilgi Tanimla");
			System.out.printf("\n[2] - Yeni Gorev Olustur");
			System.out.printf("\n[3] - Gorev Bitir");
			System.out.printf("\n\n[0] - Cikis\n");
			while (secim < 0 || secim > 3) {
				System.out.printf("\nLutfen seciminizi yapin > ");
				secim = Integer.parseInt(klavye());
			} // end while
			switch (secim) {
			case 0:
				System.out.printf("\nProgram kapatildi!");
				System.exit(0);
				break;
			case 1:
				bilgiTanimla();
				break;
			case 2:
				Gorev.olustur();
				break;
			case 3:
				Gorev.bitir();
				break;
			}
		}
	} // end method anaMenu()

	public static void bilgiTanimla() throws Exception {
		int secim = -1;
		System.out.printf("\n##### BILGI TANIMLAMA MENU ####\n");
		System.out.printf("\n[1] - Personel");
		System.out.printf("\n[2] - Arac");
		System.out.printf("\n\n[0] - Geri\n");
		while (secim < 0 || secim > 2) {
			System.out.printf("\nLutfen seciminizi yapin > ");
			secim = Integer.parseInt(klavye());
		}
		switch (secim) {
		case 0:
			break;
		case 1:
			Personel.olustur();
			break;
		case 2:
			Arac.olustur();
			break;
		}
	} // end method bilgiTanimla()

	public static String klavye() throws Exception {
		// Scanner yerine InputStreamReader
		InputStreamReader klavye = new InputStreamReader(System.in);
		BufferedReader giris = new BufferedReader(klavye);
		return giris.readLine();
	} // end method klavye()

} // end class