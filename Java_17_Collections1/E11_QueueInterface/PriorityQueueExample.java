package E11_QueueInterface;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<String>(11, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int population1 = Integer.parseInt(o1.split(":")[1].trim());
				int population2 = Integer.parseInt(o2.split(":")[1].trim());
				return population2 - population1;
			}
		}); // end queue

		queue.add("United States: 307006550");
		queue.add("Brazil: 193733800");
		queue.add("Russia: 141850000");
		queue.add("India: 1155347700");
		queue.add("China: 1331460000");

		System.out.println("Countries in database: " + queue.size());
		while (!queue.isEmpty()) {
			System.out.println(queue.poll()); // poll() yerine remove() metoduda kullanilabilir.
			// System.out.println(queue); // poll() kullandiktan sonra liste icindeki azalmayi gormek icin.
		}

		System.out.println("\nCountries in database: " + queue.size());

		// Bu ornek FIFO mantigina tam olarak uygun degil!
		// PriorityQueue() sinifi 
		// Tam FIFO mantiginda kullanmak icin LinkedList sinifindan nesne yaratilabilir.

	}

}
