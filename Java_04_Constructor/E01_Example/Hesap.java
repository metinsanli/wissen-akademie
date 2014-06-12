package E01_Example;

public class Hesap {

	static int st1;
	public int pub1;
	private int s1;
	private int s2;
	public Hesap() { // DEFAULT CONSTRUCTOR
		s1 = 100;
		s2 = 1;
		st1 = 500;
		pub1 = 666;
	} // end constractor Hesap()

	public Hesap(int sayi1, int sayi2) {
		s1 = sayi1;
		s2 = sayi2;
	} // end constractor Hesap(int,int)

	public static int topla(int sayi1, int sayi2) {
		int toplam;
		toplam = sayi1 + sayi2;
		// s1 = 444;
		return toplam;
	} // end method topla(int,int)

	public int topla() {
		return s1 + s2;
	} // end method topla()

	public void topla(double sayi1, int sayi2) {
		double toplam = 0.0;
		toplam = sayi1 + sayi2 + s1;
		System.out.println(toplam);
	} // end method topla(double,int)

} // end class