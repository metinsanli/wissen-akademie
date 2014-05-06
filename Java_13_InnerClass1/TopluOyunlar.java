public class TopluOyunlar {

	static Oyun oyun1 = new Oyun("Futbol", 11.0);
	static Oyun oyun2 = new Oyun("Voleybol", 9.0);
	static Oyuncu oyuncu = new Oyuncu();
	static Oyun tenis = new Oyun("Tenis", 3.0);
	// Inner classtan bir nesneyi ancak asagidaki gibi olusturabiliriz.
	static Oyun.Ball gameTop = tenis.new Ball(3.0);

	public static void main(String[] args) {

		oyuncu.oyuncuMevki = "Kaleci";
		oyuncu.formaNo = "1";
		oyun1.oyuncular.add(oyuncu);

		System.out.println("Futbol Topunun Hacmi : " + oyun1.oyunTopu.hacim + " cm3");
		System.out.println("Volume of a Soccer Ball : " + oyun1.gameBall.hacim + " cm3");
		System.out.println("Topun Kullanildigi Oyun : " + oyun1.oyunTopu.oyun.oyunAdi);
		System.out.println("Topun Kullanildigi Oyun : " + oyun2.gameBall.oyun);
		System.out.println("gameTop nesnesinin oyunu : " + gameTop.oyun);

	}

}
