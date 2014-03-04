public class SwitchYapisi4AygunSayilari {

	public static void main(String[] args) {
		int ay = 2;
		int yil = 2000;
		int gun = 0;

		switch (ay) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			gun = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			gun = 30;
			break;
		case 2:
			if (((yil % 4 == 0) && !(yil % 100 == 0)) || (yil % 400 == 0))
				gun = 29;
			else
				gun = 28;
			break;
		default:
			System.out.println("Girilen ay degeri yanlis!");
		}

		System.out.println("Gun sayisi = " + gun);
	}

}