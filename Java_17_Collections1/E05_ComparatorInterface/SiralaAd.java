package E5_ComparatorInterface;

import java.util.Comparator;

@SuppressWarnings("all")
public class SiralaAd implements Comparator {

	@Override
	public int compare(Object calisan1, Object calisan2) {
		// Object nesneler Calisan sinifina DownCast yapiliyor.
		String ad1 = ((Calisan) calisan1).getAd();
		String ad2 = ((Calisan) calisan2).getAd();
		return ad1.compareTo(ad2); // Buradaki compareTo methodu String sinifinindir.
	}// end method compare()

} // END CLASS
