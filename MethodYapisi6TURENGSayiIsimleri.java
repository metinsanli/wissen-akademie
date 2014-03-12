import java.util.Scanner;

public class MethodYapisi6TURENGSayiIsimleri {
	static int secim = -1;

	public static void main(String[] args) {
		sayiGir();

		for (int i = secim; i >= 0; i--)
			System.out.printf("%s\t!\t%s\n", sayiTurkce(i), sayiIngilizce(i));
	}

	public static void sayiGir() {
		Scanner veri = new Scanner(System.in);

		while (!(secim >= 0 && secim <= 9)) {
			System.out.printf("\nKactan geri sayalim >");
			secim = veri.nextInt();
			if (!(secim >= 0 && secim <= 9))
				System.out.printf("Girdiginiz sayi 0-9 arasinda olsun!\n");
		}
		veri.close();
	}

	public static String sayiTurkce(int sayi) {

		String yazi = "";
		switch (sayi) {
		case 0:
			yazi = "Sifir";
			break;
		case 1:
			yazi = "Bir";
			break;
		case 2:
			yazi = "Iki";
			break;
		case 3:
			yazi = "Uc";
			break;
		case 4:
			yazi = "Dort";
			break;
		case 5:
			yazi = "Bes";
			break;
		case 6:
			yazi = "Alti";
			break;
		case 7:
			yazi = "Yedi";
			break;
		case 8:
			yazi = "Sekiz";
			break;
		case 9:
			yazi = "Dokuz";
			break;
		}
		return yazi;
	} 

	public static String sayiIngilizce(int i) {
		String[] eng = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		return eng[i];
	} // sayiIngilizce
}
