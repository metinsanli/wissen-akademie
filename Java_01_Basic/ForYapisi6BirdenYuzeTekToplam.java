/* 1'den 100'e kadar tek sayilarin toplami.
 */

public class ForYapisi6BirdenYuzeTekToplam {

	public static void main(String[] args) {
		int sayi = 0;

		for (int i = 0; i < 100; i++) {
			if (i % 2 != 0) {
				sayi += i;
			} // end if
		} // end for

		System.out.println(" Sayi = " + sayi);

	} // end main
} // end class
