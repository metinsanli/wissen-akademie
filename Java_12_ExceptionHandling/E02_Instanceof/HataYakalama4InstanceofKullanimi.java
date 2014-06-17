package E02_Instanceof;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HataYakalama4InstanceofKullanimi {

	public static double bolme(int sayi, int bolen) {
		return sayi / bolen;
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
				System.out.println(bolme(s, b));
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
