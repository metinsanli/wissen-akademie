public class Uygulama {

	public static void main(String[] args) {

		Personel m = new Kisi();
		Kisi k;

		k = (Kisi) m; // fazladan type cast yapildi.

		k.sicilNoVer(123);
		k.adVer("Demet");
		k.soyAdVer("Beyaz");

		System.out.println(k.sicilNo);
		System.out.println(k.ad);
		System.out.println(k.soyAd);
		System.out.println(k.ucretHesapla());

		System.out.println(k.guncelle());
		System.out.println(k.ekle());
		System.out.println(k.sil());
		System.out.println(k.ara());

	} // end main()

} // end class
