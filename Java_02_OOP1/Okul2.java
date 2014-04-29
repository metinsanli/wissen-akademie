public class Okul2 {

	public static void main(String[] args) {

		Ogrenci ogrenci1 = new Ogrenci(); // ogrenci1 nesnesi yaratildi
		Ogrenci ogrenci2;
		ogrenci2 = new Ogrenci();
		Ogrenci ogrenci3 = new Ogrenci();

		ogrenci1.tanimla("Metin Sanli", 127, 75, 85);
		ogrenci2.tanimla("Volkan Sezgin", 165, 80, 86);
		ogrenci3.tanimla("Ali Veli", 198, 60, 100);

		ogrenci1.bilgiler();
		ogrenci2.bilgiler();
		ogrenci3.bilgiler();

	} // end main

} // end class