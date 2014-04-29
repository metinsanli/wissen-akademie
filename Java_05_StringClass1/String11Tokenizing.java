import java.util.Scanner;

public class String11Tokenizing {

	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		System.out.printf("Lutfen bir cumle girip Enter'a basin > ");
		String cumle = veri.nextLine();

		String[] kelimeler = cumle.split(" ");
		System.out.printf("Kelime sayisi %d adet.\n\nKelimeler =\n", kelimeler.length);
		for (String i : kelimeler)
			System.out.println(i);
		veri.close();
	
	} // end main()

} // end class 