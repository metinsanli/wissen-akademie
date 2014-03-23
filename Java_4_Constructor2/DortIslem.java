import java.util.Scanner;

public class DortIslem {

	private static int sayi1 = 0;
	private static int sayi2 = 0;

	public DortIslem() {
	}// end constructor DortIslem()

	@SuppressWarnings("static-access")
	public DortIslem(int sayi1, int sayi2) {
		this.sayi1 = sayi1;
		this.sayi2 = sayi2;
	} // end constructor DortIslem(int,int)

	public static void sayilariAl() {
		Scanner veri = new Scanner(System.in);
		int sayi = -1;
		while (sayi < 0 || sayi > 100) {
			System.out.printf("Lutfen 0-100 arasinda integer sayi girin > ");
			sayi = veri.nextInt();
		}
		veri.close();
	} // end method sayilariAl()

	public static int topla() {
		return sayi1 + sayi2;
	} // end method topla()

	public static int topla(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	} // end method topla(int,int)

	public static int cikart() {
		return sayi1 - sayi2;
	} // end method cikart()

	public static int cikart(int sayi1, int sayi2) {
		return sayi1 - sayi2;
	} // end method cikart(int,int)

	public static int bol() {
		return sayi1 / sayi2;
	} // end method bol()

	public static int bol(int sayi1, int sayi2) {
		return sayi1 / sayi2;
	} // end method bol(int,int)

	public static int carpim() {
		return sayi1 * sayi2;
	} // end method carpim()

	public static int carpim(int sayi1, int sayi2) {
		return sayi1 * sayi2;
	} // end method carpim(int,int)

} // end class