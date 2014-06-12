package E01_StringMethods;

/**
 * append()
 */

public class StringBuilder3AppEnd {

	public static void main(String[] args) {

		Object objectRef = "hello";

		String string = "googbye";
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		boolean booleanValue = true;
		char characterValue = 'Z';
		int integerValue = 7;
		long longValue = 10000000000L;
		float floatValue = 2.5F;
		double doubleValue = 33.333;

		StringBuilder lastBuffer = new StringBuilder("hello");
		StringBuilder buffer = new StringBuilder();

		buffer.append(objectRef);
		buffer.append("\n");
		buffer.append(string);
		buffer.append("\n");
		buffer.append(charArray);
		buffer.append("\n");
		buffer.append(charArray, 0, 3);
		buffer.append("\n");
		buffer.append(booleanValue);
		buffer.append("\n");
		buffer.append(characterValue);
		buffer.append("\n");
		buffer.append(integerValue);
		buffer.append("\n");
		buffer.append(longValue);
		buffer.append("\n");
		buffer.append(floatValue);
		buffer.append("\n");
		buffer.append(doubleValue);
		buffer.append("\n");
		buffer.append(lastBuffer);

		System.out.printf("buffer contains:\n\n%s", buffer.toString());

	} // end main()

} // end class