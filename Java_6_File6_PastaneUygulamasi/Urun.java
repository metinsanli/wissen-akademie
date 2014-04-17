import java.io.File;

public class Urun {

	private static File dosyaUrun = new File("./src/Urun.txt");
	public static String kod, ad;
	private static double fiyat, maliyet;
	private static String[][] recete; // []KOD, []MIKTAR

	public Urun() throws Exception {
	} // end constructor DEFAULT

	public void sec(String urunKodu) throws Exception {
		String[] satir = Dosya.bulGetir(dosyaUrun, 0, urunKodu).split("\t");
		kod = satir[0];
		ad = satir[1];
		fiyat = Double.parseDouble(Uygulama.formatla(satir[2]));
		// recete secilecek !!!
		String[] birinci = satir[4].split(" ");
		recete = new String[birinci.length][2];
		for (int i = 0; i < birinci.length; i++) {
			String[] ikinci = birinci[i].split("-");
			recete[i][0] = ikinci[0];
			recete[i][1] = ikinci[1];
		}
	} // end method sec()

	public void listele() throws Exception {
		System.out.printf("\n---- %s ----\n", "URUN LISTESI");
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s", "KOD", "AD", "FIYAT", "DURUM", "MALZEMELER");
		System.out.printf("\n%-13s%-13s%-13s%-13s%-13s", "---", "--", "-----", "-----", "----------");
		Dosya.listele(dosyaUrun, 3, "AKTIF");
		System.out.printf("\n");
	}// end method listele()

	public void ekle() throws Exception {
		listele();
		Malzeme malzeme = new Malzeme();
		StringBuilder tmp = new StringBuilder();
		System.out.printf("\n#### %s ####\n", "URUN TANIMLA");
		System.out.printf("\n%-10s> ", "Kodu");
		kod = Uygulama.klavye().toUpperCase();
		System.out.printf("%-10s> ", "Adi");
		ad = Uygulama.klavye().toUpperCase();
		System.out.printf("%-10s> ", "Fiyati");
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
				tmp.append(" ");
			tmp.append(temp1);
			malzeme.sec(temp1);
			System.out.printf("%-17s> ", "Malzeme miktari");
			String temp2 = Uygulama.klavye();
			tmp.append("-" + temp2);
			sayac++;
			System.out.printf("%s eklendi. Bitirmek icin Malzeme koduna \"0\" giriniz.", malzeme.ad);
			System.out.printf("\n\"%s\"", tmp.toString());
		} while (true);
		Dosya.satirEkle(dosyaUrun, (kod + "\t" + ad + "\t" + Uygulama.formatla(fiyat) + "\tAKTIF" + "\t" + tmp.toString()));
		System.out.printf("\n%s urun kaydi olusturuldu.\n", ad);
	} // end method ekle()

	public void sat() throws Exception {
		listele();
		System.out.printf("\nUrun secin > ");
		sec(Uygulama.klavye());
		System.out.printf("\n%s secildi.\n", ad);
		Malzeme malzeme = new Malzeme();
		// malzemelerin miktarlari yeterlimi bak! gelecek
		do {
			boolean malzDrm = true;
			for (int k = 0; k < recete.length; k++) {
				if (!malzeme.yeterlimi(Uygulama.formatla(recete[k][0]), Double.parseDouble(Uygulama.formatla(recete[k][1]))))
					malzDrm = false;
			}
			System.out.printf("\n");
			if (malzDrm) {
				for (int i = 0; i < recete.length; i++) {
					malzeme.sec(recete[i][0]);
					malzeme.miktarAzalt(Double.parseDouble(recete[i][1]));
					maliyet += malzeme.fiyat;
				}
				System.out.printf("\n%s %s TL ye mal edildi.\n", ad, Uygulama.formatla(maliyet));
			}
			break;
		} while (true);
	} // end method sat()

} // end class