/* 1 - 49 arasý Benzersiz 6 adet sayý üret ve bunlarý bir dizide sakla
 * 
 */

import java.util.Random;

public class ArrayYapisi8SayisalLotoVolkanHoca {
	public static void main(String[] args) {

		Random rsayi = new Random();
		int[] sayilar = new int[6];
		// FOR ÝLE ÜRET
		for (int adet = 0; adet < 6; adet++) {

			do {
				// sayý üret
				int yeniSayi = 1 + rsayi.nextInt(49);
				// üretilen sayý önceki elemanlarda var mý diyekontrol et
				boolean var = false;
				for (int k = 0; k < adet; k++) {
					if (sayilar[k] == yeniSayi) {
						System.out.println("Ayný Sayý denk geldi!");
						var = true;
						break;
					}
				}// end for
					// döngüden nasýl çýktýk?
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
