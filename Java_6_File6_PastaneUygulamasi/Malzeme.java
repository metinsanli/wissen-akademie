

public class Malzeme {

	private Dosya dosyaMalzeme = new Dosya("./src/Malzeme.txt");
	public String kod, ad, birim;
	public double fiyat, miktar;

	public Malzeme() throws Exception {
	} // end constructor DEFAULT

	public Malzeme(String kod, String ad, double fiyat, double miktar, String birim) throws Exception {
		dosyaMalzeme.satirEkle((kod + "\t" + ad + "\t" + Uygulama.formatla(fiyat) + "\t" + Uygulama.formatla(miktar) + "\t" + birim + "\tAKTIF"));
	} // end constructor

	public void sec(String malzemeKodu) throws Exception {
		String[] satir = dosyaMalzeme.bulGetir(0, malzemeKodu).split("\t");
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
		dosyaMalzeme.listele(5, "AKTIF");
		System.out.printf("\n");
	}// end method listele()

	public void ekle() throws Exception {
		do {
			listele();
			System.out.printf("\n#### %s ####\n", "MALZEME EKLE");
			System.out.printf("\n%-10s> ", "Kodu");
			kod = Uygulama.klavye().toUpperCase();
			// kod daha once girilmis mi?
			if (!dosyaMalzeme.bulGetir(0, kod).equals("")) {
				sec(kod);
				System.out.printf("%s secildi!\n", ad);
				System.out.printf("%-10s> ", "Miktari");
				miktar += Double.parseDouble(Uygulama.klavye());
				dosyaMalzeme.guncelle(kod, 3, Uygulama.formatla(miktar));
				System.out.printf("\n%s malzemesine yeni miktari %s %s oldu.\n", ad, Uygulama.formatla(miktar), birim);
				break;
			}
			System.out.printf("%-10s> ", "Adi");
			ad = Uygulama.klavye().toUpperCase();
			System.out.printf("%-10s> ", "Birimi");
			birim = Uygulama.klavye().toUpperCase();
			System.out.printf("%-10s> ", "Miktari");
			miktar = Double.parseDouble(Uygulama.klavye());
			System.out.printf("%-10s> ", "Fiyati");
			fiyat = Double.parseDouble(Uygulama.klavye());
			dosyaMalzeme.satirEkle(kod + "\t" + ad + "\t" + Uygulama.formatla(fiyat) + "\t" + Uygulama.formatla(miktar) + "\t" + birim + "\tAKTIF");
			System.out.printf("\n%s malzemesinin kayidi olusturuldu.\n", ad);
			break;
		} while (true);
	} // end method yeniEkle()

	public void sil() throws Exception {
		System.out.printf("\n#### %s ####\n", "MALZEME SIL");
		listele();
		System.out.printf("\n\n%-10s> ", "Kodu girin");
		sec(Uygulama.klavye().toUpperCase());
		dosyaMalzeme.satirSil(kod, 0);
		System.out.printf("\n%s malzemesi silindi.", ad);
	} // end method sil()

	public boolean miktarAzalt(double miktar) throws Exception {
		boolean mesaj = false;
		String[] satir = dosyaMalzeme.bulGetir(0, kod).split("\t");
		double mevcutMiktar = Double.valueOf(Uygulama.formatla(satir[3]));
		if (satir[0].equalsIgnoreCase(kod) && (mevcutMiktar - miktar) >= 0) {
			mevcutMiktar -= miktar;
			dosyaMalzeme.guncelle(kod, 3, Uygulama.formatla(mevcutMiktar));
			mesaj = true;
		}
		return mesaj;
	} // end method azalt()

	public boolean miktarArtir(double miktar) throws Exception {
		boolean mesaj = false;
		String[] satir = dosyaMalzeme.bulGetir(0, kod).split("\t");
		double mevcutMiktar = Double.valueOf(Uygulama.formatla(satir[3]));
		if (satir[0].equalsIgnoreCase(kod)) {
			mevcutMiktar += miktar;
			dosyaMalzeme.guncelle(kod, 3, Uygulama.formatla(mevcutMiktar));
			mesaj = true;
		}
		return mesaj;
	} // end method artir()

	public boolean yeterlimi(String malzemeKodu, double gerekenMiktar) throws Exception {
		boolean cevap = true;
		sec(malzemeKodu);
		if (miktar < gerekenMiktar) {
			System.out.printf("\n%s miktari az, gereken miktar %s %s.", ad, Uygulama.formatla(gerekenMiktar - miktar), birim);
			cevap = false;
		}
		return cevap;
	} // end method yeterlimi()

} // end class