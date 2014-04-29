public class SiralamaTest {

	public static void main(String[] args) {
		// int[] ligSira = new int[18];
		int[] ligSira = { 23, 26, 25, 89, 45, 25, 14, 74, 11, 1, 5, 7, 90, 92, 89, 15, 14, 3 };
		int temp = 0;

		for (int i = 0; i < ligSira.length; i++)
			for (int j = i; j < ligSira.length; j++) {

				if (ligSira[i] > ligSira[j]) {
					temp = ligSira[i];
					ligSira[i] = ligSira[j];
					ligSira[j] = temp;
				}

			} // end for

		for (int m = 0; m < ligSira.length; m++)
			System.out.println(m + 1 + " " + ligSira[m]);

	} // end main()

} // end class