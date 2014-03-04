import java.util.Scanner;
import java.util.Random;

public class WhileYapisi2SayiBilmece {

	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		Random uretec = new Random();
		int puan = 100;
		int giris = 0;
		int sayi = uretec.nextInt(5);

		while (puan != 0) {
			System.out.printf("Puaniniz %d : Tahmin girin >", puan);
			giris = veri.nextInt();
			
			if (sayi == giris) {
				System.out.printf("%d Tebrikler bildiniz!! PUAN = %d\n", sayi,
						puan);
				break;
			} else {
				System.out.println("Malesef bilemediniz!");
				puan -= 25;
			}
		} // end while
		veri.close();
	} // end main
} // end class
