public class ForYapisi2BirdenYuzeCiftSayilar {

	public static void main(String[] args) {

		for (int i = 2; i <= 100; i++) {

			if (i < 9 && i % 2 == 0)
				System.out.print("0");

			if (i % 10 == 1)
				System.out.println();
			
			if (i % 2 == 0)
				System.out.print(i + " ");

		}
	}
}
