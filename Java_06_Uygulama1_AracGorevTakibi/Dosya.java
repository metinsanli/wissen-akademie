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

	public static void satirEkle(File dosya, String yeniSatir) throws Exception {
		OutputStream dosyaOS = new FileOutputStream(dosya, true);
		OutputStreamWriter dosyaOSW = new OutputStreamWriter(dosyaOS, "Cp1254");
		BufferedWriter dosyaYAZ = new BufferedWriter(dosyaOSW);
		dosyaYAZ.write(yeniSatir);
		dosyaYAZ.newLine();
		dosyaYAZ.close();
	} // end method satirEkle()

	public static void satirDegistir(File dosya, String aramaKriteri, int indis, String ilkDeger, String yeniDeger) throws Exception {
		InputStream dosyaIS = new FileInputStream(dosya);
		InputStreamReader dosyaISR = new InputStreamReader(dosyaIS, "Cp1254");
		BufferedReader dosyaOKU = new BufferedReader(dosyaISR);
		String temp = "", satir, paketler[];
		while ((satir = dosyaOKU.readLine()) != null) {
			paketler = satir.split("\t");
			if (paketler[0].equalsIgnoreCase(aramaKriteri) && paketler[indis].equalsIgnoreCase(ilkDeger)) {
				paketler[indis] = yeniDeger;
				for (int i = 0; i < paketler.length - 1; i++)
					temp += (paketler[i] + "\t");
				temp += paketler[paketler.length - 1] + "\n";
				satirEkle(dosyatemp, temp);
			} else {
				for (int i = 0; i < paketler.length - 1; i++)
					temp += (paketler[i] + "\t");
				temp += paketler[paketler.length - 1] + "\n";
				satirEkle(dosyatemp, temp);
			}
		}
		dosyaOKU.close();
		dosya.delete();
		dosyatemp.renameTo(dosya);
	} // end method satirDegistir()

} // end class