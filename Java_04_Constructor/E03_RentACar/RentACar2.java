package E03_RentACar;

import java.util.Scanner;

public class RentACar2 {
	static Scanner giris = new Scanner(System.in);
	static Scanner yazi = new Scanner(System.in);
	static Araba[] araba = new Araba[6];
	static Musteri[] musteri = new Musteri[10];
	static int musteriAdedi = 2;

	public static void main(String[] args) {

		araba[0] = new Araba("Mercedes", 1.4, "34 THK 55", "Beyaz", 10450, 20, 50, 250, 4.7, true, false, 0);
		araba[1] = new Araba("Audi", 1.6, "02 MGJ 22", "Gri", 20750, 26, 50, 190, 4.2, true, true, 0);
		araba[2] = new Araba("Renault", 1.2, "06 LLK 11", "Yesil", 80055, 14, 50, 50, 2.7, false, true, 0);
		araba[3] = new Araba("Skoda", 1.2, "27 OOP 47", "Kirmizi", 60555, 11, 50, 30, 2.1, false, false, 0);
		araba[4] = new Araba("Ferrari", 2.4, "01 FRR 66", "Siyah", 10598, 22, 50, 950, 8.7, true, false, 0);
		araba[5] = new Araba("Opel", 1.8, "34 AR 1001", "Siyah", 0, 50, 50, 5, 4, false, false, 0);

		musteri[0] = new Musteri("Ahmet Mehmet", "98765432100", 0);
		musteri[1] = new Musteri("Ali Veli", "43210098721", 1);
		for (int r = 2; r < musteri.length; r++)
			musteri[r] = new Musteri();
		
		// 

		while (true) {
			switch (musteriMenu()) {
			case 0:
				System.exit(0);
			case 1: // Tum musteri bilgilerini goruntule
				for (int i = 0; i < musteri.length; i++) {
					if (musteri[i].musteriAdi != null)
						System.out.printf("\n[%d] - %s %s %s", i + 1, musteri[i].musteriAdi, musteri[i].tcKimlik, araba[musteri[i].sahibi].marka);
				}
				devamEt();
				break;
			case 2:
				@SuppressWarnings("unused")
				boolean m = true;
				baslikGetir();
				for (int i = 0; i < araba.length; i++)
					arabaBilgiListele(i);

				break;
			case 3: // Yeni musteri ekle
				yeniMusteriEkle();
				break;
			case 4: // Musteri sec araba kullan
				break;
			}
		}

	} // end main()

	public static int arabaIslemSec() {
		int sec = -1;
		System.out.printf("\n##### ARABA ISLEM SEC #####");
		System.out.printf("\n\n[1] - Arabayi sur\n[2] - Arabaya yakit al\n[3] - Araba bilgilerini goster\n[4] - Tum araba bilgilerini goster\n[0] - Cikis\n");
		while (sec <= -1 || sec > 4) {
			System.out.printf("\nLutfen seciminizi yapin > ");
			sec = giris.nextInt();
		}
		return sec;
	} // end method anaMenu()

	public static int arabaSec() {
		int sec = -1;
		System.out.printf("\n##### ARABA SEC #####");
		for (int i = 0; i < araba.length; i++) {
			System.out.printf("\n[%d] - %s", i + 1, araba[i].marka);
		}
		System.out.printf("\n[0] - Iptal\n");
		while (sec <= -1 || sec > araba.length) {
			System.out.printf("\nLutfen seciminizi yapin > ");
			sec = giris.nextInt();
		}
		return sec;
	}

	public static void devamEt() {
		int sec = 1;
		while (sec != 0) {
			System.out.printf("\n\nDevam etmek icin \"0\" girin > ");
			sec = giris.nextInt();
		}
	} // end method devamEt()

	@SuppressWarnings("unused")
	public static void arabaHareket() {
		int secim;
		while (true)
			switch (arabaIslemSec()) {
			case 0:
				break;
			case 1:
				secim = arabaSec();
				if (secim != 0)
					araba[secim - 1].arabaSur();
				devamEt();
				break;
			case 2:
				araba[arabaSec() - 1].yakitAl();
				devamEt();
				break;
			case 3:

				devamEt();
				break;
			case 4:
				boolean baslik;
				for (int i = 0; i < araba.length; i++) {
					if (i == 0)
						baslik = true;
					else
						baslik = false;

				}
				devamEt();
				break;
			}
	}

	public static int musteriMenu() {
		int sec = -1;
		System.out.printf("\n\n##### MUSTERI MENU #####\n");
		while (sec <= -1 || sec > 4) {
			System.out.printf("\n[1] - Tum musteri bilgilerini goruntule\n[2] - Tum araba bilgilerini goruntule\n[3] - Yeni musteri ekle\n[4] - Musteri ile araba kullan\n\n[0] - Cikis\n");
			System.out.printf("\nLutfen seciminizi yapin > ");
			sec = giris.nextInt();
		}
		return sec;
	}

	public static void yeniMusteriEkle() {
		String ad, tck;
		int ar;
		System.out.printf("\n##### YENI MUSTERI KAYDI ######\n");
		System.out.printf("\nMusteri adini girin > ");
		ad = giris.next();
		System.out.printf("\nTC Kimlik No girin > ");
		tck = giris.next();
		ar = arabaSec();
		musteri[musteriAdedi] = new Musteri(ad, tck, ar);
		musteriAdedi++;
	} // end method yeniMusteriEkle()

	public static void baslikGetir() {
		System.out.printf("\n%-10s%-5s%-12s%-8s%-10s%-6s%-8s%-7s%-6s%-9s%-10s", "Marka", "CC.", "Plaka", "Renk", "KM", "Yakit", "Tuketim", "Turu", "Vites", "Gunluk", "Sahibi");
		System.out.printf("\n%-10s%-5s%-12s%-8s%-10s%-6s%-8s%-7s%-6s%-9s%-10s", "---------", "----", "-----------", "-------", "---------", "-----", "-------", "------", "-----", "--------", "----------");
	} // end method baslikGetir()

	public static void arabaBilgiListele(int indis) {
		System.out.printf("\n%-10s%-5s%-12s%-8s%-10.2f%-6s%-8s%-7s%-6s%-5sTL", araba[indis].marka, araba[indis].motorHacmi, araba[indis].plaka, araba[indis].renk, araba[indis].km, araba[indis].yakitMiktari, araba[indis].yakitTuketim, araba[indis].yakitTuru, araba[indis].vitesTuru,
				araba[indis].gunlukKira, musteri[0].musteriAdi);
	} // end method arabaBilgileri()

} // end class