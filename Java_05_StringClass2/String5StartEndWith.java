public class String5StartEndWith {
	public static void main(String[] args) {

		String[] kelimeler = { "startded", "startting", "ended", "ending" };

		// test method startswith
		for (String kelime : kelimeler)
			if (kelime.startsWith("st"))
				System.out.printf("\"%s\" kelimesi \"st\" ile basliyor\n", kelime);

		System.out.println();

		// test method startswith starting from position 2 of string
		for (String kelime : kelimeler)
			if (kelime.startsWith("art", 2))
				System.out.printf("\"%s\" kelimesi 2. karakterinden sonra \"art\" ile basliyor\n", kelime);

		System.out.println();

		// test method endswith
		for (String kelime : kelimeler)
			if (kelime.endsWith("ed"))
				System.out.printf("\"%s\" kelimesi \"ed\" ile bitiyor\n", kelime);
	}
}
