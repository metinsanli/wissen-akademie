package E11_QueueInterface;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class LinkedListExample {

	public static void main(String[] args) {

		Queue<String> qe = new LinkedList<String>();

		qe.add("b");
		qe.add("a");
		qe.add("c");
		qe.add("e");
		qe.add("d");

		Iterator it = qe.iterator();

		System.out.println("Initial Size of Qeue : " + qe.size());
		while (it.hasNext()) {
			String value = (String) it.next();
			System.out.println("Qeue Next Value : " + value);
		}

		System.out.println("Qeue peek : " + qe.peek());

		while (!qe.isEmpty()) {
			System.out.println("Qeue poll : " + qe.poll());
		}

		System.out.println("Final Size of Qeue : " + qe.size());

	}

}
