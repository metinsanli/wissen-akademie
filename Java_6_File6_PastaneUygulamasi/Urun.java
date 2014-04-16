import java.io.File;

public class Urun {

	private static File dosyaUrun = new File("./src/Urun.txt");
	private static String kod, ad;
	private static double fiyat;
	private static String[][] recete; // []KOD, []MIKTAR

	public Urun() throws Exception {
	} // end constructor DEFAULT

	public static void sec(String urunKodu) throws Exception {
		String[] satir = Dosya.bulGetir(dosyaUrun, 0, urunKodu).split("\t");
		kod = satir[0];
		ad = satir[1];
		fiyat = Double.parseDouble(Uygulama.formatla(satir[2]));

	} // end method sec()

	public void ekle() throws Exception {
		Malzeme malzeme = new Malzeme();
		StringBuilder tmpMalz = new StringBuilder();
		StringBuilder tmpMikt = new StringBuilder();
		System.out.printf("\n#### %s ####\n", "URUN EKLE");
		System.out.printf("\n%-10s> ", "Kodu");
		kod = Uygulama.klavye().toUpperCase();
		System.out.printf("\n%-10s> ", "Adi");
		ad = Uygulama.klavye().toUpperCase();
		System.out.printf("\n%-10s> ", "Fiyati");
		fiyat = Double.parseDouble(Uygulama.klavye());
		//
		malzeme.listele();
		int sayac = 0;
		do {
			System.out.printf("\n%-17s> ", "Malzeme kodu");
			String temp1 = Uygulama.klavye().toUpperCase();
			if (temp1.equals("0"))
				break;
			if (sayac != 0)
				tmpMalz.append("-");
			tmpMalz.append(temp1);
			malzeme.sec(temp1);
			System.out.printf("%-17s> ", "Malzeme miktari");
			String temp2 = Uygulama.klavye();
			if (sayac != 0)
				tmpMikt.append("-");
			tmpMikt.append(temp2);
			sayac++;
			System.out.printf("%s eklendi. Bitirmek icin Malzeme koduna \"0\" giriniz.", malzeme.ad);
		} while (true);
		Dosya.satirEkle(dosyaUrun, (kod + "\t" + ad + "\t" + Uygulama.formatla(fiyat) + "\t" + "\tAKTIF"));
		// System.out.printf("\n%s urun kaydi olusturuldu.", ad);

	} // end method ekle()

} // end class