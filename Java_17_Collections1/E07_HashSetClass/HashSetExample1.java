package E07_HashSetClass;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("all")
public class HashSetExample1 {

	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		String cumle = veri.nextLine();

		Set<String> s = new HashSet<String>();
		for (String a : cumle.split(" "))
			if (!s.add(a))
				System.out.println("Tekrarlanan kelime :" + a);

		System.out.println(s.size() + " benzersiz : " + s);
	}
}
