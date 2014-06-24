package java11_enumtype;

@SuppressWarnings("all")
public class Uzay {

	public enum Gezegen {
		MERKUR(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), DUNYA(5.976e+24, 6.37814e6), MARS(6.421e+23, 3.3972e6), JUPITER(1.9e+27, 7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(
				8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);

		private final double kutle; // kilogram
		private final double cap; // metre

		Gezegen(double kutle, double cap) {
			this.kutle = kutle;
			this.cap = cap;
		}

	};

}
