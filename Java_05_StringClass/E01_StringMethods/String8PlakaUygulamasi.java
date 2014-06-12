package E01_StringMethods;

import java.util.Scanner;

public class String8PlakaUygulamasi {

	public static void main(String[] args) {

		int i = 0;
		String plaka="";
		Scanner veri = new Scanner(System.in);
		String[] iller = new String[81];

		while (i < 81) {
			String il = veri.nextLine();
			if (il == "bitti")
				break;
			iller[i] = il;
			i++;
		} // end while

		while (plaka.length() > 11 || plaka.length() < 7) {
			System.out.printf("\nLutfen plaka girin (uzunluk 7-11) > ");
			plaka = veri.nextLine();
		}// end while

		for (String il : iller) {
			if (plaka.substring(0, 2).equals(il.substring(0, 2)))
				System.out.printf("\n%s", il.substring(11));
		} // end for

		veri.close();
	} // end main()

} // end class