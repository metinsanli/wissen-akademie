import java.util.Scanner;

public class MethodYapisi5EnBuyukSayiyiBul {

	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		System.out.print("1 adet sayi girin >");
		double sayi1 = veri.nextDouble();
		System.out.print("1 adet daha sayi girin >");
		double sayi2 = veri.nextDouble();
		System.out.print("Son 1 adet daha sayi girin >");
		double sayi3 = veri.nextDouble();
		double sonuc = enBuyukBul(sayi1, sayi2, sayi3);
		System.out.println("En buyuk sayi = " + sonuc);
		veri.close();
	} // end main

	public static double enBuyukBul(double x, double y, double z) {
		double max = x;
		if (y > max)
			max = y;
		if (z > max)
			max = z;
		return max;
	} // end enBuyukBul

} // end class