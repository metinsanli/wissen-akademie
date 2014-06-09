package E06_RandomClass;
import java.util.Random;

public class RandomYapisi1SayiUretme {

	public static void main(String[] args) {

		Random rastgeleSayi = new Random();
		int s1, s2 = 4;

		s1 = rastgeleSayi.nextInt(10);
		System.out.println("Uretilen sayi = " + s1);
		System.out.println("Mutlak deger  = " + Math.abs(s1 - s2));

	}

}
