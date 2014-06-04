package E07_HashSetClass;

import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings("all")
public class HashSetExample2 {

	public static void main(String[] args) {

		HashSet<String> newset = new HashSet<String>();

		newset.add("Learning");
		newset.add("Easy");
		newset.add("Simply");
		newset.add("Difficult");
		newset.add(null);
		newset.add(null);

		Iterator iterator = newset.iterator();

		while (iterator.hasNext()) {
			System.out.println("Value : " + iterator.next());
		}

	}

}
