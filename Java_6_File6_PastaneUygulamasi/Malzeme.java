import java.io.File;

public class Malzeme {

	private static File dosyaMalzeme = new File("./src/Malzeme.txt");
	public static String kod, ad, birim;
	private static double fiyat, miktar;

	public Malzeme() throws Exception {
	} // end constructor DEFAULT

	public Malzeme(String kod, String ad, double fiyat, double miktar, String birim) throws Exception {
		Dosya.satirEkle(dosyaMalzeme,
				(kod + "\t" + ad + "\t" + Uygulama.formatla(fiyat) + "\t" + Uygulama.formatla(miktar) + "\t" + birim + "\tAKTIF"));
	} // end constructor

	public void sec(String malzemeKodu) throws Exception {
		String[] satir = Dosya.bulGetir(dosyaMalzeme, 0, malzemeKodu).split("\t");
		kod = satir[0];
		ad = satir[1];
		fiyat = Double.parseDouble(Uygulama.formatla(satir[2]));
		miktar = Double.parseDouble(Uygulama.formatla(satir[3]));
		birim = satir[4];
	} // end method sec()

	public void listele() throws Exception {
		System.out.printf("\n---- %s ----\n", "MALZEME LISTESI");
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s%-13s", "KOD", "AD", "FIYAT", "MIKTAR", "BIRIM", "DURUM");
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s%-13s", "---", "--", "-----", "------", "-----", "-----");
		Dosya.listele(dosyaMalzeme, 5, "AKTIF");
		System.out.printf("\n");
	}// end method listele()

	public void ekle() throws Exception {
		System.out.printf("\n#### %s ####\n", "MALZEME EKLE");
		System.out.printf("\n%-10s> ", "Kodu");
		kod = Uygulama.klavye().toUpperCase();
		System.out.printf("%-10s> ", "Adi");
		ad = Uygulama.klavye().toUpperCase();
		System.out.printf("%-10s> ", "Birimi");
		birim = Uygulama.klavye().toUpperCase();
		System.out.printf("%-10s> ", "Miktari");
		miktar = Double.parseDouble(Uygulama.klavye());
		System.out.printf("%-10s> ", "Fiyati");
		fiyat = Double.parseDouble(Uygulama.klavye());
		Dosya.satirEkle(dosyaMalzeme,
				(kod + "\t" + ad + "\t" + Uygulama.formatla(fiyat) + "\t" + Uygulama.formatla(miktar) + "\t" + birim + "\tAKTIF"));
		System.out.printf("\n%s malzemesinin kayidi olusturuldu.", ad);
	} // end method yeniEkle()

	public void sil() throws Exception {
		System.out.printf("\n#### %s ####\n", "MALZEME SIL");
		listele();
		System.out.printf("\n\n%-10s> ", "Kodu girin");
		sec(Uygulama.klavye().toUpperCase());
		Dosya.satirSil(dosyaMalzeme, kod, 0);
		System.out.printf("\n%s malzemesi silindi.", ad);
	} // end method sil()

	public boolean miktarAzalt(String kod, double miktar) throws Exception {
		boolean mesaj = false;
		String[] satir = Dosya.bulGetir(dosyaMalzeme, 0, kod).split("\t");
		double mevcutMiktar = Double.valueOf(Uygulama.formatla(satir[3]));
		if (satir[0].equalsIgnoreCase(kod) && (mevcutMiktar - miktar) >= 0) {
			mevcutMiktar -= miktar;
			Dosya.guncelle(dosyaMalzeme, kod, 3, Uygulama.formatla(mevcutMiktar));
			mesaj = true;
		}
		return mesaj;
	} // end method azalt()

	public boolean miktarArtir(String kod, double miktar) throws Exception {
		boolean mesaj = false;
		String[] satir = Dosya.bulGetir(dosyaMalzeme, 0, kod).split("\t");
		double mevcutMiktar = Double.valueOf(Uygulama.formatla(satir[3]));
		if (satir[0].equalsIgnoreCase(kod)) {
			mevcutMiktar += miktar;
			Dosya.guncelle(dosyaMalzeme, kod, 3, Uygulama.formatla(mevcutMiktar));
			mesaj = true;
		}
		return mesaj;
	} // end method artir()

} // end class