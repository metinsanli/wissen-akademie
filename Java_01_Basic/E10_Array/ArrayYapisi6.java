package E10_Array;
import java.util.Arrays;

public class ArrayYapisi6 {

	public static void main(String[] args) {

		int[] dizi = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
		int toplam = 0, enBuyuk = 0, enKucuk = 1000;

		for (int i = 0; i < dizi.length; i++) {

			toplam += dizi[i]; // dizi elemanlarini topla

			if (dizi[i] > enBuyuk) // en butuk sayiyi bul
				enBuyuk = dizi[i];
			if (dizi[i] < enKucuk) // en kucuk sayiyi bul
				enKucuk = dizi[i];

		} // end for

		System.out.println("Toplam        = " + toplam);
		System.out.println("En buyuk sayi = " + enBuyuk);
		System.out.println("En kucuk sayi = " + enKucuk);
		System.out.println("Ortalama      = " + (toplam / dizi.length));

		Arrays.sort(dizi);
		System.out.println("En buyuk = " + dizi[dizi.length - 1]);
		System.out.println("En kucuk = " + dizi[0]);

	} // end main
} // end class