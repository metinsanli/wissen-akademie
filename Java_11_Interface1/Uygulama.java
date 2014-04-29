import java.util.Enumeration;
import java.util.Vector;

public class Uygulama {

	public static void main(String[] args) {

		Vector<Sekil> s = new Vector<Sekil>();
		s.addElement(new Daire());
		s.addElement(new Kare());
		s.addElement(new Ucgen());

		Enumeration<Sekil> e = s.elements();

		while (e.hasMoreElements())
			((Sekil) e.nextElement()).ciz();

	} // end main()

} // end class
