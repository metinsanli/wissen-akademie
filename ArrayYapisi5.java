public class ArrayYapisi5 {

	public static void main(String[] args) {
		String[] arabalar = { "Opel", "Mercedes", "Volvo", "Toyota", "Daihatsu", "Volkswagen" };

		for (int i = 0; i < arabalar.length; i++)
			System.out.println(i + " : " + arabalar[i]);
		System.out.println("--------------------");

		arabalar[0] = "BMW"; // 0. indise yeni deger atandi "BMW"
		arabalar[2] = "PORCHE"; // 2. indise yeni deger atandi "PORCHE"

		for (int i = 0; i < arabalar.length; i++)
			System.out.println(i + " : " + arabalar[i]);

	}
}
