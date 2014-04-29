/**
 * charAt() getChars() reverse()
 */

public class StringBuilder2Char {

	public static void main(String[] args) {

		StringBuilder buffer = new StringBuilder("hello there");

		System.out.printf("\nbuffer = %s\n", buffer.toString());
		System.out.printf("\ncharacter at 0 = %s\ncharacter at 4 = %s\n", buffer.charAt(0), buffer.charAt(4));

		char[] charArray = new char[buffer.length()];
		buffer.getChars(0, buffer.length(), charArray, 0);

		System.out.printf("\nThe characters are: ");
		for (char character : charArray)
			System.out.print(character);

		buffer.setCharAt(0, 'H');
		buffer.setCharAt(6, 'T');
		System.out.printf("\nbuffer = %s\n", buffer.toString());

		buffer.reverse();
		System.out.printf("\nbuffer = %s\n", buffer.toString());

	} // end mian()

} // end class