import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Personel {
	static String ad, soyad, departman, tck;
	static File dosya = new File("./src/Personel.txt");
	// Scanner yerine InputStreamReader
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader giris = new BufferedReader(isr);
	

	public static void olustur() throws Exception {
		// LISTELE
		System.out.printf("\n# Mevcut personel :\n");
		listele();
		System.out.printf("\n");
		// Dosya yazma
		OutputStream yaz = new FileOutputStream(dosya, true);
		OutputStreamWriter out = new OutputStreamWriter(yaz, "Cp1254");
		BufferedWriter bufWriter = new BufferedWriter(out);
		// Bilgileri iste
		System.out.printf("\n#### YENI PERSONEL KAYIT ####\n");
		System.out.printf("\nAdi\t: ");
		ad = giris.readLine();
		System.out.printf("\nSoyadi\t: ");
		soyad = giris.readLine();
		System.out.printf("\nDepar.\t: ");
		departman = giris.readLine();
		System.out.printf("\nTCK\t: ");
		tck = giris.readLine();
		bufWriter.write(tck + "\t" + ad + " " + soyad + "\t" + departman);
		bufWriter.newLine();
		bufWriter.close();
	} // end method olustur()

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
			System.out.printf("\n\nTCK girin (Iptal=0) > ");
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
	} // end method sec()

	public static void listele() throws Exception {
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String satir, satirlar[];
		System.out.printf("\n%-20s%-20s%-20s", "TCK", "ADI-SOYADI", "DEPARTMAN");
		System.out.printf("\n%-20s%-20s%-20s", "-----------------", "-----------------", "------------------");
		while ((satir = bufReader.readLine()) != null) {
			satirlar = satir.split("\t");
			System.out.printf("\n%-20s%-20s%-10s", satirlar[0], satirlar[1], satirlar[2]);
		}
		bufReader.close();
	} // end method listele()

}// end class