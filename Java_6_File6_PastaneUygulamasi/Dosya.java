

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

	private File dosya;

	public Dosya(String dosya) {
		this.dosya = new File(dosya);
	} // end constructor

	private BufferedReader dosyaAcOku() throws Exception {
		InputStream dosyaIS = new FileInputStream(dosya);
		InputStreamReader dosyaISR = new InputStreamReader(dosyaIS, "Cp1254");
		BufferedReader bufDosya = new BufferedReader(dosyaISR);
		return bufDosya;
	} // end method dosyaAcOku()

	private BufferedWriter dosyaAcYaz() throws Exception {
		OutputStream dosyaOS = new FileOutputStream(dosya, true);
		OutputStreamWriter dosyaOSW = new OutputStreamWriter(dosyaOS, "Cp1254");
		BufferedWriter bufdosya = new BufferedWriter(dosyaOSW);
		return bufdosya;
	}// end method dosyaAcYaz()

	public void satirEkle(String yeniSatir) throws Exception {
		BufferedWriter dosyaYAZ = dosyaAcYaz();
		dosyaYAZ.write(yeniSatir);
		dosyaYAZ.newLine();
		dosyaYAZ.close();
	} // end method satirEkle()

	public void satirSil(String silmeKriteri, int aranacakIndis) throws Exception {
		Dosya dosyatemp = new Dosya("./src/Temp.txt");
		BufferedReader dosyaOKU = dosyaAcOku();
		StringBuilder temp = new StringBuilder();
		String satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (!paketler[0].equalsIgnoreCase(silmeKriteri)) {
				for (int i = 0; i < paketler.length - 1; i++)
					temp.append(paketler[i] + "\t");
				temp.append(paketler[paketler.length - 1]);
				satirEkle(temp.toString());
				temp.delete(0, temp.length());
			}
		}
		dosyaOKU.close();
		dosya.delete();
		dosyatemp.dosya.renameTo(dosya);
	} // end method satirSil()

	public void listele(int indis, String kriter) throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku();
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

	public void guncelle(String aramaKriteri, int degisecekIndis, String yeniDeger) throws Exception {
		Dosya dosyatemp = new Dosya("./src/Temp.txt");
		BufferedReader dosyaOKU = dosyaAcOku();
		StringBuilder temp = new StringBuilder();
		String satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (paketler[0].equalsIgnoreCase(aramaKriteri)) {
				paketler[degisecekIndis] = yeniDeger;
				for (int i = 0; i < paketler.length - 1; i++)
					temp.append(paketler[i] + "\t");
				temp.append(paketler[paketler.length - 1]);
				dosyatemp.satirEkle(temp.toString());
				temp.delete(0, temp.length());
			} else {
				for (int i = 0; i < paketler.length - 1; i++)
					temp.append(paketler[i] + "\t");
				temp.append(paketler[paketler.length - 1]);
				dosyatemp.satirEkle(temp.toString());
				temp.delete(0, temp.length());
			}
		}
		dosyaOKU.close();
		dosya.delete();
		dosyatemp.dosya.renameTo(dosya);
	} // end method guncelle()

	public String bulGetir(int aranacakIndis, String aramaKriteri) throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku();
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

	public String sonSatiriGetir() throws Exception {
		BufferedReader dosyaOKU = dosyaAcOku();
		String satir, sonSatir = "";
		while ((satir = dosyaOKU.readLine()) != null) {
			sonSatir = satir;
		}
		return sonSatir;
	} // end method sonSatiriGetir()

} // end class