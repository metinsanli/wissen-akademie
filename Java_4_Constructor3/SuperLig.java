import java.util.Scanner;

public class SuperLig {

	// SINIF DEGISKENLERI
	public static Scanner veri = new Scanner(System.in);

	// MAIN()
	public static void main(String[] args) {

		Kulup bursa = new Kulup("Bursaspor", "Bursa");
		Kulup trabzon = new Kulup("Trabzonspor", "Trabzon");

		int formaNo = 0;
		boolean var = true;

		bursa.oyuncu[0] = new Futbolcu("Frey", 1, 1020, 25, "kaleci", 75);
		bursa.oyuncu[1] = new Futbolcu("Civelli", 5, 1022, 22, "defans", 65);
		bursa.oyuncu[2] = new Futbolcu("Taiwo", 17, 1024, 29, "defans", 55);
		bursa.oyuncu[3] = new Futbolcu("Sener", 19, 1026, 35, "defans", 85);
		bursa.oyuncu[4] = new Futbolcu("Ibrahim", 11, 1028, 25, "defans", 75);
		bursa.oyuncu[5] = new Futbolcu("Bekir", 15, 1032, 22, "orta", 65);
		bursa.oyuncu[6] = new Futbolcu("Ferhat", 37, 1036, 29, "orta", 55);
		bursa.oyuncu[7] = new Futbolcu("Belluschi", 29, 1074, 35, "orta", 85);
		bursa.oyuncu[8] = new Futbolcu("Volkan", 61, 1077, 25, "orta", 75);
		bursa.oyuncu[9] = new Futbolcu("Sestak", 45, 1067, 22, "forvet", 65);
		bursa.oyuncu[10] = new Futbolcu("Fernandao", 7, 1085, 29, "forvet", 55);

		trabzon.oyuncu[0] = new Futbolcu("Onur", 22, 1177, 25, "kaleci", 75);
		trabzon.oyuncu[1] = new Futbolcu("Aykut", 5, 1263, 22, "defans", 65);
		trabzon.oyuncu[2] = new Futbolcu("Mustafa", 6, 1885, 29, "defans", 55);
		trabzon.oyuncu[3] = new Futbolcu("Bosingwa", 14, 1774, 35, "defans", 85);
		trabzon.oyuncu[4] = new Futbolcu("Caner", 21, 1977, 25, "defans", 75);
		trabzon.oyuncu[5] = new Futbolcu("Yusuf", 55, 1363, 22, "orta", 65);
		trabzon.oyuncu[6] = new Futbolcu("Adrian", 41, 2085, 29, "orta", 55);
		trabzon.oyuncu[7] = new Futbolcu("Olcan", 19, 1374, 35, "orta", 85);
		trabzon.oyuncu[8] = new Futbolcu("Colman", 60, 1677, 25, "orta", 75);
		trabzon.oyuncu[9] = new Futbolcu("Zokora", 7, 1063, 22, "orta", 65);
		trabzon.oyuncu[10] = new Futbolcu("Janko", 10, 1185, 29, "forvet", 55);

		while (true) {
			switch (menuSecim()) {
			// EXIT(0)
			case 0:
				cikisMenu();
				break;
			// Kulube mac yaptir
			case 1:
				switch (kulupSec()) {
				case 1:
					bursa.kulupMacYaptir();
					System.out.printf("\n%s klubune mac yaptirildi!", bursa.kulupAdi);
					devamEt();
					break;
				case 2:
					trabzon.kulupMacYaptir();
					System.out.printf("\n%s klubune mac yaptirildi!", trabzon.kulupAdi);
					devamEt();
					break;
				}
				break;
			// Kulube antrenman yaptir
			case 2:
				switch (kulupSec()) {
				case 1:
					bursa.kulupAntrenmanYaptir();
					System.out.printf("\n%s klubune antrenman yaptirildi!", bursa.kulupAdi);
					devamEt();
					break;
				case 2:
					trabzon.kulupAntrenmanYaptir();
					System.out.printf("\n%s klubune antrenman yaptirildi!", trabzon.kulupAdi);
					devamEt();
					break;
				}
				break;
			// Kulup Bilgilerini Listele
			case 3:
				switch (kulupSec()) {
				case 1:
					bursa.kulupOyunculariniYazdir();
					devamEt();
					break;
				case 2:
					trabzon.kulupOyunculariniYazdir();
					devamEt();
					break;
				}
				break;
			// Futbolcuya ozel antrenman yaptir
			case 4:
				switch (kulupSec()) {
				case 1:
					bursa.kulupOyunculariniYazdir();
					System.out.printf("\n\nAntrenman yapacak futbolcunun forma numarasini girin > ");
					formaNo = veri.nextInt();
					for (int i = 0; i < bursa.oyuncu.length; i++) {
						if (bursa.oyuncu[i].formaNo == formaNo) {
							bursa.oyuncu[i].futbolcuAntrenmanYaptir();
							System.out.printf("\n%s icin ozel antrenman yaptirildi!", bursa.oyuncu[i].isim);
							break;
						}
					}
					devamEt();
					break;
				case 2:
					trabzon.kulupOyunculariniYazdir();
					System.out.printf("\n\nAntrenman yapacak futbolcunun forma numarasini girin > ");
					formaNo = veri.nextInt();
					for (int i = 0; i < bursa.oyuncu.length; i++) {
						if (trabzon.oyuncu[i].formaNo == formaNo) {
							trabzon.oyuncu[i].futbolcuAntrenmanYaptir();
							System.out.printf("\n%s icin ozel antrenman yaptirildi!", trabzon.oyuncu[i].isim);
							break;
						}
					}
					devamEt();
					break;
				}
				// Tek futbolcu bilgisini goruntule
			case 5:
				switch (kulupSec()) {
				case 1:
					var = true;
					System.out.printf("\nFutbolcunun forma numarasini girin > ");
					formaNo = veri.nextInt();
					for (int i = 0; i < bursa.oyuncu.length; i++) {
						if (bursa.oyuncu[i].formaNo == formaNo) {
							Futbolcu.baslikGetir();
							bursa.oyuncu[i].oyuncuBilgileriniYazdir();
							var = true;
							break;
						}
						var = false;
					}
					if (!var)
						System.out.printf("\nBu forma numarasina sahip bir futbolcu yok !");
					devamEt();
					break;
				case 2:
					var = true;
					System.out.printf("\nFutbolcunun forma numarasini girin > ");
					formaNo = veri.nextInt();
					for (int i = 0; i < bursa.oyuncu.length; i++) {
						if (trabzon.oyuncu[i].formaNo == formaNo) {
							Futbolcu.baslikGetir();
							trabzon.oyuncu[i].oyuncuBilgileriniYazdir();
							var = true;
							break;
						}
						var = false;
					}
					if (!var)
						System.out.printf("\nBu forma numarasina sahip bir futbolcu yok !");
					devamEt();
					break;
				}
				break;
			// Iki kulube mas yaptir.
			case 6:
				bursa.gol();
				trabzon.gol();
				System.out.printf("\nTrabzon %d - %d Bursa", trabzon.skor, bursa.skor);
				break;
			}
		} // end while

	} // end main()

