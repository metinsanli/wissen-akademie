public class Uygulama {

	public static void main(String[] args) {

		Kurumsal kurumsalMusteri = new Kurumsal();

		kurumsalMusteri.setBakiye(5);
		kurumsalMusteri.paraYatir(15);
		System.out.println(kurumsalMusteri.getBakiye());

	} // end main()

} // end class
