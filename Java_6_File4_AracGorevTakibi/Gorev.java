import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gorev {
	String kod, tarih;
	static File dosya = new File("./src/Gorev.txt");

	public static void olustur() throws Exception {
		// DOSYA YAZMA
		OutputStream yaz = new FileOutputStream(dosya, true);
		OutputStreamWriter out = new OutputStreamWriter(yaz, "Cp1254");
		BufferedWriter bufWriter = new BufferedWriter(out);
		// Scanner yerine InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in, "Cp1254");
		BufferedReader giris = new BufferedReader(isr);
		// GOVDE
		while (true) {
			String plaka, personel, tarih, saat, nereye;
			Arac.listele();
			plaka = Arac.sec();
			if (plaka == null || plaka == "0")
				break;
			Personel.listele();
			personel = Personel.sec();
			if (personel == null || personel == "0")
				break;
			System.out.printf("\nCikis Tarihi\t(GGAAYY)\t> ");
			tarih = giris.readLine();
			System.out.printf("\nCikis Saati\t(SSDD)\t> ");
			saat = giris.readLine();
			System.out.printf("\nGidis Yeri\t\t> ");
			nereye = giris.readLine();
			bufWriter.write(kodUret(plaka) + "\t" + plaka.toUpperCase() + "\t" + personel + "\t" + tarih + "\t" + saat + "\t" + nereye);
			bufWriter.newLine();
		} // end while
		bufWriter.close();
	} // end method olustur()

	public static String kodUret(String plaka) {
		Date bugun = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYHHmm");
		return (formatter.format(bugun) + plaka.replace(" ", "")).toUpperCase();
	} // end method kodUret()

	public static void listele() throws Exception {
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String satir, satirlar[];
		System.out.printf("\n%-20s%-12s%-13s%-20s%-20s%-10s", "GOREV NO", "PLAKA", "TCK", "CIKIS TARIHI", "CIKIS SAATI", "HEDEF");
		System.out.printf("\n%-20s%-12s%-13s%-20s%-20s%-10s", "-----------------", "--------", "---------", "------------------",
				"------------------", "--------");
		while ((satir = bufReader.readLine()) != null) {
			satirlar = satir.split("\t");
			System.out.printf("\n%-20s%-12s%-13s%-20s%-20s%-10s", satirlar[0], satirlar[1], satirlar[2], satirlar[3], satirlar[4], satirlar[5]);
		}
		bufReader.close();
	} // end method listele()

} // end class