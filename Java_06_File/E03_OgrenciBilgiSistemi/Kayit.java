package E03_OgrenciBilgiSistemi;

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Kayit {

	static Ogrenci ogrenci;
	static File dosya = new File("./src/E03_OgrenciBilgiSistemi/yoklama.txt");

	public static void main(String[] args) throws Exception {
		anaMenu();
	} // end main()

	public static void anaMenu() throws Exception {
		@SuppressWarnings("resource")
		Scanner veri = new Scanner(System.in);
		while (true) {
			System.out.printf("\n#### OGRENCI MENU ####\n");
			System.out.printf("\n[1] - Yeni Kayit");
			System.out.printf("\n[2] - Kayitlari Listele");
			System.out.printf("\n[3] - Yoklama Gir");
			System.out.printf("\n\n[0] - Cikis\n");
			int secim = -1;
			while (secim < 0 || secim > 3) {
				System.out.printf("\nLutfen seciminizi girin > ");
				secim = veri.nextInt();
			}
			switch (secim) {
			case 0:
				System.out.printf("\nProgram kapatildi!");
				System.exit(0);
			case 1:
				yeniKayit();
				break;
			case 2:
				listele();
				break;
			case 3:
				yoklama();
				break;
			}
		}
	} // end method anaMenu()

	public static void yeniKayit() throws Exception {
		@SuppressWarnings("resource")
		Scanner veri = new Scanner(System.in);
		OutputStream yaz = new FileOutputStream(dosya, true);
		OutputStreamWriter out = new OutputStreamWriter(yaz, "Cp1254");
		BufferedWriter bufWriter = new BufferedWriter(out);
		String ad, soyad, no;

		System.out.printf("\nYeni ogrenci kaydi icin istenen bilgileri giriniz.");
		System.out.printf("\nAdi: ");
		ad = veri.nextLine();
		System.out.printf("\nSoyadi\t: ");
		soyad = veri.nextLine();
		System.out.printf("\nNo\t: ");
		no = veri.nextLine();

		bufWriter.newLine();
		bufWriter.write(no + " " + ad + " " + soyad + " 0");

		bufWriter.close();
	} // end method yeniKayit()

	public static void listele() throws Exception {
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String sCurrentLine;

		while ((sCurrentLine = bufReader.readLine()) != null) {
			System.out.printf("\n%s", sCurrentLine);
		} // end while
		System.out.printf("\n");
		bufReader.close();

	} // end method listele()

	public static void yoklama() throws Exception {
		File tmpdosya = new File("./src/temp.txt");
		OutputStream yaz = new FileOutputStream(tmpdosya);
		OutputStreamWriter out = new OutputStreamWriter(yaz, "Cp1254");
		BufferedWriter bufWriter = new BufferedWriter(out);
		@SuppressWarnings("resource")
		Scanner veri = new Scanner(System.in);
		InputStream oku = new FileInputStream(dosya);
		InputStreamReader isr = new InputStreamReader(oku, "Cp1254");
		BufferedReader bufReader = new BufferedReader(isr);
		String sCurrentLine, no;

		System.out.printf("\nEger ogrenci burada=1/degil=0 girin :");

		while ((sCurrentLine = bufReader.readLine()) != null) {
			System.out.printf("\n%s Burada mi?", sCurrentLine);
			no = veri.nextLine();
			if (no.equalsIgnoreCase("e")) {
				String[] temp = sCurrentLine.split(" ");
				temp[3] = "1";
				bufWriter.write(temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3]);
				bufWriter.newLine();
			} else {
				bufWriter.write(sCurrentLine);
				bufWriter.newLine();
			}
		} // end while

		bufWriter.close();
		bufReader.close();
		dosya.delete();
		tmpdosya.renameTo(dosya);
	} // end method yoklama()
} // end class