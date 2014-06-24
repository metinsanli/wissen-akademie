package java08_RegularExpression;

public class Kiyas {

	public static boolean kiyasIsim(String deger) {
		return deger.matches("\\d\\D\\W\\s");
	}// end method kiyasIsim()

	public static void main(String[] args) {

		System.out.println(Kiyas.kiyasIsim("1&  ") ? "Dogru.\n" : "Yanlis!");

		System.out.println("1\t= " + "1".matches("\\d"));
		System.out.println("23\t= " + "23".matches("\\d\\d"));
		System.out.println("*\t= " + "*".matches("\\D"));
		System.out.println("A!\t= " + "A!".matches("\\D\\D"));
		
		System.out.println("B\t= " + "B".matches("\\w"));
		System.out.println("2E\t= " + "2E".matches("\\w\\w"));
		System.out.println("&\t= " + "&".matches("\\W"));
		System.out.println("!^\t= " + "!^".matches("\\W\\W"));
		
		System.out.println("[SPACE]\t= " + " ".matches("\\s"));
		System.out.println("[TAB][TAB]\t= " + "		".matches("\\s\\s"));
		System.out.println("1\t= " + "1".matches("\\S"));
		System.out.println("R4\t= " + "R4".matches("\\S\\S"));
		
		System.out.println("Metin\t= " + "Metin".matches("[A-Z][a-zA-Z]*"));
		System.out.println("ME\t= " + "ME".matches("[A-Z]{2}"));
		System.out.println("MEtini\t= " + "MEtini".matches("[A-Z]{2}[a-zA-Z]{1,4}"));
		System.out.println("MET432\t= " + "MET432".matches("[A-Z]{3}[1-9]{3}"));
		System.out.println("MET432\t= " + "MET432".matches("[A-Z]{3}[1-9]{3}?"));

	} // end method main()

} // END CLASS
