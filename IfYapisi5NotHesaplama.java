import java.util.Scanner;

public class IfYapisi5NotHesaplama {
	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		int not1, not2;
		double sonuc;
		String isim;

		System.out.print("Ogrenci Ismi      : ");
		isim = veri.nextLine();

		System.out.print("Vize Notu  : ");
		not1 = veri.nextInt();

		System.out.print("Final Notu : ");
		not2 = veri.nextInt();

		sonuc = (not1 * 0.4) + (not2 * 0.6);

		if (sonuc > 80)
			System.out.println("Pekiyi");
		else if (sonuc > 50)
			System.out.println("Iyi");
		else if (sonuc > 30)
			System.out.println("Zayif");
		else
			System.out.println("Kotu");

		System.out.println(isim);

		veri.close();

	} // main
} // class
