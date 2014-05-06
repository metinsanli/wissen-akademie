package com.islemler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.vsoft.DosyaIslemleri.VsoftDosyaOP;

public class Dosya implements VsoftDosyaOP {

	@Override
	public void guncelle(File dosya, String aramaKriteri, String yeniSatir) throws Exception {
		// GUNCELLEME YAZILACAK
	} // end abstract method guncelle()

	@Override
	public void listele(File dosya) throws Exception {
		BufferedReader dosyaOKU = null;
		try {
			dosyaOKU = dosyaAcOku(dosya);
			String satir;
			while ((satir = dosyaOKU.readLine()) != null) {
				System.out.println(satir);
			}
		} finally {
			// dosyaOKU.close();
		}
	} // end abstract method listele()

	@Override
	public void yeniKayit(File dosya, String yeniSatir) throws Exception {
		BufferedWriter dosyaYAZ = null;
		try {
			dosyaYAZ = dosyaAcYaz(dosya);
			dosyaYAZ.write(yeniSatir);
			dosyaYAZ.newLine();
		} finally {
			dosyaYAZ.close();
		}
	} // end abstract method yeniKayit()

	private BufferedReader dosyaAcOku(File dosya) throws Exception {
		InputStream dosyaIS = new FileInputStream(dosya);
		InputStreamReader dosyaISR = new InputStreamReader(dosyaIS, "Cp1254");
		BufferedReader bufDosya = new BufferedReader(dosyaISR);
		return bufDosya;
	} // end method dosyaAcOku()

	private BufferedWriter dosyaAcYaz(File dosya) throws Exception {
		OutputStream dosyaOS = new FileOutputStream(dosya, true);
		OutputStreamWriter dosyaOSW = new OutputStreamWriter(dosyaOS, "Cp1254");
		BufferedWriter bufdosya = new BufferedWriter(dosyaOSW);
		return bufdosya;
	}// end method dosyaAcYaz()

} // end class