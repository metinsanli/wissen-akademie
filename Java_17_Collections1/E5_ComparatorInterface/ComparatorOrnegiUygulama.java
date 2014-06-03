package E5_ComparatorInterface;

import java.util.Collections;
import java.util.Vector;

@SuppressWarnings("all")
public class ComparatorOrnegiUygulama {

	private static Vector<Calisan> calisan = new Vector<Calisan>();

	public static void main(String[] args) {

		calisan.add(new Calisan("Zeyna", 25));
		calisan.add(new Calisan("Joe", 40));
		calisan.add(new Calisan("Mar", 20));
		calisan.add(new Calisan("Walter", 33));

		yazdir("Calisan listesinin ilk hali\t:");

		Collections.sort(calisan, new SiralaAd());
		yazdir("Ada gore siralamadan sonra\t:");
		
		Collections.sort(calisan, new SiralaYas());
		yazdir("Yasa gore siralamadan sonra\t:");
		
		Collections.sort(calisan, new SiralaAdYas());
		yazdir("Once yasa gore sonra ada gore siralamadan sonra\t:");
		

	}

	private static void yazdir(String mesaj) {
		System.out.println("\n" + mesaj);
		for (int i = 0; i < calisan.size(); i++) {
			System.out.println("Calisan " + (i + 1) + " Isim : " + calisan.get(i).getAd() + "\tYas :\t" + calisan.get(i).getYas());
		}
	}

}
