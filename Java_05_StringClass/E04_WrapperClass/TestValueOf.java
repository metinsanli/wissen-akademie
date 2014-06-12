package E04_WrapperClass;

/**
 * String sinifinin String.valueOf(degisken) methodu farkli veri türündeki
 * degerleri String türüne cevirir.
 * 
 */

public class TestValueOf {

	public static void main(String[] args) {
		double d = 9.939;
		boolean b = true;
		long l = 1232874;
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };

		//
		String doubleNumber = String.valueOf(d);
		System.out.println("String Type Return Value = " + doubleNumber);
		System.out.println("String Type Return Value = " + String.valueOf(b));
		System.out.println("String Type Return Value = " + String.valueOf(d));
		System.out.println("String Type Return Value = " + String.valueOf(l));
		System.out.println("String Type Return Value = " + String.valueOf(arr));

	}

}