import java.io.File;

public class Otobus {
	static String plaka, kaptan, durumu, koltuklar = "";
	static int kapasite;
	static File dosyaOtobus = new File("./src/Otobus.txt");

	public static void olustur() throws Exception {
		do {
			System.out.printf("\n#### OTOBUS EKLE ####\n");
			System.out.printf("\nPlaka\tiptal=0 > ");
			plaka = Uygulama.klavye().toUpperCase();
			if (plaka.equals("0"))
				break;
			System.out.printf("\nKaptan\tiptal=0 > ");
			kaptan = Uygulama.klavye();
			if (kaptan.equals("0"))
				break;
			System.out.printf("\nKapasite\tiptal=0 > ");
			kapasite = Integer.parseInt(Uygulama.klavye());
			if (kapasite == 0)
				break;
			durumu = "BOSTA";
			for (int i = 1; i <= kapasite; i++)
				koltuklar += i + "-" + "0" + " ";
			Dosya.satirEkle(dosyaOtobus, (plaka + "\t" + kaptan + "\t" + kapasite + "\t" + durumu + "\t" + koltuklar));
			break;
		} while (true);
	} // end method olustur()

	public static void listele(String durumu) throws Exception {
		System.out.printf("\n## MUSTERI LISTESI ##\n");
		System.out.printf("\n%-15s%-15s%-15s%-15s", "PLAKA", "KAPTAN", "KAPASITE", "DURUMU");
		System.out.printf("\n%-15s%-15s%-15s%-15s", "-----", "------", "--------", "------");
		Dosya.listele(dosyaOtobus, 3, durumu);
	} // end method listele()

	public static void menu() throws Exception {
		while (true) {
			System.out.printf("\n#### OTOBUS ISLEMLERI ####\n");
			System.out.printf("\n[1] - Otobus Ekle");
			System.out.printf("\n[2] - Seferdeki Otobusleri Listele");
			System.out.printf("\n[3] - Bostaki Otobusleri Listele");
			System.out.printf("\n\n[0] - Ana Menu\n");
			int secim = -1;
			while (secim > 4 || secim < 0) {
				System.out.printf("\nSecim yapin > ");
				secim = Integer.parseInt(Uygulama.klavye());
			}
			if (secim == 0)
				break;
			switch (secim) {
			case 1:
				olustur();
				break;
			case 2:
				listele("SEFERDE");
				break;
			case 3:
				listele("BOSTA");
				break;
			}
		}
	}// end method menu()

} // end class