package E01_EnumType;
public class Uygulama {

	public static void main(String[] args) {

		Sehir istanbul = new Sehir("Istanbul", Bolge.MARMARA);

		System.out.println(istanbul + " " + istanbul.getBolge().getBolgeKodu());

	} // end method main()

} // END CLASS
