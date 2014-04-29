import java.util.Scanner;
import java.util.Random;

public class IfYapisi9SayiBulmaOyunu {
	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		int tahminEt, uretilenSayi, fark;
		Random uretec = new Random();

		System.out.print("1..10 arasindaki tahminin? :> ");
		tahminEt = veri.nextInt();
		uretilenSayi = uretec.nextInt(11);

		fark = Math.abs(tahminEt - uretilenSayi);

		if (fark == 0)
			System.out.println("Tebrikler Bildiniz!!!");
		if (fark == 1)
			System.out.println("Tuh!!!");
		if (fark == 2)
			System.out.println("Eh iste...");
		if (fark == 3)
			System.out.println("Az kaldi...");
		if (fark > 3)
			System.out.println("Bilemediniz :)");

		System.out.printf("Uretilen sayi %d", uretilenSayi);
		veri.close();

	}
}
