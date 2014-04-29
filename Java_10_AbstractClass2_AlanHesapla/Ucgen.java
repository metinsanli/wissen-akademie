public class Ucgen extends Sekil {

	Ucgen(double a, double b) {
		super(a, b);
	} // end constructor

	@Override
	double alan() {
		System.out.println("Ucgenin alani :");
		return (boyut1 * boyut2) / 2;
	} // end abstract method alan()

} // end class
