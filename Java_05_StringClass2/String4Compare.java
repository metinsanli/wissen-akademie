/**
 * @equals :iki degiskenin iceriklerinin esit olup olmadigini karsilastirir
 *         TRUE/FALSE degeri uretir.
 * @equalsIgnoreCase :iki degiskenin buyuk-kucuk
 * @compareTo:
 * @regionMatches
 */

public class String4Compare {

	public static void main(String[] args) {

		String s1 = new String("hello");
		String s2 = "goodbye";
		String s3 = "Happy Birthday";
		String s4 = "happy birthday";

		System.out.printf("\ns1 = %s\ns2 = %s\ns3 = %s\ns4 = %s\n", s1, s2, s3, s4);

		// equals methodu ile esitlik testi
		if (s1.equals("hello"))
			System.out.printf("\ns1 esit \"hello\"");
		else
			System.out.printf("\ns1 esit degil \"hello\"");

		// == parametresi ile esitlik testi
		if (s1 == "hello")
			System.out.println("\ns1 is the same object as \"hello\"");
		else
			System.out.println("\ns1 is not the same object as \"hello\"");

		// equalsIgnoreCase buyuk-kucuk ayrimina bakmaksizin esit olup
		// olmadigini kontrol eder.
		if (s3.equalsIgnoreCase(s4))
			System.out.printf("\n%s equals %s with case ignored\n", s3, s4);
		else
			System.out.println("s3 ve s4 esit degil!");

		// compareTo iki degiskenin
		System.out.printf("\n s1.compareTo(s2) is %d", s1.compareTo(s2));
		System.out.printf("\n s2.compareTo(s1) is %d", s2.compareTo(s1));
		System.out.printf("\n s1.compareTo(s3) is %d", s1.compareTo(s3));
		System.out.printf("\n s3.compareTo(s4) is %d", s3.compareTo(s4));
		System.out.printf("\n s4.compareTo(s3) is %d\n", s4.compareTo(s3));

		// test regionMatches (case sensitive)
		if (s3.regionMatches(0, s4, 0, 5))
			System.out.printf("\ns3 ve s4'un ilk 5 karakteri aynidir!");
		else
			System.out.printf("\ns3 ve s4'un ilk 5 karakteri ayni degildir!");

		// test regionMatches (ignoreCase)
		if (s3.regionMatches(true, 0, s4, 0, 5))
			System.out.printf("\ns3 ve s4'un ilk 5 karakteri (kucuk-buyuk ayrimina bakilmaksizin) aynidir!");
		else
			System.out.printf("\ns3 ve s4'un ilk 5 karakteri (kucuk-buyuk ayrimina bakilmaksizin) ayni degildir!");

	} // end main()

} // end class
