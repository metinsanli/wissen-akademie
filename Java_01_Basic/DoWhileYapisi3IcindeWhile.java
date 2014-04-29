public class DoWhileYapisi3IcindeWhile {

	public static void main(String[] args) {
		int sayac1 = 500, sayac2;

		DisDongu: do {
			System.out.println(sayac1);
			sayac1++;
			sayac2 = 0; // ic dongunun sayacini sifirla

			while (sayac2 <= 9) {
				if (sayac2 == 5) {
					sayac2++;
					continue; // continue ic dongu
				}

				if (sayac1 == 505)
					break DisDongu;

				System.out.println("Sayac = " + sayac2);
				sayac2++;
			} // end IC do-while
		} while (sayac1 <= 515); // end DIS do-while

	} // end main
} // end class