import java.io.File;

public class Yolcu {
	static String tck, ad, durumu;
	static File dosyaBilet = new File("./src/Bilet.txt");

	public static void biletSat() throws Exception {
		do {
			System.out.printf("\n???? BILET SATIS ????\n");
			Sefer.listele("SEFERDE");
			System.out.printf("\n\nSefer secin\t(0=iptal) > ");
			String seferno = Uygulama.klavye().toUpperCase();
			if (seferno.equals("0"))
				break;
			System.out.printf("\n**** YENI YOLCU GIRISI ****\n");
			System.out.printf("\nTCK\tiptal=0 > ");
			tck = Uygulama.klavye();
			if (tck.equals("0"))
				break;
			System.out.printf("\nAdi\tiptal=0 > ");
			ad = Uygulama.klavye();
			if (ad.equals("0")) {
				tck = null;
				break;
			}
			durumu = "0";
			String plaka = Sefer.plakaGetir(seferno);
			Otobus.koltukListele(plaka);
			System.out.printf("\nKoltuk secin\t(0=iptal) > ");
			int koltuk = Integer.parseInt(Uygulama.klavye());
			if (koltuk == 0)
				break;
			File dosyaSefer = new File("./src/Sefer.txt");
			String[] seferBilgi = Dosya.bulGetir(dosyaSefer, 0, seferno).split("\t");
			Otobus.koltukGuncelle(plaka, koltuk, tck);
			Dosya.satirEkle(dosyaBilet, yeniBiletKoduVer() + "\t" + seferBilgi[0] + "\t" + seferBilgi[1] + "\t" + koltuk + "\t" + tck + "\t" + ad
					+ "\t" + seferBilgi[4] + "\t" + "SATILDI");
			break;
		} while (true);
	} // end method biletSat()

	public static void biletIptal() throws Exception {
		do {
			System.out.printf("\n!!!! BILET IPTAL ISLEMLERI !!!!\n");
			Sefer.listele("SEFERDE");
			System.out.printf("\n\nSefer secin\t(0=iptal) > ");
			String seferno = Uygulama.klavye().toUpperCase();
			if (seferno.equals("0"))
				break;
			File seferDosya = new File("./src/Sefer.txt");
			String[] plakaBul = Dosya.bulGetir(seferDosya, 0, seferno).split("\t");

			File dosyaOtobus = new File("./src/Otobus.txt");
			String[] otobusBilgi = Dosya.bulGetir(dosyaOtobus, 0, plakaBul[3]).split("\t");
			String koltukBilgisi = otobusBilgi[4];
			String[] koltuk = koltukBilgisi.split(" ");
			for (int i = 0; i < Integer.parseInt(otobusBilgi[2]); i++) {
				String[] kolBil = koltuk[i].split("-");
				if (!kolBil[2].equals("0")) {
					System.out.println(Dosya.bulGetir(dosyaBilet, 4, kolBil[2]));
				}
			}
			System.out.printf("\n\nBilet secin\t(0=iptal) > ");
			String bilet = Uygulama.klavye().toUpperCase();
			if (bilet.equals("0"))
				break;
			String[] m = Dosya.bulGetir(dosyaBilet, 0, bilet).split("\t");
			int koltukNo = Integer.parseInt(m[3]);
			Otobus.koltukGuncelle(otobusBilgi[0], koltukNo, "0");
			Dosya.guncelle(dosyaBilet, bilet, 7, "IPTAL");
			break;
		} while (true);
	} // end method biletIptal()

	public static void listele(String durumu) throws Exception {
		System.out.printf("\n---- MUSTERI LISTESI ----\n");
		System.out.printf("\n%-15s%-15s%-15s", "TCK", "ADI", "DURUM");
		System.out.printf("\n%-15s%-15s%-15s", "-----", "----", "-----");
		Dosya.listele(dosyaBilet, 2, durumu);
		System.out.printf("\n");
	} // end method listele()

	public static String yeniBiletKoduVer() throws Exception {
		return "BLT" + String.format("%03d", Integer.parseInt((Dosya.sonSatiriGetir(dosyaBilet)).substring(3, 6)) + 1);
	} // end method yeniBiletKoduVer()

	public static void menu() throws Exception {
		while (true) {
			System.out.printf("\n#### YOLCU ISLEMLERI ####\n");
			System.out.printf("\n[1] - Bilet Satis");
			System.out.printf("\n[2] - Bilet Iptal");
			System.out.printf("\n\n[0] - Ana Menu\n");
			int secim = -1;
			while (secim > 2 || secim < 0) {
				System.out.printf("\nSecim yapin > ");
				secim = Integer.parseInt(Uygulama.klavye());
			}
			if (secim == 0)
				break;
			switch (secim) {
			case 1:
				biletSat();
				break;
			case 2:
				biletIptal();
				break;
			}
		}
	}// end method menu()

} // end class
