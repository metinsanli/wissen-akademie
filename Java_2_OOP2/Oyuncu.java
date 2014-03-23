public class Oyuncu {
	public String adi;
	public int skor;
	public int yas;
	public Zar zar = new Zar(); // eger new ile baslatilmazsa eclipse hata
								// vermez fakat runtimeda NullPointerException
								// hatasi alinir.

	public void isimAl(String isim, int yas) {
		this.adi = isim;
		this.yas = yas;
	} // end isimAl()

	public void isimAl() {
		this.adi = "Sercan";
		this.yas = 26;
	} // end isimAl()

	public void zarSalla(int sallamaSayisi) {
		for (int i = 0; i < sallamaSayisi; i++)
			this.skor += zar.zarAt();
	} // end zarSalla()

} // end class