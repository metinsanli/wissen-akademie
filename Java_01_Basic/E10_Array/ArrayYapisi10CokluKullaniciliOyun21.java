package E10_Array;
/* Cok oyunculu 21 Oyunu :
 * Maksimum 5 adet olmak uzere kac oyuncu ile oynanmak istedigi secilsin.
 * Secilen oyuna gore olusturulan kullanilardan ilki icin kart dagitilsin.
 * Sonra digerleri icin kart dagitilsin.
 * 21 puana erisene veya gecene kadar kart dagitilma sorulsun.
 * En son puanlar ve ve 21 puana erisen gosterilsin. 
 */

import java.util.Scanner;
import java.util.Random;

public class ArrayYapisi10CokluKullaniciliOyun21 {

	public static void main(String[] args) {

		// DEGISKENLER
		String[] oyuncuAd = new String[5];
		int[] oyuncuPuan = new int[5];
		Scanner veri = new Scanner(System.in);
		Scanner isim = new Scanner(System.in);
		Random kartDagitici = new Random();
		int gelenKart = 0;
		int oyuncuAdet = -1;
		int sayac = 0;
		int tempPuan = 0;
		String cevap, tempAd;

		// PROGRAMIN BASLANGICI
		System.out.printf("\n ***** COK OYUNCULU 21 OYUNU *****\n");
		while (oyuncuAdet == -1 || oyuncuAdet > 4) {
			System.out.printf("\nKac oyuncu ile oynamak istersiniz? (1-5) >");
			oyuncuAdet = veri.nextInt() - 1;
		}

		// OYUNCU ISIMLERINI GIR
		System.out.printf("\n ***** COK OYUNCULU 21 OYUNU *****\n");
		while (sayac <= oyuncuAdet) {
			System.out.printf("\n%d. oyuncu icin isim girin >", sayac + 1);
			oyuncuAd[sayac] = isim.next();
			sayac++;
		}

		// HER OYUNCUYA 2 ADET KART DAGITILSIN
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <= oyuncuAdet; j++) {
				gelenKart = 1 + kartDagitici.nextInt(10);
				oyuncuPuan[j] += gelenKart;
			}
		}

		// DAGITILAN ILK 2 KAGITLARI GOSTER
		for (int i = 0; i <= oyuncuAdet; i++) {
			System.out.println(oyuncuAd[i] + " Puani = " + oyuncuPuan[i]);
		}

		// OYUNCULARA DEVAM EDILSINMI DIYE SOR CEVAP=EVET ISE YENI KART DAGIT
		for (int i = 0; i <= oyuncuAdet; i++) {
			while (true) {
				if (oyuncuPuan[i] == 21) {
					System.out.printf("TEBRIKLER!! PUAN = %d \n", oyuncuPuan[i]);
					break;
				} else if (oyuncuPuan[i] > 21) {
					System.out.printf(oyuncuAd[i] + " KAYBETTINIZ!! Puan : %d\n", oyuncuPuan[i]);
					break;
				} else if (oyuncuPuan[i] < 21) {
					System.out.printf(oyuncuAd[i] + " Puaniniz = %d, Devam edilsin mi? (e/h) > ", oyuncuPuan[i]);
					cevap = veri.next().toLowerCase();
					if (cevap.equals("e")) {
						oyuncuPuan[i] += (1 + kartDagitici.nextInt(10));
					} else {
						System.out.printf(oyuncuAd[i] + " icin oyun bitti! Puan = %d\n", oyuncuPuan[i]);
						break;
					}
				} // end if
			} // end while
		} // end if

		// SIRALAMALARI YAP
		boolean devam = true;
		while (devam) {
			devam = false;
			for (int i = 0; i < oyuncuAdet - 1; i++) {
				if (oyuncuPuan[i] < oyuncuPuan[i + 1]) {
					// PUAN SIRALAMASI
					tempPuan = oyuncuPuan[i];
					oyuncuPuan[i] = oyuncuPuan[i + 1];
					oyuncuPuan[i + 1] = tempPuan;
					// PUAN SIRASIYLA AYNI OLACAK SEKILDE OYUNCU ADI SIRALAMASI
					tempAd = oyuncuAd[i];
					oyuncuAd[i] = oyuncuAd[i + 1];
					oyuncuAd[i + 1] = tempAd;
					devam = true;
				}
			}
		}

		// GELISMIS FOR ILE SONUCLARI SIRALI YAZDIRMA
		System.out.printf("\nOYUN BITTI : SIRALAMA\n");
		int m = 0;
		for (int i : oyuncuPuan) {
			System.out.printf("%d. %s puan = %d\n", m + 1, oyuncuAd[m], i);
			m++;
		}

		veri.close();
		isim.close();
	} // end main
} // end class