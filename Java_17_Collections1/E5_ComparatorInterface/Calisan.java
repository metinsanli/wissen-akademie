package E5_ComparatorInterface;

@SuppressWarnings("all")
public class Calisan {

	private int yas;
	private String ad;

	public Calisan(String a, int y) {
		ad = a;
		yas = y;
	} // end constructor

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

} // END CLASS
