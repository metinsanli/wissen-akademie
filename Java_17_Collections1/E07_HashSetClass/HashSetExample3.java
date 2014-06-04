package E07_HashSetClass;

import java.util.HashSet;

@SuppressWarnings("all")
public class HashSetExample3 {

	public static class Sehir { // INNER CLASS

		public String adi;

		public Sehir(String ad) {
			this.adi = ad;
		}

		public String toString() {
			return adi;
		}

	} // END INNER CLASS

	public static void main(String[] args) {

		HashSet<Sehir> sehirler = new HashSet<Sehir>();

		Sehir ank = new Sehir("Ankara");
		Sehir baskent = new Sehir("Ankara");

		sehirler.add(ank);
		sehirler.add(ank);
		sehirler.add(ank);
		sehirler.add(ank);
		sehirler.add(baskent);

		System.out.println(sehirler);

	} // end main()

} // END CLASS
