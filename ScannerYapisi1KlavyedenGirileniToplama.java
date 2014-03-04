// Scanner (Klavyeden veri okumak) icin import kullanilmali 
import java.util.Scanner;

public class ScannerYapisi1KlavyedenGirileniToplama {
	public static void main(String[] args) {
		// Scanner sýnýfýnda "input" degiskeni tanimlandi
		Scanner input = new Scanner(System.in);
		// maematik islemi icin diger degiskenler tanimlandi
		int number1;
		int number2;
		int sum;
		// ilk sayi girisi
		System.out.print("Ilk sayiyi girin : ");
		number1 = input.nextInt();
		// ikinci sayi girisi
		System.out.print("Ikinci sayiyi girin : ");
		number2 = input.nextInt();
		// toplama islemi
		sum = number1 + number2;
		// sonuc goruntuleme
		System.out.printf("Toplam = %d\n", sum);

		input.close();

	}// end main
} // end class
