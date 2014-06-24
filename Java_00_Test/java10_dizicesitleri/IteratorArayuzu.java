package java10_dizicesitleri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

@SuppressWarnings("all")
public class IteratorArayuzu {

	private static class Ekmek { // INNER CLASS

		public Ekmek(String cesit, int agirlik) {
			this.agirlik = agirlik;
			this.cesit = cesit;
		} // end constructor

		public String getCesit() {
			return cesit;
		}

		public void setCesit(String cesit) {
			this.cesit = cesit;
		}

		public int getAgirlik() {
			return agirlik;
		}

		public void setAgirlik(int agirlik) {
			this.agirlik = agirlik;
		}

		private String cesit;
		private int agirlik;

	} // END INNER CLASS

	public static void main(String[] args) {

		String[] isim = { "Sade", "Cekirdekli", "Cavdar", "Cevizli", "Uzumlu", "Simit" };
		int[] agirlik = { 300, 350, 250, 400, 340, 100 };

		ArrayList<Ekmek> ekmekler = new ArrayList<Ekmek>();

		for (int i = 0; i < agirlik.length; i++)
			ekmekler.add(new Ekmek(isim[i], agirlik[i]));

		ListIterator<Ekmek> iterator = ekmekler.listIterator();

		while (iterator.hasNext()) {
			Ekmek temp = iterator.next();
			System.out.println(iterator.nextIndex() + "\t" + temp.getCesit());
		}

	} // end method main()

} // END CLASS
