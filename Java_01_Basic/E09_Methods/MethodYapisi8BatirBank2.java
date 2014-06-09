package E09_Methods;
import java.util.Scanner;

public class MethodYapisi8BatirBank2 {

	// SINIF DEGISKENLERI
	static String[] musteriAdi = { "Volkan Sen", "Mehmet Yasin", "Cemil Ipekci", "Gonul Balik", "Metin Yazan", "Kerim Abdullah", "Nihan Genc", "Yusuf Birinci", "Mustafa Keser" };
	static int[] musteriNo = { 5001, 5002, 5003, 5004, 5005, 5006, 5007, 5008, 5009 };
	static int[] bakiye = { 2500, 3000, 0, 5500, 600, 7800, 1000, 30, 550 };
	static Scanner veri = new Scanner(System.in);
	static int paraMik;

	public static void main(String[] args) {

		int musNo, islem;
		boolean kayitKontrol = true;
		boolean islemMenu = true;

		while (kayitKontrol) {
			kayitKontrol = false;

			// MUSTERI NO GIRISI
			System.out.printf("\n*** BATIR BANK ***\n");
			System.out.printf("\nLutfen Musteri No'sunu girin (Cikis \"0\") > ");
			musNo = sayiGir();

			// EGER "0" GIRILMISE PROGRAMDAN CIK
			if (musNo == 0) {
				System.out.printf("\nProgram kapatildi!");
				System.exit(0);
			}

			// GIRILEN MUSTERI NO KAYITLARDA VARMI?
			for (int sayac = 0; sayac < musteriNo.length; sayac++) {
				if (musteriNo[sayac] == musNo) {
					// EGER VARSA ISLEM MENUSUNU GETIR
					islemMenu = true;
					while (islemMenu) { // MUSTERI ISLEM MENUSU
						islemMenu = false;
						System.out.printf("\nSn. %s ", musteriAdi[sayac]);
						System.out.printf("yapmak istediginiz islemi secin > ");
						System.out.printf("\n1 - Bakiye Goruntule\n2 - Para yatirma\n3 - Para cekme\n0 - Cikis");
						System.out.printf("\nIslem secin (1/2/3/0) > ");
						islem = sayiGir();

						// GIRILEN ISLEMI SEC
						switch (islem) {
						case 0:
							islemMenu = false;
							break;
						case 1: // BAKIYE GORUNTULE
							bakiyeGoruntule(sayac);
							islemMenu = true;
							break;
						case 2: // PARA YATIRMA
							paraEkle(sayac);
							bakiyeGoruntule(sayac);
							islemMenu = true;
							break;

						case 3: // PARA CEKME
							paraCekme(sayac);
							bakiyeGoruntule(sayac);
							islemMenu = true;
							break;
						default: // CIKIS YAP
							islemMenu = true;
							break;
						}
					} // islem menu while

					kayitKontrol = true;
					break;
				}
			} // end ic for

			// EGER KAYIT YOKSA (MUSTERI NO GIRISINE GERI DON)
			if (kayitKontrol == false) {
				System.out.printf("\n%d Nolu Musteri kayidi bulunmuyor!\n", musNo);
				kayitKontrol = true;
			}

		}// kayitKontrol while
		veri.close();
	} // end main

	/* METHODLAR */

	public static void paraEkle(int x) {
		System.out.printf("\nSn. %s hesabina yatirilacak miktari girin (TL) > ", musteriAdi[x]);
		paraMik = sayiGir();
		bakiye[x] += paraMik;
	}

	public static void paraCekme(int x) {
		boolean paraTamam = true;
		while (paraTamam) {
			paraTamam = false;
			System.out.printf("\nSn. %s hesabinizdan cekilecek miktari girin (TL) > ", musteriAdi[x]);
			paraMik = sayiGir();
			// BAKIYE CEKILEN MIKTARDAN AZSA
			if (paraMik > bakiye[x]) {
				System.out.printf("\nBakiyeniz %d TL. Yeterli bakiyeniz yok !", bakiye[x]);
				paraTamam = true;
			} else {
				bakiye[x] -= paraMik;
			}
		}
	}

	public static void bakiyeGoruntule(int x) {
		System.out.printf("\nSn. %s guncel bakiyeniz = %d TL.\n", musteriAdi[x], bakiye[x]);
	}

	public static int sayiGir() {
		int giris = veri.nextInt();
		return giris;
	}

} // end class