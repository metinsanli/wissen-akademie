import java.io.File;

public class Yolcu {
	static String tck, ad, durumu;
	static File dosyaYolcu = new File("./src/Yolcu.txt");

	public static void olustur() throws Exception {
		do {
			System.out.printf("\n#### YOLCU OLUSTUR ####\n");
			System.out.printf("\nTCK\tiptal=0 > ");
			tck = Uygulama.klavye();
			if (tck.equals("0"))
				break;
			System.out.printf("\nAdi\tiptal=0 > ");
			ad = Uygulama.klavye();
			if (ad.equals("0"))
				break;
			durumu = "0";
			Dosya.satirEkle(dosyaYolcu, tck + "\t" + ad + "\t" + durumu);
			break;
		} while (true);
	} // end method olustur()

	public static void biletSat() throws Exception {
		do {
			System.out.printf("\n#### BILET SATIS ####\n");
			Sefer.listele("SEFERDE");
			System.out.printf("\n\nSefer secin\t> ");
			String seferno = Uygulama.klavye();
			if (seferno.equals("0"))
				break;
			Yolcu.listele("0");
			System.out.printf("\n\nMusteri secin\t> ");
			String tck = Uygulama.klavye();
			if (tck.equals("0"))
				break;
			Otobus.listele("SEFERDE");
			System.out.printf("\n");
			// OTOBUSUN KOLTUGUNU SECILIP GUNCELLENECEK
			Dosya.guncelle(dosyaYolcu, tck, 2, "1");
			break;
		} while (true);
	}

	public static void listele(String durumu) throws Exception {
		System.out.printf("\n## MUSTERI LISTESI ##\n");
		System.out.printf("\n%-15s%-15s%-15s", "TCK", "ADI", "DURUM");
		System.out.printf("\n%-15s%-15s%-15s", "-----", "----", "-----");
		Dosya.listele(dosyaYolcu, 2, durumu);
	} // end method listele()

	public static void menu() throws Exception {
		while (true) {
			System.out.printf("\n#### YOLCU ISLEMLERI ####\n");
			System.out.printf("\n[1] - Yolcu Ekle");
			System.out.printf("\n[2] - Bilet Satis");
			System.out.printf("\n[3] - Pasif Yolculari listele");
			System.out.printf("\n[4] - Seyehat Eden Yolculari Listele");
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
				biletSat();
				break;
			case 3:
				listele("0");
				break;
			case 4:
				listele("1");
				break;
			}
		}
	}// end method menu()

} // end class
