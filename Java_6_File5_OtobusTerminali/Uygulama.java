import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uygulama {

	public static void main(String[] args) throws Exception {
		anaMenu();
	}

	public static String klavye() throws Exception {
		InputStreamReader veri = new InputStreamReader(System.in);
		BufferedReader giris = new BufferedReader(veri);
		return giris.readLine();
	} // end method klavye()

	public static void anaMenu() throws Exception {
		while (true) {
			System.out.printf("\n#### ANA MENU ####\n");
			System.out.printf("\n[1] - Sefer Islemleri");
			System.out.printf("\n[2] - Otobus Islemleri");
			System.out.printf("\n[3] - Yolcu Islemleri");
			System.out.printf("\n\n[0] - Cikis\n");
			int secim = -1;
			while (secim > 3 || secim < 0) {
				System.out.printf("\nSecim yapin > ");
				secim = Integer.parseInt(klavye());
			}
			switch (secim) {
			case 0:
				System.out.printf("\nProgram kpatildi!");
				System.exit(0);
			case 1:
				Sefer.menu();
				break;
			case 2:
				Otobus.menu();
				break;
			case 3:
				Yolcu.menu();
				break;
			}
		}
	}
} // end class