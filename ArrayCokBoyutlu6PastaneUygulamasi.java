import java.util.Scanner;

public class ArrayCokBoyutlu6PastaneUygulamasi {
	// MALZEME TANIMLAMALARI
	static String[] malzemeAdi = { "Un", "Seker", "Tuz", "Kakao", "Vanilya", "Krema" };
	static int[][] malzemeBilgi = { { 5000, 5001, 5002, 5003, 5004, 5005 }, { 3, 2, 5, 6, 8, 2 } };
	static double[] malzemeMiktari = { 5.1, 25.5, 4.0, 20.0, 10.0, 9.0 };
	// URUN TANIMLAMALARI
	static String[] urunAdi = { "Browni", "Kremali Pasta", "Kurabiye" };
	static int[][] urununMalzemeleri = { { 5000, 5001, 5003 }, { 5000, 5002, 5004, 5005 }, { 5000, 5001 } };
	static double[][] urununMalzemeMiktari = { { 2.0, 0.5, 0.25 }, { 3.0, 2.0, 2.5, 1.5 }, { 1.0, 0.40 } };
	// DIGER SINIF DEGISKENLERI
	static double kasa = 250;
	static Scanner veri = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.printf("\n########## GUVEN PASTANESI ##########");
		while (true) {
			switch (anaMenu()) {
			case 0:
				cikisMenu();
				break;
			case 1:
				malzemeAlimi();
				break;
			case 2:
				urunSec();
				break;
			case 3:
				kasaGoruntule();
				break;
			case 4:
				stokBilgileri();
				break;
			}
		}

	} // end main

	public static int anaMenu() {
		int secim = -1;
		while (secim <= -1 || secim > 4) {
			System.out.printf("\n\n#>\tANA MENU\n");
			System.out.printf("\n* Malzeme Alimi\t\t[1]");
			System.out.printf("\n* Urun Satis\t\t[2]");
			System.out.printf("\n* Kasa Goruntule\t[3]");
			System.out.printf("\n* Stok Bilgileri\t[4]");
			System.out.printf("\n* Cikis\t\t\t[0]");
			System.out.printf("\n\n Lutfen seciminizi yapin > ");
			secim = veri.nextInt();
		}
		return secim;
	} // end anaMenu

	public static void cikisMenu() {
		System.out.printf("! Program kapatildi.");
		System.exit(0);
	} // end cikisMenu

	public static void stokBilgileri() {
		int devam;
		do {
			System.out.printf("\nGuncel stok bilgileri asagidaki gibidir.\n");
			System.out.printf("\nKodu\tAdi\tMiktari\tFiyati");
			System.out.printf("\n----\t----\t-------\t-------");
			for (int i = 0; i < malzemeAdi.length; i++)
				System.out.printf("\n%d\t%s\t%.1f\t %d TL", malzemeBilgi[0][i], malzemeAdi[i], malzemeMiktari[i], malzemeBilgi[1][i]);
			System.out.printf("\n\nAna Menuye gitmek icin \"0\" girin > ");
			devam = veri.nextInt();
		} while (devam != 0);
	} // end stokBilgileri

	public static void urunSec() {
		System.out.printf("\n\n#>\tURUN SATIS MENU\n\n");
		for (int i = 0; i < urunAdi.length; i++)
			System.out.printf("[%d]\t%s\n", 1000 + i, urunAdi[i]);
		System.out.println();
		int urunKodu = 0;
		while (urunKodu <= 0) {
			System.out.printf("\nUrun kodunu girin  > ");
			urunKodu = veri.nextInt();
		}
		urunUret(urunKodu);
	} // end urunSatis

	public static void urunUret(int uk) {
		uk -= 1000;
		boolean uret = stokKontrol(uk);
		while (uret) {
			uret = false;
			for (int i = 0; i < urununMalzemeleri[uk].length; i++) {
				for (int m = 0; m < malzemeBilgi[0].length; m++) {
					if (malzemeBilgi[0][m] == urununMalzemeleri[uk][i]) {
						malzemeMiktari[m] -= urununMalzemeMiktari[uk][i];
						kasa += 1.30 * malzemeBilgi[1][m];
					}
				}
			}
		}
	} // end urunUret

	public static boolean stokKontrol(int uk) {
		for (int i = 0; i < urununMalzemeleri[uk].length; i++) {
			for (int m = 0; m < malzemeBilgi[0].length; m++) {
				if (malzemeMiktari[m] <= 0 || malzemeMiktari[m] < urununMalzemeMiktari[uk][i]) {
					System.out.printf("\n%s icin mevcut %s miktari %.2f birimdir.\nEn az %.2f birim olmalidir!", urunAdi[uk], malzemeAdi[m], malzemeMiktari[m], urununMalzemeMiktari[uk][i]);
					System.out.printf("\n\nAna Menuye gitmek icin \"0\" girin > ");
					while (veri.nextInt() != 0) {
					}
					return false;
				}
			}
		}
		System.out.printf("\n%s uretimi basarili oldu.\n\nAna Menuye gitmek icin \"0\" girin > ", urunAdi[uk]);
		while (veri.nextInt() != 0) {
		}
		return true;
	} // end stokKontrol

	public static void malzemeAlimi() {
		System.out.printf("\n\n#>\tMALZEME ALIS MENU\n");
		for (int i = 0; i < malzemeAdi.length; i++) {
			System.out.printf("\n[%d]\t%s", malzemeBilgi[0][i], malzemeAdi[i]);
		}
		System.out.printf("\n\nLutfen malzemenin kodunu girin > ");
		int secim = veri.nextInt();
		for (int i = 0; i < malzemeBilgi[0].length; i++) {
			if (secim == malzemeBilgi[0][i]) {
				System.out.printf("\n%s icin eklenecek birim degeri girin > ", malzemeAdi[i]);
				double giris = veri.nextDouble();
				malzemeMiktari[i] += giris;
				kasa -= giris * malzemeBilgi[1][i];
				System.out.printf("\n%s yeni mevcut miktari = %.1f birimdir\nKasada kalan para %.2f TL.\n\nAna Menuye gitmek icin \"0\" girin > ", malzemeAdi[i], malzemeMiktari[i], kasa);
				while (veri.nextInt() != 0) {
				}
			}
		}
	} // end malzemeAlimi()

	public static void kasaGoruntule() {
		System.out.printf("\n#>\tKASA GORUNTULE\n");
		System.out.printf("\nKasadaki mevcut para = %.2f TL.", kasa);
		System.out.printf("\n\nAna Menuye gitmek icin \"0\" girin > ");
		while (veri.nextInt() != 0) {
		}
	}
} // end class
