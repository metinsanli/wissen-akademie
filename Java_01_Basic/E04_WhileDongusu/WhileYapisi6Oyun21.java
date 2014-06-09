package E04_WhileDongusu;
/* Baslangicta 2 adet kagit ver.
 * Eger PUAN 21'e esitse kazandi.
 * Eger PUAN 21'den buyukse kaybetti!
 * Eger PUAN 21'den kucukse devam edilsin mi diye sorulsun?
 * CEVAP devam ise sayi uret ve PUAN'a ekle
 * CEVAP devam degilse oyunu bitir.
 */

import java.util.Scanner;
import java.util.Random;

public class WhileYapisi6Oyun21 {
	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		Random uretec = new Random();
		int kagit1 = 1 + uretec.nextInt(10), kagit2 = 1 + uretec.nextInt(10);
		int puan = kagit1 + kagit2;
		String cevap;

		while (true) {
			if (puan == 21) {
				System.out.printf("TEBRIKLER!! PUAN = %d \n", puan);
				break;
			} else if (puan > 21) {
				System.out.printf("KAYBETTINIZ!! Puan : %d\n", puan);
				break;
			} else if (puan < 21) {
				System.out.printf("Puan = %d, Devam edilsin mi? (e/h) > ", puan);
				cevap = veri.next().toLowerCase();
				if (cevap.equals("e")) {
					puan += (1 + uretec.nextInt(10));
				} else {
					System.out.printf("Oyun bitti! Puan = %d\n", puan);
					break;
				}
			}
		} // end while

		veri.close();
	} // end main
} // end class