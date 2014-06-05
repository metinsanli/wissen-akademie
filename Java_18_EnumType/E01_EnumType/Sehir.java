package E01_EnumType;
@SuppressWarnings("all")
public class Sehir {

	String adi;
	Bolge bolge;
	int nufus;

	public Sehir(String ad, Bolge b) {
		adi = ad;
		bolge = b;
	} // end constructor

	public String toString() {
		return adi;
	} // end method toString()

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public Bolge getBolge() {
		return bolge;
	}

	public void setBolge(Bolge bolge) {
		this.bolge = bolge;
	}

	public int getNufus() {
		return nufus;
	}

	public void setNufus(int nufus) {
		this.nufus = nufus;
	}

} // END CLASS
