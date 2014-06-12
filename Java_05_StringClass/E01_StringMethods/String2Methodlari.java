package E01_StringMethods;

/**
 * String sinifinin methodlarida vardir getChars, charAt, length
 * 
 */

public class String2Methodlari {

	public static void main(String[] args) {
		String s1 = "hello there";
		char[] karakterDizisi = new char[s1.length()];

		System.out.printf("s1 = %s\ns1'in uzunlugu = %d", s1, s1.length());

		// length methodu s1 String degiskeninin uzunlugunu verir.
		System.out.printf("\nkarakterDizisi uzunlugu = %d", karakterDizisi.length);

		// charAt() s1 degiskeninin sayac ile belirtilen sirasindaki karakteri
		// verir.
		System.out.printf("\ns1'in tersten yazilisi : ");
		for (int sayac = karakterDizisi.length - 1; sayac >= 0; sayac--)
			System.out.printf("%c", s1.charAt(sayac));

		// getChars
		s1.getChars(0, 5, karakterDizisi, 0);
		System.out.printf("\nkarakterDizisi = ");
		for (char karakter : karakterDizisi)
			System.out.print(karakter);

	} // end main()

} // end class 
