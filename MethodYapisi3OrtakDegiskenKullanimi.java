public class MethodYapisi3OrtakDegiskenKullanimi {

	static int sayi = 8; // SINIF DEGISKENI

	public static void main(String[] args) {

		System.out.printf("Main methodu baslangicinda \"sayi = %d\"\nDegiskeninin ilk degeri \"%d\"\n\n", sayi, sayi);
		System.out.println("-----------");
		SayininBesKati();
		System.out.println("-----------");
		SayininOnKati();

	}

	public static void SayininBesKati() {
		int test = 88; // LOKAL DEGISKEN sadece tanimlandigi method da gecerli
		sayi *= 5;
		System.out.println("Sinif degiskeninin degerini 5 ile carptim : " + sayi);
		System.out.printf("Lokal degisken olan \"test\" = %d\n", test);
	}

	public static void SayininOnKati() {
		int test = 99; // LOKAL DEGISKEN sadece tanimlandigi method da gecerli
		sayi *= 10;
		System.out.println("Sinif degiskeninin degerini 10 ile carptim : " + sayi);
		System.out.printf("Lokal degisken olan \"test\" = %d\n", test);
	}

}
