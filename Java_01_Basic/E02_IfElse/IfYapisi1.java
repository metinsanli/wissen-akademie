package E02_IfElse;
import java.util.Scanner;

public class IfYapisi1 {
	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		int sayi1, sayi2;

		System.out.printf("Ilk sayiyi girin\t: ");
		sayi1 = veri.nextInt();

		System.out.printf("Ikinci sayiyi girin\t :");
		sayi2 = veri.nextInt();

		if (sayi1 == sayi2)
			System.out.printf("%d == %d\n", sayi1, sayi2);

		if (sayi1 != sayi2)
			System.out.printf("%d != %d\n", sayi1, sayi2);

		if (sayi1 < sayi2)
			System.out.printf("%d < %d\n", sayi1, sayi2);

		if (sayi1 > sayi2)
			System.out.printf("%d > %d\n", sayi1, sayi2);

		if (sayi1 <= sayi2)
			System.out.printf("%d <= %d\n", sayi1, sayi2);

		if (sayi1 >= sayi2)
			System.out.printf("%d >= %d\n", sayi1, sayi2);

		veri.close();

	}
}
