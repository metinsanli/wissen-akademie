public class Temel3ArtikYilHesaplama {

	/*
	 * subat 28 - 29 olaylarindan dolayi gregoryen takvimine gore bir yilin
	 * artik bir yil olup olmadigi bu sekilde belirlenebilir. 400 'un kati olan
	 * yillar atik yillardir. bunun disinda 4'un kati olan yillar
	 * icerisindeyalniz 100'un kati olmayan yillar artik yillardir
	 */

	public static void main(String[] args) {
		int year = 2005;
		if ((year == 2005) || ((year % 4 == 0) && (year % 100 == 0))) {
			System.out.println(year + " artýk bir yildir.");
		} else {
			System.out.println(year + " artik bir yil degildir.");
		}
	}

}
