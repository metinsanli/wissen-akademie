import java.util.Scanner;

public class MethodYapisi4ReturnTypeIntergerKullanimi {
	static int sayi = 8; // SINIF DEGISKENI SAYI=8 OLARAK TANIMLANDI
	static Scanner veri = new Scanner(System.in); // SINIF DEGISKENI TANIMLANDI 565465d sdf sdf sdf sdf 

	public static void main(String[] args) {
		int d;

		sayininOnKati();
		sayiYazdir();

		sayininBesKati();
		sayiYazdir();

		d = degerAl();
		sayiAl();
		sayininKati(d);
		sayiYazdir();

	} // end main

	public static void sayininBesKati() {
		System.out.printf("Sayinin Bes Kati = %d\n", sayi);
		sayi *= 5;
	}

	public static void sayininOnKati() {
		System.out.printf("Sayinin On Kati = %d\n", sayi);
		sayi *= 10;
	}

	public static void sayininKati(int deger) {
		sayi *= sayi;
		System.out.println("Sayinin 2 kati = " + sayi);
	}

	public static void sayiYazdir() {
		System.out.println("Sayi = " + sayi);
	}

	public static int degerAl() {
		int deger;
		System.out.print("Lutfen degeri girin > ");
		deger = veri.nextInt();
		return deger;
	}

	public static void sayiAl() {
		int deger = 0;
		System.out.print(deger + "Lutfen sayiyi girin > ");
		deger = veri.nextInt();
	}

} // end class
