package E04_HataYonetimi;

public class HataYonetimi {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception hata) {
			System.err.printf("\n%s\n", hata.getMessage());
			StackTraceElement[] detay = hata.getStackTrace();
			System.out.printf("\nHata Detaylari :\n");
			System.out.printf("\nSinif\t\t\t\t\tDosya\t\t\tSatir\tMetod");
			System.out.printf("\n-----\t\t\t\t\t-----\t\t\t-----\t-----");
			for (StackTraceElement element : detay) {
				System.out.printf("\n%s\t", element.getClass());
				System.out.printf("%s\t", element.getFileName());
				System.out.printf("%s\t", element.getLineNumber());
				System.out.printf("%s\t", element.getMethodName());
			}
		}
	}

	public static void method1() throws Exception  {
		method2();
	} // end method1()

	public static void method2() throws Exception {
		method3();
	} // end method2()

	public static void method3() throws Exception {
		throw new Exception("method3() te hata uretildi!");
	} // end method3()

} // end class
