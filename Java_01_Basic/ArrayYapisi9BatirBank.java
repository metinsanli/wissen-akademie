import java.util.Scanner;

public class ArrayYapisi9BatirBank {

	public static void main(String[] args) {
		// DEGISKENLER
		String[] musteriAdi = { "Volkan", "Mehmet", "Cemil", "Gonul", "Metin", "Kerim", "Nihan", "Yusuf", "Mustafa" };
		int[] musteriNo = { 5001, 5002, 5003, 5004, 5005, 5006, 5007, 5008, 5009 };
		int[] bakiye = { 2500, 3000, 0, 5500, 600, 7800, 1000, 30, 550 };

		Scanner veri = new Scanner(System.in);
		int musNo, islem, paraMik;
		boolean kayitKontrol = true;
		boolean islemMenu = true;

		while (kayitKontrol) {
			// MUSTERI NO GIRISI
			System.out.printf("\n*** BATIR BANK ***\n");
			System.out.printf("Lutfen Musteri Nosunu girin (Cikis \"0\") >");
			musNo = veri.nextInt();
			// EGER "0" GIRILMISE PROGRAMDAN CIK
			if (musNo == 0) {
				System.err.printf("Program kapatildi!");
				System.exit(0);
			}

			// GIRILEN MUSTERI NO KAYITLARDA VARMI?
			int sayac = 0;
			while (sayac < musteriNo.length) {

				if (musteriNo[sayac] == musNo) {
					// EGER VARSA ISLEM MENUSUNU GETIR
					kayitKontrol = true;

					while (islemMenu) { // MUSTERI ISLEM MENUSU
						System.out.printf("\n\n >> Sayin %s ", musteriAdi[sayac]);
						System.out.printf("\nYapmak istediginiz islemi secin >\n");
						System.out.printf("\n1 - Bakiye Goruntule\n2 - Para yatirma\n3 - Para cekme\n0 - Cikis");
						System.out.printf("\n\nIslem secin (1/2/3/0) > ");
						islem = veri.nextInt();

						// GIRILEN ISLEMI SEC
						switch (islem) {
						case 1: // BAKIYE GORUNTULE
							System.err.printf("\n%s : bakiyeniz = %d TL.\n", musteriAdi[sayac], bakiye[sayac]);
							break;
						case 2: // PARA YATIRMA
							System.out.printf("\nYatirilacak para miktari girin (TL) > ");
							paraMik = veri.nextInt();
							bakiye[sayac] += paraMik;
							System.err.printf("\n%d TL yatirildi. Yeni bakiyeniz = %d TL'dir.\n", paraMik, bakiye[sayac]);
							break;

						case 3: // PARA CEKME
							System.out.printf("\nMevcut bakiyeniz %d TL. Cekilecek miktari girin (TL) > ", bakiye[sayac]);
							paraMik = veri.nextInt();
							// BAKIYE CEKILEN MIKTARDAN AZSA
							if (paraMik > bakiye[sayac]) {
								System.err.printf("\nBakiyeniz %d TL. Yeterli bakiyeniz yok !", bakiye[sayac]);

							} else {
								bakiye[sayac] -= paraMik;
								System.err.printf("\nKalan bakiyeniz %d TL.", bakiye[sayac]);
							}
							break;
						default: // CIKIS YAP
							islemMenu = false;
							break;
						}
					} // islem menu while
				}
				sayac++;
			} // end ic while

			// EGER KAYIT YOKSA (MUSTERI NO GIRISINE GERI DON)
			if (kayitKontrol == false) {
				System.err.printf("\n%d Nolu Musteri kayidi bulunmuyor!\n", musNo);
				kayitKontrol = true;
			}
		}// kayitKontrol while
		veri.close();
	} // end main
} // end class
