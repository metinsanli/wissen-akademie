import java.util.Locale;

public class Personel {

	protected String ad;
	protected String soyad;
	public String tcKimlik;
	private Double sabitMaas = 0.0;

	public Personel() {

	} // end constructor DEFAULT

	public Personel(String persAd, String persSoyad, double persMaas) {
		this.ad = persAd;
		this.soyad = persSoyad;
		this.sabitMaas = persMaas;
	} // end constructor

	public void setAd(String personelAd) {
		StringBuilder isim = new StringBuilder(personelAd.trim());
		if (isim.length() == 0)
			System.out.println("uzunluk sifi! isim bos olamaz. Atama yapilmayacak!");
		else {
			for (int i = 0; i < isim.length(); i++) {
				if (i == 0)
					isim.setCharAt(i, Character.toUpperCase(isim.charAt(i)));
				else
					isim.setCharAt(i, Character.toLowerCase(isim.charAt(i)));
			}
			this.ad = isim.toString();
		}
	} // end method setAd()

	public String getAd() {
		return this.ad;
	} // end method getAd()

	public void setSoyad(String personelSoyad) {
		personelSoyad = personelSoyad.trim();
		if (personelSoyad.length() == 0)
			System.out.println("uzunluk sifir! Soyad bos olamaz. Atama yapilmayacak!");
		else {
			this.soyad = personelSoyad.toUpperCase(new Locale("TR"));
		}
	} // end method setSoyad()

	public String getSoyad() {
		return soyad;
	} // end method getSoyad()

	final public void setMaas(double maas) {
		sabitMaas = maas;
	} // end method setMaas()

	public double getMass() {
		return sabitMaas;
	} // end method getMass()

	public double hakEdis() {
		System.out.println("Personel Hakedis : ");
		return sabitMaas;
	} // end method hakEdis()

} // end class
