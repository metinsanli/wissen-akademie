package E01_StringMethods;

public class String10UpperLower {

	public static void main(String[] args) {

		String kelime1 = "hello";
		String kelime2 = "GOODBye";
		String kelime3 = " spaces";

		System.out.printf("\n1. Kelime = %s\n2. Kelime = %s\n3. Kelime = %s\n\n", kelime1, kelime2, kelime3);

		// Harf Degistirme
		System.out.printf("\n1. Kelimedeki kucuk 'l'yi buyuk 'L' ile deistir : %s\n", kelime1.replace('l', 'L'));

		// Buyuk-Kucuk Harf Donusturme
		System.out.printf("\n1. Kelimeyi buyuk yap = %s\n", kelime1.toUpperCase());
		System.out.printf("\n2. Kelimeyi kucuk yap = %s\n", kelime2.toLowerCase());

		// Sagdaki Soldaki Bosluklari Alma
		System.out.printf("\n3. Kelimedeki bosluklari al = \"%s\"\n", kelime3.trim());

		// Kelimeyi diziye Cevirme
		char[] kelimeDizisi = kelime1.toCharArray();
		System.out.printf("\n1. Kelimeyi diziye cevir = ");
		for (int i = 0; i < kelimeDizisi.length; i++) {
			System.out.printf("\n%s", kelimeDizisi[i]);
		}

	} // end main()

} // end class