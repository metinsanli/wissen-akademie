package E5_ComparatorInterface;

import java.util.Comparator;

@SuppressWarnings("all")
public class SiralaYas implements Comparator {

	@Override
	public int compare(Object calisan1, Object calisan2) {
		// Object'ler Calisan sinifina DownCast ediliyor.
		int yas1 = ((Calisan) calisan1).getYas();
		int yas2 = ((Calisan) calisan2).getYas();
		String ad1 = ((Calisan) calisan1).getAd();
		String ad2 = ((Calisan) calisan2).getAd();
		// Kiyaslama yapiliyor.
		if (yas1 > yas2)
			return 1;
		else if (yas1 < yas2)
			return -1;
		else
			return 0;
	} // end method compare()

} // END CLASS
