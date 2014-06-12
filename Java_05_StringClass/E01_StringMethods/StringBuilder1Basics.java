package E01_StringMethods;

/**
 * StringBuilder sinifi String sinifina alternatiftir.
 * 
 * toString() length() capacity() ensureCapacity() setLength()
 * 
 */

public class StringBuilder1Basics {

	public static void main(String[] args) {

		StringBuilder buffer = new StringBuilder("Hello, how are you?");

		System.out.printf("\nbuffer\t\t= %s\nlength\t\t= %d\ncapacity\t= %d\n", buffer.toString(), buffer.length(), buffer.capacity());

		buffer.ensureCapacity(75);
		System.out.printf("\nnew capacity\t= %d\n\n", buffer.capacity());

		buffer.setLength(10);
		System.out.printf("new length\t= %d\nbuffer\t\t= %s\n", buffer.length(), buffer.toString());

	} // end main()

} // end class