package E08_ScannerClass;
import java.util.Scanner;

public class ScannerYapisi3MaasHesaplama {
	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);

		String ad;

		double maas, prim, toplam;

		System.out.print("Isminizi girin :");
		ad = veri.nextLine();

		System.out.print("Maasinizi girin :");
		maas = veri.nextInt();

		System.out.print("Priminizi girin :");
		prim = veri.nextDouble();

		toplam = maas + (maas * prim);
		System.out.println("�sminiz  = " + ad);
		System.out.println("Maasiniz = " + toplam + " TL");

		veri.close();
	}
}
