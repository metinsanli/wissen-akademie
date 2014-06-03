package E6_StackClass;

import java.util.Stack;

@SuppressWarnings("all")
public class StackExample {

	public class Kitap { // INNER CLASS

		String adi;
		String yazar;
		int sayfaSayisi;

		public Kitap(String ad, String yazar, int sayfa) {
			this.adi = ad;
			this.yazar = yazar;
			this.sayfaSayisi = sayfa;
		} // end constructor

	} // END INNER CLASS

	Stack<Kitap> masadakiKitaplar = new Stack<>(); // sinif degiskeni

	public StackExample() {
		masadakiKitaplar.push(new Kitap("Hanzi", "Guasto Poncho", 600));
		masadakiKitaplar.push(new Kitap("Simyaci", "Paulo Coelho", 500));
		masadakiKitaplar.push(new Kitap("Java", "Volkan Sezgin", 650));
		masadakiKitaplar.push(new Kitap("SQL", "George Sql", 1200));

		System.out.println("Masadaki Kitaplar yigininin asagidan yukariya listesi :");
		for (Kitap temp : masadakiKitaplar)
			System.out.printf("%s\t%s\t%d\n", temp.adi, temp.yazar, temp.sayfaSayisi);

		System.out.printf("\nEn ustteki kitap adi : %s\n", masadakiKitaplar.peek().adi);

		System.out.println("En son eklenen bir tane kitabi aliyoruz! (pop() calistirildi!)");
		masadakiKitaplar.pop(); // en son eklenen kitap silindi.

		System.out.printf("\n%s", "Kalan kitaplar : ");
		Object kitap;
		for (int i = masadakiKitaplar.size() - 1; i >= 0; i--) {
			Kitap ktp = masadakiKitaplar.get(i);
			System.out.printf("\n%s\t%s\t%d", ktp.adi, ktp.yazar, ktp.sayfaSayisi);
		}
	} // end constructor

	public static void main(String[] args) {
		new StackExample();
	} // end method main()

} // END CLASS
