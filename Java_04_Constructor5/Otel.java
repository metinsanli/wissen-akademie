public class Otel {
	public String otelAdi, telNo, sehir;
	public Oda[] oda;

	public Otel(String otelAdi, String sehir, String telNo, int odaSayisi) {
		this.otelAdi = otelAdi;
		this.sehir = sehir;
		this.telNo = telNo;
		// Resepsiyonda olusturulan otelin odaSayisi kadar oda olusturuluyor
		oda = new Oda[odaSayisi];
		for (int i = 0; i < odaSayisi; i++)
			oda[i] = new Oda(i + 1, 0);

	} // end class Otel()

} // end class