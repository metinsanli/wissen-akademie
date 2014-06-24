package java10_dizicesitleri;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("all")
public class CollectionsArayuzu {

	public static void main(String[] args) {

		Collection dizi1 = new ArrayList<Nesne>();

	}

	private class Nesne implements Comparable { // INNER CLASS

		public String adi;

		public Nesne(String adi) {
			this.adi = adi;
		}

		@Override
		public int compareTo(Object o) {
			String temp = ((Nesne) o).adi;
			return adi.compareToIgnoreCase(temp);
		}
	} // END INNER CLASS

} // END CLASS
