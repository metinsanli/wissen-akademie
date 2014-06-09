package E02_IfElse;
import java.util.Scanner;

public class IfYapisi8BurcTespiti {

	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);
		int ay, gun;

		System.out.print("Hangi ay dogdunuz?  (1..12) : ");
		ay = veri.nextInt();
		System.out.print("Hangi gun dogdunuz? (1..31) : ");
		gun = veri.nextInt();
		veri.close();

		if (!(ay >= 1 || ay >= 12) && (gun >= 1 || gun <= 31))
			System.out.println("Hatali giris yaptiniz !!");
		else if ((ay == 3 && gun >= 21) || (ay == 4 && gun <= 20))
			System.out.println("Koc");
		else if ((ay == 4 && gun >= 21) || (ay == 5 && gun <= 20))
			System.out.println("Boga");
		else if ((ay == 5 && gun >= 21) || (ay == 6 && gun <= 21))
			System.out.println("Ikizler");
		else if ((ay == 6 && gun >= 22) || (ay == 7 && gun <= 22))
			System.out.println("Yengec");
		else if ((ay == 7 && gun >= 23) || (ay == 8 && gun <= 22))
			System.out.println("Aslan");
		else if ((ay == 8 && gun >= 23) || (ay == 9 && gun <= 22))
			System.out.println("Basak");
		else if ((ay == 9 && gun >= 23) || (ay == 10 && gun <= 23))
			System.out.println("Terazi");
		else if ((ay == 10 && gun >= 24) || (ay == 11 && gun <= 22))
			System.out.println("Akrep");
		else if ((ay == 11 && gun >= 23) || (ay == 12 && gun <= 21))
			System.out.println("Yay");
		else if ((ay == 12 && gun >= 22) || (ay == 1 && gun <= 20))
			System.out.println("Oglak");
		else if ((ay == 1 && gun >= 21) || (ay == 2 && gun <= 18))
			System.out.println("Kova");
		else if ((ay == 2 && gun >= 19) || (ay == 3 && gun <= 20))
			System.out.println("Balik");

	}
}
