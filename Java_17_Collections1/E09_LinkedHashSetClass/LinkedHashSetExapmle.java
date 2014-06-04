package E09_LinkedHashSetClass;

import java.util.HashSet;
import java.util.LinkedHashSet;

@SuppressWarnings("all")
public class LinkedHashSetExapmle {

	public static void main(String[] args) {

		LinkedHashSet lhs = new LinkedHashSet();
		HashSet hs = new HashSet();

		lhs.add("B");
		hs.add("B");
		lhs.add("A");
		hs.add("A");
		lhs.add("D");
		hs.add("D");
		lhs.add("E");
		hs.add("E");
		lhs.add("C");
		hs.add("C");
		lhs.add("F");
		hs.add("F");
		lhs.add("A");
		hs.add("A");

		System.out.println("HashSet\t\t: " + hs + "\t siralaniyor.");
		System.out.println("LinkedHashSet\t: " + lhs);

	}

}
