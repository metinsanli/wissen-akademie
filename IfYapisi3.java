import java.util.Scanner;

public class IfYapisi3 {
	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);

		String ad;
		double maas, prim, toplam, yardim = 0;
		boolean medur;

		System.out.print("Isminizi girin  : ");
		ad = veri.nextLine();

		System.out.print("Maasinizi girin : ");
		maas = veri.nextInt();

		System.out.print("Priminizi girin : ");
		prim = veri.nextDouble();

		System.out.print("Medeni durumunuz (true/false) : ");
		medur = veri.nextBoolean();

		if (medur == true)
			yardim = 500;
		else
			yardim = 0;

		toplam = maas + (maas * prim) + yardim;

		System.out.printf("*****\n›sminiz\t\t= %s\nNet maasiniz\t= %f TL.", ad, toplam);

		veri.close();
	}
}
