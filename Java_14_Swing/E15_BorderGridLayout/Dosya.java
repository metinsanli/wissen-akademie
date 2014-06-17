package E15_BorderGridLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

@SuppressWarnings("all")
public class Dosya {

	private static File dosya = new File("./src/E15_BorderGridLayout/kayit.txt");

	private static BufferedReader bufOku(File dosya) throws Exception {
		return new BufferedReader(new InputStreamReader(new FileInputStream(dosya), "Cp1254"));
	} // end method bufOku()

	private static BufferedWriter bufYaz(File dosya) throws Exception {
		return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dosya, true), "Cp1254"));
	} // end method bufYaz()

	public String bul(String aramaKriteri) throws Exception {
		BufferedReader oku = bufOku(this.dosya);
		String satir = null, kelimeler[];
		while ((satir = oku.readLine()) != null) {
			kelimeler = satir.split("\t");
			if (kelimeler[0].equalsIgnoreCase(aramaKriteri))
				break;
			else
				satir = null;
		}
		oku.close();
		return satir;
	} // end method bul()

	public void ekle(String yeniSatir) throws Exception {
		BufferedWriter yaz = bufYaz(this.dosya);
		yaz.write(yeniSatir);
		yaz.newLine();
		yaz.close();
	} // end method ekle()

	public void guncelle(String aramaKriteri, String yeniSatir) throws Exception {
		String[] varmi = bul(aramaKriteri).split("\t");
		if (aramaKriteri.equalsIgnoreCase(varmi[0])) {
			File tmp = new File("/src/E15_BorderGridLayout/temp.txt");
			BufferedReader oku = bufOku(this.dosya);
			BufferedWriter yaz = bufYaz(tmp);
			String satir, kelimeler[];
			while ((satir = oku.readLine()) != null) {
				kelimeler = satir.split("\t");
				if (kelimeler[0].equalsIgnoreCase(aramaKriteri)) {
					yaz.write(yeniSatir);
					yaz.newLine();
				} else {
					yaz.write(satir);
					yaz.newLine();
				}
			}
			oku.close();
			yaz.close();
			dosya.delete();
			tmp.renameTo(dosya);
		}
	} // end method guncelle()

} // END CLASS