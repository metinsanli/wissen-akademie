public class Dikdortgen extends Sekil {

	Dikdortgen(double a, double b) {
		super(a, b);
	} // end constructor

	@Override
	double alan() {
		System.out.println("Dikdortgenin alani : ");
		return boyut1 * boyut2;
	} // end abstract method alan()

} // end class
