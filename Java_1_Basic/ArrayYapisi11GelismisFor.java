/* Diziler icin ozel olarak kullanilabilen dongu turu
 * bir degisken tanimlanir
 */

public class ArrayYapisi11GelismisFor {

	public static void main(String[] args) {
		int[] dizi = { 65, 23, 45, 98, 65, 45, 12, 25, 69, 47 };
		int toplam = 0;

		for (int sayilar : dizi)
			toplam += sayilar;

		System.out.println("Toplam = " + toplam);

	}

}
