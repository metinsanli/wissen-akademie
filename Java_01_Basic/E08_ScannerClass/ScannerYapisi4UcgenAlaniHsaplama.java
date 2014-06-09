package E08_ScannerClass;
import java.util.Scanner;

public class ScannerYapisi4UcgenAlaniHsaplama {

	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);

		int taban, yukseklik;
		double alan;

		System.out.print("Taban :");
		taban = veri.nextInt();

		System.out.print("Yukseklik :");
		yukseklik = veri.nextInt();

		alan = (double) (taban * yukseklik) / 2; // typecast
		System.out.println("Ucgenin alani = " + alan);

		veri.close();
	}
}