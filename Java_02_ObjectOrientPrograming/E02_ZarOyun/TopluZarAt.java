package E02_ZarOyun;
public class TopluZarAt {

	public static void main(String[] args) {

		Zar[] zarlar = new Zar[6];

		for (int i = 0; i < zarlar.length; i++) {

			// �nemli!
			zarlar[i] = new Zar();
			// new ile baslatilmazsa NullPointerException hatasi verir.

			zarlar[i].zarAt();
			System.out.println(zarlar[i].deger);
			
		} // end for

	} // end main

} // end class