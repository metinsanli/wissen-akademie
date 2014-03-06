public class ArrayYapisi4 {

	public static void main(String[] args) {
		final int SABIT_VERI = 10; // Degistirilemez sabit degisken tanimlandi
		int[] dizi = new int[SABIT_VERI];

		for (int sayac = 0; sayac < dizi.length; sayac++)
			dizi[sayac] = 2 + 2 * sayac;

		System.out.printf("%s%8s\n", "Indis", "Deger");

		for (int sayac = 0; sayac < dizi.length; sayac++)
			System.out.printf("%5d%8d\n", sayac, dizi[sayac]);

	}
}