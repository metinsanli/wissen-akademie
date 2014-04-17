import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uygulama {

	public static void main(String[] args) throws Exception {

		anaMenu();

	} // end main()

	public static String klavye() throws Exception {
		InputStreamReader veri = new InputStreamReader(System.in, "Cp1254");
		BufferedReader giris = new BufferedReader(veri);
		return giris.readLine();
	} // end method klavye()

	public static String formatla(double deger) {
		return String.valueOf(String.format("%.2f", deger).replace(",", "."));
	} // end method formatla()

	public static String formatla(String deger) {
		return deger.replace(",", ".");
	} // end method formatla()

	private static void anaMenu() throws Exception {
		Malzeme malzeme = new Malzeme();
		Urun urun = new Urun();
		int secim = -1;
		while (secim != 0) {
			System.out.printf("\n#### %s ####\n", "ANA MENU");
			System.out.printf("\n[1] - Urun Sat");
			System.out.printf("\n[2] - Urun Tanimla");
			System.out.printf("\n[3] - Urunleri Listele");
			System.out.printf("\n[4] - Malzeme Ekle");
			System.out.printf("\n[5] - Malzemeleri Listele");
			System.out.printf("\n\n[0] - Cikis\n");
			while (secim > 5 || secim < 0) {
				System.out.printf("\nSecim girin > ");
				secim = Integer.parseInt(klavye());
			}
			switch (secim) {
			case 0:
				System.out.printf("\nProgram kapatildi!");
				System.exit(0);
				break;
			case 1:
				urun.sat();
				break;
			case 2:
				urun.ekle();
				break;
			case 3:
				urun.listele();
				break;
			case 4:
				malzeme.ekle();
				break;
			case 5:
				malzeme.listele();
				break;
			}
			secim = -1;
		}
	} // end method anaMenu()

} // end class