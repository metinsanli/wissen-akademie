/* while'dan farki; kume parantezi icerisine ilk once kosulsuz girer.
 * kume parantezi icersindeki akis bittiginde while kosulu kontrol eder.
 * kosul saglaniyorsa dongu tekrar calisir.
 */

public class DoWhileYapisi1 {

	public static void main(String[] args) {
		int sayac = 1;
		int sayi = 5;

		do {
			System.out.println(sayac + " ");
			sayac++;
		} while (sayac <= sayi);

	}
}
