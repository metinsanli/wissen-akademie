/**
 * insert() delete()
 */

public class StringBuilder4InsertDelete {

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

		StringBuilder buffer = new StringBuilder();

		// INSERTION
		buffer.insert(0, objectRef);
		buffer.insert(0, " ");
		buffer.insert(0, string);
		buffer.insert(0, " ");
		buffer.insert(0, charArray);
		buffer.insert(0, " ");
		buffer.insert(0, charArray, 3, 3);
		buffer.insert(0, " ");
		buffer.insert(0, booleanValue);
		buffer.insert(0, " ");
		buffer.insert(0, characterValue);
		buffer.insert(0, " ");
		buffer.insert(0, integerValue);
		buffer.insert(0, " ");
		buffer.insert(0, longValue);
		buffer.insert(0, " ");
		buffer.insert(0, floatValue);
		buffer.insert(0, " ");
		buffer.insert(0, doubleValue);
		System.out.printf("\nbuffer after insert: \n\n%s\n", buffer.toString());

		// DELETION
		buffer.deleteCharAt(10);
		buffer.delete(2, 6);
		System.out.printf("\nbuffer after deletes:\n\n%s\n", buffer.toString());

	} // end main()

} // end class