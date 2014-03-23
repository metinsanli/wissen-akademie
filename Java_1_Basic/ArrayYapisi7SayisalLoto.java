/* Kullanicidan 6 adet sayi girmesini iste.
 * Girilen sayi daha once girilmisse veya 1-49 arasinda degilse tekrar iste
 * Rastgele 1-49 arasinda 6 adet sayi uret
 * girilen ve uretilen 6 adet sayilar arasinda ayni olanlari bul(adet olarak).
 * Sonuc ekraninda kazanilan odul miktarini goster. 
 */

import java.util.Scanner;
import java.util.Random;

public class ArrayYapisi7SayisalLoto {
	public static void main(String[] args) {
		// DEGISKENLER
		int[] cekilis = new int[6];
		int[] kolon = new int[6];
		Scanner tahmin = new Scanner(System.in);
		Random sayi = new Random();
		int sayac1 = 0, sayac2 = 0;
		int giris, uretec, tutan = 0;

		// KULLANICIDAN TAHMIN GIRISI
		while (sayac1 < kolon.length) {
			System.out.printf("%d. tahmini girin > ", 1 + sayac1);
			giris = tahmin.nextInt();
			kolon[sayac1] = giris;

			if (giris == 0 || !(giris <= 49 && giris >= 1)) {
				System.out.println("Girilen sayi 1-49 arasinda olmali!");
				sayac1--;
			}

			for (int i = 0; i < sayac1; i++) {
				if (kolon[i] == giris) {
					System.out.printf("\"%d\" Bu sayi var! ", giris);
					sayac1--;
				}
			}
			sayac1++;
		}

		// CEKILIS YAPMA KISMI
		while (sayac2 < cekilis.length) {
			uretec = 1 + sayi.nextInt(49);
			cekilis[sayac2] = uretec;
			for (int i = 0; i < sayac2; i++) {
				if (cekilis[i] == uretec) {
					sayac2--;
				}
			}
			sayac2++;
		}

		// KIYASLAMA KISMI

		for (int i = 0; i < kolon.length; i++) {
			for (int j = 0; j < cekilis.length; j++) {
				if (kolon[i] == cekilis[j]) {
					tutan++;
				}
			}
		}

		// SONUC EKRANI
		System.out.print("Tahmin  = ");
		for (int i = 0; i < kolon.length; i++)
			System.out.print(kolon[i] + " ");
		System.out.println();
		System.out.print("Cekilen = ");
		for (int i = 0; i < cekilis.length; i++)
			System.out.print(cekilis[i] + " ");
		System.out.println();
		System.out.println("Tutan rakam adedi = " + tutan);
		switch (tutan) {
		case 6:
			System.out.printf("Tebrikler! 1 Milyar .TL Kazandiniz ");
		case 5:
			System.out.printf("Tebrikler! 25.000 TL Kazandiniz ");
		case 4:
			System.out.printf("Tebrikler! 1.000 TL Kazandiniz ");
		case 3:
			System.out.printf("Tebrikler! 6 TL Kazandiniz ");
		default:
			System.out.printf("Malesef ikramiye cikmadi!");
		}

		tahmin.close();
	} // end main
} // end class