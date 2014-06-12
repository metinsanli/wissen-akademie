package E04_Otel;

import java.util.Scanner;

public class Resepsiyon {

	static Scanner veri = new Scanner(System.in);
	static Scanner yazi = new Scanner(System.in);
	static Otel otel1 = new Otel("WOW", "Antalya", "321654987", 10);

	public static void main(String[] args) {

		hazirMusterileriYukle();

		anaMenuSecimYap();

	} // end main()

	public static void anaMenuSecimYap() {
		while (true) {
			int secim = -1;
			System.out.printf("\n\n #### %s OTEL ANA MENU ####\n", otel1.otelAdi);
			System.out.printf("\n[1] - Musteri Yonetim Menu");
			System.out.printf("\n[2] - Oda Yonetim Menu");
			System.out.printf("\n\n[0] - Cikis\n");
			while (!(secim >= 0 && secim <= 2)) {
				System.out.printf("\nLutfen seciminizi yapin > ");
				secim = veri.nextInt();
			}
			switch (secim) {
			case 0:
				System.out.println("! Program kapatildi.");
				System.exit(0);
			case 1:
				musteriMenu();
				break;
			case 2:
				odaMenu();
				break;
			}
		}
	} // end method anaMenuSecimYap()

	public static void devamEt() {
		int sec = 1;
		while (sec != 0) {
			System.out.printf("\nDevam etmek icin \"0\" girin > ");
			sec = veri.nextInt();
		}
	} // end method devamEt()

	public static void musteriMenu() {
		int secim = -1;
		System.out.printf("\n\n #### MUSTERI MENU ####\n");
		System.out.printf("\n[1] - Tum Musterileri Goster");
		System.out.printf("\n[2] - Yeni Musteri Girisi");
		System.out.printf("\n[3] - Musteri Cikisi Yap");
		System.out.printf("\n\n[0] - Ana Menuye don\n");
		while (!(secim >= 0 && secim <= 3)) {
			System.out.printf("\nLutfen seciminizi yapin > ");
			secim = veri.nextInt();
		}
		switch (secim) {
		case 0:
			break;
		case 1:
			musteriDurumGoster();
			break;
		case 2:
			musteriYeniKayit();
			break;
		case 3:
			musteriCikisYap();
			break;
		}
	}// end method musteriMenu()

	public static void musteriDurumGoster() {
		System.out.printf("\n%-4s%-20s%-6s%-7s%-9s", "ODA", "MUSTERI ADI", "UCRET", "DURUMU", "TEMIZLIK");
		System.out.printf("\n%-4s%-20s%-6s%-7s%-9s", "---", "-----------", "-----", "------", "--------");
		String durumu = "DOLU", hijyen = "TEMIZ";
		for (int i = 0; i < otel1.oda.length; i++)
			if (otel1.oda[i].doluBos == false) {
				if (otel1.oda[i].doluBos == true)
					durumu = "BOS";
				if (otel1.oda[i].temizKirli == false)
					hijyen = "KIRLI";
				for (int j = 0; j < otel1.oda[i].musteri.length; j++)
					if (j == 0)
						System.out.printf("\n%-4d%-20s%-6.0f%-7s%-9s", otel1.oda[i].odaNo, otel1.oda[i].musteri[j].musteriAdi, (otel1.oda[i].odaUcreti * otel1.oda[i].musteri[j].gunSayisi), durumu, hijyen);
					else
						System.out.printf("\n%-2d+ %-20s%-6.0f%-7s%-9s", otel1.oda[i].odaNo, otel1.oda[i].musteri[j].musteriAdi, (otel1.oda[i].odaUcreti * otel1.oda[i].musteri[j].gunSayisi), durumu, hijyen);
			}
	}

