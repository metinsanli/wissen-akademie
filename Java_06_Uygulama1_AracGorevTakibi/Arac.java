import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Arac {
	static String plaka, model;
	static double km;
	static File dosyaArac = new File("./src/Arac.txt");

	public static void olustur() throws Exception {
		// LISTELE
		System.out.printf("\n# Mevcut araclar :\n");
		listele("HEPSI");
		// Bilgileri iste
		System.out.printf("\n\n#### YENI ARAC KAYIT ####\n");
		System.out.printf("\nModel\t: ");
		model = SirketUygulama.klavye().toUpperCase();
		System.out.printf("\nPlaka\t: ");
		plaka = SirketUygulama.klavye().toUpperCase();
		System.out.printf("\nDepar.\t: ");
		// Dosyaya yaz
		Dosya.satirEkle(dosyaArac, plaka + "\t" + model + "\t" + km + "\t" + "BOSTA");
	} // end method olustur()

	public static void listele(String durumu) throws Exception {
		InputStream oku = new FileInputStream(dosyaArac);
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
		InputStream oku = new FileInputStream(dosyaArac);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		// METHOD ICIN DEGISKENLER
		String secim = null, satir, satirlar[];
		Boolean bulundu = false;
		// GOVDE
		while (secim == null) {
			System.out.printf("\n\nPlaka girin (Iptal=0) > ");
			secim = SirketUygulama.klavye();
			if (secim.equals("0")) {
				secim = null;
				bulundu = true;
				break;
			}
			while ((satir = bufReader.readLine()) != null) {
				satirlar = satir.split("\t");
				if (satirlar[0].equalsIgnoreCase(secim)) {
					bulundu = true;
					break;
				}
			}
		}
		if (!bulundu)
			secim = null;
		bufReader.close();
		return secim;
	} // end method aracSec()

	public static String bilgiAl(String plaka, String bilgi) throws Exception {
		// ARAC.TXT DOSYASINI AC
		InputStream oku = new FileInputStream(dosyaArac);
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

	public static void durumDegistir(String plaka, String ilkdurum, String sondurum) throws Exception {
		Dosya.satirDegistir(dosyaArac, plaka, 1, ilkdurum, sondurum);
	} // end method durumDegistir

} // end class