	public static int menuSecim() {
		int secim = -1;
		while (secim <= -1 || secim > 6) {
			System.out.printf("\n\n\t#### ANA MENU ####\n");
			System.out.printf("\n[1] Kulube mac yaptir");
			System.out.printf("\n[2] Kulube antrenman yaptir");
			System.out.printf("\n[3] Kulup Bilgilerini Listele");
			System.out.printf("\n[4] Futbolcuya antrenman yaptir");
			System.out.printf("\n[5] Futbolcu Bilgisini Listele");
			System.out.printf("\n[6] Iki kulube mac yaptir");
			System.out.printf("\n[0] Cikis\n");
			System.out.printf("\nLutfen seciminizi girin > ");
			secim = veri.nextInt();
		}
		return secim;
	} // end method menuSecim()

	public static void cikisMenu() {
		System.out.printf("! Program kapatildi.");
		System.exit(0);
	} // end method cikisMenu()

	public static int kulupSec() {
		int secim = -1;
		while (secim <= 0 || secim > 2) {
			System.out.printf("\n|#### KULUP SECIM MENU ####\n");
			System.out.printf("\n[1] Bursa");
			System.out.printf("\n[2] Trabzonspor");
			System.out.printf("\n\nLutfen seciminizi girin > ");
			secim = veri.nextInt();
		}
		return secim;
	} // end method kulupSec()

	public static void devamEt() {
		int secim = 1;
		while (secim != 0) {
			System.out.printf("\n\nDevam etmek icin \"0\" girin > ");
			secim = veri.nextInt();
		}
	} // end method devamEt()

} // end class