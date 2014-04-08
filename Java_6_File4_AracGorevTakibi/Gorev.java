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
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader giris = new BufferedReader(isr);

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
			String plaka, personel, tarih, cikisSaat, donusSaat, nereye;
			double girisKM = 0;
			Arac.listele("BOSTA");
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
			cikisSaat = giris.readLine();
			System.out.printf("\nDonus Saati\t(SSDD)\t> ");
			donusSaat = giris.readLine();
			System.out.printf("\nGidis Yeri\t\t> ");
			nereye = giris.readLine();
			bufWriter.write(kodUret(plaka) + "\t" + tarih + "\t" + cikisSaat + "\t" + donusSaat + "\t" + Arac.bilgiAl(plaka, "km") + "\t" + girisKM
					+ "\t" + personel + "\t" + plaka.toUpperCase() + "\t" + nereye + "\t" + "GOREVDE");
			bufWriter.newLine();
		} // end while
		bufWriter.close();
	} // end method olustur()

	public static String kodUret(String plaka) {
		Date bugun = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYHHmm");
		return (formatter.format(bugun) + plaka.replace(" ", "")).toUpperCase();
	} // end method kodUret()

	public static void listele(String durumu) throws Exception {
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String satir, satirlar[];
		System.out.printf("\n%-20s%-10s%-8s%-8s%-6s%-6s%-15s%-15s%-10s%-10s", "GOREV NO", "TARIH", "CIKIS", "DONUS", "KM+", "KM-", "PERSONEL",
				"PLAKA", "NEREYE", "DURUMU");
		System.out.printf("\n%-20s%-10s%-8s%-8s%-6s%-6s%-15s%-15s%-10s%-10s", "--------", "-----", "-----", "-----", "----", "----", "--------",
				"-----", "------", "-----");
		while ((satir = bufReader.readLine()) != null) {
			satirlar = satir.split("\t");
			if (durumu.equalsIgnoreCase("HEPSI") && satirlar[9].equalsIgnoreCase("HEPSI"))
				System.out.printf("\n%-20s%-10s%-8s%-8s%-6s%-6s%-15s%-15s%-10s%-10s", satirlar[0], satirlar[1], satirlar[2], satirlar[3],
						satirlar[4], satirlar[5], satirlar[6], satirlar[7], satirlar[8], satirlar[9]);
			if (durumu.equalsIgnoreCase("GOREVDE") && satirlar[9].equalsIgnoreCase("GOREVDE"))
				System.out.printf("\n%-20s%-10s%-8s%-8s%-6s%-6s%-15s%-15s%-10s%-10s", satirlar[0], satirlar[1], satirlar[2], satirlar[3],
						satirlar[4], satirlar[5], satirlar[6], satirlar[7], satirlar[8], satirlar[9]);
			if (durumu.equalsIgnoreCase("BITTI") && satirlar[9].equalsIgnoreCase("BITTI"))
				System.out.printf("\n%-20s%-10s%-8s%-8s%-6s%-6s%-15s%-15s%-10s%-10s", satirlar[0], satirlar[1], satirlar[2], satirlar[3],
						satirlar[4], satirlar[5], satirlar[6], satirlar[7], satirlar[8], satirlar[9]);
		}
		bufReader.close();
	} // end method listele()

	public static void bitir() throws Exception {
		// GOREV.TXT DOSYASINI OKUMAK ICIN AC
		InputStream gorevoku = new FileInputStream(dosya);
		InputStreamReader gorevokuisr = new InputStreamReader(gorevoku, "Cp1254");
		BufferedReader bufReadOkuGorev = new BufferedReader(gorevokuisr);
		String gorevOkuSatir, gorevOkuSatirlar[];
		// TEMP-GOREV.TXT DOSYASINI YAZMAK ICIN AC
		File tempgorev = new File("./src/temp-gorev.txt");
		OutputStream gorevyaz = new FileOutputStream(tempgorev);
		OutputStreamWriter gorevyazisr = new OutputStreamWriter(gorevyaz, "Cp1254");
		BufferedWriter bufWriteYazGorev = new BufferedWriter(gorevyazisr);
		String gorevYazSatir, gorevYazSatirlar[];

		String secim, girisKM;
		System.out.printf("\n#### GOREV BITIR ####\n");
		System.out.printf("\nGorevde olan arac ve personel bilgileri :\n");
		listele("GOREVDE");
		System.out.printf("\n\nGorev kodunu yazin (Iptal=0) >");
		secim = giris.readLine();
		if (secim.equals("0"))
			System.out.printf("\nIptal secildi!");
		System.out.printf("\nGiris KM sini girin > ");
		girisKM = giris.readLine();
		if (!secim.equals("0"))
			while ((gorevOkuSatir = bufReadOkuGorev.readLine()) != null) {
				gorevYazSatirlar = gorevOkuSatir.split("\t");
				if (secim.equalsIgnoreCase(gorevYazSatirlar[0])) {
					bufWriteYazGorev.write(gorevYazSatirlar[0] + "\t" + gorevYazSatirlar[1] + "\t" + gorevYazSatirlar[2] + "\t" + gorevYazSatirlar[3]
							+ "\t" + gorevYazSatirlar[4] + "\t" + girisKM + "\t" + gorevYazSatirlar[6] + "\t" + gorevYazSatirlar[7] + "\t"
							+ gorevYazSatirlar[8] + "\t" + "BITTI");
				}
			}
		bufReadOkuGorev.close();
		bufWriteYazGorev.close();
		dosya.delete();
		tempgorev.renameTo(dosya);
	} // end method bitir()
} // end class