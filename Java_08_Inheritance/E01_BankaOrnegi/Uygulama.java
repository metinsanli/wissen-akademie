package E01_BankaOrnegi;

public class Uygulama {

	public static void main(String[] args) {

		Kurumsal sabanci = new Kurumsal();
		Musteri ahmet = new Musteri();

		sabanci.setBakiye(5);
		sabanci.hesapNo = "76986";
		sabanci.paraYatir(15);
		System.out.println(sabanci.getBakiye());

		ahmet.setBakiye(60.5);
		ahmet.hesapNo = "45678";
		ahmet.musteriAdi = "Metin Sanli";
		ahmet.musteriTur = 'B';
		System.out.println(ahmet.hesapNo + " = " + ahmet.getBakiye());

	} // end main()

} // end class
