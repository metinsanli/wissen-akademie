package E07_HashSetClass;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample4Donusumler {

	public static void main(String[] args) {

		String[] iller = { "Istanbul", "ankara", "bursa", "giresun", "tunceli", "antalya", "istanbul", "izmir", "tunceli", "antalya" };

		List<String> illerListesi = Arrays.asList(iller); // String[] "iller" dizisi List turunde nesneye donusturuldu.

		benzersizIller(illerListesi);

	} // end method main()

	public static void benzersizIller(Collection<String> elemanlar) {

		// elemanlar Set turunde yaratilan kume nesnesine HashSet ozellikleri ile verildigi icin
		// benzersiz olan degerler alinacaktir. Bir filtre gibi calisiyor.
		Set<String> kume = new HashSet<String>(elemanlar); // Polimorfizm

		System.out.printf("\nDizinin icerigi (%d tane)\t: ", elemanlar.size());
		for (String il : elemanlar)
			System.out.printf("%s ", il);

		System.out.printf("\nBenzersiz degerler (%d tane)\t: ", kume.size());
		for (String il : kume)
			System.out.printf("%s ", il);

		System.out.println();

	} // end method bezersizIller()

} // END CLASS
