public class String6Index {

	public static void main(String[] args) {

		String harfler = "abcdefghijklmabcdefghijklm";
		System.out.println(harfler);

		// indexOf(char)
		System.out.printf("\nIlk 'c' harfi %d. indextedir.", harfler.indexOf('c'));
		System.out.printf("\nIlk 'a' harfi %d. indextedir.", harfler.indexOf('a', 1));
		System.out.printf("\nIlk '$' harfi %d. indextedir.\n", harfler.indexOf('$'));

		// lastIndexOf(char)
		System.out.printf("\nEn son 'c' harfi %d. indextedir.", harfler.lastIndexOf('c'));
		System.out.printf("\nEn son 'a' harfi %d. indextedir.", harfler.lastIndexOf('a'), 25);
		System.out.printf("\nEn son '$' harfi %d. indextedir.\n", harfler.lastIndexOf('$'));

		// indexOf(string)
		System.out.printf("\nIlk 'def' kelimesi %d. indextedir.", harfler.indexOf("def"));
		System.out.printf("\nIlk 'def' kelimesi %d. indextedir.", harfler.indexOf("def", 7));
		System.out.printf("\nIlk 'hello' kelimesi %d. indextedir.\n", harfler.indexOf("hello"));

		// lastIndexOf(string)
		System.out.printf("\nEn son 'def' kelimesi %d. indextedir.", harfler.lastIndexOf("def"));
		System.out.printf("\nEn son 'def' kelimesi %d. indextedir.", harfler.indexOf("def", 25));
		System.out.printf("\nEn son 'hello' kelimesi %d. indextedir.\n", harfler.indexOf("hello"));
	}

}
