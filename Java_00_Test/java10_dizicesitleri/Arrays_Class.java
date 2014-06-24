package java10_dizicesitleri;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("all")
public class Arrays_Class {

	public static void main(String[] args) {

		int[] dizi1 = { 7, 3, 8, 1, 0, 2, 4, 9, 3, 5 };
		int[] dizi2 = { 7, 3, 8, 1, 0, 2, 4, 9, 3, 5 };

		// [1] "dizi1"in 0. indisinden dizi.length. indisine kadar 5 sayisini her indise ata.
		Arrays.fill(dizi1, 0, dizi1.length, 5);
		for (int temp : dizi1)
			System.out.print(temp + " ");

		// [2] dizi1 ile dizi2 yi karsilastir
		boolean karsilastir = Arrays.equals(dizi1, dizi2);
		System.out.println("\n\nDiziler " + (karsilastir ? "esit." : "esit degil!" + "\n"));

		// [3] dizi2 deki elemanlari artan sirala
		Arrays.sort(dizi2);
		for (int temp : dizi2)
			System.out.print(temp + " ");
		
		
	}
}
