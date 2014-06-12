package E02_Futbol;

public class Futbolcu {

	// SINIF DEGISKENLERI
	String isim, mevki;
	int formaNo, yas, lisansNo, performans;

	public Futbolcu() {

	} // end constructor Futbolcu() DEFAULT

	public Futbolcu(String isim, int formaNo, int lisansNo, int yas, String mevki, int performans) {
		this.isim = isim;
		this.lisansNo = lisansNo;
		this.yas = yas;
		this.formaNo = formaNo;
		this.mevki = mevki;
		this.performans = performans;
	}// end constructor Futbolcu(String,int,int,int,String)

	public Futbolcu(String isim, int formaNo) {
		this.isim = isim;
		this.formaNo = formaNo;
	}// end constructor Futbolcu(String,int)

	public void oyuncuBilgileriniYazdir() {
		System.out.printf("\n%-3d%-10s%-7s%-4d%-7d%-5d", formaNo, isim, mevki, yas, lisansNo, performans);
	} // end method oyuncuBilgileriniYazdir()

	public void futbolcuMacYaptir() {
		performans *= 0.75;
		if (performans < 0)
			performans = 0;
		if (performans > 100)
			performans = 100;
	} // end method futbolcuMacYaptir()

	public void futbolcuAntrenmanYaptir() {
		performans *= 1.12;
		if (performans < 0)
			performans = 0;
		if (performans > 100)
			performans = 100;
	} // end method futbolcuAntrenmanYaptir()

	public static void baslikGetir() {
		System.out.printf("\n%-3s%-10s%-7s%-4s%-7s%-5s", "No", "Isim", "Mevki", "Yas", "Lisans", "Perf.");
		System.out.format("\n%-3s%-10s%-7s%-4s%-7s%-5s", "--", "----", "-----", "---", "------", "-----");
	} // end method baslikGetir()

} // end class