import java.util.Scanner;

public class IfYapisi6EqualsIgnoreCase {
	public static void main(String[] args) {
		Scanner veri = new Scanner(System.in);

		System.out.print("en sevdiginiz mevsim ? :");
		String mevsim = "";
		mevsim = veri.nextLine();

		if (mevsim.equalsIgnoreCase("ilkbahar")) {
			System.out.println("yeni bir baslangic! her yer yesil..!");
		} else if (mevsim.equalsIgnoreCase("yaz")) {
			System.out.println("tatil, deniz, gunes...");
		} else if (mevsim.equalsIgnoreCase("sonbahar")) {
			System.out.println("romatik bir mevsim sararmis yapraklar...");
		} else if (mevsim.equalsIgnoreCase("kis")) {
			System.out.println("yagmur, camur, kar..!");
		} else {
			System.out.println("boyle bir mevsim yok!!!");
		} // end if

		veri.close();

	}// end main
}// end class
