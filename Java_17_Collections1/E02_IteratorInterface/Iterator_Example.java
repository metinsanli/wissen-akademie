package E2_IteratorInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

@SuppressWarnings("all")
public class Iterator_Example {

	public static void main(String args[]) {

		ArrayList<String> al = new ArrayList();

		al.add("CAN");
		al.add("Ali");
		al.add("Emre");
		al.add("BORA");
		al.add("Deniz");
		al.add("Fatma");

		System.out.println("Koleksiyonun ilk hali : ");
		Iterator itr = al.iterator(); // ITERATOR INTERFACE

		while (itr.hasNext()) {
			Object element = itr.next();
			String eleman = (String) element;
			System.out.print(eleman.toLowerCase() + " ");
		}

		// Collections.sort()
		System.out.println("\n\nArtan siralama yapilmis dizi : ");
		Collections.sort(al);// Artan sekilde siralama yapiliyor
		itr = al.iterator(); // al icindeki bilgilerin sirasi degisti bunu itr ye tekrar atiyoruz.
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}

		// Collections.reverseOrder()
		Collections.sort(al, Collections.reverseOrder()); // al icindeki bilgileri azalan sirayla tekrar diz.
		ListIterator listitr = al.listIterator(); // LISTITERATOR
		while (listitr.hasNext()) {
			Object element = listitr.next();
			listitr.set(element + "***");
		}
		System.out.println("\n\nDegistirilmis dizi : ");
		itr = al.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}

		// previous()
		System.out.println("\n\nDizininson halini sondan basa yazdir : ");
		while (listitr.hasPrevious()) {
			Object element = listitr.previous();
			System.out.print(element + " ");
		}

	} // end main

} // END CLASS
