import java.util.Scanner;

public class HataYakalama {

	public static double bolme(int sayi, int bolen) {
		return sayi / bolen;
	} // end method bolme()

	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);

		System.out.printf("Bir sayi girin > ");
		int s = veri.nextInt();
		System.out.printf("Bolen girin > ");
		int b = veri.nextInt();
		System.out.println(bolme(s, b));
		veri.close();

	} // end main()

} // end class
