/**
 * equals metodu belirtilen degiskenin icerigini karsilastirir == parametresi
 * ise referans degerlerinin karsilastirir. == parmetresi sadece primitive type
 * degiskenlerde icerige bakar.
 */
public class String3Equals {

	public static void main(String[] args) {

		String string1 = "Hello Metin !";
		String string2 = string1;

		// PRIMITIVE TYPE oldugu icin icerige bakilir.
		if (string1 == string2)
			System.out.println("ESIT!");
		else
			System.out.println("ESIT DEGIL!");

		String string3 = new String("Hello Metin !");

		// string1 ve string3 ayni icerige sahip olmasina ragmen.
		// string1 = primitive type, string3 = referance type
		// oldugu icin ve gosterdikleri referanslar farkli oldugundan
		// esit degildir.
		if (string1 == string3) //
			System.out.println("ESIT!");
		else
			System.out.println("ESIT DEGIL!");

		// equals methodu string1 ve string degiskenlerinin iceriklerini
		// kiyasladigi icin islem ESIT olacaktir
		if (string1.equals(string3))
			System.out.println("ESIT!");
		else
			System.out.println("ESIT DEGIL!");

	} // end main()

} // end class