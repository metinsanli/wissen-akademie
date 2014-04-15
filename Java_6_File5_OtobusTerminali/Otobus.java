import java.io.File;

public class Otobus {
	static String plaka, kaptan, durumu;
	static int kapasite;
	static File dosyaOtobus = new File("./src/Otobus.txt");
	static Koltuk[] koltuk;

	public static void olustur() throws Exception {
		do {
			System.out.printf("\n**** YENI OTOBUS EKLE ****\n");
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
			// KAPASITE KADAR KOLTUK NESNESI OLUSTUR
			koltuk = new Koltuk[kapasite];
			for (int i = 0; i < kapasite; i++)
				koltuk[i] = new Koltuk((i + 1), "0");
			String koltuklar = "";
			for (int i = 0; i < koltuk.length; i++) {
				if (i == koltuk.length - 1)
					koltuklar += koltuk[i].koltukNo + "-" + koltuk[i].pozisyon + "-" + koltuk[i].sahip;
				else
					koltuklar += koltuk[i].koltukNo + "-" + koltuk[i].pozisyon + "-" + koltuk[i].sahip + " ";
			}
			// GIRILEN BILGILERI DOSYAYA YAZ
			Dosya.satirEkle(dosyaOtobus, (plaka + "\t" + kaptan + "\t" + kapasite + "\t" + durumu + "\t" + koltuklar));
			break;
		} while (true);
	} // end method olustur()

	public static void listele(String durumu) throws Exception {
		System.out.printf("\n---- %s OTOBUS LISTESI ----\n", durumu);
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s", "PLAKA", "KAPTAN", "KAPASITE", "DURUMU", "KOLTUKLAR");
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s", "-----", "------", "--------", "------", "---------");
		Dosya.listele(dosyaOtobus, 3, durumu);
		System.out.printf("\n");
	} // end method listele()

	public static void koltukGuncelle(String plaka, int koltukNo, String yolcu) throws Exception {
		String ikinci[] = Dosya.satirBulGetir(dosyaOtobus, plaka).split("\t");
		String ucuncu[] = ikinci[4].split(" ");
		// kapasite kadar koltuk dizisi baslat
		Koltuk[] koltuk;
		koltuk = new Koltuk[Integer.parseInt(ikinci[2])];
		for (int i = 0; i < Integer.parseInt(ikinci[2]); i++) {
			String[] bilgi = ucuncu[i].split("-");
			koltuk[i] = new Koltuk((i + 1), bilgi[2]);
		}
		koltuk[koltukNo - 1].sahip = yolcu;
		String guncel = "";
		for (int i = 0; i < koltuk.length; i++) {
			if (i == koltuk.length - 1)
				guncel += koltuk[i].koltukNo + "-" + koltuk[i].pozisyon + "-" + koltuk[i].sahip;
			else
				guncel += koltuk[i].koltukNo + "-" + koltuk[i].pozisyon + "-" + koltuk[i].sahip + " ";
		}
		Dosya.guncelle(dosyaOtobus, plaka, 4, guncel);
	} // end method koltukGuncelle()

	public static void seferBitir(String plaka) throws Exception {
		String[] otobusBilgi = Dosya.satirBulGetir(dosyaOtobus, plaka).split("\t");
		System.out.println(otobusBilgi[2]);
		int kap = Integer.parseInt(otobusBilgi[2]);
		for (int i = 1; i <= kap; i++)
			koltukGuncelle(plaka, i, "0");
		Dosya.guncelle(dosyaOtobus, plaka, 3, "BOSTA");
	} // end method koltukSifirla

	public static void koltukListele(String plaka2) throws Exception {
		System.out.printf("\n---- %s KOLTUK LISTESI -----\n", plaka2);
		System.out.printf("\n%-7s%-7s%-7s%-15s", "DURUMU", "NO", "POZ.", "MUSTERI");
		System.out.printf("\n%-7s%-7s%-7s%-15s", "------", "--", "----", "-------");
		String[] birinci = Dosya.satirBulGetir(dosyaOtobus, plaka2).split("\t");
		String[] ikinci = birinci[4].split(" ");
		String[] ucuncu = new String[Integer.parseInt(birinci[2])];
		String durumu = "";
		for (int i = 0; i < Integer.parseInt(birinci[2]) - 1; i++) {
			ucuncu = ikinci[i].split("-");
			if (!ucuncu[2].equals("0"))
				durumu = "DOLU";
			else
				durumu = "BOS";
			System.out.printf("\n%-7s%-7s%-7s%-15s", durumu, ucuncu[0], ucuncu[1], ucuncu[2]);
		}
	} // end method koltukListele()

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