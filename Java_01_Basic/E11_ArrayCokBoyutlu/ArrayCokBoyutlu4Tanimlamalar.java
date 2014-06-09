package E11_ArrayCokBoyutlu;
public class ArrayCokBoyutlu4Tanimlamalar {

	public static void main(String[] args) {

		// en az bir boyutun insdis adedi belirtilmelidir.
		int[][] sayfa = new int[6][];

		// difer boyutu sonrasinda tanimlamamiz gerekir.
		for (int i = 0; i < sayfa.length; i++)
			sayfa[i] = new int[5];

		// her iki boyutuda gelismis for ile yazdir
		for (int[] satir : sayfa) {
			for (int hucre : satir)
				System.out.print(hucre + " ");
			System.out.println();
		}

	} // end main
} // end class