	public static void musteriYeniKayit() {
		int yeniMusteriId = 0, yeniGunSayisi = 0, yeniOdaNo = 0, kayitAdet = 1;
		String yeniMusteriAdi = null, yeniTcKimlikNo = null, yeniTelNo = null, cevap = "h";

		System.out.printf("\n##### YENI MUSTERI GIRISI #####\n");

		System.out.printf("\nBos odalar : \n");
		for (int i = 0; i < otel1.oda.length; i++) {
			if (otel1.oda[i].doluBos == true)
				if (otel1.oda[i].odaNo % 2 == 0)
					System.out.printf("\nOda No : %d (Çift Kisilik)", otel1.oda[i].odaNo);
				else
					System.out.printf("\nOda No : %d (Tek Kisilik)", otel1.oda[i].odaNo);
		}

		System.out.printf("\n\nMusteri hangi odada kalacak\t> ");
		yeniOdaNo = veri.nextInt() - 1;

		if (otel1.oda[yeniOdaNo].odaNo % 2 == 0) {
			System.out.printf("\nSecilen oda 2 kisiliktir. 2 yeni kayit acilsin mi ? (e/h) > ");
			cevap = yazi.nextLine();
			if (cevap.equalsIgnoreCase("e"))
				kayitAdet = 2;
		}
		for (int z = 0; z < kayitAdet; z++) {
			System.out.printf("\nMusteri Adini giriniz\t> ");
			yeniMusteriAdi = yazi.nextLine();
			System.out.printf("\nTC Kimlik No giriniz\t> ");
			yeniTcKimlikNo = yazi.nextLine();
			System.out.printf("\nTelefon No giriniz\t> ");
			yeniTelNo = yazi.nextLine();
			System.out.printf("\nMusteri kac gun kalacak\t> ");
			yeniGunSayisi = veri.nextInt();

			otel1.oda[yeniOdaNo].musteri[z].musteriId = yeniMusteriId;
			otel1.oda[yeniOdaNo].musteri[z].musteriAdi = yeniMusteriAdi;
			otel1.oda[yeniOdaNo].musteri[z].tcKimlik = yeniTcKimlikNo;
			otel1.oda[yeniOdaNo].musteri[z].telNo = yeniTelNo;
			otel1.oda[yeniOdaNo].musteri[z].gunSayisi = yeniGunSayisi;
			otel1.oda[yeniOdaNo].doluBos = false;

			System.out.println("Yeni musteri kayidi olusturuldu!");
			devamEt();
		}

	}

	public static void musteriCikisYap() {
		int odaNosu;
		double sonFiyat;
		System.out.printf("\n##### MUSTERI CIKIS ISLEMLERI #####\n");
		System.out.printf("\nDolu odalar : \n");
		for (int i = 0; i < otel1.oda.length; i++) {
			if (otel1.oda[i].doluBos == false)
				for (int j = 0; j < otel1.oda[i].musteri.length; j++)
					System.out.printf("\nOda No : %d %s", otel1.oda[i].odaNo, otel1.oda[i].musteri[j].musteriAdi);
		}

		System.out.printf("\n\nLutfen cikis yapilacak oda numarasini girin > ");
		odaNosu = veri.nextInt() - 1;
		sonFiyat = otel1.oda[odaNosu].odaUcreti * otel1.oda[odaNosu].musteri[0].gunSayisi;
		System.out.println("Sn. " + otel1.oda[odaNosu].musteri[0].musteriAdi + " toplam borcunuz = " + sonFiyat + " TL.");
		devamEt();

		otel1.oda[odaNosu].musteri[0].musteriId = 0;
		otel1.oda[odaNosu].musteri[0].musteriAdi = null;
		otel1.oda[odaNosu].musteri[0].tcKimlik = null;
		otel1.oda[odaNosu].musteri[0].telNo = null;
		otel1.oda[odaNosu].musteri[0].gunSayisi = 0;
		otel1.oda[odaNosu].doluBos = true;
		System.out.println("Musteri kaydi silindi !");
		devamEt();
	}

	public static void odaMenu() {
		int secim = -1;
		System.out.printf("\n\n #### ODA MENU ####\n");
		System.out.printf("\n[1] - Tum odalarin durumunu goster");
		System.out.printf("\n[2] - Odayi temizle");
		System.out.printf("\n\n[0] - Ana Menuye don\n");
		while (!(secim >= 0 && secim <= 2)) {
			System.out.printf("\nLutfen seciminizi yapin > ");
			secim = veri.nextInt();
		}
		switch (secim) {
		case 0:
			break;
		case 1:
			odaDurumGoster();
			break;
		case 2:
			odaTemizle();
			break;
		}
	} // end method odaMenu()

