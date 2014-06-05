package E10_MapInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@SuppressWarnings("all")
public class HashMapExample {

	public static void main(String[] args) {

		// Ciktinin key degerine sirali olmasi istenirse.
		 Map<String, Integer> m = new HashMap<String, Integer>();

		//Map<String, Integer> m = new TreeMap<String, Integer>();

		Scanner veri = new Scanner(System.in);

		String cumle = veri.nextLine();

		for (String a : cumle.split(" ")) {
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}

		System.out.println(m.size() + " distinct words : ");
		System.out.println(m);
	}
}
