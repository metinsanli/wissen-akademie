import java.util.Scanner;
import java.util.Random;

public class ArrayCokBoyutlu5FarkleGame {
	// SINIF DEGISKENLERI
	static Random rastgele = new Random();
	static Scanner veri = new Scanner(System.in);
	static int anlikHak = 0;

	public static void main(String[] args) {
		// DEGISKENLER
		int[] gelenZar = new int[6];
		int hak = 5;
		int puan;
		// OYUNA GIRIS
		System.out.printf("\n # FARKLE GAME #\n");
		while (oyunaBasla()) {

			// KAC ZAR ATMA HAKKI VARSA O KADAR ATILACAK
			for (int i = 0; i <= hak; i++) {
				gelenZar[i] = zarAt();
			}

			puan = puanHesapla(gelenZar, hak);

			// TEST GELEN ZAR
			for (int i : gelenZar)
				System.out.print(i + " ");
			System.out.println("\n" + puan);

		} // end while oyunaDevam

	} // end main

	public static int zarAt() {
		// RASTGELE 1 KERE ZAR AT SONUCU GERI BILDIR
		return 1 + rastgele.nextInt(6);
	} // end zarAt

	public static boolean oyunaBasla() {
		String cevap;
		// YENI OYUN BASLATILSIN MI? Evet=TRUE / Hayir=FALSE
		System.out.printf("\nYeni oyun baslatilsin mi? (e/h) > ");
		cevap = veri.next();
		if (cevap.equalsIgnoreCase("e")) {
			return true;
		}
		return false;
	} // end oyunaDevam

	public static int[] ayniSayilar(int z[]) {
		int[] ayniSayilar = { 0, 0, 0, 0, 0, 0 };
		// HANGI SAYIDAN KAC TANE GELDI?
		for (int i = 0; i <= anlikHak; i++) {
			switch (z[i]) {
			case 1:
				ayniSayilar[0]++;
				break;
			case 2:
				ayniSayilar[1]++;
				break;
			case 3:
				ayniSayilar[2]++;
				break;
			case 4:
				ayniSayilar[3]++;
				break;
			case 5:
				ayniSayilar[4]++;
				break;
			case 6:
				ayniSayilar[5]++;
				break;
			default:
				break;
			}
		}
		return ayniSayilar;
	}

	public static int puanHesapla(int zz[], int h) {
		int aktifPuan = 0;
		int[] p = { 0, 0, 0, 0, 0, 0 };
		int[] as = ayniSayilar(zz);
		anlikHak = 0;
		ayniSayilar(as);
		// AYNI SAYILARDAN 3 TANE VARSA VEYA 1,5 VARSA PUANLARI ANLIK HESAPLA
		for (int i = 0; i < h; i++) {
			switch (as[i]) {
			case 1:
				p[0] += 100;
				anlikHak++;
				break;
			case 2:
				if (as[i] >= 3) {
					p[1] = p[1] + 100;
					anlikHak++;
				}
				break;
			case 3:
				if (as[i] >= 3) {
					p[2] = p[2] + 100;
					anlikHak++;
				}
				break;
			case 4:
				if (as[i] >= 3) {
					p[3] = p[3] + 100;
					anlikHak++;
				}
				break;
			case 5:
				p[4] += 50;
				anlikHak++;
				break;
			case 6:
				if (as[i] >= 3) {
					p[5] = p[5] + 100;
					anlikHak++;
				}
				break;
			}
		}
		// DIZIDEKI PUANLARI TEK DEGISKENDE TOPLA
		for (int i = 0; i <= 5; i++)
			aktifPuan += p[i];
		return aktifPuan;
	}

} // end class