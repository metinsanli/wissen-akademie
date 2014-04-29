
public class HesapMakinasi {

	public static void main(String[] args) {

		// Hesap sinifini referans olarak
		// islem1 nesnesini olusturuyouz.
		Hesap islem1 = new Hesap();
		Hesap islem2 = new Hesap();

		System.out.println(islem1.topla()); // 8
		System.out.println(islem2.topla()); // 8
		System.out.println(islem2.topla(100, 10)); // 110
		System.out.println(islem1.topla()); // 8
		System.out.println(islem2.topla()); // 444

	} // end main

} // end class