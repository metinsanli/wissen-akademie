package E4_comparable;

import java.util.Collections;
import java.util.Vector;

@SuppressWarnings("all")
public class Vector_Comparable {

	enum konum {
		HAVADA, YERDE
	};

	static Vector<Ucak> ucakFilo = new Vector();

	public Vector_Comparable() {

		ucakFilo.add(new Ucak("Boeing 747"));
		ucakFilo.add(new Ucak("Mooney"));
		ucakFilo.add(new Ucak("Airbus A102"));
		ucakFilo.add(new Ucak("Concorde"));

		// Vektor sinifinin uzunlugunu tespit et.
		int elemanSayisi = ucakFilo.size();
		System.out.println("ucakFilo listesinin uzunlugu : " + elemanSayisi);
		System.out.println("\nucakFilo listesinin ilk hali : ");
		for (int index = 0; index < elemanSayisi; index++)
			System.out.println(ucakFilo.get(index).model);
		// ucakFilo icerigini sirala
		Collections.sort(ucakFilo); // sirala yapilabilmesi icin Ucak sinifinin karsilastirilabilir olmasi gerekir.
		// Karsilastirilabilir olmasi demek Comparable interface'i Ucak sinifina implement edilmis olmasi demektir.
		System.out.println("\nucakFilo listesi siralandiktan sonra : ");
		for (int index = 0; index < elemanSayisi; index++)
			System.out.println(ucakFilo.get(index).model);

		// ucakFilo icinde 2 indexli elemanin modelini degistir.
		ucakFilo.elementAt(2).model = "Airbus A555";
		ucakFilo.elementAt(1).ucakKonum = konum.HAVADA;
		System.out.println("\nucakFilo listesindeki elemanlar duzenlendikten sonra:");
		for (int index = 0; index < elemanSayisi; index++)
			System.out.println(ucakFilo.get(index).model + " - " + ucakFilo.elementAt(index).ucakKonum);

	}

	public class Ucak implements Comparable {

		public String model;
		public int yolcuKapasitesi;
		public konum ucakKonum = konum.YERDE;

		public Ucak(String markaModel) {
			model = markaModel;
		}

		@Override
		public int compareTo(Object digerUcak) {
			String isim = ((Ucak) digerUcak).model;
			return model.compareToIgnoreCase(isim);
		}

	} // END CLASS Ucak

	public static void main(String[] args) {
		new Vector_Comparable();
	}

} // END CLASS