package E04_WhileDongusu;
import java.util.Scanner;

public class WhileYapisi7UcgenDaireKare {
	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		int secim = 5;
		double deg1 = 0, deg2 = 0;

		while (secim != 0) {

			switch (secim) {
			case 1:
				System.out.printf("\n* Ucgen Alani Hesaplama Secildi.\n\nTaban Uzunlugu girin\t> ");
				deg1 = veri.nextDouble();
				System.out.printf("Yukseklik girin\t\t> ");
				deg2 = veri.nextDouble();
				System.out.println("Ucgen Alani = " + ((deg1 * deg2) / 2));
				break;

			case 2:
				System.out.printf("\n* Daire Alani Hesaplama Secildi.\n\nPi degerini girin\t> ");
				deg1 = veri.nextDouble();
				System.out.printf("Yaricap girin\t\t> ");
				deg2 = veri.nextDouble();
				System.out.println("Daire Alani = " + (2 * (deg1 * deg2)));
				secim = 10;
				break;

			case 3:
				System.out.printf("\n* Kare Alani Hesaplama Secildi.\n\n1. Kenar uzunlugunu girin\t> ");
				deg1 = veri.nextDouble();
				System.out.printf("2. Kenar uzunlugunu girin\t\t> ");
				deg2 = veri.nextDouble();
				System.out.println("Kare Alani = " + (deg1 * deg2));
				break;
			} // end switch

			System.out.printf("\n*** ALAN HESAPLAMA ***\n\nUcgen (1)\nDaire (2)\nKare  (3)\nCikis (0)\n\nLutfen seciminizi girin > ");
			secim = veri.nextInt();
		} // end while

		veri.close();
	} // end main
} // end class