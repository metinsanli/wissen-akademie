package E10_Array;
/* 1 - 49 aras� Benzersiz 6 adet say� �ret ve bunlar� bir dizide sakla
 * 
 */

import java.util.Random;

public class ArrayYapisi8SayisalLotoVolkanHoca {
	public static void main(String[] args) {

		Random rsayi = new Random();
		int[] sayilar = new int[6];
		// FOR �LE �RET
		for (int adet = 0; adet < 6; adet++) {

			do {
				// say� �ret
				int yeniSayi = 1 + rsayi.nextInt(49);
				// �retilen say� �nceki elemanlarda var m� diyekontrol et
				boolean var = false;
				for (int k = 0; k < adet; k++) {
					if (sayilar[k] == yeniSayi) {
						System.out.println("Ayn� Say� denk geldi!");
						var = true;
						break;
					}
				}// end for
					// d�ng�den nas�l ��kt�k?
				if (var == false) {
					sayilar[adet] = yeniSayi;
					break;// do-while
				}// end if
			} while (true);

		}// end for

		for (int i = 0; i < 6; i++)
			System.out.print(sayilar[i] + " ");
	}
}
