package E02_WriteFile_Futbolcu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileOperations {

	static Futbolcu oyuncu = new Futbolcu();
	static File dosya = new File("./src/E02_WriteFile_Futbolcu/liste.txt");

	public static void main(String[] args) throws Exception {
		dosyaYaz();
		dosyaOku();
		// dosyaKopyala();

	} // end main()

	public static void dosyaYaz() throws Exception {
		OutputStream yaz = new FileOutputStream(dosya, true);
		OutputStreamWriter out = new OutputStreamWriter(yaz, "Cp1254");
		BufferedWriter bufWriter = new BufferedWriter(out);

		// Scanner yerine kullanilen konsol okuma kodu
		InputStreamReader isr = new InputStreamReader(System.in, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		Scanner veri = new Scanner(System.in);

		int secim = 1;
		while (secim == 1) {
			System.out.print("Futbolcu Adi: ");
			oyuncu.isim = bufReader.readLine();
			System.out.print("Forma No: ");
			oyuncu.formaNo = Integer.parseInt(bufReader.readLine());

			// Dosyaya yazma kismi
			bufWriter.write(oyuncu.isim + " " + oyuncu.formaNo);
			bufWriter.newLine();

			// Yeni kullanici icin sor
			System.out.print("Yeni Futbolcu Kaydolsunmu? (1=evet/2=hayir) > ");
			secim = veri.nextInt();
			if (secim == 2)
				break;
		}

		veri.close();
		bufWriter.close();

	} // end main()

	public static void dosyaOku() throws Exception {
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String sCurrentLine;

		String[] satirlar = new String[10];
		int s = 0;
		while ((sCurrentLine = bufReader.readLine()) != null) {
			satirlar[s] = sCurrentLine;
			s++;
		}

		for (String m : satirlar)
			if (m != null)
				System.out.println(m);

		bufReader.close();
	} // end method dosyaOku()

	public static void dosyaKopyala() throws Exception {
		File tmpdosya = new File("./src/E02_WriteFile_Futbolcu/temp.txt");
		OutputStream yaz = new FileOutputStream(tmpdosya);
		OutputStreamWriter out = new OutputStreamWriter(yaz, "Cp1254");
		BufferedWriter bufWriter = new BufferedWriter(out);

		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String sCurrentLine;

		while ((sCurrentLine = bufReader.readLine()) != null) {
			if (sCurrentLine.equals("serkan")) {
				bufWriter.write(sCurrentLine + " ekleme yapildi!");
				bufWriter.newLine();
			} else {
				bufWriter.write(sCurrentLine);
				bufWriter.newLine();
			}
		} // end while
		bufWriter.close();
		bufReader.close();
		System.out.println("Dosyalar kapandi.");
		dosya.delete();
		tmpdosya.renameTo(dosya);
	} // end method dosyaKopyala(

	public static void test() throws Exception {
		BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("./src/E02_WriteFile_Futbolcu/liste.txt"), true), "Cp1254"));
	}

} // end class