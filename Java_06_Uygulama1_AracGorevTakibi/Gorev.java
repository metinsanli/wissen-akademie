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
	static File dosyaGorev = new File("./src/Gorev.txt");

	public static void olustur() throws Exception {
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
			tarih = SirketUygulama.klavye();
			System.out.printf("\nCikis Saati\t(SSDD)\t> ");
			cikisSaat = SirketUygulama.klavye();
			System.out.printf("\nDonus Saati\t(SSDD)\t> ");
			donusSaat = SirketUygulama.klavye();
			System.out.printf("\nGidis Yeri\t\t> ");
			nereye = SirketUygulama.klavye();
			Dosya.satirEkle(dosyaGorev, kodUret(plaka) + "\t" + tarih + "\t" + cikisSaat + "\t" + donusSaat + "\t" + Arac.bilgiAl(plaka, "km") + "\t"
					+ girisKM + "\t" + personel + "\t" + plaka.toUpperCase() + "\t" + nereye + "\t" + "GOREVDE");
			Arac.durumDegistir(plaka, "BOSTA", "GOREVDE");
			break;
		} // end while

	} // end method olustur()

	public static String kodUret(String plaka) {
		Date bugun = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYHHmm");
		return (formatter.format(bugun) + plaka.replace(" ", "")).toUpperCase();
	} // end method kodUret()

	public static void listele(String durumu) throws Exception {
		InputStream oku = new FileInputStream(dosyaGorev);
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
		InputStream gorevIS = new FileInputStream(dosyaGorev);
		InputStreamReader gorevISR = new InputStreamReader(gorevIS, "Cp1254");
		BufferedReader gorevOKU = new BufferedReader(gorevISR);
		String gorevSatir;
		// TEMP-GOREV1.TXT DOSYASINI YAZMAK ICIN AC
		File tempdosya1 = new File("./src/temp-gorev1.txt");
		OutputStream gorevOS = new FileOutputStream(tempdosya1, true);
		OutputStreamWriter gorevOSW = new OutputStreamWriter(gorevOS, "Cp1254");
		BufferedWriter tempYAZ = new BufferedWriter(gorevOSW);
		String tempSatirlar[];
		// KONTROL DEGISKENLERI
		String secim, girisKM = null, plaka = null;
		System.out.printf("\n#### GOREV BITIR ####\n");
		System.out.printf("\nGorevde olan arac ve personel bilgileri :\n");
		listele("GOREVDE");
		System.out.printf("\n\nGorev kodunu yazin\t(Iptal=0) >");
		secim = SirketUygulama.klavye();
		if (!secim.equals("0")) {
			System.out.printf("\nGiris KM sini girin\t(Iptal=0) > ");
			girisKM = SirketUygulama.klavye();
		}
		if (secim.equals("0") || girisKM.equals("0")) {
			System.out.printf("\nIptal secildi!");
		}
		if (!secim.equals("0")) {
			while ((gorevSatir = gorevOKU.readLine()) != null) {
				tempSatirlar = gorevSatir.split("\t");
				if (secim.equalsIgnoreCase(tempSatirlar[0])) {
					tempYAZ.write(tempSatirlar[0] + "\t" + tempSatirlar[1] + "\t" + tempSatirlar[2] + "\t" + tempSatirlar[3] + "\t" + tempSatirlar[4]
							+ "\t" + girisKM + "\t" + tempSatirlar[6] + "\t" + tempSatirlar[7] + "\t" + tempSatirlar[8] + "\t" + "BITTI");
					tempYAZ.newLine();
					plaka = tempSatirlar[7];
				} else {
					tempYAZ.write(tempSatirlar[0] + "\t" + tempSatirlar[1] + "\t" + tempSatirlar[2] + "\t" + tempSatirlar[3] + "\t" + tempSatirlar[4]
							+ "\t" + tempSatirlar[5] + "\t" + tempSatirlar[6] + "\t" + tempSatirlar[7] + "\t" + tempSatirlar[8] + "\t"
							+ tempSatirlar[9]);
					tempYAZ.newLine();
				}
			}
			Arac.durumDegistir(plaka, "GOREVDE", "BOSTA");
			gorevOKU.close();
			tempYAZ.close();
			dosyaGorev.delete();
			tempdosya1.renameTo(dosyaGorev);
		} else {
			gorevOKU.close();
			tempYAZ.close();
		}

	} // end method bitir()

} // end class