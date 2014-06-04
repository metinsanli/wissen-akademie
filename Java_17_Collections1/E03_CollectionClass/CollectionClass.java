package E3_CollectionClass;

//Collections sınıfı metodları; reverse, fill, copy, max and min.
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class CollectionClass {

	public static void main(String[] args) {
		// List< Character > koleksiyonu tanımla
		Character[] letters = { 'V', 'O', 'L', 'K', 'A', 'N' };
		List<Character> list = Arrays.asList(letters); // diziyi liste içine aktar.
		System.out.println("'list' koleksiyonu içeriği: ");
		output(list);

		// reverse and display the List< Character >
		Collections.reverse(list); // reverse order the elements
		System.out.println("\n'reverse' metodu sonrası, list: ");
		output(list);

		// create copyList from an array of 3 Characters
		Character[] lettersCopy = new Character[6];
		List<Character> kopyaListe = Arrays.asList(lettersCopy);

		// copy the contents of list into copyList
		Collections.copy(kopyaListe, list);
		System.out.println("\n Kopyalamadan sonra, kopyaListe: ");
		output(kopyaListe);

		// fill list with Rs
		Collections.fill(list, 'W');
		System.out.println("\n'fill' metodu sonrası, list: ");
		output(list);

		// DENEME
		Collections.swap(kopyaListe, 0, 5);
		System.out.println("\nIlk iki eleman degisiminden sonra, kopyaListe: ");
		output(kopyaListe);

		// DENEME
		Collections.shuffle(kopyaListe);
		System.out.println("\nRandomdan sonra, kopyaListe: ");
		output(kopyaListe);

	} // end main
		// output List information

	private static void output(List<Character> listRef) {
		System.out.print("list: ");
		for (Character element : listRef)
			System.out.printf("%s ", element);
		System.out.printf("\nMax: %s", Collections.max(listRef));
		System.out.printf("Min: %s\n", Collections.min(listRef));
	} // end method output
} // end class