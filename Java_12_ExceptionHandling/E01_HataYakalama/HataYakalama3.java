package E01_HataYakalama;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HataYakalama3 {

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

			} catch (InputMismatchException veriGirisHatasi) {

				System.err.printf("\nHata olustu : %s\n", veriGirisHatasi);
				veri.nextLine();
				System.out.printf("\nBir sayi girmelisiniz! Tekrar giris yapiniz...\n");

			} catch (ArithmeticException islemHatasi) {

				System.err.printf("\nIslem hatasi olustu : %s\n", islemHatasi);
				veri.nextLine();
				System.out.printf("\nSifira bolum hatasi olustu. Tekrar giris yapiniz...\n");

			}
		}

		veri.close();

	} // end main()

} // end class
