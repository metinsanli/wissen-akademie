package E02_AlanHesapla;

/**
 * @author metin Eger bir sinifi icerisinde bir tane dahi abstract degisken veya method barindirirsa
 *         o sinif abstract sinifdir. Ve "class" ifadesinin onune "abstract" ifadesini alir.
 */

abstract class Sekil {

	double boyut1;
	double boyut2;

	Sekil(double a, double b) {
		boyut1 = a;
		boyut2 = b;
	} // end constructor

	abstract double alan();

} // end class
