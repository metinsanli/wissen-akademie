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
		// LISTELE
		System.out.printf("\n# Mevcut araclar :\n");
		listele("HEPSI");
		System.out.printf("\n");
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
		bufWriter.write(plaka + "\t" + model + "\t" + km + "\t" + "BOSTA");
		bufWriter.newLine();
		bufWriter.close();
	} // end method olustur()

	/**
	 * <code>listele("PARAMETRE")</code> metodu parantez icinde girilen
	 * parametreye gore Arac.txt dosyasindan okudugu bilgileri listeler.
	 * <p>
	 * "HEPSI" : Tum araclari listeler.
	 * <p>
	 * "BOSTA" : Bostaki araclar listelenir.
	 * <p>
	 * "GOREVDE" : Gorevdeki araclar listelenir.
	 */
	public static void listele(String durumu) throws Exception {
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String satir, satirlar[];
		System.out.printf("\n%-15s%-15s%-10s%-10s", "PLAKA", "MODEL", "KM", "DURUMU");
		System.out.printf("\n%-15s%-15s%-10s%-10s", "-----", "-----", "------", "------");
		while ((satir = bufReader.readLine()) != null) {
			satirlar = satir.split("\t");
			if (durumu.equalsIgnoreCase("HEPSI"))
				System.out.printf("\n%-15s%-15s%-10s%-10s", satirlar[0], satirlar[1], satirlar[2], satirlar[3]);
			if (durumu.equalsIgnoreCase("BOSTA") && satirlar[3].equalsIgnoreCase("BOSTA"))
				System.out.printf("\n%-15s%-15s%-10s%-10s", satirlar[0], satirlar[1], satirlar[2], satirlar[3]);
			if (durumu.equalsIgnoreCase("GOREVDE") && satirlar[3].equalsIgnoreCase("GOREVDE"))
				System.out.printf("\n%-15s%-15s%-10s%-10s", satirlar[0], satirlar[1], satirlar[2], satirlar[3]);
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

	public static String bilgiAl(String plaka, String bilgi) throws Exception {
		// ARAC.TXT DOSYASINI AC
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String satir, satirlar[] = null;
		while ((satir = bufReader.readLine()) != null) {
			satirlar = satir.split("\t");
			if (satirlar[0].equalsIgnoreCase(plaka))
				break;
		}
		bufReader.close();
		if (bilgi.equalsIgnoreCase("KM"))
			bilgi = satirlar[2];
		else if (bilgi.equalsIgnoreCase("MODEL"))
			bilgi = satirlar[1];
		else if (bilgi.equalsIgnoreCase("PLAKA"))
			bilgi = satirlar[0];
		else
			bilgi = null;
		return bilgi;
	} // end method bilgiAl()

} // end class