package E01_EnumType;
@SuppressWarnings("all")
public enum Bolge {

	EGE("E"), AKDENIZ("A"), GUNEYDOGUANADOLU("GDA"), DOGUANADOLU("DA"), ICANADOLU("IA"), DOGUKARADENIZ("DK"), BATIKARADENIZ("BK"), MARMARA("M");

	private String bolge;

	private Bolge(String s) {
		bolge = s;
	} // end constructor

	public String getBolgeKodu() {
		return bolge;
	} // end method

} // END ENUM
