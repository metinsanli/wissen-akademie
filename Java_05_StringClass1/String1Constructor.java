/**
 * String alinda bir siniftir. Referance turunde degisken tanimi yapilabilir.
 */

public class String1Constructor {

	public static void main(String[] args) {
		char[] karakterDizisi = { 'b', 'i', 'r', 't', 'h', ' ', 'd', 'a', 'y' };
		String s = new String("hello");

		String s1 = new String();
		String s2 = new String(s);
		String s3 = new String(karakterDizisi);
		String s4 = new String(karakterDizisi, 6, 3);

		System.out.printf("\ns1 = %s\ns2 = %s\ns3 = %s\ns4 = %s\n", s1, s2, s3, s4);

	} // end main()

} // end class