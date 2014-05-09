import java.io.Serializable;

@SuppressWarnings("all")
public class Personel implements Serializable {

	private String tc, adSoyad, meslek, telefon, sehir;

	public Personel(String tc, String adSoyad, String meslek, String telefon, String sehir) {
		setTc(tc);
		setAdSoyad(adSoyad);
		setMeslek(meslek);
		setTelefon(telefon);
		setSehir(sehir);
	} // end constructor

	public Personel(String[] personelBilgileri) {
		setTc(personelBilgileri[0]);
		setAdSoyad(personelBilgileri[1]);
		setMeslek(personelBilgileri[2]);
		setTelefon(personelBilgileri[3]);
		setSehir(personelBilgileri[4]);
	}// end constructor

	public String[] getAll() {
		String[] tmp = { getTc(), getAdSoyad(), getMeslek(), getTelefon(), getSehir() };
		return tmp;
	} // end method getAll()

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getMeslek() {
		return meslek;
	}

	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

} // END CLASS