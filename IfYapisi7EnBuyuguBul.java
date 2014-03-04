public class IfYapisi7EnBuyuguBul {

	public static void main(String[] args) {
		int x = 8, y = 16, z = 4;
		int max = 0;

		// birinci yontem
		max = x;
		if (y > max) {
			max = y;
		}
		if (z > max) {
			max = z;
		} // end if birinci yontem
		System.out.printf("sayilar : %d, %d, %d \n", x, y, z);
		System.out.println("sayilarin en buyugu = " + max);

		// ikinci yontem
		if (x > y) {
			if (x > z) {
				System.out.println("en buyuk sayi = " + x);
			} else {
				System.out.println("en buyuk sayi = " + z);
			}
		} else if (y > z) {
			System.out.println("en buyuk sayi = " + y);
		} else {
			System.out.println("en buyuk sayi = " + z);
		}// end if ikinci yontem

	} // end main
} // end class
