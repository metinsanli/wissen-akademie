package com.islemler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Uygulama {

	public static void main(String[] args) {

		File testtxt = new File("./src/Test.txt");
		Dosya dosya = new Dosya();

		try {

			// dosya.yeniKayit(testtxt, "Hey\tMerhaba\tSen\tAli misin");
			dosya.listele(testtxt);

		} catch (Exception e) {
			if (e instanceof IOException)
				System.err.println("Okuma/Yazma Hatasi!");
			if (e instanceof FileNotFoundException)
				System.err.println("Dosya bulunamadi!");
			if (e instanceof NullPointerException)
				System.err.println("Dongusel artiklik denetimi :)!");
		}

	} // end main()

} // end class