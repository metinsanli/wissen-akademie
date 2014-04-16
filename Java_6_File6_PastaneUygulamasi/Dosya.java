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

	private static BufferedReader dosyaAcOku(File dosya) throws Exception {
		InputStream dosyaIS = new FileInputStream(dosya);
		InputStreamReader dosyaISR = new InputStreamReader(dosyaIS, "Cp1254");
		BufferedReader bufDosya = new BufferedReader(dosyaISR);
		return bufDosya;
	} // end method dosyaAcOku()

	private static BufferedWriter dosyaAcYaz(File dosya) throws Exception {
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

	public static void satirSil(File dosya, String silmeKriteri, int aranacakIndis) throws Exception {
		File dosyatemp = new File("./src/Temp.txt");
		BufferedReader dosyaOKU = dosyaAcOku(dosya);
		StringBuilder temp = new StringBuilder();
		String satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (!paketler[0].equalsIgnoreCase(silmeKriteri)) {
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
	} // end method satirSil()

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
					System.out.printf("%-13s", yaz);
			}
		}
	} // end method listele()

	public static void guncelle(File dosya, String aramaKriteri, int degisecekIndis, String yeniDeger) throws Exception {
		File dosyatemp = new File("./src/Temp.txt");
		BufferedReader dosyaOKU = dosyaAcOku(dosya);
		StringBuilder temp = new StringBuilder();
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
	} // end method guncelle()

	public static String bulGetir(File dosya, int aranacakIndis, String aramaKriteri) throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku(dosya);
		StringBuilder temp = new StringBuilder();
		temp.delete(0, temp.length());
		String satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (paketler[aranacakIndis].equalsIgnoreCase(aramaKriteri)) {
				temp.append(satir);
			}
		}
		return temp.toString();
	} // end method satirBulGetir()

	public static String sonSatiriGetir(File dosya) throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku(dosya);
		String satir, sonSatir = "";
		while ((satir = dosyaOKU.readLine()) != null) {
			sonSatir = satir;
		}
		return sonSatir;
	} // end method sonSatiriGetir()

} // end class