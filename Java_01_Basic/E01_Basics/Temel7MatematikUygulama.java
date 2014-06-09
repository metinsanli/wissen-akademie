package E01_Basics;
public class Temel7MatematikUygulama {
	public static void main(String[] args) {

		// Declare an int variable number1 and initialize it to 98
		int sayi1 = 98;
		int sayi2 = 5;
		int toplam, fark, carpim, bolum, kalan;

		// Islemleri gerceklestir.
		toplam = sayi1 + sayi2;
		fark = sayi1 - sayi2;
		bolum = sayi1 / sayi2;
		carpim = sayi1 * sayi2;
		kalan = sayi1 % sayi2;

		// Sonuclari yazdir.
		System.out.print("Sayi 1:\t");
		System.out.println(sayi1);
		System.out.print("Sayi 2:\t");
		System.out.println(sayi2);
		System.out.print("Topla =\t");
		System.out.println(toplam);
		System.out.print("Fark =\t");
		System.out.println(fark);
		System.out.print("Carp =\t");
		System.out.println(carpim);
		System.out.print("Bol =\t");
		System.out.println(bolum);
		System.out.print("Kalan =\t");
		System.out.println(kalan);
	}// main
}// class