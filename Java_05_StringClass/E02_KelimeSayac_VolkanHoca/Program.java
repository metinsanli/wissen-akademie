package E02_KelimeSayac_VolkanHoca;

import java.util.Scanner;

public class Program {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Kelime[] kelimeler;
		Scanner veri = new Scanner(System.in);
		String paragraf = veri.nextLine();
		String[] tokens = paragraf.split(" ");
		// ----Kelimeleri i�aretlerden Temizlemek i�in kullan�labilir-----------
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = Kelime.temizle(tokens[i]);
			// alternatif
			Kelime kel = new Kelime();
			kel.deger = tokens[i];
			kel.temizle();
		}
		// ------------------------------------------
		System.out.println(tokens.length);

		kelimeler = new Kelime[tokens.length];

		// tokens taki keliemler kelimeler dizinde var m�? varsa adet artt�r
		// yoksa kelimeler dizine ekle

		for (int i = 0; i < tokens.length; i++) {
			// her bir i i�in arama yap
			boolean bulundu = false;
			for (int j = 0; j < Kelime.kelimeSayisi; j++) {

				if (tokens[i].equalsIgnoreCase(kelimeler[j].deger)) {
					kelimeler[j].adet++;
					bulundu = true;
					break;
				}
			}// end for j
				// bulundumu diye kontrol et
			if (bulundu == false) {
				kelimeler[Kelime.kelimeSayisi] = new Kelime();
				kelimeler[Kelime.kelimeSayisi].deger = tokens[i];
				kelimeler[Kelime.kelimeSayisi].adet++;
				Kelime.kelimeSayisi++;
			}
		}// end for i

		for (int j = 0; j < Kelime.kelimeSayisi; j++) {
			System.out.println(kelimeler[j].deger + " " + kelimeler[j].adet);
		}
	}

}
