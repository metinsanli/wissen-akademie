public class Kulup {

	// SINIF DEGISKENLERI
	final static int KADRO = 11;
	public String kulupAdi;
	public String sehir;
	public Futbolcu[] oyuncu = new Futbolcu[KADRO];

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

} // end class