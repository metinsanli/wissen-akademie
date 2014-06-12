package E02_Futbol;

import java.util.Random;

public class Kulup {

	// SINIF DEGISKENLERI
	final static int KADRO = 11;
	public String kulupAdi;
	public String sehir;
	public int skor, puan, atGol, yedGol;
	public Futbolcu[] oyuncu = new Futbolcu[KADRO];
	public static Random gol = new Random();

	public Kulup() {
		for (int i = 0; i < KADRO; i++)
			oyuncu[i] = new Futbolcu();
		System.out.println("Bir takim nesnesi olusturuldu!");
	} // end constructor Klup() DEFAULT

	public Kulup(String klupAdi, String sehir) {
		// this();
		this.kulupAdi = klupAdi;
		this.sehir = sehir;
	} // end constructor Kulup(String,String)

	public Kulup(String kulupAdi, int puan, int atGol, int yedGol) {
		this.kulupAdi = kulupAdi;
		this.puan = puan;
		this.atGol = atGol;
		this.yedGol = yedGol;
	}

	public void kulupOyunculariniYazdir() {
		System.out.printf("\n\nTAKIM ADI : %s\tSEHIR : %s\n", kulupAdi, sehir);
		Futbolcu.baslikGetir();
		for (int i = 0; i < oyuncu.length; i++)
			oyuncu[i].oyuncuBilgileriniYazdir();

	}// end method kulupOyunculariniYazdir()

	public void kulupMacYaptir() {
		for (int i = 0; i < oyuncu.length; i++)
			oyuncu[i].futbolcuMacYaptir();
	} // end method kulupMacYaptir()

	public void kulupAntrenmanYaptir() {
		for (int i = 0; i < oyuncu.length; i++)
			oyuncu[i].futbolcuAntrenmanYaptir();
	} // end method kulupAntrenmanYaptir()

	public void gol() {
		this.skor = gol.nextInt(5);
		this.atGol += this.skor;
	}

} // end class