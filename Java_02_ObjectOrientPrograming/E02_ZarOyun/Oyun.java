package E02_ZarOyun;
public class Oyun {

	public static void main(String[] args) {

		Zar zar1 = new Zar();
		Zar zar2 = new Zar();

		Oyuncu isim1 = new Oyuncu();
		Oyuncu isim2 = new Oyuncu();
		zar1.zarAt();
		zar2.zarAt();

		isim1.isimAl("Metin", 4);
		isim2.isimAl("Sercan", 5);

		// Zar sinifi icindeki -deger- sinif degiskenine "Mavi" degeri
		// gonderiliyor.
		zar1.renkAta("Mavi");
		// Zar sinifi icindeki -deger- sinif degiskenine "Beyaz" degeri
		// gonderiliyor.
		zar2.renkAta("Beyaz");

		System.out.printf("\nZar 1 : %d %s", zar1.deger, zar1.renk);
		System.out.printf("\nZar 2 : %d %s", zar2.deger, zar2.renk);

	} // end main

} // end class