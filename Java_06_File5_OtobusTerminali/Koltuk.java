public class Koltuk {
	int koltukNo;
	String pozisyon,sahip;

	public Koltuk(int koltukNo, String sahip) {
		this.koltukNo = koltukNo;
		this.sahip = sahip;
		if (koltukNo % 2 == 0)
			pozisyon = "K";
		else
			pozisyon = "C";
	} // end constructor

} // end class