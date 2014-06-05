package E02_EnumMap;

import java.util.EnumMap;

import javax.smartcardio.CardException;

@SuppressWarnings("all")
public class EnumExample {

	public static void main(String[] args) {

		EnumMap cars = new EnumMap(Car.class);

		cars.put(Car.BMW, Car.BMW.getPrice());
		cars.put(Car.AUDI, Car.AUDI.getPrice());
		cars.put(Car.MERCEDES, Car.MERCEDES.getPrice());

		for (Object o : cars.keySet())
			System.out.println(((Car) o).name());

		System.out.println(cars.size());

		cars.remove(Car.BMW);

		System.out.println("After removing Car.BMW, size: " + cars.size());

		cars.put(Car.valueOf("BMW"), Car.BMW.getPrice());
		System.out.println("Size is now: " + cars.size());

	} // end method main()

} // END CLASS
