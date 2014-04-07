import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Arac {
	static String plaka, model;
	static double km;
	static File dosya = new File("./src/Arac.txt");
	// KLAVYEDEN GIRIS
	static InputStreamReader klavye = new InputStreamReader(System.in);
	static BufferedReader giris = new BufferedReader(klavye);

	public static void olustur() throws Exception {
		// Scanner yerine InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in, "Cp1254");
		BufferedReader giris = new BufferedReader(isr);
		// Dosya yazma
		OutputStream yaz = new FileOutputStream(dosya, true);
		OutputStreamWriter out = new OutputStreamWriter(yaz, "Cp1254");
		BufferedWriter bufWriter = new BufferedWriter(out);
		// Bilgileri iste
		System.out.printf("\n#### YENI ARAC KAYIT ####\n");
		System.out.printf("\nModel\t: ");
		model = giris.readLine();
		System.out.printf("\nPlaka\t: ");
		plaka = giris.readLine().toUpperCase();
		System.out.printf("\nDepar.\t: ");
		// Dosyaya yaz
		bufWriter.write(plaka + "\t" + model + "\t" + km);
		bufWriter.newLine();
		bufWriter.close();
	} // end method olustur()

	public static void listele() throws Exception {
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String satir, satirlar[];
		System.out.printf("\n%-20s%-20s%-20s", "PLAKA", "MODEL", "KM");
		System.out.printf("\n%-20s%-20s%-20s", "-----------------", "-----------------", "-----------------");
		while ((satir = bufReader.readLine()) != null) {
			satirlar = satir.split("\t");
			System.out.printf("\n%-20s%-20s%-10s", satirlar[0], satirlar[1], satirlar[2]);
		}
		bufReader.close();
	} // end method listele()

	public static String sec() throws Exception {
		// DOSYAYI AC
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		// METHOD ICIN DEGISKENLER
		String secim = null, satir, satirlar[];
		Boolean bulundu = false;
		// GOVDE
		while (secim == null) {
			System.out.printf("\n\nPlaka girin (Iptal=0) > ");
			secim = giris.readLine();
			if (secim.equals("0")) {
				secim = null;
				bulundu = true;
				break;
			} // end if
			while ((satir = bufReader.readLine()) != null) {
				satirlar = satir.split("\t");
				if (satirlar[0].equalsIgnoreCase(secim)) {
					bulundu = true;
					break;
				} // end if
			} // end ic while
		} // end dis while
		if (!bulundu)
			secim = null;
		bufReader.close();
		return secim;
	} // end method aracSec()

} // end class