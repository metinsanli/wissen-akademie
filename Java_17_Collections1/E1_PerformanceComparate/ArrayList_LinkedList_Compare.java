package E1_PerformanceComparate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class ArrayList_LinkedList_Compare {

	static final int SIZE = 10000000;

	public static long timeList(List list) {
		long start = System.currentTimeMillis();
		Object obj = new Object();
		for (int i = 0; i < SIZE; i++) {
			list.add(obj);
		}
		return System.currentTimeMillis() - start;
	}

	public static void main(String[] args) {
		System.out.println("LinkedList ekleme suresi = " + timeList(new LinkedList()));
		System.out.println("ArrayList ekleme suresi = " + timeList(new ArrayList()));
		// DUSUK CIKAN DEGER DAHA IYIDIR.
	}

}
