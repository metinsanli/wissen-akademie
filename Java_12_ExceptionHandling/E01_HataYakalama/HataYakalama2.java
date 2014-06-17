package E01_HataYakalama;

public class HataYakalama2 {

	public static void HataUret() throws Exception {

		try {
			System.out.println("1-Bilerek hata uretiyorum...");
			throw new Exception("Hey"); // hata uret
			// System.out.println("Bu satiri hic goremeyeceksin :)");
		} // end try

		catch (Exception e1) {
			System.out.println("2-Az once urettigim hatayi yakaladim...");
			System.out.println("3-Simdi hatayi main methoduna firlatiyorum...");
			throw e1; // Alinan hatayi bir ust methoda firlat
		} // end catch

		finally {
			System.out.println("4-Hata Uret, Finally blogunun icindeyim." + "Henuz main methoduna cikamadim!");
		} // end finally

	} // end method HataUret

	public static void HataYok() {
		try {
			System.out.println("7-Hata yok! Try Block. Bu nomrmal calisma...");
		} catch (Exception e3) {
			System.out.println("8-Hata yok! Catch Block");
		} finally {
			System.out.println("9-Hata yok! Finally Block. Ama hata olmasada calisir.");
		}
	} // end method HataYok()

	public static void main(String[] args) {
		try {
			HataUret();
			System.out.println("5-Bu satiri da asla goremezsin!");
		} catch (Exception e2) {
			System.out.println("6-Main methodunda yeniden yakalandim...");
		}

		HataYok();
	} // end main()

} // end class
