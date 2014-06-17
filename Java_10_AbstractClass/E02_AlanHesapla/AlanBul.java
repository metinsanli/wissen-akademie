package E02_AlanHesapla;

public class AlanBul {

	public static void main(String[] args) {

		// Sekil s = new Sekil(3, 5); // nesne tanimi gecersizdir!
		// Soyut sinifa ait nesne yaratilamaz.

		Dikdortgen ddgen = new Dikdortgen(9, 5);
		Ucgen ugen = new Ucgen(10, 8);
		Sekil ref; // ref degisken olarak tanimlandi, nesne yaratilmadi!

		ref = ddgen; // ref alt sinifa ait bir degiskeni isaret ediyor.
		System.out.println("Alan : " + ref.alan());

		ref = ugen; // ref alt sinifa ait baska bir degiskeni isaret ediyor.
		System.out.println("Alan : " + ref.alan());

	} // end main()

} // end class
