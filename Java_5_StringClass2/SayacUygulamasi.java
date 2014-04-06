import java.util.Scanner;

public class SayacUygulamasi {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);

		System.out.printf("Lutfen bir cumle girin > \n");

		Kelime metin = new Kelime(veri.nextLine().split(" "));

		System.out.println(metin.kelimeToplamAdet);

		veri.close();
	}

}