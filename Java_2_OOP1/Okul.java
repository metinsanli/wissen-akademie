public class Okul {

	public static void main(String[] args) {

		Ogrenci ogrenci1 = new Ogrenci(); // ogrenci1 nesnesi yaratildi
		Ogrenci ogrenci2;
		ogrenci2 = new Ogrenci();
		Ogrenci ogrenci3 = new Ogrenci();

		ogrenci1.ogrenciAdi = "Volkan Sezgin";
		//ogrenci1.notAl();

		ogrenci2.ogrenciAdi = "Selim Ileri";
		//ogrenci2.notAl();

		ogrenci3.tanimla("Metin Sanli", 127, 75, 85);
		// ogrenci3: tanimla() metoduyla isim, not1 ve not2 parametreleri
		// gonderilerek yaratildi.

		//System.out.printf("\n%s icin not ortalamasi = %.2f", ogrenci1.ogrenciAdi, ogrenci1.ortalama());
		//System.out.printf("\n%s icin not ortalamasi = %.2f", ogrenci2.ogrenciAdi, ogrenci2.ortalama());
		//System.out.printf("\n%s icin not ortalamasi = %.2f", ogrenci3.ogrenciAdi, ogrenci3.ortalama());

		//
		System.out.println();
		//

		//System.out.printf("\n%.2f", ogrenci1.ortalama(2));
		//System.out.printf("\n%.2f", ogrenci2.ortalama(100, 65));
		//System.out.printf("\n%.1f", ogrenci3.ortalama(3));

	} // end main

} // end class