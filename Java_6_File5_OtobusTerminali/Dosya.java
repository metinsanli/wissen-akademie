import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Dosya {

	static File dosyatemp = new File("./src/Temp.txt");

	public static BufferedReader dosyaAcOku(File dosya) throws Exception {
		InputStream dosyaIS = new FileInputStream(dosya);
		InputStreamReader dosyaISR = new InputStreamReader(dosyaIS, "Cp1254");
		BufferedReader bufDosya = new BufferedReader(dosyaISR);
		return bufDosya;
	} // end method dosyaAcOku()

	public static BufferedWriter dosyaAcYaz(File dosya) throws Exception {
		OutputStream dosyaOS = new FileOutputStream(dosya, true);
		OutputStreamWriter dosyaOSW = new OutputStreamWriter(dosyaOS, "Cp1254");
		BufferedWriter bufdosya = new BufferedWriter(dosyaOSW);
		return bufdosya;
	}// end method dosyaAcYaz()

	public static void satirEkle(File dosya, String yeniSatir) throws Exception {
		BufferedWriter dosyaYAZ = dosyaAcYaz(dosya);
		dosyaYAZ.write(yeniSatir);
		dosyaYAZ.newLine();
		dosyaYAZ.close();
	} // end method satirEkle()

	public static void guncelle(File dosya, String aramaKriteri, int degisecekIndis, String yeniDeger) throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku(dosya);
		StringBuffer temp = new StringBuffer();
		String satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (paketler[0].equalsIgnoreCase(aramaKriteri)) {
				paketler[degisecekIndis] = yeniDeger;
				for (int i = 0; i < paketler.length - 1; i++)
					temp.append(paketler[i] + "\t");
				temp.append(paketler[paketler.length - 1]);
				satirEkle(dosyatemp, temp.toString());
				temp.delete(0, temp.length());
			} else {
				for (int i = 0; i < paketler.length - 1; i++)
					temp.append(paketler[i] + "\t");
				temp.append(paketler[paketler.length - 1]);
				satirEkle(dosyatemp, temp.toString());
				temp.delete(0, temp.length());
			}
		}
		dosyaOKU.close();
		dosya.delete();
		dosyatemp.renameTo(dosya);
	} // end method satirDegistir()

	public static String satirBul(File dosya, String aramaKriteri) throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku(dosya);
		StringBuffer temp = new StringBuffer();
		temp.delete(0, temp.length());
		String satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (paketler[0].equalsIgnoreCase(aramaKriteri)) {
				temp.append(satir);
			}
		}
		return temp.toString();
	} // end method satirBul()

	public static void listele(File dosya, int indis, String kriter) throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku(dosya);
		StringBuffer temp = new StringBuffer();
		temp.delete(0, temp.length());
		String satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (paketler[indis].equalsIgnoreCase(kriter)) {
				System.out.println();
				for (String yaz : paketler)
					System.out.printf("%-15s", yaz);
			}
		}
	} // end method listele()

} // end class