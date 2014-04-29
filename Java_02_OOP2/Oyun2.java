public class Oyun2 {

	public static void main(String[] args) {

		Oyuncu oyuncu1 = new Oyuncu();
		Oyuncu oyuncu2 = new Oyuncu();

		oyuncu1.isimAl("Metin", 29);
		oyuncu2.isimAl("Sercan", 25);

		for (int i = 0; i < 5; i++) {

			oyuncu1.zar.zarAt();
			oyuncu2.zar.zarAt();

			oyuncu1.skor += oyuncu1.zar.deger;
			oyuncu2.skor += oyuncu2.zar.deger;

		} // end for

		System.out.printf("\n%s icin skor = %d\n", oyuncu1.adi, oyuncu1.skor);
		System.out.printf("\n%s icin skor = %d\n", oyuncu2.adi, oyuncu2.skor);

	} // end main

} // end class