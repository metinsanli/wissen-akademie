package E04_WhileDongusu;
import java.util.Scanner;

public class WhileYapisi4WithoutBreak {
	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		int sayi = 0;

		while (!(sayi >= 5 && sayi <= 10)) {
			System.out.print("5 ile 10 arasi bir sayi giriniz : ");
			sayi = veri.nextInt();
		} // end while
		veri.close();
	} // end main
} // end class