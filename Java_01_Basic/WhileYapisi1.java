import java.util.Scanner;

public class WhileYapisi1 {

	public static void main(String[] args) {
		Scanner giris = new Scanner(System.in);
		int sonraki;
		int sayac = 1;
		int toplam = 0;

		while (sayac <= 10) {
			System.out.print(sayac + ". sayiyi giriniz >");
			sonraki = giris.nextInt();
			if (sonraki == 0)
				break; // 0 girisi olursa donguden cikilacak
			toplam += sonraki;
			sayac++;
		} // end while

		System.out.println("Girilen sayilarin toplami = " + toplam);
		giris.close();

	}// end main
}// end class