package E08_TreeSetClass;

import java.util.Iterator;
import java.util.TreeSet;

@SuppressWarnings("all")
public class TreeSetExample1 {

	public static void main(String[] args) {

		System.out.println("Tree Set Example!\n");

		TreeSet<Integer> tree = new TreeSet<Integer>();

		tree.add(92);
		tree.add(23);
		tree.add(14);
		tree.add(45);

		Iterator iterator;
		iterator = tree.iterator(); // ITERATOR OLUSTURULDU.

		System.out.print("Tree set data: ");

		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");

		System.out.println("\n");

		if (tree.isEmpty())
			System.out.print("\nTree Set is empty.");
		else
			System.out.println("Tree Set size: " + tree.size());

		System.out.println("\nFirst Data: " + tree.first());

		System.out.println("Last Data: " + tree.last());

		if (tree.remove(23))
			System.out.print("\n\"23\" Data is removed from tree set : ");
		else
			System.out.println("Data doesn!t exist!");

		iterator = tree.iterator();

		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");

		System.out.println();

		System.out.println("\nNow the size of tree set: " + tree.size());
		tree.clear();

		if (tree.isEmpty())
			System.out.println("\nTree is empty.");
		else
			System.out.println("Tree Set size: " + tree.size());
	}
}
