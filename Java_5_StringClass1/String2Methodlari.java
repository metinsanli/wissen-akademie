/**
 * String sinifinin methodlarida vardir getChars, charAt, length
 * 
 */

public class String2Methodlari {

	public static void main(String[] args) {
		String s1 = "hello there";
		char[] karakterDizisi = new char[5];

		System.out.printf("s1 = %s", s1);

		// length methodu s1 String degiskeninin uzunlugunu verir.
		System.out.printf("\ns1 dizi uzunlugu = %d", karakterDizisi.length);

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

	}

}
