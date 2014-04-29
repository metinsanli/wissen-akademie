public class HesapMakinasi1 {

	public static void main(String[] args) {

		Hesap islem1 = new Hesap();
		Hesap islem2 = new Hesap(9, 9);

		System.out.println("1: " + islem1.topla());
		System.out.println("2: " + islem1.topla(4, 7));
		System.out.println("3: " + islem1.topla());

		// static ortak degisken st1
		System.out.println("4: " + islem1.st1);
		System.out.println("5: " + islem2.st1);

		// islem2 farkli bir nesne olarak yaratildi.
		System.out.println("6: " + islem2.topla());

		// tum referanslar tarafindan kullanilan
		// static st1 degiskeninin degerini degistiriyoruz
		Hesap.st1 = 333;  // direkt sinif uzerinden atama yapilabilir
		islem1.st1 = 334; // veya nesne uzerinden atama yapilabilir
		islem2.st1 = 335; // nesne uzerinden static degiskene atanan degerler
						  // tum nesnelerde atanan degerle kullanilir.

		islem1.pub1 = 222;
		islem2.pub1 = 444;

		System.out.println("7: " + islem1.st1);
		System.out.println("8: " + islem1.pub1);
		System.out.println("9: " + islem2.pub1);

	} // end main

} // end class