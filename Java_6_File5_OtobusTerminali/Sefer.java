import java.io.File;

public class Sefer {
	static File dosyaSefer = new File("./src/Sefer.txt");
	static String kod, tarih, guzergah, plaka, durum;
	static double fiyat;

	public static void olustur() throws Exception {
		do {
			System.out.printf("\n**** YENI SEFER OLUSTUR ****\n\n");
			System.out.printf("\nTarih\t0=iptal\t> ");
			tarih = Uygulama.klavye();
			if (tarih.equals("0"))
				break;
			System.out.printf("\nGuzergah\t>0=iptal\t> ");
			guzergah = Uygulama.klavye().toUpperCase();
			if (guzergah.equals("0"))
				break;
			Otobus.listele("BOSTA");
			System.out.printf("\nPlaka\t>0=iptal\t> ");
			plaka = Uygulama.klavye().toUpperCase();
			if (plaka.equals("0"))
				break;
			System.out.printf("\nFiyat\t>0=iptal\t> ");
			fiyat = Double.parseDouble(Uygulama.klavye());
			if (plaka.equals("0"))
				break;
			kod = kodUret(tarih, guzergah, plaka);
			durum = "SEFERDE";
			File dosyaOtobus = new File("./src/Otobus.txt");
			Dosya.guncelle(dosyaOtobus, plaka, 3, "SEFERDE");
			Dosya.satirEkle(dosyaSefer, kod + "\t" + tarih + "\t" + guzergah + "\t" + plaka + "\t" + fiyat + "\t" + durum);
			break;
		} while (true);
	} // end method olustur()

	public static void listele(String durum) throws Exception {
		System.out.printf("\n---- %s SEFER LISTESI ----\n", durum);
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s%-13s", "KOD       ", "TARIH ", "GUZERGAH", "PLAKA     ", "FIYAT", "DURUM  ");
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s%-13s", "----------", "------", "--------", "----------", "-----", "-------");
		Dosya.listele(dosyaSefer, 5, durum);
		System.out.printf("\n");
	} // end method listele()

	public static void bitir() throws Exception {
		do {
			System.out.printf("\n#### AKTIF SEFERLERI BITIR ####\n");
			listele("SEFERDE");
			System.out.printf("\n\nSefer kodunu girin\tiptal=0 > ");
			String secim = Uygulama.klavye();
			if (secim.equals("0"))
				break;
			String[] bitenPlaka = Dosya.satirBulGetir(dosyaSefer, secim).split("\t");
			Otobus.seferBitir(bitenPlaka[3]);
			Dosya.guncelle(dosyaSefer, secim, 5, "BITTI");
			break;
		} while (true);
	} // end method bitir()

	public static String plakaGetir(String seferno) throws Exception {
		String[] satir = Dosya.satirBulGetir(dosyaSefer, seferno).split("\t");
		return satir[3];
	} // end method plakaGetir()

	public static String kodUret(String tarih, String guzergah, String plaka) {
		return tarih.substring(0, 4) + guzergah.substring(0, 2) + guzergah.substring(4, 6) + plaka.substring(0, 2);
	} // end method kodUret()

	public static void menu() throws Exception {
		while (true) {
			System.out.printf("\n#### SEFER ISLEMLERI ####\n");
			System.out.printf("\n[1] - Sefer Olustur");
			System.out.printf("\n[2] - Sefer Bitir");
			System.out.printf("\n[3] - Aktif Seferleri Listele");
			System.out.printf("\n[4] - Bitmis Seferleri Listele");
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
				bitir();
				break;
			case 3:
				listele("SEFERDE");
				break;
			case 4:
				listele("BITTI");
				break;
			}
		}
	}// end method menu()

} // end class