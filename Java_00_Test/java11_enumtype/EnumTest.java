package java11_enumtype;

@SuppressWarnings("all")
public class EnumTest {

	public enum Gun {
		PAZARTESI, SALI, CARSAMBA, PERSEMBE, CUMA, CUMARTESI, PAZAR
	};

	public Gun gun; // sinif degiskeni

	public EnumTest(Gun gun) {
		this.gun = gun;
	} // end constructor

	public void soyleBana() {
		switch (gun) {
			case PAZARTESI:
				System.out.println("Haftanin ilk gunu..");
				break;
			case SALI:
				System.out.println("Sali sallanir.");
				break;
			case CARSAMBA:
				System.out.println("Carsamba carsafa dolanir.");
				break;
			case PERSEMBE:
				System.out.println("Persembe perisanliktir.");
				break;
			case CUMA:
				System.out.println("Cuma mubarek gun.");
				break;
			case CUMARTESI:
				System.out.println("Cumartesi resmi tatil.");
				break;
			case PAZAR:
				System.out.println("Pazar resmi tatil.");
				break;
		}
	} // end method

	public static void main(String[] args) {

		EnumTest ilkGun = new EnumTest(Gun.PAZARTESI);
		ilkGun.soyleBana();

		EnumTest ikinciGun = new EnumTest(Gun.SALI);
		ikinciGun.soyleBana();

	} // end method main()

} // END CLASS
