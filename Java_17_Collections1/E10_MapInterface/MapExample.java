package E10_MapInterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
public class MapExample {

	public static void main(String[] args) {
		// Map bir INTERFACE oldugundan, somut(concrete) bir uygulamasina
		// ihtiyacimiz olacak.

		Map map = new HashMap(); // MAP bir tur'dur hashmap onu implement etmis bir siniftir.

		map.put(new Integer(2), "Two");
		map.put(new Integer(1), "One");
		map.put(new Integer(3), "Three");
		map.put(new Integer(4), "Four");

		Set set = map.entrySet(); // MAP elemani SET e donusturuyor.

		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			
			Map.Entry entry = (Map.Entry) iterator.next();

			int key = (Integer) entry.getKey(); // KEY i al.
			String deger = (String) entry.getValue(); // VALUE yi al.

			System.out.println("Key : " + key + "\tValue : " + deger);
		}

	}

} // <E> generic tur
