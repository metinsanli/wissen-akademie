public class YazimKontrol {
	public static boolean isimDogrula(String isim) {
		return isim.matches("[A-Z][a-zA-Z]* [A-Z][a-zA-Z]*");
	}
}
