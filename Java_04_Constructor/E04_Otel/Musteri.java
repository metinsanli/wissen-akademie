package E04_Otel;

public class Musteri {
	int musteriId, gunSayisi = 1;
	String musteriAdi, tcKimlik, telNo;

	public Musteri() {

	} // end constructor DEFAULT Musteri()

	public Musteri(int musteriId, String musteriAdi, String tcKimlik, String telNo, int gunSayisi) {
		this.musteriId = musteriId;
		this.musteriAdi = musteriAdi;
		this.tcKimlik = tcKimlik;
		this.telNo = telNo;
		this.gunSayisi = gunSayisi;
	} // end constructor Musteri()

} // end class