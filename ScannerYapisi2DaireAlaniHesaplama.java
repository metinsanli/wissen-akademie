import java.util.Scanner;

public class ScannerYapisi2DaireAlaniHesaplama {

	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);

		int yaricap;
		double pisayisi;
		double alan;

		System.out.println("* Daire Alan Hesaplama *");

		System.out.print("Yaricapi girin : ");
		yaricap = veri.nextInt();

		System.out.print("Pi sayisini girin : ");
		pisayisi = veri.nextDouble();

		alan = yaricap * yaricap * pisayisi;
		System.out.println("Daire Alani = " + alan);

		veri.close();
	}
}
