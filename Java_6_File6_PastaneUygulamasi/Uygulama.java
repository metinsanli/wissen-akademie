import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uygulama {

	public static void main(String[] args) throws Exception {
		// Malzeme malzeme2 = new Malzeme("M03", "Soda", 2.3, 30, "Lt");
		Malzeme malzeme = new Malzeme();
		Urun urun = new Urun();
		// malzeme.sec("M01");
		// System.out.println(malzeme.ad);
		// malzeme.sec("M02");
		// System.out.println(malzeme.ad);
		// malzeme.listele();
		urun.ekle();
		// malzeme.ekle();

	} // end main()

	public static String klavye() throws Exception {
		InputStreamReader veri = new InputStreamReader(System.in, "Cp1254");
		BufferedReader giris = new BufferedReader(veri);
		return giris.readLine();
	} // end method klavye()

	public static String formatla(double deger) {
		return String.valueOf(String.format("%.2f", deger).replace(",", "."));
	} // end method formatla()

	public static String formatla(String deger) {
		return deger.replace(",", ".");
	} // end method formatla()

} // end class