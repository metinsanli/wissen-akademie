/* break : doWhile dongusunden cikmak icin.
 * continue : doWhile dongusunun basina donmek icin.
 * System.exit(0); : programin kontrollu ve veri kaybina
 * ugramadan kapatildigina dair sistem loglarina bilgi verir.
 */

import java.util.Scanner;

public class DoWhileYapisi2ContinueBreak {

	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		int N, adet = 0;

		do {
			System.out.print("Pozitif ve cift sayi girin >");
			N = veri.nextInt();
			if (N < 0) {
				System.out
						.println("Eksi bir deger girdiniz donguden cikiyorum..");
				break;
			} else if (N % 2 != 0) {
				System.out.println("Cift sayi girmediniz! saymiyorum..");
				continue;
			} else if (N == 2222) {
				System.out.println("Sihirli sayiyi girdiniz! Program Bitti!!");
				System.exit(0);
			}
			adet++;
			System.out.println("Kabul edilen sayi adedi = " + adet);
		} while (true); // end do-while

		System.out.printf("Bu ifade ancak \"break\" kullanilmis ise calisir.");
		veri.close();
	} // end main
} // end class