	public static void odaDurumGoster() {
		System.out.printf("\n%-4s%-20s%-8s%-6s%-8s%-7s%-9s", "ODA", "MUSTERI ADI", "UCRETI", "YATAK", "MANZARA", "DURUMU", "TEMIZLIK");
		System.out.printf("\n%-4s%-20s%-8s%-6s%-8s%-7s%-9s", "---", "-----------", "------", "-----", "-------", "------", "--------");
		for (int i = 0; i < otel1.oda.length; i++) {
			for (int j = 0; j < otel1.oda[i].musteri.length; j++) {
				String durumu = "DOLU", manzara = "DAG", hijyen = "TEMIZ", musAd = "BOS";
				musAd = otel1.oda[i].musteri[j].musteriAdi;
				// DOLU BOS
				if (otel1.oda[i].doluBos == true)
					durumu = "BOS";
				// DENIZ DAG
				if (otel1.oda[i].denizDag == true)
					manzara = "DENIZ";
				// TEMIZ KIRLI
				if (otel1.oda[i].temizKirli == false)
					hijyen = "KIRLI";
				// MUSTERI ADI
				if (otel1.oda[i].musteriId == 0) // musteri adi
													// yazilacak
					// YAZDIR "\n%-4d%-20s%-7f%-6d%-8s%-7s%-9s"
					System.out.printf("\n%-4d%-20s%-8.0f%-6d%-8s%-7s%-9s", otel1.oda[i].odaNo, musAd, otel1.oda[i].odaUcreti, otel1.oda[j].yatakSayisi, manzara, durumu, hijyen);
			}
		}
		System.out.println();
		devamEt();
	}

	public static void odaTemizle() {
		int secim = -1;
		for (int i = 0; i < otel1.oda.length; i++) {
			if (otel1.oda[i].temizKirli == false)
				System.out.printf("\n %d numarali odanin temizlenmesi gerekiyor.", otel1.oda[i].odaNo);
		}
		System.out.println();
		while (!(secim >= 1 && secim <= otel1.oda.length)) {
			System.out.printf("\nLutfen temizlenecek oda numarasini girin > ");
			secim = veri.nextInt();
		}
		otel1.oda[secim - 1].temizKirli = true;
		System.out.printf("\n%d numarali oda temizlendi...\n", secim);
		devamEt();
	}

	public static void hazirMusterileriYukle() {
		otel1.oda[0].musteri[0].musteriId = 1;
		otel1.oda[0].musteri[0].musteriAdi = "Metin Sanli";
		otel1.oda[0].musteri[0].tcKimlik = "79865413254";
		otel1.oda[0].musteri[0].telNo = "03654589878";
		otel1.oda[0].musteri[0].gunSayisi = 3;
		otel1.oda[0].doluBos = false;
		otel1.oda[0].temizKirli = false;

		otel1.oda[2].musteri[0].musteriId = 2;
		otel1.oda[2].musteri[0].musteriAdi = "Angelina Jolie";
		otel1.oda[2].musteri[0].tcKimlik = "3479865413254";
		otel1.oda[2].musteri[0].telNo = "0343654589878";
		otel1.oda[2].musteri[0].gunSayisi = 5;
		otel1.oda[2].doluBos = false;
		otel1.oda[2].temizKirli = false;

		otel1.oda[7].musteri[0].musteriId = 55;
		otel1.oda[7].musteri[0].musteriAdi = "Cate Blanchett";
		otel1.oda[7].musteri[0].tcKimlik = "3479865413254";
		otel1.oda[7].musteri[0].telNo = "0343654589878";
		otel1.oda[7].musteri[0].gunSayisi = 5;
		otel1.oda[7].doluBos = false;
		otel1.oda[7].temizKirli = false;

		otel1.oda[7].musteri[1].musteriId = 56;
		otel1.oda[7].musteri[1].musteriAdi = "Andrew Upton";
		otel1.oda[7].musteri[1].tcKimlik = "3479865413254";
		otel1.oda[7].musteri[1].telNo = "0343654589878";
		otel1.oda[7].musteri[1].gunSayisi = 5;
		otel1.oda[7].doluBos = false;
		otel1.oda[7].temizKirli = false;

		otel1.oda[9].musteri[1].musteriId = 56;
		otel1.oda[9].musteri[1].musteriAdi = "Brad Pitt";
		otel1.oda[9].musteri[1].tcKimlik = "3479865413254";
		otel1.oda[9].musteri[1].telNo = "0343654589878";
		otel1.oda[9].musteri[1].gunSayisi = 5;
		otel1.oda[9].doluBos = false;
		otel1.oda[9].temizKirli = false;
	} // end method hazirMusterileriYukle()

} // end class