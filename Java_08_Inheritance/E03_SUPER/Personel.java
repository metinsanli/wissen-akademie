package E03_SUPER;

@SuppressWarnings("unused")
public class Personel {

	protected String ad;
	protected String soyad;
	public String tcKimlik;
	private Double sabitMaas;

	public Personel() {
	}

	public Personel(String persAd, String persSoyad, double sabitMaas) {
		this.ad = persAd;
		this.soyad = persSoyad;
		this.sabitMaas = sabitMaas;
	}

}
