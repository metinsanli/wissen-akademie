package E02_ZarOyun;
public class Oyun3 {

	public static void main(String[] args) {

		Oyuncu oyuncu1 = new Oyuncu();
		Oyuncu oyuncu2 = new Oyuncu();

		oyuncu1.isimAl("Metin", 30);
		oyuncu2.isimAl(); 

		oyuncu1.zarSalla(5);
		oyuncu2.zarSalla(6);

		System.out.printf("\n%s icin skor = %d\n", oyuncu1.adi, oyuncu1.skor);
		System.out.printf("\n%s icin skor = %d\n", oyuncu2.adi, oyuncu2.skor);

	} // end main

} // end class