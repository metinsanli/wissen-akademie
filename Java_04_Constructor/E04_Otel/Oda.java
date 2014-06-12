package E04_Otel;

public class Oda {
	public int odaNo = 1, musteriId, yatakSayisi = 1;
	public boolean denizDag = false, doluBos = true, temizKirli = true;
	public double odaUcreti = 50;
	public Musteri[] musteri;

	public Oda() {

	} // end constructor DEFAULT

	public Oda(int odaNo, int musteriId) {
		this.odaNo = odaNo;
		this.musteriId = musteriId;
		this.temizKirli = true;
		this.doluBos = true;
		if ((odaNo % 2) == 0) {
			this.denizDag = true;
			this.odaUcreti = 100.0;
			this.yatakSayisi = 2;
			musteri = new Musteri[2];
			musteri[0] = new Musteri();
			musteri[1] = new Musteri();
		} else {
			musteri = new Musteri[1];
			musteri[0] = new Musteri();
		}
	}// end constructor Oda()

} // end class