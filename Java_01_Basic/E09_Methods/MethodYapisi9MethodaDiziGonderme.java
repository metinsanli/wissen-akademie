package E09_Methods;
public class MethodYapisi9MethodaDiziGonderme {

	public static void main(String[] args) {
		int[] dizi = { 1, 2, 3, 4, 5 };
		int sayi = 5;
		System.out.printf("\n** Dizilerin referans olarak Method icine alinmasi **\n" + "\nDizinin elemanlarinin ilk degerleri : ");

		for (int deger : dizi)
			System.out.printf(" %d", deger);

		System.out.printf("\n\nSayi = %d\n", sayi);
		modifyArray(dizi, sayi);

		System.out.printf("\nDegistirilen dizinin yeni elemanlari :");
		/*
		 * Methodlara dizinin kendisi gonderildiginde uzerinde islem yapilan tum
		 * elemanlarinin degerleri degistirilir.
		 */
		for (int deger : dizi)
			System.out.printf(" %d", deger);

		System.out.printf("\n\nSayi = %d\n", sayi);

		System.out.printf("\n\n** Dizi elemanlarinin arguman olarak gecilmesi **\n " + "\ndizi[3] degismeden sonra : %d\n", dizi[3]);
		modifyElement(dizi[3]);
		System.out.printf("dizi[3] degistirildikten sonra : %d\n", dizi[3]);
	}

	public static void modifyArray(int[] dizi2, Integer s) {
		for (int sayac = 0; sayac < dizi2.length; sayac++)
			dizi2[sayac] *= 2;
		s *= 2;
	}

	public static void modifyElement(int element) {
		element *= 2;
		System.out.printf("Dizi elemani modefiyelement methodu icinde : %d\n", element);
	}
}