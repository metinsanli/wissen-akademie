package E02_Futbol;

@SuppressWarnings("all")
public class SuperLig2 {

	public static void main(String[] args) {

		// DEGISKENLER
		Kulup[] kulup = new Kulup[18];
		String[] kulupBilgileri = { "Galatasaray", "Besiktas", "Trabzon", "Fenerbahce", "Eskisehirspor", "Sivas", "Kasimpasa", "Karabuk", "Akhisar", "Gaziantep",
				"Genclerbirligi", "Bursa", "Konya", "Antalya", "Rize", "Elazig", "Erciyes", "Kayseri" };
		int[] ligSira = new int[18];
		int temp = 0;

		// 18 TANE KULUP NESNESI OLUSTURLUYOR
		for (int i = 0; i < kulup.length; i++) {
			kulup[i] = new Kulup(kulupBilgileri[i], 0, 0, 0);
			ligSira[i] = i;
		}

		// 18 tane mac yaptir
		for (int i = 0; i < kulup.length; i++)
			for (int j = 0; j < kulup.length; j++) {
				if (i == j)
					j++;
				else {
					// iki kulup icin skor uret
					kulup[i].gol();
					kulup[j].gol();
					// skora gore galibiyet, maglubiyet veya beraberlik puani
					if (kulup[i].skor > kulup[j].skor) {
						kulup[i].puan += 3;
						kulup[i].yedGol += kulup[j].skor;
						kulup[j].yedGol += kulup[i].skor;
					} else if (kulup[i].skor < kulup[j].skor) {
						kulup[j].puan += 3;
						kulup[i].yedGol += kulup[j].skor;
						kulup[j].yedGol += kulup[i].skor;
					} else if (kulup[i].skor == kulup[j].skor) {
						kulup[i].puan += 1;
						kulup[j].puan += 1;
						kulup[i].yedGol += kulup[j].skor;
						kulup[j].yedGol += kulup[i].skor;
					}
				}
			}

		baslikGetir();

		// PUAN SIRALAMASI YAP
		for (int i = 0; i < ligSira.length; i++)
			for (int j = i; j < ligSira.length; j++) {
				// YUKSEK PUANI ONE AL
				if (kulup[ligSira[i]].puan < kulup[ligSira[j]].puan) {
					temp = ligSira[i];
					ligSira[i] = ligSira[j];
					ligSira[j] = temp;
				}
				// PUAN ESITSE YUKSEK AVERAJI ONE AL
				if (kulup[ligSira[i]].puan == kulup[ligSira[j]].puan) {
					if ((kulup[ligSira[i]].atGol - kulup[ligSira[i]].yedGol) < (kulup[ligSira[j]].atGol - kulup[ligSira[j]].yedGol)) {
						temp = ligSira[i];
						ligSira[i] = ligSira[j];
						ligSira[j] = temp;
					}
					// PUAN VE AVERAJ ESITSE DAHA FAZLA GOL ATANI ONE AL
					if ((kulup[ligSira[i]].atGol - kulup[ligSira[i]].yedGol) == (kulup[ligSira[j]].atGol - kulup[ligSira[j]].yedGol)) {
						if (kulup[ligSira[i]].atGol < kulup[ligSira[j]].atGol) {
							temp = ligSira[i];
							ligSira[i] = ligSira[j];
							ligSira[j] = temp;
						}
					}
				}
			}

		// PUAN SIRALI OLARAK YAZDIR
		int toplam1 = 0;
		int toplam2 = 0;
		for (int i = 0; i < ligSira.length; i++) {
			System.out.printf("\n%-5d%-15s%-7d%-7d%-7d%-5d", i + 1, kulup[ligSira[i]].kulupAdi, kulup[ligSira[i]].atGol, kulup[ligSira[i]].yedGol, kulup[ligSira[i]].atGol
					- kulup[ligSira[i]].yedGol, kulup[ligSira[i]].puan);
			toplam1 += kulup[i].atGol;
			toplam2 += kulup[i].yedGol;
		}

		// TEST
		// System.out.printf("\nAtilan = %d / Yenen = %d\n", toplam1, toplam2);

	}// end main()

	public static void baslikGetir() {
		System.out.printf("\n%-5s%-15s%-7s%-7s%-7s%-5s", "Sira", "Kulup Adi", "Attigi", "Yedigi", "Averaj", "Puan");
		System.out.printf("\n%-5s%-15s%-7s%-7s%-7s%-5s", "----", "---------", "------", "------", "------", "----");
	} // end method baslikGetir()

} // end class