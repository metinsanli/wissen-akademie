import java.util.Scanner;

public class Araba {
	// STATIC SINIF DEGISKENLER
	public static double benzinLF = 5.1; // treu
	public static double dizelLF = 4.6; // false

	// SINIF DEGISKENLERI
	Scanner veri = new Scanner(System.in);
	public String marka, plaka, renk;
	double motorHacmi, km, yakitMiktari, yakitDeposuMax, gunlukKira, yakitTuketim, litreFiyat;
	public boolean vites; // true=manuel false=otomatik
	public String yakitTuru, vitesTuru;
	public int sahipIndis;

	@SuppressWarnings("static-access")
	public Araba(String marka, double motorHacmi, String plaka, String renk, double km, double yakitMiktari, double yakitDeposuMax, double gunlukKira, double yakitTuketim, boolean yakitTuru, boolean vites, int sahip) {
		this.marka = marka;
		this.motorHacmi = motorHacmi;
		this.plaka = plaka;
		this.renk = renk;
		this.km = km;
		this.yakitMiktari = yakitMiktari;
		this.yakitDeposuMax = yakitDeposuMax;
		this.gunlukKira = gunlukKira;
		this.yakitTuketim = yakitTuketim;
		if (yakitTuru) {
			this.litreFiyat = this.benzinLF;
			this.yakitTuru = "Benzin";
		} else {
			this.litreFiyat = this.dizelLF;
			this.yakitTuru = "Dizel";
		}
		if (vites) {
			this.vitesTuru = "MAN";
		} else {
			this.vitesTuru = "OTO";
		}
		this.sahipIndis = sahip;
	} // end constructor (...)

	public Araba() {
		// TODO Auto-generated constructor stub
	}

	public void arabaSur() {
		double kacKm;
		System.out.printf("\nArabaniz %s kac km yol gidilecek > ", marka);
		kacKm = veri.nextDouble();
		km += kacKm;
		double masraf = ((kacKm * yakitTuketim) / 100) * litreFiyat;
		System.out.println(masraf + " TL.");
	} // end method arabaSur()

	public void yakitAl() {
		double kacLitre = 0;
		System.out.printf("\n%s deposunda %.2f Litre benzin var.", marka, yakitMiktari);
		while (yakitMiktari < yakitDeposuMax) {
			System.out.printf("\nKac Litre benzin alinacak (en fazla = %.2f lt.) > ", Math.abs(yakitDeposuMax - yakitMiktari));
			kacLitre = veri.nextDouble();
			if (yakitDeposuMax > yakitMiktari + kacLitre) {
				yakitMiktari += kacLitre;
				break;
			}
		}
	} // end method yakitAl()

} // end class