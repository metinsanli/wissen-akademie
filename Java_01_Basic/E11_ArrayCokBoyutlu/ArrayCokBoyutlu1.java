package E11_ArrayCokBoyutlu;
public class ArrayCokBoyutlu1 {

	public static void main(String[] args) {
		int[][] dizi2D = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		System.out.println("dizi2D uzunlugu = " + dizi2D.length);

		for (int i = 0; i < dizi2D.length; i++) {
			for (int j = 0; j < dizi2D[0].length; j++)
				System.out.print("\ndizi2D [" + i + "][" + j + "]=" + dizi2D[i][j]);
			System.out.println();
		}
	}
}
