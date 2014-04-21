import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class AlisVerisListesi {

	public static void main(String[] args) throws Exception {

		ArrayList<Urun> alisVerisListesi = new ArrayList<Urun>();

		InputStreamReader konsol = new InputStreamReader(System.in, "Cp1254");
		BufferedReader konsolOku = new BufferedReader(konsol);

		System.out.println("Alisveris listemiz : ");
		int i = 0;
		while (true) {
			Urun listeUrun = new Urun();
			// Urun adini al
			System.out.print(++i + ". Urun : ");
			String urun = konsolOku.readLine();
			if (urun.equalsIgnoreCase("end"))
				break;
			else
				listeUrun.setUrunAdi(urun);
			// Adet al
			System.out.print("Adet : ");
			listeUrun.setUrunAdet(Integer.parseInt(konsolOku.readLine()));
			// olusan urun bilgisini "ad ve adet" listeye ekle
			alisVerisListesi.add(listeUrun);
		} // end while

		System.out.println("Listenin Son hali : ");
		for (int j = 0; j < alisVerisListesi.size(); j++)
			System.out.println(alisVerisListesi.get(j).getUrunAdi() + " " + alisVerisListesi.get(j).getUrunAdet());
	}

}
