public class Kelime {

	static int kelimeToplamAdet;
	static String[] ayniKelimeler;
	static int[] ayniKelimeAdet;

	public Kelime(String[] metin) {

		// KAC TANE KELIME VAR BUL
		kelimeToplamAdet = metin.length;

		// NOKTA VE VIRGUL AYIKLA
		noktalamaTemizle(metin);

		// AYNI KELIMELERI BUL VE SAY
		ayniKelimeleriBul(metin);

	} // end constructor

	public static void noktalamaTemizle(String[] metin) {
		for (int i = 0; i < metin.length; i++)
			if (metin[i].endsWith(".") || metin[i].endsWith(",") || metin[i].endsWith("\"") || metin[i].startsWith("\"")) {
				metin[i] = metin[i].replace('.', ' ').trim();
				metin[i] = metin[i].replace(',', ' ').trim();
				metin[i] = metin[i].replace('\"', ' ').trim();
			}
	} // end method noktalamaTemizle()

	@SuppressWarnings("unused")
	public static void ayniKelimeleriBul(String[] metin) {
		ayniKelimeler = new String[metin.length];
		ayniKelimeAdet = new int[metin.length];
		int sayac = 0;
		for (int i = 0; i < metin.length; i++) {
			boolean bulundu = false;
			for (int j = 0; j < ayniKelimeler.length; j++) {
				if (metin[i].equalsIgnoreCase(ayniKelimeler[j])) {
					ayniKelimeAdet[i]++;
					bulundu = true;
					break;
				}
			} // end for j
			if (!bulundu) {
				
			}
		} // end for i
	} // end method ayniKelimeleriBul()

} // end class