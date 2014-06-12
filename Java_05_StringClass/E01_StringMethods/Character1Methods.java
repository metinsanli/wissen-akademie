package E01_StringMethods;

/** Character sinifi tanitim
 * isDefined()				: ASCII 65536 adet tanimlanmis karaktere uygunmu? (true/false)
 * isDigit()				: Sayimi? (true/false)
 * isLetter()				: Harfmi? (true/false)
 * isLetterOrDigit()		: Harfmi sayimi? (true/false) 
 * isLowerCase()			: Kucuk harfmi? (true/false)
 * isUpperCase()			: Buyuk harfmi?(true/false)
 * toLowerCase()			: 
 * toUpperCase()			:  
 * isJavaIdentifierStart()	: Java dilinde degisken ismi olarak baslayabilirmi? (true/false)
 * isJavaIdentifierPart()	: 
 */

import java.util.Scanner;

public class Character1Methods {

	public static void main(String[] args) {

		Scanner veri = new Scanner(System.in);
		System.out.printf("\nEnter a character and press enter > ");
		String input = veri.next();
		char c = input.charAt(0); // get input character

		// display charachter info
		System.out.printf("\nis defined\t\t: %b\n", Character.isDefined(c));
		System.out.printf("\nis digit\t\t: %b\n", Character.isDigit(c));
		System.out.printf("\nis letter\t\t: %b\n", Character.isLetter(c));
		System.out.printf("\nis letter or digit\t: %b\n", Character.isLetterOrDigit(c));
		System.out.printf("\nis lower case\t\t: %b\n", Character.isLowerCase(c));
		System.out.printf("\nis upper case\t\t: %b\n", Character.isUpperCase(c));
		System.out.printf("\nto lower case\t\t: %b\n", Character.toLowerCase(c));
		System.out.printf("\nto upper case\t\t: %b\n", Character.toUpperCase(c));
		System.out.printf("\nis first character in a Java identifier : %b\n", Character.isJavaIdentifierStart(c));
		System.out.printf("\nis part of a Java identifier\t\t: %b\n", Character.isJavaIdentifierPart(c));

		veri.close();
	} // end main()

} // end class