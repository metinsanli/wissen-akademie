package E01_ArrayList;

import java.util.ArrayList;

public class ArrayListSinifi {

	public static void main(String[] args) {
		// ArrayList turunde String deger tutan bir "nesne" isimli nesne
		// yaratiliyor.
		ArrayList<String> nesne = new ArrayList<String>();

		nesne.add("kirmizi");
		nesne.add(0, "sari");

		System.out.println("\nDongu ile yazdirilanlar :");
		for (int i = 0; i < nesne.size(); i++)
			System.out.printf(" %s", nesne.get(i));

		goster(nesne, "\n\n\"goster\" methodu calistirildi :");

		nesne.add("yesil");
		nesne.add("sari");
		goster(nesne, "\nYeni eklenenleri goruntule : ");

		nesne.remove("yesil");
		goster(nesne, "\n\"yesil\" elemani silindikten sonra : ");

		nesne.remove(1);
		goster(nesne, "\nikinci eleman silindikten sonra : ");

		System.out.printf("\n\"kirmizi\" listede %s\n", nesne.contains("kirmizi") ? "var" : "yok");

		System.out.printf("\nlistenin uzunlugu : %s", nesne.size());

	}

	public static void goster(ArrayList<String> liste, String baslik) {
		System.out.print(baslik);
		for (String m : liste)
			System.out.printf(" %s", m);
		System.out.println();
	}
}
