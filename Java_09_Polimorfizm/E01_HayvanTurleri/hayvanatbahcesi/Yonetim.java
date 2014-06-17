package net.hayvanatbahcesi;

import java.util.ArrayList;
import com.dunya.canlilar.Balik;
import com.dunya.canlilar.Hayvan;
import com.dunya.canlilar.Kurbaga;
import com.dunya.canlilar.Kus;

public class Yonetim {

	// Hayvan yerine Balik turunu yazdiginizda listeye eleman eklemede hata
	// alirsiniz.
	static ArrayList<Hayvan> hayvanlar = new ArrayList<>();

	public static void main(String[] args) {

		Hayvan sazan = new Balik();
		Kurbaga kermit = new Kurbaga();
		Kus marti = new Kus();

		hayvanlar.add(sazan);
		hayvanlar.add(kermit);
		hayvanlar.add(marti);

		for (Hayvan h : hayvanlar) {

			if (h instanceof Kus) {
				System.out.println("Kus");
				h.hareketEt();
			}

			if (h instanceof Kurbaga) {
				System.out.println("Kurbaga");
				h.hareketEt();
			}

			if (h instanceof Balik) {
				System.out.println("Balik");
				h.hareketEt();
			}

		} // end for

	} // end main()

} // end class
