public class ArrayYapisi2Atamalar {

	public static void main(String[] args) {

		int[] dizi = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };
		// 10 adet "int" turunde veri "dizi" isimli degiskene atandi.

		System.out.printf("%s%8s\n", "Index", "Value");

		for (int sayac = 0; sayac < dizi.length; sayac++)
			System.out.printf("%5d%8d\n", sayac, dizi[sayac]);

	} // end main

}
