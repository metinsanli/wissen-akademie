import java.util.Scanner;

public class IfYapisi10KargoUcretiHesaplama {
	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		double carpan, mesafe, netUcret;
		int hacim;
		boolean uyeMi;

		System.out.println("Metin Kargo Hizmetleri Hosgeldiniz :)");
		System.out.print("Mesafeyi giriniz        : ");
		mesafe = veri.nextDouble();
		System.out.print("Koli hacmini giriniz    : ");
		hacim = veri.nextInt();
		System.out.print("Uyeliginiz varmi (t/f)  : ");
		uyeMi = veri.nextBoolean();

		// mesafeye gore hacim carpani
		if (mesafe >= 30)
			carpan = 10;
		else if (mesafe >= 20)
			carpan = 7;
		else if (mesafe >= 10)
			carpan = 5;
		else
			carpan = 2;

		// uyelik indirim alacakmi
		if (uyeMi)
			netUcret = (hacim * carpan) * 0.9;
		else
			netUcret = hacim * carpan;

		// sonuc goruntuleme
		System.out.println("Toplam kargo bedeli " + netUcret + "TL.");

		veri.close();

	}
}
