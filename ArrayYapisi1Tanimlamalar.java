public class ArrayYapisi1Tanimlamalar {

	public static void main(String[] args) {

		int[] dizi;
		dizi = new int[10]; // 10 adet "int" turunde "dizi" isminde yer ayrildi.

		System.out.printf("%s%8s\n", "Index", "Value");

		for (int sayac = 0; sayac < dizi.length; sayac++)
			System.out.printf("%5d%8d\n", sayac, dizi[sayac]);

	} // end main
} // end class
