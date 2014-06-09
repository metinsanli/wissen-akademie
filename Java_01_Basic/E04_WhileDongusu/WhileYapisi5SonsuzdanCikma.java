package E04_WhileDongusu;
import java.util.Scanner;

public class WhileYapisi5SonsuzdanCikma {
	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		int sayi = 0;

		while (true) {
			System.out.print("Lutfen 5-10 arasinda bir sayi giriniz : ");
			sayi = veri.nextInt();
			if (sayi >= 5 && sayi <= 10) {
				System.out.println("tamam. Girilen deger dogru !");
				break;
			}
		}
		veri.close();
	}
}
