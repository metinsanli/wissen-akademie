public class Hesap {

	private int s1 = 8;
	private int s2;
	private double d1;
	private double d2;

	public int topla() {
		return s1 + s2;
	} // end topla()

	public int topla(int sayi1, int sayi2) {
		int toplam;
		toplam = sayi1 + sayi2;
		s1 = 444;
		return toplam;
	} // end topla(int,int)

	public void topla(double sayi1, int sayi2) {
		double toplam = 0.0;
		toplam = sayi1 + sayi2 + s1;
		System.out.println(toplam);
	} // end topla(double,int)

} // end class