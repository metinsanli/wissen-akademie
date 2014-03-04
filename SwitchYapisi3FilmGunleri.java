import java.util.Scanner;

public class SwitchYapisi3FilmGunleri {
	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		int biletSayisi, gosterimGunu, toplamTutar, gununUcreti;

		System.out.print("Gunu girin (1-7) >");
		gosterimGunu = veri.nextInt();
		System.out.print("Bilet sayisini girin >");
		biletSayisi = veri.nextInt();
		veri.close();

		switch (gosterimGunu) {
		case 1:
			gununUcreti = 15;
			break;
		case 3:
			gununUcreti = 5;
			break;
		case 5:
			gununUcreti = 10;
			break;
		default:
			gununUcreti = 0;
			break;
		}

		if (gununUcreti == 0) {
			System.out.println("Bugun gosterim yok");
		} else {
			toplamTutar = gununUcreti * biletSayisi;
			System.out.println(" Toplam tutar = " + toplamTutar);
		}

	}
}