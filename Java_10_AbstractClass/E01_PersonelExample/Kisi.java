package E01_PersonelExample;

public class Kisi extends Personel {

	@Override
	public void sicilNoVer(int sicil) {
		sicilNo = sicil;
	}

	@Override
	public void soyAdVer(String soyad) {
		soyAd = soyad;
	}

	@Override
	public void adVer(String ad) {
		this.ad = ad;
	}

	@Override
	public double ucretHesapla() {
		return 3 * 1234;
	}

	@Override
	public String ara() {
		return "BULUNAMADI";
	}
	
} // end class
