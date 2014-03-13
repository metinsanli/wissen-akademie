import java.util.Random;

public class ArrayCokBoyutlu3ZarAtma {

	public static void main(String[] args) {
		Random zar = new Random();
		int[][] sonuclar = { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 0 }, { 5, 0 }, { 6, 0 } };
		int salla = 0;

		for (int i = 0; i < 100; i++) {
			salla = 1 + zar.nextInt(6);
			switch (salla) {
			case 1:
				sonuclar[0][0]++;
				break;
			case 2:
				sonuclar[1][0]++;
				break;
			case 3:
				sonuclar[2][0]++;
				break;
			case 4:
				sonuclar[3][0]++;
				break;
			case 5:
				sonuclar[4][0]++;
				break;
			case 6:
				sonuclar[5][0]++;
				break;
			}
		}

		for (int j = 0; j < sonuclar.length; j++) {
			System.out.println(j + 1 + " sayisi " + sonuclar[j][0] + " kere gelmistir.");
		}

	}
}