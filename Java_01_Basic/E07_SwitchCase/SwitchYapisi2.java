package E07_SwitchCase;
/*
 *  "BREAK" OLMADAN SWITCH ORNEGI
 */

public class SwitchYapisi2 {

	public static void main(String[] args) {
		int sayi = 2; // deger degistirerek ornek anlasilabilir.
		switch (sayi) {
		case 0:
			System.out.println(" sayi 0 ");
		case 1:
			System.out.println(" sayi 1 ");
		case 2:
			System.out.println(" sayi 2 ");
		default:
			System.out.println(" sayi default");
		}

	}

}
