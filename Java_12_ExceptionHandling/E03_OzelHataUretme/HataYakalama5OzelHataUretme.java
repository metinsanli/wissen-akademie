package E03_OzelHataUretme;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HataYakalama5OzelHataUretme {

	public static double bolme(int sayi, int bolen) {
		return (double) sayi / bolen;
	} // end method bolme()

	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		boolean devam = true;

		while (devam) {
			try {

				System.out.printf("\nBir sayi girin > ");
				int s = veri.nextInt();
				System.out.printf("\nBolen girin > ");
				int b = veri.nextInt();

				Double bolum = bolme(s, b);

				if (bolum.isInfinite())
					throw new ArithmeticException();

				String sayi = Double.toString(bolme(s, b));
				System.out.println("Sonuc : " + sayi);
				devam = false;

			} catch (Exception e1) {

				if (e1 instanceof InputMismatchException)
					System.err.printf("\nSadece sayi girin : %s\n", e1);

				if (e1 instanceof ArithmeticException)
					System.err.printf("\nSifira bolunemez : %s\n", e1);

				veri.nextLine();
				System.out.printf("\nTekrar giris yapiniz...\n");

			}
		} // end while

		veri.close();

	} // end main()

} // end class
